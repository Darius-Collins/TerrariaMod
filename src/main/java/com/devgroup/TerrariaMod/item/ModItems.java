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

    public static final RegistryObject<PickaxeItem> PLATINUM_PICKAXE = ITEMS.register("platinum_pickaxe",
            () -> new PickaxeItem(ModToolTiers.PLATINUM, 3, -2.4f,
                    new Item.Properties().tab(ModCreativeModeTab.TERRARIA_TAB).stacksTo(1)));

    public static final RegistryObject<AxeItem> PLATINUM_AXE = ITEMS.register("platinum_axe",
            () -> new AxeItem(ModToolTiers.PLATINUM, 7, -3f,
                    new Item.Properties().tab(ModCreativeModeTab.TERRARIA_TAB).stacksTo(1)));

    public static final RegistryObject<Item> TERRARIA_LOGO = ITEMS.register("terraria_logo",
            () -> new Item(new Item.Properties()));


    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
