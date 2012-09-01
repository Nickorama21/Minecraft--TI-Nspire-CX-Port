/*    */ package net.java.games.input;
/*    */ 
/*    */ import java.io.IOException;
/*    */ 
/*    */ final class LinuxRumbleFF extends LinuxForceFeedbackEffect
/*    */ {
/*    */   public LinuxRumbleFF(LinuxEventDevice device)
/*    */     throws IOException
/*    */   {
/* 35 */     super(device);
/*    */   }
/*    */ 
/*    */   protected final int upload(int id, float intensity)
/*    */     throws IOException
/*    */   {
/*    */     int weak_magnitude;
/*    */     int strong_magnitude;
/*    */     int weak_magnitude;
/* 41 */     if (intensity > 0.666666F) {
/* 42 */       int strong_magnitude = (int)(32768.0F * intensity);
/* 43 */       weak_magnitude = (int)(49152.0F * intensity);
/*    */     }
/*    */     else
/*    */     {
/*    */       int weak_magnitude;
/* 44 */       if (intensity > 0.3333333F) {
/* 45 */         int strong_magnitude = (int)(32768.0F * intensity);
/* 46 */         weak_magnitude = 0;
/*    */       } else {
/* 48 */         strong_magnitude = 0;
/* 49 */         weak_magnitude = (int)(49152.0F * intensity);
/*    */       }
/*    */     }
/* 52 */     return getDevice().uploadRumbleEffect(id, 0, 0, 0, -1, 0, strong_magnitude, weak_magnitude);
/*    */   }
/*    */ }

/* Location:           /Users/Nick/Library/Application Support/minecraft/bin/jinput.jar
 * Qualified Name:     net.java.games.input.LinuxRumbleFF
 * JD-Core Version:    0.6.1
 */