package io.github.racoondog.colorimetry;

import io.github.racoondog.colorimetry.blocks.Blocks;
import io.github.racoondog.colorimetry.config.ModConfig;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import net.devtech.arrp.api.RRPCallback;
import net.devtech.arrp.api.RuntimeResourcePack;
import net.fabricmc.api.ModInitializer;

public class Colorimetry implements ModInitializer {
    public static final String modID = "colorimetry";
    public static ModConfig config;
    public static final RuntimeResourcePack RESOURCE_PACK = RuntimeResourcePack.create(new StringBuilder(modID).append(":pack").toString());

    @Override
    public void onInitialize() {
        AutoConfig.register(ModConfig.class, JanksonConfigSerializer::new);
        config = AutoConfig.getConfigHolder(ModConfig.class).getConfig();
        Blocks.registerBlocks();
        RRPCallback.AFTER_VANILLA.register(a -> a.add(RESOURCE_PACK));
    }
}