package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.Material;

public class BlockBreakable extends Block {

   private boolean field_72245_a;


   protected BlockBreakable(int p_i3955_1_, int p_i3955_2_, Material p_i3955_3_, boolean p_i3955_4_) {
      super(p_i3955_1_, p_i3955_2_, p_i3955_3_);
      this.field_72245_a = p_i3955_4_;
   }

   public boolean func_71926_d() {
      return false;
   }
}
