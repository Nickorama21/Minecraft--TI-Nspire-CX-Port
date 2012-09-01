/*     */ package net.java.games.input;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ 
/*     */ final class OSXHIDQueue
/*     */ {
/*  50 */   private final Map map = new HashMap();
/*     */   private final long queue_address;
/*     */   private boolean released;
/*     */ 
/*     */   public OSXHIDQueue(long address, int queue_depth)
/*     */     throws IOException
/*     */   {
/*  56 */     this.queue_address = address;
/*     */     try {
/*  58 */       createQueue(queue_depth);
/*     */     } catch (IOException e) {
/*  60 */       release();
/*  61 */       throw e;
/*     */     }
/*     */   }
/*     */ 
/*     */   public final synchronized void setQueueDepth(int queue_depth) throws IOException {
/*  66 */     checkReleased();
/*  67 */     stop();
/*  68 */     close();
/*  69 */     createQueue(queue_depth);
/*     */   }
/*     */ 
/*     */   private final void createQueue(int queue_depth) throws IOException {
/*  73 */     open(queue_depth);
/*     */     try {
/*  75 */       start();
/*     */     } catch (IOException e) {
/*  77 */       close();
/*  78 */       throw e;
/*     */     }
/*     */   }
/*     */ 
/*     */   public final OSXComponent mapEvent(OSXEvent event) {
/*  83 */     return (OSXComponent)this.map.get(new Long(event.getCookie()));
/*     */   }
/*     */ 
/*     */   private final void open(int queue_depth) throws IOException {
/*  87 */     nOpen(this.queue_address, queue_depth);
/*     */   }
/*     */   private static final native void nOpen(long paramLong, int paramInt) throws IOException;
/*     */ 
/*     */   private final void close() throws IOException {
/*  92 */     nClose(this.queue_address);
/*     */   }
/*     */   private static final native void nClose(long paramLong) throws IOException;
/*     */ 
/*     */   private final void start() throws IOException {
/*  97 */     nStart(this.queue_address);
/*     */   }
/*     */   private static final native void nStart(long paramLong) throws IOException;
/*     */ 
/*     */   private final void stop() throws IOException {
/* 102 */     nStop(this.queue_address);
/*     */   }
/*     */   private static final native void nStop(long paramLong) throws IOException;
/*     */ 
/*     */   public final synchronized void release() throws IOException {
/* 107 */     if (!this.released) {
/* 108 */       this.released = true;
/*     */       try {
/* 110 */         stop();
/* 111 */         close();
/*     */       } finally {
/* 113 */         nReleaseQueue(this.queue_address);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   private static final native void nReleaseQueue(long paramLong) throws IOException;
/*     */ 
/* 120 */   public final void addElement(OSXHIDElement element, OSXComponent component) throws IOException { nAddElement(this.queue_address, element.getCookie());
/* 121 */     this.map.put(new Long(element.getCookie()), component); }
/*     */ 
/*     */   private static final native void nAddElement(long paramLong1, long paramLong2) throws IOException;
/*     */ 
/*     */   public final void removeElement(OSXHIDElement element) throws IOException {
/* 126 */     nRemoveElement(this.queue_address, element.getCookie());
/* 127 */     this.map.remove(new Long(element.getCookie()));
/*     */   }
/*     */   private static final native void nRemoveElement(long paramLong1, long paramLong2) throws IOException;
/*     */ 
/*     */   public final synchronized boolean getNextEvent(OSXEvent event) throws IOException {
/* 132 */     checkReleased();
/* 133 */     return nGetNextEvent(this.queue_address, event);
/*     */   }
/*     */   private static final native boolean nGetNextEvent(long paramLong, OSXEvent paramOSXEvent) throws IOException;
/*     */ 
/*     */   private final void checkReleased() throws IOException {
/* 138 */     if (this.released)
/* 139 */       throw new IOException("Queue is released");
/*     */   }
/*     */ }

/* Location:           /Users/Nick/Library/Application Support/minecraft/bin/jinput.jar
 * Qualified Name:     net.java.games.input.OSXHIDQueue
 * JD-Core Version:    0.6.1
 */