package com.devgroup.TerrariaMod.event;

import com.devgroup.TerrariaMod.TerrariaMod;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;

public class ClientEvents {
    @Mod.EventBusSubscriber(modid = TerrariaMod.MOD_ID, value = Dist.CLIENT)
    public static class ClientForgeEvents {

    }
}
