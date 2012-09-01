package net.minecraft.src;

import net.minecraft.src.AchievementList;
import net.minecraft.src.DamageSource;
import net.minecraft.src.EnchantmentHelper;
import net.minecraft.src.EntityAIArrowAttack;
import net.minecraft.src.EntityAIFleeSun;
import net.minecraft.src.EntityAIHurtByTarget;
import net.minecraft.src.EntityAILookIdle;
import net.minecraft.src.EntityAINearestAttackableTarget;
import net.minecraft.src.EntityAIRestrictSun;
import net.minecraft.src.EntityAISwimming;
import net.minecraft.src.EntityAIWander;
import net.minecraft.src.EntityAIWatchClosest;
import net.minecraft.src.EntityArrow;
import net.minecraft.src.EntityMob;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EnumCreatureAttribute;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.MathHelper;
import net.minecraft.src.World;

public class EntitySkeleton extends EntityMob {

   private static final ItemStack field_70842_d = new ItemStack(Item.field_77707_k, 1);


   public EntitySkeleton(World p_i3555_1_) {
      super(p_i3555_1_);
      this.field_70750_az = "/mob/skeleton.png";
      this.field_70697_bw = 0.25F;
      this.field_70714_bg.func_75776_a(1, new EntityAISwimming(this));
      this.field_70714_bg.func_75776_a(2, new EntityAIRestrictSun(this));
      this.field_70714_bg.func_75776_a(3, new EntityAIFleeSun(this, this.field_70697_bw));
      this.field_70714_bg.func_75776_a(4, new EntityAIArrowAttack(this, this.field_70697_bw, 1, 60));
      this.field_70714_bg.func_75776_a(5, new EntityAIWander(this, this.field_70697_bw));
      this.field_70714_bg.func_75776_a(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
      this.field_70714_bg.func_75776_a(6, new EntityAILookIdle(this));
      this.field_70715_bh.func_75776_a(1, new EntityAIHurtByTarget(this, false));
      this.field_70715_bh.func_75776_a(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 16.0F, 0, true));
   }

   public boolean func_70650_aV() {
      return true;
   }

   public int func_70667_aM() {
      return 20;
   }

   protected String func_70639_aQ() {
      return "mob.skeleton";
   }

   protected String func_70621_aR() {
      return "mob.skeletonhurt";
   }

   protected String func_70673_aS() {
      return "mob.skeletonhurt";
   }

   public EnumCreatureAttribute func_70668_bt() {
      return EnumCreatureAttribute.UNDEAD;
   }

   public void func_70636_d() {
      if(this.field_70170_p.func_72935_r() && !this.field_70170_p.field_72995_K) {
         float var1 = this.func_70013_c(1.0F);
         if(var1 > 0.5F && this.field_70170_p.func_72937_j(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70163_u), MathHelper.func_76128_c(this.field_70161_v)) && this.field_70146_Z.nextFloat() * 30.0F < (var1 - 0.4F) * 2.0F) {
            this.func_70015_d(8);
         }
      }

      super.func_70636_d();
   }

   public void func_70645_a(DamageSource p_70645_1_) {
      super.func_70645_a(p_70645_1_);
      if(p_70645_1_.func_76364_f() instanceof EntityArrow && p_70645_1_.func_76346_g() instanceof EntityPlayer) {
         EntityPlayer var2 = (EntityPlayer)p_70645_1_.func_76346_g();
         double var3 = var2.field_70165_t - this.field_70165_t;
         double var5 = var2.field_70161_v - this.field_70161_v;
         if(var3 * var3 + var5 * var5 >= 2500.0D) {
            var2.func_71029_a(AchievementList.field_76020_v);
         }
      }

   }

   protected int func_70633_aT() {
      return Item.field_77704_l.field_77779_bT;
   }

   protected void func_70628_a(boolean p_70628_1_, int p_70628_2_) {
      int var3 = this.field_70146_Z.nextInt(3 + p_70628_2_);

      int var4;
      for(var4 = 0; var4 < var3; ++var4) {
         this.func_70025_b(Item.field_77704_l.field_77779_bT, 1);
      }

      var3 = this.field_70146_Z.nextInt(3 + p_70628_2_);

      for(var4 = 0; var4 < var3; ++var4) {
         this.func_70025_b(Item.field_77755_aX.field_77779_bT, 1);
      }

   }

   protected void func_70600_l(int p_70600_1_) {
      if(p_70600_1_ > 0) {
         ItemStack var2 = new ItemStack(Item.field_77707_k);
         EnchantmentHelper.func_77504_a(this.field_70146_Z, var2, 5);
         this.func_70099_a(var2, 0.0F);
      } else {
         this.func_70025_b(Item.field_77707_k.field_77779_bT, 1);
      }

   }

}
