/*     */ package net.java.games.input;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ 
/*     */ final class LinuxEventDevice
/*     */   implements LinuxDevice
/*     */ {
/*  38 */   private final Map component_map = new HashMap();
/*     */   private final Rumbler[] rumblers;
/*     */   private final long fd;
/*     */   private final String name;
/*     */   private final LinuxInputID input_id;
/*     */   private final List components;
/*     */   private final Controller.Type type;
/*     */   private boolean closed;
/*  54 */   private final byte[] key_states = new byte[64];
/*     */ 
/*     */   public LinuxEventDevice(String filename) throws IOException {
/*  58 */     boolean detect_rumblers = true;
/*     */     long fd;
/*     */     try { fd = nOpen(filename, true);
/*     */     } catch (IOException e) {
/*  62 */       fd = nOpen(filename, false);
/*  63 */       detect_rumblers = false;
/*     */     }
/*  65 */     this.fd = fd;
/*     */     try {
/*  67 */       this.name = getDeviceName();
/*  68 */       this.input_id = getDeviceInputID();
/*  69 */       this.components = getDeviceComponents();
/*  70 */       if (detect_rumblers)
/*  71 */         this.rumblers = enumerateRumblers();
/*     */       else
/*  73 */         this.rumblers = new Rumbler[0];
/*  74 */       this.type = guessType();
/*     */     } catch (IOException e) {
/*  76 */       close();
/*  77 */       throw e;
/*     */     }
/*     */   }
/*     */ 
/*     */   private static final native long nOpen(String paramString, boolean paramBoolean) throws IOException;
/*     */ 
/*  83 */   public final Controller.Type getType() { return this.type; }
/*     */ 
/*     */   private static final int countComponents(List components, Class id_type, boolean relative)
/*     */   {
/*  87 */     int count = 0;
/*  88 */     for (int i = 0; i < components.size(); i++) {
/*  89 */       LinuxEventComponent component = (LinuxEventComponent)components.get(i);
/*  90 */       if ((id_type.isInstance(component.getIdentifier())) && (relative == component.isRelative()))
/*  91 */         count++;
/*     */     }
/*  93 */     return count;
/*     */   }
/*     */ 
/*     */   private final Controller.Type guessType() throws IOException {
/*  97 */     Controller.Type type_from_usages = guessTypeFromUsages();
/*  98 */     if (type_from_usages == Controller.Type.UNKNOWN) {
/*  99 */       return guessTypeFromComponents();
/*     */     }
/* 101 */     return type_from_usages;
/*     */   }
/*     */ 
/*     */   private final Controller.Type guessTypeFromUsages() throws IOException {
/* 105 */     byte[] usage_bits = getDeviceUsageBits();
/* 106 */     if (isBitSet(usage_bits, 0))
/* 107 */       return Controller.Type.MOUSE;
/* 108 */     if (isBitSet(usage_bits, 3))
/* 109 */       return Controller.Type.KEYBOARD;
/* 110 */     if (isBitSet(usage_bits, 2))
/* 111 */       return Controller.Type.GAMEPAD;
/* 112 */     if (isBitSet(usage_bits, 1)) {
/* 113 */       return Controller.Type.STICK;
/*     */     }
/* 115 */     return Controller.Type.UNKNOWN;
/*     */   }
/*     */ 
/*     */   private final Controller.Type guessTypeFromComponents() throws IOException {
/* 119 */     List components = getComponents();
/* 120 */     if (components.size() == 0)
/* 121 */       return Controller.Type.UNKNOWN;
/* 122 */     int num_rel_axes = countComponents(components, Component.Identifier.Axis.class, true);
/* 123 */     int num_abs_axes = countComponents(components, Component.Identifier.Axis.class, false);
/* 124 */     int num_keys = countComponents(components, Component.Identifier.Key.class, false);
/* 125 */     int mouse_traits = 0;
/* 126 */     int keyboard_traits = 0;
/* 127 */     int joystick_traits = 0;
/* 128 */     int gamepad_traits = 0;
/* 129 */     if (this.name.toLowerCase().indexOf("mouse") != -1)
/* 130 */       mouse_traits++;
/* 131 */     if (this.name.toLowerCase().indexOf("keyboard") != -1)
/* 132 */       keyboard_traits++;
/* 133 */     if (this.name.toLowerCase().indexOf("joystick") != -1)
/* 134 */       joystick_traits++;
/* 135 */     if (this.name.toLowerCase().indexOf("gamepad") != -1)
/* 136 */       gamepad_traits++;
/* 137 */     int num_keyboard_button_traits = 0;
/* 138 */     int num_mouse_button_traits = 0;
/* 139 */     int num_joystick_button_traits = 0;
/* 140 */     int num_gamepad_button_traits = 0;
/*     */ 
/* 142 */     for (int i = 0; i < components.size(); i++) {
/* 143 */       LinuxEventComponent component = (LinuxEventComponent)components.get(i);
/* 144 */       if (component.getButtonTrait() == Controller.Type.MOUSE)
/* 145 */         num_mouse_button_traits++;
/* 146 */       else if (component.getButtonTrait() == Controller.Type.KEYBOARD)
/* 147 */         num_keyboard_button_traits++;
/* 148 */       else if (component.getButtonTrait() == Controller.Type.GAMEPAD)
/* 149 */         num_gamepad_button_traits++;
/* 150 */       else if (component.getButtonTrait() == Controller.Type.STICK)
/* 151 */         num_joystick_button_traits++;
/*     */     }
/* 153 */     if ((num_mouse_button_traits >= num_keyboard_button_traits) && (num_mouse_button_traits >= num_joystick_button_traits) && (num_mouse_button_traits >= num_gamepad_button_traits))
/* 154 */       mouse_traits++;
/* 155 */     else if ((num_keyboard_button_traits >= num_mouse_button_traits) && (num_keyboard_button_traits >= num_joystick_button_traits) && (num_keyboard_button_traits >= num_gamepad_button_traits))
/* 156 */       keyboard_traits++;
/* 157 */     else if ((num_joystick_button_traits >= num_keyboard_button_traits) && (num_joystick_button_traits >= num_mouse_button_traits) && (num_joystick_button_traits >= num_gamepad_button_traits))
/* 158 */       joystick_traits++;
/* 159 */     else if ((num_gamepad_button_traits >= num_keyboard_button_traits) && (num_gamepad_button_traits >= num_mouse_button_traits) && (num_gamepad_button_traits >= num_joystick_button_traits)) {
/* 160 */       gamepad_traits++;
/*     */     }
/* 162 */     if (num_rel_axes >= 2) {
/* 163 */       mouse_traits++;
/*     */     }
/* 165 */     if (num_abs_axes >= 2) {
/* 166 */       joystick_traits++;
/* 167 */       gamepad_traits++;
/*     */     }
/*     */ 
/* 170 */     if ((mouse_traits >= keyboard_traits) && (mouse_traits >= joystick_traits) && (mouse_traits >= gamepad_traits))
/* 171 */       return Controller.Type.MOUSE;
/* 172 */     if ((keyboard_traits >= mouse_traits) && (keyboard_traits >= joystick_traits) && (keyboard_traits >= gamepad_traits))
/* 173 */       return Controller.Type.KEYBOARD;
/* 174 */     if ((joystick_traits >= mouse_traits) && (joystick_traits >= keyboard_traits) && (joystick_traits >= gamepad_traits))
/* 175 */       return Controller.Type.STICK;
/* 176 */     if ((gamepad_traits >= mouse_traits) && (gamepad_traits >= keyboard_traits) && (gamepad_traits >= joystick_traits)) {
/* 177 */       return Controller.Type.GAMEPAD;
/*     */     }
/* 179 */     return null;
/*     */   }
/*     */ 
/*     */   private final Rumbler[] enumerateRumblers() {
/* 183 */     List rumblers = new ArrayList();
/*     */     try {
/* 185 */       int num_effects = getNumEffects();
/* 186 */       if (num_effects <= 0)
/* 187 */         return (Rumbler[])rumblers.toArray(new Rumbler[0]);
/* 188 */       byte[] ff_bits = getForceFeedbackBits();
/* 189 */       if ((isBitSet(ff_bits, 80)) && (num_effects > rumblers.size()))
/* 190 */         rumblers.add(new LinuxRumbleFF(this));
/*     */     }
/*     */     catch (IOException e) {
/* 193 */       LinuxEnvironmentPlugin.logln("Failed to enumerate rumblers: " + e.getMessage());
/*     */     }
/* 195 */     return (Rumbler[])rumblers.toArray(new Rumbler[0]);
/*     */   }
/*     */ 
/*     */   public final Rumbler[] getRumblers() {
/* 199 */     return this.rumblers;
/*     */   }
/*     */ 
/*     */   public final synchronized int uploadRumbleEffect(int id, int trigger_button, int direction, int trigger_interval, int replay_length, int replay_delay, int strong_magnitude, int weak_magnitude) throws IOException {
/* 203 */     checkClosed();
/* 204 */     return nUploadRumbleEffect(this.fd, id, direction, trigger_button, trigger_interval, replay_length, replay_delay, strong_magnitude, weak_magnitude);
/*     */   }
/*     */   private static final native int nUploadRumbleEffect(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8) throws IOException;
/*     */ 
/*     */   public final synchronized int uploadConstantEffect(int id, int trigger_button, int direction, int trigger_interval, int replay_length, int replay_delay, int constant_level, int constant_env_attack_length, int constant_env_attack_level, int constant_env_fade_length, int constant_env_fade_level) throws IOException {
/* 209 */     checkClosed();
/* 210 */     return nUploadConstantEffect(this.fd, id, direction, trigger_button, trigger_interval, replay_length, replay_delay, constant_level, constant_env_attack_length, constant_env_attack_level, constant_env_fade_length, constant_env_fade_level);
/*     */   }
/*     */   private static final native int nUploadConstantEffect(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11) throws IOException;
/*     */ 
/*     */   final void eraseEffect(int id) throws IOException {
/* 215 */     nEraseEffect(this.fd, id);
/*     */   }
/*     */   private static final native void nEraseEffect(long paramLong, int paramInt) throws IOException;
/*     */ 
/*     */   public final synchronized void writeEvent(int type, int code, int value) throws IOException {
/* 220 */     checkClosed();
/* 221 */     nWriteEvent(this.fd, type, code, value);
/*     */   }
/*     */   private static final native void nWriteEvent(long paramLong, int paramInt1, int paramInt2, int paramInt3) throws IOException;
/*     */ 
/*     */   public final void registerComponent(LinuxAxisDescriptor desc, LinuxComponent component) {
/* 226 */     this.component_map.put(desc, component);
/*     */   }
/*     */ 
/*     */   public final LinuxComponent mapDescriptor(LinuxAxisDescriptor desc) {
/* 230 */     return (LinuxComponent)this.component_map.get(desc);
/*     */   }
/*     */ 
/*     */   public final Controller.PortType getPortType() throws IOException {
/* 234 */     return this.input_id.getPortType();
/*     */   }
/*     */ 
/*     */   public final LinuxInputID getInputID() {
/* 238 */     return this.input_id;
/*     */   }
/*     */ 
/*     */   private final LinuxInputID getDeviceInputID() throws IOException {
/* 242 */     return nGetInputID(this.fd);
/*     */   }
/*     */   private static final native LinuxInputID nGetInputID(long paramLong) throws IOException;
/*     */ 
/*     */   public final int getNumEffects() throws IOException {
/* 247 */     return nGetNumEffects(this.fd);
/*     */   }
/*     */   private static final native int nGetNumEffects(long paramLong) throws IOException;
/*     */ 
/*     */   private final int getVersion() throws IOException {
/* 252 */     return nGetVersion(this.fd);
/*     */   }
/*     */   private static final native int nGetVersion(long paramLong) throws IOException;
/*     */ 
/*     */   public final synchronized boolean getNextEvent(LinuxEvent linux_event) throws IOException {
/* 257 */     checkClosed();
/* 258 */     return nGetNextEvent(this.fd, linux_event);
/*     */   }
/*     */   private static final native boolean nGetNextEvent(long paramLong, LinuxEvent paramLinuxEvent) throws IOException;
/*     */ 
/*     */   public final synchronized void getAbsInfo(int abs_axis, LinuxAbsInfo abs_info) throws IOException {
/* 263 */     checkClosed();
/* 264 */     nGetAbsInfo(this.fd, abs_axis, abs_info);
/*     */   }
/*     */   private static final native void nGetAbsInfo(long paramLong, int paramInt, LinuxAbsInfo paramLinuxAbsInfo) throws IOException;
/*     */ 
/*     */   private final void addKeys(List components) throws IOException {
/* 269 */     byte[] bits = getKeysBits();
/* 270 */     for (int i = 0; i < bits.length * 8; i++)
/* 271 */       if (isBitSet(bits, i)) {
/* 272 */         Component.Identifier id = LinuxNativeTypesMap.getButtonID(i);
/* 273 */         components.add(new LinuxEventComponent(this, id, false, 1, i));
/*     */       }
/*     */   }
/*     */ 
/*     */   private final void addAbsoluteAxes(List components) throws IOException
/*     */   {
/* 279 */     byte[] bits = getAbsoluteAxesBits();
/* 280 */     for (int i = 0; i < bits.length * 8; i++)
/* 281 */       if (isBitSet(bits, i)) {
/* 282 */         Component.Identifier id = LinuxNativeTypesMap.getAbsAxisID(i);
/* 283 */         components.add(new LinuxEventComponent(this, id, false, 3, i));
/*     */       }
/*     */   }
/*     */ 
/*     */   private final void addRelativeAxes(List components) throws IOException
/*     */   {
/* 289 */     byte[] bits = getRelativeAxesBits();
/* 290 */     for (int i = 0; i < bits.length * 8; i++)
/* 291 */       if (isBitSet(bits, i)) {
/* 292 */         Component.Identifier id = LinuxNativeTypesMap.getRelAxisID(i);
/* 293 */         components.add(new LinuxEventComponent(this, id, true, 2, i));
/*     */       }
/*     */   }
/*     */ 
/*     */   public final List getComponents()
/*     */   {
/* 299 */     return this.components;
/*     */   }
/*     */ 
/*     */   private final List getDeviceComponents() throws IOException {
/* 303 */     List components = new ArrayList();
/* 304 */     byte[] evtype_bits = getEventTypeBits();
/* 305 */     if (isBitSet(evtype_bits, 1))
/* 306 */       addKeys(components);
/* 307 */     if (isBitSet(evtype_bits, 3))
/* 308 */       addAbsoluteAxes(components);
/* 309 */     if (isBitSet(evtype_bits, 2))
/* 310 */       addRelativeAxes(components);
/* 311 */     return components;
/*     */   }
/*     */ 
/*     */   private final byte[] getForceFeedbackBits() throws IOException {
/* 315 */     byte[] bits = new byte[16];
/* 316 */     nGetBits(this.fd, 21, bits);
/* 317 */     return bits;
/*     */   }
/*     */ 
/*     */   private final byte[] getKeysBits() throws IOException {
/* 321 */     byte[] bits = new byte[64];
/* 322 */     nGetBits(this.fd, 1, bits);
/* 323 */     return bits;
/*     */   }
/*     */ 
/*     */   private final byte[] getAbsoluteAxesBits() throws IOException {
/* 327 */     byte[] bits = new byte[8];
/* 328 */     nGetBits(this.fd, 3, bits);
/* 329 */     return bits;
/*     */   }
/*     */ 
/*     */   private final byte[] getRelativeAxesBits() throws IOException {
/* 333 */     byte[] bits = new byte[2];
/* 334 */     nGetBits(this.fd, 2, bits);
/* 335 */     return bits;
/*     */   }
/*     */ 
/*     */   private final byte[] getEventTypeBits() throws IOException {
/* 339 */     byte[] bits = new byte[4];
/* 340 */     nGetBits(this.fd, 0, bits);
/* 341 */     return bits;
/*     */   }
/*     */   private static final native void nGetBits(long paramLong, int paramInt, byte[] paramArrayOfByte) throws IOException;
/*     */ 
/*     */   private final byte[] getDeviceUsageBits() throws IOException {
/* 346 */     byte[] bits = new byte[2];
/* 347 */     if (getVersion() >= 65537) {
/* 348 */       nGetDeviceUsageBits(this.fd, bits);
/*     */     }
/* 350 */     return bits;
/*     */   }
/*     */   private static final native void nGetDeviceUsageBits(long paramLong, byte[] paramArrayOfByte) throws IOException;
/*     */ 
/*     */   public final synchronized void pollKeyStates() throws IOException {
/* 355 */     nGetKeyStates(this.fd, this.key_states);
/*     */   }
/*     */   private static final native void nGetKeyStates(long paramLong, byte[] paramArrayOfByte) throws IOException;
/*     */ 
/*     */   public final boolean isKeySet(int bit) {
/* 360 */     return isBitSet(this.key_states, bit);
/*     */   }
/*     */ 
/*     */   public static final boolean isBitSet(byte[] bits, int bit) {
/* 364 */     return (bits[(bit / 8)] & 1 << bit % 8) != 0;
/*     */   }
/*     */ 
/*     */   public final String getName() {
/* 368 */     return this.name;
/*     */   }
/*     */ 
/*     */   private final String getDeviceName() throws IOException {
/* 372 */     return nGetName(this.fd);
/*     */   }
/*     */   private static final native String nGetName(long paramLong) throws IOException;
/*     */ 
/*     */   public final synchronized void close() throws IOException {
/* 377 */     if (this.closed)
/* 378 */       return;
/* 379 */     this.closed = true;
/* 380 */     LinuxEnvironmentPlugin.execute(new LinuxDeviceTask() {
/*     */       protected final Object execute() throws IOException {
/* 382 */         LinuxEventDevice.nClose(LinuxEventDevice.this.fd);
/* 383 */         return null;
/*     */       } } );
/*     */   }
/*     */ 
/*     */   private static final native void nClose(long paramLong) throws IOException;
/*     */ 
/*     */   private final void checkClosed() throws IOException {
/* 390 */     if (this.closed)
/* 391 */       throw new IOException("Device is closed");
/*     */   }
/*     */ 
/*     */   protected void finalize() throws IOException {
/* 395 */     close();
/*     */   }
/*     */ }

/* Location:           /Users/Nick/Library/Application Support/minecraft/bin/jinput.jar
 * Qualified Name:     net.java.games.input.LinuxEventDevice
 * JD-Core Version:    0.6.1
 */