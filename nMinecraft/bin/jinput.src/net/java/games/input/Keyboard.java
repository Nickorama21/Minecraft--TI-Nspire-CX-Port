/*    */ package net.java.games.input;
/*    */ 
/*    */ public abstract class Keyboard extends AbstractController
/*    */ {
/*    */   protected Keyboard(String name, Component[] keys, Controller[] children, Rumbler[] rumblers)
/*    */   {
/* 53 */     super(name, keys, children, rumblers);
/*    */   }
/*    */ 
/*    */   public Controller.Type getType()
/*    */   {
/* 60 */     return Controller.Type.KEYBOARD;
/*    */   }
/*    */ 
/*    */   public final boolean isKeyDown(Component.Identifier.Key key_id) {
/* 64 */     Component key = getComponent(key_id);
/* 65 */     if (key == null)
/* 66 */       return false;
/* 67 */     return key.getPollData() != 0.0F;
/*    */   }
/*    */ }

/* Location:           /Users/Nick/Library/Application Support/minecraft/bin/jinput.jar
 * Qualified Name:     net.java.games.input.Keyboard
 * JD-Core Version:    0.6.1
 */