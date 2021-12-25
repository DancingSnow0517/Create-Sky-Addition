package cn.dancingsnow.create_sky.data;

import cn.dancingsnow.create_sky.CreateSky;
import cn.dancingsnow.create_sky.setup.ModItems;
import cn.dancingsnow.create_sky.setup.ModTags;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nullable;

public class ModItemTagsProvider extends ItemTagsProvider {

    public ModItemTagsProvider(DataGenerator dataGenerator, BlockTagsProvider blockTagsProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(dataGenerator, blockTagsProvider, CreateSky.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        copy(ModTags.Blocks.MACHINE, ModTags.Items.MACHINE);

        tag(ModTags.Items.MECHANISMS).add(ModItems.KINETIC_MECHANISM.get());
        tag(ModTags.Items.MECHANISMS).add(ModItems.SEALED_MECHANISM.get());
        tag(ModTags.Items.MECHANISMS).add(ModItems.INFERNAL_MECHANISM.get());
        tag(ModTags.Items.MECHANISMS).add(ModItems.INDUCTIVE_MECHANISM.get());
        tag(ModTags.Items.MECHANISMS).add(ModItems.ABSTRUSE_MECHANISM.get());
        tag(ModTags.Items.MECHANISMS).add(ModItems.CALCULATION_MECHANISM.get());

        tag(ModTags.Items.INCOMPLETES).add(ModItems.INCOMPLETE_KINETIC_MECHANISM.get());
        tag(ModTags.Items.INCOMPLETES).add(ModItems.INCOMPLETE_INFERNAL_MECHANISM.get());
        tag(ModTags.Items.INCOMPLETES).add(ModItems.INCOMPLETE_INDUCTIVE_MECHANISM.get());
        tag(ModTags.Items.INCOMPLETES).add(ModItems.INCOMPLETE_CALCULATION_MECHANISM.get());

        tag(ModTags.Items.NUMBERS).add(ModItems.ZERO.get());
        tag(ModTags.Items.NUMBERS).add(ModItems.ONE.get());
        tag(ModTags.Items.NUMBERS).add(ModItems.TWO.get());
        tag(ModTags.Items.NUMBERS).add(ModItems.THREE.get());
        tag(ModTags.Items.NUMBERS).add(ModItems.FOUR.get());
        tag(ModTags.Items.NUMBERS).add(ModItems.FIVE.get());
        tag(ModTags.Items.NUMBERS).add(ModItems.SIX.get());
        tag(ModTags.Items.NUMBERS).add(ModItems.SEVEN.get());
        tag(ModTags.Items.NUMBERS).add(ModItems.EIGHT.get());
        tag(ModTags.Items.NUMBERS).add(ModItems.NINE.get());
        tag(ModTags.Items.NUMBERS).add(ModItems.PLUS.get());
        tag(ModTags.Items.NUMBERS).add(ModItems.MINUS.get());
        tag(ModTags.Items.NUMBERS).add(ModItems.MULTIPLY.get());
        tag(ModTags.Items.NUMBERS).add(ModItems.DIVIDE.get());
        tag(ModTags.Items.NUMBERS).add(ModItems.MISSINGNO.get());

    }
}
