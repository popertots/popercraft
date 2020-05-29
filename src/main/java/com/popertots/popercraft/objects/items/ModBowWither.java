package com.popertots.popercraft.objects.items;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.WitherSkullEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.stats.Stats;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ModBowWither extends ModBow {

    public ModBowWither(Properties builder, int Tier) {
        super(builder,Tier);
    }

    public boolean hasEffect(ItemStack stack) {
        return true;
    }

    public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        super.inventoryTick(stack,worldIn,entityIn,itemSlot,isSelected);
        if (entityIn instanceof PlayerEntity) {
            PlayerEntity playerentity = (PlayerEntity)entityIn;
            if(playerentity.getHeldItemMainhand().getItem() instanceof ModBowWither || playerentity.getHeldItemOffhand().getItem() instanceof ModBowWither){
                playerentity.addPotionEffect(new EffectInstance(Effects.WITHER,20));
            }
        }
    }


    public void onPlayerStoppedUsing(ItemStack stack, World worldIn, LivingEntity entityLiving, int timeLeft) {
        if (entityLiving instanceof PlayerEntity) {
            PlayerEntity playerentity = (PlayerEntity)entityLiving;
            boolean flag = playerentity.abilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantments.INFINITY, stack) > 0;
            ItemStack itemstack = playerentity.findAmmo(stack);

            int i = this.getUseDuration(stack) - timeLeft;
            i = net.minecraftforge.event.ForgeEventFactory.onArrowLoose(stack, worldIn, playerentity, i, !itemstack.isEmpty() || flag);
            if (i < 0) return;

            if (itemstack.getCount() >= Tier || flag) {
                if (itemstack.isEmpty()) {
                    itemstack = new ItemStack(Items.ARROW);
                }

                float f = getArrowVelocity(i);
                if(f==1.0)f*=(1+(0.25*(Tier-1)));
                if (!((double)f < 0.75D)) {
                    boolean flag1 = playerentity.abilities.isCreativeMode || (itemstack.getItem() instanceof ArrowItem && ((ArrowItem)itemstack.getItem()).isInfinite(itemstack, stack, playerentity));
                    if (!worldIn.isRemote) {
                        for(int co = 0;co < 5; co++) {
                            worldIn.playEvent((PlayerEntity) null, 1024, new BlockPos(playerentity), 0);
                            double d0 = playerentity.getPosX();
                            double d1 = playerentity.getPosY() + 1.5;
                            double d2 = playerentity.getPosZ();

                            WitherSkullEntity witherskullentity = new WitherSkullEntity(worldIn, playerentity, playerentity.getLookVec().x * 100 * f + (worldIn.rand.nextFloat()-0.5)*(5*co), playerentity.getLookVec().y * 50 * f + (worldIn.rand.nextFloat()-0.5)*(5*co), playerentity.getLookVec().z * 100 * f + (worldIn.rand.nextFloat()-0.5)*(5*co));
                            witherskullentity.setPosition(d0, d1, d2);
                            worldIn.addEntity(witherskullentity);
                        }
                    }

                    worldIn.playSound((PlayerEntity)null, playerentity.getPosX(), playerentity.getPosY(), playerentity.getPosZ(), SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.PLAYERS, 1.0F, (1.0F + (Tier*0.2f))  / (random.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
                    if (!flag1 && !playerentity.abilities.isCreativeMode) {
                        itemstack.shrink(Tier);
                        if (itemstack.isEmpty()) {
                            playerentity.inventory.deleteStack(itemstack);
                        }
                    }
                    playerentity.addStat(Stats.ITEM_USED.get(this));
                }
            }
        }
    }
}
