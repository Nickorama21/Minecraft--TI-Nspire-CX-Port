/*    */ package net.java.games.input;
/*    */ 
/*    */ import java.io.IOException;
/*    */ 
/*    */ final class OSXHIDDeviceIterator
/*    */ {
/*    */   private final long iterator_address;
/*    */ 
/*    */   public OSXHIDDeviceIterator()
/*    */     throws IOException
/*    */   {
/* 52 */     this.iterator_address = nCreateIterator();
/*    */   }
/*    */   private static final native long nCreateIterator();
/*    */ 
/*    */   public final void close() {
/* 57 */     nReleaseIterator(this.iterator_address);
/*    */   }
/*    */   private static final native void nReleaseIterator(long paramLong);
/*    */ 
/*    */   public final OSXHIDDevice next() throws IOException {
/* 62 */     return nNext(this.iterator_address);
/*    */   }
/*    */ 
/*    */   private static final native OSXHIDDevice nNext(long paramLong)
/*    */     throws IOException;
/*    */ }

/* Location:           /Users/Nick/Library/Application Support/minecraft/bin/jinput.jar
 * Qualified Name:     net.java.games.input.OSXHIDDeviceIterator
 * JD-Core Version:    0.6.1
 */