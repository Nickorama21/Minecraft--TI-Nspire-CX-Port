/*     */ package net.java.games.input;
/*     */ 
/*     */ final class GenericDesktopUsage
/*     */   implements Usage
/*     */ {
/*  46 */   private static final GenericDesktopUsage[] map = new GenericDesktopUsage['ÿ'];
/*     */ 
/*  48 */   public static final GenericDesktopUsage POINTER = new GenericDesktopUsage(1);
/*  49 */   public static final GenericDesktopUsage MOUSE = new GenericDesktopUsage(2);
/*     */ 
/*  51 */   public static final GenericDesktopUsage JOYSTICK = new GenericDesktopUsage(4);
/*  52 */   public static final GenericDesktopUsage GAME_PAD = new GenericDesktopUsage(5);
/*  53 */   public static final GenericDesktopUsage KEYBOARD = new GenericDesktopUsage(6);
/*  54 */   public static final GenericDesktopUsage KEYPAD = new GenericDesktopUsage(7);
/*  55 */   public static final GenericDesktopUsage MULTI_AXIS_CONTROLLER = new GenericDesktopUsage(8);
/*     */ 
/*  57 */   public static final GenericDesktopUsage X = new GenericDesktopUsage(48);
/*  58 */   public static final GenericDesktopUsage Y = new GenericDesktopUsage(49);
/*  59 */   public static final GenericDesktopUsage Z = new GenericDesktopUsage(50);
/*  60 */   public static final GenericDesktopUsage RX = new GenericDesktopUsage(51);
/*  61 */   public static final GenericDesktopUsage RY = new GenericDesktopUsage(52);
/*  62 */   public static final GenericDesktopUsage RZ = new GenericDesktopUsage(53);
/*  63 */   public static final GenericDesktopUsage SLIDER = new GenericDesktopUsage(54);
/*  64 */   public static final GenericDesktopUsage DIAL = new GenericDesktopUsage(55);
/*  65 */   public static final GenericDesktopUsage WHEEL = new GenericDesktopUsage(56);
/*  66 */   public static final GenericDesktopUsage HATSWITCH = new GenericDesktopUsage(57);
/*  67 */   public static final GenericDesktopUsage COUNTED_BUFFER = new GenericDesktopUsage(58);
/*  68 */   public static final GenericDesktopUsage BYTE_COUNT = new GenericDesktopUsage(59);
/*  69 */   public static final GenericDesktopUsage MOTION_WAKEUP = new GenericDesktopUsage(60);
/*  70 */   public static final GenericDesktopUsage START = new GenericDesktopUsage(61);
/*  71 */   public static final GenericDesktopUsage SELECT = new GenericDesktopUsage(62);
/*     */ 
/*  73 */   public static final GenericDesktopUsage VX = new GenericDesktopUsage(64);
/*  74 */   public static final GenericDesktopUsage VY = new GenericDesktopUsage(65);
/*  75 */   public static final GenericDesktopUsage VZ = new GenericDesktopUsage(66);
/*  76 */   public static final GenericDesktopUsage VBRX = new GenericDesktopUsage(67);
/*  77 */   public static final GenericDesktopUsage VBRY = new GenericDesktopUsage(68);
/*  78 */   public static final GenericDesktopUsage VBRZ = new GenericDesktopUsage(69);
/*  79 */   public static final GenericDesktopUsage VNO = new GenericDesktopUsage(70);
/*     */ 
/*  81 */   public static final GenericDesktopUsage SYSTEM_CONTROL = new GenericDesktopUsage(128);
/*  82 */   public static final GenericDesktopUsage SYSTEM_POWER_DOWN = new GenericDesktopUsage(129);
/*  83 */   public static final GenericDesktopUsage SYSTEM_SLEEP = new GenericDesktopUsage(130);
/*  84 */   public static final GenericDesktopUsage SYSTEM_WAKE_UP = new GenericDesktopUsage(131);
/*  85 */   public static final GenericDesktopUsage SYSTEM_CONTEXT_MENU = new GenericDesktopUsage(132);
/*  86 */   public static final GenericDesktopUsage SYSTEM_MAIN_MENU = new GenericDesktopUsage(133);
/*  87 */   public static final GenericDesktopUsage SYSTEM_APP_MENU = new GenericDesktopUsage(134);
/*  88 */   public static final GenericDesktopUsage SYSTEM_MENU_HELP = new GenericDesktopUsage(135);
/*  89 */   public static final GenericDesktopUsage SYSTEM_MENU_EXIT = new GenericDesktopUsage(136);
/*  90 */   public static final GenericDesktopUsage SYSTEM_MENU = new GenericDesktopUsage(137);
/*  91 */   public static final GenericDesktopUsage SYSTEM_MENU_RIGHT = new GenericDesktopUsage(138);
/*  92 */   public static final GenericDesktopUsage SYSTEM_MENU_LEFT = new GenericDesktopUsage(139);
/*  93 */   public static final GenericDesktopUsage SYSTEM_MENU_UP = new GenericDesktopUsage(140);
/*  94 */   public static final GenericDesktopUsage SYSTEM_MENU_DOWN = new GenericDesktopUsage(141);
/*     */ 
/*  96 */   public static final GenericDesktopUsage DPAD_UP = new GenericDesktopUsage(144);
/*  97 */   public static final GenericDesktopUsage DPAD_DOWN = new GenericDesktopUsage(145);
/*  98 */   public static final GenericDesktopUsage DPAD_RIGHT = new GenericDesktopUsage(146);
/*  99 */   public static final GenericDesktopUsage DPAD_LEFT = new GenericDesktopUsage(147);
/*     */   private final int usage_id;
/*     */ 
/*     */   public static final GenericDesktopUsage map(int usage_id)
/*     */   {
/* 105 */     if ((usage_id < 0) || (usage_id >= map.length))
/* 106 */       return null;
/* 107 */     return map[usage_id];
/*     */   }
/*     */ 
/*     */   private GenericDesktopUsage(int usage_id) {
/* 111 */     map[usage_id] = this;
/* 112 */     this.usage_id = usage_id;
/*     */   }
/*     */ 
/*     */   public final String toString() {
/* 116 */     return "GenericDesktopUsage (0x" + Integer.toHexString(this.usage_id) + ")";
/*     */   }
/*     */ 
/*     */   public final Component.Identifier getIdentifier() {
/* 120 */     if (this == X)
/* 121 */       return Component.Identifier.Axis.X;
/* 122 */     if (this == Y)
/* 123 */       return Component.Identifier.Axis.Y;
/* 124 */     if ((this == Z) || (this == WHEEL))
/* 125 */       return Component.Identifier.Axis.Z;
/* 126 */     if (this == RX)
/* 127 */       return Component.Identifier.Axis.RX;
/* 128 */     if (this == RY)
/* 129 */       return Component.Identifier.Axis.RY;
/* 130 */     if (this == RZ)
/* 131 */       return Component.Identifier.Axis.RZ;
/* 132 */     if (this == SLIDER)
/* 133 */       return Component.Identifier.Axis.SLIDER;
/* 134 */     if (this == HATSWITCH)
/* 135 */       return Component.Identifier.Axis.POV;
/* 136 */     if (this == SELECT) {
/* 137 */       return Component.Identifier.Button.SELECT;
/*     */     }
/* 139 */     return null;
/*     */   }
/*     */ }

/* Location:           /Users/Nick/Library/Application Support/minecraft/bin/jinput.jar
 * Qualified Name:     net.java.games.input.GenericDesktopUsage
 * JD-Core Version:    0.6.1
 */