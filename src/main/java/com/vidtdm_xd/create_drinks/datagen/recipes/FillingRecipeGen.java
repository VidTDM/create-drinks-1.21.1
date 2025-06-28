package com.vidtdm_xd.create_drinks.datagen.recipes;

import com.vidtdm_xd.create_drinks.registry.ModFluids;
import com.vidtdm_xd.create_drinks.registry.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;

import java.util.concurrent.CompletableFuture;

import static com.vidtdm_xd.create_drinks.CreateDrinks.MODID;

@SuppressWarnings("unused")
public class FillingRecipeGen extends com.simibubi.create.api.data.recipe.FillingRecipeGen {
    GeneratedRecipe
            APPLE_JUICE = create(ResourceLocation.fromNamespaceAndPath(MODID,"apple_juice"),
            b -> b.output(ModItems.APPLE_JUICE_BOTTLE).require(ModFluids.APPLE_JUICE.get(), 250)
                    .require(Items.GLASS_BOTTLE)),
            CARROT_JUICE = create(ResourceLocation.fromNamespaceAndPath(MODID, "carrot_juice"),
                    b -> b.output(ModItems.CARROT_JUICE_BOTTLE).require(ModFluids.CARROT_JUICE.get(), 250)
                            .require(Items.GLASS_BOTTLE)),
            GLOW_BERRY_JUICE = create(ResourceLocation.fromNamespaceAndPath(MODID, "glow_berry_juice"),
                    b -> b.output(ModItems.GLOW_BERRY_JUICE_BOTTLE).require(ModFluids.GLOW_BERRY_JUICE.get(), 250)
                            .require(Items.GLASS_BOTTLE)),
            SWEET_BERRY_JUICE = create(ResourceLocation.fromNamespaceAndPath(MODID, "sweet_berry_juice"),
                    b -> b.output(ModItems.SWEET_BERRY_JUICE_BOTTLE).require(ModFluids.SWEET_BERRY_JUICE.get(), 250)
                            .require(Items.GLASS_BOTTLE)),
            SUGARCANE_JUICE = create(ResourceLocation.fromNamespaceAndPath(MODID, "sugarcane_juice"),
                    b -> b.output(ModItems.SUGARCANE_JUICE_BOTTLE).require(ModFluids.SUGARCANE_JUICE.get(), 250)
                            .require(Items.GLASS_BOTTLE)),
            MELON_JUICE = create(ResourceLocation.fromNamespaceAndPath(MODID, "melon_juice"),
                    b -> b.output(ModItems.MELON_JUICE_BOTTLE).require(ModFluids.MELON_JUICE.get(), 250)
                            .require(Items.GLASS_BOTTLE)),
            CHORUS_FRUIT_JUICE = create(ResourceLocation.fromNamespaceAndPath(MODID, "chorus_fruit_juice"),
                    b -> b.output(ModItems.CHORUS_FRUIT_JUICE_BOTTLE).require(ModFluids.CHORUS_FRUIT_JUICE.get(), 250)
                            .require(Items.GLASS_BOTTLE));

    public FillingRecipeGen(PackOutput generator, CompletableFuture<HolderLookup.Provider> registries) {
        super(generator, registries, MODID);
    }
}
