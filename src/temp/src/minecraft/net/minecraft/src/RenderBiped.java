package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.ModelBiped;
import net.minecraft.src.RenderBlocks;
import net.minecraft.src.RenderLiving;
import org.lwjgl.opengl.GL11;

public class RenderBiped extends RenderLiving {

   protected ModelBiped field_77071_a;
   protected float field_77070_b;


   public RenderBiped(ModelBiped p_i3202_1_, float p_i3202_2_) {
      this(p_i3202_1_, p_i3202_2_, 1.0F);
      this.field_77071_a = p_i3202_1_;
   }

   public RenderBiped(ModelBiped p_i3203_1_, float p_i3203_2_, float p_i3203_3_) {
      super(p_i3203_1_, p_i3203_2_);
      this.field_77071_a = p_i3203_1_;
      this.field_77070_b = p_i3203_3_;
   }

   protected void func_77029_c(EntityLiving p_77029_1_, float p_77029_2_) {
      super.func_77029_c(p_77029_1_, p_77029_2_);
      ItemStack var3 = p_77029_1_.func_70694_bm();
      if(var3 != null) {
         GL11.glPushMatrix();
         this.field_77071_a.field_78112_f.func_78794_c(0.0625F);
         GL11.glTranslatef(-0.0625F, 0.4375F, 0.0625F);
         float var4;
         if(var3.field_77993_c < 256 && RenderBlocks.func_78597_b(Block.field_71973_m[var3.field_77993_c].func_71857_b())) {
            var4 = 0.5F;
            GL11.glTranslatef(0.0F, 0.1875F, -0.3125F);
            var4 *= 0.75F;
            GL11.glRotatef(20.0F, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
            GL11.glScalef(var4, -var4, var4);
         } else if(var3.field_77993_c == Item.field_77707_k.field_77779_bT) {
            var4 = 0.625F;
            GL11.glTranslatef(0.0F, 0.125F, 0.3125F);
            GL11.glRotatef(-20.0F, 0.0F, 1.0F, 0.0F);
            GL11.glScalef(var4, -var4, var4);
            GL11.glRotatef(-100.0F, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
         } else if(Item.field_77698_e[var3.field_77993_c].func_77662_d()) {
            var4 = 0.625F;
            GL11.glTranslatef(0.0F, 0.1875F, 0.0F);
            GL11.glScalef(var4, -var4, var4);
            GL11.glRotatef(-100.0F, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
         } else {
            var4 = 0.375F;
            GL11.glTranslatef(0.25F, 0.1875F, -0.1875F);
            GL11.glScalef(var4, var4, var4);
            GL11.glRotatef(60.0F, 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(20.0F, 0.0F, 0.0F, 1.0F);
         }

         this.field_76990_c.field_78721_f.func_78443_a(p_77029_1_, var3, 0);
         if(var3.func_77973_b().func_77623_v()) {
            this.field_76990_c.field_78721_f.func_78443_a(p_77029_1_, var3, 1);
         }

         GL11.glPopMatrix();
      }

   }
}
