package net.mrqx.slashbladejs.registry;

import dev.latvian.mods.kubejs.registry.BuilderBase;
import dev.latvian.mods.kubejs.registry.RegistryInfo;
import mods.flammpfeil.slashblade.slasharts.SlashArts;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.mrqx.slashbladejs.SlashBladeJSPlugin;

import java.util.function.Function;

public class SlashArtBuilder extends BuilderBase<SlashArts> {
    private Function<LivingEntity, ResourceLocation> comboState;
    private Function<LivingEntity, ResourceLocation> comboStateJust;
    private Function<LivingEntity, ResourceLocation> comboStateSuper;
    private int costSoul;

    public SlashArtBuilder(ResourceLocation i) {
        super(i);
        comboState = null;
        comboStateJust = null;
        comboStateSuper = null;
        costSoul = 20;
    }

    public SlashArtBuilder setComboStateBase(Function<LivingEntity, ResourceLocation> comboState) {
        this.comboState = comboState;
        return this;
    }

    public SlashArtBuilder setComboStateJust(Function<LivingEntity, ResourceLocation> comboStateJust) {
        this.comboStateJust = comboStateJust;
        return this;
    }

    public SlashArtBuilder setComboStateSuper(Function<LivingEntity, ResourceLocation> comboStateSuper) {
        this.comboStateSuper = comboStateSuper;
        return this;
    }

    public SlashArtBuilder setSoulCost(int costSoul) {
        this.costSoul = costSoul;
        return this;
    }

    @Override
    public RegistryInfo<SlashArts> getRegistryType() {
        return SlashBladeJSPlugin.SLASH_ART_REGISTRY;
    }

    @Override
    public SlashArts createObject() {
        SlashArts slashArt = new SlashArts(this.comboState);
        if (this.comboStateJust != null) {
            slashArt.setComboStateJust(this.comboStateJust);
        }
        if (this.comboStateSuper != null) {
            slashArt.setComboStateSuper(this.comboStateSuper);
        }
        slashArt.setProudSoulCost(this.costSoul);
        return slashArt;
    }

}
