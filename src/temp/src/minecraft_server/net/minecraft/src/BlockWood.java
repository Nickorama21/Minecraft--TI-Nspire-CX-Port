package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Material;

public class BlockWood extends Block {

   public static final String[] field_72152_a = new String[]{"oak", "spruce", "birch", "jungle"};


   public BlockWood(int p_i4023_1_) {
      super(p_i4023_1_, 4, Material.field_76245_d);
      this.func_71849_a(CreativeTabs.field_78030_b);
   }

   public int func_71858_a(int p_71858_1_, int p_71858_2_) {
      switch(p_71858_2_) {
      case 1:
         return 198;
      case 2:
         return 214;
      case 3:
         return 199;
      default:
         return 4;
      }
   }

   protected int func_71899_b(int p_71899_1_) {
      return p_71899_1_;
   }

}
