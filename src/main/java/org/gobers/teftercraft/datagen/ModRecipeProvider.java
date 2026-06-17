package org.gobers.teftercraft.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import org.gobers.teftercraft.TefterCarft;
import org.gobers.teftercraft.item.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        super(registries, output);
    }

    public static class Runner extends RecipeProvider.Runner {
        public Runner(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> registries) {
            super(packOutput, registries);
        }

        @Override
        protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
            return new ModRecipeProvider(registries, output);
        }

        @Override
        public String getName() {
            return "TutorialMod Recipes";
        }
    }

    @Override
    protected void buildRecipes() {
        shaped(RecipeCategory.COMBAT, ModItems.TERIT_SWORD.get())
                .pattern("A")
                .pattern("A")
                .pattern("S")
                .define('A', ModItems.TERIT.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModItems.TERIT.get()), has(ModItems.TERIT))
                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                .group("azurite")
                .save(output);

        shaped(RecipeCategory.TOOLS, ModItems.TERIT_PICKAXE.get())
                .pattern("AAA")
                .pattern(" S ")
                .pattern(" S ")
                .define('A', ModItems.TERIT.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModItems.TERIT.get()), has(ModItems.TERIT))
                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                .group("azurite")
                .save(output);

        shaped(RecipeCategory.TOOLS, ModItems.TERIT_SHOVEL.get())
                .pattern("A")
                .pattern("S")
                .pattern("S")
                .define('A', ModItems.TERIT.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModItems.TERIT.get()), has(ModItems.TERIT))
                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                .group("azurite")
                .save(output);

        shaped(RecipeCategory.TOOLS, ModItems.TERIT_AXE.get())
                .pattern("AA")
                .pattern("SA")
                .pattern("S ")
                .define('A', ModItems.TERIT.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModItems.TERIT.get()), has(ModItems.TERIT))
                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                .group("azurite")
                .save(output);

        shaped(RecipeCategory.TOOLS, ModItems.TERIT_HOE.get())
                .pattern("AA")
                .pattern("S ")
                .pattern("S ")
                .define('A', ModItems.TERIT.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModItems.TERIT.get()), has(ModItems.TERIT))
                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                .group("azurite")
                .save(output);

        shaped(RecipeCategory.COMBAT, ModItems.TERIT_SPEAR.get())
                .pattern("  A")
                .pattern(" S ")
                .pattern("S  ")
                .define('A', ModItems.TERIT.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModItems.TERIT.get()), has(ModItems.TERIT))
                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                .group("azurite")
                .save(output);
    }
    @Override
    protected <T extends AbstractCookingRecipe> void oreCooking(AbstractCookingRecipe.Factory<T> factory, List<ItemLike> smeltables,
                                                                RecipeCategory craftingCategory, CookingBookCategory cookingCategory, ItemLike result,
                                                                float experience, int cookingTime, String group, String fromDesc) {
        for(ItemLike itemlike : smeltables) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), craftingCategory, cookingCategory, result, experience, cookingTime, factory).group(group).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(output, TefterCarft.MODID + ":" + getItemName(result) + fromDesc + "_" + getItemName(itemlike));
        }
    }
}
