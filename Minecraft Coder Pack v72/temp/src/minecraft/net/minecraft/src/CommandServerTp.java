package net.minecraft.src;

import java.util.List;
import net.minecraft.server.MinecraftServer;
import net.minecraft.src.CommandBase;
import net.minecraft.src.EntityPlayerMP;
import net.minecraft.src.ICommandSender;
import net.minecraft.src.PlayerNotFoundException;
import net.minecraft.src.WrongUsageException;

public class CommandServerTp extends CommandBase {

   public String func_71517_b() {
      return "tp";
   }

   public String func_71518_a(ICommandSender p_71518_1_) {
      return p_71518_1_.func_70004_a("commands.tp.usage", new Object[0]);
   }

   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) {
      if(p_71515_2_.length < 1) {
         throw new WrongUsageException("commands.tp.usage", new Object[0]);
      } else {
         MinecraftServer var3 = MinecraftServer.func_71276_C();
         EntityPlayerMP var4;
         if(p_71515_2_.length != 2 && p_71515_2_.length != 4) {
            var4 = (EntityPlayerMP)func_71521_c(p_71515_1_);
         } else {
            var4 = var3.func_71203_ab().func_72361_f(p_71515_2_[0]);
            if(var4 == null) {
               throw new PlayerNotFoundException();
            }
         }

         if(p_71515_2_.length != 3 && p_71515_2_.length != 4) {
            if(p_71515_2_.length == 1 || p_71515_2_.length == 2) {
               EntityPlayerMP var10 = var3.func_71203_ab().func_72361_f(p_71515_2_[p_71515_2_.length - 1]);
               if(var10 == null) {
                  throw new PlayerNotFoundException();
               }

               var4.field_71135_a.func_72569_a(var10.field_70165_t, var10.field_70163_u, var10.field_70161_v, var10.field_70177_z, var10.field_70125_A);
               func_71522_a(p_71515_1_, "commands.tp.success", new Object[]{var4.func_70023_ak(), var10.func_70023_ak()});
            }
         } else if(var4.field_70170_p != null) {
            int var5 = p_71515_2_.length - 3;
            int var6 = 30000000;
            int var7 = func_71532_a(p_71515_1_, p_71515_2_[var5++], -var6, var6);
            int var8 = func_71532_a(p_71515_1_, p_71515_2_[var5++], 0, 256);
            int var9 = func_71532_a(p_71515_1_, p_71515_2_[var5++], -var6, var6);
            var4.func_70634_a((double)((float)var7 + 0.5F), (double)var8, (double)((float)var9 + 0.5F));
            func_71522_a(p_71515_1_, "commands.tp.coordinates", new Object[]{var4.func_70023_ak(), Integer.valueOf(var7), Integer.valueOf(var8), Integer.valueOf(var9)});
         }

      }
   }

   public List func_71516_a(ICommandSender p_71516_1_, String[] p_71516_2_) {
      return p_71516_2_.length != 1 && p_71516_2_.length != 2?null:func_71530_a(p_71516_2_, MinecraftServer.func_71276_C().func_71213_z());
   }
}
