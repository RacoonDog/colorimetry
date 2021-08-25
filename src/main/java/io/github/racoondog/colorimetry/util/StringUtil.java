package io.github.racoondog.colorimetry.util;

import io.github.racoondog.colorimetry.Colorimetry;
import net.minecraft.util.Identifier;

public class StringUtil {
    public static String path(String path, String string) {
        return new StringBuilder(path.toLowerCase()).append('_').append(string.toLowerCase()).toString();
    }
    public static Identifier prefixPath(Identifier identifier, String prefix) {
        return new Identifier(identifier.getNamespace(), new StringBuilder(prefix.toLowerCase()).append(identifier.getPath()).toString());
    }

    public static Identifier id(String path) {
        return new Identifier(Colorimetry.modID, path.toLowerCase());
    }
}
