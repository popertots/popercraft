package com.popertots.popercraft.init;

import com.popertots.popercraft.Popercraft;
import com.popertots.popercraft.world.biomes.CitrusBiome;
import com.popertots.popercraft.world.biomes.CitrusBiomeSurfaceBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.ISurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BiomeInit {

    public static final DeferredRegister<Biome> BIOMES = new DeferredRegister<>(ForgeRegistries.BIOMES,
            Popercraft.MOD_ID);

    public static final RegistryObject<Biome> CITRUS_BIOME = BIOMES
            .register("citrus_biome",
                    () -> new CitrusBiome(
                            new Biome.Builder().precipitation(Biome.RainType.RAIN).scale(.01f).temperature(0.75f)
                                    .waterColor(0x00abed).waterFogColor(0xafe0e7)
                                    .surfaceBuilder(
                                            new ConfiguredSurfaceBuilder<SurfaceBuilderConfig>(
                                                    register("citrus_surface",
                                                            new CitrusBiomeSurfaceBuilder(
                                                                    SurfaceBuilderConfig::deserialize)),
                                                    new SurfaceBuilderConfig(Blocks.GRASS_BLOCK.getDefaultState(),
                                                            Blocks.DIRT.getDefaultState(),
                                                            Blocks.STONE.getDefaultState())))
                                    .category(Biome.Category.FOREST).downfall(0.5f).depth(0.125f).parent(null)));

    public static void registerBiomes() {
        registerBiome(CITRUS_BIOME.get(), Type.FOREST, Type.OVERWORLD);
    }

    private static void registerBiome(Biome biome, Type... types) {
        // the line below will make it spawn in the overworld
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(biome, 10));
        BiomeDictionary.addTypes(biome, types);
        BiomeManager.addSpawnBiome(biome);
    }

    @SuppressWarnings("deprecation")
    private static <C extends ISurfaceBuilderConfig, F extends SurfaceBuilder<C>> F register(String key, F builderIn) {
        return (F) (Registry.<SurfaceBuilder<?>>register(Registry.SURFACE_BUILDER, key, builderIn));
    }

}
