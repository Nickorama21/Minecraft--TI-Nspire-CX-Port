package net.minecraft.src;

import net.minecraft.src.Container;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.IInventory;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Slot;
import net.minecraft.src.TileEntityDispenser;

public class ContainerDispenser extends Container {

   private TileEntityDispenser field_75182_e;


   public ContainerDispenser(IInventory p_i3617_1_, TileEntityDispenser p_i3617_2_) {
      this.field_75182_e = p_i3617_2_;

      int var3;
      int var4;
      for(var3 = 0; var3 < 3; ++var3) {
         for(var4 = 0; var4 < 3; ++var4) {
            this.func_75146_a(new Slot(p_i3617_2_, var4 + var3 * 3, 62 + var4 * 18, 17 + var3 * 18));
         }
      }

      for(var3 = 0; var3 < 3; ++var3) {
         for(var4 = 0; var4 < 9; ++var4) {
            this.func_75146_a(new Slot(p_i3617_1_, var4 + var3 * 9 + 9, 8 + var4 * 18, 84 + var3 * 18));
         }
      }

      for(var3 = 0; var3 < 9; ++var3) {
         this.func_75146_a(new Slot(p_i3617_1_, var3, 8 + var3 * 18, 142));
      }

   }

   public boolean func_75145_c(EntityPlayer p_75145_1_) {
      return this.field_75182_e.func_70300_a(p_75145_1_);
   }

   public ItemStack func_75143_b(int p_75143_1_) {
      ItemStack var2 = null;
      Slot var3 = (Slot)this.field_75151_b.get(p_75143_1_);
      if(var3 != null && var3.func_75216_d()) {
         ItemStack var4 = var3.func_75211_c();
         var2 = var4.func_77946_l();
         if(p_75143_1_ < 9) {
            if(!this.func_75135_a(var4, 9, 45, true)) {
               return null;
            }
         } else if(!this.func_75135_a(var4, 0, 9, false)) {
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
