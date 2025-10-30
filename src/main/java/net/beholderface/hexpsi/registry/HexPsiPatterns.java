package net.beholderface.hexpsi.registry;

import at.petrak.hexcasting.api.casting.ActionRegistryEntry;
import at.petrak.hexcasting.api.casting.castables.Action;
import at.petrak.hexcasting.api.casting.iota.EntityIota;
import at.petrak.hexcasting.api.casting.iota.NullIota;
import at.petrak.hexcasting.api.casting.iota.Vec3Iota;
import at.petrak.hexcasting.api.casting.math.HexDir;
import at.petrak.hexcasting.api.casting.math.HexPattern;
import at.petrak.hexcasting.common.casting.actions.spells.OpMakePackagedSpell;
import at.petrak.hexcasting.common.lib.hex.HexActions;
import at.petrak.hexcasting.xplat.IXplatAbstractions;
import net.beholderface.hexpsi.HexPsi;
import net.beholderface.hexpsi.hex.actions.OpReadHelmet;
import net.beholderface.hexpsi.hex.actions.OpReadPsiContextData;
import net.beholderface.hexpsi.hex.actions.OpReadPsiMeter;
import net.beholderface.hexpsi.hex.actions.OpWriteHelmet;
import net.beholderface.hexpsi.hex.actions.spells.OpMakeTrinketBullet;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.DeferredRegister;

public class HexPsiPatterns {

    private static boolean registered = false;

    public static final DeferredRegister<ActionRegistryEntry> ACTIONS = DeferredRegister.create(IXplatAbstractions.INSTANCE.getActionRegistry().key(), HexPsi.MODID);

    public static final HexPattern WRITE_HELMET = register(HexPattern.fromAngles("ewqweedwwwwqwa", HexDir.NORTH_EAST), "write_helmet", new OpWriteHelmet());
    public static final HexPattern READ_HELMET = register(HexPattern.fromAngles("ewqewaqqewwqwa", HexDir.NORTH_EAST), "read_helmet", new OpReadHelmet());
    public static final HexPattern READ_PSI_METER = register(HexPattern.fromAngles("ewqwdedqwwqwa", HexDir.NORTH_EAST), "read_psi_meter", new OpReadPsiMeter());
    public static final HexPattern CRAFT_TRINKET_BULLET = register(HexPattern.fromAngles("eqqqqqawwdeqdqwdqdwqdqe", HexDir.EAST), "craft_trinket_bullet", new OpMakeTrinketBullet());

    /*public static final HexPattern READ_PSI_ATTACKER = register(HexPattern.fromAngles("ede", HexDir.NORTH_WEST), "read_attacker", new OpReadPsiContextData((context)->{
        if (context.attackingEntity != null){
            return new EntityIota(context.attackingEntity);
        } else {
            return new NullIota();
        }
    }));

    public static final HexPattern READ_PSI_TARGET = register(HexPattern.fromAngles("edew", HexDir.NORTH_WEST), "read_attacked", new OpReadPsiContextData((context)->{
        if (context.attackedEntity != null){
            return new EntityIota(context.attackedEntity);
        } else {
            return new NullIota();
        }
    }));

    public static final HexPattern READ_PSI_BLOCKHIT = register(HexPattern.fromAngles("dqqqqqaqeqawwqwwa", HexDir.NORTH_EAST), "read_blockhit", new OpReadPsiContextData((context)->{
        BlockHitResult hit = context.positionBroken;
        if (hit != null){
            BlockPos hitPos = hit.getBlockPos();
            return new Vec3Iota(new Vec3(hitPos.getX() + 0.5, hitPos.getY() + 0.5, hitPos.getZ() + 0.5));
        } else {
            return new NullIota();
        }
    }));*/

    public static HexPattern register(HexPattern pattern, String name, Action action){
        ACTIONS.register(name, ()->new ActionRegistryEntry(pattern, action));
        return pattern;
    }

    public static boolean isRegistered(){
        return registered;
    }
    public static void notifyRegistration(){
        registered = true;
    }
}
