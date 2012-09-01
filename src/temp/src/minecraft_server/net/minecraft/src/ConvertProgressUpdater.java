package net.minecraft.src;

import net.minecraft.server.MinecraftServer;
import net.minecraft.src.IProgressUpdate;

public class ConvertProgressUpdater implements IProgressUpdate {

   private long field_74266_b;
   // $FF: synthetic field
   final MinecraftServer field_74267_a;


   public ConvertProgressUpdater(MinecraftServer p_i3370_1_) {
      this.field_74267_a = p_i3370_1_;
      this.field_74266_b = System.currentTimeMillis();
   }

   public void func_73720_a(String p_73720_1_) {}

   public void func_73718_a(int p_73718_1_) {
      if(System.currentTimeMillis() - this.field_74266_b >= 1000L) {
         this.field_74266_b = System.currentTimeMillis();
         MinecraftServer.field_71306_a.info("Converting... " + p_73718_1_ + "%");
      }

   }

   public void func_73719_c(String p_73719_1_) {}
}
