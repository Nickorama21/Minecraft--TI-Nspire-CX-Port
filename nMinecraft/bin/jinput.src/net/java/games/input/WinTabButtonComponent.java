/*    */ package net.java.games.input;
/*    */ 
/*    */ public class WinTabButtonComponent extends WinTabComponent
/*    */ {
/*    */   private int index;
/*    */ 
/*    */   protected WinTabButtonComponent(WinTabContext context, int parentDevice, String name, Component.Identifier id, int index)
/*    */   {
/* 33 */     super(context, parentDevice, name, id);
/* 34 */     this.index = index;
/*    */   }
/*    */ 
/*    */   public Event processPacket(WinTabPacket packet) {
/* 38 */     Event newEvent = null;
/*    */ 
/* 40 */     float newValue = (packet.PK_BUTTONS & (int)Math.pow(2.0D, this.index)) > 0 ? 1.0F : 0.0F;
/* 41 */     if (newValue != getPollData()) {
/* 42 */       this.lastKnownValue = newValue;
/*    */ 
/* 45 */       newEvent = new Event();
/* 46 */       newEvent.set(this, newValue, packet.PK_TIME * 1000L);
/* 47 */       return newEvent;
/*    */     }
/*    */ 
/* 50 */     return newEvent;
/*    */   }
/*    */ }

/* Location:           /Users/Nick/Library/Application Support/minecraft/bin/jinput.jar
 * Qualified Name:     net.java.games.input.WinTabButtonComponent
 * JD-Core Version:    0.6.1
 */