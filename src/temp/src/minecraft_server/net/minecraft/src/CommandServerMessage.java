package net.minecraft.src;

import java.util.Arrays;
import java.util.List;
import net.minecraft.server.MinecraftServer;
import net.minecraft.src.CommandBase;
import net.minecraft.src.EntityPlayerMP;
import net.minecraft.src.ICommandSender;
import net.minecraft.src.PlayerNotFoundException;
import net.minecraft.src.WrongUsageException;

public class CommandServerMessage extends CommandBase {

   public boolean func_71519_b(ICommandSender p_71519_1_) {
      return (!MinecraftServer.func_71276_C().func_71264_H() || MinecraftServer.func_71276_C().func_71233_x() > 1) && super.func_71519_b(p_71519_1_);
   }

   public List func_71514_a() {
      return Arrays.asList(new String[]{"w", "msg"});
   }

   public String func_71517_b() {
      return "tell";
   }

   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) {
      if(p_71515_2_.length < 2) {
         throw new WrongUsageException("commands.message.usage", new Object[0]);
      } else {
         EntityPlayerMP var3 = MinecraftServer.func_71276_C().func_71203_ab().func_72361_f(p_71515_2_[0]);
         if(var3 == null) {
            throw new PlayerNotFoundException();
         } else if(var3 == p_71515_1_) {
            throw new PlayerNotFoundException("commands.message.sameTarget", new Object[0]);
         } else {
            String var4 = func_71520_a(p_71515_2_, 1);
            var3.func_70006_a("\u00a77\u00a7o" + var3.func_70004_a("commands.message.display.incoming", new Object[]{p_71515_1_.func_70005_c_(), var4}));
            p_71515_1_.func_70006_a("\u00a77\u00a7o" + p_71515_1_.func_70004_a("commands.message.display.outgoing", new Object[]{var3.func_70005_c_(), var4}));
         }
      }
   }

   public List func_71516_a(ICommandSender p_71516_1_, String[] p_71516_2_) {
      return func_71530_a(p_71516_2_, MinecraftServer.func_71276_C().func_71213_z());
   }
}
