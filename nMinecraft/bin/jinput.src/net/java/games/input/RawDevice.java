/*     */ package net.java.games.input;
/*     */ 
/*     */ import java.io.IOException;
/*     */ 
/*     */ final class RawDevice
/*     */ {
/*     */   public static final int RI_MOUSE_LEFT_BUTTON_DOWN = 1;
/*     */   public static final int RI_MOUSE_LEFT_BUTTON_UP = 2;
/*     */   public static final int RI_MOUSE_RIGHT_BUTTON_DOWN = 4;
/*     */   public static final int RI_MOUSE_RIGHT_BUTTON_UP = 8;
/*     */   public static final int RI_MOUSE_MIDDLE_BUTTON_DOWN = 16;
/*     */   public static final int RI_MOUSE_MIDDLE_BUTTON_UP = 32;
/*     */   public static final int RI_MOUSE_BUTTON_1_DOWN = 1;
/*     */   public static final int RI_MOUSE_BUTTON_1_UP = 2;
/*     */   public static final int RI_MOUSE_BUTTON_2_DOWN = 4;
/*     */   public static final int RI_MOUSE_BUTTON_2_UP = 8;
/*     */   public static final int RI_MOUSE_BUTTON_3_DOWN = 16;
/*     */   public static final int RI_MOUSE_BUTTON_3_UP = 32;
/*     */   public static final int RI_MOUSE_BUTTON_4_DOWN = 64;
/*     */   public static final int RI_MOUSE_BUTTON_4_UP = 128;
/*     */   public static final int RI_MOUSE_BUTTON_5_DOWN = 256;
/*     */   public static final int RI_MOUSE_BUTTON_5_UP = 512;
/*     */   public static final int RI_MOUSE_WHEEL = 1024;
/*     */   public static final int MOUSE_MOVE_RELATIVE = 0;
/*     */   public static final int MOUSE_MOVE_ABSOLUTE = 1;
/*     */   public static final int MOUSE_VIRTUAL_DESKTOP = 2;
/*     */   public static final int MOUSE_ATTRIBUTES_CHANGED = 4;
/*     */   public static final int RIM_TYPEHID = 2;
/*     */   public static final int RIM_TYPEKEYBOARD = 1;
/*     */   public static final int RIM_TYPEMOUSE = 0;
/*     */   public static final int WM_KEYDOWN = 256;
/*     */   public static final int WM_KEYUP = 257;
/*     */   public static final int WM_SYSKEYDOWN = 260;
/*     */   public static final int WM_SYSKEYUP = 261;
/*     */   private final RawInputEventQueue queue;
/*     */   private final long handle;
/*     */   private final int type;
/*     */   private DataQueue keyboard_events;
/*     */   private DataQueue mouse_events;
/*     */   private DataQueue processed_keyboard_events;
/*     */   private DataQueue processed_mouse_events;
/* 100 */   private final boolean[] button_states = new boolean[5];
/*     */   private int wheel;
/*     */   private int relative_x;
/*     */   private int relative_y;
/*     */   private int last_x;
/*     */   private int last_y;
/*     */   private int event_relative_x;
/*     */   private int event_relative_y;
/*     */   private int event_last_x;
/*     */   private int event_last_y;
/* 114 */   private final boolean[] key_states = new boolean['ÿ'];
/*     */ 
/*     */   public RawDevice(RawInputEventQueue queue, long handle, int type) {
/* 117 */     this.queue = queue;
/* 118 */     this.handle = handle;
/* 119 */     this.type = type;
/* 120 */     setBufferSize(32);
/*     */   }
/*     */ 
/*     */   public final synchronized void addMouseEvent(long millis, int flags, int button_flags, int button_data, long raw_buttons, long last_x, long last_y, long extra_information)
/*     */   {
/* 125 */     if (this.mouse_events.hasRemaining()) {
/* 126 */       RawMouseEvent event = (RawMouseEvent)this.mouse_events.get();
/* 127 */       event.set(millis, flags, button_flags, button_data, raw_buttons, last_x, last_y, extra_information);
/*     */     }
/*     */   }
/*     */ 
/*     */   public final synchronized void addKeyboardEvent(long millis, int make_code, int flags, int vkey, int message, long extra_information)
/*     */   {
/* 133 */     if (this.keyboard_events.hasRemaining()) {
/* 134 */       RawKeyboardEvent event = (RawKeyboardEvent)this.keyboard_events.get();
/* 135 */       event.set(millis, make_code, flags, vkey, message, extra_information);
/*     */     }
/*     */   }
/*     */ 
/*     */   public final synchronized void pollMouse() {
/* 140 */     this.relative_x = (this.relative_y = this.wheel = 0);
/* 141 */     this.mouse_events.flip();
/* 142 */     while (this.mouse_events.hasRemaining()) {
/* 143 */       RawMouseEvent event = (RawMouseEvent)this.mouse_events.get();
/* 144 */       boolean has_update = processMouseEvent(event);
/* 145 */       if ((has_update) && (this.processed_mouse_events.hasRemaining())) {
/* 146 */         RawMouseEvent processed_event = (RawMouseEvent)this.processed_mouse_events.get();
/* 147 */         processed_event.set(event);
/*     */       }
/*     */     }
/* 150 */     this.mouse_events.compact();
/*     */   }
/*     */ 
/*     */   public final synchronized void pollKeyboard() {
/* 154 */     this.keyboard_events.flip();
/* 155 */     while (this.keyboard_events.hasRemaining()) {
/* 156 */       RawKeyboardEvent event = (RawKeyboardEvent)this.keyboard_events.get();
/* 157 */       boolean has_update = processKeyboardEvent(event);
/* 158 */       if ((has_update) && (this.processed_keyboard_events.hasRemaining())) {
/* 159 */         RawKeyboardEvent processed_event = (RawKeyboardEvent)this.processed_keyboard_events.get();
/* 160 */         processed_event.set(event);
/*     */       }
/*     */     }
/* 163 */     this.keyboard_events.compact();
/*     */   }
/*     */ 
/*     */   private final boolean updateButtonState(int button_id, int button_flags, int down_flag, int up_flag) {
/* 167 */     if (button_id >= this.button_states.length)
/* 168 */       return false;
/* 169 */     if ((button_flags & down_flag) != 0) {
/* 170 */       this.button_states[button_id] = true;
/* 171 */       return true;
/* 172 */     }if ((button_flags & up_flag) != 0) {
/* 173 */       this.button_states[button_id] = false;
/* 174 */       return true;
/*     */     }
/* 176 */     return false;
/*     */   }
/*     */ 
/*     */   private final boolean processKeyboardEvent(RawKeyboardEvent event) {
/* 180 */     int message = event.getMessage();
/* 181 */     int vkey = event.getVKey();
/* 182 */     if (vkey >= this.key_states.length)
/* 183 */       return false;
/* 184 */     if ((message == 256) || (message == 260)) {
/* 185 */       this.key_states[vkey] = true;
/* 186 */       return true;
/* 187 */     }if ((message == 257) || (message == 261)) {
/* 188 */       this.key_states[vkey] = false;
/* 189 */       return true;
/*     */     }
/* 191 */     return false;
/*     */   }
/*     */ 
/*     */   public final boolean isKeyDown(int vkey) {
/* 195 */     return this.key_states[vkey];
/*     */   }
/*     */ 
/*     */   private final boolean processMouseEvent(RawMouseEvent event) {
/* 199 */     boolean has_update = false;
/* 200 */     int button_flags = event.getButtonFlags();
/* 201 */     has_update = (updateButtonState(0, button_flags, 1, 2)) || (has_update);
/* 202 */     has_update = (updateButtonState(1, button_flags, 4, 8)) || (has_update);
/* 203 */     has_update = (updateButtonState(2, button_flags, 16, 32)) || (has_update);
/* 204 */     has_update = (updateButtonState(3, button_flags, 64, 128)) || (has_update);
/* 205 */     has_update = (updateButtonState(4, button_flags, 256, 512)) || (has_update);
/*     */     int dx;
/*     */     int dy;
/* 208 */     if ((event.getFlags() & 0x1) != 0) {
/* 209 */       int dx = event.getLastX() - this.last_x;
/* 210 */       int dy = event.getLastY() - this.last_y;
/* 211 */       this.last_x = event.getLastX();
/* 212 */       this.last_y = event.getLastY();
/*     */     } else {
/* 214 */       dx = event.getLastX();
/* 215 */       dy = event.getLastY();
/*     */     }
/* 217 */     int dwheel = 0;
/* 218 */     if ((button_flags & 0x400) != 0)
/* 219 */       dwheel = event.getWheelDelta();
/* 220 */     this.relative_x += dx;
/* 221 */     this.relative_y += dy;
/* 222 */     this.wheel += dwheel;
/* 223 */     has_update = (dx != 0) || (dy != 0) || (dwheel != 0) || (has_update);
/* 224 */     return has_update;
/*     */   }
/*     */ 
/*     */   public final int getWheel() {
/* 228 */     return this.wheel;
/*     */   }
/*     */ 
/*     */   public final int getEventRelativeX() {
/* 232 */     return this.event_relative_x;
/*     */   }
/*     */ 
/*     */   public final int getEventRelativeY() {
/* 236 */     return this.event_relative_y;
/*     */   }
/*     */ 
/*     */   public final int getRelativeX() {
/* 240 */     return this.relative_x;
/*     */   }
/*     */ 
/*     */   public final int getRelativeY() {
/* 244 */     return this.relative_y;
/*     */   }
/*     */ 
/*     */   public final synchronized boolean getNextKeyboardEvent(RawKeyboardEvent event) {
/* 248 */     this.processed_keyboard_events.flip();
/* 249 */     if (!this.processed_keyboard_events.hasRemaining()) {
/* 250 */       this.processed_keyboard_events.compact();
/* 251 */       return false;
/*     */     }
/* 253 */     RawKeyboardEvent next_event = (RawKeyboardEvent)this.processed_keyboard_events.get();
/* 254 */     event.set(next_event);
/* 255 */     this.processed_keyboard_events.compact();
/* 256 */     return true;
/*     */   }
/*     */ 
/*     */   public final synchronized boolean getNextMouseEvent(RawMouseEvent event) {
/* 260 */     this.processed_mouse_events.flip();
/* 261 */     if (!this.processed_mouse_events.hasRemaining()) {
/* 262 */       this.processed_mouse_events.compact();
/* 263 */       return false;
/*     */     }
/* 265 */     RawMouseEvent next_event = (RawMouseEvent)this.processed_mouse_events.get();
/* 266 */     if ((next_event.getFlags() & 0x1) != 0) {
/* 267 */       this.event_relative_x = (next_event.getLastX() - this.event_last_x);
/* 268 */       this.event_relative_y = (next_event.getLastY() - this.event_last_y);
/* 269 */       this.event_last_x = next_event.getLastX();
/* 270 */       this.event_last_y = next_event.getLastY();
/*     */     } else {
/* 272 */       this.event_relative_x = next_event.getLastX();
/* 273 */       this.event_relative_y = next_event.getLastY();
/*     */     }
/* 275 */     event.set(next_event);
/* 276 */     this.processed_mouse_events.compact();
/* 277 */     return true;
/*     */   }
/*     */ 
/*     */   public final boolean getButtonState(int button_id) {
/* 281 */     if (button_id >= this.button_states.length)
/* 282 */       return false;
/* 283 */     return this.button_states[button_id];
/*     */   }
/*     */ 
/*     */   public final void setBufferSize(int size) {
/* 287 */     this.keyboard_events = new DataQueue(size, RawKeyboardEvent.class);
/* 288 */     this.mouse_events = new DataQueue(size, RawMouseEvent.class);
/* 289 */     this.processed_keyboard_events = new DataQueue(size, RawKeyboardEvent.class);
/* 290 */     this.processed_mouse_events = new DataQueue(size, RawMouseEvent.class);
/*     */   }
/*     */ 
/*     */   public final int getType() {
/* 294 */     return this.type;
/*     */   }
/*     */ 
/*     */   public final long getHandle() {
/* 298 */     return this.handle;
/*     */   }
/*     */ 
/*     */   public final String getName() throws IOException {
/* 302 */     return nGetName(this.handle);
/*     */   }
/*     */   private static final native String nGetName(long paramLong) throws IOException;
/*     */ 
/*     */   public final RawDeviceInfo getInfo() throws IOException {
/* 307 */     return nGetInfo(this, this.handle);
/*     */   }
/*     */ 
/*     */   private static final native RawDeviceInfo nGetInfo(RawDevice paramRawDevice, long paramLong)
/*     */     throws IOException;
/*     */ }

/* Location:           /Users/Nick/Library/Application Support/minecraft/bin/jinput.jar
 * Qualified Name:     net.java.games.input.RawDevice
 * JD-Core Version:    0.6.1
 */