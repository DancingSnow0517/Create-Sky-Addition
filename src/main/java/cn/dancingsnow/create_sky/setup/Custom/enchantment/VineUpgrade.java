package cn.dancingsnow.create_sky.setup.Custom.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;

public class VineUpgrade extends Enchantment {

    public VineUpgrade(Rarity rarity, EquipmentSlotType... equipmentSlotTypes) {
        super(rarity, EnchantmentType.DIGGER, equipmentSlotTypes);
    }

    @Override
    public int getMinLevel() {
        return 1;
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }

    @Override
    public int getMinCost(int p_77321_1_) {
        return 15;
    }

    @Override
    public int getMaxCost(int p_223551_1_) {
        return getMinCost(p_223551_1_) + 50;
    }
}
