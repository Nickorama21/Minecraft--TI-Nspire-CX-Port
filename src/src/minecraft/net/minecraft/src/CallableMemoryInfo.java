package net.minecraft.src;

import java.util.concurrent.Callable;

class CallableMemoryInfo implements Callable
{
    /** Gets Memory Information for Crash Report. */
    final CrashReport crashReportMemoryInfo;

    CallableMemoryInfo(CrashReport par1CrashReport)
    {
        this.crashReportMemoryInfo = par1CrashReport;
    }

    public String func_71485_a()
    {
        Runtime var1 = Runtime.getRuntime();
        long var2 = var1.maxMemory();
        long var4 = var1.totalMemory();
        long var6 = var1.freeMemory();
        long var8 = var2 / 1024L / 1024L;
        long var10 = var4 / 1024L / 1024L;
        long var12 = var6 / 1024L / 1024L;
        return var6 + " bytes (" + var12 + " MB) / " + var4 + " bytes (" + var10 + " MB) up to " + var2 + " bytes (" + var8 + " MB)";
    }

    public Object call()
    {
        return this.func_71485_a();
    }
}
