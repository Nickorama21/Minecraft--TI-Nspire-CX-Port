/*    */ package net.java.games.input;
/*    */ 
/*    */ final class DIDeviceObjectData
/*    */ {
/*    */   private int format_offset;
/*    */   private int data;
/*    */   private int millis;
/*    */   private int sequence;
/*    */ 
/*    */   public final void set(int format_offset, int data, int millis, int sequence)
/*    */   {
/* 52 */     this.format_offset = format_offset;
/* 53 */     this.data = data;
/* 54 */     this.millis = millis;
/* 55 */     this.sequence = sequence;
/*    */   }
/*    */ 
/*    */   public final void set(DIDeviceObjectData other) {
/* 59 */     set(other.format_offset, other.data, other.millis, other.sequence);
/*    */   }
/*    */ 
/*    */   public final int getData() {
/* 63 */     return this.data;
/*    */   }
/*    */ 
/*    */   public final int getFormatOffset() {
/* 67 */     return this.format_offset;
/*    */   }
/*    */ 
/*    */   public final long getNanos() {
/* 71 */     return this.millis * 1000000L;
/*    */   }
/*    */ }

/* Location:           /Users/Nick/Library/Application Support/minecraft/bin/jinput.jar
 * Qualified Name:     net.java.games.input.DIDeviceObjectData
 * JD-Core Version:    0.6.1
 */