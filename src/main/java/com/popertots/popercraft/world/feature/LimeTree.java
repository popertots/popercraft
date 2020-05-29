package com.popertots.popercraft.world.feature;

import com.popertots.popercraft.init.BlockInit;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraftforge.common.IPlantable;

import javax.annotation.Nullable;
import java.util.Random;

public class LimeTree extends Tree {

    public static final TreeFeatureConfig LIME_TREE_CONFIG = (new TreeFeatureConfig.Builder(
            new SimpleBlockStateProvider(BlockInit.lime_log.get().getDefaultState()),
            new SimpleBlockStateProvider(BlockInit.lime_leaves.get().getDefaultState()),
            new BlobFoliagePlacer(3, 0))).baseHeight(6).heightRandA(2).foliageHeight(3).ignoreVines()
            .setSapling((IPlantable) BlockInit.lime_sapling.get()).build();


    @Nullable
    @Override
    protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean p_225546_2_) {
         return Feature.NORMAL_TREE.withConfiguration(LIME_TREE_CONFIG);
    }
}
