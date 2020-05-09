package com.popertots.popercraft.world.gen;


import com.popertots.popercraft.Popercraft;

import com.popertots.popercraft.init.BlockInit;
import net.minecraft.block.Blocks;
import net.minecraft.block.pattern.BlockMatcher;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class orichalcumOreGen {

	public static void generateOre() {
		for(Biome biome : ForgeRegistries.BIOMES) {
			if(biome == Biomes.RIVER) {
				ConfiguredPlacement customConfig = Placement.COUNT_RANGE.configure(new CountRangeConfig(7,55,0,8));
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE
						.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.create(Popercraft.MOD_ID+": DIRT", null, new BlockMatcher(Blocks.DIRT)), BlockInit.orichalcum_ore.get().getDefaultState(),3))
						.withPlacement(customConfig));
			}
			if(biome == Biomes.SWAMP) {
				ConfiguredPlacement customConfig = Placement.COUNT_RANGE.configure(new CountRangeConfig(4,55,0,8));
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE
						.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.create(Popercraft.MOD_ID+": DIRT", null, new BlockMatcher(Blocks.DIRT)), BlockInit.orichalcum_ore.get().getDefaultState(),5))
						.withPlacement(customConfig));
			}
		}
	}
}
