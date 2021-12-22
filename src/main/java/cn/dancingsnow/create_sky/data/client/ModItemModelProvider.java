package cn.dancingsnow.create_sky.data.client;

import cn.dancingsnow.create_sky.CreateSky;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
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

    }

    private ItemModelBuilder builder(ModelFile itemGenerated, String name) {
        return getBuilder(name).parent(itemGenerated).texture("layer0", "item/" + name);
    }
}
