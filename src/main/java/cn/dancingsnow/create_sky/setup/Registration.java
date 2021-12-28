package cn.dancingsnow.create_sky.setup;

import cn.dancingsnow.create_sky.CreateSky;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class Registration {
    public static final DeferredRegister<Block> BLOCKS = create(ForgeRegistries.BLOCKS);
    public static final DeferredRegister<Item> ITEMS = create(ForgeRegistries.ITEMS);
    public static final DeferredRegister<Fluid> FLUIDS = create(ForgeRegistries.FLUIDS);
    public static final DeferredRegister<Enchantment> ENCHANTMENT = create(ForgeRegistries.ENCHANTMENTS);

    public static <T extends IForgeRegistryEntry<T>> DeferredRegister<T> create(IForgeRegistry<T> registry) {
        return DeferredRegister.create(registry, CreateSky.MOD_ID);
    }

    public static void register() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);
        FLUIDS.register(modEventBus);
        ENCHANTMENT.register(modEventBus);
        //CONTAINERS.register(modEventBus);
        //TILE_ENTITIES.register(modEventBus);
        //RECIPE_SERIALIZERS.register(modEventBus);

        ModBlocks.register();
        ModItems.register();
        ModFluids.register();
        ModEnchantments.register();
        //ModContainerTypes.register();
        //ModTileEntityTypes.register();
        //ModRecipes.register();
    }

    /*@Mod.EventBusSubscriber(modid = CreateSky.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class Client {
        public static void onClientSetup(FMLClientSetupEvent event) {
            ModContainerTypes.registerScreens(event);
        }
    }*/
}
