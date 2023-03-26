package com.devgroup.TerrariaMod.entity.client;

import com.devgroup.TerrariaMod.TerrariaMod;
import com.devgroup.TerrariaMod.entity.custom.boss.EyeofCthulhuEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class EyeofCthulhuModel extends AnimatedGeoModel<EyeofCthulhuEntity> {

    @Override
    public ResourceLocation getModelResource(EyeofCthulhuEntity object) {
        return new ResourceLocation(TerrariaMod.MOD_ID, "geo/eyeofcthulhustage1.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EyeofCthulhuEntity object) {
        return new ResourceLocation(TerrariaMod.MOD_ID, "textures/entity/eye_of_cthulhu_stage1_texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EyeofCthulhuEntity animatable) {
        return new ResourceLocation(TerrariaMod.MOD_ID, "animations/eyeofcthulhustage1.animation.json");
    }
}
