package cn.dancingsnow.create_sky.utils;

import com.simibubi.create.repack.registrate.providers.loot.RegistrateBlockLootTables;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class Loots {

    public static void dropSelf(RegistrateBlockLootTables lootTables, Block block) {
        lootTables.dropSelf(block);
    }

    public static void dropOther(RegistrateBlockLootTables lootTables, Block block, Item item) {
        lootTables.dropOther(block, item);
    }

    public static void dropWhenSilkTouch(RegistrateBlockLootTables lootTables, Block block) {
        lootTables.dropWhenSilkTouch(block);
    }

}
