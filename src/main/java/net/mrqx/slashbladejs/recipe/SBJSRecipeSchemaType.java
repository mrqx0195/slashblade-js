package net.mrqx.slashbladejs.recipe;

import dev.latvian.mods.kubejs.recipe.schema.RecipeNamespace;
import dev.latvian.mods.kubejs.recipe.schema.RecipeSchema;
import dev.latvian.mods.kubejs.recipe.schema.RecipeSchemaType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeSerializer;

import java.util.Optional;

public class SBJSRecipeSchemaType extends RecipeSchemaType {

    public SBJSRecipeSchemaType(RecipeNamespace namespace, ResourceLocation id, RecipeSchema schema,
                                RecipeSerializer<?> serializer) {
        super(namespace, id, schema);
        this.serializer = Optional.of(serializer);
    }
}
