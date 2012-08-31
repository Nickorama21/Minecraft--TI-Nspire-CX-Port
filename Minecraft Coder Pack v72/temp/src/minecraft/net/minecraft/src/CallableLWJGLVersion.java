package net.minecraft.src;

import java.util.concurrent.Callable;
import net.minecraft.client.Minecraft;
import org.lwjgl.Sys;

public class CallableLWJGLVersion implements Callable {

   // $FF: synthetic field
   final Minecraft field_74421_a;


   public CallableLWJGLVersion(Minecraft p_i3002_1_) {
      this.field_74421_a = p_i3002_1_;
   }

   public String func_74420_a() {
      return Sys.getVersion();
   }

   // $FF: synthetic method
   public Object call() {
      return this.func_74420_a();
   }
}
