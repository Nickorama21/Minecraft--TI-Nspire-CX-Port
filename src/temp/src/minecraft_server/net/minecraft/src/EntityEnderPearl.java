package net.minecraft.src;

import net.minecraft.src.DamageSource;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityPlayerMP;
import net.minecraft.src.EntityThrowable;
import net.minecraft.src.MovingObjectPosition;
import net.minecraft.src.World;

public class EntityEnderPearl extends EntityThrowable {

   public EntityEnderPearl(World p_i3589_1_) {
      super(p_i3589_1_);
   }

   public EntityEnderPearl(World p_i3590_1_, EntityLiving p_i3590_2_) {
      super(p_i3590_1_, p_i3590_2_);
   }

   protected void func_70184_a(MovingObjectPosition p_70184_1_) {
      if(p_70184_1_.field_72308_g != null) {
         p_70184_1_.field_72308_g.func_70097_a(DamageSource.func_76356_a(this, this.field_70192_c), 0);
      }

      for(int var2 = 0; var2 < 32; ++var2) {
         this.field_70170_p.func_72869_a("portal", this.field_70165_t, this.field_70163_u + this.field_70146_Z.nextDouble() * 2.0D, this.field_70161_v, this.field_70146_Z.nextGaussian(), 0.0D, this.field_70146_Z.nextGaussian());
      }

      if(!this.field_70170_p.field_72995_K) {
         if(this.field_70192_c != null && this.field_70192_c instanceof EntityPlayerMP) {
            EntityPlayerMP var3 = (EntityPlayerMP)this.field_70192_c;
            if(!var3.field_71135_a.field_72576_c && var3.field_70170_p == this.field_70170_p) {
               this.field_70192_c.func_70634_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
               this.field_70192_c.field_70143_R = 0.0F;
               this.field_70192_c.func_70097_a(DamageSource.field_76379_h, 5);
            }
         }

         this.func_70106_y();
      }

   }
}
