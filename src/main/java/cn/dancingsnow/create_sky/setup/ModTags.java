package cn.dancingsnow.create_sky.setup;

import cn.dancingsnow.create_sky.CreateSky;
import net.minecraft.block.Block;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;

public class ModTags {
    public static final class Blocks {

        public static final ITag.INamedTag<Block> MACHINE = mod("machine");


        private static ITag.INamedTag<Block> forge(String path) {
            return BlockTags.bind(new ResourceLocation("forge", path).toString());
        }

        private static ITag.INamedTag<Block> mod(String path) {
            return BlockTags.bind(new ResourceLocation(CreateSky.MOD_ID, path).toString());
        }
    }

    public static final class Items {

        public static final ITag.INamedTag<Item> MECHANISMS = mod("mechanisms");
        public static final ITag.INamedTag<Item> MACHINE = mod("machine");
        public static final ITag.INamedTag<Item> NUMBERS = mod("numbers");
        public static final ITag.INamedTag<Item> INCOMPLETES = mod("incompletes");

        private static ITag.INamedTag<Item> forge(String path) {
            return ItemTags.bind(new ResourceLocation("forge", path).toString());
        }

        private static ITag.INamedTag<Item> mod(String path) {
            return ItemTags.bind(new ResourceLocation(CreateSky.MOD_ID, path).toString());
        }

    }

    public static final class Fluids {

        public static final ITag.INamedTag<Fluid> FLUIDS = mod("fluids");


        private static ITag.INamedTag<Fluid> minecraft(String path) {
            return FluidTags.bind(new ResourceLocation("minecraft", path).toString());
        }

        private static ITag.INamedTag<Fluid> forge(String path) {
            return FluidTags.bind(new ResourceLocation("forge", path).toString());
        }

        private static ITag.INamedTag<Fluid> mod(String path) {
            return FluidTags.bind(new ResourceLocation(CreateSky.MOD_ID, path).toString());
        }
    }
}
