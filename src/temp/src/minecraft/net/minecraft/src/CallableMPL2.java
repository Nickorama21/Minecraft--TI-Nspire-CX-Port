package net.minecraft.src;

import java.util.concurrent.Callable;
import net.minecraft.src.WorldClient;

class CallableMPL2 implements Callable {

   // $FF: synthetic field
   final WorldClient field_78835_a;


   CallableMPL2(WorldClient p_i3097_1_) {
      this.field_78835_a = p_i3097_1_;
   }

   public String func_78834_a() {
      return WorldClient.func_73030_b(this.field_78835_a).size() + " total; " + WorldClient.func_73030_b(this.field_78835_a).toString();
   }

   // $FF: synthetic method
   public Object call() {
      return this.func_78834_a();
   }
}
