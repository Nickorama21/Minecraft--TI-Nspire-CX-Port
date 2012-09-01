package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.Chunk;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemMapBase;
import net.minecraft.src.ItemStack;
import net.minecraft.src.MapColor;
import net.minecraft.src.MapData;
import net.minecraft.src.MathHelper;
import net.minecraft.src.Packet;
import net.minecraft.src.Packet131MapData;
import net.minecraft.src.World;

public class ItemMap extends ItemMapBase {

   protected ItemMap(int p_i3668_1_) {
      super(p_i3668_1_);
      this.func_77625_d(1);
      this.func_77637_a(CreativeTabs.field_78026_f);
   }

   public MapData func_77873_a(ItemStack p_77873_1_, World p_77873_2_) {
      "map_" + p_77873_1_.func_77960_j();
      MapData var4 = (MapData)p_77873_2_.func_72943_a(MapData.class, "map_" + p_77873_1_.func_77960_j());
      if(var4 == null) {
         p_77873_1_.func_77964_b(p_77873_2_.func_72841_b("map"));
         String var3 = "map_" + p_77873_1_.func_77960_j();
         var4 = new MapData(var3);
         var4.field_76201_a = p_77873_2_.func_72912_H().func_76079_c();
         var4.field_76199_b = p_77873_2_.func_72912_H().func_76074_e();
         var4.field_76197_d = 3;
         var4.field_76200_c = (byte)p_77873_2_.field_73011_w.field_76574_g;
         var4.func_76185_a();
         p_77873_2_.func_72823_a(var3, var4);
      }

      return var4;
   }

   public void func_77872_a(World p_77872_1_, Entity p_77872_2_, MapData p_77872_3_) {
      if(p_77872_1_.field_73011_w.field_76574_g == p_77872_3_.field_76200_c) {
         short var4 = 128;
         short var5 = 128;
         int var6 = 1 << p_77872_3_.field_76197_d;
         int var7 = p_77872_3_.field_76201_a;
         int var8 = p_77872_3_.field_76199_b;
         int var9 = MathHelper.func_76128_c(p_77872_2_.field_70165_t - (double)var7) / var6 + var4 / 2;
         int var10 = MathHelper.func_76128_c(p_77872_2_.field_70161_v - (double)var8) / var6 + var5 / 2;
         int var11 = 128 / var6;
         if(p_77872_1_.field_73011_w.field_76576_e) {
            var11 /= 2;
         }

         ++p_77872_3_.field_76195_f;

         for(int var12 = var9 - var11 + 1; var12 < var9 + var11; ++var12) {
            if((var12 & 15) == (p_77872_3_.field_76195_f & 15)) {
               int var13 = 255;
               int var14 = 0;
               double var15 = 0.0D;

               for(int var17 = var10 - var11 - 1; var17 < var10 + var11; ++var17) {
                  if(var12 >= 0 && var17 >= -1 && var12 < var4 && var17 < var5) {
                     int var18 = var12 - var9;
                     int var19 = var17 - var10;
                     boolean var20 = var18 * var18 + var19 * var19 > (var11 - 2) * (var11 - 2);
                     int var21 = (var7 / var6 + var12 - var4 / 2) * var6;
                     int var22 = (var8 / var6 + var17 - var5 / 2) * var6;
                     byte var23 = 0;
                     byte var24 = 0;
                     byte var25 = 0;
                     int[] var26 = new int[256];
                     Chunk var27 = p_77872_1_.func_72938_d(var21, var22);
                     if(!var27.func_76621_g()) {
                        int var28 = var21 & 15;
                        int var29 = var22 & 15;
                        int var30 = 0;
                        double var31 = 0.0D;
                        int var34;
                        int var35;
                        int var33;
                        int var38;
                        if(p_77872_1_.field_73011_w.field_76576_e) {
                           var33 = var21 + var22 * 231871;
                           var33 = var33 * var33 * 31287121 + var33 * 11;
                           if((var33 >> 20 & 1) == 0) {
                              var26[Block.field_71979_v.field_71990_ca] += 10;
                           } else {
                              var26[Block.field_71981_t.field_71990_ca] += 10;
                           }

                           var31 = 100.0D;
                        } else {
                           for(var33 = 0; var33 < var6; ++var33) {
                              for(var34 = 0; var34 < var6; ++var34) {
                                 var35 = var27.func_76611_b(var33 + var28, var34 + var29) + 1;
                                 int var36 = 0;
                                 if(var35 > 1) {
                                    boolean var37 = false;

                                    do {
                                       var37 = true;
                                       var36 = var27.func_76610_a(var33 + var28, var35 - 1, var34 + var29);
                                       if(var36 == 0) {
                                          var37 = false;
                                       } else if(var35 > 0 && var36 > 0 && Block.field_71973_m[var36].field_72018_cp.field_76234_F == MapColor.field_76279_b) {
                                          var37 = false;
                                       }

                                       if(!var37) {
                                          --var35;
                                          if(var35 <= 0) {
                                             break;
                                          }

                                          var36 = var27.func_76610_a(var33 + var28, var35 - 1, var34 + var29);
                                       }
                                    } while(var35 > 0 && !var37);

                                    if(var35 > 0 && var36 != 0 && Block.field_71973_m[var36].field_72018_cp.func_76224_d()) {
                                       var38 = var35 - 1;
                                       boolean var39 = false;

                                       int var41;
                                       do {
                                          var41 = var27.func_76610_a(var33 + var28, var38--, var34 + var29);
                                          ++var30;
                                       } while(var38 > 0 && var41 != 0 && Block.field_71973_m[var41].field_72018_cp.func_76224_d());
                                    }
                                 }

                                 var31 += (double)var35 / (double)(var6 * var6);
                                 ++var26[var36];
                              }
                           }
                        }

                        var30 /= var6 * var6;
                        int var10000 = var23 / (var6 * var6);
                        var10000 = var24 / (var6 * var6);
                        var10000 = var25 / (var6 * var6);
                        var33 = 0;
                        var34 = 0;

                        for(var35 = 0; var35 < 256; ++var35) {
                           if(var26[var35] > var33) {
                              var34 = var35;
                              var33 = var26[var35];
                           }
                        }

                        double var43 = (var31 - var15) * 4.0D / (double)(var6 + 4) + ((double)(var12 + var17 & 1) - 0.5D) * 0.4D;
                        byte var42 = 1;
                        if(var43 > 0.6D) {
                           var42 = 2;
                        }

                        if(var43 < -0.6D) {
                           var42 = 0;
                        }

                        var38 = 0;
                        if(var34 > 0) {
                           MapColor var45 = Block.field_71973_m[var34].field_72018_cp.field_76234_F;
                           if(var45 == MapColor.field_76282_n) {
                              var43 = (double)var30 * 0.1D + (double)(var12 + var17 & 1) * 0.2D;
                              var42 = 1;
                              if(var43 < 0.5D) {
                                 var42 = 2;
                              }

                              if(var43 > 0.9D) {
                                 var42 = 0;
                              }
                           }

                           var38 = var45.field_76290_q;
                        }

                        var15 = var31;
                        if(var17 >= 0 && var18 * var18 + var19 * var19 < var11 * var11 && (!var20 || (var12 + var17 & 1) != 0)) {
                           byte var44 = p_77872_3_.field_76198_e[var12 + var17 * var4];
                           byte var40 = (byte)(var38 * 4 + var42);
                           if(var44 != var40) {
                              if(var13 > var17) {
                                 var13 = var17;
                              }

                              if(var14 < var17) {
                                 var14 = var17;
                              }

                              p_77872_3_.field_76198_e[var12 + var17 * var4] = var40;
                           }
                        }
                     }
                  }
               }

               if(var13 <= var14) {
                  p_77872_3_.func_76194_a(var12, var13, var14);
               }
            }
         }

      }
   }

   public void func_77663_a(ItemStack p_77663_1_, World p_77663_2_, Entity p_77663_3_, int p_77663_4_, boolean p_77663_5_) {
      if(!p_77663_2_.field_72995_K) {
         MapData var6 = this.func_77873_a(p_77663_1_, p_77663_2_);
         if(p_77663_3_ instanceof EntityPlayer) {
            EntityPlayer var7 = (EntityPlayer)p_77663_3_;
            var6.func_76191_a(var7, p_77663_1_);
         }

         if(p_77663_5_) {
            this.func_77872_a(p_77663_2_, p_77663_3_, var6);
         }

      }
   }

   public void func_77622_d(ItemStack p_77622_1_, World p_77622_2_, EntityPlayer p_77622_3_) {
      p_77622_1_.func_77964_b(p_77622_2_.func_72841_b("map"));
      String var4 = "map_" + p_77622_1_.func_77960_j();
      MapData var5 = new MapData(var4);
      p_77622_2_.func_72823_a(var4, var5);
      var5.field_76201_a = MathHelper.func_76128_c(p_77622_3_.field_70165_t);
      var5.field_76199_b = MathHelper.func_76128_c(p_77622_3_.field_70161_v);
      var5.field_76197_d = 3;
      var5.field_76200_c = (byte)p_77622_2_.field_73011_w.field_76574_g;
      var5.func_76185_a();
   }

   public Packet func_77871_c(ItemStack p_77871_1_, World p_77871_2_, EntityPlayer p_77871_3_) {
      byte[] var4 = this.func_77873_a(p_77871_1_, p_77871_2_).func_76193_a(p_77871_1_, p_77871_2_, p_77871_3_);
      return var4 == null?null:new Packet131MapData((short)Item.field_77744_bd.field_77779_bT, (short)p_77871_1_.func_77960_j(), var4);
   }
}
