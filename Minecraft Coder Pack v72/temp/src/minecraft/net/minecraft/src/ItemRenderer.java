package net.minecraft.src;

import net.minecraft.client.Minecraft;
import net.minecraft.src.Block;
import net.minecraft.src.EntityClientPlayerMP;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityPlayerSP;
import net.minecraft.src.EnumAction;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.MapData;
import net.minecraft.src.MapItemRenderer;
import net.minecraft.src.Material;
import net.minecraft.src.MathHelper;
import net.minecraft.src.OpenGlHelper;
import net.minecraft.src.Render;
import net.minecraft.src.RenderBlocks;
import net.minecraft.src.RenderHelper;
import net.minecraft.src.RenderManager;
import net.minecraft.src.RenderPlayer;
import net.minecraft.src.Tessellator;
import org.lwjgl.opengl.GL11;

public class ItemRenderer {

   private Minecraft field_78455_a;
   private ItemStack field_78453_b = null;
   private float field_78454_c = 0.0F;
   private float field_78451_d = 0.0F;
   private RenderBlocks field_78452_e = new RenderBlocks();
   private MapItemRenderer field_78449_f;
   private int field_78450_g = -1;


   public ItemRenderer(Minecraft p_i3186_1_) {
      this.field_78455_a = p_i3186_1_;
      this.field_78449_f = new MapItemRenderer(p_i3186_1_.field_71466_p, p_i3186_1_.field_71474_y, p_i3186_1_.field_71446_o);
   }

   public void func_78443_a(EntityLiving p_78443_1_, ItemStack p_78443_2_, int p_78443_3_) {
      GL11.glPushMatrix();
      Block var4 = Block.field_71973_m[p_78443_2_.field_77993_c];
      if(var4 != null && RenderBlocks.func_78597_b(var4.func_71857_b())) {
         GL11.glBindTexture(3553, this.field_78455_a.field_71446_o.func_78341_b("/terrain.png"));
         this.field_78452_e.func_78600_a(var4, p_78443_2_.func_77960_j(), 1.0F);
      } else {
         if(var4 != null) {
            GL11.glBindTexture(3553, this.field_78455_a.field_71446_o.func_78341_b("/terrain.png"));
         } else {
            GL11.glBindTexture(3553, this.field_78455_a.field_71446_o.func_78341_b("/gui/items.png"));
         }

         Tessellator var5 = Tessellator.field_78398_a;
         int var6 = p_78443_1_.func_70620_b(p_78443_2_, p_78443_3_);
         float var7 = ((float)(var6 % 16 * 16) + 0.0F) / 256.0F;
         float var8 = ((float)(var6 % 16 * 16) + 15.99F) / 256.0F;
         float var9 = ((float)(var6 / 16 * 16) + 0.0F) / 256.0F;
         float var10 = ((float)(var6 / 16 * 16) + 15.99F) / 256.0F;
         float var11 = 0.0F;
         float var12 = 0.3F;
         GL11.glEnable('\u803a');
         GL11.glTranslatef(-var11, -var12, 0.0F);
         float var13 = 1.5F;
         GL11.glScalef(var13, var13, var13);
         GL11.glRotatef(50.0F, 0.0F, 1.0F, 0.0F);
         GL11.glRotatef(335.0F, 0.0F, 0.0F, 1.0F);
         GL11.glTranslatef(-0.9375F, -0.0625F, 0.0F);
         this.func_78439_a(var5, var8, var9, var7, var10);
         if(p_78443_2_ != null && p_78443_2_.func_77962_s() && p_78443_3_ == 0) {
            GL11.glDepthFunc(514);
            GL11.glDisable(2896);
            this.field_78455_a.field_71446_o.func_78342_b(this.field_78455_a.field_71446_o.func_78341_b("%blur%/misc/glint.png"));
            GL11.glEnable(3042);
            GL11.glBlendFunc(768, 1);
            float var14 = 0.76F;
            GL11.glColor4f(0.5F * var14, 0.25F * var14, 0.8F * var14, 1.0F);
            GL11.glMatrixMode(5890);
            GL11.glPushMatrix();
            float var15 = 0.125F;
            GL11.glScalef(var15, var15, var15);
            float var16 = (float)(Minecraft.func_71386_F() % 3000L) / 3000.0F * 8.0F;
            GL11.glTranslatef(var16, 0.0F, 0.0F);
            GL11.glRotatef(-50.0F, 0.0F, 0.0F, 1.0F);
            this.func_78439_a(var5, 0.0F, 0.0F, 1.0F, 1.0F);
            GL11.glPopMatrix();
            GL11.glPushMatrix();
            GL11.glScalef(var15, var15, var15);
            var16 = (float)(Minecraft.func_71386_F() % 4873L) / 4873.0F * 8.0F;
            GL11.glTranslatef(-var16, 0.0F, 0.0F);
            GL11.glRotatef(10.0F, 0.0F, 0.0F, 1.0F);
            this.func_78439_a(var5, 0.0F, 0.0F, 1.0F, 1.0F);
            GL11.glPopMatrix();
            GL11.glMatrixMode(5888);
            GL11.glDisable(3042);
            GL11.glEnable(2896);
            GL11.glDepthFunc(515);
         }

         GL11.glDisable('\u803a');
      }

      GL11.glPopMatrix();
   }

   private void func_78439_a(Tessellator p_78439_1_, float p_78439_2_, float p_78439_3_, float p_78439_4_, float p_78439_5_) {
      float var6 = 1.0F;
      float var7 = 0.0625F;
      p_78439_1_.func_78382_b();
      p_78439_1_.func_78375_b(0.0F, 0.0F, 1.0F);
      p_78439_1_.func_78374_a(0.0D, 0.0D, 0.0D, (double)p_78439_2_, (double)p_78439_5_);
      p_78439_1_.func_78374_a((double)var6, 0.0D, 0.0D, (double)p_78439_4_, (double)p_78439_5_);
      p_78439_1_.func_78374_a((double)var6, 1.0D, 0.0D, (double)p_78439_4_, (double)p_78439_3_);
      p_78439_1_.func_78374_a(0.0D, 1.0D, 0.0D, (double)p_78439_2_, (double)p_78439_3_);
      p_78439_1_.func_78381_a();
      p_78439_1_.func_78382_b();
      p_78439_1_.func_78375_b(0.0F, 0.0F, -1.0F);
      p_78439_1_.func_78374_a(0.0D, 1.0D, (double)(0.0F - var7), (double)p_78439_2_, (double)p_78439_3_);
      p_78439_1_.func_78374_a((double)var6, 1.0D, (double)(0.0F - var7), (double)p_78439_4_, (double)p_78439_3_);
      p_78439_1_.func_78374_a((double)var6, 0.0D, (double)(0.0F - var7), (double)p_78439_4_, (double)p_78439_5_);
      p_78439_1_.func_78374_a(0.0D, 0.0D, (double)(0.0F - var7), (double)p_78439_2_, (double)p_78439_5_);
      p_78439_1_.func_78381_a();
      p_78439_1_.func_78382_b();
      p_78439_1_.func_78375_b(-1.0F, 0.0F, 0.0F);

      int var8;
      float var9;
      float var10;
      float var11;
      for(var8 = 0; var8 < 16; ++var8) {
         var9 = (float)var8 / 16.0F;
         var10 = p_78439_2_ + (p_78439_4_ - p_78439_2_) * var9 - 0.001953125F;
         var11 = var6 * var9;
         p_78439_1_.func_78374_a((double)var11, 0.0D, (double)(0.0F - var7), (double)var10, (double)p_78439_5_);
         p_78439_1_.func_78374_a((double)var11, 0.0D, 0.0D, (double)var10, (double)p_78439_5_);
         p_78439_1_.func_78374_a((double)var11, 1.0D, 0.0D, (double)var10, (double)p_78439_3_);
         p_78439_1_.func_78374_a((double)var11, 1.0D, (double)(0.0F - var7), (double)var10, (double)p_78439_3_);
      }

      p_78439_1_.func_78381_a();
      p_78439_1_.func_78382_b();
      p_78439_1_.func_78375_b(1.0F, 0.0F, 0.0F);

      for(var8 = 0; var8 < 16; ++var8) {
         var9 = (float)var8 / 16.0F;
         var10 = p_78439_2_ + (p_78439_4_ - p_78439_2_) * var9 - 0.001953125F;
         var11 = var6 * var9 + 0.0625F;
         p_78439_1_.func_78374_a((double)var11, 1.0D, (double)(0.0F - var7), (double)var10, (double)p_78439_3_);
         p_78439_1_.func_78374_a((double)var11, 1.0D, 0.0D, (double)var10, (double)p_78439_3_);
         p_78439_1_.func_78374_a((double)var11, 0.0D, 0.0D, (double)var10, (double)p_78439_5_);
         p_78439_1_.func_78374_a((double)var11, 0.0D, (double)(0.0F - var7), (double)var10, (double)p_78439_5_);
      }

      p_78439_1_.func_78381_a();
      p_78439_1_.func_78382_b();
      p_78439_1_.func_78375_b(0.0F, 1.0F, 0.0F);

      for(var8 = 0; var8 < 16; ++var8) {
         var9 = (float)var8 / 16.0F;
         var10 = p_78439_5_ + (p_78439_3_ - p_78439_5_) * var9 - 0.001953125F;
         var11 = var6 * var9 + 0.0625F;
         p_78439_1_.func_78374_a(0.0D, (double)var11, 0.0D, (double)p_78439_2_, (double)var10);
         p_78439_1_.func_78374_a((double)var6, (double)var11, 0.0D, (double)p_78439_4_, (double)var10);
         p_78439_1_.func_78374_a((double)var6, (double)var11, (double)(0.0F - var7), (double)p_78439_4_, (double)var10);
         p_78439_1_.func_78374_a(0.0D, (double)var11, (double)(0.0F - var7), (double)p_78439_2_, (double)var10);
      }

      p_78439_1_.func_78381_a();
      p_78439_1_.func_78382_b();
      p_78439_1_.func_78375_b(0.0F, -1.0F, 0.0F);

      for(var8 = 0; var8 < 16; ++var8) {
         var9 = (float)var8 / 16.0F;
         var10 = p_78439_5_ + (p_78439_3_ - p_78439_5_) * var9 - 0.001953125F;
         var11 = var6 * var9;
         p_78439_1_.func_78374_a((double)var6, (double)var11, 0.0D, (double)p_78439_4_, (double)var10);
         p_78439_1_.func_78374_a(0.0D, (double)var11, 0.0D, (double)p_78439_2_, (double)var10);
         p_78439_1_.func_78374_a(0.0D, (double)var11, (double)(0.0F - var7), (double)p_78439_2_, (double)var10);
         p_78439_1_.func_78374_a((double)var6, (double)var11, (double)(0.0F - var7), (double)p_78439_4_, (double)var10);
      }

      p_78439_1_.func_78381_a();
   }

   public void func_78440_a(float p_78440_1_) {
      float var2 = this.field_78451_d + (this.field_78454_c - this.field_78451_d) * p_78440_1_;
      EntityClientPlayerMP var3 = this.field_78455_a.field_71439_g;
      float var4 = var3.field_70127_C + (var3.field_70125_A - var3.field_70127_C) * p_78440_1_;
      GL11.glPushMatrix();
      GL11.glRotatef(var4, 1.0F, 0.0F, 0.0F);
      GL11.glRotatef(var3.field_70126_B + (var3.field_70177_z - var3.field_70126_B) * p_78440_1_, 0.0F, 1.0F, 0.0F);
      RenderHelper.func_74519_b();
      GL11.glPopMatrix();
      float var6;
      float var7;
      if(var3 instanceof EntityPlayerSP) {
         EntityPlayerSP var5 = (EntityPlayerSP)var3;
         var6 = var5.field_71164_i + (var5.field_71155_g - var5.field_71164_i) * p_78440_1_;
         var7 = var5.field_71163_h + (var5.field_71154_f - var5.field_71163_h) * p_78440_1_;
         GL11.glRotatef((var3.field_70125_A - var6) * 0.1F, 1.0F, 0.0F, 0.0F);
         GL11.glRotatef((var3.field_70177_z - var7) * 0.1F, 0.0F, 1.0F, 0.0F);
      }

      ItemStack var17 = this.field_78453_b;
      var6 = this.field_78455_a.field_71441_e.func_72801_o(MathHelper.func_76128_c(var3.field_70165_t), MathHelper.func_76128_c(var3.field_70163_u), MathHelper.func_76128_c(var3.field_70161_v));
      var6 = 1.0F;
      int var18 = this.field_78455_a.field_71441_e.func_72802_i(MathHelper.func_76128_c(var3.field_70165_t), MathHelper.func_76128_c(var3.field_70163_u), MathHelper.func_76128_c(var3.field_70161_v), 0);
      int var8 = var18 % 65536;
      int var9 = var18 / 65536;
      OpenGlHelper.func_77475_a(OpenGlHelper.field_77476_b, (float)var8 / 1.0F, (float)var9 / 1.0F);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      float var10;
      float var21;
      float var20;
      if(var17 != null) {
         var18 = Item.field_77698_e[var17.field_77993_c].func_77620_a(var17.func_77960_j(), 0);
         var20 = (float)(var18 >> 16 & 255) / 255.0F;
         var21 = (float)(var18 >> 8 & 255) / 255.0F;
         var10 = (float)(var18 & 255) / 255.0F;
         GL11.glColor4f(var6 * var20, var6 * var21, var6 * var10, 1.0F);
      } else {
         GL11.glColor4f(var6, var6, var6, 1.0F);
      }

      float var11;
      float var12;
      float var13;
      Render var24;
      RenderPlayer var26;
      if(var17 != null && var17.field_77993_c == Item.field_77744_bd.field_77779_bT) {
         GL11.glPushMatrix();
         var7 = 0.8F;
         var20 = var3.func_70678_g(p_78440_1_);
         var21 = MathHelper.func_76126_a(var20 * 3.1415927F);
         var10 = MathHelper.func_76126_a(MathHelper.func_76129_c(var20) * 3.1415927F);
         GL11.glTranslatef(-var10 * 0.4F, MathHelper.func_76126_a(MathHelper.func_76129_c(var20) * 3.1415927F * 2.0F) * 0.2F, -var21 * 0.2F);
         var20 = 1.0F - var4 / 45.0F + 0.1F;
         if(var20 < 0.0F) {
            var20 = 0.0F;
         }

         if(var20 > 1.0F) {
            var20 = 1.0F;
         }

         var20 = -MathHelper.func_76134_b(var20 * 3.1415927F) * 0.5F + 0.5F;
         GL11.glTranslatef(0.0F, 0.0F * var7 - (1.0F - var2) * 1.2F - var20 * 0.5F + 0.04F, -0.9F * var7);
         GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
         GL11.glRotatef(var20 * -85.0F, 0.0F, 0.0F, 1.0F);
         GL11.glEnable('\u803a');
         GL11.glBindTexture(3553, this.field_78455_a.field_71446_o.func_78350_a(this.field_78455_a.field_71439_g.field_70120_cr, this.field_78455_a.field_71439_g.func_70073_O()));

         for(var9 = 0; var9 < 2; ++var9) {
            int var22 = var9 * 2 - 1;
            GL11.glPushMatrix();
            GL11.glTranslatef(-0.0F, -0.6F, 1.1F * (float)var22);
            GL11.glRotatef((float)(-45 * var22), 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(-90.0F, 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(59.0F, 0.0F, 0.0F, 1.0F);
            GL11.glRotatef((float)(-65 * var22), 0.0F, 1.0F, 0.0F);
            var24 = RenderManager.field_78727_a.func_78713_a(this.field_78455_a.field_71439_g);
            var26 = (RenderPlayer)var24;
            var13 = 1.0F;
            GL11.glScalef(var13, var13, var13);
            var26.func_77106_b();
            GL11.glPopMatrix();
         }

         var21 = var3.func_70678_g(p_78440_1_);
         var10 = MathHelper.func_76126_a(var21 * var21 * 3.1415927F);
         var11 = MathHelper.func_76126_a(MathHelper.func_76129_c(var21) * 3.1415927F);
         GL11.glRotatef(-var10 * 20.0F, 0.0F, 1.0F, 0.0F);
         GL11.glRotatef(-var11 * 20.0F, 0.0F, 0.0F, 1.0F);
         GL11.glRotatef(-var11 * 80.0F, 1.0F, 0.0F, 0.0F);
         var12 = 0.38F;
         GL11.glScalef(var12, var12, var12);
         GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
         GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
         GL11.glTranslatef(-1.0F, -1.0F, 0.0F);
         var13 = 0.015625F;
         GL11.glScalef(var13, var13, var13);
         this.field_78455_a.field_71446_o.func_78342_b(this.field_78455_a.field_71446_o.func_78341_b("/misc/mapbg.png"));
         Tessellator var28 = Tessellator.field_78398_a;
         GL11.glNormal3f(0.0F, 0.0F, -1.0F);
         var28.func_78382_b();
         byte var27 = 7;
         var28.func_78374_a((double)(0 - var27), (double)(128 + var27), 0.0D, 0.0D, 1.0D);
         var28.func_78374_a((double)(128 + var27), (double)(128 + var27), 0.0D, 1.0D, 1.0D);
         var28.func_78374_a((double)(128 + var27), (double)(0 - var27), 0.0D, 1.0D, 0.0D);
         var28.func_78374_a((double)(0 - var27), (double)(0 - var27), 0.0D, 0.0D, 0.0D);
         var28.func_78381_a();
         MapData var16 = Item.field_77744_bd.func_77873_a(var17, this.field_78455_a.field_71441_e);
         this.field_78449_f.func_78319_a(this.field_78455_a.field_71439_g, this.field_78455_a.field_71446_o, var16);
         GL11.glPopMatrix();
      } else if(var17 != null) {
         GL11.glPushMatrix();
         var7 = 0.8F;
         if(var3.func_71052_bv() > 0) {
            EnumAction var19 = var17.func_77975_n();
            if(var19 == EnumAction.eat || var19 == EnumAction.drink) {
               var21 = (float)var3.func_71052_bv() - p_78440_1_ + 1.0F;
               var10 = 1.0F - var21 / (float)var17.func_77988_m();
               var11 = 1.0F - var10;
               var11 = var11 * var11 * var11;
               var11 = var11 * var11 * var11;
               var11 = var11 * var11 * var11;
               var12 = 1.0F - var11;
               GL11.glTranslatef(0.0F, MathHelper.func_76135_e(MathHelper.func_76134_b(var21 / 4.0F * 3.1415927F) * 0.1F) * (float)((double)var10 > 0.2D?1:0), 0.0F);
               GL11.glTranslatef(var12 * 0.6F, -var12 * 0.5F, 0.0F);
               GL11.glRotatef(var12 * 90.0F, 0.0F, 1.0F, 0.0F);
               GL11.glRotatef(var12 * 10.0F, 1.0F, 0.0F, 0.0F);
               GL11.glRotatef(var12 * 30.0F, 0.0F, 0.0F, 1.0F);
            }
         } else {
            var20 = var3.func_70678_g(p_78440_1_);
            var21 = MathHelper.func_76126_a(var20 * 3.1415927F);
            var10 = MathHelper.func_76126_a(MathHelper.func_76129_c(var20) * 3.1415927F);
            GL11.glTranslatef(-var10 * 0.4F, MathHelper.func_76126_a(MathHelper.func_76129_c(var20) * 3.1415927F * 2.0F) * 0.2F, -var21 * 0.2F);
         }

         GL11.glTranslatef(0.7F * var7, -0.65F * var7 - (1.0F - var2) * 0.6F, -0.9F * var7);
         GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
         GL11.glEnable('\u803a');
         var20 = var3.func_70678_g(p_78440_1_);
         var21 = MathHelper.func_76126_a(var20 * var20 * 3.1415927F);
         var10 = MathHelper.func_76126_a(MathHelper.func_76129_c(var20) * 3.1415927F);
         GL11.glRotatef(-var21 * 20.0F, 0.0F, 1.0F, 0.0F);
         GL11.glRotatef(-var10 * 20.0F, 0.0F, 0.0F, 1.0F);
         GL11.glRotatef(-var10 * 80.0F, 1.0F, 0.0F, 0.0F);
         var11 = 0.4F;
         GL11.glScalef(var11, var11, var11);
         float var14;
         float var15;
         if(var3.func_71052_bv() > 0) {
            EnumAction var23 = var17.func_77975_n();
            if(var23 == EnumAction.block) {
               GL11.glTranslatef(-0.5F, 0.2F, 0.0F);
               GL11.glRotatef(30.0F, 0.0F, 1.0F, 0.0F);
               GL11.glRotatef(-80.0F, 1.0F, 0.0F, 0.0F);
               GL11.glRotatef(60.0F, 0.0F, 1.0F, 0.0F);
            } else if(var23 == EnumAction.bow) {
               GL11.glRotatef(-18.0F, 0.0F, 0.0F, 1.0F);
               GL11.glRotatef(-12.0F, 0.0F, 1.0F, 0.0F);
               GL11.glRotatef(-8.0F, 1.0F, 0.0F, 0.0F);
               GL11.glTranslatef(-0.9F, 0.2F, 0.0F);
               var13 = (float)var17.func_77988_m() - ((float)var3.func_71052_bv() - p_78440_1_ + 1.0F);
               var14 = var13 / 20.0F;
               var14 = (var14 * var14 + var14 * 2.0F) / 3.0F;
               if(var14 > 1.0F) {
                  var14 = 1.0F;
               }

               if(var14 > 0.1F) {
                  GL11.glTranslatef(0.0F, MathHelper.func_76126_a((var13 - 0.1F) * 1.3F) * 0.01F * (var14 - 0.1F), 0.0F);
               }

               GL11.glTranslatef(0.0F, 0.0F, var14 * 0.1F);
               GL11.glRotatef(-335.0F, 0.0F, 0.0F, 1.0F);
               GL11.glRotatef(-50.0F, 0.0F, 1.0F, 0.0F);
               GL11.glTranslatef(0.0F, 0.5F, 0.0F);
               var15 = 1.0F + var14 * 0.2F;
               GL11.glScalef(1.0F, 1.0F, var15);
               GL11.glTranslatef(0.0F, -0.5F, 0.0F);
               GL11.glRotatef(50.0F, 0.0F, 1.0F, 0.0F);
               GL11.glRotatef(335.0F, 0.0F, 0.0F, 1.0F);
            }
         }

         if(var17.func_77973_b().func_77629_n_()) {
            GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
         }

         if(var17.func_77973_b().func_77623_v()) {
            this.func_78443_a(var3, var17, 0);
            int var25 = Item.field_77698_e[var17.field_77993_c].func_77620_a(var17.func_77960_j(), 1);
            var13 = (float)(var25 >> 16 & 255) / 255.0F;
            var14 = (float)(var25 >> 8 & 255) / 255.0F;
            var15 = (float)(var25 & 255) / 255.0F;
            GL11.glColor4f(var6 * var13, var6 * var14, var6 * var15, 1.0F);
            this.func_78443_a(var3, var17, 1);
         } else {
            this.func_78443_a(var3, var17, 0);
         }

         GL11.glPopMatrix();
      } else {
         GL11.glPushMatrix();
         var7 = 0.8F;
         var20 = var3.func_70678_g(p_78440_1_);
         var21 = MathHelper.func_76126_a(var20 * 3.1415927F);
         var10 = MathHelper.func_76126_a(MathHelper.func_76129_c(var20) * 3.1415927F);
         GL11.glTranslatef(-var10 * 0.3F, MathHelper.func_76126_a(MathHelper.func_76129_c(var20) * 3.1415927F * 2.0F) * 0.4F, -var21 * 0.4F);
         GL11.glTranslatef(0.8F * var7, -0.75F * var7 - (1.0F - var2) * 0.6F, -0.9F * var7);
         GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
         GL11.glEnable('\u803a');
         var20 = var3.func_70678_g(p_78440_1_);
         var21 = MathHelper.func_76126_a(var20 * var20 * 3.1415927F);
         var10 = MathHelper.func_76126_a(MathHelper.func_76129_c(var20) * 3.1415927F);
         GL11.glRotatef(var10 * 70.0F, 0.0F, 1.0F, 0.0F);
         GL11.glRotatef(-var21 * 20.0F, 0.0F, 0.0F, 1.0F);
         GL11.glBindTexture(3553, this.field_78455_a.field_71446_o.func_78350_a(this.field_78455_a.field_71439_g.field_70120_cr, this.field_78455_a.field_71439_g.func_70073_O()));
         GL11.glTranslatef(-1.0F, 3.6F, 3.5F);
         GL11.glRotatef(120.0F, 0.0F, 0.0F, 1.0F);
         GL11.glRotatef(200.0F, 1.0F, 0.0F, 0.0F);
         GL11.glRotatef(-135.0F, 0.0F, 1.0F, 0.0F);
         GL11.glScalef(1.0F, 1.0F, 1.0F);
         GL11.glTranslatef(5.6F, 0.0F, 0.0F);
         var24 = RenderManager.field_78727_a.func_78713_a(this.field_78455_a.field_71439_g);
         var26 = (RenderPlayer)var24;
         var13 = 1.0F;
         GL11.glScalef(var13, var13, var13);
         var26.func_77106_b();
         GL11.glPopMatrix();
      }

      GL11.glDisable('\u803a');
      RenderHelper.func_74518_a();
   }

   public void func_78447_b(float p_78447_1_) {
      GL11.glDisable(3008);
      int var2;
      if(this.field_78455_a.field_71439_g.func_70027_ad()) {
         var2 = this.field_78455_a.field_71446_o.func_78341_b("/terrain.png");
         GL11.glBindTexture(3553, var2);
         this.func_78442_d(p_78447_1_);
      }

      if(this.field_78455_a.field_71439_g.func_70094_T()) {
         var2 = MathHelper.func_76128_c(this.field_78455_a.field_71439_g.field_70165_t);
         int var3 = MathHelper.func_76128_c(this.field_78455_a.field_71439_g.field_70163_u);
         int var4 = MathHelper.func_76128_c(this.field_78455_a.field_71439_g.field_70161_v);
         int var5 = this.field_78455_a.field_71446_o.func_78341_b("/terrain.png");
         GL11.glBindTexture(3553, var5);
         int var6 = this.field_78455_a.field_71441_e.func_72798_a(var2, var3, var4);
         if(this.field_78455_a.field_71441_e.func_72809_s(var2, var3, var4)) {
            this.func_78446_a(p_78447_1_, Block.field_71973_m[var6].func_71851_a(2));
         } else {
            for(int var7 = 0; var7 < 8; ++var7) {
               float var8 = ((float)((var7 >> 0) % 2) - 0.5F) * this.field_78455_a.field_71439_g.field_70130_N * 0.9F;
               float var9 = ((float)((var7 >> 1) % 2) - 0.5F) * this.field_78455_a.field_71439_g.field_70131_O * 0.2F;
               float var10 = ((float)((var7 >> 2) % 2) - 0.5F) * this.field_78455_a.field_71439_g.field_70130_N * 0.9F;
               int var11 = MathHelper.func_76141_d((float)var2 + var8);
               int var12 = MathHelper.func_76141_d((float)var3 + var9);
               int var13 = MathHelper.func_76141_d((float)var4 + var10);
               if(this.field_78455_a.field_71441_e.func_72809_s(var11, var12, var13)) {
                  var6 = this.field_78455_a.field_71441_e.func_72798_a(var11, var12, var13);
               }
            }
         }

         if(Block.field_71973_m[var6] != null) {
            this.func_78446_a(p_78447_1_, Block.field_71973_m[var6].func_71851_a(2));
         }
      }

      if(this.field_78455_a.field_71439_g.func_70055_a(Material.field_76244_g)) {
         var2 = this.field_78455_a.field_71446_o.func_78341_b("/misc/water.png");
         GL11.glBindTexture(3553, var2);
         this.func_78448_c(p_78447_1_);
      }

      GL11.glEnable(3008);
   }

   private void func_78446_a(float p_78446_1_, int p_78446_2_) {
      Tessellator var3 = Tessellator.field_78398_a;
      this.field_78455_a.field_71439_g.func_70013_c(p_78446_1_);
      float var4 = 0.1F;
      GL11.glColor4f(var4, var4, var4, 0.5F);
      GL11.glPushMatrix();
      float var5 = -1.0F;
      float var6 = 1.0F;
      float var7 = -1.0F;
      float var8 = 1.0F;
      float var9 = -0.5F;
      float var10 = 0.0078125F;
      float var11 = (float)(p_78446_2_ % 16) / 256.0F - var10;
      float var12 = ((float)(p_78446_2_ % 16) + 15.99F) / 256.0F + var10;
      float var13 = (float)(p_78446_2_ / 16) / 256.0F - var10;
      float var14 = ((float)(p_78446_2_ / 16) + 15.99F) / 256.0F + var10;
      var3.func_78382_b();
      var3.func_78374_a((double)var5, (double)var7, (double)var9, (double)var12, (double)var14);
      var3.func_78374_a((double)var6, (double)var7, (double)var9, (double)var11, (double)var14);
      var3.func_78374_a((double)var6, (double)var8, (double)var9, (double)var11, (double)var13);
      var3.func_78374_a((double)var5, (double)var8, (double)var9, (double)var12, (double)var13);
      var3.func_78381_a();
      GL11.glPopMatrix();
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
   }

   private void func_78448_c(float p_78448_1_) {
      Tessellator var2 = Tessellator.field_78398_a;
      float var3 = this.field_78455_a.field_71439_g.func_70013_c(p_78448_1_);
      GL11.glColor4f(var3, var3, var3, 0.5F);
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glPushMatrix();
      float var4 = 4.0F;
      float var5 = -1.0F;
      float var6 = 1.0F;
      float var7 = -1.0F;
      float var8 = 1.0F;
      float var9 = -0.5F;
      float var10 = -this.field_78455_a.field_71439_g.field_70177_z / 64.0F;
      float var11 = this.field_78455_a.field_71439_g.field_70125_A / 64.0F;
      var2.func_78382_b();
      var2.func_78374_a((double)var5, (double)var7, (double)var9, (double)(var4 + var10), (double)(var4 + var11));
      var2.func_78374_a((double)var6, (double)var7, (double)var9, (double)(0.0F + var10), (double)(var4 + var11));
      var2.func_78374_a((double)var6, (double)var8, (double)var9, (double)(0.0F + var10), (double)(0.0F + var11));
      var2.func_78374_a((double)var5, (double)var8, (double)var9, (double)(var4 + var10), (double)(0.0F + var11));
      var2.func_78381_a();
      GL11.glPopMatrix();
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      GL11.glDisable(3042);
   }

   private void func_78442_d(float p_78442_1_) {
      Tessellator var2 = Tessellator.field_78398_a;
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.9F);
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      float var3 = 1.0F;

      for(int var4 = 0; var4 < 2; ++var4) {
         GL11.glPushMatrix();
         int var5 = Block.field_72067_ar.field_72059_bZ + var4 * 16;
         int var6 = (var5 & 15) << 4;
         int var7 = var5 & 240;
         float var8 = (float)var6 / 256.0F;
         float var9 = ((float)var6 + 15.99F) / 256.0F;
         float var10 = (float)var7 / 256.0F;
         float var11 = ((float)var7 + 15.99F) / 256.0F;
         float var12 = (0.0F - var3) / 2.0F;
         float var13 = var12 + var3;
         float var14 = 0.0F - var3 / 2.0F;
         float var15 = var14 + var3;
         float var16 = -0.5F;
         GL11.glTranslatef((float)(-(var4 * 2 - 1)) * 0.24F, -0.3F, 0.0F);
         GL11.glRotatef((float)(var4 * 2 - 1) * 10.0F, 0.0F, 1.0F, 0.0F);
         var2.func_78382_b();
         var2.func_78374_a((double)var12, (double)var14, (double)var16, (double)var9, (double)var11);
         var2.func_78374_a((double)var13, (double)var14, (double)var16, (double)var8, (double)var11);
         var2.func_78374_a((double)var13, (double)var15, (double)var16, (double)var8, (double)var10);
         var2.func_78374_a((double)var12, (double)var15, (double)var16, (double)var9, (double)var10);
         var2.func_78381_a();
         GL11.glPopMatrix();
      }

      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      GL11.glDisable(3042);
   }

   public void func_78441_a() {
      this.field_78451_d = this.field_78454_c;
      EntityClientPlayerMP var1 = this.field_78455_a.field_71439_g;
      ItemStack var2 = var1.field_71071_by.func_70448_g();
      boolean var3 = this.field_78450_g == var1.field_71071_by.field_70461_c && var2 == this.field_78453_b;
      if(this.field_78453_b == null && var2 == null) {
         var3 = true;
      }

      if(var2 != null && this.field_78453_b != null && var2 != this.field_78453_b && var2.field_77993_c == this.field_78453_b.field_77993_c && var2.func_77960_j() == this.field_78453_b.func_77960_j()) {
         this.field_78453_b = var2;
         var3 = true;
      }

      float var4 = 0.4F;
      float var5 = var3?1.0F:0.0F;
      float var6 = var5 - this.field_78454_c;
      if(var6 < -var4) {
         var6 = -var4;
      }

      if(var6 > var4) {
         var6 = var4;
      }

      this.field_78454_c += var6;
      if(this.field_78454_c < 0.1F) {
         this.field_78453_b = var2;
         this.field_78450_g = var1.field_71071_by.field_70461_c;
      }

   }

   public void func_78444_b() {
      this.field_78454_c = 0.0F;
   }

   public void func_78445_c() {
      this.field_78454_c = 0.0F;
   }
}
