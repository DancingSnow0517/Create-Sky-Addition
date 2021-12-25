package cn.dancingsnow.create_sky.setup;

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

    public static final ResourceLocation WATER_STILL_RL = new ResourceLocation("block/water_still");
    public static final ResourceLocation WATER_FLOWING_RL = new ResourceLocation("block/water_flow");
    public static final ResourceLocation WATER_OVERLAY_RL = new ResourceLocation("block/water_overlay");

    public static final RegistryObject<FlowingFluid> LOGIC_FLUID = Registration.FLUIDS.register("logic_fluid", () ->
        new ForgeFlowingFluid.Source(ModFluids.LOGIC_PROPERTIES));

    public static final RegistryObject<FlowingFluid> LOGIC_FLOWING = Registration.FLUIDS.register("logic_flowing", () ->
            new ForgeFlowingFluid.Flowing(ModFluids.LOGIC_PROPERTIES));

    public static final ForgeFlowingFluid.Properties LOGIC_PROPERTIES = new ForgeFlowingFluid.Properties(
            () -> LOGIC_FLUID.get(), () -> LOGIC_FLOWING.get(), FluidAttributes.builder(WATER_STILL_RL, WATER_FLOWING_RL)
            .sound(SoundEvents.WATER_AMBIENT).color(0xbfD6ECBC).density(15).luminosity(7).overlay(WATER_OVERLAY_RL)
    ).slopeFindDistance(2).explosionResistance(2)
            .block(() -> ModFluids.LOGIC_BLOCK.get()).bucket(() -> ModItems.LOGIC_BUCKET.get());

    public static final RegistryObject<FlowingFluidBlock> LOGIC_BLOCK = Registration.BLOCKS.register("logic", () ->
            new FlowingFluidBlock(() -> ModFluids.LOGIC_FLUID.get(), AbstractBlock.Properties.of(Material.WATER)
                    .noDrops().noCollission().strength(100F)));
}
