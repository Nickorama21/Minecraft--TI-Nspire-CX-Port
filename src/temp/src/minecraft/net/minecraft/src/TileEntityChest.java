package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.IInventory;
import net.minecraft.src.ItemStack;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.NBTTagList;
import net.minecraft.src.TileEntity;

public class TileEntityChest extends TileEntity implements IInventory {

   private ItemStack[] field_70428_i = new ItemStack[36];
   public boolean field_70425_a = false;
   public TileEntityChest field_70423_b;
   public TileEntityChest field_70424_c;
   public TileEntityChest field_70421_d;
   public TileEntityChest field_70422_e;
   public float field_70419_f;
   public float field_70420_g;
   public int field_70427_h;
   private int field_70426_j;


   public int func_70302_i_() {
      return 27;
   }

   public ItemStack func_70301_a(int p_70301_1_) {
      return this.field_70428_i[p_70301_1_];
   }

   public ItemStack func_70298_a(int p_70298_1_, int p_70298_2_) {
      if(this.field_70428_i[p_70298_1_] != null) {
         ItemStack var3;
         if(this.field_70428_i[p_70298_1_].field_77994_a <= p_70298_2_) {
            var3 = this.field_70428_i[p_70298_1_];
            this.field_70428_i[p_70298_1_] = null;
            this.func_70296_d();
            return var3;
         } else {
            var3 = this.field_70428_i[p_70298_1_].func_77979_a(p_70298_2_);
            if(this.field_70428_i[p_70298_1_].field_77994_a == 0) {
               this.field_70428_i[p_70298_1_] = null;
            }

            this.func_70296_d();
            return var3;
         }
      } else {
         return null;
      }
   }

   public ItemStack func_70304_b(int p_70304_1_) {
      if(this.field_70428_i[p_70304_1_] != null) {
         ItemStack var2 = this.field_70428_i[p_70304_1_];
         this.field_70428_i[p_70304_1_] = null;
         return var2;
      } else {
         return null;
      }
   }

   public void func_70299_a(int p_70299_1_, ItemStack p_70299_2_) {
      this.field_70428_i[p_70299_1_] = p_70299_2_;
      if(p_70299_2_ != null && p_70299_2_.field_77994_a > this.func_70297_j_()) {
         p_70299_2_.field_77994_a = this.func_70297_j_();
      }

      this.func_70296_d();
   }

   public String func_70303_b() {
      return "container.chest";
   }

   public void func_70307_a(NBTTagCompound p_70307_1_) {
      super.func_70307_a(p_70307_1_);
      NBTTagList var2 = p_70307_1_.func_74761_m("Items");
      this.field_70428_i = new ItemStack[this.func_70302_i_()];

      for(int var3 = 0; var3 < var2.func_74745_c(); ++var3) {
         NBTTagCompound var4 = (NBTTagCompound)var2.func_74743_b(var3);
         int var5 = var4.func_74771_c("Slot") & 255;
         if(var5 >= 0 && var5 < this.field_70428_i.length) {
            this.field_70428_i[var5] = ItemStack.func_77949_a(var4);
         }
      }

   }

   public void func_70310_b(NBTTagCompound p_70310_1_) {
      super.func_70310_b(p_70310_1_);
      NBTTagList var2 = new NBTTagList();

      for(int var3 = 0; var3 < this.field_70428_i.length; ++var3) {
         if(this.field_70428_i[var3] != null) {
            NBTTagCompound var4 = new NBTTagCompound();
            var4.func_74774_a("Slot", (byte)var3);
            this.field_70428_i[var3].func_77955_b(var4);
            var2.func_74742_a(var4);
         }
      }

      p_70310_1_.func_74782_a("Items", var2);
   }

   public int func_70297_j_() {
      return 64;
   }

   public boolean func_70300_a(EntityPlayer p_70300_1_) {
      return this.field_70331_k.func_72796_p(this.field_70329_l, this.field_70330_m, this.field_70327_n) != this?false:p_70300_1_.func_70092_e((double)this.field_70329_l + 0.5D, (double)this.field_70330_m + 0.5D, (double)this.field_70327_n + 0.5D) <= 64.0D;
   }

   public void func_70321_h() {
      super.func_70321_h();
      this.field_70425_a = false;
   }

   public void func_70418_i() {
      if(!this.field_70425_a) {
         this.field_70425_a = true;
         this.field_70423_b = null;
         this.field_70424_c = null;
         this.field_70421_d = null;
         this.field_70422_e = null;
         if(this.field_70331_k.func_72798_a(this.field_70329_l - 1, this.field_70330_m, this.field_70327_n) == Block.field_72077_au.field_71990_ca) {
            this.field_70421_d = (TileEntityChest)this.field_70331_k.func_72796_p(this.field_70329_l - 1, this.field_70330_m, this.field_70327_n);
         }

         if(this.field_70331_k.func_72798_a(this.field_70329_l + 1, this.field_70330_m, this.field_70327_n) == Block.field_72077_au.field_71990_ca) {
            this.field_70424_c = (TileEntityChest)this.field_70331_k.func_72796_p(this.field_70329_l + 1, this.field_70330_m, this.field_70327_n);
         }

         if(this.field_70331_k.func_72798_a(this.field_70329_l, this.field_70330_m, this.field_70327_n - 1) == Block.field_72077_au.field_71990_ca) {
            this.field_70423_b = (TileEntityChest)this.field_70331_k.func_72796_p(this.field_70329_l, this.field_70330_m, this.field_70327_n - 1);
         }

         if(this.field_70331_k.func_72798_a(this.field_70329_l, this.field_70330_m, this.field_70327_n + 1) == Block.field_72077_au.field_71990_ca) {
            this.field_70422_e = (TileEntityChest)this.field_70331_k.func_72796_p(this.field_70329_l, this.field_70330_m, this.field_70327_n + 1);
         }

         if(this.field_70423_b != null) {
            this.field_70423_b.func_70321_h();
         }

         if(this.field_70422_e != null) {
            this.field_70422_e.func_70321_h();
         }

         if(this.field_70424_c != null) {
            this.field_70424_c.func_70321_h();
         }

         if(this.field_70421_d != null) {
            this.field_70421_d.func_70321_h();
         }

      }
   }

   public void func_70316_g() {
      super.func_70316_g();
      this.func_70418_i();
      if(++this.field_70426_j % 20 * 4 == 0) {
         ;
      }

      this.field_70420_g = this.field_70419_f;
      float var1 = 0.1F;
      double var4;
      if(this.field_70427_h > 0 && this.field_70419_f == 0.0F && this.field_70423_b == null && this.field_70421_d == null) {
         double var2 = (double)this.field_70329_l + 0.5D;
         var4 = (double)this.field_70327_n + 0.5D;
         if(this.field_70422_e != null) {
            var4 += 0.5D;
         }

         if(this.field_70424_c != null) {
            var2 += 0.5D;
         }

         this.field_70331_k.func_72908_a(var2, (double)this.field_70330_m + 0.5D, var4, "random.chestopen", 0.5F, this.field_70331_k.field_73012_v.nextFloat() * 0.1F + 0.9F);
      }

      if(this.field_70427_h == 0 && this.field_70419_f > 0.0F || this.field_70427_h > 0 && this.field_70419_f < 1.0F) {
         float var8 = this.field_70419_f;
         if(this.field_70427_h > 0) {
            this.field_70419_f += var1;
         } else {
            this.field_70419_f -= var1;
         }

         if(this.field_70419_f > 1.0F) {
            this.field_70419_f = 1.0F;
         }

         float var3 = 0.5F;
         if(this.field_70419_f < var3 && var8 >= var3 && this.field_70423_b == null && this.field_70421_d == null) {
            var4 = (double)this.field_70329_l + 0.5D;
            double var6 = (double)this.field_70327_n + 0.5D;
            if(this.field_70422_e != null) {
               var6 += 0.5D;
            }

            if(this.field_70424_c != null) {
               var4 += 0.5D;
            }

            this.field_70331_k.func_72908_a(var4, (double)this.field_70330_m + 0.5D, var6, "random.chestclosed", 0.5F, this.field_70331_k.field_73012_v.nextFloat() * 0.1F + 0.9F);
         }

         if(this.field_70419_f < 0.0F) {
            this.field_70419_f = 0.0F;
         }
      }

   }

   public void func_70315_b(int p_70315_1_, int p_70315_2_) {
      if(p_70315_1_ == 1) {
         this.field_70427_h = p_70315_2_;
      }

   }

   public void func_70295_k_() {
      ++this.field_70427_h;
      this.field_70331_k.func_72965_b(this.field_70329_l, this.field_70330_m, this.field_70327_n, Block.field_72077_au.field_71990_ca, 1, this.field_70427_h);
   }

   public void func_70305_f() {
      --this.field_70427_h;
      this.field_70331_k.func_72965_b(this.field_70329_l, this.field_70330_m, this.field_70327_n, Block.field_72077_au.field_71990_ca, 1, this.field_70427_h);
   }

   public void func_70313_j() {
      this.func_70321_h();
      this.func_70418_i();
      super.func_70313_j();
   }
}
