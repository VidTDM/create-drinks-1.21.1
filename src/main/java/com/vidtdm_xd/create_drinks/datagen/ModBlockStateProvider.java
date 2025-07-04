package com.vidtdm_xd.create_drinks.datagen;

import com.vidtdm_xd.create_drinks.CreateDrinks;
import com.vidtdm_xd.create_drinks.registry.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.neoforged.neoforge.client.model.generators.*;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, CreateDrinks.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        liquidBlock(ModBlocks.APPLE_JUICE, "apple_juice");
        liquidBlock(ModBlocks.CARROT_JUICE, "carrot_juice");
        liquidBlock(ModBlocks.GLOW_BERRY_JUICE, "glow_berry_juice");
        liquidBlock(ModBlocks.SWEET_BERRY_JUICE, "sweet_berry_juice");
        liquidBlock(ModBlocks.SUGARCANE_JUICE, "sugarcane_juice");
        liquidBlock(ModBlocks.MELON_JUICE, "melon_juice");
        liquidBlock(ModBlocks.CHORUS_FRUIT_JUICE, "chorus_fruit_juice");
        cubeBottomTop(ModBlocks.APPLE_CRATE, "apple_crate");
    }

    private void liquidBlock(DeferredBlock<? extends LiquidBlock> block, String name) {
        VariantBlockStateBuilder builder = getVariantBuilder(block.get());

        ModelBuilder<?> modelBuilder = models().getBuilder(name);
        modelBuilder.texture("particle", modLoc("block/" + name + "_still"));
        for (int i = 0; i <= 15; i++) {
            builder.partialState()
                    .with(BlockStateProperties.LEVEL, i)
                    .modelForState()
                    .modelFile(models().getExistingFile(modLoc("block/" + name)))
                    .addModel();
        }
    }

    private void cubeBottomTop(DeferredBlock<Block> block, String name) {
        ModelFile model = models().cubeBottomTop(name, modLoc("block/" + name + "_side"), modLoc("block/" + name + "_bottom"), modLoc("block/" + name + "_top"));
        getVariantBuilder(block.get()).partialState().setModels(new ConfiguredModel(model));
        simpleBlockItem(block.get(), model);
    }
}
