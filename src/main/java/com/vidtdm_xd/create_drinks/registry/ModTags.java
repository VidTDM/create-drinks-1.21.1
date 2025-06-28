package com.vidtdm_xd.create_drinks.registry;

import com.vidtdm_xd.create_drinks.CreateDrinks;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModTags {
    public static class Items {
        public static final TagKey<Item> JUICE_BOTTLES = ItemTags.create(ResourceLocation.fromNamespaceAndPath(CreateDrinks.MODID, "juice_bottles"));
    }
}
