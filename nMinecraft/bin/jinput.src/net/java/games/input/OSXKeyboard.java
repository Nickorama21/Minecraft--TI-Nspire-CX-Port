/*    */ package net.java.games.input;
/*    */ 
/*    */ import java.io.IOException;
/*    */ 
/*    */ final class OSXKeyboard extends Keyboard
/*    */ {
/*    */   private final Controller.PortType port;
/*    */   private final OSXHIDQueue queue;
/*    */ 
/*    */   protected OSXKeyboard(OSXHIDDevice device, OSXHIDQueue queue, Component[] components, Controller[] children, Rumbler[] rumblers)
/*    */   {
/* 52 */     super(device.getProductName(), components, children, rumblers);
/* 53 */     this.queue = queue;
/* 54 */     this.port = device.getPortType();
/*    */   }
/*    */ 
/*    */   protected final boolean getNextDeviceEvent(Event event) throws IOException {
/* 58 */     return OSXControllers.getNextDeviceEvent(event, this.queue);
/*    */   }
/*    */ 
/*    */   protected final void setDeviceEventQueueSize(int size) throws IOException {
/* 62 */     this.queue.setQueueDepth(size);
/*    */   }
/*    */ 
/*    */   public final Controller.PortType getPortType() {
/* 66 */     return this.port;
/*    */   }
/*    */ }

/* Location:           /Users/Nick/Library/Application Support/minecraft/bin/jinput.jar
 * Qualified Name:     net.java.games.input.OSXKeyboard
 * JD-Core Version:    0.6.1
 */