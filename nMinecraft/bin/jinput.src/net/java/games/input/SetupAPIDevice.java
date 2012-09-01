/*    */ package net.java.games.input;
/*    */ 
/*    */ final class SetupAPIDevice
/*    */ {
/*    */   private final String device_instance_id;
/*    */   private final String device_name;
/*    */ 
/*    */   public SetupAPIDevice(String device_instance_id, String device_name)
/*    */   {
/* 52 */     this.device_instance_id = device_instance_id;
/* 53 */     this.device_name = device_name;
/*    */   }
/*    */ 
/*    */   public final String getName() {
/* 57 */     return this.device_name;
/*    */   }
/*    */ 
/*    */   public final String getInstanceId() {
/* 61 */     return this.device_instance_id;
/*    */   }
/*    */ }

/* Location:           /Users/Nick/Library/Application Support/minecraft/bin/jinput.jar
 * Qualified Name:     net.java.games.input.SetupAPIDevice
 * JD-Core Version:    0.6.1
 */