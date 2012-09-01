package net.minecraft.src;

import java.util.Iterator;
import net.minecraft.src.Container;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.ICrafting;
import net.minecraft.src.InventoryPlayer;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Slot;
import net.minecraft.src.SlotBrewingStandIngredient;
import net.minecraft.src.SlotBrewingStandPotion;
import net.minecraft.src.TileEntityBrewingStand;

public class ContainerBrewingStand extends Container {

   private TileEntityBrewingStand field_75188_e;
   private final Slot field_75186_f;
   private int field_75187_g = 0;


   public ContainerBrewingStand(InventoryPlayer p_i3600_1_, TileEntityBrewingStand p_i3600_2_) {
      this.field_75188_e = p_i3600_2_;
      this.func_75146_a(new SlotBrewingStandPotion(p_i3600_1_.field_70458_d, p_i3600_2_, 0, 56, 46));
      this.func_75146_a(new SlotBrewingStandPotion(p_i3600_1_.field_70458_d, p_i3600_2_, 1, 79, 53));
      this.func_75146_a(new SlotBrewingStandPotion(p_i3600_1_.field_70458_d, p_i3600_2_, 2, 102, 46));
      this.field_75186_f = this.func_75146_a(new SlotBrewingStandIngredient(this, p_i3600_2_, 3, 79, 17));

      int var3;
      for(var3 = 0; var3 < 3; ++var3) {
         for(int var4 = 0; var4 < 9; ++var4) {
            this.func_75146_a(new Slot(p_i3600_1_, var4 + var3 * 9 + 9, 8 + var4 * 18, 84 + var3 * 18));
         }
      }

      for(var3 = 0; var3 < 9; ++var3) {
         this.func_75146_a(new Slot(p_i3600_1_, var3, 8 + var3 * 18, 142));
      }

   }

   public void func_75132_a(ICrafting p_75132_1_) {
      super.func_75132_a(p_75132_1_);
      p_75132_1_.func_71112_a(this, 0, this.field_75188_e.func_70355_t_());
   }

   public void func_75142_b() {
      super.func_75142_b();
      Iterator var1 = this.field_75149_d.iterator();

      while(var1.hasNext()) {
         ICrafting var2 = (ICrafting)var1.next();
         if(this.field_75187_g != this.field_75188_e.func_70355_t_()) {
            var2.func_71112_a(this, 0, this.field_75188_e.func_70355_t_());
         }
      }

      this.field_75187_g = this.field_75188_e.func_70355_t_();
   }

   public boolean func_75145_c(EntityPlayer p_75145_1_) {
      return this.field_75188_e.func_70300_a(p_75145_1_);
   }

   public ItemStack func_75143_b(int p_75143_1_) {
      ItemStack var2 = null;
      Slot var3 = (Slot)this.field_75151_b.get(p_75143_1_);
      if(var3 != null && var3.func_75216_d()) {
         ItemStack var4 = var3.func_75211_c();
         var2 = var4.func_77946_l();
         if((p_75143_1_ < 0 || p_75143_1_ > 2) && p_75143_1_ != 3) {
            if(!this.field_75186_f.func_75216_d() && this.field_75186_f.func_75214_a(var4)) {
               if(!this.func_75135_a(var4, 3, 4, false)) {
                  return null;
               }
            } else if(SlotBrewingStandPotion.func_75243_a_(var2)) {
               if(!this.func_75135_a(var4, 0, 3, false)) {
                  return null;
               }
            } else if(p_75143_1_ >= 4 && p_75143_1_ < 31) {
               if(!this.func_75135_a(var4, 31, 40, false)) {
                  return null;
               }
            } else if(p_75143_1_ >= 31 && p_75143_1_ < 40) {
               if(!this.func_75135_a(var4, 4, 31, false)) {
                  return null;
               }
            } else if(!this.func_75135_a(var4, 4, 40, false)) {
               return null;
            }
         } else {
            if(!this.func_75135_a(var4, 4, 40, true)) {
               return null;
            }

            var3.func_75220_a(var4, var2);
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
