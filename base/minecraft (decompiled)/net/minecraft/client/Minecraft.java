package net.minecraft.client;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import javax.swing.JPanel;
import net.minecraft.src.AchievementList;
import net.minecraft.src.AnvilSaveConverter;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.CallableClientProfiler;
import net.minecraft.src.CallableGLInfo;
import net.minecraft.src.CallableLWJGLVersion;
import net.minecraft.src.CallableModded;
import net.minecraft.src.CallableTexturePack;
import net.minecraft.src.CallableType2;
import net.minecraft.src.ColorizerFoliage;
import net.minecraft.src.ColorizerGrass;
import net.minecraft.src.ColorizerWater;
import net.minecraft.src.CrashReport;
import net.minecraft.src.EffectRenderer;
import net.minecraft.src.EntityBoat;
import net.minecraft.src.EntityClientPlayerMP;
import net.minecraft.src.EntityList;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityMinecart;
import net.minecraft.src.EntityPainting;
import net.minecraft.src.EntityRenderer;
import net.minecraft.src.EnumMovingObjectType;
import net.minecraft.src.EnumOS;
import net.minecraft.src.EnumOSHelper;
import net.minecraft.src.EnumOptions;
import net.minecraft.src.FontRenderer;
import net.minecraft.src.GLAllocation;
import net.minecraft.src.GameSettings;
import net.minecraft.src.GameWindowListener;
import net.minecraft.src.GuiAchievement;
import net.minecraft.src.GuiChat;
import net.minecraft.src.GuiConnecting;
import net.minecraft.src.GuiErrorScreen;
import net.minecraft.src.GuiGameOver;
import net.minecraft.src.GuiIngame;
import net.minecraft.src.GuiIngameMenu;
import net.minecraft.src.GuiInventory;
import net.minecraft.src.GuiMainMenu;
import net.minecraft.src.GuiMemoryErrorScreen;
import net.minecraft.src.GuiScreen;
import net.minecraft.src.GuiSleepMP;
import net.minecraft.src.IPlayerUsage;
import net.minecraft.src.ISaveFormat;
import net.minecraft.src.ISaveHandler;
import net.minecraft.src.IntegratedServer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemRenderer;
import net.minecraft.src.ItemStack;
import net.minecraft.src.KeyBinding;
import net.minecraft.src.LoadingScreenRenderer;
import net.minecraft.src.MathHelper;
import net.minecraft.src.MemoryConnection;
import net.minecraft.src.MinecraftError;
import net.minecraft.src.MinecraftFakeLauncher;
import net.minecraft.src.MouseHelper;
import net.minecraft.src.MovementInputFromOptions;
import net.minecraft.src.MovingObjectPosition;
import net.minecraft.src.NetClientHandler;
import net.minecraft.src.NetworkManager;
import net.minecraft.src.OpenGlHelper;
import net.minecraft.src.Packet3Chat;
import net.minecraft.src.PlayerControllerMP;
import net.minecraft.src.PlayerUsageSnooper;
import net.minecraft.src.Profiler;
import net.minecraft.src.ProfilerResult;
import net.minecraft.src.RenderBlocks;
import net.minecraft.src.RenderEngine;
import net.minecraft.src.RenderGlobal;
import net.minecraft.src.RenderManager;
import net.minecraft.src.ReportedException;
import net.minecraft.src.ScaledResolution;
import net.minecraft.src.ScreenShotHelper;
import net.minecraft.src.ServerData;
import net.minecraft.src.Session;
import net.minecraft.src.SoundManager;
import net.minecraft.src.StatCollector;
import net.minecraft.src.StatFileWriter;
import net.minecraft.src.StatList;
import net.minecraft.src.StatStringFormatKeyInv;
import net.minecraft.src.StringTranslate;
import net.minecraft.src.Tessellator;
import net.minecraft.src.TextureCompassFX;
import net.minecraft.src.TextureFlamesFX;
import net.minecraft.src.TextureLavaFX;
import net.minecraft.src.TextureLavaFlowFX;
import net.minecraft.src.TexturePackList;
import net.minecraft.src.TexturePortalFX;
import net.minecraft.src.TextureWatchFX;
import net.minecraft.src.TextureWaterFX;
import net.minecraft.src.TextureWaterFlowFX;
import net.minecraft.src.ThreadClientSleep;
import net.minecraft.src.ThreadDownloadResources;
import net.minecraft.src.ThreadShutdown;
import net.minecraft.src.Timer;
import net.minecraft.src.Vec3;
import net.minecraft.src.WorldClient;
import net.minecraft.src.WorldInfo;
import net.minecraft.src.WorldRenderer;
import net.minecraft.src.WorldSettings;
import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GLContext;
import org.lwjgl.opengl.PixelFormat;
import org.lwjgl.util.glu.GLU;

public abstract class Minecraft implements Runnable, IPlayerUsage
{
    /** The experienceTotal value the client thinks the player has. */
    public static byte[] clientExperience = new byte[10485760];
    private ServerData currentServerData;

    /**
     * Set to 'this' in Minecraft constructor; used by some settings get methods
     */
    private static Minecraft theMinecraft;
    public PlayerControllerMP playerController;
    private boolean fullscreen = false;
    private boolean hasCrashed = false;

    /** Instance of CrashReport. */
    private CrashReport crashReporter;
    public int displayWidth;
    public int displayHeight;
    private Timer timer = new Timer(20.0F);

    /** Instance of PlayerUsageSnooper. */
    private PlayerUsageSnooper usageSnooper = new PlayerUsageSnooper("client", this);
    public WorldClient theWorld;
    public RenderGlobal renderGlobal;
    public EntityClientPlayerMP thePlayer;

    /**
     * The Entity from which the renderer determines the render viewpoint. Currently is always the parent Minecraft
     * class's 'thePlayer' instance. Modification of its location, rotation, or other settings at render time will
     * modify the camera likewise, with the caveat of triggering chunk rebuilds as it moves, making it unsuitable for
     * changing the viewpoint mid-render.
     */
    public EntityLiving renderViewEntity;
    public EffectRenderer effectRenderer;
    public Session session = null;
    public String minecraftUri;
    public Canvas mcCanvas;

    /** a boolean to hide a Quit button from the main menu */
    public boolean hideQuitButton = false;
    public volatile boolean isGamePaused = false;

    /** The RenderEngine instance used by Minecraft */
    public RenderEngine renderEngine;

    /** The font renderer used for displaying and measuring text. */
    public FontRenderer fontRenderer;
    public FontRenderer standardGalacticFontRenderer;

    /** The GuiScreen that's being displayed at the moment. */
    public GuiScreen currentScreen = null;
    public LoadingScreenRenderer loadingScreen;
    public EntityRenderer entityRenderer;

    /** Reference to the download resources thread. */
    private ThreadDownloadResources downloadResourcesThread;

    /** Mouse left click counter */
    private int leftClickCounter = 0;

    /** Display width */
    private int tempDisplayWidth;

    /** Display height */
    private int tempDisplayHeight;

    /** Instance of IntegratedServer. */
    private IntegratedServer theIntegratedServer;

    /** Gui achievement */
    public GuiAchievement guiAchievement = new GuiAchievement(this);
    public GuiIngame ingameGUI;

    /** Skip render world */
    public boolean skipRenderWorld = false;

    /** The ray trace hit that the mouse is over. */
    public MovingObjectPosition objectMouseOver = null;

    /** The game settings that currently hold effect. */
    public GameSettings gameSettings;
    protected MinecraftApplet mcApplet;
    public SoundManager sndManager = new SoundManager();

    /** Mouse helper instance. */
    public MouseHelper mouseHelper;

    /** The TexturePackLister used by this instance of Minecraft... */
    public TexturePackList texturePackList;
    public File mcDataDir;
    private ISaveFormat saveLoader;
    private static int field_71470_ab;

    /**
     * When you place a block, it's set to 6, decremented once per tick, when it's 0, you can place another block.
     */
    private int rightClickDelayTimer = 0;
    private boolean field_71468_ad;

    /** Stat file writer */
    public StatFileWriter statFileWriter;
    private String serverName;
    private int serverPort;
    private TextureWaterFX textureWaterFX = new TextureWaterFX();
    private TextureLavaFX textureLavaFX = new TextureLavaFX();

    /**
     * Makes sure it doesn't keep taking screenshots when both buttons are down.
     */
    boolean isTakingScreenshot = false;

    /**
     * Does the actual gameplay have focus. If so then mouse and keys will effect the player instead of menus.
     */
    public boolean inGameHasFocus = false;
    long systemTime = getSystemTime();

    /** Join player counter */
    private int joinPlayerCounter = 0;
    private boolean isDemo;
    private NetworkManager myNetworkManager;
    private boolean integratedServerIsRunning;

    /** The profiler instance */
    public final Profiler mcProfiler = new Profiler();

    /** The working dir (OS specific) for minecraft */
    private static File minecraftDir = null;

    /**
     * Set to true to keep the game loop running. Set to false by shutdown() to allow the game loop to exit cleanly.
     */
    public volatile boolean running = true;

    /** String that shows the debug information */
    public String debug = "";

    /** Approximate time (in ms) of last update to debug string */
    long debugUpdateTime = getSystemTime();

    /** holds the current fps */
    int fpsCounter = 0;
    long prevFrameTime = -1L;

    /** Profiler currently displayed in the debug screen pie chart */
    private String debugProfilerName = "root";

    public Minecraft(Canvas par1Canvas, MinecraftApplet par2MinecraftApplet, int par3, int par4, boolean par5)
    {
        StatList.func_75919_a();
        this.tempDisplayHeight = par4;
        this.fullscreen = par5;
        this.mcApplet = par2MinecraftApplet;
        Packet3Chat.maxChatLength = 32767;
        this.startTimerHackThread();
        this.mcCanvas = par1Canvas;
        this.displayWidth = par3;
        this.displayHeight = par4;
        this.fullscreen = par5;
        theMinecraft = this;
    }

    private void startTimerHackThread()
    {
        ThreadClientSleep var1 = new ThreadClientSleep(this, "Timer hack thread");
        var1.setDaemon(true);
        var1.start();
    }

    public void crashed(CrashReport par1CrashReport)
    {
        this.hasCrashed = true;
        this.crashReporter = par1CrashReport;
    }

    /**
     * Wrapper around displayCrashReportInternal
     */
    public void displayCrashReport(CrashReport par1CrashReport)
    {
        this.hasCrashed = true;
        this.displayCrashReportInternal(par1CrashReport);
    }

    public abstract void displayCrashReportInternal(CrashReport var1);

    public void setServer(String par1Str, int par2)
    {
        this.serverName = par1Str;
        this.serverPort = par2;
    }

    /**
     * Starts the game: initializes the canvas, the title, the settings, etcetera.
     */
    public void startGame() throws LWJGLException
    {
        if (this.mcCanvas != null)
        {
            Graphics var1 = this.mcCanvas.getGraphics();

            if (var1 != null)
            {
                var1.setColor(Color.BLACK);
                var1.fillRect(0, 0, this.displayWidth, this.displayHeight);
                var1.dispose();
            }

            Display.setParent(this.mcCanvas);
        }
        else if (this.fullscreen)
        {
            Display.setFullscreen(true);
            this.displayWidth = Display.getDisplayMode().getWidth();
            this.displayHeight = Display.getDisplayMode().getHeight();

            if (this.displayWidth <= 0)
            {
                this.displayWidth = 1;
            }

            if (this.displayHeight <= 0)
            {
                this.displayHeight = 1;
            }
        }
        else
        {
            Display.setDisplayMode(new DisplayMode(this.displayWidth, this.displayHeight));
        }

        Display.setTitle("Minecraft Minecraft 1.3.2");
        System.out.println("LWJGL Version: " + Sys.getVersion());

        try
        {
            Display.create((new PixelFormat()).withDepthBits(24));
        }
        catch (LWJGLException var5)
        {
            var5.printStackTrace();

            try
            {
                Thread.sleep(1000L);
            }
            catch (InterruptedException var4)
            {
                ;
            }

            Display.create();
        }

        OpenGlHelper.initializeTextures();
        this.mcDataDir = getMinecraftDir();
        this.saveLoader = new AnvilSaveConverter(new File(this.mcDataDir, "saves"));
        this.gameSettings = new GameSettings(this, this.mcDataDir);
        this.texturePackList = new TexturePackList(this.mcDataDir, this);
        this.renderEngine = new RenderEngine(this.texturePackList, this.gameSettings);
        this.loadScreen();
        this.fontRenderer = new FontRenderer(this.gameSettings, "/font/default.png", this.renderEngine, false);
        this.standardGalacticFontRenderer = new FontRenderer(this.gameSettings, "/font/alternate.png", this.renderEngine, false);

        if (this.gameSettings.language != null)
        {
            StringTranslate.getInstance().setLanguage(this.gameSettings.language);
            this.fontRenderer.setUnicodeFlag(StringTranslate.getInstance().isUnicode());
            this.fontRenderer.setBidiFlag(StringTranslate.isBidirectional(this.gameSettings.language));
        }

        ColorizerWater.setWaterBiomeColorizer(this.renderEngine.getTextureContents("/misc/watercolor.png"));
        ColorizerGrass.setGrassBiomeColorizer(this.renderEngine.getTextureContents("/misc/grasscolor.png"));
        ColorizerFoliage.getFoilageBiomeColorizer(this.renderEngine.getTextureContents("/misc/foliagecolor.png"));
        this.entityRenderer = new EntityRenderer(this);
        RenderManager.instance.itemRenderer = new ItemRenderer(this);
        this.statFileWriter = new StatFileWriter(this.session, this.mcDataDir);
        AchievementList.openInventory.setStatStringFormatter(new StatStringFormatKeyInv(this));
        this.loadScreen();
        Mouse.create();
        this.mouseHelper = new MouseHelper(this.mcCanvas);
        this.checkGLError("Pre startup");
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glShadeModel(GL11.GL_SMOOTH);
        GL11.glClearDepth(1.0D);
        GL11.glEnable(GL11.GL_DEPTH_TEST);
        GL11.glDepthFunc(GL11.GL_LEQUAL);
        GL11.glEnable(GL11.GL_ALPHA_TEST);
        GL11.glAlphaFunc(GL11.GL_GREATER, 0.1F);
        GL11.glCullFace(GL11.GL_BACK);
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
        this.checkGLError("Startup");
        this.sndManager.loadSoundSettings(this.gameSettings);
        this.renderEngine.registerTextureFX(this.textureLavaFX);
        this.renderEngine.registerTextureFX(this.textureWaterFX);
        this.renderEngine.registerTextureFX(new TexturePortalFX());
        this.renderEngine.registerTextureFX(new TextureCompassFX(this));
        this.renderEngine.registerTextureFX(new TextureWatchFX(this));
        this.renderEngine.registerTextureFX(new TextureWaterFlowFX());
        this.renderEngine.registerTextureFX(new TextureLavaFlowFX());
        this.renderEngine.registerTextureFX(new TextureFlamesFX(0));
        this.renderEngine.registerTextureFX(new TextureFlamesFX(1));
        this.renderGlobal = new RenderGlobal(this, this.renderEngine);
        GL11.glViewport(0, 0, this.displayWidth, this.displayHeight);
        this.effectRenderer = new EffectRenderer(this.theWorld, this.renderEngine);

        try
        {
            this.downloadResourcesThread = new ThreadDownloadResources(this.mcDataDir, this);
            this.downloadResourcesThread.start();
        }
        catch (Exception var3)
        {
            ;
        }

        this.checkGLError("Post startup");
        this.ingameGUI = new GuiIngame(this);

        if (this.serverName != null)
        {
            this.displayGuiScreen(new GuiConnecting(this, this.serverName, this.serverPort));
        }
        else
        {
            this.displayGuiScreen(new GuiMainMenu());
        }

        this.loadingScreen = new LoadingScreenRenderer(this);

        if (this.gameSettings.fullScreen && !this.fullscreen)
        {
            this.toggleFullscreen();
        }
    }

    /**
     * Displays a new screen.
     */
    private void loadScreen() throws LWJGLException
    {
        ScaledResolution var1 = new ScaledResolution(this.gameSettings, this.displayWidth, this.displayHeight);
        GL11.glClear(16640);
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        GL11.glOrtho(0.0D, var1.getScaledWidth_double(), var1.getScaledHeight_double(), 0.0D, 1000.0D, 3000.0D);
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
        GL11.glLoadIdentity();
        GL11.glTranslatef(0.0F, 0.0F, -2000.0F);
        GL11.glViewport(0, 0, this.displayWidth, this.displayHeight);
        GL11.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glDisable(GL11.GL_FOG);
        Tessellator var2 = Tessellator.instance;
        GL11.glBindTexture(GL11.GL_TEXTURE_2D, this.renderEngine.getTexture("/title/mojang.png"));
        var2.startDrawingQuads();
        var2.setColorOpaque_I(16777215);
        var2.addVertexWithUV(0.0D, (double)this.displayHeight, 0.0D, 0.0D, 0.0D);
        var2.addVertexWithUV((double)this.displayWidth, (double)this.displayHeight, 0.0D, 0.0D, 0.0D);
        var2.addVertexWithUV((double)this.displayWidth, 0.0D, 0.0D, 0.0D, 0.0D);
        var2.addVertexWithUV(0.0D, 0.0D, 0.0D, 0.0D, 0.0D);
        var2.draw();
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        var2.setColorOpaque_I(16777215);
        short var3 = 256;
        short var4 = 256;
        this.scaledTessellator((var1.getScaledWidth() - var3) / 2, (var1.getScaledHeight() - var4) / 2, 0, 0, var3, var4);
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glDisable(GL11.GL_FOG);
        GL11.glEnable(GL11.GL_ALPHA_TEST);
        GL11.glAlphaFunc(GL11.GL_GREATER, 0.1F);
        Display.swapBuffers();
    }

    /**
     * Loads Tessellator with a scaled resolution
     */
    public void scaledTessellator(int par1, int par2, int par3, int par4, int par5, int par6)
    {
        float var7 = 0.00390625F;
        float var8 = 0.00390625F;
        Tessellator var9 = Tessellator.instance;
        var9.startDrawingQuads();
        var9.addVertexWithUV((double)(par1 + 0), (double)(par2 + par6), 0.0D, (double)((float)(par3 + 0) * var7), (double)((float)(par4 + par6) * var8));
        var9.addVertexWithUV((double)(par1 + par5), (double)(par2 + par6), 0.0D, (double)((float)(par3 + par5) * var7), (double)((float)(par4 + par6) * var8));
        var9.addVertexWithUV((double)(par1 + par5), (double)(par2 + 0), 0.0D, (double)((float)(par3 + par5) * var7), (double)((float)(par4 + 0) * var8));
        var9.addVertexWithUV((double)(par1 + 0), (double)(par2 + 0), 0.0D, (double)((float)(par3 + 0) * var7), (double)((float)(par4 + 0) * var8));
        var9.draw();
    }

    /**
     * gets the working dir (OS specific) for minecraft
     */
    public static File getMinecraftDir()
    {
        if (minecraftDir == null)
        {
            minecraftDir = getAppDir("minecraft");
        }

        return minecraftDir;
    }

    /**
     * gets the working dir (OS specific) for the specific application (which is always minecraft)
     */
    public static File getAppDir(String par0Str)
    {
        String var1 = System.getProperty("user.home", ".");
        File var2;

        switch (EnumOSHelper.field_74533_a[getOs().ordinal()])
        {
            case 1:
            case 2:
                var2 = new File(var1, '.' + par0Str + '/');
                break;

            case 3:
                String var3 = System.getenv("APPDATA");

                if (var3 != null)
                {
                    var2 = new File(var3, "." + par0Str + '/');
                }
                else
                {
                    var2 = new File(var1, '.' + par0Str + '/');
                }

                break;

            case 4:
                var2 = new File(var1, "Library/Application Support/" + par0Str);
                break;

            default:
                var2 = new File(var1, par0Str + '/');
        }

        if (!var2.exists() && !var2.mkdirs())
        {
            throw new RuntimeException("The working directory could not be created: " + var2);
        }
        else
        {
            return var2;
        }
    }

    public static EnumOS getOs()
    {
        String var0 = System.getProperty("os.name").toLowerCase();
        return var0.contains("win") ? EnumOS.WINDOWS : (var0.contains("mac") ? EnumOS.MACOS : (var0.contains("solaris") ? EnumOS.SOLARIS : (var0.contains("sunos") ? EnumOS.SOLARIS : (var0.contains("linux") ? EnumOS.LINUX : (var0.contains("unix") ? EnumOS.LINUX : EnumOS.UNKNOWN)))));
    }

    /**
     * Returns the save loader that is currently being used
     */
    public ISaveFormat getSaveLoader()
    {
        return this.saveLoader;
    }

    /**
     * Sets the argument GuiScreen as the main (topmost visible) screen.
     */
    public void displayGuiScreen(GuiScreen par1GuiScreen)
    {
        if (!(this.currentScreen instanceof GuiErrorScreen))
        {
            if (this.currentScreen != null)
            {
                this.currentScreen.onGuiClosed();
            }

            this.statFileWriter.syncStats();

            if (par1GuiScreen == null && this.theWorld == null)
            {
                par1GuiScreen = new GuiMainMenu();
            }
            else if (par1GuiScreen == null && this.thePlayer.getHealth() <= 0)
            {
                par1GuiScreen = new GuiGameOver();
            }

            if (par1GuiScreen instanceof GuiMainMenu)
            {
                this.gameSettings.showDebugInfo = false;
                this.ingameGUI.getChatGUI().func_73761_a();
            }

            this.currentScreen = (GuiScreen)par1GuiScreen;

            if (par1GuiScreen != null)
            {
                this.setIngameNotInFocus();
                ScaledResolution var2 = new ScaledResolution(this.gameSettings, this.displayWidth, this.displayHeight);
                int var3 = var2.getScaledWidth();
                int var4 = var2.getScaledHeight();
                ((GuiScreen)par1GuiScreen).setWorldAndResolution(this, var3, var4);
                this.skipRenderWorld = false;
            }
            else
            {
                this.setIngameFocus();
            }
        }
    }

    /**
     * Checks for an OpenGL error. If there is one, prints the error ID and error string.
     */
    private void checkGLError(String par1Str)
    {
        int var2 = GL11.glGetError();

        if (var2 != 0)
        {
            String var3 = GLU.gluErrorString(var2);
            System.out.println("########## GL ERROR ##########");
            System.out.println("@ " + par1Str);
            System.out.println(var2 + ": " + var3);
        }
    }

    /**
     * Shuts down the minecraft applet by stopping the resource downloads, and clearing up GL stuff; called when the
     * application (or web page) is exited.
     */
    public void shutdownMinecraftApplet()
    {
        try
        {
            this.statFileWriter.syncStats();

            try
            {
                if (this.downloadResourcesThread != null)
                {
                    this.downloadResourcesThread.closeMinecraft();
                }
            }
            catch (Exception var9)
            {
                ;
            }

            System.out.println("Stopping!");

            try
            {
                this.loadWorld((WorldClient)null);
            }
            catch (Throwable var8)
            {
                ;
            }

            try
            {
                GLAllocation.deleteTexturesAndDisplayLists();
            }
            catch (Throwable var7)
            {
                ;
            }

            this.sndManager.closeMinecraft();
            Mouse.destroy();
            Keyboard.destroy();
        }
        finally
        {
            Display.destroy();

            if (!this.hasCrashed)
            {
                System.exit(0);
            }
        }

        System.gc();
    }

    public void run()
    {
        this.running = true;

        try
        {
            this.startGame();
        }
        catch (Exception var11)
        {
            var11.printStackTrace();
            this.displayCrashReport(this.func_71396_d(new CrashReport("Failed to start game", var11)));
            return;
        }

        try
        {
            while (this.running)
            {
                if (this.hasCrashed && this.crashReporter != null)
                {
                    this.displayCrashReport(this.crashReporter);
                    return;
                }

                if (this.field_71468_ad)
                {
                    this.field_71468_ad = false;
                    this.renderEngine.refreshTextures();
                }

                try
                {
                    this.runGameLoop();
                }
                catch (OutOfMemoryError var10)
                {
                    this.freeMemory();
                    this.displayGuiScreen(new GuiMemoryErrorScreen());
                    System.gc();
                }
            }
        }
        catch (MinecraftError var12)
        {
            ;
        }
        catch (ReportedException var13)
        {
            this.func_71396_d(var13.func_71575_a());
            this.freeMemory();
            var13.printStackTrace();
            this.displayCrashReport(var13.func_71575_a());
        }
        catch (Throwable var14)
        {
            CrashReport var2 = this.func_71396_d(new CrashReport("Unexpected error", var14));
            this.freeMemory();
            var14.printStackTrace();
            this.displayCrashReport(var2);
        }
        finally
        {
            this.shutdownMinecraftApplet();
        }
    }

    /**
     * Called repeatedly from run()
     */
    private void runGameLoop()
    {
        if (this.mcApplet != null && !this.mcApplet.isActive())
        {
            this.running = false;
        }
        else
        {
            AxisAlignedBB.getAABBPool().cleanPool();
            Vec3.getVec3Pool().clear();
            this.mcProfiler.startSection("root");

            if (this.mcCanvas == null && Display.isCloseRequested())
            {
                this.shutdown();
            }

            if (this.isGamePaused && this.theWorld != null)
            {
                float var1 = this.timer.renderPartialTicks;
                this.timer.updateTimer();
                this.timer.renderPartialTicks = var1;
            }
            else
            {
                this.timer.updateTimer();
            }

            long var6 = System.nanoTime();
            this.mcProfiler.startSection("tick");

            for (int var3 = 0; var3 < this.timer.elapsedTicks; ++var3)
            {
                this.runTick();
            }

            this.mcProfiler.endStartSection("preRenderErrors");
            long var7 = System.nanoTime() - var6;
            this.checkGLError("Pre render");
            RenderBlocks.fancyGrass = this.gameSettings.fancyGraphics;
            this.mcProfiler.endStartSection("sound");
            this.sndManager.setListener(this.thePlayer, this.timer.renderPartialTicks);
            this.mcProfiler.endStartSection("updatelights");

            if (this.theWorld != null)
            {
                this.theWorld.updatingLighting();
            }

            this.mcProfiler.endSection();
            this.mcProfiler.startSection("render");
            this.mcProfiler.startSection("display");
            GL11.glEnable(GL11.GL_TEXTURE_2D);

            if (!Keyboard.isKeyDown(65))
            {
                Display.update();
            }

            if (this.thePlayer != null && this.thePlayer.isEntityInsideOpaqueBlock())
            {
                this.gameSettings.thirdPersonView = 0;
            }

            this.mcProfiler.endSection();

            if (!this.skipRenderWorld)
            {
                this.mcProfiler.endStartSection("gameRenderer");
                this.entityRenderer.updateCameraAndRender(this.timer.renderPartialTicks);
                this.mcProfiler.endSection();
            }

            GL11.glFlush();
            this.mcProfiler.endSection();

            if (!Display.isActive() && this.fullscreen)
            {
                this.toggleFullscreen();
            }

            if (this.gameSettings.showDebugInfo && this.gameSettings.field_74329_Q)
            {
                if (!this.mcProfiler.profilingEnabled)
                {
                    this.mcProfiler.clearProfiling();
                }

                this.mcProfiler.profilingEnabled = true;
                this.displayDebugInfo(var7);
            }
            else
            {
                this.mcProfiler.profilingEnabled = false;
                this.prevFrameTime = System.nanoTime();
            }

            this.guiAchievement.updateAchievementWindow();
            this.mcProfiler.startSection("root");
            Thread.yield();

            if (Keyboard.isKeyDown(65))
            {
                Display.update();
            }

            this.screenshotListener();

            if (this.mcCanvas != null && !this.fullscreen && (this.mcCanvas.getWidth() != this.displayWidth || this.mcCanvas.getHeight() != this.displayHeight))
            {
                this.displayWidth = this.mcCanvas.getWidth();
                this.displayHeight = this.mcCanvas.getHeight();

                if (this.displayWidth <= 0)
                {
                    this.displayWidth = 1;
                }

                if (this.displayHeight <= 0)
                {
                    this.displayHeight = 1;
                }

                this.resize(this.displayWidth, this.displayHeight);
            }

            this.checkGLError("Post render");
            ++this.fpsCounter;
            boolean var5 = this.isGamePaused;
            this.isGamePaused = this.isSingleplayer() && this.currentScreen != null && this.currentScreen.doesGuiPauseGame() && !this.theIntegratedServer.func_71344_c();

            if (this.isIntegratedServerRunning() && this.thePlayer != null && this.thePlayer.sendQueue != null && this.isGamePaused != var5)
            {
                ((MemoryConnection)this.thePlayer.sendQueue.getNetManager()).setGamePaused(this.isGamePaused);
            }

            while (getSystemTime() >= this.debugUpdateTime + 1000L)
            {
                field_71470_ab = this.fpsCounter;
                this.debug = field_71470_ab + " fps, " + WorldRenderer.chunksUpdated + " chunk updates";
                WorldRenderer.chunksUpdated = 0;
                this.debugUpdateTime += 1000L;
                this.fpsCounter = 0;
                this.usageSnooper.addMemoryStatsToSnooper();

                if (!this.usageSnooper.isSnooperRunning())
                {
                    this.usageSnooper.startSnooper();
                }
            }

            this.mcProfiler.endSection();

            if (this.gameSettings.limitFramerate > 0)
            {
                EntityRenderer var10000 = this.entityRenderer;
                Display.sync(EntityRenderer.func_78465_a(this.gameSettings.limitFramerate));
            }
        }
    }

    public void freeMemory()
    {
        try
        {
            clientExperience = new byte[0];
            this.renderGlobal.func_72728_f();
        }
        catch (Throwable var4)
        {
            ;
        }

        try
        {
            System.gc();
            AxisAlignedBB.getAABBPool().clearPool();
            Vec3.getVec3Pool().clearAndFreeCache();
        }
        catch (Throwable var3)
        {
            ;
        }

        try
        {
            System.gc();
            this.loadWorld((WorldClient)null);
        }
        catch (Throwable var2)
        {
            ;
        }

        System.gc();
    }

    /**
     * checks if keys are down
     */
    private void screenshotListener()
    {
        if (Keyboard.isKeyDown(60))
        {
            if (!this.isTakingScreenshot)
            {
                this.isTakingScreenshot = true;
                this.ingameGUI.getChatGUI().printChatMessage(ScreenShotHelper.saveScreenshot(minecraftDir, this.displayWidth, this.displayHeight));
            }
        }
        else
        {
            this.isTakingScreenshot = false;
        }
    }

    /**
     * Update debugProfilerName in response to number keys in debug screen
     */
    private void updateDebugProfilerName(int par1)
    {
        List var2 = this.mcProfiler.getProfilingData(this.debugProfilerName);

        if (var2 != null && !var2.isEmpty())
        {
            ProfilerResult var3 = (ProfilerResult)var2.remove(0);

            if (par1 == 0)
            {
                if (var3.field_76331_c.length() > 0)
                {
                    int var4 = this.debugProfilerName.lastIndexOf(".");

                    if (var4 >= 0)
                    {
                        this.debugProfilerName = this.debugProfilerName.substring(0, var4);
                    }
                }
            }
            else
            {
                --par1;

                if (par1 < var2.size() && !((ProfilerResult)var2.get(par1)).field_76331_c.equals("unspecified"))
                {
                    if (this.debugProfilerName.length() > 0)
                    {
                        this.debugProfilerName = this.debugProfilerName + ".";
                    }

                    this.debugProfilerName = this.debugProfilerName + ((ProfilerResult)var2.get(par1)).field_76331_c;
                }
            }
        }
    }

    private void displayDebugInfo(long par1)
    {
        if (this.mcProfiler.profilingEnabled)
        {
            List var3 = this.mcProfiler.getProfilingData(this.debugProfilerName);
            ProfilerResult var4 = (ProfilerResult)var3.remove(0);
            GL11.glClear(256);
            GL11.glMatrixMode(GL11.GL_PROJECTION);
            GL11.glEnable(GL11.GL_COLOR_MATERIAL);
            GL11.glLoadIdentity();
            GL11.glOrtho(0.0D, (double)this.displayWidth, (double)this.displayHeight, 0.0D, 1000.0D, 3000.0D);
            GL11.glMatrixMode(GL11.GL_MODELVIEW);
            GL11.glLoadIdentity();
            GL11.glTranslatef(0.0F, 0.0F, -2000.0F);
            GL11.glLineWidth(1.0F);
            GL11.glDisable(GL11.GL_TEXTURE_2D);
            Tessellator var5 = Tessellator.instance;
            short var6 = 160;
            int var7 = this.displayWidth - var6 - 10;
            int var8 = this.displayHeight - var6 * 2;
            GL11.glEnable(GL11.GL_BLEND);
            var5.startDrawingQuads();
            var5.setColorRGBA_I(0, 200);
            var5.addVertex((double)((float)var7 - (float)var6 * 1.1F), (double)((float)var8 - (float)var6 * 0.6F - 16.0F), 0.0D);
            var5.addVertex((double)((float)var7 - (float)var6 * 1.1F), (double)(var8 + var6 * 2), 0.0D);
            var5.addVertex((double)((float)var7 + (float)var6 * 1.1F), (double)(var8 + var6 * 2), 0.0D);
            var5.addVertex((double)((float)var7 + (float)var6 * 1.1F), (double)((float)var8 - (float)var6 * 0.6F - 16.0F), 0.0D);
            var5.draw();
            GL11.glDisable(GL11.GL_BLEND);
            double var9 = 0.0D;
            int var13;

            for (int var11 = 0; var11 < var3.size(); ++var11)
            {
                ProfilerResult var12 = (ProfilerResult)var3.get(var11);
                var13 = MathHelper.floor_double(var12.field_76332_a / 4.0D) + 1;
                var5.startDrawing(6);
                var5.setColorOpaque_I(var12.func_76329_a());
                var5.addVertex((double)var7, (double)var8, 0.0D);
                int var14;
                float var15;
                float var17;
                float var16;

                for (var14 = var13; var14 >= 0; --var14)
                {
                    var15 = (float)((var9 + var12.field_76332_a * (double)var14 / (double)var13) * Math.PI * 2.0D / 100.0D);
                    var16 = MathHelper.sin(var15) * (float)var6;
                    var17 = MathHelper.cos(var15) * (float)var6 * 0.5F;
                    var5.addVertex((double)((float)var7 + var16), (double)((float)var8 - var17), 0.0D);
                }

                var5.draw();
                var5.startDrawing(5);
                var5.setColorOpaque_I((var12.func_76329_a() & 16711422) >> 1);

                for (var14 = var13; var14 >= 0; --var14)
                {
                    var15 = (float)((var9 + var12.field_76332_a * (double)var14 / (double)var13) * Math.PI * 2.0D / 100.0D);
                    var16 = MathHelper.sin(var15) * (float)var6;
                    var17 = MathHelper.cos(var15) * (float)var6 * 0.5F;
                    var5.addVertex((double)((float)var7 + var16), (double)((float)var8 - var17), 0.0D);
                    var5.addVertex((double)((float)var7 + var16), (double)((float)var8 - var17 + 10.0F), 0.0D);
                }

                var5.draw();
                var9 += var12.field_76332_a;
            }

            DecimalFormat var19 = new DecimalFormat("##0.00");
            GL11.glEnable(GL11.GL_TEXTURE_2D);
            String var18 = "";

            if (!var4.field_76331_c.equals("unspecified"))
            {
                var18 = var18 + "[0] ";
            }

            if (var4.field_76331_c.length() == 0)
            {
                var18 = var18 + "ROOT ";
            }
            else
            {
                var18 = var18 + var4.field_76331_c + " ";
            }

            var13 = 16777215;
            this.fontRenderer.drawStringWithShadow(var18, var7 - var6, var8 - var6 / 2 - 16, var13);
            this.fontRenderer.drawStringWithShadow(var18 = var19.format(var4.field_76330_b) + "%", var7 + var6 - this.fontRenderer.getStringWidth(var18), var8 - var6 / 2 - 16, var13);

            for (int var21 = 0; var21 < var3.size(); ++var21)
            {
                ProfilerResult var20 = (ProfilerResult)var3.get(var21);
                String var22 = "";

                if (var20.field_76331_c.equals("unspecified"))
                {
                    var22 = var22 + "[?] ";
                }
                else
                {
                    var22 = var22 + "[" + (var21 + 1) + "] ";
                }

                var22 = var22 + var20.field_76331_c;
                this.fontRenderer.drawStringWithShadow(var22, var7 - var6, var8 + var6 / 2 + var21 * 8 + 20, var20.func_76329_a());
                this.fontRenderer.drawStringWithShadow(var22 = var19.format(var20.field_76332_a) + "%", var7 + var6 - 50 - this.fontRenderer.getStringWidth(var22), var8 + var6 / 2 + var21 * 8 + 20, var20.func_76329_a());
                this.fontRenderer.drawStringWithShadow(var22 = var19.format(var20.field_76330_b) + "%", var7 + var6 - this.fontRenderer.getStringWidth(var22), var8 + var6 / 2 + var21 * 8 + 20, var20.func_76329_a());
            }
        }
    }

    /**
     * Called when the window is closing. Sets 'running' to false which allows the game loop to exit cleanly.
     */
    public void shutdown()
    {
        this.running = false;
    }

    /**
     * Will set the focus to ingame if the Minecraft window is the active with focus. Also clears any GUI screen
     * currently displayed
     */
    public void setIngameFocus()
    {
        if (Display.isActive())
        {
            if (!this.inGameHasFocus)
            {
                this.inGameHasFocus = true;
                this.mouseHelper.grabMouseCursor();
                this.displayGuiScreen((GuiScreen)null);
                this.leftClickCounter = 10000;
            }
        }
    }

    /**
     * Resets the player keystate, disables the ingame focus, and ungrabs the mouse cursor.
     */
    public void setIngameNotInFocus()
    {
        if (this.inGameHasFocus)
        {
            KeyBinding.unPressAllKeys();
            this.inGameHasFocus = false;
            this.mouseHelper.ungrabMouseCursor();
        }
    }

    /**
     * Displays the ingame menu
     */
    public void displayInGameMenu()
    {
        if (this.currentScreen == null)
        {
            this.displayGuiScreen(new GuiIngameMenu());
        }
    }

    private void sendClickBlockToController(int par1, boolean par2)
    {
        if (!par2)
        {
            this.leftClickCounter = 0;
        }

        if (par1 != 0 || this.leftClickCounter <= 0)
        {
            if (par2 && this.objectMouseOver != null && this.objectMouseOver.typeOfHit == EnumMovingObjectType.TILE && par1 == 0)
            {
                int var3 = this.objectMouseOver.blockX;
                int var4 = this.objectMouseOver.blockY;
                int var5 = this.objectMouseOver.blockZ;
                this.playerController.onPlayerDamageBlock(var3, var4, var5, this.objectMouseOver.sideHit);

                if (this.thePlayer.canPlayerEdit(var3, var4, var5))
                {
                    this.effectRenderer.addBlockHitEffects(var3, var4, var5, this.objectMouseOver.sideHit);
                    this.thePlayer.swingItem();
                }
            }
            else
            {
                this.playerController.resetBlockRemoving();
            }
        }
    }

    /**
     * Called whenever the mouse is clicked. Button clicked is 0 for left clicking and 1 for right clicking. Args:
     * buttonClicked
     */
    private void clickMouse(int par1)
    {
        if (par1 != 0 || this.leftClickCounter <= 0)
        {
            if (par1 == 0)
            {
                this.thePlayer.swingItem();
            }

            if (par1 == 1)
            {
                this.rightClickDelayTimer = 4;
            }

            boolean var2 = true;
            ItemStack var3 = this.thePlayer.inventory.getCurrentItem();

            if (this.objectMouseOver == null)
            {
                if (par1 == 0 && this.playerController.isNotCreative())
                {
                    this.leftClickCounter = 10;
                }
            }
            else if (this.objectMouseOver.typeOfHit == EnumMovingObjectType.ENTITY)
            {
                if (par1 == 0)
                {
                    this.playerController.attackEntity(this.thePlayer, this.objectMouseOver.entityHit);
                }

                if (par1 == 1 && this.playerController.func_78768_b(this.thePlayer, this.objectMouseOver.entityHit))
                {
                    var2 = false;
                }
            }
            else if (this.objectMouseOver.typeOfHit == EnumMovingObjectType.TILE)
            {
                int var4 = this.objectMouseOver.blockX;
                int var5 = this.objectMouseOver.blockY;
                int var6 = this.objectMouseOver.blockZ;
                int var7 = this.objectMouseOver.sideHit;

                if (par1 == 0)
                {
                    this.playerController.clickBlock(var4, var5, var6, this.objectMouseOver.sideHit);
                }
                else
                {
                    int var8 = var3 != null ? var3.stackSize : 0;

                    if (this.playerController.onPlayerRightClick(this.thePlayer, this.theWorld, var3, var4, var5, var6, var7, this.objectMouseOver.hitVec))
                    {
                        var2 = false;
                        this.thePlayer.swingItem();
                    }

                    if (var3 == null)
                    {
                        return;
                    }

                    if (var3.stackSize == 0)
                    {
                        this.thePlayer.inventory.mainInventory[this.thePlayer.inventory.currentItem] = null;
                    }
                    else if (var3.stackSize != var8 || this.playerController.isInCreativeMode())
                    {
                        this.entityRenderer.itemRenderer.func_78444_b();
                    }
                }
            }

            if (var2 && par1 == 1)
            {
                ItemStack var9 = this.thePlayer.inventory.getCurrentItem();

                if (var9 != null && this.playerController.sendUseItem(this.thePlayer, this.theWorld, var9))
                {
                    this.entityRenderer.itemRenderer.func_78445_c();
                }
            }
        }
    }

    /**
     * Toggles fullscreen mode.
     */
    public void toggleFullscreen()
    {
        try
        {
            this.fullscreen = !this.fullscreen;

            if (this.fullscreen)
            {
                Display.setDisplayMode(Display.getDesktopDisplayMode());
                this.displayWidth = Display.getDisplayMode().getWidth();
                this.displayHeight = Display.getDisplayMode().getHeight();

                if (this.displayWidth <= 0)
                {
                    this.displayWidth = 1;
                }

                if (this.displayHeight <= 0)
                {
                    this.displayHeight = 1;
                }
            }
            else
            {
                if (this.mcCanvas != null)
                {
                    this.displayWidth = this.mcCanvas.getWidth();
                    this.displayHeight = this.mcCanvas.getHeight();
                }
                else
                {
                    this.displayWidth = this.tempDisplayWidth;
                    this.displayHeight = this.tempDisplayHeight;
                }

                if (this.displayWidth <= 0)
                {
                    this.displayWidth = 1;
                }

                if (this.displayHeight <= 0)
                {
                    this.displayHeight = 1;
                }
            }

            if (this.currentScreen != null)
            {
                this.resize(this.displayWidth, this.displayHeight);
            }

            Display.setFullscreen(this.fullscreen);
            Display.setVSyncEnabled(this.gameSettings.enableVsync);
            Display.update();
        }
        catch (Exception var2)
        {
            var2.printStackTrace();
        }
    }

    /**
     * Called to resize the current screen.
     */
    private void resize(int par1, int par2)
    {
        this.displayWidth = par1 <= 0 ? 1 : par1;
        this.displayHeight = par2 <= 0 ? 1 : par2;

        if (this.currentScreen != null)
        {
            ScaledResolution var3 = new ScaledResolution(this.gameSettings, par1, par2);
            int var4 = var3.getScaledWidth();
            int var5 = var3.getScaledHeight();
            this.currentScreen.setWorldAndResolution(this, var4, var5);
        }
    }

    /**
     * Runs the current tick.
     */
    public void runTick()
    {
        if (this.rightClickDelayTimer > 0)
        {
            --this.rightClickDelayTimer;
        }

        this.mcProfiler.startSection("stats");
        this.statFileWriter.func_77449_e();
        this.mcProfiler.endStartSection("gui");

        if (!this.isGamePaused)
        {
            this.ingameGUI.updateTick();
        }

        this.mcProfiler.endStartSection("pick");
        this.entityRenderer.getMouseOver(1.0F);
        this.mcProfiler.endStartSection("gameMode");

        if (!this.isGamePaused && this.theWorld != null)
        {
            this.playerController.updateController();
        }

        GL11.glBindTexture(GL11.GL_TEXTURE_2D, this.renderEngine.getTexture("/terrain.png"));
        this.mcProfiler.endStartSection("textures");

        if (!this.isGamePaused)
        {
            this.renderEngine.updateDynamicTextures();
        }

        if (this.currentScreen == null && this.thePlayer != null)
        {
            if (this.thePlayer.getHealth() <= 0)
            {
                this.displayGuiScreen((GuiScreen)null);
            }
            else if (this.thePlayer.isPlayerSleeping() && this.theWorld != null)
            {
                this.displayGuiScreen(new GuiSleepMP());
            }
        }
        else if (this.currentScreen != null && this.currentScreen instanceof GuiSleepMP && !this.thePlayer.isPlayerSleeping())
        {
            this.displayGuiScreen((GuiScreen)null);
        }

        if (this.currentScreen != null)
        {
            this.leftClickCounter = 10000;
        }

        if (this.currentScreen != null)
        {
            this.currentScreen.handleInput();

            if (this.currentScreen != null)
            {
                this.currentScreen.guiParticles.update();
                this.currentScreen.updateScreen();
            }
        }

        if (this.currentScreen == null || this.currentScreen.allowUserInput)
        {
            this.mcProfiler.endStartSection("mouse");

            while (Mouse.next())
            {
                KeyBinding.setKeyBindState(Mouse.getEventButton() - 100, Mouse.getEventButtonState());

                if (Mouse.getEventButtonState())
                {
                    KeyBinding.onTick(Mouse.getEventButton() - 100);
                }

                long var1 = getSystemTime() - this.systemTime;

                if (var1 <= 200L)
                {
                    int var3 = Mouse.getEventDWheel();

                    if (var3 != 0)
                    {
                        this.thePlayer.inventory.changeCurrentItem(var3);

                        if (this.gameSettings.noclip)
                        {
                            if (var3 > 0)
                            {
                                var3 = 1;
                            }

                            if (var3 < 0)
                            {
                                var3 = -1;
                            }

                            this.gameSettings.noclipRate += (float)var3 * 0.25F;
                        }
                    }

                    if (this.currentScreen == null)
                    {
                        if (!this.inGameHasFocus && Mouse.getEventButtonState())
                        {
                            this.setIngameFocus();
                        }
                    }
                    else if (this.currentScreen != null)
                    {
                        this.currentScreen.handleMouseInput();
                    }
                }
            }

            if (this.leftClickCounter > 0)
            {
                --this.leftClickCounter;
            }

            this.mcProfiler.endStartSection("keyboard");
            boolean var4;

            while (Keyboard.next())
            {
                KeyBinding.setKeyBindState(Keyboard.getEventKey(), Keyboard.getEventKeyState());

                if (Keyboard.getEventKeyState())
                {
                    KeyBinding.onTick(Keyboard.getEventKey());
                }

                if (Keyboard.getEventKeyState())
                {
                    if (Keyboard.getEventKey() == 87)
                    {
                        this.toggleFullscreen();
                    }
                    else
                    {
                        if (this.currentScreen != null)
                        {
                            this.currentScreen.handleKeyboardInput();
                        }
                        else
                        {
                            if (Keyboard.getEventKey() == 1)
                            {
                                this.displayInGameMenu();
                            }

                            if (Keyboard.getEventKey() == 31 && Keyboard.isKeyDown(61))
                            {
                                this.forceReload();
                            }

                            if (Keyboard.getEventKey() == 20 && Keyboard.isKeyDown(61))
                            {
                                this.renderEngine.refreshTextures();
                            }

                            if (Keyboard.getEventKey() == 33 && Keyboard.isKeyDown(61))
                            {
                                var4 = Keyboard.isKeyDown(42) | Keyboard.isKeyDown(54);
                                this.gameSettings.setOptionValue(EnumOptions.RENDER_DISTANCE, var4 ? -1 : 1);
                            }

                            if (Keyboard.getEventKey() == 30 && Keyboard.isKeyDown(61))
                            {
                                this.renderGlobal.loadRenderers();
                            }

                            if (Keyboard.getEventKey() == 59)
                            {
                                this.gameSettings.hideGUI = !this.gameSettings.hideGUI;
                            }

                            if (Keyboard.getEventKey() == 61)
                            {
                                this.gameSettings.showDebugInfo = !this.gameSettings.showDebugInfo;
                                this.gameSettings.field_74329_Q = !GuiScreen.isShiftKeyDown();
                            }

                            if (Keyboard.getEventKey() == 63)
                            {
                                ++this.gameSettings.thirdPersonView;

                                if (this.gameSettings.thirdPersonView > 2)
                                {
                                    this.gameSettings.thirdPersonView = 0;
                                }
                            }

                            if (Keyboard.getEventKey() == 66)
                            {
                                this.gameSettings.smoothCamera = !this.gameSettings.smoothCamera;
                            }
                        }

                        int var5;

                        for (var5 = 0; var5 < 9; ++var5)
                        {
                            if (Keyboard.getEventKey() == 2 + var5)
                            {
                                this.thePlayer.inventory.currentItem = var5;
                            }
                        }

                        if (this.gameSettings.showDebugInfo && this.gameSettings.field_74329_Q)
                        {
                            if (Keyboard.getEventKey() == 11)
                            {
                                this.updateDebugProfilerName(0);
                            }

                            for (var5 = 0; var5 < 9; ++var5)
                            {
                                if (Keyboard.getEventKey() == 2 + var5)
                                {
                                    this.updateDebugProfilerName(var5 + 1);
                                }
                            }
                        }
                    }
                }
            }

            var4 = this.gameSettings.chatVisibility != 2;

            while (this.gameSettings.keyBindInventory.isPressed())
            {
                this.displayGuiScreen(new GuiInventory(this.thePlayer));
            }

            while (this.gameSettings.keyBindDrop.isPressed())
            {
                this.thePlayer.dropOneItem();
            }

            while (this.gameSettings.keyBindChat.isPressed() && var4)
            {
                this.displayGuiScreen(new GuiChat());
            }

            if (this.currentScreen == null && this.gameSettings.field_74323_J.isPressed() && var4)
            {
                this.displayGuiScreen(new GuiChat("/"));
            }

            if (this.thePlayer.isUsingItem())
            {
                if (!this.gameSettings.keyBindUseItem.pressed)
                {
                    this.playerController.onStoppedUsingItem(this.thePlayer);
                }

                label309:

                while (true)
                {
                    if (!this.gameSettings.keyBindAttack.isPressed())
                    {
                        while (this.gameSettings.keyBindUseItem.isPressed())
                        {
                            ;
                        }

                        while (true)
                        {
                            if (this.gameSettings.keyBindPickBlock.isPressed())
                            {
                                continue;
                            }

                            break label309;
                        }
                    }
                }
            }
            else
            {
                while (this.gameSettings.keyBindAttack.isPressed())
                {
                    this.clickMouse(0);
                }

                while (this.gameSettings.keyBindUseItem.isPressed())
                {
                    this.clickMouse(1);
                }

                while (this.gameSettings.keyBindPickBlock.isPressed())
                {
                    this.clickMiddleMouseButton();
                }
            }

            if (this.gameSettings.keyBindUseItem.pressed && this.rightClickDelayTimer == 0 && !this.thePlayer.isUsingItem())
            {
                this.clickMouse(1);
            }

            this.sendClickBlockToController(0, this.currentScreen == null && this.gameSettings.keyBindAttack.pressed && this.inGameHasFocus);
        }

        if (this.theWorld != null)
        {
            if (this.thePlayer != null)
            {
                ++this.joinPlayerCounter;

                if (this.joinPlayerCounter == 30)
                {
                    this.joinPlayerCounter = 0;
                    this.theWorld.joinEntityInSurroundings(this.thePlayer);
                }
            }

            this.mcProfiler.endStartSection("gameRenderer");

            if (!this.isGamePaused)
            {
                this.entityRenderer.updateRenderer();
            }

            this.mcProfiler.endStartSection("levelRenderer");

            if (!this.isGamePaused)
            {
                this.renderGlobal.updateClouds();
            }

            this.mcProfiler.endStartSection("level");

            if (!this.isGamePaused)
            {
                if (this.theWorld.lightningFlash > 0)
                {
                    --this.theWorld.lightningFlash;
                }

                this.theWorld.updateEntities();
            }

            if (!this.isGamePaused)
            {
                this.theWorld.setAllowedSpawnTypes(this.theWorld.difficultySetting > 0, true);
                this.theWorld.tick();
            }

            this.mcProfiler.endStartSection("animateTick");

            if (!this.isGamePaused && this.theWorld != null)
            {
                this.theWorld.func_73029_E(MathHelper.floor_double(this.thePlayer.posX), MathHelper.floor_double(this.thePlayer.posY), MathHelper.floor_double(this.thePlayer.posZ));
            }

            this.mcProfiler.endStartSection("particles");

            if (!this.isGamePaused)
            {
                this.effectRenderer.updateEffects();
            }
        }
        else if (this.myNetworkManager != null)
        {
            this.mcProfiler.endStartSection("pendingConnection");
            this.myNetworkManager.processReadPackets();
        }

        this.mcProfiler.endSection();
        this.systemTime = getSystemTime();
    }

    /**
     * Forces a reload of the sound manager and all the resources. Called in game by holding 'F3' and pressing 'S'.
     */
    private void forceReload()
    {
        System.out.println("FORCING RELOAD!");
        this.sndManager = new SoundManager();
        this.sndManager.loadSoundSettings(this.gameSettings);
        this.downloadResourcesThread.reloadResources();
    }

    /**
     * Arguments: World foldername,  World ingame name, WorldSettings
     */
    public void launchIntegratedServer(String par1Str, String par2Str, WorldSettings par3WorldSettings)
    {
        this.loadWorld((WorldClient)null);
        System.gc();
        ISaveHandler var4 = this.saveLoader.getSaveLoader(par1Str, false);
        WorldInfo var5 = var4.loadWorldInfo();

        if (var5 == null && par3WorldSettings != null)
        {
            this.statFileWriter.readStat(StatList.createWorldStat, 1);
            var5 = new WorldInfo(par3WorldSettings, par1Str);
            var4.saveWorldInfo(var5);
        }

        if (par3WorldSettings == null)
        {
            par3WorldSettings = new WorldSettings(var5);
        }

        this.statFileWriter.readStat(StatList.startGameStat, 1);
        this.theIntegratedServer = new IntegratedServer(this, par1Str, par2Str, par3WorldSettings);
        this.theIntegratedServer.startServerThread();
        this.integratedServerIsRunning = true;
        this.loadingScreen.displayProgressMessage(StatCollector.translateToLocal("menu.loadingLevel"));

        while (!this.theIntegratedServer.serverIsInRunLoop())
        {
            String var6 = this.theIntegratedServer.getUserMessage();

            if (var6 != null)
            {
                this.loadingScreen.resetProgresAndWorkingMessage(StatCollector.translateToLocal(var6));
            }
            else
            {
                this.loadingScreen.resetProgresAndWorkingMessage("");
            }

            try
            {
                Thread.sleep(200L);
            }
            catch (InterruptedException var9)
            {
                ;
            }
        }

        this.displayGuiScreen((GuiScreen)null);

        try
        {
            NetClientHandler var10 = new NetClientHandler(this, this.theIntegratedServer);
            this.myNetworkManager = var10.getNetManager();
        }
        catch (IOException var8)
        {
            this.displayCrashReport(this.func_71396_d(new CrashReport("Connecting to integrated server", var8)));
        }
    }

    /**
     * unloads the current world first
     */
    public void loadWorld(WorldClient par1WorldClient)
    {
        this.loadWorld(par1WorldClient, "");
    }

    /**
     * par2Str is displayed on the loading screen to the user unloads the current world first
     */
    public void loadWorld(WorldClient par1WorldClient, String par2Str)
    {
        this.statFileWriter.syncStats();

        if (par1WorldClient == null)
        {
            NetClientHandler var3 = this.getSendQueue();

            if (var3 != null)
            {
                var3.cleanup();
            }

            if (this.myNetworkManager != null)
            {
                this.myNetworkManager.closeConnections();
            }

            if (this.theIntegratedServer != null)
            {
                this.theIntegratedServer.setServerStopping();
            }

            this.theIntegratedServer = null;
        }

        this.renderViewEntity = null;
        this.myNetworkManager = null;

        if (this.loadingScreen != null)
        {
            this.loadingScreen.resetProgressAndMessage(par2Str);
            this.loadingScreen.resetProgresAndWorkingMessage("");
        }

        if (par1WorldClient == null && this.theWorld != null)
        {
            if (this.texturePackList.func_77295_a())
            {
                this.texturePackList.func_77304_b();
            }

            this.setServerData((ServerData)null);
            this.integratedServerIsRunning = false;
        }

        this.sndManager.playStreaming((String)null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.theWorld = par1WorldClient;

        if (par1WorldClient != null)
        {
            if (this.renderGlobal != null)
            {
                this.renderGlobal.setWorldAndLoadRenderers(par1WorldClient);
            }

            if (this.effectRenderer != null)
            {
                this.effectRenderer.clearEffects(par1WorldClient);
            }

            if (this.thePlayer == null)
            {
                this.thePlayer = this.playerController.func_78754_a(par1WorldClient);
                this.playerController.flipPlayer(this.thePlayer);
            }

            this.thePlayer.preparePlayerToSpawn();
            par1WorldClient.spawnEntityInWorld(this.thePlayer);
            this.thePlayer.movementInput = new MovementInputFromOptions(this.gameSettings);
            this.playerController.func_78748_a(this.thePlayer);
            this.renderViewEntity = this.thePlayer;
        }
        else
        {
            this.saveLoader.flushCache();
            this.thePlayer = null;
        }

        System.gc();
        this.systemTime = 0L;
    }

    /**
     * Installs a resource. Currently only sounds are download so this method just adds them to the SoundManager.
     */
    public void installResource(String par1Str, File par2File)
    {
        int var3 = par1Str.indexOf("/");
        String var4 = par1Str.substring(0, var3);
        par1Str = par1Str.substring(var3 + 1);

        if (!var4.equalsIgnoreCase("sound") && !var4.equalsIgnoreCase("newsound"))
        {
            if (var4.equalsIgnoreCase("streaming"))
            {
                this.sndManager.addStreaming(par1Str, par2File);
            }
            else if (var4.equalsIgnoreCase("music") || var4.equalsIgnoreCase("newmusic"))
            {
                this.sndManager.addMusic(par1Str, par2File);
            }
        }
        else
        {
            this.sndManager.addSound(par1Str, par2File);
        }
    }

    /**
     * A String of renderGlobal.getDebugInfoRenders
     */
    public String debugInfoRenders()
    {
        return this.renderGlobal.getDebugInfoRenders();
    }

    /**
     * Gets the information in the F3 menu about how many entities are infront/around you
     */
    public String getEntityDebug()
    {
        return this.renderGlobal.getDebugInfoEntities();
    }

    /**
     * Gets the name of the world's current chunk provider
     */
    public String getWorldProviderName()
    {
        return this.theWorld.getProviderName();
    }

    /**
     * A String of how many entities are in the world
     */
    public String debugInfoEntities()
    {
        return "P: " + this.effectRenderer.getStatistics() + ". T: " + this.theWorld.getDebugLoadedEntities();
    }

    public void setDimensionAndSpawnPlayer(int par1)
    {
        this.theWorld.setSpawnLocation();
        this.theWorld.removeAllEntities();
        int var2 = 0;

        if (this.thePlayer != null)
        {
            var2 = this.thePlayer.entityId;
            this.theWorld.setEntityDead(this.thePlayer);
        }

        this.renderViewEntity = null;
        this.thePlayer = this.playerController.func_78754_a(this.theWorld);
        this.thePlayer.dimension = par1;
        this.renderViewEntity = this.thePlayer;
        this.thePlayer.preparePlayerToSpawn();
        this.theWorld.spawnEntityInWorld(this.thePlayer);
        this.playerController.flipPlayer(this.thePlayer);
        this.thePlayer.movementInput = new MovementInputFromOptions(this.gameSettings);
        this.thePlayer.entityId = var2;
        this.playerController.func_78748_a(this.thePlayer);

        if (this.currentScreen instanceof GuiGameOver)
        {
            this.displayGuiScreen((GuiScreen)null);
        }
    }

    /**
     * Sets whether this is a demo or not.
     */
    void setDemo(boolean par1)
    {
        this.isDemo = par1;
    }

    /**
     * Gets whether this is a demo or not.
     */
    public final boolean isDemo()
    {
        return this.isDemo;
    }

    /**
     * get the client packet send queue
     */
    public NetClientHandler getSendQueue()
    {
        return this.thePlayer != null ? this.thePlayer.sendQueue : null;
    }

    public static void main(String[] par0ArrayOfStr)
    {
        HashMap var1 = new HashMap();
        boolean var2 = false;
        boolean var3 = true;
        boolean var4 = false;
        String var5 = "Player" + getSystemTime() % 1000L;

        if (par0ArrayOfStr.length > 0)
        {
            var5 = par0ArrayOfStr[0];
        }

        String var6 = "-";

        if (par0ArrayOfStr.length > 1)
        {
            var6 = par0ArrayOfStr[1];
        }

        for (int var7 = 2; var7 < par0ArrayOfStr.length; ++var7)
        {
            String var8 = par0ArrayOfStr[var7];
            String var10000;

            if (var7 == par0ArrayOfStr.length - 1)
            {
                var10000 = null;
            }
            else
            {
                var10000 = par0ArrayOfStr[var7 + 1];
            }

            boolean var10 = false;

            if (!var8.equals("-demo") && !var8.equals("--demo"))
            {
                if (var8.equals("--applet"))
                {
                    var3 = false;
                }
            }
            else
            {
                var2 = true;
            }

            if (var10)
            {
                ++var7;
            }
        }

        var1.put("demo", "" + var2);
        var1.put("stand-alone", "" + var3);
        var1.put("username", var5);
        var1.put("fullscreen", "" + var4);
        var1.put("sessionid", var6);
        Frame var12 = new Frame();
        var12.setTitle("Minecraft");
        var12.setBackground(Color.BLACK);
        JPanel var11 = new JPanel();
        var12.setLayout(new BorderLayout());
        var11.setPreferredSize(new Dimension(854, 480));
        var12.add(var11, "Center");
        var12.pack();
        var12.setLocationRelativeTo((Component)null);
        var12.setVisible(true);
        var12.addWindowListener(new GameWindowListener());
        MinecraftFakeLauncher var9 = new MinecraftFakeLauncher(var1);
        MinecraftApplet var13 = new MinecraftApplet();
        var13.setStub(var9);
        var9.setLayout(new BorderLayout());
        var9.add(var13, "Center");
        var9.validate();
        var12.removeAll();
        var12.setLayout(new BorderLayout());
        var12.add(var9, "Center");
        var12.validate();
        var13.init();
        var13.start();
        Runtime.getRuntime().addShutdownHook(new ThreadShutdown());
    }

    public static boolean isGuiEnabled()
    {
        return theMinecraft == null || !theMinecraft.gameSettings.hideGUI;
    }

    public static boolean isFancyGraphicsEnabled()
    {
        return theMinecraft != null && theMinecraft.gameSettings.fancyGraphics;
    }

    /**
     * Returns if ambient occlusion is enabled
     */
    public static boolean isAmbientOcclusionEnabled()
    {
        return theMinecraft != null && theMinecraft.gameSettings.ambientOcclusion;
    }

    public static boolean isDebugInfoEnabled()
    {
        return theMinecraft != null && theMinecraft.gameSettings.showDebugInfo;
    }

    /**
     * Returns true if the message is a client command and should not be sent to the server. However there are no such
     * commands at this point in time.
     */
    public boolean handleClientCommand(String par1Str)
    {
        return !par1Str.startsWith("/") ? false : false;
    }

    /**
     * Called when the middle mouse button gets clicked
     */
    private void clickMiddleMouseButton()
    {
        if (this.objectMouseOver != null)
        {
            boolean var1 = this.thePlayer.capabilities.isCreativeMode;
            int var3 = 0;
            boolean var4 = false;
            int var2;
            int var5;

            if (this.objectMouseOver.typeOfHit == EnumMovingObjectType.TILE)
            {
                var5 = this.objectMouseOver.blockX;
                int var6 = this.objectMouseOver.blockY;
                int var7 = this.objectMouseOver.blockZ;
                Block var8 = Block.blocksList[this.theWorld.getBlockId(var5, var6, var7)];

                if (var8 == null)
                {
                    return;
                }

                var2 = var8.idPicked(this.theWorld, var5, var6, var7);

                if (var2 == 0)
                {
                    return;
                }

                var4 = Item.itemsList[var2].getHasSubtypes();
                int var9 = var2 >= 256 ? var8.blockID : var2;
                var3 = Block.blocksList[var9].getDamageValue(this.theWorld, var5, var6, var7);
            }
            else
            {
                if (this.objectMouseOver.typeOfHit != EnumMovingObjectType.ENTITY || this.objectMouseOver.entityHit == null || !var1)
                {
                    return;
                }

                if (this.objectMouseOver.entityHit instanceof EntityPainting)
                {
                    var2 = Item.painting.shiftedIndex;
                }
                else if (this.objectMouseOver.entityHit instanceof EntityMinecart)
                {
                    EntityMinecart var10 = (EntityMinecart)this.objectMouseOver.entityHit;

                    if (var10.minecartType == 2)
                    {
                        var2 = Item.minecartPowered.shiftedIndex;
                    }
                    else if (var10.minecartType == 1)
                    {
                        var2 = Item.minecartCrate.shiftedIndex;
                    }
                    else
                    {
                        var2 = Item.minecartEmpty.shiftedIndex;
                    }
                }
                else if (this.objectMouseOver.entityHit instanceof EntityBoat)
                {
                    var2 = Item.boat.shiftedIndex;
                }
                else
                {
                    var2 = Item.monsterPlacer.shiftedIndex;
                    var3 = EntityList.getEntityID(this.objectMouseOver.entityHit);
                    var4 = true;

                    if (var3 <= 0 || !EntityList.entityEggs.containsKey(Integer.valueOf(var3)))
                    {
                        return;
                    }
                }
            }

            this.thePlayer.inventory.setCurrentItem(var2, var3, var4, var1);

            if (var1)
            {
                var5 = this.thePlayer.inventorySlots.inventorySlots.size() - 9 + this.thePlayer.inventory.currentItem;
                this.playerController.sendSlotPacket(this.thePlayer.inventory.getStackInSlot(this.thePlayer.inventory.currentItem), var5);
            }
        }
    }

    public CrashReport func_71396_d(CrashReport par1CrashReport)
    {
        par1CrashReport.addCrashSectionCallable("LWJGL", new CallableLWJGLVersion(this));
        par1CrashReport.addCrashSectionCallable("OpenGL", new CallableGLInfo(this));
        par1CrashReport.addCrashSectionCallable("Is Modded", new CallableModded(this));
        par1CrashReport.addCrashSectionCallable("Type", new CallableType2(this));
        par1CrashReport.addCrashSectionCallable("Texture Pack", new CallableTexturePack(this));
        par1CrashReport.addCrashSectionCallable("Profiler Position", new CallableClientProfiler(this));

        if (this.theWorld != null)
        {
            this.theWorld.addWorldInfoToCrashReport(par1CrashReport);
        }

        return par1CrashReport;
    }

    /**
     * Return the singleton Minecraft instance for the game
     */
    public static Minecraft getMinecraft()
    {
        return theMinecraft;
    }

    public void func_71395_y()
    {
        this.field_71468_ad = true;
    }

    public void addServerStatsToSnooper(PlayerUsageSnooper par1PlayerUsageSnooper)
    {
        par1PlayerUsageSnooper.addData("fps", Integer.valueOf(field_71470_ab));
        par1PlayerUsageSnooper.addData("texpack_name", this.texturePackList.getSelectedTexturePack().func_77538_c());
        par1PlayerUsageSnooper.addData("texpack_resolution", Integer.valueOf(this.texturePackList.getSelectedTexturePack().func_77534_f()));
        par1PlayerUsageSnooper.addData("vsync_enabled", Boolean.valueOf(this.gameSettings.enableVsync));
        par1PlayerUsageSnooper.addData("display_frequency", Integer.valueOf(Display.getDisplayMode().getFrequency()));
        par1PlayerUsageSnooper.addData("display_type", this.fullscreen ? "fullscreen" : "windowed");

        if (this.theIntegratedServer != null && this.theIntegratedServer.func_80003_ah() != null)
        {
            par1PlayerUsageSnooper.addData("snooper_partner", this.theIntegratedServer.func_80003_ah().func_80006_f());
        }
    }

    public void addServerTypeToSnooper(PlayerUsageSnooper par1PlayerUsageSnooper)
    {
        par1PlayerUsageSnooper.addData("opengl_version", GL11.glGetString(GL11.GL_VERSION));
        par1PlayerUsageSnooper.addData("opengl_vendor", GL11.glGetString(GL11.GL_VENDOR));
        par1PlayerUsageSnooper.addData("client_brand", ClientBrandRetriever.getClientModName());
        par1PlayerUsageSnooper.addData("applet", Boolean.valueOf(this.hideQuitButton));
        ContextCapabilities var2 = GLContext.getCapabilities();
        par1PlayerUsageSnooper.addData("gl_caps[ARB_multitexture]", Boolean.valueOf(var2.GL_ARB_multitexture));
        par1PlayerUsageSnooper.addData("gl_caps[ARB_multisample]", Boolean.valueOf(var2.GL_ARB_multisample));
        par1PlayerUsageSnooper.addData("gl_caps[ARB_texture_cube_map]", Boolean.valueOf(var2.GL_ARB_texture_cube_map));
        par1PlayerUsageSnooper.addData("gl_caps[ARB_vertex_blend]", Boolean.valueOf(var2.GL_ARB_vertex_blend));
        par1PlayerUsageSnooper.addData("gl_caps[ARB_matrix_palette]", Boolean.valueOf(var2.GL_ARB_matrix_palette));
        par1PlayerUsageSnooper.addData("gl_caps[ARB_vertex_program]", Boolean.valueOf(var2.GL_ARB_vertex_program));
        par1PlayerUsageSnooper.addData("gl_caps[ARB_vertex_shader]", Boolean.valueOf(var2.GL_ARB_vertex_shader));
        par1PlayerUsageSnooper.addData("gl_caps[ARB_fragment_program]", Boolean.valueOf(var2.GL_ARB_fragment_program));
        par1PlayerUsageSnooper.addData("gl_caps[ARB_fragment_shader]", Boolean.valueOf(var2.GL_ARB_fragment_shader));
        par1PlayerUsageSnooper.addData("gl_caps[ARB_shader_objects]", Boolean.valueOf(var2.GL_ARB_shader_objects));
        par1PlayerUsageSnooper.addData("gl_caps[ARB_vertex_buffer_object]", Boolean.valueOf(var2.GL_ARB_vertex_buffer_object));
        par1PlayerUsageSnooper.addData("gl_caps[ARB_framebuffer_object]", Boolean.valueOf(var2.GL_ARB_framebuffer_object));
        par1PlayerUsageSnooper.addData("gl_caps[ARB_pixel_buffer_object]", Boolean.valueOf(var2.GL_ARB_pixel_buffer_object));
        par1PlayerUsageSnooper.addData("gl_caps[ARB_uniform_buffer_object]", Boolean.valueOf(var2.GL_ARB_uniform_buffer_object));
        par1PlayerUsageSnooper.addData("gl_caps[ARB_texture_non_power_of_two]", Boolean.valueOf(var2.GL_ARB_texture_non_power_of_two));
        par1PlayerUsageSnooper.addData("gl_max_texture_size", Integer.valueOf(func_71369_N()));
    }

    private static int func_71369_N()
    {
        for (int var0 = 16384; var0 > 0; var0 >>= 1)
        {
            GL11.glTexImage2D(GL11.GL_PROXY_TEXTURE_2D, 0, GL11.GL_RGBA, var0, var0, 0, GL11.GL_RGBA, GL11.GL_UNSIGNED_BYTE, (ByteBuffer)null);
            int var1 = GL11.glGetTexLevelParameteri(GL11.GL_PROXY_TEXTURE_2D, 0, GL11.GL_TEXTURE_WIDTH);

            if (var1 != 0)
            {
                return var0;
            }
        }

        return -1;
    }

    /**
     * Returns whether snooping is enabled or not.
     */
    public boolean isSnooperEnabled()
    {
        return this.gameSettings.snooperEnabled;
    }

    /**
     * Set the current ServerData instance.
     */
    public void setServerData(ServerData par1ServerData)
    {
        this.currentServerData = par1ServerData;
    }

    /**
     * Get the current ServerData instance.
     */
    public ServerData getServerData()
    {
        return this.currentServerData;
    }

    public boolean isIntegratedServerRunning()
    {
        return this.integratedServerIsRunning;
    }

    /**
     * Returns true if there is only one player playing, and the current server is the integrated one.
     */
    public boolean isSingleplayer()
    {
        return this.integratedServerIsRunning && this.theIntegratedServer != null;
    }

    /**
     * Returns the currently running integrated server
     */
    public IntegratedServer getIntegratedServer()
    {
        return this.theIntegratedServer;
    }

    public static void stopIntegratedServer()
    {
        if (theMinecraft != null)
        {
            IntegratedServer var0 = theMinecraft.getIntegratedServer();

            if (var0 != null)
            {
                var0.stopServer();
            }
        }
    }

    /**
     * Returns the PlayerUsageSnooper instance.
     */
    public PlayerUsageSnooper getPlayerUsageSnooper()
    {
        return this.usageSnooper;
    }

    /**
     * Gets the system time in milliseconds.
     */
    public static long getSystemTime()
    {
        return Sys.getTime() * 1000L / Sys.getTimerResolution();
    }

    /**
     * Returns whether we're in full screen or not.
     */
    public boolean isFullScreen()
    {
        return this.fullscreen;
    }
}
