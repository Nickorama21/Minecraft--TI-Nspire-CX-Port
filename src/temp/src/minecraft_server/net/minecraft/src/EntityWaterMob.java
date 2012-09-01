package net.minecraft.src;

import net.minecraft.src.EntityCreature;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.IAnimals;
import net.minecraft.src.World;

public abstract class EntityWaterMob extends EntityCreature implements IAnimals {

   public EntityWaterMob(World p_i3525_1_) {
      super(p_i3525_1_);
   }

   public boolean func_70648_aU() {
      return true;
   }

   public boolean func_70601_bi() {
      return this.field_70170_p.func_72855_b(this.field_70121_D);
   }

   public int func_70627_aG() {
      return 120;
   }

   protected boolean func_70692_ba() {
      return true;
   }

   protected int func_70693_a(EntityPlayer p_70693_1_) {
      return 1 + this.field_70170_p.field_73012_v.nextInt(3);
   }
}
