package net.minecraft.src;

public class BlockLever extends Block
{
    protected BlockLever(int par1, int par2)
    {
        super(par1, par2, Material.circuits);
        this.setCreativeTab(CreativeTabs.field_78028_d);
    }

    /**
     * Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been
     * cleared to be reused)
     */
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
        return null;
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
        return 12;
    }

    /**
     * checks to see if you can place this block can be placed on that side of a block: BlockLever overrides
     */
    public boolean canPlaceBlockOnSide(World par1World, int par2, int par3, int par4, int par5)
    {
        return par5 == 0 && par1World.isBlockNormalCube(par2, par3 + 1, par4) ? true : (par5 == 1 && par1World.doesBlockHaveSolidTopSurface(par2, par3 - 1, par4) ? true : (par5 == 2 && par1World.isBlockNormalCube(par2, par3, par4 + 1) ? true : (par5 == 3 && par1World.isBlockNormalCube(par2, par3, par4 - 1) ? true : (par5 == 4 && par1World.isBlockNormalCube(par2 + 1, par3, par4) ? true : par5 == 5 && par1World.isBlockNormalCube(par2 - 1, par3, par4)))));
    }

    /**
     * Checks to see if its valid to put this block at the specified coordinates. Args: world, x, y, z
     */
    public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4)
    {
        return par1World.isBlockNormalCube(par2 - 1, par3, par4) ? true : (par1World.isBlockNormalCube(par2 + 1, par3, par4) ? true : (par1World.isBlockNormalCube(par2, par3, par4 - 1) ? true : (par1World.isBlockNormalCube(par2, par3, par4 + 1) ? true : (par1World.doesBlockHaveSolidTopSurface(par2, par3 - 1, par4) ? true : par1World.isBlockNormalCube(par2, par3 + 1, par4)))));
    }

    public void func_71909_a(World par1World, int par2, int par3, int par4, int par5, float par6, float par7, float par8)
    {
        int var9 = par1World.getBlockMetadata(par2, par3, par4);
        int var10 = var9 & 8;
        var9 &= 7;
        var9 = -1;

        if (par5 == 0 && par1World.isBlockNormalCube(par2, par3 + 1, par4))
        {
            var9 = par1World.rand.nextBoolean() ? 0 : 7;
        }

        if (par5 == 1 && par1World.doesBlockHaveSolidTopSurface(par2, par3 - 1, par4))
        {
            var9 = 5 + par1World.rand.nextInt(2);
        }

        if (par5 == 2 && par1World.isBlockNormalCube(par2, par3, par4 + 1))
        {
            var9 = 4;
        }

        if (par5 == 3 && par1World.isBlockNormalCube(par2, par3, par4 - 1))
        {
            var9 = 3;
        }

        if (par5 == 4 && par1World.isBlockNormalCube(par2 + 1, par3, par4))
        {
            var9 = 2;
        }

        if (par5 == 5 && par1World.isBlockNormalCube(par2 - 1, par3, par4))
        {
            var9 = 1;
        }

        if (var9 == -1)
        {
            this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
            par1World.setBlockWithNotify(par2, par3, par4, 0);
        }
        else
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, var9 + var10);
        }
    }

    public static int func_72196_d(int par0)
    {
        switch (par0)
        {
            case 0:
                return 0;

            case 1:
                return 5;

            case 2:
                return 4;

            case 3:
                return 3;

            case 4:
                return 2;

            case 5:
                return 1;

            default:
                return -1;
        }
    }

    /**
     * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
     * their own) Args: x, y, z, neighbor blockID
     */
    public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5)
    {
        if (this.checkIfAttachedToBlock(par1World, par2, par3, par4))
        {
            int var6 = par1World.getBlockMetadata(par2, par3, par4) & 7;
            boolean var7 = false;

            if (!par1World.isBlockNormalCube(par2 - 1, par3, par4) && var6 == 1)
            {
                var7 = true;
            }

            if (!par1World.isBlockNormalCube(par2 + 1, par3, par4) && var6 == 2)
            {
                var7 = true;
            }

            if (!par1World.isBlockNormalCube(par2, par3, par4 - 1) && var6 == 3)
            {
                var7 = true;
            }

            if (!par1World.isBlockNormalCube(par2, par3, par4 + 1) && var6 == 4)
            {
                var7 = true;
            }

            if (!par1World.doesBlockHaveSolidTopSurface(par2, par3 - 1, par4) && var6 == 5)
            {
                var7 = true;
            }

            if (!par1World.doesBlockHaveSolidTopSurface(par2, par3 - 1, par4) && var6 == 6)
            {
                var7 = true;
            }

            if (!par1World.isBlockNormalCube(par2, par3 + 1, par4) && var6 == 0)
            {
                var7 = true;
            }

            if (!par1World.isBlockNormalCube(par2, par3 + 1, par4) && var6 == 7)
            {
                var7 = true;
            }

            if (var7)
            {
                this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
                par1World.setBlockWithNotify(par2, par3, par4, 0);
            }
        }
    }

    /**
     * Checks if the block is attached to another block. If it is not, it returns false and drops the block as an item.
     * If it is it returns true.
     */
    private boolean checkIfAttachedToBlock(World par1World, int par2, int par3, int par4)
    {
        if (!this.canPlaceBlockAt(par1World, par2, par3, par4))
        {
            this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
            par1World.setBlockWithNotify(par2, par3, par4, 0);
            return false;
        }
        else
        {
            return true;
        }
    }

    /**
     * Updates the blocks bounds based on its current state. Args: world, x, y, z
     */
    public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
    {
        int var5 = par1IBlockAccess.getBlockMetadata(par2, par3, par4) & 7;
        float var6 = 0.1875F;

        if (var5 == 1)
        {
            this.setBlockBounds(0.0F, 0.2F, 0.5F - var6, var6 * 2.0F, 0.8F, 0.5F + var6);
        }
        else if (var5 == 2)
        {
            this.setBlockBounds(1.0F - var6 * 2.0F, 0.2F, 0.5F - var6, 1.0F, 0.8F, 0.5F + var6);
        }
        else if (var5 == 3)
        {
            this.setBlockBounds(0.5F - var6, 0.2F, 0.0F, 0.5F + var6, 0.8F, var6 * 2.0F);
        }
        else if (var5 == 4)
        {
            this.setBlockBounds(0.5F - var6, 0.2F, 1.0F - var6 * 2.0F, 0.5F + var6, 0.8F, 1.0F);
        }
        else if (var5 != 5 && var5 != 6)
        {
            if (var5 == 0 || var5 == 7)
            {
                var6 = 0.25F;
                this.setBlockBounds(0.5F - var6, 0.4F, 0.5F - var6, 0.5F + var6, 1.0F, 0.5F + var6);
            }
        }
        else
        {
            var6 = 0.25F;
            this.setBlockBounds(0.5F - var6, 0.0F, 0.5F - var6, 0.5F + var6, 0.6F, 0.5F + var6);
        }
    }

    /**
     * Called when the block is clicked by a player. Args: x, y, z, entityPlayer
     */
    public void onBlockClicked(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer)
    {
        this.onBlockActivated(par1World, par2, par3, par4, par5EntityPlayer, 0, 0.0F, 0.0F, 0.0F);
    }

    /**
     * Called upon block activation (right click on the block.)
     */
    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
        if (par1World.isRemote)
        {
            return true;
        }
        else
        {
            int var10 = par1World.getBlockMetadata(par2, par3, par4);
            int var11 = var10 & 7;
            int var12 = 8 - (var10 & 8);
            par1World.setBlockMetadataWithNotify(par2, par3, par4, var11 + var12);
            par1World.markBlocksDirty(par2, par3, par4, par2, par3, par4);
            par1World.playSoundEffect((double)par2 + 0.5D, (double)par3 + 0.5D, (double)par4 + 0.5D, "random.click", 0.3F, var12 > 0 ? 0.6F : 0.5F);
            par1World.notifyBlocksOfNeighborChange(par2, par3, par4, this.blockID);

            if (var11 == 1)
            {
                par1World.notifyBlocksOfNeighborChange(par2 - 1, par3, par4, this.blockID);
            }
            else if (var11 == 2)
            {
                par1World.notifyBlocksOfNeighborChange(par2 + 1, par3, par4, this.blockID);
            }
            else if (var11 == 3)
            {
                par1World.notifyBlocksOfNeighborChange(par2, par3, par4 - 1, this.blockID);
            }
            else if (var11 == 4)
            {
                par1World.notifyBlocksOfNeighborChange(par2, par3, par4 + 1, this.blockID);
            }
            else if (var11 != 5 && var11 != 6)
            {
                if (var11 == 0 || var11 == 7)
                {
                    par1World.notifyBlocksOfNeighborChange(par2, par3 + 1, par4, this.blockID);
                }
            }
            else
            {
                par1World.notifyBlocksOfNeighborChange(par2, par3 - 1, par4, this.blockID);
            }

            return true;
        }
    }

    public void func_71852_a(World par1World, int par2, int par3, int par4, int par5, int par6)
    {
        if ((par6 & 8) > 0)
        {
            par1World.notifyBlocksOfNeighborChange(par2, par3, par4, this.blockID);
            int var7 = par6 & 7;

            if (var7 == 1)
            {
                par1World.notifyBlocksOfNeighborChange(par2 - 1, par3, par4, this.blockID);
            }
            else if (var7 == 2)
            {
                par1World.notifyBlocksOfNeighborChange(par2 + 1, par3, par4, this.blockID);
            }
            else if (var7 == 3)
            {
                par1World.notifyBlocksOfNeighborChange(par2, par3, par4 - 1, this.blockID);
            }
            else if (var7 == 4)
            {
                par1World.notifyBlocksOfNeighborChange(par2, par3, par4 + 1, this.blockID);
            }
            else if (var7 != 5 && var7 != 6)
            {
                if (var7 == 0 || var7 == 7)
                {
                    par1World.notifyBlocksOfNeighborChange(par2, par3 + 1, par4, this.blockID);
                }
            }
            else
            {
                par1World.notifyBlocksOfNeighborChange(par2, par3 - 1, par4, this.blockID);
            }
        }

        super.func_71852_a(par1World, par2, par3, par4, par5, par6);
    }

    /**
     * Is this block powering the block on the specified side
     */
    public boolean isPoweringTo(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
    {
        return (par1IBlockAccess.getBlockMetadata(par2, par3, par4) & 8) > 0;
    }

    /**
     * Is this block indirectly powering the block on the specified side
     */
    public boolean isIndirectlyPoweringTo(World par1World, int par2, int par3, int par4, int par5)
    {
        int var6 = par1World.getBlockMetadata(par2, par3, par4);

        if ((var6 & 8) == 0)
        {
            return false;
        }
        else
        {
            int var7 = var6 & 7;
            return var7 == 0 && par5 == 0 ? true : (var7 == 7 && par5 == 0 ? true : (var7 == 6 && par5 == 1 ? true : (var7 == 5 && par5 == 1 ? true : (var7 == 4 && par5 == 2 ? true : (var7 == 3 && par5 == 3 ? true : (var7 == 2 && par5 == 4 ? true : var7 == 1 && par5 == 5))))));
        }
    }

    /**
     * Can this block provide power. Only wire currently seems to have this change based on its state.
     */
    public boolean canProvidePower()
    {
        return true;
    }
}
