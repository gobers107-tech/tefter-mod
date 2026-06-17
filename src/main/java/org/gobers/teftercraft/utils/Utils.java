package org.gobers.teftercraft.utils;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Utils {
    static Random rand = new Random();
    static List<Block> blocks = new ArrayList<>();

    private static void fillBlocks(){
        BuiltInRegistries.BLOCK.forEach(block -> {

            if (block != Blocks.AIR &&
                    block != Blocks.CAVE_AIR &&
                    block != Blocks.VOID_AIR) {

                blocks.add(block);
            }
        });
    }
    public static Block getRandomBlock(){

        if (blocks.isEmpty()) fillBlocks();
        return blocks.get(rand.nextInt(blocks.size()));
    }
    public static Item getRandomItem(){

        if (blocks.isEmpty()) fillBlocks();
        return BufferMod.randItemToTransform.get(rand.nextInt(BufferMod.randItemToTransform.size()));
    }
}
