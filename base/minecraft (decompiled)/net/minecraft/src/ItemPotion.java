package net.minecraft.src;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ItemPotion extends Item
{
    /** maps potion damage values to lists of effect names */
    private HashMap effectCache = new HashMap();
    private static final Map field_77835_b = new LinkedHashMap();

    public ItemPotion(int par1)
    {
        super(par1);
        this.setMaxStackSize(1);
        this.setHasSubtypes(true);
        this.setMaxDamage(0);
        this.setTabToDisplayOn(CreativeTabs.tabBrewing);
    }

    /**
     * Returns a list of potion effects for the specified itemstack.
     */
    public List getEffects(ItemStack par1ItemStack)
    {
        return this.getEffects(par1ItemStack.getItemDamage());
    }

    /**
     * Returns a list of effects for the specified potion damage value.
     */
    public List getEffects(int par1)
    {
        List var2 = (List)this.effectCache.get(Integer.valueOf(par1));

        if (var2 == null)
        {
            var2 = PotionHelper.getPotionEffects(par1, false);
            this.effectCache.put(Integer.valueOf(par1), var2);
        }

        return var2;
    }

    public ItemStack onFoodEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        if (!par3EntityPlayer.capabilities.isCreativeMode)
        {
            --par1ItemStack.stackSize;
        }

        if (!par2World.isRemote)
        {
            List var4 = this.getEffects(par1ItemStack);

            if (var4 != null)
            {
                Iterator var5 = var4.iterator();

                while (var5.hasNext())
                {
                    PotionEffect var6 = (PotionEffect)var5.next();
                    par3EntityPlayer.addPotionEffect(new PotionEffect(var6));
                }
            }
        }

        if (!par3EntityPlayer.capabilities.isCreativeMode)
        {
            if (par1ItemStack.stackSize <= 0)
            {
                return new ItemStack(Item.glassBottle);
            }

            par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Item.glassBottle));
        }

        return par1ItemStack;
    }

    /**
     * How long it takes to use or consume an item
     */
    public int getMaxItemUseDuration(ItemStack par1ItemStack)
    {
        return 32;
    }

    /**
     * returns the action that specifies what animation to play when the items is being used
     */
    public EnumAction getItemUseAction(ItemStack par1ItemStack)
    {
        return EnumAction.drink;
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        if (isSplash(par1ItemStack.getItemDamage()))
        {
            if (!par3EntityPlayer.capabilities.isCreativeMode)
            {
                --par1ItemStack.stackSize;
            }

            par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

            if (!par2World.isRemote)
            {
                par2World.spawnEntityInWorld(new EntityPotion(par2World, par3EntityPlayer, par1ItemStack.getItemDamage()));
            }

            return par1ItemStack;
        }
        else
        {
            par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
            return par1ItemStack;
        }
    }

    public boolean tryPlaceIntoWorld(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
        return false;
    }

    /**
     * Gets an icon index based on an item's damage value
     */
    public int getIconFromDamage(int par1)
    {
        return isSplash(par1) ? 154 : 140;
    }

    /**
     * Gets an icon index based on an item's damage value and the given render pass
     */
    public int getIconFromDamageForRenderPass(int par1, int par2)
    {
        return par2 == 0 ? 141 : super.getIconFromDamageForRenderPass(par1, par2);
    }

    /**
     * returns wether or not a potion is a throwable splash potion based on damage value
     */
    public static boolean isSplash(int par0)
    {
        return (par0 & 16384) != 0;
    }

    public int getColorFromDamage(int par1, int par2)
    {
        return par2 > 0 ? 16777215 : PotionHelper.func_77915_a(par1, false);
    }

    public boolean requiresMultipleRenderPasses()
    {
        return true;
    }

    public boolean isEffectInstant(int par1)
    {
        List var2 = this.getEffects(par1);

        if (var2 != null && !var2.isEmpty())
        {
            Iterator var3 = var2.iterator();
            PotionEffect var4;

            do
            {
                if (!var3.hasNext())
                {
                    return false;
                }

                var4 = (PotionEffect)var3.next();
            }
            while (!Potion.potionTypes[var4.getPotionID()].isInstant());

            return true;
        }
        else
        {
            return false;
        }
    }

    public String getItemDisplayName(ItemStack par1ItemStack)
    {
        if (par1ItemStack.getItemDamage() == 0)
        {
            return StatCollector.translateToLocal("item.emptyPotion.name").trim();
        }
        else
        {
            String var2 = "";

            if (isSplash(par1ItemStack.getItemDamage()))
            {
                var2 = StatCollector.translateToLocal("potion.prefix.grenade").trim() + " ";
            }

            List var3 = Item.potion.getEffects(par1ItemStack);
            String var4;

            if (var3 != null && !var3.isEmpty())
            {
                var4 = ((PotionEffect)var3.get(0)).getEffectName();
                var4 = var4 + ".postfix";
                return var2 + StatCollector.translateToLocal(var4).trim();
            }
            else
            {
                var4 = PotionHelper.func_77905_c(par1ItemStack.getItemDamage());
                return StatCollector.translateToLocal(var4).trim() + " " + super.getItemDisplayName(par1ItemStack);
            }
        }
    }

    /**
     * allows items to add custom lines of information to the mouseover description
     */
    public void addInformation(ItemStack par1ItemStack, List par2List)
    {
        if (par1ItemStack.getItemDamage() != 0)
        {
            List var3 = Item.potion.getEffects(par1ItemStack);

            if (var3 != null && !var3.isEmpty())
            {
                Iterator var7 = var3.iterator();

                while (var7.hasNext())
                {
                    PotionEffect var5 = (PotionEffect)var7.next();
                    String var6 = StatCollector.translateToLocal(var5.getEffectName()).trim();

                    if (var5.getAmplifier() > 0)
                    {
                        var6 = var6 + " " + StatCollector.translateToLocal("potion.potency." + var5.getAmplifier()).trim();
                    }

                    if (var5.getDuration() > 20)
                    {
                        var6 = var6 + " (" + Potion.getDurationString(var5) + ")";
                    }

                    if (Potion.potionTypes[var5.getPotionID()].isBadEffect())
                    {
                        par2List.add("\u00a7c" + var6);
                    }
                    else
                    {
                        par2List.add("\u00a77" + var6);
                    }
                }
            }
            else
            {
                String var4 = StatCollector.translateToLocal("potion.empty").trim();
                par2List.add("\u00a77" + var4);
            }
        }
    }

    public boolean hasEffect(ItemStack par1ItemStack)
    {
        List var2 = this.getEffects(par1ItemStack);
        return var2 != null && !var2.isEmpty();
    }

    /**
     * returns a list of items with the same ID, but different meta (eg: dye returns 16 items)
     */
    public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        super.getSubItems(par1, par2CreativeTabs, par3List);

        if (field_77835_b.isEmpty())
        {
            for (int var4 = 0; var4 <= 32767; ++var4)
            {
                List var5 = PotionHelper.getPotionEffects(var4, false);

                if (var5 != null && !var5.isEmpty())
                {
                    field_77835_b.put(var5, Integer.valueOf(var4));
                }
            }
        }

        Iterator var6 = field_77835_b.values().iterator();

        while (var6.hasNext())
        {
            int var7 = ((Integer)var6.next()).intValue();
            par3List.add(new ItemStack(par1, 1, var7));
        }
    }
}
