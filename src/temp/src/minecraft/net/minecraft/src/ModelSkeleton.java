package net.minecraft.src;

import net.minecraft.src.ModelRenderer;
import net.minecraft.src.ModelZombie;

public class ModelSkeleton extends ModelZombie {

   public ModelSkeleton() {
      float var1 = 0.0F;
      this.field_78112_f = new ModelRenderer(this, 40, 16);
      this.field_78112_f.func_78790_a(-1.0F, -2.0F, -1.0F, 2, 12, 2, var1);
      this.field_78112_f.func_78793_a(-5.0F, 2.0F, 0.0F);
      this.field_78113_g = new ModelRenderer(this, 40, 16);
      this.field_78113_g.field_78809_i = true;
      this.field_78113_g.func_78790_a(-1.0F, -2.0F, -1.0F, 2, 12, 2, var1);
      this.field_78113_g.func_78793_a(5.0F, 2.0F, 0.0F);
      this.field_78123_h = new ModelRenderer(this, 0, 16);
      this.field_78123_h.func_78790_a(-1.0F, 0.0F, -1.0F, 2, 12, 2, var1);
      this.field_78123_h.func_78793_a(-2.0F, 12.0F, 0.0F);
      this.field_78124_i = new ModelRenderer(this, 0, 16);
      this.field_78124_i.field_78809_i = true;
      this.field_78124_i.func_78790_a(-1.0F, 0.0F, -1.0F, 2, 12, 2, var1);
      this.field_78124_i.func_78793_a(2.0F, 12.0F, 0.0F);
   }

   public void func_78087_a(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_) {
      this.field_78118_o = true;
      super.func_78087_a(p_78087_1_, p_78087_2_, p_78087_3_, p_78087_4_, p_78087_5_, p_78087_6_);
   }
}
