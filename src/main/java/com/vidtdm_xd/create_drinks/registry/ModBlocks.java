package com.vidtdm_xd.create_drinks.registry;

import com.vidtdm_xd.create_drinks.CreateDrinks;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(CreateDrinks.MODID);

    public static final DeferredBlock<LiquidBlock> APPLE_JUICE = BLOCKS.register("apple_juice",
            () -> new LiquidBlock(ModFluids.APPLE_JUICE.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.WATER)));

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
