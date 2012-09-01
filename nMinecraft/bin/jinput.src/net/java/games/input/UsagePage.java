/*     */ package net.java.games.input;
/*     */ 
/*     */ import java.lang.reflect.Method;
/*     */ 
/*     */ final class UsagePage
/*     */ {
/*  48 */   private static final UsagePage[] map = new UsagePage['ÿ'];
/*     */ 
/*  50 */   public static final UsagePage UNDEFINED = new UsagePage(0);
/*  51 */   public static final UsagePage GENERIC_DESKTOP = new UsagePage(1, GenericDesktopUsage.class);
/*  52 */   public static final UsagePage SIMULATION = new UsagePage(2);
/*  53 */   public static final UsagePage VR = new UsagePage(3);
/*  54 */   public static final UsagePage SPORT = new UsagePage(4);
/*  55 */   public static final UsagePage GAME = new UsagePage(5);
/*     */ 
/*  57 */   public static final UsagePage KEYBOARD_OR_KEYPAD = new UsagePage(7, KeyboardUsage.class);
/*  58 */   public static final UsagePage LEDS = new UsagePage(8);
/*  59 */   public static final UsagePage BUTTON = new UsagePage(9, ButtonUsage.class);
/*  60 */   public static final UsagePage ORDINAL = new UsagePage(10);
/*  61 */   public static final UsagePage TELEPHONY = new UsagePage(11);
/*  62 */   public static final UsagePage CONSUMER = new UsagePage(12);
/*  63 */   public static final UsagePage DIGITIZER = new UsagePage(13);
/*     */ 
/*  65 */   public static final UsagePage PID = new UsagePage(15);
/*  66 */   public static final UsagePage UNICODE = new UsagePage(16);
/*     */ 
/*  68 */   public static final UsagePage ALPHANUMERIC_DISPLAY = new UsagePage(20);
/*     */ 
/*  72 */   public static final UsagePage POWER_DEVICE = new UsagePage(132);
/*  73 */   public static final UsagePage BATTERY_SYSTEM = new UsagePage(133);
/*     */ 
/*  75 */   public static final UsagePage BAR_CODE_SCANNER = new UsagePage(140);
/*  76 */   public static final UsagePage SCALE = new UsagePage(141);
/*     */ 
/*  78 */   public static final UsagePage CAMERACONTROL = new UsagePage(144);
/*  79 */   public static final UsagePage ARCADE = new UsagePage(145);
/*     */   private final Class usage_class;
/*     */   private final int usage_page_id;
/*     */ 
/*     */   public static final UsagePage map(int page_id)
/*     */   {
/*  84 */     if ((page_id < 0) || (page_id >= map.length))
/*  85 */       return null;
/*  86 */     return map[page_id];
/*     */   }
/*     */ 
/*     */   private UsagePage(int page_id, Class usage_class) {
/*  90 */     map[page_id] = this;
/*  91 */     this.usage_class = usage_class;
/*  92 */     this.usage_page_id = page_id;
/*     */   }
/*     */ 
/*     */   private UsagePage(int page_id) {
/*  96 */     this(page_id, null);
/*     */   }
/*     */ 
/*     */   public final String toString() {
/* 100 */     return "UsagePage (0x" + Integer.toHexString(this.usage_page_id) + ")";
/*     */   }
/*     */ 
/*     */   public final Usage mapUsage(int usage_id) {
/* 104 */     if (this.usage_class == null)
/* 105 */       return null;
/*     */     try {
/* 107 */       Method map_method = this.usage_class.getMethod("map", new Class[] { Integer.TYPE });
/* 108 */       Object result = map_method.invoke(null, new Object[] { new Integer(usage_id) });
/* 109 */       return (Usage)result;
/*     */     } catch (Exception e) {
/* 111 */       throw new Error(e);
/*     */     }
/*     */   }
/*     */ }

/* Location:           /Users/Nick/Library/Application Support/minecraft/bin/jinput.jar
 * Qualified Name:     net.java.games.input.UsagePage
 * JD-Core Version:    0.6.1
 */