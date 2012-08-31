package net.minecraft.src;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.minecraft.server.MinecraftServer;
import net.minecraft.src.NetServerHandler;

public abstract class NetworkListenThread {

   public static Logger field_71751_a = Logger.getLogger("Minecraft");
   private final MinecraftServer field_71750_c;
   private final List field_71748_d = Collections.synchronizedList(new ArrayList());
   public volatile boolean field_71749_b = false;


   public NetworkListenThread(MinecraftServer p_i3402_1_) throws IOException {
      this.field_71750_c = p_i3402_1_;
      this.field_71749_b = true;
   }

   public void func_71745_a(NetServerHandler p_71745_1_) {
      this.field_71748_d.add(p_71745_1_);
   }

   public void func_71744_a() {
      this.field_71749_b = false;
   }

   public void func_71747_b() {
      for(int var1 = 0; var1 < this.field_71748_d.size(); ++var1) {
         NetServerHandler var2 = (NetServerHandler)this.field_71748_d.get(var1);

         try {
            var2.func_72570_d();
         } catch (Exception var4) {
            field_71751_a.log(Level.WARNING, "Failed to handle packet: " + var4, var4);
            var2.func_72565_c("Internal server error");
         }

         if(var2.field_72576_c) {
            this.field_71748_d.remove(var1--);
         }

         var2.field_72575_b.func_74427_a();
      }

   }

   public MinecraftServer func_71746_d() {
      return this.field_71750_c;
   }

}
