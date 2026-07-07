package org.gobers.teftercraft;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import org.gobers.teftercraft.datagen.ModItemTagsProvider;
import org.gobers.teftercraft.datagen.ModModelProvider;
import org.gobers.teftercraft.datagen.ModRecipeProvider;
import org.gobers.teftercraft.datagen.ModWorldGenProvider;

@EventBusSubscriber(modid = TefterCarft.MODID)
public class TefterCraftDataGen {

    @SubscribeEvent
    public static void gatherClientData(GatherDataEvent.Client event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        var lookupProvider = event.getLookupProvider();

        generator.addProvider(true, new ModModelProvider(packOutput));

        generator.addProvider(true, new ModRecipeProvider.Runner(packOutput, lookupProvider));
        generator.addProvider(true, new ModItemTagsProvider(packOutput, lookupProvider));

        generator.addProvider(true, new ModWorldGenProvider(packOutput, lookupProvider));
    }
}
