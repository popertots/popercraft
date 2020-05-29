package com.popertots.popercraft.util;

import com.popertots.popercraft.Popercraft;
import com.popertots.popercraft.client.entity.render.ModSlimeRender;
import com.popertots.popercraft.client.entity.render.ModSnowmanRender;
import com.popertots.popercraft.entities.ThrowableFlameEntity;
import com.popertots.popercraft.init.BlockInit;
import com.popertots.popercraft.init.ModEntityTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.entity.SpriteRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = Popercraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {
    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        RenderTypeLookup.setRenderLayer(BlockInit.lemon_sapling.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BlockInit.orange_sapling.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BlockInit.lime_sapling.get(), RenderType.getCutout());

        RenderTypeLookup.setRenderLayer(BlockInit.lemon_door.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BlockInit.orange_door.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BlockInit.lime_door.get(), RenderType.getCutout());

        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.mod_slime.get(), ModSlimeRender::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.mod_snowman.get(), ModSnowmanRender::new);
    }
}
