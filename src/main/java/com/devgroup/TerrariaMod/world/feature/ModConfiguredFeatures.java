package com.devgroup.TerrariaMod.world.feature;

import com.devgroup.TerrariaMod.TerrariaMod;
import com.devgroup.TerrariaMod.blocks.ModBlocks;
import com.google.common.base.Suppliers;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.GeodeBlockSettings;
import net.minecraft.world.level.levelgen.GeodeCrackSettings;
import net.minecraft.world.level.levelgen.GeodeLayerSettings;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.GeodeConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.function.Supplier;

public class ModConfiguredFeatures {
    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES =
            DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, TerrariaMod.MOD_ID);

    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_PLATINUM_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.PLATINUM_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_PLATINUM_ORE.get().defaultBlockState())));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_TUNGSTEN_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.TUNGSTEN_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_TUNGSTEN_ORE.get().defaultBlockState())));

    public static final RegistryObject<ConfiguredFeature<?, ?>> PLATINUM_ORE = CONFIGURED_FEATURES.register("platinum_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_PLATINUM_ORES.get(), 7))); //7 is the vein size
    public static final RegistryObject<ConfiguredFeature<?, ?>> TUNGSTEN_ORE = CONFIGURED_FEATURES.register("tungsten_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_TUNGSTEN_ORES.get(), 7))); //7 is the vein size

    public static final RegistryObject<ConfiguredFeature<?, ?>> METEORITE_CRATER = CONFIGURED_FEATURES.register("meteorite_crater",
            () -> new ConfiguredFeature<>(Feature.GEODE,
                    new GeodeConfiguration(new GeodeBlockSettings(BlockStateProvider.simple(Blocks.AIR),
                            BlockStateProvider.simple(Blocks.MUD),
                            BlockStateProvider.simple(ModBlocks.METEORITE_ORE.get()),
                            BlockStateProvider.simple(ModBlocks.METEORITE_BLOCK.get()),
                            BlockStateProvider.simple(Blocks.STONE),
                            List.of(ModBlocks.METEORITE_ORE.get().defaultBlockState()),
                            BlockTags.FEATURES_CANNOT_REPLACE , BlockTags.GEODE_INVALID_BLOCKS),
                            new GeodeLayerSettings(1.7D, 1.2D, 2.5D, 2D),
                            new GeodeCrackSettings(0.75D, 1.5D, 0), 1D, 0.1D,
                            true, UniformInt.of(4, 5),
                            UniformInt.of(4,5), UniformInt.of(1,2),
                            -18,18, 0.075D, 1)));

    public static void register(IEventBus eventBus) {
        CONFIGURED_FEATURES.register(eventBus);
    }
}