/*    */ package net.java.games.input;
/*    */ 
/*    */ import java.io.IOException;
/*    */ 
/*    */ final class LinuxAbstractController extends AbstractController
/*    */ {
/*    */   private final Controller.PortType port;
/*    */   private final LinuxEventDevice device;
/*    */   private final Controller.Type type;
/*    */ 
/*    */   protected LinuxAbstractController(LinuxEventDevice device, Component[] components, Controller[] children, Rumbler[] rumblers, Controller.Type type)
/*    */     throws IOException
/*    */   {
/* 53 */     super(device.getName(), components, children, rumblers);
/* 54 */     this.device = device;
/* 55 */     this.port = device.getPortType();
/* 56 */     this.type = type;
/*    */   }
/*    */ 
/*    */   public final Controller.PortType getPortType() {
/* 60 */     return this.port;
/*    */   }
/*    */ 
/*    */   public final void pollDevice() throws IOException {
/* 64 */     this.device.pollKeyStates();
/*    */   }
/*    */ 
/*    */   protected final boolean getNextDeviceEvent(Event event) throws IOException {
/* 68 */     return LinuxControllers.getNextDeviceEvent(event, this.device);
/*    */   }
/*    */ 
/*    */   public Controller.Type getType() {
/* 72 */     return this.type;
/*    */   }
/*    */ }

/* Location:           /Users/Nick/Library/Application Support/minecraft/bin/jinput.jar
 * Qualified Name:     net.java.games.input.LinuxAbstractController
 * JD-Core Version:    0.6.1
 */