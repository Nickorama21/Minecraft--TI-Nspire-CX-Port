package net.minecraft.src;

import net.minecraft.src.EntityGiantZombie;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.ModelBase;
import net.minecraft.src.RenderLiving;
import org.lwjgl.opengl.GL11;

public class RenderGiantZombie extends RenderLiving {

   private float field_77073_a;


   public RenderGiantZombie(ModelBase p_i3205_1_, float p_i3205_2_, float p_i3205_3_) {
      super(p_i3205_1_, p_i3205_2_ * p_i3205_3_);
      this.field_77073_a = p_i3205_3_;
   }

   protected void func_77072_a(EntityGiantZombie p_77072_1_, float p_77072_2_) {
      GL11.glScalef(this.field_77073_a, this.field_77073_a, this.field_77073_a);
   }

   // $FF: synthetic method
   protected void func_77041_b(EntityLiving p_77041_1_, float p_77041_2_) {
      this.func_77072_a((EntityGiantZombie)p_77041_1_, p_77041_2_);
   }
}
