package cn.dancingsnow.create_sky.setup.Custom.item;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class Mechanisms extends Item {
    private final TextComponent text;
    private final boolean suggestion;

    public Mechanisms(Properties properties, TranslationTextComponent textComponent, boolean suggestion) {
        super(properties);
        this.text = textComponent;
        this.suggestion = suggestion;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World world, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(text);
        if (suggestion) {
            tooltip.add(new TranslationTextComponent("item.create_sky.mechanisms.suggestion"));
        }
        super.appendHoverText(stack, world, tooltip, flagIn);
    }
}
