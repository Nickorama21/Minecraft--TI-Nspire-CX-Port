package net.minecraft.src;

import java.util.Iterator;
import java.util.List;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.DamageSource;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.MathHelper;
import net.minecraft.src.MovingObjectPosition;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.NBTTagDouble;
import net.minecraft.src.NBTTagList;
import net.minecraft.src.Vec3;
import net.minecraft.src.World;

public class EntityFireball extends Entity {

   private int field_70231_e = -1;
   private int field_70228_f = -1;
   private int field_70229_g = -1;
   private int field_70237_h = 0;
   private boolean field_70238_i = false;
   public EntityLiving field_70235_a;
   private int field_70236_j;
   private int field_70234_an = 0;
   public double field_70232_b;
   public double field_70233_c;
   public double field_70230_d;


   public EntityFireball(World p_i3571_1_) {
      super(p_i3571_1_);
      this.func_70105_a(1.0F, 1.0F);
   }

   protected void func_70088_a() {}

   public EntityFireball(World p_i3572_1_, double p_i3572_2_, double p_i3572_4_, double p_i3572_6_, double p_i3572_8_, double p_i3572_10_, double p_i3572_12_) {
      super(p_i3572_1_);
      this.func_70105_a(1.0F, 1.0F);
      this.func_70012_b(p_i3572_2_, p_i3572_4_, p_i3572_6_, this.field_70177_z, this.field_70125_A);
      this.func_70107_b(p_i3572_2_, p_i3572_4_, p_i3572_6_);
      double var14 = (double)MathHelper.func_76133_a(p_i3572_8_ * p_i3572_8_ + p_i3572_10_ * p_i3572_10_ + p_i3572_12_ * p_i3572_12_);
      this.field_70232_b = p_i3572_8_ / var14 * 0.1D;
      this.field_70233_c = p_i3572_10_ / var14 * 0.1D;
      this.field_70230_d = p_i3572_12_ / var14 * 0.1D;
   }

   public EntityFireball(World p_i3573_1_, EntityLiving p_i3573_2_, double p_i3573_3_, double p_i3573_5_, double p_i3573_7_) {
      super(p_i3573_1_);
      this.field_70235_a = p_i3573_2_;
      this.func_70105_a(1.0F, 1.0F);
      this.func_70012_b(p_i3573_2_.field_70165_t, p_i3573_2_.field_70163_u, p_i3573_2_.field_70161_v, p_i3573_2_.field_70177_z, p_i3573_2_.field_70125_A);
      this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
      this.field_70129_M = 0.0F;
      this.field_70159_w = this.field_70181_x = this.field_70179_y = 0.0D;
      p_i3573_3_ += this.field_70146_Z.nextGaussian() * 0.4D;
      p_i3573_5_ += this.field_70146_Z.nextGaussian() * 0.4D;
      p_i3573_7_ += this.field_70146_Z.nextGaussian() * 0.4D;
      double var9 = (double)MathHelper.func_76133_a(p_i3573_3_ * p_i3573_3_ + p_i3573_5_ * p_i3573_5_ + p_i3573_7_ * p_i3573_7_);
      this.field_70232_b = p_i3573_3_ / var9 * 0.1D;
      this.field_70233_c = p_i3573_5_ / var9 * 0.1D;
      this.field_70230_d = p_i3573_7_ / var9 * 0.1D;
   }

   public void func_70071_h_() {
      if(!this.field_70170_p.field_72995_K && (this.field_70235_a != null && this.field_70235_a.field_70128_L || !this.field_70170_p.func_72899_e((int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v))) {
         this.func_70106_y();
      } else {
         super.func_70071_h_();
         this.func_70015_d(1);
         if(this.field_70238_i) {
            int var1 = this.field_70170_p.func_72798_a(this.field_70231_e, this.field_70228_f, this.field_70229_g);
            if(var1 == this.field_70237_h) {
               ++this.field_70236_j;
               if(this.field_70236_j == 600) {
                  this.func_70106_y();
               }

               return;
            }

            this.field_70238_i = false;
            this.field_70159_w *= (double)(this.field_70146_Z.nextFloat() * 0.2F);
            this.field_70181_x *= (double)(this.field_70146_Z.nextFloat() * 0.2F);
            this.field_70179_y *= (double)(this.field_70146_Z.nextFloat() * 0.2F);
            this.field_70236_j = 0;
            this.field_70234_an = 0;
         } else {
            ++this.field_70234_an;
         }

         Vec3 var15 = Vec3.func_72437_a().func_72345_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
         Vec3 var2 = Vec3.func_72437_a().func_72345_a(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
         MovingObjectPosition var3 = this.field_70170_p.func_72933_a(var15, var2);
         var15 = Vec3.func_72437_a().func_72345_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
         var2 = Vec3.func_72437_a().func_72345_a(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
         if(var3 != null) {
            var2 = Vec3.func_72437_a().func_72345_a(var3.field_72307_f.field_72450_a, var3.field_72307_f.field_72448_b, var3.field_72307_f.field_72449_c);
         }

         Entity var4 = null;
         List var5 = this.field_70170_p.func_72839_b(this, this.field_70121_D.func_72321_a(this.field_70159_w, this.field_70181_x, this.field_70179_y).func_72314_b(1.0D, 1.0D, 1.0D));
         double var6 = 0.0D;
         Iterator var8 = var5.iterator();

         while(var8.hasNext()) {
            Entity var9 = (Entity)var8.next();
            if(var9.func_70067_L() && (!var9.func_70028_i(this.field_70235_a) || this.field_70234_an >= 25)) {
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

         if(var3 != null) {
            this.func_70227_a(var3);
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
         float var17 = 0.95F;
         if(this.func_70090_H()) {
            for(int var19 = 0; var19 < 4; ++var19) {
               float var18 = 0.25F;
               this.field_70170_p.func_72869_a("bubble", this.field_70165_t - this.field_70159_w * (double)var18, this.field_70163_u - this.field_70181_x * (double)var18, this.field_70161_v - this.field_70179_y * (double)var18, this.field_70159_w, this.field_70181_x, this.field_70179_y);
            }

            var17 = 0.8F;
         }

         this.field_70159_w += this.field_70232_b;
         this.field_70181_x += this.field_70233_c;
         this.field_70179_y += this.field_70230_d;
         this.field_70159_w *= (double)var17;
         this.field_70181_x *= (double)var17;
         this.field_70179_y *= (double)var17;
         this.field_70170_p.func_72869_a("smoke", this.field_70165_t, this.field_70163_u + 0.5D, this.field_70161_v, 0.0D, 0.0D, 0.0D);
         this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
      }
   }

   protected void func_70227_a(MovingObjectPosition p_70227_1_) {
      if(!this.field_70170_p.field_72995_K) {
         if(p_70227_1_.field_72308_g != null) {
            p_70227_1_.field_72308_g.func_70097_a(DamageSource.func_76362_a(this, this.field_70235_a), 6);
         }

         this.field_70170_p.func_72885_a((Entity)null, this.field_70165_t, this.field_70163_u, this.field_70161_v, 1.0F, true);
         this.func_70106_y();
      }

   }

   public void func_70014_b(NBTTagCompound p_70014_1_) {
      p_70014_1_.func_74777_a("xTile", (short)this.field_70231_e);
      p_70014_1_.func_74777_a("yTile", (short)this.field_70228_f);
      p_70014_1_.func_74777_a("zTile", (short)this.field_70229_g);
      p_70014_1_.func_74774_a("inTile", (byte)this.field_70237_h);
      p_70014_1_.func_74774_a("inGround", (byte)(this.field_70238_i?1:0));
      p_70014_1_.func_74782_a("direction", this.func_70087_a(new double[]{this.field_70159_w, this.field_70181_x, this.field_70179_y}));
   }

   public void func_70037_a(NBTTagCompound p_70037_1_) {
      this.field_70231_e = p_70037_1_.func_74765_d("xTile");
      this.field_70228_f = p_70037_1_.func_74765_d("yTile");
      this.field_70229_g = p_70037_1_.func_74765_d("zTile");
      this.field_70237_h = p_70037_1_.func_74771_c("inTile") & 255;
      this.field_70238_i = p_70037_1_.func_74771_c("inGround") == 1;
      if(p_70037_1_.func_74764_b("direction")) {
         NBTTagList var2 = p_70037_1_.func_74761_m("direction");
         this.field_70159_w = ((NBTTagDouble)var2.func_74743_b(0)).field_74755_a;
         this.field_70181_x = ((NBTTagDouble)var2.func_74743_b(1)).field_74755_a;
         this.field_70179_y = ((NBTTagDouble)var2.func_74743_b(2)).field_74755_a;
      } else {
         this.func_70106_y();
      }

   }

   public boolean func_70067_L() {
      return true;
   }

   public float func_70111_Y() {
      return 1.0F;
   }

   public boolean func_70097_a(DamageSource p_70097_1_, int p_70097_2_) {
      this.func_70018_K();
      if(p_70097_1_.func_76346_g() != null) {
         Vec3 var3 = p_70097_1_.func_76346_g().func_70040_Z();
         if(var3 != null) {
            this.field_70159_w = var3.field_72450_a;
            this.field_70181_x = var3.field_72448_b;
            this.field_70179_y = var3.field_72449_c;
            this.field_70232_b = this.field_70159_w * 0.1D;
            this.field_70233_c = this.field_70181_x * 0.1D;
            this.field_70230_d = this.field_70179_y * 0.1D;
         }

         if(p_70097_1_.func_76346_g() instanceof EntityLiving) {
            this.field_70235_a = (EntityLiving)p_70097_1_.func_76346_g();
         }

         return true;
      } else {
         return false;
      }
   }

   public float func_70013_c(float p_70013_1_) {
      return 1.0F;
   }
}
