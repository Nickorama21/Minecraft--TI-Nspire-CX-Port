package net.minecraft.src;

import java.util.concurrent.Callable;
import net.minecraft.server.MinecraftServer;

public class CallableIsServerModded implements Callable
{
    /** For checking if Minecraft Server is modded. */
    final MinecraftServer minecraftServerIsServerModded;

    public CallableIsServerModded(MinecraftServer par1MinecraftServer)
    {
        this.minecraftServerIsServerModded = par1MinecraftServer;
    }

    public String func_74273_a()
    {
        String var1 = this.minecraftServerIsServerModded.getServerModName();
        return !var1.equals("vanilla") ? "Definitely; \'" + var1 + "\'" : "Unknown (can\'t tell)";
    }

    public Object call()
    {
        return this.func_74273_a();
    }
}
