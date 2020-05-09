package com.popertots.popercraft.world.gen;

import com.popertots.popercraft.world.feature.LimeTree;
import com.popertots.popercraft.world.feature.OrangeTree;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class LimeTreeGen {

    public static void generateTrees() {
        for (Biome biome : ForgeRegistries.BIOMES) {
            biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.NORMAL_TREE
                    .withConfiguration(LimeTree.LIME_TREE_CONFIG)
                    .withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP
                            .configure(new AtSurfaceWithExtraConfig(1, 0, 0))));
        }
    }
}
