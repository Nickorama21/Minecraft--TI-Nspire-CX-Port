package net.minecraft.src;

import java.util.List;
import net.minecraft.server.MinecraftServer;

public class CommandServerKick extends CommandBase
{
    public String getCommandName()
    {
        return "kick";
    }

    public String getCommandUsage(ICommandSender par1ICommandSender)
    {
        return par1ICommandSender.translateString("commands.kick.usage", new Object[0]);
    }

    public void processCommand(ICommandSender par1ICommandSender, String[] par2ArrayOfStr)
    {
        if (par2ArrayOfStr.length > 0 && par2ArrayOfStr[0].length() > 1)
        {
            EntityPlayerMP var3 = MinecraftServer.getServer().getConfigurationManager().getPlayerEntity(par2ArrayOfStr[0]);
            String var4 = "Kicked by an operator.";
            boolean var5 = false;

            if (var3 == null)
            {
                throw new PlayerNotFoundException();
            }
            else
            {
                if (par2ArrayOfStr.length >= 2)
                {
                    var4 = joinString(par2ArrayOfStr, 1);
                    var5 = true;
                }

                var3.playerNetServerHandler.kickPlayer(var4);

                if (var5)
                {
                    func_71522_a(par1ICommandSender, "commands.kick.success.reason", new Object[] {var3.getEntityName(), var4});
                }
                else
                {
                    func_71522_a(par1ICommandSender, "commands.kick.success", new Object[] {var3.getEntityName()});
                }
            }
        }
        else
        {
            throw new WrongUsageException("commands.kick.usage", new Object[0]);
        }
    }

    /**
     * Adds the strings available in this command to the given list of tab completion options.
     */
    public List addTabCompletionOptions(ICommandSender par1ICommandSender, String[] par2ArrayOfStr)
    {
        return par2ArrayOfStr.length >= 1 ? getListOfStringsMatchingLastWord(par2ArrayOfStr, MinecraftServer.getServer().getPlayerNamesAsList()) : null;
    }
}
