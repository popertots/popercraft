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

public class mithrilOreGen {

	public static void generateOre() {
		for(Biome biome : ForgeRegistries.BIOMES) {
			ConfiguredPlacement customConfig = Placement.COUNT_RANGE.configure(new CountRangeConfig(4,20,0,28)); // chance, minimum, 0, range
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE
					.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockInit.mithril_ore.get().getDefaultState(),4))
					.withPlacement(customConfig));
		}
	}
}
