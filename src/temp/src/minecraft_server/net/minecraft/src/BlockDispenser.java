package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.BlockContainer;
import net.minecraft.src.BlockRail;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EntityArrow;
import net.minecraft.src.EntityBoat;
import net.minecraft.src.EntityEgg;
import net.minecraft.src.EntityExpBottle;
import net.minecraft.src.EntityItem;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityMinecart;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EntityPotion;
import net.minecraft.src.EntitySmallFireball;
import net.minecraft.src.EntitySnowball;
import net.minecraft.src.Item;
import net.minecraft.src.ItemBucket;
import net.minecraft.src.ItemMinecart;
import net.minecraft.src.ItemMonsterPlacer;
import net.minecraft.src.ItemPotion;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.MathHelper;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.TileEntity;
import net.minecraft.src.TileEntityDispenser;
import net.minecraft.src.World;

public class BlockDispenser extends BlockContainer {

   private Random field_72284_a = new Random();


   protected BlockDispenser(int p_i3938_1_) {
      super(p_i3938_1_, Material.field_76246_e);
      this.field_72059_bZ = 45;
      this.func_71849_a(CreativeTabs.field_78028_d);
   }

   public int func_71859_p_() {
      return 4;
   }

   public int func_71885_a(int p_71885_1_, Random p_71885_2_, int p_71885_3_) {
      return Block.field_71958_P.field_71990_ca;
   }

   public void func_71861_g(World p_71861_1_, int p_71861_2_, int p_71861_3_, int p_71861_4_) {
      super.func_71861_g(p_71861_1_, p_71861_2_, p_71861_3_, p_71861_4_);
      this.func_72280_l(p_71861_1_, p_71861_2_, p_71861_3_, p_71861_4_);
   }

   private void func_72280_l(World p_72280_1_, int p_72280_2_, int p_72280_3_, int p_72280_4_) {
      if(!p_72280_1_.field_72995_K) {
         int var5 = p_72280_1_.func_72798_a(p_72280_2_, p_72280_3_, p_72280_4_ - 1);
         int var6 = p_72280_1_.func_72798_a(p_72280_2_, p_72280_3_, p_72280_4_ + 1);
         int var7 = p_72280_1_.func_72798_a(p_72280_2_ - 1, p_72280_3_, p_72280_4_);
         int var8 = p_72280_1_.func_72798_a(p_72280_2_ + 1, p_72280_3_, p_72280_4_);
         byte var9 = 3;
         if(Block.field_71970_n[var5] && !Block.field_71970_n[var6]) {
            var9 = 3;
         }

         if(Block.field_71970_n[var6] && !Block.field_71970_n[var5]) {
            var9 = 2;
         }

         if(Block.field_71970_n[var7] && !Block.field_71970_n[var8]) {
            var9 = 5;
         }

         if(Block.field_71970_n[var8] && !Block.field_71970_n[var7]) {
            var9 = 4;
         }

         p_72280_1_.func_72921_c(p_72280_2_, p_72280_3_, p_72280_4_, var9);
      }
   }

   public int func_71851_a(int p_71851_1_) {
      return p_71851_1_ == 1?this.field_72059_bZ + 17:(p_71851_1_ == 0?this.field_72059_bZ + 17:(p_71851_1_ == 3?this.field_72059_bZ + 1:this.field_72059_bZ));
   }

   public boolean func_71903_a(World p_71903_1_, int p_71903_2_, int p_71903_3_, int p_71903_4_, EntityPlayer p_71903_5_, int p_71903_6_, float p_71903_7_, float p_71903_8_, float p_71903_9_) {
      if(p_71903_1_.field_72995_K) {
         return true;
      } else {
         TileEntityDispenser var10 = (TileEntityDispenser)p_71903_1_.func_72796_p(p_71903_2_, p_71903_3_, p_71903_4_);
         if(var10 != null) {
            p_71903_5_.func_71006_a(var10);
         }

         return true;
      }
   }

   private void func_72281_c(World p_72281_1_, int p_72281_2_, int p_72281_3_, int p_72281_4_, Random p_72281_5_) {
      int var6 = p_72281_1_.func_72805_g(p_72281_2_, p_72281_3_, p_72281_4_);
      byte var9 = 0;
      byte var10 = 0;
      if(var6 == 3) {
         var10 = 1;
      } else if(var6 == 2) {
         var10 = -1;
      } else if(var6 == 5) {
         var9 = 1;
      } else {
         var9 = -1;
      }

      TileEntityDispenser var11 = (TileEntityDispenser)p_72281_1_.func_72796_p(p_72281_2_, p_72281_3_, p_72281_4_);
      if(var11 != null) {
         int var12 = var11.func_70361_i();
         if(var12 < 0) {
            p_72281_1_.func_72926_e(1001, p_72281_2_, p_72281_3_, p_72281_4_, 0);
         } else {
            double var13 = (double)p_72281_2_ + (double)var9 * 0.6D + 0.5D;
            double var15 = (double)p_72281_3_ + 0.5D;
            double var17 = (double)p_72281_4_ + (double)var10 * 0.6D + 0.5D;
            ItemStack var19 = var11.func_70301_a(var12);
            int var20 = func_72283_a(var11, p_72281_1_, var19, p_72281_5_, p_72281_2_, p_72281_3_, p_72281_4_, var9, var10, var13, var15, var17);
            if(var20 == 1) {
               var11.func_70298_a(var12, 1);
            } else if(var20 == 0) {
               var19 = var11.func_70298_a(var12, 1);
               func_72282_a(p_72281_1_, var19, p_72281_5_, 6, var9, var10, var13, var15, var17);
               p_72281_1_.func_72926_e(1000, p_72281_2_, p_72281_3_, p_72281_4_, 0);
            }

            p_72281_1_.func_72926_e(2000, p_72281_2_, p_72281_3_, p_72281_4_, var9 + 1 + (var10 + 1) * 3);
         }
      }

   }

   public void func_71863_a(World p_71863_1_, int p_71863_2_, int p_71863_3_, int p_71863_4_, int p_71863_5_) {
      if(p_71863_5_ > 0 && Block.field_71973_m[p_71863_5_].func_71853_i()) {
         boolean var6 = p_71863_1_.func_72864_z(p_71863_2_, p_71863_3_, p_71863_4_) || p_71863_1_.func_72864_z(p_71863_2_, p_71863_3_ + 1, p_71863_4_);
         if(var6) {
            p_71863_1_.func_72836_a(p_71863_2_, p_71863_3_, p_71863_4_, this.field_71990_ca, this.func_71859_p_());
         }
      }

   }

   public void func_71847_b(World p_71847_1_, int p_71847_2_, int p_71847_3_, int p_71847_4_, Random p_71847_5_) {
      if(!p_71847_1_.field_72995_K && (p_71847_1_.func_72864_z(p_71847_2_, p_71847_3_, p_71847_4_) || p_71847_1_.func_72864_z(p_71847_2_, p_71847_3_ + 1, p_71847_4_))) {
         this.func_72281_c(p_71847_1_, p_71847_2_, p_71847_3_, p_71847_4_, p_71847_5_);
      }

   }

   public TileEntity func_72274_a(World p_72274_1_) {
      return new TileEntityDispenser();
   }

   public void func_71860_a(World p_71860_1_, int p_71860_2_, int p_71860_3_, int p_71860_4_, EntityLiving p_71860_5_) {
      int var6 = MathHelper.func_76128_c((double)(p_71860_5_.field_70177_z * 4.0F / 360.0F) + 0.5D) & 3;
      if(var6 == 0) {
         p_71860_1_.func_72921_c(p_71860_2_, p_71860_3_, p_71860_4_, 2);
      }

      if(var6 == 1) {
         p_71860_1_.func_72921_c(p_71860_2_, p_71860_3_, p_71860_4_, 5);
      }

      if(var6 == 2) {
         p_71860_1_.func_72921_c(p_71860_2_, p_71860_3_, p_71860_4_, 3);
      }

      if(var6 == 3) {
         p_71860_1_.func_72921_c(p_71860_2_, p_71860_3_, p_71860_4_, 4);
      }

   }

   public void func_71852_a(World p_71852_1_, int p_71852_2_, int p_71852_3_, int p_71852_4_, int p_71852_5_, int p_71852_6_) {
      TileEntityDispenser var7 = (TileEntityDispenser)p_71852_1_.func_72796_p(p_71852_2_, p_71852_3_, p_71852_4_);
      if(var7 != null) {
         for(int var8 = 0; var8 < var7.func_70302_i_(); ++var8) {
            ItemStack var9 = var7.func_70301_a(var8);
            if(var9 != null) {
               float var10 = this.field_72284_a.nextFloat() * 0.8F + 0.1F;
               float var11 = this.field_72284_a.nextFloat() * 0.8F + 0.1F;
               float var12 = this.field_72284_a.nextFloat() * 0.8F + 0.1F;

               while(var9.field_77994_a > 0) {
                  int var13 = this.field_72284_a.nextInt(21) + 10;
                  if(var13 > var9.field_77994_a) {
                     var13 = var9.field_77994_a;
                  }

                  var9.field_77994_a -= var13;
                  EntityItem var14 = new EntityItem(p_71852_1_, (double)((float)p_71852_2_ + var10), (double)((float)p_71852_3_ + var11), (double)((float)p_71852_4_ + var12), new ItemStack(var9.field_77993_c, var13, var9.func_77960_j()));
                  if(var9.func_77942_o()) {
                     var14.field_70294_a.func_77982_d((NBTTagCompound)var9.func_77978_p().func_74737_b());
                  }

                  float var15 = 0.05F;
                  var14.field_70159_w = (double)((float)this.field_72284_a.nextGaussian() * var15);
                  var14.field_70181_x = (double)((float)this.field_72284_a.nextGaussian() * var15 + 0.2F);
                  var14.field_70179_y = (double)((float)this.field_72284_a.nextGaussian() * var15);
                  p_71852_1_.func_72838_d(var14);
               }
            }
         }
      }

      super.func_71852_a(p_71852_1_, p_71852_2_, p_71852_3_, p_71852_4_, p_71852_5_, p_71852_6_);
   }

   private static void func_72282_a(World p_72282_0_, ItemStack p_72282_1_, Random p_72282_2_, int p_72282_3_, int p_72282_4_, int p_72282_5_, double p_72282_6_, double p_72282_8_, double p_72282_10_) {
      EntityItem var12 = new EntityItem(p_72282_0_, p_72282_6_, p_72282_8_ - 0.3D, p_72282_10_, p_72282_1_);
      double var13 = p_72282_2_.nextDouble() * 0.1D + 0.2D;
      var12.field_70159_w = (double)p_72282_4_ * var13;
      var12.field_70181_x = 0.20000000298023224D;
      var12.field_70179_y = (double)p_72282_5_ * var13;
      var12.field_70159_w += p_72282_2_.nextGaussian() * 0.007499999832361937D * (double)p_72282_3_;
      var12.field_70181_x += p_72282_2_.nextGaussian() * 0.007499999832361937D * (double)p_72282_3_;
      var12.field_70179_y += p_72282_2_.nextGaussian() * 0.007499999832361937D * (double)p_72282_3_;
      p_72282_0_.func_72838_d(var12);
   }

   private static int func_72283_a(TileEntityDispenser p_72283_0_, World p_72283_1_, ItemStack p_72283_2_, Random p_72283_3_, int p_72283_4_, int p_72283_5_, int p_72283_6_, int p_72283_7_, int p_72283_8_, double p_72283_9_, double p_72283_11_, double p_72283_13_) {
      float var15 = 1.1F;
      byte var16 = 6;
      if(p_72283_2_.field_77993_c == Item.field_77704_l.field_77779_bT) {
         EntityArrow var28 = new EntityArrow(p_72283_1_, p_72283_9_, p_72283_11_, p_72283_13_);
         var28.func_70244_c((double)p_72283_7_, 0.10000000149011612D, (double)p_72283_8_, var15, (float)var16);
         var28.field_70251_a = 1;
         p_72283_1_.func_72838_d(var28);
         p_72283_1_.func_72926_e(1002, p_72283_4_, p_72283_5_, p_72283_6_, 0);
         return 1;
      } else if(p_72283_2_.field_77993_c == Item.field_77764_aP.field_77779_bT) {
         EntityEgg var29 = new EntityEgg(p_72283_1_, p_72283_9_, p_72283_11_, p_72283_13_);
         var29.func_70186_c((double)p_72283_7_, 0.10000000149011612D, (double)p_72283_8_, var15, (float)var16);
         p_72283_1_.func_72838_d(var29);
         p_72283_1_.func_72926_e(1002, p_72283_4_, p_72283_5_, p_72283_6_, 0);
         return 1;
      } else if(p_72283_2_.field_77993_c == Item.field_77768_aD.field_77779_bT) {
         EntitySnowball var24 = new EntitySnowball(p_72283_1_, p_72283_9_, p_72283_11_, p_72283_13_);
         var24.func_70186_c((double)p_72283_7_, 0.10000000149011612D, (double)p_72283_8_, var15, (float)var16);
         p_72283_1_.func_72838_d(var24);
         p_72283_1_.func_72926_e(1002, p_72283_4_, p_72283_5_, p_72283_6_, 0);
         return 1;
      } else if(p_72283_2_.field_77993_c == Item.field_77726_bs.field_77779_bT && ItemPotion.func_77831_g(p_72283_2_.func_77960_j())) {
         EntityPotion var25 = new EntityPotion(p_72283_1_, p_72283_9_, p_72283_11_, p_72283_13_, p_72283_2_.func_77960_j());
         var25.func_70186_c((double)p_72283_7_, 0.10000000149011612D, (double)p_72283_8_, var15 * 1.25F, (float)var16 * 0.5F);
         p_72283_1_.func_72838_d(var25);
         p_72283_1_.func_72926_e(1002, p_72283_4_, p_72283_5_, p_72283_6_, 0);
         return 1;
      } else if(p_72283_2_.field_77993_c == Item.field_77809_bD.field_77779_bT) {
         EntityExpBottle var26 = new EntityExpBottle(p_72283_1_, p_72283_9_, p_72283_11_, p_72283_13_);
         var26.func_70186_c((double)p_72283_7_, 0.10000000149011612D, (double)p_72283_8_, var15 * 1.25F, (float)var16 * 0.5F);
         p_72283_1_.func_72838_d(var26);
         p_72283_1_.func_72926_e(1002, p_72283_4_, p_72283_5_, p_72283_6_, 0);
         return 1;
      } else if(p_72283_2_.field_77993_c == Item.field_77815_bC.field_77779_bT) {
         ItemMonsterPlacer.func_77840_a(p_72283_1_, p_72283_2_.func_77960_j(), p_72283_9_ + (double)p_72283_7_ * 0.3D, p_72283_11_ - 0.3D, p_72283_13_ + (double)p_72283_8_ * 0.3D);
         p_72283_1_.func_72926_e(1002, p_72283_4_, p_72283_5_, p_72283_6_, 0);
         return 1;
      } else if(p_72283_2_.field_77993_c == Item.field_77811_bE.field_77779_bT) {
         EntitySmallFireball var27 = new EntitySmallFireball(p_72283_1_, p_72283_9_ + (double)p_72283_7_ * 0.3D, p_72283_11_, p_72283_13_ + (double)p_72283_8_ * 0.3D, (double)p_72283_7_ + p_72283_3_.nextGaussian() * 0.05D, p_72283_3_.nextGaussian() * 0.05D, (double)p_72283_8_ + p_72283_3_.nextGaussian() * 0.05D);
         p_72283_1_.func_72838_d(var27);
         p_72283_1_.func_72926_e(1009, p_72283_4_, p_72283_5_, p_72283_6_, 0);
         return 1;
      } else if(p_72283_2_.field_77993_c != Item.field_77775_ay.field_77779_bT && p_72283_2_.field_77993_c != Item.field_77786_ax.field_77779_bT) {
         if(p_72283_2_.field_77993_c == Item.field_77788_aw.field_77779_bT) {
            int var21 = p_72283_4_ + p_72283_7_;
            int var18 = p_72283_6_ + p_72283_8_;
            Material var19 = p_72283_1_.func_72803_f(var21, p_72283_5_, var18);
            int var20 = p_72283_1_.func_72805_g(var21, p_72283_5_, var18);
            if(var19 == Material.field_76244_g && var20 == 0) {
               p_72283_1_.func_72859_e(var21, p_72283_5_, var18, 0);
               if(--p_72283_2_.field_77994_a == 0) {
                  p_72283_2_.field_77993_c = Item.field_77786_ax.field_77779_bT;
                  p_72283_2_.field_77994_a = 1;
               } else if(p_72283_0_.func_70360_a(new ItemStack(Item.field_77786_ax)) < 0) {
                  func_72282_a(p_72283_1_, new ItemStack(Item.field_77786_ax), p_72283_3_, 6, p_72283_7_, p_72283_8_, p_72283_9_, p_72283_11_, p_72283_13_);
               }

               return 2;
            } else if(var19 == Material.field_76256_h && var20 == 0) {
               p_72283_1_.func_72859_e(var21, p_72283_5_, var18, 0);
               if(--p_72283_2_.field_77994_a == 0) {
                  p_72283_2_.field_77993_c = Item.field_77775_ay.field_77779_bT;
                  p_72283_2_.field_77994_a = 1;
               } else if(p_72283_0_.func_70360_a(new ItemStack(Item.field_77775_ay)) < 0) {
                  func_72282_a(p_72283_1_, new ItemStack(Item.field_77775_ay), p_72283_3_, 6, p_72283_7_, p_72283_8_, p_72283_9_, p_72283_11_, p_72283_13_);
               }

               return 2;
            } else {
               return 0;
            }
         } else if(p_72283_2_.func_77973_b() instanceof ItemMinecart) {
            p_72283_9_ = (double)p_72283_4_ + (p_72283_7_ < 0?(double)p_72283_7_ * 0.8D:(double)((float)p_72283_7_ * 1.8F)) + (double)((float)Math.abs(p_72283_8_) * 0.5F);
            p_72283_13_ = (double)p_72283_6_ + (p_72283_8_ < 0?(double)p_72283_8_ * 0.8D:(double)((float)p_72283_8_ * 1.8F)) + (double)((float)Math.abs(p_72283_7_) * 0.5F);
            if(BlockRail.func_72180_d_(p_72283_1_, p_72283_4_ + p_72283_7_, p_72283_5_, p_72283_6_ + p_72283_8_)) {
               p_72283_11_ = (double)((float)p_72283_5_ + 0.5F);
            } else {
               if(!p_72283_1_.func_72799_c(p_72283_4_ + p_72283_7_, p_72283_5_, p_72283_6_ + p_72283_8_) || !BlockRail.func_72180_d_(p_72283_1_, p_72283_4_ + p_72283_7_, p_72283_5_ - 1, p_72283_6_ + p_72283_8_)) {
                  return 0;
               }

               p_72283_11_ = (double)((float)p_72283_5_ - 0.5F);
            }

            EntityMinecart var22 = new EntityMinecart(p_72283_1_, p_72283_9_, p_72283_11_, p_72283_13_, ((ItemMinecart)p_72283_2_.func_77973_b()).field_77841_a);
            p_72283_1_.func_72838_d(var22);
            p_72283_1_.func_72926_e(1000, p_72283_4_, p_72283_5_, p_72283_6_, 0);
            return 1;
         } else if(p_72283_2_.field_77993_c == Item.field_77769_aE.field_77779_bT) {
            p_72283_9_ = (double)p_72283_4_ + (p_72283_7_ < 0?(double)p_72283_7_ * 0.8D:(double)((float)p_72283_7_ * 1.8F)) + (double)((float)Math.abs(p_72283_8_) * 0.5F);
            p_72283_13_ = (double)p_72283_6_ + (p_72283_8_ < 0?(double)p_72283_8_ * 0.8D:(double)((float)p_72283_8_ * 1.8F)) + (double)((float)Math.abs(p_72283_7_) * 0.5F);
            if(p_72283_1_.func_72803_f(p_72283_4_ + p_72283_7_, p_72283_5_, p_72283_6_ + p_72283_8_) == Material.field_76244_g) {
               p_72283_11_ = (double)((float)p_72283_5_ + 1.0F);
            } else {
               if(!p_72283_1_.func_72799_c(p_72283_4_ + p_72283_7_, p_72283_5_, p_72283_6_ + p_72283_8_) || p_72283_1_.func_72803_f(p_72283_4_ + p_72283_7_, p_72283_5_ - 1, p_72283_6_ + p_72283_8_) != Material.field_76244_g) {
                  return 0;
               }

               p_72283_11_ = (double)p_72283_5_;
            }

            EntityBoat var23 = new EntityBoat(p_72283_1_, p_72283_9_, p_72283_11_, p_72283_13_);
            p_72283_1_.func_72838_d(var23);
            p_72283_1_.func_72926_e(1000, p_72283_4_, p_72283_5_, p_72283_6_, 0);
            return 1;
         } else {
            return 0;
         }
      } else {
         ItemBucket var17 = (ItemBucket)p_72283_2_.func_77973_b();
         if(var17.func_77875_a(p_72283_1_, (double)p_72283_4_, (double)p_72283_5_, (double)p_72283_6_, p_72283_4_ + p_72283_7_, p_72283_5_, p_72283_6_ + p_72283_8_)) {
            p_72283_2_.field_77993_c = Item.field_77788_aw.field_77779_bT;
            p_72283_2_.field_77994_a = 1;
            return 2;
         } else {
            return 0;
         }
      }
   }
}
