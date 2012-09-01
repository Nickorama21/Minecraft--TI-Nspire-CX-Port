/*     */ package net.java.games.input;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.security.AccessController;
/*     */ import java.security.PrivilegedAction;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import net.java.games.util.plugins.Plugin;
/*     */ 
/*     */ public class WinTabEnvironmentPlugin extends ControllerEnvironment
/*     */   implements Plugin
/*     */ {
/*  37 */   private static boolean supported = false;
/*     */   private final Controller[] controllers;
/*  91 */   private final List active_devices = new ArrayList();
/*     */   private final WinTabContext winTabContext;
/*     */ 
/*     */   static void loadLibrary(String lib_name)
/*     */   {
/*  47 */     AccessController.doPrivileged(new PrivilegedAction() {
/*     */       private final String val$lib_name;
/*     */ 
/*     */       public final Object run() {
/*     */         try { String lib_path = System.getProperty("net.java.games.input.librarypath");
/*  52 */           if (lib_path != null)
/*  53 */             System.load(lib_path + File.separator + System.mapLibraryName(this.val$lib_name));
/*     */           else
/*  55 */             System.loadLibrary(this.val$lib_name);
/*     */         } catch (UnsatisfiedLinkError e) {
/*  57 */           e.printStackTrace();
/*  58 */           WinTabEnvironmentPlugin.access$002(false);
/*     */         }
/*  60 */         return null;
/*     */       }
/*     */     });
/*     */   }
/*     */ 
/*     */   static String getPrivilegedProperty(String property) {
/*  66 */     return (String)AccessController.doPrivileged(new PrivilegedAction() { private final String val$property;
/*     */ 
/*  68 */       public Object run() { return System.getProperty(this.val$property); }
/*     */ 
/*     */     });
/*     */   }
/*     */ 
/*     */   static String getPrivilegedProperty(String property, final String default_value)
/*     */   {
/*  75 */     return (String)AccessController.doPrivileged(new PrivilegedAction() { private final String val$property;
/*     */       private final String val$default_value;
/*     */ 
/*  77 */       public Object run() { return System.getProperty(this.val$property, default_value); }
/*     */ 
/*     */     });
/*     */   }
/*     */ 
/*     */   public WinTabEnvironmentPlugin()
/*     */   {
/*  96 */     if (isSupported()) {
/*  97 */       DummyWindow window = null;
/*  98 */       WinTabContext winTabContext = null;
/*  99 */       Controller[] controllers = new Controller[0];
/*     */       try {
/* 101 */         window = new DummyWindow();
/* 102 */         winTabContext = new WinTabContext(window);
/*     */         try {
/* 104 */           winTabContext.open();
/* 105 */           controllers = winTabContext.getControllers();
/*     */         } catch (Exception e) {
/* 107 */           window.destroy();
/* 108 */           throw e;
/*     */         }
/*     */       } catch (Exception e) {
/* 111 */         logln("Failed to enumerate devices: " + e.getMessage());
/* 112 */         e.printStackTrace();
/*     */       }
/* 114 */       this.controllers = controllers;
/* 115 */       this.winTabContext = winTabContext;
/* 116 */       AccessController.doPrivileged(new PrivilegedAction()
/*     */       {
/*     */         public final Object run() {
/* 119 */           Runtime.getRuntime().addShutdownHook(new WinTabEnvironmentPlugin.ShutdownHook(WinTabEnvironmentPlugin.this, null));
/* 120 */           return null;
/*     */         } } );
/*     */     }
/*     */     else {
/* 124 */       this.winTabContext = null;
/* 125 */       this.controllers = new Controller[0];
/*     */     }
/*     */   }
/*     */ 
/*     */   public boolean isSupported() {
/* 130 */     return supported;
/*     */   }
/*     */ 
/*     */   public Controller[] getControllers() {
/* 134 */     return this.controllers;
/*     */   }
/*     */ 
/*     */   static
/*     */   {
/*  83 */     String osName = getPrivilegedProperty("os.name", "").trim();
/*  84 */     if (osName.startsWith("Windows")) {
/*  85 */       supported = true;
/*  86 */       loadLibrary("jinput-wintab");
/*     */     }
/*     */   }
/*     */ 
/*     */   private final class ShutdownHook extends Thread
/*     */   {
/*     */     private ShutdownHook()
/*     */     {
/*     */     }
/*     */ 
/*     */     public final void run()
/*     */     {
/* 140 */       for (int i = 0; i < WinTabEnvironmentPlugin.this.active_devices.size(); i++);
/* 144 */       WinTabEnvironmentPlugin.this.winTabContext.close();
/*     */     }
/*     */ 
/*     */     ShutdownHook(WinTabEnvironmentPlugin.1 x1)
/*     */     {
/* 137 */       this();
/*     */     }
/*     */   }
/*     */ }

/* Location:           /Users/Nick/Library/Application Support/minecraft/bin/jinput.jar
 * Qualified Name:     net.java.games.input.WinTabEnvironmentPlugin
 * JD-Core Version:    0.6.1
 */