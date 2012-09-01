/*    */ package net.java.games.input;
/*    */ 
/*    */ public class LinuxJoystickPOV extends LinuxJoystickAxis
/*    */ {
/*    */   private LinuxJoystickAxis hatX;
/*    */   private LinuxJoystickAxis hatY;
/*    */ 
/*    */   LinuxJoystickPOV(Component.Identifier.Axis id, LinuxJoystickAxis hatX, LinuxJoystickAxis hatY)
/*    */   {
/* 11 */     super(id, false);
/* 12 */     this.hatX = hatX;
/* 13 */     this.hatY = hatY;
/*    */   }
/*    */ 
/*    */   protected LinuxJoystickAxis getXAxis() {
/* 17 */     return this.hatX;
/*    */   }
/*    */ 
/*    */   protected LinuxJoystickAxis getYAxis() {
/* 21 */     return this.hatY;
/*    */   }
/*    */ 
/*    */   protected void updateValue()
/*    */   {
/* 27 */     float last_x = this.hatX.getPollData();
/* 28 */     float last_y = this.hatY.getPollData();
/*    */ 
/* 30 */     resetHasPolled();
/* 31 */     if ((last_x == -1.0F) && (last_y == -1.0F)) {
/* 32 */       setValue(0.125F);
/* 33 */     } else if ((last_x == -1.0F) && (last_y == 0.0F)) {
/* 34 */       setValue(1.0F);
/* 35 */     } else if ((last_x == -1.0F) && (last_y == 1.0F)) {
/* 36 */       setValue(0.875F);
/* 37 */     } else if ((last_x == 0.0F) && (last_y == -1.0F)) {
/* 38 */       setValue(0.25F);
/* 39 */     } else if ((last_x == 0.0F) && (last_y == 0.0F)) {
/* 40 */       setValue(0.0F);
/* 41 */     } else if ((last_x == 0.0F) && (last_y == 1.0F)) {
/* 42 */       setValue(0.75F);
/* 43 */     } else if ((last_x == 1.0F) && (last_y == -1.0F)) {
/* 44 */       setValue(0.375F);
/* 45 */     } else if ((last_x == 1.0F) && (last_y == 0.0F)) {
/* 46 */       setValue(0.5F);
/* 47 */     } else if ((last_x == 1.0F) && (last_y == 1.0F)) {
/* 48 */       setValue(0.625F);
/*    */     } else {
/* 50 */       LinuxEnvironmentPlugin.logln("Unknown values x = " + last_x + " | y = " + last_y);
/* 51 */       setValue(0.0F);
/*    */     }
/*    */   }
/*    */ }

/* Location:           /Users/Nick/Library/Application Support/minecraft/bin/jinput.jar
 * Qualified Name:     net.java.games.input.LinuxJoystickPOV
 * JD-Core Version:    0.6.1
 */