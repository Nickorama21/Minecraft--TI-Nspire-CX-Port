package net.minecraft.src;

import net.minecraft.src.Entity;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityWolf;
import net.minecraft.src.ModelBase;
import net.minecraft.src.RenderLiving;

public class RenderWolf extends RenderLiving {

   public RenderWolf(ModelBase p_i3211_1_, float p_i3211_2_) {
      super(p_i3211_1_, p_i3211_2_);
   }

   public void func_77058_a(EntityWolf p_77058_1_, double p_77058_2_, double p_77058_4_, double p_77058_6_, float p_77058_8_, float p_77058_9_) {
      super.func_77031_a(p_77058_1_, p_77058_2_, p_77058_4_, p_77058_6_, p_77058_8_, p_77058_9_);
   }

   protected float func_77057_a(EntityWolf p_77057_1_, float p_77057_2_) {
      return p_77057_1_.func_70920_v();
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected float func_77044_a(EntityLiving p_77044_1_, float p_77044_2_) {
      return this.func_77057_a((EntityWolf)p_77044_1_, p_77044_2_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_77031_a(EntityLiving p_77031_1_, double p_77031_2_, double p_77031_4_, double p_77031_6_, float p_77031_8_, float p_77031_9_) {
      this.func_77058_a((EntityWolf)p_77031_1_, p_77031_2_, p_77031_4_, p_77031_6_, p_77031_8_, p_77031_9_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
      this.func_77058_a((EntityWolf)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
   }
}
