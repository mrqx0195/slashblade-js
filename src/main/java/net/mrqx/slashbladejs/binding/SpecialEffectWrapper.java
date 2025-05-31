package net.mrqx.slashbladejs.binding;

import mods.flammpfeil.slashblade.registry.SpecialEffectsRegistry;
import mods.flammpfeil.slashblade.registry.specialeffects.SpecialEffect;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

public interface SpecialEffectWrapper {
    static boolean isEffective(ResourceLocation id, int level) {
        return SpecialEffectsRegistry.REGISTRY.get().getValue(id).getRequestLevel() <= level;
    }

    static Component getDescription(ResourceLocation id) {
        return SpecialEffectsRegistry.REGISTRY.get().getValue(id).getDescription();
    }

    static int getRequestLevel(ResourceLocation id) {
        return SpecialEffectsRegistry.REGISTRY.get().getValue(id).getRequestLevel();
    }

    static SpecialEffect getSpecialEffect(ResourceLocation id) {
        return SpecialEffectsRegistry.REGISTRY.get().getValue(id);
    }
}
