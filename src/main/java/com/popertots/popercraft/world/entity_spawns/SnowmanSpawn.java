package com.popertots.popercraft.world.entity_spawns;

import com.popertots.popercraft.entities.ModHostileSnowmanEntity;
import com.popertots.popercraft.init.ModEntityTypes;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.registries.ForgeRegistries;

public class SnowmanSpawn {

    public static void generateSpawn() {
        for(Biome biome : ForgeRegistries.BIOMES) {
            if(biome.getDefaultTemperature()<=0) {
                biome.getSpawns(EntityClassification.CREATURE).add(new Biome.SpawnListEntry(ModEntityTypes.mod_snowman.get(), 3, 1, 3));
            }
        }
    }
}
