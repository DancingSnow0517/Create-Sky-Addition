package cn.dancingsnow.create_sky.mixin;

import cn.dancingsnow.create_sky.CreateSky;
import cn.dancingsnow.create_sky.setup.ModEnchantments;
import dev.ftb.mods.ftbultimine.client.FTBUltimineClient;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.ListNBT;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Map;

@Mixin(FTBUltimineClient.class)
public class FTBUltimineClientMixin {

    @Inject(at = @At("HEAD"), method = "clientTick")
    private void clientTick(Minecraft mc, CallbackInfo ci) {
        if (Minecraft.getInstance().player != null) {
            ClientPlayerEntity player = Minecraft.getInstance().player;
            ItemStack itemStack = player.getMainHandItem();
            ListNBT nbt = itemStack.getEnchantmentTags();
            Map<Enchantment, Integer> map = EnchantmentHelper.getEnchantments(itemStack);
            map.forEach((enchantment, integer) -> {

                if (enchantment.equals(ModEnchantments.VEIN_UPGRADE.get())) {

                }
            });
        }
    }

}
