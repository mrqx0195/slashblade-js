package net.mrqx.slashbladejs;

import com.mojang.logging.LogUtils;
import dev.latvian.mods.kubejs.script.ScriptType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.mrqx.sbr_core.events.MrqxSlashBladeEvents;
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
        MinecraftForge.EVENT_BUS.addListener(this::powerBlade);
        MinecraftForge.EVENT_BUS.addListener(this::updateAttack);
        MinecraftForge.EVENT_BUS.addListener(this::bladeStandAttack);
        MinecraftForge.EVENT_BUS.addListener(this::hit);
        MinecraftForge.EVENT_BUS.addListener(this::update);
        MinecraftForge.EVENT_BUS.addListener(this::doSlash);
    }

    public void bladeChangeSpecialAttack(MrqxSlashBladeEvents.BladeChangeSpecialAttackEvent event) {
        SlashBladeJSPlugin.BLADE_CHANGE_SA.post(ScriptType.SERVER,
                new SlashBladeJSPlugin.BladeChangeSpecialAttackEvent(event));
    }

    public void bladeChangeSpecialEffect(MrqxSlashBladeEvents.BladeChangeSpecialEffectEvent event) {
        SlashBladeJSPlugin.BLADE_CHANGE_SE.post(ScriptType.SERVER,
                new SlashBladeJSPlugin.BladeChangeSpecialEffectEvent(event));
    }

    public void copySpecialAttackFromBlade(MrqxSlashBladeEvents.CopySpecialAttackFromBladeEvent event) {
        SlashBladeJSPlugin.BLADE_COPY_SA.post(ScriptType.SERVER,
                new SlashBladeJSPlugin.CopySpecialAttackFromBladeEvent(event));
    }

    public void copySpecialEffectFromBlade(MrqxSlashBladeEvents.CopySpecialEffectFromBladeEvent event) {
        SlashBladeJSPlugin.BLADE_COPY_SE.post(ScriptType.SERVER,
                new SlashBladeJSPlugin.CopySpecialEffectFromBladeEvent(event));
    }

    public void preCopySpecialAttackFromBlade(MrqxSlashBladeEvents.PreCopySpecialAttackFromBladeEvent event) {
        SlashBladeJSPlugin.PRE_COPY_SA.post(ScriptType.SERVER,
                new SlashBladeJSPlugin.PreCopySpecialAttackFromBladeEvent(event));
    }

    public void preCopySpecialEffectFromBlade(MrqxSlashBladeEvents.PreCopySpecialEffectFromBladeEvent event) {
        SlashBladeJSPlugin.PRE_COPY_SE.post(ScriptType.SERVER,
                new SlashBladeJSPlugin.PreCopySpecialEffectFromBladeEvent(event));
    }

    public void proudSoulEnchantment(MrqxSlashBladeEvents.ProudSoulEnchantmentEvent event) {
        SlashBladeJSPlugin.PROUD_SOUL_ENCHANT.post(ScriptType.SERVER,
                new SlashBladeJSPlugin.ProudSoulEnchantmentEvent(event));
    }

    public void refineProgress(MrqxSlashBladeEvents.RefineProgressEvent event) {
        SlashBladeJSPlugin.REFINE_PROGRESS.post(ScriptType.SERVER,
                new SlashBladeJSPlugin.RefineProgressEvent(event));
    }

    public void refineSettlement(MrqxSlashBladeEvents.RefineSettlementEvent event) {
        SlashBladeJSPlugin.REFINE_SETTLEMENT.post(ScriptType.SERVER,
                new SlashBladeJSPlugin.RefineSettlementEvent(event));
    }

    public void powerBlade(MrqxSlashBladeEvents.PowerBladeEvent event) {
        SlashBladeJSPlugin.POWER_BLADE.post(ScriptType.SERVER,
                new SlashBladeJSPlugin.PowerBladeEvent(event));
    }

    public void updateAttack(MrqxSlashBladeEvents.UpdateAttackEvent event) {
        SlashBladeJSPlugin.UPDATE_ATTACK.post(ScriptType.SERVER,
                new SlashBladeJSPlugin.UpdateAttackEvent(event));
    }

    public void bladeStandAttack(MrqxSlashBladeEvents.BladeStandAttackEvent event) {
        SlashBladeJSPlugin.BLADE_STAND_ATTACK.post(ScriptType.SERVER,
                new SlashBladeJSPlugin.BladeStandAttackEvent(event));
    }

    public void hit(MrqxSlashBladeEvents.HitEvent event) {
        SlashBladeJSPlugin.HIT.post(ScriptType.SERVER,
                new SlashBladeJSPlugin.HitEvent(event));
    }

    public void update(MrqxSlashBladeEvents.UpdateEvent event) {
        SlashBladeJSPlugin.UPDATE.post(ScriptType.SERVER,
                new SlashBladeJSPlugin.UpdateEvent(event));
    }

    public void doSlash(MrqxSlashBladeEvents.DoSlashEvent event) {
        SlashBladeJSPlugin.DO_SLASH.post(ScriptType.SERVER,
                new SlashBladeJSPlugin.DoSlashEvent(event));
    }
}