package net.minecraft.src;

import net.minecraft.server.MinecraftServer;

public class CommandServerSaveAll extends CommandBase
{
    public String getCommandName()
    {
        return "save-all";
    }

    public void processCommand(ICommandSender par1ICommandSender, String[] par2ArrayOfStr)
    {
        MinecraftServer var3 = MinecraftServer.getServer();
        par1ICommandSender.sendChatToPlayer(par1ICommandSender.translateString("commands.save.start", new Object[0]));

        if (var3.getConfigurationManager() != null)
        {
            var3.getConfigurationManager().saveAllPlayerData();
        }

        try
        {
            for (int var4 = 0; var4 < var3.theWorldServer.length; ++var4)
            {
                if (var3.theWorldServer[var4] != null)
                {
                    WorldServer var5 = var3.theWorldServer[var4];
                    boolean var6 = var5.canNotSave;
                    var5.canNotSave = false;
                    var5.saveAllChunks(true, (IProgressUpdate)null);
                    var5.canNotSave = var6;
                }
            }
        }
        catch (MinecraftException var7)
        {
            notifyAdmins(par1ICommandSender, "commands.save.failed", new Object[] {var7.getMessage()});
            return;
        }

        notifyAdmins(par1ICommandSender, "commands.save.success", new Object[0]);
    }
}
