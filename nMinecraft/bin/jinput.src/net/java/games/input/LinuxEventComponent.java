/*     */ package net.java.games.input;
/*     */ 
/*     */ import java.io.IOException;
/*     */ 
/*     */ final class LinuxEventComponent
/*     */ {
/*     */   private final LinuxEventDevice device;
/*     */   private final Component.Identifier identifier;
/*     */   private final Controller.Type button_trait;
/*     */   private final boolean is_relative;
/*     */   private final LinuxAxisDescriptor descriptor;
/*     */   private final int min;
/*     */   private final int max;
/*     */   private final int flat;
/*     */ 
/*     */   public LinuxEventComponent(LinuxEventDevice device, Component.Identifier identifier, boolean is_relative, int native_type, int native_code)
/*     */     throws IOException
/*     */   {
/*  46 */     this.device = device;
/*  47 */     this.identifier = identifier;
/*  48 */     if (native_type == 1)
/*  49 */       this.button_trait = LinuxNativeTypesMap.guessButtonTrait(native_code);
/*     */     else
/*  51 */       this.button_trait = Controller.Type.UNKNOWN;
/*  52 */     this.is_relative = is_relative;
/*  53 */     this.descriptor = new LinuxAxisDescriptor();
/*  54 */     this.descriptor.set(native_type, native_code);
/*  55 */     if (native_type == 3) {
/*  56 */       LinuxAbsInfo abs_info = new LinuxAbsInfo();
/*  57 */       getAbsInfo(abs_info);
/*  58 */       this.min = abs_info.getMin();
/*  59 */       this.max = abs_info.getMax();
/*  60 */       this.flat = abs_info.getFlat();
/*     */     } else {
/*  62 */       this.min = -2147483648;
/*  63 */       this.max = 2147483647;
/*  64 */       this.flat = 0;
/*     */     }
/*     */   }
/*     */ 
/*     */   public final LinuxEventDevice getDevice() {
/*  69 */     return this.device;
/*     */   }
/*     */ 
/*     */   public final void getAbsInfo(LinuxAbsInfo abs_info) throws IOException {
/*  73 */     assert (this.descriptor.getType() == 3);
/*  74 */     this.device.getAbsInfo(this.descriptor.getCode(), abs_info);
/*     */   }
/*     */ 
/*     */   public final Controller.Type getButtonTrait() {
/*  78 */     return this.button_trait;
/*     */   }
/*     */ 
/*     */   public final Component.Identifier getIdentifier() {
/*  82 */     return this.identifier;
/*     */   }
/*     */ 
/*     */   public final LinuxAxisDescriptor getDescriptor() {
/*  86 */     return this.descriptor;
/*     */   }
/*     */ 
/*     */   public final boolean isRelative() {
/*  90 */     return this.is_relative;
/*     */   }
/*     */ 
/*     */   public final boolean isAnalog() {
/*  94 */     return ((this.identifier instanceof Component.Identifier.Axis)) && (this.identifier != Component.Identifier.Axis.POV);
/*     */   }
/*     */ 
/*     */   final float convertValue(float value) {
/*  98 */     if (((this.identifier instanceof Component.Identifier.Axis)) && (!this.is_relative))
/*     */     {
/* 100 */       if (this.min == this.max)
/* 101 */         return 0.0F;
/* 102 */       if (value > this.max)
/* 103 */         value = this.max;
/* 104 */       else if (value < this.min)
/* 105 */         value = this.min;
/* 106 */       return 2.0F * (value - this.min) / this.max - this.min - 1.0F;
/*     */     }
/* 108 */     return value;
/*     */   }
/*     */ 
/*     */   final float getDeadZone()
/*     */   {
/* 113 */     return this.flat / (2.0F * this.max - this.min);
/*     */   }
/*     */ }

/* Location:           /Users/Nick/Library/Application Support/minecraft/bin/jinput.jar
 * Qualified Name:     net.java.games.input.LinuxEventComponent
 * JD-Core Version:    0.6.1
 */