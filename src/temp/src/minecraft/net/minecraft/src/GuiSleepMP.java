package net.minecraft.src;

import net.minecraft.src.GuiButton;
import net.minecraft.src.GuiChat;
import net.minecraft.src.NetClientHandler;
import net.minecraft.src.Packet19EntityAction;
import net.minecraft.src.StringTranslate;

public class GuiSleepMP extends GuiChat {

   public void func_73866_w_() {
      super.func_73866_w_();
      StringTranslate var1 = StringTranslate.func_74808_a();
      this.field_73887_h.add(new GuiButton(1, this.field_73880_f / 2 - 100, this.field_73881_g - 40, var1.func_74805_b("multiplayer.stopSleeping")));
   }

   protected void func_73869_a(char p_73869_1_, int p_73869_2_) {
      if(p_73869_2_ == 1) {
         this.func_73906_g();
      } else if(p_73869_2_ == 28) {
         String var3 = this.field_73901_a.func_73781_b().trim();
         if(var3.length() > 0) {
            this.field_73882_e.field_71439_g.func_71165_d(var3);
         }

         this.field_73901_a.func_73782_a("");
         this.field_73882_e.field_71456_v.func_73827_b().func_73764_c();
      } else {
         super.func_73869_a(p_73869_1_, p_73869_2_);
      }

   }

   protected void func_73875_a(GuiButton p_73875_1_) {
      if(p_73875_1_.field_73741_f == 1) {
         this.func_73906_g();
      } else {
         super.func_73875_a(p_73875_1_);
      }

   }

   private void func_73906_g() {
      NetClientHandler var1 = this.field_73882_e.field_71439_g.field_71174_a;
      var1.func_72552_c(new Packet19EntityAction(this.field_73882_e.field_71439_g, 3));
   }
}
