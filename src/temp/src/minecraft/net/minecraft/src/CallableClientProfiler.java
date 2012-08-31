package net.minecraft.src;

import java.util.concurrent.Callable;
import net.minecraft.client.Minecraft;

public class CallableClientProfiler implements Callable {

   // $FF: synthetic field
   final Minecraft field_74500_a;


   public CallableClientProfiler(Minecraft p_i3017_1_) {
      this.field_74500_a = p_i3017_1_;
   }

   public String func_74499_a() {
      return this.field_74500_a.field_71424_I.field_76327_a?this.field_74500_a.field_71424_I.func_76322_c():"N/A (disabled)";
   }

   // $FF: synthetic method
   public Object call() {
      return this.func_74499_a();
   }
}
