package net.minecraft.src;

import net.minecraft.server.MinecraftServer;

public class ConvertProgressUpdater implements IProgressUpdate
{
    private long field_74266_b;

    final MinecraftServer field_74267_a;

    public ConvertProgressUpdater(MinecraftServer par1MinecraftServer)
    {
        this.field_74267_a = par1MinecraftServer;
        this.field_74266_b = System.currentTimeMillis();
    }

    /**
     * "Saving level", or the loading,or downloading equivelent
     */
    public void displayProgressMessage(String par1Str) {}

    /**
     * this string, followed by "working..." and then the "% complete" are the 3 lines shown. This resets progress to 0,
     * and the WorkingString to "working...".
     */
    public void resetProgressAndMessage(String par1Str) {}

    /**
     * Updates the progress bar on the loading screen to the specified amount. Args: loadProgress
     */
    public void setLoadingProgress(int par1)
    {
        if (System.currentTimeMillis() - this.field_74266_b >= 1000L)
        {
            this.field_74266_b = System.currentTimeMillis();
            MinecraftServer.logger.info("Converting... " + par1 + "%");
        }
    }

    /**
     * called when there is no more progress to be had, both on completion and failure
     */
    public void onNoMoreProgress() {}

    /**
     * This is called with "Working..." by resetProgressAndMessage
     */
    public void resetProgresAndWorkingMessage(String par1Str) {}
}
