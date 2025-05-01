package net.mrqx.slashbladejs;

import dev.latvian.mods.kubejs.event.EventGroup;
import dev.latvian.mods.kubejs.event.EventHandler;
import dev.latvian.mods.kubejs.event.EventJS;
import dev.latvian.mods.kubejs.KubeJSPlugin;
import dev.latvian.mods.kubejs.recipe.schema.RegisterRecipeSchemasEvent;
import dev.latvian.mods.kubejs.script.BindingsEvent;
import mods.flammpfeil.slashblade.capability.slashblade.ISlashBladeState;
import mods.flammpfeil.slashblade.entity.BladeStandEntity;
import mods.flammpfeil.slashblade.event.SlashBladeEvent;
import mods.flammpfeil.slashblade.recipe.ProudsoulShapelessRecipe;
import mods.flammpfeil.slashblade.recipe.RequestDefinition;
import mods.flammpfeil.slashblade.recipe.SlashBladeShapedRecipe;
import mods.flammpfeil.slashblade.util.KnockBacks;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.mrqx.sbr_core.events.MrqxSlashBladeEvents;
import net.mrqx.slashbladejs.binding.BladeStateJS;
import net.mrqx.slashbladejs.binding.SlashBladeIngredientJS;
import net.mrqx.slashbladejs.recipe.ProudsoulShapelessRecipeSchema;
import net.mrqx.slashbladejs.recipe.SBJSRecipeSchemaType;
import net.mrqx.slashbladejs.recipe.SlashBladeShapedRecipeSchema;

public class SlashBladeJSPlugin extends KubeJSPlugin {
    public static EventGroup GROUP = EventGroup.of("SlashBladeJSEvents");

    public static EventHandler BLADE_CHANGE_SA = GROUP.server("bladeChangeSpecialAttack",
            () -> BladeChangeSpecialAttackEvent.class);
    public static EventHandler BLADE_CHANGE_SE = GROUP.server("bladeChangeSpecialEffect",
            () -> BladeChangeSpecialEffectEvent.class);

    public static EventHandler BLADE_COPY_SA = GROUP.server("copySpecialAttackFromBlade",
            () -> CopySpecialAttackFromBladeEvent.class);
    public static EventHandler BLADE_COPY_SE = GROUP.server("copySpecialEffectFromBlade",
            () -> CopySpecialEffectFromBladeEvent.class);

    public static EventHandler PRE_COPY_SA = GROUP.server("preCopySpecialAttackFromBlade",
            () -> PreCopySpecialAttackFromBladeEvent.class);
    public static EventHandler PRE_COPY_SE = GROUP.server("preCopySpecialEffectFromBlade",
            () -> PreCopySpecialEffectFromBladeEvent.class);

    public static EventHandler PROUD_SOUL_ENCHANT = GROUP.server("proudSoulEnchantment",
            () -> ProudSoulEnchantmentEvent.class);

    public static EventHandler REFINE_PROGRESS = GROUP.server("refineProgress",
            () -> RefineProgressEvent.class);
    public static EventHandler REFINE_SETTLEMENT = GROUP.server("refineSettlement",
            () -> RefineSettlementEvent.class);

    public static EventHandler POWER_BLADE = GROUP.server("powerBlade",
            () -> PowerBladeEvent.class);
    public static EventHandler UPDATE_ATTACK = GROUP.server("updateAttack",
            () -> UpdateAttackEvent.class);
    public static EventHandler BLADE_STAND_ATTACK = GROUP.server("bladeStandAttack",
            () -> BladeStandAttackEvent.class);
    public static EventHandler HIT = GROUP.server("hit",
            () -> HitEvent.class);
    public static EventHandler UPDATE = GROUP.server("update",
            () -> UpdateEvent.class);
    public static EventHandler DO_SLASH = GROUP.server("doSlash",
            () -> DoSlashEvent.class);

    @Override
    public void registerEvents() {
        GROUP.register();
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
        event.add("SlashBladeRequestDefinition", RequestDefinition.Builder.newInstance());
    }

    public static class SlashBladeEventJS extends EventJS {
        private SlashBladeEvent event;

        public SlashBladeEventJS(SlashBladeEvent event) {
            this.event = event;
        }

        public ItemStack getBlade() {
            return event.getBlade();
        }

        public ISlashBladeState getSlashBladeState() {
            return event.getSlashBladeState();
        }
    }

    public static class BladeChangeSpecialAttackEvent extends SlashBladeEventJS {
        private MrqxSlashBladeEvents.BladeChangeSpecialAttackEvent event;

        public BladeChangeSpecialAttackEvent(MrqxSlashBladeEvents.BladeChangeSpecialAttackEvent event) {
            super(event);
            this.event = event;
        }

        public ResourceLocation getSAKey() {
            return event.getSAKey();
        }

        public ResourceLocation setSAKey(ResourceLocation SAKey) {
            return event.setSAKey(SAKey);
        }

        public int getShrinkCount() {
            return event.getShrinkCount();
        }

        public int setShrinkCount(int shrinkCount) {
            return event.setShrinkCount(shrinkCount);
        }

        public SlashBladeEvent.BladeStandAttackEvent getOriginalEvent() {
            return event.getOriginalEvent();
        }
    }

    public static class BladeChangeSpecialEffectEvent extends SlashBladeEventJS {
        private MrqxSlashBladeEvents.BladeChangeSpecialEffectEvent event;

        public BladeChangeSpecialEffectEvent(MrqxSlashBladeEvents.BladeChangeSpecialEffectEvent event) {
            super(event);
            this.event = event;
        }

        public ResourceLocation getSEKey() {
            return event.getSEKey();
        }

        public ResourceLocation setSEKey(ResourceLocation SEKey) {
            return event.setSEKey(SEKey);
        }

        public int getShrinkCount() {
            return event.getShrinkCount();
        }

        public int setShrinkCount(int shrinkCount) {
            return event.setShrinkCount(shrinkCount);
        }

        public SlashBladeEvent.BladeStandAttackEvent getOriginalEvent() {
            return event.getOriginalEvent();
        }
    }

    public static class CopySpecialAttackFromBladeEvent extends SlashBladeEventJS {
        private MrqxSlashBladeEvents.CopySpecialAttackFromBladeEvent event;

        public CopySpecialAttackFromBladeEvent(MrqxSlashBladeEvents.CopySpecialAttackFromBladeEvent event) {
            super(event);
            this.event = event;
        }

        public ResourceLocation getSAKey() {
            return event.getSAKey();
        }

        public ItemStack getOrb() {
            return event.getOrb();
        }

        public ItemEntity getItemEntity() {
            return event.getItemEntity();
        }

        public SlashBladeEvent.BladeStandAttackEvent getOriginalEvent() {
            return event.getOriginalEvent();
        }
    }

    public static class CopySpecialEffectFromBladeEvent extends SlashBladeEventJS {
        private MrqxSlashBladeEvents.CopySpecialEffectFromBladeEvent event;

        public CopySpecialEffectFromBladeEvent(MrqxSlashBladeEvents.CopySpecialEffectFromBladeEvent event) {
            super(event);
            this.event = event;
        }

        public ResourceLocation getSEKey() {
            return event.getSEKey();
        }

        public ItemStack getOrb() {
            return event.getOrb();
        }

        public boolean isRemovable() {
            return event.isRemovable();
        }

        public boolean isCopiable() {
            return event.isCopiable();
        }

        public ItemEntity getItemEntity() {
            return event.getItemEntity();
        }

        public SlashBladeEvent.BladeStandAttackEvent getOriginalEvent() {
            return event.getOriginalEvent();
        }
    }

    public static class PreCopySpecialAttackFromBladeEvent extends SlashBladeEventJS {
        private MrqxSlashBladeEvents.PreCopySpecialAttackFromBladeEvent event;

        public PreCopySpecialAttackFromBladeEvent(MrqxSlashBladeEvents.PreCopySpecialAttackFromBladeEvent event) {
            super(event);
            this.event = event;
        }

        public ResourceLocation getSAKey() {
            return event.getSAKey();
        }

        public ResourceLocation setSAKey(ResourceLocation SAKey) {
            return event.setSAKey(SAKey);
        }

        public int getShrinkCount() {
            return event.getShrinkCount();
        }

        public int setShrinkCount(int shrinkCount) {
            return event.setShrinkCount(shrinkCount);
        }

        public SlashBladeEvent.BladeStandAttackEvent getOriginalEvent() {
            return event.getOriginalEvent();
        }
    }

    public static class PreCopySpecialEffectFromBladeEvent extends SlashBladeEventJS {
        private MrqxSlashBladeEvents.PreCopySpecialEffectFromBladeEvent event;

        public PreCopySpecialEffectFromBladeEvent(MrqxSlashBladeEvents.PreCopySpecialEffectFromBladeEvent event) {
            super(event);
            this.event = event;
        }

        public ResourceLocation getSEKey() {
            return event.getSEKey();
        }

        public ResourceLocation setSEKey(ResourceLocation SEKey) {
            return event.setSEKey(SEKey);
        }

        public int getShrinkCount() {
            return event.getShrinkCount();
        }

        public int setShrinkCount(int shrinkCount) {
            return event.setShrinkCount(shrinkCount);
        }

        public boolean isRemovable() {
            return event.isRemovable();
        }

        public boolean setRemovable(boolean isRemovable) {
            return event.setRemovable(isRemovable);
        }

        public boolean isCopiable() {
            return event.isCopiable();
        }

        public boolean setCopiable(boolean isCopiable) {
            return event.setCopiable(isCopiable);
        }

        public SlashBladeEvent.BladeStandAttackEvent getOriginalEvent() {
            return event.getOriginalEvent();
        }
    }

    public static class ProudSoulEnchantmentEvent extends SlashBladeEventJS {
        private MrqxSlashBladeEvents.ProudSoulEnchantmentEvent event;

        public ProudSoulEnchantmentEvent(MrqxSlashBladeEvents.ProudSoulEnchantmentEvent event) {
            super(event);
            this.event = event;
        }

        public Enchantment getEnchantment() {
            return event.getEnchantment();
        }

        public Enchantment setEnchantment(Enchantment enchantment) {
            return event.setEnchantment(enchantment);
        }

        public int getEnchantLevel() {
            return event.getEnchantLevel();
        }

        public int setEnchantLevel(int enchantLevel) {
            return event.setEnchantLevel(enchantLevel);
        }

        public boolean willTryNextEnchant() {
            return event.willTryNextEnchant();
        }

        public boolean setWillTryNextEnchant(boolean tryNextEnchant) {
            return event.setWillTryNextEnchant(tryNextEnchant);
        }

        public int getTotalShrinkCount() {
            return event.getTotalShrinkCount();
        }

        public int setTotalShrinkCount(int totalShrinkCount) {
            return event.setTotalShrinkCount(totalShrinkCount);
        }

        public float getProbability() {
            return event.getProbability();
        }

        public float setProbability(float probability) {
            return event.setProbability(probability);
        }

        public SlashBladeEvent.BladeStandAttackEvent getOriginalEvent() {
            return event.getOriginalEvent();
        }
    }

    public static class RefineProgressEvent extends SlashBladeEventJS {
        private MrqxSlashBladeEvents.RefineProgressEvent event;

        public RefineProgressEvent(MrqxSlashBladeEvents.RefineProgressEvent event) {
            super(event);
            this.event = event;
        }

        public int getMaterialCost() {
            return event.getMaterialCost();
        }

        public int setMaterialCost(int materialCost) {
            return event.setMaterialCost(materialCost);
        }

        public int getLevelCost() {
            return event.getLevelCost();
        }

        public int setLevelCost(int levelCost) {
            return event.setLevelCost(levelCost);
        }

        public int getCostResult() {
            return event.getCostResult();
        }

        public int getRefineResult() {
            return event.getRefineResult();
        }

        public int setRefineResult(int refineResult) {
            return event.setRefineResult(refineResult);
        }

        public AnvilUpdateEvent getOriginalEvent() {
            return event.getOriginalEvent();
        }
    }

    public static class RefineSettlementEvent extends SlashBladeEventJS {
        private MrqxSlashBladeEvents.RefineSettlementEvent event;

        public RefineSettlementEvent(MrqxSlashBladeEvents.RefineSettlementEvent event) {
            super(event);
            this.event = event;
        }

        public int getMaterialCost() {
            return event.getMaterialCost();
        }

        public int setMaterialCost(int materialCost) {
            return event.setMaterialCost(materialCost);
        }

        public int getCostResult() {
            return event.getCostResult();
        }

        public int setCostResult(int costResult) {
            return event.setCostResult(costResult);
        }

        public int getRefineResult() {
            return event.getRefineResult();
        }

        public int setRefineResult(int refineResult) {
            return event.setRefineResult(refineResult);
        }

        public AnvilUpdateEvent getOriginalEvent() {
            return event.getOriginalEvent();
        }
    }

    public static class PowerBladeEvent extends SlashBladeEventJS {
        private SlashBladeEvent.PowerBladeEvent event;

        public PowerBladeEvent(SlashBladeEvent.PowerBladeEvent event) {
            super(event);
            this.event = event;
        }

        public boolean isPowered() {
            return event.isPowered();
        }

        public void setPowered(boolean isPowered) {
            event.setPowered(isPowered);
        }

        public LivingEntity getUser() {
            return event.getUser();
        }

    }

    public static class UpdateAttackEvent extends SlashBladeEventJS {
        private SlashBladeEvent.UpdateAttackEvent event;

        public UpdateAttackEvent(SlashBladeEvent.UpdateAttackEvent event) {
            super(event);
            this.event = event;
        }

        public double getNewDamage() {
            return event.getNewDamage();
        }

        public void setNewDamage(double newDamage) {
            event.setNewDamage(newDamage);
        }

        public double getOriginDamage() {
            return event.getOriginDamage();
        }
    }

    public static class BladeStandAttackEvent extends SlashBladeEventJS {
        private SlashBladeEvent.BladeStandAttackEvent event;

        public BladeStandAttackEvent(SlashBladeEvent.BladeStandAttackEvent event) {
            super(event);
            this.event = event;
        }

        public BladeStandEntity getBladeStand() {
            return event.getBladeStand();
        }

        public DamageSource getDamageSource() {
            return event.getDamageSource();
        }

    }

    public static class HitEvent extends SlashBladeEventJS {
        private SlashBladeEvent.HitEvent event;

        public HitEvent(SlashBladeEvent.HitEvent event) {
            super(event);
            this.event = event;
        }

        public LivingEntity getUser() {
            return event.getUser();
        }

        public LivingEntity getTarget() {
            return event.getTarget();
        }

    }

    public static class UpdateEvent extends SlashBladeEventJS {
        private SlashBladeEvent.UpdateEvent event;

        public UpdateEvent(SlashBladeEvent.UpdateEvent event) {
            super(event);
            this.event = event;
        }

        public Level getLevel() {
            return event.getLevel();
        }

        public Entity getEntity() {
            return event.getEntity();
        }

        public int getItemSlot() {
            return event.getItemSlot();
        }

        public boolean isSelected() {
            return event.isSelected();
        }

    }

    public static class DoSlashEvent extends SlashBladeEventJS {
        private SlashBladeEvent.DoSlashEvent event;

        public DoSlashEvent(SlashBladeEvent.DoSlashEvent event) {
            super(event);
            this.event = event;
        }

        public LivingEntity getUser() {
            return event.getUser();
        }

        public float getRoll() {
            return event.getRoll();
        }

        public void setRoll(float roll) {
            event.setRoll(roll);
        }

        public boolean isCritical() {
            return event.isCritical();
        }

        public void setCritical(boolean critical) {
            event.setCritical(critical);
        }

        public double getDamage() {
            return event.getDamage();
        }

        public void setDamage(double damage) {
            event.setDamage(damage);
        }

        public KnockBacks getKnockback() {
            return event.getKnockback();
        }

        public void setKnockback(KnockBacks knockback) {
            event.setKnockback(knockback);
        }

    }
}