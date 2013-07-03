package exterminatorJeff.undergroundBiomes.common.block;

import java.util.Random;
import java.util.List;
import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.world.World;
import net.minecraft.entity.Entity;

import exterminatorJeff.undergroundBiomes.common.UndergroundBiomes;

public abstract class BlockMetadataBase extends Block
{
    public BlockMetadataBase(int id, int texture)
    {
        super(id, texture, Material.rock);
        this.setHardness(1.5f);
        this.setResistance(10.0f);
        this.setCreativeTab(UndergroundBiomes.tabModBlocks);
    }
    
    public int getBlockTextureFromSideAndMetadata(int side, int metadata)
    {
        return blockIndexInTexture + (metadata & 7);
    }
    
    public String getTextureFile()
    {
        return UndergroundBiomes.textures;
    }

    public void getSubBlocks(int id, CreativeTabs tabs, List list)
    {
        for (int i = 0; i < 8; i++)
        {
            list.add(new ItemStack(id, 1, i));
        } 
    }

    public int damageDropped(int metadata)
    {
        return metadata & 7;
    }

    public boolean isGenMineableReplaceable(World world, int x, int y, int z)
    {
        return true;
    }

    public boolean isGenMineableReplaceable(World world, int x, int y, int z, int target)
    {
        return true;
    }

    public float getBlockHardness(int meta)
    {
        return 1.5f;
    }

    public float getBlockExplosionResistance(int meta)
    {
        return 6.0f;
    }

    public float getExplosionResistance(Entity entity, World world, int x, int y, int z, double explosionX, double explosionY, double explosionZ)
    {
        return getBlockExplosionResistance(getDamageValue(world, x, y, z) & 7);
    }
    
    public float getBlockHardness(World world, int x, int y, int z)
    {
        return getBlockHardness(getDamageValue(world, x, y, z) & 7);
    }

    public ItemStack itemDropped(int metadata, Random random, int fortune, int y)
    {
        return new ItemStack(this.blockID, 1, metadata & 7);
    }

    public ArrayList<ItemStack> getBlockDropped(World world, int x, int y, int z, int metadata, int fortune)
    {
        ArrayList<ItemStack> ret = new ArrayList<ItemStack>();

        int count = 1;
        ItemStack stack = itemDropped(metadata, world.rand, fortune, y);

        if ((fortune != 0) && (UndergroundBiomes.fortuneAffected.contains(stack.itemID)))
        {
            // Fortune III gives up to 4 items
            int j = world.rand.nextInt(fortune + 2);
            count = (j < 1) ? 1 : j;
        }
        for(int i = 0; i < count; i++)
        {
            ret.add(stack);
        }
        return ret;
    }

    public abstract String getBlockTypeName(int index);

    public abstract boolean hasRareDrops();

    public String getBlockName(int index)
    {
        return getBlockTypeName(index);
    }
}
