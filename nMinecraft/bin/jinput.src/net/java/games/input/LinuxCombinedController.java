/*    */ package net.java.games.input;
/*    */ 
/*    */ import java.io.IOException;
/*    */ 
/*    */ public class LinuxCombinedController extends AbstractController
/*    */ {
/*    */   private LinuxAbstractController eventController;
/*    */   private LinuxJoystickAbstractController joystickController;
/*    */ 
/*    */   LinuxCombinedController(LinuxAbstractController eventController, LinuxJoystickAbstractController joystickController)
/*    */   {
/* 11 */     super(eventController.getName(), joystickController.getComponents(), eventController.getControllers(), eventController.getRumblers());
/* 12 */     this.eventController = eventController;
/* 13 */     this.joystickController = joystickController;
/*    */   }
/*    */ 
/*    */   protected boolean getNextDeviceEvent(Event event) throws IOException {
/* 17 */     return this.joystickController.getNextDeviceEvent(event);
/*    */   }
/*    */ 
/*    */   public final Controller.PortType getPortType() {
/* 21 */     return this.eventController.getPortType();
/*    */   }
/*    */ 
/*    */   public final void pollDevice() throws IOException {
/* 25 */     this.eventController.pollDevice();
/* 26 */     this.joystickController.pollDevice();
/*    */   }
/*    */ 
/*    */   public Controller.Type getType() {
/* 30 */     return this.eventController.getType();
/*    */   }
/*    */ }

/* Location:           /Users/Nick/Library/Application Support/minecraft/bin/jinput.jar
 * Qualified Name:     net.java.games.input.LinuxCombinedController
 * JD-Core Version:    0.6.1
 */