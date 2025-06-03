package com.vidtdm_xd.create_drinks.registry;

import com.vidtdm_xd.create_drinks.CreateDrinks;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class ModFluidTypes {
    public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister.create(NeoForgeRegistries.FLUID_TYPES, CreateDrinks.MODID);

    public static void register(IEventBus eventBus) {
        FLUID_TYPES.register(eventBus);
    }
}
