package com.devgroup.TerrariaMod.entity;

import com.devgroup.TerrariaMod.TerrariaMod;
import com.devgroup.TerrariaMod.entity.custom.MeteorHeadEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, TerrariaMod.MOD_ID);

    public static final RegistryObject<EntityType<MeteorHeadEntity>> METEORHEAD =
            ENTITY_TYPES.register("meteorhead",
                    () -> EntityType.Builder.of(MeteorHeadEntity::new, MobCategory.MONSTER)
                            .sized(0.7f, 1f) //hitbox size
                            .build(new ResourceLocation(TerrariaMod.MOD_ID, "meteorhead").toString()));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
