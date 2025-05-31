package net.mrqx.slashbladejs.recipe;

import dev.latvian.mods.kubejs.recipe.RecipeTypeFunction;
import dev.latvian.mods.kubejs.recipe.schema.RecipeSchema;
import dev.latvian.mods.kubejs.recipe.schema.minecraft.ShapelessRecipeSchema;

public interface ProudsoulShapelessRecipeSchema extends ShapelessRecipeSchema {
    class SlashBladeShapedRecipeJS extends ShapelessRecipeSchema.ShapelessRecipeJS {
        @Override
        public RecipeTypeFunction getSerializationTypeFunction() {
            return type;
        }
    }

    RecipeSchema SCHEMA = new RecipeSchema(ShapelessRecipeJS.class, ShapelessRecipeJS::new, RESULT, INGREDIENTS)
            .uniqueOutputId(RESULT);
}
