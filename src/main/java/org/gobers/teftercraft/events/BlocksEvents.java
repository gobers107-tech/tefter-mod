package org.gobers.teftercraft.events;

import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.gamerules.GameRules;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.level.BlockEvent;
import net.neoforged.neoforge.event.level.block.BreakBlockEvent;
import org.gobers.teftercraft.TefterCarft;

import java.util.function.Consumer;

public class BlocksEvents{


    @SubscribeEvent
    public  void onBlockBrack(BreakBlockEvent event){

//        event.getPlayer().sendSystemMessage(Component.literal("tetettette"));
        if (event.getState() == Blocks.TNT.defaultBlockState()){




            ((Level)event.getLevel()).explode(null,event.getPos().getX(),event.getPos().getY(),event.getPos().getZ(),5, Level.ExplosionInteraction.MOB);
            event.setCanceled(true);

        }
        else {

//            var tnt = new PrimedTnt((Level) event.getLevel(),event.getPos().getX()+0.5,event.getPos().getY(),event.getPos().getZ()+0.5,event.getPlayer());
//            tnt.setFuse(40);
//
//            tnt.setInvisible(true);
//            tnt.setBlockState(event.getState());
//            tnt.setDeltaMovement(0,0,0);
//
//            event.getLevel().addFreshEntity(tnt);
        }
    }


}
