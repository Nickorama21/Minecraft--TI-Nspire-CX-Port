package net.minecraft.src;

import net.minecraft.src.Enchantment;
import net.minecraft.src.EnumEnchantmentType;

public class EnchantmentFireAspect extends Enchantment {

   protected EnchantmentFireAspect(int p_i3714_1_, int p_i3714_2_) {
      super(p_i3714_1_, p_i3714_2_, EnumEnchantmentType.weapon);
      this.func_77322_b("fire");
   }

   public int func_77321_a(int p_77321_1_) {
      return 10 + 20 * (p_77321_1_ - 1);
   }

   public int func_77317_b(int p_77317_1_) {
      return super.func_77321_a(p_77317_1_) + 50;
   }

   public int func_77325_b() {
      return 2;
   }
}
