package cn.dancingsnow.create_sky.setup.Custom.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;

public class VineUpgrade extends Enchantment {

    public VineUpgrade(Rarity rarity, EnchantmentType enchantmentType, EquipmentSlotType... equipmentSlotTypes) {
        super(rarity, enchantmentType, equipmentSlotTypes);
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

    @Override
    public boolean isTradeable() {
        return false;
    }

    @Override
    public boolean isDiscoverable() {
        return false;
    }

    @Override
    public boolean isCurse() {
        return false;
    }

    @Override
    public boolean isTreasureOnly() {
        return false;
    }

    @Override
    public boolean isAllowedOnBooks() {
        return true;
    }


}
