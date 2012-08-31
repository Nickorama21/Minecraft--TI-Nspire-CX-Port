package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.BlockWood;
import net.minecraft.src.ItemBlock;
import net.minecraft.src.ItemStack;

public class ItemWood extends ItemBlock {

   private Block field_77886_a;


   public ItemWood(int p_i3696_1_, Block p_i3696_2_) {
      super(p_i3696_1_);
      this.field_77886_a = p_i3696_2_;
      this.func_77656_e(0);
      this.func_77627_a(true);
   }

   public int func_77617_a(int p_77617_1_) {
      return this.field_77886_a.func_71858_a(2, p_77617_1_);
   }

   public int func_77647_b(int p_77647_1_) {
      return p_77647_1_;
   }

   public String func_77667_c(ItemStack p_77667_1_) {
      int var2 = p_77667_1_.func_77960_j();
      if(var2 < 0 || var2 >= BlockWood.field_72152_a.length) {
         var2 = 0;
      }

      return super.func_77658_a() + "." + BlockWood.field_72152_a[var2];
   }
}
