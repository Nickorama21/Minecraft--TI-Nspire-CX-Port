package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.DamageSource;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Material;
import net.minecraft.src.MathHelper;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.World;

public class EntityXPOrb extends Entity {

   public int field_70533_a;
   public int field_70531_b = 0;
   public int field_70532_c;
   private int field_70529_d = 5;
   private int field_70530_e;
   private EntityPlayer field_80001_f;
   private int field_80002_g;


   public EntityXPOrb(World p_i3440_1_, double p_i3440_2_, double p_i3440_4_, double p_i3440_6_, int p_i3440_8_) {
      super(p_i3440_1_);
      this.func_70105_a(0.5F, 0.5F);
      this.field_70129_M = this.field_70131_O / 2.0F;
      this.func_70107_b(p_i3440_2_, p_i3440_4_, p_i3440_6_);
      this.field_70177_z = (float)(Math.random() * 360.0D);
      this.field_70159_w = (double)((float)(Math.random() * 0.20000000298023224D - 0.10000000149011612D) * 2.0F);
      this.field_70181_x = (double)((float)(Math.random() * 0.2D) * 2.0F);
      this.field_70179_y = (double)((float)(Math.random() * 0.20000000298023224D - 0.10000000149011612D) * 2.0F);
      this.field_70530_e = p_i3440_8_;
   }

   protected boolean func_70041_e_() {
      return false;
   }

   public EntityXPOrb(World p_i3441_1_) {
      super(p_i3441_1_);
      this.func_70105_a(0.25F, 0.25F);
      this.field_70129_M = this.field_70131_O / 2.0F;
   }

   protected void func_70088_a() {}

   public void func_70071_h_() {
      super.func_70071_h_();
      if(this.field_70532_c > 0) {
         --this.field_70532_c;
      }

      this.field_70169_q = this.field_70165_t;
      this.field_70167_r = this.field_70163_u;
      this.field_70166_s = this.field_70161_v;
      this.field_70181_x -= 0.029999999329447746D;
      if(this.field_70170_p.func_72803_f(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70163_u), MathHelper.func_76128_c(this.field_70161_v)) == Material.field_76256_h) {
         this.field_70181_x = 0.20000000298023224D;
         this.field_70159_w = (double)((this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.2F);
         this.field_70179_y = (double)((this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.2F);
         this.field_70170_p.func_72956_a(this, "random.fizz", 0.4F, 2.0F + this.field_70146_Z.nextFloat() * 0.4F);
      }

      this.func_70048_i(this.field_70165_t, (this.field_70121_D.field_72338_b + this.field_70121_D.field_72337_e) / 2.0D, this.field_70161_v);
      double var1 = 8.0D;
      if(this.field_80002_g < this.field_70533_a - 20 + this.field_70157_k % 100) {
         if(this.field_80001_f == null || this.field_80001_f.func_70068_e(this) > var1 * var1) {
            this.field_80001_f = this.field_70170_p.func_72890_a(this, var1);
         }

         this.field_80002_g = this.field_70533_a;
      }

      if(this.field_80001_f != null) {
         double var3 = (this.field_80001_f.field_70165_t - this.field_70165_t) / var1;
         double var5 = (this.field_80001_f.field_70163_u + (double)this.field_80001_f.func_70047_e() - this.field_70163_u) / var1;
         double var7 = (this.field_80001_f.field_70161_v - this.field_70161_v) / var1;
         double var9 = Math.sqrt(var3 * var3 + var5 * var5 + var7 * var7);
         double var11 = 1.0D - var9;
         if(var11 > 0.0D) {
            var11 *= var11;
            this.field_70159_w += var3 / var9 * var11 * 0.1D;
            this.field_70181_x += var5 / var9 * var11 * 0.1D;
            this.field_70179_y += var7 / var9 * var11 * 0.1D;
         }
      }

      this.func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
      float var13 = 0.98F;
      if(this.field_70122_E) {
         var13 = 0.58800006F;
         int var4 = this.field_70170_p.func_72798_a(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70121_D.field_72338_b) - 1, MathHelper.func_76128_c(this.field_70161_v));
         if(var4 > 0) {
            var13 = Block.field_71973_m[var4].field_72016_cq * 0.98F;
         }
      }

      this.field_70159_w *= (double)var13;
      this.field_70181_x *= 0.9800000190734863D;
      this.field_70179_y *= (double)var13;
      if(this.field_70122_E) {
         this.field_70181_x *= -0.8999999761581421D;
      }

      ++this.field_70533_a;
      ++this.field_70531_b;
      if(this.field_70531_b >= 6000) {
         this.func_70106_y();
      }

   }

   public boolean func_70072_I() {
      return this.field_70170_p.func_72918_a(this.field_70121_D, Material.field_76244_g, this);
   }

   protected void func_70081_e(int p_70081_1_) {
      this.func_70097_a(DamageSource.field_76372_a, p_70081_1_);
   }

   public boolean func_70097_a(DamageSource p_70097_1_, int p_70097_2_) {
      this.func_70018_K();
      this.field_70529_d -= p_70097_2_;
      if(this.field_70529_d <= 0) {
         this.func_70106_y();
      }

      return false;
   }

   public void func_70014_b(NBTTagCompound p_70014_1_) {
      p_70014_1_.func_74777_a("Health", (short)((byte)this.field_70529_d));
      p_70014_1_.func_74777_a("Age", (short)this.field_70531_b);
      p_70014_1_.func_74777_a("Value", (short)this.field_70530_e);
   }

   public void func_70037_a(NBTTagCompound p_70037_1_) {
      this.field_70529_d = p_70037_1_.func_74765_d("Health") & 255;
      this.field_70531_b = p_70037_1_.func_74765_d("Age");
      this.field_70530_e = p_70037_1_.func_74765_d("Value");
   }

   public void func_70100_b_(EntityPlayer p_70100_1_) {
      if(!this.field_70170_p.field_72995_K) {
         if(this.field_70532_c == 0 && p_70100_1_.field_71090_bL == 0) {
            p_70100_1_.field_71090_bL = 2;
            this.field_70170_p.func_72956_a(this, "random.orb", 0.1F, 0.5F * ((this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.7F + 1.8F));
            p_70100_1_.func_71001_a(this, 1);
            p_70100_1_.func_71023_q(this.field_70530_e);
            this.func_70106_y();
         }

      }
   }

   public int func_70526_d() {
      return this.field_70530_e;
   }

   public static int func_70527_a(int p_70527_0_) {
      return p_70527_0_ >= 2477?2477:(p_70527_0_ >= 1237?1237:(p_70527_0_ >= 617?617:(p_70527_0_ >= 307?307:(p_70527_0_ >= 149?149:(p_70527_0_ >= 73?73:(p_70527_0_ >= 37?37:(p_70527_0_ >= 17?17:(p_70527_0_ >= 7?7:(p_70527_0_ >= 3?3:1)))))))));
   }

   public boolean func_70075_an() {
      return false;
   }
}
