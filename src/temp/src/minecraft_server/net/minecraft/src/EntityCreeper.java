package net.minecraft.src;

import net.minecraft.src.DamageSource;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityAIAttackOnCollide;
import net.minecraft.src.EntityAIAvoidEntity;
import net.minecraft.src.EntityAICreeperSwell;
import net.minecraft.src.EntityAIHurtByTarget;
import net.minecraft.src.EntityAILookIdle;
import net.minecraft.src.EntityAINearestAttackableTarget;
import net.minecraft.src.EntityAISwimming;
import net.minecraft.src.EntityAIWander;
import net.minecraft.src.EntityAIWatchClosest;
import net.minecraft.src.EntityLightningBolt;
import net.minecraft.src.EntityMob;
import net.minecraft.src.EntityOcelot;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EntitySkeleton;
import net.minecraft.src.Item;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.World;

public class EntityCreeper extends EntityMob {

   int field_70833_d;
   int field_70834_e;


   public EntityCreeper(World p_i3547_1_) {
      super(p_i3547_1_);
      this.field_70750_az = "/mob/creeper.png";
      this.field_70714_bg.func_75776_a(1, new EntityAISwimming(this));
      this.field_70714_bg.func_75776_a(2, new EntityAICreeperSwell(this));
      this.field_70714_bg.func_75776_a(3, new EntityAIAvoidEntity(this, EntityOcelot.class, 6.0F, 0.25F, 0.3F));
      this.field_70714_bg.func_75776_a(4, new EntityAIAttackOnCollide(this, 0.25F, false));
      this.field_70714_bg.func_75776_a(5, new EntityAIWander(this, 0.2F));
      this.field_70714_bg.func_75776_a(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
      this.field_70714_bg.func_75776_a(6, new EntityAILookIdle(this));
      this.field_70715_bh.func_75776_a(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 16.0F, 0, true));
      this.field_70715_bh.func_75776_a(2, new EntityAIHurtByTarget(this, false));
   }

   public boolean func_70650_aV() {
      return true;
   }

   public int func_70667_aM() {
      return 20;
   }

   protected void func_70088_a() {
      super.func_70088_a();
      this.field_70180_af.func_75682_a(16, Byte.valueOf((byte)-1));
      this.field_70180_af.func_75682_a(17, Byte.valueOf((byte)0));
   }

   public void func_70014_b(NBTTagCompound p_70014_1_) {
      super.func_70014_b(p_70014_1_);
      if(this.field_70180_af.func_75683_a(17) == 1) {
         p_70014_1_.func_74757_a("powered", true);
      }

   }

   public void func_70037_a(NBTTagCompound p_70037_1_) {
      super.func_70037_a(p_70037_1_);
      this.field_70180_af.func_75692_b(17, Byte.valueOf((byte)(p_70037_1_.func_74767_n("powered")?1:0)));
   }

   public void func_70071_h_() {
      if(this.func_70089_S()) {
         this.field_70834_e = this.field_70833_d;
         int var1 = this.func_70832_p();
         if(var1 > 0 && this.field_70833_d == 0) {
            this.field_70170_p.func_72956_a(this, "random.fuse", 1.0F, 0.5F);
         }

         this.field_70833_d += var1;
         if(this.field_70833_d < 0) {
            this.field_70833_d = 0;
         }

         if(this.field_70833_d >= 30) {
            this.field_70833_d = 30;
            if(!this.field_70170_p.field_72995_K) {
               if(this.func_70830_n()) {
                  this.field_70170_p.func_72876_a(this, this.field_70165_t, this.field_70163_u, this.field_70161_v, 6.0F);
               } else {
                  this.field_70170_p.func_72876_a(this, this.field_70165_t, this.field_70163_u, this.field_70161_v, 3.0F);
               }

               this.func_70106_y();
            }
         }
      }

      super.func_70071_h_();
   }

   protected String func_70621_aR() {
      return "mob.creeper";
   }

   protected String func_70673_aS() {
      return "mob.creeperdeath";
   }

   public void func_70645_a(DamageSource p_70645_1_) {
      super.func_70645_a(p_70645_1_);
      if(p_70645_1_.func_76346_g() instanceof EntitySkeleton) {
         this.func_70025_b(Item.field_77819_bI.field_77779_bT + this.field_70146_Z.nextInt(10), 1);
      }

   }

   public boolean func_70652_k(Entity p_70652_1_) {
      return true;
   }

   public boolean func_70830_n() {
      return this.field_70180_af.func_75683_a(17) == 1;
   }

   protected int func_70633_aT() {
      return Item.field_77677_M.field_77779_bT;
   }

   public int func_70832_p() {
      return this.field_70180_af.func_75683_a(16);
   }

   public void func_70829_a(int p_70829_1_) {
      this.field_70180_af.func_75692_b(16, Byte.valueOf((byte)p_70829_1_));
   }

   public void func_70077_a(EntityLightningBolt p_70077_1_) {
      super.func_70077_a(p_70077_1_);
      this.field_70180_af.func_75692_b(17, Byte.valueOf((byte)1));
   }
}
