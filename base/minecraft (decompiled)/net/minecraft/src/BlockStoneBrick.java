package net.minecraft.src;

import java.util.List;

public class BlockStoneBrick extends Block
{
    public static final String[] field_72188_a = new String[] {"default", "mossy", "cracked", "chiseled"};

    public BlockStoneBrick(int par1)
    {
        super(par1, 54, Material.rock);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public int getBlockTextureFromSideAndMetadata(int par1, int par2)
    {
        switch (par2)
        {
            case 1:
                return 100;

            case 2:
                return 101;

            case 3:
                return 213;

            default:
                return 54;
        }
    }

    /**
     * Determines the damage on the item the block drops. Used in cloth and wood.
     */
    protected int damageDropped(int par1)
    {
        return par1;
    }

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        for (int var4 = 0; var4 < 4; ++var4)
        {
            par3List.add(new ItemStack(par1, 1, var4));
        }
    }
}
