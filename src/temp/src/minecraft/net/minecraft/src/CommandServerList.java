package net.minecraft.src;

import net.minecraft.server.MinecraftServer;
import net.minecraft.src.CommandBase;
import net.minecraft.src.ICommandSender;

public class CommandServerList extends CommandBase {

   public String func_71517_b() {
      return "list";
   }

   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) {
      p_71515_1_.func_70006_a(p_71515_1_.func_70004_a("commands.players.list", new Object[]{Integer.valueOf(MinecraftServer.func_71276_C().func_71233_x()), Integer.valueOf(MinecraftServer.func_71276_C().func_71275_y())}));
      p_71515_1_.func_70006_a(MinecraftServer.func_71276_C().func_71203_ab().func_72398_c());
   }
}
