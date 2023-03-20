package com.devgroup.TerrariaMod.entity.client;

import com.devgroup.TerrariaMod.TerrariaMod;
import com.devgroup.TerrariaMod.entity.custom.MeteorHeadEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class MeteorheadModel extends AnimatedGeoModel<MeteorHeadEntity> {
    @Override
    public ResourceLocation getModelResource(MeteorHeadEntity object) {
        return new ResourceLocation(TerrariaMod.MOD_ID, "geo/meteorhead.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(MeteorHeadEntity object) {
        return new ResourceLocation(TerrariaMod.MOD_ID, "textures/entity/meteor_head_texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(MeteorHeadEntity animatable) {
        return new ResourceLocation(TerrariaMod.MOD_ID, "animations/meteor_head.animation.json");
    }
}
