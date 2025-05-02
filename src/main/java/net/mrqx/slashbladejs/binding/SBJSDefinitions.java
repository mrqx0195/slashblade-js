package net.mrqx.slashbladejs.binding;

import com.google.gson.JsonElement;
import com.mojang.serialization.JsonOps;
import java.util.HashMap;
import java.util.List;
import mods.flammpfeil.slashblade.client.renderer.CarryType;
import mods.flammpfeil.slashblade.item.SwordType;
import mods.flammpfeil.slashblade.registry.slashblade.EnchantmentDefinition;
import mods.flammpfeil.slashblade.registry.slashblade.PropertiesDefinition;
import mods.flammpfeil.slashblade.registry.slashblade.RenderDefinition;
import mods.flammpfeil.slashblade.registry.slashblade.SlashBladeDefinition;
import net.minecraft.resources.ResourceLocation;
import net.mrqx.slashbladejs.SlashBladeJS;

public class SBJSDefinitions {
    public static class SBSlashBladeDefinition {
        public SlashBladeDefinition of(ResourceLocation name, RenderDefinition renderDefinition,
                PropertiesDefinition stateDefinition, List<EnchantmentDefinition> enchantments) {
            return new SlashBladeDefinition(name, renderDefinition, stateDefinition, enchantments);
        }

        public SlashBladeDefinition of(ResourceLocation item, ResourceLocation name, RenderDefinition renderDefinition,
                PropertiesDefinition stateDefinition, List<EnchantmentDefinition> enchantments) {
            return new SlashBladeDefinition(item, name, renderDefinition, stateDefinition, enchantments);
        }

        public JsonElement toJSON(SlashBladeDefinition definition) {
            return SlashBladeDefinition.CODEC.encodeStart(JsonOps.INSTANCE, definition)
                    .resultOrPartial(SlashBladeJS.LOGGER::error).orElseThrow();
        }

        public SlashBladeDefinition fromJSON(JsonElement json) {
            return SlashBladeDefinition.CODEC.parse(JsonOps.INSTANCE, json).resultOrPartial(SlashBladeJS.LOGGER::error)
                    .orElseThrow();
        }
    }

    public static class SBEnchantmentDefinition {
        public EnchantmentDefinition of(ResourceLocation enchantment, int level) {
            return new EnchantmentDefinition(enchantment, level);
        }

        public JsonElement toJSON(EnchantmentDefinition definition) {
            return EnchantmentDefinition.CODEC.encodeStart(JsonOps.INSTANCE, definition)
                    .resultOrPartial(SlashBladeJS.LOGGER::error).orElseThrow();
        }

        public EnchantmentDefinition fromJSON(JsonElement json) {
            return EnchantmentDefinition.CODEC.parse(JsonOps.INSTANCE, json).resultOrPartial(SlashBladeJS.LOGGER::error)
                    .orElseThrow();
        }
    }

    public static class SBRenderDefinition {
        public RenderDefinition.Builder newInstance() {
            return RenderDefinition.Builder.newInstance();
        }

        public JsonElement toJSON(RenderDefinition definition) {
            return RenderDefinition.CODEC.encodeStart(JsonOps.INSTANCE, definition)
                    .resultOrPartial(SlashBladeJS.LOGGER::error).orElseThrow();
        }

        public RenderDefinition fromJSON(JsonElement json) {
            return RenderDefinition.CODEC.parse(JsonOps.INSTANCE, json).resultOrPartial(SlashBladeJS.LOGGER::error)
                    .orElseThrow();
        }
    }

    public static class SBPropertiesDefinition {
        public PropertiesDefinition.Builder newInstance() {
            return PropertiesDefinition.Builder.newInstance();
        }

        public JsonElement toJSON(PropertiesDefinition definition) {
            return PropertiesDefinition.CODEC.encodeStart(JsonOps.INSTANCE, definition)
                    .resultOrPartial(SlashBladeJS.LOGGER::error).orElseThrow();
        }

        public PropertiesDefinition fromJSON(JsonElement json) {
            return PropertiesDefinition.CODEC.parse(JsonOps.INSTANCE, json).resultOrPartial(SlashBladeJS.LOGGER::error)
                    .orElseThrow();
        }
    }

    public static class SBEnums {
        private HashMap<String, CarryType> SBCarryType = new HashMap<String, CarryType>();
        private HashMap<String, SwordType> SBSwordType = new HashMap<String, SwordType>();

        public HashMap<String, CarryType> SBCarryType() {
            if (SBCarryType.isEmpty()) {
                for (CarryType type : CarryType.values()) {
                    SBCarryType.put(type.name(), type);
                }
            }
            return SBCarryType;
        }

        public HashMap<String, SwordType> SBSwordType() {
            if (SBSwordType.isEmpty()) {
                for (SwordType type : SwordType.values()) {
                    SBSwordType.put(type.name(), type);
                }
            }
            return SBSwordType;
        }
    }
}
