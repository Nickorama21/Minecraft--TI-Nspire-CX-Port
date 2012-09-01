package net.minecraft.src;

import java.util.Iterator;
import net.minecraft.server.MinecraftServer;
import net.minecraft.src.CommandBase;
import net.minecraft.src.CommandDebug;
import net.minecraft.src.CommandDefaultGameMode;
import net.minecraft.src.CommandGameMode;
import net.minecraft.src.CommandGive;
import net.minecraft.src.CommandHandler;
import net.minecraft.src.CommandHelp;
import net.minecraft.src.CommandKill;
import net.minecraft.src.CommandServerBan;
import net.minecraft.src.CommandServerBanIp;
import net.minecraft.src.CommandServerBanlist;
import net.minecraft.src.CommandServerDeop;
import net.minecraft.src.CommandServerEmote;
import net.minecraft.src.CommandServerKick;
import net.minecraft.src.CommandServerList;
import net.minecraft.src.CommandServerMessage;
import net.minecraft.src.CommandServerOp;
import net.minecraft.src.CommandServerPardon;
import net.minecraft.src.CommandServerPardonIp;
import net.minecraft.src.CommandServerPublishLocal;
import net.minecraft.src.CommandServerSaveAll;
import net.minecraft.src.CommandServerSaveOff;
import net.minecraft.src.CommandServerSaveOn;
import net.minecraft.src.CommandServerSay;
import net.minecraft.src.CommandServerStop;
import net.minecraft.src.CommandServerTp;
import net.minecraft.src.CommandServerWhitelist;
import net.minecraft.src.CommandShowSeed;
import net.minecraft.src.CommandTime;
import net.minecraft.src.CommandToggleDownfall;
import net.minecraft.src.CommandXP;
import net.minecraft.src.EntityPlayerMP;
import net.minecraft.src.IAdminCommand;
import net.minecraft.src.ICommandSender;

public class ServerCommandManager extends CommandHandler implements IAdminCommand {

   public ServerCommandManager() {
      this.func_71560_a(new CommandTime());
      this.func_71560_a(new CommandGameMode());
      this.func_71560_a(new CommandDefaultGameMode());
      this.func_71560_a(new CommandKill());
      this.func_71560_a(new CommandToggleDownfall());
      this.func_71560_a(new CommandXP());
      this.func_71560_a(new CommandServerTp());
      this.func_71560_a(new CommandGive());
      this.func_71560_a(new CommandServerEmote());
      this.func_71560_a(new CommandShowSeed());
      this.func_71560_a(new CommandHelp());
      this.func_71560_a(new CommandDebug());
      this.func_71560_a(new CommandServerMessage());
      if(MinecraftServer.func_71276_C().func_71262_S()) {
         this.func_71560_a(new CommandServerOp());
         this.func_71560_a(new CommandServerDeop());
         this.func_71560_a(new CommandServerStop());
         this.func_71560_a(new CommandServerSaveAll());
         this.func_71560_a(new CommandServerSaveOff());
         this.func_71560_a(new CommandServerSaveOn());
         this.func_71560_a(new CommandServerBanIp());
         this.func_71560_a(new CommandServerPardonIp());
         this.func_71560_a(new CommandServerBan());
         this.func_71560_a(new CommandServerBanlist());
         this.func_71560_a(new CommandServerPardon());
         this.func_71560_a(new CommandServerKick());
         this.func_71560_a(new CommandServerList());
         this.func_71560_a(new CommandServerSay());
         this.func_71560_a(new CommandServerWhitelist());
      } else {
         this.func_71560_a(new CommandServerPublishLocal());
      }

      CommandBase.func_71529_a(this);
   }

   public void func_71563_a(ICommandSender p_71563_1_, int p_71563_2_, String p_71563_3_, Object ... p_71563_4_) {
      Iterator var5 = MinecraftServer.func_71276_C().func_71203_ab().field_72404_b.iterator();

      while(var5.hasNext()) {
         EntityPlayerMP var6 = (EntityPlayerMP)var5.next();
         if(var6 != p_71563_1_ && MinecraftServer.func_71276_C().func_71203_ab().func_72353_e(var6.field_71092_bJ)) {
            var6.func_70006_a("\u00a77\u00a7o[" + p_71563_1_.func_70005_c_() + ": " + var6.func_70004_a(p_71563_3_, p_71563_4_) + "]");
         }
      }

      if(p_71563_1_ != MinecraftServer.func_71276_C()) {
         MinecraftServer.field_71306_a.info("[" + p_71563_1_.func_70005_c_() + ": " + MinecraftServer.func_71276_C().func_70004_a(p_71563_3_, p_71563_4_) + "]");
      }

      if((p_71563_2_ & 1) != 1) {
         p_71563_1_.func_70006_a(p_71563_1_.func_70004_a(p_71563_3_, p_71563_4_));
      }

   }
}
