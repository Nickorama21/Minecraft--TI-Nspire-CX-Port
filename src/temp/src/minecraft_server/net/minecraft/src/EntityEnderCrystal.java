package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.DamageSource;
import net.minecraft.src.Entity;
import net.minecraft.src.MathHelper;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.World;

public class EntityEnderCrystal extends Entity {

   public int field_70261_a = 0;
   public int field_70260_b;


   public EntityEnderCrystal(World p_i3529_1_) {
      super(p_i3529_1_);
      this.field_70156_m = true;
      this.func_70105_a(2.0F, 2.0F);
      this.field_70129_M = this.field_70131_O / 2.0F;
      this.field_70260_b = 5;
      this.field_70261_a = this.field_70146_Z.nextInt(100000);
   }

   protected boolean func_70041_e_() {
      return false;
   }

   protected void func_70088_a() {
      this.field_70180_af.func_75682_a(8, Integer.valueOf(this.field_70260_b));
   }

   public void func_70071_h_() {
      this.field_70169_q = this.field_70165_t;
      this.field_70167_r = this.field_70163_u;
      this.field_70166_s = this.field_70161_v;
      ++this.field_70261_a;
      this.field_70180_af.func_75692_b(8, Integer.valueOf(this.field_70260_b));
      int var1 = MathHelper.func_76128_c(this.field_70165_t);
      int var2 = MathHelper.func_76128_c(this.field_70163_u);
      int var3 = MathHelper.func_76128_c(this.field_70161_v);
      if(this.field_70170_p.func_72798_a(var1, var2, var3) != Block.field_72067_ar.field_71990_ca) {
         this.field_70170_p.func_72859_e(var1, var2, var3, Block.field_72067_ar.field_71990_ca);
      }

   }

   protected void func_70014_b(NBTTagCompound p_70014_1_) {}

   protected void func_70037_a(NBTTagCompound p_70037_1_) {}

   public boolean func_70067_L() {
      return true;
   }

   public boolean func_70097_a(DamageSource p_70097_1_, int p_70097_2_) {
      if(!this.field_70128_L && !this.field_70170_p.field_72995_K) {
         this.field_70260_b = 0;
         if(this.field_70260_b <= 0) {
            this.func_70106_y();
            if(!this.field_70170_p.field_72995_K) {
               this.field_70170_p.func_72876_a((Entity)null, this.field_70165_t, this.field_70163_u, this.field_70161_v, 6.0F);
            }
         }
      }

      return true;
   }
}
