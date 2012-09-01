/*    */ package net.java.games.input;
/*    */ 
/*    */ import net.java.games.util.plugins.Plugin;
/*    */ 
/*    */ public class AWTEnvironmentPlugin extends ControllerEnvironment
/*    */   implements Plugin
/*    */ {
/*    */   private final Controller[] controllers;
/*    */ 
/*    */   public AWTEnvironmentPlugin()
/*    */   {
/* 41 */     this.controllers = new Controller[] { new AWTKeyboard(), new AWTMouse() };
/*    */   }
/*    */ 
/*    */   public Controller[] getControllers() {
/* 45 */     return this.controllers;
/*    */   }
/*    */ 
/*    */   public boolean isSupported() {
/* 49 */     return true;
/*    */   }
/*    */ }

/* Location:           /Users/Nick/Library/Application Support/minecraft/bin/jinput.jar
 * Qualified Name:     net.java.games.input.AWTEnvironmentPlugin
 * JD-Core Version:    0.6.1
 */