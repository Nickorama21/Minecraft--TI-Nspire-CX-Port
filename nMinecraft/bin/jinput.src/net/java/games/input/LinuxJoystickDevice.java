/*     */ package net.java.games.input;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ 
/*     */ final class LinuxJoystickDevice
/*     */   implements LinuxDevice
/*     */ {
/*     */   public static final int JS_EVENT_BUTTON = 1;
/*     */   public static final int JS_EVENT_AXIS = 2;
/*     */   public static final int JS_EVENT_INIT = 128;
/*     */   public static final int AXIS_MAX_VALUE = 32767;
/*     */   private final long fd;
/*     */   private final String name;
/*  47 */   private final LinuxJoystickEvent joystick_event = new LinuxJoystickEvent();
/*  48 */   private final Event event = new Event();
/*     */   private final LinuxJoystickButton[] buttons;
/*     */   private final LinuxJoystickAxis[] axes;
/*  51 */   private final Map povXs = new HashMap();
/*  52 */   private final Map povYs = new HashMap();
/*     */   private final byte[] axisMap;
/*     */   private final char[] buttonMap;
/*     */   private EventQueue event_queue;
/*     */   private boolean closed;
/*     */ 
/*     */   public LinuxJoystickDevice(String filename)
/*     */     throws IOException
/*     */   {
/*  64 */     this.fd = nOpen(filename);
/*     */     try {
/*  66 */       this.name = getDeviceName();
/*  67 */       setBufferSize(32);
/*  68 */       this.buttons = new LinuxJoystickButton[getNumDeviceButtons()];
/*  69 */       this.axes = new LinuxJoystickAxis[getNumDeviceAxes()];
/*  70 */       this.axisMap = getDeviceAxisMap();
/*  71 */       this.buttonMap = getDeviceButtonMap();
/*     */     } catch (IOException e) {
/*  73 */       close();
/*  74 */       throw e;
/*     */     }
/*     */   }
/*     */ 
/*     */   private static final native long nOpen(String paramString) throws IOException;
/*     */ 
/*  80 */   public final synchronized void setBufferSize(int size) { this.event_queue = new EventQueue(size); }
/*     */ 
/*     */   private final void processEvent(LinuxJoystickEvent joystick_event)
/*     */   {
/*  84 */     int index = joystick_event.getNumber();
/*     */ 
/*  86 */     int type = joystick_event.getType() & 0xFFFFFF7F;
/*  87 */     switch (type) {
/*     */     case 1:
/*  89 */       if (index < getNumButtons()) {
/*  90 */         LinuxJoystickButton button = this.buttons[index];
/*  91 */         if (button != null) {
/*  92 */           float value = joystick_event.getValue();
/*  93 */           button.setValue(value);
/*  94 */           this.event.set(button, value, joystick_event.getNanos());
/*  95 */           break;
/*     */         }
/*     */       }
/*  98 */       return;
/*     */     case 2:
/* 100 */       if (index < getNumAxes()) {
/* 101 */         LinuxJoystickAxis axis = this.axes[index];
/* 102 */         if (axis != null) {
/* 103 */           float value = joystick_event.getValue() / 32767.0F;
/* 104 */           axis.setValue(value);
/* 105 */           if (this.povXs.containsKey(new Integer(index))) {
/* 106 */             LinuxJoystickPOV pov = (LinuxJoystickPOV)this.povXs.get(new Integer(index));
/* 107 */             pov.updateValue();
/* 108 */             this.event.set(pov, pov.getPollData(), joystick_event.getNanos());
/* 109 */             break; } if (this.povYs.containsKey(new Integer(index))) {
/* 110 */             LinuxJoystickPOV pov = (LinuxJoystickPOV)this.povYs.get(new Integer(index));
/* 111 */             pov.updateValue();
/* 112 */             this.event.set(pov, pov.getPollData(), joystick_event.getNanos());
/* 113 */             break;
/* 114 */           }this.event.set(axis, value, joystick_event.getNanos());
/*     */ 
/* 116 */           break;
/*     */         }
/*     */       }
/* 119 */       return;
/*     */     default:
/* 122 */       return;
/*     */     }
/* 124 */     if (!this.event_queue.isFull())
/* 125 */       this.event_queue.add(this.event);
/*     */   }
/*     */ 
/*     */   public final void registerAxis(int index, LinuxJoystickAxis axis)
/*     */   {
/* 130 */     this.axes[index] = axis;
/*     */   }
/*     */ 
/*     */   public final void registerButton(int index, LinuxJoystickButton button) {
/* 134 */     this.buttons[index] = button;
/*     */   }
/*     */ 
/*     */   public final void registerPOV(LinuxJoystickPOV pov)
/*     */   {
/* 139 */     LinuxJoystickAxis xAxis = pov.getYAxis();
/* 140 */     LinuxJoystickAxis yAxis = pov.getXAxis();
/*     */ 
/* 143 */     for (int xIndex = 0; (xIndex < this.axes.length) && 
/* 144 */       (this.axes[xIndex] != xAxis); xIndex++);
/* 148 */     for (int yIndex = 0; (yIndex < this.axes.length) && 
/* 149 */       (this.axes[yIndex] != yAxis); yIndex++);
/* 153 */     this.povXs.put(new Integer(xIndex), pov);
/* 154 */     this.povYs.put(new Integer(yIndex), pov);
/*     */   }
/*     */ 
/*     */   public final synchronized boolean getNextEvent(Event event) throws IOException {
/* 158 */     return this.event_queue.getNextEvent(event);
/*     */   }
/*     */ 
/*     */   public final synchronized void poll() throws IOException {
/* 162 */     checkClosed();
/* 163 */     while (getNextDeviceEvent(this.joystick_event))
/* 164 */       processEvent(this.joystick_event);
/*     */   }
/*     */ 
/*     */   private final boolean getNextDeviceEvent(LinuxJoystickEvent joystick_event) throws IOException
/*     */   {
/* 169 */     return nGetNextEvent(this.fd, joystick_event);
/*     */   }
/*     */   private static final native boolean nGetNextEvent(long paramLong, LinuxJoystickEvent paramLinuxJoystickEvent) throws IOException;
/*     */ 
/*     */   public final int getNumAxes() {
/* 174 */     return this.axes.length;
/*     */   }
/*     */ 
/*     */   public final int getNumButtons() {
/* 178 */     return this.buttons.length;
/*     */   }
/*     */ 
/*     */   public final byte[] getAxisMap() {
/* 182 */     return this.axisMap;
/*     */   }
/*     */ 
/*     */   public final char[] getButtonMap() {
/* 186 */     return this.buttonMap;
/*     */   }
/*     */ 
/*     */   private final int getNumDeviceButtons() throws IOException {
/* 190 */     return nGetNumButtons(this.fd);
/*     */   }
/*     */   private static final native int nGetNumButtons(long paramLong) throws IOException;
/*     */ 
/*     */   private final int getNumDeviceAxes() throws IOException {
/* 195 */     return nGetNumAxes(this.fd);
/*     */   }
/*     */   private static final native int nGetNumAxes(long paramLong) throws IOException;
/*     */ 
/*     */   private final byte[] getDeviceAxisMap() throws IOException {
/* 200 */     return nGetAxisMap(this.fd);
/*     */   }
/*     */   private static final native byte[] nGetAxisMap(long paramLong) throws IOException;
/*     */ 
/*     */   private final char[] getDeviceButtonMap() throws IOException {
/* 205 */     return nGetButtonMap(this.fd);
/*     */   }
/*     */   private static final native char[] nGetButtonMap(long paramLong) throws IOException;
/*     */ 
/*     */   private final int getVersion() throws IOException {
/* 210 */     return nGetVersion(this.fd);
/*     */   }
/*     */   private static final native int nGetVersion(long paramLong) throws IOException;
/*     */ 
/*     */   public final String getName() {
/* 215 */     return this.name;
/*     */   }
/*     */ 
/*     */   private final String getDeviceName() throws IOException {
/* 219 */     return nGetName(this.fd);
/*     */   }
/*     */   private static final native String nGetName(long paramLong) throws IOException;
/*     */ 
/*     */   public final synchronized void close() throws IOException {
/* 224 */     if (!this.closed) {
/* 225 */       this.closed = true;
/* 226 */       nClose(this.fd);
/*     */     }
/*     */   }
/*     */ 
/*     */   private static final native void nClose(long paramLong) throws IOException;
/*     */ 
/* 232 */   private final void checkClosed() throws IOException { if (this.closed)
/* 233 */       throw new IOException("Device is closed"); }
/*     */ 
/*     */   protected void finalize() throws IOException
/*     */   {
/* 237 */     close();
/*     */   }
/*     */ }

/* Location:           /Users/Nick/Library/Application Support/minecraft/bin/jinput.jar
 * Qualified Name:     net.java.games.input.LinuxJoystickDevice
 * JD-Core Version:    0.6.1
 */