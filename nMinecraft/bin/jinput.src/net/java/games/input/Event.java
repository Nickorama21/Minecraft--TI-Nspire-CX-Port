/*    */ package net.java.games.input;
/*    */ 
/*    */ public final class Event
/*    */ {
/*    */   private Component component;
/*    */   private float value;
/*    */   private long nanos;
/*    */ 
/*    */   public final void set(Event other)
/*    */   {
/* 47 */     set(other.getComponent(), other.getValue(), other.getNanos());
/*    */   }
/*    */ 
/*    */   public final void set(Component component, float value, long nanos) {
/* 51 */     this.component = component;
/* 52 */     this.value = value;
/* 53 */     this.nanos = nanos;
/*    */   }
/*    */ 
/*    */   public final Component getComponent() {
/* 57 */     return this.component;
/*    */   }
/*    */ 
/*    */   public final float getValue() {
/* 61 */     return this.value;
/*    */   }
/*    */ 
/*    */   public final long getNanos()
/*    */   {
/* 70 */     return this.nanos;
/*    */   }
/*    */ 
/*    */   public final String toString() {
/* 74 */     return "Event: component = " + this.component + " | value = " + this.value;
/*    */   }
/*    */ }

/* Location:           /Users/Nick/Library/Application Support/minecraft/bin/jinput.jar
 * Qualified Name:     net.java.games.input.Event
 * JD-Core Version:    0.6.1
 */