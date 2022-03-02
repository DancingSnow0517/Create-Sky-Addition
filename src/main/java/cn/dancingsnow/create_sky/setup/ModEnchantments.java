package cn.dancingsnow.create_sky.setup;

import cn.dancingsnow.create_sky.CreateSky;
import cn.dancingsnow.create_sky.setup.Custom.enchantment.VineUpgrade;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.repack.registrate.util.entry.RegistryEntry;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraftforge.fml.RegistryObject;

public class ModEnchantments {

    private static final CreateRegistrate REGISTRATE = CreateSky.getRegistrate().itemGroup(() -> ModGroups.ADDITIONS);


//    public static final RegistryObject<Enchantment> VEIN_UPGRADE = Registration.ENCHANTMENT.register("vein_upgrade", () ->
//            new VineUpgrade(Enchantment.Rarity.COMMON, EquipmentSlotType.MAINHAND));

    public static final RegistryEntry<VineUpgrade> VEIN_UPGRADE = REGISTRATE
            .object("vein_upgrade")
            .enchantment(EnchantmentType.DIGGER, VineUpgrade::new)
            .rarity(Enchantment.Rarity.COMMON)
            .lang("Vine Upgrade")
            .register();

    static void register() {CreateSky.LOGGER.debug("Registering ModEnchantments");}

}
