package net.minecraft.src;

import net.minecraft.src.Container;
import net.minecraft.src.EntityAIBase;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EntityVillager;

public class EntityAITradePlayer extends EntityAIBase {

   private EntityVillager field_75276_a;


   public EntityAITradePlayer(EntityVillager p_i3496_1_) {
      this.field_75276_a = p_i3496_1_;
      this.func_75248_a(5);
   }

   public boolean func_75250_a() {
      if(!this.field_75276_a.func_70089_S()) {
         return false;
      } else if(this.field_75276_a.func_70090_H()) {
         return false;
      } else if(!this.field_75276_a.field_70122_E) {
         return false;
      } else if(this.field_75276_a.field_70133_I) {
         return false;
      } else {
         EntityPlayer var1 = this.field_75276_a.func_70931_l_();
         return var1 == null?false:(this.field_75276_a.func_70068_e(var1) > 16.0D?false:var1.field_71070_bA instanceof Container);
      }
   }

   public void func_75249_e() {
      this.field_75276_a.func_70661_as().func_75499_g();
   }

   public void func_75251_c() {
      this.field_75276_a.func_70932_a_((EntityPlayer)null);
   }
}
