package net.minecraft.src;

import java.util.List;
import java.util.Random;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityItem;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EntityPlayerMP;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.World;

public class BlockCauldron extends Block {

   public BlockCauldron(int p_i3927_1_) {
      super(p_i3927_1_, Material.field_76243_f);
      this.field_72059_bZ = 154;
   }

   public int func_71858_a(int p_71858_1_, int p_71858_2_) {
      return p_71858_1_ == 1?138:(p_71858_1_ == 0?155:154);
   }

   public void func_71871_a(World p_71871_1_, int p_71871_2_, int p_71871_3_, int p_71871_4_, AxisAlignedBB p_71871_5_, List p_71871_6_, Entity p_71871_7_) {
      this.func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 0.3125F, 1.0F);
      super.func_71871_a(p_71871_1_, p_71871_2_, p_71871_3_, p_71871_4_, p_71871_5_, p_71871_6_, p_71871_7_);
      float var8 = 0.125F;
      this.func_71905_a(0.0F, 0.0F, 0.0F, var8, 1.0F, 1.0F);
      super.func_71871_a(p_71871_1_, p_71871_2_, p_71871_3_, p_71871_4_, p_71871_5_, p_71871_6_, p_71871_7_);
      this.func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, var8);
      super.func_71871_a(p_71871_1_, p_71871_2_, p_71871_3_, p_71871_4_, p_71871_5_, p_71871_6_, p_71871_7_);
      this.func_71905_a(1.0F - var8, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
      super.func_71871_a(p_71871_1_, p_71871_2_, p_71871_3_, p_71871_4_, p_71871_5_, p_71871_6_, p_71871_7_);
      this.func_71905_a(0.0F, 0.0F, 1.0F - var8, 1.0F, 1.0F, 1.0F);
      super.func_71871_a(p_71871_1_, p_71871_2_, p_71871_3_, p_71871_4_, p_71871_5_, p_71871_6_, p_71871_7_);
      this.func_71919_f();
   }

   public void func_71919_f() {
      this.func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
   }

   public boolean func_71926_d() {
      return false;
   }

   public int func_71857_b() {
      return 24;
   }

   public boolean func_71886_c() {
      return false;
   }

   public boolean func_71903_a(World p_71903_1_, int p_71903_2_, int p_71903_3_, int p_71903_4_, EntityPlayer p_71903_5_, int p_71903_6_, float p_71903_7_, float p_71903_8_, float p_71903_9_) {
      if(p_71903_1_.field_72995_K) {
         return true;
      } else {
         ItemStack var10 = p_71903_5_.field_71071_by.func_70448_g();
         if(var10 == null) {
            return true;
         } else {
            int var11 = p_71903_1_.func_72805_g(p_71903_2_, p_71903_3_, p_71903_4_);
            if(var10.field_77993_c == Item.field_77786_ax.field_77779_bT) {
               if(var11 < 3) {
                  if(!p_71903_5_.field_71075_bZ.field_75098_d) {
                     p_71903_5_.field_71071_by.func_70299_a(p_71903_5_.field_71071_by.field_70461_c, new ItemStack(Item.field_77788_aw));
                  }

                  p_71903_1_.func_72921_c(p_71903_2_, p_71903_3_, p_71903_4_, 3);
               }

               return true;
            } else {
               if(var10.field_77993_c == Item.field_77729_bt.field_77779_bT && var11 > 0) {
                  ItemStack var12 = new ItemStack(Item.field_77726_bs, 1, 0);
                  if(!p_71903_5_.field_71071_by.func_70441_a(var12)) {
                     p_71903_1_.func_72838_d(new EntityItem(p_71903_1_, (double)p_71903_2_ + 0.5D, (double)p_71903_3_ + 1.5D, (double)p_71903_4_ + 0.5D, var12));
                  } else if(p_71903_5_ instanceof EntityPlayerMP) {
                     ((EntityPlayerMP)p_71903_5_).func_71120_a(p_71903_5_.field_71069_bz);
                  }

                  --var10.field_77994_a;
                  if(var10.field_77994_a <= 0) {
                     p_71903_5_.field_71071_by.func_70299_a(p_71903_5_.field_71071_by.field_70461_c, (ItemStack)null);
                  }

                  p_71903_1_.func_72921_c(p_71903_2_, p_71903_3_, p_71903_4_, var11 - 1);
               }

               return true;
            }
         }
      }
   }

   public void func_71892_f(World p_71892_1_, int p_71892_2_, int p_71892_3_, int p_71892_4_) {
      if(p_71892_1_.field_73012_v.nextInt(20) == 1) {
         int var5 = p_71892_1_.func_72805_g(p_71892_2_, p_71892_3_, p_71892_4_);
         if(var5 < 3) {
            p_71892_1_.func_72921_c(p_71892_2_, p_71892_3_, p_71892_4_, var5 + 1);
         }

      }
   }

   public int func_71885_a(int p_71885_1_, Random p_71885_2_, int p_71885_3_) {
      return Item.field_77721_bz.field_77779_bT;
   }
}
