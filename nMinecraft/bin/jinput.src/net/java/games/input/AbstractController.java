/*     */ package net.java.games.input;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ 
/*     */ public abstract class AbstractController
/*     */   implements Controller
/*     */ {
/*     */   static final int EVENT_QUEUE_DEPTH = 32;
/*  55 */   private static final Event event = new Event();
/*     */   private final String name;
/*     */   private final Component[] components;
/*     */   private final Controller[] children;
/*     */   private final Rumbler[] rumblers;
/*  80 */   private final Map id_to_components = new HashMap();
/*     */ 
/*  82 */   private EventQueue event_queue = new EventQueue(32);
/*     */ 
/*     */   protected AbstractController(String name, Component[] components, Controller[] children, Rumbler[] rumblers)
/*     */   {
/*  93 */     this.name = name;
/*  94 */     this.components = components;
/*  95 */     this.children = children;
/*  96 */     this.rumblers = rumblers;
/*     */ 
/*  98 */     for (int i = components.length - 1; i >= 0; i--)
/*  99 */       this.id_to_components.put(components[i].getIdentifier(), components[i]);
/*     */   }
/*     */ 
/*     */   public final Controller[] getControllers()
/*     */   {
/* 110 */     return this.children;
/*     */   }
/*     */ 
/*     */   public final Component[] getComponents()
/*     */   {
/* 123 */     return this.components;
/*     */   }
/*     */ 
/*     */   public final Component getComponent(Component.Identifier id)
/*     */   {
/* 131 */     return (Component)this.id_to_components.get(id);
/*     */   }
/*     */ 
/*     */   public final Rumbler[] getRumblers()
/*     */   {
/* 139 */     return this.rumblers;
/*     */   }
/*     */ 
/*     */   public Controller.PortType getPortType()
/*     */   {
/* 147 */     return Controller.PortType.UNKNOWN;
/*     */   }
/*     */ 
/*     */   public int getPortNumber()
/*     */   {
/* 155 */     return 0;
/*     */   }
/*     */ 
/*     */   public final String getName()
/*     */   {
/* 162 */     return this.name;
/*     */   }
/*     */ 
/*     */   public String toString()
/*     */   {
/* 169 */     return this.name;
/*     */   }
/*     */ 
/*     */   public Controller.Type getType()
/*     */   {
/* 175 */     return Controller.Type.UNKNOWN;
/*     */   }
/*     */ 
/*     */   public final void setEventQueueSize(int size)
/*     */   {
/*     */     try
/*     */     {
/* 183 */       setDeviceEventQueueSize(size);
/* 184 */       this.event_queue = new EventQueue(size);
/*     */     } catch (IOException e) {
/* 186 */       ControllerEnvironment.logln("Failed to create new event queue of size " + size + ": " + e);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void setDeviceEventQueueSize(int size)
/*     */     throws IOException
/*     */   {
/*     */   }
/*     */ 
/*     */   public final EventQueue getEventQueue()
/*     */   {
/* 197 */     return this.event_queue;
/*     */   }
/*     */ 
/*     */   protected abstract boolean getNextDeviceEvent(Event paramEvent) throws IOException;
/*     */ 
/*     */   protected void pollDevice() throws IOException
/*     */   {
/*     */   }
/*     */ 
/*     */   public synchronized boolean poll() {
/* 207 */     Component[] components = getComponents();
/*     */     try {
/* 209 */       pollDevice();
/* 210 */       for (int i = 0; i < components.length; i++) {
/* 211 */         AbstractComponent component = (AbstractComponent)components[i];
/* 212 */         if (component.isRelative()) {
/* 213 */           component.setPollData(0.0F);
/*     */         }
/*     */         else {
/* 216 */           component.resetHasPolled();
/*     */         }
/*     */       }
/* 219 */       while (getNextDeviceEvent(event)) {
/* 220 */         AbstractComponent component = (AbstractComponent)event.getComponent();
/* 221 */         float value = event.getValue();
/* 222 */         if (component.isRelative()) {
/* 223 */           if (value != 0.0F)
/*     */           {
/* 225 */             component.setPollData(component.getPollData() + value);
/*     */           }
/* 227 */         } else if (value != component.getEventValue())
/*     */         {
/* 229 */           component.setEventValue(value);
/*     */ 
/* 231 */           if (!this.event_queue.isFull())
/* 232 */             this.event_queue.add(event); 
/*     */         }
/*     */       }
/* 234 */       return true;
/*     */     } catch (IOException e) {
/* 236 */       ControllerEnvironment.logln("Failed to poll device: " + e.getMessage());
/* 237 */     }return false;
/*     */   }
/*     */ }

/* Location:           /Users/Nick/Library/Application Support/minecraft/bin/jinput.jar
 * Qualified Name:     net.java.games.input.AbstractController
 * JD-Core Version:    0.6.1
 */