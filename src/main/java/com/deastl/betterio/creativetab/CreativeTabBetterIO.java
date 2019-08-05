package com.deastl.betterio.creativetab;

import com.deastl.betterio.reference.Reference;
import net.minecraft.block.BlockButtonStone;
import net.minecraft.block.BlockGlass;
import net.minecraft.block.BlockGlowstone;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CreativeTabBetterIO {
    public static final CreativeTabs BETTERIO_TAB = new CreativeTabs(Reference.MOD_ID.toLowerCase()) {
        @Override
        public ItemStack getTabIconItem() {
            return null;
        }
//        @Override
//        public Item getTabIconItem() {
//            //return new ItemStack(BlockGlass).getItem();
//            ItemStack itemStack = new ItemStack(new BlockGlowstone()).getItem();
//            return itemStack;
//        }


    };
};
