package net.minecraft.src;

import java.util.List;
import net.minecraft.server.MinecraftServer;

public class CommandGive extends CommandBase
{
    public String getCommandName()
    {
        return "give";
    }

    public String getCommandUsage(ICommandSender par1ICommandSender)
    {
        return par1ICommandSender.translateString("commands.give.usage", new Object[0]);
    }

    public void processCommand(ICommandSender par1ICommandSender, String[] par2ArrayOfStr)
    {
        if (par2ArrayOfStr.length >= 2)
        {
            EntityPlayer var3 = this.func_71537_a(par2ArrayOfStr[0]);
            int var4 = parseIntWithMin(par1ICommandSender, par2ArrayOfStr[1], 1);
            int var5 = 1;
            int var6 = 0;

            if (Item.itemsList[var4] == null)
            {
                throw new NumberInvalidException("commands.give.notFound", new Object[] {Integer.valueOf(var4)});
            }
            else
            {
                if (par2ArrayOfStr.length >= 3)
                {
                    var5 = parseIntBounded(par1ICommandSender, par2ArrayOfStr[2], 1, 64);
                }

                if (par2ArrayOfStr.length >= 4)
                {
                    var6 = parseInt(par1ICommandSender, par2ArrayOfStr[3]);
                }

                ItemStack var7 = new ItemStack(var4, var5, var6);
                var3.dropPlayerItem(var7);
                notifyAdmins(par1ICommandSender, "commands.give.success", new Object[] {Item.itemsList[var4].func_77653_i(var7), Integer.valueOf(var4), Integer.valueOf(var5), var3.getEntityName()});
            }
        }
        else
        {
            throw new WrongUsageException("commands.give.usage", new Object[0]);
        }
    }

    /**
     * Adds the strings available in this command to the given list of tab completion options.
     */
    public List addTabCompletionOptions(ICommandSender par1ICommandSender, String[] par2ArrayOfStr)
    {
        return par2ArrayOfStr.length == 1 ? getListOfStringsMatchingLastWord(par2ArrayOfStr, this.getPlayers()) : null;
    }

    protected EntityPlayer func_71537_a(String par1Str)
    {
        EntityPlayerMP var2 = MinecraftServer.getServer().getConfigurationManager().getPlayerForUsername(par1Str);

        if (var2 == null)
        {
            throw new PlayerNotFoundException();
        }
        else
        {
            return var2;
        }
    }

    protected String[] getPlayers()
    {
        return MinecraftServer.getServer().getAllUsernames();
    }
}
