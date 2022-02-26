package cn.dancingsnow.create_sky;

import cn.dancingsnow.create_sky.data.PonderIndex;
import com.simibubi.create.AllParticleTypes;
import com.simibubi.create.CreateClient;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class CreateSkyClient {

    public static void onCtorClient(IEventBus modEventBus, IEventBus forgeEventBus) {
        modEventBus.addListener(CreateClient::clientInit);
        modEventBus.addListener(AllParticleTypes::registerFactories);
    }

    public static void clientInit(final FMLClientSetupEvent event) {
        PonderIndex.register();
    }

}
