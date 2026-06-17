package org.gobers.teftercraft.item.custom;

import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.phys.Vec3;

public class TeftnrfItem extends Item {
    public TeftnrfItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        if (context.getLevel().isClientSide())return InteractionResult.SUCCESS;
        var forvord = context.getPlayer().getForward();

        var block = FallingBlockEntity.fall(context.getLevel(),context.getClickedPos(),context.getLevel().getBlockState(context.getClickedPos()));

        block.addDeltaMovement(new Vec3(forvord.x,1,forvord.z));
        context.getItemInHand().hurtAndBreak(1,context.getPlayer(),context.getHand());
        return InteractionResult.SUCCESS;
    }
}
