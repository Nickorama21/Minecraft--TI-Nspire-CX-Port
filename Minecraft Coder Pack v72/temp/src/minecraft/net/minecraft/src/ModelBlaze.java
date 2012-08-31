package net.minecraft.src;

import net.minecraft.src.Entity;
import net.minecraft.src.MathHelper;
import net.minecraft.src.ModelBase;
import net.minecraft.src.ModelRenderer;

public class ModelBlaze extends ModelBase {

   private ModelRenderer[] field_78106_a = new ModelRenderer[12];
   private ModelRenderer field_78105_b;


   public ModelBlaze() {
      for(int var1 = 0; var1 < this.field_78106_a.length; ++var1) {
         this.field_78106_a[var1] = new ModelRenderer(this, 0, 16);
         this.field_78106_a[var1].func_78789_a(0.0F, 0.0F, 0.0F, 2, 8, 2);
      }

      this.field_78105_b = new ModelRenderer(this, 0, 0);
      this.field_78105_b.func_78789_a(-4.0F, -4.0F, -4.0F, 8, 8, 8);
   }

   public int func_78104_a() {
      return 8;
   }

   public void func_78088_a(Entity p_78088_1_, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float p_78088_7_) {
      this.func_78087_a(p_78088_2_, p_78088_3_, p_78088_4_, p_78088_5_, p_78088_6_, p_78088_7_);
      this.field_78105_b.func_78785_a(p_78088_7_);
      ModelRenderer[] var8 = this.field_78106_a;
      int var9 = var8.length;

      for(int var10 = 0; var10 < var9; ++var10) {
         ModelRenderer var11 = var8[var10];
         var11.func_78785_a(p_78088_7_);
      }

   }

   public void func_78087_a(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_) {
      float var7 = p_78087_3_ * 3.1415927F * -0.1F;

      int var8;
      for(var8 = 0; var8 < 4; ++var8) {
         this.field_78106_a[var8].field_78797_d = -2.0F + MathHelper.func_76134_b(((float)(var8 * 2) + p_78087_3_) * 0.25F);
         this.field_78106_a[var8].field_78800_c = MathHelper.func_76134_b(var7) * 9.0F;
         this.field_78106_a[var8].field_78798_e = MathHelper.func_76126_a(var7) * 9.0F;
         ++var7;
      }

      var7 = 0.7853982F + p_78087_3_ * 3.1415927F * 0.03F;

      for(var8 = 4; var8 < 8; ++var8) {
         this.field_78106_a[var8].field_78797_d = 2.0F + MathHelper.func_76134_b(((float)(var8 * 2) + p_78087_3_) * 0.25F);
         this.field_78106_a[var8].field_78800_c = MathHelper.func_76134_b(var7) * 7.0F;
         this.field_78106_a[var8].field_78798_e = MathHelper.func_76126_a(var7) * 7.0F;
         ++var7;
      }

      var7 = 0.47123894F + p_78087_3_ * 3.1415927F * -0.05F;

      for(var8 = 8; var8 < 12; ++var8) {
         this.field_78106_a[var8].field_78797_d = 11.0F + MathHelper.func_76134_b(((float)var8 * 1.5F + p_78087_3_) * 0.5F);
         this.field_78106_a[var8].field_78800_c = MathHelper.func_76134_b(var7) * 5.0F;
         this.field_78106_a[var8].field_78798_e = MathHelper.func_76126_a(var7) * 5.0F;
         ++var7;
      }

      this.field_78105_b.field_78796_g = p_78087_4_ / 57.295776F;
      this.field_78105_b.field_78795_f = p_78087_5_ / 57.295776F;
   }
}
