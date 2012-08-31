package net.minecraft.src;

import net.minecraft.src.IStatType;
import net.minecraft.src.StatBase;

final class StatTypeSimple implements IStatType {

   public String func_75843_a(int p_75843_1_) {
      return StatBase.func_75965_j().format((long)p_75843_1_);
   }
}
