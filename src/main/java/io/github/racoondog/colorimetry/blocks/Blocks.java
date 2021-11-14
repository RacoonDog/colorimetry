package io.github.racoondog.colorimetry.blocks;

import io.github.racoondog.colorimetry.Colorimetry;
import io.github.racoondog.colorimetry.blocks.generic.ColoredPlanksBlock;
import io.github.racoondog.colorimetry.blocks.generic.ColoredSandBlock;
import io.github.racoondog.colorimetry.blocks.generic.ColoredStoneBlock;
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
    public static ColoredStoneBlock[] coloredStone;
    public static ColoredPlanksBlock[] coloredPlanks;
    public static int[] coloredSandColors;
    public static int[] coloredStoneColors;
    public static int[] coloredPlanksColors;
    private static final RuntimeResourcePack pack = Colorimetry.RESOURCE_PACK;

    public static void registerBlocks() {
        registerSand();
        registerStone();
        registerPlanks();
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

    private static void registerStone() {
        coloredStoneColors = ColorUtil.genColors(Colorimetry.config.stoneColors);
        coloredStone = new ColoredStoneBlock[coloredStoneColors.length];
        for (int i = 0; i < coloredStoneColors.length; i++) {
            ColoredStoneBlock block = new ColoredStoneBlock(coloredStoneColors[i], FabricBlockSettings.copyOf(net.minecraft.block.Blocks.STONE));
            Identifier id = StringUtil.id(StringUtil.path("colored_stone", block.getHexColor()));
            Registry.register(Registry.BLOCK, id, block);
            Registry.register(Registry.ITEM, id, new BlockItem(block, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));
            coloredStone[i] = block;
            ARRPUtil.addLootTable(new Identifier("minecraft", "cobblestone"), pack);
            ARRPUtil.addBlockState(id, "colored_stone", pack);
            ARRPUtil.addBlockItemModel(id, "colored_stone", pack);
        }
    }

    private static void registerPlanks() {
        coloredPlanksColors = ColorUtil.genColors(Colorimetry.config.plankColors);
        coloredPlanks = new ColoredPlanksBlock[coloredPlanksColors.length];
        for (int i = 0; i < coloredPlanksColors.length; i++) {
            ColoredPlanksBlock block = new ColoredPlanksBlock(coloredPlanksColors[i], FabricBlockSettings.copyOf(net.minecraft.block.Blocks.OAK_PLANKS));
            Identifier id = StringUtil.id(StringUtil.path("colored_planks", block.getHexColor()));
            Registry.register(Registry.BLOCK, id, block);
            Registry.register(Registry.ITEM, id, new BlockItem(block, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));
            coloredPlanks[i] = block;
            ARRPUtil.addLootTable(id, pack);
            ARRPUtil.addBlockState(id, "colored_planks", pack);
            ARRPUtil.addBlockItemModel(id, "colored_planks", pack);
        }
    }
}
