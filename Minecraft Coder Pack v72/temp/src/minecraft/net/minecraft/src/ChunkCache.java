package net.minecraft.src;

import net.minecraft.src.BiomeGenBase;
import net.minecraft.src.Block;
import net.minecraft.src.BlockHalfSlab;
import net.minecraft.src.BlockStairs;
import net.minecraft.src.Chunk;
import net.minecraft.src.EnumSkyBlock;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.Material;
import net.minecraft.src.TileEntity;
import net.minecraft.src.World;

public class ChunkCache implements IBlockAccess {

   private int field_72818_a;
   private int field_72816_b;
   private Chunk[][] field_72817_c;
   private boolean field_72814_d;
   private World field_72815_e;


   public ChunkCache(World p_i3740_1_, int p_i3740_2_, int p_i3740_3_, int p_i3740_4_, int p_i3740_5_, int p_i3740_6_, int p_i3740_7_) {
      this.field_72815_e = p_i3740_1_;
      this.field_72818_a = p_i3740_2_ >> 4;
      this.field_72816_b = p_i3740_4_ >> 4;
      int var8 = p_i3740_5_ >> 4;
      int var9 = p_i3740_7_ >> 4;
      this.field_72817_c = new Chunk[var8 - this.field_72818_a + 1][var9 - this.field_72816_b + 1];
      this.field_72814_d = true;

      for(int var10 = this.field_72818_a; var10 <= var8; ++var10) {
         for(int var11 = this.field_72816_b; var11 <= var9; ++var11) {
            Chunk var12 = p_i3740_1_.func_72964_e(var10, var11);
            if(var12 != null) {
               this.field_72817_c[var10 - this.field_72818_a][var11 - this.field_72816_b] = var12;
               if(!var12.func_76606_c(p_i3740_3_, p_i3740_6_)) {
                  this.field_72814_d = false;
               }
            }
         }
      }

   }

   public boolean func_72806_N() {
      return this.field_72814_d;
   }

   public int func_72798_a(int p_72798_1_, int p_72798_2_, int p_72798_3_) {
      if(p_72798_2_ < 0) {
         return 0;
      } else if(p_72798_2_ >= 256) {
         return 0;
      } else {
         int var4 = (p_72798_1_ >> 4) - this.field_72818_a;
         int var5 = (p_72798_3_ >> 4) - this.field_72816_b;
         if(var4 >= 0 && var4 < this.field_72817_c.length && var5 >= 0 && var5 < this.field_72817_c[var4].length) {
            Chunk var6 = this.field_72817_c[var4][var5];
            return var6 == null?0:var6.func_76610_a(p_72798_1_ & 15, p_72798_2_, p_72798_3_ & 15);
         } else {
            return 0;
         }
      }
   }

   public TileEntity func_72796_p(int p_72796_1_, int p_72796_2_, int p_72796_3_) {
      int var4 = (p_72796_1_ >> 4) - this.field_72818_a;
      int var5 = (p_72796_3_ >> 4) - this.field_72816_b;
      return this.field_72817_c[var4][var5].func_76597_e(p_72796_1_ & 15, p_72796_2_, p_72796_3_ & 15);
   }

   public float func_72808_j(int p_72808_1_, int p_72808_2_, int p_72808_3_, int p_72808_4_) {
      int var5 = this.func_72811_b(p_72808_1_, p_72808_2_, p_72808_3_);
      if(var5 < p_72808_4_) {
         var5 = p_72808_4_;
      }

      return this.field_72815_e.field_73011_w.field_76573_f[var5];
   }

   public int func_72802_i(int p_72802_1_, int p_72802_2_, int p_72802_3_, int p_72802_4_) {
      int var5 = this.func_72810_a(EnumSkyBlock.Sky, p_72802_1_, p_72802_2_, p_72802_3_);
      int var6 = this.func_72810_a(EnumSkyBlock.Block, p_72802_1_, p_72802_2_, p_72802_3_);
      if(var6 < p_72802_4_) {
         var6 = p_72802_4_;
      }

      return var5 << 20 | var6 << 4;
   }

   public float func_72801_o(int p_72801_1_, int p_72801_2_, int p_72801_3_) {
      return this.field_72815_e.field_73011_w.field_76573_f[this.func_72811_b(p_72801_1_, p_72801_2_, p_72801_3_)];
   }

   public int func_72811_b(int p_72811_1_, int p_72811_2_, int p_72811_3_) {
      return this.func_72813_a(p_72811_1_, p_72811_2_, p_72811_3_, true);
   }

   public int func_72813_a(int p_72813_1_, int p_72813_2_, int p_72813_3_, boolean p_72813_4_) {
      if(p_72813_1_ >= -30000000 && p_72813_3_ >= -30000000 && p_72813_1_ < 30000000 && p_72813_3_ <= 30000000) {
         int var5;
         int var6;
         if(p_72813_4_) {
            var5 = this.func_72798_a(p_72813_1_, p_72813_2_, p_72813_3_);
            if(var5 == Block.field_72079_ak.field_71990_ca || var5 == Block.field_72092_bO.field_71990_ca || var5 == Block.field_72050_aA.field_71990_ca || var5 == Block.field_72063_at.field_71990_ca || var5 == Block.field_72057_aH.field_71990_ca) {
               var6 = this.func_72813_a(p_72813_1_, p_72813_2_ + 1, p_72813_3_, false);
               int var7 = this.func_72813_a(p_72813_1_ + 1, p_72813_2_, p_72813_3_, false);
               int var8 = this.func_72813_a(p_72813_1_ - 1, p_72813_2_, p_72813_3_, false);
               int var9 = this.func_72813_a(p_72813_1_, p_72813_2_, p_72813_3_ + 1, false);
               int var10 = this.func_72813_a(p_72813_1_, p_72813_2_, p_72813_3_ - 1, false);
               if(var7 > var6) {
                  var6 = var7;
               }

               if(var8 > var6) {
                  var6 = var8;
               }

               if(var9 > var6) {
                  var6 = var9;
               }

               if(var10 > var6) {
                  var6 = var10;
               }

               return var6;
            }
         }

         if(p_72813_2_ < 0) {
            return 0;
         } else if(p_72813_2_ >= 256) {
            var5 = 15 - this.field_72815_e.field_73008_k;
            if(var5 < 0) {
               var5 = 0;
            }

            return var5;
         } else {
            var5 = (p_72813_1_ >> 4) - this.field_72818_a;
            var6 = (p_72813_3_ >> 4) - this.field_72816_b;
            return this.field_72817_c[var5][var6].func_76629_c(p_72813_1_ & 15, p_72813_2_, p_72813_3_ & 15, this.field_72815_e.field_73008_k);
         }
      } else {
         return 15;
      }
   }

   public int func_72805_g(int p_72805_1_, int p_72805_2_, int p_72805_3_) {
      if(p_72805_2_ < 0) {
         return 0;
      } else if(p_72805_2_ >= 256) {
         return 0;
      } else {
         int var4 = (p_72805_1_ >> 4) - this.field_72818_a;
         int var5 = (p_72805_3_ >> 4) - this.field_72816_b;
         return this.field_72817_c[var4][var5].func_76628_c(p_72805_1_ & 15, p_72805_2_, p_72805_3_ & 15);
      }
   }

   public Material func_72803_f(int p_72803_1_, int p_72803_2_, int p_72803_3_) {
      int var4 = this.func_72798_a(p_72803_1_, p_72803_2_, p_72803_3_);
      return var4 == 0?Material.field_76249_a:Block.field_71973_m[var4].field_72018_cp;
   }

   public BiomeGenBase func_72807_a(int p_72807_1_, int p_72807_2_) {
      return this.field_72815_e.func_72807_a(p_72807_1_, p_72807_2_);
   }

   public boolean func_72804_r(int p_72804_1_, int p_72804_2_, int p_72804_3_) {
      Block var4 = Block.field_71973_m[this.func_72798_a(p_72804_1_, p_72804_2_, p_72804_3_)];
      return var4 == null?false:var4.func_71926_d();
   }

   public boolean func_72809_s(int p_72809_1_, int p_72809_2_, int p_72809_3_) {
      Block var4 = Block.field_71973_m[this.func_72798_a(p_72809_1_, p_72809_2_, p_72809_3_)];
      return var4 == null?false:var4.field_72018_cp.func_76230_c() && var4.func_71886_c();
   }

   public boolean func_72797_t(int p_72797_1_, int p_72797_2_, int p_72797_3_) {
      Block var4 = Block.field_71973_m[this.func_72798_a(p_72797_1_, p_72797_2_, p_72797_3_)];
      return var4 == null?false:(var4.field_72018_cp.func_76218_k() && var4.func_71886_c()?true:(var4 instanceof BlockStairs?(this.func_72805_g(p_72797_1_, p_72797_2_, p_72797_3_) & 4) == 4:(var4 instanceof BlockHalfSlab?(this.func_72805_g(p_72797_1_, p_72797_2_, p_72797_3_) & 8) == 8:false)));
   }

   public boolean func_72799_c(int p_72799_1_, int p_72799_2_, int p_72799_3_) {
      Block var4 = Block.field_71973_m[this.func_72798_a(p_72799_1_, p_72799_2_, p_72799_3_)];
      return var4 == null;
   }

   public int func_72810_a(EnumSkyBlock p_72810_1_, int p_72810_2_, int p_72810_3_, int p_72810_4_) {
      if(p_72810_3_ < 0) {
         p_72810_3_ = 0;
      }

      if(p_72810_3_ >= 256) {
         p_72810_3_ = 255;
      }

      if(p_72810_3_ >= 0 && p_72810_3_ < 256 && p_72810_2_ >= -30000000 && p_72810_4_ >= -30000000 && p_72810_2_ < 30000000 && p_72810_4_ <= 30000000) {
         int var5;
         int var6;
         if(Block.field_71982_s[this.func_72798_a(p_72810_2_, p_72810_3_, p_72810_4_)]) {
            var5 = this.func_72812_b(p_72810_1_, p_72810_2_, p_72810_3_ + 1, p_72810_4_);
            var6 = this.func_72812_b(p_72810_1_, p_72810_2_ + 1, p_72810_3_, p_72810_4_);
            int var7 = this.func_72812_b(p_72810_1_, p_72810_2_ - 1, p_72810_3_, p_72810_4_);
            int var8 = this.func_72812_b(p_72810_1_, p_72810_2_, p_72810_3_, p_72810_4_ + 1);
            int var9 = this.func_72812_b(p_72810_1_, p_72810_2_, p_72810_3_, p_72810_4_ - 1);
            if(var6 > var5) {
               var5 = var6;
            }

            if(var7 > var5) {
               var5 = var7;
            }

            if(var8 > var5) {
               var5 = var8;
            }

            if(var9 > var5) {
               var5 = var9;
            }

            return var5;
         } else {
            var5 = (p_72810_2_ >> 4) - this.field_72818_a;
            var6 = (p_72810_4_ >> 4) - this.field_72816_b;
            return this.field_72817_c[var5][var6].func_76614_a(p_72810_1_, p_72810_2_ & 15, p_72810_3_, p_72810_4_ & 15);
         }
      } else {
         return p_72810_1_.field_77198_c;
      }
   }

   public int func_72812_b(EnumSkyBlock p_72812_1_, int p_72812_2_, int p_72812_3_, int p_72812_4_) {
      if(p_72812_3_ < 0) {
         p_72812_3_ = 0;
      }

      if(p_72812_3_ >= 256) {
         p_72812_3_ = 255;
      }

      if(p_72812_3_ >= 0 && p_72812_3_ < 256 && p_72812_2_ >= -30000000 && p_72812_4_ >= -30000000 && p_72812_2_ < 30000000 && p_72812_4_ <= 30000000) {
         int var5 = (p_72812_2_ >> 4) - this.field_72818_a;
         int var6 = (p_72812_4_ >> 4) - this.field_72816_b;
         return this.field_72817_c[var5][var6].func_76614_a(p_72812_1_, p_72812_2_ & 15, p_72812_3_, p_72812_4_ & 15);
      } else {
         return p_72812_1_.field_77198_c;
      }
   }

   public int func_72800_K() {
      return 256;
   }
}
