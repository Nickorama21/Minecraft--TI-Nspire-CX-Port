/*     */ package net.java.games.input;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ 
/*     */ final class RawInputEventQueue
/*     */ {
/*     */   private final Object monitor;
/*     */   private List devices;
/*     */ 
/*     */   RawInputEventQueue()
/*     */   {
/*  52 */     this.monitor = new Object();
/*     */   }
/*     */ 
/*     */   public final void start(List devices) throws IOException
/*     */   {
/*  57 */     this.devices = devices;
/*  58 */     QueueThread queue = new QueueThread();
/*  59 */     synchronized (this.monitor) {
/*  60 */       queue.start();
/*     */ 
/*  62 */       while (!queue.isInitialized())
/*     */         try {
/*  64 */           this.monitor.wait();
/*     */         } catch (InterruptedException e) {
/*     */         }
/*     */     }
/*  68 */     if (queue.getException() != null)
/*  69 */       throw queue.getException();
/*     */   }
/*     */ 
/*     */   private final RawDevice lookupDevice(long handle) {
/*  73 */     for (int i = 0; i < this.devices.size(); i++) {
/*  74 */       RawDevice device = (RawDevice)this.devices.get(i);
/*  75 */       if (device.getHandle() == handle)
/*  76 */         return device;
/*     */     }
/*  78 */     return null;
/*     */   }
/*     */ 
/*     */   private final void addMouseEvent(long handle, long millis, int flags, int button_flags, int button_data, long raw_buttons, long last_x, long last_y, long extra_information)
/*     */   {
/*  83 */     RawDevice device = lookupDevice(handle);
/*  84 */     if (device == null)
/*  85 */       return;
/*  86 */     device.addMouseEvent(millis, flags, button_flags, button_data, raw_buttons, last_x, last_y, extra_information);
/*     */   }
/*     */ 
/*     */   private final void addKeyboardEvent(long handle, long millis, int make_code, int flags, int vkey, int message, long extra_information) {
/*  90 */     RawDevice device = lookupDevice(handle);
/*  91 */     if (device == null)
/*  92 */       return;
/*  93 */     device.addKeyboardEvent(millis, make_code, flags, vkey, message, extra_information);
/*     */   }
/*     */ 
/*     */   private final void poll(DummyWindow window) throws IOException {
/*  97 */     nPoll(window.getHwnd());
/*     */   }
/*     */   private final native void nPoll(long paramLong) throws IOException;
/*     */ 
/*     */   private static final void registerDevices(DummyWindow window, RawDeviceInfo[] devices) throws IOException {
/* 102 */     nRegisterDevices(0, window.getHwnd(), devices);
/*     */   }
/*     */   private static final native void nRegisterDevices(int paramInt, long paramLong, RawDeviceInfo[] paramArrayOfRawDeviceInfo) throws IOException;
/*     */ 
/*     */   private final class QueueThread extends Thread { private boolean initialized;
/*     */     private DummyWindow window;
/*     */     private IOException exception;
/*     */ 
/* 112 */     public QueueThread() { setDaemon(true); }
/*     */ 
/*     */     public final boolean isInitialized()
/*     */     {
/* 116 */       return this.initialized;
/*     */     }
/*     */ 
/*     */     public final IOException getException() {
/* 120 */       return this.exception;
/*     */     }
/*     */ 
/*     */     public final void run()
/*     */     {
/*     */       try {
/* 126 */         this.window = new DummyWindow();
/*     */       } catch (IOException e) {
/* 128 */         this.exception = e;
/*     */       }
/* 130 */       this.initialized = true;
/* 131 */       synchronized (RawInputEventQueue.this.monitor) {
/* 132 */         RawInputEventQueue.this.monitor.notify();
/*     */       }
/* 134 */       if (this.exception != null)
/* 135 */         return;
/* 136 */       Set active_infos = new HashSet();
/*     */       try {
/* 138 */         for (int i = 0; i < RawInputEventQueue.this.devices.size(); i++) {
/* 139 */           RawDevice device = (RawDevice)RawInputEventQueue.this.devices.get(i);
/* 140 */           active_infos.add(device.getInfo());
/*     */         }
/* 142 */         RawDeviceInfo[] active_infos_array = new RawDeviceInfo[active_infos.size()];
/* 143 */         active_infos.toArray(active_infos_array);
/*     */         try {
/* 145 */           RawInputEventQueue.registerDevices(this.window, active_infos_array);
/* 146 */           while (!isInterrupted())
/* 147 */             RawInputEventQueue.this.poll(this.window);
/*     */         }
/*     */         finally {
/* 150 */           this.window.destroy();
/*     */         }
/*     */       } catch (IOException e) {
/* 153 */         this.exception = e;
/*     */       }
/*     */     }
/*     */   }
/*     */ }

/* Location:           /Users/Nick/Library/Application Support/minecraft/bin/jinput.jar
 * Qualified Name:     net.java.games.input.RawInputEventQueue
 * JD-Core Version:    0.6.1
 */