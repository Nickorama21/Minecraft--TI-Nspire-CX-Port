package net.minecraft.src;

import net.minecraft.server.MinecraftServer;
import net.minecraft.src.CommandBase;
import net.minecraft.src.ICommandSender;

public class CommandToggleDownfall extends CommandBase {

   public String func_71517_b() {
      return "toggledownfall";
   }

   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) {
      this.func_71554_c();
      func_71522_a(p_71515_1_, "commands.downfall.success", new Object[0]);
   }

   protected void func_71554_c() {
      MinecraftServer.func_71276_C().field_71305_c[0].func_72913_w();
      MinecraftServer.func_71276_C().field_71305_c[0].func_72912_H().func_76069_a(true);
   }
}
