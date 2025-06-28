package com.vidtdm_xd.create_drinks.datagen.recipes;

import com.vidtdm_xd.create_drinks.registry.ModBlocks;
import com.vidtdm_xd.create_drinks.registry.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.tags.ItemTags;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.concurrent.CompletableFuture;

public class VanillaRecipeGen extends RecipeProvider implements IConditionBuilder {
    public VanillaRecipeGen(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.APPLE_JUICE.get())
                .pattern("bb")
                .pattern("pp")
                .pattern("pp")
                .define('b', ModTags.Items.JUICE_BOTTLES)
                .define('p', ItemTags.PLANKS)
                .unlockedBy("has", has(ItemTags.PLANKS)).save(recipeOutput);
    }
}
