package net.minecraft.src;

import java.util.concurrent.Callable;
import net.minecraft.src.World;

class CallableLvl1 implements Callable {

   // $FF: synthetic field
   final World field_77485_a;


   CallableLvl1(World p_i3728_1_) {
      this.field_77485_a = p_i3728_1_;
   }

   public String func_77484_a() {
      return this.field_77485_a.field_72996_f.size() + " total; " + this.field_77485_a.field_72996_f.toString();
   }

   // $FF: synthetic method
   public Object call() {
      return this.func_77484_a();
   }
}
