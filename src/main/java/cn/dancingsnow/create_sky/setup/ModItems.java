package cn.dancingsnow.create_sky.setup;

import cn.dancingsnow.create_sky.CreateSky;
import cn.dancingsnow.create_sky.setup.Custom.item.GetMechanisms;
import net.minecraft.item.Item;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.fml.RegistryObject;

public class ModItems {

    private static final String TOOLTIPS = "item." + CreateSky.MOD_ID + ".%s.tooltip";

    public static final RegistryObject<Item> KINETIC_MECHANISM = Registration.ITEMS.register("kinetic_mechanism", () ->
            GetMechanisms.getNewItem(new TranslationTextComponent(String.format(TOOLTIPS, "kinetic_mechanism")), Boolean.TRUE)
    );
    public static final RegistryObject<Item> SEALED_MECHANISM = Registration.ITEMS.register("sealed_mechanism", () ->
            GetMechanisms.getNewItem(new TranslationTextComponent(String.format(TOOLTIPS, "sealed_mechanism")))
    );
    public static final RegistryObject<Item> INFERNAL_MECHANISM = Registration.ITEMS.register("infernal_mechanism", () ->
            GetMechanisms.getNewItem(new TranslationTextComponent(String.format(TOOLTIPS, "infernal_mechanism")))
    );
    public static final RegistryObject<Item> INDUCTIVE_MECHANISM = Registration.ITEMS.register("inductive_mechanism", () ->
            GetMechanisms.getNewItem(new TranslationTextComponent(String.format(TOOLTIPS, "inductive_mechanism")),Boolean.TRUE)
    );
    public static final RegistryObject<Item> ABSTRUSE_MECHANISM = Registration.ITEMS.register("abstruse_mechanism", () ->
            GetMechanisms.getNewItem(new TranslationTextComponent(String.format(TOOLTIPS, "abstruse_mechanism")))
    );
    public static final RegistryObject<Item> CALCULATION_MECHANISM = Registration.ITEMS.register("calculation_mechanism", () ->
            GetMechanisms.getNewItem(new TranslationTextComponent(String.format(TOOLTIPS, "calculation_mechanism")),Boolean.TRUE)
    );

    public static final RegistryObject<Item> INCOMPLETE_KINETIC_MECHANISM = Registration.ITEMS.register("incomplete_kinetic_mechanism", () ->
            GetMechanisms.getNewItemNoTab(new TranslationTextComponent(String.format(TOOLTIPS, "kinetic_mechanism")), Boolean.TRUE)
    );
    public static final RegistryObject<Item> INCOMPLETE_INFERNAL_MECHANISM = Registration.ITEMS.register("incomplete_infernal_mechanism", () ->
            GetMechanisms.getNewItemNoTab(new TranslationTextComponent(String.format(TOOLTIPS, "incomplete_infernal_mechanism")))
    );
    public static final RegistryObject<Item> INCOMPLETE_INDUCTIVE_MECHANISM = Registration.ITEMS.register("incomplete_inductive_mechanism", () ->
            GetMechanisms.getNewItem(new TranslationTextComponent(String.format(TOOLTIPS, "incomplete_inductive_mechanism")),Boolean.TRUE)
    );
    public static final RegistryObject<Item> INCOMPLETE_CALCULATION_MECHANISM = Registration.ITEMS.register("incomplete_calculation_mechanism", () ->
            GetMechanisms.getNewItem(new TranslationTextComponent(String.format(TOOLTIPS, "incomplete_calculation_mechanism")),Boolean.TRUE)
    );

    static void register() {}
}
