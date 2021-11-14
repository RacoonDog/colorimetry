package io.github.racoondog.colorimetry.blocks.generic;

import io.github.racoondog.colorimetry.util.ColorUtil;
import net.minecraft.block.Block;
import net.minecraft.block.SandBlock;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ColoredStoneBlock extends Block {
    private int color;
    private String hexColor;

    public ColoredStoneBlock(int color, Settings settings) {
        super(settings);
        this.color = color;
        this.hexColor = String.format("%06X", (0xFFFFFF & color));
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable BlockView world, List<Text> tooltip, TooltipContext options) {
        tooltip.add(new LiteralText(new StringBuilder('#').append(this.hexColor).toString()).formatted(ColorUtil.getClosestColorHue(ColorUtil.getHue(this.color))));
    }

    @Override
    public String getTranslationKey() {
        return "block.colorimetry.colored_stone";
    }

    public int getColor() {
        return this.color;
    }

    public String getHexColor() {
        return this.hexColor;
    }
}
