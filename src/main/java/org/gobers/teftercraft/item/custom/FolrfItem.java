package org.gobers.teftercraft.item.custom;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class FolrfItem extends Item {

    private static FoodProperties foodProperties = new FoodProperties(10,12,true);

    public FolrfItem(Properties properties) {

        properties.food(foodProperties);

        super(properties);
    }


}
