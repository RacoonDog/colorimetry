package io.github.racoondog.colorimetry.util;

import me.shedaniel.math.Color;
import net.minecraft.util.Formatting;

public class ColorUtil {
    public static int[] genColors(int count) {
        int[] output = new int[count];
        float x = 360.0f / count;
        for (int i = 0; i < count; i++) {
            float h = x * i / 360.0f;
            output[i] = Color.HSBtoRGB(h, 1.0f, 1.0f);
        }
        return output;
    }

    public static Formatting formatFromHue(int hue) {
        switch (hue) {
            case 40: return Formatting.GOLD;
            case 240: return Formatting.BLUE;
            case 120: return Formatting.GREEN;
            case 180: return Formatting.AQUA;
            case 0: return Formatting.RED;
            case 300: return Formatting.LIGHT_PURPLE;
            case 60: return Formatting.YELLOW;
            default: return Formatting.GRAY;
        }
    }

    public static int getHue(int color) {
        int red = color >> 16 & 0xFF;
        int green = color >> 8 & 0xFF;
        int blue = color & 0xFF;

        float min = Math.min(Math.min(red, green), blue);
        float max = Math.max(Math.max(red, green), blue);

        if (min == max) return 0;

        float hue = 0f;
        if (max == red) {
            hue = (green - blue) / (max - min);
        } else if (max == green) {
            hue = 2f + (blue - red) / (max - min);
        } else {
            hue = 4f + (red - green) / (max - min);
        }

        hue = hue * 60;
        if (hue < 0) hue = hue + 360;

        return Math.round(hue);
    }

    private static int[] clist = new int[]{40, 240, 120, 180, 0, 300, 60};

    public static Formatting getClosestColorHue(int hue) {
        int distance = Math.abs(clist[0] - hue);
        int idx = 0;
        for(int c = 1; c < clist.length; c++){
            int cdistance = Math.abs(clist[c] - hue);
            if(cdistance < distance){
                idx = c;
                distance = cdistance;
            }
        }
        return formatFromHue(clist[idx]);
    }
}