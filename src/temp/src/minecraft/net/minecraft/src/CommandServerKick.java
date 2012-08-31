package net.minecraft.src;

import java.util.List;
import net.minecraft.server.MinecraftServer;
import net.minecraft.src.CommandBase;
import net.minecraft.src.EntityPlayerMP;
import net.minecraft.src.ICommandSender;
import net.minecraft.src.PlayerNotFoundException;
import net.minecraft.src.WrongUsageException;

public class CommandServerKick extends CommandBase {

   public String func_71517_b() {
      return "kick";
   }

   public String func_71518_a(ICommandSender p_71518_1_) {
      return p_71518_1_.func_70004_a("commands.kick.usage", new Object[0]);
   }

   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) {
      if(p_71515_2_.length > 0 && p_71515_2_[0].length() > 1) {
         EntityPlayerMP var3 = MinecraftServer.func_71276_C().func_71203_ab().func_72361_f(p_71515_2_[0]);
         String var4 = "Kicked by an operator.";
         boolean var5 = false;
         if(var3 == null) {
            throw new PlayerNotFoundException();
         } else {
            if(p_71515_2_.length >= 2) {
               var4 = func_71520_a(p_71515_2_, 1);
               var5 = true;
            }

            var3.field_71135_a.func_72565_c(var4);
            if(var5) {
               func_71522_a(p_71515_1_, "commands.kick.success.reason", new Object[]{var3.func_70023_ak(), var4});
            } else {
               func_71522_a(p_71515_1_, "commands.kick.success", new Object[]{var3.func_70023_ak()});
            }

         }
      } else {
         throw new WrongUsageException("commands.kick.usage", new Object[0]);
      }
   }

   public List func_71516_a(ICommandSender p_71516_1_, String[] p_71516_2_) {
      return p_71516_2_.length >= 1?func_71530_a(p_71516_2_, MinecraftServer.func_71276_C().func_71213_z()):null;
   }
}
