package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.BlockFlower;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.StatList;
import net.minecraft.src.World;

public class BlockTallGrass extends BlockFlower {

   protected BlockTallGrass(int p_i4002_1_, int p_i4002_2_) {
      super(p_i4002_1_, p_i4002_2_, Material.field_76255_k);
      float var3 = 0.4F;
      this.func_71905_a(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3, 0.8F, 0.5F + var3);
   }

   public int func_71858_a(int p_71858_1_, int p_71858_2_) {
      return p_71858_2_ == 1?this.field_72059_bZ:(p_71858_2_ == 2?this.field_72059_bZ + 16 + 1:(p_71858_2_ == 0?this.field_72059_bZ + 16:this.field_72059_bZ));
   }

   public int func_71885_a(int p_71885_1_, Random p_71885_2_, int p_71885_3_) {
      return p_71885_2_.nextInt(8) == 0?Item.field_77690_S.field_77779_bT:-1;
   }

   public int func_71910_a(int p_71910_1_, Random p_71910_2_) {
      return 1 + p_71910_2_.nextInt(p_71910_1_ * 2 + 1);
   }

   public void func_71893_a(World p_71893_1_, EntityPlayer p_71893_2_, int p_71893_3_, int p_71893_4_, int p_71893_5_, int p_71893_6_) {
      if(!p_71893_1_.field_72995_K && p_71893_2_.func_71045_bC() != null && p_71893_2_.func_71045_bC().field_77993_c == Item.field_77745_be.field_77779_bT) {
         p_71893_2_.func_71064_a(StatList.field_75934_C[this.field_71990_ca], 1);
         this.func_71929_a(p_71893_1_, p_71893_3_, p_71893_4_, p_71893_5_, new ItemStack(Block.field_71962_X, 1, p_71893_6_));
      } else {
         super.func_71893_a(p_71893_1_, p_71893_2_, p_71893_3_, p_71893_4_, p_71893_5_, p_71893_6_);
      }

   }
}
