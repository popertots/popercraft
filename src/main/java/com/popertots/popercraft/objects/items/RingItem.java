package com.popertots.popercraft.objects.items;

import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.monster.EndermanEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class RingItem extends Item {
    public RingItem(Properties properties) {
        super(properties);
    }

    public boolean hasEffect(ItemStack stack) {
        return true;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        playerIn.addPotionEffect(new EffectInstance(Effects.STRENGTH,20*30,3));
        playerIn.addPotionEffect(new EffectInstance(Effects.SPEED,20*30,3));
        playerIn.setHealth(1);
        playerIn.addPotionEffect(new EffectInstance(Effects.INVISIBILITY,20*30));
        if(!worldIn.isRemote){
            ServerWorld sw = (ServerWorld)worldIn;
            sw.addLightningBolt(new LightningBoltEntity(worldIn,playerIn.getPosX(),playerIn.getPosY(),playerIn.getPosZ(),false));
        }
        for(int i = 0; i < 64; i++) {
            if (teleportRandomly(worldIn, playerIn)) {
                break;
            }
        }
        playerIn.getHeldItemMainhand().shrink(1);
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }

    protected boolean teleportRandomly(World worldIn, LivingEntity livingEntityIn) {
        if (!worldIn.isRemote() && livingEntityIn.isAlive()) {
            double d0 = livingEntityIn.getPosX() + (worldIn.rand.nextDouble() - 0.5D) * 64.0D;
            double d1 = livingEntityIn.getPosY() + (double)(worldIn.rand.nextInt(64) - 32);
            double d2 = livingEntityIn.getPosZ() + (worldIn.rand.nextDouble() - 0.5D) * 64.0D;
            return this.teleportTo(d0, d1, d2, worldIn, livingEntityIn);
        } else {
            return false;
        }
    }

    private boolean teleportTo(double x, double y, double z, World worldIn, LivingEntity livingEntityIn) {
        BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable(x, y, z);

        while(blockpos$mutable.getY() > 0 && !worldIn.getBlockState(blockpos$mutable).getMaterial().blocksMovement()) {
            blockpos$mutable.move(Direction.DOWN);
        }

        BlockState blockstate = worldIn.getBlockState(blockpos$mutable);
        boolean flag = blockstate.getMaterial().blocksMovement();
        boolean flag1 = blockstate.getFluidState().isTagged(FluidTags.WATER);
        if (flag && !flag1) {
            net.minecraftforge.event.entity.living.EnderTeleportEvent event = new net.minecraftforge.event.entity.living.EnderTeleportEvent(livingEntityIn, x, y, z, 0);
            if (net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(event)) return false;
            boolean flag2 = livingEntityIn.attemptTeleport(event.getTargetX(), event.getTargetY(), event.getTargetZ(), true);
            if (flag2) {
                worldIn.playSound((PlayerEntity)null, livingEntityIn.prevPosX, livingEntityIn.prevPosY, livingEntityIn.prevPosZ, SoundEvents.ENTITY_ENDERMAN_TELEPORT, livingEntityIn.getSoundCategory(), 1.0F, 1.0F);
                livingEntityIn.playSound(SoundEvents.ENTITY_ENDERMAN_TELEPORT, 1.0F, 1.0F);
            }

            return flag2;
        } else {
            return false;
        }
    }

}
