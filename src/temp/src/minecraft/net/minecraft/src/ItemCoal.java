package net.minecraft.src;

import java.util.List;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;

public class ItemCoal extends Item {

   public ItemCoal(int p_i3627_1_) {
      super(p_i3627_1_);
      this.func_77627_a(true);
      this.func_77656_e(0);
      this.func_77637_a(CreativeTabs.field_78035_l);
   }

   public String func_77667_c(ItemStack p_77667_1_) {
      return p_77667_1_.func_77960_j() == 1?"item.charcoal":"item.coal";
   }

   public void func_77633_a(int p_77633_1_, CreativeTabs p_77633_2_, List p_77633_3_) {
      p_77633_3_.add(new ItemStack(p_77633_1_, 1, 0));
      p_77633_3_.add(new ItemStack(p_77633_1_, 1, 1));
   }
}
