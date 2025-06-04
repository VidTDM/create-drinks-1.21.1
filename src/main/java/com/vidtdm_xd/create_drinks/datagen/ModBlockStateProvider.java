package com.vidtdm_xd.create_drinks.datagen;

import com.vidtdm_xd.create_drinks.CreateDrinks;
import com.vidtdm_xd.create_drinks.registry.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelBuilder;
import net.neoforged.neoforge.client.model.generators.VariantBlockStateBuilder;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, CreateDrinks.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        liquidBlock(ModBlocks.APPLE_JUICE, "apple_juice");
    }

    private void liquidBlock(DeferredBlock<? extends LiquidBlock> block, String name) {
        ResourceLocation modelLoc = modLoc("block/" + name);
        VariantBlockStateBuilder builder = getVariantBuilder(block.get());

        for (int i = 0; i <= 15; i++) {
            builder.partialState()
                    .with(BlockStateProperties.LEVEL, i)
                    .modelForState()
                    .modelFile(models().getExistingFile(modelLoc))
                    .addModel();
        }
        ModelBuilder<?> modelBuilder = models().getBuilder(name);
        modelBuilder.texture("particle", modLoc("block/" + name + "_still"));
    }
}
