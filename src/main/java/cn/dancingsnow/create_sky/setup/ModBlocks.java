package cn.dancingsnow.create_sky.setup;

import cn.dancingsnow.create_sky.CreateSky;
import cn.dancingsnow.create_sky.setup.Custom.block.Machines;
import cn.dancingsnow.create_sky.utils.Loots;
import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllItems;
import com.simibubi.create.content.AllSections;
import com.simibubi.create.content.contraptions.base.CasingBlock;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.repack.registrate.providers.RegistrateRecipeProvider;
import com.simibubi.create.repack.registrate.util.entry.BlockEntry;
import net.minecraft.block.SoundType;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraftforge.common.ToolType;

public class ModBlocks {

    private static final CreateRegistrate REGISTRATE = CreateSky.getRegistrate().itemGroup(() -> ModGroups.ADDITIONS);

    static {REGISTRATE.startSection(AllSections.MATERIALS);}

    public static final BlockEntry<Machines> ANDESITE_MACHINE = REGISTRATE
            .block("andesite_machine", Machines::new)
            .blockstate((genContext, provider) -> provider.horizontalBlock(genContext.get(), provider.models().getExistingFile(provider.modLoc("andesite_machine"))))
            .tag(ModTags.Blocks.MACHINE)
            .loot(Loots::dropSelf)
            .recipe((genContext, provider) -> ShapedRecipeBuilder.shaped(genContext.get())
                    .pattern("AAA")
                    .pattern("ABA")
                    .pattern("AAA")
                    .define('A', ModItems.KINETIC_MECHANISM.get())
                    .define('B', AllBlocks.ANDESITE_CASING.get())
                    .unlockedBy("hasitem", RegistrateRecipeProvider.hasItem(ModItems.KINETIC_MECHANISM.get()))
                    .save(provider))
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
            .blockstate((genContext, provider) -> provider.horizontalBlock(genContext.get(), provider.models().getExistingFile(provider.modLoc("copper_machine"))))
            .tag(ModTags.Blocks.MACHINE)
            .loot(Loots::dropSelf)
            .recipe((genContext, provider) -> ShapedRecipeBuilder.shaped(genContext.get())
                    .pattern("AAA")
                    .pattern("ABA")
                    .pattern("AAA")
                    .define('A', ModItems.SEALED_MECHANISM.get())
                    .define('B', AllBlocks.COPPER_CASING.get())
                    .unlockedBy("hasitem", RegistrateRecipeProvider.hasItem(ModItems.SEALED_MECHANISM.get()))
                    .save(provider))
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
            .blockstate((genContext, provider) -> provider.horizontalBlock(genContext.get(), provider.models().getExistingFile(provider.modLoc("brass_machine"))))
            .tag(ModTags.Blocks.MACHINE)
            .loot(Loots::dropSelf)
            .recipe((genContext, provider) -> ShapedRecipeBuilder.shaped(genContext.get())
                    .pattern("AAA")
                    .pattern("ABA")
                    .pattern("AAA")
                    .define('A', AllItems.PRECISION_MECHANISM.get())
                    .define('B', AllBlocks.BRASS_CASING.get())
                    .unlockedBy("hasitem", RegistrateRecipeProvider.hasItem(AllItems.PRECISION_MECHANISM.get()))
                    .save(provider))
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
            .blockstate((genContext, provider) -> provider.horizontalBlock(genContext.get(), provider.models().getExistingFile(provider.modLoc("zinc_machine"))))
            .tag(ModTags.Blocks.MACHINE)
            .loot(Loots::dropSelf)
            .recipe((genContext, provider) -> ShapedRecipeBuilder.shaped(genContext.get())
                    .pattern("AAA")
                    .pattern("ABA")
                    .pattern("AAA")
                    .define('A', ModItems.INFERNAL_MECHANISM.get())
                    .define('B', ModBlocks.ZINC_CASING.get())
                    .unlockedBy("hasitem", RegistrateRecipeProvider.hasItem(ModItems.INFERNAL_MECHANISM.get()))
                    .save(provider))
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
            .blockstate((genContext, provider) -> provider.horizontalBlock(genContext.get(), provider.models().getExistingFile(provider.modLoc("enderium_machine"))))
            .tag(ModTags.Blocks.MACHINE)
            .loot(Loots::dropSelf)
            .recipe((genContext, provider) -> ShapedRecipeBuilder.shaped(genContext.get())
                    .pattern("AAA")
                    .pattern("ABA")
                    .pattern("AAA")
                    .define('A', ModItems.ABSTRUSE_MECHANISM.get())
                    .define('B', ModBlocks.ENDERIUM_CASING.get())
                    .unlockedBy("hasitem", RegistrateRecipeProvider.hasItem(ModItems.ABSTRUSE_MECHANISM.get()))
                    .save(provider))
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
            .loot(Loots::dropSelf)
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
            .loot(Loots::dropSelf)
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
            .loot(Loots::dropSelf)
            .blockstate((genContext, provider) -> provider.simpleBlock(genContext.get(), provider.models().getExistingFile(provider.modLoc("enderium_casing"))))
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
