package cn.dancingsnow.create_sky.setup;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    static void register() {}

    private static <T extends Block> RegistryObject<T> registryNoItem(String name, Supplier<T> block) {
        return Registration.BLOCKS.register(name, block);
    }

    private static <T extends Block>RegistryObject<T> registry(String name, Supplier<T> block) {
        RegistryObject<T> ret = registryNoItem(name, block);
        Registration.ITEMS.register(name, () -> new BlockItem(ret.get(), new Item.Properties().tab(ModGroups.ADDITIONS)));
        return ret;
    }
}
