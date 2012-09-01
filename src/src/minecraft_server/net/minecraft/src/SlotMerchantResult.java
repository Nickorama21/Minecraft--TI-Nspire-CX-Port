package net.minecraft.src;

public class SlotMerchantResult extends Slot
{
    private final InventoryMerchant field_75233_a;
    private EntityPlayer field_75232_b;
    private int field_75231_g;
    private final IMerchant field_75234_h;

    public SlotMerchantResult(EntityPlayer par1EntityPlayer, IMerchant par2IMerchant, InventoryMerchant par3InventoryMerchant, int par4, int par5, int par6)
    {
        super(par3InventoryMerchant, par4, par5, par6);
        this.field_75232_b = par1EntityPlayer;
        this.field_75234_h = par2IMerchant;
        this.field_75233_a = par3InventoryMerchant;
    }

    /**
     * Check if the stack is a valid item for this slot. Always true beside for the armor slots.
     */
    public boolean isItemValid(ItemStack par1ItemStack)
    {
        return false;
    }

    /**
     * Decrease the size of the stack in slot (first int arg) by the amount of the second int arg. Returns the new
     * stack.
     */
    public ItemStack decrStackSize(int par1)
    {
        if (this.getHasStack())
        {
            this.field_75231_g += Math.min(par1, this.getStack().stackSize);
        }

        return super.decrStackSize(par1);
    }

    protected void func_75210_a(ItemStack par1ItemStack, int par2)
    {
        this.field_75231_g += par2;
        this.func_75208_c(par1ItemStack);
    }

    protected void func_75208_c(ItemStack par1ItemStack)
    {
        par1ItemStack.onCrafting(this.field_75232_b.worldObj, this.field_75232_b, this.field_75231_g);
        this.field_75231_g = 0;
    }

    /**
     * Called when the player picks up an item from an inventory slot
     */
    public void onPickupFromSlot(ItemStack par1ItemStack)
    {
        this.func_75208_c(par1ItemStack);
        MerchantRecipe var2 = this.field_75233_a.func_70468_h();

        if (var2 != null)
        {
            ItemStack var3 = this.field_75233_a.getStackInSlot(0);
            ItemStack var4 = this.field_75233_a.getStackInSlot(1);

            if (this.func_75230_a(var2, var3, var4) || this.func_75230_a(var2, var4, var3))
            {
                if (var3 != null && var3.stackSize <= 0)
                {
                    var3 = null;
                }

                if (var4 != null && var4.stackSize <= 0)
                {
                    var4 = null;
                }

                this.field_75233_a.setInventorySlotContents(0, var3);
                this.field_75233_a.setInventorySlotContents(1, var4);
                this.field_75234_h.func_70933_a(var2);
            }
        }
    }

    private boolean func_75230_a(MerchantRecipe par1MerchantRecipe, ItemStack par2ItemStack, ItemStack par3ItemStack)
    {
        ItemStack var4 = par1MerchantRecipe.getItemToBuy();
        ItemStack var5 = par1MerchantRecipe.getSecondItemToBuy();

        if (par2ItemStack != null && par2ItemStack.itemID == var4.itemID)
        {
            if (var5 != null && par3ItemStack != null && var5.itemID == par3ItemStack.itemID)
            {
                par2ItemStack.stackSize -= var4.stackSize;
                par3ItemStack.stackSize -= var5.stackSize;
                return true;
            }

            if (var5 == null && par3ItemStack == null)
            {
                par2ItemStack.stackSize -= var4.stackSize;
                return true;
            }
        }

        return false;
    }
}
