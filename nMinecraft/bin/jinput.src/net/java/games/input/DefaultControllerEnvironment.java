/*     */ package net.java.games.input;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.PrintStream;
/*     */ import java.security.AccessController;
/*     */ import java.security.PrivilegedAction;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.StringTokenizer;
/*     */ import net.java.games.util.plugins.Plugins;
/*     */ 
/*     */ class DefaultControllerEnvironment extends ControllerEnvironment
/*     */ {
/*     */   static String libPath;
/*     */   private ArrayList controllers;
/* 106 */   private Collection loadedPlugins = new ArrayList();
/*     */ 
/*     */   static void loadLibrary(String lib_name)
/*     */   {
/*  71 */     AccessController.doPrivileged(new PrivilegedAction() {
/*     */       private final String val$lib_name;
/*     */ 
/*  74 */       public final Object run() { String lib_path = System.getProperty("net.java.games.input.librarypath");
/*  75 */         if (lib_path != null)
/*  76 */           System.load(lib_path + File.separator + System.mapLibraryName(this.val$lib_name));
/*     */         else
/*  78 */           System.loadLibrary(this.val$lib_name);
/*  79 */         return null; }
/*     */     });
/*     */   }
/*     */ 
/*     */   static String getPrivilegedProperty(String property)
/*     */   {
/*  85 */     return (String)AccessController.doPrivileged(new PrivilegedAction() { private final String val$property;
/*     */ 
/*  87 */       public Object run() { return System.getProperty(this.val$property); }
/*     */ 
/*     */     });
/*     */   }
/*     */ 
/*     */   static String getPrivilegedProperty(String property, final String default_value)
/*     */   {
/*  94 */     return (String)AccessController.doPrivileged(new PrivilegedAction() { private final String val$property;
/*     */       private final String val$default_value;
/*     */ 
/*  96 */       public Object run() { return System.getProperty(this.val$property, default_value); }
/*     */ 
/*     */     });
/*     */   }
/*     */ 
/*     */   public Controller[] getControllers()
/*     */   {
/* 119 */     if (this.controllers == null)
/*     */     {
/* 121 */       this.controllers = new ArrayList();
/* 122 */       AccessController.doPrivileged(new PrivilegedAction() {
/*     */         public Object run() {
/* 124 */           DefaultControllerEnvironment.this.scanControllers();
/* 125 */           return null;
/*     */         }
/*     */       });
/* 129 */       String pluginClasses = getPrivilegedProperty("jinput.plugins", "") + " " + getPrivilegedProperty("net.java.games.input.plugins", "");
/* 130 */       if ((!getPrivilegedProperty("jinput.useDefaultPlugin", "true").toLowerCase().trim().equals("false")) && (!getPrivilegedProperty("net.java.games.input.useDefaultPlugin", "true").toLowerCase().trim().equals("false"))) {
/* 131 */         String osName = getPrivilegedProperty("os.name", "").trim();
/* 132 */         if (osName.equals("Linux")) {
/* 133 */           pluginClasses = pluginClasses + " net.java.games.input.LinuxEnvironmentPlugin";
/* 134 */         } else if (osName.equals("Mac OS X")) {
/* 135 */           pluginClasses = pluginClasses + " net.java.games.input.OSXEnvironmentPlugin";
/* 136 */         } else if ((osName.equals("Windows XP")) || (osName.equals("Windows Vista"))) {
/* 137 */           pluginClasses = pluginClasses + " net.java.games.input.DirectAndRawInputEnvironmentPlugin";
/* 138 */         } else if ((osName.equals("Windows 98")) || (osName.equals("Windows 2000"))) {
/* 139 */           pluginClasses = pluginClasses + " net.java.games.input.DirectInputEnvironmentPlugin";
/* 140 */         } else if (osName.startsWith("Windows")) {
/* 141 */           System.out.println("WARNING: Found unknown Windows version: " + osName);
/* 142 */           System.out.println("Attempting to use default windows plug-in.");
/* 143 */           System.out.flush();
/* 144 */           pluginClasses = pluginClasses + " net.java.games.input.DirectAndRawInputEnvironmentPlugin";
/*     */         } else {
/* 146 */           System.out.println("Trying to use default plugin, OS name " + osName + " not recognised");
/*     */         }
/*     */       }
/*     */ 
/* 150 */       StringTokenizer pluginClassTok = new StringTokenizer(pluginClasses, " \t\n\r\f,;:");
/* 151 */       while (pluginClassTok.hasMoreTokens()) {
/* 152 */         String className = pluginClassTok.nextToken();
/*     */         try {
/* 154 */           if (!this.loadedPlugins.contains(className)) {
/* 155 */             System.out.println("Loading: " + className);
/* 156 */             Class ceClass = Class.forName(className);
/* 157 */             ControllerEnvironment ce = (ControllerEnvironment)ceClass.newInstance();
/* 158 */             if (ce.isSupported()) {
/* 159 */               addControllers(ce.getControllers());
/* 160 */               this.loadedPlugins.add(ce.getClass().getName());
/*     */             } else {
/* 162 */               logln(ceClass.getName() + " is not supported");
/*     */             }
/*     */           }
/*     */         } catch (Throwable e) {
/* 166 */           e.printStackTrace();
/*     */         }
/*     */       }
/*     */     }
/* 170 */     Controller[] ret = new Controller[this.controllers.size()];
/* 171 */     Iterator it = this.controllers.iterator();
/* 172 */     int i = 0;
/* 173 */     while (it.hasNext()) {
/* 174 */       ret[i] = ((Controller)it.next());
/* 175 */       i++;
/*     */     }
/* 177 */     return ret;
/*     */   }
/*     */ 
/*     */   private void scanControllers()
/*     */   {
/* 182 */     String pluginPathName = getPrivilegedProperty("jinput.controllerPluginPath");
/* 183 */     if (pluginPathName == null) {
/* 184 */       pluginPathName = "controller";
/*     */     }
/*     */ 
/* 187 */     scanControllersAt(getPrivilegedProperty("java.home") + File.separator + "lib" + File.separator + pluginPathName);
/*     */ 
/* 189 */     scanControllersAt(getPrivilegedProperty("user.dir") + File.separator + pluginPathName);
/*     */   }
/*     */ 
/*     */   private void scanControllersAt(String path)
/*     */   {
/* 194 */     File file = new File(path);
/* 195 */     if (!file.exists())
/* 196 */       return;
/*     */     try
/*     */     {
/* 199 */       Plugins plugins = new Plugins(file);
/* 200 */       Class[] envClasses = plugins.getExtends(ControllerEnvironment.class);
/* 201 */       for (int i = 0; i < envClasses.length; i++)
/*     */         try {
/* 203 */           ControllerEnvironment.logln("ControllerEnvironment " + envClasses[i].getName() + " loaded by " + envClasses[i].getClassLoader());
/*     */ 
/* 206 */           ControllerEnvironment ce = (ControllerEnvironment)envClasses[i].newInstance();
/*     */ 
/* 208 */           if (ce.isSupported()) {
/* 209 */             addControllers(ce.getControllers());
/* 210 */             this.loadedPlugins.add(ce.getClass().getName());
/*     */           } else {
/* 212 */             logln(envClasses[i].getName() + " is not supported");
/*     */           }
/*     */         } catch (Throwable e) {
/* 215 */           e.printStackTrace();
/*     */         }
/*     */     }
/*     */     catch (Exception e) {
/* 219 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   private void addControllers(Controller[] c)
/*     */   {
/* 227 */     for (int i = 0; i < c.length; i++)
/* 228 */       this.controllers.add(c[i]);
/*     */   }
/*     */ 
/*     */   public boolean isSupported()
/*     */   {
/* 233 */     return true;
/*     */   }
/*     */ }

/* Location:           /Users/Nick/Library/Application Support/minecraft/bin/jinput.jar
 * Qualified Name:     net.java.games.input.DefaultControllerEnvironment
 * JD-Core Version:    0.6.1
 */