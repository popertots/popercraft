package com.popertots.popercraft.entities;

import com.popertots.popercraft.init.ItemInit;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ItemParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ThrowableFlameEntity extends ProjectileItemEntity {
    public ThrowableFlameEntity(EntityType<? extends ProjectileItemEntity> type, LivingEntity livingEntityIn, World worldIn) {
        super(type, livingEntityIn, worldIn);
        this.setNoGravity(true);
    }

    public ThrowableFlameEntity(EntityType<ThrowableFlameEntity> throwableFlameEntityEntityType, World world) {
        super(throwableFlameEntityEntityType,world);
        this.setNoGravity(true);
    }

    @Override
    protected Item getDefaultItem() {
        return ItemInit.flame_projectile_item.get();
    }

    @Override
    protected void onImpact(RayTraceResult result) {
        if(!this.world.isRemote){
            //this.world.createExplosion(this,this.getPosX(),this.getPosY(),this.getPosZ(),4, Explosion.Mode.BREAK);
            this.world.setEntityState(this, (byte)3);
        }
        this.remove();
    }

    @OnlyIn(Dist.CLIENT)
    private IParticleData makeParticle() {
        ItemStack itemstack = this.func_213882_k();
        return (IParticleData)(itemstack.isEmpty() ? ParticleTypes.FLAME : new ItemParticleData(ParticleTypes.ITEM, itemstack));
    }

    /**
     * Handler for {@link World#setEntityState}
     */
    @OnlyIn(Dist.CLIENT)
    public void handleStatusUpdate(byte id) {
        if (id == 3) {
            IParticleData iparticledata = this.makeParticle();

            for(int i = 0; i < 8; ++i) {
                this.world.addParticle(iparticledata, this.getPosX(), this.getPosY(), this.getPosZ(), 0.0D, 0.0D, 0.0D);
            }
        }

    }
}
