package cn.dancingsnow.create_sky.data.client;


import cn.dancingsnow.create_sky.CreateSky;
import cn.dancingsnow.create_sky.setup.ModBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, CreateSky.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

        horizontalBlock(ModBlocks.ANDESITE_MACHINE.get(), getModel("andesite_machine"));
        horizontalBlock(ModBlocks.COPPER_MACHINE.get(), getModel("copper_machine"));
        horizontalBlock(ModBlocks.BRASS_MACHINE.get(), getModel("brass_machine"));
        horizontalBlock(ModBlocks.ZINC_MACHINE.get(), getModel("zinc_machine"));
        horizontalBlock(ModBlocks.ENDERIUM_MACHINE.get(), getModel("enderium_machine"));
        simpleBlock(ModBlocks.ZINC_CASING.get());
        simpleBlock(ModBlocks.INVAR_CASING.get());
        simpleBlock(ModBlocks.FLUIX_CASING.get());
        simpleBlock(ModBlocks.ENDERIUM_CASING.get(), getModel("enderium_casing"));

    }

    public ModelFile getModel(String name) {
        return models().getExistingFile(modLoc("block/" + name));
    }
}
