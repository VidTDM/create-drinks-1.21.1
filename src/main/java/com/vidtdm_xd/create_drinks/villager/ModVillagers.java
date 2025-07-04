package com.vidtdm_xd.create_drinks.villager;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
//import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllSoundEvents;
import com.vidtdm_xd.create_drinks.CreateDrinks;
import com.vidtdm_xd.create_drinks.registry.ModBlocks;
import com.vidtdm_xd.create_drinks.registry.ModItems;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModVillagers {
    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(BuiltInRegistries.POINT_OF_INTEREST_TYPE, CreateDrinks.MODID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
            DeferredRegister.create(BuiltInRegistries.VILLAGER_PROFESSION, CreateDrinks.MODID);

    public static final Holder<PoiType> FRUIT_VENDOR_POI = POI_TYPES.register("fruit_vendor_poi",
            () -> new PoiType(ImmutableSet.copyOf(ModBlocks.APPLE_CRATE.get().getStateDefinition().getPossibleStates()), 1, 1));
    public static final Holder<VillagerProfession> FRUIT_VENDOR = VILLAGER_PROFESSIONS.register("fruit_vendor",
            () -> new VillagerProfession("fruit_vendor", holder -> holder.value() == FRUIT_VENDOR_POI.value(),
                    poiTypeHolder -> poiTypeHolder.value() == FRUIT_VENDOR_POI.value(), ImmutableSet.of(), ImmutableSet.of(),
                    AllSoundEvents.SPOUTING.getMainEvent()));

    public static void fillTradeData() {
        VillagerTrades.ItemListing[] lvl1 = new VillagerTrades.ItemListing[] {
                new VillagerTrades.EmeraldForItems(Items.GLOW_BERRIES, 15, 16, 2),
                new VillagerTrades.EmeraldForItems(Items.SWEET_BERRIES, 26, 16, 2),
                new VillagerTrades.EmeraldForItems(Items.MELON_SLICE, 22, 16, 2),
                new VillagerTrades.ItemsForEmeralds(Items.SUGAR_CANE, 3, 3, 16, 2),
        };
        VillagerTrades.ItemListing[] lvl2 = new VillagerTrades.ItemListing[] {
                new VillagerTrades.ItemsAndEmeraldsToItems(Items.APPLE, 1, 1, ModItems.APPLE_JUICE_BOTTLE.get(), 1, 16, 5, 0.05f),
                new VillagerTrades.ItemsAndEmeraldsToItems(Items.MELON_SLICE, 1, 1, ModItems.MELON_JUICE_BOTTLE.get(), 1, 16, 5, 0.05f),
                new VillagerTrades.ItemsAndEmeraldsToItems(Items.SWEET_BERRIES, 1, 1, ModItems.SWEET_BERRY_JUICE_BOTTLE.get(), 1, 16, 5, 0.05f),
                new VillagerTrades.ItemsAndEmeraldsToItems(Items.CARROT, 1, 1, ModItems.CARROT_JUICE_BOTTLE.get(), 1, 16, 5, 0.05f),
        };
        VillagerTrades.ItemListing[] lvl3 = new VillagerTrades.ItemListing[] {
                new VillagerTrades.ItemsAndEmeraldsToItems(Items.SUGAR_CANE, 1, 2, ModItems.SUGARCANE_JUICE_BOTTLE.get(), 1, 12, 10, 0.05f),
                new VillagerTrades.ItemsAndEmeraldsToItems(Items.GLOW_BERRIES, 1, 2, ModItems.GLOW_BERRY_JUICE_BOTTLE.get(), 1, 12, 10, 0.05f),
                new VillagerTrades.ItemsForEmeralds(Items.SUGAR, 1, 4, 16, 10)
        };
        VillagerTrades.ItemListing[] lvl4 = new VillagerTrades.ItemListing[] {
                new VillagerTrades.ItemsAndEmeraldsToItems(Items.CHORUS_FRUIT, 1, 2, ModItems.CHORUS_FRUIT_JUICE_BOTTLE.get(), 1, 6, 15, 0.05f),
        };
        VillagerTrades.ItemListing[] lvl5 = new VillagerTrades.ItemListing[] {
                new VillagerTrades.ItemsForEmeralds(Items.GOLDEN_APPLE, 5, 3, 16, 30),
                new VillagerTrades.ItemsForEmeralds(Items.GOLDEN_CARROT, 3, 3, 16, 30),
        };
        VillagerTrades.TRADES.put(FRUIT_VENDOR.value(), new Int2ObjectOpenHashMap<>(ImmutableMap.of(1, lvl1, 2, lvl2, 3, lvl3, 4, lvl4, 5, lvl5)));
    }

    public static void register(IEventBus bus) {
        POI_TYPES.register(bus);
        VILLAGER_PROFESSIONS.register(bus);
    }
}
