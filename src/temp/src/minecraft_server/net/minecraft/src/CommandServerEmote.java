package net.minecraft.src;

import java.util.List;
import net.minecraft.server.MinecraftServer;
import net.minecraft.src.CommandBase;
import net.minecraft.src.ICommandSender;
import net.minecraft.src.Packet3Chat;
import net.minecraft.src.WrongUsageException;

public class CommandServerEmote extends CommandBase {

   public String func_71517_b() {
      return "me";
   }

   public String func_71518_a(ICommandSender p_71518_1_) {
      return p_71518_1_.func_70004_a("commands.me.usage", new Object[0]);
   }

   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) {
      if(p_71515_2_.length > 0) {
         String var3 = func_71520_a(p_71515_2_, 0);
         MinecraftServer.func_71276_C().func_71203_ab().func_72384_a(new Packet3Chat("* " + p_71515_1_.func_70005_c_() + " " + var3));
      } else {
         throw new WrongUsageException("commands.me.usage", new Object[0]);
      }
   }

   public List func_71516_a(ICommandSender p_71516_1_, String[] p_71516_2_) {
      return func_71530_a(p_71516_2_, MinecraftServer.func_71276_C().func_71213_z());
   }
}
