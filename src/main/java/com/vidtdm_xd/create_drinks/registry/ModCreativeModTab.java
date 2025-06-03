package com.vidtdm_xd.create_drinks.registry;

import com.vidtdm_xd.create_drinks.CreateDrinks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.Set;
import java.util.function.Supplier;

public class ModCreativeModTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CreateDrinks.MODID);

    private static final Set<DeferredItem<? extends Item>> EXCLUDED_ITEMS = Set.of();

    public static final Supplier<CreativeModeTab> CREATE_DRINKS_TAB = CREATIVE_MODE_TAB.register("create_drinks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.APPLE_JUICE_BOTTLE.get()))
                    .title(Component.translatable("creativetab.create_drinks.create_drinks_tab"))
                    .displayItems((params, output) -> {
                        ModItems.ITEMS.getEntries().forEach(item -> {
                            if (!EXCLUDED_ITEMS.contains(item)) output.accept(item.get());
                        });
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
