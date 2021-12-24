package cn.dancingsnow.create_sky.data;

import cn.dancingsnow.create_sky.CreateSky;
import cn.dancingsnow.create_sky.setup.ModBlocks;
import cn.dancingsnow.create_sky.setup.ModItems;
import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllItems;
import net.minecraft.data.*;
import net.minecraft.util.ResourceLocation;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected void buildShapelessRecipes(Consumer<IFinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(ModBlocks.ANDESITE_MACHINE.get())
                .define('A', ModItems.KINETIC_MECHANISM.get())
                .define('B', AllBlocks.ANDESITE_CASING.get())
                .pattern("AAA")
                .pattern("ABA")
                .pattern("AAA")
                .unlockedBy("has_item", has(ModItems.KINETIC_MECHANISM.get()))
                .save(consumer);
    }

    private static ResourceLocation modID(String path) {
        return new ResourceLocation(CreateSky.MOD_ID, path);
    }
}
