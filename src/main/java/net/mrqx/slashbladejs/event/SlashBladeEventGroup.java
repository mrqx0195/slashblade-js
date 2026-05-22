package net.mrqx.slashbladejs.event;

import dev.latvian.mods.kubejs.event.EventGroup;
import dev.latvian.mods.kubejs.event.EventHandler;

public class SlashBladeEventGroup {
    public static final EventGroup GROUP = EventGroup.of("SlashBladeJSEvents");
    
    public static final EventHandler BLADE_CHANGE_SA = GROUP.server("bladeChangeSpecialAttack",
        () -> SlashBladeEventJS.BladeChangeSpecialAttackJSEvent.class).hasResult();
    public static final EventHandler BLADE_CHANGE_SE = GROUP.server("bladeChangeSpecialEffect",
        () -> SlashBladeEventJS.BladeChangeSpecialEffectJSEvent.class).hasResult();
    
    public static final EventHandler BLADE_COPY_SA = GROUP.server("copySpecialAttackFromBlade",
        () -> SlashBladeEventJS.CopySpecialAttackFromBladeJSEvent.class);
    public static final EventHandler BLADE_COPY_SE = GROUP.server("copySpecialEffectFromBlade",
        () -> SlashBladeEventJS.CopySpecialEffectFromBladeJSEvent.class);
    
    public static final EventHandler PRE_COPY_SA = GROUP.server("preCopySpecialAttackFromBlade",
        () -> SlashBladeEventJS.PreCopySpecialAttackFromBladeJSEvent.class).hasResult();
    public static final EventHandler PRE_COPY_SE = GROUP.server("preCopySpecialEffectFromBlade",
        () -> SlashBladeEventJS.PreCopySpecialEffectFromBladeJSEvent.class).hasResult();
    
    public static final EventHandler PROUD_SOUL_ENCHANT = GROUP.server("proudSoulEnchantment",
        () -> SlashBladeEventJS.ProudSoulEnchantmentJSEvent.class).hasResult();
    
    public static final EventHandler REFINE_PROGRESS = GROUP.server("refineProgress",
        () -> SlashBladeEventJS.RefineProgressJSEvent.class).hasResult();
    public static final EventHandler REFINE_SETTLEMENT = GROUP.server("refineSettlement",
        () -> SlashBladeEventJS.RefineSettlementJSEvent.class).hasResult();
    
    public static final EventHandler COMBO_STATE_REGISTRY = GROUP.startup("comboStateRegistry",
        () -> SlashBladeEventJS.ComboStateRegistryEvent.class);
    
    public static final EventHandler PLAYER_ANIMATION_REGISTRY = GROUP.startup("playerAnimationRegistryEvent",
        () -> SlashBladeEventJS.PlayerAnimationRegistryEvent.class);
    
    public static final EventHandler POWER_BLADE = GROUP.server("powerBlade",
        () -> SlashBladeEventJS.PowerBladeEvent.class).hasResult();
    public static final EventHandler UPDATE_ATTACK = GROUP.server("updateAttack",
        () -> SlashBladeEventJS.UpdateAttackEvent.class);
    public static final EventHandler BLADE_STAND_ATTACK = GROUP.server("bladeStandAttack",
        () -> SlashBladeEventJS.BladeStandAttackEvent.class).hasResult();
    public static final EventHandler HIT = GROUP.server("hit",
        () -> SlashBladeEventJS.HitEvent.class).hasResult();
    public static final EventHandler UPDATE = GROUP.server("update",
        () -> SlashBladeEventJS.UpdateEvent.class).hasResult();
    public static final EventHandler DO_SLASH = GROUP.server("doSlash",
        () -> SlashBladeEventJS.DoSlashEvent.class).hasResult();
    
    public static final EventHandler ADD_KILL_COUNT = GROUP.server("addKillCount",
        () -> SlashBladeEventJS.AddKillCountEvent.class);
    public static final EventHandler ADD_PROUD_SOUL = GROUP.server("addProudSoul",
        () -> SlashBladeEventJS.AddProudSoulEvent.class);
    public static final EventHandler BLADE_STAND_TICK = GROUP.server("bladeStandTick",
        () -> SlashBladeEventJS.BladeStandTickEvent.class);
    public static final EventHandler BREAK = GROUP.server("break",
        () -> SlashBladeEventJS.BreakEvent.class).hasResult();
    public static final EventHandler NEXT_COMBO = GROUP.server("nextCombo",
        () -> SlashBladeEventJS.NextComboEvent.class);
    public static final EventHandler NEXT_OF_TIMEOUT_COMBO = GROUP.server("nextOfTimeOutCombo",
        () -> SlashBladeEventJS.NextOfTimeOutComboEvent.class);
    public static final EventHandler CHARGE_ACTION = GROUP.server("chargeAction",
        () -> SlashBladeEventJS.ChargeActionEvent.class).hasResult();
    public static final EventHandler PERFORM_SLASH_ART = GROUP.server("performSlashArt",
        () -> SlashBladeEventJS.PerformSlashArtEvent.class).hasResult();
    public static final EventHandler SUMMONED_SWORD_ON_HIT_ENTITY = GROUP.server("summonedSwordOnHitEntity",
        () -> SlashBladeEventJS.SummonedSwordOnHitEntityEvent.class);
}
