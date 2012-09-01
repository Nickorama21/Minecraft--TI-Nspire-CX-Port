package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.BlockStoneBrick;
import net.minecraft.src.ItemBlock;
import net.minecraft.src.ItemStack;

public class ItemSmoothStone extends ItemBlock {

   private Block field_77887_a;


   public ItemSmoothStone(int p_i3686_1_, Block p_i3686_2_) {
      super(p_i3686_1_);
      this.field_77887_a = p_i3686_2_;
      this.func_77656_e(0);
      this.func_77627_a(true);
   }

   public int func_77647_b(int p_77647_1_) {
      return p_77647_1_;
   }

   public String func_77667_c(ItemStack p_77667_1_) {
      int var2 = p_77667_1_.func_77960_j();
      if(var2 < 0 || var2 >= BlockStoneBrick.field_72188_a.length) {
         var2 = 0;
      }

      return super.func_77658_a() + "." + BlockStoneBrick.field_72188_a[var2];
   }
}
