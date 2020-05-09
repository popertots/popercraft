package com.popertots.popercraft.world.gen;



import com.popertots.popercraft.init.BlockInit;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class malachiteOreGen {

	public static void generateOre() {
		for(Biome biome : ForgeRegistries.BIOMES) {
			ConfiguredPlacement customConfig = Placement.COUNT_RANGE.configure(new CountRangeConfig(2,96,0,32)); // chance, minimum, 0, range
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE
					.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockInit.malachite_ore.get().getDefaultState(),5))
					.withPlacement(customConfig));
			ConfiguredPlacement customConfig2 = Placement.COUNT_RANGE.configure(new CountRangeConfig(1,64,0,32)); // chance, minimum, 0, range
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE
					.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockInit.malachite_ore.get().getDefaultState(),2))
					.withPlacement(customConfig2));
			ConfiguredPlacement customConfig3 = Placement.COUNT_RANGE.configure(new CountRangeConfig(2,128,0,32)); // chance, minimum, 0, range
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE
					.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockInit.malachite_ore.get().getDefaultState(),2))
					.withPlacement(customConfig3));
		}
	}
}
