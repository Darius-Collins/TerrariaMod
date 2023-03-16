package com.devgroup.TerrariaMod.item;

import com.devgroup.TerrariaMod.TerrariaMod;
import com.devgroup.TerrariaMod.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {
    public static Tier PLATINUM;
    public static Tier TUNGSTEN;

    static {
        PLATINUM = TierSortingRegistry.registerTier(
                new ForgeTier(2, 300, 0, 1, 10,
                        ModTags.Blocks.NEEDS_PLATINUM_TOOL, () -> Ingredient.of(ModItems.PLATINUM_INGOT.get())),
                new ResourceLocation(TerrariaMod.MOD_ID, "platinum"), List.of(Tiers.IRON), List.of());
    }

    static {
        TUNGSTEN = TierSortingRegistry.registerTier(
                new ForgeTier(2, 300, 0, 1, 10,
                        ModTags.Blocks.NEEDS_TUNGSTEN_TOOL, () -> Ingredient.of(ModItems.TUNGSTEN_INGOT.get())),
                new ResourceLocation(TerrariaMod.MOD_ID, "tungsten"), List.of(Tiers.IRON), List.of());
    }

}
