/*    */ package net.java.games.input;
/*    */ 
/*    */ import java.io.IOException;
/*    */ 
/*    */ final class DIAbstractController extends AbstractController
/*    */ {
/*    */   private final IDirectInputDevice device;
/*    */   private final Controller.Type type;
/*    */ 
/*    */   protected DIAbstractController(IDirectInputDevice device, Component[] components, Controller[] children, Rumbler[] rumblers, Controller.Type type)
/*    */   {
/* 52 */     super(device.getProductName(), components, children, rumblers);
/* 53 */     this.device = device;
/* 54 */     this.type = type;
/*    */   }
/*    */ 
/*    */   public final void pollDevice() throws IOException {
/* 58 */     this.device.pollAll();
/*    */   }
/*    */ 
/*    */   protected final boolean getNextDeviceEvent(Event event) throws IOException {
/* 62 */     return DIControllers.getNextDeviceEvent(event, this.device);
/*    */   }
/*    */ 
/*    */   protected final void setDeviceEventQueueSize(int size) throws IOException {
/* 66 */     this.device.setBufferSize(size);
/*    */   }
/*    */ 
/*    */   public final Controller.Type getType() {
/* 70 */     return this.type;
/*    */   }
/*    */ }

/* Location:           /Users/Nick/Library/Application Support/minecraft/bin/jinput.jar
 * Qualified Name:     net.java.games.input.DIAbstractController
 * JD-Core Version:    0.6.1
 */