package net.minecraft.src;

import net.minecraft.src.EntityAITarget;
import net.minecraft.src.EntityIronGolem;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.Village;

public class EntityAIDefendVillage extends EntityAITarget {

   EntityIronGolem field_75305_a;
   EntityLiving field_75304_b;


   public EntityAIDefendVillage(EntityIronGolem p_i3497_1_) {
      super(p_i3497_1_, 16.0F, false, true);
      this.field_75305_a = p_i3497_1_;
      this.func_75248_a(1);
   }

   public boolean func_75250_a() {
      Village var1 = this.field_75305_a.func_70852_n();
      if(var1 == null) {
         return false;
      } else {
         this.field_75304_b = var1.func_75571_b(this.field_75305_a);
         return this.func_75296_a(this.field_75304_b, false);
      }
   }

   public void func_75249_e() {
      this.field_75305_a.func_70624_b(this.field_75304_b);
      super.func_75249_e();
   }
}
