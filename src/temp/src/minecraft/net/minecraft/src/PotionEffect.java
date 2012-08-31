package net.minecraft.src;

import net.minecraft.src.EntityLiving;
import net.minecraft.src.Potion;

public class PotionEffect {

   private int field_76462_a;
   private int field_76460_b;
   private int field_76461_c;


   public PotionEffect(int p_i3434_1_, int p_i3434_2_, int p_i3434_3_) {
      this.field_76462_a = p_i3434_1_;
      this.field_76460_b = p_i3434_2_;
      this.field_76461_c = p_i3434_3_;
   }

   public PotionEffect(PotionEffect p_i3435_1_) {
      this.field_76462_a = p_i3435_1_.field_76462_a;
      this.field_76460_b = p_i3435_1_.field_76460_b;
      this.field_76461_c = p_i3435_1_.field_76461_c;
   }

   public void func_76452_a(PotionEffect p_76452_1_) {
      if(this.field_76462_a != p_76452_1_.field_76462_a) {
         System.err.println("This method should only be called for matching effects!");
      }

      if(p_76452_1_.field_76461_c > this.field_76461_c) {
         this.field_76461_c = p_76452_1_.field_76461_c;
         this.field_76460_b = p_76452_1_.field_76460_b;
      } else if(p_76452_1_.field_76461_c == this.field_76461_c && this.field_76460_b < p_76452_1_.field_76460_b) {
         this.field_76460_b = p_76452_1_.field_76460_b;
      }

   }

   public int func_76456_a() {
      return this.field_76462_a;
   }

   public int func_76459_b() {
      return this.field_76460_b;
   }

   public int func_76458_c() {
      return this.field_76461_c;
   }

   public boolean func_76455_a(EntityLiving p_76455_1_) {
      if(this.field_76460_b > 0) {
         if(Potion.field_76425_a[this.field_76462_a].func_76397_a(this.field_76460_b, this.field_76461_c)) {
            this.func_76457_b(p_76455_1_);
         }

         this.func_76454_e();
      }

      return this.field_76460_b > 0;
   }

   private int func_76454_e() {
      return --this.field_76460_b;
   }

   public void func_76457_b(EntityLiving p_76457_1_) {
      if(this.field_76460_b > 0) {
         Potion.field_76425_a[this.field_76462_a].func_76394_a(p_76457_1_, this.field_76461_c);
      }

   }

   public String func_76453_d() {
      return Potion.field_76425_a[this.field_76462_a].func_76393_a();
   }

   public int hashCode() {
      return this.field_76462_a;
   }

   public String toString() {
      String var1 = "";
      if(this.func_76458_c() > 0) {
         var1 = this.func_76453_d() + " x " + (this.func_76458_c() + 1) + ", Duration: " + this.func_76459_b();
      } else {
         var1 = this.func_76453_d() + ", Duration: " + this.func_76459_b();
      }

      return Potion.field_76425_a[this.field_76462_a].func_76395_i()?"(" + var1 + ")":var1;
   }

   public boolean equals(Object p_equals_1_) {
      if(!(p_equals_1_ instanceof PotionEffect)) {
         return false;
      } else {
         PotionEffect var2 = (PotionEffect)p_equals_1_;
         return this.field_76462_a == var2.field_76462_a && this.field_76461_c == var2.field_76461_c && this.field_76460_b == var2.field_76460_b;
      }
   }
}
