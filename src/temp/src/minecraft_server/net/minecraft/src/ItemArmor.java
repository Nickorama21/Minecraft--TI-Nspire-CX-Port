package net.minecraft.src;

import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EnumArmorMaterial;
import net.minecraft.src.Item;

public class ItemArmor extends Item {

   private static final int[] field_77882_bY = new int[]{11, 16, 15, 13};
   public final int field_77881_a;
   public final int field_77879_b;
   public final int field_77880_c;
   private final EnumArmorMaterial field_77878_bZ;


   public ItemArmor(int p_i3619_1_, EnumArmorMaterial p_i3619_2_, int p_i3619_3_, int p_i3619_4_) {
      super(p_i3619_1_);
      this.field_77878_bZ = p_i3619_2_;
      this.field_77881_a = p_i3619_4_;
      this.field_77880_c = p_i3619_3_;
      this.field_77879_b = p_i3619_2_.func_78044_b(p_i3619_4_);
      this.func_77656_e(p_i3619_2_.func_78046_a(p_i3619_4_));
      this.field_77777_bU = 1;
      this.func_77637_a(CreativeTabs.field_78037_j);
   }

   public int func_77619_b() {
      return this.field_77878_bZ.func_78045_a();
   }

   // $FF: synthetic method
   static int[] func_77877_c() {
      return field_77882_bY;
   }

}
