/*     */ package net.java.games.input;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ 
/*     */ final class IDirectInputDevice
/*     */ {
/*     */   public static final int GUID_XAxis = 1;
/*     */   public static final int GUID_YAxis = 2;
/*     */   public static final int GUID_ZAxis = 3;
/*     */   public static final int GUID_RxAxis = 4;
/*     */   public static final int GUID_RyAxis = 5;
/*     */   public static final int GUID_RzAxis = 6;
/*     */   public static final int GUID_Slider = 7;
/*     */   public static final int GUID_Button = 8;
/*     */   public static final int GUID_Key = 9;
/*     */   public static final int GUID_POV = 10;
/*     */   public static final int GUID_Unknown = 11;
/*     */   public static final int GUID_ConstantForce = 12;
/*     */   public static final int GUID_RampForce = 13;
/*     */   public static final int GUID_Square = 14;
/*     */   public static final int GUID_Sine = 15;
/*     */   public static final int GUID_Triangle = 16;
/*     */   public static final int GUID_SawtoothUp = 17;
/*     */   public static final int GUID_SawtoothDown = 18;
/*     */   public static final int GUID_Spring = 19;
/*     */   public static final int GUID_Damper = 20;
/*     */   public static final int GUID_Inertia = 21;
/*     */   public static final int GUID_Friction = 22;
/*     */   public static final int GUID_CustomForce = 23;
/*     */   public static final int DI8DEVTYPE_DEVICE = 17;
/*     */   public static final int DI8DEVTYPE_MOUSE = 18;
/*     */   public static final int DI8DEVTYPE_KEYBOARD = 19;
/*     */   public static final int DI8DEVTYPE_JOYSTICK = 20;
/*     */   public static final int DI8DEVTYPE_GAMEPAD = 21;
/*     */   public static final int DI8DEVTYPE_DRIVING = 22;
/*     */   public static final int DI8DEVTYPE_FLIGHT = 23;
/*     */   public static final int DI8DEVTYPE_1STPERSON = 24;
/*     */   public static final int DI8DEVTYPE_DEVICECTRL = 25;
/*     */   public static final int DI8DEVTYPE_SCREENPOINTER = 26;
/*     */   public static final int DI8DEVTYPE_REMOTE = 27;
/*     */   public static final int DI8DEVTYPE_SUPPLEMENTAL = 28;
/*     */   public static final int DISCL_EXCLUSIVE = 1;
/*     */   public static final int DISCL_NONEXCLUSIVE = 2;
/*     */   public static final int DISCL_FOREGROUND = 4;
/*     */   public static final int DISCL_BACKGROUND = 8;
/*     */   public static final int DISCL_NOWINKEY = 16;
/*     */   public static final int DIDFT_ALL = 0;
/*     */   public static final int DIDFT_RELAXIS = 1;
/*     */   public static final int DIDFT_ABSAXIS = 2;
/*     */   public static final int DIDFT_AXIS = 3;
/*     */   public static final int DIDFT_PSHBUTTON = 4;
/*     */   public static final int DIDFT_TGLBUTTON = 8;
/*     */   public static final int DIDFT_BUTTON = 12;
/*     */   public static final int DIDFT_POV = 16;
/*     */   public static final int DIDFT_COLLECTION = 64;
/*     */   public static final int DIDFT_NODATA = 128;
/*     */   public static final int DIDFT_FFACTUATOR = 16777216;
/*     */   public static final int DIDFT_FFEFFECTTRIGGER = 33554432;
/*     */   public static final int DIDFT_OUTPUT = 268435456;
/*     */   public static final int DIDFT_VENDORDEFINED = 67108864;
/*     */   public static final int DIDFT_ALIAS = 134217728;
/*     */   public static final int DIDFT_OPTIONAL = -2147483648;
/*     */   public static final int DIDFT_NOCOLLECTION = 16776960;
/*     */   public static final int DIDF_ABSAXIS = 1;
/*     */   public static final int DIDF_RELAXIS = 2;
/*     */   public static final int DI_OK = 0;
/*     */   public static final int DI_NOEFFECT = 1;
/*     */   public static final int DI_PROPNOEFFECT = 1;
/*     */   public static final int DI_POLLEDDEVICE = 2;
/*     */   public static final int DI_DOWNLOADSKIPPED = 3;
/*     */   public static final int DI_EFFECTRESTARTED = 4;
/*     */   public static final int DI_TRUNCATED = 8;
/*     */   public static final int DI_SETTINGSNOTSAVED = 11;
/*     */   public static final int DI_TRUNCATEDANDRESTARTED = 12;
/*     */   public static final int DI_BUFFEROVERFLOW = 1;
/*     */   public static final int DIERR_INPUTLOST = -2147024866;
/*     */   public static final int DIERR_NOTACQUIRED = -2147024868;
/*     */   public static final int DIERR_OTHERAPPHASPRIO = -2147024891;
/*     */   public static final int DIDOI_FFACTUATOR = 1;
/*     */   public static final int DIDOI_FFEFFECTTRIGGER = 2;
/*     */   public static final int DIDOI_POLLED = 32768;
/*     */   public static final int DIDOI_ASPECTPOSITION = 256;
/*     */   public static final int DIDOI_ASPECTVELOCITY = 512;
/*     */   public static final int DIDOI_ASPECTACCEL = 768;
/*     */   public static final int DIDOI_ASPECTFORCE = 1024;
/*     */   public static final int DIDOI_ASPECTMASK = 3840;
/*     */   public static final int DIDOI_GUIDISUSAGE = 65536;
/*     */   public static final int DIEFT_ALL = 0;
/*     */   public static final int DIEFT_CONSTANTFORCE = 1;
/*     */   public static final int DIEFT_RAMPFORCE = 2;
/*     */   public static final int DIEFT_PERIODIC = 3;
/*     */   public static final int DIEFT_CONDITION = 4;
/*     */   public static final int DIEFT_CUSTOMFORCE = 5;
/*     */   public static final int DIEFT_HARDWARE = 255;
/*     */   public static final int DIEFT_FFATTACK = 512;
/*     */   public static final int DIEFT_FFFADE = 1024;
/*     */   public static final int DIEFT_SATURATION = 2048;
/*     */   public static final int DIEFT_POSNEGCOEFFICIENTS = 4096;
/*     */   public static final int DIEFT_POSNEGSATURATION = 8192;
/*     */   public static final int DIEFT_DEADBAND = 16384;
/*     */   public static final int DIEFT_STARTDELAY = 32768;
/*     */   public static final int DIEFF_OBJECTIDS = 1;
/*     */   public static final int DIEFF_OBJECTOFFSETS = 2;
/*     */   public static final int DIEFF_CARTESIAN = 16;
/*     */   public static final int DIEFF_POLAR = 32;
/*     */   public static final int DIEFF_SPHERICAL = 64;
/*     */   public static final int DIEP_DURATION = 1;
/*     */   public static final int DIEP_SAMPLEPERIOD = 2;
/*     */   public static final int DIEP_GAIN = 4;
/*     */   public static final int DIEP_TRIGGERBUTTON = 8;
/*     */   public static final int DIEP_TRIGGERREPEATINTERVAL = 16;
/*     */   public static final int DIEP_AXES = 32;
/*     */   public static final int DIEP_DIRECTION = 64;
/*     */   public static final int DIEP_ENVELOPE = 128;
/*     */   public static final int DIEP_TYPESPECIFICPARAMS = 256;
/*     */   public static final int DIEP_STARTDELAY = 512;
/*     */   public static final int DIEP_ALLPARAMS_DX5 = 511;
/*     */   public static final int DIEP_ALLPARAMS = 1023;
/*     */   public static final int DIEP_START = 536870912;
/*     */   public static final int DIEP_NORESTART = 1073741824;
/*     */   public static final int DIEP_NODOWNLOAD = -2147483648;
/*     */   public static final int DIEB_NOTRIGGER = -1;
/*     */   public static final int INFINITE = -1;
/*     */   public static final int DI_DEGREES = 100;
/*     */   public static final int DI_FFNOMINALMAX = 10000;
/*     */   public static final int DI_SECONDS = 1000000;
/*     */   public static final int DIPROPRANGE_NOMIN = -2147483648;
/*     */   public static final int DIPROPRANGE_NOMAX = 2147483647;
/*     */   private final DummyWindow window;
/*     */   private final long address;
/*     */   private final int dev_type;
/*     */   private final int dev_subtype;
/*     */   private final String instance_name;
/*     */   private final String product_name;
/* 204 */   private final List objects = new ArrayList();
/* 205 */   private final List effects = new ArrayList();
/* 206 */   private final List rumblers = new ArrayList();
/*     */   private final int[] device_state;
/* 208 */   private final Map object_to_component = new HashMap();
/*     */   private final boolean axes_in_relative_mode;
/*     */   private boolean released;
/*     */   private DataQueue queue;
/*     */   private int button_counter;
/*     */   private int current_format_offset;
/*     */ 
/*     */   public IDirectInputDevice(DummyWindow window, long address, byte[] instance_guid, byte[] product_guid, int dev_type, int dev_subtype, String instance_name, String product_name)
/*     */     throws IOException
/*     */   {
/* 219 */     this.window = window;
/* 220 */     this.address = address;
/* 221 */     this.product_name = product_name;
/* 222 */     this.instance_name = instance_name;
/* 223 */     this.dev_type = dev_type;
/* 224 */     this.dev_subtype = dev_subtype;
/*     */ 
/* 226 */     enumObjects();
/*     */     try {
/* 228 */       enumEffects();
/* 229 */       createRumblers();
/*     */     } catch (IOException e) {
/* 231 */       DirectInputEnvironmentPlugin.logln("Failed to create rumblers: " + e.getMessage());
/*     */     }
/*     */ 
/* 242 */     boolean all_relative = true;
/* 243 */     boolean has_axis = false;
/* 244 */     for (int i = 0; i < this.objects.size(); i++) {
/* 245 */       DIDeviceObject obj = (DIDeviceObject)this.objects.get(i);
/* 246 */       if (obj.isAxis()) {
/* 247 */         has_axis = true;
/* 248 */         if (!obj.isRelative()) {
/* 249 */           all_relative = false;
/* 250 */           break;
/*     */         }
/*     */       }
/*     */     }
/* 254 */     this.axes_in_relative_mode = ((all_relative) && (has_axis));
/* 255 */     int axis_mode = all_relative ? 2 : 1;
/* 256 */     setDataFormat(axis_mode);
/* 257 */     if (this.rumblers.size() > 0)
/*     */       try {
/* 259 */         setCooperativeLevel(9);
/*     */       } catch (IOException e) {
/* 261 */         setCooperativeLevel(10);
/*     */       }
/*     */     else
/* 264 */       setCooperativeLevel(10);
/* 265 */     setBufferSize(32);
/* 266 */     acquire();
/* 267 */     this.device_state = new int[this.objects.size()];
/*     */   }
/*     */ 
/*     */   public final boolean areAxesRelative() {
/* 271 */     return this.axes_in_relative_mode;
/*     */   }
/*     */ 
/*     */   public final Rumbler[] getRumblers() {
/* 275 */     return (Rumbler[])this.rumblers.toArray(new Rumbler[0]);
/*     */   }
/*     */ 
/*     */   private final List createRumblers() throws IOException {
/* 279 */     DIDeviceObject x_axis = lookupObjectByGUID(1);
/*     */ 
/* 281 */     if (x_axis == null)
/* 282 */       return this.rumblers;
/* 283 */     DIDeviceObject[] axes = { x_axis };
/* 284 */     long[] directions = { 0L };
/* 285 */     for (int i = 0; i < this.effects.size(); i++) {
/* 286 */       DIEffectInfo info = (DIEffectInfo)this.effects.get(i);
/* 287 */       if (((info.getEffectType() & 0xFF) == 3) && ((info.getDynamicParams() & 0x4) != 0))
/*     */       {
/* 289 */         this.rumblers.add(createPeriodicRumbler(axes, directions, info));
/*     */       }
/*     */     }
/* 292 */     return this.rumblers;
/*     */   }
/*     */ 
/*     */   private final Rumbler createPeriodicRumbler(DIDeviceObject[] axes, long[] directions, DIEffectInfo info) throws IOException {
/* 296 */     int[] axis_ids = new int[axes.length];
/* 297 */     for (int i = 0; i < axis_ids.length; i++) {
/* 298 */       axis_ids[i] = axes[i].getDIIdentifier();
/*     */     }
/* 300 */     long effect_address = nCreatePeriodicEffect(this.address, info.getGUID(), 17, -1, 0, 10000, -1, 0, axis_ids, directions, 0, 0, 0, 0, 10000, 0, 0, 50000, 0);
/* 301 */     return new IDirectInputEffect(effect_address, info);
/*     */   }
/*     */   private static final native long nCreatePeriodicEffect(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int[] paramArrayOfInt, long[] paramArrayOfLong, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12, int paramInt13, int paramInt14, int paramInt15) throws IOException;
/*     */ 
/*     */   private final DIDeviceObject lookupObjectByGUID(int guid_id) {
/* 306 */     for (int i = 0; i < this.objects.size(); i++) {
/* 307 */       DIDeviceObject object = (DIDeviceObject)this.objects.get(i);
/* 308 */       if (guid_id == object.getGUIDType())
/* 309 */         return object;
/*     */     }
/* 311 */     return null;
/*     */   }
/*     */ 
/*     */   public final int getPollData(DIDeviceObject object) {
/* 315 */     return this.device_state[object.getFormatOffset()];
/*     */   }
/*     */ 
/*     */   public final DIDeviceObject mapEvent(DIDeviceObjectData event)
/*     */   {
/* 323 */     int format_offset = event.getFormatOffset() / 4;
/* 324 */     return (DIDeviceObject)this.objects.get(format_offset);
/*     */   }
/*     */ 
/*     */   public final DIComponent mapObject(DIDeviceObject object) {
/* 328 */     return (DIComponent)this.object_to_component.get(object);
/*     */   }
/*     */ 
/*     */   public final void registerComponent(DIDeviceObject object, DIComponent component) {
/* 332 */     this.object_to_component.put(object, component);
/*     */   }
/*     */ 
/*     */   public final synchronized void pollAll() throws IOException {
/* 336 */     checkReleased();
/* 337 */     poll();
/* 338 */     getDeviceState(this.device_state);
/* 339 */     this.queue.compact();
/* 340 */     getDeviceData(this.queue);
/* 341 */     this.queue.flip();
/*     */   }
/*     */ 
/*     */   public final synchronized boolean getNextEvent(DIDeviceObjectData data) {
/* 345 */     DIDeviceObjectData next_event = (DIDeviceObjectData)this.queue.get();
/* 346 */     if (next_event == null)
/* 347 */       return false;
/* 348 */     data.set(next_event);
/* 349 */     return true;
/*     */   }
/*     */ 
/*     */   private final void poll() throws IOException {
/* 353 */     int res = nPoll(this.address);
/* 354 */     if ((res != 0) && (res != 1)) {
/* 355 */       if (res == -2147024868) {
/* 356 */         acquire();
/* 357 */         return;
/*     */       }
/* 359 */       throw new IOException("Failed to poll device (" + Integer.toHexString(res) + ")");
/*     */     }
/*     */   }
/*     */ 
/*     */   private static final native int nPoll(long paramLong) throws IOException;
/*     */ 
/* 365 */   private final void acquire() throws IOException { int res = nAcquire(this.address);
/* 366 */     if ((res != 0) && (res != -2147024891) && (res != 1))
/* 367 */       throw new IOException("Failed to acquire device (" + Integer.toHexString(res) + ")"); }
/*     */ 
/*     */   private static final native int nAcquire(long paramLong);
/*     */ 
/*     */   private final void unacquire() throws IOException {
/* 372 */     int res = nUnacquire(this.address);
/* 373 */     if ((res != 0) && (res != 1))
/* 374 */       throw new IOException("Failed to unAcquire device (" + Integer.toHexString(res) + ")"); 
/*     */   }
/*     */ 
/*     */   private static final native int nUnacquire(long paramLong);
/*     */ 
/* 379 */   private final boolean getDeviceData(DataQueue queue) throws IOException { int res = nGetDeviceData(this.address, 0, queue, queue.getElements(), queue.position(), queue.remaining());
/* 380 */     if ((res != 0) && (res != 1)) {
/* 381 */       if (res == -2147024868) {
/* 382 */         acquire();
/* 383 */         return false;
/*     */       }
/* 385 */       throw new IOException("Failed to get device data (" + Integer.toHexString(res) + ")");
/*     */     }
/* 387 */     return true; }
/*     */ 
/*     */   private static final native int nGetDeviceData(long paramLong, int paramInt1, DataQueue paramDataQueue, Object[] paramArrayOfObject, int paramInt2, int paramInt3);
/*     */ 
/*     */   private final void getDeviceState(int[] device_state) throws IOException {
/* 392 */     int res = nGetDeviceState(this.address, device_state);
/* 393 */     if (res != 0) {
/* 394 */       if (res == -2147024868) {
/* 395 */         Arrays.fill(device_state, 0);
/* 396 */         acquire();
/* 397 */         return;
/*     */       }
/* 399 */       throw new IOException("Failed to get device state (" + Integer.toHexString(res) + ")");
/*     */     }
/*     */   }
/*     */ 
/*     */   private static final native int nGetDeviceState(long paramLong, int[] paramArrayOfInt);
/*     */ 
/*     */   private final void setDataFormat(int flags) throws IOException
/*     */   {
/* 407 */     DIDeviceObject[] device_objects = new DIDeviceObject[this.objects.size()];
/* 408 */     this.objects.toArray(device_objects);
/* 409 */     int res = nSetDataFormat(this.address, flags, device_objects);
/* 410 */     if (res != 0)
/* 411 */       throw new IOException("Failed to set data format (" + Integer.toHexString(res) + ")"); 
/*     */   }
/*     */ 
/*     */   private static final native int nSetDataFormat(long paramLong, int paramInt, DIDeviceObject[] paramArrayOfDIDeviceObject);
/*     */ 
/* 416 */   public final String getProductName() { return this.product_name; }
/*     */ 
/*     */   public final int getType()
/*     */   {
/* 420 */     return this.dev_type;
/*     */   }
/*     */ 
/*     */   public final List getObjects() {
/* 424 */     return this.objects;
/*     */   }
/*     */ 
/*     */   private final void enumEffects() throws IOException {
/* 428 */     int res = nEnumEffects(this.address, 0);
/* 429 */     if (res != 0)
/* 430 */       throw new IOException("Failed to enumerate effects (" + Integer.toHexString(res) + ")");
/*     */   }
/*     */ 
/*     */   private final native int nEnumEffects(long paramLong, int paramInt);
/*     */ 
/*     */   private final void addEffect(byte[] guid, int guid_id, int effect_type, int static_params, int dynamic_params, String name) {
/* 436 */     this.effects.add(new DIEffectInfo(this, guid, guid_id, effect_type, static_params, dynamic_params, name));
/*     */   }
/*     */ 
/*     */   private final void enumObjects() throws IOException {
/* 440 */     int res = nEnumObjects(this.address, 31);
/* 441 */     if (res != 0)
/* 442 */       throw new IOException("Failed to enumerate objects (" + Integer.toHexString(res) + ")"); 
/*     */   }
/*     */ 
/*     */   private final native int nEnumObjects(long paramLong, int paramInt);
/*     */ 
/* 447 */   public final synchronized long[] getRangeProperty(int object_identifier) throws IOException { checkReleased();
/* 448 */     long[] range = new long[2];
/* 449 */     int res = nGetRangeProperty(this.address, object_identifier, range);
/* 450 */     if (res != 0)
/* 451 */       throw new IOException("Failed to get object range (" + res + ")");
/* 452 */     return range; }
/*     */ 
/*     */   private static final native int nGetRangeProperty(long paramLong, int paramInt, long[] paramArrayOfLong);
/*     */ 
/*     */   public final synchronized int getDeadzoneProperty(int object_identifier) throws IOException {
/* 457 */     checkReleased();
/* 458 */     return nGetDeadzoneProperty(this.address, object_identifier);
/*     */   }
/*     */ 
/*     */   private static final native int nGetDeadzoneProperty(long paramLong, int paramInt) throws IOException;
/*     */ 
/*     */   private final void addObject(byte[] guid, int guid_type, int identifier, int type, int instance, int flags, String name) throws IOException {
/* 464 */     Component.Identifier id = getIdentifier(guid_type, type, instance);
/* 465 */     int format_offset = this.current_format_offset++;
/* 466 */     DIDeviceObject obj = new DIDeviceObject(this, id, guid, guid_type, identifier, type, instance, flags, name, format_offset);
/* 467 */     this.objects.add(obj);
/*     */   }
/*     */ 
/*     */   private static final Component.Identifier.Key getKeyIdentifier(int key_instance) {
/* 471 */     return DIIdentifierMap.getKeyIdentifier(key_instance);
/*     */   }
/*     */ 
/*     */   private final Component.Identifier.Button getNextButtonIdentifier() {
/* 475 */     int button_id = this.button_counter++;
/* 476 */     return DIIdentifierMap.getButtonIdentifier(button_id);
/*     */   }
/*     */ 
/*     */   private final Component.Identifier getIdentifier(int guid_type, int type, int instance) {
/* 480 */     switch (guid_type) {
/*     */     case 1:
/* 482 */       return Component.Identifier.Axis.X;
/*     */     case 2:
/* 484 */       return Component.Identifier.Axis.Y;
/*     */     case 3:
/* 486 */       return Component.Identifier.Axis.Z;
/*     */     case 4:
/* 488 */       return Component.Identifier.Axis.RX;
/*     */     case 5:
/* 490 */       return Component.Identifier.Axis.RY;
/*     */     case 6:
/* 492 */       return Component.Identifier.Axis.RZ;
/*     */     case 7:
/* 494 */       return Component.Identifier.Axis.SLIDER;
/*     */     case 10:
/* 496 */       return Component.Identifier.Axis.POV;
/*     */     case 9:
/* 498 */       return getKeyIdentifier(instance);
/*     */     case 8:
/* 500 */       return getNextButtonIdentifier();
/*     */     }
/* 502 */     return Component.Identifier.Axis.UNKNOWN;
/*     */   }
/*     */ 
/*     */   public final synchronized void setBufferSize(int size) throws IOException
/*     */   {
/* 507 */     checkReleased();
/* 508 */     unacquire();
/* 509 */     int res = nSetBufferSize(this.address, size);
/* 510 */     if ((res != 0) && (res != 1) && (res != 2))
/* 511 */       throw new IOException("Failed to set buffer size (" + Integer.toHexString(res) + ")");
/* 512 */     this.queue = new DataQueue(size, DIDeviceObjectData.class);
/* 513 */     this.queue.position(this.queue.limit());
/* 514 */     acquire();
/*     */   }
/*     */   private static final native int nSetBufferSize(long paramLong, int paramInt);
/*     */ 
/*     */   public final synchronized void setCooperativeLevel(int flags) throws IOException {
/* 519 */     checkReleased();
/* 520 */     int res = nSetCooperativeLevel(this.address, this.window.getHwnd(), flags);
/* 521 */     if (res != 0)
/* 522 */       throw new IOException("Failed to set cooperative level (" + Integer.toHexString(res) + ")"); 
/*     */   }
/*     */ 
/*     */   private static final native int nSetCooperativeLevel(long paramLong1, long paramLong2, int paramInt);
/*     */ 
/* 527 */   public final synchronized void release() { if (!this.released) {
/* 528 */       this.released = true;
/* 529 */       for (int i = 0; i < this.rumblers.size(); i++) {
/* 530 */         IDirectInputEffect effect = (IDirectInputEffect)this.rumblers.get(i);
/* 531 */         effect.release();
/*     */       }
/* 533 */       nRelease(this.address);
/*     */     } }
/*     */ 
/*     */   private static final native void nRelease(long paramLong);
/*     */ 
/*     */   private final void checkReleased() throws IOException {
/* 539 */     if (this.released)
/* 540 */       throw new IOException("Device is released");
/*     */   }
/*     */ 
/*     */   protected void finalize() {
/* 544 */     release();
/*     */   }
/*     */ }

/* Location:           /Users/Nick/Library/Application Support/minecraft/bin/jinput.jar
 * Qualified Name:     net.java.games.input.IDirectInputDevice
 * JD-Core Version:    0.6.1
 */