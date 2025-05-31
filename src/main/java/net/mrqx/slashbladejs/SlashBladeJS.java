package net.mrqx.slashbladejs;

import com.mojang.logging.LogUtils;
import dev.latvian.mods.kubejs.script.ScriptType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.mrqx.sbr_core.events.ComboStateRegistryEvent;
import net.mrqx.sbr_core.events.MrqxSlashBladeEvents;
import net.mrqx.sbr_core.events.SlashBladePlayerAnimationRegistryEvent;
import net.mrqx.slashbladejs.event.SlashBladeEventGroup;
import net.mrqx.slashbladejs.event.SlashBladeEventJS;
import org.slf4j.Logger;

@Mod(SlashBladeJS.MODID)
public class SlashBladeJS {
    public static final String MODID = "slashbladejs";
    public static final Logger LOGGER = LogUtils.getLogger();

    public SlashBladeJS() {
        MinecraftForge.EVENT_BUS.addListener(this::bladeChangeSpecialAttack);
        MinecraftForge.EVENT_BUS.addListener(this::bladeChangeSpecialEffect);
        MinecraftForge.EVENT_BUS.addListener(this::copySpecialAttackFromBlade);
        MinecraftForge.EVENT_BUS.addListener(this::copySpecialEffectFromBlade);
        MinecraftForge.EVENT_BUS.addListener(this::preCopySpecialAttackFromBlade);
        MinecraftForge.EVENT_BUS.addListener(this::preCopySpecialEffectFromBlade);
        MinecraftForge.EVENT_BUS.addListener(this::proudSoulEnchantment);
        MinecraftForge.EVENT_BUS.addListener(this::refineProgress);
        MinecraftForge.EVENT_BUS.addListener(this::refineSettlement);
        MinecraftForge.EVENT_BUS.addListener(this::comboStateRegistry);
        MinecraftForge.EVENT_BUS.addListener(this::playerAnimationRegistry);
        MinecraftForge.EVENT_BUS.addListener(this::powerBlade);
        MinecraftForge.EVENT_BUS.addListener(this::updateAttack);
        MinecraftForge.EVENT_BUS.addListener(this::bladeStandAttack);
        MinecraftForge.EVENT_BUS.addListener(this::hit);
        MinecraftForge.EVENT_BUS.addListener(this::update);
        MinecraftForge.EVENT_BUS.addListener(this::doSlash);
    }

    public void bladeChangeSpecialAttack(MrqxSlashBladeEvents.BladeChangeSpecialAttackEvent event) {
        SlashBladeEventGroup.BLADE_CHANGE_SA.post(ScriptType.SERVER,
                new SlashBladeEventJS.BladeChangeSpecialAttackEvent(event));
    }

    public void bladeChangeSpecialEffect(MrqxSlashBladeEvents.BladeChangeSpecialEffectEvent event) {
        SlashBladeEventGroup.BLADE_CHANGE_SE.post(ScriptType.SERVER,
                new SlashBladeEventJS.BladeChangeSpecialEffectEvent(event));
    }

    public void copySpecialAttackFromBlade(MrqxSlashBladeEvents.CopySpecialAttackFromBladeEvent event) {
        SlashBladeEventGroup.BLADE_COPY_SA.post(ScriptType.SERVER,
                new SlashBladeEventJS.CopySpecialAttackFromBladeEvent(event));
    }

    public void copySpecialEffectFromBlade(MrqxSlashBladeEvents.CopySpecialEffectFromBladeEvent event) {
        SlashBladeEventGroup.BLADE_COPY_SE.post(ScriptType.SERVER,
                new SlashBladeEventJS.CopySpecialEffectFromBladeEvent(event));
    }

    public void preCopySpecialAttackFromBlade(MrqxSlashBladeEvents.PreCopySpecialAttackFromBladeEvent event) {
        SlashBladeEventGroup.PRE_COPY_SA.post(ScriptType.SERVER,
                new SlashBladeEventJS.PreCopySpecialAttackFromBladeEvent(event));
    }

    public void preCopySpecialEffectFromBlade(MrqxSlashBladeEvents.PreCopySpecialEffectFromBladeEvent event) {
        SlashBladeEventGroup.PRE_COPY_SE.post(ScriptType.SERVER,
                new SlashBladeEventJS.PreCopySpecialEffectFromBladeEvent(event));
    }

    public void proudSoulEnchantment(MrqxSlashBladeEvents.ProudSoulEnchantmentEvent event) {
        SlashBladeEventGroup.PROUD_SOUL_ENCHANT.post(ScriptType.SERVER,
                new SlashBladeEventJS.ProudSoulEnchantmentEvent(event));
    }

    public void refineProgress(MrqxSlashBladeEvents.RefineProgressEvent event) {
        SlashBladeEventGroup.REFINE_PROGRESS.post(ScriptType.SERVER,
                new SlashBladeEventJS.RefineProgressEvent(event));
    }

    public void refineSettlement(MrqxSlashBladeEvents.RefineSettlementEvent event) {
        SlashBladeEventGroup.REFINE_SETTLEMENT.post(ScriptType.SERVER,
                new SlashBladeEventJS.RefineSettlementEvent(event));
    }

    public void comboStateRegistry(ComboStateRegistryEvent event) {
        SlashBladeEventGroup.COMBO_STATE_REGISTRY.post(ScriptType.STARTUP,
                new SlashBladeEventJS.ComboStateRegistryEvent(event));
    }

    public void playerAnimationRegistry(SlashBladePlayerAnimationRegistryEvent event) {
        SlashBladeEventGroup.PLAYER_ANIMATION_REGISTRY.post(ScriptType.STARTUP,
                new SlashBladeEventJS.PlayerAnimationRegistryEvent(event));
    }

    public void powerBlade(MrqxSlashBladeEvents.PowerBladeEvent event) {
        SlashBladeEventGroup.POWER_BLADE.post(ScriptType.SERVER,
                new SlashBladeEventJS.PowerBladeEvent(event));
    }

    public void updateAttack(MrqxSlashBladeEvents.UpdateAttackEvent event) {
        SlashBladeEventGroup.UPDATE_ATTACK.post(ScriptType.SERVER,
                new SlashBladeEventJS.UpdateAttackEvent(event));
    }

    public void bladeStandAttack(MrqxSlashBladeEvents.BladeStandAttackEvent event) {
        SlashBladeEventGroup.BLADE_STAND_ATTACK.post(ScriptType.SERVER,
                new SlashBladeEventJS.BladeStandAttackEvent(event));
    }

    public void hit(MrqxSlashBladeEvents.HitEvent event) {
        SlashBladeEventGroup.HIT.post(ScriptType.SERVER,
                new SlashBladeEventJS.HitEvent(event));
    }

    public void update(MrqxSlashBladeEvents.UpdateEvent event) {
        SlashBladeEventGroup.UPDATE.post(ScriptType.SERVER,
                new SlashBladeEventJS.UpdateEvent(event));
    }

    public void doSlash(MrqxSlashBladeEvents.DoSlashEvent event) {
        SlashBladeEventGroup.DO_SLASH.post(ScriptType.SERVER,
                new SlashBladeEventJS.DoSlashEvent(event));
    }
}
