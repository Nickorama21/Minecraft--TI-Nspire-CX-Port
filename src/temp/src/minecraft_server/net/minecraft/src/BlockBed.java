package net.minecraft.src;

import java.util.Iterator;
import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.BlockDirectional;
import net.minecraft.src.ChunkCoordinates;
import net.minecraft.src.Direction;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EnumStatus;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.Item;
import net.minecraft.src.Material;
import net.minecraft.src.World;

public class BlockBed extends BlockDirectional {

   public static final int[][] field_72230_a = new int[][]{{0, 1}, {-1, 0}, {0, -1}, {1, 0}};


   public BlockBed(int p_i3919_1_) {
      super(p_i3919_1_, 134, Material.field_76253_m);
      this.func_72227_n();
   }

   public boolean func_71903_a(World p_71903_1_, int p_71903_2_, int p_71903_3_, int p_71903_4_, EntityPlayer p_71903_5_, int p_71903_6_, float p_71903_7_, float p_71903_8_, float p_71903_9_) {
      if(p_71903_1_.field_72995_K) {
         return true;
      } else {
         int var10 = p_71903_1_.func_72805_g(p_71903_2_, p_71903_3_, p_71903_4_);
         if(!func_72229_a_(var10)) {
            int var11 = func_72217_d(var10);
            p_71903_2_ += field_72230_a[var11][0];
            p_71903_4_ += field_72230_a[var11][1];
            if(p_71903_1_.func_72798_a(p_71903_2_, p_71903_3_, p_71903_4_) != this.field_71990_ca) {
               return true;
            }

            var10 = p_71903_1_.func_72805_g(p_71903_2_, p_71903_3_, p_71903_4_);
         }

         if(!p_71903_1_.field_73011_w.func_76567_e()) {
            double var19 = (double)p_71903_2_ + 0.5D;
            double var21 = (double)p_71903_3_ + 0.5D;
            double var15 = (double)p_71903_4_ + 0.5D;
            p_71903_1_.func_72859_e(p_71903_2_, p_71903_3_, p_71903_4_, 0);
            int var17 = func_72217_d(var10);
            p_71903_2_ += field_72230_a[var17][0];
            p_71903_4_ += field_72230_a[var17][1];
            if(p_71903_1_.func_72798_a(p_71903_2_, p_71903_3_, p_71903_4_) == this.field_71990_ca) {
               p_71903_1_.func_72859_e(p_71903_2_, p_71903_3_, p_71903_4_, 0);
               var19 = (var19 + (double)p_71903_2_ + 0.5D) / 2.0D;
               var21 = (var21 + (double)p_71903_3_ + 0.5D) / 2.0D;
               var15 = (var15 + (double)p_71903_4_ + 0.5D) / 2.0D;
            }

            p_71903_1_.func_72885_a((Entity)null, (double)((float)p_71903_2_ + 0.5F), (double)((float)p_71903_3_ + 0.5F), (double)((float)p_71903_4_ + 0.5F), 5.0F, true);
            return true;
         } else {
            if(func_72225_b_(var10)) {
               EntityPlayer var18 = null;
               Iterator var12 = p_71903_1_.field_73010_i.iterator();

               while(var12.hasNext()) {
                  EntityPlayer var13 = (EntityPlayer)var12.next();
                  if(var13.func_70608_bn()) {
                     ChunkCoordinates var14 = var13.field_71081_bT;
                     if(var14.field_71574_a == p_71903_2_ && var14.field_71572_b == p_71903_3_ && var14.field_71573_c == p_71903_4_) {
                        var18 = var13;
                     }
                  }
               }

               if(var18 != null) {
                  p_71903_5_.func_71035_c("tile.bed.occupied");
                  return true;
               }

               func_72228_a(p_71903_1_, p_71903_2_, p_71903_3_, p_71903_4_, false);
            }

            EnumStatus var20 = p_71903_5_.func_71018_a(p_71903_2_, p_71903_3_, p_71903_4_);
            if(var20 == EnumStatus.OK) {
               func_72228_a(p_71903_1_, p_71903_2_, p_71903_3_, p_71903_4_, true);
               return true;
            } else {
               if(var20 == EnumStatus.NOT_POSSIBLE_NOW) {
                  p_71903_5_.func_71035_c("tile.bed.noSleep");
               } else if(var20 == EnumStatus.NOT_SAFE) {
                  p_71903_5_.func_71035_c("tile.bed.notSafe");
               }

               return true;
            }
         }
      }
   }

   public int func_71858_a(int p_71858_1_, int p_71858_2_) {
      if(p_71858_1_ == 0) {
         return Block.field_71988_x.field_72059_bZ;
      } else {
         int var3 = func_72217_d(p_71858_2_);
         int var4 = Direction.field_71584_h[var3][p_71858_1_];
         return func_72229_a_(p_71858_2_)?(var4 == 2?this.field_72059_bZ + 2 + 16:(var4 != 5 && var4 != 4?this.field_72059_bZ + 1:this.field_72059_bZ + 1 + 16)):(var4 == 3?this.field_72059_bZ - 1 + 16:(var4 != 5 && var4 != 4?this.field_72059_bZ:this.field_72059_bZ + 16));
      }
   }

   public int func_71857_b() {
      return 14;
   }

   public boolean func_71886_c() {
      return false;
   }

   public boolean func_71926_d() {
      return false;
   }

   public void func_71902_a(IBlockAccess p_71902_1_, int p_71902_2_, int p_71902_3_, int p_71902_4_) {
      this.func_72227_n();
   }

   public void func_71863_a(World p_71863_1_, int p_71863_2_, int p_71863_3_, int p_71863_4_, int p_71863_5_) {
      int var6 = p_71863_1_.func_72805_g(p_71863_2_, p_71863_3_, p_71863_4_);
      int var7 = func_72217_d(var6);
      if(func_72229_a_(var6)) {
         if(p_71863_1_.func_72798_a(p_71863_2_ - field_72230_a[var7][0], p_71863_3_, p_71863_4_ - field_72230_a[var7][1]) != this.field_71990_ca) {
            p_71863_1_.func_72859_e(p_71863_2_, p_71863_3_, p_71863_4_, 0);
         }
      } else if(p_71863_1_.func_72798_a(p_71863_2_ + field_72230_a[var7][0], p_71863_3_, p_71863_4_ + field_72230_a[var7][1]) != this.field_71990_ca) {
         p_71863_1_.func_72859_e(p_71863_2_, p_71863_3_, p_71863_4_, 0);
         if(!p_71863_1_.field_72995_K) {
            this.func_71897_c(p_71863_1_, p_71863_2_, p_71863_3_, p_71863_4_, var6, 0);
         }
      }

   }

   public int func_71885_a(int p_71885_1_, Random p_71885_2_, int p_71885_3_) {
      return func_72229_a_(p_71885_1_)?0:Item.field_77776_ba.field_77779_bT;
   }

   private void func_72227_n() {
      this.func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 0.5625F, 1.0F);
   }

   public static boolean func_72229_a_(int p_72229_0_) {
      return (p_72229_0_ & 8) != 0;
   }

   public static boolean func_72225_b_(int p_72225_0_) {
      return (p_72225_0_ & 4) != 0;
   }

   public static void func_72228_a(World p_72228_0_, int p_72228_1_, int p_72228_2_, int p_72228_3_, boolean p_72228_4_) {
      int var5 = p_72228_0_.func_72805_g(p_72228_1_, p_72228_2_, p_72228_3_);
      if(p_72228_4_) {
         var5 |= 4;
      } else {
         var5 &= -5;
      }

      p_72228_0_.func_72921_c(p_72228_1_, p_72228_2_, p_72228_3_, var5);
   }

   public static ChunkCoordinates func_72226_b(World p_72226_0_, int p_72226_1_, int p_72226_2_, int p_72226_3_, int p_72226_4_) {
      int var5 = p_72226_0_.func_72805_g(p_72226_1_, p_72226_2_, p_72226_3_);
      int var6 = BlockDirectional.func_72217_d(var5);

      for(int var7 = 0; var7 <= 1; ++var7) {
         int var8 = p_72226_1_ - field_72230_a[var6][0] * var7 - 1;
         int var9 = p_72226_3_ - field_72230_a[var6][1] * var7 - 1;
         int var10 = var8 + 2;
         int var11 = var9 + 2;

         for(int var12 = var8; var12 <= var10; ++var12) {
            for(int var13 = var9; var13 <= var11; ++var13) {
               if(p_72226_0_.func_72797_t(var12, p_72226_2_ - 1, var13) && p_72226_0_.func_72799_c(var12, p_72226_2_, var13) && p_72226_0_.func_72799_c(var12, p_72226_2_ + 1, var13)) {
                  if(p_72226_4_ <= 0) {
                     return new ChunkCoordinates(var12, p_72226_2_, var13);
                  }

                  --p_72226_4_;
               }
            }
         }
      }

      return null;
   }

   public void func_71914_a(World p_71914_1_, int p_71914_2_, int p_71914_3_, int p_71914_4_, int p_71914_5_, float p_71914_6_, int p_71914_7_) {
      if(!func_72229_a_(p_71914_5_)) {
         super.func_71914_a(p_71914_1_, p_71914_2_, p_71914_3_, p_71914_4_, p_71914_5_, p_71914_6_, 0);
      }

   }

   public int func_71915_e() {
      return 1;
   }

}
