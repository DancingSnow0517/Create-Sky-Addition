//package cn.dancingsnow.create_sky.mixin;
//
//import cn.dancingsnow.create_sky.setup.ModEnchantments;
// import dev.ftb.mods.ftbultimine.FTBUltimine;
// import net.minecraft.enchantment.Enchantment;
// import net.minecraft.enchantment.EnchantmentHelper;
// import net.minecraft.entity.player.PlayerEntity;
// import net.minecraft.item.ItemStack;
// import org.spongepowered.asm.mixin.Mixin;
// import org.spongepowered.asm.mixin.injection.At;
// import org.spongepowered.asm.mixin.injection.Inject;
// import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
//
// import java.util.Map;
//
// @Mixin(value = FTBUltimine.class, remap = false)
// public class FTBUltimineMixin {
//
//     @Inject(method = "canUltimine", at = @At("RETURN"), cancellable = true)
//     private void afterCanUltimine(PlayerEntity player, CallbackInfoReturnable<Boolean> cir) {
//         if (!cir.getReturnValue()) {
//             return;
//         }
//         ItemStack itemStack = player.getMainHandItem();
//         Map<Enchantment, Integer> map = EnchantmentHelper.getEnchantments(itemStack);
//         cir.setReturnValue(map.containsKey(ModEnchantments.VEIN_UPGRADE.get()));
//     }
//
//     @Inject(method = "getMaxBlocks", at = @At("RETURN"), cancellable = true)
//     private void getMaxBlocks(PlayerEntity player, CallbackInfoReturnable<Integer> cir) {
//         if (cir.getReturnValue() == 0) {
//             return;
//         }
//         ItemStack itemStack = player.getMainHandItem();
//         Map<Enchantment, Integer> map = EnchantmentHelper.getEnchantments(itemStack);
//         if (map.containsKey(ModEnchantments.VEIN_UPGRADE.get())) {
//             int level = map.get(ModEnchantments.VEIN_UPGRADE.get());
//             cir.setReturnValue((int) (16 * Math.pow(2, level-1)));
//         } else
//             cir.setReturnValue(0);
//     }
// }
