package cn.dancingsnow.create_sky.data;

import cn.dancingsnow.create_sky.CreateSky;
import cn.dancingsnow.create_sky.setup.ModBlocks;
import cn.dancingsnow.create_sky.setup.ModTags;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;

public class ModBlockTagsProvider extends BlockTagsProvider {
    public ModBlockTagsProvider(DataGenerator dataGenerator, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(dataGenerator, CreateSky.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {

        tag(ModTags.Blocks.MACHINE).add(ModBlocks.ANDESITE_MACHINE.get());
        tag(ModTags.Blocks.MACHINE).add(ModBlocks.COPPER_MACHINE.get());
        tag(ModTags.Blocks.MACHINE).add(ModBlocks.BRASS_MACHINE.get());
        tag(ModTags.Blocks.MACHINE).add(ModBlocks.ZINC_MACHINE.get());
        tag(ModTags.Blocks.MACHINE).add(ModBlocks.ENDERIUM_MACHINE.get());

    }
}
