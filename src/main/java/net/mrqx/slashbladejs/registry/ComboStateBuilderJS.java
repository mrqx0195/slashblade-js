package net.mrqx.slashbladejs.registry;

import dev.latvian.mods.kubejs.registry.BuilderBase;
import dev.latvian.mods.kubejs.registry.RegistryInfo;
import mods.flammpfeil.slashblade.registry.combo.ComboState;
import mods.flammpfeil.slashblade.slasharts.SlashArts;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.mrqx.slashbladejs.SlashBladeJSPlugin;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public class ComboStateBuilderJS extends BuilderBase<ComboState> {
    private final ComboState.Builder builder = ComboState.Builder.newInstance();

    public ComboStateBuilderJS(ResourceLocation i) {
        super(i);
    }

    public ComboStateBuilderJS startAndEnd(int start, int end) {
        builder.startAndEnd(start, end);
        return this;
    }

    public ComboStateBuilderJS priority(int priority) {
        builder.priority(priority);
        return this;
    }

    public ComboStateBuilderJS speed(float speed) {
        builder.speed(speed);
        return this;
    }

    public ComboStateBuilderJS loop() {
        builder.loop();
        return this;
    }

    public ComboStateBuilderJS aerial() {
        builder.aerial();
        return this;
    }

    public ComboStateBuilderJS timeout(int timeout) {
        builder.timeout(timeout);
        return this;
    }

    public ComboStateBuilderJS motionLoc(ResourceLocation motionLoc) {
        builder.motionLoc(motionLoc);
        return this;
    }

    public ComboStateBuilderJS next(Function<LivingEntity, ResourceLocation> next) {
        builder.next(next);
        return this;
    }

    public ComboStateBuilderJS nextOfTimeout(Function<LivingEntity, ResourceLocation> nextOfTimeout) {
        builder.nextOfTimeout(nextOfTimeout);
        return this;
    }

    public ComboStateBuilderJS addHoldAction(Consumer<LivingEntity> holdAction) {
        builder.addHoldAction(holdAction);
        return this;
    }

    public ComboStateBuilderJS addTickAction(Consumer<LivingEntity> tickAction) {
        builder.addTickAction(tickAction);
        return this;
    }

    public ComboStateBuilderJS addHitEffect(BiConsumer<LivingEntity, LivingEntity> hitEffect) {
        builder.addHitEffect(hitEffect);
        return this;
    }

    public ComboStateBuilderJS clickAction(Consumer<LivingEntity> clickAction) {
        builder.clickAction(clickAction);
        return this;
    }

    public ComboStateBuilderJS releaseAction(BiFunction<LivingEntity, Integer, SlashArts.ArtsType> clickAction) {
        builder.releaseAction(clickAction);
        return this;
    }

    @Override
    public RegistryInfo<ComboState> getRegistryType() {
        return SlashBladeJSPlugin.COMBO_STATE_REGISTRY;
    }

    @Override
    public ComboState createObject() {
        return builder.build();
    }
}
