package net.minecraft.src;

import net.minecraft.src.DamageSource;
import net.minecraft.src.EntityDragonPart;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.World;

public class EntityDragonBase extends EntityLiving {

   protected int field_70966_a = 100;


   public EntityDragonBase(World p_i3527_1_) {
      super(p_i3527_1_);
   }

   public int func_70667_aM() {
      return this.field_70966_a;
   }

   public boolean func_70965_a(EntityDragonPart p_70965_1_, DamageSource p_70965_2_, int p_70965_3_) {
      return this.func_70097_a(p_70965_2_, p_70965_3_);
   }

   public boolean func_70097_a(DamageSource p_70097_1_, int p_70097_2_) {
      return false;
   }

   protected boolean func_70964_e(DamageSource p_70964_1_, int p_70964_2_) {
      return super.func_70097_a(p_70964_1_, p_70964_2_);
   }
}
