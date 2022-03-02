package cn.dancingsnow.create_sky.data;

import cn.dancingsnow.create_sky.CreateSky;
import cn.dancingsnow.create_sky.setup.ModFluids;
import cn.dancingsnow.create_sky.setup.ModTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.FluidTagsProvider;
import net.minecraft.tags.FluidTags;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nullable;

public class ModFluidTagsProvider extends FluidTagsProvider {

    public ModFluidTagsProvider(DataGenerator dataGenerator, @Nullable ExistingFileHelper existingFileHelper) {
        super(dataGenerator, CreateSky.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {

        tag(ModTags.Fluids.FLUIDS).add(ModFluids.FLOWING_NUMBER_0.get());
        tag(FluidTags.WATER).add(ModFluids.FLOWING_NUMBER_0.get());
        tag(ModTags.Fluids.FLUIDS).add(ModFluids.FLOWING_NUMBER_1.get());
        tag(FluidTags.WATER).add(ModFluids.FLOWING_NUMBER_1.get());
        tag(ModTags.Fluids.FLUIDS).add(ModFluids.FLOWING_NUMBER_2.get());
        tag(FluidTags.WATER).add(ModFluids.FLOWING_NUMBER_2.get());
        tag(ModTags.Fluids.FLUIDS).add(ModFluids.FLOWING_NUMBER_3.get());
        tag(FluidTags.WATER).add(ModFluids.FLOWING_NUMBER_3.get());
        tag(ModTags.Fluids.FLUIDS).add(ModFluids.FLOWING_NUMBER_4.get());
        tag(FluidTags.WATER).add(ModFluids.FLOWING_NUMBER_4.get());
        tag(ModTags.Fluids.FLUIDS).add(ModFluids.FLOWING_NUMBER_5.get());
        tag(FluidTags.WATER).add(ModFluids.FLOWING_NUMBER_5.get());
        tag(ModTags.Fluids.FLUIDS).add(ModFluids.FLOWING_NUMBER_6.get());
        tag(FluidTags.WATER).add(ModFluids.FLOWING_NUMBER_6.get());
        tag(ModTags.Fluids.FLUIDS).add(ModFluids.FLOWING_NUMBER_7.get());
        tag(FluidTags.WATER).add(ModFluids.FLOWING_NUMBER_7.get());
        tag(ModTags.Fluids.FLUIDS).add(ModFluids.FLOWING_NUMBER_8.get());
        tag(FluidTags.WATER).add(ModFluids.FLOWING_NUMBER_8.get());
        tag(ModTags.Fluids.FLUIDS).add(ModFluids.FLOWING_NUMBER_9.get());
        tag(FluidTags.WATER).add(ModFluids.FLOWING_NUMBER_9.get());
        tag(ModTags.Fluids.FLUIDS).add(ModFluids.MATRIX_FLUID.get());
        tag(FluidTags.WATER).add(ModFluids.MATRIX_FLUID.get());

    }
}
