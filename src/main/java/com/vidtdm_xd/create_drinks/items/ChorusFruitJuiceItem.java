package com.vidtdm_xd.create_drinks.items;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Fox;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.event.EventHooks;
import net.neoforged.neoforge.event.entity.EntityTeleportEvent;

public class ChorusFruitJuiceItem extends JuiceBottleItem {
    public ChorusFruitJuiceItem(Properties properties) {
        super(properties);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
        ItemStack retval = new ItemStack(Items.GLASS_BOTTLE);
        super.finishUsingItem(itemstack, world, entity);

        if (!world.isClientSide) {
            double d0 = entity.getX();
            double d1 = entity.getY();
            double d2 = entity.getZ();

            for (int i = 0; i < 32; ++i) {
                double d3 = entity.getX() + (entity.getRandom().nextDouble() - 0.5D) * 32.0D;
                double d4 = Mth.clamp(entity.getY() + (double) (entity.getRandom().nextInt(32) - 8),
                        (double) world.getMinBuildHeight(),
                        (double) (world.getMinBuildHeight() + ((ServerLevel) world).getLogicalHeight() - 1));
                double d5 = entity.getZ() + (entity.getRandom().nextDouble() - 0.5D) * 32.0D;
                if (entity.isPassenger()) {
                    entity.stopRiding();
                }

                Vec3 vec3 = entity.position();
                world.gameEvent(GameEvent.TELEPORT, vec3, GameEvent.Context.of(entity));
                EntityTeleportEvent.ChorusFruit event = EventHooks.onChorusFruitTeleport(entity, d3, d4, d5);
                // if (event.isCanceled()) return itemstack;
                if (event.isCanceled())
                    break;
                if (entity.randomTeleport(event.getTargetX(), event.getTargetY(), event.getTargetZ(), true)) {
                    SoundEvent soundevent = entity instanceof Fox ? SoundEvents.FOX_TELEPORT
                            : SoundEvents.CHORUS_FRUIT_TELEPORT;
                    world.playSound((Player) null, d0, d1, d2, soundevent, SoundSource.PLAYERS, 1.0F, 1.0F);
                    entity.playSound(soundevent, 1.0F, 1.0F);
                    break;
                }
            }

            if (entity instanceof Player) {
                ((Player)entity).getCooldowns().addCooldown(this, 20);
            }
        }

        if (itemstack.isEmpty()) {
            return retval;
        } else {
            if (entity instanceof Player player && !player.getAbilities().instabuild) {
                if (!player.getInventory().add(retval))
                    player.drop(retval, false);
            }
            return itemstack;
        }
    }
}
