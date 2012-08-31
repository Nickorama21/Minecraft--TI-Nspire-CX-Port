package net.minecraft.src;

import java.awt.Component;
import org.lwjgl.input.Mouse;

public class MouseHelper {

   private Component field_74376_c;
   public int field_74377_a;
   public int field_74375_b;


   public MouseHelper(Component p_i3015_1_) {
      this.field_74376_c = p_i3015_1_;
   }

   public void func_74372_a() {
      Mouse.setGrabbed(true);
      this.field_74377_a = 0;
      this.field_74375_b = 0;
   }

   public void func_74373_b() {
      Mouse.setCursorPosition(this.field_74376_c.getWidth() / 2, this.field_74376_c.getHeight() / 2);
      Mouse.setGrabbed(false);
   }

   public void func_74374_c() {
      this.field_74377_a = Mouse.getDX();
      this.field_74375_b = Mouse.getDY();
   }
}
