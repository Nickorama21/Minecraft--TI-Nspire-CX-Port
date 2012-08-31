package net.minecraft.src;

import java.util.concurrent.Callable;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

public class CallableGLInfo implements Callable {

   // $FF: synthetic field
   final Minecraft field_74419_a;


   public CallableGLInfo(Minecraft p_i3016_1_) {
      this.field_74419_a = p_i3016_1_;
   }

   public String func_74418_a() {
      return GL11.glGetString(7937) + " GL version " + GL11.glGetString(7938) + ", " + GL11.glGetString(7936);
   }

   // $FF: synthetic method
   public Object call() {
      return this.func_74418_a();
   }
}
