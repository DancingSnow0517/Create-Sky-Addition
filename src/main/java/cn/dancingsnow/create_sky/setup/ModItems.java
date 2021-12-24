package cn.dancingsnow.create_sky.setup;

import cn.dancingsnow.create_sky.CreateSky;
import cn.dancingsnow.create_sky.setup.Custom.item.Mechanisms;
import net.minecraft.item.Item;
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
}
