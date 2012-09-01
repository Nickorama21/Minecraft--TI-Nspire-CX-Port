/*    */ package net.java.games.input;
/*    */ 
/*    */ import java.io.IOException;
/*    */ 
/*    */ final class OSXAbstractController extends AbstractController
/*    */ {
/*    */   private final Controller.PortType port;
/*    */   private final OSXHIDQueue queue;
/*    */   private final Controller.Type type;
/*    */ 
/*    */   protected OSXAbstractController(OSXHIDDevice device, OSXHIDQueue queue, Component[] components, Controller[] children, Rumbler[] rumblers, Controller.Type type)
/*    */   {
/* 53 */     super(device.getProductName(), components, children, rumblers);
/* 54 */     this.queue = queue;
/* 55 */     this.type = type;
/* 56 */     this.port = device.getPortType();
/*    */   }
/*    */ 
/*    */   protected final boolean getNextDeviceEvent(Event event) throws IOException {
/* 60 */     return OSXControllers.getNextDeviceEvent(event, this.queue);
/*    */   }
/*    */ 
/*    */   protected final void setDeviceEventQueueSize(int size) throws IOException {
/* 64 */     this.queue.setQueueDepth(size);
/*    */   }
/*    */ 
/*    */   public Controller.Type getType() {
/* 68 */     return this.type;
/*    */   }
/*    */ 
/*    */   public final Controller.PortType getPortType() {
/* 72 */     return this.port;
/*    */   }
/*    */ }

/* Location:           /Users/Nick/Library/Application Support/minecraft/bin/jinput.jar
 * Qualified Name:     net.java.games.input.OSXAbstractController
 * JD-Core Version:    0.6.1
 */