/*    */ package net.java.games.input;
/*    */ 
/*    */ import java.io.IOException;
/*    */ 
/*    */ class RawKeyboardInfo extends RawDeviceInfo
/*    */ {
/*    */   private final RawDevice device;
/*    */   private final int type;
/*    */   private final int sub_type;
/*    */   private final int keyboard_mode;
/*    */   private final int num_function_keys;
/*    */   private final int num_indicators;
/*    */   private final int num_keys_total;
/*    */ 
/*    */   public RawKeyboardInfo(RawDevice device, int type, int sub_type, int keyboard_mode, int num_function_keys, int num_indicators, int num_keys_total)
/*    */   {
/* 57 */     this.device = device;
/* 58 */     this.type = type;
/* 59 */     this.sub_type = sub_type;
/* 60 */     this.keyboard_mode = keyboard_mode;
/* 61 */     this.num_function_keys = num_function_keys;
/* 62 */     this.num_indicators = num_indicators;
/* 63 */     this.num_keys_total = num_keys_total;
/*    */   }
/*    */ 
/*    */   public final int getUsage() {
/* 67 */     return 6;
/*    */   }
/*    */ 
/*    */   public final int getUsagePage() {
/* 71 */     return 1;
/*    */   }
/*    */ 
/*    */   public final long getHandle() {
/* 75 */     return this.device.getHandle();
/*    */   }
/*    */ 
/*    */   public final Controller createControllerFromDevice(RawDevice device, SetupAPIDevice setupapi_device) throws IOException {
/* 79 */     return new RawKeyboard(setupapi_device.getName(), device, new Controller[0], new Rumbler[0]);
/*    */   }
/*    */ }

/* Location:           /Users/Nick/Library/Application Support/minecraft/bin/jinput.jar
 * Qualified Name:     net.java.games.input.RawKeyboardInfo
 * JD-Core Version:    0.6.1
 */