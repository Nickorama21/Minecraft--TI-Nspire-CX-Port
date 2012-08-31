package net.minecraft.src;

import net.minecraft.src.EntityAIBase;
import net.minecraft.src.EntityArrow;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntitySnowball;
import net.minecraft.src.MathHelper;
import net.minecraft.src.World;

public class EntityAIArrowAttack extends EntityAIBase {

   World field_75324_a;
   EntityLiving field_75322_b;
   EntityLiving field_75323_c;
   int field_75320_d = 0;
   float field_75321_e;
   int field_75318_f = 0;
   int field_75319_g;
   int field_75325_h;


   public EntityAIArrowAttack(EntityLiving p_i3457_1_, float p_i3457_2_, int p_i3457_3_, int p_i3457_4_) {
      this.field_75322_b = p_i3457_1_;
      this.field_75324_a = p_i3457_1_.field_70170_p;
      this.field_75321_e = p_i3457_2_;
      this.field_75319_g = p_i3457_3_;
      this.field_75325_h = p_i3457_4_;
      this.func_75248_a(3);
   }

   public boolean func_75250_a() {
      EntityLiving var1 = this.field_75322_b.func_70638_az();
      if(var1 == null) {
         return false;
      } else {
         this.field_75323_c = var1;
         return true;
      }
   }

   public boolean func_75253_b() {
      return this.func_75250_a() || !this.field_75322_b.func_70661_as().func_75500_f();
   }

   public void func_75251_c() {
      this.field_75323_c = null;
   }

   public void func_75246_d() {
      double var1 = 100.0D;
      double var3 = this.field_75322_b.func_70092_e(this.field_75323_c.field_70165_t, this.field_75323_c.field_70121_D.field_72338_b, this.field_75323_c.field_70161_v);
      boolean var5 = this.field_75322_b.func_70635_at().func_75522_a(this.field_75323_c);
      if(var5) {
         ++this.field_75318_f;
      } else {
         this.field_75318_f = 0;
      }

      if(var3 <= var1 && this.field_75318_f >= 20) {
         this.field_75322_b.func_70661_as().func_75499_g();
      } else {
         this.field_75322_b.func_70661_as().func_75497_a(this.field_75323_c, this.field_75321_e);
      }

      this.field_75322_b.func_70671_ap().func_75651_a(this.field_75323_c, 30.0F, 30.0F);
      this.field_75320_d = Math.max(this.field_75320_d - 1, 0);
      if(this.field_75320_d <= 0) {
         if(var3 <= var1 && var5) {
            this.func_75317_f();
            this.field_75320_d = this.field_75325_h;
         }
      }
   }

   private void func_75317_f() {
      if(this.field_75319_g == 1) {
         EntityArrow var1 = new EntityArrow(this.field_75324_a, this.field_75322_b, this.field_75323_c, 1.6F, 12.0F);
         this.field_75324_a.func_72956_a(this.field_75322_b, "random.bow", 1.0F, 1.0F / (this.field_75322_b.func_70681_au().nextFloat() * 0.4F + 0.8F));
         this.field_75324_a.func_72838_d(var1);
      } else if(this.field_75319_g == 2) {
         EntitySnowball var9 = new EntitySnowball(this.field_75324_a, this.field_75322_b);
         double var2 = this.field_75323_c.field_70165_t - this.field_75322_b.field_70165_t;
         double var4 = this.field_75323_c.field_70163_u + (double)this.field_75323_c.func_70047_e() - 1.100000023841858D - var9.field_70163_u;
         double var6 = this.field_75323_c.field_70161_v - this.field_75322_b.field_70161_v;
         float var8 = MathHelper.func_76133_a(var2 * var2 + var6 * var6) * 0.2F;
         var9.func_70186_c(var2, var4 + (double)var8, var6, 1.6F, 12.0F);
         this.field_75324_a.func_72956_a(this.field_75322_b, "random.bow", 1.0F, 1.0F / (this.field_75322_b.func_70681_au().nextFloat() * 0.4F + 0.8F));
         this.field_75324_a.func_72838_d(var9);
      }

   }
}
