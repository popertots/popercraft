package com.popertots.popercraft.enchantments;

import com.popertots.popercraft.Popercraft;
import com.popertots.popercraft.init.EnchantmentInit;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class LastChanceEnchantment extends Enchantment {
    public LastChanceEnchantment(Rarity rarityIn, EnchantmentType typeIn, EquipmentSlotType[] slots) {
        super(rarityIn, typeIn, slots);
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }

    @Override
    public int getMinLevel() {
        return 1;
    }

    @Mod.EventBusSubscriber(modid = Popercraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
    public static class EscapistEquipped {

        @SubscribeEvent
        public static void doStuff(LivingHurtEvent event) {
            if(event.getEntityLiving() instanceof PlayerEntity) {
                PlayerEntity playerIn = (PlayerEntity) event.getEntityLiving();
                int head = EnchantmentHelper.getEnchantmentLevel(EnchantmentInit.last_chance.get(), playerIn.getItemStackFromSlot(EquipmentSlotType.HEAD));
                int chest = EnchantmentHelper.getEnchantmentLevel(EnchantmentInit.last_chance.get(), playerIn.getItemStackFromSlot(EquipmentSlotType.CHEST));
                int legs = EnchantmentHelper.getEnchantmentLevel(EnchantmentInit.last_chance.get(), playerIn.getItemStackFromSlot(EquipmentSlotType.LEGS));
                int feet = EnchantmentHelper.getEnchantmentLevel(EnchantmentInit.last_chance.get(), playerIn.getItemStackFromSlot(EquipmentSlotType.FEET));
                if (head > 0 ||
                        chest > 0 ||
                        legs > 0 ||
                        feet > 0) {
                    if(playerIn.getHealth()<event.getAmount()){
                        event.setAmount(event.getAmount()/(head+chest+legs+feet+1));
                        if(event.getSource().getTrueSource() instanceof LivingEntity){
                            LivingEntity attacker = (LivingEntity)event.getSource().getTrueSource();
                            attacker.knockBack(playerIn,1.5f,playerIn.getPosX()-attacker.getPosX(),playerIn.getPosZ()-attacker.getPosZ());
                            playerIn.knockBack(attacker,1.5f,attacker.getPosX()-playerIn.getPosX(),attacker.getPosZ()-playerIn.getPosZ());
                            for(int j = 0; j < 128; ++j) {
                                double d0 = (double)j / 127.0D;
                                float f = (playerIn.world.rand.nextFloat() - 0.5F) * 0.2F;
                                float f1 = (playerIn.world.rand.nextFloat() - 0.5F) * 0.2F;
                                float f2 = (playerIn.world.rand.nextFloat() - 0.5F) * 0.2F;
                                double d1 = MathHelper.lerp(d0, playerIn.prevPosX, playerIn.getPosX()) + (playerIn.world.rand.nextDouble() - 0.5D) * (double)playerIn.getWidth() * 2.0D;
                                double d2 = MathHelper.lerp(d0, playerIn.prevPosY, playerIn.getPosY()) + playerIn.world.rand.nextDouble() * (double)playerIn.getHeight();
                                double d3 = MathHelper.lerp(d0, playerIn.prevPosZ, playerIn.getPosZ()) + (playerIn.world.rand.nextDouble() - 0.5D) * (double)playerIn.getWidth() * 2.0D;
                                playerIn.world.addParticle(ParticleTypes.CAMPFIRE_COSY_SMOKE, d1, d2, d3, (double)f, (double)f1, (double)f2);
                            }
                            playerIn.world.playSound((PlayerEntity)null, playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), SoundEvents.ENTITY_FIREWORK_ROCKET_LAUNCH, SoundCategory.PLAYERS, 1.0F, 1f);
                        }
                    }
                }
            }
        }
    }

}
