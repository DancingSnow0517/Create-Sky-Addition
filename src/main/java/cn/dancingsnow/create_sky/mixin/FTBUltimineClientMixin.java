package cn.dancingsnow.create_sky.mixin;

//import cn.dancingsnow.create_sky.CreateSky;
// import cn.dancingsnow.create_sky.setup.ModEnchantments;
// import dev.ftb.mods.ftbultimine.client.FTBUltimineClient;
// import net.minecraft.client.Minecraft;
// import net.minecraft.client.entity.player.ClientPlayerEntity;
// import net.minecraft.enchantment.Enchantment;
// import net.minecraft.enchantment.EnchantmentHelper;
// import net.minecraft.item.ItemStack;
// import org.spongepowered.asm.mixin.Mixin;
// import org.spongepowered.asm.mixin.Shadow;
// import org.spongepowered.asm.mixin.injection.At;
// import org.spongepowered.asm.mixin.injection.Inject;
// import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
//
// import java.util.Map;
//
// @Mixin(value = FTBUltimineClient.class, remap = false)
// public abstract class FTBUltimineClientMixin {
//
//     @Shadow private boolean canUltimine;
//
//     @Inject(method = "clientTick", at = @At("RETURN"))
//     private void afterCanUltimine(Minecraft mc, CallbackInfo ci) {
//         ClientPlayerEntity player = Minecraft.getInstance().player;
//         if (player != null) {
//             ItemStack itemStack = player.getMainHandItem();
//             Map<Enchantment, Integer> map = EnchantmentHelper.getEnchantments(itemStack);
//             canUltimine = map.containsKey(ModEnchantments.VEIN_UPGRADE.get());
//         }
//     }
//
// }
