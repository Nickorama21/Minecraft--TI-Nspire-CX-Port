/*     */ package net.java.games.input;
/*     */ 
/*     */ import java.io.IOException;
/*     */ 
/*     */ abstract class LinuxForceFeedbackEffect
/*     */   implements Rumbler
/*     */ {
/*     */   private final LinuxEventDevice device;
/*     */   private final int ff_id;
/*  36 */   private final WriteTask write_task = new WriteTask(null);
/*  37 */   private final UploadTask upload_task = new UploadTask(null);
/*     */ 
/*     */   public LinuxForceFeedbackEffect(LinuxEventDevice device) throws IOException {
/*  40 */     this.device = device;
/*  41 */     this.ff_id = this.upload_task.doUpload(-1, 0.0F);
/*     */   }
/*     */ 
/*     */   protected abstract int upload(int paramInt, float paramFloat) throws IOException;
/*     */ 
/*     */   protected final LinuxEventDevice getDevice() {
/*  47 */     return this.device;
/*     */   }
/*     */ 
/*     */   public final synchronized void rumble(float intensity) {
/*     */     try {
/*  52 */       if (intensity > 0.0F) {
/*  53 */         this.upload_task.doUpload(this.ff_id, intensity);
/*  54 */         this.write_task.write(1);
/*     */       } else {
/*  56 */         this.write_task.write(0);
/*     */       }
/*     */     } catch (IOException e) {
/*  59 */       LinuxEnvironmentPlugin.logln("Failed to rumble: " + e);
/*     */     }
/*     */   }
/*     */ 
/*     */   public final String getAxisName()
/*     */   {
/*  73 */     return null;
/*     */   }
/*     */ 
/*     */   public final Component.Identifier getAxisIdentifier() {
/*  77 */     return null;
/*     */   }
/*     */ 
/*     */   private final class WriteTask extends LinuxDeviceTask
/*     */   {
/*     */     private int value;
/*     */ 
/*     */     private WriteTask()
/*     */     {
/*     */     }
/*     */ 
/*     */     public final void write(int value)
/*     */       throws IOException
/*     */     {
/* 101 */       this.value = value;
/* 102 */       LinuxEnvironmentPlugin.execute(this);
/*     */     }
/*     */ 
/*     */     protected final Object execute() throws IOException {
/* 106 */       LinuxForceFeedbackEffect.this.device.writeEvent(21, LinuxForceFeedbackEffect.this.ff_id, this.value);
/* 107 */       return null;
/*     */     }
/*     */ 
/*     */     WriteTask(LinuxForceFeedbackEffect.1 x1)
/*     */     {
/*  97 */       this();
/*     */     }
/*     */   }
/*     */ 
/*     */   private final class UploadTask extends LinuxDeviceTask
/*     */   {
/*     */     private int id;
/*     */     private float intensity;
/*     */ 
/*     */     private UploadTask()
/*     */     {
/*     */     }
/*     */ 
/*     */     public final int doUpload(int id, float intensity)
/*     */       throws IOException
/*     */     {
/*  85 */       this.id = id;
/*  86 */       this.intensity = intensity;
/*  87 */       LinuxEnvironmentPlugin.execute(this);
/*  88 */       return this.id;
/*     */     }
/*     */ 
/*     */     protected final Object execute() throws IOException {
/*  92 */       this.id = LinuxForceFeedbackEffect.this.upload(this.id, this.intensity);
/*  93 */       return null;
/*     */     }
/*     */ 
/*     */     UploadTask(LinuxForceFeedbackEffect.1 x1)
/*     */     {
/*  80 */       this();
/*     */     }
/*     */   }
/*     */ }

/* Location:           /Users/Nick/Library/Application Support/minecraft/bin/jinput.jar
 * Qualified Name:     net.java.games.input.LinuxForceFeedbackEffect
 * JD-Core Version:    0.6.1
 */