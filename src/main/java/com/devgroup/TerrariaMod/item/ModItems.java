package com.devgroup.TerrariaMod.item;

import com.devgroup.TerrariaMod.TerrariaMod;
import com.devgroup.TerrariaMod.base.ModArmorMaterial;
import com.devgroup.TerrariaMod.entity.ModEntityTypes;
import net.minecraft.client.Minecraft;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeSpawnEggItem;
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
            () -> new PickaxeItem(ModToolTiers.COPPER, 1, -2.8f,
                    new Item.Properties().tab(ModCreativeModeTab.TERRARIA_TAB).stacksTo(1)));

    public static final RegistryObject<AxeItem> COPPER_AXE = ITEMS.register("copper_axe",
            () -> new AxeItem(ModToolTiers.COPPER, 6, -3.2f,
                    new Item.Properties().tab(ModCreativeModeTab.TERRARIA_TAB).stacksTo(1)));

    public static final RegistryObject<HoeItem> COPPER_HOE = ITEMS.register("copper_hoe",
            () -> new HoeItem(ModToolTiers.COPPER, -1, -2f,
                    new Item.Properties().tab(ModCreativeModeTab.TERRARIA_TAB).stacksTo(1)));

    public static final RegistryObject<ArmorItem> COPPER_HELMET = ITEMS.register("copper_helmet",
            () -> new ArmorItem(ArmorTiers.COPPER, EquipmentSlot.HEAD, props()));
    public static final RegistryObject<ArmorItem> COPPER_CHESTPLATE = ITEMS.register("copper_chestplate",
            () -> new ArmorItem(ArmorTiers.COPPER, EquipmentSlot.CHEST, props()));
    public static final RegistryObject<ArmorItem> COPPER_LEGGINGS = ITEMS.register("copper_leggings",
            () -> new ArmorItem(ArmorTiers.COPPER, EquipmentSlot.LEGS, props()));
    public static final RegistryObject<ArmorItem> COPPER_BOOTS = ITEMS.register("copper_boots",
            () -> new ArmorItem(ArmorTiers.COPPER, EquipmentSlot.FEET, props()));

    public static final RegistryObject<Item> RAW_METEORITE = ITEMS.register("raw_meteorite",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TERRARIA_TAB)));

    public static final RegistryObject<Item> METEORITE_INGOT = ITEMS.register("meteorite_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TERRARIA_TAB)));

    public static final RegistryObject<Item> METORHEAD_SPAWN_EGG = ITEMS.register("meteorhead_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.METEORHEAD, 0x0C424e, 0xFF0000,
                    new Item.Properties().tab(ModCreativeModeTab.TERRARIA_TAB)));

    public static final RegistryObject<Item> EYEOFCTHULHU_SPAWN_EGG = ITEMS.register("eyeofcthulhu_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.EYEOFCTHULHU, 0x0C424e, 0xFF0000,
                    new Item.Properties().tab(ModCreativeModeTab.TERRARIA_TAB)));


    public static final RegistryObject<Item> TERRARIA_LOGO = ITEMS.register("terraria_logo",
            () -> new Item(new Item.Properties()));


    private static Item.Properties props() {return new Item.Properties().tab(ModCreativeModeTab.TERRARIA_TAB);}

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }



    public static class ArmorTiers {
        public static final ArmorMaterial COPPER = new ModArmorMaterial(
                "copper",
                300,
                new int[] { 1, 2, 3, 1 },
                30,
                SoundEvents.ARMOR_EQUIP_IRON,
                0.0f,
                0.0f,
                () -> Ingredient.of(Items.COPPER_INGOT));
    }
}
