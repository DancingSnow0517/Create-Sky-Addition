package cn.dancingsnow.create_sky.setup.Custom.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Numbers extends Item {

    public Numbers(Properties p_i48487_1_) {
        super(p_i48487_1_);
    }

    @Override
    public boolean isFoil(ItemStack itemStack) {
        return Boolean.TRUE;
    }
}
