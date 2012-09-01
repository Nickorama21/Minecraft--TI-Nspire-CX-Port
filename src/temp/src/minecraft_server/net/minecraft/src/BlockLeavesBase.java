package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.Material;

public class BlockLeavesBase extends Block {

   protected boolean field_72131_c;


   protected BlockLeavesBase(int p_i4014_1_, int p_i4014_2_, Material p_i4014_3_, boolean p_i4014_4_) {
      super(p_i4014_1_, p_i4014_2_, p_i4014_3_);
      this.field_72131_c = p_i4014_4_;
   }

   public boolean func_71926_d() {
      return false;
   }
}
