package cn.dancingsnow.create_sky.mixin;

import net.minecraft.client.gui.screen.MainMenuScreen;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MainMenuScreen.class)
public class TestMixin {

    @Shadow @Final private static Logger LOGGER;

    @Inject(at = @At("HEAD"), method = "init()V")
    private void init(CallbackInfo info) {
        LOGGER.info("This line is printed by an example mod mixin!");
    }
}

