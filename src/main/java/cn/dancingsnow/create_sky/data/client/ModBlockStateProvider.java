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
        ModelFile and = models().getExistingFile(modLoc("block/andesite_machine"));
        simpleBlock(ModBlocks.ANDESITE_MACHINE.get(), and);
    }
}
