package com.popertots.popercraft.world.biomes;

import com.popertots.popercraft.init.BlockInit;
import com.popertots.popercraft.world.feature.LemonTree;
import com.popertots.popercraft.world.feature.LimeTree;
import com.popertots.popercraft.world.feature.OrangeTree;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.GrassColors;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placement.*;

public class CitrusBiome extends Biome {

    public CitrusBiome(Builder biomeBuilder) {
        super(biomeBuilder);
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.CHICKEN, 20, 2, 10));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.PIG, 5, 1, 3));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.COW, 5, 1, 3));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.ENDERMAN, 15, 3, 5));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.CREEPER, 15, 1, 2));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.ZOMBIE, 5, 1, 2));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.SKELETON, 5, 1, 2));
        this.addCarver(GenerationStage.Carving.AIR,
                Biome.createCarver(WorldCarver.CAVE, new ProbabilityConfig(0.14285715F)));
        this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                Feature.RANDOM_BOOLEAN_SELECTOR
                        .withConfiguration(new TwoFeatureChoiceConfig(
                                Feature.NORMAL_TREE.withConfiguration(OrangeTree.ORANGE_TREE_CONFIG),
                                Feature.NORMAL_TREE.withConfiguration(LimeTree.LIME_TREE_CONFIG)))
                        .withPlacement(Placement.COUNT_HEIGHTMAP.configure(new FrequencyConfig(1))));


        this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                Feature.NORMAL_TREE.withConfiguration(LemonTree.LEMON_TREE_CONFIG).withPlacement(
                        Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(1, 0.1f, 1))));

        DefaultBiomeFeatures.addOres(this);
        DefaultBiomeFeatures.addDefaultFlowers(this);
        this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(DefaultBiomeFeatures.GRASS_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(10))));
        this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.SPRING_FEATURE.withConfiguration(DefaultBiomeFeatures.WATER_SPRING_CONFIG).withPlacement(Placement.COUNT_BIASED_RANGE.configure(new CountRangeConfig(250, 5, 20, 2048))));
    }
}
