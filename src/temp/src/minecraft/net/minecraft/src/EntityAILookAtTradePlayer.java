package net.minecraft.src;

import net.minecraft.src.EntityAIWatchClosest;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EntityVillager;

public class EntityAILookAtTradePlayer extends EntityAIWatchClosest {

   private final EntityVillager field_75335_b;


   public EntityAILookAtTradePlayer(EntityVillager p_i3474_1_) {
      super(p_i3474_1_, EntityPlayer.class, 8.0F);
      this.field_75335_b = p_i3474_1_;
   }

   public boolean func_75250_a() {
      if(this.field_75335_b.func_70940_q()) {
         this.field_75334_a = this.field_75335_b.func_70931_l_();
         return true;
      } else {
         return false;
      }
   }
}
