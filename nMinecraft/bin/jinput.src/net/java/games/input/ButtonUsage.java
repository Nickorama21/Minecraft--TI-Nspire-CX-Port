/*     */ package net.java.games.input;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ 
/*     */ final class ButtonUsage
/*     */   implements Usage
/*     */ {
/*  49 */   private static final Map map = new HashMap();
/*     */   private final int button_id;
/*     */ 
/*     */   public static final ButtonUsage map(int button_id)
/*     */   {
/*  54 */     Integer button_id_obj = new Integer(button_id);
/*  55 */     ButtonUsage existing = (ButtonUsage)map.get(button_id_obj);
/*  56 */     if (existing != null)
/*  57 */       return existing;
/*  58 */     ButtonUsage new_button = new ButtonUsage(button_id);
/*  59 */     map.put(button_id_obj, new_button);
/*  60 */     return new_button;
/*     */   }
/*     */ 
/*     */   private ButtonUsage(int button_id) {
/*  64 */     this.button_id = button_id;
/*     */   }
/*     */ 
/*     */   public final Component.Identifier.Button getIdentifier() {
/*  68 */     switch (this.button_id) {
/*     */     case 1:
/*  70 */       return Component.Identifier.Button._0;
/*     */     case 2:
/*  72 */       return Component.Identifier.Button._1;
/*     */     case 3:
/*  74 */       return Component.Identifier.Button._2;
/*     */     case 4:
/*  76 */       return Component.Identifier.Button._3;
/*     */     case 5:
/*  78 */       return Component.Identifier.Button._4;
/*     */     case 6:
/*  80 */       return Component.Identifier.Button._5;
/*     */     case 7:
/*  82 */       return Component.Identifier.Button._6;
/*     */     case 8:
/*  84 */       return Component.Identifier.Button._7;
/*     */     case 9:
/*  86 */       return Component.Identifier.Button._8;
/*     */     case 10:
/*  88 */       return Component.Identifier.Button._9;
/*     */     case 11:
/*  90 */       return Component.Identifier.Button._10;
/*     */     case 12:
/*  92 */       return Component.Identifier.Button._11;
/*     */     case 13:
/*  94 */       return Component.Identifier.Button._12;
/*     */     case 14:
/*  96 */       return Component.Identifier.Button._13;
/*     */     case 15:
/*  98 */       return Component.Identifier.Button._14;
/*     */     case 16:
/* 100 */       return Component.Identifier.Button._15;
/*     */     case 17:
/* 102 */       return Component.Identifier.Button._16;
/*     */     case 18:
/* 104 */       return Component.Identifier.Button._17;
/*     */     case 19:
/* 106 */       return Component.Identifier.Button._18;
/*     */     case 20:
/* 108 */       return Component.Identifier.Button._19;
/*     */     case 21:
/* 110 */       return Component.Identifier.Button._20;
/*     */     case 22:
/* 112 */       return Component.Identifier.Button._21;
/*     */     case 23:
/* 114 */       return Component.Identifier.Button._22;
/*     */     case 24:
/* 116 */       return Component.Identifier.Button._23;
/*     */     case 25:
/* 118 */       return Component.Identifier.Button._24;
/*     */     case 26:
/* 120 */       return Component.Identifier.Button._25;
/*     */     case 27:
/* 122 */       return Component.Identifier.Button._26;
/*     */     case 28:
/* 124 */       return Component.Identifier.Button._27;
/*     */     case 29:
/* 126 */       return Component.Identifier.Button._28;
/*     */     case 30:
/* 128 */       return Component.Identifier.Button._29;
/*     */     case 31:
/* 130 */       return Component.Identifier.Button._30;
/*     */     case 32:
/* 132 */       return Component.Identifier.Button._31;
/*     */     }
/* 134 */     return null;
/*     */   }
/*     */ 
/*     */   public final String toString()
/*     */   {
/* 139 */     return "ButtonUsage (" + this.button_id + ")";
/*     */   }
/*     */ }

/* Location:           /Users/Nick/Library/Application Support/minecraft/bin/jinput.jar
 * Qualified Name:     net.java.games.input.ButtonUsage
 * JD-Core Version:    0.6.1
 */