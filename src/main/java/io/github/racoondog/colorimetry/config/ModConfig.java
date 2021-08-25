package io.github.racoondog.colorimetry.config;

import io.github.racoondog.colorimetry.Colorimetry;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;

@Config(name = Colorimetry.modID)
public class ModConfig implements ConfigData {
    public int sandColors = 16;
}
