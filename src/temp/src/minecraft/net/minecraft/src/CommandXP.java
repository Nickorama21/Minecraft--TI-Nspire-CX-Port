package net.minecraft.src;

import java.util.List;
import net.minecraft.server.MinecraftServer;
import net.minecraft.src.CommandBase;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EntityPlayerMP;
import net.minecraft.src.ICommandSender;
import net.minecraft.src.PlayerNotFoundException;
import net.minecraft.src.WrongUsageException;

public class CommandXP extends CommandBase {

   public String func_71517_b() {
      return "xp";
   }

   public String func_71518_a(ICommandSender p_71518_1_) {
      return p_71518_1_.func_70004_a("commands.xp.usage", new Object[0]);
   }

   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) {
      if(p_71515_2_.length > 0) {
         int var4 = func_71532_a(p_71515_1_, p_71515_2_[0], 0, 5000);
         EntityPlayer var3;
         if(p_71515_2_.length > 1) {
            var3 = this.func_71543_a(p_71515_2_[1]);
         } else {
            var3 = func_71521_c(p_71515_1_);
         }

         var3.func_71023_q(var4);
         func_71522_a(p_71515_1_, "commands.xp.success", new Object[]{Integer.valueOf(var4), var3.func_70023_ak()});
      } else {
         throw new WrongUsageException("commands.xp.usage", new Object[0]);
      }
   }

   public List func_71516_a(ICommandSender p_71516_1_, String[] p_71516_2_) {
      return p_71516_2_.length == 2?func_71530_a(p_71516_2_, this.func_71542_c()):null;
   }

   protected EntityPlayer func_71543_a(String p_71543_1_) {
      EntityPlayerMP var2 = MinecraftServer.func_71276_C().func_71203_ab().func_72361_f(p_71543_1_);
      if(var2 == null) {
         throw new PlayerNotFoundException();
      } else {
         return var2;
      }
   }

   protected String[] func_71542_c() {
      return MinecraftServer.func_71276_C().func_71213_z();
   }
}
