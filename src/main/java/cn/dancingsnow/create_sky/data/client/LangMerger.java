package cn.dancingsnow.create_sky.data.client;

import cn.dancingsnow.create_sky.CreateSky;
import cn.dancingsnow.create_sky.data.AllLangPartials;
import cn.dancingsnow.create_sky.data.utility.FilesHelper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DirectoryCache;
import net.minecraft.data.IDataProvider;
import net.minecraft.util.JSONUtils;
import org.apache.commons.lang3.mutable.MutableInt;
import org.apache.commons.lang3.mutable.MutableObject;
import org.apache.commons.lang3.tuple.Pair;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class LangMerger implements IDataProvider {
    private static final Gson GSON = (new GsonBuilder()).setPrettyPrinting()
            .disableHtmlEscaping()
            .create();
    static final String CATEGORY_HEADER = "\t\"_\": \"->------------------------]  %s  [------------------------<-\",";

    private DataGenerator gen;

    private List<Object> mergedLangData;
    private Map<String, List<Object>> populatedLangData;
    private Map<String, Map<String, String>> allLocalizedEntries;
    private Map<String, MutableInt> missingTranslationTally;
    private Map<String, Map<String, String>> allLangPartials;

    private List<String> langIgnore;

    public LangMerger(DataGenerator gen) {
        this.gen = gen;
        this.mergedLangData = new ArrayList<>();
        this.langIgnore = new ArrayList<>();
        this.allLocalizedEntries = new HashMap<>();
        this.populatedLangData = new HashMap<>();
        this.missingTranslationTally = new HashMap<>();
        this.allLangPartials = new HashMap<>();
        populateLangIgnore();
    }

    private void populateLangIgnore() {
        // Key prefixes added here will NOT be transferred to lang templates
        langIgnore.add("create.ponder.debug_"); // Ponder debug scene text
        langIgnore.add("create.gui.chromatic_projector");
    }

    private boolean shouldIgnore(String key) {
        for (String string : langIgnore)
            if (key.startsWith(string))
                return true;
        return false;
    }

    @Override
    public String getName() {
        return "Lang merger";
    }

    @Override
    public void run(DirectoryCache cache) throws IOException {
        Path path = this.gen.getOutputFolder()
                .resolve("assets/" + CreateSky.MOD_ID + "/lang/" + "zh_cn.json");

        for (Pair<String, JsonElement> pair : getAllLocalizationFiles()) {
            if (!pair.getRight()
                    .isJsonObject())
                continue;
            Map<String, String> localizedEntries = new HashMap<>();
            JsonObject jsonobject = pair.getRight()
                    .getAsJsonObject();
            jsonobject.entrySet()
                    .stream()
                    .forEachOrdered(entry -> {
                        String key = entry.getKey();
                        if (key.startsWith("_"))
                            return;
                        String value = entry.getValue()
                                .getAsString();
                        localizedEntries.put(key, value);
                    });
            String key = pair.getKey();
            allLocalizedEntries.put(key, localizedEntries);
            populatedLangData.put(key, new ArrayList<>());
            missingTranslationTally.put(key, new MutableInt(0));
        }

        collectAllPartials();
        collectExistingEntries(path);
        collectEntries();
        if (mergedLangData.isEmpty())
            return;

        save(cache, mergedLangData, -1, path, "合并 zh_cn.json 带有手写的语言条目...");
        for (Map.Entry<String, List<Object>> localization : populatedLangData.entrySet()) {
            String key = localization.getKey();
            Path populatedLangPath = this.gen.getOutputFolder()
                    .resolve("assets/" + CreateSky.MOD_ID + "/lang/unfinished/" + key);
            save(cache, localization.getValue(), missingTranslationTally.get(key)
                    .intValue(), populatedLangPath, "缺少 " + key + " 条目, 正在填充...");
        }
    }

    private void collectExistingEntries(Path path) throws IOException {
        if (!Files.exists(path)) {
            CreateSky.LOGGER.warn("没有什么可以合并的！ 在我之前似乎没有生成任何语言。");
            return;
        }

        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            JsonObject jsonobject = JSONUtils.fromJson(GSON, reader, JsonObject.class);
            addAll("Game Elements", jsonobject);
            reader.close();
        }
    }

    protected void addAll(String header, JsonObject jsonobject) {
        if (jsonobject == null)
            return;
        header = String.format(CATEGORY_HEADER, header);

        writeData("\n");
        writeData(header);
        writeData("\n\n");

        MutableObject<String> previousKey = new MutableObject<>("");
        String finalHeader = header;
        jsonobject.entrySet()
                .stream()
                .forEachOrdered(entry -> {
                    String key = entry.getKey();
                    if (shouldIgnore(key))
                        return;
                    if (isInLangPartials(key) )
                        if (finalHeader.equals("Game Elements"))
                            return;
                    String value = entry.getValue()
                            .getAsString();
                    if (value.equals("感谢你翻译 Create Sky Addition!"))
                        return;
                    if (!previousKey.getValue()
                            .isEmpty() && shouldAddLineBreak(key, previousKey.getValue()))
                        writeData("\n");
                    writeEntry(key, value);
                    previousKey.setValue(key);
                });

        writeData("\n");
    }

    private void writeData(String data) {
        mergedLangData.add(data);
        populatedLangData.values()
                .forEach(l -> l.add(data));
    }

    private void writeEntry(String key, String value) {
        mergedLangData.add(new LangEntry(key, value));
        populatedLangData.forEach((k, l) -> {
            ForeignLangEntry entry = new ForeignLangEntry(key, value, allLocalizedEntries.get(k));
            if (entry.isMissing())
                missingTranslationTally.get(k)
                        .increment();
            l.add(entry);
        });
    }

    protected boolean shouldAddLineBreak(String key, String previousKey) {
        // Always put tooltips and ponder scenes in their own paragraphs
        if (key.endsWith(".tooltip"))
            return true;

        key = key.replaceFirst("\\.", "");
        previousKey = previousKey.replaceFirst("\\.", "");

        String[] split = key.split("\\.");
        String[] split2 = previousKey.split("\\.");
        if (split.length == 0 || split2.length == 0)
            return false;

        // Start new paragraph if keys before second point do not match
        return !split[0].equals(split2[0]);
    }

    private List<Pair<String, JsonElement>> getAllLocalizationFiles() {
        ArrayList<Pair<String, JsonElement>> list = new ArrayList<>();

        String filepath = "assets/" + CreateSky.MOD_ID + "/lang/";
        try {
            InputStream resourceAsStream = CreateSky.class.getClassLoader()
                    .getResourceAsStream(filepath);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resourceAsStream));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null)
                    break;
                if (!readLine.endsWith(".json"))
                    continue;
                if (readLine.startsWith("zh_cn") || readLine.startsWith("en_ud"))
                    continue;
                list.add(Pair.of(readLine, FilesHelper.loadJsonResource(filepath + "/" + readLine)));
            }
            resourceAsStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }

    private void collectEntries() {
        for (AllLangPartials partial : AllLangPartials.values())
            addAll(partial.getDisplay(), partial.provide()
                    .getAsJsonObject());

    }

    private void collectAllPartials() {
        JsonObject jsonObject;
        for (AllLangPartials partial : AllLangPartials.values()) {
            Map<String, String> map = new HashMap<>();
            jsonObject = partial.provide().getAsJsonObject();
            jsonObject.entrySet().stream().forEachOrdered(entry -> {
                String key = entry.getKey();
                String value = entry.getValue().getAsString();
                map.put(key, value);
            });
            allLangPartials.put(partial.getDisplay(), map);
        }
    }

    private boolean isInLangPartials(String key){
        AtomicBoolean rt = new AtomicBoolean(false);
        allLangPartials.forEach((s, stringStringMap) -> {
            if (stringStringMap.containsKey(key))
                rt.set(true);
        });
        return rt.get();
    }

    private void save(DirectoryCache cache, List<Object> dataIn, int missingKeys, Path target, String message)
            throws IOException {
        String data = createString(dataIn, missingKeys);
//		data = JavaUnicodeEscaper.outsideOf(0, 0x7f)
//			.translate(data);
        String hash = IDataProvider.SHA1.hashUnencodedChars(data)
                .toString();
        if (!Objects.equals(cache.getHash(target), hash) || !Files.exists(target)) {
            Files.createDirectories(target.getParent());

            try (BufferedWriter bufferedwriter = Files.newBufferedWriter(target, StandardCharsets.UTF_8)) {
                CreateSky.LOGGER.info(message);
                bufferedwriter.write(data);
                bufferedwriter.close();
            }
        }

        cache.putNew(target, hash);
    }

    protected String createString(List<Object> data, int missingKeys) {
        StringBuilder builder = new StringBuilder();
        builder.append("{\n");
        if (missingKeys != -1)
            builder.append("\t\"_\": \"缺少的条目: " + missingKeys + "\",\n");
        data.forEach(builder::append);
        builder.append("\t\"_\": \"感谢你翻译 Create Sky Addition!\"\n\n");
        builder.append("}");
        return builder.toString();
    }

    private class LangEntry {
        static final String ENTRY_FORMAT = "\t\"%s\": %s,\n";

        private String key;
        private String value;

        LangEntry(String key, String value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return String.format(ENTRY_FORMAT, key, GSON.toJson(value, String.class));
        }

    }

    private class ForeignLangEntry extends LangEntry {

        private boolean missing;

        ForeignLangEntry(String key, String value, Map<String, String> localizationMap) {
            super(key, localizationMap.getOrDefault(key, "未本地化: " + value));
            missing = !localizationMap.containsKey(key);
        }

        public boolean isMissing() {
            return missing;
        }

    }
}

