package com.devgroup.TerrariaMod.entity.client;

import com.devgroup.TerrariaMod.TerrariaMod;
import com.devgroup.TerrariaMod.entity.custom.boss.EyeofCthulhuEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class EyeofCthulhuRenderer extends GeoEntityRenderer<EyeofCthulhuEntity> {
    public EyeofCthulhuRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new EyeofCthulhuModel());
        this.shadowRadius = 1f;
    }

    @Override
    public ResourceLocation getTextureLocation(EyeofCthulhuEntity animatable) {
        return new ResourceLocation(TerrariaMod.MOD_ID, "textures/entity/eye_of_cthulhu_stage1_texture.png");
    }
    @Override
    public RenderType getRenderType(EyeofCthulhuEntity animatable, float partialTick, PoseStack poseStack,
                                    @Nullable MultiBufferSource bufferSource,
                                    @Nullable VertexConsumer buffer, int packedLight,
                                    ResourceLocation texture) {
        poseStack.scale(6f, 6F, 6F); //how big entity should be

        return super.getRenderType(animatable, partialTick, poseStack, bufferSource, buffer, packedLight, texture);
    }
}