package net.minecraft.src;

import net.minecraft.src.CommandBase;
import net.minecraft.src.DamageSource;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.ICommandSender;

public class CommandKill extends CommandBase {

   public String func_71517_b() {
      return "kill";
   }

   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) {
      EntityPlayer var3 = func_71521_c(p_71515_1_);
      var3.func_70097_a(DamageSource.field_76380_i, 1000);
      p_71515_1_.func_70006_a("Ouch. That look like it hurt.");
   }
}
