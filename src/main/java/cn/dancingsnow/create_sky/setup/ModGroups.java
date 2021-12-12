package cn.dancingsnow.create_sky.setup;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModGroups {
    public static final ItemGroup ADDITIONS = new ItemGroup("create_sky") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.KINETIC_MECHANISM.get());
        }
    };
}
