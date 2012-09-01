/*     */ package net.java.games.input;
/*     */ 
/*     */ public abstract interface Component
/*     */ {
/*     */   public abstract Identifier getIdentifier();
/*     */ 
/*     */   public abstract boolean isRelative();
/*     */ 
/*     */   public abstract boolean isAnalog();
/*     */ 
/*     */   public abstract float getDeadZone();
/*     */ 
/*     */   public abstract float getPollData();
/*     */ 
/*     */   public abstract String getName();
/*     */ 
/*     */   public static class POV
/*     */   {
/*     */     public static final float OFF = 0.0F;
/*     */     public static final float CENTER = 0.0F;
/*     */     public static final float UP_LEFT = 0.125F;
/*     */     public static final float UP = 0.25F;
/*     */     public static final float UP_RIGHT = 0.375F;
/*     */     public static final float RIGHT = 0.5F;
/*     */     public static final float DOWN_RIGHT = 0.625F;
/*     */     public static final float DOWN = 0.75F;
/*     */     public static final float DOWN_LEFT = 0.875F;
/*     */     public static final float LEFT = 1.0F;
/*     */   }
/*     */ 
/*     */   public static class Identifier
/*     */   {
/*     */     private final String name;
/*     */ 
/*     */     protected Identifier(String name)
/*     */     {
/* 102 */       this.name = name;
/*     */     }
/*     */ 
/*     */     public String getName()
/*     */     {
/* 109 */       return this.name;
/*     */     }
/*     */ 
/*     */     public String toString()
/*     */     {
/* 116 */       return this.name;
/*     */     }
/*     */ 
/*     */     public static class Key extends Component.Identifier
/*     */     {
/* 560 */       public static final Key VOID = new Key("Void");
/* 561 */       public static final Key ESCAPE = new Key("Escape");
/* 562 */       public static final Key _1 = new Key("1");
/* 563 */       public static final Key _2 = new Key("2");
/* 564 */       public static final Key _3 = new Key("3");
/* 565 */       public static final Key _4 = new Key("4");
/* 566 */       public static final Key _5 = new Key("5");
/* 567 */       public static final Key _6 = new Key("6");
/* 568 */       public static final Key _7 = new Key("7");
/* 569 */       public static final Key _8 = new Key("8");
/* 570 */       public static final Key _9 = new Key("9");
/* 571 */       public static final Key _0 = new Key("0");
/* 572 */       public static final Key MINUS = new Key("-");
/* 573 */       public static final Key EQUALS = new Key("=");
/* 574 */       public static final Key BACK = new Key("Back");
/* 575 */       public static final Key TAB = new Key("Tab");
/* 576 */       public static final Key Q = new Key("Q");
/* 577 */       public static final Key W = new Key("W");
/* 578 */       public static final Key E = new Key("E");
/* 579 */       public static final Key R = new Key("R");
/* 580 */       public static final Key T = new Key("T");
/* 581 */       public static final Key Y = new Key("Y");
/* 582 */       public static final Key U = new Key("U");
/* 583 */       public static final Key I = new Key("I");
/* 584 */       public static final Key O = new Key("O");
/* 585 */       public static final Key P = new Key("P");
/* 586 */       public static final Key LBRACKET = new Key("[");
/* 587 */       public static final Key RBRACKET = new Key("]");
/* 588 */       public static final Key RETURN = new Key("Return");
/* 589 */       public static final Key LCONTROL = new Key("Left Control");
/* 590 */       public static final Key A = new Key("A");
/* 591 */       public static final Key S = new Key("S");
/* 592 */       public static final Key D = new Key("D");
/* 593 */       public static final Key F = new Key("F");
/* 594 */       public static final Key G = new Key("G");
/* 595 */       public static final Key H = new Key("H");
/* 596 */       public static final Key J = new Key("J");
/* 597 */       public static final Key K = new Key("K");
/* 598 */       public static final Key L = new Key("L");
/* 599 */       public static final Key SEMICOLON = new Key(";");
/* 600 */       public static final Key APOSTROPHE = new Key("'");
/* 601 */       public static final Key GRAVE = new Key("~");
/* 602 */       public static final Key LSHIFT = new Key("Left Shift");
/* 603 */       public static final Key BACKSLASH = new Key("\\");
/* 604 */       public static final Key Z = new Key("Z");
/* 605 */       public static final Key X = new Key("X");
/* 606 */       public static final Key C = new Key("C");
/* 607 */       public static final Key V = new Key("V");
/* 608 */       public static final Key B = new Key("B");
/* 609 */       public static final Key N = new Key("N");
/* 610 */       public static final Key M = new Key("M");
/* 611 */       public static final Key COMMA = new Key(",");
/* 612 */       public static final Key PERIOD = new Key(".");
/* 613 */       public static final Key SLASH = new Key("/");
/* 614 */       public static final Key RSHIFT = new Key("Right Shift");
/* 615 */       public static final Key MULTIPLY = new Key("Multiply");
/* 616 */       public static final Key LALT = new Key("Left Alt");
/* 617 */       public static final Key SPACE = new Key(" ");
/* 618 */       public static final Key CAPITAL = new Key("Caps Lock");
/* 619 */       public static final Key F1 = new Key("F1");
/* 620 */       public static final Key F2 = new Key("F2");
/* 621 */       public static final Key F3 = new Key("F3");
/* 622 */       public static final Key F4 = new Key("F4");
/* 623 */       public static final Key F5 = new Key("F5");
/* 624 */       public static final Key F6 = new Key("F6");
/* 625 */       public static final Key F7 = new Key("F7");
/* 626 */       public static final Key F8 = new Key("F8");
/* 627 */       public static final Key F9 = new Key("F9");
/* 628 */       public static final Key F10 = new Key("F10");
/* 629 */       public static final Key NUMLOCK = new Key("Num Lock");
/* 630 */       public static final Key SCROLL = new Key("Scroll Lock");
/* 631 */       public static final Key NUMPAD7 = new Key("Num 7");
/* 632 */       public static final Key NUMPAD8 = new Key("Num 8");
/* 633 */       public static final Key NUMPAD9 = new Key("Num 9");
/* 634 */       public static final Key SUBTRACT = new Key("Num -");
/* 635 */       public static final Key NUMPAD4 = new Key("Num 4");
/* 636 */       public static final Key NUMPAD5 = new Key("Num 5");
/* 637 */       public static final Key NUMPAD6 = new Key("Num 6");
/* 638 */       public static final Key ADD = new Key("Num +");
/* 639 */       public static final Key NUMPAD1 = new Key("Num 1");
/* 640 */       public static final Key NUMPAD2 = new Key("Num 2");
/* 641 */       public static final Key NUMPAD3 = new Key("Num 3");
/* 642 */       public static final Key NUMPAD0 = new Key("Num 0");
/* 643 */       public static final Key DECIMAL = new Key("Num .");
/* 644 */       public static final Key F11 = new Key("F11");
/* 645 */       public static final Key F12 = new Key("F12");
/* 646 */       public static final Key F13 = new Key("F13");
/* 647 */       public static final Key F14 = new Key("F14");
/* 648 */       public static final Key F15 = new Key("F15");
/* 649 */       public static final Key KANA = new Key("Kana");
/* 650 */       public static final Key CONVERT = new Key("Convert");
/* 651 */       public static final Key NOCONVERT = new Key("Noconvert");
/* 652 */       public static final Key YEN = new Key("Yen");
/* 653 */       public static final Key NUMPADEQUAL = new Key("Num =");
/* 654 */       public static final Key CIRCUMFLEX = new Key("Circumflex");
/* 655 */       public static final Key AT = new Key("At");
/* 656 */       public static final Key COLON = new Key("Colon");
/* 657 */       public static final Key UNDERLINE = new Key("Underline");
/* 658 */       public static final Key KANJI = new Key("Kanji");
/* 659 */       public static final Key STOP = new Key("Stop");
/* 660 */       public static final Key AX = new Key("Ax");
/* 661 */       public static final Key UNLABELED = new Key("Unlabeled");
/* 662 */       public static final Key NUMPADENTER = new Key("Num Enter");
/* 663 */       public static final Key RCONTROL = new Key("Right Control");
/* 664 */       public static final Key NUMPADCOMMA = new Key("Num ,");
/* 665 */       public static final Key DIVIDE = new Key("Num /");
/* 666 */       public static final Key SYSRQ = new Key("SysRq");
/* 667 */       public static final Key RALT = new Key("Right Alt");
/* 668 */       public static final Key PAUSE = new Key("Pause");
/* 669 */       public static final Key HOME = new Key("Home");
/* 670 */       public static final Key UP = new Key("Up");
/* 671 */       public static final Key PAGEUP = new Key("Pg Up");
/* 672 */       public static final Key LEFT = new Key("Left");
/* 673 */       public static final Key RIGHT = new Key("Right");
/* 674 */       public static final Key END = new Key("End");
/* 675 */       public static final Key DOWN = new Key("Down");
/* 676 */       public static final Key PAGEDOWN = new Key("Pg Down");
/* 677 */       public static final Key INSERT = new Key("Insert");
/* 678 */       public static final Key DELETE = new Key("Delete");
/* 679 */       public static final Key LWIN = new Key("Left Windows");
/* 680 */       public static final Key RWIN = new Key("Right Windows");
/* 681 */       public static final Key APPS = new Key("Apps");
/* 682 */       public static final Key POWER = new Key("Power");
/* 683 */       public static final Key SLEEP = new Key("Sleep");
/* 684 */       public static final Key UNKNOWN = new Key("Unknown");
/*     */ 
/*     */       protected Key(String name)
/*     */       {
/* 553 */         super();
/*     */       }
/*     */     }
/*     */ 
/*     */     public static class Button extends Component.Identifier
/*     */     {
/* 291 */       public static final Button _0 = new Button("0");
/*     */ 
/* 295 */       public static final Button _1 = new Button("1");
/*     */ 
/* 299 */       public static final Button _2 = new Button("2");
/*     */ 
/* 303 */       public static final Button _3 = new Button("3");
/*     */ 
/* 307 */       public static final Button _4 = new Button("4");
/*     */ 
/* 311 */       public static final Button _5 = new Button("5");
/*     */ 
/* 315 */       public static final Button _6 = new Button("6");
/*     */ 
/* 319 */       public static final Button _7 = new Button("7");
/*     */ 
/* 323 */       public static final Button _8 = new Button("8");
/*     */ 
/* 327 */       public static final Button _9 = new Button("9");
/* 328 */       public static final Button _10 = new Button("10");
/* 329 */       public static final Button _11 = new Button("11");
/* 330 */       public static final Button _12 = new Button("12");
/* 331 */       public static final Button _13 = new Button("13");
/* 332 */       public static final Button _14 = new Button("14");
/* 333 */       public static final Button _15 = new Button("15");
/* 334 */       public static final Button _16 = new Button("16");
/* 335 */       public static final Button _17 = new Button("17");
/* 336 */       public static final Button _18 = new Button("18");
/* 337 */       public static final Button _19 = new Button("19");
/* 338 */       public static final Button _20 = new Button("20");
/* 339 */       public static final Button _21 = new Button("21");
/* 340 */       public static final Button _22 = new Button("22");
/* 341 */       public static final Button _23 = new Button("23");
/* 342 */       public static final Button _24 = new Button("24");
/* 343 */       public static final Button _25 = new Button("25");
/* 344 */       public static final Button _26 = new Button("26");
/* 345 */       public static final Button _27 = new Button("27");
/* 346 */       public static final Button _28 = new Button("28");
/* 347 */       public static final Button _29 = new Button("29");
/* 348 */       public static final Button _30 = new Button("30");
/* 349 */       public static final Button _31 = new Button("31");
/*     */ 
/* 353 */       public static final Button TRIGGER = new Button("Trigger");
/*     */ 
/* 357 */       public static final Button THUMB = new Button("Thumb");
/*     */ 
/* 361 */       public static final Button THUMB2 = new Button("Thumb 2");
/*     */ 
/* 365 */       public static final Button TOP = new Button("Top");
/*     */ 
/* 369 */       public static final Button TOP2 = new Button("Top 2");
/*     */ 
/* 374 */       public static final Button PINKIE = new Button("Pinkie");
/*     */ 
/* 378 */       public static final Button BASE = new Button("Base");
/*     */ 
/* 382 */       public static final Button BASE2 = new Button("Base 2");
/*     */ 
/* 386 */       public static final Button BASE3 = new Button("Base 3");
/*     */ 
/* 390 */       public static final Button BASE4 = new Button("Base 4");
/*     */ 
/* 394 */       public static final Button BASE5 = new Button("Base 5");
/*     */ 
/* 398 */       public static final Button BASE6 = new Button("Base 6");
/*     */ 
/* 402 */       public static final Button DEAD = new Button("Dead");
/*     */ 
/* 406 */       public static final Button A = new Button("A");
/*     */ 
/* 410 */       public static final Button B = new Button("B");
/*     */ 
/* 414 */       public static final Button C = new Button("C");
/*     */ 
/* 418 */       public static final Button X = new Button("X");
/*     */ 
/* 422 */       public static final Button Y = new Button("Y");
/*     */ 
/* 426 */       public static final Button Z = new Button("Z");
/*     */ 
/* 430 */       public static final Button LEFT_THUMB = new Button("Left Thumb");
/*     */ 
/* 434 */       public static final Button RIGHT_THUMB = new Button("Right Thumb");
/*     */ 
/* 438 */       public static final Button LEFT_THUMB2 = new Button("Left Thumb 2");
/*     */ 
/* 442 */       public static final Button RIGHT_THUMB2 = new Button("Right Thumb 2");
/*     */ 
/* 446 */       public static final Button SELECT = new Button("Select");
/*     */ 
/* 450 */       public static final Button MODE = new Button("Mode");
/*     */ 
/* 454 */       public static final Button LEFT_THUMB3 = new Button("Left Thumb 3");
/*     */ 
/* 458 */       public static final Button RIGHT_THUMB3 = new Button("Right Thumb 3");
/*     */ 
/* 462 */       public static final Button TOOL_PEN = new Button("Pen");
/*     */ 
/* 466 */       public static final Button TOOL_RUBBER = new Button("Rubber");
/*     */ 
/* 470 */       public static final Button TOOL_BRUSH = new Button("Brush");
/*     */ 
/* 474 */       public static final Button TOOL_PENCIL = new Button("Pencil");
/*     */ 
/* 478 */       public static final Button TOOL_AIRBRUSH = new Button("Airbrush");
/*     */ 
/* 482 */       public static final Button TOOL_FINGER = new Button("Finger");
/*     */ 
/* 486 */       public static final Button TOOL_MOUSE = new Button("Mouse");
/*     */ 
/* 490 */       public static final Button TOOL_LENS = new Button("Lens");
/*     */ 
/* 494 */       public static final Button TOUCH = new Button("Touch");
/*     */ 
/* 498 */       public static final Button STYLUS = new Button("Stylus");
/*     */ 
/* 502 */       public static final Button STYLUS2 = new Button("Stylus 2");
/*     */ 
/* 507 */       public static final Button UNKNOWN = new Button("Unknown");
/*     */ 
/* 512 */       public static final Button BACK = new Button("Back");
/*     */ 
/* 517 */       public static final Button EXTRA = new Button("Extra");
/*     */ 
/* 522 */       public static final Button FORWARD = new Button("Forward");
/*     */ 
/* 527 */       public static final Button LEFT = new Button("Left");
/*     */ 
/* 532 */       public static final Button MIDDLE = new Button("Middle");
/*     */ 
/* 537 */       public static final Button RIGHT = new Button("Right");
/*     */ 
/* 542 */       public static final Button SIDE = new Button("Side");
/*     */ 
/*     */       public Button(String name)
/*     */       {
/* 286 */         super();
/*     */       }
/*     */     }
/*     */ 
/*     */     public static class Axis extends Component.Identifier
/*     */     {
/* 131 */       public static final Axis X = new Axis("x");
/*     */ 
/* 136 */       public static final Axis Y = new Axis("y");
/*     */ 
/* 143 */       public static final Axis Z = new Axis("z");
/*     */ 
/* 148 */       public static final Axis RX = new Axis("rx");
/*     */ 
/* 153 */       public static final Axis RY = new Axis("ry");
/*     */ 
/* 159 */       public static final Axis RZ = new Axis("rz");
/*     */ 
/* 164 */       public static final Axis SLIDER = new Axis("slider");
/*     */ 
/* 169 */       public static final Axis SLIDER_ACCELERATION = new Axis("slider-acceleration");
/*     */ 
/* 174 */       public static final Axis SLIDER_FORCE = new Axis("slider-force");
/*     */ 
/* 179 */       public static final Axis SLIDER_VELOCITY = new Axis("slider-velocity");
/*     */ 
/* 184 */       public static final Axis X_ACCELERATION = new Axis("x-acceleration");
/*     */ 
/* 189 */       public static final Axis X_FORCE = new Axis("x-force");
/*     */ 
/* 194 */       public static final Axis X_VELOCITY = new Axis("x-velocity");
/*     */ 
/* 199 */       public static final Axis Y_ACCELERATION = new Axis("y-acceleration");
/*     */ 
/* 204 */       public static final Axis Y_FORCE = new Axis("y-force");
/*     */ 
/* 209 */       public static final Axis Y_VELOCITY = new Axis("y-velocity");
/*     */ 
/* 214 */       public static final Axis Z_ACCELERATION = new Axis("z-acceleration");
/*     */ 
/* 219 */       public static final Axis Z_FORCE = new Axis("z-force");
/*     */ 
/* 224 */       public static final Axis Z_VELOCITY = new Axis("z-velocity");
/*     */ 
/* 229 */       public static final Axis RX_ACCELERATION = new Axis("rx-acceleration");
/*     */ 
/* 234 */       public static final Axis RX_FORCE = new Axis("rx-force");
/*     */ 
/* 239 */       public static final Axis RX_VELOCITY = new Axis("rx-velocity");
/*     */ 
/* 244 */       public static final Axis RY_ACCELERATION = new Axis("ry-acceleration");
/*     */ 
/* 249 */       public static final Axis RY_FORCE = new Axis("ry-force");
/*     */ 
/* 254 */       public static final Axis RY_VELOCITY = new Axis("ry-velocity");
/*     */ 
/* 259 */       public static final Axis RZ_ACCELERATION = new Axis("rz-acceleration");
/*     */ 
/* 264 */       public static final Axis RZ_FORCE = new Axis("rz-force");
/*     */ 
/* 269 */       public static final Axis RZ_VELOCITY = new Axis("rz-velocity");
/*     */ 
/* 274 */       public static final Axis POV = new Axis("pov");
/*     */ 
/* 279 */       public static final Axis UNKNOWN = new Axis("unknown");
/*     */ 
/*     */       protected Axis(String name)
/*     */       {
/* 125 */         super();
/*     */       }
/*     */     }
/*     */   }
/*     */ }

/* Location:           /Users/Nick/Library/Application Support/minecraft/bin/jinput.jar
 * Qualified Name:     net.java.games.input.Component
 * JD-Core Version:    0.6.1
 */