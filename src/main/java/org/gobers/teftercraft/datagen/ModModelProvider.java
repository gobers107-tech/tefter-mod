package org.gobers.teftercraft.datagen;

import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.data.PackOutput;

import org.gobers.teftercraft.*;
import org.gobers.teftercraft.block.ModBlocks;
import org.gobers.teftercraft.item.ModItems;

public class ModModelProvider extends ModelProvider  {


    public ModModelProvider(PackOutput output) {
        super(output,TefterCarft.MODID);
    }
    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {

        itemModels.generateFlatItem(ModItems.TEST_ITEM.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.DIRON.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.PORTAL.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.KABOOM.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.BLOCK_TO_TNT.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.FAll_Block.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.TERIT.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.TEFTBRF.get(), ModelTemplates.FLAT_ITEM);

        itemModels.generateFlatItem(ModItems.TERIT_SWORD.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(ModItems.TERIT_PICKAXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(ModItems.TERIT_SHOVEL.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(ModItems.TERIT_AXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(ModItems.TERIT_HOE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateSpear(ModItems.TERIT_SPEAR.get());
        /* BLOCKS */
        blockModels.createTrivialCube(ModBlocks.TEST_BLOCK.get());
        blockModels.createTrivialCube(ModBlocks.TEST2_BLOCK.get());
        blockModels.createTrivialCube(ModBlocks.TEREN.get());
        blockModels.createTrivialCube(ModBlocks.AN_CRAFT_BLOCK.get());

    }
}

