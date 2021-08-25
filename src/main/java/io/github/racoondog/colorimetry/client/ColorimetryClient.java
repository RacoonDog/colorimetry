package io.github.racoondog.colorimetry.client;

import io.github.racoondog.colorimetry.blocks.Blocks;
import io.github.racoondog.colorimetry.blocks.generic.ColoredSandBlock;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;

@net.fabricmc.api.Environment(net.fabricmc.api.EnvType.CLIENT)
public class ColorimetryClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        registerSandColors();
    }

    public static void registerSandColors() {
        for (int i = 0; i < Blocks.coloredSand.length; i++) {
            ColoredSandBlock block = Blocks.coloredSand[i];
            ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> block.getColor(), block);
            ColorProviderRegistry.ITEM.register((stack, tintIndex) -> block.getColor(), block.asItem());
        }
    }
}
