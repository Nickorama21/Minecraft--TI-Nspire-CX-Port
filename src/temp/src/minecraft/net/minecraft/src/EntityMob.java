package net.minecraft.src;

import net.minecraft.src.DamageSource;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityCreature;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EnumSkyBlock;
import net.minecraft.src.IMob;
import net.minecraft.src.MathHelper;
import net.minecraft.src.Potion;
import net.minecraft.src.World;

public abstract class EntityMob extends EntityCreature implements IMob {

   protected int field_70815_f = 2;


   public EntityMob(World p_i3552_1_) {
      super(p_i3552_1_);
      this.field_70728_aV = 5;
   }

   public void func_70636_d() {
      float var1 = this.func_70013_c(1.0F);
      if(var1 > 0.5F) {
         this.field_70708_bq += 2;
      }

      super.func_70636_d();
   }

   public void func_70071_h_() {
      super.func_70071_h_();
      if(!this.field_70170_p.field_72995_K && this.field_70170_p.field_73013_u == 0) {
         this.func_70106_y();
      }

   }

   protected Entity func_70782_k() {
      EntityPlayer var1 = this.field_70170_p.func_72856_b(this, 16.0D);
      return var1 != null && this.func_70685_l(var1)?var1:null;
   }

   public boolean func_70097_a(DamageSource p_70097_1_, int p_70097_2_) {
      if(super.func_70097_a(p_70097_1_, p_70097_2_)) {
         Entity var3 = p_70097_1_.func_76346_g();
         if(this.field_70153_n != var3 && this.field_70154_o != var3) {
            if(var3 != this) {
               this.field_70789_a = var3;
            }

            return true;
         } else {
            return true;
         }
      } else {
         return false;
      }
   }

   public boolean func_70652_k(Entity p_70652_1_) {
      int var2 = this.field_70815_f;
      if(this.func_70644_a(Potion.field_76420_g)) {
         var2 += 3 << this.func_70660_b(Potion.field_76420_g).func_76458_c();
      }

      if(this.func_70644_a(Potion.field_76437_t)) {
         var2 -= 2 << this.func_70660_b(Potion.field_76437_t).func_76458_c();
      }

      return p_70652_1_.func_70097_a(DamageSource.func_76358_a(this), var2);
   }

   protected void func_70785_a(Entity p_70785_1_, float p_70785_2_) {
      if(this.field_70724_aR <= 0 && p_70785_2_ < 2.0F && p_70785_1_.field_70121_D.field_72337_e > this.field_70121_D.field_72338_b && p_70785_1_.field_70121_D.field_72338_b < this.field_70121_D.field_72337_e) {
         this.field_70724_aR = 20;
         this.func_70652_k(p_70785_1_);
      }

   }

   public float func_70783_a(int p_70783_1_, int p_70783_2_, int p_70783_3_) {
      return 0.5F - this.field_70170_p.func_72801_o(p_70783_1_, p_70783_2_, p_70783_3_);
   }

   protected boolean func_70814_o() {
      int var1 = MathHelper.func_76128_c(this.field_70165_t);
      int var2 = MathHelper.func_76128_c(this.field_70121_D.field_72338_b);
      int var3 = MathHelper.func_76128_c(this.field_70161_v);
      if(this.field_70170_p.func_72972_b(EnumSkyBlock.Sky, var1, var2, var3) > this.field_70146_Z.nextInt(32)) {
         return false;
      } else {
         int var4 = this.field_70170_p.func_72957_l(var1, var2, var3);
         if(this.field_70170_p.func_72911_I()) {
            int var5 = this.field_70170_p.field_73008_k;
            this.field_70170_p.field_73008_k = 10;
            var4 = this.field_70170_p.func_72957_l(var1, var2, var3);
            this.field_70170_p.field_73008_k = var5;
         }

         return var4 <= this.field_70146_Z.nextInt(8);
      }
   }

   public boolean func_70601_bi() {
      return this.func_70814_o() && super.func_70601_bi();
   }
}
