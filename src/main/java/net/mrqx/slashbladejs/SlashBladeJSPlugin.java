package net.mrqx.slashbladejs;

import dev.latvian.mods.kubejs.KubeJSPlugin;
import dev.latvian.mods.kubejs.recipe.schema.RegisterRecipeSchemasEvent;
import dev.latvian.mods.kubejs.registry.RegistryInfo;
import dev.latvian.mods.kubejs.script.BindingsEvent;
import mods.flammpfeil.slashblade.ability.StunManager;
import mods.flammpfeil.slashblade.ability.Untouchable;
import mods.flammpfeil.slashblade.compat.playerAnim.VmdAnimation;
import mods.flammpfeil.slashblade.event.client.UserPoseOverrider;
import mods.flammpfeil.slashblade.recipe.ProudsoulShapelessRecipe;
import mods.flammpfeil.slashblade.recipe.RequestDefinition;
import mods.flammpfeil.slashblade.recipe.SlashBladeShapedRecipe;
import mods.flammpfeil.slashblade.registry.combo.ComboState;
import mods.flammpfeil.slashblade.registry.specialeffects.SpecialEffect;
import mods.flammpfeil.slashblade.slasharts.SlashArts;
import mods.flammpfeil.slashblade.util.AdvancementHelper;
import mods.flammpfeil.slashblade.util.AttackManager;
import mods.flammpfeil.slashblade.util.TargetSelector;
import net.minecraft.resources.ResourceLocation;
import net.mrqx.sbr_core.utils.InputStream;
import net.mrqx.sbr_core.utils.MrqxSlayerStyleArts;
import net.mrqx.sbr_core.utils.MrqxSummonedSwordArts;
import net.mrqx.slashbladejs.binding.BladeStateJS;
import net.mrqx.slashbladejs.binding.SBJSDefinitions;
import net.mrqx.slashbladejs.binding.SBJSDefinitions.SBEnums;
import net.mrqx.slashbladejs.binding.SlashBladeIngredientJS;
import net.mrqx.slashbladejs.binding.SpecialEffectWrapper;
import net.mrqx.slashbladejs.event.SlashBladeEventGroup;
import net.mrqx.slashbladejs.recipe.ProudsoulShapelessRecipeSchema;
import net.mrqx.slashbladejs.recipe.SBJSRecipeSchemaType;
import net.mrqx.slashbladejs.recipe.SlashBladeShapedRecipeSchema;
import net.mrqx.slashbladejs.registry.ComboStateBuilderJS;
import net.mrqx.slashbladejs.registry.CustomSpecialEffect;
import net.mrqx.slashbladejs.registry.SlashArtBuilder;
import org.apache.logging.log4j.util.LoaderUtil;

import java.util.Collections;

public class SlashBladeJSPlugin extends KubeJSPlugin {
    public static final RegistryInfo<ComboState> COMBO_STATE_REGISTRY = RegistryInfo.of(ComboState.REGISTRY_KEY, ComboState.class);
    public static final RegistryInfo<SpecialEffect> SPECIAL_EFFECT_REGISTRY = RegistryInfo.of(SpecialEffect.REGISTRY_KEY, SpecialEffect.class);
    public static final RegistryInfo<SlashArts> SLASH_ART_REGISTRY = RegistryInfo.of(SlashArts.REGISTRY_KEY, SlashArts.class);

    @Override
    public void init() {
        COMBO_STATE_REGISTRY.addType("basic", ComboStateBuilderJS.class, ComboStateBuilderJS::new);
        SPECIAL_EFFECT_REGISTRY.addType("basic", CustomSpecialEffect.SpecialEffectBuilder.class, CustomSpecialEffect.SpecialEffectBuilder::new);
        SLASH_ART_REGISTRY.addType("basic", SlashArtBuilder.class, SlashArtBuilder::new);
    }

    @Override
    public void registerEvents() {
        SlashBladeEventGroup.GROUP.register();
    }

    @Override
    public void registerRecipeSchemas(RegisterRecipeSchemasEvent event) {
        event.namespace("slashblade").put("slashblade_shaped_recipe",
                new SBJSRecipeSchemaType(event.namespace("slashblade"),
                        new ResourceLocation(SlashBladeJS.MODID, "slashblade_shaped_recipe"),
                        SlashBladeShapedRecipeSchema.SCHEMA, SlashBladeShapedRecipe.SERIALIZER));
        event.namespace("slashblade").put("proudsoul_shapeless_recipe",
                new SBJSRecipeSchemaType(event.namespace("slashblade"),
                        new ResourceLocation(SlashBladeJS.MODID, "proudsoul_shapeless_recipe"),
                        ProudsoulShapelessRecipeSchema.SCHEMA, ProudsoulShapelessRecipe.SERIALIZER));
    }

    @Override
    public void registerBindings(BindingsEvent event) {
        event.add("SlashBladeIngredient", new SlashBladeIngredientJS());
        event.add("BladeState", new BladeStateJS());

        event.add("SBSlashBladeDefinition", SBJSDefinitions.SBSlashBladeDefinition.class);
        event.add("SBEnchantmentDefinition", SBJSDefinitions.SBEnchantmentDefinition.class);
        event.add("SBPropertiesDefinition", SBJSDefinitions.SBPropertiesDefinition.class);
        event.add("SBRenderDefinition", SBJSDefinitions.SBRenderDefinition.class);

        SBEnums enums = new SBJSDefinitions.SBEnums();
        event.add("SBCarryType", Collections.unmodifiableMap(enums.SBCarryType()));
        event.add("SBSwordType", Collections.unmodifiableMap(enums.SBSwordType()));

        event.add("SlashBladeRequestDefinition", RequestDefinition.Builder.newInstance());

        if (LoaderUtil.isClassAvailable("dev.kosmx.playerAnim.api.layered.AnimationStack")) {
            event.add("SBVmdAnimation", VmdAnimation.class);
        }
        event.add("SBUserPoseOverrider", UserPoseOverrider.class);

        event.add("SBAdvancementHelper", AdvancementHelper.class);
        event.add("SBAttackManager", AttackManager.class);
        event.add("SBTargetSelector", TargetSelector.class);
        event.add("SBStunManager", StunManager.class);
        event.add("SBUntouchable", Untouchable.class);

        event.add("SBInputStream", InputStream.class);
        event.add("SBSlayerStyleArts", MrqxSlayerStyleArts.class);
        event.add("SBSummonedSwordArts", MrqxSummonedSwordArts.class);

        event.add("SBSpecialEffect", SpecialEffectWrapper.class);
    }
}
