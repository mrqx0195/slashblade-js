package net.mrqx.slashbladejs;

import com.mojang.logging.LogUtils;
import dev.latvian.mods.kubejs.script.ScriptType;
import mods.flammpfeil.slashblade.event.RefineProgressEvent;
import mods.flammpfeil.slashblade.event.RefineSettlementEvent;
import mods.flammpfeil.slashblade.event.SlashBladeEvent;
import mods.flammpfeil.slashblade.event.bladestand.*;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.mrqx.sbr_core.events.ComboStateRegistryEvent;
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
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::comboStateRegistry);
        MinecraftForge.EVENT_BUS.addListener(this::playerAnimationRegistry);
        MinecraftForge.EVENT_BUS.addListener(this::powerBlade);
        MinecraftForge.EVENT_BUS.addListener(this::updateAttack);
        MinecraftForge.EVENT_BUS.addListener(this::bladeStandAttack);
        MinecraftForge.EVENT_BUS.addListener(this::hit);
        MinecraftForge.EVENT_BUS.addListener(this::update);
        MinecraftForge.EVENT_BUS.addListener(this::doSlash);
        MinecraftForge.EVENT_BUS.addListener(this::addKillCount);
        MinecraftForge.EVENT_BUS.addListener(this::addProudSoul);
        MinecraftForge.EVENT_BUS.addListener(this::bladeStandTick);
        MinecraftForge.EVENT_BUS.addListener(this::breakBlade);
        MinecraftForge.EVENT_BUS.addListener(this::nextCombo);
        MinecraftForge.EVENT_BUS.addListener(this::nextOfTimeOutCombo);
        MinecraftForge.EVENT_BUS.addListener(this::chargeAction);
        MinecraftForge.EVENT_BUS.addListener(this::performSlashArt);
        MinecraftForge.EVENT_BUS.addListener(this::summonedSwordOnHitEntity);
    }

    public void bladeChangeSpecialAttack(BladeChangeSpecialAttackEvent event) {
        SlashBladeEventGroup.BLADE_CHANGE_SA.post(ScriptType.SERVER,
                new SlashBladeEventJS.BladeChangeSpecialAttackJSEvent(event));
    }

    public void bladeChangeSpecialEffect(BladeChangeSpecialEffectEvent event) {
        SlashBladeEventGroup.BLADE_CHANGE_SE.post(ScriptType.SERVER,
                new SlashBladeEventJS.BladeChangeSpecialEffectJSEvent(event));
    }

    public void copySpecialAttackFromBlade(CopySpecialAttackFromBladeEvent event) {
        SlashBladeEventGroup.BLADE_COPY_SA.post(ScriptType.SERVER,
                new SlashBladeEventJS.CopySpecialAttackFromBladeJSEvent(event));
    }

    public void copySpecialEffectFromBlade(CopySpecialEffectFromBladeEvent event) {
        SlashBladeEventGroup.BLADE_COPY_SE.post(ScriptType.SERVER,
                new SlashBladeEventJS.CopySpecialEffectFromBladeJSEvent(event));
    }

    public void preCopySpecialAttackFromBlade(PreCopySpecialAttackFromBladeEvent event) {
        SlashBladeEventGroup.PRE_COPY_SA.post(ScriptType.SERVER,
                new SlashBladeEventJS.PreCopySpecialAttackFromBladeJSEvent(event));
    }

    public void preCopySpecialEffectFromBlade(PreCopySpecialEffectFromBladeEvent event) {
        SlashBladeEventGroup.PRE_COPY_SE.post(ScriptType.SERVER,
                new SlashBladeEventJS.PreCopySpecialEffectFromBladeJSEvent(event));
    }

    public void proudSoulEnchantment(ProudSoulEnchantmentEvent event) {
        SlashBladeEventGroup.PROUD_SOUL_ENCHANT.post(ScriptType.SERVER,
                new SlashBladeEventJS.ProudSoulEnchantmentJSEvent(event));
    }

    public void refineProgress(RefineProgressEvent event) {
        SlashBladeEventGroup.REFINE_PROGRESS.post(ScriptType.SERVER,
                new SlashBladeEventJS.RefineProgressJSEvent(event));
    }

    public void refineSettlement(RefineSettlementEvent event) {
        SlashBladeEventGroup.REFINE_SETTLEMENT.post(ScriptType.SERVER,
                new SlashBladeEventJS.RefineSettlementJSEvent(event));
    }

    public void comboStateRegistry(ComboStateRegistryEvent event) {
        SlashBladeEventGroup.COMBO_STATE_REGISTRY.post(ScriptType.STARTUP,
                new SlashBladeEventJS.ComboStateRegistryEvent(event));
    }

    public void playerAnimationRegistry(SlashBladePlayerAnimationRegistryEvent event) {
        SlashBladeEventGroup.PLAYER_ANIMATION_REGISTRY.post(ScriptType.STARTUP,
                new SlashBladeEventJS.PlayerAnimationRegistryEvent(event));
    }

    public void powerBlade(SlashBladeEvent.PowerBladeEvent event) {
        SlashBladeEventGroup.POWER_BLADE.post(ScriptType.SERVER,
                new SlashBladeEventJS.PowerBladeEvent(event));
    }

    public void updateAttack(SlashBladeEvent.UpdateAttackEvent event) {
        SlashBladeEventGroup.UPDATE_ATTACK.post(ScriptType.SERVER,
                new SlashBladeEventJS.UpdateAttackEvent(event));
    }

    public void bladeStandAttack(SlashBladeEvent.BladeStandAttackEvent event) {
        SlashBladeEventGroup.BLADE_STAND_ATTACK.post(ScriptType.SERVER,
                new SlashBladeEventJS.BladeStandAttackEvent(event));
    }

    public void hit(SlashBladeEvent.HitEvent event) {
        SlashBladeEventGroup.HIT.post(ScriptType.SERVER,
                new SlashBladeEventJS.HitEvent(event));
    }

    public void update(SlashBladeEvent.UpdateEvent event) {
        SlashBladeEventGroup.UPDATE.post(ScriptType.SERVER,
                new SlashBladeEventJS.UpdateEvent(event));
    }

    public void doSlash(SlashBladeEvent.DoSlashEvent event) {
        SlashBladeEventGroup.DO_SLASH.post(ScriptType.SERVER,
                new SlashBladeEventJS.DoSlashEvent(event));
    }

    public void addKillCount(SlashBladeEvent.AddKillCountEvent event) {
        SlashBladeEventGroup.ADD_KILL_COUNT.post(ScriptType.SERVER,
                new SlashBladeEventJS.AddKillCountEvent(event));
    }

    public void addProudSoul(SlashBladeEvent.AddProudSoulEvent event) {
        SlashBladeEventGroup.ADD_PROUD_SOUL.post(ScriptType.SERVER,
                new SlashBladeEventJS.AddProudSoulEvent(event));
    }

    public void bladeStandTick(SlashBladeEvent.BladeStandTickEvent event) {
        SlashBladeEventGroup.BLADE_STAND_TICK.post(ScriptType.SERVER,
                new SlashBladeEventJS.BladeStandTickEvent(event));
    }

    public void breakBlade(SlashBladeEvent.BreakEvent event) {
        SlashBladeEventGroup.BREAK.post(ScriptType.SERVER,
                new SlashBladeEventJS.BreakEvent(event));
    }

    public void nextCombo(SlashBladeEvent.NextComboEvent event) {
        SlashBladeEventGroup.NEXT_COMBO.post(ScriptType.SERVER,
                new SlashBladeEventJS.NextComboEvent(event));
    }

    public void nextOfTimeOutCombo(SlashBladeEvent.NextOfTimeOutComboEvent event) {
        SlashBladeEventGroup.NEXT_OF_TIMEOUT_COMBO.post(ScriptType.SERVER,
                new SlashBladeEventJS.NextOfTimeOutComboEvent(event));
    }

    public void chargeAction(SlashBladeEvent.ChargeActionEvent event) {
        SlashBladeEventGroup.CHARGE_ACTION.post(ScriptType.SERVER,
                new SlashBladeEventJS.ChargeActionEvent(event));
    }

    public void performSlashArt(SlashBladeEvent.PerformSlashArtEvent event) {
        SlashBladeEventGroup.PERFORM_SLASH_ART.post(ScriptType.SERVER,
                new SlashBladeEventJS.PerformSlashArtEvent(event));
    }

    public void summonedSwordOnHitEntity(SlashBladeEvent.SummonedSwordOnHitEntityEvent event) {
        SlashBladeEventGroup.SUMMONED_SWORD_ON_HIT_ENTITY.post(ScriptType.SERVER,
                new SlashBladeEventJS.SummonedSwordOnHitEntityEvent(event));
    }
}
