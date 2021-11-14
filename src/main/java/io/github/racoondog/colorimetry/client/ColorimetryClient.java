package io.github.racoondog.colorimetry.client;

import io.github.racoondog.colorimetry.blocks.Blocks;
import io.github.racoondog.colorimetry.blocks.generic.ColoredPlanksBlock;
import io.github.racoondog.colorimetry.blocks.generic.ColoredSandBlock;
import io.github.racoondog.colorimetry.blocks.generic.ColoredStoneBlock;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;

@net.fabricmc.api.Environment(net.fabricmc.api.EnvType.CLIENT)
public class ColorimetryClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        registerSandColors();
        registerStoneColors();
        registerPlanksColors();
    }

    public static void registerSandColors() {
        for (int i = 0; i < Blocks.coloredSand.length; i++) {
            ColoredSandBlock block = Blocks.coloredSand[i];
            ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> block.getColor(), block);
            ColorProviderRegistry.ITEM.register((stack, tintIndex) -> block.getColor(), block.asItem());
        }
    }
    public static void registerStoneColors() {
        for (int i = 0; i < Blocks.coloredStone.length; i++) {
            ColoredStoneBlock block = Blocks.coloredStone[i];
            ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> block.getColor(), block);
            ColorProviderRegistry.ITEM.register((stack, tintIndex) -> block.getColor(), block.asItem());
        }
    }
    public static void registerPlanksColors() {
        for (int i = 0; i < Blocks.coloredStone.length; i++) {
            ColoredPlanksBlock block = Blocks.coloredPlanks[i];
            ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> block.getColor(), block);
            ColorProviderRegistry.ITEM.register((stack, tintIndex) -> block.getColor(), block.asItem());
        }
    }
}
