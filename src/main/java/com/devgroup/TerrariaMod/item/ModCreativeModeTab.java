package com.devgroup.TerrariaMod.item;

import com.mojang.patchy.MojangBlockListSupplier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab
{
    public static final CreativeModeTab TERRARIA_TAB = new CreativeModeTab("terraria_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.TERRARIA_LOGO.get());
        }
    };
}
