/*     */ package net.java.games.input;
/*     */ 
/*     */ import java.io.IOException;
/*     */ 
/*     */ final class OSXHIDElement
/*     */ {
/*     */   private final OSXHIDDevice device;
/*     */   private final UsagePair usage_pair;
/*     */   private final long element_cookie;
/*     */   private final ElementType element_type;
/*     */   private final int min;
/*     */   private final int max;
/*     */   private final Component.Identifier identifier;
/*     */   private final boolean is_relative;
/*     */ 
/*     */   public OSXHIDElement(OSXHIDDevice device, UsagePair usage_pair, long element_cookie, ElementType element_type, int min, int max, boolean is_relative)
/*     */   {
/*  59 */     this.device = device;
/*  60 */     this.usage_pair = usage_pair;
/*  61 */     this.element_cookie = element_cookie;
/*  62 */     this.element_type = element_type;
/*  63 */     this.min = min;
/*  64 */     this.max = max;
/*  65 */     this.identifier = computeIdentifier();
/*  66 */     this.is_relative = is_relative;
/*     */   }
/*     */ 
/*     */   private final Component.Identifier computeIdentifier() {
/*  70 */     if (this.usage_pair.getUsagePage() == UsagePage.GENERIC_DESKTOP)
/*  71 */       return ((GenericDesktopUsage)this.usage_pair.getUsage()).getIdentifier();
/*  72 */     if (this.usage_pair.getUsagePage() == UsagePage.BUTTON)
/*  73 */       return ((ButtonUsage)this.usage_pair.getUsage()).getIdentifier();
/*  74 */     if (this.usage_pair.getUsagePage() == UsagePage.KEYBOARD_OR_KEYPAD) {
/*  75 */       return ((KeyboardUsage)this.usage_pair.getUsage()).getIdentifier();
/*     */     }
/*  77 */     return null;
/*     */   }
/*     */ 
/*     */   final Component.Identifier getIdentifier() {
/*  81 */     return this.identifier;
/*     */   }
/*     */ 
/*     */   final long getCookie() {
/*  85 */     return this.element_cookie;
/*     */   }
/*     */ 
/*     */   final ElementType getType() {
/*  89 */     return this.element_type;
/*     */   }
/*     */ 
/*     */   final boolean isRelative() {
/*  93 */     return (this.is_relative) && ((this.identifier instanceof Component.Identifier.Axis));
/*     */   }
/*     */ 
/*     */   final boolean isAnalog() {
/*  97 */     return ((this.identifier instanceof Component.Identifier.Axis)) && (this.identifier != Component.Identifier.Axis.POV);
/*     */   }
/*     */ 
/*     */   private UsagePair getUsagePair() {
/* 101 */     return this.usage_pair;
/*     */   }
/*     */ 
/*     */   final void getElementValue(OSXEvent event) throws IOException {
/* 105 */     this.device.getElementValue(this.element_cookie, event);
/*     */   }
/*     */ 
/*     */   final float convertValue(float value) {
/* 109 */     if (this.identifier == Component.Identifier.Axis.POV) {
/* 110 */       switch ((int)value) {
/*     */       case 0:
/* 112 */         return 0.25F;
/*     */       case 1:
/* 114 */         return 0.375F;
/*     */       case 2:
/* 116 */         return 0.5F;
/*     */       case 3:
/* 118 */         return 0.625F;
/*     */       case 4:
/* 120 */         return 0.75F;
/*     */       case 5:
/* 122 */         return 0.875F;
/*     */       case 6:
/* 124 */         return 1.0F;
/*     */       case 7:
/* 126 */         return 0.125F;
/*     */       case 8:
/* 128 */         return 0.0F;
/*     */       }
/* 130 */       return 0.0F;
/*     */     }
/* 132 */     if (((this.identifier instanceof Component.Identifier.Axis)) && (!this.is_relative)) {
/* 133 */       if (this.min == this.max)
/* 134 */         return 0.0F;
/* 135 */       if (value > this.max)
/* 136 */         value = this.max;
/* 137 */       else if (value < this.min)
/* 138 */         value = this.min;
/* 139 */       return 2.0F * (value - this.min) / this.max - this.min - 1.0F;
/*     */     }
/* 141 */     return value;
/*     */   }
/*     */ }

/* Location:           /Users/Nick/Library/Application Support/minecraft/bin/jinput.jar
 * Qualified Name:     net.java.games.input.OSXHIDElement
 * JD-Core Version:    0.6.1
 */