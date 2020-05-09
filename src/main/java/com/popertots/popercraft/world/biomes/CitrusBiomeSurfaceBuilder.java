package com.popertots.popercraft.world.biomes;

import com.mojang.datafixers.Dynamic;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

import java.util.Random;
import java.util.function.Function;

public class CitrusBiomeSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderConfig> {
        public CitrusBiomeSurfaceBuilder(Function<Dynamic<?>, ? extends SurfaceBuilderConfig> function) {
            super(function);
        }

    @Override
    public void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise,
                             BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
        Random rd = new Random();
        int i = rd.nextInt(10);
        if (i == 0) {
            SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight*2, noise, defaultBlock,
                    defaultFluid, seaLevel, seed,
                    new SurfaceBuilderConfig(Blocks.GRASS_BLOCK.getDefaultState(),
                            Blocks.DIRT.getDefaultState(), Blocks.STONE.getDefaultState()));
        } else {
            SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock,
                    defaultFluid, seaLevel, seed,
                    new SurfaceBuilderConfig(
                            i == 1 ? Blocks.DIRT.getDefaultState()
                                    : Blocks.GRASS_BLOCK.getDefaultState(),
                            Blocks.DIRT.getDefaultState(), Blocks.STONE.getDefaultState()));
        }
    }
}
