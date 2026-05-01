package net.mrqx.slashbladejs.event;

import dev.latvian.mods.kubejs.event.EventJS;
import mods.flammpfeil.slashblade.capability.slashblade.ISlashBladeState;
import mods.flammpfeil.slashblade.compat.playerAnim.VmdAnimation;
import mods.flammpfeil.slashblade.entity.BladeStandEntity;
import mods.flammpfeil.slashblade.entity.EntityAbstractSummonedSword;
import mods.flammpfeil.slashblade.event.RefineProgressEvent;
import mods.flammpfeil.slashblade.event.RefineSettlementEvent;
import mods.flammpfeil.slashblade.event.SlashBladeEvent;
import mods.flammpfeil.slashblade.event.bladestand.*;
import mods.flammpfeil.slashblade.registry.combo.ComboState;
import mods.flammpfeil.slashblade.slasharts.SlashArts;
import mods.flammpfeil.slashblade.util.KnockBacks;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.mrqx.sbr_core.events.SlashBladePlayerAnimationRegistryEvent;

import java.util.Map;

@SuppressWarnings({"unused", "AlibabaLowerCamelCaseVariableNaming", "AlibabaClassNamingShouldBeCamel"})
public class SlashBladeEventJS extends EventJS {
    private final SlashBladeEvent event;
    
    public SlashBladeEventJS(SlashBladeEvent event) {
        this.event = event;
    }
    
    public ItemStack getBlade() {
        return event.getBlade();
    }
    
    public ISlashBladeState getSlashBladeState() {
        return event.getSlashBladeState();
    }
    
    public static class BladeChangeSpecialAttackJSEvent extends SlashBladeEventJS {
        private final BladeChangeSpecialAttackEvent event;
        
        public BladeChangeSpecialAttackJSEvent(BladeChangeSpecialAttackEvent event) {
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
    
    public static class BladeChangeSpecialEffectJSEvent extends SlashBladeEventJS {
        private final BladeChangeSpecialEffectEvent event;
        
        public BladeChangeSpecialEffectJSEvent(BladeChangeSpecialEffectEvent event) {
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
    
    public static class CopySpecialAttackFromBladeJSEvent extends SlashBladeEventJS {
        private final CopySpecialAttackFromBladeEvent event;
        
        public CopySpecialAttackFromBladeJSEvent(CopySpecialAttackFromBladeEvent event) {
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
    
    public static class CopySpecialEffectFromBladeJSEvent extends SlashBladeEventJS {
        private final CopySpecialEffectFromBladeEvent event;
        
        public CopySpecialEffectFromBladeJSEvent(CopySpecialEffectFromBladeEvent event) {
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
    
    public static class PreCopySpecialAttackFromBladeJSEvent extends SlashBladeEventJS {
        private final PreCopySpecialAttackFromBladeEvent event;
        
        public PreCopySpecialAttackFromBladeJSEvent(PreCopySpecialAttackFromBladeEvent event) {
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
    
    public static class PreCopySpecialEffectFromBladeJSEvent extends SlashBladeEventJS {
        private final PreCopySpecialEffectFromBladeEvent event;
        
        public PreCopySpecialEffectFromBladeJSEvent(PreCopySpecialEffectFromBladeEvent event) {
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
    
    public static class ProudSoulEnchantmentJSEvent extends SlashBladeEventJS {
        private final ProudSoulEnchantmentEvent event;
        
        public ProudSoulEnchantmentJSEvent(ProudSoulEnchantmentEvent event) {
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
    
    public static class RefineProgressJSEvent extends SlashBladeEventJS {
        private final RefineProgressEvent event;
        
        public RefineProgressJSEvent(RefineProgressEvent event) {
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
    
    public static class RefineSettlementJSEvent extends SlashBladeEventJS {
        private final RefineSettlementEvent event;
        
        public RefineSettlementJSEvent(RefineSettlementEvent event) {
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
    
    public static class ComboStateRegistryEvent extends EventJS {
        private final net.mrqx.sbr_core.events.ComboStateRegistryEvent event;
        
        public ComboStateRegistryEvent(net.mrqx.sbr_core.events.ComboStateRegistryEvent event) {
            this.event = event;
        }
        
        public ComboState.Builder getBuilder() {
            return event.getBuilder();
        }
        
        public ComboState getCombo() {
            return event.getCombo();
        }
    }
    
    public static class PlayerAnimationRegistryEvent extends EventJS {
        private final SlashBladePlayerAnimationRegistryEvent event;
        
        public PlayerAnimationRegistryEvent(SlashBladePlayerAnimationRegistryEvent event) {
            this.event = event;
        }
        
        public Map<ResourceLocation, VmdAnimation> getAnimation() {
            return event.getAnimation();
        }
    }
    
    public static class PowerBladeEvent extends SlashBladeEventJS {
        private final SlashBladeEvent.PowerBladeEvent event;
        
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
        private final SlashBladeEvent.UpdateAttackEvent event;
        
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
        private final SlashBladeEvent.BladeStandAttackEvent event;
        
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
        private final SlashBladeEvent.HitEvent event;
        
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
        private final SlashBladeEvent.UpdateEvent event;
        
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
        private final SlashBladeEvent.DoSlashEvent event;
        
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
        
        public float getYRot() {
            return event.getYRot();
        }
        
        public void setYRot(float yRot) {
            event.setYRot(yRot);
        }
    }
    
    public static class AddKillCountEvent extends SlashBladeEventJS {
        private final SlashBladeEvent.AddKillCountEvent event;
        
        public AddKillCountEvent(SlashBladeEvent.AddKillCountEvent event) {
            super(event);
            this.event = event;
        }
        
        public int getOriginCount() {
            return event.getOriginCount();
        }
        
        public int getNewCount() {
            return event.getNewCount();
        }
        
        public void setNewCount(int newCount) {
            event.setNewCount(newCount);
        }
    }
    
    public static class AddProudSoulEvent extends SlashBladeEventJS {
        private final SlashBladeEvent.AddProudSoulEvent event;
        
        public AddProudSoulEvent(SlashBladeEvent.AddProudSoulEvent event) {
            super(event);
            this.event = event;
        }
        
        public int getOriginCount() {
            return event.getOriginCount();
        }
        
        public int getNewCount() {
            return event.getNewCount();
        }
        
        public void setNewCount(int newCount) {
            event.setNewCount(newCount);
        }
    }
    
    public static class BladeStandTickEvent extends SlashBladeEventJS {
        private final SlashBladeEvent.BladeStandTickEvent event;
        
        public BladeStandTickEvent(SlashBladeEvent.BladeStandTickEvent event) {
            super(event);
            this.event = event;
        }
        
        public BladeStandEntity getBladeStand() {
            return event.getBladeStand();
        }
    }
    
    @SuppressWarnings("FieldCanBeLocal")
    public static class BreakEvent extends SlashBladeEventJS {
        private final SlashBladeEvent.BreakEvent event;
        
        public BreakEvent(SlashBladeEvent.BreakEvent event) {
            super(event);
            this.event = event;
        }
    }
    
    public static class NextComboEvent extends SlashBladeEventJS {
        private final SlashBladeEvent.NextComboEvent event;
        
        public NextComboEvent(SlashBladeEvent.NextComboEvent event) {
            super(event);
            this.event = event;
        }
        
        public LivingEntity getUser() {
            return event.getUser();
        }
        
        public ResourceLocation getNextCombo() {
            return event.getNextCombo();
        }
        
        public void setNextCombo(ResourceLocation nextCombo) {
            event.setNextCombo(nextCombo);
        }
    }
    
    public static class NextOfTimeOutComboEvent extends SlashBladeEventJS {
        private final SlashBladeEvent.NextOfTimeOutComboEvent event;
        
        public NextOfTimeOutComboEvent(SlashBladeEvent.NextOfTimeOutComboEvent event) {
            super(event);
            this.event = event;
        }
        
        public LivingEntity getUser() {
            return event.getUser();
        }
        
        public ResourceLocation getNextCombo() {
            return event.getNextCombo();
        }
        
        public void setNextCombo(ResourceLocation nextCombo) {
            event.setNextCombo(nextCombo);
        }
    }
    
    public static class ChargeActionEvent extends EventJS {
        private final SlashBladeEvent.ChargeActionEvent event;
        
        public ChargeActionEvent(SlashBladeEvent.ChargeActionEvent event) {
            this.event = event;
        }
        
        public LivingEntity getEntityLiving() {
            return event.getEntityLiving();
        }
        
        public int getChargeTicks() {
            return event.getChargeTicks();
        }
        
        public ISlashBladeState getSlashBladeState() {
            return event.getSlashBladeState();
        }
    }
    
    public static class PerformSlashArtEvent extends EventJS {
        private final SlashBladeEvent.PerformSlashArtEvent event;
        
        public PerformSlashArtEvent(SlashBladeEvent.PerformSlashArtEvent event) {
            this.event = event;
        }
        
        public LivingEntity getEntityLiving() {
            return event.getEntityLiving();
        }
        
        public int getElapsed() {
            return event.getElapsed();
        }
        
        public ISlashBladeState getSlashBladeState() {
            return event.getSlashBladeState();
        }
        
        public ResourceLocation getComboState() {
            return event.getComboState();
        }
        
        public void setComboState(ResourceLocation comboState) {
            event.setComboState(comboState);
        }
        
        public SlashArts.ArtsType getType() {
            return event.getType();
        }
    }
    
    public static class SummonedSwordOnHitEntityEvent extends EventJS {
        private final SlashBladeEvent.SummonedSwordOnHitEntityEvent event;
        
        public SummonedSwordOnHitEntityEvent(SlashBladeEvent.SummonedSwordOnHitEntityEvent event) {
            this.event = event;
        }
        
        public EntityAbstractSummonedSword getSummonedSword() {
            return event.getSummonedSword();
        }
        
        public Entity getTarget() {
            return event.getTarget();
        }
    }
}
