package com.popertots.popercraft.objects.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

public class EndriumBlock extends Block {
    public EndriumBlock(Properties properties) {
        super(properties);
    }

    @Override
    public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
        return 5;
        //return Blocks.COAL_BLOCK.getFlammability(state,world,pos,face);
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
        return 5;
        //return Blocks.COAL_BLOCK.getFireSpreadSpeed(state,world,pos,face);
    }
}
