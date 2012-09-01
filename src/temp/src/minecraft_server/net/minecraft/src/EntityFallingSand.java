package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.BlockSand;
import net.minecraft.src.Entity;
import net.minecraft.src.ItemStack;
import net.minecraft.src.MathHelper;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.World;

public class EntityFallingSand extends Entity {

   public int field_70287_a;
   public int field_70285_b;
   public int field_70286_c;
   public boolean field_70284_d;


   public EntityFallingSand(World p_i3536_1_) {
      super(p_i3536_1_);
      this.field_70286_c = 0;
      this.field_70284_d = true;
   }

   public EntityFallingSand(World p_i3537_1_, double p_i3537_2_, double p_i3537_4_, double p_i3537_6_, int p_i3537_8_) {
      this(p_i3537_1_, p_i3537_2_, p_i3537_4_, p_i3537_6_, p_i3537_8_, 0);
   }

   public EntityFallingSand(World p_i3538_1_, double p_i3538_2_, double p_i3538_4_, double p_i3538_6_, int p_i3538_8_, int p_i3538_9_) {
      super(p_i3538_1_);
      this.field_70286_c = 0;
      this.field_70284_d = true;
      this.field_70287_a = p_i3538_8_;
      this.field_70285_b = p_i3538_9_;
      this.field_70156_m = true;
      this.func_70105_a(0.98F, 0.98F);
      this.field_70129_M = this.field_70131_O / 2.0F;
      this.func_70107_b(p_i3538_2_, p_i3538_4_, p_i3538_6_);
      this.field_70159_w = 0.0D;
      this.field_70181_x = 0.0D;
      this.field_70179_y = 0.0D;
      this.field_70169_q = p_i3538_2_;
      this.field_70167_r = p_i3538_4_;
      this.field_70166_s = p_i3538_6_;
   }

   protected boolean func_70041_e_() {
      return false;
   }

   protected void func_70088_a() {}

   public boolean func_70067_L() {
      return !this.field_70128_L;
   }

   public void func_70071_h_() {
      if(this.field_70287_a == 0) {
         this.func_70106_y();
      } else {
         this.field_70169_q = this.field_70165_t;
         this.field_70167_r = this.field_70163_u;
         this.field_70166_s = this.field_70161_v;
         ++this.field_70286_c;
         this.field_70181_x -= 0.03999999910593033D;
         this.func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
         this.field_70159_w *= 0.9800000190734863D;
         this.field_70181_x *= 0.9800000190734863D;
         this.field_70179_y *= 0.9800000190734863D;
         if(!this.field_70170_p.field_72995_K) {
            int var1 = MathHelper.func_76128_c(this.field_70165_t);
            int var2 = MathHelper.func_76128_c(this.field_70163_u);
            int var3 = MathHelper.func_76128_c(this.field_70161_v);
            if(this.field_70286_c == 1) {
               if(this.field_70286_c == 1 && this.field_70170_p.func_72798_a(var1, var2, var3) == this.field_70287_a) {
                  this.field_70170_p.func_72859_e(var1, var2, var3, 0);
               } else {
                  this.func_70106_y();
               }
            }

            if(this.field_70122_E) {
               this.field_70159_w *= 0.699999988079071D;
               this.field_70179_y *= 0.699999988079071D;
               this.field_70181_x *= -0.5D;
               if(this.field_70170_p.func_72798_a(var1, var2, var3) != Block.field_72095_ac.field_71990_ca) {
                  this.func_70106_y();
                  if((!this.field_70170_p.func_72931_a(this.field_70287_a, var1, var2, var3, true, 1, (Entity)null) || BlockSand.func_72191_e_(this.field_70170_p, var1, var2 - 1, var3) || !this.field_70170_p.func_72832_d(var1, var2, var3, this.field_70287_a, this.field_70285_b)) && !this.field_70170_p.field_72995_K && this.field_70284_d) {
                     this.func_70099_a(new ItemStack(this.field_70287_a, 1, this.field_70285_b), 0.0F);
                  }
               }
            } else if(this.field_70286_c > 100 && !this.field_70170_p.field_72995_K && (var2 < 1 || var2 > 256) || this.field_70286_c > 600) {
               if(this.field_70284_d) {
                  this.func_70025_b(this.field_70287_a, 1);
               }

               this.func_70106_y();
            }
         }

      }
   }

   protected void func_70014_b(NBTTagCompound p_70014_1_) {
      p_70014_1_.func_74774_a("Tile", (byte)this.field_70287_a);
      p_70014_1_.func_74774_a("Data", (byte)this.field_70285_b);
      p_70014_1_.func_74774_a("Time", (byte)this.field_70286_c);
      p_70014_1_.func_74757_a("DropItem", this.field_70284_d);
   }

   protected void func_70037_a(NBTTagCompound p_70037_1_) {
      this.field_70287_a = p_70037_1_.func_74771_c("Tile") & 255;
      this.field_70285_b = p_70037_1_.func_74771_c("Data") & 255;
      this.field_70286_c = p_70037_1_.func_74771_c("Time") & 255;
      if(p_70037_1_.func_74764_b("DropItem")) {
         this.field_70284_d = p_70037_1_.func_74767_n("DropItem");
      }

      if(this.field_70287_a == 0) {
         this.field_70287_a = Block.field_71939_E.field_71990_ca;
      }

   }
}
