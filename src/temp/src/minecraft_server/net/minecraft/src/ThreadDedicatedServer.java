package net.minecraft.src;

import net.minecraft.src.DedicatedServer;

public final class ThreadDedicatedServer extends Thread {

   // $FF: synthetic field
   final DedicatedServer field_79030_a;


   public ThreadDedicatedServer(DedicatedServer p_i4100_1_) {
      this.field_79030_a = p_i4100_1_;
   }

   public void run() {
      this.field_79030_a.func_71260_j();
   }
}
