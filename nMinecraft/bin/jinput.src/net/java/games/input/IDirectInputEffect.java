/*     */ package net.java.games.input;
/*     */ 
/*     */ import java.io.IOException;
/*     */ 
/*     */ final class IDirectInputEffect
/*     */   implements Rumbler
/*     */ {
/*     */   private final long address;
/*     */   private final DIEffectInfo info;
/*     */   private boolean released;
/*     */ 
/*     */   public IDirectInputEffect(long address, DIEffectInfo info)
/*     */   {
/*  53 */     this.address = address;
/*  54 */     this.info = info;
/*     */   }
/*     */ 
/*     */   public final synchronized void rumble(float intensity) {
/*     */     try {
/*  59 */       checkReleased();
/*  60 */       if (intensity > 0.0F) {
/*  61 */         int int_gain = Math.round(intensity * 10000.0F);
/*  62 */         setGain(int_gain);
/*  63 */         start(1, 0);
/*     */       } else {
/*  65 */         stop();
/*     */       }
/*     */     } catch (IOException e) { DirectInputEnvironmentPlugin.logln("Failed to set rumbler gain: " + e.getMessage()); }
/*     */   }
/*     */ 
/*     */   public final Component.Identifier getAxisIdentifier()
/*     */   {
/*  72 */     return null;
/*     */   }
/*     */ 
/*     */   public final String getAxisName() {
/*  76 */     return null;
/*     */   }
/*     */ 
/*     */   public final synchronized void release() {
/*  80 */     if (!this.released) {
/*  81 */       this.released = true;
/*  82 */       nRelease(this.address);
/*     */     }
/*     */   }
/*     */ 
/*     */   private static final native void nRelease(long paramLong);
/*     */ 
/*  88 */   private final void checkReleased() throws IOException { if (this.released)
/*  89 */       throw new IOException(); }
/*     */ 
/*     */   private final void setGain(int gain) throws IOException
/*     */   {
/*  93 */     int res = nSetGain(this.address, gain);
/*  94 */     if ((res != 3) && (res != 4) && (res != 0) && (res != 8) && (res != 12))
/*     */     {
/*  99 */       throw new IOException("Failed to set effect gain (0x" + Integer.toHexString(res) + ")");
/*     */     }
/*     */   }
/*     */ 
/*     */   private static final native int nSetGain(long paramLong, int paramInt);
/*     */ 
/* 105 */   private final void start(int iterations, int flags) throws IOException { int res = nStart(this.address, iterations, flags);
/* 106 */     if (res != 0)
/* 107 */       throw new IOException("Failed to start effect (0x" + Integer.toHexString(res) + ")"); }
/*     */ 
/*     */   private static final native int nStart(long paramLong, int paramInt1, int paramInt2);
/*     */ 
/*     */   private final void stop() throws IOException {
/* 112 */     int res = nStop(this.address);
/* 113 */     if (res != 0)
/* 114 */       throw new IOException("Failed to stop effect (0x" + Integer.toHexString(res) + ")"); 
/*     */   }
/*     */ 
/*     */   private static final native int nStop(long paramLong);
/*     */ 
/* 119 */   protected void finalize() { release(); }
/*     */ 
/*     */ }

/* Location:           /Users/Nick/Library/Application Support/minecraft/bin/jinput.jar
 * Qualified Name:     net.java.games.input.IDirectInputEffect
 * JD-Core Version:    0.6.1
 */