/*     */ package net.java.games.input;
/*     */ 
/*     */ final class RawMouseEvent
/*     */ {
/*     */   private static final int WHEEL_SCALE = 120;
/*     */   private long millis;
/*     */   private int flags;
/*     */   private int button_flags;
/*     */   private int button_data;
/*     */   private long raw_buttons;
/*     */   private long last_x;
/*     */   private long last_y;
/*     */   private long extra_information;
/*     */ 
/*     */   public final void set(long millis, int flags, int button_flags, int button_data, long raw_buttons, long last_x, long last_y, long extra_information)
/*     */   {
/*  63 */     this.millis = millis;
/*  64 */     this.flags = flags;
/*  65 */     this.button_flags = button_flags;
/*  66 */     this.button_data = button_data;
/*  67 */     this.raw_buttons = raw_buttons;
/*  68 */     this.last_x = last_x;
/*  69 */     this.last_y = last_y;
/*  70 */     this.extra_information = extra_information;
/*     */   }
/*     */ 
/*     */   public final void set(RawMouseEvent event) {
/*  74 */     set(event.millis, event.flags, event.button_flags, event.button_data, event.raw_buttons, event.last_x, event.last_y, event.extra_information);
/*     */   }
/*     */ 
/*     */   public final int getWheelDelta() {
/*  78 */     return this.button_data / 120;
/*     */   }
/*     */ 
/*     */   private final int getButtonData() {
/*  82 */     return this.button_data;
/*     */   }
/*     */ 
/*     */   public final int getFlags() {
/*  86 */     return this.flags;
/*     */   }
/*     */ 
/*     */   public final int getButtonFlags() {
/*  90 */     return this.button_flags;
/*     */   }
/*     */ 
/*     */   public final int getLastX() {
/*  94 */     return (int)this.last_x;
/*     */   }
/*     */ 
/*     */   public final int getLastY() {
/*  98 */     return (int)this.last_y;
/*     */   }
/*     */ 
/*     */   public final long getRawButtons() {
/* 102 */     return this.raw_buttons;
/*     */   }
/*     */ 
/*     */   public final long getNanos() {
/* 106 */     return this.millis * 1000000L;
/*     */   }
/*     */ }

/* Location:           /Users/Nick/Library/Application Support/minecraft/bin/jinput.jar
 * Qualified Name:     net.java.games.input.RawMouseEvent
 * JD-Core Version:    0.6.1
 */