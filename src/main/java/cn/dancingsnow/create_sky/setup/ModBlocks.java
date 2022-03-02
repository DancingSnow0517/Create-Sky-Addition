package cn.dancingsnow.create_sky.setup;

import cn.dancingsnow.create_sky.CreateSky;
import cn.dancingsnow.create_sky.setup.Custom.block.Machines;
import com.simibubi.create.content.AllSections;
import com.simibubi.create.content.contraptions.base.CasingBlock;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.repack.registrate.util.entry.BlockEntry;
import net.minecraft.block.SoundType;
import net.minecraftforge.common.ToolType;

public class ModBlocks {

    private static final CreateRegistrate REGISTRATE = CreateSky.getRegistrate().itemGroup(() -> ModGroups.ADDITIONS);

    static {REGISTRATE.startSection(AllSections.MATERIALS);}

    public static final BlockEntry<Machines> ANDESITE_MACHINE = REGISTRATE
            .block("andesite_machine", Machines::new)
            .blockstate((genContext, provider) -> {
                provider.horizontalBlock(genContext.get(), provider.models().getExistingFile(provider.modLoc("andesite_machine")));
            })
            .properties(properties -> properties
                    .sound(SoundType.LANTERN)
                    .harvestLevel(1)
                    .harvestTool(ToolType.PICKAXE)
                    .strength(6)
                    .requiresCorrectToolForDrops()
                    .noOcclusion())
            .simpleItem()
            .register();
    public static final BlockEntry<Machines> COPPER_MACHINE = REGISTRATE
            .block("copper_machine", Machines::new)
            .blockstate((genContext, provider) -> {
                provider.horizontalBlock(genContext.get(), provider.models().getExistingFile(provider.modLoc("copper_machine")));
            })
            .properties(properties -> properties
                    .sound(SoundType.LANTERN)
                    .harvestLevel(2)
                    .harvestTool(ToolType.PICKAXE)
                    .strength(6)
                    .requiresCorrectToolForDrops()
                    .noOcclusion())
            .simpleItem()
            .register();
    public static final BlockEntry<Machines> BRASS_MACHINE = REGISTRATE
            .block("brass_machine", Machines::new)
            .blockstate((genContext, provider) -> {
                provider.horizontalBlock(genContext.get(), provider.models().getExistingFile(provider.modLoc("brass_machine")));
            })
            .properties(properties -> properties
                    .sound(SoundType.LANTERN)
                    .harvestLevel(2)
                    .harvestTool(ToolType.PICKAXE)
                    .strength(6)
                    .requiresCorrectToolForDrops()
                    .noOcclusion())
            .simpleItem()
            .register();
    public static final BlockEntry<Machines> ZINC_MACHINE = REGISTRATE
            .block("zinc_machine", Machines::new)
            .blockstate((genContext, provider) -> {
                provider.horizontalBlock(genContext.get(), provider.models().getExistingFile(provider.modLoc("zinc_machine")));
            })
            .properties(properties -> properties
                    .sound(SoundType.LANTERN)
                    .harvestLevel(2)
                    .harvestTool(ToolType.PICKAXE)
                    .strength(6)
                    .requiresCorrectToolForDrops()
                    .noOcclusion())
            .simpleItem()
            .register();
    public static final BlockEntry<Machines> ENDERIUM_MACHINE = REGISTRATE
            .block("enderium_machine", Machines::new)
            .blockstate((genContext, provider) -> {
                provider.horizontalBlock(genContext.get(), provider.models().getExistingFile(provider.modLoc("enderium_machine")));
            })
            .properties(properties -> properties
                    .sound(SoundType.LANTERN)
                    .harvestLevel(3)
                    .harvestTool(ToolType.PICKAXE)
                    .strength(6)
                    .requiresCorrectToolForDrops()
                    .noOcclusion())
            .simpleItem()
            .register();

    public static final BlockEntry<CasingBlock> ZINC_CASING = REGISTRATE
            .block("zinc_casing", CasingBlock::new)
            .properties(properties -> properties
                    .sound(SoundType.METAL)
                    .harvestLevel(2)
                    .harvestTool(ToolType.PICKAXE)
                    .strength(6)
                    .requiresCorrectToolForDrops()
                    .noOcclusion())
            .simpleItem()
            .register();
    public static final BlockEntry<CasingBlock> INVAR_CASING = REGISTRATE
            .block("invar_casing", CasingBlock::new)
            .properties(properties -> properties
                    .sound(SoundType.METAL)
                    .harvestLevel(2)
                    .harvestTool(ToolType.PICKAXE)
                    .strength(6)
                    .requiresCorrectToolForDrops()
                    .noOcclusion())
            .simpleItem()
            .register();
    public static final BlockEntry<CasingBlock> FLUIX_CASING = REGISTRATE
            .block("fluix_casing", CasingBlock::new)
            .properties(properties -> properties
                    .sound(SoundType.METAL)
                    .harvestLevel(2)
                    .harvestTool(ToolType.PICKAXE)
                    .strength(6)
                    .requiresCorrectToolForDrops()
                    .noOcclusion())
            .simpleItem()
            .register();
    public static final BlockEntry<CasingBlock> ENDERIUM_CASING = REGISTRATE
            .block("enderium_casing", CasingBlock::new)
            .blockstate((genContext, provider) -> {
                provider.simpleBlock(genContext.get(), provider.models().getExistingFile(provider.modLoc("enderium_casing")));
            })
            .properties(properties -> properties
                    .sound(SoundType.METAL)
                    .harvestLevel(2)
                    .harvestTool(ToolType.PICKAXE)
                    .strength(6)
                    .requiresCorrectToolForDrops()
                    .noOcclusion())
            .simpleItem()
            .loot((registrateBlockLootTables, casingBlock) -> registrateBlockLootTables.dropSelf(casingBlock.getBlock()))
            .register();

    static void register() {
        CreateSky.LOGGER.debug("Registering ModBlocks!");
    }

}
