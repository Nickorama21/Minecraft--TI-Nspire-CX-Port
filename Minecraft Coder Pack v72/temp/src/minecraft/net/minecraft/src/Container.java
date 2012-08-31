package net.minecraft.src;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.ICrafting;
import net.minecraft.src.IInventory;
import net.minecraft.src.InventoryPlayer;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Slot;

public abstract class Container {

   public List field_75153_a = new ArrayList();
   public List field_75151_b = new ArrayList();
   public int field_75152_c = 0;
   private short field_75150_e = 0;
   protected List field_75149_d = new ArrayList();
   private Set field_75148_f = new HashSet();


   protected Slot func_75146_a(Slot p_75146_1_) {
      p_75146_1_.field_75222_d = this.field_75151_b.size();
      this.field_75151_b.add(p_75146_1_);
      this.field_75153_a.add((Object)null);
      return p_75146_1_;
   }

   public void func_75132_a(ICrafting p_75132_1_) {
      if(this.field_75149_d.contains(p_75132_1_)) {
         throw new IllegalArgumentException("Listener already listening");
      } else {
         this.field_75149_d.add(p_75132_1_);
         p_75132_1_.func_71110_a(this, this.func_75138_a());
         this.func_75142_b();
      }
   }

   public List func_75138_a() {
      ArrayList var1 = new ArrayList();
      Iterator var2 = this.field_75151_b.iterator();

      while(var2.hasNext()) {
         Slot var3 = (Slot)var2.next();
         var1.add(var3.func_75211_c());
      }

      return var1;
   }

   public void func_75142_b() {
      for(int var1 = 0; var1 < this.field_75151_b.size(); ++var1) {
         ItemStack var2 = ((Slot)this.field_75151_b.get(var1)).func_75211_c();
         ItemStack var3 = (ItemStack)this.field_75153_a.get(var1);
         if(!ItemStack.func_77989_b(var3, var2)) {
            var3 = var2 == null?null:var2.func_77946_l();
            this.field_75153_a.set(var1, var3);
            Iterator var4 = this.field_75149_d.iterator();

            while(var4.hasNext()) {
               ICrafting var5 = (ICrafting)var4.next();
               var5.func_71111_a(this, var1, var3);
            }
         }
      }

   }

   public boolean func_75140_a(EntityPlayer p_75140_1_, int p_75140_2_) {
      return false;
   }

   public Slot func_75147_a(IInventory p_75147_1_, int p_75147_2_) {
      Iterator var3 = this.field_75151_b.iterator();

      Slot var4;
      do {
         if(!var3.hasNext()) {
            return null;
         }

         var4 = (Slot)var3.next();
      } while(!var4.func_75217_a(p_75147_1_, p_75147_2_));

      return var4;
   }

   public Slot func_75139_a(int p_75139_1_) {
      return (Slot)this.field_75151_b.get(p_75139_1_);
   }

   public ItemStack func_75143_b(int p_75143_1_) {
      Slot var2 = (Slot)this.field_75151_b.get(p_75143_1_);
      return var2 != null?var2.func_75211_c():null;
   }

   public ItemStack func_75144_a(int p_75144_1_, int p_75144_2_, boolean p_75144_3_, EntityPlayer p_75144_4_) {
      ItemStack var5 = null;
      if(p_75144_2_ > 1) {
         return null;
      } else {
         if(p_75144_2_ == 0 || p_75144_2_ == 1) {
            InventoryPlayer var6 = p_75144_4_.field_71071_by;
            if(p_75144_1_ == -999) {
               if(var6.func_70445_o() != null && p_75144_1_ == -999) {
                  if(p_75144_2_ == 0) {
                     p_75144_4_.func_71021_b(var6.func_70445_o());
                     var6.func_70437_b((ItemStack)null);
                  }

                  if(p_75144_2_ == 1) {
                     p_75144_4_.func_71021_b(var6.func_70445_o().func_77979_a(1));
                     if(var6.func_70445_o().field_77994_a == 0) {
                        var6.func_70437_b((ItemStack)null);
                     }
                  }
               }
            } else if(p_75144_3_) {
               ItemStack var7 = this.func_75143_b(p_75144_1_);
               if(var7 != null) {
                  int var8 = var7.field_77993_c;
                  var5 = var7.func_77946_l();
                  Slot var9 = (Slot)this.field_75151_b.get(p_75144_1_);
                  if(var9 != null && var9.func_75211_c() != null && var9.func_75211_c().field_77993_c == var8) {
                     this.func_75133_b(p_75144_1_, p_75144_2_, p_75144_3_, p_75144_4_);
                  }
               }
            } else {
               if(p_75144_1_ < 0) {
                  return null;
               }

               Slot var12 = (Slot)this.field_75151_b.get(p_75144_1_);
               if(var12 != null) {
                  ItemStack var13 = var12.func_75211_c();
                  ItemStack var14 = var6.func_70445_o();
                  if(var13 != null) {
                     var5 = var13.func_77946_l();
                  }

                  int var10;
                  if(var13 == null) {
                     if(var14 != null && var12.func_75214_a(var14)) {
                        var10 = p_75144_2_ == 0?var14.field_77994_a:1;
                        if(var10 > var12.func_75219_a()) {
                           var10 = var12.func_75219_a();
                        }

                        var12.func_75215_d(var14.func_77979_a(var10));
                        if(var14.field_77994_a == 0) {
                           var6.func_70437_b((ItemStack)null);
                        }
                     }
                  } else if(var14 == null) {
                     var10 = p_75144_2_ == 0?var13.field_77994_a:(var13.field_77994_a + 1) / 2;
                     ItemStack var11 = var12.func_75209_a(var10);
                     var6.func_70437_b(var11);
                     if(var13.field_77994_a == 0) {
                        var12.func_75215_d((ItemStack)null);
                     }

                     var12.func_75213_b(var6.func_70445_o());
                  } else if(var12.func_75214_a(var14)) {
                     if(var13.field_77993_c == var14.field_77993_c && (!var13.func_77981_g() || var13.func_77960_j() == var14.func_77960_j()) && ItemStack.func_77970_a(var13, var14)) {
                        var10 = p_75144_2_ == 0?var14.field_77994_a:1;
                        if(var10 > var12.func_75219_a() - var13.field_77994_a) {
                           var10 = var12.func_75219_a() - var13.field_77994_a;
                        }

                        if(var10 > var14.func_77976_d() - var13.field_77994_a) {
                           var10 = var14.func_77976_d() - var13.field_77994_a;
                        }

                        var14.func_77979_a(var10);
                        if(var14.field_77994_a == 0) {
                           var6.func_70437_b((ItemStack)null);
                        }

                        var13.field_77994_a += var10;
                     } else if(var14.field_77994_a <= var12.func_75219_a()) {
                        var12.func_75215_d(var14);
                        var6.func_70437_b(var13);
                     }
                  } else if(var13.field_77993_c == var14.field_77993_c && var14.func_77976_d() > 1 && (!var13.func_77981_g() || var13.func_77960_j() == var14.func_77960_j()) && ItemStack.func_77970_a(var13, var14)) {
                     var10 = var13.field_77994_a;
                     if(var10 > 0 && var10 + var14.field_77994_a <= var14.func_77976_d()) {
                        var14.field_77994_a += var10;
                        var13 = var12.func_75209_a(var10);
                        if(var13.field_77994_a == 0) {
                           var12.func_75215_d((ItemStack)null);
                        }

                        var12.func_75213_b(var6.func_70445_o());
                     }
                  }

                  var12.func_75218_e();
               }
            }
         }

         return var5;
      }
   }

   protected void func_75133_b(int p_75133_1_, int p_75133_2_, boolean p_75133_3_, EntityPlayer p_75133_4_) {
      this.func_75144_a(p_75133_1_, p_75133_2_, p_75133_3_, p_75133_4_);
   }

   public void func_75134_a(EntityPlayer p_75134_1_) {
      InventoryPlayer var2 = p_75134_1_.field_71071_by;
      if(var2.func_70445_o() != null) {
         p_75134_1_.func_71021_b(var2.func_70445_o());
         var2.func_70437_b((ItemStack)null);
      }

   }

   public void func_75130_a(IInventory p_75130_1_) {
      this.func_75142_b();
   }

   public void func_75141_a(int p_75141_1_, ItemStack p_75141_2_) {
      this.func_75139_a(p_75141_1_).func_75215_d(p_75141_2_);
   }

   public void func_75131_a(ItemStack[] p_75131_1_) {
      for(int var2 = 0; var2 < p_75131_1_.length; ++var2) {
         this.func_75139_a(var2).func_75215_d(p_75131_1_[var2]);
      }

   }

   public void func_75137_b(int p_75137_1_, int p_75137_2_) {}

   public short func_75136_a(InventoryPlayer p_75136_1_) {
      ++this.field_75150_e;
      return this.field_75150_e;
   }

   public boolean func_75129_b(EntityPlayer p_75129_1_) {
      return !this.field_75148_f.contains(p_75129_1_);
   }

   public void func_75128_a(EntityPlayer p_75128_1_, boolean p_75128_2_) {
      if(p_75128_2_) {
         this.field_75148_f.remove(p_75128_1_);
      } else {
         this.field_75148_f.add(p_75128_1_);
      }

   }

   public abstract boolean func_75145_c(EntityPlayer var1);

   protected boolean func_75135_a(ItemStack p_75135_1_, int p_75135_2_, int p_75135_3_, boolean p_75135_4_) {
      boolean var5 = false;
      int var6 = p_75135_2_;
      if(p_75135_4_) {
         var6 = p_75135_3_ - 1;
      }

      Slot var7;
      ItemStack var8;
      if(p_75135_1_.func_77985_e()) {
         while(p_75135_1_.field_77994_a > 0 && (!p_75135_4_ && var6 < p_75135_3_ || p_75135_4_ && var6 >= p_75135_2_)) {
            var7 = (Slot)this.field_75151_b.get(var6);
            var8 = var7.func_75211_c();
            if(var8 != null && var8.field_77993_c == p_75135_1_.field_77993_c && (!p_75135_1_.func_77981_g() || p_75135_1_.func_77960_j() == var8.func_77960_j()) && ItemStack.func_77970_a(p_75135_1_, var8)) {
               int var9 = var8.field_77994_a + p_75135_1_.field_77994_a;
               if(var9 <= p_75135_1_.func_77976_d()) {
                  p_75135_1_.field_77994_a = 0;
                  var8.field_77994_a = var9;
                  var7.func_75218_e();
                  var5 = true;
               } else if(var8.field_77994_a < p_75135_1_.func_77976_d()) {
                  p_75135_1_.field_77994_a -= p_75135_1_.func_77976_d() - var8.field_77994_a;
                  var8.field_77994_a = p_75135_1_.func_77976_d();
                  var7.func_75218_e();
                  var5 = true;
               }
            }

            if(p_75135_4_) {
               --var6;
            } else {
               ++var6;
            }
         }
      }

      if(p_75135_1_.field_77994_a > 0) {
         if(p_75135_4_) {
            var6 = p_75135_3_ - 1;
         } else {
            var6 = p_75135_2_;
         }

         while(!p_75135_4_ && var6 < p_75135_3_ || p_75135_4_ && var6 >= p_75135_2_) {
            var7 = (Slot)this.field_75151_b.get(var6);
            var8 = var7.func_75211_c();
            if(var8 == null) {
               var7.func_75215_d(p_75135_1_.func_77946_l());
               var7.func_75218_e();
               p_75135_1_.field_77994_a = 0;
               var5 = true;
               break;
            }

            if(p_75135_4_) {
               --var6;
            } else {
               ++var6;
            }
         }
      }

      return var5;
   }
}
