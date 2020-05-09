package com.popertots.popercraft.world.gen;

import com.popertots.popercraft.init.BlockInit;
import com.popertots.popercraft.world.feature.LemonTree;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class CitrusTreeGen {

    public static void generateTrees() {
        for (
            Biome biome : ForgeRegistries.BIOMES) {
                biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.NORMAL_TREE
                        .withConfiguration(LemonTree.LEMON_TREE_CONFIG)
                        .withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP
                                .configure(new AtSurfaceWithExtraConfig(1,0.1f,1))));
        }
    }
}
