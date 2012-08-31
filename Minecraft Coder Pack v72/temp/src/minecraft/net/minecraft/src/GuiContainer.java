package net.minecraft.src;

import java.util.Iterator;
import java.util.List;
import net.minecraft.src.Container;
import net.minecraft.src.GuiScreen;
import net.minecraft.src.InventoryPlayer;
import net.minecraft.src.ItemStack;
import net.minecraft.src.OpenGlHelper;
import net.minecraft.src.RenderHelper;
import net.minecraft.src.RenderItem;
import net.minecraft.src.Slot;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

public abstract class GuiContainer extends GuiScreen {

   protected static RenderItem field_74196_a = new RenderItem();
   protected int field_74194_b = 176;
   protected int field_74195_c = 166;
   public Container field_74193_d;
   protected int field_74198_m;
   protected int field_74197_n;


   public GuiContainer(Container p_i3079_1_) {
      this.field_74193_d = p_i3079_1_;
   }

   public void func_73866_w_() {
      super.func_73866_w_();
      this.field_73882_e.field_71439_g.field_71070_bA = this.field_74193_d;
      this.field_74198_m = (this.field_73880_f - this.field_74194_b) / 2;
      this.field_74197_n = (this.field_73881_g - this.field_74195_c) / 2;
   }

   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
      this.func_73873_v_();
      int var4 = this.field_74198_m;
      int var5 = this.field_74197_n;
      this.func_74185_a(p_73863_3_, p_73863_1_, p_73863_2_);
      GL11.glDisable('\u803a');
      RenderHelper.func_74518_a();
      GL11.glDisable(2896);
      GL11.glDisable(2929);
      super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
      RenderHelper.func_74520_c();
      GL11.glPushMatrix();
      GL11.glTranslatef((float)var4, (float)var5, 0.0F);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      GL11.glEnable('\u803a');
      Slot var6 = null;
      short var7 = 240;
      short var8 = 240;
      OpenGlHelper.func_77475_a(OpenGlHelper.field_77476_b, (float)var7 / 1.0F, (float)var8 / 1.0F);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

      for(int var11 = 0; var11 < this.field_74193_d.field_75151_b.size(); ++var11) {
         Slot var14 = (Slot)this.field_74193_d.field_75151_b.get(var11);
         this.func_74192_a(var14);
         if(this.func_74186_a(var14, p_73863_1_, p_73863_2_)) {
            var6 = var14;
            GL11.glDisable(2896);
            GL11.glDisable(2929);
            int var9 = var14.field_75223_e;
            int var10 = var14.field_75221_f;
            this.func_73733_a(var9, var10, var9 + 16, var10 + 16, -2130706433, -2130706433);
            GL11.glEnable(2896);
            GL11.glEnable(2929);
         }
      }

      this.func_74189_g();
      InventoryPlayer var12 = this.field_73882_e.field_71439_g.field_71071_by;
      if(var12.func_70445_o() != null) {
         GL11.glTranslatef(0.0F, 0.0F, 32.0F);
         this.field_73735_i = 200.0F;
         field_74196_a.field_77023_b = 200.0F;
         field_74196_a.func_77015_a(this.field_73886_k, this.field_73882_e.field_71446_o, var12.func_70445_o(), p_73863_1_ - var4 - 8, p_73863_2_ - var5 - 8);
         field_74196_a.func_77021_b(this.field_73886_k, this.field_73882_e.field_71446_o, var12.func_70445_o(), p_73863_1_ - var4 - 8, p_73863_2_ - var5 - 8);
         this.field_73735_i = 0.0F;
         field_74196_a.field_77023_b = 0.0F;
      }

      if(var12.func_70445_o() == null && var6 != null && var6.func_75216_d()) {
         ItemStack var13 = var6.func_75211_c();
         this.func_74184_a(var13, p_73863_1_ - var4, p_73863_2_ - var5);
      }

      GL11.glPopMatrix();
      GL11.glEnable(2896);
      GL11.glEnable(2929);
      RenderHelper.func_74519_b();
   }

   protected void func_74184_a(ItemStack p_74184_1_, int p_74184_2_, int p_74184_3_) {
      GL11.glDisable('\u803a');
      RenderHelper.func_74518_a();
      GL11.glDisable(2896);
      GL11.glDisable(2929);
      List var4 = p_74184_1_.func_77968_r();
      if(!var4.isEmpty()) {
         int var5 = 0;
         Iterator var6 = var4.iterator();

         while(var6.hasNext()) {
            String var7 = (String)var6.next();
            int var8 = this.field_73886_k.func_78256_a(var7);
            if(var8 > var5) {
               var5 = var8;
            }
         }

         int var15 = p_74184_2_ + 12;
         int var16 = p_74184_3_ - 12;
         int var9 = 8;
         if(var4.size() > 1) {
            var9 += 2 + (var4.size() - 1) * 10;
         }

         this.field_73735_i = 300.0F;
         field_74196_a.field_77023_b = 300.0F;
         int var10 = -267386864;
         this.func_73733_a(var15 - 3, var16 - 4, var15 + var5 + 3, var16 - 3, var10, var10);
         this.func_73733_a(var15 - 3, var16 + var9 + 3, var15 + var5 + 3, var16 + var9 + 4, var10, var10);
         this.func_73733_a(var15 - 3, var16 - 3, var15 + var5 + 3, var16 + var9 + 3, var10, var10);
         this.func_73733_a(var15 - 4, var16 - 3, var15 - 3, var16 + var9 + 3, var10, var10);
         this.func_73733_a(var15 + var5 + 3, var16 - 3, var15 + var5 + 4, var16 + var9 + 3, var10, var10);
         int var11 = 1347420415;
         int var12 = (var11 & 16711422) >> 1 | var11 & -16777216;
         this.func_73733_a(var15 - 3, var16 - 3 + 1, var15 - 3 + 1, var16 + var9 + 3 - 1, var11, var12);
         this.func_73733_a(var15 + var5 + 2, var16 - 3 + 1, var15 + var5 + 3, var16 + var9 + 3 - 1, var11, var12);
         this.func_73733_a(var15 - 3, var16 - 3, var15 + var5 + 3, var16 - 3 + 1, var11, var11);
         this.func_73733_a(var15 - 3, var16 + var9 + 2, var15 + var5 + 3, var16 + var9 + 3, var12, var12);

         for(int var13 = 0; var13 < var4.size(); ++var13) {
            String var14 = (String)var4.get(var13);
            if(var13 == 0) {
               var14 = "\u00a7" + Integer.toHexString(p_74184_1_.func_77953_t().field_77937_e) + var14;
            } else {
               var14 = "\u00a77" + var14;
            }

            this.field_73886_k.func_78261_a(var14, var15, var16, -1);
            if(var13 == 0) {
               var16 += 2;
            }

            var16 += 10;
         }

         this.field_73735_i = 0.0F;
         field_74196_a.field_77023_b = 0.0F;
      }

   }

   protected void func_74190_a(String p_74190_1_, int p_74190_2_, int p_74190_3_) {
      GL11.glDisable('\u803a');
      RenderHelper.func_74518_a();
      GL11.glDisable(2896);
      GL11.glDisable(2929);
      int var4 = this.field_73886_k.func_78256_a(p_74190_1_);
      int var5 = p_74190_2_ + 12;
      int var6 = p_74190_3_ - 12;
      byte var8 = 8;
      this.field_73735_i = 300.0F;
      field_74196_a.field_77023_b = 300.0F;
      int var9 = -267386864;
      this.func_73733_a(var5 - 3, var6 - 4, var5 + var4 + 3, var6 - 3, var9, var9);
      this.func_73733_a(var5 - 3, var6 + var8 + 3, var5 + var4 + 3, var6 + var8 + 4, var9, var9);
      this.func_73733_a(var5 - 3, var6 - 3, var5 + var4 + 3, var6 + var8 + 3, var9, var9);
      this.func_73733_a(var5 - 4, var6 - 3, var5 - 3, var6 + var8 + 3, var9, var9);
      this.func_73733_a(var5 + var4 + 3, var6 - 3, var5 + var4 + 4, var6 + var8 + 3, var9, var9);
      int var10 = 1347420415;
      int var11 = (var10 & 16711422) >> 1 | var10 & -16777216;
      this.func_73733_a(var5 - 3, var6 - 3 + 1, var5 - 3 + 1, var6 + var8 + 3 - 1, var10, var11);
      this.func_73733_a(var5 + var4 + 2, var6 - 3 + 1, var5 + var4 + 3, var6 + var8 + 3 - 1, var10, var11);
      this.func_73733_a(var5 - 3, var6 - 3, var5 + var4 + 3, var6 - 3 + 1, var10, var10);
      this.func_73733_a(var5 - 3, var6 + var8 + 2, var5 + var4 + 3, var6 + var8 + 3, var11, var11);
      this.field_73886_k.func_78261_a(p_74190_1_, var5, var6, -1);
      this.field_73735_i = 0.0F;
      field_74196_a.field_77023_b = 0.0F;
   }

   protected void func_74189_g() {}

   protected abstract void func_74185_a(float var1, int var2, int var3);

   private void func_74192_a(Slot p_74192_1_) {
      int var2 = p_74192_1_.field_75223_e;
      int var3 = p_74192_1_.field_75221_f;
      ItemStack var4 = p_74192_1_.func_75211_c();
      boolean var5 = false;
      this.field_73735_i = 100.0F;
      field_74196_a.field_77023_b = 100.0F;
      if(var4 == null) {
         int var6 = p_74192_1_.func_75212_b();
         if(var6 >= 0) {
            GL11.glDisable(2896);
            this.field_73882_e.field_71446_o.func_78342_b(this.field_73882_e.field_71446_o.func_78341_b("/gui/items.png"));
            this.func_73729_b(var2, var3, var6 % 16 * 16, var6 / 16 * 16, 16, 16);
            GL11.glEnable(2896);
            var5 = true;
         }
      }

      if(!var5) {
         GL11.glEnable(2929);
         field_74196_a.func_77015_a(this.field_73886_k, this.field_73882_e.field_71446_o, var4, var2, var3);
         field_74196_a.func_77021_b(this.field_73886_k, this.field_73882_e.field_71446_o, var4, var2, var3);
      }

      field_74196_a.field_77023_b = 0.0F;
      this.field_73735_i = 0.0F;
   }

   private Slot func_74187_b(int p_74187_1_, int p_74187_2_) {
      for(int var3 = 0; var3 < this.field_74193_d.field_75151_b.size(); ++var3) {
         Slot var4 = (Slot)this.field_74193_d.field_75151_b.get(var3);
         if(this.func_74186_a(var4, p_74187_1_, p_74187_2_)) {
            return var4;
         }
      }

      return null;
   }

   protected void func_73864_a(int p_73864_1_, int p_73864_2_, int p_73864_3_) {
      super.func_73864_a(p_73864_1_, p_73864_2_, p_73864_3_);
      if(p_73864_3_ == 0 || p_73864_3_ == 1) {
         Slot var4 = this.func_74187_b(p_73864_1_, p_73864_2_);
         int var5 = this.field_74198_m;
         int var6 = this.field_74197_n;
         boolean var7 = p_73864_1_ < var5 || p_73864_2_ < var6 || p_73864_1_ >= var5 + this.field_74194_b || p_73864_2_ >= var6 + this.field_74195_c;
         int var8 = -1;
         if(var4 != null) {
            var8 = var4.field_75222_d;
         }

         if(var7) {
            var8 = -999;
         }

         if(var8 != -1) {
            boolean var9 = var8 != -999 && (Keyboard.isKeyDown(42) || Keyboard.isKeyDown(54));
            this.func_74191_a(var4, var8, p_73864_3_, var9);
         }
      }

   }

   private boolean func_74186_a(Slot p_74186_1_, int p_74186_2_, int p_74186_3_) {
      return this.func_74188_c(p_74186_1_.field_75223_e, p_74186_1_.field_75221_f, 16, 16, p_74186_2_, p_74186_3_);
   }

   protected boolean func_74188_c(int p_74188_1_, int p_74188_2_, int p_74188_3_, int p_74188_4_, int p_74188_5_, int p_74188_6_) {
      int var7 = this.field_74198_m;
      int var8 = this.field_74197_n;
      p_74188_5_ -= var7;
      p_74188_6_ -= var8;
      return p_74188_5_ >= p_74188_1_ - 1 && p_74188_5_ < p_74188_1_ + p_74188_3_ + 1 && p_74188_6_ >= p_74188_2_ - 1 && p_74188_6_ < p_74188_2_ + p_74188_4_ + 1;
   }

   protected void func_74191_a(Slot p_74191_1_, int p_74191_2_, int p_74191_3_, boolean p_74191_4_) {
      if(p_74191_1_ != null) {
         p_74191_2_ = p_74191_1_.field_75222_d;
      }

      this.field_73882_e.field_71442_b.func_78753_a(this.field_74193_d.field_75152_c, p_74191_2_, p_74191_3_, p_74191_4_, this.field_73882_e.field_71439_g);
   }

   protected void func_73869_a(char p_73869_1_, int p_73869_2_) {
      if(p_73869_2_ == 1 || p_73869_2_ == this.field_73882_e.field_71474_y.field_74315_B.field_74512_d) {
         this.field_73882_e.field_71439_g.func_71053_j();
      }

   }

   public void func_73874_b() {
      if(this.field_73882_e.field_71439_g != null) {
         this.field_74193_d.func_75134_a(this.field_73882_e.field_71439_g);
      }
   }

   public boolean func_73868_f() {
      return false;
   }

   public void func_73876_c() {
      super.func_73876_c();
      if(!this.field_73882_e.field_71439_g.func_70089_S() || this.field_73882_e.field_71439_g.field_70128_L) {
         this.field_73882_e.field_71439_g.func_71053_j();
      }

   }

}
