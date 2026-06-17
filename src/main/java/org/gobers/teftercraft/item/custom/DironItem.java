package org.gobers.teftercraft.item.custom;

import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import org.gobers.teftercraft.utils.Utils;


public class DironItem extends Item {
    public DironItem(Properties properties) {
        properties.durability(128);
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        if (level.isClientSide()) return super.useOn(context);
        ((ServerLevel) level).sendParticles(new BlockParticleOption(ParticleTypes.BLOCK,context.getLevel().getBlockState(context.getClickedPos())),context.getClickedPos().getX()+0.5
              ,context.getClickedPos().getY()+1,context.getClickedPos().getZ() + 0.5,50,0,0,0,1.5f);


        assert context.getPlayer() != null;
        context.getItemInHand().hurtAndBreak(1,context.getPlayer(),context.getHand());
        var block = Utils.getRandomBlock();
        level.setBlock(context.getClickedPos(),block.defaultBlockState(), 1);
        ((ServerLevel) level).sendParticles(new BlockParticleOption(ParticleTypes.BLOCK,block.defaultBlockState()),context.getClickedPos().getX()+0.5
        ,context.getClickedPos().getY()+1,context.getClickedPos().getZ() + 0.5,50,0.5,0.5,0.5,1.5f);

        return super.useOn(context);
    }
}
