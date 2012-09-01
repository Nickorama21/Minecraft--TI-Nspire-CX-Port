/*    */ package net.java.games.input;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ final class IDirectInput
/*    */ {
/* 51 */   private final List devices = new ArrayList();
/*    */   private final long idirectinput_address;
/*    */   private final DummyWindow window;
/*    */ 
/*    */   public IDirectInput(DummyWindow window)
/*    */     throws IOException
/*    */   {
/* 56 */     this.window = window;
/* 57 */     this.idirectinput_address = createIDirectInput();
/*    */     try {
/* 59 */       enumDevices();
/*    */     } catch (IOException e) {
/* 61 */       releaseDevices();
/* 62 */       release();
/* 63 */       throw e;
/*    */     }
/*    */   }
/*    */ 
/*    */   private static final native long createIDirectInput() throws IOException;
/*    */ 
/* 69 */   public final List getDevices() { return this.devices; }
/*    */ 
/*    */   private final void enumDevices() throws IOException
/*    */   {
/* 73 */     nEnumDevices(this.idirectinput_address);
/*    */   }
/*    */ 
/*    */   private final native void nEnumDevices(long paramLong) throws IOException;
/*    */ 
/*    */   private final void addDevice(long address, byte[] instance_guid, byte[] product_guid, int dev_type, int dev_subtype, String instance_name, String product_name) throws IOException
/*    */   {
/*    */     try
/*    */     {
/* 82 */       IDirectInputDevice device = new IDirectInputDevice(this.window, address, instance_guid, product_guid, dev_type, dev_subtype, instance_name, product_name);
/* 83 */       this.devices.add(device);
/*    */     } catch (IOException e) {
/* 85 */       DirectInputEnvironmentPlugin.logln("Failed to initialize device " + product_name + " because of: " + e);
/*    */     }
/*    */   }
/*    */ 
/*    */   public final void releaseDevices() {
/* 90 */     for (int i = 0; i < this.devices.size(); i++) {
/* 91 */       IDirectInputDevice device = (IDirectInputDevice)this.devices.get(i);
/* 92 */       device.release();
/*    */     }
/*    */   }
/*    */ 
/*    */   public final void release() {
/* 97 */     nRelease(this.idirectinput_address);
/*    */   }
/*    */ 
/*    */   private static final native void nRelease(long paramLong);
/*    */ }

/* Location:           /Users/Nick/Library/Application Support/minecraft/bin/jinput.jar
 * Qualified Name:     net.java.games.input.IDirectInput
 * JD-Core Version:    0.6.1
 */