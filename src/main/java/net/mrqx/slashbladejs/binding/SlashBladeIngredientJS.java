package net.mrqx.slashbladejs.binding;

import mods.flammpfeil.slashblade.recipe.RequestDefinition;
import mods.flammpfeil.slashblade.recipe.SlashBladeIngredient;
import net.minecraft.world.level.ItemLike;

public class SlashBladeIngredientJS {
    public SlashBladeIngredient of(ItemLike item, RequestDefinition request) {
        return SlashBladeIngredient.of(item, request);
    }

    public SlashBladeIngredient of(RequestDefinition request) {
        return SlashBladeIngredient.of(request);
    }
}