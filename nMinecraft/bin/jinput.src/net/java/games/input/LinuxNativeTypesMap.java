/*     */ package net.java.games.input;
/*     */ 
/*     */ import java.io.PrintStream;
/*     */ 
/*     */ class LinuxNativeTypesMap
/*     */ {
/*  34 */   private static LinuxNativeTypesMap INSTANCE = new LinuxNativeTypesMap();
/*     */   private final Component.Identifier[] relAxesIDs;
/*     */   private final Component.Identifier[] absAxesIDs;
/*     */   private final Component.Identifier[] buttonIDs;
/*     */ 
/*     */   private LinuxNativeTypesMap()
/*     */   {
/*  43 */     this.buttonIDs = new Component.Identifier[511];
/*  44 */     this.relAxesIDs = new Component.Identifier[15];
/*  45 */     this.absAxesIDs = new Component.Identifier[63];
/*  46 */     reInit();
/*     */   }
/*     */ 
/*     */   private void reInit()
/*     */   {
/*  52 */     this.buttonIDs[1] = Component.Identifier.Key.ESCAPE;
/*  53 */     this.buttonIDs[2] = Component.Identifier.Key._1;
/*  54 */     this.buttonIDs[3] = Component.Identifier.Key._2;
/*  55 */     this.buttonIDs[4] = Component.Identifier.Key._3;
/*  56 */     this.buttonIDs[5] = Component.Identifier.Key._4;
/*  57 */     this.buttonIDs[6] = Component.Identifier.Key._5;
/*  58 */     this.buttonIDs[7] = Component.Identifier.Key._6;
/*  59 */     this.buttonIDs[8] = Component.Identifier.Key._7;
/*  60 */     this.buttonIDs[9] = Component.Identifier.Key._8;
/*  61 */     this.buttonIDs[10] = Component.Identifier.Key._9;
/*  62 */     this.buttonIDs[11] = Component.Identifier.Key._0;
/*  63 */     this.buttonIDs[12] = Component.Identifier.Key.MINUS;
/*  64 */     this.buttonIDs[13] = Component.Identifier.Key.EQUALS;
/*  65 */     this.buttonIDs[14] = Component.Identifier.Key.BACK;
/*  66 */     this.buttonIDs[15] = Component.Identifier.Key.TAB;
/*  67 */     this.buttonIDs[16] = Component.Identifier.Key.Q;
/*  68 */     this.buttonIDs[17] = Component.Identifier.Key.W;
/*  69 */     this.buttonIDs[18] = Component.Identifier.Key.E;
/*  70 */     this.buttonIDs[19] = Component.Identifier.Key.R;
/*  71 */     this.buttonIDs[20] = Component.Identifier.Key.T;
/*  72 */     this.buttonIDs[21] = Component.Identifier.Key.Y;
/*  73 */     this.buttonIDs[22] = Component.Identifier.Key.U;
/*  74 */     this.buttonIDs[23] = Component.Identifier.Key.I;
/*  75 */     this.buttonIDs[24] = Component.Identifier.Key.O;
/*  76 */     this.buttonIDs[25] = Component.Identifier.Key.P;
/*  77 */     this.buttonIDs[26] = Component.Identifier.Key.LBRACKET;
/*  78 */     this.buttonIDs[27] = Component.Identifier.Key.RBRACKET;
/*  79 */     this.buttonIDs[28] = Component.Identifier.Key.RETURN;
/*  80 */     this.buttonIDs[29] = Component.Identifier.Key.LCONTROL;
/*  81 */     this.buttonIDs[30] = Component.Identifier.Key.A;
/*  82 */     this.buttonIDs[31] = Component.Identifier.Key.S;
/*  83 */     this.buttonIDs[32] = Component.Identifier.Key.D;
/*  84 */     this.buttonIDs[33] = Component.Identifier.Key.F;
/*  85 */     this.buttonIDs[34] = Component.Identifier.Key.G;
/*  86 */     this.buttonIDs[35] = Component.Identifier.Key.H;
/*  87 */     this.buttonIDs[36] = Component.Identifier.Key.J;
/*  88 */     this.buttonIDs[37] = Component.Identifier.Key.K;
/*  89 */     this.buttonIDs[38] = Component.Identifier.Key.L;
/*  90 */     this.buttonIDs[39] = Component.Identifier.Key.SEMICOLON;
/*  91 */     this.buttonIDs[40] = Component.Identifier.Key.APOSTROPHE;
/*  92 */     this.buttonIDs[41] = Component.Identifier.Key.GRAVE;
/*  93 */     this.buttonIDs[42] = Component.Identifier.Key.LSHIFT;
/*  94 */     this.buttonIDs[43] = Component.Identifier.Key.BACKSLASH;
/*  95 */     this.buttonIDs[44] = Component.Identifier.Key.Z;
/*  96 */     this.buttonIDs[45] = Component.Identifier.Key.X;
/*  97 */     this.buttonIDs[46] = Component.Identifier.Key.C;
/*  98 */     this.buttonIDs[47] = Component.Identifier.Key.V;
/*  99 */     this.buttonIDs[48] = Component.Identifier.Key.B;
/* 100 */     this.buttonIDs[49] = Component.Identifier.Key.N;
/* 101 */     this.buttonIDs[50] = Component.Identifier.Key.M;
/* 102 */     this.buttonIDs[51] = Component.Identifier.Key.COMMA;
/* 103 */     this.buttonIDs[52] = Component.Identifier.Key.PERIOD;
/* 104 */     this.buttonIDs[53] = Component.Identifier.Key.SLASH;
/* 105 */     this.buttonIDs[54] = Component.Identifier.Key.RSHIFT;
/* 106 */     this.buttonIDs[55] = Component.Identifier.Key.MULTIPLY;
/* 107 */     this.buttonIDs[56] = Component.Identifier.Key.LALT;
/* 108 */     this.buttonIDs[57] = Component.Identifier.Key.SPACE;
/* 109 */     this.buttonIDs[58] = Component.Identifier.Key.CAPITAL;
/* 110 */     this.buttonIDs[59] = Component.Identifier.Key.F1;
/* 111 */     this.buttonIDs[60] = Component.Identifier.Key.F2;
/* 112 */     this.buttonIDs[61] = Component.Identifier.Key.F3;
/* 113 */     this.buttonIDs[62] = Component.Identifier.Key.F4;
/* 114 */     this.buttonIDs[63] = Component.Identifier.Key.F5;
/* 115 */     this.buttonIDs[64] = Component.Identifier.Key.F6;
/* 116 */     this.buttonIDs[65] = Component.Identifier.Key.F7;
/* 117 */     this.buttonIDs[66] = Component.Identifier.Key.F8;
/* 118 */     this.buttonIDs[67] = Component.Identifier.Key.F9;
/* 119 */     this.buttonIDs[68] = Component.Identifier.Key.F10;
/* 120 */     this.buttonIDs[69] = Component.Identifier.Key.NUMLOCK;
/* 121 */     this.buttonIDs[70] = Component.Identifier.Key.SCROLL;
/* 122 */     this.buttonIDs[71] = Component.Identifier.Key.NUMPAD7;
/* 123 */     this.buttonIDs[72] = Component.Identifier.Key.NUMPAD8;
/* 124 */     this.buttonIDs[73] = Component.Identifier.Key.NUMPAD9;
/* 125 */     this.buttonIDs[74] = Component.Identifier.Key.SUBTRACT;
/* 126 */     this.buttonIDs[75] = Component.Identifier.Key.NUMPAD4;
/* 127 */     this.buttonIDs[76] = Component.Identifier.Key.NUMPAD5;
/* 128 */     this.buttonIDs[77] = Component.Identifier.Key.NUMPAD6;
/* 129 */     this.buttonIDs[78] = Component.Identifier.Key.ADD;
/* 130 */     this.buttonIDs[79] = Component.Identifier.Key.NUMPAD1;
/* 131 */     this.buttonIDs[80] = Component.Identifier.Key.NUMPAD2;
/* 132 */     this.buttonIDs[81] = Component.Identifier.Key.NUMPAD3;
/* 133 */     this.buttonIDs[82] = Component.Identifier.Key.NUMPAD0;
/* 134 */     this.buttonIDs[83] = Component.Identifier.Key.DECIMAL;
/*     */ 
/* 136 */     this.buttonIDs['·'] = Component.Identifier.Key.F13;
/* 137 */     this.buttonIDs[86] = null;
/* 138 */     this.buttonIDs[87] = Component.Identifier.Key.F11;
/* 139 */     this.buttonIDs[88] = Component.Identifier.Key.F12;
/* 140 */     this.buttonIDs['¸'] = Component.Identifier.Key.F14;
/* 141 */     this.buttonIDs['¹'] = Component.Identifier.Key.F15;
/* 142 */     this.buttonIDs['º'] = null;
/* 143 */     this.buttonIDs['»'] = null;
/* 144 */     this.buttonIDs['¼'] = null;
/* 145 */     this.buttonIDs['½'] = null;
/* 146 */     this.buttonIDs['¾'] = null;
/* 147 */     this.buttonIDs[96] = Component.Identifier.Key.NUMPADENTER;
/* 148 */     this.buttonIDs[97] = Component.Identifier.Key.RCONTROL;
/* 149 */     this.buttonIDs[98] = Component.Identifier.Key.DIVIDE;
/* 150 */     this.buttonIDs[99] = Component.Identifier.Key.SYSRQ;
/* 151 */     this.buttonIDs[100] = Component.Identifier.Key.RALT;
/* 152 */     this.buttonIDs[101] = null;
/* 153 */     this.buttonIDs[102] = Component.Identifier.Key.HOME;
/* 154 */     this.buttonIDs[103] = Component.Identifier.Key.UP;
/* 155 */     this.buttonIDs[104] = Component.Identifier.Key.PAGEUP;
/* 156 */     this.buttonIDs[105] = Component.Identifier.Key.LEFT;
/* 157 */     this.buttonIDs[106] = Component.Identifier.Key.RIGHT;
/* 158 */     this.buttonIDs[107] = Component.Identifier.Key.END;
/* 159 */     this.buttonIDs[108] = Component.Identifier.Key.DOWN;
/* 160 */     this.buttonIDs[109] = Component.Identifier.Key.PAGEDOWN;
/* 161 */     this.buttonIDs[110] = Component.Identifier.Key.INSERT;
/* 162 */     this.buttonIDs[111] = Component.Identifier.Key.DELETE;
/* 163 */     this.buttonIDs[119] = Component.Identifier.Key.PAUSE;
/*     */ 
/* 169 */     this.buttonIDs[117] = Component.Identifier.Key.NUMPADEQUAL;
/*     */ 
/* 193 */     this.buttonIDs[''] = Component.Identifier.Key.SLEEP;
/*     */ 
/* 256 */     this.buttonIDs['ð'] = Component.Identifier.Key.UNLABELED;
/*     */ 
/* 261 */     this.buttonIDs[256] = Component.Identifier.Button._0;
/* 262 */     this.buttonIDs[257] = Component.Identifier.Button._1;
/* 263 */     this.buttonIDs[258] = Component.Identifier.Button._2;
/* 264 */     this.buttonIDs[259] = Component.Identifier.Button._3;
/* 265 */     this.buttonIDs[260] = Component.Identifier.Button._4;
/* 266 */     this.buttonIDs[261] = Component.Identifier.Button._5;
/* 267 */     this.buttonIDs[262] = Component.Identifier.Button._6;
/* 268 */     this.buttonIDs[263] = Component.Identifier.Button._7;
/* 269 */     this.buttonIDs[264] = Component.Identifier.Button._8;
/* 270 */     this.buttonIDs[265] = Component.Identifier.Button._9;
/*     */ 
/* 273 */     this.buttonIDs[272] = Component.Identifier.Button.LEFT;
/* 274 */     this.buttonIDs[273] = Component.Identifier.Button.RIGHT;
/* 275 */     this.buttonIDs[274] = Component.Identifier.Button.MIDDLE;
/* 276 */     this.buttonIDs[275] = Component.Identifier.Button.SIDE;
/* 277 */     this.buttonIDs[276] = Component.Identifier.Button.EXTRA;
/* 278 */     this.buttonIDs[277] = Component.Identifier.Button.FORWARD;
/* 279 */     this.buttonIDs[278] = Component.Identifier.Button.BACK;
/*     */ 
/* 282 */     this.buttonIDs[288] = Component.Identifier.Button.TRIGGER;
/* 283 */     this.buttonIDs[289] = Component.Identifier.Button.THUMB;
/* 284 */     this.buttonIDs[290] = Component.Identifier.Button.THUMB2;
/* 285 */     this.buttonIDs[291] = Component.Identifier.Button.TOP;
/* 286 */     this.buttonIDs[292] = Component.Identifier.Button.TOP2;
/* 287 */     this.buttonIDs[293] = Component.Identifier.Button.PINKIE;
/* 288 */     this.buttonIDs[294] = Component.Identifier.Button.BASE;
/* 289 */     this.buttonIDs[295] = Component.Identifier.Button.BASE2;
/* 290 */     this.buttonIDs[296] = Component.Identifier.Button.BASE3;
/* 291 */     this.buttonIDs[297] = Component.Identifier.Button.BASE4;
/* 292 */     this.buttonIDs[298] = Component.Identifier.Button.BASE5;
/* 293 */     this.buttonIDs[299] = Component.Identifier.Button.BASE6;
/* 294 */     this.buttonIDs[303] = Component.Identifier.Button.DEAD;
/*     */ 
/* 297 */     this.buttonIDs[304] = Component.Identifier.Button.A;
/* 298 */     this.buttonIDs[305] = Component.Identifier.Button.B;
/* 299 */     this.buttonIDs[306] = Component.Identifier.Button.C;
/* 300 */     this.buttonIDs[307] = Component.Identifier.Button.X;
/* 301 */     this.buttonIDs[308] = Component.Identifier.Button.Y;
/* 302 */     this.buttonIDs[309] = Component.Identifier.Button.Z;
/* 303 */     this.buttonIDs[310] = Component.Identifier.Button.LEFT_THUMB;
/* 304 */     this.buttonIDs[311] = Component.Identifier.Button.RIGHT_THUMB;
/* 305 */     this.buttonIDs[312] = Component.Identifier.Button.LEFT_THUMB2;
/* 306 */     this.buttonIDs[313] = Component.Identifier.Button.RIGHT_THUMB2;
/* 307 */     this.buttonIDs[314] = Component.Identifier.Button.SELECT;
/* 308 */     this.buttonIDs[316] = Component.Identifier.Button.MODE;
/* 309 */     this.buttonIDs[317] = Component.Identifier.Button.LEFT_THUMB3;
/* 310 */     this.buttonIDs[318] = Component.Identifier.Button.RIGHT_THUMB3;
/*     */ 
/* 313 */     this.buttonIDs[320] = Component.Identifier.Button.TOOL_PEN;
/* 314 */     this.buttonIDs[321] = Component.Identifier.Button.TOOL_RUBBER;
/* 315 */     this.buttonIDs[322] = Component.Identifier.Button.TOOL_BRUSH;
/* 316 */     this.buttonIDs[323] = Component.Identifier.Button.TOOL_PENCIL;
/* 317 */     this.buttonIDs[324] = Component.Identifier.Button.TOOL_AIRBRUSH;
/* 318 */     this.buttonIDs[325] = Component.Identifier.Button.TOOL_FINGER;
/* 319 */     this.buttonIDs[326] = Component.Identifier.Button.TOOL_MOUSE;
/* 320 */     this.buttonIDs[327] = Component.Identifier.Button.TOOL_LENS;
/* 321 */     this.buttonIDs[330] = Component.Identifier.Button.TOUCH;
/* 322 */     this.buttonIDs[331] = Component.Identifier.Button.STYLUS;
/* 323 */     this.buttonIDs[332] = Component.Identifier.Button.STYLUS2;
/*     */ 
/* 325 */     this.relAxesIDs[0] = Component.Identifier.Axis.X;
/* 326 */     this.relAxesIDs[1] = Component.Identifier.Axis.Y;
/* 327 */     this.relAxesIDs[2] = Component.Identifier.Axis.Z;
/* 328 */     this.relAxesIDs[8] = Component.Identifier.Axis.Z;
/*     */ 
/* 330 */     this.relAxesIDs[6] = Component.Identifier.Axis.SLIDER;
/* 331 */     this.relAxesIDs[7] = Component.Identifier.Axis.SLIDER;
/* 332 */     this.relAxesIDs[9] = Component.Identifier.Axis.SLIDER;
/*     */ 
/* 334 */     this.absAxesIDs[0] = Component.Identifier.Axis.X;
/* 335 */     this.absAxesIDs[1] = Component.Identifier.Axis.Y;
/* 336 */     this.absAxesIDs[2] = Component.Identifier.Axis.Z;
/* 337 */     this.absAxesIDs[3] = Component.Identifier.Axis.RX;
/* 338 */     this.absAxesIDs[4] = Component.Identifier.Axis.RY;
/* 339 */     this.absAxesIDs[5] = Component.Identifier.Axis.RZ;
/* 340 */     this.absAxesIDs[6] = Component.Identifier.Axis.SLIDER;
/* 341 */     this.absAxesIDs[7] = Component.Identifier.Axis.RZ;
/* 342 */     this.absAxesIDs[8] = Component.Identifier.Axis.Y;
/* 343 */     this.absAxesIDs[9] = Component.Identifier.Axis.SLIDER;
/* 344 */     this.absAxesIDs[10] = Component.Identifier.Axis.SLIDER;
/*     */ 
/* 346 */     this.absAxesIDs[16] = Component.Identifier.Axis.POV;
/* 347 */     this.absAxesIDs[17] = Component.Identifier.Axis.POV;
/* 348 */     this.absAxesIDs[18] = Component.Identifier.Axis.POV;
/* 349 */     this.absAxesIDs[19] = Component.Identifier.Axis.POV;
/* 350 */     this.absAxesIDs[20] = Component.Identifier.Axis.POV;
/* 351 */     this.absAxesIDs[21] = Component.Identifier.Axis.POV;
/* 352 */     this.absAxesIDs[22] = Component.Identifier.Axis.POV;
/* 353 */     this.absAxesIDs[23] = Component.Identifier.Axis.POV;
/*     */ 
/* 355 */     this.absAxesIDs[24] = null;
/* 356 */     this.absAxesIDs[25] = null;
/* 357 */     this.absAxesIDs[26] = null;
/* 358 */     this.absAxesIDs[27] = null;
/* 359 */     this.absAxesIDs[40] = null;
/*     */   }
/*     */ 
/*     */   public static final Controller.Type guessButtonTrait(int button_code) {
/* 363 */     switch (button_code) {
/*     */     case 288:
/*     */     case 289:
/*     */     case 290:
/*     */     case 291:
/*     */     case 292:
/*     */     case 293:
/*     */     case 294:
/*     */     case 295:
/*     */     case 296:
/*     */     case 297:
/*     */     case 298:
/*     */     case 299:
/*     */     case 303:
/* 377 */       return Controller.Type.STICK;
/*     */     case 304:
/*     */     case 305:
/*     */     case 306:
/*     */     case 307:
/*     */     case 308:
/*     */     case 309:
/*     */     case 310:
/*     */     case 311:
/*     */     case 312:
/*     */     case 313:
/*     */     case 314:
/*     */     case 316:
/*     */     case 317:
/*     */     case 318:
/* 392 */       return Controller.Type.GAMEPAD;
/*     */     case 256:
/*     */     case 257:
/*     */     case 258:
/*     */     case 259:
/*     */     case 260:
/*     */     case 261:
/*     */     case 262:
/*     */     case 263:
/*     */     case 264:
/*     */     case 265:
/* 403 */       return Controller.Type.UNKNOWN;
/*     */     case 272:
/*     */     case 273:
/*     */     case 274:
/*     */     case 275:
/*     */     case 276:
/* 409 */       return Controller.Type.MOUSE;
/*     */     case 1:
/*     */     case 2:
/*     */     case 3:
/*     */     case 4:
/*     */     case 5:
/*     */     case 6:
/*     */     case 7:
/*     */     case 8:
/*     */     case 9:
/*     */     case 10:
/*     */     case 11:
/*     */     case 12:
/*     */     case 13:
/*     */     case 14:
/*     */     case 15:
/*     */     case 16:
/*     */     case 17:
/*     */     case 18:
/*     */     case 19:
/*     */     case 20:
/*     */     case 21:
/*     */     case 22:
/*     */     case 23:
/*     */     case 24:
/*     */     case 25:
/*     */     case 26:
/*     */     case 27:
/*     */     case 28:
/*     */     case 29:
/*     */     case 30:
/*     */     case 31:
/*     */     case 32:
/*     */     case 33:
/*     */     case 34:
/*     */     case 35:
/*     */     case 36:
/*     */     case 37:
/*     */     case 38:
/*     */     case 39:
/*     */     case 40:
/*     */     case 41:
/*     */     case 42:
/*     */     case 43:
/*     */     case 44:
/*     */     case 45:
/*     */     case 46:
/*     */     case 47:
/*     */     case 48:
/*     */     case 49:
/*     */     case 50:
/*     */     case 51:
/*     */     case 52:
/*     */     case 53:
/*     */     case 54:
/*     */     case 55:
/*     */     case 56:
/*     */     case 57:
/*     */     case 58:
/*     */     case 59:
/*     */     case 60:
/*     */     case 61:
/*     */     case 62:
/*     */     case 63:
/*     */     case 64:
/*     */     case 65:
/*     */     case 66:
/*     */     case 67:
/*     */     case 68:
/*     */     case 69:
/*     */     case 70:
/*     */     case 71:
/*     */     case 72:
/*     */     case 73:
/*     */     case 74:
/*     */     case 75:
/*     */     case 76:
/*     */     case 77:
/*     */     case 78:
/*     */     case 79:
/*     */     case 80:
/*     */     case 81:
/*     */     case 82:
/*     */     case 83:
/*     */     case 85:
/*     */     case 86:
/*     */     case 87:
/*     */     case 88:
/*     */     case 89:
/*     */     case 90:
/*     */     case 91:
/*     */     case 92:
/*     */     case 93:
/*     */     case 94:
/*     */     case 95:
/*     */     case 96:
/*     */     case 97:
/*     */     case 98:
/*     */     case 99:
/*     */     case 100:
/*     */     case 101:
/*     */     case 102:
/*     */     case 103:
/*     */     case 104:
/*     */     case 105:
/*     */     case 106:
/*     */     case 107:
/*     */     case 108:
/*     */     case 109:
/*     */     case 110:
/*     */     case 111:
/*     */     case 112:
/*     */     case 113:
/*     */     case 114:
/*     */     case 115:
/*     */     case 116:
/*     */     case 117:
/*     */     case 118:
/*     */     case 119:
/*     */     case 121:
/*     */     case 122:
/*     */     case 123:
/*     */     case 124:
/*     */     case 125:
/*     */     case 126:
/*     */     case 127:
/*     */     case 128:
/*     */     case 129:
/*     */     case 130:
/*     */     case 131:
/*     */     case 132:
/*     */     case 133:
/*     */     case 134:
/*     */     case 135:
/*     */     case 136:
/*     */     case 137:
/*     */     case 138:
/*     */     case 139:
/*     */     case 140:
/*     */     case 141:
/*     */     case 142:
/*     */     case 143:
/*     */     case 144:
/*     */     case 145:
/*     */     case 146:
/*     */     case 147:
/*     */     case 148:
/*     */     case 149:
/*     */     case 150:
/*     */     case 151:
/*     */     case 152:
/*     */     case 153:
/*     */     case 154:
/*     */     case 155:
/*     */     case 156:
/*     */     case 157:
/*     */     case 158:
/*     */     case 159:
/*     */     case 160:
/*     */     case 161:
/*     */     case 162:
/*     */     case 163:
/*     */     case 164:
/*     */     case 165:
/*     */     case 166:
/*     */     case 167:
/*     */     case 168:
/*     */     case 169:
/*     */     case 170:
/*     */     case 171:
/*     */     case 172:
/*     */     case 173:
/*     */     case 174:
/*     */     case 175:
/*     */     case 176:
/*     */     case 177:
/*     */     case 178:
/*     */     case 179:
/*     */     case 180:
/*     */     case 183:
/*     */     case 184:
/*     */     case 185:
/*     */     case 186:
/*     */     case 187:
/*     */     case 188:
/*     */     case 189:
/*     */     case 190:
/*     */     case 191:
/*     */     case 192:
/*     */     case 193:
/*     */     case 194:
/*     */     case 200:
/*     */     case 201:
/*     */     case 202:
/*     */     case 203:
/*     */     case 205:
/*     */     case 206:
/*     */     case 207:
/*     */     case 208:
/*     */     case 209:
/*     */     case 210:
/*     */     case 211:
/*     */     case 212:
/*     */     case 213:
/*     */     case 214:
/*     */     case 215:
/*     */     case 216:
/*     */     case 217:
/*     */     case 218:
/*     */     case 219:
/*     */     case 220:
/*     */     case 221:
/*     */     case 222:
/*     */     case 223:
/*     */     case 224:
/*     */     case 225:
/*     */     case 226:
/*     */     case 227:
/*     */     case 228:
/*     */     case 229:
/*     */     case 230:
/*     */     case 352:
/*     */     case 353:
/*     */     case 354:
/*     */     case 355:
/*     */     case 356:
/*     */     case 357:
/*     */     case 358:
/*     */     case 359:
/*     */     case 360:
/*     */     case 361:
/*     */     case 362:
/*     */     case 363:
/*     */     case 364:
/*     */     case 365:
/*     */     case 366:
/*     */     case 367:
/*     */     case 368:
/*     */     case 369:
/*     */     case 370:
/*     */     case 371:
/*     */     case 372:
/*     */     case 373:
/*     */     case 374:
/*     */     case 375:
/*     */     case 376:
/*     */     case 377:
/*     */     case 378:
/*     */     case 379:
/*     */     case 380:
/*     */     case 381:
/*     */     case 382:
/*     */     case 383:
/*     */     case 384:
/*     */     case 385:
/*     */     case 386:
/*     */     case 387:
/*     */     case 388:
/*     */     case 389:
/*     */     case 390:
/*     */     case 391:
/*     */     case 392:
/*     */     case 393:
/*     */     case 394:
/*     */     case 395:
/*     */     case 396:
/*     */     case 397:
/*     */     case 398:
/*     */     case 399:
/*     */     case 400:
/*     */     case 401:
/*     */     case 402:
/*     */     case 403:
/*     */     case 404:
/*     */     case 405:
/*     */     case 406:
/*     */     case 407:
/*     */     case 408:
/*     */     case 409:
/*     */     case 410:
/*     */     case 411:
/*     */     case 412:
/*     */     case 413:
/*     */     case 414:
/*     */     case 415:
/*     */     case 448:
/*     */     case 449:
/*     */     case 450:
/*     */     case 451:
/*     */     case 464:
/*     */     case 465:
/*     */     case 466:
/*     */     case 467:
/*     */     case 468:
/*     */     case 469:
/*     */     case 470:
/*     */     case 471:
/*     */     case 472:
/*     */     case 473:
/*     */     case 474:
/*     */     case 475:
/*     */     case 476:
/*     */     case 477:
/*     */     case 478:
/*     */     case 479:
/*     */     case 480:
/*     */     case 481:
/*     */     case 482:
/*     */     case 483:
/*     */     case 484:
/* 721 */       return Controller.Type.KEYBOARD;
/*     */     case 84:
/*     */     case 120:
/*     */     case 181:
/*     */     case 182:
/*     */     case 195:
/*     */     case 196:
/*     */     case 197:
/*     */     case 198:
/*     */     case 199:
/*     */     case 204:
/*     */     case 231:
/*     */     case 232:
/*     */     case 233:
/*     */     case 234:
/*     */     case 235:
/*     */     case 236:
/*     */     case 237:
/*     */     case 238:
/*     */     case 239:
/*     */     case 240:
/*     */     case 241:
/*     */     case 242:
/*     */     case 243:
/*     */     case 244:
/*     */     case 245:
/*     */     case 246:
/*     */     case 247:
/*     */     case 248:
/*     */     case 249:
/*     */     case 250:
/*     */     case 251:
/*     */     case 252:
/*     */     case 253:
/*     */     case 254:
/*     */     case 255:
/*     */     case 266:
/*     */     case 267:
/*     */     case 268:
/*     */     case 269:
/*     */     case 270:
/*     */     case 271:
/*     */     case 277:
/*     */     case 278:
/*     */     case 279:
/*     */     case 280:
/*     */     case 281:
/*     */     case 282:
/*     */     case 283:
/*     */     case 284:
/*     */     case 285:
/*     */     case 286:
/*     */     case 287:
/*     */     case 300:
/*     */     case 301:
/*     */     case 302:
/*     */     case 315:
/*     */     case 319:
/*     */     case 320:
/*     */     case 321:
/*     */     case 322:
/*     */     case 323:
/*     */     case 324:
/*     */     case 325:
/*     */     case 326:
/*     */     case 327:
/*     */     case 328:
/*     */     case 329:
/*     */     case 330:
/*     */     case 331:
/*     */     case 332:
/*     */     case 333:
/*     */     case 334:
/*     */     case 335:
/*     */     case 336:
/*     */     case 337:
/*     */     case 338:
/*     */     case 339:
/*     */     case 340:
/*     */     case 341:
/*     */     case 342:
/*     */     case 343:
/*     */     case 344:
/*     */     case 345:
/*     */     case 346:
/*     */     case 347:
/*     */     case 348:
/*     */     case 349:
/*     */     case 350:
/*     */     case 351:
/*     */     case 416:
/*     */     case 417:
/*     */     case 418:
/*     */     case 419:
/*     */     case 420:
/*     */     case 421:
/*     */     case 422:
/*     */     case 423:
/*     */     case 424:
/*     */     case 425:
/*     */     case 426:
/*     */     case 427:
/*     */     case 428:
/*     */     case 429:
/*     */     case 430:
/*     */     case 431:
/*     */     case 432:
/*     */     case 433:
/*     */     case 434:
/*     */     case 435:
/*     */     case 436:
/*     */     case 437:
/*     */     case 438:
/*     */     case 439:
/*     */     case 440:
/*     */     case 441:
/*     */     case 442:
/*     */     case 443:
/*     */     case 444:
/*     */     case 445:
/*     */     case 446:
/*     */     case 447:
/*     */     case 452:
/*     */     case 453:
/*     */     case 454:
/*     */     case 455:
/*     */     case 456:
/*     */     case 457:
/*     */     case 458:
/*     */     case 459:
/*     */     case 460:
/*     */     case 461:
/*     */     case 462:
/* 723 */     case 463: } return Controller.Type.UNKNOWN;
/*     */   }
/*     */ 
/*     */   public static Controller.PortType getPortType(int nativeid)
/*     */   {
/* 733 */     switch (nativeid) {
/*     */     case 20:
/* 735 */       return Controller.PortType.GAME;
/*     */     case 17:
/* 737 */       return Controller.PortType.I8042;
/*     */     case 21:
/* 739 */       return Controller.PortType.PARALLEL;
/*     */     case 19:
/* 741 */       return Controller.PortType.SERIAL;
/*     */     case 3:
/* 743 */       return Controller.PortType.USB;
/*     */     }
/* 745 */     return Controller.PortType.UNKNOWN;
/*     */   }
/*     */ 
/*     */   public static Component.Identifier getRelAxisID(int nativeID)
/*     */   {
/* 754 */     Component.Identifier retval = null;
/*     */     try {
/* 756 */       retval = INSTANCE.relAxesIDs[nativeID];
/*     */     } catch (ArrayIndexOutOfBoundsException e) {
/* 758 */       System.out.println("INSTANCE.relAxesIDis only " + INSTANCE.relAxesIDs.length + " long, so " + nativeID + " not contained");
/*     */     }
/*     */ 
/* 761 */     if (retval == null) {
/* 762 */       retval = Component.Identifier.Axis.SLIDER_VELOCITY;
/*     */     }
/* 764 */     return retval;
/*     */   }
/*     */ 
/*     */   public static Component.Identifier getAbsAxisID(int nativeID)
/*     */   {
/* 772 */     Component.Identifier retval = null;
/*     */     try {
/* 774 */       retval = INSTANCE.absAxesIDs[nativeID];
/*     */     } catch (ArrayIndexOutOfBoundsException e) {
/* 776 */       System.out.println("INSTANCE.absAxesIDs is only " + INSTANCE.absAxesIDs.length + " long, so " + nativeID + " not contained");
/*     */     }
/*     */ 
/* 779 */     if (retval == null) {
/* 780 */       retval = Component.Identifier.Axis.SLIDER;
/*     */     }
/* 782 */     return retval;
/*     */   }
/*     */ 
/*     */   public static Component.Identifier getButtonID(int nativeID)
/*     */   {
/* 790 */     Component.Identifier retval = null;
/*     */     try {
/* 792 */       retval = INSTANCE.buttonIDs[nativeID];
/*     */     } catch (ArrayIndexOutOfBoundsException e) {
/* 794 */       System.out.println("INSTANCE.buttonIDs is only " + INSTANCE.buttonIDs.length + " long, so " + nativeID + " not contained");
/*     */     }
/*     */ 
/* 797 */     if (retval == null) {
/* 798 */       retval = Component.Identifier.Key.UNKNOWN;
/*     */     }
/* 800 */     return retval;
/*     */   }
/*     */ }

/* Location:           /Users/Nick/Library/Application Support/minecraft/bin/jinput.jar
 * Qualified Name:     net.java.games.input.LinuxNativeTypesMap
 * JD-Core Version:    0.6.1
 */