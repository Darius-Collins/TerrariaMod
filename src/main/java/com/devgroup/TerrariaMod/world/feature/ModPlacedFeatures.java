package com.devgroup.TerrariaMod.world.feature;

import com.devgroup.TerrariaMod.TerrariaMod;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ModPlacedFeatures {
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES =
            DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, TerrariaMod.MOD_ID);

    public static final RegistryObject<PlacedFeature> PLATINUM_ORE_PLACED = PLACED_FEATURES.register("platinum_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.PLATINUM_ORE.getHolder().get(),
                    commonOrePlacement( 10, // veins per chunk
                            HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));
    public static final RegistryObject<PlacedFeature> TUNGSTEN_ORE_PLACED = PLACED_FEATURES.register("tungsten_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.TUNGSTEN_ORE.getHolder().get(),
                    commonOrePlacement( 12, // veins per chunk
                            HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(100)))));

    public static final RegistryObject<PlacedFeature> METEORITE_CRATER_PLACED = PLACED_FEATURES.register("meteorite_crater_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.METEORITE_CRATER.getHolder().get(), List.of(
                    RarityFilter.onAverageOnceEvery(20), InSquarePlacement.spread(),
                    HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(105), VerticalAnchor.absolute(200)),
                    BiomeFilter.biome())));


    public static void register(IEventBus eventBus) {
        PLACED_FEATURES.register(eventBus);
    }

    private static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
        return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
    }

    private static List<PlacementModifier> commonOrePlacement(int p_195344_, PlacementModifier p_195345_) {
        return orePlacement(CountPlacement.of(p_195344_), p_195345_);
    }

    private static List<PlacementModifier> rareOrePlacement(int p_195350_, PlacementModifier p_195351_) {
        return orePlacement(RarityFilter.onAverageOnceEvery(p_195350_), p_195351_);
    }
}
