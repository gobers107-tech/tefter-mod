package org.gobers.teftercraft.block;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.gobers.teftercraft.TefterCarft;
import org.gobers.teftercraft.block.custom.AnCraftBlock;
import org.gobers.teftercraft.block.custom.TerenBlock;
import org.gobers.teftercraft.item.ModItems;

import java.util.function.Function;

public class ModBlocks {


    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(TefterCarft.MODID);


    public static final DeferredBlock<Block> TEST_BLOCK  = registerBlock("test",(properties) -> new Block(properties.strength(1)),false);
    public static final DeferredBlock<Block> TEST2_BLOCK  = registerBlock("test2",(properties) -> new Block(properties.strength(1)),true);
    public static final DeferredBlock<Block> TEREN  = registerBlock("teren",(properties) -> new TerenBlock(properties.strength(1)),true);
    public static final DeferredBlock<Block> AN_CRAFT_BLOCK  = registerBlock("an_craft_block",(properties) -> new AnCraftBlock(properties.strength(1)),true);

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Function<BlockBehaviour.Properties, T> function,boolean BI ) {
        DeferredBlock<T> toReturn = BLOCKS.registerBlock(name, function);
        if(BI)registerBlockItem(name, toReturn);
        return toReturn;
    }


    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.registerItem(name, properties -> new BlockItem(block.get(), properties.useBlockDescriptionPrefix()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);

    }
}
