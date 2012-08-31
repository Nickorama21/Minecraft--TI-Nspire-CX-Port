package net.minecraft.src;

import java.awt.Toolkit;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.src.EnumOS;
import net.minecraft.src.FontRenderer;
import net.minecraft.src.Gui;
import net.minecraft.src.GuiButton;
import net.minecraft.src.GuiParticle;
import net.minecraft.src.Tessellator;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

public class GuiScreen extends Gui {

   protected Minecraft field_73882_e;
   public int field_73880_f;
   public int field_73881_g;
   protected List field_73887_h = new ArrayList();
   public boolean field_73885_j = false;
   protected FontRenderer field_73886_k;
   public GuiParticle field_73884_l;
   private GuiButton field_73883_a = null;


   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
      Iterator var4 = this.field_73887_h.iterator();

      while(var4.hasNext()) {
         GuiButton var5 = (GuiButton)var4.next();
         var5.func_73737_a(this.field_73882_e, p_73863_1_, p_73863_2_);
      }

   }

   protected void func_73869_a(char p_73869_1_, int p_73869_2_) {
      if(p_73869_2_ == 1) {
         this.field_73882_e.func_71373_a((GuiScreen)null);
         this.field_73882_e.func_71381_h();
      }

   }

   public static String func_73870_l() {
      try {
         Transferable var0 = Toolkit.getDefaultToolkit().getSystemClipboard().getContents((Object)null);
         if(var0 != null && var0.isDataFlavorSupported(DataFlavor.stringFlavor)) {
            return (String)var0.getTransferData(DataFlavor.stringFlavor);
         }
      } catch (Exception var1) {
         ;
      }

      return "";
   }

   public static void func_73865_d(String p_73865_0_) {
      try {
         StringSelection var1 = new StringSelection(p_73865_0_);
         Toolkit.getDefaultToolkit().getSystemClipboard().setContents(var1, (ClipboardOwner)null);
      } catch (Exception var2) {
         ;
      }

   }

   protected void func_73864_a(int p_73864_1_, int p_73864_2_, int p_73864_3_) {
      if(p_73864_3_ == 0) {
         for(int var4 = 0; var4 < this.field_73887_h.size(); ++var4) {
            GuiButton var5 = (GuiButton)this.field_73887_h.get(var4);
            if(var5.func_73736_c(this.field_73882_e, p_73864_1_, p_73864_2_)) {
               this.field_73883_a = var5;
               this.field_73882_e.field_71416_A.func_77366_a("random.click", 1.0F, 1.0F);
               this.func_73875_a(var5);
            }
         }
      }

   }

   protected void func_73879_b(int p_73879_1_, int p_73879_2_, int p_73879_3_) {
      if(this.field_73883_a != null && p_73879_3_ == 0) {
         this.field_73883_a.func_73740_a(p_73879_1_, p_73879_2_);
         this.field_73883_a = null;
      }

   }

   protected void func_73875_a(GuiButton p_73875_1_) {}

   public void func_73872_a(Minecraft p_73872_1_, int p_73872_2_, int p_73872_3_) {
      this.field_73884_l = new GuiParticle(p_73872_1_);
      this.field_73882_e = p_73872_1_;
      this.field_73886_k = p_73872_1_.field_71466_p;
      this.field_73880_f = p_73872_2_;
      this.field_73881_g = p_73872_3_;
      this.field_73887_h.clear();
      this.func_73866_w_();
   }

   public void func_73866_w_() {}

   public void func_73862_m() {
      while(Mouse.next()) {
         this.func_73867_d();
      }

      while(Keyboard.next()) {
         this.func_73860_n();
      }

   }

   public void func_73867_d() {
      int var1;
      int var2;
      if(Mouse.getEventButtonState()) {
         var1 = Mouse.getEventX() * this.field_73880_f / this.field_73882_e.field_71443_c;
         var2 = this.field_73881_g - Mouse.getEventY() * this.field_73881_g / this.field_73882_e.field_71440_d - 1;
         this.func_73864_a(var1, var2, Mouse.getEventButton());
      } else {
         var1 = Mouse.getEventX() * this.field_73880_f / this.field_73882_e.field_71443_c;
         var2 = this.field_73881_g - Mouse.getEventY() * this.field_73881_g / this.field_73882_e.field_71440_d - 1;
         this.func_73879_b(var1, var2, Mouse.getEventButton());
      }

   }

   public void func_73860_n() {
      if(Keyboard.getEventKeyState()) {
         if(Keyboard.getEventKey() == 87) {
            this.field_73882_e.func_71352_k();
            return;
         }

         this.func_73869_a(Keyboard.getEventCharacter(), Keyboard.getEventKey());
      }

   }

   public void func_73876_c() {}

   public void func_73874_b() {}

   public void func_73873_v_() {
      this.func_73859_b(0);
   }

   public void func_73859_b(int p_73859_1_) {
      if(this.field_73882_e.field_71441_e != null) {
         this.func_73733_a(0, 0, this.field_73880_f, this.field_73881_g, -1072689136, -804253680);
      } else {
         this.func_73871_c(p_73859_1_);
      }

   }

   public void func_73871_c(int p_73871_1_) {
      GL11.glDisable(2896);
      GL11.glDisable(2912);
      Tessellator var2 = Tessellator.field_78398_a;
      GL11.glBindTexture(3553, this.field_73882_e.field_71446_o.func_78341_b("/gui/background.png"));
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      float var3 = 32.0F;
      var2.func_78382_b();
      var2.func_78378_d(4210752);
      var2.func_78374_a(0.0D, (double)this.field_73881_g, 0.0D, 0.0D, (double)((float)this.field_73881_g / var3 + (float)p_73871_1_));
      var2.func_78374_a((double)this.field_73880_f, (double)this.field_73881_g, 0.0D, (double)((float)this.field_73880_f / var3), (double)((float)this.field_73881_g / var3 + (float)p_73871_1_));
      var2.func_78374_a((double)this.field_73880_f, 0.0D, 0.0D, (double)((float)this.field_73880_f / var3), (double)p_73871_1_);
      var2.func_78374_a(0.0D, 0.0D, 0.0D, 0.0D, (double)p_73871_1_);
      var2.func_78381_a();
   }

   public boolean func_73868_f() {
      return true;
   }

   public void func_73878_a(boolean p_73878_1_, int p_73878_2_) {}

   public static boolean func_73861_o() {
      return Keyboard.isKeyDown(29) || Keyboard.isKeyDown(157) || Minecraft.func_71376_c() == EnumOS.MACOS && (Keyboard.isKeyDown(219) || Keyboard.isKeyDown(220));
   }

   public static boolean func_73877_p() {
      return Keyboard.isKeyDown(42) || Keyboard.isKeyDown(54);
   }
}
