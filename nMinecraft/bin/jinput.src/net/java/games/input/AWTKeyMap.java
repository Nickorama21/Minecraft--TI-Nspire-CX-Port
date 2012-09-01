/*     */ package net.java.games.input;
/*     */ 
/*     */ import java.awt.event.KeyEvent;
/*     */ 
/*     */ final class AWTKeyMap
/*     */ {
/*     */   public static final Component.Identifier.Key mapKeyCode(int key_code)
/*     */   {
/*  36 */     switch (key_code) {
/*     */     case 48:
/*  38 */       return Component.Identifier.Key._0;
/*     */     case 49:
/*  40 */       return Component.Identifier.Key._1;
/*     */     case 50:
/*  42 */       return Component.Identifier.Key._2;
/*     */     case 51:
/*  44 */       return Component.Identifier.Key._3;
/*     */     case 52:
/*  46 */       return Component.Identifier.Key._4;
/*     */     case 53:
/*  48 */       return Component.Identifier.Key._5;
/*     */     case 54:
/*  50 */       return Component.Identifier.Key._6;
/*     */     case 55:
/*  52 */       return Component.Identifier.Key._7;
/*     */     case 56:
/*  54 */       return Component.Identifier.Key._8;
/*     */     case 57:
/*  56 */       return Component.Identifier.Key._9;
/*     */     case 81:
/*  59 */       return Component.Identifier.Key.Q;
/*     */     case 87:
/*  61 */       return Component.Identifier.Key.W;
/*     */     case 69:
/*  63 */       return Component.Identifier.Key.E;
/*     */     case 82:
/*  65 */       return Component.Identifier.Key.R;
/*     */     case 84:
/*  67 */       return Component.Identifier.Key.T;
/*     */     case 89:
/*  69 */       return Component.Identifier.Key.Y;
/*     */     case 85:
/*  71 */       return Component.Identifier.Key.U;
/*     */     case 73:
/*  73 */       return Component.Identifier.Key.I;
/*     */     case 79:
/*  75 */       return Component.Identifier.Key.O;
/*     */     case 80:
/*  77 */       return Component.Identifier.Key.P;
/*     */     case 65:
/*  79 */       return Component.Identifier.Key.A;
/*     */     case 83:
/*  81 */       return Component.Identifier.Key.S;
/*     */     case 68:
/*  83 */       return Component.Identifier.Key.D;
/*     */     case 70:
/*  85 */       return Component.Identifier.Key.F;
/*     */     case 71:
/*  87 */       return Component.Identifier.Key.G;
/*     */     case 72:
/*  89 */       return Component.Identifier.Key.H;
/*     */     case 74:
/*  91 */       return Component.Identifier.Key.J;
/*     */     case 75:
/*  93 */       return Component.Identifier.Key.K;
/*     */     case 76:
/*  95 */       return Component.Identifier.Key.L;
/*     */     case 90:
/*  97 */       return Component.Identifier.Key.Z;
/*     */     case 88:
/*  99 */       return Component.Identifier.Key.X;
/*     */     case 67:
/* 101 */       return Component.Identifier.Key.C;
/*     */     case 86:
/* 103 */       return Component.Identifier.Key.V;
/*     */     case 66:
/* 105 */       return Component.Identifier.Key.B;
/*     */     case 78:
/* 107 */       return Component.Identifier.Key.N;
/*     */     case 77:
/* 109 */       return Component.Identifier.Key.M;
/*     */     case 112:
/* 112 */       return Component.Identifier.Key.F1;
/*     */     case 113:
/* 114 */       return Component.Identifier.Key.F2;
/*     */     case 114:
/* 116 */       return Component.Identifier.Key.F3;
/*     */     case 115:
/* 118 */       return Component.Identifier.Key.F4;
/*     */     case 116:
/* 120 */       return Component.Identifier.Key.F5;
/*     */     case 117:
/* 122 */       return Component.Identifier.Key.F6;
/*     */     case 118:
/* 124 */       return Component.Identifier.Key.F7;
/*     */     case 119:
/* 126 */       return Component.Identifier.Key.F8;
/*     */     case 120:
/* 128 */       return Component.Identifier.Key.F9;
/*     */     case 121:
/* 130 */       return Component.Identifier.Key.F10;
/*     */     case 122:
/* 132 */       return Component.Identifier.Key.F11;
/*     */     case 123:
/* 134 */       return Component.Identifier.Key.F12;
/*     */     case 27:
/* 137 */       return Component.Identifier.Key.ESCAPE;
/*     */     case 45:
/* 139 */       return Component.Identifier.Key.MINUS;
/*     */     case 61:
/* 141 */       return Component.Identifier.Key.EQUALS;
/*     */     case 8:
/* 143 */       return Component.Identifier.Key.BACKSLASH;
/*     */     case 9:
/* 145 */       return Component.Identifier.Key.TAB;
/*     */     case 91:
/* 147 */       return Component.Identifier.Key.LBRACKET;
/*     */     case 93:
/* 149 */       return Component.Identifier.Key.RBRACKET;
/*     */     case 59:
/* 151 */       return Component.Identifier.Key.SEMICOLON;
/*     */     case 222:
/* 153 */       return Component.Identifier.Key.APOSTROPHE;
/*     */     case 520:
/* 155 */       return Component.Identifier.Key.GRAVE;
/*     */     case 92:
/* 157 */       return Component.Identifier.Key.BACKSLASH;
/*     */     case 46:
/* 159 */       return Component.Identifier.Key.PERIOD;
/*     */     case 47:
/* 161 */       return Component.Identifier.Key.SLASH;
/*     */     case 106:
/* 163 */       return Component.Identifier.Key.MULTIPLY;
/*     */     case 32:
/* 165 */       return Component.Identifier.Key.SPACE;
/*     */     case 20:
/* 167 */       return Component.Identifier.Key.CAPITAL;
/*     */     case 144:
/* 169 */       return Component.Identifier.Key.NUMLOCK;
/*     */     case 145:
/* 171 */       return Component.Identifier.Key.SCROLL;
/*     */     case 103:
/* 173 */       return Component.Identifier.Key.NUMPAD7;
/*     */     case 104:
/* 175 */       return Component.Identifier.Key.NUMPAD8;
/*     */     case 105:
/* 177 */       return Component.Identifier.Key.NUMPAD9;
/*     */     case 109:
/* 179 */       return Component.Identifier.Key.SUBTRACT;
/*     */     case 100:
/* 181 */       return Component.Identifier.Key.NUMPAD4;
/*     */     case 101:
/* 183 */       return Component.Identifier.Key.NUMPAD5;
/*     */     case 102:
/* 185 */       return Component.Identifier.Key.NUMPAD6;
/*     */     case 107:
/* 187 */       return Component.Identifier.Key.ADD;
/*     */     case 97:
/* 189 */       return Component.Identifier.Key.NUMPAD1;
/*     */     case 98:
/* 191 */       return Component.Identifier.Key.NUMPAD2;
/*     */     case 99:
/* 193 */       return Component.Identifier.Key.NUMPAD3;
/*     */     case 96:
/* 195 */       return Component.Identifier.Key.NUMPAD0;
/*     */     case 110:
/* 197 */       return Component.Identifier.Key.DECIMAL;
/*     */     case 21:
/* 200 */       return Component.Identifier.Key.KANA;
/*     */     case 28:
/* 202 */       return Component.Identifier.Key.CONVERT;
/*     */     case 29:
/* 204 */       return Component.Identifier.Key.NOCONVERT;
/*     */     case 514:
/* 207 */       return Component.Identifier.Key.CIRCUMFLEX;
/*     */     case 512:
/* 209 */       return Component.Identifier.Key.AT;
/*     */     case 513:
/* 211 */       return Component.Identifier.Key.COLON;
/*     */     case 523:
/* 213 */       return Component.Identifier.Key.UNDERLINE;
/*     */     case 25:
/* 215 */       return Component.Identifier.Key.KANJI;
/*     */     case 65480:
/* 218 */       return Component.Identifier.Key.STOP;
/*     */     case 111:
/* 221 */       return Component.Identifier.Key.DIVIDE;
/*     */     case 19:
/* 224 */       return Component.Identifier.Key.PAUSE;
/*     */     case 36:
/* 226 */       return Component.Identifier.Key.HOME;
/*     */     case 38:
/* 228 */       return Component.Identifier.Key.UP;
/*     */     case 33:
/* 230 */       return Component.Identifier.Key.PAGEUP;
/*     */     case 37:
/* 232 */       return Component.Identifier.Key.LEFT;
/*     */     case 39:
/* 234 */       return Component.Identifier.Key.RIGHT;
/*     */     case 35:
/* 236 */       return Component.Identifier.Key.END;
/*     */     case 40:
/* 238 */       return Component.Identifier.Key.DOWN;
/*     */     case 34:
/* 240 */       return Component.Identifier.Key.PAGEDOWN;
/*     */     case 155:
/* 242 */       return Component.Identifier.Key.INSERT;
/*     */     case 127:
/* 244 */       return Component.Identifier.Key.DELETE;
/*     */     }
/* 246 */     return Component.Identifier.Key.UNKNOWN;
/*     */   }
/*     */ 
/*     */   public static final Component.Identifier.Key map(KeyEvent event)
/*     */   {
/* 251 */     int key_code = event.getKeyCode();
/* 252 */     int key_location = event.getKeyLocation();
/* 253 */     switch (key_code) {
/*     */     case 17:
/* 255 */       if (key_location == 3) {
/* 256 */         return Component.Identifier.Key.RCONTROL;
/*     */       }
/* 258 */       return Component.Identifier.Key.LCONTROL;
/*     */     case 16:
/* 260 */       if (key_location == 3) {
/* 261 */         return Component.Identifier.Key.RSHIFT;
/*     */       }
/* 263 */       return Component.Identifier.Key.LSHIFT;
/*     */     case 18:
/* 265 */       if (key_location == 3) {
/* 266 */         return Component.Identifier.Key.RALT;
/*     */       }
/* 268 */       return Component.Identifier.Key.LALT;
/*     */     case 10:
/* 276 */       if (key_location == 4) {
/* 277 */         return Component.Identifier.Key.NUMPADENTER;
/*     */       }
/* 279 */       return Component.Identifier.Key.RETURN;
/*     */     case 44:
/* 281 */       if (key_location == 4) {
/* 282 */         return Component.Identifier.Key.NUMPADCOMMA;
/*     */       }
/* 284 */       return Component.Identifier.Key.COMMA;
/*     */     }
/* 286 */     return mapKeyCode(key_code);
/*     */   }
/*     */ }

/* Location:           /Users/Nick/Library/Application Support/minecraft/bin/jinput.jar
 * Qualified Name:     net.java.games.input.AWTKeyMap
 * JD-Core Version:    0.6.1
 */