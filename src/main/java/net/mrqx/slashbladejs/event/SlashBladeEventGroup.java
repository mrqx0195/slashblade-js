package net.mrqx.slashbladejs.event;

import dev.latvian.mods.kubejs.event.EventGroup;
import dev.latvian.mods.kubejs.event.EventHandler;

public class SlashBladeEventGroup {
    public static final EventGroup GROUP = EventGroup.of("SlashBladeJSEvents");

    public static final EventHandler BLADE_CHANGE_SA = GROUP.server("bladeChangeSpecialAttack",
            () -> SlashBladeEventJS.BladeChangeSpecialAttackEvent.class);
    public static final EventHandler BLADE_CHANGE_SE = GROUP.server("bladeChangeSpecialEffect",
            () -> SlashBladeEventJS.BladeChangeSpecialEffectEvent.class);

    public static final EventHandler BLADE_COPY_SA = GROUP.server("copySpecialAttackFromBlade",
            () -> SlashBladeEventJS.CopySpecialAttackFromBladeEvent.class);
    public static final EventHandler BLADE_COPY_SE = GROUP.server("copySpecialEffectFromBlade",
            () -> SlashBladeEventJS.CopySpecialEffectFromBladeEvent.class);

    public static final EventHandler PRE_COPY_SA = GROUP.server("preCopySpecialAttackFromBlade",
            () -> SlashBladeEventJS.PreCopySpecialAttackFromBladeEvent.class);
    public static final EventHandler PRE_COPY_SE = GROUP.server("preCopySpecialEffectFromBlade",
            () -> SlashBladeEventJS.PreCopySpecialEffectFromBladeEvent.class);

    public static final EventHandler PROUD_SOUL_ENCHANT = GROUP.server("proudSoulEnchantment",
            () -> SlashBladeEventJS.ProudSoulEnchantmentEvent.class);

    public static final EventHandler REFINE_PROGRESS = GROUP.server("refineProgress",
            () -> SlashBladeEventJS.RefineProgressEvent.class);
    public static final EventHandler REFINE_SETTLEMENT = GROUP.server("refineSettlement",
            () -> SlashBladeEventJS.RefineSettlementEvent.class);

    public static final EventHandler COMBO_STATE_REGISTRY = GROUP.startup("comboStateRegistry",
            () -> SlashBladeEventJS.ComboStateRegistryEvent.class);

    public static final EventHandler PLAYER_ANIMATION_REGISTRY = GROUP.startup("playerAnimationRegistryEvent",
            () -> SlashBladeEventJS.PlayerAnimationRegistryEvent.class);

    public static final EventHandler POWER_BLADE = GROUP.server("powerBlade",
            () -> SlashBladeEventJS.PowerBladeEvent.class);
    public static final EventHandler UPDATE_ATTACK = GROUP.server("updateAttack",
            () -> SlashBladeEventJS.UpdateAttackEvent.class);
    public static final EventHandler BLADE_STAND_ATTACK = GROUP.server("bladeStandAttack",
            () -> SlashBladeEventJS.BladeStandAttackEvent.class);
    public static final EventHandler HIT = GROUP.server("hit",
            () -> SlashBladeEventJS.HitEvent.class);
    public static final EventHandler UPDATE = GROUP.server("update",
            () -> SlashBladeEventJS.UpdateEvent.class);
    public static final EventHandler DO_SLASH = GROUP.server("doSlash",
            () -> SlashBladeEventJS.DoSlashEvent.class);

}
