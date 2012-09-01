package net.minecraft.src;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.text.DecimalFormat;
import javax.swing.JComponent;
import javax.swing.Timer;
import net.minecraft.server.MinecraftServer;

public class GuiStatsComponent extends JComponent
{
    private static final DecimalFormat field_79020_a = new DecimalFormat("########0.000");

    /** An array containing the columns that make up the memory use graph. */
    private int[] memoryUse = new int[256];

    /**
     * Counts the number of updates. Used as the index into the memoryUse array to display the latest value.
     */
    private int updateCounter = 0;

    /** An array containing the strings displayed in this stats component. */
    private String[] displayStrings = new String[10];
    private final MinecraftServer field_79017_e;

    public GuiStatsComponent(MinecraftServer par1MinecraftServer)
    {
        this.field_79017_e = par1MinecraftServer;
        this.setPreferredSize(new Dimension(356, 246));
        this.setMinimumSize(new Dimension(356, 246));
        this.setMaximumSize(new Dimension(356, 246));
        (new Timer(500, new GuiStatsListener(this))).start();
        this.setBackground(Color.BLACK);
    }

    /**
     * Updates the stat values and calls paint to redraw the component.
     */
    private void updateStats()
    {
        long var1 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.gc();
        this.displayStrings[0] = "Memory use: " + var1 / 1024L / 1024L + " mb (" + Runtime.getRuntime().freeMemory() * 100L / Runtime.getRuntime().maxMemory() + "% free)";
        this.displayStrings[1] = "Threads: " + TcpConnection.field_74471_a.get() + " + " + TcpConnection.field_74469_b.get();
        this.displayStrings[2] = "Avg tick: " + field_79020_a.format(this.func_79015_a(this.field_79017_e.field_71311_j) * 1.0E-6D) + " ms";
        this.displayStrings[3] = "Avg sent: " + (int)this.func_79015_a(this.field_79017_e.field_71300_f) + ", Avg size: " + (int)this.func_79015_a(this.field_79017_e.field_71301_g);
        this.displayStrings[4] = "Avg rec: " + (int)this.func_79015_a(this.field_79017_e.field_71313_h) + ", Avg size: " + (int)this.func_79015_a(this.field_79017_e.field_71314_i);

        if (this.field_79017_e.theWorldServer != null)
        {
            for (int var3 = 0; var3 < this.field_79017_e.theWorldServer.length; ++var3)
            {
                this.displayStrings[5 + var3] = "Lvl " + var3 + " tick: " + field_79020_a.format(this.func_79015_a(this.field_79017_e.field_71312_k[var3]) * 1.0E-6D) + " ms";

                if (this.field_79017_e.theWorldServer[var3] != null && this.field_79017_e.theWorldServer[var3].theChunkProviderServer != null)
                {
                    this.displayStrings[5 + var3] = this.displayStrings[5 + var3] + ", " + this.field_79017_e.theWorldServer[var3].theChunkProviderServer.func_73148_d();
                }
            }
        }

        this.memoryUse[this.updateCounter++ & 255] = (int)(this.func_79015_a(this.field_79017_e.field_71301_g) * 100.0D / 12500.0D);
        this.repaint();
    }

    private double func_79015_a(long[] par1ArrayOfLong)
    {
        long var2 = 0L;
        long[] var4 = par1ArrayOfLong;
        int var5 = par1ArrayOfLong.length;

        for (int var6 = 0; var6 < var5; ++var6)
        {
            long var7 = var4[var6];
            var2 += var7;
        }

        return (double)var2 / (double)par1ArrayOfLong.length;
    }

    public void paint(Graphics par1Graphics)
    {
        par1Graphics.setColor(new Color(16777215));
        par1Graphics.fillRect(0, 0, 356, 246);
        int var2;

        for (var2 = 0; var2 < 256; ++var2)
        {
            int var3 = this.memoryUse[var2 + this.updateCounter & 255];
            par1Graphics.setColor(new Color(var3 + 28 << 16));
            par1Graphics.fillRect(var2, 100 - var3, 1, var3);
        }

        par1Graphics.setColor(Color.BLACK);

        for (var2 = 0; var2 < this.displayStrings.length; ++var2)
        {
            String var4 = this.displayStrings[var2];

            if (var4 != null)
            {
                par1Graphics.drawString(var4, 32, 116 + var2 * 16);
            }
        }
    }

    /**
     * Public static accessor to call updateStats.
     */
    static void update(GuiStatsComponent par0GuiStatsComponent)
    {
        par0GuiStatsComponent.updateStats();
    }
}
