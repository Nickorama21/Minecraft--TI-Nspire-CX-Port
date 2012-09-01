package net.minecraft.src;

import java.util.Iterator;
import java.util.List;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityWeatherEffect;
import net.minecraft.src.MathHelper;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.World;

public class EntityLightningBolt extends EntityWeatherEffect {

   private int field_70262_b;
   public long field_70264_a = 0L;
   private int field_70263_c;


   public EntityLightningBolt(World p_i3533_1_, double p_i3533_2_, double p_i3533_4_, double p_i3533_6_) {
      super(p_i3533_1_);
      this.func_70012_b(p_i3533_2_, p_i3533_4_, p_i3533_6_, 0.0F, 0.0F);
      this.field_70262_b = 2;
      this.field_70264_a = this.field_70146_Z.nextLong();
      this.field_70263_c = this.field_70146_Z.nextInt(3) + 1;
      if(p_i3533_1_.field_73013_u >= 2 && p_i3533_1_.func_72873_a(MathHelper.func_76128_c(p_i3533_2_), MathHelper.func_76128_c(p_i3533_4_), MathHelper.func_76128_c(p_i3533_6_), 10)) {
         int var8 = MathHelper.func_76128_c(p_i3533_2_);
         int var9 = MathHelper.func_76128_c(p_i3533_4_);
         int var10 = MathHelper.func_76128_c(p_i3533_6_);
         if(p_i3533_1_.func_72798_a(var8, var9, var10) == 0 && Block.field_72067_ar.func_71930_b(p_i3533_1_, var8, var9, var10)) {
            p_i3533_1_.func_72859_e(var8, var9, var10, Block.field_72067_ar.field_71990_ca);
         }

         for(var8 = 0; var8 < 4; ++var8) {
            var9 = MathHelper.func_76128_c(p_i3533_2_) + this.field_70146_Z.nextInt(3) - 1;
            var10 = MathHelper.func_76128_c(p_i3533_4_) + this.field_70146_Z.nextInt(3) - 1;
            int var11 = MathHelper.func_76128_c(p_i3533_6_) + this.field_70146_Z.nextInt(3) - 1;
            if(p_i3533_1_.func_72798_a(var9, var10, var11) == 0 && Block.field_72067_ar.func_71930_b(p_i3533_1_, var9, var10, var11)) {
               p_i3533_1_.func_72859_e(var9, var10, var11, Block.field_72067_ar.field_71990_ca);
            }
         }
      }

   }

   public void func_70071_h_() {
      super.func_70071_h_();
      if(this.field_70262_b == 2) {
         this.field_70170_p.func_72908_a(this.field_70165_t, this.field_70163_u, this.field_70161_v, "ambient.weather.thunder", 10000.0F, 0.8F + this.field_70146_Z.nextFloat() * 0.2F);
         this.field_70170_p.func_72908_a(this.field_70165_t, this.field_70163_u, this.field_70161_v, "random.explode", 2.0F, 0.5F + this.field_70146_Z.nextFloat() * 0.2F);
      }

      --this.field_70262_b;
      if(this.field_70262_b < 0) {
         if(this.field_70263_c == 0) {
            this.func_70106_y();
         } else if(this.field_70262_b < -this.field_70146_Z.nextInt(10)) {
            --this.field_70263_c;
            this.field_70262_b = 1;
            this.field_70264_a = this.field_70146_Z.nextLong();
            if(this.field_70170_p.func_72873_a(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70163_u), MathHelper.func_76128_c(this.field_70161_v), 10)) {
               int var1 = MathHelper.func_76128_c(this.field_70165_t);
               int var2 = MathHelper.func_76128_c(this.field_70163_u);
               int var3 = MathHelper.func_76128_c(this.field_70161_v);
               if(this.field_70170_p.func_72798_a(var1, var2, var3) == 0 && Block.field_72067_ar.func_71930_b(this.field_70170_p, var1, var2, var3)) {
                  this.field_70170_p.func_72859_e(var1, var2, var3, Block.field_72067_ar.field_71990_ca);
               }
            }
         }
      }

      if(this.field_70262_b >= 0) {
         double var6 = 3.0D;
         List var7 = this.field_70170_p.func_72839_b(this, AxisAlignedBB.func_72332_a().func_72299_a(this.field_70165_t - var6, this.field_70163_u - var6, this.field_70161_v - var6, this.field_70165_t + var6, this.field_70163_u + 6.0D + var6, this.field_70161_v + var6));
         Iterator var4 = var7.iterator();

         while(var4.hasNext()) {
            Entity var5 = (Entity)var4.next();
            var5.func_70077_a(this);
         }

         this.field_70170_p.field_73015_s = 2;
      }

   }

   protected void func_70088_a() {}

   protected void func_70037_a(NBTTagCompound p_70037_1_) {}

   protected void func_70014_b(NBTTagCompound p_70014_1_) {}
}
