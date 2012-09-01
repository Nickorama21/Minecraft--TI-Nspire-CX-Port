package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Material;

public class BlockSandStone extends Block {

   public static final String[] field_72189_a = new String[]{"default", "chiseled", "smooth"};


   public BlockSandStone(int p_i3990_1_) {
      super(p_i3990_1_, 192, Material.field_76246_e);
      this.func_71849_a(CreativeTabs.field_78030_b);
   }

   public int func_71858_a(int p_71858_1_, int p_71858_2_) {
      return p_71858_1_ != 1 && (p_71858_1_ != 0 || p_71858_2_ != 1 && p_71858_2_ != 2)?(p_71858_1_ == 0?208:(p_71858_2_ == 1?229:(p_71858_2_ == 2?230:192))):176;
   }

   public int func_71851_a(int p_71851_1_) {
      return p_71851_1_ == 1?this.field_72059_bZ - 16:(p_71851_1_ == 0?this.field_72059_bZ + 16:this.field_72059_bZ);
   }

   protected int func_71899_b(int p_71899_1_) {
      return p_71899_1_;
   }

}
