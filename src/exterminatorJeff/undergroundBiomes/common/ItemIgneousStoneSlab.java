package exterminatorJeff.undergroundBiomes.common;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemIgneousStoneSlab extends ItemBlock{

	public ItemIgneousStoneSlab(int par1, Block block) {
		super(par1);
		this.setMaxDamage(0);
        this.setHasSubtypes(true);
	}
	
	public int getMetadata(int par1)
    {
        return par1;
    }
    
    @SideOnly(Side.CLIENT)
    public int getIconFromDamage(int par1)
    {
        return UndergroundBiomes.igneousBrickSlabHalf.getBlockTextureFromSideAndMetadata(0, par1);
    }
    
    public String getItemNameIS(ItemStack itemstack) {
    	String name = "";
    	switch(itemstack.getItemDamage()){
    		case(0): name = "redGraniteBrickSlab";
    			break;
    		case(1): name = "blackGraniteBrickSlab";
    			break;
    		case(2): name = "rhyoliteBrickSlab";
    			break;
    		case(3): name = "andesiteBrickSlab";
    			break;
    		case(4): name = "gabbroBrickSlab";
    			break;
    		case(5): name = "basaltBrickSlab";
    			break;
    		case(6): name = "komatiiteBrickSlab";
    			break;
    		case(7): name = "epidoteBrickSlab";
    			break;
    		default: name="default";
    		
	    }
    	return getItemName() + "." + name;
	}

}