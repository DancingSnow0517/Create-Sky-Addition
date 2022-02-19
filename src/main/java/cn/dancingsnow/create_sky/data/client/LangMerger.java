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
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.*;

public class LangMerger implements IDataProvider {
    private static final Gson GSON = (new GsonBuilder()).setPrettyPrinting().disableHtmlEscaping().create();
    static final String CATEGORY_HEADER = "\t\"_\": \"->------------------------]  %s  [------------------------<-\",";
    private DataGenerator gen;
    private List<Object> mergedLangData;
    private Map<String, List<Object>> populatedLangData;
    private Map<String, Map<String, String>> allLocalizedEntries;
    private Map<String, MutableInt> missingTranslationTally;
    private List<String> langIgnore;

    public LangMerger(DataGenerator gen) {
        this.gen = gen;
        this.mergedLangData = new ArrayList();
        this.langIgnore = new ArrayList();
        this.allLocalizedEntries = new HashMap();
        this.populatedLangData = new HashMap();
        this.missingTranslationTally = new HashMap();
        this.populateLangIgnore();
    }

    private void populateLangIgnore() {
        this.langIgnore.add("create.ponder.debug_");
        this.langIgnore.add("create.gui.chromatic_projector");
    }

    private boolean shouldIgnore(String key) {
        Iterator var2 = this.langIgnore.iterator();

        String string;
        do {
            if (!var2.hasNext()) {
                return false;
            }

            string = (String)var2.next();
        } while(!key.startsWith(string));

        return true;
    }

    public String getName() {
        return "Lang merger";
    }

    public void run(DirectoryCache cache) throws IOException {
        Path path = this.gen.getOutputFolder().resolve("assets/create/lang/en_us.json");
        Iterator var3 = this.getAllLocalizationFiles().iterator();

        while(var3.hasNext()) {
            Pair<String, JsonElement> pair = (Pair)var3.next();
            if (((JsonElement)pair.getRight()).isJsonObject()) {
                Map<String, String> localizedEntries = new HashMap();
                JsonObject jsonobject = ((JsonElement)pair.getRight()).getAsJsonObject();
                jsonobject.entrySet().stream().forEachOrdered((entry) -> {
                    String key = (String)entry.getKey();
                    if (!key.startsWith("_")) {
                        String value = ((JsonElement)entry.getValue()).getAsString();
                        localizedEntries.put(key, value);
                    }
                });
                String key = (String)pair.getKey();
                this.allLocalizedEntries.put(key, localizedEntries);
                this.populatedLangData.put(key, new ArrayList());
                this.missingTranslationTally.put(key, new MutableInt(0));
            }
        }

        this.collectExistingEntries(path);
        this.collectEntries();
        if (!this.mergedLangData.isEmpty()) {
            this.save(cache, this.mergedLangData, -1, path, "Merging en_us.json with hand-written lang entries...");
            var3 = this.populatedLangData.entrySet().iterator();

            while(var3.hasNext()) {
                Map.Entry<String, List<Object>> localization = (Map.Entry)var3.next();
                String key = (String)localization.getKey();
                Path populatedLangPath = this.gen.getOutputFolder().resolve("assets/create/lang/unfinished/" + key);
                this.save(cache, (List)localization.getValue(), ((MutableInt)this.missingTranslationTally.get(key)).intValue(), populatedLangPath, "Populating " + key + " with missing entries...");
            }

        }
    }

    private void collectExistingEntries(Path path) throws IOException {
        if (!Files.exists(path, new LinkOption[0])) {
            CreateSky.LOGGER.warn("Nothing to merge! It appears no lang was generated before me.");
        } else {
            BufferedReader reader = Files.newBufferedReader(path);
            Throwable var3 = null;

            try {
                JsonObject jsonobject = (JsonObject) JSONUtils.fromJson(GSON, reader, JsonObject.class);
                this.addAll("Game Elements", jsonobject);
                reader.close();
            } catch (Throwable var12) {
                var3 = var12;
                throw var12;
            } finally {
                if (reader != null) {
                    if (var3 != null) {
                        try {
                            reader.close();
                        } catch (Throwable var11) {
                            var3.addSuppressed(var11);
                        }
                    } else {
                        reader.close();
                    }
                }

            }

        }
    }

    protected void addAll(String header, JsonObject jsonobject) {
        if (jsonobject != null) {
            header = String.format("\t\"_\": \"->------------------------]  %s  [------------------------<-\",", header);
            this.writeData("\n");
            this.writeData(header);
            this.writeData("\n\n");
            MutableObject<String> previousKey;
            previousKey = new MutableObject("");
            jsonobject.entrySet().stream().forEachOrdered((entry) -> {
                String key = (String)entry.getKey();
                if (!this.shouldIgnore(key)) {
                    String value = ((JsonElement)entry.getValue()).getAsString();
                    if (!((String)previousKey.getValue()).isEmpty() && this.shouldAddLineBreak(key, (String)previousKey.getValue())) {
                        this.writeData("\n");
                    }

                    this.writeEntry(key, value);
                    previousKey.setValue(key);
                }
            });
            this.writeData("\n");
        }
    }

    private void writeData(String data) {
        this.mergedLangData.add(data);
        this.populatedLangData.values().forEach((l) -> {
            l.add(data);
        });
    }

    private void writeEntry(String key, String value) {
        this.mergedLangData.add(new cn.dancingsnow.create_sky.data.client.LangMerger.LangEntry(key, value));
        this.populatedLangData.forEach((k, l) -> {
            cn.dancingsnow.create_sky.data.client.LangMerger.ForeignLangEntry entry = new cn.dancingsnow.create_sky.data.client.LangMerger.ForeignLangEntry(key, value, (Map)this.allLocalizedEntries.get(k));
            if (entry.isMissing()) {
                ((MutableInt)this.missingTranslationTally.get(k)).increment();
            }

            l.add(entry);
        });
    }

    protected boolean shouldAddLineBreak(String key, String previousKey) {
        if (key.endsWith(".tooltip")) {
            return true;
        } else if (key.startsWith("create.ponder") && key.endsWith("header")) {
            return true;
        } else {
            key = key.replaceFirst("\\.", "");
            previousKey = previousKey.replaceFirst("\\.", "");
            String[] split = key.split("\\.");
            String[] split2 = previousKey.split("\\.");
            if (split.length != 0 && split2.length != 0) {
                return !split[0].equals(split2[0]);
            } else {
                return false;
            }
        }
    }

    private List<Pair<String, JsonElement>> getAllLocalizationFiles() {
        ArrayList<Pair<String, JsonElement>> list = new ArrayList();
        String filepath = "assets/create/lang/";

        try {
            InputStream resourceAsStream = CreateSky.class.getClassLoader().getResourceAsStream(filepath);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resourceAsStream));

            while(true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    resourceAsStream.close();
                    break;
                }

                if (readLine.endsWith(".json") && !readLine.startsWith("en_us") && !readLine.startsWith("en_ud")) {
                    list.add(Pair.of(readLine, FilesHelper.loadJsonResource(filepath + "/" + readLine)));
                }
            }
        } catch (IOException var6) {
            var6.printStackTrace();
        }

        return list;
    }

    private void collectEntries() {
        AllLangPartials[] var1 = AllLangPartials.values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            AllLangPartials partial = var1[var3];
            this.addAll(partial.getDisplay(), partial.provide().getAsJsonObject());
        }

    }

    private void save(DirectoryCache cache, List<Object> dataIn, int missingKeys, Path target, String message) throws IOException {
        String data = this.createString(dataIn, missingKeys);
        String hash = IDataProvider.SHA1.hashUnencodedChars(data).toString();
        if (!Objects.equals(cache.getHash(target), hash) || !Files.exists(target, new LinkOption[0])) {
            Files.createDirectories(target.getParent());
            BufferedWriter bufferedwriter = Files.newBufferedWriter(target);
            Throwable var9 = null;

            try {
                CreateSky.LOGGER.info(message);
                bufferedwriter.write(data);
                bufferedwriter.close();
            } catch (Throwable var18) {
                var9 = var18;
                throw var18;
            } finally {
                if (bufferedwriter != null) {
                    if (var9 != null) {
                        try {
                            bufferedwriter.close();
                        } catch (Throwable var17) {
                            var9.addSuppressed(var17);
                        }
                    } else {
                        bufferedwriter.close();
                    }
                }

            }
        }

        cache.putNew(target, hash);
    }

    protected String createString(List<Object> data, int missingKeys) {
        StringBuilder builder = new StringBuilder();
        builder.append("{\n");
        if (missingKeys != -1) {
            builder.append("\t\"_\": \"Missing Localizations: " + missingKeys + "\",\n");
        }

        data.forEach(builder::append);
        builder.append("\t\"_\": \"Thank you for translating Create!\"\n\n");
        builder.append("}");
        return builder.toString();
    }

    private class ForeignLangEntry extends cn.dancingsnow.create_sky.data.client.LangMerger.LangEntry {
        private boolean missing;

        ForeignLangEntry(String key, String value, Map<String, String> localizationMap) {
            super(key, (String)localizationMap.getOrDefault(key, "UNLOCALIZED: " + value));
            this.missing = !localizationMap.containsKey(key);
        }

        public boolean isMissing() {
            return this.missing;
        }
    }

    private class LangEntry {
        static final String ENTRY_FORMAT = "\t\"%s\": %s,\n";
        private String key;
        private String value;

        LangEntry(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String toString() {
            return String.format("\t\"%s\": %s,\n", this.key, cn.dancingsnow.create_sky.data.client.LangMerger.GSON.toJson(this.value, String.class));
        }
    }
}

