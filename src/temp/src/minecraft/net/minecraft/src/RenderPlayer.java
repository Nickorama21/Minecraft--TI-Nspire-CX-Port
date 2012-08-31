package net.minecraft.src;

import net.minecraft.client.Minecraft;
import net.minecraft.src.Block;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EntityPlayerSP;
import net.minecraft.src.EnumAction;
import net.minecraft.src.FontRenderer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemArmor;
import net.minecraft.src.ItemStack;
import net.minecraft.src.MathHelper;
import net.minecraft.src.ModelBiped;
import net.minecraft.src.RenderBlocks;
import net.minecraft.src.RenderLiving;
import net.minecraft.src.Tessellator;
import org.lwjgl.opengl.GL11;

public class RenderPlayer extends RenderLiving {

   private ModelBiped field_77109_a;
   private ModelBiped field_77108_b;
   private ModelBiped field_77111_i;
   private static final String[] field_77110_j = new String[]{"cloth", "chain", "iron", "diamond", "gold"};


   public RenderPlayer() {
      super(new ModelBiped(0.0F), 0.5F);
      this.field_77109_a = (ModelBiped)this.field_77045_g;
      this.field_77108_b = new ModelBiped(1.0F);
      this.field_77111_i = new ModelBiped(0.5F);
   }

   protected int func_77107_a(EntityPlayer p_77107_1_, int p_77107_2_, float p_77107_3_) {
      ItemStack var4 = p_77107_1_.field_71071_by.func_70440_f(3 - p_77107_2_);
      if(var4 != null) {
         Item var5 = var4.func_77973_b();
         if(var5 instanceof ItemArmor) {
            ItemArmor var6 = (ItemArmor)var5;
            this.func_76985_a("/armor/" + field_77110_j[var6.field_77880_c] + "_" + (p_77107_2_ == 2?2:1) + ".png");
            ModelBiped var7 = p_77107_2_ == 2?this.field_77111_i:this.field_77108_b;
            var7.field_78116_c.field_78806_j = p_77107_2_ == 0;
            var7.field_78114_d.field_78806_j = p_77107_2_ == 0;
            var7.field_78115_e.field_78806_j = p_77107_2_ == 1 || p_77107_2_ == 2;
            var7.field_78112_f.field_78806_j = p_77107_2_ == 1;
            var7.field_78113_g.field_78806_j = p_77107_2_ == 1;
            var7.field_78123_h.field_78806_j = p_77107_2_ == 2 || p_77107_2_ == 3;
            var7.field_78124_i.field_78806_j = p_77107_2_ == 2 || p_77107_2_ == 3;
            this.func_77042_a(var7);
            if(var4.func_77948_v()) {
               return 15;
            }

            return 1;
         }
      }

      return -1;
   }

   public void func_77101_a(EntityPlayer p_77101_1_, double p_77101_2_, double p_77101_4_, double p_77101_6_, float p_77101_8_, float p_77101_9_) {
      ItemStack var10 = p_77101_1_.field_71071_by.func_70448_g();
      this.field_77108_b.field_78120_m = this.field_77111_i.field_78120_m = this.field_77109_a.field_78120_m = var10 != null?1:0;
      if(var10 != null && p_77101_1_.func_71052_bv() > 0) {
         EnumAction var11 = var10.func_77975_n();
         if(var11 == EnumAction.block) {
            this.field_77108_b.field_78120_m = this.field_77111_i.field_78120_m = this.field_77109_a.field_78120_m = 3;
         } else if(var11 == EnumAction.bow) {
            this.field_77108_b.field_78118_o = this.field_77111_i.field_78118_o = this.field_77109_a.field_78118_o = true;
         }
      }

      this.field_77108_b.field_78117_n = this.field_77111_i.field_78117_n = this.field_77109_a.field_78117_n = p_77101_1_.func_70093_af();
      double var13 = p_77101_4_ - (double)p_77101_1_.field_70129_M;
      if(p_77101_1_.func_70093_af() && !(p_77101_1_ instanceof EntityPlayerSP)) {
         var13 -= 0.125D;
      }

      super.func_77031_a(p_77101_1_, p_77101_2_, var13, p_77101_6_, p_77101_8_, p_77101_9_);
      this.field_77108_b.field_78118_o = this.field_77111_i.field_78118_o = this.field_77109_a.field_78118_o = false;
      this.field_77108_b.field_78117_n = this.field_77111_i.field_78117_n = this.field_77109_a.field_78117_n = false;
      this.field_77108_b.field_78120_m = this.field_77111_i.field_78120_m = this.field_77109_a.field_78120_m = 0;
   }

   protected void func_77103_a(EntityPlayer p_77103_1_, double p_77103_2_, double p_77103_4_, double p_77103_6_) {
      if(Minecraft.func_71382_s() && p_77103_1_ != this.field_76990_c.field_78734_h) {
         float var8 = 1.6F;
         float var9 = 0.016666668F * var8;
         double var10 = p_77103_1_.func_70068_e(this.field_76990_c.field_78734_h);
         float var12 = p_77103_1_.func_70093_af()?32.0F:64.0F;
         if(var10 < (double)(var12 * var12)) {
            String var13 = p_77103_1_.field_71092_bJ;
            if(p_77103_1_.func_70093_af()) {
               FontRenderer var14 = this.func_76983_a();
               GL11.glPushMatrix();
               GL11.glTranslatef((float)p_77103_2_ + 0.0F, (float)p_77103_4_ + 2.3F, (float)p_77103_6_);
               GL11.glNormal3f(0.0F, 1.0F, 0.0F);
               GL11.glRotatef(-this.field_76990_c.field_78735_i, 0.0F, 1.0F, 0.0F);
               GL11.glRotatef(this.field_76990_c.field_78732_j, 1.0F, 0.0F, 0.0F);
               GL11.glScalef(-var9, -var9, var9);
               GL11.glDisable(2896);
               GL11.glTranslatef(0.0F, 0.25F / var9, 0.0F);
               GL11.glDepthMask(false);
               GL11.glEnable(3042);
               GL11.glBlendFunc(770, 771);
               Tessellator var15 = Tessellator.field_78398_a;
               GL11.glDisable(3553);
               var15.func_78382_b();
               int var16 = var14.func_78256_a(var13) / 2;
               var15.func_78369_a(0.0F, 0.0F, 0.0F, 0.25F);
               var15.func_78377_a((double)(-var16 - 1), -1.0D, 0.0D);
               var15.func_78377_a((double)(-var16 - 1), 8.0D, 0.0D);
               var15.func_78377_a((double)(var16 + 1), 8.0D, 0.0D);
               var15.func_78377_a((double)(var16 + 1), -1.0D, 0.0D);
               var15.func_78381_a();
               GL11.glEnable(3553);
               GL11.glDepthMask(true);
               var14.func_78276_b(var13, -var14.func_78256_a(var13) / 2, 0, 553648127);
               GL11.glEnable(2896);
               GL11.glDisable(3042);
               GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
               GL11.glPopMatrix();
            } else if(p_77103_1_.func_70608_bn()) {
               this.func_77038_a(p_77103_1_, var13, p_77103_2_, p_77103_4_ - 1.5D, p_77103_6_, 64);
            } else {
               this.func_77038_a(p_77103_1_, var13, p_77103_2_, p_77103_4_, p_77103_6_, 64);
            }
         }
      }

   }

   protected void func_77100_a(EntityPlayer p_77100_1_, float p_77100_2_) {
      super.func_77029_c(p_77100_1_, p_77100_2_);
      ItemStack var3 = p_77100_1_.field_71071_by.func_70440_f(3);
      if(var3 != null && var3.func_77973_b().field_77779_bT < 256) {
         GL11.glPushMatrix();
         this.field_77109_a.field_78116_c.func_78794_c(0.0625F);
         if(RenderBlocks.func_78597_b(Block.field_71973_m[var3.field_77993_c].func_71857_b())) {
            float var4 = 0.625F;
            GL11.glTranslatef(0.0F, -0.25F, 0.0F);
            GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
            GL11.glScalef(var4, -var4, var4);
         }

         this.field_76990_c.field_78721_f.func_78443_a(p_77100_1_, var3, 0);
         GL11.glPopMatrix();
      }

      float var6;
      if(p_77100_1_.field_71092_bJ.equals("deadmau5") && this.func_76984_a(p_77100_1_.field_70120_cr, (String)null)) {
         for(int var19 = 0; var19 < 2; ++var19) {
            float var5 = p_77100_1_.field_70126_B + (p_77100_1_.field_70177_z - p_77100_1_.field_70126_B) * p_77100_2_ - (p_77100_1_.field_70760_ar + (p_77100_1_.field_70761_aq - p_77100_1_.field_70760_ar) * p_77100_2_);
            var6 = p_77100_1_.field_70127_C + (p_77100_1_.field_70125_A - p_77100_1_.field_70127_C) * p_77100_2_;
            GL11.glPushMatrix();
            GL11.glRotatef(var5, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(var6, 1.0F, 0.0F, 0.0F);
            GL11.glTranslatef(0.375F * (float)(var19 * 2 - 1), 0.0F, 0.0F);
            GL11.glTranslatef(0.0F, -0.375F, 0.0F);
            GL11.glRotatef(-var6, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(-var5, 0.0F, 1.0F, 0.0F);
            float var7 = 1.3333334F;
            GL11.glScalef(var7, var7, var7);
            this.field_77109_a.func_78110_b(0.0625F);
            GL11.glPopMatrix();
         }
      }

      float var10;
      if(this.func_76984_a(p_77100_1_.field_71084_cw, (String)null)) {
         GL11.glPushMatrix();
         GL11.glTranslatef(0.0F, 0.0F, 0.125F);
         double var22 = p_77100_1_.field_71091_bM + (p_77100_1_.field_71094_bP - p_77100_1_.field_71091_bM) * (double)p_77100_2_ - (p_77100_1_.field_70169_q + (p_77100_1_.field_70165_t - p_77100_1_.field_70169_q) * (double)p_77100_2_);
         double var23 = p_77100_1_.field_71096_bN + (p_77100_1_.field_71095_bQ - p_77100_1_.field_71096_bN) * (double)p_77100_2_ - (p_77100_1_.field_70167_r + (p_77100_1_.field_70163_u - p_77100_1_.field_70167_r) * (double)p_77100_2_);
         double var8 = p_77100_1_.field_71097_bO + (p_77100_1_.field_71085_bR - p_77100_1_.field_71097_bO) * (double)p_77100_2_ - (p_77100_1_.field_70166_s + (p_77100_1_.field_70161_v - p_77100_1_.field_70166_s) * (double)p_77100_2_);
         var10 = p_77100_1_.field_70760_ar + (p_77100_1_.field_70761_aq - p_77100_1_.field_70760_ar) * p_77100_2_;
         double var11 = (double)MathHelper.func_76126_a(var10 * 3.1415927F / 180.0F);
         double var13 = (double)(-MathHelper.func_76134_b(var10 * 3.1415927F / 180.0F));
         float var15 = (float)var23 * 10.0F;
         if(var15 < -6.0F) {
            var15 = -6.0F;
         }

         if(var15 > 32.0F) {
            var15 = 32.0F;
         }

         float var16 = (float)(var22 * var11 + var8 * var13) * 100.0F;
         float var17 = (float)(var22 * var13 - var8 * var11) * 100.0F;
         if(var16 < 0.0F) {
            var16 = 0.0F;
         }

         float var18 = p_77100_1_.field_71107_bF + (p_77100_1_.field_71109_bG - p_77100_1_.field_71107_bF) * p_77100_2_;
         var15 += MathHelper.func_76126_a((p_77100_1_.field_70141_P + (p_77100_1_.field_70140_Q - p_77100_1_.field_70141_P) * p_77100_2_) * 6.0F) * 32.0F * var18;
         if(p_77100_1_.func_70093_af()) {
            var15 += 25.0F;
         }

         GL11.glRotatef(6.0F + var16 / 2.0F + var15, 1.0F, 0.0F, 0.0F);
         GL11.glRotatef(var17 / 2.0F, 0.0F, 0.0F, 1.0F);
         GL11.glRotatef(-var17 / 2.0F, 0.0F, 1.0F, 0.0F);
         GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
         this.field_77109_a.func_78111_c(0.0625F);
         GL11.glPopMatrix();
      }

      ItemStack var21 = p_77100_1_.field_71071_by.func_70448_g();
      if(var21 != null) {
         GL11.glPushMatrix();
         this.field_77109_a.field_78112_f.func_78794_c(0.0625F);
         GL11.glTranslatef(-0.0625F, 0.4375F, 0.0625F);
         if(p_77100_1_.field_71104_cf != null) {
            var21 = new ItemStack(Item.field_77669_D);
         }

         EnumAction var20 = null;
         if(p_77100_1_.func_71052_bv() > 0) {
            var20 = var21.func_77975_n();
         }

         if(var21.field_77993_c < 256 && RenderBlocks.func_78597_b(Block.field_71973_m[var21.field_77993_c].func_71857_b())) {
            var6 = 0.5F;
            GL11.glTranslatef(0.0F, 0.1875F, -0.3125F);
            var6 *= 0.75F;
            GL11.glRotatef(20.0F, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
            GL11.glScalef(var6, -var6, var6);
         } else if(var21.field_77993_c == Item.field_77707_k.field_77779_bT) {
            var6 = 0.625F;
            GL11.glTranslatef(0.0F, 0.125F, 0.3125F);
            GL11.glRotatef(-20.0F, 0.0F, 1.0F, 0.0F);
            GL11.glScalef(var6, -var6, var6);
            GL11.glRotatef(-100.0F, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
         } else if(Item.field_77698_e[var21.field_77993_c].func_77662_d()) {
            var6 = 0.625F;
            if(Item.field_77698_e[var21.field_77993_c].func_77629_n_()) {
               GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
               GL11.glTranslatef(0.0F, -0.125F, 0.0F);
            }

            if(p_77100_1_.func_71052_bv() > 0 && var20 == EnumAction.block) {
               GL11.glTranslatef(0.05F, 0.0F, -0.1F);
               GL11.glRotatef(-50.0F, 0.0F, 1.0F, 0.0F);
               GL11.glRotatef(-10.0F, 1.0F, 0.0F, 0.0F);
               GL11.glRotatef(-60.0F, 0.0F, 0.0F, 1.0F);
            }

            GL11.glTranslatef(0.0F, 0.1875F, 0.0F);
            GL11.glScalef(var6, -var6, var6);
            GL11.glRotatef(-100.0F, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
         } else {
            var6 = 0.375F;
            GL11.glTranslatef(0.25F, 0.1875F, -0.1875F);
            GL11.glScalef(var6, var6, var6);
            GL11.glRotatef(60.0F, 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(20.0F, 0.0F, 0.0F, 1.0F);
         }

         if(var21.func_77973_b().func_77623_v()) {
            for(int var25 = 0; var25 <= 1; ++var25) {
               int var24 = var21.func_77973_b().func_77620_a(var21.func_77960_j(), var25);
               float var26 = (float)(var24 >> 16 & 255) / 255.0F;
               float var9 = (float)(var24 >> 8 & 255) / 255.0F;
               var10 = (float)(var24 & 255) / 255.0F;
               GL11.glColor4f(var26, var9, var10, 1.0F);
               this.field_76990_c.field_78721_f.func_78443_a(p_77100_1_, var21, var25);
            }
         } else {
            this.field_76990_c.field_78721_f.func_78443_a(p_77100_1_, var21, 0);
         }

         GL11.glPopMatrix();
      }

   }

   protected void func_77104_b(EntityPlayer p_77104_1_, float p_77104_2_) {
      float var3 = 0.9375F;
      GL11.glScalef(var3, var3, var3);
   }

   public void func_77106_b() {
      this.field_77109_a.field_78095_p = 0.0F;
      this.field_77109_a.func_78087_a(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
      this.field_77109_a.field_78112_f.func_78785_a(0.0625F);
   }

   protected void func_77105_b(EntityPlayer p_77105_1_, double p_77105_2_, double p_77105_4_, double p_77105_6_) {
      if(p_77105_1_.func_70089_S() && p_77105_1_.func_70608_bn()) {
         super.func_77039_a(p_77105_1_, p_77105_2_ + (double)p_77105_1_.field_71079_bU, p_77105_4_ + (double)p_77105_1_.field_71082_cx, p_77105_6_ + (double)p_77105_1_.field_71089_bV);
      } else {
         super.func_77039_a(p_77105_1_, p_77105_2_, p_77105_4_, p_77105_6_);
      }

   }

   protected void func_77102_a(EntityPlayer p_77102_1_, float p_77102_2_, float p_77102_3_, float p_77102_4_) {
      if(p_77102_1_.func_70089_S() && p_77102_1_.func_70608_bn()) {
         GL11.glRotatef(p_77102_1_.func_71051_bG(), 0.0F, 1.0F, 0.0F);
         GL11.glRotatef(this.func_77037_a(p_77102_1_), 0.0F, 0.0F, 1.0F);
         GL11.glRotatef(270.0F, 0.0F, 1.0F, 0.0F);
      } else {
         super.func_77043_a(p_77102_1_, p_77102_2_, p_77102_3_, p_77102_4_);
      }

   }

   // $FF: synthetic method
   protected void func_77033_b(EntityLiving p_77033_1_, double p_77033_2_, double p_77033_4_, double p_77033_6_) {
      this.func_77103_a((EntityPlayer)p_77033_1_, p_77033_2_, p_77033_4_, p_77033_6_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected void func_77041_b(EntityLiving p_77041_1_, float p_77041_2_) {
      this.func_77104_b((EntityPlayer)p_77041_1_, p_77041_2_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected int func_77032_a(EntityLiving p_77032_1_, int p_77032_2_, float p_77032_3_) {
      return this.func_77107_a((EntityPlayer)p_77032_1_, p_77032_2_, p_77032_3_);
   }

   // $FF: synthetic method
   protected void func_77029_c(EntityLiving p_77029_1_, float p_77029_2_) {
      this.func_77100_a((EntityPlayer)p_77029_1_, p_77029_2_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected void func_77043_a(EntityLiving p_77043_1_, float p_77043_2_, float p_77043_3_, float p_77043_4_) {
      this.func_77102_a((EntityPlayer)p_77043_1_, p_77043_2_, p_77043_3_, p_77043_4_);
   }

   // $FF: synthetic method
   protected void func_77039_a(EntityLiving p_77039_1_, double p_77039_2_, double p_77039_4_, double p_77039_6_) {
      this.func_77105_b((EntityPlayer)p_77039_1_, p_77039_2_, p_77039_4_, p_77039_6_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_77031_a(EntityLiving p_77031_1_, double p_77031_2_, double p_77031_4_, double p_77031_6_, float p_77031_8_, float p_77031_9_) {
      this.func_77101_a((EntityPlayer)p_77031_1_, p_77031_2_, p_77031_4_, p_77031_6_, p_77031_8_, p_77031_9_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
      this.func_77101_a((EntityPlayer)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
   }

}
