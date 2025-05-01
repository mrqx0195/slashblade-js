package net.mrqx.slashbladejs.recipe;

import dev.latvian.mods.kubejs.item.OutputItem;
import dev.latvian.mods.kubejs.recipe.component.ItemComponents;
import dev.latvian.mods.kubejs.recipe.component.StringComponent;
import dev.latvian.mods.kubejs.recipe.RecipeKey;
import dev.latvian.mods.kubejs.recipe.RecipeTypeFunction;
import dev.latvian.mods.kubejs.recipe.schema.minecraft.ShapedRecipeSchema;
import dev.latvian.mods.kubejs.recipe.schema.RecipeSchema;

public interface SlashBladeShapedRecipeSchema extends ShapedRecipeSchema {
    class SlashBladeShapedRecipeJS extends ShapedRecipeSchema.ShapedRecipeJS {
        @Override
        public RecipeTypeFunction getSerializationTypeFunction() {
            return type;
        }
    }

    RecipeKey<String> OUTPUT_BLADE = StringComponent.NON_EMPTY.key("blade");
    RecipeKey<OutputItem> RESULT = ItemComponents.OUTPUT.key("result");

    RecipeSchema SCHEMA = new RecipeSchema(SlashBladeShapedRecipeJS.class, SlashBladeShapedRecipeJS::new, RESULT,
            PATTERN, KEY, OUTPUT_BLADE)
            .constructor(RESULT, PATTERN, KEY, OUTPUT_BLADE)
            .uniqueOutputId(RESULT);
}