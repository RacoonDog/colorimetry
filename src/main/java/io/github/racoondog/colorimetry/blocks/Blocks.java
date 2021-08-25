package io.github.racoondog.colorimetry.blocks;

import io.github.racoondog.colorimetry.Colorimetry;
import io.github.racoondog.colorimetry.blocks.generic.ColoredSandBlock;
import io.github.racoondog.colorimetry.util.ColorUtil;
import io.github.racoondog.colorimetry.util.ARRPUtil;
import io.github.racoondog.colorimetry.util.StringUtil;
import net.devtech.arrp.api.RuntimeResourcePack;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Blocks {
    public static ColoredSandBlock[] coloredSand;
    public static int[] coloredSandColors;
    private static final RuntimeResourcePack pack = Colorimetry.RESOURCE_PACK;

    public static void registerBlocks() {
        registerSand();
    }

    private static void registerSand() {
        coloredSandColors = ColorUtil.genColors(Colorimetry.config.sandColors);
        coloredSand = new ColoredSandBlock[coloredSandColors.length];
        for (int i = 0; i < coloredSandColors.length; i++) {
            ColoredSandBlock block = new ColoredSandBlock(coloredSandColors[i], FabricBlockSettings.copyOf(net.minecraft.block.Blocks.SAND));
            Identifier id = StringUtil.id(StringUtil.path("colored_sand", block.getHexColor()));
            Registry.register(Registry.BLOCK, id, block);
            Registry.register(Registry.ITEM, id, new BlockItem(block, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));
            coloredSand[i] = block;
            ARRPUtil.addLootTable(id, pack);
            ARRPUtil.addBlockState(id, "colored_sand", pack);
            ARRPUtil.addBlockItemModel(id, "colored_sand", pack);
        }
    }
}
