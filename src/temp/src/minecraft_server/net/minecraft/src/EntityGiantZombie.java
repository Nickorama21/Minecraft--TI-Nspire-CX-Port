package net.minecraft.src;

import net.minecraft.src.EntityMob;
import net.minecraft.src.World;

public class EntityGiantZombie extends EntityMob {

   public EntityGiantZombie(World p_i3550_1_) {
      super(p_i3550_1_);
      this.field_70750_az = "/mob/zombie.png";
      this.field_70697_bw = 0.5F;
      this.field_70815_f = 50;
      this.field_70129_M *= 6.0F;
      this.func_70105_a(this.field_70130_N * 6.0F, this.field_70131_O * 6.0F);
   }

   public int func_70667_aM() {
      return 100;
   }

   public float func_70783_a(int p_70783_1_, int p_70783_2_, int p_70783_3_) {
      return this.field_70170_p.func_72801_o(p_70783_1_, p_70783_2_, p_70783_3_) - 0.5F;
   }
}
