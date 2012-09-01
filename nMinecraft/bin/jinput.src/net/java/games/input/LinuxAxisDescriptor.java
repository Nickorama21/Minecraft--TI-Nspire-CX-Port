/*    */ package net.java.games.input;
/*    */ 
/*    */ final class LinuxAxisDescriptor
/*    */ {
/*    */   private int type;
/*    */   private int code;
/*    */ 
/*    */   public final void set(int type, int code)
/*    */   {
/* 36 */     this.type = type;
/* 37 */     this.code = code;
/*    */   }
/*    */ 
/*    */   public final int getType() {
/* 41 */     return this.type;
/*    */   }
/*    */ 
/*    */   public final int getCode() {
/* 45 */     return this.code;
/*    */   }
/*    */ 
/*    */   public final int hashCode() {
/* 49 */     return this.type ^ this.code;
/*    */   }
/*    */ 
/*    */   public final boolean equals(Object other) {
/* 53 */     if (!(other instanceof LinuxAxisDescriptor))
/* 54 */       return false;
/* 55 */     LinuxAxisDescriptor descriptor = (LinuxAxisDescriptor)other;
/* 56 */     return (descriptor.type == this.type) && (descriptor.code == this.code);
/*    */   }
/*    */ 
/*    */   public final String toString() {
/* 60 */     return "LinuxAxis: type = 0x" + Integer.toHexString(this.type) + ", code = 0x" + Integer.toHexString(this.code);
/*    */   }
/*    */ }

/* Location:           /Users/Nick/Library/Application Support/minecraft/bin/jinput.jar
 * Qualified Name:     net.java.games.input.LinuxAxisDescriptor
 * JD-Core Version:    0.6.1
 */