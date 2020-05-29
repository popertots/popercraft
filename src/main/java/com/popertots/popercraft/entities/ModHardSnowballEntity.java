package com.popertots.popercraft.entities;

import com.popertots.popercraft.init.ItemInit;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.monster.BlazeEntity;
import net.minecraft.entity.passive.SnowGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.SnowballEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class ModHardSnowballEntity extends SnowballEntity {
    public ModHardSnowballEntity(World worldIn, LivingEntity throwerIn) {
        super(worldIn, throwerIn);
    }

    protected Item getDefaultItem() {
        return ItemInit.hard_snowball.get();
    }

    protected void onImpact(RayTraceResult result) {
        if (result.getType() == RayTraceResult.Type.ENTITY) {
            Entity entity = ((EntityRayTraceResult)result).getEntity();
            int i = entity instanceof BlazeEntity ? 6 : entity instanceof ModHostileSnowmanEntity && this.getThrower().getEntity() instanceof ModHostileSnowmanEntity ? 0: 3;
            entity.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), (float)i);
        }

        this.checkDespawn();
        if (!this.world.isRemote) {
            this.world.setEntityState(this, (byte)3);
            this.remove();
        }
    }
}
