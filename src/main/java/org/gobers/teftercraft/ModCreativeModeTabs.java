package org.gobers.teftercraft;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.gobers.teftercraft.block.ModBlocks;
import org.gobers.teftercraft.item.ModItems;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TefterCarft.MODID);

    public static final Supplier<CreativeModeTab> AZURITE_ITEMS_TAB = CREATIVE_MODE_TABS.register("azurite_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(Items.DIRT))
                    .title(Component.translatable("creativetab.tutorialmod.azurite_items"))
                    .withTabsBefore(CreativeModeTabs.INGREDIENTS)
                    .withTabsAfter(Identifier.fromNamespaceAndPath(TefterCarft.MODID, "azurite_blocks_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
//                                     ITEMS
                    output.accept(new ItemStack(ModItems.TEST_ITEM.get()));
                    output.accept(new ItemStack(ModItems.DIRON.get()));
                    output.accept(new ItemStack(ModItems.PORTAL.get()));
                    output.accept(new ItemStack(ModItems.KABOOM.get()));
                    output.accept(new ItemStack(ModItems.BLOCK_TO_TNT.get()));
                    output.accept(new ItemStack(ModItems.FAll_Block.get()));
                    output.accept(new ItemStack(ModItems.TERIT.get()));
                    output.accept(new ItemStack(ModItems.TERIT_SWORD.get()));
                    output.accept(new ItemStack(ModItems.TERIT_SPEAR.get()));
                    output.accept(new ItemStack(ModItems.TERIT_PICKAXE.get()));
                    output.accept(new ItemStack(ModItems.TERIT_SHOVEL.get()));
                    output.accept(new ItemStack(ModItems.TERIT_HOE.get()));
                    output.accept(new ItemStack(ModItems.TERIT_AXE.get()));
                    output.accept(new ItemStack(ModItems.TEFTBRF.get()));
//                                     BLOCKS
                    output.accept(new ItemStack(ModBlocks.AN_CRAFT_BLOCK));
                    output.accept(new ItemStack(ModBlocks.TEST2_BLOCK));
                    output.accept(new ItemStack(ModBlocks.TEREN));

                    }).build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}