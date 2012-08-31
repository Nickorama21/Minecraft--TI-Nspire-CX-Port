package net.minecraft.src;

import java.util.Iterator;
import java.util.List;

public class GuiDisconnected extends GuiScreen
{
    /** The error message. */
    private String errorMessage;

    /** The details about the error. */
    private String errorDetail;
    private Object[] field_74247_c;
    private List field_74245_d;

    public GuiDisconnected(String par1Str, String par2Str, Object ... par3ArrayOfObj)
    {
        StringTranslate var4 = StringTranslate.getInstance();
        this.errorMessage = var4.translateKey(par1Str);
        this.errorDetail = par2Str;
        this.field_74247_c = par3ArrayOfObj;
    }

    /**
     * Fired when a key is typed. This is the equivalent of KeyListener.keyTyped(KeyEvent e).
     */
    protected void keyTyped(char par1, int par2) {}

    /**
     * Adds the buttons (and other controls) to the screen in question.
     */
    public void initGui()
    {
        StringTranslate var1 = StringTranslate.getInstance();
        this.controlList.clear();
        this.controlList.add(new GuiButton(0, this.width / 2 - 100, this.height / 4 + 120 + 12, var1.translateKey("gui.toMenu")));

        if (this.field_74247_c != null)
        {
            this.field_74245_d = this.fontRenderer.listFormattedStringToWidth(var1.translateKeyFormat(this.errorDetail, this.field_74247_c), this.width - 50);
        }
        else
        {
            this.field_74245_d = this.fontRenderer.listFormattedStringToWidth(var1.translateKey(this.errorDetail), this.width - 50);
        }
    }

    /**
     * Fired when a control is clicked. This is the equivalent of ActionListener.actionPerformed(ActionEvent e).
     */
    protected void actionPerformed(GuiButton par1GuiButton)
    {
        if (par1GuiButton.id == 0)
        {
            this.mc.displayGuiScreen(new GuiMainMenu());
        }
    }

    /**
     * Draws the screen and all the components in it.
     */
    public void drawScreen(int par1, int par2, float par3)
    {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRenderer, this.errorMessage, this.width / 2, this.height / 2 - 50, 11184810);
        int var4 = this.height / 2 - 30;

        if (this.field_74245_d == null)
        {
            this.initGui();
        }

        for (Iterator var5 = this.field_74245_d.iterator(); var5.hasNext(); var4 += 5)
        {
            String var6 = (String)var5.next();
            this.drawCenteredString(this.fontRenderer, var6, this.width / 2, var4, 16777215);
        }

        super.drawScreen(par1, par2, par3);
    }
}
