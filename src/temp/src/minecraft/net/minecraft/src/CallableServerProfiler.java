package net.minecraft.src;

import java.util.concurrent.Callable;
import net.minecraft.server.MinecraftServer;

public class CallableServerProfiler implements Callable {

   // $FF: synthetic field
   final MinecraftServer field_74272_a;


   public CallableServerProfiler(MinecraftServer p_i3373_1_) {
      this.field_74272_a = p_i3373_1_;
   }

   public String func_74271_a() {
      return this.field_74272_a.field_71304_b.field_76327_a?this.field_74272_a.field_71304_b.func_76322_c():"N/A (disabled)";
   }

   // $FF: synthetic method
   public Object call() {
      return this.func_74271_a();
   }
}
