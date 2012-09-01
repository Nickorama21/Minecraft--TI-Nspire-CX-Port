package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.Entity;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.Material;
import net.minecraft.src.Vec3;
import net.minecraft.src.World;

public abstract class BlockFluid extends Block {

   protected BlockFluid(int p_i3964_1_, Material p_i3964_2_) {
      super(p_i3964_1_, (p_i3964_2_ == Material.field_76256_h?14:12) * 16 + 13, p_i3964_2_);
      float var3 = 0.0F;
      float var4 = 0.0F;
      this.func_71905_a(0.0F + var4, 0.0F + var3, 0.0F + var4, 1.0F + var4, 1.0F + var3, 1.0F + var4);
      this.func_71907_b(true);
   }

   public boolean func_71918_c(IBlockAccess p_71918_1_, int p_71918_2_, int p_71918_3_, int p_71918_4_) {
      return this.field_72018_cp != Material.field_76256_h;
   }

   public static float func_72199_d(int p_72199_0_) {
      if(p_72199_0_ >= 8) {
         p_72199_0_ = 0;
      }

      return (float)(p_72199_0_ + 1) / 9.0F;
   }

   public int func_71851_a(int p_71851_1_) {
      return p_71851_1_ != 0 && p_71851_1_ != 1?this.field_72059_bZ + 1:this.field_72059_bZ;
   }

   protected int func_72198_f_(World p_72198_1_, int p_72198_2_, int p_72198_3_, int p_72198_4_) {
      return p_72198_1_.func_72803_f(p_72198_2_, p_72198_3_, p_72198_4_) == this.field_72018_cp?p_72198_1_.func_72805_g(p_72198_2_, p_72198_3_, p_72198_4_):-1;
   }

   protected int func_72203_d(IBlockAccess p_72203_1_, int p_72203_2_, int p_72203_3_, int p_72203_4_) {
      if(p_72203_1_.func_72803_f(p_72203_2_, p_72203_3_, p_72203_4_) != this.field_72018_cp) {
         return -1;
      } else {
         int var5 = p_72203_1_.func_72805_g(p_72203_2_, p_72203_3_, p_72203_4_);
         if(var5 >= 8) {
            var5 = 0;
         }

         return var5;
      }
   }

   public boolean func_71886_c() {
      return false;
   }

   public boolean func_71926_d() {
      return false;
   }

   public boolean func_71913_a(int p_71913_1_, boolean p_71913_2_) {
      return p_71913_2_ && p_71913_1_ == 0;
   }

   public boolean func_71924_d(IBlockAccess p_71924_1_, int p_71924_2_, int p_71924_3_, int p_71924_4_, int p_71924_5_) {
      Material var6 = p_71924_1_.func_72803_f(p_71924_2_, p_71924_3_, p_71924_4_);
      return var6 == this.field_72018_cp?false:(p_71924_5_ == 1?true:(var6 == Material.field_76260_u?false:super.func_71924_d(p_71924_1_, p_71924_2_, p_71924_3_, p_71924_4_, p_71924_5_)));
   }

   public AxisAlignedBB func_71872_e(World p_71872_1_, int p_71872_2_, int p_71872_3_, int p_71872_4_) {
      return null;
   }

   public int func_71857_b() {
      return 4;
   }

   public int func_71885_a(int p_71885_1_, Random p_71885_2_, int p_71885_3_) {
      return 0;
   }

   public int func_71925_a(Random p_71925_1_) {
      return 0;
   }

   private Vec3 func_72202_i(IBlockAccess p_72202_1_, int p_72202_2_, int p_72202_3_, int p_72202_4_) {
      Vec3 var5 = Vec3.func_72437_a().func_72345_a(0.0D, 0.0D, 0.0D);
      int var6 = this.func_72203_d(p_72202_1_, p_72202_2_, p_72202_3_, p_72202_4_);

      for(int var7 = 0; var7 < 4; ++var7) {
         int var8 = p_72202_2_;
         int var10 = p_72202_4_;
         if(var7 == 0) {
            var8 = p_72202_2_ - 1;
         }

         if(var7 == 1) {
            var10 = p_72202_4_ - 1;
         }

         if(var7 == 2) {
            ++var8;
         }

         if(var7 == 3) {
            ++var10;
         }

         int var11 = this.func_72203_d(p_72202_1_, var8, p_72202_3_, var10);
         int var12;
         if(var11 < 0) {
            if(!p_72202_1_.func_72803_f(var8, p_72202_3_, var10).func_76230_c()) {
               var11 = this.func_72203_d(p_72202_1_, var8, p_72202_3_ - 1, var10);
               if(var11 >= 0) {
                  var12 = var11 - (var6 - 8);
                  var5 = var5.func_72441_c((double)((var8 - p_72202_2_) * var12), (double)((p_72202_3_ - p_72202_3_) * var12), (double)((var10 - p_72202_4_) * var12));
               }
            }
         } else if(var11 >= 0) {
            var12 = var11 - var6;
            var5 = var5.func_72441_c((double)((var8 - p_72202_2_) * var12), (double)((p_72202_3_ - p_72202_3_) * var12), (double)((var10 - p_72202_4_) * var12));
         }
      }

      if(p_72202_1_.func_72805_g(p_72202_2_, p_72202_3_, p_72202_4_) >= 8) {
         boolean var13 = false;
         if(var13 || this.func_71924_d(p_72202_1_, p_72202_2_, p_72202_3_, p_72202_4_ - 1, 2)) {
            var13 = true;
         }

         if(var13 || this.func_71924_d(p_72202_1_, p_72202_2_, p_72202_3_, p_72202_4_ + 1, 3)) {
            var13 = true;
         }

         if(var13 || this.func_71924_d(p_72202_1_, p_72202_2_ - 1, p_72202_3_, p_72202_4_, 4)) {
            var13 = true;
         }

         if(var13 || this.func_71924_d(p_72202_1_, p_72202_2_ + 1, p_72202_3_, p_72202_4_, 5)) {
            var13 = true;
         }

         if(var13 || this.func_71924_d(p_72202_1_, p_72202_2_, p_72202_3_ + 1, p_72202_4_ - 1, 2)) {
            var13 = true;
         }

         if(var13 || this.func_71924_d(p_72202_1_, p_72202_2_, p_72202_3_ + 1, p_72202_4_ + 1, 3)) {
            var13 = true;
         }

         if(var13 || this.func_71924_d(p_72202_1_, p_72202_2_ - 1, p_72202_3_ + 1, p_72202_4_, 4)) {
            var13 = true;
         }

         if(var13 || this.func_71924_d(p_72202_1_, p_72202_2_ + 1, p_72202_3_ + 1, p_72202_4_, 5)) {
            var13 = true;
         }

         if(var13) {
            var5 = var5.func_72432_b().func_72441_c(0.0D, -6.0D, 0.0D);
         }
      }

      var5 = var5.func_72432_b();
      return var5;
   }

   public void func_71901_a(World p_71901_1_, int p_71901_2_, int p_71901_3_, int p_71901_4_, Entity p_71901_5_, Vec3 p_71901_6_) {
      Vec3 var7 = this.func_72202_i(p_71901_1_, p_71901_2_, p_71901_3_, p_71901_4_);
      p_71901_6_.field_72450_a += var7.field_72450_a;
      p_71901_6_.field_72448_b += var7.field_72448_b;
      p_71901_6_.field_72449_c += var7.field_72449_c;
   }

   public int func_71859_p_() {
      return this.field_72018_cp == Material.field_76244_g?5:(this.field_72018_cp == Material.field_76256_h?30:0);
   }

   public void func_71861_g(World p_71861_1_, int p_71861_2_, int p_71861_3_, int p_71861_4_) {
      this.func_72200_l(p_71861_1_, p_71861_2_, p_71861_3_, p_71861_4_);
   }

   public void func_71863_a(World p_71863_1_, int p_71863_2_, int p_71863_3_, int p_71863_4_, int p_71863_5_) {
      this.func_72200_l(p_71863_1_, p_71863_2_, p_71863_3_, p_71863_4_);
   }

   private void func_72200_l(World p_72200_1_, int p_72200_2_, int p_72200_3_, int p_72200_4_) {
      if(p_72200_1_.func_72798_a(p_72200_2_, p_72200_3_, p_72200_4_) == this.field_71990_ca) {
         if(this.field_72018_cp == Material.field_76256_h) {
            boolean var5 = false;
            if(var5 || p_72200_1_.func_72803_f(p_72200_2_, p_72200_3_, p_72200_4_ - 1) == Material.field_76244_g) {
               var5 = true;
            }

            if(var5 || p_72200_1_.func_72803_f(p_72200_2_, p_72200_3_, p_72200_4_ + 1) == Material.field_76244_g) {
               var5 = true;
            }

            if(var5 || p_72200_1_.func_72803_f(p_72200_2_ - 1, p_72200_3_, p_72200_4_) == Material.field_76244_g) {
               var5 = true;
            }

            if(var5 || p_72200_1_.func_72803_f(p_72200_2_ + 1, p_72200_3_, p_72200_4_) == Material.field_76244_g) {
               var5 = true;
            }

            if(var5 || p_72200_1_.func_72803_f(p_72200_2_, p_72200_3_ + 1, p_72200_4_) == Material.field_76244_g) {
               var5 = true;
            }

            if(var5) {
               int var6 = p_72200_1_.func_72805_g(p_72200_2_, p_72200_3_, p_72200_4_);
               if(var6 == 0) {
                  p_72200_1_.func_72859_e(p_72200_2_, p_72200_3_, p_72200_4_, Block.field_72089_ap.field_71990_ca);
               } else if(var6 <= 4) {
                  p_72200_1_.func_72859_e(p_72200_2_, p_72200_3_, p_72200_4_, Block.field_71978_w.field_71990_ca);
               }

               this.func_72201_j(p_72200_1_, p_72200_2_, p_72200_3_, p_72200_4_);
            }
         }

      }
   }

   protected void func_72201_j(World p_72201_1_, int p_72201_2_, int p_72201_3_, int p_72201_4_) {
      p_72201_1_.func_72908_a((double)((float)p_72201_2_ + 0.5F), (double)((float)p_72201_3_ + 0.5F), (double)((float)p_72201_4_ + 0.5F), "random.fizz", 0.5F, 2.6F + (p_72201_1_.field_73012_v.nextFloat() - p_72201_1_.field_73012_v.nextFloat()) * 0.8F);

      for(int var5 = 0; var5 < 8; ++var5) {
         p_72201_1_.func_72869_a("largesmoke", (double)p_72201_2_ + Math.random(), (double)p_72201_3_ + 1.2D, (double)p_72201_4_ + Math.random(), 0.0D, 0.0D, 0.0D);
      }

   }
}
