package com.vidtdm_xd.create_drinks.registry;

import com.vidtdm_xd.create_drinks.CreateDrinks;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlocks {
    private static final BlockBehaviour.Properties waterCopy = BlockBehaviour.Properties.ofFullCopy(Blocks.WATER);
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(CreateDrinks.MODID);

    public static final DeferredBlock<LiquidBlock> APPLE_JUICE =
            BLOCKS.register("apple_juice", () -> new LiquidBlock(ModFluids.APPLE_JUICE.get(), waterCopy)),
            CARROT_JUICE = BLOCKS.register("carrot_juice", () -> new LiquidBlock(ModFluids.CARROT_JUICE.get(), waterCopy)),
            GLOW_BERRY_JUICE = BLOCKS.register("glow_berry_juice", () -> new LiquidBlock(ModFluids.GLOW_BERRY_JUICE.get(), waterCopy)),
            SWEET_BERRY_JUICE = BLOCKS.register("sweet_berry_juice", () -> new LiquidBlock(ModFluids.SWEET_BERRY_JUICE.get(), waterCopy)),
            SUGARCANE_JUICE = BLOCKS.register("sugarcane_juice", () -> new LiquidBlock(ModFluids.SUGARCANE_JUICE.get(), waterCopy)),
            MELON_JUICE = BLOCKS.register("melon_juice", () -> new LiquidBlock(ModFluids.MELON_JUICE.get(), waterCopy)),
            CHORUS_FRUIT_JUICE = BLOCKS.register("chorus_fruit_juice", () -> new LiquidBlock(ModFluids.CHORUS_FRUIT_JUICE.get(), waterCopy));

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
