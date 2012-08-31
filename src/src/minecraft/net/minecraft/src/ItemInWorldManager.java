package net.minecraft.src;

public class ItemInWorldManager
{
    /** The world object that this object is connected to. */
    public World theWorld;
    public EntityPlayerMP field_73090_b;
    private EnumGameType gameType;

    /**
     * set to true on first call of destroyBlockInWorldPartially, false before any further calls
     */
    private boolean isPartiallyDestroyedBlockWhole;
    private int field_73089_e;
    private int partiallyDestroyedBlockX;
    private int partiallyDestroyedBlockY;
    private int partiallyDestroyedBlockZ;
    private int field_73100_i;
    private boolean field_73097_j;
    private int posX;
    private int posY;
    private int posZ;
    private int field_73093_n;
    private int durabilityRemainingOnBlock;

    public ItemInWorldManager(World par1World)
    {
        this.gameType = EnumGameType.NOT_SET;
        this.durabilityRemainingOnBlock = -1;
        this.theWorld = par1World;
    }

    public void setGameType(EnumGameType par1EnumGameType)
    {
        this.gameType = par1EnumGameType;
        par1EnumGameType.configurePlayerCapabilities(this.field_73090_b.capabilities);
        this.field_73090_b.sendPlayerAbilities();
    }

    public EnumGameType getGameType()
    {
        return this.gameType;
    }

    public boolean isCreative()
    {
        return this.gameType.isCreative();
    }

    /**
     * if the gameType is currently NOT_SET then change it to par1
     */
    public void initializeGameType(EnumGameType par1EnumGameType)
    {
        if (this.gameType == EnumGameType.NOT_SET)
        {
            this.gameType = par1EnumGameType;
        }

        this.setGameType(this.gameType);
    }

    public void func_73075_a()
    {
        ++this.field_73100_i;
        int var1;
        float var4;
        int var5;

        if (this.field_73097_j)
        {
            var1 = this.field_73100_i - this.field_73093_n;
            int var2 = this.theWorld.getBlockId(this.posX, this.posY, this.posZ);

            if (var2 == 0)
            {
                this.field_73097_j = false;
            }
            else
            {
                Block var3 = Block.blocksList[var2];
                var4 = var3.getPlayerRelativeBlockHardness(this.field_73090_b, this.field_73090_b.worldObj, this.posX, this.posY, this.posZ) * (float)(var1 + 1);
                var5 = (int)(var4 * 10.0F);

                if (var5 != this.durabilityRemainingOnBlock)
                {
                    this.theWorld.destroyBlockInWorldPartially(this.field_73090_b.entityId, this.posX, this.posY, this.posZ, var5);
                    this.durabilityRemainingOnBlock = var5;
                }

                if (var4 >= 1.0F)
                {
                    this.field_73097_j = false;
                    this.tryHarvestBlock(this.posX, this.posY, this.posZ);
                }
            }
        }
        else if (this.isPartiallyDestroyedBlockWhole)
        {
            var1 = this.theWorld.getBlockId(this.partiallyDestroyedBlockX, this.partiallyDestroyedBlockY, this.partiallyDestroyedBlockZ);
            Block var6 = Block.blocksList[var1];

            if (var6 == null)
            {
                this.theWorld.destroyBlockInWorldPartially(this.field_73090_b.entityId, this.partiallyDestroyedBlockX, this.partiallyDestroyedBlockY, this.partiallyDestroyedBlockZ, -1);
                this.durabilityRemainingOnBlock = -1;
                this.isPartiallyDestroyedBlockWhole = false;
            }
            else
            {
                int var7 = this.field_73100_i - this.field_73089_e;
                var4 = var6.getPlayerRelativeBlockHardness(this.field_73090_b, this.field_73090_b.worldObj, this.partiallyDestroyedBlockX, this.partiallyDestroyedBlockY, this.partiallyDestroyedBlockZ) * (float)(var7 + 1);
                var5 = (int)(var4 * 10.0F);

                if (var5 != this.durabilityRemainingOnBlock)
                {
                    this.theWorld.destroyBlockInWorldPartially(this.field_73090_b.entityId, this.partiallyDestroyedBlockX, this.partiallyDestroyedBlockY, this.partiallyDestroyedBlockZ, var5);
                    this.durabilityRemainingOnBlock = var5;
                }
            }
        }
    }

    /**
     * if not creative, it calls destroyBlockInWorldPartially untill the block is broken first. par4 is the specific
     * side. tryHarvestBlock can also be the result of this call
     */
    public void onBlockClicked(int par1, int par2, int par3, int par4)
    {
        if (!this.gameType.isAdventure())
        {
            if (this.isCreative())
            {
                if (!this.theWorld.extinguishFire((EntityPlayer)null, par1, par2, par3, par4))
                {
                    this.tryHarvestBlock(par1, par2, par3);
                }
            }
            else
            {
                this.theWorld.extinguishFire(this.field_73090_b, par1, par2, par3, par4);
                this.field_73089_e = this.field_73100_i;
                float var5 = 1.0F;
                int var6 = this.theWorld.getBlockId(par1, par2, par3);

                if (var6 > 0)
                {
                    Block.blocksList[var6].onBlockClicked(this.theWorld, par1, par2, par3, this.field_73090_b);
                    var5 = Block.blocksList[var6].getPlayerRelativeBlockHardness(this.field_73090_b, this.field_73090_b.worldObj, par1, par2, par3);
                }

                if (var6 > 0 && var5 >= 1.0F)
                {
                    this.tryHarvestBlock(par1, par2, par3);
                }
                else
                {
                    this.isPartiallyDestroyedBlockWhole = true;
                    this.partiallyDestroyedBlockX = par1;
                    this.partiallyDestroyedBlockY = par2;
                    this.partiallyDestroyedBlockZ = par3;
                    int var7 = (int)(var5 * 10.0F);
                    this.theWorld.destroyBlockInWorldPartially(this.field_73090_b.entityId, par1, par2, par3, var7);
                    this.durabilityRemainingOnBlock = var7;
                }
            }
        }
    }

    public void uncheckedTryHarvestBlock(int par1, int par2, int par3)
    {
        if (par1 == this.partiallyDestroyedBlockX && par2 == this.partiallyDestroyedBlockY && par3 == this.partiallyDestroyedBlockZ)
        {
            int var4 = this.field_73100_i - this.field_73089_e;
            int var5 = this.theWorld.getBlockId(par1, par2, par3);

            if (var5 != 0)
            {
                Block var6 = Block.blocksList[var5];
                float var7 = var6.getPlayerRelativeBlockHardness(this.field_73090_b, this.field_73090_b.worldObj, par1, par2, par3) * (float)(var4 + 1);

                if (var7 >= 0.7F)
                {
                    this.isPartiallyDestroyedBlockWhole = false;
                    this.theWorld.destroyBlockInWorldPartially(this.field_73090_b.entityId, par1, par2, par3, -1);
                    this.tryHarvestBlock(par1, par2, par3);
                }
                else if (!this.field_73097_j)
                {
                    this.isPartiallyDestroyedBlockWhole = false;
                    this.field_73097_j = true;
                    this.posX = par1;
                    this.posY = par2;
                    this.posZ = par3;
                    this.field_73093_n = this.field_73089_e;
                }
            }
        }
    }

    /**
     * note: this ignores the pars passed in and continues to destroy the onClickedBlock
     */
    public void destroyBlockInWorldPartially(int par1, int par2, int par3)
    {
        this.isPartiallyDestroyedBlockWhole = false;
        this.theWorld.destroyBlockInWorldPartially(this.field_73090_b.entityId, this.partiallyDestroyedBlockX, this.partiallyDestroyedBlockY, this.partiallyDestroyedBlockZ, -1);
    }

    /**
     * Removes a block and triggers the appropriate  events
     */
    private boolean removeBlock(int par1, int par2, int par3)
    {
        Block var4 = Block.blocksList[this.theWorld.getBlockId(par1, par2, par3)];
        int var5 = this.theWorld.getBlockMetadata(par1, par2, par3);

        if (var4 != null)
        {
            var4.onBlockHarvested(this.theWorld, par1, par2, par3, var5, this.field_73090_b);
        }

        boolean var6 = this.theWorld.setBlockWithNotify(par1, par2, par3, 0);

        if (var4 != null && var6)
        {
            var4.onBlockDestroyedByPlayer(this.theWorld, par1, par2, par3, var5);
        }

        return var6;
    }

    /**
     * Attempts to harvest a block at the given coordinate
     */
    public boolean tryHarvestBlock(int par1, int par2, int par3)
    {
        if (this.gameType.isAdventure())
        {
            return false;
        }
        else
        {
            int var4 = this.theWorld.getBlockId(par1, par2, par3);
            int var5 = this.theWorld.getBlockMetadata(par1, par2, par3);
            this.theWorld.playAuxSFXAtEntity(this.field_73090_b, 2001, par1, par2, par3, var4 + (this.theWorld.getBlockMetadata(par1, par2, par3) << 12));
            boolean var6 = this.removeBlock(par1, par2, par3);

            if (this.isCreative())
            {
                this.field_73090_b.serverForThisPlayer.sendPacketToPlayer(new Packet53BlockChange(par1, par2, par3, this.theWorld));
            }
            else
            {
                ItemStack var7 = this.field_73090_b.getCurrentEquippedItem();
                boolean var8 = this.field_73090_b.canHarvestBlock(Block.blocksList[var4]);

                if (var7 != null)
                {
                    var7.func_77941_a(this.theWorld, var4, par1, par2, par3, this.field_73090_b);

                    if (var7.stackSize == 0)
                    {
                        this.field_73090_b.destroyCurrentEquippedItem();
                    }
                }

                if (var6 && var8)
                {
                    Block.blocksList[var4].harvestBlock(this.theWorld, this.field_73090_b, par1, par2, par3, var5);
                }
            }

            return var6;
        }
    }

    /**
     * Attempts to right-click use an item by the given EntityPlayer in the given World
     */
    public boolean tryUseItem(EntityPlayer par1EntityPlayer, World par2World, ItemStack par3ItemStack)
    {
        int var4 = par3ItemStack.stackSize;
        int var5 = par3ItemStack.getItemDamage();
        ItemStack var6 = par3ItemStack.useItemRightClick(par2World, par1EntityPlayer);

        if (var6 == par3ItemStack && (var6 == null || var6.stackSize == var4) && (var6 == null || var6.getMaxItemUseDuration() <= 0))
        {
            return false;
        }
        else
        {
            par1EntityPlayer.inventory.mainInventory[par1EntityPlayer.inventory.currentItem] = var6;

            if (this.isCreative())
            {
                var6.stackSize = var4;
                var6.setItemDamage(var5);
            }

            if (var6.stackSize == 0)
            {
                par1EntityPlayer.inventory.mainInventory[par1EntityPlayer.inventory.currentItem] = null;
            }

            return true;
        }
    }

    /**
     * Activate the clicked on block, otherwise use the held item. Args: player, world, itemStack, x, y, z, side,
     * xOffset, yOffset, zOffset
     */
    public boolean activateBlockOrUseItem(EntityPlayer par1EntityPlayer, World par2World, ItemStack par3ItemStack, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
        int var11 = par2World.getBlockId(par4, par5, par6);

        if (var11 > 0 && Block.blocksList[var11].onBlockActivated(par2World, par4, par5, par6, par1EntityPlayer, par7, par8, par9, par10))
        {
            return true;
        }
        else if (par3ItemStack == null)
        {
            return false;
        }
        else if (this.isCreative())
        {
            int var12 = par3ItemStack.getItemDamage();
            int var13 = par3ItemStack.stackSize;
            boolean var14 = par3ItemStack.tryPlaceItemIntoWorld(par1EntityPlayer, par2World, par4, par5, par6, par7, par8, par9, par10);
            par3ItemStack.setItemDamage(var12);
            par3ItemStack.stackSize = var13;
            return var14;
        }
        else
        {
            return par3ItemStack.tryPlaceItemIntoWorld(par1EntityPlayer, par2World, par4, par5, par6, par7, par8, par9, par10);
        }
    }

    /**
     * Sets the world instance.
     */
    public void setWorld(WorldServer par1WorldServer)
    {
        this.theWorld = par1WorldServer;
    }
}
