package net.mrqx.slashbladejs.registry;

import dev.latvian.mods.kubejs.registry.BuilderBase;
import dev.latvian.mods.kubejs.registry.RegistryInfo;
import mods.flammpfeil.slashblade.registry.specialeffects.SpecialEffect;
import net.minecraft.resources.ResourceLocation;
import net.mrqx.slashbladejs.SlashBladeJSPlugin;

public class CustomSpecialEffect extends SpecialEffect {
    public CustomSpecialEffect(SpecialEffectBuilder builder) {
        super(builder.requestLevel, builder.isCopiable, builder.isRemovable);
    }

    public static class SpecialEffectBuilder extends BuilderBase<CustomSpecialEffect> {
        private int requestLevel;
        private boolean isCopiable;
        private boolean isRemovable;

        public SpecialEffectBuilder(ResourceLocation i) {
            super(i);
        }

        public SpecialEffectBuilder setRequestLevel(int requestLevel) {
            this.requestLevel = requestLevel;
            return this;
        }

        public SpecialEffectBuilder setCopiable(boolean isCopiable) {
            this.isCopiable = isCopiable;
            return this;
        }

        public SpecialEffectBuilder setRemovable(boolean isRemovable) {
            this.isRemovable = isRemovable;
            return this;
        }

        @Override
        public RegistryInfo<SpecialEffect> getRegistryType() {
            return SlashBladeJSPlugin.SPECIAL_EFFECT_REGISTRY;
        }

        @Override
        public CustomSpecialEffect createObject() {
            return new CustomSpecialEffect(this);
        }
    }
}
