package com.devgroup.TerrariaMod.item;

import com.devgroup.TerrariaMod.TerrariaMod;
import com.devgroup.TerrariaMod.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public enum ModToolTiers implements Tier {;
    public static Tier PLATINUM;
    public static Tier TUNGSTEN;
    public static Tier COPPER;

    static {
       PLATINUM  = TierSortingRegistry.registerTier(
                new ForgeTier(3, 1000, 9, 1, 24,
                        ModTags.Blocks.NEEDS_PLATINUM_TOOL, () -> Ingredient.of(ModItems.PLATINUM_INGOT.get())),
                new ResourceLocation(TerrariaMod.MOD_ID, "platinum"), List.of(Tiers.DIAMOND), List.of());
    }

    static {
        TUNGSTEN = TierSortingRegistry.registerTier(
                new ForgeTier(2, 600, 7, 1, 24,
                        ModTags.Blocks.NEEDS_TUNGSTEN_TOOL, () -> Ingredient.of(ModItems.TUNGSTEN_INGOT.get())),
                new ResourceLocation(TerrariaMod.MOD_ID, "tungsten"), List.of(Tiers.IRON), List.of());
    }

    static {
        COPPER = TierSortingRegistry.registerTier(
                new ForgeTier(1, 250, 4, 1, 10,
                        ModTags.Blocks.NEEDS_COPPER_TOOL, () -> Ingredient.of(Items.COPPER_INGOT.getDefaultInstance())),
                new ResourceLocation(TerrariaMod.MOD_ID, "copper"), List.of(Tiers.STONE), List.of());
    }

    @Override
    public int getUses() {
        return getUses();
    }

    @Override
    public float getSpeed() {
        return getSpeed();
    }

    @Override
    public float getAttackDamageBonus() {
        return getAttackDamageBonus();
    }

    @Override
    public int getLevel() {
        return getLevel();
    }

    @Override
    public int getEnchantmentValue() {
        return getEnchantmentValue();
    }

    @Override
    public Ingredient getRepairIngredient() {
        return null;
    }
}
