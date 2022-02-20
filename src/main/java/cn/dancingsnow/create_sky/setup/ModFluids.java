package cn.dancingsnow.create_sky.setup;

import cn.dancingsnow.create_sky.CreateSky;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.material.Material;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fml.RegistryObject;

public class ModFluids {

    public static void register() {}

    public static final ResourceLocation WATER_STILL_RL = new ResourceLocation(CreateSky.MOD_ID, "fluid/number_still");
    public static final ResourceLocation WATER_FLOWING_RL = new ResourceLocation(CreateSky.MOD_ID, "fluid/number_flow");

    public static final RegistryObject<FlowingFluid> LOGIC_FLUID = Registration.FLUIDS.register("logic_fluid", () ->
            new ForgeFlowingFluid.Source(ModFluids.LOGIC_PROPERTIES));

    public static final RegistryObject<FlowingFluid> FLOWING_LOGIC = Registration.FLUIDS.register("flowing_logic", () ->
            new ForgeFlowingFluid.Flowing(ModFluids.LOGIC_PROPERTIES));

    public static final ForgeFlowingFluid.Properties LOGIC_PROPERTIES = new ForgeFlowingFluid.Properties(
            () -> LOGIC_FLUID.get(), () -> FLOWING_LOGIC.get(), FluidAttributes.builder(WATER_STILL_RL, WATER_FLOWING_RL)
            .sound(SoundEvents.WATER_AMBIENT).color(0xbfD6ECBC).density(15).luminosity(7)
    ).slopeFindDistance(2).explosionResistance(2)
            .block(() -> ModFluids.LOGIC_BLOCK.get()).bucket(() -> ModItems.LOGIC_BUCKET.get());

    public static final RegistryObject<FlowingFluidBlock> LOGIC_BLOCK = Registration.BLOCKS.register("logic", () ->
            new FlowingFluidBlock(() -> ModFluids.LOGIC_FLUID.get(), AbstractBlock.Properties.of(Material.WATER)
                    .noDrops().noCollission().strength(100F)));


    public static final RegistryObject<FlowingFluid> NUMBER_0_FLUID = Registration.FLUIDS.register("number_0_fluid", () ->
            new ForgeFlowingFluid.Source(ModFluids.NUMBER_0_PROPERTIES));

    public static final RegistryObject<FlowingFluid> FLOWING_NUMBER_0 = Registration.FLUIDS.register("flowing_number_0", () ->
            new ForgeFlowingFluid.Flowing(ModFluids.NUMBER_0_PROPERTIES));

    public static final ForgeFlowingFluid.Properties NUMBER_0_PROPERTIES = new ForgeFlowingFluid.Properties(
            () -> NUMBER_0_FLUID.get(), () -> FLOWING_NUMBER_0.get(), FluidAttributes.builder(WATER_STILL_RL, WATER_FLOWING_RL)
            .sound(SoundEvents.WATER_AMBIENT).color(0xbfeaf07c).density(15).luminosity(7)
    ).slopeFindDistance(2).explosionResistance(2)
            .block(() -> ModFluids.NUMBER_0_BLOCK.get()).bucket(() -> ModItems.NUMBER_0_BUCKET.get());

    public static final RegistryObject<FlowingFluidBlock> NUMBER_0_BLOCK = Registration.BLOCKS.register("number_0", () ->
            new FlowingFluidBlock(() -> ModFluids.NUMBER_0_FLUID.get(), AbstractBlock.Properties.of(Material.WATER)
                    .noDrops().noCollission().strength(100F)));


    public static final RegistryObject<FlowingFluid> NUMBER_1_FLUID = Registration.FLUIDS.register("number_1_fluid", () ->
            new ForgeFlowingFluid.Source(ModFluids.NUMBER_1_PROPERTIES));

    public static final RegistryObject<FlowingFluid> FLOWING_NUMBER_1 = Registration.FLUIDS.register("flowing_number_1", () ->
            new ForgeFlowingFluid.Flowing(ModFluids.NUMBER_1_PROPERTIES));

    public static final ForgeFlowingFluid.Properties NUMBER_1_PROPERTIES = new ForgeFlowingFluid.Properties(
            () -> NUMBER_1_FLUID.get(), () -> FLOWING_NUMBER_1.get(), FluidAttributes.builder(WATER_STILL_RL, WATER_FLOWING_RL)
            .sound(SoundEvents.WATER_AMBIENT).color(0xbfb3c744).density(15).luminosity(7)
    ).slopeFindDistance(2).explosionResistance(2)
            .block(() -> ModFluids.NUMBER_1_BLOCK.get()).bucket(() -> ModItems.NUMBER_1_BUCKET.get());

    public static final RegistryObject<FlowingFluidBlock> NUMBER_1_BLOCK = Registration.BLOCKS.register("number_1", () ->
            new FlowingFluidBlock(() -> ModFluids.NUMBER_1_FLUID.get(), AbstractBlock.Properties.of(Material.WATER)
                    .noDrops().noCollission().strength(100F)));


    public static final RegistryObject<FlowingFluid> NUMBER_2_FLUID = Registration.FLUIDS.register("number_2_fluid", () ->
            new ForgeFlowingFluid.Source(ModFluids.NUMBER_2_PROPERTIES));

    public static final RegistryObject<FlowingFluid> FLOWING_NUMBER_2 = Registration.FLUIDS.register("flowing_number_2", () ->
            new ForgeFlowingFluid.Flowing(ModFluids.NUMBER_2_PROPERTIES));

    public static final ForgeFlowingFluid.Properties NUMBER_2_PROPERTIES = new ForgeFlowingFluid.Properties(
            () -> NUMBER_2_FLUID.get(), () -> FLOWING_NUMBER_2.get(), FluidAttributes.builder(WATER_STILL_RL, WATER_FLOWING_RL)
            .sound(SoundEvents.WATER_AMBIENT).color(0xbfa0c744).density(15).luminosity(7)
    ).slopeFindDistance(2).explosionResistance(2)
            .block(() -> ModFluids.NUMBER_2_BLOCK.get()).bucket(() -> ModItems.NUMBER_2_BUCKET.get());

    public static final RegistryObject<FlowingFluidBlock> NUMBER_2_BLOCK = Registration.BLOCKS.register("number_2", () ->
            new FlowingFluidBlock(() -> ModFluids.NUMBER_2_FLUID.get(), AbstractBlock.Properties.of(Material.WATER)
                    .noDrops().noCollission().strength(100F)));


    public static final RegistryObject<FlowingFluid> NUMBER_3_FLUID = Registration.FLUIDS.register("number_3_fluid", () ->
            new ForgeFlowingFluid.Source(ModFluids.NUMBER_3_PROPERTIES));

    public static final RegistryObject<FlowingFluid> FLOWING_NUMBER_3 = Registration.FLUIDS.register("flowing_number_3", () ->
            new ForgeFlowingFluid.Flowing(ModFluids.NUMBER_3_PROPERTIES));

    public static final ForgeFlowingFluid.Properties NUMBER_3_PROPERTIES = new ForgeFlowingFluid.Properties(
            () -> NUMBER_3_FLUID.get(), () -> FLOWING_NUMBER_3.get(), FluidAttributes.builder(WATER_STILL_RL, WATER_FLOWING_RL)
            .sound(SoundEvents.WATER_AMBIENT).color(0xbf83d15b).density(15).luminosity(7)
    ).slopeFindDistance(2).explosionResistance(2)
            .block(() -> ModFluids.NUMBER_3_BLOCK.get()).bucket(() -> ModItems.NUMBER_3_BUCKET.get());

    public static final RegistryObject<FlowingFluidBlock> NUMBER_3_BLOCK = Registration.BLOCKS.register("number_3", () ->
            new FlowingFluidBlock(() -> ModFluids.NUMBER_3_FLUID.get(), AbstractBlock.Properties.of(Material.WATER)
                    .noDrops().noCollission().strength(100F)));


    public static final RegistryObject<FlowingFluid> NUMBER_4_FLUID = Registration.FLUIDS.register("number_4_fluid", () ->
            new ForgeFlowingFluid.Source(ModFluids.NUMBER_4_PROPERTIES));

    public static final RegistryObject<FlowingFluid> FLOWING_NUMBER_4 = Registration.FLUIDS.register("flowing_number_4", () ->
            new ForgeFlowingFluid.Flowing(ModFluids.NUMBER_4_PROPERTIES));

    public static final ForgeFlowingFluid.Properties NUMBER_4_PROPERTIES = new ForgeFlowingFluid.Properties(
            () -> NUMBER_4_FLUID.get(), () -> FLOWING_NUMBER_4.get(), FluidAttributes.builder(WATER_STILL_RL, WATER_FLOWING_RL)
            .sound(SoundEvents.WATER_AMBIENT).color(0xbf58cc82).density(15).luminosity(7)
    ).slopeFindDistance(2).explosionResistance(2)
            .block(() -> ModFluids.NUMBER_4_BLOCK.get()).bucket(() -> ModItems.NUMBER_4_BUCKET.get());

    public static final RegistryObject<FlowingFluidBlock> NUMBER_4_BLOCK = Registration.BLOCKS.register("number_4", () ->
            new FlowingFluidBlock(() -> ModFluids.NUMBER_4_FLUID.get(), AbstractBlock.Properties.of(Material.WATER)
                    .noDrops().noCollission().strength(100F)));


    public static final RegistryObject<FlowingFluid> NUMBER_5_FLUID = Registration.FLUIDS.register("number_5_fluid", () ->
            new ForgeFlowingFluid.Source(ModFluids.NUMBER_5_PROPERTIES));

    public static final RegistryObject<FlowingFluid> FLOWING_NUMBER_5 = Registration.FLUIDS.register("flowing_number_5", () ->
            new ForgeFlowingFluid.Flowing(ModFluids.NUMBER_5_PROPERTIES));

    public static final ForgeFlowingFluid.Properties NUMBER_5_PROPERTIES = new ForgeFlowingFluid.Properties(
            () -> NUMBER_5_FLUID.get(), () -> FLOWING_NUMBER_5.get(), FluidAttributes.builder(WATER_STILL_RL, WATER_FLOWING_RL)
            .sound(SoundEvents.WATER_AMBIENT).color(0xbf62d9b6).density(15).luminosity(7)
    ).slopeFindDistance(2).explosionResistance(2)
            .block(() -> ModFluids.NUMBER_5_BLOCK.get()).bucket(() -> ModItems.NUMBER_5_BUCKET.get());

    public static final RegistryObject<FlowingFluidBlock> NUMBER_5_BLOCK = Registration.BLOCKS.register("number_5", () ->
            new FlowingFluidBlock(() -> ModFluids.NUMBER_5_FLUID.get(), AbstractBlock.Properties.of(Material.WATER)
                    .noDrops().noCollission().strength(100F)));


    public static final RegistryObject<FlowingFluid> NUMBER_6_FLUID = Registration.FLUIDS.register("number_6_fluid", () ->
            new ForgeFlowingFluid.Source(ModFluids.NUMBER_6_PROPERTIES));

    public static final RegistryObject<FlowingFluid> FLOWING_NUMBER_6 = Registration.FLUIDS.register("flowing_number_6", () ->
            new ForgeFlowingFluid.Flowing(ModFluids.NUMBER_6_PROPERTIES));

    public static final ForgeFlowingFluid.Properties NUMBER_6_PROPERTIES = new ForgeFlowingFluid.Properties(
            () -> NUMBER_6_FLUID.get(), () -> FLOWING_NUMBER_6.get(), FluidAttributes.builder(WATER_STILL_RL, WATER_FLOWING_RL)
            .sound(SoundEvents.WATER_AMBIENT).color(0xbf63dbe1).density(15).luminosity(7)
    ).slopeFindDistance(2).explosionResistance(2)
            .block(() -> ModFluids.NUMBER_6_BLOCK.get()).bucket(() -> ModItems.NUMBER_6_BUCKET.get());

    public static final RegistryObject<FlowingFluidBlock> NUMBER_6_BLOCK = Registration.BLOCKS.register("number_6", () ->
            new FlowingFluidBlock(() -> ModFluids.NUMBER_6_FLUID.get(), AbstractBlock.Properties.of(Material.WATER)
                    .noDrops().noCollission().strength(100F)));


    public static final RegistryObject<FlowingFluid> NUMBER_7_FLUID = Registration.FLUIDS.register("number_7_fluid", () ->
            new ForgeFlowingFluid.Source(ModFluids.NUMBER_7_PROPERTIES));

    public static final RegistryObject<FlowingFluid> FLOWING_NUMBER_7 = Registration.FLUIDS.register("flowing_number_7", () ->
            new ForgeFlowingFluid.Flowing(ModFluids.NUMBER_7_PROPERTIES));

    public static final ForgeFlowingFluid.Properties NUMBER_7_PROPERTIES = new ForgeFlowingFluid.Properties(
            () -> NUMBER_7_FLUID.get(), () -> FLOWING_NUMBER_7.get(), FluidAttributes.builder(WATER_STILL_RL, WATER_FLOWING_RL)
            .sound(SoundEvents.WATER_AMBIENT).color(0xbf61b8d6).density(15).luminosity(7)
    ).slopeFindDistance(2).explosionResistance(2)
            .block(() -> ModFluids.NUMBER_7_BLOCK.get()).bucket(() -> ModItems.NUMBER_7_BUCKET.get());

    public static final RegistryObject<FlowingFluidBlock> NUMBER_7_BLOCK = Registration.BLOCKS.register("number_7", () ->
            new FlowingFluidBlock(() -> ModFluids.NUMBER_7_FLUID.get(), AbstractBlock.Properties.of(Material.WATER)
                    .noDrops().noCollission().strength(100F)));


    public static final RegistryObject<FlowingFluid> NUMBER_8_FLUID = Registration.FLUIDS.register("number_8_fluid", () ->
            new ForgeFlowingFluid.Source(ModFluids.NUMBER_8_PROPERTIES));

    public static final RegistryObject<FlowingFluid> FLOWING_NUMBER_8 = Registration.FLUIDS.register("flowing_number_8", () ->
            new ForgeFlowingFluid.Flowing(ModFluids.NUMBER_8_PROPERTIES));

    public static final ForgeFlowingFluid.Properties NUMBER_8_PROPERTIES = new ForgeFlowingFluid.Properties(
            () -> NUMBER_8_FLUID.get(), () -> FLOWING_NUMBER_8.get(), FluidAttributes.builder(WATER_STILL_RL, WATER_FLOWING_RL)
            .sound(SoundEvents.WATER_AMBIENT).color(0xbf5394c2).density(15).luminosity(7)
    ).slopeFindDistance(2).explosionResistance(2)
            .block(() -> ModFluids.NUMBER_8_BLOCK.get()).bucket(() -> ModItems.NUMBER_8_BUCKET.get());

    public static final RegistryObject<FlowingFluidBlock> NUMBER_8_BLOCK = Registration.BLOCKS.register("number_8", () ->
            new FlowingFluidBlock(() -> ModFluids.NUMBER_8_FLUID.get(), AbstractBlock.Properties.of(Material.WATER)
                    .noDrops().noCollission().strength(100F)));


    public static final RegistryObject<FlowingFluid> NUMBER_9_FLUID = Registration.FLUIDS.register("number_9_fluid", () ->
            new ForgeFlowingFluid.Source(ModFluids.NUMBER_9_PROPERTIES));

    public static final RegistryObject<FlowingFluid> FLOWING_NUMBER_9 = Registration.FLUIDS.register("flowing_number_9", () ->
            new ForgeFlowingFluid.Flowing(ModFluids.NUMBER_9_PROPERTIES));

    public static final ForgeFlowingFluid.Properties NUMBER_9_PROPERTIES = new ForgeFlowingFluid.Properties(
            () -> NUMBER_9_FLUID.get(), () -> FLOWING_NUMBER_9.get(), FluidAttributes.builder(WATER_STILL_RL, WATER_FLOWING_RL)
            .sound(SoundEvents.WATER_AMBIENT).color(0xbf4058d1).density(15).luminosity(7)
    ).slopeFindDistance(2).explosionResistance(2)
            .block(() -> ModFluids.NUMBER_9_BLOCK.get()).bucket(() -> ModItems.NUMBER_9_BUCKET.get());

    public static final RegistryObject<FlowingFluidBlock> NUMBER_9_BLOCK = Registration.BLOCKS.register("number_9", () ->
            new FlowingFluidBlock(() -> ModFluids.NUMBER_9_FLUID.get(), AbstractBlock.Properties.of(Material.WATER)
                    .noDrops().noCollission().strength(100F)));


    public static final ResourceLocation MATRIX_STILL_RL = new ResourceLocation(CreateSky.MOD_ID, "fluid/matrix_still");
    public static final ResourceLocation MATRIX_FLOWING_RL = new ResourceLocation(CreateSky.MOD_ID, "fluid/matrix_flow");

    public static final RegistryObject<FlowingFluid> MATRIX_FLUID = Registration.FLUIDS.register("matrix_fluid", () ->
            new ForgeFlowingFluid.Source(ModFluids.MATRIX_PROPERTIES));

    public static final RegistryObject<FlowingFluid> FLOWING_MATRIX = Registration.FLUIDS.register("flowing_matrix", () ->
            new ForgeFlowingFluid.Flowing(ModFluids.MATRIX_PROPERTIES));

    public static final ForgeFlowingFluid.Properties MATRIX_PROPERTIES = new ForgeFlowingFluid.Properties(
            () -> MATRIX_FLUID.get(), () -> FLOWING_MATRIX.get(), FluidAttributes.builder(MATRIX_STILL_RL, MATRIX_FLOWING_RL)
            .sound(SoundEvents.WATER_AMBIENT).density(15).luminosity(7)
    ).slopeFindDistance(2).explosionResistance(2)
            .block(() -> ModFluids.MATRIX_BLOCK.get()).bucket(() -> ModItems.MATRIX_BUCKET.get());

    public static final RegistryObject<FlowingFluidBlock> MATRIX_BLOCK = Registration.BLOCKS.register("matrix", () ->
            new FlowingFluidBlock(() -> ModFluids.MATRIX_FLUID.get(), AbstractBlock.Properties.of(Material.WATER)
                    .noDrops().noCollission().strength(100F)));

}
