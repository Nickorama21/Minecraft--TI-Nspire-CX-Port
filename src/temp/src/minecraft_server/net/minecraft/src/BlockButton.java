package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.Material;
import net.minecraft.src.World;

public class BlockButton extends Block {

   protected BlockButton(int p_i3924_1_, int p_i3924_2_) {
      super(p_i3924_1_, p_i3924_2_, Material.field_76265_p);
      this.func_71907_b(true);
      this.func_71849_a(CreativeTabs.field_78028_d);
   }

   public AxisAlignedBB func_71872_e(World p_71872_1_, int p_71872_2_, int p_71872_3_, int p_71872_4_) {
      return null;
   }

   public int func_71859_p_() {
      return 20;
   }

   public boolean func_71926_d() {
      return false;
   }

   public boolean func_71886_c() {
      return false;
   }

   public boolean func_71850_a_(World p_71850_1_, int p_71850_2_, int p_71850_3_, int p_71850_4_, int p_71850_5_) {
      return p_71850_5_ == 2 && p_71850_1_.func_72809_s(p_71850_2_, p_71850_3_, p_71850_4_ + 1)?true:(p_71850_5_ == 3 && p_71850_1_.func_72809_s(p_71850_2_, p_71850_3_, p_71850_4_ - 1)?true:(p_71850_5_ == 4 && p_71850_1_.func_72809_s(p_71850_2_ + 1, p_71850_3_, p_71850_4_)?true:p_71850_5_ == 5 && p_71850_1_.func_72809_s(p_71850_2_ - 1, p_71850_3_, p_71850_4_)));
   }

   public boolean func_71930_b(World p_71930_1_, int p_71930_2_, int p_71930_3_, int p_71930_4_) {
      return p_71930_1_.func_72809_s(p_71930_2_ - 1, p_71930_3_, p_71930_4_)?true:(p_71930_1_.func_72809_s(p_71930_2_ + 1, p_71930_3_, p_71930_4_)?true:(p_71930_1_.func_72809_s(p_71930_2_, p_71930_3_, p_71930_4_ - 1)?true:p_71930_1_.func_72809_s(p_71930_2_, p_71930_3_, p_71930_4_ + 1)));
   }

   public void func_71909_a(World p_71909_1_, int p_71909_2_, int p_71909_3_, int p_71909_4_, int p_71909_5_, float p_71909_6_, float p_71909_7_, float p_71909_8_) {
      int var9 = p_71909_1_.func_72805_g(p_71909_2_, p_71909_3_, p_71909_4_);
      int var10 = var9 & 8;
      var9 &= 7;
      if(p_71909_5_ == 2 && p_71909_1_.func_72809_s(p_71909_2_, p_71909_3_, p_71909_4_ + 1)) {
         var9 = 4;
      } else if(p_71909_5_ == 3 && p_71909_1_.func_72809_s(p_71909_2_, p_71909_3_, p_71909_4_ - 1)) {
         var9 = 3;
      } else if(p_71909_5_ == 4 && p_71909_1_.func_72809_s(p_71909_2_ + 1, p_71909_3_, p_71909_4_)) {
         var9 = 2;
      } else if(p_71909_5_ == 5 && p_71909_1_.func_72809_s(p_71909_2_ - 1, p_71909_3_, p_71909_4_)) {
         var9 = 1;
      } else {
         var9 = this.func_72260_l(p_71909_1_, p_71909_2_, p_71909_3_, p_71909_4_);
      }

      p_71909_1_.func_72921_c(p_71909_2_, p_71909_3_, p_71909_4_, var9 + var10);
   }

   private int func_72260_l(World p_72260_1_, int p_72260_2_, int p_72260_3_, int p_72260_4_) {
      return p_72260_1_.func_72809_s(p_72260_2_ - 1, p_72260_3_, p_72260_4_)?1:(p_72260_1_.func_72809_s(p_72260_2_ + 1, p_72260_3_, p_72260_4_)?2:(p_72260_1_.func_72809_s(p_72260_2_, p_72260_3_, p_72260_4_ - 1)?3:(p_72260_1_.func_72809_s(p_72260_2_, p_72260_3_, p_72260_4_ + 1)?4:1)));
   }

   public void func_71863_a(World p_71863_1_, int p_71863_2_, int p_71863_3_, int p_71863_4_, int p_71863_5_) {
      if(this.func_72261_n(p_71863_1_, p_71863_2_, p_71863_3_, p_71863_4_)) {
         int var6 = p_71863_1_.func_72805_g(p_71863_2_, p_71863_3_, p_71863_4_) & 7;
         boolean var7 = false;
         if(!p_71863_1_.func_72809_s(p_71863_2_ - 1, p_71863_3_, p_71863_4_) && var6 == 1) {
            var7 = true;
         }

         if(!p_71863_1_.func_72809_s(p_71863_2_ + 1, p_71863_3_, p_71863_4_) && var6 == 2) {
            var7 = true;
         }

         if(!p_71863_1_.func_72809_s(p_71863_2_, p_71863_3_, p_71863_4_ - 1) && var6 == 3) {
            var7 = true;
         }

         if(!p_71863_1_.func_72809_s(p_71863_2_, p_71863_3_, p_71863_4_ + 1) && var6 == 4) {
            var7 = true;
         }

         if(var7) {
            this.func_71897_c(p_71863_1_, p_71863_2_, p_71863_3_, p_71863_4_, p_71863_1_.func_72805_g(p_71863_2_, p_71863_3_, p_71863_4_), 0);
            p_71863_1_.func_72859_e(p_71863_2_, p_71863_3_, p_71863_4_, 0);
         }
      }

   }

   private boolean func_72261_n(World p_72261_1_, int p_72261_2_, int p_72261_3_, int p_72261_4_) {
      if(!this.func_71930_b(p_72261_1_, p_72261_2_, p_72261_3_, p_72261_4_)) {
         this.func_71897_c(p_72261_1_, p_72261_2_, p_72261_3_, p_72261_4_, p_72261_1_.func_72805_g(p_72261_2_, p_72261_3_, p_72261_4_), 0);
         p_72261_1_.func_72859_e(p_72261_2_, p_72261_3_, p_72261_4_, 0);
         return false;
      } else {
         return true;
      }
   }

   public void func_71902_a(IBlockAccess p_71902_1_, int p_71902_2_, int p_71902_3_, int p_71902_4_) {
      int var5 = p_71902_1_.func_72805_g(p_71902_2_, p_71902_3_, p_71902_4_);
      int var6 = var5 & 7;
      boolean var7 = (var5 & 8) > 0;
      float var8 = 0.375F;
      float var9 = 0.625F;
      float var10 = 0.1875F;
      float var11 = 0.125F;
      if(var7) {
         var11 = 0.0625F;
      }

      if(var6 == 1) {
         this.func_71905_a(0.0F, var8, 0.5F - var10, var11, var9, 0.5F + var10);
      } else if(var6 == 2) {
         this.func_71905_a(1.0F - var11, var8, 0.5F - var10, 1.0F, var9, 0.5F + var10);
      } else if(var6 == 3) {
         this.func_71905_a(0.5F - var10, var8, 0.0F, 0.5F + var10, var9, var11);
      } else if(var6 == 4) {
         this.func_71905_a(0.5F - var10, var8, 1.0F - var11, 0.5F + var10, var9, 1.0F);
      }

   }

   public void func_71921_a(World p_71921_1_, int p_71921_2_, int p_71921_3_, int p_71921_4_, EntityPlayer p_71921_5_) {
      this.func_71903_a(p_71921_1_, p_71921_2_, p_71921_3_, p_71921_4_, p_71921_5_, 0, 0.0F, 0.0F, 0.0F);
   }

   public boolean func_71903_a(World p_71903_1_, int p_71903_2_, int p_71903_3_, int p_71903_4_, EntityPlayer p_71903_5_, int p_71903_6_, float p_71903_7_, float p_71903_8_, float p_71903_9_) {
      int var10 = p_71903_1_.func_72805_g(p_71903_2_, p_71903_3_, p_71903_4_);
      int var11 = var10 & 7;
      int var12 = 8 - (var10 & 8);
      if(var12 == 0) {
         return true;
      } else {
         p_71903_1_.func_72921_c(p_71903_2_, p_71903_3_, p_71903_4_, var11 + var12);
         p_71903_1_.func_72909_d(p_71903_2_, p_71903_3_, p_71903_4_, p_71903_2_, p_71903_3_, p_71903_4_);
         p_71903_1_.func_72908_a((double)p_71903_2_ + 0.5D, (double)p_71903_3_ + 0.5D, (double)p_71903_4_ + 0.5D, "random.click", 0.3F, 0.6F);
         p_71903_1_.func_72898_h(p_71903_2_, p_71903_3_, p_71903_4_, this.field_71990_ca);
         if(var11 == 1) {
            p_71903_1_.func_72898_h(p_71903_2_ - 1, p_71903_3_, p_71903_4_, this.field_71990_ca);
         } else if(var11 == 2) {
            p_71903_1_.func_72898_h(p_71903_2_ + 1, p_71903_3_, p_71903_4_, this.field_71990_ca);
         } else if(var11 == 3) {
            p_71903_1_.func_72898_h(p_71903_2_, p_71903_3_, p_71903_4_ - 1, this.field_71990_ca);
         } else if(var11 == 4) {
            p_71903_1_.func_72898_h(p_71903_2_, p_71903_3_, p_71903_4_ + 1, this.field_71990_ca);
         } else {
            p_71903_1_.func_72898_h(p_71903_2_, p_71903_3_ - 1, p_71903_4_, this.field_71990_ca);
         }

         p_71903_1_.func_72836_a(p_71903_2_, p_71903_3_, p_71903_4_, this.field_71990_ca, this.func_71859_p_());
         return true;
      }
   }

   public void func_71852_a(World p_71852_1_, int p_71852_2_, int p_71852_3_, int p_71852_4_, int p_71852_5_, int p_71852_6_) {
      if((p_71852_6_ & 8) > 0) {
         p_71852_1_.func_72898_h(p_71852_2_, p_71852_3_, p_71852_4_, this.field_71990_ca);
         int var7 = p_71852_6_ & 7;
         if(var7 == 1) {
            p_71852_1_.func_72898_h(p_71852_2_ - 1, p_71852_3_, p_71852_4_, this.field_71990_ca);
         } else if(var7 == 2) {
            p_71852_1_.func_72898_h(p_71852_2_ + 1, p_71852_3_, p_71852_4_, this.field_71990_ca);
         } else if(var7 == 3) {
            p_71852_1_.func_72898_h(p_71852_2_, p_71852_3_, p_71852_4_ - 1, this.field_71990_ca);
         } else if(var7 == 4) {
            p_71852_1_.func_72898_h(p_71852_2_, p_71852_3_, p_71852_4_ + 1, this.field_71990_ca);
         } else {
            p_71852_1_.func_72898_h(p_71852_2_, p_71852_3_ - 1, p_71852_4_, this.field_71990_ca);
         }
      }

      super.func_71852_a(p_71852_1_, p_71852_2_, p_71852_3_, p_71852_4_, p_71852_5_, p_71852_6_);
   }

   public boolean func_71865_a(IBlockAccess p_71865_1_, int p_71865_2_, int p_71865_3_, int p_71865_4_, int p_71865_5_) {
      return (p_71865_1_.func_72805_g(p_71865_2_, p_71865_3_, p_71865_4_) & 8) > 0;
   }

   public boolean func_71855_c(World p_71855_1_, int p_71855_2_, int p_71855_3_, int p_71855_4_, int p_71855_5_) {
      int var6 = p_71855_1_.func_72805_g(p_71855_2_, p_71855_3_, p_71855_4_);
      if((var6 & 8) == 0) {
         return false;
      } else {
         int var7 = var6 & 7;
         return var7 == 5 && p_71855_5_ == 1?true:(var7 == 4 && p_71855_5_ == 2?true:(var7 == 3 && p_71855_5_ == 3?true:(var7 == 2 && p_71855_5_ == 4?true:var7 == 1 && p_71855_5_ == 5)));
      }
   }

   public boolean func_71853_i() {
      return true;
   }

   public void func_71847_b(World p_71847_1_, int p_71847_2_, int p_71847_3_, int p_71847_4_, Random p_71847_5_) {
      if(!p_71847_1_.field_72995_K) {
         int var6 = p_71847_1_.func_72805_g(p_71847_2_, p_71847_3_, p_71847_4_);
         if((var6 & 8) != 0) {
            p_71847_1_.func_72921_c(p_71847_2_, p_71847_3_, p_71847_4_, var6 & 7);
            p_71847_1_.func_72898_h(p_71847_2_, p_71847_3_, p_71847_4_, this.field_71990_ca);
            int var7 = var6 & 7;
            if(var7 == 1) {
               p_71847_1_.func_72898_h(p_71847_2_ - 1, p_71847_3_, p_71847_4_, this.field_71990_ca);
            } else if(var7 == 2) {
               p_71847_1_.func_72898_h(p_71847_2_ + 1, p_71847_3_, p_71847_4_, this.field_71990_ca);
            } else if(var7 == 3) {
               p_71847_1_.func_72898_h(p_71847_2_, p_71847_3_, p_71847_4_ - 1, this.field_71990_ca);
            } else if(var7 == 4) {
               p_71847_1_.func_72898_h(p_71847_2_, p_71847_3_, p_71847_4_ + 1, this.field_71990_ca);
            } else {
               p_71847_1_.func_72898_h(p_71847_2_, p_71847_3_ - 1, p_71847_4_, this.field_71990_ca);
            }

            p_71847_1_.func_72908_a((double)p_71847_2_ + 0.5D, (double)p_71847_3_ + 0.5D, (double)p_71847_4_ + 0.5D, "random.click", 0.3F, 0.5F);
            p_71847_1_.func_72909_d(p_71847_2_, p_71847_3_, p_71847_4_, p_71847_2_, p_71847_3_, p_71847_4_);
         }
      }
   }

   public void func_71919_f() {
      float var1 = 0.1875F;
      float var2 = 0.125F;
      float var3 = 0.125F;
      this.func_71905_a(0.5F - var1, 0.5F - var2, 0.5F - var3, 0.5F + var1, 0.5F + var2, 0.5F + var3);
   }
}
