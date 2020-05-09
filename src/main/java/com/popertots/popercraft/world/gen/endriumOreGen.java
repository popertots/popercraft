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

public class endriumOreGen {

	public static void generateOre() {
		for(Biome biome : ForgeRegistries.BIOMES) {
			if (biome == Biomes.THE_END || biome == Biomes.SMALL_END_ISLANDS || biome == Biomes.END_BARRENS || biome == Biomes.END_HIGHLANDS || biome == Biomes.END_MIDLANDS) {
				ConfiguredPlacement customConfig = Placement.COUNT_RANGE.configure(new CountRangeConfig(25, 48, 0, 80)); // chance, minimum, 0, range
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE
						.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.create(Popercraft.MOD_ID + ": ENDSTONE", null, new BlockMatcher(Blocks.END_STONE)), BlockInit.endrium_ore.get().getDefaultState(), 3))
						.withPlacement(customConfig));
			}
		}
	}
}
