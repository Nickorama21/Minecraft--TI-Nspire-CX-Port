package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.DamageSource;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityAIAvoidEntity;
import net.minecraft.src.EntityAIFollowOwner;
import net.minecraft.src.EntityAILeapAtTarget;
import net.minecraft.src.EntityAIMate;
import net.minecraft.src.EntityAIOcelotAttack;
import net.minecraft.src.EntityAIOcelotSit;
import net.minecraft.src.EntityAISwimming;
import net.minecraft.src.EntityAITargetNonTamed;
import net.minecraft.src.EntityAITempt;
import net.minecraft.src.EntityAIWander;
import net.minecraft.src.EntityAIWatchClosest;
import net.minecraft.src.EntityAnimal;
import net.minecraft.src.EntityChicken;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EntityTameable;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.MathHelper;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.World;

public class EntityOcelot extends EntityTameable {

   private EntityAITempt field_70914_e;


   public EntityOcelot(World p_i3519_1_) {
      super(p_i3519_1_);
      this.field_70750_az = "/mob/ozelot.png";
      this.func_70105_a(0.6F, 0.8F);
      this.func_70661_as().func_75491_a(true);
      this.field_70714_bg.func_75776_a(1, new EntityAISwimming(this));
      this.field_70714_bg.func_75776_a(2, this.field_70911_d);
      this.field_70714_bg.func_75776_a(3, this.field_70914_e = new EntityAITempt(this, 0.18F, Item.field_77754_aU.field_77779_bT, true));
      this.field_70714_bg.func_75776_a(4, new EntityAIAvoidEntity(this, EntityPlayer.class, 16.0F, 0.23F, 0.4F));
      this.field_70714_bg.func_75776_a(5, new EntityAIFollowOwner(this, 0.3F, 10.0F, 5.0F));
      this.field_70714_bg.func_75776_a(6, new EntityAIOcelotSit(this, 0.4F));
      this.field_70714_bg.func_75776_a(7, new EntityAILeapAtTarget(this, 0.3F));
      this.field_70714_bg.func_75776_a(8, new EntityAIOcelotAttack(this));
      this.field_70714_bg.func_75776_a(9, new EntityAIMate(this, 0.23F));
      this.field_70714_bg.func_75776_a(10, new EntityAIWander(this, 0.23F));
      this.field_70714_bg.func_75776_a(11, new EntityAIWatchClosest(this, EntityPlayer.class, 10.0F));
      this.field_70715_bh.func_75776_a(1, new EntityAITargetNonTamed(this, EntityChicken.class, 14.0F, 750, false));
   }

   protected void func_70088_a() {
      super.func_70088_a();
      this.field_70180_af.func_75682_a(18, Byte.valueOf((byte)0));
   }

   public void func_70629_bd() {
      if(this.func_70605_aq().func_75640_a()) {
         float var1 = this.func_70605_aq().func_75638_b();
         if(var1 == 0.18F) {
            this.func_70095_a(true);
            this.func_70031_b(false);
         } else if(var1 == 0.4F) {
            this.func_70095_a(false);
            this.func_70031_b(true);
         } else {
            this.func_70095_a(false);
            this.func_70031_b(false);
         }
      } else {
         this.func_70095_a(false);
         this.func_70031_b(false);
      }

   }

   protected boolean func_70692_ba() {
      return !this.func_70909_n();
   }

   public boolean func_70650_aV() {
      return true;
   }

   public int func_70667_aM() {
      return 10;
   }

   protected void func_70069_a(float p_70069_1_) {}

   public void func_70014_b(NBTTagCompound p_70014_1_) {
      super.func_70014_b(p_70014_1_);
      p_70014_1_.func_74768_a("CatType", this.func_70913_u());
   }

   public void func_70037_a(NBTTagCompound p_70037_1_) {
      super.func_70037_a(p_70037_1_);
      this.func_70912_b(p_70037_1_.func_74762_e("CatType"));
   }

   protected String func_70639_aQ() {
      return this.func_70909_n()?(this.func_70880_s()?"mob.cat.purr":(this.field_70146_Z.nextInt(4) == 0?"mob.cat.purreow":"mob.cat.meow")):"";
   }

   protected String func_70621_aR() {
      return "mob.cat.hitt";
   }

   protected String func_70673_aS() {
      return "mob.cat.hitt";
   }

   protected float func_70599_aP() {
      return 0.4F;
   }

   protected int func_70633_aT() {
      return Item.field_77770_aF.field_77779_bT;
   }

   public boolean func_70652_k(Entity p_70652_1_) {
      return p_70652_1_.func_70097_a(DamageSource.func_76358_a(this), 3);
   }

   public boolean func_70097_a(DamageSource p_70097_1_, int p_70097_2_) {
      this.field_70911_d.func_75270_a(false);
      return super.func_70097_a(p_70097_1_, p_70097_2_);
   }

   protected void func_70628_a(boolean p_70628_1_, int p_70628_2_) {}

   public boolean func_70085_c(EntityPlayer p_70085_1_) {
      ItemStack var2 = p_70085_1_.field_71071_by.func_70448_g();
      if(this.func_70909_n()) {
         if(p_70085_1_.field_71092_bJ.equalsIgnoreCase(this.func_70905_p()) && !this.field_70170_p.field_72995_K && !this.func_70877_b(var2)) {
            this.field_70911_d.func_75270_a(!this.func_70906_o());
         }
      } else if(this.field_70914_e.func_75277_f() && var2 != null && var2.field_77993_c == Item.field_77754_aU.field_77779_bT && p_70085_1_.func_70068_e(this) < 9.0D) {
         if(!p_70085_1_.field_71075_bZ.field_75098_d) {
            --var2.field_77994_a;
         }

         if(var2.field_77994_a <= 0) {
            p_70085_1_.field_71071_by.func_70299_a(p_70085_1_.field_71071_by.field_70461_c, (ItemStack)null);
         }

         if(!this.field_70170_p.field_72995_K) {
            if(this.field_70146_Z.nextInt(3) == 0) {
               this.func_70903_f(true);
               this.func_70912_b(1 + this.field_70170_p.field_73012_v.nextInt(3));
               this.func_70910_a(p_70085_1_.field_71092_bJ);
               this.func_70908_e(true);
               this.field_70911_d.func_75270_a(true);
               this.field_70170_p.func_72960_a(this, (byte)7);
            } else {
               this.func_70908_e(false);
               this.field_70170_p.func_72960_a(this, (byte)6);
            }
         }

         return true;
      }

      return super.func_70085_c(p_70085_1_);
   }

   public EntityAnimal func_70879_a(EntityAnimal p_70879_1_) {
      EntityOcelot var2 = new EntityOcelot(this.field_70170_p);
      if(this.func_70909_n()) {
         var2.func_70910_a(this.func_70905_p());
         var2.func_70903_f(true);
         var2.func_70912_b(this.func_70913_u());
      }

      return var2;
   }

   public boolean func_70877_b(ItemStack p_70877_1_) {
      return p_70877_1_ != null && p_70877_1_.field_77993_c == Item.field_77754_aU.field_77779_bT;
   }

   public boolean func_70878_b(EntityAnimal p_70878_1_) {
      if(p_70878_1_ == this) {
         return false;
      } else if(!this.func_70909_n()) {
         return false;
      } else if(!(p_70878_1_ instanceof EntityOcelot)) {
         return false;
      } else {
         EntityOcelot var2 = (EntityOcelot)p_70878_1_;
         return !var2.func_70909_n()?false:this.func_70880_s() && var2.func_70880_s();
      }
   }

   public int func_70913_u() {
      return this.field_70180_af.func_75683_a(18);
   }

   public void func_70912_b(int p_70912_1_) {
      this.field_70180_af.func_75692_b(18, Byte.valueOf((byte)p_70912_1_));
   }

   public boolean func_70601_bi() {
      if(this.field_70170_p.field_73012_v.nextInt(3) == 0) {
         return false;
      } else {
         if(this.field_70170_p.func_72855_b(this.field_70121_D) && this.field_70170_p.func_72945_a(this, this.field_70121_D).isEmpty() && !this.field_70170_p.func_72953_d(this.field_70121_D)) {
            int var1 = MathHelper.func_76128_c(this.field_70165_t);
            int var2 = MathHelper.func_76128_c(this.field_70121_D.field_72338_b);
            int var3 = MathHelper.func_76128_c(this.field_70161_v);
            if(var2 < 63) {
               return false;
            }

            int var4 = this.field_70170_p.func_72798_a(var1, var2 - 1, var3);
            if(var4 == Block.field_71980_u.field_71990_ca || var4 == Block.field_71952_K.field_71990_ca) {
               return true;
            }
         }

         return false;
      }
   }

   public String func_70023_ak() {
      return this.func_70909_n()?"entity.Cat.name":super.func_70023_ak();
   }
}
