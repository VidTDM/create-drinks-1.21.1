package com.vidtdm_xd.create_drinks.items;

import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class SugarcaneJuiceItem extends JuiceBottleItem {
    public SugarcaneJuiceItem(Properties properties) {
        super(properties);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
        ItemStack retval = new ItemStack(Items.GLASS_BOTTLE);
        super.finishUsingItem(itemstack, world, entity);

        if (!world.isClientSide) {
            entity.removeEffect(MobEffects.WEAKNESS);
            entity.removeEffect(MobEffects.DIG_SLOWDOWN);
            entity.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
        }

        if (itemstack.isEmpty()) return retval;

        if (entity instanceof Player player && !player.getAbilities().instabuild)
            if (!player.getInventory().add(retval))
                player.drop(retval, false);

        return itemstack;
    }
}
