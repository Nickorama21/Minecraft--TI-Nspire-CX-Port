/*    */ package net.java.games.input;
/*    */ 
/*    */ import java.io.IOException;
/*    */ 
/*    */ final class DummyWindow
/*    */ {
/*    */   private final long hwnd_address;
/*    */ 
/*    */   public DummyWindow()
/*    */     throws IOException
/*    */   {
/* 52 */     this.hwnd_address = createWindow();
/*    */   }
/*    */   private static final native long createWindow() throws IOException;
/*    */ 
/*    */   public final void destroy() throws IOException {
/* 57 */     nDestroy(this.hwnd_address);
/*    */   }
/*    */   private static final native void nDestroy(long paramLong) throws IOException;
/*    */ 
/*    */   public final long getHwnd() {
/* 62 */     return this.hwnd_address;
/*    */   }
/*    */ }

/* Location:           /Users/Nick/Library/Application Support/minecraft/bin/jinput.jar
 * Qualified Name:     net.java.games.input.DummyWindow
 * JD-Core Version:    0.6.1
 */