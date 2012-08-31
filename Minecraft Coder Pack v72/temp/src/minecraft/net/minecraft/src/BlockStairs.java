package net.minecraft.src;

import java.util.List;
import java.util.Random;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.MathHelper;
import net.minecraft.src.MovingObjectPosition;
import net.minecraft.src.Vec3;
import net.minecraft.src.World;

public class BlockStairs extends Block {

   private static final int[][] field_72159_a = new int[][]{{2, 6}, {3, 7}, {2, 3}, {6, 7}, {0, 4}, {1, 5}, {0, 1}, {4, 5}};
   private final Block field_72157_b;
   private final int field_72158_c;
   private boolean field_72156_cr = false;
   private int field_72160_cs = 0;


   protected BlockStairs(int p_i3997_1_, Block p_i3997_2_, int p_i3997_3_) {
      super(p_i3997_1_, p_i3997_2_.field_72059_bZ, p_i3997_2_.field_72018_cp);
      this.field_72157_b = p_i3997_2_;
      this.field_72158_c = p_i3997_3_;
      this.func_71848_c(p_i3997_2_.field_71989_cb);
      this.func_71894_b(p_i3997_2_.field_72029_cc / 3.0F);
      this.func_71884_a(p_i3997_2_.field_72020_cn);
      this.func_71868_h(255);
      this.func_71849_a(CreativeTabs.field_78030_b);
   }

   public void func_71902_a(IBlockAccess p_71902_1_, int p_71902_2_, int p_71902_3_, int p_71902_4_) {
      if(this.field_72156_cr) {
         this.func_71905_a(0.5F * (float)(this.field_72160_cs % 2), 0.5F * (float)(this.field_72160_cs / 2 % 2), 0.5F * (float)(this.field_72160_cs / 4 % 2), 0.5F + 0.5F * (float)(this.field_72160_cs % 2), 0.5F + 0.5F * (float)(this.field_72160_cs / 2 % 2), 0.5F + 0.5F * (float)(this.field_72160_cs / 4 % 2));
      } else {
         this.func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
      }

   }

   public boolean func_71926_d() {
      return false;
   }

   public boolean func_71886_c() {
      return false;
   }

   public int func_71857_b() {
      return 10;
   }

   public void func_71871_a(World p_71871_1_, int p_71871_2_, int p_71871_3_, int p_71871_4_, AxisAlignedBB p_71871_5_, List p_71871_6_, Entity p_71871_7_) {
      int var8 = p_71871_1_.func_72805_g(p_71871_2_, p_71871_3_, p_71871_4_);
      int var9 = var8 & 3;
      float var10 = 0.0F;
      float var11 = 0.5F;
      float var12 = 0.5F;
      float var13 = 1.0F;
      if((var8 & 4) != 0) {
         var10 = 0.5F;
         var11 = 1.0F;
         var12 = 0.0F;
         var13 = 0.5F;
      }

      this.func_71905_a(0.0F, var10, 0.0F, 1.0F, var11, 1.0F);
      super.func_71871_a(p_71871_1_, p_71871_2_, p_71871_3_, p_71871_4_, p_71871_5_, p_71871_6_, p_71871_7_);
      if(var9 == 0) {
         this.func_71905_a(0.5F, var12, 0.0F, 1.0F, var13, 1.0F);
         super.func_71871_a(p_71871_1_, p_71871_2_, p_71871_3_, p_71871_4_, p_71871_5_, p_71871_6_, p_71871_7_);
      } else if(var9 == 1) {
         this.func_71905_a(0.0F, var12, 0.0F, 0.5F, var13, 1.0F);
         super.func_71871_a(p_71871_1_, p_71871_2_, p_71871_3_, p_71871_4_, p_71871_5_, p_71871_6_, p_71871_7_);
      } else if(var9 == 2) {
         this.func_71905_a(0.0F, var12, 0.5F, 1.0F, var13, 1.0F);
         super.func_71871_a(p_71871_1_, p_71871_2_, p_71871_3_, p_71871_4_, p_71871_5_, p_71871_6_, p_71871_7_);
      } else if(var9 == 3) {
         this.func_71905_a(0.0F, var12, 0.0F, 1.0F, var13, 0.5F);
         super.func_71871_a(p_71871_1_, p_71871_2_, p_71871_3_, p_71871_4_, p_71871_5_, p_71871_6_, p_71871_7_);
      }

      this.func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
   }

   public void func_71862_a(World p_71862_1_, int p_71862_2_, int p_71862_3_, int p_71862_4_, Random p_71862_5_) {
      this.field_72157_b.func_71862_a(p_71862_1_, p_71862_2_, p_71862_3_, p_71862_4_, p_71862_5_);
   }

   public void func_71921_a(World p_71921_1_, int p_71921_2_, int p_71921_3_, int p_71921_4_, EntityPlayer p_71921_5_) {
      this.field_72157_b.func_71921_a(p_71921_1_, p_71921_2_, p_71921_3_, p_71921_4_, p_71921_5_);
   }

   public void func_71898_d(World p_71898_1_, int p_71898_2_, int p_71898_3_, int p_71898_4_, int p_71898_5_) {
      this.field_72157_b.func_71898_d(p_71898_1_, p_71898_2_, p_71898_3_, p_71898_4_, p_71898_5_);
   }

   public int func_71874_e(IBlockAccess p_71874_1_, int p_71874_2_, int p_71874_3_, int p_71874_4_) {
      return this.field_72157_b.func_71874_e(p_71874_1_, p_71874_2_, p_71874_3_, p_71874_4_);
   }

   public float func_71870_f(IBlockAccess p_71870_1_, int p_71870_2_, int p_71870_3_, int p_71870_4_) {
      return this.field_72157_b.func_71870_f(p_71870_1_, p_71870_2_, p_71870_3_, p_71870_4_);
   }

   public float func_71904_a(Entity p_71904_1_) {
      return this.field_72157_b.func_71904_a(p_71904_1_);
   }

   public int func_71856_s_() {
      return this.field_72157_b.func_71856_s_();
   }

   public int func_71858_a(int p_71858_1_, int p_71858_2_) {
      return this.field_72157_b.func_71858_a(p_71858_1_, this.field_72158_c);
   }

   public int func_71851_a(int p_71851_1_) {
      return this.field_72157_b.func_71858_a(p_71851_1_, this.field_72158_c);
   }

   public int func_71859_p_() {
      return this.field_72157_b.func_71859_p_();
   }

   public AxisAlignedBB func_71911_a_(World p_71911_1_, int p_71911_2_, int p_71911_3_, int p_71911_4_) {
      return this.field_72157_b.func_71911_a_(p_71911_1_, p_71911_2_, p_71911_3_, p_71911_4_);
   }

   public void func_71901_a(World p_71901_1_, int p_71901_2_, int p_71901_3_, int p_71901_4_, Entity p_71901_5_, Vec3 p_71901_6_) {
      this.field_72157_b.func_71901_a(p_71901_1_, p_71901_2_, p_71901_3_, p_71901_4_, p_71901_5_, p_71901_6_);
   }

   public boolean func_71935_l() {
      return this.field_72157_b.func_71935_l();
   }

   public boolean func_71913_a(int p_71913_1_, boolean p_71913_2_) {
      return this.field_72157_b.func_71913_a(p_71913_1_, p_71913_2_);
   }

   public boolean func_71930_b(World p_71930_1_, int p_71930_2_, int p_71930_3_, int p_71930_4_) {
      return this.field_72157_b.func_71930_b(p_71930_1_, p_71930_2_, p_71930_3_, p_71930_4_);
   }

   public void func_71861_g(World p_71861_1_, int p_71861_2_, int p_71861_3_, int p_71861_4_) {
      this.func_71863_a(p_71861_1_, p_71861_2_, p_71861_3_, p_71861_4_, 0);
      this.field_72157_b.func_71861_g(p_71861_1_, p_71861_2_, p_71861_3_, p_71861_4_);
   }

   public void func_71852_a(World p_71852_1_, int p_71852_2_, int p_71852_3_, int p_71852_4_, int p_71852_5_, int p_71852_6_) {
      this.field_72157_b.func_71852_a(p_71852_1_, p_71852_2_, p_71852_3_, p_71852_4_, p_71852_5_, p_71852_6_);
   }

   public void func_71891_b(World p_71891_1_, int p_71891_2_, int p_71891_3_, int p_71891_4_, Entity p_71891_5_) {
      this.field_72157_b.func_71891_b(p_71891_1_, p_71891_2_, p_71891_3_, p_71891_4_, p_71891_5_);
   }

   public void func_71847_b(World p_71847_1_, int p_71847_2_, int p_71847_3_, int p_71847_4_, Random p_71847_5_) {
      this.field_72157_b.func_71847_b(p_71847_1_, p_71847_2_, p_71847_3_, p_71847_4_, p_71847_5_);
   }

   public boolean func_71903_a(World p_71903_1_, int p_71903_2_, int p_71903_3_, int p_71903_4_, EntityPlayer p_71903_5_, int p_71903_6_, float p_71903_7_, float p_71903_8_, float p_71903_9_) {
      return this.field_72157_b.func_71903_a(p_71903_1_, p_71903_2_, p_71903_3_, p_71903_4_, p_71903_5_, 0, 0.0F, 0.0F, 0.0F);
   }

   public void func_71867_k(World p_71867_1_, int p_71867_2_, int p_71867_3_, int p_71867_4_) {
      this.field_72157_b.func_71867_k(p_71867_1_, p_71867_2_, p_71867_3_, p_71867_4_);
   }

   public void func_71860_a(World p_71860_1_, int p_71860_2_, int p_71860_3_, int p_71860_4_, EntityLiving p_71860_5_) {
      int var6 = MathHelper.func_76128_c((double)(p_71860_5_.field_70177_z * 4.0F / 360.0F) + 0.5D) & 3;
      int var7 = p_71860_1_.func_72805_g(p_71860_2_, p_71860_3_, p_71860_4_) & 4;
      if(var6 == 0) {
         p_71860_1_.func_72921_c(p_71860_2_, p_71860_3_, p_71860_4_, 2 | var7);
      }

      if(var6 == 1) {
         p_71860_1_.func_72921_c(p_71860_2_, p_71860_3_, p_71860_4_, 1 | var7);
      }

      if(var6 == 2) {
         p_71860_1_.func_72921_c(p_71860_2_, p_71860_3_, p_71860_4_, 3 | var7);
      }

      if(var6 == 3) {
         p_71860_1_.func_72921_c(p_71860_2_, p_71860_3_, p_71860_4_, 0 | var7);
      }

   }

   public void func_71909_a(World p_71909_1_, int p_71909_2_, int p_71909_3_, int p_71909_4_, int p_71909_5_, float p_71909_6_, float p_71909_7_, float p_71909_8_) {
      if(p_71909_5_ == 0 || p_71909_5_ != 1 && (double)p_71909_7_ > 0.5D) {
         int var9 = p_71909_1_.func_72805_g(p_71909_2_, p_71909_3_, p_71909_4_);
         p_71909_1_.func_72921_c(p_71909_2_, p_71909_3_, p_71909_4_, var9 | 4);
      }

   }

   public MovingObjectPosition func_71878_a(World p_71878_1_, int p_71878_2_, int p_71878_3_, int p_71878_4_, Vec3 p_71878_5_, Vec3 p_71878_6_) {
      MovingObjectPosition[] var7 = new MovingObjectPosition[8];
      int var8 = p_71878_1_.func_72805_g(p_71878_2_, p_71878_3_, p_71878_4_);
      int var9 = var8 & 3;
      boolean var10 = (var8 & 4) == 4;
      int[] var11 = field_72159_a[var9 + (var10?4:0)];
      this.field_72156_cr = true;

      int var14;
      int var15;
      int var16;
      for(int var12 = 0; var12 < 8; ++var12) {
         this.field_72160_cs = var12;
         int[] var13 = var11;
         var14 = var11.length;

         for(var15 = 0; var15 < var14; ++var15) {
            var16 = var13[var15];
            if(var16 == var12) {
               ;
            }
         }

         var7[var12] = super.func_71878_a(p_71878_1_, p_71878_2_, p_71878_3_, p_71878_4_, p_71878_5_, p_71878_6_);
      }

      int[] var21 = var11;
      int var24 = var11.length;

      for(var14 = 0; var14 < var24; ++var14) {
         var15 = var21[var14];
         var7[var15] = null;
      }

      MovingObjectPosition var23 = null;
      double var22 = 0.0D;
      MovingObjectPosition[] var25 = var7;
      var16 = var7.length;

      for(int var17 = 0; var17 < var16; ++var17) {
         MovingObjectPosition var18 = var25[var17];
         if(var18 != null) {
            double var19 = var18.field_72307_f.func_72436_e(p_71878_6_);
            if(var19 > var22) {
               var23 = var18;
               var22 = var19;
            }
         }
      }

      return var23;
   }

}
