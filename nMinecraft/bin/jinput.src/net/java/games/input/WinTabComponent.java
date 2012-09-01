/*     */ package net.java.games.input;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.lang.reflect.Field;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.List;
/*     */ 
/*     */ public class WinTabComponent extends AbstractComponent
/*     */ {
/*     */   public static final int XAxis = 1;
/*     */   public static final int YAxis = 2;
/*     */   public static final int ZAxis = 3;
/*     */   public static final int NPressureAxis = 4;
/*     */   public static final int TPressureAxis = 5;
/*     */   public static final int OrientationAxis = 6;
/*     */   public static final int RotationAxis = 7;
/*     */   private int min;
/*     */   private int max;
/*     */   protected float lastKnownValue;
/*     */   private boolean analog;
/*     */ 
/*     */   protected WinTabComponent(WinTabContext context, int parentDevice, String name, Component.Identifier id, int min, int max)
/*     */   {
/*  50 */     super(name, id);
/*  51 */     this.min = min;
/*  52 */     this.max = max;
/*  53 */     this.analog = true;
/*     */   }
/*     */ 
/*     */   protected WinTabComponent(WinTabContext context, int parentDevice, String name, Component.Identifier id) {
/*  57 */     super(name, id);
/*  58 */     this.min = 0;
/*  59 */     this.max = 1;
/*  60 */     this.analog = false;
/*     */   }
/*     */ 
/*     */   protected float poll() throws IOException {
/*  64 */     return this.lastKnownValue;
/*     */   }
/*     */ 
/*     */   public boolean isAnalog() {
/*  68 */     return this.analog;
/*     */   }
/*     */ 
/*     */   public boolean isRelative()
/*     */   {
/*  73 */     return false;
/*     */   }
/*     */ 
/*     */   public static List createComponents(WinTabContext context, int parentDevice, int axisId, int[] axisRanges) {
/*  77 */     List components = new ArrayList();
/*     */     Component.Identifier id;
/*  79 */     switch (axisId) {
/*     */     case 1:
/*  81 */       id = Component.Identifier.Axis.X;
/*  82 */       components.add(new WinTabComponent(context, parentDevice, id.getName(), id, axisRanges[0], axisRanges[1]));
/*  83 */       break;
/*     */     case 2:
/*  85 */       id = Component.Identifier.Axis.Y;
/*  86 */       components.add(new WinTabComponent(context, parentDevice, id.getName(), id, axisRanges[0], axisRanges[1]));
/*  87 */       break;
/*     */     case 3:
/*  89 */       id = Component.Identifier.Axis.Z;
/*  90 */       components.add(new WinTabComponent(context, parentDevice, id.getName(), id, axisRanges[0], axisRanges[1]));
/*  91 */       break;
/*     */     case 4:
/*  93 */       id = Component.Identifier.Axis.X_FORCE;
/*  94 */       components.add(new WinTabComponent(context, parentDevice, id.getName(), id, axisRanges[0], axisRanges[1]));
/*  95 */       break;
/*     */     case 5:
/*  97 */       id = Component.Identifier.Axis.Y_FORCE;
/*  98 */       components.add(new WinTabComponent(context, parentDevice, id.getName(), id, axisRanges[0], axisRanges[1]));
/*  99 */       break;
/*     */     case 6:
/* 101 */       id = Component.Identifier.Axis.RX;
/* 102 */       components.add(new WinTabComponent(context, parentDevice, id.getName(), id, axisRanges[0], axisRanges[1]));
/* 103 */       id = Component.Identifier.Axis.RY;
/* 104 */       components.add(new WinTabComponent(context, parentDevice, id.getName(), id, axisRanges[2], axisRanges[3]));
/* 105 */       id = Component.Identifier.Axis.RZ;
/* 106 */       components.add(new WinTabComponent(context, parentDevice, id.getName(), id, axisRanges[4], axisRanges[5]));
/* 107 */       break;
/*     */     case 7:
/* 109 */       id = Component.Identifier.Axis.RX;
/* 110 */       components.add(new WinTabComponent(context, parentDevice, id.getName(), id, axisRanges[0], axisRanges[1]));
/* 111 */       id = Component.Identifier.Axis.RY;
/* 112 */       components.add(new WinTabComponent(context, parentDevice, id.getName(), id, axisRanges[2], axisRanges[3]));
/* 113 */       id = Component.Identifier.Axis.RZ;
/* 114 */       components.add(new WinTabComponent(context, parentDevice, id.getName(), id, axisRanges[4], axisRanges[5]));
/*     */     }
/*     */ 
/* 118 */     return components;
/*     */   }
/*     */ 
/*     */   public static Collection createButtons(WinTabContext context, int deviceIndex, int numberOfButtons) {
/* 122 */     List buttons = new ArrayList();
/*     */ 
/* 125 */     for (int i = 0; i < numberOfButtons; i++) {
/*     */       try {
/* 127 */         Class buttonIdClass = Component.Identifier.Button.class;
/* 128 */         Field idField = buttonIdClass.getField("_" + i);
/* 129 */         Component.Identifier id = (Component.Identifier)idField.get(null);
/* 130 */         buttons.add(new WinTabButtonComponent(context, deviceIndex, id.getName(), id, i));
/*     */       }
/*     */       catch (SecurityException e) {
/* 133 */         e.printStackTrace();
/*     */       }
/*     */       catch (NoSuchFieldException e) {
/* 136 */         e.printStackTrace();
/*     */       }
/*     */       catch (IllegalArgumentException e) {
/* 139 */         e.printStackTrace();
/*     */       }
/*     */       catch (IllegalAccessException e) {
/* 142 */         e.printStackTrace();
/*     */       }
/*     */     }
/*     */ 
/* 146 */     return buttons;
/*     */   }
/*     */ 
/*     */   public Event processPacket(WinTabPacket packet)
/*     */   {
/* 151 */     float newValue = this.lastKnownValue;
/*     */ 
/* 153 */     if (getIdentifier() == Component.Identifier.Axis.X) {
/* 154 */       newValue = normalise(packet.PK_X);
/*     */     }
/* 156 */     if (getIdentifier() == Component.Identifier.Axis.Y) {
/* 157 */       newValue = normalise(packet.PK_Y);
/*     */     }
/* 159 */     if (getIdentifier() == Component.Identifier.Axis.Z) {
/* 160 */       newValue = normalise(packet.PK_Z);
/*     */     }
/* 162 */     if (getIdentifier() == Component.Identifier.Axis.X_FORCE) {
/* 163 */       newValue = normalise(packet.PK_NORMAL_PRESSURE);
/*     */     }
/* 165 */     if (getIdentifier() == Component.Identifier.Axis.Y_FORCE) {
/* 166 */       newValue = normalise(packet.PK_TANGENT_PRESSURE);
/*     */     }
/* 168 */     if (getIdentifier() == Component.Identifier.Axis.RX) {
/* 169 */       newValue = normalise(packet.PK_ORIENTATION_ALT);
/*     */     }
/* 171 */     if (getIdentifier() == Component.Identifier.Axis.RY) {
/* 172 */       newValue = normalise(packet.PK_ORIENTATION_AZ);
/*     */     }
/* 174 */     if (getIdentifier() == Component.Identifier.Axis.RZ) {
/* 175 */       newValue = normalise(packet.PK_ORIENTATION_TWIST);
/*     */     }
/* 177 */     if (newValue != getPollData()) {
/* 178 */       this.lastKnownValue = newValue;
/*     */ 
/* 181 */       Event newEvent = new Event();
/* 182 */       newEvent.set(this, newValue, packet.PK_TIME * 1000L);
/* 183 */       return newEvent;
/*     */     }
/*     */ 
/* 186 */     return null;
/*     */   }
/*     */ 
/*     */   private float normalise(float value) {
/* 190 */     if (this.max == this.min) return value;
/* 191 */     float bottom = this.max - this.min;
/* 192 */     return (value - this.min) / bottom;
/*     */   }
/*     */ 
/*     */   public static Collection createCursors(WinTabContext context, int deviceIndex, String[] cursorNames)
/*     */   {
/* 197 */     List cursors = new ArrayList();
/*     */ 
/* 199 */     for (int i = 0; i < cursorNames.length; i++)
/*     */     {
/*     */       Component.Identifier id;
/*     */       Component.Identifier id;
/* 200 */       if (cursorNames[i].matches("Puck")) {
/* 201 */         id = Component.Identifier.Button.TOOL_FINGER;
/*     */       }
/*     */       else
/*     */       {
/*     */         Component.Identifier id;
/* 202 */         if (cursorNames[i].matches("Eraser.*"))
/* 203 */           id = Component.Identifier.Button.TOOL_RUBBER;
/*     */         else
/* 205 */           id = Component.Identifier.Button.TOOL_PEN;
/*     */       }
/* 207 */       cursors.add(new WinTabCursorComponent(context, deviceIndex, id.getName(), id, i));
/*     */     }
/*     */ 
/* 210 */     return cursors;
/*     */   }
/*     */ }

/* Location:           /Users/Nick/Library/Application Support/minecraft/bin/jinput.jar
 * Qualified Name:     net.java.games.input.WinTabComponent
 * JD-Core Version:    0.6.1
 */