package net.minecraft.src;

import net.minecraft.src.Container;
import net.minecraft.src.CraftingManager;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.IInventory;
import net.minecraft.src.InventoryCraftResult;
import net.minecraft.src.InventoryCrafting;
import net.minecraft.src.InventoryPlayer;
import net.minecraft.src.ItemArmor;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Slot;
import net.minecraft.src.SlotArmor;
import net.minecraft.src.SlotCrafting;

public class ContainerPlayer extends Container {

   public InventoryCrafting field_75181_e;
   public IInventory field_75179_f;
   public boolean field_75180_g;


   public ContainerPlayer(InventoryPlayer p_i3610_1_) {
      this(p_i3610_1_, true);
   }

   public ContainerPlayer(InventoryPlayer p_i3611_1_, boolean p_i3611_2_) {
      this.field_75181_e = new InventoryCrafting(this, 2, 2);
      this.field_75179_f = new InventoryCraftResult();
      this.field_75180_g = false;
      this.field_75180_g = p_i3611_2_;
      this.func_75146_a(new SlotCrafting(p_i3611_1_.field_70458_d, this.field_75181_e, this.field_75179_f, 0, 144, 36));

      int var3;
      int var4;
      for(var3 = 0; var3 < 2; ++var3) {
         for(var4 = 0; var4 < 2; ++var4) {
            this.func_75146_a(new Slot(this.field_75181_e, var4 + var3 * 2, 88 + var4 * 18, 26 + var3 * 18));
         }
      }

      for(var3 = 0; var3 < 4; ++var3) {
         this.func_75146_a(new SlotArmor(this, p_i3611_1_, p_i3611_1_.func_70302_i_() - 1 - var3, 8, 8 + var3 * 18, var3));
      }

      for(var3 = 0; var3 < 3; ++var3) {
         for(var4 = 0; var4 < 9; ++var4) {
            this.func_75146_a(new Slot(p_i3611_1_, var4 + (var3 + 1) * 9, 8 + var4 * 18, 84 + var3 * 18));
         }
      }

      for(var3 = 0; var3 < 9; ++var3) {
         this.func_75146_a(new Slot(p_i3611_1_, var3, 8 + var3 * 18, 142));
      }

      this.func_75130_a(this.field_75181_e);
   }

   public void func_75130_a(IInventory p_75130_1_) {
      this.field_75179_f.func_70299_a(0, CraftingManager.func_77594_a().func_77593_a(this.field_75181_e));
   }

   public void func_75134_a(EntityPlayer p_75134_1_) {
      super.func_75134_a(p_75134_1_);

      for(int var2 = 0; var2 < 4; ++var2) {
         ItemStack var3 = this.field_75181_e.func_70304_b(var2);
         if(var3 != null) {
            p_75134_1_.func_71021_b(var3);
         }
      }

      this.field_75179_f.func_70299_a(0, (ItemStack)null);
   }

   public boolean func_75145_c(EntityPlayer p_75145_1_) {
      return true;
   }

   public ItemStack func_75143_b(int p_75143_1_) {
      ItemStack var2 = null;
      Slot var3 = (Slot)this.field_75151_b.get(p_75143_1_);
      if(var3 != null && var3.func_75216_d()) {
         ItemStack var4 = var3.func_75211_c();
         var2 = var4.func_77946_l();
         if(p_75143_1_ == 0) {
            if(!this.func_75135_a(var4, 9, 45, true)) {
               return null;
            }

            var3.func_75220_a(var4, var2);
         } else if(p_75143_1_ >= 1 && p_75143_1_ < 5) {
            if(!this.func_75135_a(var4, 9, 45, false)) {
               return null;
            }
         } else if(p_75143_1_ >= 5 && p_75143_1_ < 9) {
            if(!this.func_75135_a(var4, 9, 45, false)) {
               return null;
            }
         } else if(var2.func_77973_b() instanceof ItemArmor && !((Slot)this.field_75151_b.get(5 + ((ItemArmor)var2.func_77973_b()).field_77881_a)).func_75216_d()) {
            int var5 = 5 + ((ItemArmor)var2.func_77973_b()).field_77881_a;
            if(!this.func_75135_a(var4, var5, var5 + 1, false)) {
               return null;
            }
         } else if(p_75143_1_ >= 9 && p_75143_1_ < 36) {
            if(!this.func_75135_a(var4, 36, 45, false)) {
               return null;
            }
         } else if(p_75143_1_ >= 36 && p_75143_1_ < 45) {
            if(!this.func_75135_a(var4, 9, 36, false)) {
               return null;
            }
         } else if(!this.func_75135_a(var4, 9, 45, false)) {
            return null;
         }

         if(var4.field_77994_a == 0) {
            var3.func_75215_d((ItemStack)null);
         } else {
            var3.func_75218_e();
         }

         if(var4.field_77994_a == var2.field_77994_a) {
            return null;
         }

         var3.func_75213_b(var4);
      }

      return var2;
   }
}
