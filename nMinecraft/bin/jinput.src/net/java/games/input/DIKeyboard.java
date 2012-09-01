/*    */ package net.java.games.input;
/*    */ 
/*    */ import java.io.IOException;
/*    */ 
/*    */ final class DIKeyboard extends Keyboard
/*    */ {
/*    */   private final IDirectInputDevice device;
/*    */ 
/*    */   protected DIKeyboard(IDirectInputDevice device, Component[] components, Controller[] children, Rumbler[] rumblers)
/*    */   {
/* 51 */     super(device.getProductName(), components, children, rumblers);
/* 52 */     this.device = device;
/*    */   }
/*    */ 
/*    */   protected final boolean getNextDeviceEvent(Event event) throws IOException {
/* 56 */     return DIControllers.getNextDeviceEvent(event, this.device);
/*    */   }
/*    */ 
/*    */   public final void pollDevice() throws IOException {
/* 60 */     this.device.pollAll();
/*    */   }
/*    */ 
/*    */   protected final void setDeviceEventQueueSize(int size) throws IOException {
/* 64 */     this.device.setBufferSize(size);
/*    */   }
/*    */ }

/* Location:           /Users/Nick/Library/Application Support/minecraft/bin/jinput.jar
 * Qualified Name:     net.java.games.input.DIKeyboard
 * JD-Core Version:    0.6.1
 */