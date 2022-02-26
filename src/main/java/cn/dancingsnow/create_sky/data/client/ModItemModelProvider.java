package cn.dancingsnow.create_sky.data.client;

import cn.dancingsnow.create_sky.CreateSky;
import net.minecraft.data.DataGenerator;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, CreateSky.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

        withExistingParent("andesite_machine", modLoc("block/andesite_machine"));
        withExistingParent("copper_machine", modLoc("block/copper_machine"));
        withExistingParent("brass_machine", modLoc("block/brass_machine"));
        withExistingParent("zinc_machine", modLoc("block/zinc_machine"));
        withExistingParent("enderium_machine", modLoc("block/enderium_machine"));
        withExistingParent("zinc_casing", modLoc("block/zinc_casing"));
        withExistingParent("invar_casing", modLoc("block/invar_casing"));
        withExistingParent("fluix_casing", modLoc("block/fluix_casing"));
        withExistingParent("enderium_casing", modLoc("block/enderium_casing"));

        ModelFile itemGenerated = getExistingFile(mcLoc("item/generated"));

        builder(itemGenerated, "kinetic_mechanism");
        builder(itemGenerated, "sealed_mechanism");
        builder(itemGenerated, "infernal_mechanism");
        builder(itemGenerated, "inductive_mechanism");
        builder(itemGenerated, "abstruse_mechanism");
        builder(itemGenerated, "calculation_mechanism");

        builder(itemGenerated, "incomplete_kinetic_mechanism");
        builder(itemGenerated, "incomplete_infernal_mechanism");
        builder(itemGenerated, "incomplete_inductive_mechanism");
        builder(itemGenerated, "incomplete_calculation_mechanism");

        builder(itemGenerated, "ash");

        builder(itemGenerated, "zero");
        builder(itemGenerated, "one");
        builder(itemGenerated, "two");
        builder(itemGenerated, "three");
        builder(itemGenerated, "four");
        builder(itemGenerated, "five");
        builder(itemGenerated, "six");
        builder(itemGenerated, "seven");
        builder(itemGenerated, "eight");
        builder(itemGenerated, "nine");
        builder(itemGenerated, "plus");
        builder(itemGenerated, "minus");
        builder(itemGenerated, "multiply");
        builder(itemGenerated, "divide");
        builder(itemGenerated, "missingno");

        builder(itemGenerated, "charged_calculator");

        bucket_builder(itemGenerated, "logic_bucket");
        bucket_builder(itemGenerated, "number_0_bucket");
        bucket_builder(itemGenerated, "number_1_bucket");
        bucket_builder(itemGenerated, "number_2_bucket");
        bucket_builder(itemGenerated, "number_3_bucket");
        bucket_builder(itemGenerated, "number_4_bucket");
        bucket_builder(itemGenerated, "number_5_bucket");
        bucket_builder(itemGenerated, "number_6_bucket");
        bucket_builder(itemGenerated, "number_7_bucket");
        bucket_builder(itemGenerated, "number_8_bucket");
        bucket_builder(itemGenerated, "number_9_bucket");
        bucket_builder(itemGenerated, "matrix_bucket");

    }

    private void builder(ModelFile itemGenerated, String name) {
        getBuilder(name).parent(itemGenerated).texture("layer0", "item/" + name);
    }

    private void bucket_builder(ModelFile itemGenerated, String name) {
        getBuilder(name).parent(itemGenerated).texture("layer0", "item/bucket/" + name);
    }

}
