/*    */ package net.java.games.input;
/*    */ 
/*    */ final class DIEffectInfo
/*    */ {
/*    */   private final IDirectInputDevice device;
/*    */   private final byte[] guid;
/*    */   private final int guid_id;
/*    */   private final int effect_type;
/*    */   private final int static_params;
/*    */   private final int dynamic_params;
/*    */   private final String name;
/*    */ 
/*    */   public DIEffectInfo(IDirectInputDevice device, byte[] guid, int guid_id, int effect_type, int static_params, int dynamic_params, String name)
/*    */   {
/* 55 */     this.device = device;
/* 56 */     this.guid = guid;
/* 57 */     this.guid_id = guid_id;
/* 58 */     this.effect_type = effect_type;
/* 59 */     this.static_params = static_params;
/* 60 */     this.dynamic_params = dynamic_params;
/* 61 */     this.name = name;
/*    */   }
/*    */ 
/*    */   public final byte[] getGUID() {
/* 65 */     return this.guid;
/*    */   }
/*    */ 
/*    */   public final int getGUIDId() {
/* 69 */     return this.guid_id;
/*    */   }
/*    */ 
/*    */   public final int getDynamicParams() {
/* 73 */     return this.dynamic_params;
/*    */   }
/*    */ 
/*    */   public final int getEffectType() {
/* 77 */     return this.effect_type;
/*    */   }
/*    */ 
/*    */   public final String getName() {
/* 81 */     return this.name;
/*    */   }
/*    */ }

/* Location:           /Users/Nick/Library/Application Support/minecraft/bin/jinput.jar
 * Qualified Name:     net.java.games.input.DIEffectInfo
 * JD-Core Version:    0.6.1
 */