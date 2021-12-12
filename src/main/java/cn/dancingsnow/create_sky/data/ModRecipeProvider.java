package cn.dancingsnow.create_sky.data;

import cn.dancingsnow.create_sky.CreateSky;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.util.ResourceLocation;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected void buildShapelessRecipes(Consumer<IFinishedRecipe> consumer) {

    }

    private static ResourceLocation modID(String path) {
        return new ResourceLocation(CreateSky.MOD_ID, path);
    }
}
