package net.minecraft.src;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityAINearestAttackableTargetSorter;
import net.minecraft.src.EntityAITarget;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityPlayer;

public class EntityAINearestAttackableTarget extends EntityAITarget {

   EntityLiving field_75309_a;
   Class field_75307_b;
   int field_75308_c;
   private EntityAINearestAttackableTargetSorter field_75306_g;


   public EntityAINearestAttackableTarget(EntityLiving p_i3500_1_, Class p_i3500_2_, float p_i3500_3_, int p_i3500_4_, boolean p_i3500_5_) {
      this(p_i3500_1_, p_i3500_2_, p_i3500_3_, p_i3500_4_, p_i3500_5_, false);
   }

   public EntityAINearestAttackableTarget(EntityLiving p_i3501_1_, Class p_i3501_2_, float p_i3501_3_, int p_i3501_4_, boolean p_i3501_5_, boolean p_i3501_6_) {
      super(p_i3501_1_, p_i3501_3_, p_i3501_5_, p_i3501_6_);
      this.field_75307_b = p_i3501_2_;
      this.field_75300_e = p_i3501_3_;
      this.field_75308_c = p_i3501_4_;
      this.field_75306_g = new EntityAINearestAttackableTargetSorter(this, p_i3501_1_);
      this.func_75248_a(1);
   }

   public boolean func_75250_a() {
      if(this.field_75308_c > 0 && this.field_75299_d.func_70681_au().nextInt(this.field_75308_c) != 0) {
         return false;
      } else {
         if(this.field_75307_b == EntityPlayer.class) {
            EntityPlayer var1 = this.field_75299_d.field_70170_p.func_72856_b(this.field_75299_d, (double)this.field_75300_e);
            if(this.func_75296_a(var1, false)) {
               this.field_75309_a = var1;
               return true;
            }
         } else {
            List var5 = this.field_75299_d.field_70170_p.func_72872_a(this.field_75307_b, this.field_75299_d.field_70121_D.func_72314_b((double)this.field_75300_e, 4.0D, (double)this.field_75300_e));
            Collections.sort(var5, this.field_75306_g);
            Iterator var2 = var5.iterator();

            while(var2.hasNext()) {
               Entity var3 = (Entity)var2.next();
               EntityLiving var4 = (EntityLiving)var3;
               if(this.func_75296_a(var4, false)) {
                  this.field_75309_a = var4;
                  return true;
               }
            }
         }

         return false;
      }
   }

   public void func_75249_e() {
      this.field_75299_d.func_70624_b(this.field_75309_a);
      super.func_75249_e();
   }
}
