package com.popertots.popercraft.client.entity.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.popertots.popercraft.Popercraft;
import com.popertots.popercraft.client.entity.model.ModSlimeModel;
import com.popertots.popercraft.entities.ModSlimeEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.SlimeRenderer;
import net.minecraft.client.renderer.entity.model.SlimeModel;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.monster.SlimeEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL46;

public class ModSlimeRender extends SlimeRenderer {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(Popercraft.MOD_ID,"textures/entity/mod_slime.png");

    public ModSlimeRender(EntityRendererManager renderManagerIn) {
        super(renderManagerIn);
    }

    protected void preRenderCallback(SlimeEntity entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime)
    {
        //ModSlimeEntity slime = (ModSlimeEntity)entitylivingbaseIn;

        float f = 0.999F;
        matrixStackIn.scale(0.999F, 0.999F, 0.999F);
        matrixStackIn.translate(0.0D, (double)0.001F, 0.0D);
        float f1 = (float)entitylivingbaseIn.getSlimeSize();
        float f2 = MathHelper.lerp(partialTickTime, entitylivingbaseIn.prevSquishFactor, entitylivingbaseIn.squishFactor) / (f1 * 0.5F + 1.0F);
        float f3 = 1.0F / (f2 + 1.0F);
        matrixStackIn.scale(f3 * f1, 1.0F / f3 * f1, f3 * f1);
    }

    @Override
    public ResourceLocation getEntityTexture(SlimeEntity entity) {
        return TEXTURE;
    }
}
