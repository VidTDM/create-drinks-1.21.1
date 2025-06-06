package com.vidtdm_xd.create_drinks.datagen.recipes;

import com.simibubi.create.AllRecipeTypes;
import com.simibubi.create.foundation.data.recipe.ProcessingRecipeGen;
import com.simibubi.create.foundation.recipe.IRecipeTypeInfo;
import com.vidtdm_xd.create_drinks.registry.ModFluids;
import com.vidtdm_xd.create_drinks.registry.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;

import java.util.concurrent.CompletableFuture;

import static com.vidtdm_xd.create_drinks.CreateDrinks.MODID;

public class EmptyingRecipeGen extends ProcessingRecipeGen {
    GeneratedRecipe
            APPLE_JUICE = create(ResourceLocation.fromNamespaceAndPath(MODID,"apple_juice"),
                    b -> b.require(ModItems.APPLE_JUICE_BOTTLE).output(ModFluids.APPLE_JUICE.get(), 250)
                            .output(Items.GLASS_BOTTLE)),
            CARROT_JUICE = create(ResourceLocation.fromNamespaceAndPath(MODID, "carrot_juice"),
                    b -> b.require(ModItems.CARROT_JUICE_BOTTLE).output(ModFluids.CARROT_JUICE.get(), 250)
                            .output(Items.GLASS_BOTTLE)),
            GLOW_BERRY_JUICE = create(ResourceLocation.fromNamespaceAndPath(MODID, "glow_berry_juice"),
                    b -> b.require(ModItems.GLOW_BERRY_JUICE_BOTTLE).output(ModFluids.GLOW_BERRY_JUICE.get(), 250)
                            .output(Items.GLASS_BOTTLE)),
            SWEET_BERRY_JUICE = create(ResourceLocation.fromNamespaceAndPath(MODID, "sweet_berry_juice"),
                    b -> b.require(ModItems.SWEET_BERRY_JUICE_BOTTLE).output(ModFluids.SWEET_BERRY_JUICE.get(), 250)
                            .output(Items.GLASS_BOTTLE)),
            SUGARCANE_JUICE = create(ResourceLocation.fromNamespaceAndPath(MODID, "sugarcane_juice"),
                    b -> b.require(ModItems.SUGARCANE_JUICE_BOTTLE).output(ModFluids.SUGARCANE_JUICE.get(), 250)
                            .output(Items.GLASS_BOTTLE)),
            MELON_JUICE = create(ResourceLocation.fromNamespaceAndPath(MODID, "melon_juice"),
                    b -> b.require(ModItems.MELON_JUICE_BOTTLE).output(ModFluids.MELON_JUICE.get(), 250)
                            .output(Items.GLASS_BOTTLE)),
            CHORUS_FRUIT_JUICE = create(ResourceLocation.fromNamespaceAndPath(MODID, "chorus_fruit_juice"),
                    b -> b.require(ModItems.CHORUS_FRUIT_JUICE_BOTTLE).output(ModFluids.CHORUS_FRUIT_JUICE.get(), 250)
                            .output(Items.GLASS_BOTTLE));

    public EmptyingRecipeGen(PackOutput generator, CompletableFuture<HolderLookup.Provider> registries) {
        super(generator, registries);
    }

    @Override
    protected IRecipeTypeInfo getRecipeType() {
        return AllRecipeTypes.EMPTYING;
    }
}
