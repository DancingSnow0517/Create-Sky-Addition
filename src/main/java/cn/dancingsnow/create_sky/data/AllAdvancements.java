package cn.dancingsnow.create_sky.data;

import cn.dancingsnow.create_sky.CreateSky;
import cn.dancingsnow.create_sky.setup.ModItems;
import com.google.common.collect.Sets;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.simibubi.create.foundation.advancement.AllTriggers;
import com.simibubi.create.foundation.advancement.RegistryTrigger;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.advancements.criterion.PlacedBlockTrigger;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DirectoryCache;
import net.minecraft.data.IDataProvider;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TranslationTextComponent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Set;
import java.util.function.Consumer;

public class AllAdvancements implements IDataProvider {

    static final String LANG = "advancement." + CreateSky.MOD_ID + ".";

    public void register(Consumer<Advancement> t ) {
        String id = CreateSky.MOD_ID;

        Advancement root = Advancement.Builder.advancement()
                .display(ModItems.KINETIC_MECHANISM.get(), new TranslationTextComponent(LANG + "root"),
                        new TranslationTextComponent(LANG + "root.desc"),
                        new ResourceLocation(CreateSky.MOD_ID, "textures/block/zinc_casing.png"), FrameType.TASK,
                        false, false, false)
                .addCriterion("0", InventoryChangeTrigger.Instance.hasItems(new IItemProvider[] {}))
                .save(t, id + ":root");
    }

    // Data-gen

    private static final Logger LOGGER = LogManager.getLogger();
    private static final Gson GSON = (new GsonBuilder()).setPrettyPrinting()
            .create();
    private final DataGenerator generator;

    public AllAdvancements(DataGenerator generatorIn) {
        this.generator = generatorIn;
    }

    @Override
    public void run(DirectoryCache cache) throws IOException {
        Path path = this.generator.getOutputFolder();
        Set<ResourceLocation> set = Sets.newHashSet();
        Consumer<Advancement> consumer = (p_204017_3_) -> {
            if (!set.add(p_204017_3_.getId()))
                throw new IllegalStateException("Duplicate advancement " + p_204017_3_.getId());

            Path path1 = getPath(path, p_204017_3_);

            try {
                IDataProvider.save(GSON, cache, p_204017_3_.deconstruct()
                        .serializeToJson(), path1);
            } catch (IOException ioexception) {
                LOGGER.error("Couldn't save advancement {}", path1, ioexception);
            }
        };

        register(consumer);
    }

    private static Path getPath(Path pathIn, Advancement advancementIn) {
        return pathIn.resolve("data/" + advancementIn.getId()
                .getNamespace() + "/advancements/"
                + advancementIn.getId()
                .getPath()
                + ".json");
    }

    @Override
    public String getName() {
        return "CreateSky's Advancements";
    }

    public PlacedBlockTrigger.Instance placeBlock(Block block) {
        return PlacedBlockTrigger.Instance.placedBlock(block);
    }

    public RegistryTrigger.Instance<Fluid> isInfinite(FlowingFluid fluid) {
        return AllTriggers.INFINITE_FLUID.forEntries(fluid.getSource());
    }

    public InventoryChangeTrigger.Instance itemGathered(IItemProvider itemprovider) {
        return InventoryChangeTrigger.Instance.hasItems(itemprovider);
    }

    enum TaskType {

        NORMAL(FrameType.TASK, true, false, false),
        MILESTONE(FrameType.TASK, true, true, false),
        GOAL(FrameType.GOAL, true, true, false),
        SECRET(FrameType.GOAL, true, true, true),
        SILENT_GATE(FrameType.CHALLENGE, false, false, false),
        CHALLENGE(FrameType.CHALLENGE, true, true, false),

        ;

        private FrameType frame;
        private boolean toast;
        private boolean announce;
        private boolean hide;

        TaskType(FrameType frame, boolean toast, boolean announce, boolean hide) {
            this.frame = frame;
            this.toast = toast;
            this.announce = announce;
            this.hide = hide;
        }
    }

}
