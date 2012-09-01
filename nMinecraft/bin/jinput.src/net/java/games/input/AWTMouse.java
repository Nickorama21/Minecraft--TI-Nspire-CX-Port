/*     */ package net.java.games.input;
/*     */ 
/*     */ import java.awt.AWTEvent;
/*     */ import java.awt.Toolkit;
/*     */ import java.awt.event.AWTEventListener;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.awt.event.MouseWheelEvent;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ 
/*     */ final class AWTMouse extends Mouse
/*     */   implements AWTEventListener
/*     */ {
/*     */   private static final int EVENT_X = 1;
/*     */   private static final int EVENT_Y = 2;
/*     */   private static final int EVENT_BUTTON = 4;
/*  50 */   private final List awt_events = new ArrayList();
/*  51 */   private final List processed_awt_events = new ArrayList();
/*     */ 
/*  53 */   private int event_state = 1;
/*     */ 
/*     */   protected AWTMouse() {
/*  56 */     super("AWTMouse", createComponents(), new Controller[0], new Rumbler[0]);
/*  57 */     Toolkit.getDefaultToolkit().addAWTEventListener(this, 131120L);
/*     */   }
/*     */ 
/*     */   private static final Component[] createComponents() {
/*  61 */     return new Component[] { new Axis(Component.Identifier.Axis.X), new Axis(Component.Identifier.Axis.Y), new Axis(Component.Identifier.Axis.Z), new Button(Component.Identifier.Button.LEFT), new Button(Component.Identifier.Button.MIDDLE), new Button(Component.Identifier.Button.RIGHT) };
/*     */   }
/*     */ 
/*     */   private final void processButtons(int button_enum, float value)
/*     */   {
/*  70 */     Button button = getButton(button_enum);
/*  71 */     if (button != null)
/*  72 */       button.setValue(value);
/*     */   }
/*     */ 
/*     */   private final Button getButton(int button_enum) {
/*  76 */     switch (button_enum) {
/*     */     case 1:
/*  78 */       return (Button)getLeft();
/*     */     case 2:
/*  80 */       return (Button)getMiddle();
/*     */     case 3:
/*  82 */       return (Button)getRight();
/*     */     case 0:
/*     */     }
/*     */ 
/*  86 */     return null;
/*     */   }
/*     */ 
/*     */   private final void processEvent(AWTEvent event) throws IOException
/*     */   {
/*  91 */     if ((event instanceof MouseWheelEvent)) {
/*  92 */       MouseWheelEvent mwe = (MouseWheelEvent)event;
/*  93 */       Axis wheel = (Axis)getWheel();
/*  94 */       wheel.setValue(wheel.poll() + mwe.getWheelRotation());
/*  95 */     } else if ((event instanceof MouseEvent)) {
/*  96 */       MouseEvent me = (MouseEvent)event;
/*  97 */       Axis x = (Axis)getX();
/*  98 */       Axis y = (Axis)getY();
/*  99 */       x.setValue(me.getX());
/* 100 */       y.setValue(me.getY());
/* 101 */       switch (me.getID()) {
/*     */       case 501:
/* 103 */         processButtons(me.getButton(), 1.0F);
/* 104 */         break;
/*     */       case 502:
/* 106 */         processButtons(me.getButton(), 0.0F);
/* 107 */         break;
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public final synchronized void pollDevice()
/*     */     throws IOException
/*     */   {
/* 115 */     Axis wheel = (Axis)getWheel();
/* 116 */     wheel.setValue(0.0F);
/* 117 */     for (int i = 0; i < this.awt_events.size(); i++) {
/* 118 */       AWTEvent event = (AWTEvent)this.awt_events.get(i);
/* 119 */       processEvent(event);
/* 120 */       this.processed_awt_events.add(event);
/*     */     }
/* 122 */     this.awt_events.clear();
/*     */   }
/*     */ 
/*     */   protected final synchronized boolean getNextDeviceEvent(Event event) throws IOException {
/*     */     while (true) {
/* 127 */       if (this.processed_awt_events.isEmpty())
/* 128 */         return false;
/* 129 */       AWTEvent awt_event = (AWTEvent)this.processed_awt_events.get(0);
/* 130 */       if ((awt_event instanceof MouseWheelEvent)) {
/* 131 */         MouseWheelEvent awt_wheel_event = (MouseWheelEvent)awt_event;
/* 132 */         long nanos = awt_wheel_event.getWhen() * 1000000L;
/* 133 */         event.set(getWheel(), awt_wheel_event.getWheelRotation(), nanos);
/* 134 */         this.processed_awt_events.remove(0);
/* 135 */       } else if ((awt_event instanceof MouseEvent)) {
/* 136 */         MouseEvent mouse_event = (MouseEvent)awt_event;
/* 137 */         long nanos = mouse_event.getWhen() * 1000000L;
/* 138 */         switch (this.event_state) {
/*     */         case 1:
/* 140 */           this.event_state = 2;
/* 141 */           event.set(getX(), mouse_event.getX(), nanos);
/* 142 */           return true;
/*     */         case 2:
/* 144 */           this.event_state = 4;
/* 145 */           event.set(getY(), mouse_event.getY(), nanos);
/* 146 */           return true;
/*     */         case 4:
/* 148 */           this.processed_awt_events.remove(0);
/* 149 */           this.event_state = 1;
/* 150 */           Button button = getButton(mouse_event.getButton());
/* 151 */           if (button != null)
/* 152 */             switch (mouse_event.getID()) {
/*     */             case 501:
/* 154 */               event.set(button, 1.0F, nanos);
/* 155 */               return true;
/*     */             case 502:
/* 157 */               event.set(button, 0.0F, nanos);
/* 158 */               return true;
/*     */             }
/* 160 */           break;
/*     */         case 3:
/*     */         default:
/* 165 */           throw new RuntimeException("Unknown event state: " + this.event_state);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public final synchronized void eventDispatched(AWTEvent event) {
/* 172 */     this.awt_events.add(event);
/*     */   }
/*     */ 
/*     */   static final class Button extends AbstractComponent
/*     */   {
/*     */     private float value;
/*     */ 
/*     */     public Button(Component.Identifier.Button button_id)
/*     */     {
/* 203 */       super(button_id);
/*     */     }
/*     */ 
/*     */     protected final void setValue(float value) {
/* 207 */       this.value = value;
/*     */     }
/*     */ 
/*     */     protected final float poll() throws IOException {
/* 211 */       return this.value;
/*     */     }
/*     */ 
/*     */     public final boolean isAnalog() {
/* 215 */       return false;
/*     */     }
/*     */ 
/*     */     public final boolean isRelative() {
/* 219 */       return false;
/*     */     }
/*     */   }
/*     */ 
/*     */   static final class Axis extends AbstractComponent
/*     */   {
/*     */     private float value;
/*     */ 
/*     */     public Axis(Component.Identifier.Axis axis_id)
/*     */     {
/* 179 */       super(axis_id);
/*     */     }
/*     */ 
/*     */     public final boolean isRelative() {
/* 183 */       return false;
/*     */     }
/*     */ 
/*     */     public final boolean isAnalog() {
/* 187 */       return true;
/*     */     }
/*     */ 
/*     */     protected final void setValue(float value) {
/* 191 */       this.value = value;
/*     */     }
/*     */ 
/*     */     protected final float poll() throws IOException {
/* 195 */       return this.value;
/*     */     }
/*     */   }
/*     */ }

/* Location:           /Users/Nick/Library/Application Support/minecraft/bin/jinput.jar
 * Qualified Name:     net.java.games.input.AWTMouse
 * JD-Core Version:    0.6.1
 */