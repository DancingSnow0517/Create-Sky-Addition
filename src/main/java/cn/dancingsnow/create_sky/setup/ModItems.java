package cn.dancingsnow.create_sky.setup;

import cn.dancingsnow.create_sky.CreateSky;
import cn.dancingsnow.create_sky.setup.Custom.item.Mechanisms;
import net.minecraft.item.Item;
import net.minecraft.item.Rarity;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.fml.RegistryObject;

public class ModItems {

    private static final String TOOLTIPS = "item." + CreateSky.MOD_ID + ".%s.tooltip";

    public static final RegistryObject<Item> KINETIC_MECHANISM = getMechanisms("kinetic_mechanism", Boolean.TRUE);
    public static final RegistryObject<Item> SEALED_MECHANISM = getMechanisms("sealed_mechanism", Boolean.FALSE);
    public static final RegistryObject<Item> INFERNAL_MECHANISM = getMechanisms("infernal_mechanism", Boolean.FALSE);
    public static final RegistryObject<Item> INDUCTIVE_MECHANISM = getMechanisms("inductive_mechanism", Boolean.TRUE);
    public static final RegistryObject<Item> ABSTRUSE_MECHANISM = getMechanisms("abstruse_mechanism", Boolean.FALSE);
    public static final RegistryObject<Item> CALCULATION_MECHANISM = getMechanisms("calculation_mechanism", Boolean.TRUE);

    public static final RegistryObject<Item> INCOMPLETE_KINETIC_MECHANISM = getMechanismsNotab("incomplete_kinetic_mechanism", Boolean.TRUE);
    public static final RegistryObject<Item> INCOMPLETE_INFERNAL_MECHANISM = getMechanismsNotab("incomplete_infernal_mechanism", Boolean.FALSE);
    public static final RegistryObject<Item> INCOMPLETE_INDUCTIVE_MECHANISM = getMechanismsNotab("incomplete_inductive_mechanism", Boolean.TRUE);
    public static final RegistryObject<Item> INCOMPLETE_CALCULATION_MECHANISM = getMechanismsNotab("incomplete_calculation_mechanism", Boolean.TRUE);

    public static final RegistryObject<Item> ZERO = getNumbers("zero");
    public static final RegistryObject<Item> ONE = getNumbers("one");
    public static final RegistryObject<Item> TWO = getNumbers("two");
    public static final RegistryObject<Item> THREE = getNumbers("three");
    public static final RegistryObject<Item> FOUR = getNumbers("four");
    public static final RegistryObject<Item> FIVE = getNumbers("five");
    public static final RegistryObject<Item> SIX = getNumbers("six");
    public static final RegistryObject<Item> SEVEN = getNumbers("seven");
    public static final RegistryObject<Item> EIGHT = getNumbers("eight");
    public static final RegistryObject<Item> NINE = getNumbers("nine");
    public static final RegistryObject<Item> PLUS = getNumbers("plus");
    public static final RegistryObject<Item> MINUS = getNumbers("minus");
    public static final RegistryObject<Item> MULTIPLY = getNumbers("multiply");
    public static final RegistryObject<Item> DIVIDE = getNumbers("divide");
    public static final RegistryObject<Item> MISSINGNO = getNumbers("missingno");

    public static final RegistryObject<Item> CALCULATOR = Registration.ITEMS.register("calculator", () ->
            new Item(new Item.Properties()
                    .tab(ModGroups.ADDITIONS)
                    .stacksTo(1)));
    public static final RegistryObject<Item> CHARGED_CALCULATOR = Registration.ITEMS.register("charged_calculator", () ->
            new Item(new Item.Properties()
                    .tab(ModGroups.ADDITIONS)
                    .stacksTo(1)));

    static void register() {}

    public static RegistryObject<Item> getMechanisms(String reg_id, Boolean suggestion){
        TranslationTextComponent textComponent = new TranslationTextComponent(String.format(TOOLTIPS, reg_id));
        return Registration.ITEMS.register(reg_id, () ->
                new Mechanisms(new Item.Properties().tab(ModGroups.ADDITIONS), textComponent, suggestion));
    }

    public static RegistryObject<Item> getMechanismsNotab(String reg_id, Boolean suggestion){
        TranslationTextComponent textComponent = new TranslationTextComponent(String.format(TOOLTIPS, reg_id));
        return Registration.ITEMS.register(reg_id, () ->
                new Mechanisms(new Item.Properties(), textComponent, suggestion));
    }

    public static RegistryObject<Item> getNumbers(String reg_id) {
        return Registration.ITEMS.register(reg_id, () ->
                new Item(new Item.Properties().tab(ModGroups.ADDITIONS).stacksTo(64).rarity(Rarity.COMMON)));
    }
}
