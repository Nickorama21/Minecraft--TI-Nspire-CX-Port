/*     */ package net.java.games.input;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ 
/*     */ public class WinTabDevice extends AbstractController
/*     */ {
/*     */   private WinTabContext context;
/*  34 */   private List eventList = new ArrayList();
/*     */ 
/*     */   private WinTabDevice(WinTabContext context, int index, String name, Component[] components) {
/*  37 */     super(name, components, new Controller[0], new Rumbler[0]);
/*  38 */     this.context = context;
/*     */   }
/*     */ 
/*     */   protected boolean getNextDeviceEvent(Event event) throws IOException {
/*  42 */     if (this.eventList.size() > 0) {
/*  43 */       Event ourEvent = (Event)this.eventList.remove(0);
/*  44 */       event.set(ourEvent);
/*  45 */       return true;
/*     */     }
/*  47 */     return false;
/*     */   }
/*     */ 
/*     */   protected void pollDevice()
/*     */     throws IOException
/*     */   {
/*  53 */     this.context.processEvents();
/*     */ 
/*  55 */     super.pollDevice();
/*     */   }
/*     */ 
/*     */   public Controller.Type getType() {
/*  59 */     return Controller.Type.TRACKPAD;
/*     */   }
/*     */ 
/*     */   public void processPacket(WinTabPacket packet) {
/*  63 */     Component[] components = getComponents();
/*  64 */     for (int i = 0; i < components.length; i++) {
/*  65 */       Event event = ((WinTabComponent)components[i]).processPacket(packet);
/*  66 */       if (event != null)
/*  67 */         this.eventList.add(event);
/*     */     }
/*     */   }
/*     */ 
/*     */   public static WinTabDevice createDevice(WinTabContext context, int deviceIndex)
/*     */   {
/*  73 */     String name = nGetName(deviceIndex);
/*  74 */     WinTabEnvironmentPlugin.logln("Device " + deviceIndex + ", name: " + name);
/*  75 */     List componentsList = new ArrayList();
/*     */ 
/*  77 */     int[] axisDetails = nGetAxisDetails(deviceIndex, 1);
/*  78 */     if (axisDetails.length == 0) {
/*  79 */       WinTabEnvironmentPlugin.logln("ZAxis not supported");
/*     */     } else {
/*  81 */       WinTabEnvironmentPlugin.logln("Xmin: " + axisDetails[0] + ", Xmax: " + axisDetails[1]);
/*  82 */       componentsList.addAll(WinTabComponent.createComponents(context, deviceIndex, 1, axisDetails));
/*     */     }
/*     */ 
/*  85 */     axisDetails = nGetAxisDetails(deviceIndex, 2);
/*  86 */     if (axisDetails.length == 0) {
/*  87 */       WinTabEnvironmentPlugin.logln("YAxis not supported");
/*     */     } else {
/*  89 */       WinTabEnvironmentPlugin.logln("Ymin: " + axisDetails[0] + ", Ymax: " + axisDetails[1]);
/*  90 */       componentsList.addAll(WinTabComponent.createComponents(context, deviceIndex, 2, axisDetails));
/*     */     }
/*     */ 
/*  93 */     axisDetails = nGetAxisDetails(deviceIndex, 3);
/*  94 */     if (axisDetails.length == 0) {
/*  95 */       WinTabEnvironmentPlugin.logln("ZAxis not supported");
/*     */     } else {
/*  97 */       WinTabEnvironmentPlugin.logln("Zmin: " + axisDetails[0] + ", Zmax: " + axisDetails[1]);
/*  98 */       componentsList.addAll(WinTabComponent.createComponents(context, deviceIndex, 3, axisDetails));
/*     */     }
/*     */ 
/* 101 */     axisDetails = nGetAxisDetails(deviceIndex, 4);
/* 102 */     if (axisDetails.length == 0) {
/* 103 */       WinTabEnvironmentPlugin.logln("NPressureAxis not supported");
/*     */     } else {
/* 105 */       WinTabEnvironmentPlugin.logln("NPressMin: " + axisDetails[0] + ", NPressMax: " + axisDetails[1]);
/* 106 */       componentsList.addAll(WinTabComponent.createComponents(context, deviceIndex, 4, axisDetails));
/*     */     }
/*     */ 
/* 109 */     axisDetails = nGetAxisDetails(deviceIndex, 5);
/* 110 */     if (axisDetails.length == 0) {
/* 111 */       WinTabEnvironmentPlugin.logln("TPressureAxis not supported");
/*     */     } else {
/* 113 */       WinTabEnvironmentPlugin.logln("TPressureAxismin: " + axisDetails[0] + ", TPressureAxismax: " + axisDetails[1]);
/* 114 */       componentsList.addAll(WinTabComponent.createComponents(context, deviceIndex, 5, axisDetails));
/*     */     }
/*     */ 
/* 117 */     axisDetails = nGetAxisDetails(deviceIndex, 6);
/* 118 */     if (axisDetails.length == 0) {
/* 119 */       WinTabEnvironmentPlugin.logln("OrientationAxis not supported");
/*     */     } else {
/* 121 */       WinTabEnvironmentPlugin.logln("OrientationAxis mins/maxs: " + axisDetails[0] + "," + axisDetails[1] + ", " + axisDetails[2] + "," + axisDetails[3] + ", " + axisDetails[4] + "," + axisDetails[5]);
/* 122 */       componentsList.addAll(WinTabComponent.createComponents(context, deviceIndex, 6, axisDetails));
/*     */     }
/*     */ 
/* 125 */     axisDetails = nGetAxisDetails(deviceIndex, 7);
/* 126 */     if (axisDetails.length == 0) {
/* 127 */       WinTabEnvironmentPlugin.logln("RotationAxis not supported");
/*     */     } else {
/* 129 */       WinTabEnvironmentPlugin.logln("RotationAxis is supported (by the device, not by this plugin)");
/* 130 */       componentsList.addAll(WinTabComponent.createComponents(context, deviceIndex, 7, axisDetails));
/*     */     }
/*     */ 
/* 133 */     String[] cursorNames = nGetCursorNames(deviceIndex);
/* 134 */     componentsList.addAll(WinTabComponent.createCursors(context, deviceIndex, cursorNames));
/* 135 */     for (int i = 0; i < cursorNames.length; i++) {
/* 136 */       WinTabEnvironmentPlugin.logln("Cursor " + i + "'s name: " + cursorNames[i]);
/*     */     }
/*     */ 
/* 139 */     int numberOfButtons = nGetMaxButtonCount(deviceIndex);
/* 140 */     WinTabEnvironmentPlugin.logln("Device has " + numberOfButtons + " buttons");
/* 141 */     componentsList.addAll(WinTabComponent.createButtons(context, deviceIndex, numberOfButtons));
/*     */ 
/* 143 */     Component[] components = (Component[])componentsList.toArray(new Component[0]);
/*     */ 
/* 145 */     return new WinTabDevice(context, deviceIndex, name, components);
/*     */   }
/*     */ 
/*     */   private static final native String nGetName(int paramInt);
/*     */ 
/*     */   private static final native int[] nGetAxisDetails(int paramInt1, int paramInt2);
/*     */ 
/*     */   private static final native String[] nGetCursorNames(int paramInt);
/*     */ 
/*     */   private static final native int nGetMaxButtonCount(int paramInt);
/*     */ }

/* Location:           /Users/Nick/Library/Application Support/minecraft/bin/jinput.jar
 * Qualified Name:     net.java.games.input.WinTabDevice
 * JD-Core Version:    0.6.1
 */