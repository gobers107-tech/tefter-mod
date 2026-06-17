package org.gobers.teftercraft.item.custom;

import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;

public class BlockToTntItem extends Item {
    public BlockToTntItem(Properties properties) {
        properties.stacksTo(1);
        properties.durability(32);
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        if (context.getLevel().isClientSide())return InteractionResult.SUCCESS;
        var tnt = new PrimedTnt((Level) context.getLevel(),context.getClickedPos().getX()+0.5,context.getClickedPos().getY(),context.getClickedPos().getZ()+0.5,context.getPlayer());
        tnt.setFuse(40);

        tnt.setInvisible(true);
        tnt.setBlockState(context.getLevel().getBlockState(context.getClickedPos()));
        tnt.setDeltaMovement(0,0,0);

        context.getLevel().setBlock(context.getClickedPos(), Blocks.AIR.defaultBlockState(),0,1);
        context.getLevel().addFreshEntity(tnt);
        context.getItemInHand().hurtAndBreak(1,context.getPlayer(),context.getHand());

        return InteractionResult.SUCCESS;
    }
}
