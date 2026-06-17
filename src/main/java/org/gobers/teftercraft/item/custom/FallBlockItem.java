package org.gobers.teftercraft.item.custom;

import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;

public class FallBlockItem extends Item {
    public FallBlockItem(Properties properties) {
        properties.stacksTo(1);
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {

//        var fallingBlock = new FallingBlockEntity(EntityType.FALLING_BLOCK, context.getLevel());
//        fallingBlock.setPos(context.getClickedPos().getX(),context.getClickedPos().getY(),context.getClickedPos().getZ());
//        fallingBlock.
//
//        context.getLevel().addFreshEntity(fallingBlock);
        if (context.getLevel().isClientSide())return InteractionResult.SUCCESS;

        FallingBlockEntity.fall(context.getLevel(),context.getClickedPos(),context.getLevel().getBlockState(context.getClickedPos()));
        context.getItemInHand().hurtAndBreak(1,context.getPlayer(),context.getHand());
        return InteractionResult.SUCCESS;
    }
}
