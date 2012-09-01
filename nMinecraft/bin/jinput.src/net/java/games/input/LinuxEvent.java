/*    */ package net.java.games.input;
/*    */ 
/*    */ final class LinuxEvent
/*    */ {
/*    */   private long nanos;
/* 33 */   private final LinuxAxisDescriptor descriptor = new LinuxAxisDescriptor();
/*    */   private int value;
/*    */ 
/*    */   public final void set(long seconds, long microseconds, int type, int code, int value)
/*    */   {
/* 37 */     this.nanos = ((seconds * 1000000L + microseconds) * 1000L);
/* 38 */     this.descriptor.set(type, code);
/* 39 */     this.value = value;
/*    */   }
/*    */ 
/*    */   public final int getValue() {
/* 43 */     return this.value;
/*    */   }
/*    */ 
/*    */   public final LinuxAxisDescriptor getDescriptor() {
/* 47 */     return this.descriptor;
/*    */   }
/*    */ 
/*    */   public final long getNanos() {
/* 51 */     return this.nanos;
/*    */   }
/*    */ }

/* Location:           /Users/Nick/Library/Application Support/minecraft/bin/jinput.jar
 * Qualified Name:     net.java.games.input.LinuxEvent
 * JD-Core Version:    0.6.1
 */