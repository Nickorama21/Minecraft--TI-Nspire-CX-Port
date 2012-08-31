package net.minecraft.src;

import net.minecraft.src.EntityAnimal;
import net.minecraft.src.EntityWaterMob;
import net.minecraft.src.IMob;
import net.minecraft.src.Material;

public enum EnumCreatureType {

   monster("monster", 0, IMob.class, 70, Material.field_76249_a, false),
   creature("creature", 1, EntityAnimal.class, 15, Material.field_76249_a, true),
   waterCreature("waterCreature", 2, EntityWaterMob.class, 5, Material.field_76244_g, true);
   private final Class field_75605_d;
   private final int field_75606_e;
   private final Material field_75603_f;
   private final boolean field_75604_g;
   // $FF: synthetic field
   private static final EnumCreatureType[] $VALUES = new EnumCreatureType[]{monster, creature, waterCreature};


   private EnumCreatureType(String p_i3444_1_, int p_i3444_2_, Class p_i3444_3_, int p_i3444_4_, Material p_i3444_5_, boolean p_i3444_6_) {
      this.field_75605_d = p_i3444_3_;
      this.field_75606_e = p_i3444_4_;
      this.field_75603_f = p_i3444_5_;
      this.field_75604_g = p_i3444_6_;
   }

   public Class func_75598_a() {
      return this.field_75605_d;
   }

   public int func_75601_b() {
      return this.field_75606_e;
   }

   public Material func_75600_c() {
      return this.field_75603_f;
   }

   public boolean func_75599_d() {
      return this.field_75604_g;
   }

}
