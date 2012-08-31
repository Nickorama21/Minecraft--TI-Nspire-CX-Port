package net.minecraft.src;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServerListenThread extends Thread
{
    private static Logger minecraftLogger = Logger.getLogger("Minecraft");
    private final List pendingConnections = Collections.synchronizedList(new ArrayList());
    private final HashMap field_71776_c = new HashMap();
    private int connectionCounter = 0;
    private final ServerSocket myServerSocket;
    private NetworkListenThread myNetworkListenThread;
    private final InetAddress myServerAddress;
    private final int myPort;

    public ServerListenThread(NetworkListenThread par1NetworkListenThread, InetAddress par2InetAddress, int par3) throws IOException
    {
        super("Listen thread");
        this.myNetworkListenThread = par1NetworkListenThread;
        this.myServerAddress = par2InetAddress;
        this.myPort = par3;
        this.myServerSocket = new ServerSocket(par3, 0, par2InetAddress);
        this.myServerSocket.setPerformancePreferences(0, 2, 1);
    }

    public void processPendingConnections()
    {
        List var1 = this.pendingConnections;

        synchronized (this.pendingConnections)
        {
            for (int var2 = 0; var2 < this.pendingConnections.size(); ++var2)
            {
                NetLoginHandler var3 = (NetLoginHandler)this.pendingConnections.get(var2);

                try
                {
                    var3.tryLogin();
                }
                catch (Exception var6)
                {
                    var3.raiseErrorAndDisconnect("Internal server error");
                    minecraftLogger.log(Level.WARNING, "Failed to handle packet: " + var6, var6);
                }

                if (var3.connectionComplete)
                {
                    this.pendingConnections.remove(var2--);
                }

                var3.myTCPConnection.wakeThreads();
            }
        }
    }

    public void run()
    {
        while (this.myNetworkListenThread.field_71749_b)
        {
            try
            {
                Socket var1 = this.myServerSocket.accept();
                InetAddress var2 = var1.getInetAddress();
                long var3 = System.currentTimeMillis();
                HashMap var5 = this.field_71776_c;

                synchronized (this.field_71776_c)
                {
                    if (this.field_71776_c.containsKey(var2) && !isLocalHost(var2) && var3 - ((Long)this.field_71776_c.get(var2)).longValue() < 4000L)
                    {
                        this.field_71776_c.put(var2, Long.valueOf(var3));
                        var1.close();
                        continue;
                    }

                    this.field_71776_c.put(var2, Long.valueOf(var3));
                }

                NetLoginHandler var9 = new NetLoginHandler(this.myNetworkListenThread.getServer(), var1, "Connection #" + this.connectionCounter++);
                this.addPendingConnection(var9);
            }
            catch (IOException var8)
            {
                var8.printStackTrace();
            }
        }

        System.out.println("Closing listening thread");
    }

    private void addPendingConnection(NetLoginHandler par1NetLoginHandler)
    {
        if (par1NetLoginHandler == null)
        {
            throw new IllegalArgumentException("Got null pendingconnection!");
        }
        else
        {
            List var2 = this.pendingConnections;

            synchronized (this.pendingConnections)
            {
                this.pendingConnections.add(par1NetLoginHandler);
            }
        }
    }

    private static boolean isLocalHost(InetAddress par0InetAddress)
    {
        return "127.0.0.1".equals(par0InetAddress.getHostAddress());
    }

    public void func_71769_a(InetAddress par1InetAddress)
    {
        if (par1InetAddress != null)
        {
            HashMap var2 = this.field_71776_c;

            synchronized (this.field_71776_c)
            {
                this.field_71776_c.remove(par1InetAddress);
            }
        }
    }

    public void func_71768_b()
    {
        try
        {
            this.myServerSocket.close();
        }
        catch (Throwable var2)
        {
            ;
        }
    }

    public InetAddress getInetAddress()
    {
        return this.myServerAddress;
    }

    public int func_71765_d()
    {
        return this.myPort;
    }
}
