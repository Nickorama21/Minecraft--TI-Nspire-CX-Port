package net.minecraft.src;

import net.minecraft.src.EntityAIAttackOnCollide;
import net.minecraft.src.EntityAIBreakDoor;
import net.minecraft.src.EntityAIHurtByTarget;
import net.minecraft.src.EntityAILookIdle;
import net.minecraft.src.EntityAIMoveThroughVillage;
import net.minecraft.src.EntityAIMoveTwardsRestriction;
import net.minecraft.src.EntityAINearestAttackableTarget;
import net.minecraft.src.EntityAISwimming;
import net.minecraft.src.EntityAIWander;
import net.minecraft.src.EntityAIWatchClosest;
import net.minecraft.src.EntityMob;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EntityVillager;
import net.minecraft.src.EnumCreatureAttribute;
import net.minecraft.src.Item;
import net.minecraft.src.MathHelper;
import net.minecraft.src.World;

public class EntityZombie extends EntityMob {

   public EntityZombie(World p_i3558_1_) {
      super(p_i3558_1_);
      this.field_70750_az = "/mob/zombie.png";
      this.field_70697_bw = 0.23F;
      this.field_70815_f = 4;
      this.func_70661_as().func_75498_b(true);
      this.field_70714_bg.func_75776_a(0, new EntityAISwimming(this));
      this.field_70714_bg.func_75776_a(1, new EntityAIBreakDoor(this));
      this.field_70714_bg.func_75776_a(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, this.field_70697_bw, false));
      this.field_70714_bg.func_75776_a(3, new EntityAIAttackOnCollide(this, EntityVillager.class, this.field_70697_bw, true));
      this.field_70714_bg.func_75776_a(4, new EntityAIMoveTwardsRestriction(this, this.field_70697_bw));
      this.field_70714_bg.func_75776_a(5, new EntityAIMoveThroughVillage(this, this.field_70697_bw, false));
      this.field_70714_bg.func_75776_a(6, new EntityAIWander(this, this.field_70697_bw));
      this.field_70714_bg.func_75776_a(7, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
      this.field_70714_bg.func_75776_a(7, new EntityAILookIdle(this));
      this.field_70715_bh.func_75776_a(1, new EntityAIHurtByTarget(this, false));
      this.field_70715_bh.func_75776_a(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 16.0F, 0, true));
      this.field_70715_bh.func_75776_a(2, new EntityAINearestAttackableTarget(this, EntityVillager.class, 16.0F, 0, false));
   }

   public int func_70667_aM() {
      return 20;
   }

   public int func_70658_aO() {
      return 2;
   }

   protected boolean func_70650_aV() {
      return true;
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

   protected String func_70639_aQ() {
      return "mob.zombie";
   }

   protected String func_70621_aR() {
      return "mob.zombiehurt";
   }

   protected String func_70673_aS() {
      return "mob.zombiedeath";
   }

   protected int func_70633_aT() {
      return Item.field_77737_bm.field_77779_bT;
   }

   public EnumCreatureAttribute func_70668_bt() {
      return EnumCreatureAttribute.UNDEAD;
   }

   protected void func_70600_l(int p_70600_1_) {
      switch(this.field_70146_Z.nextInt(4)) {
      case 0:
         this.func_70025_b(Item.field_77716_q.field_77779_bT, 1);
         break;
      case 1:
         this.func_70025_b(Item.field_77812_ad.field_77779_bT, 1);
         break;
      case 2:
         this.func_70025_b(Item.field_77703_o.field_77779_bT, 1);
         break;
      case 3:
         this.func_70025_b(Item.field_77695_f.field_77779_bT, 1);
      }

   }
}
