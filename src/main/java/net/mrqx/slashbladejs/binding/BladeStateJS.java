package net.mrqx.slashbladejs.binding;

import mods.flammpfeil.slashblade.capability.slashblade.ISlashBladeState;
import mods.flammpfeil.slashblade.capability.slashblade.SlashBladeState;
import mods.flammpfeil.slashblade.item.ItemSlashBlade;
import net.minecraft.world.item.ItemStack;

public class BladeStateJS {
    public ISlashBladeState of(ItemStack itemStack) {
        return itemStack.getCapability(ItemSlashBlade.BLADESTATE).orElse(new SlashBladeState(itemStack));
    }
}