package net.minecraft.src;

import java.util.List;
import net.minecraft.server.MinecraftServer;
import net.minecraft.src.CommandBase;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EntityPlayerMP;
import net.minecraft.src.ICommandSender;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.NumberInvalidException;
import net.minecraft.src.PlayerNotFoundException;
import net.minecraft.src.WrongUsageException;

public class CommandGive extends CommandBase {

   public String func_71517_b() {
      return "give";
   }

   public String func_71518_a(ICommandSender p_71518_1_) {
      return p_71518_1_.func_70004_a("commands.give.usage", new Object[0]);
   }

   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) {
      if(p_71515_2_.length >= 2) {
         EntityPlayer var3 = this.func_71537_a(p_71515_2_[0]);
         int var4 = func_71528_a(p_71515_1_, p_71515_2_[1], 1);
         int var5 = 1;
         int var6 = 0;
         if(Item.field_77698_e[var4] == null) {
            throw new NumberInvalidException("commands.give.notFound", new Object[]{Integer.valueOf(var4)});
         } else {
            if(p_71515_2_.length >= 3) {
               var5 = func_71532_a(p_71515_1_, p_71515_2_[2], 1, 64);
            }

            if(p_71515_2_.length >= 4) {
               var6 = func_71526_a(p_71515_1_, p_71515_2_[3]);
            }

            ItemStack var7 = new ItemStack(var4, var5, var6);
            var3.func_71021_b(var7);
            func_71522_a(p_71515_1_, "commands.give.success", new Object[]{Item.field_77698_e[var4].func_77653_i(var7), Integer.valueOf(var4), Integer.valueOf(var5), var3.func_70023_ak()});
         }
      } else {
         throw new WrongUsageException("commands.give.usage", new Object[0]);
      }
   }

   public List func_71516_a(ICommandSender p_71516_1_, String[] p_71516_2_) {
      return p_71516_2_.length == 1?func_71530_a(p_71516_2_, this.func_71536_c()):null;
   }

   protected EntityPlayer func_71537_a(String p_71537_1_) {
      EntityPlayerMP var2 = MinecraftServer.func_71276_C().func_71203_ab().func_72361_f(p_71537_1_);
      if(var2 == null) {
         throw new PlayerNotFoundException();
      } else {
         return var2;
      }
   }

   protected String[] func_71536_c() {
      return MinecraftServer.func_71276_C().func_71213_z();
   }
}
