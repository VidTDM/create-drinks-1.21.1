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

    public static final DeferredHolder<Fluid, FlowingFluid>
            APPLE_JUICE = FLUIDS.register("apple_juice", () -> new BaseFlowingFluid.Source(ModFluids.APPLE_JUICE_PROPERTIES)),
            CARROT_JUICE = FLUIDS.register("carrot_juice", () -> new BaseFlowingFluid.Source(ModFluids.CARROT_JUICE_PROPERTIES)),
            GLOW_BERRY_JUICE = FLUIDS.register("glow_berry_juice", () -> new BaseFlowingFluid.Source(ModFluids.GLOW_BERRY_JUICE_PROPERTIES)),
            SWEET_BERRY_JUICE = FLUIDS.register("sweet_berry_juice", () -> new BaseFlowingFluid.Source(ModFluids.SWEET_BERRY_JUICE_PROPERTIES)),
            SUGARCANE_JUICE = FLUIDS.register("sugarcane_juice", () -> new BaseFlowingFluid.Source(ModFluids.SUGARCANE_JUICE_PROPERTIES)),
            MELON_JUICE = FLUIDS.register("melon_juice", () -> new BaseFlowingFluid.Source(ModFluids.MELON_JUICE_PROPERTIES)),
            CHORUS_FRUIT_JUICE = FLUIDS.register("chorus_fruit_juice", () -> new BaseFlowingFluid.Source(ModFluids.CHORUS_FRUIT_JUICE_PROPERTIES));

    public static final DeferredHolder<Fluid, FlowingFluid>
            APPLE_JUICE_FLOWING = FLUIDS.register("apple_juice_flowing", () -> new BaseFlowingFluid.Flowing(ModFluids.APPLE_JUICE_PROPERTIES)),
            CARROT_JUICE_FLOWING = FLUIDS.register("carrot_juice_flowing", () -> new BaseFlowingFluid.Flowing(ModFluids.CARROT_JUICE_PROPERTIES)),
            GLOW_BERRY_JUICE_FLOWING = FLUIDS.register("glow_berry_juice_flowing", () -> new BaseFlowingFluid.Flowing(ModFluids.GLOW_BERRY_JUICE_PROPERTIES)),
            SWEET_BERRY_JUICE_FLOWING = FLUIDS.register("sweet_berry_juice_flowing", () -> new BaseFlowingFluid.Flowing(ModFluids.SWEET_BERRY_JUICE_PROPERTIES)),
            SUGARCANE_JUICE_FLOWING = FLUIDS.register("sugarcane_juice_flowing", () -> new BaseFlowingFluid.Flowing(ModFluids.SUGARCANE_JUICE_PROPERTIES)),
            MELON_JUICE_FLOWING = FLUIDS.register("melon_juice_flowing", () -> new BaseFlowingFluid.Flowing(ModFluids.MELON_JUICE_PROPERTIES)),
            CHORUS_FRUIT_JUICE_FLOWING = FLUIDS.register("chorus_fruit_juice_flowing", () -> new BaseFlowingFluid.Flowing(ModFluids.CHORUS_FRUIT_JUICE_PROPERTIES));

    public static final BaseFlowingFluid.Properties
            APPLE_JUICE_PROPERTIES = new BaseFlowingFluid.Properties(ModFluidTypes.APPLE_JUICE_TYPE, APPLE_JUICE, APPLE_JUICE_FLOWING).block(ModBlocks.APPLE_JUICE),
            CARROT_JUICE_PROPERTIES = new BaseFlowingFluid.Properties(ModFluidTypes.CARROT_JUICE_TYPE, CARROT_JUICE, CARROT_JUICE_FLOWING).block(ModBlocks.CARROT_JUICE),
            GLOW_BERRY_JUICE_PROPERTIES = new BaseFlowingFluid.Properties(ModFluidTypes.GLOW_BERRY_JUICE_TYPE, GLOW_BERRY_JUICE, GLOW_BERRY_JUICE_FLOWING).block(ModBlocks.GLOW_BERRY_JUICE),
            SWEET_BERRY_JUICE_PROPERTIES = new BaseFlowingFluid.Properties(ModFluidTypes.SWEET_BERRY_JUICE_TYPE, SWEET_BERRY_JUICE, SWEET_BERRY_JUICE_FLOWING).block(ModBlocks.SWEET_BERRY_JUICE),
            SUGARCANE_JUICE_PROPERTIES = new BaseFlowingFluid.Properties(ModFluidTypes.SUGARCANE_JUICE_TYPE, SUGARCANE_JUICE, SUGARCANE_JUICE_FLOWING).block(ModBlocks.SUGARCANE_JUICE),
            MELON_JUICE_PROPERTIES = new BaseFlowingFluid.Properties(ModFluidTypes.MELON_JUICE_TYPE, MELON_JUICE, MELON_JUICE_FLOWING).block(ModBlocks.MELON_JUICE),
            CHORUS_FRUIT_JUICE_PROPERTIES = new BaseFlowingFluid.Properties(ModFluidTypes.CHORUS_FRUIT_JUICE_TYPE, CHORUS_FRUIT_JUICE, CHORUS_FRUIT_JUICE_FLOWING).block(ModBlocks.CHORUS_FRUIT_JUICE);


    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }
}
