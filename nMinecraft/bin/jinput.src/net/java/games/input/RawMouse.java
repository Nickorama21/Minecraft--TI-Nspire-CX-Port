/*     */ package net.java.games.input;
/*     */ 
/*     */ import java.io.IOException;
/*     */ 
/*     */ final class RawMouse extends Mouse
/*     */ {
/*     */   private static final int EVENT_DONE = 1;
/*     */   private static final int EVENT_X = 2;
/*     */   private static final int EVENT_Y = 3;
/*     */   private static final int EVENT_Z = 4;
/*     */   private static final int EVENT_BUTTON_0 = 5;
/*     */   private static final int EVENT_BUTTON_1 = 6;
/*     */   private static final int EVENT_BUTTON_2 = 7;
/*     */   private static final int EVENT_BUTTON_3 = 8;
/*     */   private static final int EVENT_BUTTON_4 = 9;
/*     */   private final RawDevice device;
/*  74 */   private final RawMouseEvent current_event = new RawMouseEvent();
/*  75 */   private int event_state = 1;
/*     */ 
/*     */   protected RawMouse(String name, RawDevice device, Component[] components, Controller[] children, Rumbler[] rumblers) throws IOException {
/*  78 */     super(name, components, children, rumblers);
/*  79 */     this.device = device;
/*     */   }
/*     */ 
/*     */   public final void pollDevice() throws IOException {
/*  83 */     this.device.pollMouse();
/*     */   }
/*     */ 
/*     */   private static final boolean makeButtonEvent(RawMouseEvent mouse_event, Event event, Component button_component, int down_flag, int up_flag) {
/*  87 */     if ((mouse_event.getButtonFlags() & down_flag) != 0) {
/*  88 */       event.set(button_component, 1.0F, mouse_event.getNanos());
/*  89 */       return true;
/*  90 */     }if ((mouse_event.getButtonFlags() & up_flag) != 0) {
/*  91 */       event.set(button_component, 0.0F, mouse_event.getNanos());
/*  92 */       return true;
/*     */     }
/*  94 */     return false;
/*     */   }
/*     */ 
/*     */   protected final synchronized boolean getNextDeviceEvent(Event event) throws IOException {
/*     */     while (true)
/*  99 */       switch (this.event_state) {
/*     */       case 1:
/* 101 */         if (!this.device.getNextMouseEvent(this.current_event))
/* 102 */           return false;
/* 103 */         this.event_state = 2;
/* 104 */         break;
/*     */       case 2:
/* 106 */         int rel_x = this.device.getEventRelativeX();
/* 107 */         this.event_state = 3;
/* 108 */         if (rel_x != 0) {
/* 109 */           event.set(getX(), rel_x, this.current_event.getNanos());
/* 110 */           return true;
/*     */         }
/*     */         break;
/*     */       case 3:
/* 114 */         int rel_y = this.device.getEventRelativeY();
/* 115 */         this.event_state = 4;
/* 116 */         if (rel_y != 0) {
/* 117 */           event.set(getY(), rel_y, this.current_event.getNanos());
/* 118 */           return true;
/*     */         }
/*     */         break;
/*     */       case 4:
/* 122 */         int wheel = this.current_event.getWheelDelta();
/* 123 */         this.event_state = 5;
/* 124 */         if (wheel != 0) {
/* 125 */           event.set(getWheel(), wheel, this.current_event.getNanos());
/* 126 */           return true;
/*     */         }
/*     */         break;
/*     */       case 5:
/* 130 */         this.event_state = 6;
/* 131 */         if (makeButtonEvent(this.current_event, event, getPrimaryButton(), 1, 2))
/* 132 */           return true;
/*     */         break;
/*     */       case 6:
/* 135 */         this.event_state = 7;
/* 136 */         if (makeButtonEvent(this.current_event, event, getSecondaryButton(), 4, 8))
/* 137 */           return true;
/*     */         break;
/*     */       case 7:
/* 140 */         this.event_state = 8;
/* 141 */         if (makeButtonEvent(this.current_event, event, getTertiaryButton(), 16, 32))
/* 142 */           return true;
/*     */         break;
/*     */       case 8:
/* 145 */         this.event_state = 9;
/* 146 */         if (makeButtonEvent(this.current_event, event, getButton3(), 64, 128))
/* 147 */           return true;
/*     */         break;
/*     */       case 9:
/* 150 */         this.event_state = 1;
/* 151 */         if (makeButtonEvent(this.current_event, event, getButton4(), 256, 512))
/* 152 */           return true;
/*     */         break;
/*     */       default:
/* 155 */         throw new RuntimeException("Unknown event state: " + this.event_state);
/*     */       }
/*     */   }
/*     */ 
/*     */   protected final void setDeviceEventQueueSize(int size) throws IOException
/*     */   {
/* 161 */     this.device.setBufferSize(size);
/*     */   }
/*     */ 
/*     */   static final class Button extends AbstractComponent
/*     */   {
/*     */     private final RawDevice device;
/*     */     private final int button_id;
/*     */ 
/*     */     public Button(RawDevice device, Component.Identifier.Button id, int button_id)
/*     */     {
/* 197 */       super(id);
/* 198 */       this.device = device;
/* 199 */       this.button_id = button_id;
/*     */     }
/*     */ 
/*     */     protected final float poll() throws IOException {
/* 203 */       return this.device.getButtonState(this.button_id) ? 1.0F : 0.0F;
/*     */     }
/*     */ 
/*     */     public final boolean isAnalog() {
/* 207 */       return false;
/*     */     }
/*     */ 
/*     */     public final boolean isRelative() {
/* 211 */       return false;
/*     */     }
/*     */   }
/*     */ 
/*     */   static final class Axis extends AbstractComponent
/*     */   {
/*     */     private final RawDevice device;
/*     */ 
/*     */     public Axis(RawDevice device, Component.Identifier.Axis axis)
/*     */     {
/* 168 */       super(axis);
/* 169 */       this.device = device;
/*     */     }
/*     */ 
/*     */     public final boolean isRelative() {
/* 173 */       return true;
/*     */     }
/*     */ 
/*     */     public final boolean isAnalog() {
/* 177 */       return true;
/*     */     }
/*     */ 
/*     */     protected final float poll() throws IOException {
/* 181 */       if (getIdentifier() == Component.Identifier.Axis.X)
/* 182 */         return this.device.getRelativeX();
/* 183 */       if (getIdentifier() == Component.Identifier.Axis.Y)
/* 184 */         return this.device.getRelativeY();
/* 185 */       if (getIdentifier() == Component.Identifier.Axis.Z) {
/* 186 */         return this.device.getWheel();
/*     */       }
/* 188 */       throw new RuntimeException("Unknown raw axis: " + getIdentifier());
/*     */     }
/*     */   }
/*     */ }

/* Location:           /Users/Nick/Library/Application Support/minecraft/bin/jinput.jar
 * Qualified Name:     net.java.games.input.RawMouse
 * JD-Core Version:    0.6.1
 */