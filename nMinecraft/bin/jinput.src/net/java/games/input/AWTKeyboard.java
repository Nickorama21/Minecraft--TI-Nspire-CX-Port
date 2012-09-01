/*     */ package net.java.games.input;
/*     */ 
/*     */ import java.awt.AWTEvent;
/*     */ import java.awt.EventQueue;
/*     */ import java.awt.Toolkit;
/*     */ import java.awt.event.AWTEventListener;
/*     */ import java.awt.event.KeyEvent;
/*     */ import java.io.IOException;
/*     */ import java.lang.reflect.Field;
/*     */ import java.lang.reflect.Modifier;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ 
/*     */ final class AWTKeyboard extends Keyboard
/*     */   implements AWTEventListener
/*     */ {
/*  46 */   private final List awt_events = new ArrayList();
/*     */   private Event[] processed_events;
/*     */   private int processed_events_index;
/*     */ 
/*     */   protected AWTKeyboard()
/*     */   {
/*  51 */     super("AWTKeyboard", createComponents(), new Controller[0], new Rumbler[0]);
/*  52 */     Toolkit.getDefaultToolkit().addAWTEventListener(this, 8L);
/*  53 */     resizeEventQueue(32);
/*     */   }
/*     */ 
/*     */   private static final Component[] createComponents() {
/*  57 */     List components = new ArrayList();
/*  58 */     Field[] vkey_fields = KeyEvent.class.getFields();
/*  59 */     for (int i = 0; i < vkey_fields.length; i++) {
/*  60 */       Field vkey_field = vkey_fields[i];
/*     */       try {
/*  62 */         if ((Modifier.isStatic(vkey_field.getModifiers())) && (vkey_field.getType() == Integer.TYPE) && (vkey_field.getName().startsWith("VK_")))
/*     */         {
/*  64 */           int vkey_code = vkey_field.getInt(null);
/*  65 */           Component.Identifier.Key key_id = AWTKeyMap.mapKeyCode(vkey_code);
/*  66 */           if (key_id != Component.Identifier.Key.UNKNOWN)
/*  67 */             components.add(new Key(key_id));
/*     */         }
/*     */       } catch (IllegalAccessException e) {
/*  70 */         throw new RuntimeException(e);
/*     */       }
/*     */     }
/*  73 */     components.add(new Key(Component.Identifier.Key.RCONTROL));
/*  74 */     components.add(new Key(Component.Identifier.Key.LCONTROL));
/*  75 */     components.add(new Key(Component.Identifier.Key.RSHIFT));
/*  76 */     components.add(new Key(Component.Identifier.Key.LSHIFT));
/*  77 */     components.add(new Key(Component.Identifier.Key.RALT));
/*  78 */     components.add(new Key(Component.Identifier.Key.LALT));
/*  79 */     components.add(new Key(Component.Identifier.Key.NUMPADENTER));
/*  80 */     components.add(new Key(Component.Identifier.Key.RETURN));
/*  81 */     components.add(new Key(Component.Identifier.Key.NUMPADCOMMA));
/*  82 */     components.add(new Key(Component.Identifier.Key.COMMA));
/*  83 */     return (Component[])components.toArray(new Component[0]);
/*     */   }
/*     */ 
/*     */   private final void resizeEventQueue(int size) {
/*  87 */     this.processed_events = new Event[size];
/*  88 */     for (int i = 0; i < this.processed_events.length; i++)
/*  89 */       this.processed_events[i] = new Event();
/*  90 */     this.processed_events_index = 0;
/*     */   }
/*     */ 
/*     */   protected final void setDeviceEventQueueSize(int size) throws IOException {
/*  94 */     resizeEventQueue(size);
/*     */   }
/*     */ 
/*     */   public final synchronized void eventDispatched(AWTEvent event) {
/*  98 */     if ((event instanceof KeyEvent))
/*  99 */       this.awt_events.add(event);
/*     */   }
/*     */ 
/*     */   public final synchronized void pollDevice() throws IOException {
/* 103 */     for (int i = 0; i < this.awt_events.size(); i++) {
/* 104 */       KeyEvent event = (KeyEvent)this.awt_events.get(i);
/* 105 */       processEvent(event);
/*     */     }
/* 107 */     this.awt_events.clear();
/*     */   }
/*     */ 
/*     */   private final void processEvent(KeyEvent event) {
/* 111 */     Component.Identifier.Key key_id = AWTKeyMap.map(event);
/* 112 */     if (key_id == null)
/* 113 */       return;
/* 114 */     Key key = (Key)getComponent(key_id);
/* 115 */     if (key == null)
/* 116 */       return;
/* 117 */     long nanos = event.getWhen() * 1000000L;
/* 118 */     if (event.getID() == 401)
/*     */     {
/* 120 */       addEvent(key, 1.0F, nanos);
/* 121 */     } else if (event.getID() == 402) {
/* 122 */       KeyEvent nextPress = (KeyEvent)Toolkit.getDefaultToolkit().getSystemEventQueue().peekEvent(401);
/* 123 */       if ((nextPress == null) || (nextPress.getWhen() != event.getWhen()))
/*     */       {
/* 125 */         addEvent(key, 0.0F, nanos);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   private final void addEvent(Key key, float value, long nanos) {
/* 131 */     key.setValue(value);
/* 132 */     if (this.processed_events_index < this.processed_events.length)
/* 133 */       this.processed_events[(this.processed_events_index++)].set(key, value, nanos);
/*     */   }
/*     */ 
/*     */   protected final synchronized boolean getNextDeviceEvent(Event event) throws IOException {
/* 137 */     if (this.processed_events_index == 0)
/* 138 */       return false;
/* 139 */     this.processed_events_index -= 1;
/* 140 */     event.set(this.processed_events[0]);
/* 141 */     Event tmp = this.processed_events[0];
/* 142 */     this.processed_events[0] = this.processed_events[this.processed_events_index];
/* 143 */     this.processed_events[this.processed_events_index] = tmp;
/* 144 */     return true;
/*     */   }
/*     */ 
/*     */   private static final class Key extends AbstractComponent
/*     */   {
/*     */     private float value;
/*     */ 
/*     */     public Key(Component.Identifier.Key key_id) {
/* 152 */       super(key_id);
/*     */     }
/*     */ 
/*     */     public final void setValue(float value) {
/* 156 */       this.value = value;
/*     */     }
/*     */ 
/*     */     protected final float poll() {
/* 160 */       return this.value;
/*     */     }
/*     */ 
/*     */     public final boolean isAnalog() {
/* 164 */       return false;
/*     */     }
/*     */ 
/*     */     public final boolean isRelative() {
/* 168 */       return false;
/*     */     }
/*     */   }
/*     */ }

/* Location:           /Users/Nick/Library/Application Support/minecraft/bin/jinput.jar
 * Qualified Name:     net.java.games.input.AWTKeyboard
 * JD-Core Version:    0.6.1
 */