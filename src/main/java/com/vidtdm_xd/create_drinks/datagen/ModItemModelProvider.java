package com.vidtdm_xd.create_drinks.datagen;

import com.vidtdm_xd.create_drinks.CreateDrinks;
import com.vidtdm_xd.create_drinks.registry.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, CreateDrinks.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.APPLE_JUICE_BOTTLE.get());
        basicItem(ModItems.CARROT_JUICE_BOTTLE.get());
        basicItem(ModItems.MELON_JUICE_BOTTLE.get());
        basicItem(ModItems.SWEET_BERRY_JUICE_BOTTLE.get());
        basicItem(ModItems.CHORUS_FRUIT_JUICE_BOTTLE.get());
        basicItem(ModItems.SUGARCANE_JUICE_BOTTLE.get());
        basicItem(ModItems.GLOW_BERRY_JUICE_BOTTLE.get());
    }
}
