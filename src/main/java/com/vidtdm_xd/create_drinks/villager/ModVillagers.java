package com.vidtdm_xd.create_drinks.villager;

import com.google.common.collect.ImmutableSet;
import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllSoundEvents;
import com.vidtdm_xd.create_drinks.CreateDrinks;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModVillagers {
    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(BuiltInRegistries.POINT_OF_INTEREST_TYPE, CreateDrinks.MODID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
            DeferredRegister.create(BuiltInRegistries.VILLAGER_PROFESSION, CreateDrinks.MODID);

    public static final Holder<PoiType> FRUIT_VENDOR_POI = POI_TYPES.register("fruit_vendor_poi",
            () -> new PoiType(ImmutableSet.copyOf(AllBlocks.BASIN.get().getStateDefinition().getPossibleStates()), 1, 1));
    public static final Holder<VillagerProfession> FRUIT_VENDOR = VILLAGER_PROFESSIONS.register("fruit_vendor",
            () -> new VillagerProfession("fruit_vendor", holder -> holder.value() == FRUIT_VENDOR_POI.value(),
                    poiTypeHolder -> poiTypeHolder.value() == FRUIT_VENDOR_POI.value(), ImmutableSet.of(), ImmutableSet.of(),
                    AllSoundEvents.SPOUTING.getMainEvent()));

    public static void register(IEventBus bus) {
        POI_TYPES.register(bus);
        VILLAGER_PROFESSIONS.register(bus);
    }
}
