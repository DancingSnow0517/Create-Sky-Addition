package cn.dancingsnow.create_sky.mixin;

import cn.dancingsnow.create_sky.CreateSky;
import dev.ftb.mods.ftbultimine.client.FTBUltimineClient;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Map;
import java.util.Objects;

@Mixin(FTBUltimineClient.class)
public abstract class FTBUltimineClientMixin {

    @Inject(at = @At("HEAD"), method = "clientTick")
    private void clientTick(Minecraft mc, CallbackInfo ci) {
        if (Minecraft.getInstance().player != null) {
            ClientPlayerEntity player = Minecraft.getInstance().player;
            ItemStack itemStack = player.getMainHandItem();
            Map<Enchantment, Integer> map = EnchantmentHelper.getEnchantments(itemStack);
            map.forEach((enchantment, integer) -> {

                CreateSky.LOGGER.info("Enchantment {}", Objects.requireNonNull(enchantment.getRegistryName()).toString());

            });
        }
    }

}
