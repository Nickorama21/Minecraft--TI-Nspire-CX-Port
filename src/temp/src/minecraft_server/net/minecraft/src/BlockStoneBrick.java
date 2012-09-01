package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Material;

public class BlockStoneBrick extends Block {

   public static final String[] field_72188_a = new String[]{"default", "mossy", "cracked", "chiseled"};


   public BlockStoneBrick(int p_i3994_1_) {
      super(p_i3994_1_, 54, Material.field_76246_e);
      this.func_71849_a(CreativeTabs.field_78030_b);
   }

   public int func_71858_a(int p_71858_1_, int p_71858_2_) {
      switch(p_71858_2_) {
      case 1:
         return 100;
      case 2:
         return 101;
      case 3:
         return 213;
      default:
         return 54;
      }
   }

   protected int func_71899_b(int p_71899_1_) {
      return p_71899_1_;
   }

}
