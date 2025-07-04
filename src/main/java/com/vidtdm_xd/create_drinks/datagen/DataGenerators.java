package com.vidtdm_xd.create_drinks.datagen;

import com.simibubi.create.api.data.recipe.ProcessingRecipeGen;
import com.vidtdm_xd.create_drinks.CreateDrinks;
import com.vidtdm_xd.create_drinks.datagen.recipes.CompactingRecipeGen;
import com.vidtdm_xd.create_drinks.datagen.recipes.EmptyingRecipeGen;
import com.vidtdm_xd.create_drinks.datagen.recipes.FillingRecipeGen;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = CreateDrinks.MODID, bus = EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    protected static final List<ProcessingRecipeGen<?, ?, ?>> GENERATORS = new ArrayList<>();

    @SubscribeEvent
    public static void gatherData(GatherDataEvent e) {
        DataGenerator generator = e.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = e.getExistingFileHelper();

        GENERATORS.add(new CompactingRecipeGen(packOutput, e.getLookupProvider()));
        GENERATORS.add(new EmptyingRecipeGen(packOutput, e.getLookupProvider()));
        GENERATORS.add(new FillingRecipeGen(packOutput, e.getLookupProvider()));

        generator.addProvider(e.includeClient(), new ModItemModelProvider(packOutput, existingFileHelper));
        generator.addProvider(e.includeClient(), new ModBlockStateProvider(packOutput, existingFileHelper));

        generator.addProvider(e.includeClient(), new DataProvider() {
            @Override
            public CompletableFuture<?> run(CachedOutput cachedOutput) {
                return CompletableFuture.allOf(GENERATORS.stream()
                        .map(gen -> gen.run(cachedOutput))
                        .toArray(CompletableFuture[]::new));
            }

            @Override
            public String getName() {
                return "Create: Drinks's recipe datagen";
            }
        });
    }
}
