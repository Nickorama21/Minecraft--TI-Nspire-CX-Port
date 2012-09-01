/*    */ package net.java.games.input;
/*    */ 
/*    */ import java.io.IOException;
/*    */ 
/*    */ abstract class RawDeviceInfo
/*    */ {
/*    */   public abstract Controller createControllerFromDevice(RawDevice paramRawDevice, SetupAPIDevice paramSetupAPIDevice)
/*    */     throws IOException;
/*    */ 
/*    */   public abstract int getUsage();
/*    */ 
/*    */   public abstract int getUsagePage();
/*    */ 
/*    */   public abstract long getHandle();
/*    */ 
/*    */   public final boolean equals(Object other)
/*    */   {
/* 57 */     if (!(other instanceof RawDeviceInfo))
/* 58 */       return false;
/* 59 */     RawDeviceInfo other_info = (RawDeviceInfo)other;
/* 60 */     return (other_info.getUsage() == getUsage()) && (other_info.getUsagePage() == getUsagePage());
/*    */   }
/*    */ 
/*    */   public final int hashCode()
/*    */   {
/* 65 */     return getUsage() ^ getUsagePage();
/*    */   }
/*    */ }

/* Location:           /Users/Nick/Library/Application Support/minecraft/bin/jinput.jar
 * Qualified Name:     net.java.games.input.RawDeviceInfo
 * JD-Core Version:    0.6.1
 */