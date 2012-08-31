package net.minecraft.src;

import java.util.concurrent.Callable;
import net.minecraft.src.DedicatedServer;

class CallableType implements Callable {

   // $FF: synthetic field
   final DedicatedServer field_71743_a;


   CallableType(DedicatedServer p_i3381_1_) {
      this.field_71743_a = p_i3381_1_;
   }

   public String func_71742_a() {
      return "Dedicated Server";
   }

   // $FF: synthetic method
   public Object call() {
      return this.func_71742_a();
   }
}
