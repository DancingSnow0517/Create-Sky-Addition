package cn.dancingsnow.create_sky.setup.Custom.item;

import cn.dancingsnow.create_sky.setup.ModGroups;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class GetMechanisms {
    public static Item getNewItem(TranslationTextComponent tooltip) {
        class Mechanisms extends Item {
            public Mechanisms(Properties properties) {
                super(properties);
            }

            @Override
            public void appendHoverText(ItemStack itemStack, @Nullable World world, List<ITextComponent> tooltips, ITooltipFlag flagIn) {

                tooltips.add(tooltip);

                super.appendHoverText(itemStack, world, tooltips, flagIn);
            }
        }
        return new Mechanisms(new Item.Properties().tab(ModGroups.ADDITIONS));
    }

    public static Item getNewItem(TranslationTextComponent tooltip, Boolean suggestion) {
        class Mechanisms extends Item {
            public Mechanisms(Properties properties) {
                super(properties);
            }

            @Override
            public void appendHoverText(ItemStack itemStack, @Nullable World world, List<ITextComponent> tooltips, ITooltipFlag flagIn) {

                tooltips.add(tooltip);

                if (suggestion == Boolean.TRUE) {
                    tooltips.add(new TranslationTextComponent("item.create_sky.mechanisms.suggestion"));
                }

                super.appendHoverText(itemStack, world, tooltips, flagIn);
            }
        }
        return new Mechanisms(new Item.Properties().tab(ModGroups.ADDITIONS));
    }

    public static Item getNewItemNoTab(TranslationTextComponent tooltip) {
        class Mechanisms extends Item {
            public Mechanisms(Properties properties) {
                super(properties);
            }

            @Override
            public void appendHoverText(ItemStack itemStack, @Nullable World world, List<ITextComponent> tooltips, ITooltipFlag flagIn) {

                tooltips.add(tooltip);

                super.appendHoverText(itemStack, world, tooltips, flagIn);
            }
        }
        return new Mechanisms(new Item.Properties());
    }

    public static Item getNewItemNoTab(TranslationTextComponent tooltip, Boolean suggestion) {
        class Mechanisms extends Item {
            public Mechanisms(Properties properties) {
                super(properties);
            }

            @Override
            public void appendHoverText(ItemStack itemStack, @Nullable World world, List<ITextComponent> tooltips, ITooltipFlag flagIn) {

                tooltips.add(tooltip);

                if (suggestion == Boolean.TRUE) {
                    tooltips.add(new TranslationTextComponent("item.create_sky.mechanisms.suggestion"));
                }

                super.appendHoverText(itemStack, world, tooltips, flagIn);
            }
        }
        return new Mechanisms(new Item.Properties());
    }


}
