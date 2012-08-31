package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityPainting;
import net.minecraft.src.EnumArt;
import net.minecraft.src.MathHelper;
import net.minecraft.src.OpenGlHelper;
import net.minecraft.src.Render;
import net.minecraft.src.Tessellator;
import org.lwjgl.opengl.GL11;

public class RenderPainting extends Render {

   private Random field_77011_a = new Random();


   public void func_77009_a(EntityPainting p_77009_1_, double p_77009_2_, double p_77009_4_, double p_77009_6_, float p_77009_8_, float p_77009_9_) {
      this.field_77011_a.setSeed(187L);
      GL11.glPushMatrix();
      GL11.glTranslatef((float)p_77009_2_, (float)p_77009_4_, (float)p_77009_6_);
      GL11.glRotatef(p_77009_8_, 0.0F, 1.0F, 0.0F);
      GL11.glEnable('\u803a');
      this.func_76985_a("/art/kz.png");
      EnumArt var10 = p_77009_1_.field_70522_e;
      float var11 = 0.0625F;
      GL11.glScalef(var11, var11, var11);
      this.func_77010_a(p_77009_1_, var10.field_75703_B, var10.field_75704_C, var10.field_75699_D, var10.field_75700_E);
      GL11.glDisable('\u803a');
      GL11.glPopMatrix();
   }

   private void func_77010_a(EntityPainting p_77010_1_, int p_77010_2_, int p_77010_3_, int p_77010_4_, int p_77010_5_) {
      float var6 = (float)(-p_77010_2_) / 2.0F;
      float var7 = (float)(-p_77010_3_) / 2.0F;
      float var8 = -0.5F;
      float var9 = 0.5F;

      for(int var10 = 0; var10 < p_77010_2_ / 16; ++var10) {
         for(int var11 = 0; var11 < p_77010_3_ / 16; ++var11) {
            float var12 = var6 + (float)((var10 + 1) * 16);
            float var13 = var6 + (float)(var10 * 16);
            float var14 = var7 + (float)((var11 + 1) * 16);
            float var15 = var7 + (float)(var11 * 16);
            this.func_77008_a(p_77010_1_, (var12 + var13) / 2.0F, (var14 + var15) / 2.0F);
            float var16 = (float)(p_77010_4_ + p_77010_2_ - var10 * 16) / 256.0F;
            float var17 = (float)(p_77010_4_ + p_77010_2_ - (var10 + 1) * 16) / 256.0F;
            float var18 = (float)(p_77010_5_ + p_77010_3_ - var11 * 16) / 256.0F;
            float var19 = (float)(p_77010_5_ + p_77010_3_ - (var11 + 1) * 16) / 256.0F;
            float var20 = 0.75F;
            float var21 = 0.8125F;
            float var22 = 0.0F;
            float var23 = 0.0625F;
            float var24 = 0.75F;
            float var25 = 0.8125F;
            float var26 = 0.001953125F;
            float var27 = 0.001953125F;
            float var28 = 0.7519531F;
            float var29 = 0.7519531F;
            float var30 = 0.0F;
            float var31 = 0.0625F;
            Tessellator var32 = Tessellator.field_78398_a;
            var32.func_78382_b();
            var32.func_78375_b(0.0F, 0.0F, -1.0F);
            var32.func_78374_a((double)var12, (double)var15, (double)var8, (double)var17, (double)var18);
            var32.func_78374_a((double)var13, (double)var15, (double)var8, (double)var16, (double)var18);
            var32.func_78374_a((double)var13, (double)var14, (double)var8, (double)var16, (double)var19);
            var32.func_78374_a((double)var12, (double)var14, (double)var8, (double)var17, (double)var19);
            var32.func_78375_b(0.0F, 0.0F, 1.0F);
            var32.func_78374_a((double)var12, (double)var14, (double)var9, (double)var20, (double)var22);
            var32.func_78374_a((double)var13, (double)var14, (double)var9, (double)var21, (double)var22);
            var32.func_78374_a((double)var13, (double)var15, (double)var9, (double)var21, (double)var23);
            var32.func_78374_a((double)var12, (double)var15, (double)var9, (double)var20, (double)var23);
            var32.func_78375_b(0.0F, 1.0F, 0.0F);
            var32.func_78374_a((double)var12, (double)var14, (double)var8, (double)var24, (double)var26);
            var32.func_78374_a((double)var13, (double)var14, (double)var8, (double)var25, (double)var26);
            var32.func_78374_a((double)var13, (double)var14, (double)var9, (double)var25, (double)var27);
            var32.func_78374_a((double)var12, (double)var14, (double)var9, (double)var24, (double)var27);
            var32.func_78375_b(0.0F, -1.0F, 0.0F);
            var32.func_78374_a((double)var12, (double)var15, (double)var9, (double)var24, (double)var26);
            var32.func_78374_a((double)var13, (double)var15, (double)var9, (double)var25, (double)var26);
            var32.func_78374_a((double)var13, (double)var15, (double)var8, (double)var25, (double)var27);
            var32.func_78374_a((double)var12, (double)var15, (double)var8, (double)var24, (double)var27);
            var32.func_78375_b(-1.0F, 0.0F, 0.0F);
            var32.func_78374_a((double)var12, (double)var14, (double)var9, (double)var29, (double)var30);
            var32.func_78374_a((double)var12, (double)var15, (double)var9, (double)var29, (double)var31);
            var32.func_78374_a((double)var12, (double)var15, (double)var8, (double)var28, (double)var31);
            var32.func_78374_a((double)var12, (double)var14, (double)var8, (double)var28, (double)var30);
            var32.func_78375_b(1.0F, 0.0F, 0.0F);
            var32.func_78374_a((double)var13, (double)var14, (double)var8, (double)var29, (double)var30);
            var32.func_78374_a((double)var13, (double)var15, (double)var8, (double)var29, (double)var31);
            var32.func_78374_a((double)var13, (double)var15, (double)var9, (double)var28, (double)var31);
            var32.func_78374_a((double)var13, (double)var14, (double)var9, (double)var28, (double)var30);
            var32.func_78381_a();
         }
      }

   }

   private void func_77008_a(EntityPainting p_77008_1_, float p_77008_2_, float p_77008_3_) {
      int var4 = MathHelper.func_76128_c(p_77008_1_.field_70165_t);
      int var5 = MathHelper.func_76128_c(p_77008_1_.field_70163_u + (double)(p_77008_3_ / 16.0F));
      int var6 = MathHelper.func_76128_c(p_77008_1_.field_70161_v);
      if(p_77008_1_.field_70525_a == 0) {
         var4 = MathHelper.func_76128_c(p_77008_1_.field_70165_t + (double)(p_77008_2_ / 16.0F));
      }

      if(p_77008_1_.field_70525_a == 1) {
         var6 = MathHelper.func_76128_c(p_77008_1_.field_70161_v - (double)(p_77008_2_ / 16.0F));
      }

      if(p_77008_1_.field_70525_a == 2) {
         var4 = MathHelper.func_76128_c(p_77008_1_.field_70165_t - (double)(p_77008_2_ / 16.0F));
      }

      if(p_77008_1_.field_70525_a == 3) {
         var6 = MathHelper.func_76128_c(p_77008_1_.field_70161_v + (double)(p_77008_2_ / 16.0F));
      }

      int var7 = this.field_76990_c.field_78722_g.func_72802_i(var4, var5, var6, 0);
      int var8 = var7 % 65536;
      int var9 = var7 / 65536;
      OpenGlHelper.func_77475_a(OpenGlHelper.field_77476_b, (float)var8, (float)var9);
      GL11.glColor3f(1.0F, 1.0F, 1.0F);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
      this.func_77009_a((EntityPainting)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
   }
}
