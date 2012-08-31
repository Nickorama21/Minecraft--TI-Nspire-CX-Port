package net.minecraft.src;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadLanServerPing extends Thread
{
    private static Logger field_77530_a = Logger.getLogger("Minecraft");
    private final String motd;
    private final DatagramSocket field_77529_c;
    private boolean isStopping = true;
    private final String address;

    public ThreadLanServerPing(String par1Str, String par2Str) throws IOException
    {
        super("LanServerPinger");
        this.motd = par1Str;
        this.address = par2Str;
        this.setDaemon(true);
        this.field_77529_c = new DatagramSocket();
    }

    public void run()
    {
        String var1 = getPingResponse(this.motd, this.address);
        byte[] var2 = var1.getBytes();

        while (!this.isInterrupted() && this.isStopping)
        {
            try
            {
                InetAddress var3 = InetAddress.getByName("224.0.2.60");
                DatagramPacket var4 = new DatagramPacket(var2, var2.length, var3, 4445);
                this.field_77529_c.send(var4);
            }
            catch (IOException var6)
            {
                field_77530_a.log(Level.WARNING, "LanServerPinger: " + var6.getMessage());
                break;
            }

            try
            {
                sleep(1500L);
            }
            catch (InterruptedException var5)
            {
                ;
            }
        }
    }

    public void interrupt()
    {
        super.interrupt();
        this.isStopping = false;
    }

    public static String getPingResponse(String par0Str, String par1Str)
    {
        return "[MOTD]" + par0Str + "[/MOTD][AD]" + par1Str + "[/AD]";
    }

    public static String func_77524_a(String par0Str)
    {
        int var1 = par0Str.indexOf("[MOTD]");

        if (var1 < 0)
        {
            return "missing no";
        }
        else
        {
            int var2 = par0Str.indexOf("[/MOTD]", var1 + "[MOTD]".length());
            return var2 < var1 ? "missing no" : par0Str.substring(var1 + "[MOTD]".length(), var2);
        }
    }

    public static String func_77523_b(String par0Str)
    {
        int var1 = par0Str.indexOf("[/MOTD]");

        if (var1 < 0)
        {
            return null;
        }
        else
        {
            int var2 = par0Str.indexOf("[/MOTD]", var1 + "[/MOTD]".length());

            if (var2 >= 0)
            {
                return null;
            }
            else
            {
                int var3 = par0Str.indexOf("[AD]", var1 + "[/MOTD]".length());

                if (var3 < 0)
                {
                    return null;
                }
                else
                {
                    int var4 = par0Str.indexOf("[/AD]", var3 + "[AD]".length());
                    return var4 < var3 ? null : par0Str.substring(var3 + "[AD]".length(), var4);
                }
            }
        }
    }
}
