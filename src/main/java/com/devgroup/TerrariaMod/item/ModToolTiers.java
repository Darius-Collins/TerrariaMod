package com.devgroup.TerrariaMod.item;

import com.devgroup.TerrariaMod.TerrariaMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {
    public static Tier PLATINUM;

    static {
        PLATINUM = TierSortingRegistry.registerTier(
                new ForgeTier(2, 300, 6.3, 3, 24,
                        null, () -> Ingredient.of(ModItems.PLATINUM_INGOT.get())),
                new ResourceLocation(TerrariaMod.MOD_ID, "platinum"), List.of(Tiers.IRON), List.of();
        )
    }

}
