package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.ItemBlock;
import net.minecraft.src.ItemStack;

public class ItemColored extends ItemBlock {

   private final Block field_77896_a;
   private String[] field_77895_b;


   public ItemColored(int p_i3628_1_, boolean p_i3628_2_) {
      super(p_i3628_1_);
      this.field_77896_a = Block.field_71973_m[this.func_77883_f()];
      if(p_i3628_2_) {
         this.func_77656_e(0);
         this.func_77627_a(true);
      }

   }

   public int func_77647_b(int p_77647_1_) {
      return p_77647_1_;
   }

   public ItemColored func_77894_a(String[] p_77894_1_) {
      this.field_77895_b = p_77894_1_;
      return this;
   }

   public String func_77667_c(ItemStack p_77667_1_) {
      if(this.field_77895_b == null) {
         return super.func_77667_c(p_77667_1_);
      } else {
         int var2 = p_77667_1_.func_77960_j();
         return var2 >= 0 && var2 < this.field_77895_b.length?super.func_77667_c(p_77667_1_) + "." + this.field_77895_b[var2]:super.func_77667_c(p_77667_1_);
      }
   }
}
