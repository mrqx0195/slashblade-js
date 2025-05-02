package net.mrqx.slashbladejs.event;

import dev.latvian.mods.kubejs.event.EventGroup;
import dev.latvian.mods.kubejs.event.EventHandler;

public class SlashBladeEventGroup {
    public static EventGroup GROUP = EventGroup.of("SlashBladeJSEvents");

    public static EventHandler BLADE_CHANGE_SA = GROUP.server("bladeChangeSpecialAttack",
            () -> SlashBladeEventJS.BladeChangeSpecialAttackEvent.class);
    public static EventHandler BLADE_CHANGE_SE = GROUP.server("bladeChangeSpecialEffect",
            () -> SlashBladeEventJS.BladeChangeSpecialEffectEvent.class);

    public static EventHandler BLADE_COPY_SA = GROUP.server("copySpecialAttackFromBlade",
            () -> SlashBladeEventJS.CopySpecialAttackFromBladeEvent.class);
    public static EventHandler BLADE_COPY_SE = GROUP.server("copySpecialEffectFromBlade",
            () -> SlashBladeEventJS.CopySpecialEffectFromBladeEvent.class);

    public static EventHandler PRE_COPY_SA = GROUP.server("preCopySpecialAttackFromBlade",
            () -> SlashBladeEventJS.PreCopySpecialAttackFromBladeEvent.class);
    public static EventHandler PRE_COPY_SE = GROUP.server("preCopySpecialEffectFromBlade",
            () -> SlashBladeEventJS.PreCopySpecialEffectFromBladeEvent.class);

    public static EventHandler PROUD_SOUL_ENCHANT = GROUP.server("proudSoulEnchantment",
            () -> SlashBladeEventJS.ProudSoulEnchantmentEvent.class);

    public static EventHandler REFINE_PROGRESS = GROUP.server("refineProgress",
            () -> SlashBladeEventJS.RefineProgressEvent.class);
    public static EventHandler REFINE_SETTLEMENT = GROUP.server("refineSettlement",
            () -> SlashBladeEventJS.RefineSettlementEvent.class);

    public static EventHandler POWER_BLADE = GROUP.server("powerBlade",
            () -> SlashBladeEventJS.PowerBladeEvent.class);
    public static EventHandler UPDATE_ATTACK = GROUP.server("updateAttack",
            () -> SlashBladeEventJS.UpdateAttackEvent.class);
    public static EventHandler BLADE_STAND_ATTACK = GROUP.server("bladeStandAttack",
            () -> SlashBladeEventJS.BladeStandAttackEvent.class);
    public static EventHandler HIT = GROUP.server("hit",
            () -> SlashBladeEventJS.HitEvent.class);
    public static EventHandler UPDATE = GROUP.server("update",
            () -> SlashBladeEventJS.UpdateEvent.class);
    public static EventHandler DO_SLASH = GROUP.server("doSlash",
            () -> SlashBladeEventJS.DoSlashEvent.class);

}
