package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.Entity;
import net.minecraft.src.MathHelper;
import net.minecraft.src.World;

public class Teleporter {

   private Random field_77187_a = new Random();


   public void func_77185_a(World p_77185_1_, Entity p_77185_2_) {
      if(p_77185_1_.field_73011_w.field_76574_g != 1) {
         if(!this.func_77184_b(p_77185_1_, p_77185_2_)) {
            this.func_77186_c(p_77185_1_, p_77185_2_);
            this.func_77184_b(p_77185_1_, p_77185_2_);
         }
      } else {
         int var3 = MathHelper.func_76128_c(p_77185_2_.field_70165_t);
         int var4 = MathHelper.func_76128_c(p_77185_2_.field_70163_u) - 1;
         int var5 = MathHelper.func_76128_c(p_77185_2_.field_70161_v);
         byte var6 = 1;
         byte var7 = 0;

         for(int var8 = -2; var8 <= 2; ++var8) {
            for(int var9 = -2; var9 <= 2; ++var9) {
               for(int var10 = -1; var10 < 3; ++var10) {
                  int var11 = var3 + var9 * var6 + var8 * var7;
                  int var12 = var4 + var10;
                  int var13 = var5 + var9 * var7 - var8 * var6;
                  boolean var14 = var10 < 0;
                  p_77185_1_.func_72859_e(var11, var12, var13, var14?Block.field_72089_ap.field_71990_ca:0);
               }
            }
         }

         p_77185_2_.func_70012_b((double)var3, (double)var4, (double)var5, p_77185_2_.field_70177_z, 0.0F);
         p_77185_2_.field_70159_w = p_77185_2_.field_70181_x = p_77185_2_.field_70179_y = 0.0D;
      }
   }

   public boolean func_77184_b(World p_77184_1_, Entity p_77184_2_) {
      short var3 = 128;
      double var4 = -1.0D;
      int var6 = 0;
      int var7 = 0;
      int var8 = 0;
      int var9 = MathHelper.func_76128_c(p_77184_2_.field_70165_t);
      int var10 = MathHelper.func_76128_c(p_77184_2_.field_70161_v);

      double var18;
      for(int var11 = var9 - var3; var11 <= var9 + var3; ++var11) {
         double var12 = (double)var11 + 0.5D - p_77184_2_.field_70165_t;

         for(int var14 = var10 - var3; var14 <= var10 + var3; ++var14) {
            double var15 = (double)var14 + 0.5D - p_77184_2_.field_70161_v;

            for(int var17 = p_77184_1_.func_72940_L() - 1; var17 >= 0; --var17) {
               if(p_77184_1_.func_72798_a(var11, var17, var14) == Block.field_72015_be.field_71990_ca) {
                  while(p_77184_1_.func_72798_a(var11, var17 - 1, var14) == Block.field_72015_be.field_71990_ca) {
                     --var17;
                  }

                  var18 = (double)var17 + 0.5D - p_77184_2_.field_70163_u;
                  double var20 = var12 * var12 + var18 * var18 + var15 * var15;
                  if(var4 < 0.0D || var20 < var4) {
                     var4 = var20;
                     var6 = var11;
                     var7 = var17;
                     var8 = var14;
                  }
               }
            }
         }
      }

      if(var4 >= 0.0D) {
         double var22 = (double)var6 + 0.5D;
         double var16 = (double)var7 + 0.5D;
         var18 = (double)var8 + 0.5D;
         if(p_77184_1_.func_72798_a(var6 - 1, var7, var8) == Block.field_72015_be.field_71990_ca) {
            var22 -= 0.5D;
         }

         if(p_77184_1_.func_72798_a(var6 + 1, var7, var8) == Block.field_72015_be.field_71990_ca) {
            var22 += 0.5D;
         }

         if(p_77184_1_.func_72798_a(var6, var7, var8 - 1) == Block.field_72015_be.field_71990_ca) {
            var18 -= 0.5D;
         }

         if(p_77184_1_.func_72798_a(var6, var7, var8 + 1) == Block.field_72015_be.field_71990_ca) {
            var18 += 0.5D;
         }

         p_77184_2_.func_70012_b(var22, var16, var18, p_77184_2_.field_70177_z, 0.0F);
         p_77184_2_.field_70159_w = p_77184_2_.field_70181_x = p_77184_2_.field_70179_y = 0.0D;
         return true;
      } else {
         return false;
      }
   }

   public boolean func_77186_c(World p_77186_1_, Entity p_77186_2_) {
      byte var3 = 16;
      double var4 = -1.0D;
      int var6 = MathHelper.func_76128_c(p_77186_2_.field_70165_t);
      int var7 = MathHelper.func_76128_c(p_77186_2_.field_70163_u);
      int var8 = MathHelper.func_76128_c(p_77186_2_.field_70161_v);
      int var9 = var6;
      int var10 = var7;
      int var11 = var8;
      int var12 = 0;
      int var13 = this.field_77187_a.nextInt(4);

      int var14;
      double var15;
      int var17;
      double var18;
      int var21;
      int var20;
      int var23;
      int var22;
      int var25;
      int var24;
      int var27;
      int var26;
      int var28;
      double var34;
      double var32;
      for(var14 = var6 - var3; var14 <= var6 + var3; ++var14) {
         var15 = (double)var14 + 0.5D - p_77186_2_.field_70165_t;

         for(var17 = var8 - var3; var17 <= var8 + var3; ++var17) {
            var18 = (double)var17 + 0.5D - p_77186_2_.field_70161_v;

            label274:
            for(var20 = p_77186_1_.func_72940_L() - 1; var20 >= 0; --var20) {
               if(p_77186_1_.func_72799_c(var14, var20, var17)) {
                  while(var20 > 0 && p_77186_1_.func_72799_c(var14, var20 - 1, var17)) {
                     --var20;
                  }

                  for(var21 = var13; var21 < var13 + 4; ++var21) {
                     var22 = var21 % 2;
                     var23 = 1 - var22;
                     if(var21 % 4 >= 2) {
                        var22 = -var22;
                        var23 = -var23;
                     }

                     for(var24 = 0; var24 < 3; ++var24) {
                        for(var25 = 0; var25 < 4; ++var25) {
                           for(var26 = -1; var26 < 4; ++var26) {
                              var27 = var14 + (var25 - 1) * var22 + var24 * var23;
                              var28 = var20 + var26;
                              int var29 = var17 + (var25 - 1) * var23 - var24 * var22;
                              if(var26 < 0 && !p_77186_1_.func_72803_f(var27, var28, var29).func_76220_a() || var26 >= 0 && !p_77186_1_.func_72799_c(var27, var28, var29)) {
                                 continue label274;
                              }
                           }
                        }
                     }

                     var32 = (double)var20 + 0.5D - p_77186_2_.field_70163_u;
                     var34 = var15 * var15 + var32 * var32 + var18 * var18;
                     if(var4 < 0.0D || var34 < var4) {
                        var4 = var34;
                        var9 = var14;
                        var10 = var20;
                        var11 = var17;
                        var12 = var21 % 4;
                     }
                  }
               }
            }
         }
      }

      if(var4 < 0.0D) {
         for(var14 = var6 - var3; var14 <= var6 + var3; ++var14) {
            var15 = (double)var14 + 0.5D - p_77186_2_.field_70165_t;

            for(var17 = var8 - var3; var17 <= var8 + var3; ++var17) {
               var18 = (double)var17 + 0.5D - p_77186_2_.field_70161_v;

               label222:
               for(var20 = p_77186_1_.func_72940_L() - 1; var20 >= 0; --var20) {
                  if(p_77186_1_.func_72799_c(var14, var20, var17)) {
                     while(var20 > 0 && p_77186_1_.func_72799_c(var14, var20 - 1, var17)) {
                        --var20;
                     }

                     for(var21 = var13; var21 < var13 + 2; ++var21) {
                        var22 = var21 % 2;
                        var23 = 1 - var22;

                        for(var24 = 0; var24 < 4; ++var24) {
                           for(var25 = -1; var25 < 4; ++var25) {
                              var26 = var14 + (var24 - 1) * var22;
                              var27 = var20 + var25;
                              var28 = var17 + (var24 - 1) * var23;
                              if(var25 < 0 && !p_77186_1_.func_72803_f(var26, var27, var28).func_76220_a() || var25 >= 0 && !p_77186_1_.func_72799_c(var26, var27, var28)) {
                                 continue label222;
                              }
                           }
                        }

                        var32 = (double)var20 + 0.5D - p_77186_2_.field_70163_u;
                        var34 = var15 * var15 + var32 * var32 + var18 * var18;
                        if(var4 < 0.0D || var34 < var4) {
                           var4 = var34;
                           var9 = var14;
                           var10 = var20;
                           var11 = var17;
                           var12 = var21 % 2;
                        }
                     }
                  }
               }
            }
         }
      }

      int var30 = var9;
      int var16 = var10;
      var17 = var11;
      int var31 = var12 % 2;
      int var19 = 1 - var31;
      if(var12 % 4 >= 2) {
         var31 = -var31;
         var19 = -var19;
      }

      boolean var33;
      if(var4 < 0.0D) {
         if(var10 < 70) {
            var10 = 70;
         }

         if(var10 > p_77186_1_.func_72940_L() - 10) {
            var10 = p_77186_1_.func_72940_L() - 10;
         }

         var16 = var10;

         for(var20 = -1; var20 <= 1; ++var20) {
            for(var21 = 1; var21 < 3; ++var21) {
               for(var22 = -1; var22 < 3; ++var22) {
                  var23 = var30 + (var21 - 1) * var31 + var20 * var19;
                  var24 = var16 + var22;
                  var25 = var17 + (var21 - 1) * var19 - var20 * var31;
                  var33 = var22 < 0;
                  p_77186_1_.func_72859_e(var23, var24, var25, var33?Block.field_72089_ap.field_71990_ca:0);
               }
            }
         }
      }

      for(var20 = 0; var20 < 4; ++var20) {
         p_77186_1_.field_73014_t = true;

         for(var21 = 0; var21 < 4; ++var21) {
            for(var22 = -1; var22 < 4; ++var22) {
               var23 = var30 + (var21 - 1) * var31;
               var24 = var16 + var22;
               var25 = var17 + (var21 - 1) * var19;
               var33 = var21 == 0 || var21 == 3 || var22 == -1 || var22 == 3;
               p_77186_1_.func_72859_e(var23, var24, var25, var33?Block.field_72089_ap.field_71990_ca:Block.field_72015_be.field_71990_ca);
            }
         }

         p_77186_1_.field_73014_t = false;

         for(var21 = 0; var21 < 4; ++var21) {
            for(var22 = -1; var22 < 4; ++var22) {
               var23 = var30 + (var21 - 1) * var31;
               var24 = var16 + var22;
               var25 = var17 + (var21 - 1) * var19;
               p_77186_1_.func_72898_h(var23, var24, var25, p_77186_1_.func_72798_a(var23, var24, var25));
            }
         }
      }

      return true;
   }
}
