package com.popertots.popercraft.entities;

import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.SnowGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootTables;

import javax.annotation.Nullable;

public class ModHostileSnowmanEntity extends SnowGolemEntity {

    boolean killed = false;

    public ModHostileSnowmanEntity(EntityType<? extends SnowGolemEntity> type, World worldIn) {
        super(type, worldIn);
        setPumpkinEquipped(false);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(1, new RangedAttackGoal(this, 1.25D, 20, 10.0F));
        this.goalSelector.addGoal(2, new WaterAvoidingRandomWalkingGoal(this, 1.0D, 1.0000001E-5F));
        this.goalSelector.addGoal(3, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.addGoal(4, new LookRandomlyGoal(this));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, BlazeEntity.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, PillagerEntity.class, true));
        this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, VillagerEntity.class, true));
    }
    @Nullable
    public ILivingEntityData onInitialSpawn(IWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
        super.onInitialSpawn(worldIn,difficultyIn,reason,spawnDataIn,dataTag);
        if(!worldIn.isRemote() && this.getPosY() < 63){
            this.remove();
        }
        return spawnDataIn;
    }


    public void checkDespawn() {
        if(this.world.getDifficulty() == Difficulty.PEACEFUL) {
            this.remove();
        }
    }

    public void attackEntityWithRangedAttack(LivingEntity target, float distanceFactor) {
        ModHardSnowballEntity snowballentity = new ModHardSnowballEntity(this.world, this);
        double d0 = target.getPosYEye() - (double)1.1F;
        double d1 = target.getPosX() - this.getPosX();
        double d2 = d0 - snowballentity.getPosY();
        double d3 = target.getPosZ() - this.getPosZ();
        float f = MathHelper.sqrt(d1 * d1 + d3 * d3) * 0.2F;
        snowballentity.shoot(d1, d2 + (double)f, d3, 1.6F, 4.0F);
        this.playSound(SoundEvents.ENTITY_SNOW_GOLEM_SHOOT, 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
        this.world.addEntity(snowballentity);
    }

//    public void livingTick() {
//        if (this.isAlive()) {
//            if (this.isInDaylight()) {
//                this.setFire(8);
//            }
//        }
//        super.livingTick();
//    }

    protected ResourceLocation getLootTable() {
        return this.getFireTimer() > 0 ? LootTables.EMPTY : this.getType().getLootTable();
    }
}
