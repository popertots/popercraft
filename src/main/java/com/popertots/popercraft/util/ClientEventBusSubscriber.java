package com.popertots.popercraft.util;

import com.popertots.popercraft.Popercraft;
import com.popertots.popercraft.init.BlockInit;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = Popercraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {
    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        RenderTypeLookup.setRenderLayer(BlockInit.lemon_sapling.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BlockInit.orange_sapling.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BlockInit.lime_sapling.get(), RenderType.getCutout());
    }
}
