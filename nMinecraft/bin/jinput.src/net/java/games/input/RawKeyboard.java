/*     */ package net.java.games.input;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.lang.reflect.Field;
/*     */ import java.lang.reflect.Modifier;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ 
/*     */ final class RawKeyboard extends Keyboard
/*     */ {
/*  53 */   private final RawKeyboardEvent raw_event = new RawKeyboardEvent();
/*     */   private final RawDevice device;
/*     */ 
/*     */   protected RawKeyboard(String name, RawDevice device, Controller[] children, Rumbler[] rumblers)
/*     */     throws IOException
/*     */   {
/*  57 */     super(name, createKeyboardComponents(device), children, rumblers);
/*  58 */     this.device = device;
/*     */   }
/*     */ 
/*     */   private static final Component[] createKeyboardComponents(RawDevice device) {
/*  62 */     List components = new ArrayList();
/*  63 */     Field[] vkey_fields = RawIdentifierMap.class.getFields();
/*  64 */     for (int i = 0; i < vkey_fields.length; i++) {
/*  65 */       Field vkey_field = vkey_fields[i];
/*     */       try {
/*  67 */         if ((Modifier.isStatic(vkey_field.getModifiers())) && (vkey_field.getType() == Integer.TYPE)) {
/*  68 */           int vkey_code = vkey_field.getInt(null);
/*  69 */           Component.Identifier.Key key_id = RawIdentifierMap.mapVKey(vkey_code);
/*  70 */           if (key_id != Component.Identifier.Key.UNKNOWN)
/*  71 */             components.add(new Key(device, vkey_code, key_id));
/*     */         }
/*     */       } catch (IllegalAccessException e) {
/*  74 */         throw new RuntimeException(e);
/*     */       }
/*     */     }
/*  77 */     return (Component[])components.toArray(new Component[0]);
/*     */   }
/*     */ 
/*     */   protected final synchronized boolean getNextDeviceEvent(Event event) throws IOException {
/*     */     while (true) {
/*  82 */       if (!this.device.getNextKeyboardEvent(this.raw_event))
/*  83 */         return false;
/*  84 */       int vkey = this.raw_event.getVKey();
/*  85 */       Component.Identifier.Key key_id = RawIdentifierMap.mapVKey(vkey);
/*  86 */       Component key = getComponent(key_id);
/*  87 */       if (key != null)
/*     */       {
/*  89 */         int message = this.raw_event.getMessage();
/*  90 */         if ((message == 256) || (message == 260)) {
/*  91 */           event.set(key, 1.0F, this.raw_event.getNanos());
/*  92 */           return true;
/*  93 */         }if ((message == 257) || (message == 261)) {
/*  94 */           event.set(key, 0.0F, this.raw_event.getNanos());
/*  95 */           return true;
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/* 101 */   public final void pollDevice() throws IOException { this.device.pollKeyboard(); }
/*     */ 
/*     */   protected final void setDeviceEventQueueSize(int size) throws IOException
/*     */   {
/* 105 */     this.device.setBufferSize(size);
/*     */   }
/*     */   static final class Key extends AbstractComponent {
/*     */     private final RawDevice device;
/*     */     private final int vkey_code;
/*     */ 
/*     */     public Key(RawDevice device, int vkey_code, Component.Identifier.Key key_id) {
/* 113 */       super(key_id);
/* 114 */       this.device = device;
/* 115 */       this.vkey_code = vkey_code;
/*     */     }
/*     */ 
/*     */     protected final float poll() throws IOException {
/* 119 */       return this.device.isKeyDown(this.vkey_code) ? 1.0F : 0.0F;
/*     */     }
/*     */ 
/*     */     public final boolean isAnalog() {
/* 123 */       return false;
/*     */     }
/*     */ 
/*     */     public final boolean isRelative() {
/* 127 */       return false;
/*     */     }
/*     */   }
/*     */ }

/* Location:           /Users/Nick/Library/Application Support/minecraft/bin/jinput.jar
 * Qualified Name:     net.java.games.input.RawKeyboard
 * JD-Core Version:    0.6.1
 */