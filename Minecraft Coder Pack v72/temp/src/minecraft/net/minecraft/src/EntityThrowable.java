package net.minecraft.src;

import java.util.Iterator;
import java.util.List;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.MathHelper;
import net.minecraft.src.MovingObjectPosition;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.Vec3;
import net.minecraft.src.World;

public abstract class EntityThrowable extends Entity {

   private int field_70189_d = -1;
   private int field_70190_e = -1;
   private int field_70187_f = -1;
   private int field_70188_g = 0;
   protected boolean field_70193_a = false;
   public int field_70191_b = 0;
   protected EntityLiving field_70192_c;
   private int field_70194_h;
   private int field_70195_i = 0;


   public EntityThrowable(World p_i3583_1_) {
      super(p_i3583_1_);
      this.func_70105_a(0.25F, 0.25F);
   }

   protected void func_70088_a() {}

   public boolean func_70112_a(double p_70112_1_) {
      double var3 = this.field_70121_D.func_72320_b() * 4.0D;
      var3 *= 64.0D;
      return p_70112_1_ < var3 * var3;
   }

   public EntityThrowable(World p_i3584_1_, EntityLiving p_i3584_2_) {
      super(p_i3584_1_);
      this.field_70192_c = p_i3584_2_;
      this.func_70105_a(0.25F, 0.25F);
      this.func_70012_b(p_i3584_2_.field_70165_t, p_i3584_2_.field_70163_u + (double)p_i3584_2_.func_70047_e(), p_i3584_2_.field_70161_v, p_i3584_2_.field_70177_z, p_i3584_2_.field_70125_A);
      this.field_70165_t -= (double)(MathHelper.func_76134_b(this.field_70177_z / 180.0F * 3.1415927F) * 0.16F);
      this.field_70163_u -= 0.10000000149011612D;
      this.field_70161_v -= (double)(MathHelper.func_76126_a(this.field_70177_z / 180.0F * 3.1415927F) * 0.16F);
      this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
      this.field_70129_M = 0.0F;
      float var3 = 0.4F;
      this.field_70159_w = (double)(-MathHelper.func_76126_a(this.field_70177_z / 180.0F * 3.1415927F) * MathHelper.func_76134_b(this.field_70125_A / 180.0F * 3.1415927F) * var3);
      this.field_70179_y = (double)(MathHelper.func_76134_b(this.field_70177_z / 180.0F * 3.1415927F) * MathHelper.func_76134_b(this.field_70125_A / 180.0F * 3.1415927F) * var3);
      this.field_70181_x = (double)(-MathHelper.func_76126_a((this.field_70125_A + this.func_70183_g()) / 180.0F * 3.1415927F) * var3);
      this.func_70186_c(this.field_70159_w, this.field_70181_x, this.field_70179_y, this.func_70182_d(), 1.0F);
   }

   public EntityThrowable(World p_i3585_1_, double p_i3585_2_, double p_i3585_4_, double p_i3585_6_) {
      super(p_i3585_1_);
      this.field_70194_h = 0;
      this.func_70105_a(0.25F, 0.25F);
      this.func_70107_b(p_i3585_2_, p_i3585_4_, p_i3585_6_);
      this.field_70129_M = 0.0F;
   }

   protected float func_70182_d() {
      return 1.5F;
   }

   protected float func_70183_g() {
      return 0.0F;
   }

   public void func_70186_c(double p_70186_1_, double p_70186_3_, double p_70186_5_, float p_70186_7_, float p_70186_8_) {
      float var9 = MathHelper.func_76133_a(p_70186_1_ * p_70186_1_ + p_70186_3_ * p_70186_3_ + p_70186_5_ * p_70186_5_);
      p_70186_1_ /= (double)var9;
      p_70186_3_ /= (double)var9;
      p_70186_5_ /= (double)var9;
      p_70186_1_ += this.field_70146_Z.nextGaussian() * 0.007499999832361937D * (double)p_70186_8_;
      p_70186_3_ += this.field_70146_Z.nextGaussian() * 0.007499999832361937D * (double)p_70186_8_;
      p_70186_5_ += this.field_70146_Z.nextGaussian() * 0.007499999832361937D * (double)p_70186_8_;
      p_70186_1_ *= (double)p_70186_7_;
      p_70186_3_ *= (double)p_70186_7_;
      p_70186_5_ *= (double)p_70186_7_;
      this.field_70159_w = p_70186_1_;
      this.field_70181_x = p_70186_3_;
      this.field_70179_y = p_70186_5_;
      float var10 = MathHelper.func_76133_a(p_70186_1_ * p_70186_1_ + p_70186_5_ * p_70186_5_);
      this.field_70126_B = this.field_70177_z = (float)(Math.atan2(p_70186_1_, p_70186_5_) * 180.0D / 3.1415927410125732D);
      this.field_70127_C = this.field_70125_A = (float)(Math.atan2(p_70186_3_, (double)var10) * 180.0D / 3.1415927410125732D);
      this.field_70194_h = 0;
   }

   public void func_70016_h(double p_70016_1_, double p_70016_3_, double p_70016_5_) {
      this.field_70159_w = p_70016_1_;
      this.field_70181_x = p_70016_3_;
      this.field_70179_y = p_70016_5_;
      if(this.field_70127_C == 0.0F && this.field_70126_B == 0.0F) {
         float var7 = MathHelper.func_76133_a(p_70016_1_ * p_70016_1_ + p_70016_5_ * p_70016_5_);
         this.field_70126_B = this.field_70177_z = (float)(Math.atan2(p_70016_1_, p_70016_5_) * 180.0D / 3.1415927410125732D);
         this.field_70127_C = this.field_70125_A = (float)(Math.atan2(p_70016_3_, (double)var7) * 180.0D / 3.1415927410125732D);
      }

   }

   public void func_70071_h_() {
      this.field_70142_S = this.field_70165_t;
      this.field_70137_T = this.field_70163_u;
      this.field_70136_U = this.field_70161_v;
      super.func_70071_h_();
      if(this.field_70191_b > 0) {
         --this.field_70191_b;
      }

      if(this.field_70193_a) {
         int var1 = this.field_70170_p.func_72798_a(this.field_70189_d, this.field_70190_e, this.field_70187_f);
         if(var1 == this.field_70188_g) {
            ++this.field_70194_h;
            if(this.field_70194_h == 1200) {
               this.func_70106_y();
            }

            return;
         }

         this.field_70193_a = false;
         this.field_70159_w *= (double)(this.field_70146_Z.nextFloat() * 0.2F);
         this.field_70181_x *= (double)(this.field_70146_Z.nextFloat() * 0.2F);
         this.field_70179_y *= (double)(this.field_70146_Z.nextFloat() * 0.2F);
         this.field_70194_h = 0;
         this.field_70195_i = 0;
      } else {
         ++this.field_70195_i;
      }

      Vec3 var15 = Vec3.func_72437_a().func_72345_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
      Vec3 var2 = Vec3.func_72437_a().func_72345_a(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
      MovingObjectPosition var3 = this.field_70170_p.func_72933_a(var15, var2);
      var15 = Vec3.func_72437_a().func_72345_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
      var2 = Vec3.func_72437_a().func_72345_a(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
      if(var3 != null) {
         var2 = Vec3.func_72437_a().func_72345_a(var3.field_72307_f.field_72450_a, var3.field_72307_f.field_72448_b, var3.field_72307_f.field_72449_c);
      }

      if(!this.field_70170_p.field_72995_K) {
         Entity var4 = null;
         List var5 = this.field_70170_p.func_72839_b(this, this.field_70121_D.func_72321_a(this.field_70159_w, this.field_70181_x, this.field_70179_y).func_72314_b(1.0D, 1.0D, 1.0D));
         double var6 = 0.0D;
         Iterator var8 = var5.iterator();

         while(var8.hasNext()) {
            Entity var9 = (Entity)var8.next();
            if(var9.func_70067_L() && (var9 != this.field_70192_c || this.field_70195_i >= 5)) {
               float var10 = 0.3F;
               AxisAlignedBB var11 = var9.field_70121_D.func_72314_b((double)var10, (double)var10, (double)var10);
               MovingObjectPosition var12 = var11.func_72327_a(var15, var2);
               if(var12 != null) {
                  double var13 = var15.func_72438_d(var12.field_72307_f);
                  if(var13 < var6 || var6 == 0.0D) {
                     var4 = var9;
                     var6 = var13;
                  }
               }
            }
         }

         if(var4 != null) {
            var3 = new MovingObjectPosition(var4);
         }
      }

      if(var3 != null) {
         this.func_70184_a(var3);
      }

      this.field_70165_t += this.field_70159_w;
      this.field_70163_u += this.field_70181_x;
      this.field_70161_v += this.field_70179_y;
      float var16 = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
      this.field_70177_z = (float)(Math.atan2(this.field_70159_w, this.field_70179_y) * 180.0D / 3.1415927410125732D);

      for(this.field_70125_A = (float)(Math.atan2(this.field_70181_x, (double)var16) * 180.0D / 3.1415927410125732D); this.field_70125_A - this.field_70127_C < -180.0F; this.field_70127_C -= 360.0F) {
         ;
      }

      while(this.field_70125_A - this.field_70127_C >= 180.0F) {
         this.field_70127_C += 360.0F;
      }

      while(this.field_70177_z - this.field_70126_B < -180.0F) {
         this.field_70126_B -= 360.0F;
      }

      while(this.field_70177_z - this.field_70126_B >= 180.0F) {
         this.field_70126_B += 360.0F;
      }

      this.field_70125_A = this.field_70127_C + (this.field_70125_A - this.field_70127_C) * 0.2F;
      this.field_70177_z = this.field_70126_B + (this.field_70177_z - this.field_70126_B) * 0.2F;
      float var17 = 0.99F;
      float var18 = this.func_70185_h();
      if(this.func_70090_H()) {
         for(int var7 = 0; var7 < 4; ++var7) {
            float var19 = 0.25F;
            this.field_70170_p.func_72869_a("bubble", this.field_70165_t - this.field_70159_w * (double)var19, this.field_70163_u - this.field_70181_x * (double)var19, this.field_70161_v - this.field_70179_y * (double)var19, this.field_70159_w, this.field_70181_x, this.field_70179_y);
         }

         var17 = 0.8F;
      }

      this.field_70159_w *= (double)var17;
      this.field_70181_x *= (double)var17;
      this.field_70179_y *= (double)var17;
      this.field_70181_x -= (double)var18;
      this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
   }

   protected float func_70185_h() {
      return 0.03F;
   }

   protected abstract void func_70184_a(MovingObjectPosition var1);

   public void func_70014_b(NBTTagCompound p_70014_1_) {
      p_70014_1_.func_74777_a("xTile", (short)this.field_70189_d);
      p_70014_1_.func_74777_a("yTile", (short)this.field_70190_e);
      p_70014_1_.func_74777_a("zTile", (short)this.field_70187_f);
      p_70014_1_.func_74774_a("inTile", (byte)this.field_70188_g);
      p_70014_1_.func_74774_a("shake", (byte)this.field_70191_b);
      p_70014_1_.func_74774_a("inGround", (byte)(this.field_70193_a?1:0));
   }

   public void func_70037_a(NBTTagCompound p_70037_1_) {
      this.field_70189_d = p_70037_1_.func_74765_d("xTile");
      this.field_70190_e = p_70037_1_.func_74765_d("yTile");
      this.field_70187_f = p_70037_1_.func_74765_d("zTile");
      this.field_70188_g = p_70037_1_.func_74771_c("inTile") & 255;
      this.field_70191_b = p_70037_1_.func_74771_c("shake") & 255;
      this.field_70193_a = p_70037_1_.func_74771_c("inGround") == 1;
   }

   public float func_70053_R() {
      return 0.0F;
   }
}
