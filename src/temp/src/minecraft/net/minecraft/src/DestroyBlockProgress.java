package net.minecraft.src;


public class DestroyBlockProgress {

   private final int field_73115_a;
   private final int field_73113_b;
   private final int field_73114_c;
   private final int field_73111_d;
   private int field_73112_e;


   public DestroyBlockProgress(int p_i3385_1_, int p_i3385_2_, int p_i3385_3_, int p_i3385_4_) {
      this.field_73115_a = p_i3385_1_;
      this.field_73113_b = p_i3385_2_;
      this.field_73114_c = p_i3385_3_;
      this.field_73111_d = p_i3385_4_;
   }

   public int func_73110_b() {
      return this.field_73113_b;
   }

   public int func_73109_c() {
      return this.field_73114_c;
   }

   public int func_73108_d() {
      return this.field_73111_d;
   }

   public void func_73107_a(int p_73107_1_) {
      if(p_73107_1_ > 10) {
         p_73107_1_ = 10;
      }

      this.field_73112_e = p_73107_1_;
   }

   public int func_73106_e() {
      return this.field_73112_e;
   }
}
