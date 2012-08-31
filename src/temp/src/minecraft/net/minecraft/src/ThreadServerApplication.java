package net.minecraft.src;

import net.minecraft.server.MinecraftServer;

public class ThreadServerApplication extends Thread {

   // $FF: synthetic field
   final MinecraftServer field_73716_a;


   public ThreadServerApplication(MinecraftServer p_i3371_1_, String p_i3371_2_) {
      super(p_i3371_2_);
      this.field_73716_a = p_i3371_1_;
   }

   public void run() {
      this.field_73716_a.run();
   }
}
