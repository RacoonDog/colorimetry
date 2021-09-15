package io.github.racoondog.colorimetry.util;

import net.devtech.arrp.api.RuntimeResourcePack;
import net.devtech.arrp.json.models.JModel;
import net.minecraft.util.Identifier;

import static net.devtech.arrp.json.blockstate.JState.*;
import static net.devtech.arrp.json.loot.JLootTable.*;

public class ARRPUtil {
    public static void addLootTable(Identifier id, RuntimeResourcePack RRP) {
        RRP.addLootTable(StringUtil.prefixPath(id, "blocks/"), loot("minecraft:block").pool(pool().rolls(1).entry(entry().type("minecraft:item").name(id.toString())).condition(predicate("minecraft:survives_explosion"))));
    }
    public static void addBlockState(Identifier id, String parent, RuntimeResourcePack RRP) {
        RRP.addBlockState(state(variant(model(new StringBuilder(id.getNamespace()).append(":block/").append(parent.toLowerCase()).toString()))), id);
    }
    public static void addBlockItemModel(Identifier id, String parent, RuntimeResourcePack RRP) {
        RRP.addModel(JModel.model(new StringBuilder(id.getNamespace()).append(":block/").append(parent.toLowerCase()).toString()), StringUtil.prefixPath(id, "item/"));
    }
    public static void addBlockItemModel(Identifier id, RuntimeResourcePack RRP) {
        addBlockItemModel(id, id.getPath(), RRP);
    }
}