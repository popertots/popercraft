package com.popertots.popercraft.objects.items;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.MilkBucketItem;
import net.minecraft.item.UseAction;
import net.minecraft.stats.Stats;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

public class bowl_food_item extends MilkBucketItem{

	public bowl_food_item(Properties properties) {
		super(properties);
	}
	
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
		PlayerEntity playerentity = entityLiving instanceof PlayerEntity ? (PlayerEntity)entityLiving : null;
	      if (playerentity instanceof ServerPlayerEntity) {
	         CriteriaTriggers.CONSUME_ITEM.trigger((ServerPlayerEntity)playerentity, stack);
	      }

	      if (playerentity != null) {
	         playerentity.addStat(Stats.ITEM_USED.get(this));
	         if (!playerentity.abilities.isCreativeMode) {
	            stack.shrink(1);
	         }
	      }

	      if (playerentity == null || !playerentity.abilities.isCreativeMode) {
	         if (stack.isEmpty()) {
	            return new ItemStack(Items.BOWL);
	         }

	         if (playerentity != null) {
	            playerentity.inventory.addItemStackToInventory(new ItemStack(Items.BOWL));
	         }
	      }

	      return entityLiving.onFoodEaten(worldIn, stack);
	}
	
	public UseAction getUseAction(ItemStack stack) {
	      return UseAction.DRINK;
	}
	
	public SoundEvent getDrinkSound() {
	      return SoundEvents.ENTITY_GENERIC_DRINK;
	}
}
