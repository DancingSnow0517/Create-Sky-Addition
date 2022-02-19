package cn.dancingsnow.create_sky;

import cn.dancingsnow.create_sky.setup.Registration;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(CreateSky.MOD_ID)
public class CreateSky {
    public static final String MOD_ID = "create_sky";
    public static final Logger LOGGER = LogManager.getLogger();

    public CreateSky() {
        Registration.register();
    }
}
