/*    */ package net.java.games.input;
/*    */ 
/*    */ import java.io.IOException;
/*    */ 
/*    */ final class DIMouse extends Mouse
/*    */ {
/*    */   private final IDirectInputDevice device;
/*    */ 
/*    */   protected DIMouse(IDirectInputDevice device, Component[] components, Controller[] children, Rumbler[] rumblers)
/*    */   {
/* 51 */     super(device.getProductName(), components, children, rumblers);
/* 52 */     this.device = device;
/*    */   }
/*    */ 
/*    */   public final void pollDevice() throws IOException {
/* 56 */     this.device.pollAll();
/*    */   }
/*    */ 
/*    */   protected final boolean getNextDeviceEvent(Event event) throws IOException {
/* 60 */     return DIControllers.getNextDeviceEvent(event, this.device);
/*    */   }
/*    */ 
/*    */   protected final void setDeviceEventQueueSize(int size) throws IOException {
/* 64 */     this.device.setBufferSize(size);
/*    */   }
/*    */ }

/* Location:           /Users/Nick/Library/Application Support/minecraft/bin/jinput.jar
 * Qualified Name:     net.java.games.input.DIMouse
 * JD-Core Version:    0.6.1
 */