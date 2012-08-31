package net.minecraft.src;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.src.DamageSource;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityItem;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EnumArt;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.MathHelper;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.World;

public class EntityPainting extends Entity {

   private int field_70520_f;
   public int field_70525_a;
   public int field_70523_b;
   public int field_70524_c;
   public int field_70521_d;
   public EnumArt field_70522_e;


   public EntityPainting(World p_i3447_1_) {
      super(p_i3447_1_);
      this.field_70520_f = 0;
      this.field_70525_a = 0;
      this.field_70129_M = 0.0F;
      this.func_70105_a(0.5F, 0.5F);
   }

   public EntityPainting(World p_i3448_1_, int p_i3448_2_, int p_i3448_3_, int p_i3448_4_, int p_i3448_5_) {
      this(p_i3448_1_);
      this.field_70523_b = p_i3448_2_;
      this.field_70524_c = p_i3448_3_;
      this.field_70521_d = p_i3448_4_;
      ArrayList var6 = new ArrayList();
      EnumArt[] var7 = EnumArt.values();
      int var8 = var7.length;

      for(int var9 = 0; var9 < var8; ++var9) {
         EnumArt var10 = var7[var9];
         this.field_70522_e = var10;
         this.func_70519_a(p_i3448_5_);
         if(this.func_70518_d()) {
            var6.add(var10);
         }
      }

      if(!var6.isEmpty()) {
         this.field_70522_e = (EnumArt)var6.get(this.field_70146_Z.nextInt(var6.size()));
      }

      this.func_70519_a(p_i3448_5_);
   }

   public EntityPainting(World p_i3449_1_, int p_i3449_2_, int p_i3449_3_, int p_i3449_4_, int p_i3449_5_, String p_i3449_6_) {
      this(p_i3449_1_);
      this.field_70523_b = p_i3449_2_;
      this.field_70524_c = p_i3449_3_;
      this.field_70521_d = p_i3449_4_;
      EnumArt[] var7 = EnumArt.values();
      int var8 = var7.length;

      for(int var9 = 0; var9 < var8; ++var9) {
         EnumArt var10 = var7[var9];
         if(var10.field_75702_A.equals(p_i3449_6_)) {
            this.field_70522_e = var10;
            break;
         }
      }

      this.func_70519_a(p_i3449_5_);
   }

   protected void func_70088_a() {}

   public void func_70519_a(int p_70519_1_) {
      this.field_70525_a = p_70519_1_;
      this.field_70126_B = this.field_70177_z = (float)(p_70519_1_ * 90);
      float var2 = (float)this.field_70522_e.field_75703_B;
      float var3 = (float)this.field_70522_e.field_75704_C;
      float var4 = (float)this.field_70522_e.field_75703_B;
      if(p_70519_1_ != 0 && p_70519_1_ != 2) {
         var2 = 0.5F;
      } else {
         var4 = 0.5F;
      }

      var2 /= 32.0F;
      var3 /= 32.0F;
      var4 /= 32.0F;
      float var5 = (float)this.field_70523_b + 0.5F;
      float var6 = (float)this.field_70524_c + 0.5F;
      float var7 = (float)this.field_70521_d + 0.5F;
      float var8 = 0.5625F;
      if(p_70519_1_ == 0) {
         var7 -= var8;
      }

      if(p_70519_1_ == 1) {
         var5 -= var8;
      }

      if(p_70519_1_ == 2) {
         var7 += var8;
      }

      if(p_70519_1_ == 3) {
         var5 += var8;
      }

      if(p_70519_1_ == 0) {
         var5 -= this.func_70517_b(this.field_70522_e.field_75703_B);
      }

      if(p_70519_1_ == 1) {
         var7 += this.func_70517_b(this.field_70522_e.field_75703_B);
      }

      if(p_70519_1_ == 2) {
         var5 += this.func_70517_b(this.field_70522_e.field_75703_B);
      }

      if(p_70519_1_ == 3) {
         var7 -= this.func_70517_b(this.field_70522_e.field_75703_B);
      }

      var6 += this.func_70517_b(this.field_70522_e.field_75704_C);
      this.func_70107_b((double)var5, (double)var6, (double)var7);
      float var9 = -0.00625F;
      this.field_70121_D.func_72324_b((double)(var5 - var2 - var9), (double)(var6 - var3 - var9), (double)(var7 - var4 - var9), (double)(var5 + var2 + var9), (double)(var6 + var3 + var9), (double)(var7 + var4 + var9));
   }

   private float func_70517_b(int p_70517_1_) {
      return p_70517_1_ == 32?0.5F:(p_70517_1_ == 64?0.5F:0.0F);
   }

   public void func_70071_h_() {
      if(this.field_70520_f++ == 100 && !this.field_70170_p.field_72995_K) {
         this.field_70520_f = 0;
         if(!this.field_70128_L && !this.func_70518_d()) {
            this.func_70106_y();
            this.field_70170_p.func_72838_d(new EntityItem(this.field_70170_p, this.field_70165_t, this.field_70163_u, this.field_70161_v, new ItemStack(Item.field_77780_as)));
         }
      }

   }

   public boolean func_70518_d() {
      if(!this.field_70170_p.func_72945_a(this, this.field_70121_D).isEmpty()) {
         return false;
      } else {
         int var1 = this.field_70522_e.field_75703_B / 16;
         int var2 = this.field_70522_e.field_75704_C / 16;
         int var3 = this.field_70523_b;
         int var4 = this.field_70524_c;
         int var5 = this.field_70521_d;
         if(this.field_70525_a == 0) {
            var3 = MathHelper.func_76128_c(this.field_70165_t - (double)((float)this.field_70522_e.field_75703_B / 32.0F));
         }

         if(this.field_70525_a == 1) {
            var5 = MathHelper.func_76128_c(this.field_70161_v - (double)((float)this.field_70522_e.field_75703_B / 32.0F));
         }

         if(this.field_70525_a == 2) {
            var3 = MathHelper.func_76128_c(this.field_70165_t - (double)((float)this.field_70522_e.field_75703_B / 32.0F));
         }

         if(this.field_70525_a == 3) {
            var5 = MathHelper.func_76128_c(this.field_70161_v - (double)((float)this.field_70522_e.field_75703_B / 32.0F));
         }

         var4 = MathHelper.func_76128_c(this.field_70163_u - (double)((float)this.field_70522_e.field_75704_C / 32.0F));

         for(int var6 = 0; var6 < var1; ++var6) {
            for(int var7 = 0; var7 < var2; ++var7) {
               Material var8;
               if(this.field_70525_a != 0 && this.field_70525_a != 2) {
                  var8 = this.field_70170_p.func_72803_f(this.field_70523_b, var4 + var7, var5 + var6);
               } else {
                  var8 = this.field_70170_p.func_72803_f(var3 + var6, var4 + var7, this.field_70521_d);
               }

               if(!var8.func_76220_a()) {
                  return false;
               }
            }
         }

         List var9 = this.field_70170_p.func_72839_b(this, this.field_70121_D);
         Iterator var10 = var9.iterator();

         Entity var11;
         do {
            if(!var10.hasNext()) {
               return true;
            }

            var11 = (Entity)var10.next();
         } while(!(var11 instanceof EntityPainting));

         return false;
      }
   }

   public boolean func_70067_L() {
      return true;
   }

   public boolean func_70097_a(DamageSource p_70097_1_, int p_70097_2_) {
      if(!this.field_70128_L && !this.field_70170_p.field_72995_K) {
         this.func_70106_y();
         this.func_70018_K();
         EntityPlayer var3 = null;
         if(p_70097_1_.func_76346_g() instanceof EntityPlayer) {
            var3 = (EntityPlayer)p_70097_1_.func_76346_g();
         }

         if(var3 != null && var3.field_71075_bZ.field_75098_d) {
            return true;
         }

         this.field_70170_p.func_72838_d(new EntityItem(this.field_70170_p, this.field_70165_t, this.field_70163_u, this.field_70161_v, new ItemStack(Item.field_77780_as)));
      }

      return true;
   }

   public void func_70014_b(NBTTagCompound p_70014_1_) {
      p_70014_1_.func_74774_a("Dir", (byte)this.field_70525_a);
      p_70014_1_.func_74778_a("Motive", this.field_70522_e.field_75702_A);
      p_70014_1_.func_74768_a("TileX", this.field_70523_b);
      p_70014_1_.func_74768_a("TileY", this.field_70524_c);
      p_70014_1_.func_74768_a("TileZ", this.field_70521_d);
   }

   public void func_70037_a(NBTTagCompound p_70037_1_) {
      this.field_70525_a = p_70037_1_.func_74771_c("Dir");
      this.field_70523_b = p_70037_1_.func_74762_e("TileX");
      this.field_70524_c = p_70037_1_.func_74762_e("TileY");
      this.field_70521_d = p_70037_1_.func_74762_e("TileZ");
      String var2 = p_70037_1_.func_74779_i("Motive");
      EnumArt[] var3 = EnumArt.values();
      int var4 = var3.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         EnumArt var6 = var3[var5];
         if(var6.field_75702_A.equals(var2)) {
            this.field_70522_e = var6;
         }
      }

      if(this.field_70522_e == null) {
         this.field_70522_e = EnumArt.Kebab;
      }

      this.func_70519_a(this.field_70525_a);
   }

   public void func_70091_d(double p_70091_1_, double p_70091_3_, double p_70091_5_) {
      if(!this.field_70170_p.field_72995_K && !this.field_70128_L && p_70091_1_ * p_70091_1_ + p_70091_3_ * p_70091_3_ + p_70091_5_ * p_70091_5_ > 0.0D) {
         this.func_70106_y();
         this.field_70170_p.func_72838_d(new EntityItem(this.field_70170_p, this.field_70165_t, this.field_70163_u, this.field_70161_v, new ItemStack(Item.field_77780_as)));
      }

   }

   public void func_70024_g(double p_70024_1_, double p_70024_3_, double p_70024_5_) {
      if(!this.field_70170_p.field_72995_K && !this.field_70128_L && p_70024_1_ * p_70024_1_ + p_70024_3_ * p_70024_3_ + p_70024_5_ * p_70024_5_ > 0.0D) {
         this.func_70106_y();
         this.field_70170_p.func_72838_d(new EntityItem(this.field_70170_p, this.field_70165_t, this.field_70163_u, this.field_70161_v, new ItemStack(Item.field_77780_as)));
      }

   }
}
