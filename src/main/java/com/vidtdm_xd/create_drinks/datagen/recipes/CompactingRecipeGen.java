package com.vidtdm_xd.create_drinks.datagen.recipes;

import com.simibubi.create.AllRecipeTypes;
import com.simibubi.create.foundation.data.recipe.ProcessingRecipeGen;
import com.simibubi.create.foundation.recipe.IRecipeTypeInfo;
import com.vidtdm_xd.create_drinks.registry.ModFluids;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;

import java.util.concurrent.CompletableFuture;

import static com.vidtdm_xd.create_drinks.CreateDrinks.MODID;

public class CompactingRecipeGen extends ProcessingRecipeGen {
    GeneratedRecipe
        APPLE_JUICE = create(ResourceLocation.fromNamespaceAndPath(MODID,"apple_juice"),
                b -> b.require(Items.APPLE)
                        .require(Items.SUGAR)
                        .output(ModFluids.APPLE_JUICE.get(), 250)),
        CARROT_JUICE = create(ResourceLocation.fromNamespaceAndPath(MODID, "carrot_juice"),
                b -> b.require(Items.CARROT)
                        .require(Items.SUGAR)
                        .output(ModFluids.CARROT_JUICE.get(), 250)),
        GLOW_BERRY_JUICE = create(ResourceLocation.fromNamespaceAndPath(MODID, "glow_berry_juice"),
                b -> b.require(Items.GLOW_BERRIES)
                        .require(Items.SUGAR)
                        .output(ModFluids.GLOW_BERRY_JUICE.get(), 250)),
        SWEET_BERRY_JUICE = create(ResourceLocation.fromNamespaceAndPath(MODID, "sweet_berry_juice"),
                b -> b.require(Items.SWEET_BERRIES)
                        .require(Items.SUGAR)
                        .output(ModFluids.SWEET_BERRY_JUICE.get(), 250)),
        SUGARCANE_JUICE = create(ResourceLocation.fromNamespaceAndPath(MODID, "sugarcane_juice"),
                b -> b.require(Items.SUGAR_CANE)
                      .output(ModFluids.SUGARCANE_JUICE.get(), 250)),
        MELON_JUICE = create(ResourceLocation.fromNamespaceAndPath(MODID, "melon_juice"),
                b -> b.require(Items.MELON)
                        .require(Items.SUGAR)
                        .output(ModFluids.MELON_JUICE.get(), 250)),
        CHORUS_FRUIT_JUICE = create(ResourceLocation.fromNamespaceAndPath(MODID, "chorus_fruit_juice"),
                b -> b.require(Items.CHORUS_FRUIT)
                        .require(Items.SUGAR)
                        .output(ModFluids.CHORUS_FRUIT_JUICE.get(), 250));

    public CompactingRecipeGen(PackOutput generator, CompletableFuture<HolderLookup.Provider> registries) {
        super(generator, registries);
    }

    @Override
    protected IRecipeTypeInfo getRecipeType() {
        return AllRecipeTypes.COMPACTING;
    }
}
