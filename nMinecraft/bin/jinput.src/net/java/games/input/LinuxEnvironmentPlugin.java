/*     */ package net.java.games.input;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FilenameFilter;
/*     */ import java.io.IOException;
/*     */ import java.security.AccessController;
/*     */ import java.security.PrivilegedAction;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import net.java.games.util.plugins.Plugin;
/*     */ 
/*     */ public final class LinuxEnvironmentPlugin extends ControllerEnvironment
/*     */   implements Plugin
/*     */ {
/*     */   private static final String LIBNAME = "jinput-linux";
/*     */   private static final String POSTFIX64BIT = "64";
/*  44 */   private static boolean supported = false;
/*     */   private final Controller[] controllers;
/*  47 */   private final List devices = new ArrayList();
/*  48 */   private static final LinuxDeviceThread device_thread = new LinuxDeviceThread();
/*     */ 
/*     */   static void loadLibrary(String lib_name)
/*     */   {
/*  58 */     AccessController.doPrivileged(new PrivilegedAction() {
/*     */       private final String val$lib_name;
/*     */ 
/*  61 */       public final Object run() { String lib_path = System.getProperty("net.java.games.input.librarypath");
/*     */         try {
/*  63 */           if (lib_path != null)
/*  64 */             System.load(lib_path + File.separator + System.mapLibraryName(this.val$lib_name));
/*     */           else
/*  66 */             System.loadLibrary(this.val$lib_name);
/*     */         } catch (UnsatisfiedLinkError e) {
/*  68 */           ControllerEnvironment.logln("Failed to load library: " + e.getMessage());
/*  69 */           e.printStackTrace();
/*  70 */           LinuxEnvironmentPlugin.access$002(false);
/*     */         }
/*  72 */         return null; }
/*     */     });
/*     */   }
/*     */ 
/*     */   static String getPrivilegedProperty(String property)
/*     */   {
/*  78 */     return (String)AccessController.doPrivileged(new PrivilegedAction() { private final String val$property;
/*     */ 
/*  80 */       public Object run() { return System.getProperty(this.val$property); }
/*     */ 
/*     */     });
/*     */   }
/*     */ 
/*     */   static String getPrivilegedProperty(String property, final String default_value)
/*     */   {
/*  87 */     return (String)AccessController.doPrivileged(new PrivilegedAction() { private final String val$property;
/*     */       private final String val$default_value;
/*     */ 
/*  89 */       public Object run() { return System.getProperty(this.val$property, default_value); }
/*     */ 
/*     */     });
/*     */   }
/*     */ 
/*     */   public static final Object execute(LinuxDeviceTask task)
/*     */     throws IOException
/*     */   {
/* 107 */     return device_thread.execute(task);
/*     */   }
/*     */ 
/*     */   public LinuxEnvironmentPlugin() {
/* 111 */     if (isSupported()) {
/* 112 */       this.controllers = enumerateControllers();
/* 113 */       logln("Linux plugin claims to have found " + this.controllers.length + " controllers");
/* 114 */       AccessController.doPrivileged(new PrivilegedAction()
/*     */       {
/*     */         public final Object run() {
/* 117 */           Runtime.getRuntime().addShutdownHook(new LinuxEnvironmentPlugin.ShutdownHook(LinuxEnvironmentPlugin.this, null));
/* 118 */           return null;
/*     */         } } );
/*     */     }
/*     */     else {
/* 122 */       this.controllers = new Controller[0];
/*     */     }
/*     */   }
/*     */ 
/*     */   public final Controller[] getControllers()
/*     */   {
/* 132 */     return this.controllers;
/*     */   }
/*     */ 
/*     */   private static final Component[] createComponents(List event_components, LinuxEventDevice device) {
/* 136 */     LinuxEventComponent[][] povs = new LinuxEventComponent[4][2];
/* 137 */     List components = new ArrayList();
/* 138 */     for (int i = 0; i < event_components.size(); i++) {
/* 139 */       LinuxEventComponent event_component = (LinuxEventComponent)event_components.get(i);
/* 140 */       Component.Identifier identifier = event_component.getIdentifier();
/*     */ 
/* 142 */       if (identifier == Component.Identifier.Axis.POV) {
/* 143 */         int native_code = event_component.getDescriptor().getCode();
/* 144 */         switch (native_code) {
/*     */         case 16:
/* 146 */           povs[0][0] = event_component;
/* 147 */           break;
/*     */         case 17:
/* 149 */           povs[0][1] = event_component;
/* 150 */           break;
/*     */         case 18:
/* 152 */           povs[1][0] = event_component;
/* 153 */           break;
/*     */         case 19:
/* 155 */           povs[1][1] = event_component;
/* 156 */           break;
/*     */         case 20:
/* 158 */           povs[2][0] = event_component;
/* 159 */           break;
/*     */         case 21:
/* 161 */           povs[2][1] = event_component;
/* 162 */           break;
/*     */         case 22:
/* 164 */           povs[3][0] = event_component;
/* 165 */           break;
/*     */         case 23:
/* 167 */           povs[3][1] = event_component;
/* 168 */           break;
/*     */         default:
/* 170 */           logln("Unknown POV instance: " + native_code);
/*     */         }
/*     */       }
/* 173 */       else if (identifier != null) {
/* 174 */         LinuxComponent component = new LinuxComponent(event_component);
/* 175 */         components.add(component);
/* 176 */         device.registerComponent(event_component.getDescriptor(), component);
/*     */       }
/*     */     }
/* 179 */     for (int i = 0; i < povs.length; i++) {
/* 180 */       LinuxEventComponent x = povs[i][0];
/* 181 */       LinuxEventComponent y = povs[i][1];
/* 182 */       if ((x != null) && (y != null)) {
/* 183 */         LinuxComponent controller_component = new LinuxPOV(x, y);
/* 184 */         components.add(controller_component);
/* 185 */         device.registerComponent(x.getDescriptor(), controller_component);
/* 186 */         device.registerComponent(y.getDescriptor(), controller_component);
/*     */       }
/*     */     }
/* 189 */     Component[] components_array = new Component[components.size()];
/* 190 */     components.toArray(components_array);
/* 191 */     return components_array;
/*     */   }
/*     */ 
/*     */   private static final Mouse createMouseFromDevice(LinuxEventDevice device, Component[] components) throws IOException {
/* 195 */     Mouse mouse = new LinuxMouse(device, components, new Controller[0], device.getRumblers());
/* 196 */     if ((mouse.getX() != null) && (mouse.getY() != null) && (mouse.getPrimaryButton() != null)) {
/* 197 */       return mouse;
/*     */     }
/* 199 */     return null;
/*     */   }
/*     */ 
/*     */   private static final Keyboard createKeyboardFromDevice(LinuxEventDevice device, Component[] components) throws IOException {
/* 203 */     Keyboard keyboard = new LinuxKeyboard(device, components, new Controller[0], device.getRumblers());
/* 204 */     return keyboard;
/*     */   }
/*     */ 
/*     */   private static final Controller createJoystickFromDevice(LinuxEventDevice device, Component[] components, Controller.Type type) throws IOException {
/* 208 */     Controller joystick = new LinuxAbstractController(device, components, new Controller[0], device.getRumblers(), type);
/* 209 */     return joystick;
/*     */   }
/*     */ 
/*     */   private static final Controller createControllerFromDevice(LinuxEventDevice device) throws IOException {
/* 213 */     List event_components = device.getComponents();
/* 214 */     Component[] components = createComponents(event_components, device);
/* 215 */     Controller.Type type = device.getType();
/*     */ 
/* 217 */     if (type == Controller.Type.MOUSE)
/* 218 */       return createMouseFromDevice(device, components);
/* 219 */     if (type == Controller.Type.KEYBOARD)
/* 220 */       return createKeyboardFromDevice(device, components);
/* 221 */     if ((type == Controller.Type.STICK) || (type == Controller.Type.GAMEPAD)) {
/* 222 */       return createJoystickFromDevice(device, components, type);
/*     */     }
/* 224 */     return null;
/*     */   }
/*     */ 
/*     */   private final Controller[] enumerateControllers() {
/* 228 */     List controllers = new ArrayList();
/* 229 */     List eventControllers = new ArrayList();
/* 230 */     List jsControllers = new ArrayList();
/* 231 */     enumerateEventControllers(eventControllers);
/* 232 */     enumerateJoystickControllers(jsControllers);
/*     */ 
/* 234 */     for (int i = 0; i < eventControllers.size(); i++) {
/* 235 */       for (int j = 0; j < jsControllers.size(); j++) {
/* 236 */         Controller evController = (Controller)eventControllers.get(i);
/* 237 */         Controller jsController = (Controller)jsControllers.get(j);
/*     */ 
/* 241 */         if (evController.getName().equals(jsController.getName()))
/*     */         {
/* 243 */           Component[] evComponents = evController.getComponents();
/* 244 */           Component[] jsComponents = jsController.getComponents();
/*     */           Controller[] controllers_array;
/* 245 */           if (evComponents.length == jsComponents.length) {
/* 246 */             boolean foundADifference = false;
/*     */ 
/* 248 */             for (int k = 0; k < evComponents.length; k++)
/*     */             {
/* 250 */               if (evComponents[k].getIdentifier() != jsComponents[k].getIdentifier()) {
/* 251 */                 foundADifference = true;
/*     */               }
/*     */             }
/*     */ 
/* 255 */             if (!foundADifference) {
/* 256 */               controllers.add(new LinuxCombinedController((LinuxAbstractController)eventControllers.remove(i), (LinuxJoystickAbstractController)jsControllers.remove(j)));
/* 257 */               i--;
/* 258 */               j--;
/* 259 */               break;
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 265 */     controllers.addAll(eventControllers);
/* 266 */     controllers.addAll(jsControllers);
/*     */ 
/* 268 */     controllers_array = new Controller[controllers.size()];
/* 269 */     controllers.toArray(controllers_array);
/* 270 */     return controllers_array;
/*     */   }
/*     */ 
/*     */   private static final Component.Identifier.Button getButtonIdentifier(int index) {
/* 274 */     switch (index) {
/*     */     case 0:
/* 276 */       return Component.Identifier.Button._0;
/*     */     case 1:
/* 278 */       return Component.Identifier.Button._1;
/*     */     case 2:
/* 280 */       return Component.Identifier.Button._2;
/*     */     case 3:
/* 282 */       return Component.Identifier.Button._3;
/*     */     case 4:
/* 284 */       return Component.Identifier.Button._4;
/*     */     case 5:
/* 286 */       return Component.Identifier.Button._5;
/*     */     case 6:
/* 288 */       return Component.Identifier.Button._6;
/*     */     case 7:
/* 290 */       return Component.Identifier.Button._7;
/*     */     case 8:
/* 292 */       return Component.Identifier.Button._8;
/*     */     case 9:
/* 294 */       return Component.Identifier.Button._9;
/*     */     case 10:
/* 296 */       return Component.Identifier.Button._10;
/*     */     case 11:
/* 298 */       return Component.Identifier.Button._11;
/*     */     case 12:
/* 300 */       return Component.Identifier.Button._12;
/*     */     case 13:
/* 302 */       return Component.Identifier.Button._13;
/*     */     case 14:
/* 304 */       return Component.Identifier.Button._14;
/*     */     case 15:
/* 306 */       return Component.Identifier.Button._15;
/*     */     case 16:
/* 308 */       return Component.Identifier.Button._16;
/*     */     case 17:
/* 310 */       return Component.Identifier.Button._17;
/*     */     case 18:
/* 312 */       return Component.Identifier.Button._18;
/*     */     case 19:
/* 314 */       return Component.Identifier.Button._19;
/*     */     case 20:
/* 316 */       return Component.Identifier.Button._20;
/*     */     case 21:
/* 318 */       return Component.Identifier.Button._21;
/*     */     case 22:
/* 320 */       return Component.Identifier.Button._22;
/*     */     case 23:
/* 322 */       return Component.Identifier.Button._23;
/*     */     case 24:
/* 324 */       return Component.Identifier.Button._24;
/*     */     case 25:
/* 326 */       return Component.Identifier.Button._25;
/*     */     case 26:
/* 328 */       return Component.Identifier.Button._26;
/*     */     case 27:
/* 330 */       return Component.Identifier.Button._27;
/*     */     case 28:
/* 332 */       return Component.Identifier.Button._28;
/*     */     case 29:
/* 334 */       return Component.Identifier.Button._29;
/*     */     case 30:
/* 336 */       return Component.Identifier.Button._30;
/*     */     case 31:
/* 338 */       return Component.Identifier.Button._31;
/*     */     }
/* 340 */     return null;
/*     */   }
/*     */ 
/*     */   private static final Controller createJoystickFromJoystickDevice(LinuxJoystickDevice device)
/*     */   {
/* 345 */     List components = new ArrayList();
/* 346 */     byte[] axisMap = device.getAxisMap();
/* 347 */     char[] buttonMap = device.getButtonMap();
/* 348 */     LinuxJoystickAxis[] hatBits = new LinuxJoystickAxis[6];
/*     */ 
/* 350 */     for (int i = 0; i < device.getNumButtons(); i++) {
/* 351 */       Component.Identifier button_id = LinuxNativeTypesMap.getButtonID(buttonMap[i]);
/* 352 */       if (button_id != null) {
/* 353 */         LinuxJoystickButton button = new LinuxJoystickButton(button_id);
/* 354 */         device.registerButton(i, button);
/* 355 */         components.add(button);
/*     */       }
/*     */     }
/* 358 */     for (int i = 0; i < device.getNumAxes(); i++)
/*     */     {
/* 360 */       Component.Identifier.Axis axis_id = (Component.Identifier.Axis)LinuxNativeTypesMap.getAbsAxisID(axisMap[i]);
/* 361 */       LinuxJoystickAxis axis = new LinuxJoystickAxis(axis_id);
/*     */ 
/* 363 */       device.registerAxis(i, axis);
/*     */ 
/* 365 */       if (axisMap[i] == 16) {
/* 366 */         hatBits[0] = axis;
/* 367 */       } else if (axisMap[i] == 17) {
/* 368 */         hatBits[1] = axis;
/* 369 */         axis = new LinuxJoystickPOV(Component.Identifier.Axis.POV, hatBits[0], hatBits[1]);
/* 370 */         device.registerPOV((LinuxJoystickPOV)axis);
/* 371 */         components.add(axis);
/* 372 */       } else if (axisMap[i] == 18) {
/* 373 */         hatBits[2] = axis;
/* 374 */       } else if (axisMap[i] == 19) {
/* 375 */         hatBits[3] = axis;
/* 376 */         axis = new LinuxJoystickPOV(Component.Identifier.Axis.POV, hatBits[2], hatBits[3]);
/* 377 */         device.registerPOV((LinuxJoystickPOV)axis);
/* 378 */         components.add(axis);
/* 379 */       } else if (axisMap[i] == 20) {
/* 380 */         hatBits[4] = axis;
/* 381 */       } else if (axisMap[i] == 21) {
/* 382 */         hatBits[5] = axis;
/* 383 */         axis = new LinuxJoystickPOV(Component.Identifier.Axis.POV, hatBits[4], hatBits[5]);
/* 384 */         device.registerPOV((LinuxJoystickPOV)axis);
/* 385 */         components.add(axis);
/*     */       } else {
/* 387 */         components.add(axis);
/*     */       }
/*     */     }
/*     */ 
/* 391 */     return new LinuxJoystickAbstractController(device, (Component[])components.toArray(new Component[0]), new Controller[0], new Rumbler[0]);
/*     */   }
/*     */ 
/*     */   private final void enumerateJoystickControllers(List controllers) {
/* 395 */     File[] joystick_device_files = enumerateJoystickDeviceFiles("/dev/input");
/* 396 */     if ((joystick_device_files == null) || (joystick_device_files.length == 0)) {
/* 397 */       joystick_device_files = enumerateJoystickDeviceFiles("/dev");
/* 398 */       if (joystick_device_files == null)
/* 399 */         return;
/*     */     }
/* 401 */     for (int i = 0; i < joystick_device_files.length; i++) {
/* 402 */       File event_file = joystick_device_files[i];
/*     */       try {
/* 404 */         String path = getAbsolutePathPrivileged(event_file);
/* 405 */         LinuxJoystickDevice device = new LinuxJoystickDevice(path);
/* 406 */         Controller controller = createJoystickFromJoystickDevice(device);
/* 407 */         if (controller != null) {
/* 408 */           controllers.add(controller);
/* 409 */           this.devices.add(device);
/*     */         } else {
/* 411 */           device.close();
/*     */         }
/*     */       } catch (IOException e) { logln("Failed to open device (" + event_file + "): " + e.getMessage()); }
/*     */     }
/*     */   }
/*     */ 
/*     */   private static final File[] enumerateJoystickDeviceFiles(String dev_path)
/*     */   {
/* 419 */     File dev = new File(dev_path);
/* 420 */     return listFilesPrivileged(dev, new FilenameFilter() {
/*     */       public final boolean accept(File dir, String name) {
/* 422 */         return name.startsWith("js");
/*     */       }
/*     */     });
/*     */   }
/*     */ 
/*     */   private static String getAbsolutePathPrivileged(File file) {
/* 428 */     return (String)AccessController.doPrivileged(new PrivilegedAction() { private final File val$file;
/*     */ 
/* 430 */       public Object run() { return this.val$file.getAbsolutePath(); }
/*     */     });
/*     */   }
/*     */ 
/*     */   private static File[] listFilesPrivileged(File dir, final FilenameFilter filter)
/*     */   {
/* 436 */     return (File[])AccessController.doPrivileged(new PrivilegedAction() { private final File val$dir;
/*     */       private final FilenameFilter val$filter;
/*     */ 
/* 438 */       public Object run() { return this.val$dir.listFiles(filter); }
/*     */     });
/*     */   }
/*     */ 
/*     */   private final void enumerateEventControllers(List controllers)
/*     */   {
/* 444 */     File dev = new File("/dev/input");
/* 445 */     File[] event_device_files = listFilesPrivileged(dev, new FilenameFilter() {
/*     */       public final boolean accept(File dir, String name) {
/* 447 */         return name.startsWith("event");
/*     */       }
/*     */     });
/* 450 */     if (event_device_files == null)
/* 451 */       return;
/* 452 */     for (int i = 0; i < event_device_files.length; i++) {
/* 453 */       File event_file = event_device_files[i];
/*     */       try {
/* 455 */         String path = getAbsolutePathPrivileged(event_file);
/* 456 */         LinuxEventDevice device = new LinuxEventDevice(path);
/*     */         try {
/* 458 */           Controller controller = createControllerFromDevice(device);
/* 459 */           if (controller != null) {
/* 460 */             controllers.add(controller);
/* 461 */             this.devices.add(device);
/*     */           } else {
/* 463 */             device.close();
/*     */           }
/*     */         } catch (IOException e) { logln("Failed to create Controller: " + e.getMessage());
/* 466 */           device.close(); }
/*     */       }
/*     */       catch (IOException e) {
/* 469 */         logln("Failed to open device (" + event_file + "): " + e.getMessage());
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public boolean isSupported()
/*     */   {
/* 488 */     return supported;
/*     */   }
/*     */ 
/*     */   static
/*     */   {
/*  95 */     String osName = getPrivilegedProperty("os.name", "").trim();
/*  96 */     if (osName.equals("Linux")) {
/*  97 */       supported = true;
/*  98 */       if ("i386".equals(getPrivilegedProperty("os.arch")))
/*  99 */         loadLibrary("jinput-linux");
/*     */       else
/* 101 */         loadLibrary("jinput-linux64");
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
/* 476 */       for (int i = 0; i < LinuxEnvironmentPlugin.this.devices.size(); i++)
/*     */         try {
/* 478 */           LinuxDevice device = (LinuxDevice)LinuxEnvironmentPlugin.this.devices.get(i);
/* 479 */           device.close();
/*     */         } catch (IOException e) {
/* 481 */           ControllerEnvironment.logln("Failed to close device: " + e.getMessage());
/*     */         }
/*     */     }
/*     */ 
/*     */     ShutdownHook(LinuxEnvironmentPlugin.1 x1)
/*     */     {
/* 474 */       this();
/*     */     }
/*     */   }
/*     */ }

/* Location:           /Users/Nick/Library/Application Support/minecraft/bin/jinput.jar
 * Qualified Name:     net.java.games.input.LinuxEnvironmentPlugin
 * JD-Core Version:    0.6.1
 */