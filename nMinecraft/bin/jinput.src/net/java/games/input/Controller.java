/*     */ package net.java.games.input;
/*     */ 
/*     */ public abstract interface Controller
/*     */ {
/*     */   public abstract Controller[] getControllers();
/*     */ 
/*     */   public abstract Type getType();
/*     */ 
/*     */   public abstract Component[] getComponents();
/*     */ 
/*     */   public abstract Component getComponent(Component.Identifier paramIdentifier);
/*     */ 
/*     */   public abstract Rumbler[] getRumblers();
/*     */ 
/*     */   public abstract boolean poll();
/*     */ 
/*     */   public abstract void setEventQueueSize(int paramInt);
/*     */ 
/*     */   public abstract EventQueue getEventQueue();
/*     */ 
/*     */   public abstract PortType getPortType();
/*     */ 
/*     */   public abstract int getPortNumber();
/*     */ 
/*     */   public abstract String getName();
/*     */ 
/*     */   public static final class PortType
/*     */   {
/*     */     private final String name;
/* 230 */     public static final PortType UNKNOWN = new PortType("Unknown");
/*     */ 
/* 235 */     public static final PortType USB = new PortType("USB port");
/*     */ 
/* 240 */     public static final PortType GAME = new PortType("Game port");
/*     */ 
/* 245 */     public static final PortType NETWORK = new PortType("Network port");
/*     */ 
/* 250 */     public static final PortType SERIAL = new PortType("Serial port");
/*     */ 
/* 255 */     public static final PortType I8042 = new PortType("i8042 (PS/2)");
/*     */ 
/* 260 */     public static final PortType PARALLEL = new PortType("Parallel port");
/*     */ 
/*     */     protected PortType(String name)
/*     */     {
/* 217 */       this.name = name;
/*     */     }
/*     */ 
/*     */     public String toString()
/*     */     {
/* 224 */       return this.name;
/*     */     }
/*     */   }
/*     */ 
/*     */   public static class Type
/*     */   {
/*     */     private final String name;
/* 145 */     public static final Type UNKNOWN = new Type("Unknown");
/*     */ 
/* 150 */     public static final Type MOUSE = new Type("Mouse");
/*     */ 
/* 155 */     public static final Type KEYBOARD = new Type("Keyboard");
/*     */ 
/* 161 */     public static final Type FINGERSTICK = new Type("Fingerstick");
/*     */ 
/* 166 */     public static final Type GAMEPAD = new Type("Gamepad");
/*     */ 
/* 171 */     public static final Type HEADTRACKER = new Type("Headtracker");
/*     */ 
/* 176 */     public static final Type RUDDER = new Type("Rudder");
/*     */ 
/* 181 */     public static final Type STICK = new Type("Stick");
/*     */ 
/* 187 */     public static final Type TRACKBALL = new Type("Trackball");
/*     */ 
/* 193 */     public static final Type TRACKPAD = new Type("Trackpad");
/*     */ 
/* 200 */     public static final Type WHEEL = new Type("Wheel");
/*     */ 
/*     */     protected Type(String name)
/*     */     {
/* 132 */       this.name = name;
/*     */     }
/*     */ 
/*     */     public String toString()
/*     */     {
/* 139 */       return this.name;
/*     */     }
/*     */   }
/*     */ }

/* Location:           /Users/Nick/Library/Application Support/minecraft/bin/jinput.jar
 * Qualified Name:     net.java.games.input.Controller
 * JD-Core Version:    0.6.1
 */