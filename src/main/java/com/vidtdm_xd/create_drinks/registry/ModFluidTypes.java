package com.vidtdm_xd.create_drinks.registry;

import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import static com.vidtdm_xd.create_drinks.CreateDrinks.MODID;

public class ModFluidTypes {
    public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister.create(NeoForgeRegistries.FLUID_TYPES, MODID);

    public static final DeferredHolder<FluidType, FluidType> APPLE_JUICE_TYPE = FLUID_TYPES.register("apple_juice", () -> new FluidType(FluidType.Properties.create()));

    public static void register(IEventBus eventBus) {
        FLUID_TYPES.register(eventBus);
        eventBus.addListener(ModFluidTypes::registerClientExtensions);
    }

    private static void registerClientExtensions(RegisterClientExtensionsEvent e) {
        e.registerFluidType(new IClientFluidTypeExtensions() {
            @Override
            public ResourceLocation getStillTexture() {
                return ResourceLocation.fromNamespaceAndPath(MODID, "blocks/apple_juice_still");
            }

            @Override
            public ResourceLocation getFlowingTexture() {
                return ResourceLocation.fromNamespaceAndPath(MODID, "blocks/apple_juice_flow");
            }
        }, ModFluidTypes.APPLE_JUICE_TYPE.get());
    }
}
