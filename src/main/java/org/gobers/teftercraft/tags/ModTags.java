package org.gobers.teftercraft.tags;

import net.minecraft.resources.Identifier;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import org.gobers.teftercraft.TefterCarft;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_TERIT_TOOL = createTag("needs_terit_tool");
        public static final TagKey<Block> INCORRECT_FOR_TERIT_TOOL = createTag("incorrect_for_terit_tool");


        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(Identifier.fromNamespaceAndPath(TefterCarft.MODID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> TRANSFORMABLE_ITEMS = createTag("transformable_items");
        public static final TagKey<Item> TERIT_REPAIRABLE = createTag("TERIT_repairable".toLowerCase());


        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(Identifier.fromNamespaceAndPath(TefterCarft.MODID, name));
        }
    }
}
