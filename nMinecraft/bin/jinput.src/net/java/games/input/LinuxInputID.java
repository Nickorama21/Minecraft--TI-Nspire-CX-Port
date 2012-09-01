/*    */ package net.java.games.input;
/*    */ 
/*    */ final class LinuxInputID
/*    */ {
/*    */   private final int bustype;
/*    */   private final int vendor;
/*    */   private final int product;
/*    */   private final int version;
/*    */ 
/*    */   public LinuxInputID(int bustype, int vendor, int product, int version)
/*    */   {
/* 38 */     this.bustype = bustype;
/* 39 */     this.vendor = vendor;
/* 40 */     this.product = product;
/* 41 */     this.version = version;
/*    */   }
/*    */ 
/*    */   public final Controller.PortType getPortType() {
/* 45 */     return LinuxNativeTypesMap.getPortType(this.bustype);
/*    */   }
/*    */ 
/*    */   public final String toString() {
/* 49 */     return "LinuxInputID: bustype = 0x" + Integer.toHexString(this.bustype) + " | vendor = 0x" + Integer.toHexString(this.vendor) + " | product = 0x" + Integer.toHexString(this.product) + " | version = 0x" + Integer.toHexString(this.version);
/*    */   }
/*    */ }

/* Location:           /Users/Nick/Library/Application Support/minecraft/bin/jinput.jar
 * Qualified Name:     net.java.games.input.LinuxInputID
 * JD-Core Version:    0.6.1
 */