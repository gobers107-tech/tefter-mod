package org.gobers.teftercraft.datagen;


import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.data.ItemTagsProvider;
import org.gobers.teftercraft.TefterCarft;
import org.gobers.teftercraft.item.ModItems;
import org.gobers.teftercraft.tags.ModTags;
import org.gobers.teftercraft.utils.Utils;

import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider extends ItemTagsProvider {
    public ModItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, TefterCarft.MODID);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {

        tag(ItemTags.PICKAXES).add(Utils.getRID( ModItems.TERIT_PICKAXE.get()));
        tag(ItemTags.SWORDS).add(Utils.getRID(ModItems.TERIT_SWORD.get())).add(Utils.getRID(ModItems.TERIT_PICKAXE.get()));
        tag(ItemTags.SHOVELS).add(Utils.getRID(ModItems.TERIT_SHOVEL.get()));
        tag(ItemTags.HOES).add(Utils.getRID(ModItems.TERIT_HOE.get()));
        tag(ItemTags.AXES).add(Utils.getRID(ModItems.TERIT_AXE.get()));


        tag(ModTags.Items.TRANSFORMABLE_ITEMS)
                .add(Utils.getRID(Items.IRON_INGOT))
                .add(Utils.getRID(Items.REDSTONE))
                .add(Utils.getRID(Items.COPPER_INGOT))
                .add(Utils.getRID(ModItems.TEST_ITEM.get()));
    }
}