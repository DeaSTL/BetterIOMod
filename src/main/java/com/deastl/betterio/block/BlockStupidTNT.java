package com.deastl.betterio.block;

import com.deastl.betterio.BetterIO;
import com.deastl.betterio.init.ModBlocks;
import com.deastl.betterio.init.ModItems;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraft.item.Item;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Random;

public class BlockStupidTNT extends BlockTNT {

    public BlockStupidTNT(String name, Material material){
        super();
        setRegistryName(name);
        setUnlocalizedName(name);
        setSoundType(SoundType.PLANT);
        setHardness(1f);
        setResistance(1.0f);
        setHarvestLevel("pickaxe",1);
        setLightLevel(1f);
        setCreativeTab(CreativeTabs.REDSTONE);
        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
        setTickRandomly(true);


    }

    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
    {
        super.onBlockAdded(worldIn, pos, state);

        if (worldIn.isBlockPowered(pos))
        {
            this.onBlockDestroyedByPlayer(worldIn, pos, state.withProperty(EXPLODE, Boolean.valueOf(true)));
            worldIn.setBlockToAir(pos);

        }
    }

    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {

    }
    public void onBlockDestroyedByExplosion(World worldIn, BlockPos pos, Explosion explosionIn)
    {
        if (!worldIn.isRemote)
        {
            Random random = new Random();
            for(int i = 0;i<30;i++){
                EntityTNTPrimed entitytntprimed = new EntityTNTPrimed(
                        worldIn,
                        (double)((float)pos.getX() + ((random.nextFloat()*5f)-2.5f)),
                        (double)((float)pos.getY() + ((random.nextFloat()*5f)-2.5f)),
                        (double)((float)pos.getZ() + ((random.nextFloat()*5f)-2.5f)),
                        explosionIn.getExplosivePlacedBy());
                worldIn.spawnEntity(entitytntprimed);
                worldIn.playSound((EntityPlayer)null, entitytntprimed.posX, entitytntprimed.posY, entitytntprimed.posZ, SoundEvents.ENTITY_TNT_PRIMED, SoundCategory.BLOCKS, 1.0F, 1.0F);
            }
        }
    }
    public void explode(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase igniter)
    {

        if (!worldIn.isRemote)
        {
            if (((Boolean)state.getValue(EXPLODE)).booleanValue())
            {
                Random random = new Random();
                for(int i = 0;i<30;i++){
                    EntityTNTPrimed entitytntprimed = new EntityTNTPrimed(
                            worldIn,
                            (double)((float)pos.getX() + ((random.nextFloat()*5f)-2.5f)),
                            (double)((float)pos.getY() + ((random.nextFloat()*5f)-2.5f)),
                            (double)((float)pos.getZ() + ((random.nextFloat()*5f)-2.5f)),
                            igniter);
                    worldIn.spawnEntity(entitytntprimed);
                    worldIn.playSound((EntityPlayer)null, entitytntprimed.posX, entitytntprimed.posY, entitytntprimed.posZ, SoundEvents.ENTITY_TNT_PRIMED, SoundCategory.BLOCKS, 1.0F, 1.0F);
                }
            }
        }
    }


}
