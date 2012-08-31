package net.minecraft.src;

import net.minecraft.src.Vec3Pool;

final class Vec3LocalPool extends ThreadLocal {

   protected Vec3Pool func_72342_a() {
      return new Vec3Pool(300, 2000);
   }

   // $FF: synthetic method
   protected Object initialValue() {
      return this.func_72342_a();
   }
}
