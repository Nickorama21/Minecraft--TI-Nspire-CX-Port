package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.BlockContainer;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Facing;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.Material;
import net.minecraft.src.TileEntity;
import net.minecraft.src.TileEntityPiston;
import net.minecraft.src.World;

public class BlockPistonMoving extends BlockContainer {

   public BlockPistonMoving(int p_i4027_1_) {
      super(p_i4027_1_, Material.field_76233_E);
      this.func_71848_c(-1.0F);
   }

   public TileEntity func_72274_a(World p_72274_1_) {
      return null;
   }

   public void func_71861_g(World p_71861_1_, int p_71861_2_, int p_71861_3_, int p_71861_4_) {}

   public void func_71852_a(World p_71852_1_, int p_71852_2_, int p_71852_3_, int p_71852_4_, int p_71852_5_, int p_71852_6_) {
      TileEntity var7 = p_71852_1_.func_72796_p(p_71852_2_, p_71852_3_, p_71852_4_);
      if(var7 instanceof TileEntityPiston) {
         ((TileEntityPiston)var7).func_70339_i();
      } else {
         super.func_71852_a(p_71852_1_, p_71852_2_, p_71852_3_, p_71852_4_, p_71852_5_, p_71852_6_);
      }

   }

   public boolean func_71930_b(World p_71930_1_, int p_71930_2_, int p_71930_3_, int p_71930_4_) {
      return false;
   }

   public boolean func_71850_a_(World p_71850_1_, int p_71850_2_, int p_71850_3_, int p_71850_4_, int p_71850_5_) {
      return false;
   }

   public int func_71857_b() {
      return -1;
   }

   public boolean func_71926_d() {
      return false;
   }

   public boolean func_71886_c() {
      return false;
   }

   public boolean func_71903_a(World p_71903_1_, int p_71903_2_, int p_71903_3_, int p_71903_4_, EntityPlayer p_71903_5_, int p_71903_6_, float p_71903_7_, float p_71903_8_, float p_71903_9_) {
      if(!p_71903_1_.field_72995_K && p_71903_1_.func_72796_p(p_71903_2_, p_71903_3_, p_71903_4_) == null) {
         p_71903_1_.func_72859_e(p_71903_2_, p_71903_3_, p_71903_4_, 0);
         return true;
      } else {
         return false;
      }
   }

   public int func_71885_a(int p_71885_1_, Random p_71885_2_, int p_71885_3_) {
      return 0;
   }

   public void func_71914_a(World p_71914_1_, int p_71914_2_, int p_71914_3_, int p_71914_4_, int p_71914_5_, float p_71914_6_, int p_71914_7_) {
      if(!p_71914_1_.field_72995_K) {
         TileEntityPiston var8 = this.func_72295_d(p_71914_1_, p_71914_2_, p_71914_3_, p_71914_4_);
         if(var8 != null) {
            Block.field_71973_m[var8.func_70340_a()].func_71897_c(p_71914_1_, p_71914_2_, p_71914_3_, p_71914_4_, var8.func_70322_n(), 0);
         }
      }
   }

   public void func_71863_a(World p_71863_1_, int p_71863_2_, int p_71863_3_, int p_71863_4_, int p_71863_5_) {
      if(!p_71863_1_.field_72995_K && p_71863_1_.func_72796_p(p_71863_2_, p_71863_3_, p_71863_4_) == null) {
         ;
      }

   }

   public static TileEntity func_72297_a(int p_72297_0_, int p_72297_1_, int p_72297_2_, boolean p_72297_3_, boolean p_72297_4_) {
      return new TileEntityPiston(p_72297_0_, p_72297_1_, p_72297_2_, p_72297_3_, p_72297_4_);
   }

   public AxisAlignedBB func_71872_e(World p_71872_1_, int p_71872_2_, int p_71872_3_, int p_71872_4_) {
      TileEntityPiston var5 = this.func_72295_d(p_71872_1_, p_71872_2_, p_71872_3_, p_71872_4_);
      if(var5 == null) {
         return null;
      } else {
         float var6 = var5.func_70333_a(0.0F);
         if(var5.func_70341_b()) {
            var6 = 1.0F - var6;
         }

         return this.func_72296_b(p_71872_1_, p_71872_2_, p_71872_3_, p_71872_4_, var5.func_70340_a(), var6, var5.func_70336_c());
      }
   }

   public void func_71902_a(IBlockAccess p_71902_1_, int p_71902_2_, int p_71902_3_, int p_71902_4_) {
      TileEntityPiston var5 = this.func_72295_d(p_71902_1_, p_71902_2_, p_71902_3_, p_71902_4_);
      if(var5 != null) {
         Block var6 = Block.field_71973_m[var5.func_70340_a()];
         if(var6 == null || var6 == this) {
            return;
         }

         var6.func_71902_a(p_71902_1_, p_71902_2_, p_71902_3_, p_71902_4_);
         float var7 = var5.func_70333_a(0.0F);
         if(var5.func_70341_b()) {
            var7 = 1.0F - var7;
         }

         int var8 = var5.func_70336_c();
         this.field_72026_ch = var6.field_72026_ch - (double)((float)Facing.field_71586_b[var8] * var7);
         this.field_72023_ci = var6.field_72023_ci - (double)((float)Facing.field_71587_c[var8] * var7);
         this.field_72024_cj = var6.field_72024_cj - (double)((float)Facing.field_71585_d[var8] * var7);
         this.field_72021_ck = var6.field_72021_ck - (double)((float)Facing.field_71586_b[var8] * var7);
         this.field_72022_cl = var6.field_72022_cl - (double)((float)Facing.field_71587_c[var8] * var7);
         this.field_72019_cm = var6.field_72019_cm - (double)((float)Facing.field_71585_d[var8] * var7);
      }

   }

   public AxisAlignedBB func_72296_b(World p_72296_1_, int p_72296_2_, int p_72296_3_, int p_72296_4_, int p_72296_5_, float p_72296_6_, int p_72296_7_) {
      if(p_72296_5_ != 0 && p_72296_5_ != this.field_71990_ca) {
         AxisAlignedBB var8 = Block.field_71973_m[p_72296_5_].func_71872_e(p_72296_1_, p_72296_2_, p_72296_3_, p_72296_4_);
         if(var8 == null) {
            return null;
         } else {
            if(Facing.field_71586_b[p_72296_7_] < 0) {
               var8.field_72340_a -= (double)((float)Facing.field_71586_b[p_72296_7_] * p_72296_6_);
            } else {
               var8.field_72336_d -= (double)((float)Facing.field_71586_b[p_72296_7_] * p_72296_6_);
            }

            if(Facing.field_71587_c[p_72296_7_] < 0) {
               var8.field_72338_b -= (double)((float)Facing.field_71587_c[p_72296_7_] * p_72296_6_);
            } else {
               var8.field_72337_e -= (double)((float)Facing.field_71587_c[p_72296_7_] * p_72296_6_);
            }

            if(Facing.field_71585_d[p_72296_7_] < 0) {
               var8.field_72339_c -= (double)((float)Facing.field_71585_d[p_72296_7_] * p_72296_6_);
            } else {
               var8.field_72334_f -= (double)((float)Facing.field_71585_d[p_72296_7_] * p_72296_6_);
            }

            return var8;
         }
      } else {
         return null;
      }
   }

   private TileEntityPiston func_72295_d(IBlockAccess p_72295_1_, int p_72295_2_, int p_72295_3_, int p_72295_4_) {
      TileEntity var5 = p_72295_1_.func_72796_p(p_72295_2_, p_72295_3_, p_72295_4_);
      return var5 instanceof TileEntityPiston?(TileEntityPiston)var5:null;
   }
}
