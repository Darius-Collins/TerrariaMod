package com.devgroup.TerrariaMod.entity.client;

import com.devgroup.TerrariaMod.TerrariaMod;
import com.devgroup.TerrariaMod.entity.custom.MeteorHeadEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class MeteorheadRenderer extends GeoEntityRenderer<MeteorHeadEntity> {
    public MeteorheadRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new MeteorheadModel());
        this.shadowRadius = 0.5f;
    }

    @Override
    public ResourceLocation getTextureLocation(MeteorHeadEntity animatable) {
        return new ResourceLocation(TerrariaMod.MOD_ID, "textures/entity/meteor_head_texture.png");
    }

    @Override
    public RenderType getRenderType(MeteorHeadEntity animatable, float partialTick, PoseStack poseStack,
                                    @Nullable MultiBufferSource bufferSource,
                                    @Nullable VertexConsumer buffer, int packedLight,
                                    ResourceLocation texture) {
        poseStack.scale(1.2f, 1.2F, 1.2F); //how big entity should be

        return super.getRenderType(animatable, partialTick, poseStack, bufferSource, buffer, packedLight, texture);
    }
}
