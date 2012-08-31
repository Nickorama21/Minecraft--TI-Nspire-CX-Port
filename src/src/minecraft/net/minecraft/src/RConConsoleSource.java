package net.minecraft.src;

public class RConConsoleSource implements ICommandSender
{
    /** only ever used by MinecraftServer.executeCommand */
    public static final RConConsoleSource consoleBuffer = new RConConsoleSource();
    private StringBuffer chatBuffer = new StringBuffer();

    public void clearChatBuffer()
    {
        this.chatBuffer.setLength(0);
    }

    public String getChatBuffer()
    {
        return this.chatBuffer.toString();
    }

    /**
     * Gets the name of this command sender (usually username, but possibly "Rcon")
     */
    public String getCommandSenderName()
    {
        return "Rcon";
    }

    public void sendChatToPlayer(String par1Str)
    {
        this.chatBuffer.append(par1Str);
    }

    /**
     * Returns true if the command sender is allowed to use the given command.
     */
    public boolean canCommandSenderUseCommand(String par1Str)
    {
        return true;
    }

    /**
     * Translates and formats the given string key with the given arguments.
     */
    public String translateString(String par1Str, Object ... par2ArrayOfObj)
    {
        return StringTranslate.getInstance().translateKeyFormat(par1Str, par2ArrayOfObj);
    }
}
