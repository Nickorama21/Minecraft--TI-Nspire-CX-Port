package net.minecraft.src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.BlockTorch;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.RedstoneUpdateInfo;
import net.minecraft.src.World;

public class BlockRedstoneTorch extends BlockTorch {

   private boolean field_72130_a = false;
   private static Map field_72129_b = new HashMap();


   public int func_71858_a(int p_71858_1_, int p_71858_2_) {
      return p_71858_1_ == 1?Block.field_72075_av.func_71858_a(p_71858_1_, p_71858_2_):super.func_71858_a(p_71858_1_, p_71858_2_);
   }

   private boolean func_72127_a(World p_72127_1_, int p_72127_2_, int p_72127_3_, int p_72127_4_, boolean p_72127_5_) {
      if(!field_72129_b.containsKey(p_72127_1_)) {
         field_72129_b.put(p_72127_1_, new ArrayList());
      }

      if(p_72127_5_) {
         ((List)field_72129_b.get(p_72127_1_)).add(new RedstoneUpdateInfo(p_72127_2_, p_72127_3_, p_72127_4_, p_72127_1_.func_72820_D()));
      }

      int var6 = 0;
      Iterator var7 = ((List)field_72129_b.get(p_72127_1_)).iterator();

      while(var7.hasNext()) {
         RedstoneUpdateInfo var8 = (RedstoneUpdateInfo)var7.next();
         if(var8.field_73664_a == p_72127_2_ && var8.field_73662_b == p_72127_3_ && var8.field_73663_c == p_72127_4_) {
            ++var6;
            if(var6 >= 8) {
               return true;
            }
         }
      }

      return false;
   }

   protected BlockRedstoneTorch(int p_i3976_1_, int p_i3976_2_, boolean p_i3976_3_) {
      super(p_i3976_1_, p_i3976_2_);
      this.field_72130_a = p_i3976_3_;
      this.func_71907_b(true);
      this.func_71849_a((CreativeTabs)null);
   }

   public int func_71859_p_() {
      return 2;
   }

   public void func_71861_g(World p_71861_1_, int p_71861_2_, int p_71861_3_, int p_71861_4_) {
      if(p_71861_1_.func_72805_g(p_71861_2_, p_71861_3_, p_71861_4_) == 0) {
         super.func_71861_g(p_71861_1_, p_71861_2_, p_71861_3_, p_71861_4_);
      }

      if(this.field_72130_a) {
         p_71861_1_.func_72898_h(p_71861_2_, p_71861_3_ - 1, p_71861_4_, this.field_71990_ca);
         p_71861_1_.func_72898_h(p_71861_2_, p_71861_3_ + 1, p_71861_4_, this.field_71990_ca);
         p_71861_1_.func_72898_h(p_71861_2_ - 1, p_71861_3_, p_71861_4_, this.field_71990_ca);
         p_71861_1_.func_72898_h(p_71861_2_ + 1, p_71861_3_, p_71861_4_, this.field_71990_ca);
         p_71861_1_.func_72898_h(p_71861_2_, p_71861_3_, p_71861_4_ - 1, this.field_71990_ca);
         p_71861_1_.func_72898_h(p_71861_2_, p_71861_3_, p_71861_4_ + 1, this.field_71990_ca);
      }

   }

   public void func_71852_a(World p_71852_1_, int p_71852_2_, int p_71852_3_, int p_71852_4_, int p_71852_5_, int p_71852_6_) {
      if(this.field_72130_a) {
         p_71852_1_.func_72898_h(p_71852_2_, p_71852_3_ - 1, p_71852_4_, this.field_71990_ca);
         p_71852_1_.func_72898_h(p_71852_2_, p_71852_3_ + 1, p_71852_4_, this.field_71990_ca);
         p_71852_1_.func_72898_h(p_71852_2_ - 1, p_71852_3_, p_71852_4_, this.field_71990_ca);
         p_71852_1_.func_72898_h(p_71852_2_ + 1, p_71852_3_, p_71852_4_, this.field_71990_ca);
         p_71852_1_.func_72898_h(p_71852_2_, p_71852_3_, p_71852_4_ - 1, this.field_71990_ca);
         p_71852_1_.func_72898_h(p_71852_2_, p_71852_3_, p_71852_4_ + 1, this.field_71990_ca);
      }

   }

   public boolean func_71865_a(IBlockAccess p_71865_1_, int p_71865_2_, int p_71865_3_, int p_71865_4_, int p_71865_5_) {
      if(!this.field_72130_a) {
         return false;
      } else {
         int var6 = p_71865_1_.func_72805_g(p_71865_2_, p_71865_3_, p_71865_4_);
         return var6 == 5 && p_71865_5_ == 1?false:(var6 == 3 && p_71865_5_ == 3?false:(var6 == 4 && p_71865_5_ == 2?false:(var6 == 1 && p_71865_5_ == 5?false:var6 != 2 || p_71865_5_ != 4)));
      }
   }

   private boolean func_72128_l(World p_72128_1_, int p_72128_2_, int p_72128_3_, int p_72128_4_) {
      int var5 = p_72128_1_.func_72805_g(p_72128_2_, p_72128_3_, p_72128_4_);
      return var5 == 5 && p_72128_1_.func_72878_l(p_72128_2_, p_72128_3_ - 1, p_72128_4_, 0)?true:(var5 == 3 && p_72128_1_.func_72878_l(p_72128_2_, p_72128_3_, p_72128_4_ - 1, 2)?true:(var5 == 4 && p_72128_1_.func_72878_l(p_72128_2_, p_72128_3_, p_72128_4_ + 1, 3)?true:(var5 == 1 && p_72128_1_.func_72878_l(p_72128_2_ - 1, p_72128_3_, p_72128_4_, 4)?true:var5 == 2 && p_72128_1_.func_72878_l(p_72128_2_ + 1, p_72128_3_, p_72128_4_, 5))));
   }

   public void func_71847_b(World p_71847_1_, int p_71847_2_, int p_71847_3_, int p_71847_4_, Random p_71847_5_) {
      boolean var6 = this.func_72128_l(p_71847_1_, p_71847_2_, p_71847_3_, p_71847_4_);
      List var7 = (List)field_72129_b.get(p_71847_1_);

      while(var7 != null && !var7.isEmpty() && p_71847_1_.func_72820_D() - ((RedstoneUpdateInfo)var7.get(0)).field_73661_d > 60L) {
         var7.remove(0);
      }

      if(this.field_72130_a) {
         if(var6) {
            p_71847_1_.func_72832_d(p_71847_2_, p_71847_3_, p_71847_4_, Block.field_72049_aP.field_71990_ca, p_71847_1_.func_72805_g(p_71847_2_, p_71847_3_, p_71847_4_));
            if(this.func_72127_a(p_71847_1_, p_71847_2_, p_71847_3_, p_71847_4_, true)) {
               p_71847_1_.func_72908_a((double)((float)p_71847_2_ + 0.5F), (double)((float)p_71847_3_ + 0.5F), (double)((float)p_71847_4_ + 0.5F), "random.fizz", 0.5F, 2.6F + (p_71847_1_.field_73012_v.nextFloat() - p_71847_1_.field_73012_v.nextFloat()) * 0.8F);

               for(int var8 = 0; var8 < 5; ++var8) {
                  double var9 = (double)p_71847_2_ + p_71847_5_.nextDouble() * 0.6D + 0.2D;
                  double var11 = (double)p_71847_3_ + p_71847_5_.nextDouble() * 0.6D + 0.2D;
                  double var13 = (double)p_71847_4_ + p_71847_5_.nextDouble() * 0.6D + 0.2D;
                  p_71847_1_.func_72869_a("smoke", var9, var11, var13, 0.0D, 0.0D, 0.0D);
               }
            }
         }
      } else if(!var6 && !this.func_72127_a(p_71847_1_, p_71847_2_, p_71847_3_, p_71847_4_, false)) {
         p_71847_1_.func_72832_d(p_71847_2_, p_71847_3_, p_71847_4_, Block.field_72035_aQ.field_71990_ca, p_71847_1_.func_72805_g(p_71847_2_, p_71847_3_, p_71847_4_));
      }

   }

   public void func_71863_a(World p_71863_1_, int p_71863_2_, int p_71863_3_, int p_71863_4_, int p_71863_5_) {
      super.func_71863_a(p_71863_1_, p_71863_2_, p_71863_3_, p_71863_4_, p_71863_5_);
      p_71863_1_.func_72836_a(p_71863_2_, p_71863_3_, p_71863_4_, this.field_71990_ca, this.func_71859_p_());
   }

   public boolean func_71855_c(World p_71855_1_, int p_71855_2_, int p_71855_3_, int p_71855_4_, int p_71855_5_) {
      return p_71855_5_ == 0?this.func_71865_a(p_71855_1_, p_71855_2_, p_71855_3_, p_71855_4_, p_71855_5_):false;
   }

   public int func_71885_a(int p_71885_1_, Random p_71885_2_, int p_71885_3_) {
      return Block.field_72035_aQ.field_71990_ca;
   }

   public boolean func_71853_i() {
      return true;
   }

   public void func_71862_a(World p_71862_1_, int p_71862_2_, int p_71862_3_, int p_71862_4_, Random p_71862_5_) {
      if(this.field_72130_a) {
         int var6 = p_71862_1_.func_72805_g(p_71862_2_, p_71862_3_, p_71862_4_);
         double var7 = (double)((float)p_71862_2_ + 0.5F) + (double)(p_71862_5_.nextFloat() - 0.5F) * 0.2D;
         double var9 = (double)((float)p_71862_3_ + 0.7F) + (double)(p_71862_5_.nextFloat() - 0.5F) * 0.2D;
         double var11 = (double)((float)p_71862_4_ + 0.5F) + (double)(p_71862_5_.nextFloat() - 0.5F) * 0.2D;
         double var13 = 0.2199999988079071D;
         double var15 = 0.27000001072883606D;
         if(var6 == 1) {
            p_71862_1_.func_72869_a("reddust", var7 - var15, var9 + var13, var11, 0.0D, 0.0D, 0.0D);
         } else if(var6 == 2) {
            p_71862_1_.func_72869_a("reddust", var7 + var15, var9 + var13, var11, 0.0D, 0.0D, 0.0D);
         } else if(var6 == 3) {
            p_71862_1_.func_72869_a("reddust", var7, var9 + var13, var11 - var15, 0.0D, 0.0D, 0.0D);
         } else if(var6 == 4) {
            p_71862_1_.func_72869_a("reddust", var7, var9 + var13, var11 + var15, 0.0D, 0.0D, 0.0D);
         } else {
            p_71862_1_.func_72869_a("reddust", var7, var9, var11, 0.0D, 0.0D, 0.0D);
         }

      }
   }

   public int func_71922_a(World p_71922_1_, int p_71922_2_, int p_71922_3_, int p_71922_4_) {
      return Block.field_72035_aQ.field_71990_ca;
   }

   public void func_71937_a(World p_71937_1_, long p_71937_2_, long p_71937_4_) {
      List var6 = (List)field_72129_b.get(p_71937_1_);
      RedstoneUpdateInfo var8;
      if(var6 != null) {
         for(Iterator var7 = var6.iterator(); var7.hasNext(); var8.field_73661_d += p_71937_2_) {
            var8 = (RedstoneUpdateInfo)var7.next();
         }
      }

   }

}
