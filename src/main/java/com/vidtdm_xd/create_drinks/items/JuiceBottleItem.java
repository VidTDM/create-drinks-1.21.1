package com.vidtdm_xd.create_drinks.items;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

public class JuiceBottleItem extends Item {
    public JuiceBottleItem(Properties properties) {
        super(properties);
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.DRINK;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        ItemStack retval = new ItemStack(Items.GLASS_BOTTLE);
        super.finishUsingItem(stack, level, entity);
        if (stack.isEmpty()) return retval;

        if (entity instanceof Player player && !player.getAbilities().instabuild)
            if (!player.getInventory().add(retval))
                player.drop(retval, false);

        return stack;
    }
}
