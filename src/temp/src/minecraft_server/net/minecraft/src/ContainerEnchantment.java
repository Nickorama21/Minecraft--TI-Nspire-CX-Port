package net.minecraft.src;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.Container;
import net.minecraft.src.EnchantmentData;
import net.minecraft.src.EnchantmentHelper;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.ICrafting;
import net.minecraft.src.IInventory;
import net.minecraft.src.InventoryPlayer;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Slot;
import net.minecraft.src.SlotEnchantment;
import net.minecraft.src.SlotEnchantmentTable;
import net.minecraft.src.World;

public class ContainerEnchantment extends Container {

   public IInventory field_75168_e = new SlotEnchantmentTable(this, "Enchant", 1);
   private World field_75172_h;
   private int field_75173_i;
   private int field_75170_j;
   private int field_75171_k;
   private Random field_75169_l = new Random();
   public long field_75166_f;
   public int[] field_75167_g = new int[3];


   public ContainerEnchantment(InventoryPlayer p_i3606_1_, World p_i3606_2_, int p_i3606_3_, int p_i3606_4_, int p_i3606_5_) {
      this.field_75172_h = p_i3606_2_;
      this.field_75173_i = p_i3606_3_;
      this.field_75170_j = p_i3606_4_;
      this.field_75171_k = p_i3606_5_;
      this.func_75146_a(new SlotEnchantment(this, this.field_75168_e, 0, 25, 47));

      int var6;
      for(var6 = 0; var6 < 3; ++var6) {
         for(int var7 = 0; var7 < 9; ++var7) {
            this.func_75146_a(new Slot(p_i3606_1_, var7 + var6 * 9 + 9, 8 + var7 * 18, 84 + var6 * 18));
         }
      }

      for(var6 = 0; var6 < 9; ++var6) {
         this.func_75146_a(new Slot(p_i3606_1_, var6, 8 + var6 * 18, 142));
      }

   }

   public void func_75132_a(ICrafting p_75132_1_) {
      super.func_75132_a(p_75132_1_);
      p_75132_1_.func_71112_a(this, 0, this.field_75167_g[0]);
      p_75132_1_.func_71112_a(this, 1, this.field_75167_g[1]);
      p_75132_1_.func_71112_a(this, 2, this.field_75167_g[2]);
   }

   public void func_75142_b() {
      super.func_75142_b();
      Iterator var1 = this.field_75149_d.iterator();

      while(var1.hasNext()) {
         ICrafting var2 = (ICrafting)var1.next();
         var2.func_71112_a(this, 0, this.field_75167_g[0]);
         var2.func_71112_a(this, 1, this.field_75167_g[1]);
         var2.func_71112_a(this, 2, this.field_75167_g[2]);
      }

   }

   public void func_75130_a(IInventory p_75130_1_) {
      if(p_75130_1_ == this.field_75168_e) {
         ItemStack var2 = p_75130_1_.func_70301_a(0);
         int var3;
         if(var2 != null && var2.func_77956_u()) {
            this.field_75166_f = this.field_75169_l.nextLong();
            if(!this.field_75172_h.field_72995_K) {
               var3 = 0;

               int var4;
               for(var4 = -1; var4 <= 1; ++var4) {
                  for(int var5 = -1; var5 <= 1; ++var5) {
                     if((var4 != 0 || var5 != 0) && this.field_75172_h.func_72799_c(this.field_75173_i + var5, this.field_75170_j, this.field_75171_k + var4) && this.field_75172_h.func_72799_c(this.field_75173_i + var5, this.field_75170_j + 1, this.field_75171_k + var4)) {
                        if(this.field_75172_h.func_72798_a(this.field_75173_i + var5 * 2, this.field_75170_j, this.field_75171_k + var4 * 2) == Block.field_72093_an.field_71990_ca) {
                           ++var3;
                        }

                        if(this.field_75172_h.func_72798_a(this.field_75173_i + var5 * 2, this.field_75170_j + 1, this.field_75171_k + var4 * 2) == Block.field_72093_an.field_71990_ca) {
                           ++var3;
                        }

                        if(var5 != 0 && var4 != 0) {
                           if(this.field_75172_h.func_72798_a(this.field_75173_i + var5 * 2, this.field_75170_j, this.field_75171_k + var4) == Block.field_72093_an.field_71990_ca) {
                              ++var3;
                           }

                           if(this.field_75172_h.func_72798_a(this.field_75173_i + var5 * 2, this.field_75170_j + 1, this.field_75171_k + var4) == Block.field_72093_an.field_71990_ca) {
                              ++var3;
                           }

                           if(this.field_75172_h.func_72798_a(this.field_75173_i + var5, this.field_75170_j, this.field_75171_k + var4 * 2) == Block.field_72093_an.field_71990_ca) {
                              ++var3;
                           }

                           if(this.field_75172_h.func_72798_a(this.field_75173_i + var5, this.field_75170_j + 1, this.field_75171_k + var4 * 2) == Block.field_72093_an.field_71990_ca) {
                              ++var3;
                           }
                        }
                     }
                  }
               }

               for(var4 = 0; var4 < 3; ++var4) {
                  this.field_75167_g[var4] = EnchantmentHelper.func_77514_a(this.field_75169_l, var4, var3, var2);
               }

               this.func_75142_b();
            }
         } else {
            for(var3 = 0; var3 < 3; ++var3) {
               this.field_75167_g[var3] = 0;
            }
         }
      }

   }

   public boolean func_75140_a(EntityPlayer p_75140_1_, int p_75140_2_) {
      ItemStack var3 = this.field_75168_e.func_70301_a(0);
      if(this.field_75167_g[p_75140_2_] > 0 && var3 != null && (p_75140_1_.field_71068_ca >= this.field_75167_g[p_75140_2_] || p_75140_1_.field_71075_bZ.field_75098_d)) {
         if(!this.field_75172_h.field_72995_K) {
            List var4 = EnchantmentHelper.func_77513_b(this.field_75169_l, var3, this.field_75167_g[p_75140_2_]);
            if(var4 != null) {
               p_75140_1_.func_71032_a(this.field_75167_g[p_75140_2_]);
               Iterator var5 = var4.iterator();

               while(var5.hasNext()) {
                  EnchantmentData var6 = (EnchantmentData)var5.next();
                  var3.func_77966_a(var6.field_76302_b, var6.field_76303_c);
               }

               this.func_75130_a(this.field_75168_e);
            }
         }

         return true;
      } else {
         return false;
      }
   }

   public void func_75134_a(EntityPlayer p_75134_1_) {
      super.func_75134_a(p_75134_1_);
      if(!this.field_75172_h.field_72995_K) {
         ItemStack var2 = this.field_75168_e.func_70304_b(0);
         if(var2 != null) {
            p_75134_1_.func_71021_b(var2);
         }

      }
   }

   public boolean func_75145_c(EntityPlayer p_75145_1_) {
      return this.field_75172_h.func_72798_a(this.field_75173_i, this.field_75170_j, this.field_75171_k) != Block.field_72096_bE.field_71990_ca?false:p_75145_1_.func_70092_e((double)this.field_75173_i + 0.5D, (double)this.field_75170_j + 0.5D, (double)this.field_75171_k + 0.5D) <= 64.0D;
   }

   public ItemStack func_75143_b(int p_75143_1_) {
      ItemStack var2 = null;
      Slot var3 = (Slot)this.field_75151_b.get(p_75143_1_);
      if(var3 != null && var3.func_75216_d()) {
         ItemStack var4 = var3.func_75211_c();
         var2 = var4.func_77946_l();
         if(p_75143_1_ == 0) {
            if(!this.func_75135_a(var4, 1, 37, true)) {
               return null;
            }
         } else {
            if(((Slot)this.field_75151_b.get(0)).func_75216_d() || !((Slot)this.field_75151_b.get(0)).func_75214_a(var4)) {
               return null;
            }

            if(var4.func_77942_o() && var4.field_77994_a == 1) {
               ((Slot)this.field_75151_b.get(0)).func_75215_d(var4.func_77946_l());
               var4.field_77994_a = 0;
            } else if(var4.field_77994_a >= 1) {
               ((Slot)this.field_75151_b.get(0)).func_75215_d(new ItemStack(var4.field_77993_c, 1, var4.func_77960_j()));
               --var4.field_77994_a;
            }
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
