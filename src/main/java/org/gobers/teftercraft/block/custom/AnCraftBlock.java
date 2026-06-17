package org.gobers.teftercraft.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.vehicle.minecart.Minecart;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingRecipe;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.gobers.teftercraft.tags.ModTags;
import org.gobers.teftercraft.utils.Utils;

import java.util.Objects;

public class AnCraftBlock extends Block {
    public AnCraftBlock(Properties properties) {
        super(properties);
    }


    @Override
    public void stepOn(Level level, BlockPos pos, BlockState onState, Entity entity) {
        if (entity instanceof ItemEntity itemEntity && !level.isClientSide()){
            if (itemEntity.getItem().is(ModTags.Items.TRANSFORMABLE_ITEMS)){
                itemEntity.setItem(new ItemStack(Utils.getRandomItem(),itemEntity.getItem().getCount()));
            }
        }
    }
}
