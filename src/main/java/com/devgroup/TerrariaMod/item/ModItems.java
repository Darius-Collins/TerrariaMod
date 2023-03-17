package com.devgroup.TerrariaMod.item;

import com.devgroup.TerrariaMod.TerrariaMod;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import javax.swing.*;

public class ModItems
{
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TerrariaMod.MOD_ID);

    public static final RegistryObject<Item> RAW_TUNGSTEN = ITEMS.register("raw_tungsten",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TERRARIA_TAB)));

    public static final RegistryObject<Item> TUNGSTEN_INGOT = ITEMS.register("tungsten_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TERRARIA_TAB)));

    public static final RegistryObject<SwordItem> TUNGSTEN_SWORD = ITEMS.register("tungsten_sword",
            () -> new SwordItem(ModToolTiers.TUNGSTEN, 4, -2.2f,
                    new Item.Properties().tab(ModCreativeModeTab.TERRARIA_TAB).stacksTo(1)));

    public static final RegistryObject<ShovelItem> TUNGSTEN_SHOVEL = ITEMS.register("tungsten_shovel",
            () -> new ShovelItem(ModToolTiers.TUNGSTEN, 3, -2.8f,
                    new Item.Properties().tab(ModCreativeModeTab.TERRARIA_TAB).stacksTo(1)));

    public static final RegistryObject<PickaxeItem> TUNGSTEN_PICKAXE = ITEMS.register("tungsten_pickaxe",
            () -> new PickaxeItem(ModToolTiers.TUNGSTEN, 2, -2.6f,
                    new Item.Properties().tab(ModCreativeModeTab.TERRARIA_TAB).stacksTo(1)));

    public static final RegistryObject<AxeItem> TUNGSTEN_AXE = ITEMS.register("tungsten_axe",
            () -> new AxeItem(ModToolTiers.TUNGSTEN, 7, -3f,
                    new Item.Properties().tab(ModCreativeModeTab.TERRARIA_TAB).stacksTo(1)));

    public static final RegistryObject<HoeItem> TUNGSTEN_HOE = ITEMS.register("tungsten_hoe",
            () -> new HoeItem(ModToolTiers.TUNGSTEN, -1, -0.8f,
                    new Item.Properties().tab(ModCreativeModeTab.TERRARIA_TAB).stacksTo(1)));

    public static final RegistryObject<Item> RAW_PLATINUM = ITEMS.register("raw_platinum",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TERRARIA_TAB)));

    public static final RegistryObject<Item> PLATINUM_INGOT = ITEMS.register("platinum_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TERRARIA_TAB)));

    public static final RegistryObject<SwordItem> PLATINUM_SWORD = ITEMS.register("platinum_sword",
            () -> new SwordItem(ModToolTiers.PLATINUM, 5, -2.2f,
                    new Item.Properties().tab(ModCreativeModeTab.TERRARIA_TAB).stacksTo(1)));

    public static final RegistryObject<ShovelItem> PLATINUM_SHOVEL = ITEMS.register("platinum_shovel",
            () -> new ShovelItem(ModToolTiers.PLATINUM, 3, -2.6f,
                    new Item.Properties().tab(ModCreativeModeTab.TERRARIA_TAB).stacksTo(1)));

    public static final RegistryObject<PickaxeItem> PLATINUM_PICKAXE = ITEMS.register("platinum_pickaxe",
            () -> new PickaxeItem(ModToolTiers.PLATINUM, 3, -2.4f,
                    new Item.Properties().tab(ModCreativeModeTab.TERRARIA_TAB).stacksTo(1)));

    public static final RegistryObject<AxeItem> PLATINUM_AXE = ITEMS.register("platinum_axe",
            () -> new AxeItem(ModToolTiers.PLATINUM, 7, -2.8f,
                    new Item.Properties().tab(ModCreativeModeTab.TERRARIA_TAB).stacksTo(1)));

    public static final RegistryObject<HoeItem> PLATINUM_HOE = ITEMS.register("platinum_hoe",
            () -> new HoeItem(ModToolTiers.PLATINUM, -1, -0.7f,
                    new Item.Properties().tab(ModCreativeModeTab.TERRARIA_TAB).stacksTo(1)));

    public static final RegistryObject<SwordItem> COPPER_SWORD = ITEMS.register("copper_sword",
            () -> new SwordItem(ModToolTiers.COPPER, 3, -2.8f,
                    new Item.Properties().tab(ModCreativeModeTab.TERRARIA_TAB).stacksTo(1)));

    public static final RegistryObject<ShovelItem> COPPER_SHOVEL = ITEMS.register("copper_shovel",
            () -> new ShovelItem(ModToolTiers.COPPER, 3, -2.8f,
                    new Item.Properties().tab(ModCreativeModeTab.TERRARIA_TAB).stacksTo(1)));

    public static final RegistryObject<PickaxeItem> COPPER_PICKAXE = ITEMS.register("copper_pickaxe",
            () -> new PickaxeItem(ModToolTiers.COPPER, 1, -2.4f,
                    new Item.Properties().tab(ModCreativeModeTab.TERRARIA_TAB).stacksTo(1)));

    public static final RegistryObject<AxeItem> COPPER_AXE = ITEMS.register("copper_axe",
            () -> new AxeItem(ModToolTiers.COPPER, 6, -3.2f,
                    new Item.Properties().tab(ModCreativeModeTab.TERRARIA_TAB).stacksTo(1)));

    public static final RegistryObject<HoeItem> COPPER_HOE = ITEMS.register("copper_hoe",
            () -> new HoeItem(ModToolTiers.COPPER, -1, -2f,
                    new Item.Properties().tab(ModCreativeModeTab.TERRARIA_TAB).stacksTo(1)));

    public static final RegistryObject<Item> TERRARIA_LOGO = ITEMS.register("terraria_logo",
            () -> new Item(new Item.Properties()));




    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
