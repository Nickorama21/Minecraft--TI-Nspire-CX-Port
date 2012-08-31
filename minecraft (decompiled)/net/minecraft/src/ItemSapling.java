package net.minecraft.src;

public class ItemSapling extends ItemBlock
{
    public ItemSapling(int par1)
    {
        super(par1);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }

    /**
     * Returns the metadata of the block which this Item (ItemBlock) can place
     */
    public int getMetadata(int par1)
    {
        return par1;
    }

    /**
     * Gets an icon index based on an item's damage value
     */
    public int getIconFromDamage(int par1)
    {
        return Block.sapling.getBlockTextureFromSideAndMetadata(0, par1);
    }

    public String getItemNameIS(ItemStack par1ItemStack)
    {
        int var2 = par1ItemStack.getItemDamage();

        if (var2 < 0 || var2 >= BlockSapling.field_72270_a.length)
        {
            var2 = 0;
        }

        return super.getItemName() + "." + BlockSapling.field_72270_a[var2];
    }
}
