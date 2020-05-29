package com.popertots.popercraft.client.entity.render;

import com.popertots.popercraft.Popercraft;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.SnowManRenderer;
import net.minecraft.entity.passive.SnowGolemEntity;
import net.minecraft.util.ResourceLocation;

public class ModSnowmanRender extends SnowManRenderer {
    protected static final ResourceLocation TEXTURE = new ResourceLocation(Popercraft.MOD_ID,"textures/entity/mod_snowman.png");

    public ModSnowmanRender(EntityRendererManager renderManagerIn) {
        super(renderManagerIn);
    }

    public ResourceLocation getEntityTexture(SnowGolemEntity entity) {
        return TEXTURE;
    }
}
