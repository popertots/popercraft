package com.popertots.popercraft.entities;

import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.monster.SlimeEntity;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootTables;

import javax.annotation.Nullable;

public class ModSlimeEntity extends SlimeEntity {

    private static final DataParameter<Integer> SLIME_COLOR = EntityDataManager.<Integer>createKey(ModSlimeEntity.class, DataSerializers.VARINT);

    public ModSlimeEntity(EntityType<? extends SlimeEntity> type, World worldIn) {
        super(type, worldIn);
    }
//    protected boolean isDespawnPeaceful() {
//        return this.getSlimeSize() > 0;
//    }

    protected boolean isDespawnPeaceful() {
        return false;
    }

    protected int getJumpDelay() {
        return this.rand.nextInt(20) + 5 + (this.getSlimeSize()*2);
    }

    @Nullable
    public ILivingEntityData onInitialSpawn(IWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
        int slimeSize = (int) (this.rand.nextGaussian() * 2) + 1;
        if (slimeSize < 0)
            slimeSize *= -1;
        if (this.rand.nextInt(500) == 0) {
            slimeSize = 15;
        }
        this.setSlimeSize(slimeSize, true);
        if(slimeSize>5) {
            this.experienceValue *= 5;
        }
        this.getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).applyModifier(new AttributeModifier("Random spawn bonus", this.rand.nextGaussian() * 0.05D, AttributeModifier.Operation.MULTIPLY_BASE));
        if (this.rand.nextFloat() < 0.05F) {
            this.setLeftHanded(true);
        } else {
            this.setLeftHanded(false);
        }

        return spawnDataIn;
    }

    protected ResourceLocation getLootTable() {
        return this.getSlimeSize() >= 3 ? this.getType().getLootTable() : LootTables.EMPTY;
    }

    public float[] getSlimeColor()
    {
        //int hexcol = ((Integer)this.dataManager.get(SLIME_COLOR)).intValue();
        int hexcol = this.rand.nextInt(0xffffff);
        float r1 = ((hexcol & 0xFF0000) >> 16);
        float g1 = ((hexcol & 0xFF00) >> 8);
        float b1 = (hexcol & 0xFF);
        return new float[] {r1/255f,g1/255f,b1/255f};
    }

    public void setSlimeColor(int Color)
    {
        this.dataManager.set(SLIME_COLOR, Integer.valueOf(Color));
    }

    public int getSlimeColorHex()
    {
        return ((Integer)this.dataManager.get(SLIME_COLOR)).intValue();
    }
}
