package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.ChunkCoordinates;
import net.minecraft.src.DamageSource;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityAIAttackOnCollide;
import net.minecraft.src.EntityAIDefendVillage;
import net.minecraft.src.EntityAIHurtByTarget;
import net.minecraft.src.EntityAILookAtVillager;
import net.minecraft.src.EntityAILookIdle;
import net.minecraft.src.EntityAIMoveThroughVillage;
import net.minecraft.src.EntityAIMoveTowardsTarget;
import net.minecraft.src.EntityAIMoveTwardsRestriction;
import net.minecraft.src.EntityAINearestAttackableTarget;
import net.minecraft.src.EntityAIWander;
import net.minecraft.src.EntityAIWatchClosest;
import net.minecraft.src.EntityGolem;
import net.minecraft.src.EntityMob;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.MathHelper;
import net.minecraft.src.Village;
import net.minecraft.src.World;

public class EntityIronGolem extends EntityGolem {

   private int field_70858_e = 0;
   Village field_70857_d = null;
   private int field_70855_f;
   private int field_70856_g;


   public EntityIronGolem(World p_i3524_1_) {
      super(p_i3524_1_);
      this.field_70750_az = "/mob/villager_golem.png";
      this.func_70105_a(1.4F, 2.9F);
      this.func_70661_as().func_75491_a(true);
      this.field_70714_bg.func_75776_a(1, new EntityAIAttackOnCollide(this, 0.25F, true));
      this.field_70714_bg.func_75776_a(2, new EntityAIMoveTowardsTarget(this, 0.22F, 32.0F));
      this.field_70714_bg.func_75776_a(3, new EntityAIMoveThroughVillage(this, 0.16F, true));
      this.field_70714_bg.func_75776_a(4, new EntityAIMoveTwardsRestriction(this, 0.16F));
      this.field_70714_bg.func_75776_a(5, new EntityAILookAtVillager(this));
      this.field_70714_bg.func_75776_a(6, new EntityAIWander(this, 0.16F));
      this.field_70714_bg.func_75776_a(7, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
      this.field_70714_bg.func_75776_a(8, new EntityAILookIdle(this));
      this.field_70715_bh.func_75776_a(1, new EntityAIDefendVillage(this));
      this.field_70715_bh.func_75776_a(2, new EntityAIHurtByTarget(this, false));
      this.field_70715_bh.func_75776_a(3, new EntityAINearestAttackableTarget(this, EntityMob.class, 16.0F, 0, false, true));
   }

   protected void func_70088_a() {
      super.func_70088_a();
      this.field_70180_af.func_75682_a(16, Byte.valueOf((byte)0));
   }

   public boolean func_70650_aV() {
      return true;
   }

   protected void func_70629_bd() {
      if(--this.field_70858_e <= 0) {
         this.field_70858_e = 70 + this.field_70146_Z.nextInt(50);
         this.field_70857_d = this.field_70170_p.field_72982_D.func_75550_a(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70163_u), MathHelper.func_76128_c(this.field_70161_v), 32);
         if(this.field_70857_d == null) {
            this.func_70677_aE();
         } else {
            ChunkCoordinates var1 = this.field_70857_d.func_75577_a();
            this.func_70598_b(var1.field_71574_a, var1.field_71572_b, var1.field_71573_c, this.field_70857_d.func_75568_b());
         }
      }

      super.func_70629_bd();
   }

   public int func_70667_aM() {
      return 100;
   }

   protected int func_70682_h(int p_70682_1_) {
      return p_70682_1_;
   }

   public void func_70636_d() {
      super.func_70636_d();
      if(this.field_70855_f > 0) {
         --this.field_70855_f;
      }

      if(this.field_70856_g > 0) {
         --this.field_70856_g;
      }

      if(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y > 2.500000277905201E-7D && this.field_70146_Z.nextInt(5) == 0) {
         int var1 = MathHelper.func_76128_c(this.field_70165_t);
         int var2 = MathHelper.func_76128_c(this.field_70163_u - 0.20000000298023224D - (double)this.field_70129_M);
         int var3 = MathHelper.func_76128_c(this.field_70161_v);
         int var4 = this.field_70170_p.func_72798_a(var1, var2, var3);
         if(var4 > 0) {
            this.field_70170_p.func_72869_a("tilecrack_" + var4, this.field_70165_t + ((double)this.field_70146_Z.nextFloat() - 0.5D) * (double)this.field_70130_N, this.field_70121_D.field_72338_b + 0.1D, this.field_70161_v + ((double)this.field_70146_Z.nextFloat() - 0.5D) * (double)this.field_70130_N, 4.0D * ((double)this.field_70146_Z.nextFloat() - 0.5D), 0.5D, ((double)this.field_70146_Z.nextFloat() - 0.5D) * 4.0D);
         }
      }

   }

   public boolean func_70686_a(Class p_70686_1_) {
      return this.func_70850_q() && EntityPlayer.class.isAssignableFrom(p_70686_1_)?false:super.func_70686_a(p_70686_1_);
   }

   public boolean func_70652_k(Entity p_70652_1_) {
      this.field_70855_f = 10;
      this.field_70170_p.func_72960_a(this, (byte)4);
      boolean var2 = p_70652_1_.func_70097_a(DamageSource.func_76358_a(this), 7 + this.field_70146_Z.nextInt(15));
      if(var2) {
         p_70652_1_.field_70181_x += 0.4000000059604645D;
      }

      this.field_70170_p.func_72956_a(this, "mob.irongolem.throw", 1.0F, 1.0F);
      return var2;
   }

   public Village func_70852_n() {
      return this.field_70857_d;
   }

   public void func_70851_e(boolean p_70851_1_) {
      this.field_70856_g = p_70851_1_?400:0;
      this.field_70170_p.func_72960_a(this, (byte)11);
   }

   protected String func_70639_aQ() {
      return "none";
   }

   protected String func_70621_aR() {
      return "mob.irongolem.hit";
   }

   protected String func_70673_aS() {
      return "mob.irongolem.death";
   }

   protected void func_70036_a(int p_70036_1_, int p_70036_2_, int p_70036_3_, int p_70036_4_) {
      this.field_70170_p.func_72956_a(this, "mob.irongolem.walk", 1.0F, 1.0F);
   }

   protected void func_70628_a(boolean p_70628_1_, int p_70628_2_) {
      int var3 = this.field_70146_Z.nextInt(3);

      int var4;
      for(var4 = 0; var4 < var3; ++var4) {
         this.func_70025_b(Block.field_72107_ae.field_71990_ca, 1);
      }

      var4 = 3 + this.field_70146_Z.nextInt(3);

      for(int var5 = 0; var5 < var4; ++var5) {
         this.func_70025_b(Item.field_77703_o.field_77779_bT, 1);
      }

   }

   public int func_70853_p() {
      return this.field_70856_g;
   }

   public boolean func_70850_q() {
      return (this.field_70180_af.func_75683_a(16) & 1) != 0;
   }

   public void func_70849_f(boolean p_70849_1_) {
      byte var2 = this.field_70180_af.func_75683_a(16);
      if(p_70849_1_) {
         this.field_70180_af.func_75692_b(16, Byte.valueOf((byte)(var2 | 1)));
      } else {
         this.field_70180_af.func_75692_b(16, Byte.valueOf((byte)(var2 & -2)));
      }

   }
}
