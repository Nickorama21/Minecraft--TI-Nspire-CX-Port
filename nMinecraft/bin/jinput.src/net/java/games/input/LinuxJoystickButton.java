/*    */ package net.java.games.input;
/*    */ 
/*    */ import java.io.IOException;
/*    */ 
/*    */ final class LinuxJoystickButton extends AbstractComponent
/*    */ {
/*    */   private float value;
/*    */ 
/*    */   public LinuxJoystickButton(Component.Identifier button_id)
/*    */   {
/* 51 */     super(button_id.getName(), button_id);
/*    */   }
/*    */ 
/*    */   public final boolean isRelative() {
/* 55 */     return false;
/*    */   }
/*    */ 
/*    */   final void setValue(float value) {
/* 59 */     this.value = value;
/*    */   }
/*    */ 
/*    */   protected final float poll() throws IOException {
/* 63 */     return this.value;
/*    */   }
/*    */ }

/* Location:           /Users/Nick/Library/Application Support/minecraft/bin/jinput.jar
 * Qualified Name:     net.java.games.input.LinuxJoystickButton
 * JD-Core Version:    0.6.1
 */