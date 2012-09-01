/*     */ package net.java.games.input;
/*     */ 
/*     */ import java.io.IOException;
/*     */ 
/*     */ final class DIDeviceObject
/*     */ {
/*     */   private static final int WHEEL_SCALE = 120;
/*     */   private final IDirectInputDevice device;
/*     */   private final byte[] guid;
/*     */   private final int identifier;
/*     */   private final int type;
/*     */   private final int instance;
/*     */   private final int guid_type;
/*     */   private final int flags;
/*     */   private final String name;
/*     */   private final Component.Identifier id;
/*     */   private final int format_offset;
/*     */   private final long min;
/*     */   private final long max;
/*     */   private final int deadzone;
/*     */   private int last_poll_value;
/*     */   private int last_event_value;
/*     */ 
/*     */   public DIDeviceObject(IDirectInputDevice device, Component.Identifier id, byte[] guid, int guid_type, int identifier, int type, int instance, int flags, String name, int format_offset)
/*     */     throws IOException
/*     */   {
/*  70 */     this.device = device;
/*  71 */     this.id = id;
/*  72 */     this.guid = guid;
/*  73 */     this.identifier = identifier;
/*  74 */     this.type = type;
/*  75 */     this.instance = instance;
/*  76 */     this.guid_type = guid_type;
/*  77 */     this.flags = flags;
/*  78 */     this.name = name;
/*  79 */     this.format_offset = format_offset;
/*  80 */     if ((isAxis()) && (!isRelative())) {
/*  81 */       long[] range = device.getRangeProperty(identifier);
/*  82 */       this.min = range[0];
/*  83 */       this.max = range[1];
/*  84 */       this.deadzone = device.getDeadzoneProperty(identifier);
/*     */     } else {
/*  86 */       this.min = -2147483648L;
/*  87 */       this.max = 2147483647L;
/*  88 */       this.deadzone = 0;
/*     */     }
/*     */   }
/*     */ 
/*     */   public final synchronized int getRelativePollValue(int current_abs_value) {
/*  93 */     if (this.device.areAxesRelative())
/*  94 */       return current_abs_value;
/*  95 */     int rel_value = current_abs_value - this.last_poll_value;
/*  96 */     this.last_poll_value = current_abs_value;
/*  97 */     return rel_value;
/*     */   }
/*     */ 
/*     */   public final synchronized int getRelativeEventValue(int current_abs_value) {
/* 101 */     if (this.device.areAxesRelative())
/* 102 */       return current_abs_value;
/* 103 */     int rel_value = current_abs_value - this.last_event_value;
/* 104 */     this.last_event_value = current_abs_value;
/* 105 */     return rel_value;
/*     */   }
/*     */ 
/*     */   public final int getGUIDType() {
/* 109 */     return this.guid_type;
/*     */   }
/*     */ 
/*     */   public final int getFormatOffset() {
/* 113 */     return this.format_offset;
/*     */   }
/*     */ 
/*     */   public final IDirectInputDevice getDevice() {
/* 117 */     return this.device;
/*     */   }
/*     */ 
/*     */   public final int getDIIdentifier() {
/* 121 */     return this.identifier;
/*     */   }
/*     */ 
/*     */   public final Component.Identifier getIdentifier() {
/* 125 */     return this.id;
/*     */   }
/*     */ 
/*     */   public final String getName() {
/* 129 */     return this.name;
/*     */   }
/*     */ 
/*     */   public final int getInstance() {
/* 133 */     return this.instance;
/*     */   }
/*     */ 
/*     */   public final int getType() {
/* 137 */     return this.type;
/*     */   }
/*     */ 
/*     */   public final byte[] getGUID() {
/* 141 */     return this.guid;
/*     */   }
/*     */ 
/*     */   public final int getFlags() {
/* 145 */     return this.flags;
/*     */   }
/*     */ 
/*     */   public final long getMin() {
/* 149 */     return this.min;
/*     */   }
/*     */ 
/*     */   public final long getMax() {
/* 153 */     return this.max;
/*     */   }
/*     */ 
/*     */   public final float getDeadzone() {
/* 157 */     return this.deadzone;
/*     */   }
/*     */ 
/*     */   public final boolean isButton() {
/* 161 */     return (this.type & 0xC) != 0;
/*     */   }
/*     */ 
/*     */   public final boolean isAxis() {
/* 165 */     return (this.type & 0x3) != 0;
/*     */   }
/*     */ 
/*     */   public final boolean isRelative() {
/* 169 */     return (isAxis()) && ((this.type & 0x1) != 0);
/*     */   }
/*     */ 
/*     */   public final boolean isAnalog() {
/* 173 */     return (isAxis()) && (this.id != Component.Identifier.Axis.POV);
/*     */   }
/*     */ 
/*     */   public final float convertValue(float value) {
/* 177 */     if ((getDevice().getType() == 18) && (this.id == Component.Identifier.Axis.Z))
/* 178 */       return value / 120.0F;
/* 179 */     if (isButton())
/* 180 */       return ((int)value & 0x80) != 0 ? 1.0F : 0.0F;
/* 181 */     if (this.id == Component.Identifier.Axis.POV) {
/* 182 */       int int_value = (int)value;
/* 183 */       if ((int_value & 0xFFFF) == 65535) {
/* 184 */         return 0.0F;
/*     */       }
/* 186 */       int slice = 2250;
/* 187 */       if ((int_value >= 0) && (int_value < slice))
/* 188 */         return 0.25F;
/* 189 */       if (int_value < 3 * slice)
/* 190 */         return 0.375F;
/* 191 */       if (int_value < 5 * slice)
/* 192 */         return 0.5F;
/* 193 */       if (int_value < 7 * slice)
/* 194 */         return 0.625F;
/* 195 */       if (int_value < 9 * slice)
/* 196 */         return 0.75F;
/* 197 */       if (int_value < 11 * slice)
/* 198 */         return 0.875F;
/* 199 */       if (int_value < 13 * slice)
/* 200 */         return 1.0F;
/* 201 */       if (int_value < 15 * slice) {
/* 202 */         return 0.125F;
/*     */       }
/* 204 */       return 0.25F;
/* 205 */     }if ((isAxis()) && (!isRelative())) {
/* 206 */       return 2.0F * (value - (float)this.min) / (float)(this.max - this.min) - 1.0F;
/*     */     }
/* 208 */     return value;
/*     */   }
/*     */ }

/* Location:           /Users/Nick/Library/Application Support/minecraft/bin/jinput.jar
 * Qualified Name:     net.java.games.input.DIDeviceObject
 * JD-Core Version:    0.6.1
 */