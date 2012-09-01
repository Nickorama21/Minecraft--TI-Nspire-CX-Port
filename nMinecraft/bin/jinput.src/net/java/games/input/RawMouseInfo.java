/*    */ package net.java.games.input;
/*    */ 
/*    */ import java.io.IOException;
/*    */ 
/*    */ class RawMouseInfo extends RawDeviceInfo
/*    */ {
/*    */   private final RawDevice device;
/*    */   private final int id;
/*    */   private final int num_buttons;
/*    */   private final int sample_rate;
/*    */ 
/*    */   public RawMouseInfo(RawDevice device, int id, int num_buttons, int sample_rate)
/*    */   {
/* 54 */     this.device = device;
/* 55 */     this.id = id;
/* 56 */     this.num_buttons = num_buttons;
/* 57 */     this.sample_rate = sample_rate;
/*    */   }
/*    */ 
/*    */   public final int getUsage() {
/* 61 */     return 2;
/*    */   }
/*    */ 
/*    */   public final int getUsagePage() {
/* 65 */     return 1;
/*    */   }
/*    */ 
/*    */   public final long getHandle() {
/* 69 */     return this.device.getHandle();
/*    */   }
/*    */ 
/*    */   public final Controller createControllerFromDevice(RawDevice device, SetupAPIDevice setupapi_device) throws IOException {
/* 73 */     if (this.num_buttons == 0) {
/* 74 */       return null;
/*    */     }
/* 76 */     Component[] components = new Component[3 + this.num_buttons];
/* 77 */     int index = 0;
/* 78 */     components[(index++)] = new RawMouse.Axis(device, Component.Identifier.Axis.X);
/* 79 */     components[(index++)] = new RawMouse.Axis(device, Component.Identifier.Axis.Y);
/* 80 */     components[(index++)] = new RawMouse.Axis(device, Component.Identifier.Axis.Z);
/* 81 */     for (int i = 0; i < this.num_buttons; i++) {
/* 82 */       Component.Identifier.Button id = DIIdentifierMap.mapMouseButtonIdentifier(DIIdentifierMap.getButtonIdentifier(i));
/* 83 */       components[(index++)] = new RawMouse.Button(device, id, i);
/*    */     }
/* 85 */     Controller mouse = new RawMouse(setupapi_device.getName(), device, components, new Controller[0], new Rumbler[0]);
/* 86 */     return mouse;
/*    */   }
/*    */ }

/* Location:           /Users/Nick/Library/Application Support/minecraft/bin/jinput.jar
 * Qualified Name:     net.java.games.input.RawMouseInfo
 * JD-Core Version:    0.6.1
 */