/*    */ package net.java.games.input;
/*    */ 
/*    */ final class ElementType
/*    */ {
/* 48 */   private static final ElementType[] map = new ElementType[514];
/*    */ 
/* 50 */   public static final ElementType INPUT_MISC = new ElementType(1);
/* 51 */   public static final ElementType INPUT_BUTTON = new ElementType(2);
/* 52 */   public static final ElementType INPUT_AXIS = new ElementType(3);
/* 53 */   public static final ElementType INPUT_SCANCODES = new ElementType(4);
/* 54 */   public static final ElementType OUTPUT = new ElementType(129);
/* 55 */   public static final ElementType FEATURE = new ElementType(257);
/* 56 */   public static final ElementType COLLECTION = new ElementType(513);
/*    */   private final int type_id;
/*    */ 
/*    */   public static final ElementType map(int type_id)
/*    */   {
/* 61 */     if ((type_id < 0) || (type_id >= map.length))
/* 62 */       return null;
/* 63 */     return map[type_id];
/*    */   }
/*    */ 
/*    */   private ElementType(int type_id) {
/* 67 */     map[type_id] = this;
/* 68 */     this.type_id = type_id;
/*    */   }
/*    */ 
/*    */   public final String toString() {
/* 72 */     return "ElementType (0x" + Integer.toHexString(this.type_id) + ")";
/*    */   }
/*    */ }

/* Location:           /Users/Nick/Library/Application Support/minecraft/bin/jinput.jar
 * Qualified Name:     net.java.games.input.ElementType
 * JD-Core Version:    0.6.1
 */