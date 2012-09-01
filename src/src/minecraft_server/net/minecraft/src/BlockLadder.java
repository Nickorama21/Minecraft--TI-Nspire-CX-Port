package net.minecraft.src;

import java.util.Random;

public class BlockLadder extends Block
{
    protected BlockLadder(int par1, int par2)
    {
        super(par1, par2, Material.circuits);
        this.setCreativeTab(CreativeTabs.field_78031_c);
    }

    /**
     * Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been
     * cleared to be reused)
     */
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
        int var5 = par1World.getBlockMetadata(par2, par3, par4);
        float var6 = 0.125F;

        if (var5 == 2)
        {
            this.setBlockBounds(0.0F, 0.0F, 1.0F - var6, 1.0F, 1.0F, 1.0F);
        }

        if (var5 == 3)
        {
            this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, var6);
        }

        if (var5 == 4)
        {
            this.setBlockBounds(1.0F - var6, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        }

        if (var5 == 5)
        {
            this.setBlockBounds(0.0F, 0.0F, 0.0F, var6, 1.0F, 1.0F);
        }

        return super.getCollisionBoundingBoxFromPool(par1World, par2, par3, par4);
    }

    /**
     * Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
     * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
     */
    public boolean isOpaqueCube()
    {
        return false;
    }

    /**
     * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
     */
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    /**
     * The type of render function that is called for this block
     */
    public int getRenderType()
    {
        return 8;
    }

    /**
     * Checks to see if its valid to put this block at the specified coordinates. Args: world, x, y, z
     */
    public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4)
    {
        return par1World.isBlockNormalCube(par2 - 1, par3, par4) ? true : (par1World.isBlockNormalCube(par2 + 1, par3, par4) ? true : (par1World.isBlockNormalCube(par2, par3, par4 - 1) ? true : par1World.isBlockNormalCube(par2, par3, par4 + 1)));
    }

    public void func_71909_a(World par1World, int par2, int par3, int par4, int par5, float par6, float par7, float par8)
    {
        int var9 = par1World.getBlockMetadata(par2, par3, par4);

        if ((var9 == 0 || par5 == 2) && par1World.isBlockNormalCube(par2, par3, par4 + 1))
        {
            var9 = 2;
        }

        if ((var9 == 0 || par5 == 3) && par1World.isBlockNormalCube(par2, par3, par4 - 1))
        {
            var9 = 3;
        }

        if ((var9 == 0 || par5 == 4) && par1World.isBlockNormalCube(par2 + 1, par3, par4))
        {
            var9 = 4;
        }

        if ((var9 == 0 || par5 == 5) && par1World.isBlockNormalCube(par2 - 1, par3, par4))
        {
            var9 = 5;
        }

        par1World.setBlockMetadataWithNotify(par2, par3, par4, var9);
    }

    /**
     * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
     * their own) Args: x, y, z, neighbor blockID
     */
    public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5)
    {
        int var6 = par1World.getBlockMetadata(par2, par3, par4);
        boolean var7 = false;

        if (var6 == 2 && par1World.isBlockNormalCube(par2, par3, par4 + 1))
        {
            var7 = true;
        }

        if (var6 == 3 && par1World.isBlockNormalCube(par2, par3, par4 - 1))
        {
            var7 = true;
        }

        if (var6 == 4 && par1World.isBlockNormalCube(par2 + 1, par3, par4))
        {
            var7 = true;
        }

        if (var6 == 5 && par1World.isBlockNormalCube(par2 - 1, par3, par4))
        {
            var7 = true;
        }

        if (!var7)
        {
            this.dropBlockAsItem(par1World, par2, par3, par4, var6, 0);
            par1World.setBlockWithNotify(par2, par3, par4, 0);
        }

        super.onNeighborBlockChange(par1World, par2, par3, par4, par5);
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random par1Random)
    {
        return 1;
    }
}
