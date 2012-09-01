/*     */ package net.java.games.input;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.security.AccessController;
/*     */ import java.security.PrivilegedAction;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import net.java.games.util.plugins.Plugin;
/*     */ 
/*     */ public final class RawInputEnvironmentPlugin extends ControllerEnvironment
/*     */   implements Plugin
/*     */ {
/*  57 */   private static boolean supported = false;
/*     */   private final Controller[] controllers;
/*     */ 
/*     */   static void loadLibrary(String lib_name)
/*     */   {
/*  67 */     AccessController.doPrivileged(new PrivilegedAction() {
/*     */       private final String val$lib_name;
/*     */ 
/*     */       public final Object run() {
/*     */         try { String lib_path = System.getProperty("net.java.games.input.librarypath");
/*  72 */           if (lib_path != null)
/*  73 */             System.load(lib_path + File.separator + System.mapLibraryName(this.val$lib_name));
/*     */           else
/*  75 */             System.loadLibrary(this.val$lib_name);
/*     */         } catch (UnsatisfiedLinkError e) {
/*  77 */           e.printStackTrace();
/*  78 */           RawInputEnvironmentPlugin.access$002(false);
/*     */         }
/*  80 */         return null;
/*     */       }
/*     */     });
/*     */   }
/*     */ 
/*     */   static String getPrivilegedProperty(String property) {
/*  86 */     return (String)AccessController.doPrivileged(new PrivilegedAction() { private final String val$property;
/*     */ 
/*  88 */       public Object run() { return System.getProperty(this.val$property); }
/*     */ 
/*     */     });
/*     */   }
/*     */ 
/*     */   static String getPrivilegedProperty(String property, final String default_value)
/*     */   {
/*  95 */     return (String)AccessController.doPrivileged(new PrivilegedAction() { private final String val$property;
/*     */       private final String val$default_value;
/*     */ 
/*  97 */       public Object run() { return System.getProperty(this.val$property, default_value); }
/*     */ 
/*     */     });
/*     */   }
/*     */ 
/*     */   public RawInputEnvironmentPlugin()
/*     */   {
/* 119 */     Controller[] controllers = new Controller[0];
/* 120 */     if (isSupported()) {
/*     */       try {
/* 122 */         RawInputEventQueue queue = new RawInputEventQueue();
/* 123 */         controllers = enumControllers(queue);
/*     */       } catch (IOException e) {
/* 125 */         logln("Failed to enumerate devices: " + e.getMessage());
/*     */       }
/*     */     }
/* 128 */     this.controllers = controllers;
/*     */   }
/*     */ 
/*     */   public final Controller[] getControllers() {
/* 132 */     return this.controllers;
/*     */   }
/*     */ 
/*     */   private static final SetupAPIDevice lookupSetupAPIDevice(String device_name, List setupapi_devices)
/*     */   {
/* 139 */     device_name = device_name.replaceAll("#", "\\\\").toUpperCase();
/* 140 */     for (int i = 0; i < setupapi_devices.size(); i++) {
/* 141 */       SetupAPIDevice device = (SetupAPIDevice)setupapi_devices.get(i);
/* 142 */       if (device_name.indexOf(device.getInstanceId().toUpperCase()) != -1)
/* 143 */         return device;
/*     */     }
/* 145 */     return null;
/*     */   }
/*     */ 
/*     */   private static final void createControllersFromDevices(RawInputEventQueue queue, List controllers, List devices, List setupapi_devices) throws IOException {
/* 149 */     List active_devices = new ArrayList();
/* 150 */     for (int i = 0; i < devices.size(); i++) {
/* 151 */       RawDevice device = (RawDevice)devices.get(i);
/* 152 */       SetupAPIDevice setupapi_device = lookupSetupAPIDevice(device.getName(), setupapi_devices);
/* 153 */       if (setupapi_device != null)
/*     */       {
/* 159 */         RawDeviceInfo info = device.getInfo();
/* 160 */         Controller controller = info.createControllerFromDevice(device, setupapi_device);
/* 161 */         if (controller != null) {
/* 162 */           controllers.add(controller);
/* 163 */           active_devices.add(device);
/*     */         }
/*     */       }
/*     */     }
/* 166 */     queue.start(active_devices);
/*     */   }
/*     */ 
/*     */   private static final native void enumerateDevices(RawInputEventQueue paramRawInputEventQueue, List paramList) throws IOException;
/*     */ 
/*     */   private final Controller[] enumControllers(RawInputEventQueue queue) throws IOException {
/* 172 */     List controllers = new ArrayList();
/* 173 */     List devices = new ArrayList();
/* 174 */     enumerateDevices(queue, devices);
/* 175 */     List setupapi_devices = enumSetupAPIDevices();
/* 176 */     createControllersFromDevices(queue, controllers, devices, setupapi_devices);
/* 177 */     Controller[] controllers_array = new Controller[controllers.size()];
/* 178 */     controllers.toArray(controllers_array);
/* 179 */     return controllers_array;
/*     */   }
/*     */ 
/*     */   public boolean isSupported() {
/* 183 */     return supported;
/*     */   }
/*     */ 
/*     */   private static final List enumSetupAPIDevices()
/*     */     throws IOException
/*     */   {
/* 206 */     List devices = new ArrayList();
/* 207 */     nEnumSetupAPIDevices(getKeyboardClassGUID(), devices);
/* 208 */     nEnumSetupAPIDevices(getMouseClassGUID(), devices);
/* 209 */     return devices;
/*     */   }
/*     */ 
/*     */   private static final native void nEnumSetupAPIDevices(byte[] paramArrayOfByte, List paramList)
/*     */     throws IOException;
/*     */ 
/*     */   private static final native byte[] getKeyboardClassGUID();
/*     */ 
/*     */   private static final native byte[] getMouseClassGUID();
/*     */ 
/*     */   static
/*     */   {
/* 103 */     String osName = getPrivilegedProperty("os.name", "").trim();
/* 104 */     if (osName.startsWith("Windows")) {
/* 105 */       supported = true;
/* 106 */       if ("x86".equals(getPrivilegedProperty("os.arch")))
/* 107 */         loadLibrary("jinput-raw");
/*     */       else
/* 109 */         loadLibrary("jinput-raw_64");
/*     */     }
/*     */   }
/*     */ }

/* Location:           /Users/Nick/Library/Application Support/minecraft/bin/jinput.jar
 * Qualified Name:     net.java.games.input.RawInputEnvironmentPlugin
 * JD-Core Version:    0.6.1
 */