/*    */ package net.java.games.input;
/*    */ 
/*    */ import java.io.IOException;
/*    */ 
/*    */ final class LinuxPOV extends LinuxComponent
/*    */ {
/*    */   private final LinuxEventComponent component_x;
/*    */   private final LinuxEventComponent component_y;
/*    */   private float last_x;
/*    */   private float last_y;
/*    */ 
/*    */   public LinuxPOV(LinuxEventComponent component_x, LinuxEventComponent component_y)
/*    */   {
/* 55 */     super(component_x);
/* 56 */     this.component_x = component_x;
/* 57 */     this.component_y = component_y;
/*    */   }
/*    */ 
/*    */   protected final float poll() throws IOException {
/* 61 */     this.last_x = LinuxControllers.poll(this.component_x);
/* 62 */     this.last_y = LinuxControllers.poll(this.component_y);
/* 63 */     return convertValue(0.0F, null);
/*    */   }
/*    */ 
/*    */   public float convertValue(float value, LinuxAxisDescriptor descriptor) {
/* 67 */     if (descriptor == this.component_x.getDescriptor())
/* 68 */       this.last_x = value;
/* 69 */     if (descriptor == this.component_y.getDescriptor()) {
/* 70 */       this.last_y = value;
/*    */     }
/* 72 */     if ((this.last_x == -1.0F) && (this.last_y == -1.0F))
/* 73 */       return 0.125F;
/* 74 */     if ((this.last_x == -1.0F) && (this.last_y == 0.0F))
/* 75 */       return 1.0F;
/* 76 */     if ((this.last_x == -1.0F) && (this.last_y == 1.0F))
/* 77 */       return 0.875F;
/* 78 */     if ((this.last_x == 0.0F) && (this.last_y == -1.0F))
/* 79 */       return 0.25F;
/* 80 */     if ((this.last_x == 0.0F) && (this.last_y == 0.0F))
/* 81 */       return 0.0F;
/* 82 */     if ((this.last_x == 0.0F) && (this.last_y == 1.0F))
/* 83 */       return 0.75F;
/* 84 */     if ((this.last_x == 1.0F) && (this.last_y == -1.0F))
/* 85 */       return 0.375F;
/* 86 */     if ((this.last_x == 1.0F) && (this.last_y == 0.0F))
/* 87 */       return 0.5F;
/* 88 */     if ((this.last_x == 1.0F) && (this.last_y == 1.0F)) {
/* 89 */       return 0.625F;
/*    */     }
/* 91 */     LinuxEnvironmentPlugin.logln("Unknown values x = " + this.last_x + " | y = " + this.last_y);
/* 92 */     return 0.0F;
/*    */   }
/*    */ }

/* Location:           /Users/Nick/Library/Application Support/minecraft/bin/jinput.jar
 * Qualified Name:     net.java.games.input.LinuxPOV
 * JD-Core Version:    0.6.1
 */