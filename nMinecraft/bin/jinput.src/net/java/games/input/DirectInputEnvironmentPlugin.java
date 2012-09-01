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
/*     */ public final class DirectInputEnvironmentPlugin extends ControllerEnvironment
/*     */   implements Plugin
/*     */ {
/*  57 */   private static boolean supported = false;
/*     */   private final Controller[] controllers;
/* 115 */   private final List active_devices = new ArrayList();
/*     */   private final DummyWindow window;
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
/*  78 */           DirectInputEnvironmentPlugin.access$002(false);
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
/*     */   public DirectInputEnvironmentPlugin()
/*     */   {
/* 120 */     DummyWindow window = null;
/* 121 */     Controller[] controllers = new Controller[0];
/* 122 */     if (isSupported()) {
/*     */       try {
/* 124 */         window = new DummyWindow();
/*     */         try {
/* 126 */           controllers = enumControllers(window);
/*     */         } catch (IOException e) {
/* 128 */           window.destroy();
/* 129 */           throw e;
/*     */         }
/*     */       } catch (IOException e) {
/* 132 */         logln("Failed to enumerate devices: " + e.getMessage());
/*     */       }
/* 134 */       this.window = window;
/* 135 */       this.controllers = controllers;
/* 136 */       AccessController.doPrivileged(new PrivilegedAction()
/*     */       {
/*     */         public final Object run() {
/* 139 */           Runtime.getRuntime().addShutdownHook(new DirectInputEnvironmentPlugin.ShutdownHook(DirectInputEnvironmentPlugin.this, null));
/* 140 */           return null;
/*     */         }
/*     */       });
/*     */     }
/*     */     else
/*     */     {
/* 146 */       this.window = null;
/* 147 */       this.controllers = controllers;
/*     */     }
/*     */   }
/*     */ 
/*     */   public final Controller[] getControllers() {
/* 152 */     return this.controllers;
/*     */   }
/*     */ 
/*     */   private final Component[] createComponents(IDirectInputDevice device, boolean map_mouse_buttons) {
/* 156 */     List device_objects = device.getObjects();
/* 157 */     List controller_components = new ArrayList();
/* 158 */     for (int i = 0; i < device_objects.size(); i++) {
/* 159 */       DIDeviceObject device_object = (DIDeviceObject)device_objects.get(i);
/* 160 */       Component.Identifier identifier = device_object.getIdentifier();
/* 161 */       if (identifier != null)
/*     */       {
/* 163 */         if ((map_mouse_buttons) && ((identifier instanceof Component.Identifier.Button))) {
/* 164 */           identifier = DIIdentifierMap.mapMouseButtonIdentifier((Component.Identifier.Button)identifier);
/*     */         }
/* 166 */         DIComponent component = new DIComponent(identifier, device_object);
/* 167 */         controller_components.add(component);
/* 168 */         device.registerComponent(device_object, component);
/*     */       }
/*     */     }
/* 170 */     Component[] components = new Component[controller_components.size()];
/* 171 */     controller_components.toArray(components);
/* 172 */     return components;
/*     */   }
/*     */ 
/*     */   private final Mouse createMouseFromDevice(IDirectInputDevice device) {
/* 176 */     Component[] components = createComponents(device, true);
/* 177 */     Mouse mouse = new DIMouse(device, components, new Controller[0], device.getRumblers());
/* 178 */     if ((mouse.getX() != null) && (mouse.getY() != null) && (mouse.getPrimaryButton() != null)) {
/* 179 */       return mouse;
/*     */     }
/* 181 */     return null;
/*     */   }
/*     */ 
/*     */   private final AbstractController createControllerFromDevice(IDirectInputDevice device, Controller.Type type) {
/* 185 */     Component[] components = createComponents(device, false);
/* 186 */     AbstractController controller = new DIAbstractController(device, components, new Controller[0], device.getRumblers(), type);
/* 187 */     return controller;
/*     */   }
/*     */ 
/*     */   private final Keyboard createKeyboardFromDevice(IDirectInputDevice device) {
/* 191 */     Component[] components = createComponents(device, false);
/* 192 */     return new DIKeyboard(device, components, new Controller[0], device.getRumblers());
/*     */   }
/*     */ 
/*     */   private final Controller createControllerFromDevice(IDirectInputDevice device) {
/* 196 */     switch (device.getType()) {
/*     */     case 18:
/* 198 */       return createMouseFromDevice(device);
/*     */     case 19:
/* 200 */       return createKeyboardFromDevice(device);
/*     */     case 21:
/* 202 */       return createControllerFromDevice(device, Controller.Type.GAMEPAD);
/*     */     case 22:
/* 204 */       return createControllerFromDevice(device, Controller.Type.WHEEL);
/*     */     case 20:
/*     */     case 23:
/*     */     case 24:
/* 210 */       return createControllerFromDevice(device, Controller.Type.STICK);
/*     */     }
/* 212 */     return createControllerFromDevice(device, Controller.Type.UNKNOWN);
/*     */   }
/*     */ 
/*     */   private final Controller[] enumControllers(DummyWindow window) throws IOException
/*     */   {
/* 217 */     List controllers = new ArrayList();
/* 218 */     IDirectInput dinput = new IDirectInput(window);
/*     */     try {
/* 220 */       List devices = dinput.getDevices();
/* 221 */       for (int i = 0; i < devices.size(); i++) {
/* 222 */         IDirectInputDevice device = (IDirectInputDevice)devices.get(i);
/* 223 */         Controller controller = createControllerFromDevice(device);
/* 224 */         if (controller != null) {
/* 225 */           controllers.add(controller);
/* 226 */           this.active_devices.add(device);
/*     */         } else {
/* 228 */           device.release();
/*     */         }
/*     */       }
/*     */     } finally { dinput.release(); }
/*     */ 
/* 233 */     Controller[] controllers_array = new Controller[controllers.size()];
/* 234 */     controllers.toArray(controllers_array);
/* 235 */     return controllers_array;
/*     */   }
/*     */ 
/*     */   public boolean isSupported()
/*     */   {
/* 252 */     return supported;
/*     */   }
/*     */ 
/*     */   static
/*     */   {
/* 103 */     String osName = getPrivilegedProperty("os.name", "").trim();
/* 104 */     if (osName.startsWith("Windows")) {
/* 105 */       supported = true;
/* 106 */       if ("x86".equals(getPrivilegedProperty("os.arch")))
/* 107 */         loadLibrary("jinput-dx8");
/*     */       else
/* 109 */         loadLibrary("jinput-dx8_64");
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
/* 241 */       for (int i = 0; i < DirectInputEnvironmentPlugin.this.active_devices.size(); i++) {
/* 242 */         IDirectInputDevice device = (IDirectInputDevice)DirectInputEnvironmentPlugin.this.active_devices.get(i);
/* 243 */         device.release();
/*     */       }
/*     */     }
/*     */ 
/*     */     ShutdownHook(DirectInputEnvironmentPlugin.1 x1)
/*     */     {
/* 238 */       this();
/*     */     }
/*     */   }
/*     */ }

/* Location:           /Users/Nick/Library/Application Support/minecraft/bin/jinput.jar
 * Qualified Name:     net.java.games.input.DirectInputEnvironmentPlugin
 * JD-Core Version:    0.6.1
 */