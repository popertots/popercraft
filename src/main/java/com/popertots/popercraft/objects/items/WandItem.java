package com.popertots.popercraft.objects.items;

import com.popertots.popercraft.entities.ThrowableFlameEntity;
import com.popertots.popercraft.init.ModEntityTypes;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.EnderPearlItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

public class WandItem extends Item {
    public WandItem(Properties properties) {
        super(properties);
    }

//    public void onUse(World worldIn, LivingEntity livingEntityIn, ItemStack stack, int count) {
//        if(!worldIn.isRemote){
//            ThrowableFlameEntity fire = new ThrowableFlameEntity(EntityType.ENDER_PEARL,livingEntityIn,worldIn);
//            fire.addVelocity(livingEntityIn.getLookVec().getX(),livingEntityIn.getLookVec().getY(),livingEntityIn.getLookVec().getZ());
//            fire.setPosition(livingEntityIn.getPosX(),livingEntityIn.getPosY(),livingEntityIn.getPosZ());
//            worldIn.playSound((PlayerEntity)null, livingEntityIn.getPosX(), livingEntityIn.getPosY(), livingEntityIn.getPosZ(), SoundEvents.ENTITY_TNT_PRIMED, SoundCategory.PLAYERS, 1.0F, (1.0F  / (random.nextFloat() * 0.4F + 1.2F)  * 0.5F));
//            worldIn.addEntity(fire);
//        }
//    }

    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        if(!worldIn.isRemote){
            ThrowableFlameEntity fire = new ThrowableFlameEntity(ModEntityTypes.flame_projectile.get(),playerIn,worldIn);
            //fire.addVelocity(playerIn.getLookVec().getX()*5,playerIn.getLookVec().getY()*5,playerIn.getLookVec().getZ()*5);
            fire.setPosition(playerIn.getPosX(),playerIn.getPosY()+ playerIn.getEyeHeight(),playerIn.getPosZ());
            fire.shoot(playerIn,playerIn.getPitchYaw().x,playerIn.getPitchYaw().y,playerIn.getEyeHeight(),2,2);
            worldIn.playSound((PlayerEntity)null, playerIn.getPosX(), playerIn.getPosY() + playerIn.getEyeHeight(), playerIn.getPosZ(), SoundEvents.ENTITY_TNT_PRIMED, SoundCategory.PLAYERS, 1.0F, (1.0F  / (random.nextFloat() * 0.4F + 1.2F)  * 0.5F));
            worldIn.addEntity(fire);
            //playerIn.getCooldownTracker().setCooldown(this, 10);
            return ActionResult.resultSuccess(playerIn.getHeldItem(handIn));
        }
        return ActionResult.resultPass(playerIn.getHeldItem(handIn));
    }

}
