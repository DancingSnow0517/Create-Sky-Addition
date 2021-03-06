package cn.dancingsnow.create_sky.data;

import cn.dancingsnow.create_sky.setup.ModBlocks;
import cn.dancingsnow.create_sky.setup.Registration;
import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.LootTableProvider;
import net.minecraft.data.loot.BlockLootTables;
import net.minecraft.loot.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class ModLootTableProvider extends LootTableProvider {
    public ModLootTableProvider(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootParameterSet>> getTables() {
        return ImmutableList.of(
                Pair.of(ModBlockLootTables::new, LootParameterSets.BLOCK)
        );
    }

    @Override
    protected void validate(Map<ResourceLocation, LootTable> map, ValidationTracker validationtracker) {
        map.forEach((p_218436_2_, p_218436_3_) -> LootTableManager.validate(validationtracker, p_218436_2_, p_218436_3_));
    }

    public static class ModBlockLootTables extends BlockLootTables {
        @Override
        protected void addTables() {
            dropSelf(ModBlocks.ANDESITE_MACHINE.get());
            dropSelf(ModBlocks.COPPER_MACHINE.get());
            dropSelf(ModBlocks.BRASS_MACHINE.get());
            dropSelf(ModBlocks.ZINC_MACHINE.get());
            dropSelf(ModBlocks.ENDERIUM_MACHINE.get());
            dropSelf(ModBlocks.ZINC_CASING.get());
            dropSelf(ModBlocks.INVAR_CASING.get());
            dropSelf(ModBlocks.FLUIX_CASING.get());
            dropSelf(ModBlocks.ENDERIUM_CASING.get());

        }

        @Override
        protected Iterable<Block> getKnownBlocks() {
            return Registration.BLOCKS.getEntries().stream()
                    .map(RegistryObject::get)
                    .collect(Collectors.toList());
        }
    }
}
