package com.devgroup.TerrariaMod.event;

import com.devgroup.TerrariaMod.TerrariaMod;
import com.devgroup.TerrariaMod.entity.ModEntityTypes;
import com.devgroup.TerrariaMod.entity.custom.MeteorHeadEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class ModEvents {
    @Mod.EventBusSubscriber(modid = TerrariaMod.MOD_ID)
    public static class ForgeEvents {

    }

    @Mod.EventBusSubscriber(modid = TerrariaMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ModEventBusEvents {
        @SubscribeEvent
        public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
            event.put(ModEntityTypes.METEORHEAD.get(), MeteorHeadEntity.setAttributes());
        }
    }
}
