package com.popertots.popercraft.init;

import com.popertots.popercraft.Popercraft;
import com.popertots.popercraft.entities.ModHostileSnowmanEntity;
import com.popertots.popercraft.entities.ModSlimeEntity;
import com.popertots.popercraft.entities.ThrowableFlameEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.projectile.SnowballEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = new DeferredRegister<>(ForgeRegistries.ENTITIES,
            Popercraft.MOD_ID);

    public static final RegistryObject<EntityType<ModSlimeEntity>> mod_slime = ENTITY_TYPES
            .register("mod_slime",
                    () -> EntityType.Builder.<ModSlimeEntity>create(ModSlimeEntity::new, EntityClassification.CREATURE)
                            .build(new ResourceLocation(Popercraft.MOD_ID, "mod_slime").toString()));

    public static final RegistryObject<EntityType<ModHostileSnowmanEntity>> mod_snowman = ENTITY_TYPES
            .register("mod_snowman",
                    () -> EntityType.Builder.<ModHostileSnowmanEntity>create(ModHostileSnowmanEntity::new, EntityClassification.MONSTER)
                            .build(new ResourceLocation(Popercraft.MOD_ID, "mod_snowman").toString()));

//    public static final RegistryObject<EntityType<ThrowableFlameEntity>> flame_projectile = ENTITY_TYPES
//            .register("flame_projectile",
//                    () -> EntityType.Builder.<ThrowableFlameEntity>create(ThrowableFlameEntity::new, EntityClassification.MISC)
//                            .build(new ResourceLocation(Popercraft.MOD_ID, "flame_projectile").toString()));

    public static final RegistryObject<EntityType<ThrowableFlameEntity>> flame_projectile = ENTITY_TYPES
            .register("flame_projectile",
                    () -> EntityType.Builder.<ThrowableFlameEntity>create(ThrowableFlameEntity::new, EntityClassification.MISC).size(0.25f,0.25f)
                            .build(new ResourceLocation(Popercraft.MOD_ID, "flame_projectile").toString()));
}
