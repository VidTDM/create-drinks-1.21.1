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

    public static final DeferredHolder<FluidType, FluidType> APPLE_JUICE_TYPE = FLUID_TYPES.register("apple_juice", () -> new FluidType(FluidType.Properties.create())),
        CARROT_JUICE_TYPE = FLUID_TYPES.register("carrot_juice", () -> new FluidType(FluidType.Properties.create())),
        GLOW_BERRY_JUICE_TYPE = FLUID_TYPES.register("glow_berry_juice", () -> new FluidType(FluidType.Properties.create())),
        SWEET_BERRY_JUICE_TYPE = FLUID_TYPES.register("sweet_berry_juice", () -> new FluidType(FluidType.Properties.create())),
        SUGARCANE_JUICE_TYPE = FLUID_TYPES.register("sugarcane_juice", () -> new FluidType(FluidType.Properties.create())),
        MELON_JUICE_TYPE = FLUID_TYPES.register("melon_juice", () -> new FluidType(FluidType.Properties.create())),
        CHORUS_FRUIT_JUICE_TYPE = FLUID_TYPES.register("chorus_fruit_juice", () -> new FluidType(FluidType.Properties.create()));

    public static void register(IEventBus eventBus) {
        FLUID_TYPES.register(eventBus);
        eventBus.addListener(ModFluidTypes::registerClientExtensions);
    }

    private static void registerClientExtensions(RegisterClientExtensionsEvent e) {
        e.registerFluidType(new IClientFluidTypeExtensions() {
            @Override
            public ResourceLocation getStillTexture() { return ResourceLocation.fromNamespaceAndPath(MODID, "block/apple_juice_still"); }
            @Override
            public ResourceLocation getFlowingTexture() { return ResourceLocation.fromNamespaceAndPath(MODID, "block/apple_juice_flow"); }
        }, ModFluidTypes.APPLE_JUICE_TYPE.get());
        e.registerFluidType(new IClientFluidTypeExtensions() {
            @Override
            public ResourceLocation getStillTexture() { return ResourceLocation.fromNamespaceAndPath(MODID, "block/carrot_juice_still"); }
            @Override
            public ResourceLocation getFlowingTexture() { return ResourceLocation.fromNamespaceAndPath(MODID, "block/carrot_juice_flow"); }
        }, ModFluidTypes.CARROT_JUICE_TYPE.get());
        e.registerFluidType(new IClientFluidTypeExtensions() {
            @Override
            public ResourceLocation getStillTexture() { return ResourceLocation.fromNamespaceAndPath(MODID, "block/glow_berry_juice_still"); }
            @Override
            public ResourceLocation getFlowingTexture() { return ResourceLocation.fromNamespaceAndPath(MODID, "block/glow_berry_juice_flow"); }
        }, ModFluidTypes.GLOW_BERRY_JUICE_TYPE.get());
        e.registerFluidType(new IClientFluidTypeExtensions() {
            @Override
            public ResourceLocation getStillTexture() { return ResourceLocation.fromNamespaceAndPath(MODID, "block/sweet_berry_juice_still"); }
            @Override
            public ResourceLocation getFlowingTexture() { return ResourceLocation.fromNamespaceAndPath(MODID, "block/sweet_berry_juice_flow"); }
        }, ModFluidTypes.SWEET_BERRY_JUICE_TYPE.get());
        e.registerFluidType(new IClientFluidTypeExtensions() {
            @Override
            public ResourceLocation getStillTexture() { return ResourceLocation.fromNamespaceAndPath(MODID, "block/sugarcane_juice_still"); }
            @Override
            public ResourceLocation getFlowingTexture() { return ResourceLocation.fromNamespaceAndPath(MODID, "block/sugarcane_juice_flow"); }
        }, ModFluidTypes.SUGARCANE_JUICE_TYPE.get());
        e.registerFluidType(new IClientFluidTypeExtensions() {
            @Override
            public ResourceLocation getStillTexture() { return ResourceLocation.fromNamespaceAndPath(MODID, "block/melon_juice_still"); }
            @Override
            public ResourceLocation getFlowingTexture() { return ResourceLocation.fromNamespaceAndPath(MODID, "block/melon_juice_flow"); }
        }, ModFluidTypes.MELON_JUICE_TYPE.get());
        e.registerFluidType(new IClientFluidTypeExtensions() {
            @Override
            public ResourceLocation getStillTexture() { return ResourceLocation.fromNamespaceAndPath(MODID, "block/chorus_fruit_juice_still"); }
            @Override
            public ResourceLocation getFlowingTexture() { return ResourceLocation.fromNamespaceAndPath(MODID, "block/chorus_fruit_juice_flow"); }
        }, ModFluidTypes.CHORUS_FRUIT_JUICE_TYPE.get());
    }
}
