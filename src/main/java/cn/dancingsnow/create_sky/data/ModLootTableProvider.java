package cn.dancingsnow.create_sky.data;

import cn.dancingsnow.create_sky.setup.ModBlocks;
import cn.dancingsnow.create_sky.setup.Registration;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.LootTableProvider;
import net.minecraft.data.loot.BlockLootTables;
import net.minecraftforge.fml.RegistryObject;

import java.util.stream.Collectors;

public class ModLootTableProvider extends LootTableProvider {
    public ModLootTableProvider(DataGenerator generator) {
        super(generator);
    }

    public static class ModBlockLootTables extends BlockLootTables {
        @Override
        protected void addTables() {
            dropSelf(ModBlocks.ANDESITE_MACHINE.get());
        }

        @Override
        protected Iterable<Block> getKnownBlocks() {
            return Registration.BLOCKS.getEntries().stream()
                    .map(RegistryObject::get)
                    .collect(Collectors.toList());
        }
    }
}
