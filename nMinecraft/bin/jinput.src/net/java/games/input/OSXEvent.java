/*    */ package net.java.games.input;
/*    */ 
/*    */ class OSXEvent
/*    */ {
/*    */   private long type;
/*    */   private long cookie;
/*    */   private int value;
/*    */   private long nanos;
/*    */ 
/*    */   public void set(long type, long cookie, int value, long nanos)
/*    */   {
/* 52 */     this.type = type;
/* 53 */     this.cookie = cookie;
/* 54 */     this.value = value;
/* 55 */     this.nanos = nanos;
/*    */   }
/*    */ 
/*    */   public long getType() {
/* 59 */     return this.type;
/*    */   }
/*    */ 
/*    */   public long getCookie() {
/* 63 */     return this.cookie;
/*    */   }
/*    */ 
/*    */   public int getValue() {
/* 67 */     return this.value;
/*    */   }
/*    */ 
/*    */   public long getNanos() {
/* 71 */     return this.nanos;
/*    */   }
/*    */ }

/* Location:           /Users/Nick/Library/Application Support/minecraft/bin/jinput.jar
 * Qualified Name:     net.java.games.input.OSXEvent
 * JD-Core Version:    0.6.1
 */