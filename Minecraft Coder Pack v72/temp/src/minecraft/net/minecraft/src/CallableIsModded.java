package net.minecraft.src;

import java.util.concurrent.Callable;
import net.minecraft.client.ClientBrandRetriever;
import net.minecraft.client.Minecraft;
import net.minecraft.src.IntegratedServer;

class CallableIsModded implements Callable {

   // $FF: synthetic field
   final IntegratedServer field_76972_a;


   CallableIsModded(IntegratedServer p_i3123_1_) {
      this.field_76972_a = p_i3123_1_;
   }

   public String func_76971_a() {
      String var1 = ClientBrandRetriever.getClientModName();
      if(!var1.equals("vanilla")) {
         return "Definitely; \'" + var1 + "\'";
      } else {
         var1 = this.field_76972_a.getServerModName();
         return !var1.equals("vanilla")?"Definitely; \'" + var1 + "\'":(Minecraft.class.getSigners() == null?"Very likely":"Probably not");
      }
   }

   // $FF: synthetic method
   public Object call() {
      return this.func_76971_a();
   }
}
