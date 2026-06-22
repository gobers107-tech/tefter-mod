package org.gobers.teftercraft.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.Level;
import org.gobers.teftercraft.data.ModDataComponents;
import org.gobers.teftercraft.utils.test.PosAndState;

import java.util.function.Consumer;

public class DataTabletItem extends Item {
    public DataTabletItem(Properties properties) {
        super(properties);
    }


    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        if(player.getItemInHand(hand).has(ModDataComponents.POS_AND_STATE)) {
            player.getItemInHand(hand).remove(ModDataComponents.POS_AND_STATE);
        }

        return InteractionResult.SUCCESS;
    }

    @Override
    public boolean isFoil(ItemStack itemStack) {
        return itemStack.has(ModDataComponents.POS_AND_STATE);
    }

    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext context, TooltipDisplay display,
                                Consumer<Component> builder, TooltipFlag tooltipFlag) {
        if(itemStack.has(ModDataComponents.POS_AND_STATE)) {
            PosAndState posAndState = itemStack.get(ModDataComponents.POS_AND_STATE);
            String foundPositionString = "(" + posAndState.getPos().getX() + ", " + posAndState.getPos().getY() + ", " + posAndState.getPos().getZ() + ")";
            String block = "(%s)".formatted(posAndState.getBlockState().getBlock().toString());

            builder.accept(Component.literal(foundPositionString));
            builder.accept(Component.literal(block));
        }
    }
}
