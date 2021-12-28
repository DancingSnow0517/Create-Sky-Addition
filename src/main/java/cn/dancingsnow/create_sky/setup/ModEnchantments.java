package cn.dancingsnow.create_sky.setup;

import cn.dancingsnow.create_sky.setup.Custom.enchantment.VineUpgrade;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraftforge.fml.RegistryObject;

public class ModEnchantments {

    static void register() {}

    public static final RegistryObject<Enchantment> VEIN_UPGRADE = Registration.ENCHANTMENT.register("vein_upgrade", () ->
            new VineUpgrade(Enchantment.Rarity.COMMON, EquipmentSlotType.MAINHAND));

}
