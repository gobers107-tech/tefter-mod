package org.gobers.teftercraft.item;


import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.gobers.teftercraft.TefterCarft;
import org.gobers.teftercraft.item.custom.*;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TefterCarft.MODID);

    public static final DeferredItem<Item> TEST_ITEM = ITEMS.registerSimpleItem("test");
    public static final DeferredItem<Item> DIRON = ITEMS.registerItem("diron", DironItem::new);
    public static final DeferredItem<Item> PORTAL = ModItems.ITEMS.registerItem("portal", properties -> new BlockItem(Blocks.NETHER_PORTAL,properties));
    public static final DeferredItem<Item> KABOOM = ModItems.ITEMS.registerItem("kaboom", KaboomItem::new);
    public static final DeferredItem<Item> BLOCK_TO_TNT = ModItems.ITEMS.registerItem("block_to_tnt", BlockToTntItem::new);
    public static final DeferredItem<Item> FAll_Block = ModItems.ITEMS.registerItem("fall_block", FallBlockItem::new);
    public static final DeferredItem<Item> TEFTBRF = ModItems.ITEMS.registerItem("TEFTBRF".toLowerCase(), TeftnrfItem::new);
    public static final DeferredItem<Item> TERIT = ModItems.ITEMS.registerItem("terit", (properties) -> new Item(properties));


    public static final DeferredItem<Item> TERIT_SWORD = ITEMS.registerItem("terit_sword",
            properties -> new Item(properties.sword(ModToolRirs.TERIT, 3, -2.4f)));
    public static final DeferredItem<Item> TERIT_PICKAXE = ITEMS.registerItem("terit_pickaxe",
            properties -> new Item(properties.pickaxe(ModToolRirs.TERIT, 1, -2.8f)));
    public static final DeferredItem<Item> TERIT_SHOVEL = ITEMS.registerItem("terit_shovel",
            properties -> new ShovelItem(ModToolRirs.TERIT, 1.5f, -3.0f, properties));
    public static final DeferredItem<Item> TERIT_AXE = ITEMS.registerItem("terit_axe",
            properties -> new AxeItem(ModToolRirs.TERIT, 6, -3.2f, properties));
    public static final DeferredItem<Item> TERIT_HOE = ITEMS.registerItem("terit_hoe",
            properties -> new HoeItem(ModToolRirs.TERIT, 0, -3.0f, properties));
    public static final DeferredItem<Item> TERIT_SPEAR = ITEMS.registerItem("terit_spear",
            properties -> new Item(properties.spear(ModToolRirs.TERIT, 0.95f, 0.7f, 0.7f,
                    3.5f, 13f, 8.5f, 5.1f, 13.37f, 4.67f)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
