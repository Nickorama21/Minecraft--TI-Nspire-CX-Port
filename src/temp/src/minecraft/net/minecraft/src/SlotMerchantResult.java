package net.minecraft.src;

import net.minecraft.src.EntityPlayer;
import net.minecraft.src.IMerchant;
import net.minecraft.src.InventoryMerchant;
import net.minecraft.src.ItemStack;
import net.minecraft.src.MerchantRecipe;
import net.minecraft.src.Slot;

public class SlotMerchantResult extends Slot {

   private final InventoryMerchant field_75233_a;
   private EntityPlayer field_75232_b;
   private int field_75231_g;
   private final IMerchant field_75234_h;


   public SlotMerchantResult(EntityPlayer p_i3614_1_, IMerchant p_i3614_2_, InventoryMerchant p_i3614_3_, int p_i3614_4_, int p_i3614_5_, int p_i3614_6_) {
      super(p_i3614_3_, p_i3614_4_, p_i3614_5_, p_i3614_6_);
      this.field_75232_b = p_i3614_1_;
      this.field_75234_h = p_i3614_2_;
      this.field_75233_a = p_i3614_3_;
   }

   public boolean func_75214_a(ItemStack p_75214_1_) {
      return false;
   }

   public ItemStack func_75209_a(int p_75209_1_) {
      if(this.func_75216_d()) {
         this.field_75231_g += Math.min(p_75209_1_, this.func_75211_c().field_77994_a);
      }

      return super.func_75209_a(p_75209_1_);
   }

   protected void func_75210_a(ItemStack p_75210_1_, int p_75210_2_) {
      this.field_75231_g += p_75210_2_;
      this.func_75208_c(p_75210_1_);
   }

   protected void func_75208_c(ItemStack p_75208_1_) {
      p_75208_1_.func_77980_a(this.field_75232_b.field_70170_p, this.field_75232_b, this.field_75231_g);
      this.field_75231_g = 0;
   }

   public void func_75213_b(ItemStack p_75213_1_) {
      this.func_75208_c(p_75213_1_);
      MerchantRecipe var2 = this.field_75233_a.func_70468_h();
      if(var2 != null) {
         ItemStack var3 = this.field_75233_a.func_70301_a(0);
         ItemStack var4 = this.field_75233_a.func_70301_a(1);
         if(this.func_75230_a(var2, var3, var4) || this.func_75230_a(var2, var4, var3)) {
            if(var3 != null && var3.field_77994_a <= 0) {
               var3 = null;
            }

            if(var4 != null && var4.field_77994_a <= 0) {
               var4 = null;
            }

            this.field_75233_a.func_70299_a(0, var3);
            this.field_75233_a.func_70299_a(1, var4);
            this.field_75234_h.func_70933_a(var2);
         }
      }

   }

   private boolean func_75230_a(MerchantRecipe p_75230_1_, ItemStack p_75230_2_, ItemStack p_75230_3_) {
      ItemStack var4 = p_75230_1_.func_77394_a();
      ItemStack var5 = p_75230_1_.func_77396_b();
      if(p_75230_2_ != null && p_75230_2_.field_77993_c == var4.field_77993_c) {
         if(var5 != null && p_75230_3_ != null && var5.field_77993_c == p_75230_3_.field_77993_c) {
            p_75230_2_.field_77994_a -= var4.field_77994_a;
            p_75230_3_.field_77994_a -= var5.field_77994_a;
            return true;
         }

         if(var5 == null && p_75230_3_ == null) {
            p_75230_2_.field_77994_a -= var4.field_77994_a;
            return true;
         }
      }

      return false;
   }
}
