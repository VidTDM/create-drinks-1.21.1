package com.vidtdm_xd.create_drinks.registry;

import com.vidtdm_xd.create_drinks.CreateDrinks;
import com.vidtdm_xd.create_drinks.items.ChorusFruitJuiceItem;
import com.vidtdm_xd.create_drinks.items.JuiceBottleItem;
import com.vidtdm_xd.create_drinks.items.SugarcaneJuiceItem;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(CreateDrinks.MODID);

    public static final DeferredItem<JuiceBottleItem>
            APPLE_JUICE_BOTTLE = registerSimpleJuice("apple_juice_bottle", 6, 2.8f),
            CARROT_JUICE_BOTTLE = registerSimpleJuice("carrot_juice_bottle", 5, 5.0f),
            MELON_JUICE_BOTTLE = registerSimpleJuice("melon_juice_bottle", 5, 5.0f),
            SWEET_BERRY_JUICE_BOTTLE = registerSimpleJuice("sweet_berry_juice_bottle", 4, 1.8f);

    public static final DeferredItem<ChorusFruitJuiceItem> CHORUS_FRUIT_JUICE_BOTTLE = ITEMS.register("chorus_fruit_juice_bottle",
            () -> new ChorusFruitJuiceItem(new Item.Properties().stacksTo(16).food(new FoodProperties.Builder()
                    .nutrition(6)
                    .saturationModifier(3.0f)
                    .alwaysEdible().build())));

    public static final DeferredItem<SugarcaneJuiceItem> SUGARCANE_JUICE_BOTTLE = ITEMS.register("sugarcane_juice_bottle",
            () -> new SugarcaneJuiceItem(new Item.Properties().stacksTo(16).food(new FoodProperties.Builder()
                    .nutrition(5)
                    .saturationModifier(5.4f)
                    .alwaysEdible().build())));

    public static final DeferredItem<JuiceBottleItem> GLOW_BERRY_JUICE_BOTTLE = ITEMS.register("glow_berry_juice_bottle",
            () -> new JuiceBottleItem(new Item.Properties().stacksTo(16).food(new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationModifier(1.8f)
                    .effect(() -> new MobEffectInstance(MobEffects.GLOWING, 180), 1f)
                    .alwaysEdible().build())));

    public static final DeferredItem<BlockItem> APPLE_CRATE = ITEMS.register("apple_crate",
            () -> new BlockItem(ModBlocks.APPLE_CRATE.get(), new Item.Properties()));

    private static DeferredItem<JuiceBottleItem> registerSimpleJuice(String name, int nutrition, float saturationMod) {
        return ITEMS.register(name, () -> new JuiceBottleItem(new Item.Properties()
                .stacksTo(16)
                .food(new FoodProperties.Builder()
                        .nutrition(nutrition)
                        .saturationModifier(saturationMod).build())));
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
