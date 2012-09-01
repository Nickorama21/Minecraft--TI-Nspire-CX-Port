package net.minecraft.src;

import net.minecraft.src.BlockLeaves;
import net.minecraft.src.ItemBlock;
import net.minecraft.src.ItemStack;

public class ItemLeaves extends ItemBlock {

   public ItemLeaves(int p_i3667_1_) {
      super(p_i3667_1_);
      this.func_77656_e(0);
      this.func_77627_a(true);
   }

   public int func_77647_b(int p_77647_1_) {
      return p_77647_1_ | 4;
   }

   public String func_77667_c(ItemStack p_77667_1_) {
      int var2 = p_77667_1_.func_77960_j();
      if(var2 < 0 || var2 >= BlockLeaves.field_72136_a.length) {
         var2 = 0;
      }

      return super.func_77658_a() + "." + BlockLeaves.field_72136_a[var2];
   }
}
