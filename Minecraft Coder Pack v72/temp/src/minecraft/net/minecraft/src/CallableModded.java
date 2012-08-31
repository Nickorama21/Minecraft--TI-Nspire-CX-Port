package net.minecraft.src;

import java.util.concurrent.Callable;
import net.minecraft.client.ClientBrandRetriever;
import net.minecraft.client.Minecraft;

public class CallableModded implements Callable {

   // $FF: synthetic field
   final Minecraft field_74416_a;


   public CallableModded(Minecraft p_i3006_1_) {
      this.field_74416_a = p_i3006_1_;
   }

   public String func_74415_a() {
      String var1 = ClientBrandRetriever.getClientModName();
      return !var1.equals("vanilla")?"Definitely; \'" + var1 + "\'":(Minecraft.class.getSigners() == null?"Very likely":"Probably not");
   }

   // $FF: synthetic method
   public Object call() {
      return this.func_74415_a();
   }
}
