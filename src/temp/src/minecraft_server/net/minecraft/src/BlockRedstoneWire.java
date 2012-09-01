package net.minecraft.src;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.ChunkPosition;
import net.minecraft.src.Direction;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.Item;
import net.minecraft.src.Material;
import net.minecraft.src.World;

public class BlockRedstoneWire extends Block {

   private boolean field_72175_a = true;
   private Set field_72174_b = new HashSet();


   public BlockRedstoneWire(int p_i3986_1_, int p_i3986_2_) {
      super(p_i3986_1_, p_i3986_2_, Material.field_76265_p);
      this.func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 0.0625F, 1.0F);
   }

   public int func_71858_a(int p_71858_1_, int p_71858_2_) {
      return this.field_72059_bZ;
   }

   public AxisAlignedBB func_71872_e(World p_71872_1_, int p_71872_2_, int p_71872_3_, int p_71872_4_) {
      return null;
   }

   public boolean func_71926_d() {
      return false;
   }

   public boolean func_71886_c() {
      return false;
   }

   public int func_71857_b() {
      return 5;
   }

   public boolean func_71930_b(World p_71930_1_, int p_71930_2_, int p_71930_3_, int p_71930_4_) {
      return p_71930_1_.func_72797_t(p_71930_2_, p_71930_3_ - 1, p_71930_4_) || p_71930_1_.func_72798_a(p_71930_2_, p_71930_3_ - 1, p_71930_4_) == Block.field_72014_bd.field_71990_ca;
   }

   private void func_72168_l(World p_72168_1_, int p_72168_2_, int p_72168_3_, int p_72168_4_) {
      this.func_72171_a(p_72168_1_, p_72168_2_, p_72168_3_, p_72168_4_, p_72168_2_, p_72168_3_, p_72168_4_);
      ArrayList var5 = new ArrayList(this.field_72174_b);
      this.field_72174_b.clear();
      Iterator var6 = var5.iterator();

      while(var6.hasNext()) {
         ChunkPosition var7 = (ChunkPosition)var6.next();
         p_72168_1_.func_72898_h(var7.field_76930_a, var7.field_76928_b, var7.field_76929_c, this.field_71990_ca);
      }

   }

   private void func_72171_a(World p_72171_1_, int p_72171_2_, int p_72171_3_, int p_72171_4_, int p_72171_5_, int p_72171_6_, int p_72171_7_) {
      int var8 = p_72171_1_.func_72805_g(p_72171_2_, p_72171_3_, p_72171_4_);
      int var9 = 0;
      this.field_72175_a = false;
      boolean var10 = p_72171_1_.func_72864_z(p_72171_2_, p_72171_3_, p_72171_4_);
      this.field_72175_a = true;
      int var11;
      int var12;
      int var13;
      if(var10) {
         var9 = 15;
      } else {
         for(var11 = 0; var11 < 4; ++var11) {
            var12 = p_72171_2_;
            var13 = p_72171_4_;
            if(var11 == 0) {
               var12 = p_72171_2_ - 1;
            }

            if(var11 == 1) {
               ++var12;
            }

            if(var11 == 2) {
               var13 = p_72171_4_ - 1;
            }

            if(var11 == 3) {
               ++var13;
            }

            if(var12 != p_72171_5_ || p_72171_3_ != p_72171_6_ || var13 != p_72171_7_) {
               var9 = this.func_72170_e(p_72171_1_, var12, p_72171_3_, var13, var9);
            }

            if(p_72171_1_.func_72809_s(var12, p_72171_3_, var13) && !p_72171_1_.func_72809_s(p_72171_2_, p_72171_3_ + 1, p_72171_4_)) {
               if(var12 != p_72171_5_ || p_72171_3_ + 1 != p_72171_6_ || var13 != p_72171_7_) {
                  var9 = this.func_72170_e(p_72171_1_, var12, p_72171_3_ + 1, var13, var9);
               }
            } else if(!p_72171_1_.func_72809_s(var12, p_72171_3_, var13) && (var12 != p_72171_5_ || p_72171_3_ - 1 != p_72171_6_ || var13 != p_72171_7_)) {
               var9 = this.func_72170_e(p_72171_1_, var12, p_72171_3_ - 1, var13, var9);
            }
         }

         if(var9 > 0) {
            --var9;
         } else {
            var9 = 0;
         }
      }

      if(var8 != var9) {
         p_72171_1_.field_73014_t = true;
         p_72171_1_.func_72921_c(p_72171_2_, p_72171_3_, p_72171_4_, var9);
         p_72171_1_.func_72909_d(p_72171_2_, p_72171_3_, p_72171_4_, p_72171_2_, p_72171_3_, p_72171_4_);
         p_72171_1_.field_73014_t = false;

         for(var11 = 0; var11 < 4; ++var11) {
            var12 = p_72171_2_;
            var13 = p_72171_4_;
            int var14 = p_72171_3_ - 1;
            if(var11 == 0) {
               var12 = p_72171_2_ - 1;
            }

            if(var11 == 1) {
               ++var12;
            }

            if(var11 == 2) {
               var13 = p_72171_4_ - 1;
            }

            if(var11 == 3) {
               ++var13;
            }

            if(p_72171_1_.func_72809_s(var12, p_72171_3_, var13)) {
               var14 += 2;
            }

            boolean var15 = false;
            int var16 = this.func_72170_e(p_72171_1_, var12, p_72171_3_, var13, -1);
            var9 = p_72171_1_.func_72805_g(p_72171_2_, p_72171_3_, p_72171_4_);
            if(var9 > 0) {
               --var9;
            }

            if(var16 >= 0 && var16 != var9) {
               this.func_72171_a(p_72171_1_, var12, p_72171_3_, var13, p_72171_2_, p_72171_3_, p_72171_4_);
            }

            var16 = this.func_72170_e(p_72171_1_, var12, var14, var13, -1);
            var9 = p_72171_1_.func_72805_g(p_72171_2_, p_72171_3_, p_72171_4_);
            if(var9 > 0) {
               --var9;
            }

            if(var16 >= 0 && var16 != var9) {
               this.func_72171_a(p_72171_1_, var12, var14, var13, p_72171_2_, p_72171_3_, p_72171_4_);
            }
         }

         if(var8 < var9 || var9 == 0) {
            this.field_72174_b.add(new ChunkPosition(p_72171_2_, p_72171_3_, p_72171_4_));
            this.field_72174_b.add(new ChunkPosition(p_72171_2_ - 1, p_72171_3_, p_72171_4_));
            this.field_72174_b.add(new ChunkPosition(p_72171_2_ + 1, p_72171_3_, p_72171_4_));
            this.field_72174_b.add(new ChunkPosition(p_72171_2_, p_72171_3_ - 1, p_72171_4_));
            this.field_72174_b.add(new ChunkPosition(p_72171_2_, p_72171_3_ + 1, p_72171_4_));
            this.field_72174_b.add(new ChunkPosition(p_72171_2_, p_72171_3_, p_72171_4_ - 1));
            this.field_72174_b.add(new ChunkPosition(p_72171_2_, p_72171_3_, p_72171_4_ + 1));
         }
      }

   }

   private void func_72172_n(World p_72172_1_, int p_72172_2_, int p_72172_3_, int p_72172_4_) {
      if(p_72172_1_.func_72798_a(p_72172_2_, p_72172_3_, p_72172_4_) == this.field_71990_ca) {
         p_72172_1_.func_72898_h(p_72172_2_, p_72172_3_, p_72172_4_, this.field_71990_ca);
         p_72172_1_.func_72898_h(p_72172_2_ - 1, p_72172_3_, p_72172_4_, this.field_71990_ca);
         p_72172_1_.func_72898_h(p_72172_2_ + 1, p_72172_3_, p_72172_4_, this.field_71990_ca);
         p_72172_1_.func_72898_h(p_72172_2_, p_72172_3_, p_72172_4_ - 1, this.field_71990_ca);
         p_72172_1_.func_72898_h(p_72172_2_, p_72172_3_, p_72172_4_ + 1, this.field_71990_ca);
         p_72172_1_.func_72898_h(p_72172_2_, p_72172_3_ - 1, p_72172_4_, this.field_71990_ca);
         p_72172_1_.func_72898_h(p_72172_2_, p_72172_3_ + 1, p_72172_4_, this.field_71990_ca);
      }
   }

   public void func_71861_g(World p_71861_1_, int p_71861_2_, int p_71861_3_, int p_71861_4_) {
      super.func_71861_g(p_71861_1_, p_71861_2_, p_71861_3_, p_71861_4_);
      if(!p_71861_1_.field_72995_K) {
         this.func_72168_l(p_71861_1_, p_71861_2_, p_71861_3_, p_71861_4_);
         p_71861_1_.func_72898_h(p_71861_2_, p_71861_3_ + 1, p_71861_4_, this.field_71990_ca);
         p_71861_1_.func_72898_h(p_71861_2_, p_71861_3_ - 1, p_71861_4_, this.field_71990_ca);
         this.func_72172_n(p_71861_1_, p_71861_2_ - 1, p_71861_3_, p_71861_4_);
         this.func_72172_n(p_71861_1_, p_71861_2_ + 1, p_71861_3_, p_71861_4_);
         this.func_72172_n(p_71861_1_, p_71861_2_, p_71861_3_, p_71861_4_ - 1);
         this.func_72172_n(p_71861_1_, p_71861_2_, p_71861_3_, p_71861_4_ + 1);
         if(p_71861_1_.func_72809_s(p_71861_2_ - 1, p_71861_3_, p_71861_4_)) {
            this.func_72172_n(p_71861_1_, p_71861_2_ - 1, p_71861_3_ + 1, p_71861_4_);
         } else {
            this.func_72172_n(p_71861_1_, p_71861_2_ - 1, p_71861_3_ - 1, p_71861_4_);
         }

         if(p_71861_1_.func_72809_s(p_71861_2_ + 1, p_71861_3_, p_71861_4_)) {
            this.func_72172_n(p_71861_1_, p_71861_2_ + 1, p_71861_3_ + 1, p_71861_4_);
         } else {
            this.func_72172_n(p_71861_1_, p_71861_2_ + 1, p_71861_3_ - 1, p_71861_4_);
         }

         if(p_71861_1_.func_72809_s(p_71861_2_, p_71861_3_, p_71861_4_ - 1)) {
            this.func_72172_n(p_71861_1_, p_71861_2_, p_71861_3_ + 1, p_71861_4_ - 1);
         } else {
            this.func_72172_n(p_71861_1_, p_71861_2_, p_71861_3_ - 1, p_71861_4_ - 1);
         }

         if(p_71861_1_.func_72809_s(p_71861_2_, p_71861_3_, p_71861_4_ + 1)) {
            this.func_72172_n(p_71861_1_, p_71861_2_, p_71861_3_ + 1, p_71861_4_ + 1);
         } else {
            this.func_72172_n(p_71861_1_, p_71861_2_, p_71861_3_ - 1, p_71861_4_ + 1);
         }

      }
   }

   public void func_71852_a(World p_71852_1_, int p_71852_2_, int p_71852_3_, int p_71852_4_, int p_71852_5_, int p_71852_6_) {
      super.func_71852_a(p_71852_1_, p_71852_2_, p_71852_3_, p_71852_4_, p_71852_5_, p_71852_6_);
      if(!p_71852_1_.field_72995_K) {
         p_71852_1_.func_72898_h(p_71852_2_, p_71852_3_ + 1, p_71852_4_, this.field_71990_ca);
         p_71852_1_.func_72898_h(p_71852_2_, p_71852_3_ - 1, p_71852_4_, this.field_71990_ca);
         p_71852_1_.func_72898_h(p_71852_2_ + 1, p_71852_3_, p_71852_4_, this.field_71990_ca);
         p_71852_1_.func_72898_h(p_71852_2_ - 1, p_71852_3_, p_71852_4_, this.field_71990_ca);
         p_71852_1_.func_72898_h(p_71852_2_, p_71852_3_, p_71852_4_ + 1, this.field_71990_ca);
         p_71852_1_.func_72898_h(p_71852_2_, p_71852_3_, p_71852_4_ - 1, this.field_71990_ca);
         this.func_72168_l(p_71852_1_, p_71852_2_, p_71852_3_, p_71852_4_);
         this.func_72172_n(p_71852_1_, p_71852_2_ - 1, p_71852_3_, p_71852_4_);
         this.func_72172_n(p_71852_1_, p_71852_2_ + 1, p_71852_3_, p_71852_4_);
         this.func_72172_n(p_71852_1_, p_71852_2_, p_71852_3_, p_71852_4_ - 1);
         this.func_72172_n(p_71852_1_, p_71852_2_, p_71852_3_, p_71852_4_ + 1);
         if(p_71852_1_.func_72809_s(p_71852_2_ - 1, p_71852_3_, p_71852_4_)) {
            this.func_72172_n(p_71852_1_, p_71852_2_ - 1, p_71852_3_ + 1, p_71852_4_);
         } else {
            this.func_72172_n(p_71852_1_, p_71852_2_ - 1, p_71852_3_ - 1, p_71852_4_);
         }

         if(p_71852_1_.func_72809_s(p_71852_2_ + 1, p_71852_3_, p_71852_4_)) {
            this.func_72172_n(p_71852_1_, p_71852_2_ + 1, p_71852_3_ + 1, p_71852_4_);
         } else {
            this.func_72172_n(p_71852_1_, p_71852_2_ + 1, p_71852_3_ - 1, p_71852_4_);
         }

         if(p_71852_1_.func_72809_s(p_71852_2_, p_71852_3_, p_71852_4_ - 1)) {
            this.func_72172_n(p_71852_1_, p_71852_2_, p_71852_3_ + 1, p_71852_4_ - 1);
         } else {
            this.func_72172_n(p_71852_1_, p_71852_2_, p_71852_3_ - 1, p_71852_4_ - 1);
         }

         if(p_71852_1_.func_72809_s(p_71852_2_, p_71852_3_, p_71852_4_ + 1)) {
            this.func_72172_n(p_71852_1_, p_71852_2_, p_71852_3_ + 1, p_71852_4_ + 1);
         } else {
            this.func_72172_n(p_71852_1_, p_71852_2_, p_71852_3_ - 1, p_71852_4_ + 1);
         }

      }
   }

   private int func_72170_e(World p_72170_1_, int p_72170_2_, int p_72170_3_, int p_72170_4_, int p_72170_5_) {
      if(p_72170_1_.func_72798_a(p_72170_2_, p_72170_3_, p_72170_4_) != this.field_71990_ca) {
         return p_72170_5_;
      } else {
         int var6 = p_72170_1_.func_72805_g(p_72170_2_, p_72170_3_, p_72170_4_);
         return var6 > p_72170_5_?var6:p_72170_5_;
      }
   }

   public void func_71863_a(World p_71863_1_, int p_71863_2_, int p_71863_3_, int p_71863_4_, int p_71863_5_) {
      if(!p_71863_1_.field_72995_K) {
         int var6 = p_71863_1_.func_72805_g(p_71863_2_, p_71863_3_, p_71863_4_);
         boolean var7 = this.func_71930_b(p_71863_1_, p_71863_2_, p_71863_3_, p_71863_4_);
         if(var7) {
            this.func_72168_l(p_71863_1_, p_71863_2_, p_71863_3_, p_71863_4_);
         } else {
            this.func_71897_c(p_71863_1_, p_71863_2_, p_71863_3_, p_71863_4_, var6, 0);
            p_71863_1_.func_72859_e(p_71863_2_, p_71863_3_, p_71863_4_, 0);
         }

         super.func_71863_a(p_71863_1_, p_71863_2_, p_71863_3_, p_71863_4_, p_71863_5_);
      }
   }

   public int func_71885_a(int p_71885_1_, Random p_71885_2_, int p_71885_3_) {
      return Item.field_77767_aC.field_77779_bT;
   }

   public boolean func_71855_c(World p_71855_1_, int p_71855_2_, int p_71855_3_, int p_71855_4_, int p_71855_5_) {
      return !this.field_72175_a?false:this.func_71865_a(p_71855_1_, p_71855_2_, p_71855_3_, p_71855_4_, p_71855_5_);
   }

   public boolean func_71865_a(IBlockAccess p_71865_1_, int p_71865_2_, int p_71865_3_, int p_71865_4_, int p_71865_5_) {
      if(!this.field_72175_a) {
         return false;
      } else if(p_71865_1_.func_72805_g(p_71865_2_, p_71865_3_, p_71865_4_) == 0) {
         return false;
      } else if(p_71865_5_ == 1) {
         return true;
      } else {
         boolean var6 = func_72169_f(p_71865_1_, p_71865_2_ - 1, p_71865_3_, p_71865_4_, 1) || !p_71865_1_.func_72809_s(p_71865_2_ - 1, p_71865_3_, p_71865_4_) && func_72169_f(p_71865_1_, p_71865_2_ - 1, p_71865_3_ - 1, p_71865_4_, -1);
         boolean var7 = func_72169_f(p_71865_1_, p_71865_2_ + 1, p_71865_3_, p_71865_4_, 3) || !p_71865_1_.func_72809_s(p_71865_2_ + 1, p_71865_3_, p_71865_4_) && func_72169_f(p_71865_1_, p_71865_2_ + 1, p_71865_3_ - 1, p_71865_4_, -1);
         boolean var8 = func_72169_f(p_71865_1_, p_71865_2_, p_71865_3_, p_71865_4_ - 1, 2) || !p_71865_1_.func_72809_s(p_71865_2_, p_71865_3_, p_71865_4_ - 1) && func_72169_f(p_71865_1_, p_71865_2_, p_71865_3_ - 1, p_71865_4_ - 1, -1);
         boolean var9 = func_72169_f(p_71865_1_, p_71865_2_, p_71865_3_, p_71865_4_ + 1, 0) || !p_71865_1_.func_72809_s(p_71865_2_, p_71865_3_, p_71865_4_ + 1) && func_72169_f(p_71865_1_, p_71865_2_, p_71865_3_ - 1, p_71865_4_ + 1, -1);
         if(!p_71865_1_.func_72809_s(p_71865_2_, p_71865_3_ + 1, p_71865_4_)) {
            if(p_71865_1_.func_72809_s(p_71865_2_ - 1, p_71865_3_, p_71865_4_) && func_72169_f(p_71865_1_, p_71865_2_ - 1, p_71865_3_ + 1, p_71865_4_, -1)) {
               var6 = true;
            }

            if(p_71865_1_.func_72809_s(p_71865_2_ + 1, p_71865_3_, p_71865_4_) && func_72169_f(p_71865_1_, p_71865_2_ + 1, p_71865_3_ + 1, p_71865_4_, -1)) {
               var7 = true;
            }

            if(p_71865_1_.func_72809_s(p_71865_2_, p_71865_3_, p_71865_4_ - 1) && func_72169_f(p_71865_1_, p_71865_2_, p_71865_3_ + 1, p_71865_4_ - 1, -1)) {
               var8 = true;
            }

            if(p_71865_1_.func_72809_s(p_71865_2_, p_71865_3_, p_71865_4_ + 1) && func_72169_f(p_71865_1_, p_71865_2_, p_71865_3_ + 1, p_71865_4_ + 1, -1)) {
               var9 = true;
            }
         }

         return !var8 && !var7 && !var6 && !var9 && p_71865_5_ >= 2 && p_71865_5_ <= 5?true:(p_71865_5_ == 2 && var8 && !var6 && !var7?true:(p_71865_5_ == 3 && var9 && !var6 && !var7?true:(p_71865_5_ == 4 && var6 && !var8 && !var9?true:p_71865_5_ == 5 && var7 && !var8 && !var9)));
      }
   }

   public boolean func_71853_i() {
      return this.field_72175_a;
   }

   public static boolean func_72173_e(IBlockAccess p_72173_0_, int p_72173_1_, int p_72173_2_, int p_72173_3_, int p_72173_4_) {
      int var5 = p_72173_0_.func_72798_a(p_72173_1_, p_72173_2_, p_72173_3_);
      if(var5 == Block.field_72075_av.field_71990_ca) {
         return true;
      } else if(var5 == 0) {
         return false;
      } else if(var5 != Block.field_72010_bh.field_71990_ca && var5 != Block.field_72011_bi.field_71990_ca) {
         return Block.field_71973_m[var5].func_71853_i() && p_72173_4_ != -1;
      } else {
         int var6 = p_72173_0_.func_72805_g(p_72173_1_, p_72173_2_, p_72173_3_);
         return p_72173_4_ == (var6 & 3) || p_72173_4_ == Direction.field_71580_e[var6 & 3];
      }
   }

   public static boolean func_72169_f(IBlockAccess p_72169_0_, int p_72169_1_, int p_72169_2_, int p_72169_3_, int p_72169_4_) {
      if(func_72173_e(p_72169_0_, p_72169_1_, p_72169_2_, p_72169_3_, p_72169_4_)) {
         return true;
      } else {
         int var5 = p_72169_0_.func_72798_a(p_72169_1_, p_72169_2_, p_72169_3_);
         if(var5 == Block.field_72011_bi.field_71990_ca) {
            int var6 = p_72169_0_.func_72805_g(p_72169_1_, p_72169_2_, p_72169_3_);
            return p_72169_4_ == (var6 & 3);
         } else {
            return false;
         }
      }
   }
}
