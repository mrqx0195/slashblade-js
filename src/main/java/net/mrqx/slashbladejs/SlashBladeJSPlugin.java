package net.mrqx.slashbladejs;

import dev.latvian.mods.kubejs.KubeJSPlugin;
import dev.latvian.mods.kubejs.recipe.schema.RegisterRecipeSchemasEvent;
import dev.latvian.mods.kubejs.script.BindingsEvent;
import java.util.Collections;
import mods.flammpfeil.slashblade.recipe.ProudsoulShapelessRecipe;
import mods.flammpfeil.slashblade.recipe.RequestDefinition;
import mods.flammpfeil.slashblade.recipe.SlashBladeShapedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.mrqx.slashbladejs.binding.BladeStateJS;
import net.mrqx.slashbladejs.binding.SBJSDefinitions;
import net.mrqx.slashbladejs.binding.SBJSDefinitions.SBEnums;
import net.mrqx.slashbladejs.binding.SlashBladeIngredientJS;
import net.mrqx.slashbladejs.event.SlashBladeEventGroup;
import net.mrqx.slashbladejs.recipe.ProudsoulShapelessRecipeSchema;
import net.mrqx.slashbladejs.recipe.SBJSRecipeSchemaType;
import net.mrqx.slashbladejs.recipe.SlashBladeShapedRecipeSchema;

public class SlashBladeJSPlugin extends KubeJSPlugin {

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

        event.add("SBSlashBladeDefinition", new SBJSDefinitions.SBSlashBladeDefinition());
        event.add("SBEnchantmentDefinition", new SBJSDefinitions.SBEnchantmentDefinition());
        event.add("SBPropertiesDefinition", new SBJSDefinitions.SBPropertiesDefinition());
        event.add("SBRenderDefinition", new SBJSDefinitions.SBRenderDefinition());

        SBEnums enums = new SBJSDefinitions.SBEnums();
        event.add("SBCarryType", Collections.unmodifiableMap(enums.SBCarryType()));
        event.add("SBSwordType", Collections.unmodifiableMap(enums.SBSwordType()));

        event.add("SlashBladeRequestDefinition", RequestDefinition.Builder.newInstance());
    }
}