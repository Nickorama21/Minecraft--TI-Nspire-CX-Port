package net.minecraft.src;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.BlockFluid;
import net.minecraft.src.DamageSource;
import net.minecraft.src.DataWatcher;
import net.minecraft.src.EntityItem;
import net.minecraft.src.EntityLightningBolt;
import net.minecraft.src.EntityList;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EnumEntitySize;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.MathHelper;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.NBTTagDouble;
import net.minecraft.src.NBTTagFloat;
import net.minecraft.src.NBTTagList;
import net.minecraft.src.StatCollector;
import net.minecraft.src.StepSound;
import net.minecraft.src.Vec3;
import net.minecraft.src.World;

public abstract class Entity {

   private static int field_70152_a = 0;
   public int field_70157_k;
   public double field_70155_l;
   public boolean field_70156_m;
   public Entity field_70153_n;
   public Entity field_70154_o;
   public World field_70170_p;
   public double field_70169_q;
   public double field_70167_r;
   public double field_70166_s;
   public double field_70165_t;
   public double field_70163_u;
   public double field_70161_v;
   public double field_70159_w;
   public double field_70181_x;
   public double field_70179_y;
   public float field_70177_z;
   public float field_70125_A;
   public float field_70126_B;
   public float field_70127_C;
   public final AxisAlignedBB field_70121_D;
   public boolean field_70122_E;
   public boolean field_70123_F;
   public boolean field_70124_G;
   public boolean field_70132_H;
   public boolean field_70133_I;
   protected boolean field_70134_J;
   public boolean field_70135_K;
   public boolean field_70128_L;
   public float field_70129_M;
   public float field_70130_N;
   public float field_70131_O;
   public float field_70141_P;
   public float field_70140_Q;
   public float field_70143_R;
   private int field_70150_b;
   public double field_70142_S;
   public double field_70137_T;
   public double field_70136_U;
   public float field_70139_V;
   public float field_70138_W;
   public boolean field_70145_X;
   public float field_70144_Y;
   protected Random field_70146_Z;
   public int field_70173_aa;
   public int field_70174_ab;
   private int field_70151_c;
   protected boolean field_70171_ac;
   public int field_70172_ad;
   private boolean field_70148_d;
   protected boolean field_70178_ae;
   protected DataWatcher field_70180_af;
   private double field_70149_e;
   private double field_70147_f;
   public boolean field_70175_ag;
   public int field_70176_ah;
   public int field_70162_ai;
   public int field_70164_aj;
   public boolean field_70158_ak;
   public boolean field_70160_al;
   public EnumEntitySize field_70168_am;


   public Entity(World p_i3438_1_) {
      this.field_70157_k = field_70152_a++;
      this.field_70155_l = 1.0D;
      this.field_70156_m = false;
      this.field_70121_D = AxisAlignedBB.func_72330_a(0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D);
      this.field_70122_E = false;
      this.field_70132_H = false;
      this.field_70133_I = false;
      this.field_70135_K = true;
      this.field_70128_L = false;
      this.field_70129_M = 0.0F;
      this.field_70130_N = 0.6F;
      this.field_70131_O = 1.8F;
      this.field_70141_P = 0.0F;
      this.field_70140_Q = 0.0F;
      this.field_70143_R = 0.0F;
      this.field_70150_b = 1;
      this.field_70139_V = 0.0F;
      this.field_70138_W = 0.0F;
      this.field_70145_X = false;
      this.field_70144_Y = 0.0F;
      this.field_70146_Z = new Random();
      this.field_70173_aa = 0;
      this.field_70174_ab = 1;
      this.field_70151_c = 0;
      this.field_70171_ac = false;
      this.field_70172_ad = 0;
      this.field_70148_d = true;
      this.field_70178_ae = false;
      this.field_70180_af = new DataWatcher();
      this.field_70175_ag = false;
      this.field_70168_am = EnumEntitySize.SIZE_2;
      this.field_70170_p = p_i3438_1_;
      this.func_70107_b(0.0D, 0.0D, 0.0D);
      this.field_70180_af.func_75682_a(0, Byte.valueOf((byte)0));
      this.field_70180_af.func_75682_a(1, Short.valueOf((short)300));
      this.func_70088_a();
   }

   protected abstract void func_70088_a();

   public DataWatcher func_70096_w() {
      return this.field_70180_af;
   }

   public boolean equals(Object p_equals_1_) {
      return p_equals_1_ instanceof Entity?((Entity)p_equals_1_).field_70157_k == this.field_70157_k:false;
   }

   public int hashCode() {
      return this.field_70157_k;
   }

   public void func_70106_y() {
      this.field_70128_L = true;
   }

   protected void func_70105_a(float p_70105_1_, float p_70105_2_) {
      this.field_70130_N = p_70105_1_;
      this.field_70131_O = p_70105_2_;
      float var3 = p_70105_1_ % 2.0F;
      if((double)var3 < 0.375D) {
         this.field_70168_am = EnumEntitySize.SIZE_1;
      } else if((double)var3 < 0.75D) {
         this.field_70168_am = EnumEntitySize.SIZE_2;
      } else if((double)var3 < 1.0D) {
         this.field_70168_am = EnumEntitySize.SIZE_3;
      } else if((double)var3 < 1.375D) {
         this.field_70168_am = EnumEntitySize.SIZE_4;
      } else if((double)var3 < 1.75D) {
         this.field_70168_am = EnumEntitySize.SIZE_5;
      } else {
         this.field_70168_am = EnumEntitySize.SIZE_6;
      }

   }

   protected void func_70101_b(float p_70101_1_, float p_70101_2_) {
      this.field_70177_z = p_70101_1_ % 360.0F;
      this.field_70125_A = p_70101_2_ % 360.0F;
   }

   public void func_70107_b(double p_70107_1_, double p_70107_3_, double p_70107_5_) {
      this.field_70165_t = p_70107_1_;
      this.field_70163_u = p_70107_3_;
      this.field_70161_v = p_70107_5_;
      float var7 = this.field_70130_N / 2.0F;
      float var8 = this.field_70131_O;
      this.field_70121_D.func_72324_b(p_70107_1_ - (double)var7, p_70107_3_ - (double)this.field_70129_M + (double)this.field_70139_V, p_70107_5_ - (double)var7, p_70107_1_ + (double)var7, p_70107_3_ - (double)this.field_70129_M + (double)this.field_70139_V + (double)var8, p_70107_5_ + (double)var7);
   }

   public void func_70071_h_() {
      this.func_70030_z();
   }

   public void func_70030_z() {
      this.field_70170_p.field_72984_F.func_76320_a("entityBaseTick");
      if(this.field_70154_o != null && this.field_70154_o.field_70128_L) {
         this.field_70154_o = null;
      }

      ++this.field_70173_aa;
      this.field_70141_P = this.field_70140_Q;
      this.field_70169_q = this.field_70165_t;
      this.field_70167_r = this.field_70163_u;
      this.field_70166_s = this.field_70161_v;
      this.field_70127_C = this.field_70125_A;
      this.field_70126_B = this.field_70177_z;
      int var3;
      if(this.func_70051_ag() && !this.func_70090_H()) {
         int var1 = MathHelper.func_76128_c(this.field_70165_t);
         int var2 = MathHelper.func_76128_c(this.field_70163_u - 0.20000000298023224D - (double)this.field_70129_M);
         var3 = MathHelper.func_76128_c(this.field_70161_v);
         int var4 = this.field_70170_p.func_72798_a(var1, var2, var3);
         if(var4 > 0) {
            this.field_70170_p.func_72869_a("tilecrack_" + var4, this.field_70165_t + ((double)this.field_70146_Z.nextFloat() - 0.5D) * (double)this.field_70130_N, this.field_70121_D.field_72338_b + 0.1D, this.field_70161_v + ((double)this.field_70146_Z.nextFloat() - 0.5D) * (double)this.field_70130_N, -this.field_70159_w * 4.0D, 1.5D, -this.field_70179_y * 4.0D);
         }
      }

      if(this.func_70072_I()) {
         if(!this.field_70171_ac && !this.field_70148_d) {
            float var6 = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w * 0.20000000298023224D + this.field_70181_x * this.field_70181_x + this.field_70179_y * this.field_70179_y * 0.20000000298023224D) * 0.2F;
            if(var6 > 1.0F) {
               var6 = 1.0F;
            }

            this.field_70170_p.func_72956_a(this, "random.splash", var6, 1.0F + (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.4F);
            float var7 = (float)MathHelper.func_76128_c(this.field_70121_D.field_72338_b);

            float var5;
            float var8;
            for(var3 = 0; (float)var3 < 1.0F + this.field_70130_N * 20.0F; ++var3) {
               var8 = (this.field_70146_Z.nextFloat() * 2.0F - 1.0F) * this.field_70130_N;
               var5 = (this.field_70146_Z.nextFloat() * 2.0F - 1.0F) * this.field_70130_N;
               this.field_70170_p.func_72869_a("bubble", this.field_70165_t + (double)var8, (double)(var7 + 1.0F), this.field_70161_v + (double)var5, this.field_70159_w, this.field_70181_x - (double)(this.field_70146_Z.nextFloat() * 0.2F), this.field_70179_y);
            }

            for(var3 = 0; (float)var3 < 1.0F + this.field_70130_N * 20.0F; ++var3) {
               var8 = (this.field_70146_Z.nextFloat() * 2.0F - 1.0F) * this.field_70130_N;
               var5 = (this.field_70146_Z.nextFloat() * 2.0F - 1.0F) * this.field_70130_N;
               this.field_70170_p.func_72869_a("splash", this.field_70165_t + (double)var8, (double)(var7 + 1.0F), this.field_70161_v + (double)var5, this.field_70159_w, this.field_70181_x, this.field_70179_y);
            }
         }

         this.field_70143_R = 0.0F;
         this.field_70171_ac = true;
         this.field_70151_c = 0;
      } else {
         this.field_70171_ac = false;
      }

      if(this.field_70170_p.field_72995_K) {
         this.field_70151_c = 0;
      } else if(this.field_70151_c > 0) {
         if(this.field_70178_ae) {
            this.field_70151_c -= 4;
            if(this.field_70151_c < 0) {
               this.field_70151_c = 0;
            }
         } else {
            if(this.field_70151_c % 20 == 0) {
               this.func_70097_a(DamageSource.field_76370_b, 1);
            }

            --this.field_70151_c;
         }
      }

      if(this.func_70058_J()) {
         this.func_70044_A();
         this.field_70143_R *= 0.5F;
      }

      if(this.field_70163_u < -64.0D) {
         this.func_70076_C();
      }

      if(!this.field_70170_p.field_72995_K) {
         this.func_70052_a(0, this.field_70151_c > 0);
         this.func_70052_a(2, this.field_70154_o != null);
      }

      this.field_70148_d = false;
      this.field_70170_p.field_72984_F.func_76319_b();
   }

   protected void func_70044_A() {
      if(!this.field_70178_ae) {
         this.func_70097_a(DamageSource.field_76371_c, 4);
         this.func_70015_d(15);
      }

   }

   public void func_70015_d(int p_70015_1_) {
      int var2 = p_70015_1_ * 20;
      if(this.field_70151_c < var2) {
         this.field_70151_c = var2;
      }

   }

   public void func_70066_B() {
      this.field_70151_c = 0;
   }

   protected void func_70076_C() {
      this.func_70106_y();
   }

   public boolean func_70038_c(double p_70038_1_, double p_70038_3_, double p_70038_5_) {
      AxisAlignedBB var7 = this.field_70121_D.func_72325_c(p_70038_1_, p_70038_3_, p_70038_5_);
      List var8 = this.field_70170_p.func_72945_a(this, var7);
      return !var8.isEmpty()?false:!this.field_70170_p.func_72953_d(var7);
   }

   public void func_70091_d(double p_70091_1_, double p_70091_3_, double p_70091_5_) {
      if(this.field_70145_X) {
         this.field_70121_D.func_72317_d(p_70091_1_, p_70091_3_, p_70091_5_);
         this.field_70165_t = (this.field_70121_D.field_72340_a + this.field_70121_D.field_72336_d) / 2.0D;
         this.field_70163_u = this.field_70121_D.field_72338_b + (double)this.field_70129_M - (double)this.field_70139_V;
         this.field_70161_v = (this.field_70121_D.field_72339_c + this.field_70121_D.field_72334_f) / 2.0D;
      } else {
         this.field_70170_p.field_72984_F.func_76320_a("move");
         this.field_70139_V *= 0.4F;
         double var7 = this.field_70165_t;
         double var9 = this.field_70161_v;
         if(this.field_70134_J) {
            this.field_70134_J = false;
            p_70091_1_ *= 0.25D;
            p_70091_3_ *= 0.05000000074505806D;
            p_70091_5_ *= 0.25D;
            this.field_70159_w = 0.0D;
            this.field_70181_x = 0.0D;
            this.field_70179_y = 0.0D;
         }

         double var11 = p_70091_1_;
         double var13 = p_70091_3_;
         double var15 = p_70091_5_;
         AxisAlignedBB var17 = this.field_70121_D.func_72329_c();
         boolean var18 = this.field_70122_E && this.func_70093_af() && this instanceof EntityPlayer;
         if(var18) {
            double var19;
            for(var19 = 0.05D; p_70091_1_ != 0.0D && this.field_70170_p.func_72945_a(this, this.field_70121_D.func_72325_c(p_70091_1_, -1.0D, 0.0D)).isEmpty(); var11 = p_70091_1_) {
               if(p_70091_1_ < var19 && p_70091_1_ >= -var19) {
                  p_70091_1_ = 0.0D;
               } else if(p_70091_1_ > 0.0D) {
                  p_70091_1_ -= var19;
               } else {
                  p_70091_1_ += var19;
               }
            }

            for(; p_70091_5_ != 0.0D && this.field_70170_p.func_72945_a(this, this.field_70121_D.func_72325_c(0.0D, -1.0D, p_70091_5_)).isEmpty(); var15 = p_70091_5_) {
               if(p_70091_5_ < var19 && p_70091_5_ >= -var19) {
                  p_70091_5_ = 0.0D;
               } else if(p_70091_5_ > 0.0D) {
                  p_70091_5_ -= var19;
               } else {
                  p_70091_5_ += var19;
               }
            }

            while(p_70091_1_ != 0.0D && p_70091_5_ != 0.0D && this.field_70170_p.func_72945_a(this, this.field_70121_D.func_72325_c(p_70091_1_, -1.0D, p_70091_5_)).isEmpty()) {
               if(p_70091_1_ < var19 && p_70091_1_ >= -var19) {
                  p_70091_1_ = 0.0D;
               } else if(p_70091_1_ > 0.0D) {
                  p_70091_1_ -= var19;
               } else {
                  p_70091_1_ += var19;
               }

               if(p_70091_5_ < var19 && p_70091_5_ >= -var19) {
                  p_70091_5_ = 0.0D;
               } else if(p_70091_5_ > 0.0D) {
                  p_70091_5_ -= var19;
               } else {
                  p_70091_5_ += var19;
               }

               var11 = p_70091_1_;
               var15 = p_70091_5_;
            }
         }

         List var30 = this.field_70170_p.func_72945_a(this, this.field_70121_D.func_72321_a(p_70091_1_, p_70091_3_, p_70091_5_));

         AxisAlignedBB var21;
         for(Iterator var20 = var30.iterator(); var20.hasNext(); p_70091_3_ = var21.func_72323_b(this.field_70121_D, p_70091_3_)) {
            var21 = (AxisAlignedBB)var20.next();
         }

         this.field_70121_D.func_72317_d(0.0D, p_70091_3_, 0.0D);
         if(!this.field_70135_K && var13 != p_70091_3_) {
            p_70091_5_ = 0.0D;
            p_70091_3_ = 0.0D;
            p_70091_1_ = 0.0D;
         }

         boolean var31 = this.field_70122_E || var13 != p_70091_3_ && var13 < 0.0D;

         AxisAlignedBB var22;
         Iterator var32;
         for(var32 = var30.iterator(); var32.hasNext(); p_70091_1_ = var22.func_72316_a(this.field_70121_D, p_70091_1_)) {
            var22 = (AxisAlignedBB)var32.next();
         }

         this.field_70121_D.func_72317_d(p_70091_1_, 0.0D, 0.0D);
         if(!this.field_70135_K && var11 != p_70091_1_) {
            p_70091_5_ = 0.0D;
            p_70091_3_ = 0.0D;
            p_70091_1_ = 0.0D;
         }

         for(var32 = var30.iterator(); var32.hasNext(); p_70091_5_ = var22.func_72322_c(this.field_70121_D, p_70091_5_)) {
            var22 = (AxisAlignedBB)var32.next();
         }

         this.field_70121_D.func_72317_d(0.0D, 0.0D, p_70091_5_);
         if(!this.field_70135_K && var15 != p_70091_5_) {
            p_70091_5_ = 0.0D;
            p_70091_3_ = 0.0D;
            p_70091_1_ = 0.0D;
         }

         double var23;
         double var33;
         if(this.field_70138_W > 0.0F && var31 && (var18 || this.field_70139_V < 0.05F) && (var11 != p_70091_1_ || var15 != p_70091_5_)) {
            var33 = p_70091_1_;
            var23 = p_70091_3_;
            double var25 = p_70091_5_;
            p_70091_1_ = var11;
            p_70091_3_ = (double)this.field_70138_W;
            p_70091_5_ = var15;
            AxisAlignedBB var27 = this.field_70121_D.func_72329_c();
            this.field_70121_D.func_72328_c(var17);
            var30 = this.field_70170_p.func_72945_a(this, this.field_70121_D.func_72321_a(var11, p_70091_3_, var15));

            AxisAlignedBB var29;
            Iterator var28;
            for(var28 = var30.iterator(); var28.hasNext(); p_70091_3_ = var29.func_72323_b(this.field_70121_D, p_70091_3_)) {
               var29 = (AxisAlignedBB)var28.next();
            }

            this.field_70121_D.func_72317_d(0.0D, p_70091_3_, 0.0D);
            if(!this.field_70135_K && var13 != p_70091_3_) {
               p_70091_5_ = 0.0D;
               p_70091_3_ = 0.0D;
               p_70091_1_ = 0.0D;
            }

            for(var28 = var30.iterator(); var28.hasNext(); p_70091_1_ = var29.func_72316_a(this.field_70121_D, p_70091_1_)) {
               var29 = (AxisAlignedBB)var28.next();
            }

            this.field_70121_D.func_72317_d(p_70091_1_, 0.0D, 0.0D);
            if(!this.field_70135_K && var11 != p_70091_1_) {
               p_70091_5_ = 0.0D;
               p_70091_3_ = 0.0D;
               p_70091_1_ = 0.0D;
            }

            for(var28 = var30.iterator(); var28.hasNext(); p_70091_5_ = var29.func_72322_c(this.field_70121_D, p_70091_5_)) {
               var29 = (AxisAlignedBB)var28.next();
            }

            this.field_70121_D.func_72317_d(0.0D, 0.0D, p_70091_5_);
            if(!this.field_70135_K && var15 != p_70091_5_) {
               p_70091_5_ = 0.0D;
               p_70091_3_ = 0.0D;
               p_70091_1_ = 0.0D;
            }

            if(!this.field_70135_K && var13 != p_70091_3_) {
               p_70091_5_ = 0.0D;
               p_70091_3_ = 0.0D;
               p_70091_1_ = 0.0D;
            } else {
               p_70091_3_ = (double)(-this.field_70138_W);

               for(var28 = var30.iterator(); var28.hasNext(); p_70091_3_ = var29.func_72323_b(this.field_70121_D, p_70091_3_)) {
                  var29 = (AxisAlignedBB)var28.next();
               }

               this.field_70121_D.func_72317_d(0.0D, p_70091_3_, 0.0D);
            }

            if(var33 * var33 + var25 * var25 >= p_70091_1_ * p_70091_1_ + p_70091_5_ * p_70091_5_) {
               p_70091_1_ = var33;
               p_70091_3_ = var23;
               p_70091_5_ = var25;
               this.field_70121_D.func_72328_c(var27);
            } else {
               double var37 = this.field_70121_D.field_72338_b - (double)((int)this.field_70121_D.field_72338_b);
               if(var37 > 0.0D) {
                  this.field_70139_V = (float)((double)this.field_70139_V + var37 + 0.01D);
               }
            }
         }

         this.field_70170_p.field_72984_F.func_76319_b();
         this.field_70170_p.field_72984_F.func_76320_a("rest");
         this.field_70165_t = (this.field_70121_D.field_72340_a + this.field_70121_D.field_72336_d) / 2.0D;
         this.field_70163_u = this.field_70121_D.field_72338_b + (double)this.field_70129_M - (double)this.field_70139_V;
         this.field_70161_v = (this.field_70121_D.field_72339_c + this.field_70121_D.field_72334_f) / 2.0D;
         this.field_70123_F = var11 != p_70091_1_ || var15 != p_70091_5_;
         this.field_70124_G = var13 != p_70091_3_;
         this.field_70122_E = var13 != p_70091_3_ && var13 < 0.0D;
         this.field_70132_H = this.field_70123_F || this.field_70124_G;
         this.func_70064_a(p_70091_3_, this.field_70122_E);
         if(var11 != p_70091_1_) {
            this.field_70159_w = 0.0D;
         }

         if(var13 != p_70091_3_) {
            this.field_70181_x = 0.0D;
         }

         if(var15 != p_70091_5_) {
            this.field_70179_y = 0.0D;
         }

         var33 = this.field_70165_t - var7;
         var23 = this.field_70161_v - var9;
         if(this.func_70041_e_() && !var18 && this.field_70154_o == null) {
            this.field_70140_Q = (float)((double)this.field_70140_Q + (double)MathHelper.func_76133_a(var33 * var33 + var23 * var23) * 0.6D);
            int var34 = MathHelper.func_76128_c(this.field_70165_t);
            int var26 = MathHelper.func_76128_c(this.field_70163_u - 0.20000000298023224D - (double)this.field_70129_M);
            int var36 = MathHelper.func_76128_c(this.field_70161_v);
            int var38 = this.field_70170_p.func_72798_a(var34, var26, var36);
            if(var38 == 0 && this.field_70170_p.func_72798_a(var34, var26 - 1, var36) == Block.field_72031_aZ.field_71990_ca) {
               var38 = this.field_70170_p.func_72798_a(var34, var26 - 1, var36);
            }

            if(this.field_70140_Q > (float)this.field_70150_b && var38 > 0) {
               this.field_70150_b = (int)this.field_70140_Q + 1;
               this.func_70036_a(var34, var26, var36, var38);
               Block.field_71973_m[var38].func_71891_b(this.field_70170_p, var34, var26, var36, this);
            }
         }

         this.func_70017_D();
         boolean var35 = this.func_70026_G();
         if(this.field_70170_p.func_72978_e(this.field_70121_D.func_72331_e(0.0010D, 0.0010D, 0.0010D))) {
            this.func_70081_e(1);
            if(!var35) {
               ++this.field_70151_c;
               if(this.field_70151_c == 0) {
                  this.func_70015_d(8);
               }
            }
         } else if(this.field_70151_c <= 0) {
            this.field_70151_c = -this.field_70174_ab;
         }

         if(var35 && this.field_70151_c > 0) {
            this.field_70170_p.func_72956_a(this, "random.fizz", 0.7F, 1.6F + (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.4F);
            this.field_70151_c = -this.field_70174_ab;
         }

         this.field_70170_p.field_72984_F.func_76319_b();
      }
   }

   protected void func_70017_D() {
      int var1 = MathHelper.func_76128_c(this.field_70121_D.field_72340_a + 0.0010D);
      int var2 = MathHelper.func_76128_c(this.field_70121_D.field_72338_b + 0.0010D);
      int var3 = MathHelper.func_76128_c(this.field_70121_D.field_72339_c + 0.0010D);
      int var4 = MathHelper.func_76128_c(this.field_70121_D.field_72336_d - 0.0010D);
      int var5 = MathHelper.func_76128_c(this.field_70121_D.field_72337_e - 0.0010D);
      int var6 = MathHelper.func_76128_c(this.field_70121_D.field_72334_f - 0.0010D);
      if(this.field_70170_p.func_72904_c(var1, var2, var3, var4, var5, var6)) {
         for(int var7 = var1; var7 <= var4; ++var7) {
            for(int var8 = var2; var8 <= var5; ++var8) {
               for(int var9 = var3; var9 <= var6; ++var9) {
                  int var10 = this.field_70170_p.func_72798_a(var7, var8, var9);
                  if(var10 > 0) {
                     Block.field_71973_m[var10].func_71869_a(this.field_70170_p, var7, var8, var9, this);
                  }
               }
            }
         }
      }

   }

   protected void func_70036_a(int p_70036_1_, int p_70036_2_, int p_70036_3_, int p_70036_4_) {
      StepSound var5 = Block.field_71973_m[p_70036_4_].field_72020_cn;
      if(this.field_70170_p.func_72798_a(p_70036_1_, p_70036_2_ + 1, p_70036_3_) == Block.field_72037_aS.field_71990_ca) {
         var5 = Block.field_72037_aS.field_72020_cn;
         this.field_70170_p.func_72956_a(this, var5.func_72675_d(), var5.func_72677_b() * 0.15F, var5.func_72678_c());
      } else if(!Block.field_71973_m[p_70036_4_].field_72018_cp.func_76224_d()) {
         this.field_70170_p.func_72956_a(this, var5.func_72675_d(), var5.func_72677_b() * 0.15F, var5.func_72678_c());
      }

   }

   protected boolean func_70041_e_() {
      return true;
   }

   protected void func_70064_a(double p_70064_1_, boolean p_70064_3_) {
      if(p_70064_3_) {
         if(this.field_70143_R > 0.0F) {
            if(this instanceof EntityLiving) {
               int var4 = MathHelper.func_76128_c(this.field_70165_t);
               int var5 = MathHelper.func_76128_c(this.field_70163_u - 0.20000000298023224D - (double)this.field_70129_M);
               int var6 = MathHelper.func_76128_c(this.field_70161_v);
               int var7 = this.field_70170_p.func_72798_a(var4, var5, var6);
               if(var7 == 0 && this.field_70170_p.func_72798_a(var4, var5 - 1, var6) == Block.field_72031_aZ.field_71990_ca) {
                  var7 = this.field_70170_p.func_72798_a(var4, var5 - 1, var6);
               }

               if(var7 > 0) {
                  Block.field_71973_m[var7].func_71866_a(this.field_70170_p, var4, var5, var6, this, this.field_70143_R);
               }
            }

            this.func_70069_a(this.field_70143_R);
            this.field_70143_R = 0.0F;
         }
      } else if(p_70064_1_ < 0.0D) {
         this.field_70143_R = (float)((double)this.field_70143_R - p_70064_1_);
      }

   }

   public AxisAlignedBB func_70046_E() {
      return null;
   }

   protected void func_70081_e(int p_70081_1_) {
      if(!this.field_70178_ae) {
         this.func_70097_a(DamageSource.field_76372_a, p_70081_1_);
      }

   }

   public final boolean func_70045_F() {
      return this.field_70178_ae;
   }

   protected void func_70069_a(float p_70069_1_) {
      if(this.field_70153_n != null) {
         this.field_70153_n.func_70069_a(p_70069_1_);
      }

   }

   public boolean func_70026_G() {
      return this.field_70171_ac || this.field_70170_p.func_72951_B(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70163_u), MathHelper.func_76128_c(this.field_70161_v));
   }

   public boolean func_70090_H() {
      return this.field_70171_ac;
   }

   public boolean func_70072_I() {
      return this.field_70170_p.func_72918_a(this.field_70121_D.func_72314_b(0.0D, -0.4000000059604645D, 0.0D).func_72331_e(0.0010D, 0.0010D, 0.0010D), Material.field_76244_g, this);
   }

   public boolean func_70055_a(Material p_70055_1_) {
      double var2 = this.field_70163_u + (double)this.func_70047_e();
      int var4 = MathHelper.func_76128_c(this.field_70165_t);
      int var5 = MathHelper.func_76141_d((float)MathHelper.func_76128_c(var2));
      int var6 = MathHelper.func_76128_c(this.field_70161_v);
      int var7 = this.field_70170_p.func_72798_a(var4, var5, var6);
      if(var7 != 0 && Block.field_71973_m[var7].field_72018_cp == p_70055_1_) {
         float var8 = BlockFluid.func_72199_d(this.field_70170_p.func_72805_g(var4, var5, var6)) - 0.11111111F;
         float var9 = (float)(var5 + 1) - var8;
         return var2 < (double)var9;
      } else {
         return false;
      }
   }

   public float func_70047_e() {
      return 0.0F;
   }

   public boolean func_70058_J() {
      return this.field_70170_p.func_72875_a(this.field_70121_D.func_72314_b(-0.10000000149011612D, -0.4000000059604645D, -0.10000000149011612D), Material.field_76256_h);
   }

   public void func_70060_a(float p_70060_1_, float p_70060_2_, float p_70060_3_) {
      float var4 = p_70060_1_ * p_70060_1_ + p_70060_2_ * p_70060_2_;
      if(var4 >= 1.0E-4F) {
         var4 = MathHelper.func_76129_c(var4);
         if(var4 < 1.0F) {
            var4 = 1.0F;
         }

         var4 = p_70060_3_ / var4;
         p_70060_1_ *= var4;
         p_70060_2_ *= var4;
         float var5 = MathHelper.func_76126_a(this.field_70177_z * 3.1415927F / 180.0F);
         float var6 = MathHelper.func_76134_b(this.field_70177_z * 3.1415927F / 180.0F);
         this.field_70159_w += (double)(p_70060_1_ * var6 - p_70060_2_ * var5);
         this.field_70179_y += (double)(p_70060_2_ * var6 + p_70060_1_ * var5);
      }
   }

   public float func_70013_c(float p_70013_1_) {
      int var2 = MathHelper.func_76128_c(this.field_70165_t);
      int var3 = MathHelper.func_76128_c(this.field_70161_v);
      if(this.field_70170_p.func_72899_e(var2, 0, var3)) {
         double var4 = (this.field_70121_D.field_72337_e - this.field_70121_D.field_72338_b) * 0.66D;
         int var6 = MathHelper.func_76128_c(this.field_70163_u - (double)this.field_70129_M + var4);
         return this.field_70170_p.func_72801_o(var2, var6, var3);
      } else {
         return 0.0F;
      }
   }

   public void func_70029_a(World p_70029_1_) {
      this.field_70170_p = p_70029_1_;
   }

   public void func_70080_a(double p_70080_1_, double p_70080_3_, double p_70080_5_, float p_70080_7_, float p_70080_8_) {
      this.field_70169_q = this.field_70165_t = p_70080_1_;
      this.field_70167_r = this.field_70163_u = p_70080_3_;
      this.field_70166_s = this.field_70161_v = p_70080_5_;
      this.field_70126_B = this.field_70177_z = p_70080_7_;
      this.field_70127_C = this.field_70125_A = p_70080_8_;
      this.field_70139_V = 0.0F;
      double var9 = (double)(this.field_70126_B - p_70080_7_);
      if(var9 < -180.0D) {
         this.field_70126_B += 360.0F;
      }

      if(var9 >= 180.0D) {
         this.field_70126_B -= 360.0F;
      }

      this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
      this.func_70101_b(p_70080_7_, p_70080_8_);
   }

   public void func_70012_b(double p_70012_1_, double p_70012_3_, double p_70012_5_, float p_70012_7_, float p_70012_8_) {
      this.field_70142_S = this.field_70169_q = this.field_70165_t = p_70012_1_;
      this.field_70137_T = this.field_70167_r = this.field_70163_u = p_70012_3_ + (double)this.field_70129_M;
      this.field_70136_U = this.field_70166_s = this.field_70161_v = p_70012_5_;
      this.field_70177_z = p_70012_7_;
      this.field_70125_A = p_70012_8_;
      this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
   }

   public float func_70032_d(Entity p_70032_1_) {
      float var2 = (float)(this.field_70165_t - p_70032_1_.field_70165_t);
      float var3 = (float)(this.field_70163_u - p_70032_1_.field_70163_u);
      float var4 = (float)(this.field_70161_v - p_70032_1_.field_70161_v);
      return MathHelper.func_76129_c(var2 * var2 + var3 * var3 + var4 * var4);
   }

   public double func_70092_e(double p_70092_1_, double p_70092_3_, double p_70092_5_) {
      double var7 = this.field_70165_t - p_70092_1_;
      double var9 = this.field_70163_u - p_70092_3_;
      double var11 = this.field_70161_v - p_70092_5_;
      return var7 * var7 + var9 * var9 + var11 * var11;
   }

   public double func_70011_f(double p_70011_1_, double p_70011_3_, double p_70011_5_) {
      double var7 = this.field_70165_t - p_70011_1_;
      double var9 = this.field_70163_u - p_70011_3_;
      double var11 = this.field_70161_v - p_70011_5_;
      return (double)MathHelper.func_76133_a(var7 * var7 + var9 * var9 + var11 * var11);
   }

   public double func_70068_e(Entity p_70068_1_) {
      double var2 = this.field_70165_t - p_70068_1_.field_70165_t;
      double var4 = this.field_70163_u - p_70068_1_.field_70163_u;
      double var6 = this.field_70161_v - p_70068_1_.field_70161_v;
      return var2 * var2 + var4 * var4 + var6 * var6;
   }

   public void func_70100_b_(EntityPlayer p_70100_1_) {}

   public void func_70108_f(Entity p_70108_1_) {
      if(p_70108_1_.field_70153_n != this && p_70108_1_.field_70154_o != this) {
         double var2 = p_70108_1_.field_70165_t - this.field_70165_t;
         double var4 = p_70108_1_.field_70161_v - this.field_70161_v;
         double var6 = MathHelper.func_76132_a(var2, var4);
         if(var6 >= 0.009999999776482582D) {
            var6 = (double)MathHelper.func_76133_a(var6);
            var2 /= var6;
            var4 /= var6;
            double var8 = 1.0D / var6;
            if(var8 > 1.0D) {
               var8 = 1.0D;
            }

            var2 *= var8;
            var4 *= var8;
            var2 *= 0.05000000074505806D;
            var4 *= 0.05000000074505806D;
            var2 *= (double)(1.0F - this.field_70144_Y);
            var4 *= (double)(1.0F - this.field_70144_Y);
            this.func_70024_g(-var2, 0.0D, -var4);
            p_70108_1_.func_70024_g(var2, 0.0D, var4);
         }

      }
   }

   public void func_70024_g(double p_70024_1_, double p_70024_3_, double p_70024_5_) {
      this.field_70159_w += p_70024_1_;
      this.field_70181_x += p_70024_3_;
      this.field_70179_y += p_70024_5_;
      this.field_70160_al = true;
   }

   protected void func_70018_K() {
      this.field_70133_I = true;
   }

   public boolean func_70097_a(DamageSource p_70097_1_, int p_70097_2_) {
      this.func_70018_K();
      return false;
   }

   public boolean func_70067_L() {
      return false;
   }

   public boolean func_70104_M() {
      return false;
   }

   public void func_70084_c(Entity p_70084_1_, int p_70084_2_) {}

   public boolean func_70039_c(NBTTagCompound p_70039_1_) {
      String var2 = this.func_70022_Q();
      if(!this.field_70128_L && var2 != null) {
         p_70039_1_.func_74778_a("id", var2);
         this.func_70109_d(p_70039_1_);
         return true;
      } else {
         return false;
      }
   }

   public void func_70109_d(NBTTagCompound p_70109_1_) {
      p_70109_1_.func_74782_a("Pos", this.func_70087_a(new double[]{this.field_70165_t, this.field_70163_u + (double)this.field_70139_V, this.field_70161_v}));
      p_70109_1_.func_74782_a("Motion", this.func_70087_a(new double[]{this.field_70159_w, this.field_70181_x, this.field_70179_y}));
      p_70109_1_.func_74782_a("Rotation", this.func_70049_a(new float[]{this.field_70177_z, this.field_70125_A}));
      p_70109_1_.func_74776_a("FallDistance", this.field_70143_R);
      p_70109_1_.func_74777_a("Fire", (short)this.field_70151_c);
      p_70109_1_.func_74777_a("Air", (short)this.func_70086_ai());
      p_70109_1_.func_74757_a("OnGround", this.field_70122_E);
      this.func_70014_b(p_70109_1_);
   }

   public void func_70020_e(NBTTagCompound p_70020_1_) {
      NBTTagList var2 = p_70020_1_.func_74761_m("Pos");
      NBTTagList var3 = p_70020_1_.func_74761_m("Motion");
      NBTTagList var4 = p_70020_1_.func_74761_m("Rotation");
      this.field_70159_w = ((NBTTagDouble)var3.func_74743_b(0)).field_74755_a;
      this.field_70181_x = ((NBTTagDouble)var3.func_74743_b(1)).field_74755_a;
      this.field_70179_y = ((NBTTagDouble)var3.func_74743_b(2)).field_74755_a;
      if(Math.abs(this.field_70159_w) > 10.0D) {
         this.field_70159_w = 0.0D;
      }

      if(Math.abs(this.field_70181_x) > 10.0D) {
         this.field_70181_x = 0.0D;
      }

      if(Math.abs(this.field_70179_y) > 10.0D) {
         this.field_70179_y = 0.0D;
      }

      this.field_70169_q = this.field_70142_S = this.field_70165_t = ((NBTTagDouble)var2.func_74743_b(0)).field_74755_a;
      this.field_70167_r = this.field_70137_T = this.field_70163_u = ((NBTTagDouble)var2.func_74743_b(1)).field_74755_a;
      this.field_70166_s = this.field_70136_U = this.field_70161_v = ((NBTTagDouble)var2.func_74743_b(2)).field_74755_a;
      this.field_70126_B = this.field_70177_z = ((NBTTagFloat)var4.func_74743_b(0)).field_74750_a;
      this.field_70127_C = this.field_70125_A = ((NBTTagFloat)var4.func_74743_b(1)).field_74750_a;
      this.field_70143_R = p_70020_1_.func_74760_g("FallDistance");
      this.field_70151_c = p_70020_1_.func_74765_d("Fire");
      this.func_70050_g(p_70020_1_.func_74765_d("Air"));
      this.field_70122_E = p_70020_1_.func_74767_n("OnGround");
      this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
      this.func_70101_b(this.field_70177_z, this.field_70125_A);
      this.func_70037_a(p_70020_1_);
   }

   protected final String func_70022_Q() {
      return EntityList.func_75621_b(this);
   }

   protected abstract void func_70037_a(NBTTagCompound var1);

   protected abstract void func_70014_b(NBTTagCompound var1);

   protected NBTTagList func_70087_a(double ... p_70087_1_) {
      NBTTagList var2 = new NBTTagList();
      double[] var3 = p_70087_1_;
      int var4 = p_70087_1_.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         double var6 = var3[var5];
         var2.func_74742_a(new NBTTagDouble((String)null, var6));
      }

      return var2;
   }

   protected NBTTagList func_70049_a(float ... p_70049_1_) {
      NBTTagList var2 = new NBTTagList();
      float[] var3 = p_70049_1_;
      int var4 = p_70049_1_.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         float var6 = var3[var5];
         var2.func_74742_a(new NBTTagFloat((String)null, var6));
      }

      return var2;
   }

   public EntityItem func_70025_b(int p_70025_1_, int p_70025_2_) {
      return this.func_70054_a(p_70025_1_, p_70025_2_, 0.0F);
   }

   public EntityItem func_70054_a(int p_70054_1_, int p_70054_2_, float p_70054_3_) {
      return this.func_70099_a(new ItemStack(p_70054_1_, p_70054_2_, 0), p_70054_3_);
   }

   public EntityItem func_70099_a(ItemStack p_70099_1_, float p_70099_2_) {
      EntityItem var3 = new EntityItem(this.field_70170_p, this.field_70165_t, this.field_70163_u + (double)p_70099_2_, this.field_70161_v, p_70099_1_);
      var3.field_70293_c = 10;
      this.field_70170_p.func_72838_d(var3);
      return var3;
   }

   public boolean func_70089_S() {
      return !this.field_70128_L;
   }

   public boolean func_70094_T() {
      for(int var1 = 0; var1 < 8; ++var1) {
         float var2 = ((float)((var1 >> 0) % 2) - 0.5F) * this.field_70130_N * 0.8F;
         float var3 = ((float)((var1 >> 1) % 2) - 0.5F) * 0.1F;
         float var4 = ((float)((var1 >> 2) % 2) - 0.5F) * this.field_70130_N * 0.8F;
         int var5 = MathHelper.func_76128_c(this.field_70165_t + (double)var2);
         int var6 = MathHelper.func_76128_c(this.field_70163_u + (double)this.func_70047_e() + (double)var3);
         int var7 = MathHelper.func_76128_c(this.field_70161_v + (double)var4);
         if(this.field_70170_p.func_72809_s(var5, var6, var7)) {
            return true;
         }
      }

      return false;
   }

   public boolean func_70085_c(EntityPlayer p_70085_1_) {
      return false;
   }

   public AxisAlignedBB func_70114_g(Entity p_70114_1_) {
      return null;
   }

   public void func_70098_U() {
      if(this.field_70154_o.field_70128_L) {
         this.field_70154_o = null;
      } else {
         this.field_70159_w = 0.0D;
         this.field_70181_x = 0.0D;
         this.field_70179_y = 0.0D;
         this.func_70071_h_();
         if(this.field_70154_o != null) {
            this.field_70154_o.func_70043_V();
            this.field_70147_f += (double)(this.field_70154_o.field_70177_z - this.field_70154_o.field_70126_B);

            for(this.field_70149_e += (double)(this.field_70154_o.field_70125_A - this.field_70154_o.field_70127_C); this.field_70147_f >= 180.0D; this.field_70147_f -= 360.0D) {
               ;
            }

            while(this.field_70147_f < -180.0D) {
               this.field_70147_f += 360.0D;
            }

            while(this.field_70149_e >= 180.0D) {
               this.field_70149_e -= 360.0D;
            }

            while(this.field_70149_e < -180.0D) {
               this.field_70149_e += 360.0D;
            }

            double var1 = this.field_70147_f * 0.5D;
            double var3 = this.field_70149_e * 0.5D;
            float var5 = 10.0F;
            if(var1 > (double)var5) {
               var1 = (double)var5;
            }

            if(var1 < (double)(-var5)) {
               var1 = (double)(-var5);
            }

            if(var3 > (double)var5) {
               var3 = (double)var5;
            }

            if(var3 < (double)(-var5)) {
               var3 = (double)(-var5);
            }

            this.field_70147_f -= var1;
            this.field_70149_e -= var3;
            this.field_70177_z = (float)((double)this.field_70177_z + var1);
            this.field_70125_A = (float)((double)this.field_70125_A + var3);
         }
      }
   }

   public void func_70043_V() {
      if(!(this.field_70153_n instanceof EntityPlayer) || !((EntityPlayer)this.field_70153_n).func_71066_bF()) {
         this.field_70153_n.field_70142_S = this.field_70153_n.field_70165_t;
         this.field_70153_n.field_70137_T = this.field_70153_n.field_70163_u;
         this.field_70153_n.field_70136_U = this.field_70153_n.field_70161_v;
      }

      this.field_70153_n.func_70107_b(this.field_70165_t, this.field_70163_u + this.func_70042_X() + this.field_70153_n.func_70033_W(), this.field_70161_v);
   }

   public double func_70033_W() {
      return (double)this.field_70129_M;
   }

   public double func_70042_X() {
      return (double)this.field_70131_O * 0.75D;
   }

   public void func_70078_a(Entity p_70078_1_) {
      this.field_70149_e = 0.0D;
      this.field_70147_f = 0.0D;
      if(p_70078_1_ == null) {
         if(this.field_70154_o != null) {
            this.func_70012_b(this.field_70154_o.field_70165_t, this.field_70154_o.field_70121_D.field_72338_b + (double)this.field_70154_o.field_70131_O, this.field_70154_o.field_70161_v, this.field_70177_z, this.field_70125_A);
            this.field_70154_o.field_70153_n = null;
         }

         this.field_70154_o = null;
      } else if(this.field_70154_o == p_70078_1_) {
         this.func_70061_h(p_70078_1_);
         this.field_70154_o.field_70153_n = null;
         this.field_70154_o = null;
      } else {
         if(this.field_70154_o != null) {
            this.field_70154_o.field_70153_n = null;
         }

         if(p_70078_1_.field_70153_n != null) {
            p_70078_1_.field_70153_n.field_70154_o = null;
         }

         this.field_70154_o = p_70078_1_;
         p_70078_1_.field_70153_n = this;
      }
   }

   public void func_70061_h(Entity p_70061_1_) {
      double var3 = p_70061_1_.field_70165_t;
      double var5 = p_70061_1_.field_70121_D.field_72338_b + (double)p_70061_1_.field_70131_O;
      double var7 = p_70061_1_.field_70161_v;

      for(double var9 = -1.5D; var9 < 2.0D; ++var9) {
         for(double var11 = -1.5D; var11 < 2.0D; ++var11) {
            if(var9 != 0.0D || var11 != 0.0D) {
               int var13 = (int)(this.field_70165_t + var9);
               int var14 = (int)(this.field_70161_v + var11);
               AxisAlignedBB var2 = this.field_70121_D.func_72325_c(var9, 1.0D, var11);
               if(this.field_70170_p.func_72840_a(var2).isEmpty()) {
                  if(this.field_70170_p.func_72797_t(var13, (int)this.field_70163_u, var14)) {
                     this.func_70012_b(this.field_70165_t + var9, this.field_70163_u + 1.0D, this.field_70161_v + var11, this.field_70177_z, this.field_70125_A);
                     return;
                  }

                  if(this.field_70170_p.func_72797_t(var13, (int)this.field_70163_u - 1, var14) || this.field_70170_p.func_72803_f(var13, (int)this.field_70163_u - 1, var14) == Material.field_76244_g) {
                     var3 = this.field_70165_t + var9;
                     var5 = this.field_70163_u + 1.0D;
                     var7 = this.field_70161_v + var11;
                  }
               }
            }
         }
      }

      this.func_70012_b(var3, var5, var7, this.field_70177_z, this.field_70125_A);
   }

   public float func_70111_Y() {
      return 0.1F;
   }

   public Vec3 func_70040_Z() {
      return null;
   }

   public void func_70063_aa() {}

   public ItemStack[] func_70035_c() {
      return null;
   }

   public boolean func_70027_ad() {
      return this.field_70151_c > 0 || this.func_70083_f(0);
   }

   public boolean func_70093_af() {
      return this.func_70083_f(1);
   }

   public void func_70095_a(boolean p_70095_1_) {
      this.func_70052_a(1, p_70095_1_);
   }

   public boolean func_70051_ag() {
      return this.func_70083_f(3);
   }

   public void func_70031_b(boolean p_70031_1_) {
      this.func_70052_a(3, p_70031_1_);
   }

   public void func_70019_c(boolean p_70019_1_) {
      this.func_70052_a(4, p_70019_1_);
   }

   protected boolean func_70083_f(int p_70083_1_) {
      return (this.field_70180_af.func_75683_a(0) & 1 << p_70083_1_) != 0;
   }

   protected void func_70052_a(int p_70052_1_, boolean p_70052_2_) {
      byte var3 = this.field_70180_af.func_75683_a(0);
      if(p_70052_2_) {
         this.field_70180_af.func_75692_b(0, Byte.valueOf((byte)(var3 | 1 << p_70052_1_)));
      } else {
         this.field_70180_af.func_75692_b(0, Byte.valueOf((byte)(var3 & ~(1 << p_70052_1_))));
      }

   }

   public int func_70086_ai() {
      return this.field_70180_af.func_75693_b(1);
   }

   public void func_70050_g(int p_70050_1_) {
      this.field_70180_af.func_75692_b(1, Short.valueOf((short)p_70050_1_));
   }

   public void func_70077_a(EntityLightningBolt p_70077_1_) {
      this.func_70081_e(5);
      ++this.field_70151_c;
      if(this.field_70151_c == 0) {
         this.func_70015_d(8);
      }

   }

   public void func_70074_a(EntityLiving p_70074_1_) {}

   protected boolean func_70048_i(double p_70048_1_, double p_70048_3_, double p_70048_5_) {
      int var7 = MathHelper.func_76128_c(p_70048_1_);
      int var8 = MathHelper.func_76128_c(p_70048_3_);
      int var9 = MathHelper.func_76128_c(p_70048_5_);
      double var10 = p_70048_1_ - (double)var7;
      double var12 = p_70048_3_ - (double)var8;
      double var14 = p_70048_5_ - (double)var9;
      if(this.field_70170_p.func_72809_s(var7, var8, var9)) {
         boolean var16 = !this.field_70170_p.func_72809_s(var7 - 1, var8, var9);
         boolean var17 = !this.field_70170_p.func_72809_s(var7 + 1, var8, var9);
         boolean var18 = !this.field_70170_p.func_72809_s(var7, var8 - 1, var9);
         boolean var19 = !this.field_70170_p.func_72809_s(var7, var8 + 1, var9);
         boolean var20 = !this.field_70170_p.func_72809_s(var7, var8, var9 - 1);
         boolean var21 = !this.field_70170_p.func_72809_s(var7, var8, var9 + 1);
         byte var22 = -1;
         double var23 = 9999.0D;
         if(var16 && var10 < var23) {
            var23 = var10;
            var22 = 0;
         }

         if(var17 && 1.0D - var10 < var23) {
            var23 = 1.0D - var10;
            var22 = 1;
         }

         if(var18 && var12 < var23) {
            var23 = var12;
            var22 = 2;
         }

         if(var19 && 1.0D - var12 < var23) {
            var23 = 1.0D - var12;
            var22 = 3;
         }

         if(var20 && var14 < var23) {
            var23 = var14;
            var22 = 4;
         }

         if(var21 && 1.0D - var14 < var23) {
            var23 = 1.0D - var14;
            var22 = 5;
         }

         float var25 = this.field_70146_Z.nextFloat() * 0.2F + 0.1F;
         if(var22 == 0) {
            this.field_70159_w = (double)(-var25);
         }

         if(var22 == 1) {
            this.field_70159_w = (double)var25;
         }

         if(var22 == 2) {
            this.field_70181_x = (double)(-var25);
         }

         if(var22 == 3) {
            this.field_70181_x = (double)var25;
         }

         if(var22 == 4) {
            this.field_70179_y = (double)(-var25);
         }

         if(var22 == 5) {
            this.field_70179_y = (double)var25;
         }

         return true;
      } else {
         return false;
      }
   }

   public void func_70110_aj() {
      this.field_70134_J = true;
      this.field_70143_R = 0.0F;
   }

   public String func_70023_ak() {
      String var1 = EntityList.func_75621_b(this);
      if(var1 == null) {
         var1 = "generic";
      }

      return StatCollector.func_74838_a("entity." + var1 + ".name");
   }

   public Entity[] func_70021_al() {
      return null;
   }

   public boolean func_70028_i(Entity p_70028_1_) {
      return this == p_70028_1_;
   }

   public float func_70079_am() {
      return 0.0F;
   }

   public boolean func_70075_an() {
      return true;
   }

   public String toString() {
      return String.format("%s[\'%s\'/%d, l=\'%s\', x=%.2f, y=%.2f, z=%.2f]", new Object[]{this.getClass().getSimpleName(), this.func_70023_ak(), Integer.valueOf(this.field_70157_k), this.field_70170_p == null?"~NULL~":this.field_70170_p.func_72912_H().func_76065_j(), Double.valueOf(this.field_70165_t), Double.valueOf(this.field_70163_u), Double.valueOf(this.field_70161_v)});
   }

}
