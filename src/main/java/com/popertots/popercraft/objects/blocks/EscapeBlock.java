package com.popertots.popercraft.objects.blocks;

import com.popertots.popercraft.init.ItemInit;
import com.popertots.popercraft.objects.items.RingItem;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class EscapeBlock extends Block {
    public EscapeBlock(Properties properties) {
        super(properties);
    }
}
