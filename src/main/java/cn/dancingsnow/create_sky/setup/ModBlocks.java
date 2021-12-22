package cn.dancingsnow.create_sky.setup;

import cn.dancingsnow.create_sky.setup.Custom.block.Machines;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    static void register() {}

    public static final RegistryObject<Block> ANDESITE_MACHINE = registry("andesite_machine", () ->
            new Machines(AbstractBlock.Properties.of(Material.HEAVY_METAL)
                    .sound(SoundType.METAL)
                    .harvestLevel(1)
                    .harvestTool(ToolType.PICKAXE)
                    .strength(10)
                    .requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> COPPER_MACHINE = registry("copper_machine", () ->
            new Machines(AbstractBlock.Properties.of(Material.HEAVY_METAL)
                    .sound(SoundType.METAL)
                    .harvestLevel(2)
                    .harvestTool(ToolType.PICKAXE)
                    .strength(10)
                    .requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> BRASS_MACHINE = registry("brass_machine", () ->
            new Machines(AbstractBlock.Properties.of(Material.HEAVY_METAL)
                    .sound(SoundType.METAL)
                    .harvestLevel(3)
                    .harvestTool(ToolType.PICKAXE)
                    .strength(10)
                    .requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> ZINC_MACHINE = registry("zinc_machine", () ->
            new Machines(AbstractBlock.Properties.of(Material.HEAVY_METAL)
                    .sound(SoundType.METAL)
                    .harvestLevel(3)
                    .harvestTool(ToolType.PICKAXE)
                    .strength(10)
                    .requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> ENDERIUM_MACHINE = registry("enderium_machine", () ->
            new Machines(AbstractBlock.Properties.of(Material.HEAVY_METAL)
                    .sound(SoundType.METAL)
                    .harvestLevel(4)
                    .harvestTool(ToolType.PICKAXE)
                    .strength(10)
                    .requiresCorrectToolForDrops()));

    private static <T extends Block> RegistryObject<T> registryNoItem(String name, Supplier<T> block) {
        return Registration.BLOCKS.register(name, block);
    }

    private static <T extends Block>RegistryObject<T> registry(String name, Supplier<T> block) {
        RegistryObject<T> ret = registryNoItem(name, block);
        Registration.ITEMS.register(name, () -> new BlockItem(ret.get(), new Item.Properties().tab(ModGroups.ADDITIONS)));
        return ret;
    }
}
