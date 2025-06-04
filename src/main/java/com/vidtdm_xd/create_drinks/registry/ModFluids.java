package com.vidtdm_xd.create_drinks.registry;

import com.vidtdm_xd.create_drinks.CreateDrinks;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModFluids {
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(Registries.FLUID, CreateDrinks.MODID);

    public static final DeferredHolder<Fluid, FlowingFluid> APPLE_JUICE = FLUIDS.register("apple_juice", () -> new BaseFlowingFluid.Source(ModFluids.APPLE_JUICE_PROPERTIES)),
            APPLE_JUICE_FLOWING = FLUIDS.register("apple_juice_flowing", () -> new BaseFlowingFluid.Flowing(ModFluids.APPLE_JUICE_PROPERTIES));
    public static final BaseFlowingFluid.Properties APPLE_JUICE_PROPERTIES = new BaseFlowingFluid.Properties(ModFluidTypes.APPLE_JUICE_TYPE, APPLE_JUICE, APPLE_JUICE_FLOWING).block(ModBlocks.APPLE_JUICE);

    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }
}
