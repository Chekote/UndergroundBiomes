package exterminatorJeff.undergroundBiomes.common.block;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import exterminatorJeff.undergroundBiomes.common.UndergroundBiomes;

public class BlockIgneousStone extends BlockMetadataBase{

	public BlockIgneousStone(int id, int texture){
		super(id, Material.rock);
		this.setHardness(1.5f);
		this.setResistance(10.0f);
		this.setCreativeTab(UndergroundBiomes.tabModBlocks);
	}
	
	public boolean isGenMineableReplaceable(World world, int x, int y, int z)
    {
        return true;
    }
	
	public float getExplosionResistance(Entity par1Entity, World world, int x, int y, int z, double explosionX, double explosionY, double explosionZ)
    {
		switch(getDamageValue(world, x, y, z)){
		
			case 0: return UndergroundBiomes.resistanceFactor * 6;
					
			case 1: return UndergroundBiomes.resistanceFactor * 6;
					
			case 2: return UndergroundBiomes.resistanceFactor * 6;
					
			case 3: return UndergroundBiomes.resistanceFactor * 7;
					
			case 4: return UndergroundBiomes.resistanceFactor * 5;
					
			case 5: return UndergroundBiomes.resistanceFactor * 6;
					
			case 6: return UndergroundBiomes.resistanceFactor * 6;
					
			case 7: return UndergroundBiomes.resistanceFactor * 7;
					
			default: getExplosionResistance(par1Entity);
		}
		return getExplosionResistance(par1Entity);
    }
	
	@Override
	public float getBlockHardness(World par1World, int par2, int par3, int par4){
		int meta = this.getDamageValue(par1World, par2, par3, par4);
		switch(meta){
		case 0: return UndergroundBiomes.hardnessFactor * 6;
		
		case 1: return UndergroundBiomes.hardnessFactor * 6;
		
		case 2: return UndergroundBiomes.hardnessFactor * 6;
		
		case 3: return UndergroundBiomes.hardnessFactor * 7;
		
		case 4: return UndergroundBiomes.hardnessFactor * 5;
		
		case 5: return UndergroundBiomes.hardnessFactor * 6;
		
		case 6: return UndergroundBiomes.hardnessFactor * 6;
		
		case 7: return UndergroundBiomes.hardnessFactor * 7;
		
		default: return 1.5f;
		}
	}

    public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
    	for(int i = 0; i < 8; i++){
    		par3List.add(new ItemStack(par1, 1, i));
    	} 
    }
    
    @Override
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return UndergroundBiomes.igneousCobblestone.blockID;
    }

    @Override
	public int damageDropped (int metadata) {
		return metadata;
	}
    
    @Override
    public String getBlockName(int index){
    	String name = "";
    	switch(index){
    		case(0): name = "redGranite";
    			break;
    		case(1): name = "blackGranite";
    			break;
    		case(2): name = "rhyolite";
    			break;
    		case(3): name = "andesite";
    			break;
    		case(4): name = "gabbro";
    			break;
    		case(5): name = "basalt";
    			break;
    		case(6): name = "komatiite";
    			break;
    		case(7): name = "epidote";
    			break;
    		default: name="default";
    		
	    }
    	return name;
    }
    
            
    

}
