package net.minecraft.src;

import net.minecraft.src.EntityAIBase;
import net.minecraft.src.EntityCreeper;
import net.minecraft.src.EntityLiving;

public class EntityAICreeperSwell extends EntityAIBase {

   EntityCreeper field_75269_a;
   EntityLiving field_75268_b;


   public EntityAICreeperSwell(EntityCreeper p_i3493_1_) {
      this.field_75269_a = p_i3493_1_;
      this.func_75248_a(1);
   }

   public boolean func_75250_a() {
      EntityLiving var1 = this.field_75269_a.func_70638_az();
      return this.field_75269_a.func_70832_p() > 0 || var1 != null && this.field_75269_a.func_70068_e(var1) < 9.0D;
   }

   public void func_75249_e() {
      this.field_75269_a.func_70661_as().func_75499_g();
      this.field_75268_b = this.field_75269_a.func_70638_az();
   }

   public void func_75251_c() {
      this.field_75268_b = null;
   }

   public void func_75246_d() {
      if(this.field_75268_b == null) {
         this.field_75269_a.func_70829_a(-1);
      } else if(this.field_75269_a.func_70068_e(this.field_75268_b) > 49.0D) {
         this.field_75269_a.func_70829_a(-1);
      } else if(!this.field_75269_a.func_70635_at().func_75522_a(this.field_75268_b)) {
         this.field_75269_a.func_70829_a(-1);
      } else {
         this.field_75269_a.func_70829_a(1);
      }
   }
}
