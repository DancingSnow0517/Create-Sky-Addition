package cn.dancingsnow.create_sky.setup;

import cn.dancingsnow.create_sky.CreateSky;
import cn.dancingsnow.create_sky.setup.Custom.item.Mechanisms;
import cn.dancingsnow.create_sky.setup.Custom.item.Numbers;
import com.simibubi.create.content.AllSections;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.repack.registrate.util.entry.ItemEntry;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.Rarity;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.fml.RegistryObject;

@SuppressWarnings("unused")
public class ModItems {

    private static final String TOOLTIPS = "item." + CreateSky.MOD_ID + ".tooltip.%s";
    private static final CreateRegistrate REGISTRATE = CreateSky.getRegistrate().itemGroup(() -> ModGroups.ADDITIONS);

    static {REGISTRATE.startSection(AllSections.KINETICS);}

    public static final ItemEntry<Mechanisms> KINETIC_MECHANISM = getMechanisms("kinetic_mechanism", true);
    public static final ItemEntry<Mechanisms> SEALED_MECHANISM = getMechanisms("sealed_mechanism", true);
    public static final ItemEntry<Mechanisms> INFERNAL_MECHANISM = getMechanisms("infernal_mechanism", false);
    public static final ItemEntry<Mechanisms> INDUCTIVE_MECHANISM = getMechanisms("inductive_mechanism", true, Rarity.UNCOMMON);
    public static final ItemEntry<Mechanisms> ABSTRUSE_MECHANISM = getMechanisms("abstruse_mechanism", false, Rarity.RARE);
    public static final ItemEntry<Mechanisms> CALCULATION_MECHANISM = getMechanisms("calculation_mechanism", true, Rarity.RARE);

    public static final ItemEntry<Item> INCOMPLETE_KINETIC_MECHANISM = getMechanismsNotab("incomplete_kinetic_mechanism");
    public static final ItemEntry<Item> INCOMPLETE_INFERNAL_MECHANISM = getMechanismsNotab("incomplete_infernal_mechanism");
    public static final ItemEntry<Item> INCOMPLETE_INDUCTIVE_MECHANISM = getMechanismsNotab("incomplete_inductive_mechanism");
    public static final ItemEntry<Item> INCOMPLETE_CALCULATION_MECHANISM = getMechanismsNotab("incomplete_calculation_mechanism");

    public static final ItemEntry<Item> ASH = REGISTRATE.item("ash", Item::new).register();

    public static final ItemEntry<Numbers> ZERO = getNumbers("zero");
    public static final ItemEntry<Numbers> ONE = getNumbers("one");
    public static final ItemEntry<Numbers> TWO = getNumbers("two");
    public static final ItemEntry<Numbers> THREE = getNumbers("three");
    public static final ItemEntry<Numbers> FOUR = getNumbers("four");
    public static final ItemEntry<Numbers> FIVE = getNumbers("five");
    public static final ItemEntry<Numbers> SIX = getNumbers("six");
    public static final ItemEntry<Numbers> SEVEN = getNumbers("seven");
    public static final ItemEntry<Numbers> EIGHT = getNumbers("eight");
    public static final ItemEntry<Numbers> NINE = getNumbers("nine");
    public static final ItemEntry<Numbers> PLUS = getNumbers("plus");
    public static final ItemEntry<Numbers> MINUS = getNumbers("minus");
    public static final ItemEntry<Numbers> MULTIPLY = getNumbers("multiply");
    public static final ItemEntry<Numbers> DIVIDE = getNumbers("divide");
    public static final ItemEntry<Numbers> MISSINGNO = getNumbers("missingno");

    public static final ItemEntry<Item> CHARGED_CALCULATOR = REGISTRATE
            .item("charged_calculator", Item::new)
            .properties(properties -> properties.stacksTo(1))
            .register();

    public static final RegistryObject<Item> LOGIC_BUCKET = Registration.ITEMS.register("logic_bucket", () ->
            new BucketItem(() -> ModFluids.LOGIC_FLUID.get(), new Item.Properties()
                    .tab(ModGroups.ADDITIONS)
                    .stacksTo(1)));
    public static final RegistryObject<Item> NUMBER_0_BUCKET = Registration.ITEMS.register("number_0_bucket", () ->
            new BucketItem(() -> ModFluids.NUMBER_0_FLUID.get(), new Item.Properties()
                    .tab(ModGroups.ADDITIONS)
                    .stacksTo(1)));
    public static final RegistryObject<Item> NUMBER_1_BUCKET = Registration.ITEMS.register("number_1_bucket", () ->
            new BucketItem(() -> ModFluids.NUMBER_1_FLUID.get(), new Item.Properties()
                    .tab(ModGroups.ADDITIONS)
                    .stacksTo(1)));
    public static final RegistryObject<Item> NUMBER_2_BUCKET = Registration.ITEMS.register("number_2_bucket", () ->
            new BucketItem(() -> ModFluids.NUMBER_2_FLUID.get(), new Item.Properties()
                    .tab(ModGroups.ADDITIONS)
                    .stacksTo(1)));
    public static final RegistryObject<Item> NUMBER_3_BUCKET = Registration.ITEMS.register("number_3_bucket", () ->
            new BucketItem(() -> ModFluids.NUMBER_3_FLUID.get(), new Item.Properties()
                    .tab(ModGroups.ADDITIONS)
                    .stacksTo(1)));
    public static final RegistryObject<Item> NUMBER_4_BUCKET = Registration.ITEMS.register("number_4_bucket", () ->
            new BucketItem(() -> ModFluids.NUMBER_4_FLUID.get(), new Item.Properties()
                    .tab(ModGroups.ADDITIONS)
                    .stacksTo(1)));
    public static final RegistryObject<Item> NUMBER_5_BUCKET = Registration.ITEMS.register("number_5_bucket", () ->
            new BucketItem(() -> ModFluids.NUMBER_5_FLUID.get(), new Item.Properties()
                    .tab(ModGroups.ADDITIONS)
                    .stacksTo(1)));
    public static final RegistryObject<Item> NUMBER_6_BUCKET = Registration.ITEMS.register("number_6_bucket", () ->
            new BucketItem(() -> ModFluids.NUMBER_6_FLUID.get(), new Item.Properties()
                    .tab(ModGroups.ADDITIONS)
                    .stacksTo(1)));
    public static final RegistryObject<Item> NUMBER_7_BUCKET = Registration.ITEMS.register("number_7_bucket", () ->
            new BucketItem(() -> ModFluids.NUMBER_7_FLUID.get(), new Item.Properties()
                    .tab(ModGroups.ADDITIONS)
                    .stacksTo(1)));
    public static final RegistryObject<Item> NUMBER_8_BUCKET = Registration.ITEMS.register("number_8_bucket", () ->
            new BucketItem(() -> ModFluids.NUMBER_8_FLUID.get(), new Item.Properties()
                    .tab(ModGroups.ADDITIONS)
                    .stacksTo(1)));
    public static final RegistryObject<Item> NUMBER_9_BUCKET = Registration.ITEMS.register("number_9_bucket", () ->
            new BucketItem(() -> ModFluids.NUMBER_9_FLUID.get(), new Item.Properties()
                    .tab(ModGroups.ADDITIONS)
                    .stacksTo(1)));
    public static final RegistryObject<Item> MATRIX_BUCKET = Registration.ITEMS.register("matrix_bucket", () ->
            new BucketItem(() -> ModFluids.MATRIX_FLUID.get(), new Item.Properties()
                    .tab(ModGroups.ADDITIONS)
                    .stacksTo(1)));

    static void register() {
        CreateSky.LOGGER.debug("Registering Moditems");
    }

    public static ItemEntry<Mechanisms> getMechanisms(String reg_id, boolean suggestion) {
        return getMechanisms(reg_id, suggestion, Rarity.COMMON);
    }

    public static ItemEntry<Mechanisms> getMechanisms(String reg_id, boolean suggestion, Rarity rarity) {
        TranslationTextComponent textComponent = new TranslationTextComponent(String.format(TOOLTIPS, reg_id));
        return REGISTRATE
                .item(reg_id, p -> new Mechanisms(p, textComponent, suggestion))
                .register();
    }

    public static ItemEntry<Item> getMechanismsNotab(String reg_id) {
        return REGISTRATE
                .item(reg_id, p -> new Item(p))
                .properties(properties -> properties.stacksTo(64))
                .register();
    }

    public static ItemEntry<Numbers> getNumbers(String reg_id) {
        return REGISTRATE
                .item(reg_id, p -> new Numbers(p))
                .properties(properties -> properties.stacksTo(64))
                .register();
    }

    public static RegistryObject<BucketItem> getBucketItem(String reg_id, FlowingFluid fluid) {
        return Registration.ITEMS.register(reg_id, () ->
                new BucketItem(fluid, new Item.Properties().tab(ModGroups.ADDITIONS).stacksTo(1)));
    }

}
