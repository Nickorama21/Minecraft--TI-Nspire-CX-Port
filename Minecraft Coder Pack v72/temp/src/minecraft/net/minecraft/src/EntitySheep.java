package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.EntityAIEatGrass;
import net.minecraft.src.EntityAIFollowParent;
import net.minecraft.src.EntityAILookIdle;
import net.minecraft.src.EntityAIMate;
import net.minecraft.src.EntityAIPanic;
import net.minecraft.src.EntityAISwimming;
import net.minecraft.src.EntityAITempt;
import net.minecraft.src.EntityAIWander;
import net.minecraft.src.EntityAIWatchClosest;
import net.minecraft.src.EntityAnimal;
import net.minecraft.src.EntityItem;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.MathHelper;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.World;

public class EntitySheep extends EntityAnimal {

   public static final float[][] field_70898_d = new float[][]{{1.0F, 1.0F, 1.0F}, {0.95F, 0.7F, 0.2F}, {0.9F, 0.5F, 0.85F}, {0.6F, 0.7F, 0.95F}, {0.9F, 0.9F, 0.2F}, {0.5F, 0.8F, 0.1F}, {0.95F, 0.7F, 0.8F}, {0.3F, 0.3F, 0.3F}, {0.6F, 0.6F, 0.6F}, {0.3F, 0.6F, 0.7F}, {0.7F, 0.4F, 0.9F}, {0.2F, 0.4F, 0.8F}, {0.5F, 0.4F, 0.3F}, {0.4F, 0.5F, 0.2F}, {0.8F, 0.3F, 0.3F}, {0.1F, 0.1F, 0.1F}};
   private int field_70899_e;
   private EntityAIEatGrass field_70897_f = new EntityAIEatGrass(this);


   public EntitySheep(World p_i3521_1_) {
      super(p_i3521_1_);
      this.field_70750_az = "/mob/sheep.png";
      this.func_70105_a(0.9F, 1.3F);
      float var2 = 0.23F;
      this.func_70661_as().func_75491_a(true);
      this.field_70714_bg.func_75776_a(0, new EntityAISwimming(this));
      this.field_70714_bg.func_75776_a(1, new EntityAIPanic(this, 0.38F));
      this.field_70714_bg.func_75776_a(2, new EntityAIMate(this, var2));
      this.field_70714_bg.func_75776_a(3, new EntityAITempt(this, 0.25F, Item.field_77685_T.field_77779_bT, false));
      this.field_70714_bg.func_75776_a(4, new EntityAIFollowParent(this, 0.25F));
      this.field_70714_bg.func_75776_a(5, this.field_70897_f);
      this.field_70714_bg.func_75776_a(6, new EntityAIWander(this, var2));
      this.field_70714_bg.func_75776_a(7, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
      this.field_70714_bg.func_75776_a(8, new EntityAILookIdle(this));
   }

   protected boolean func_70650_aV() {
      return true;
   }

   protected void func_70619_bc() {
      this.field_70899_e = this.field_70897_f.func_75362_f();
      super.func_70619_bc();
   }

   public void func_70636_d() {
      if(this.field_70170_p.field_72995_K) {
         this.field_70899_e = Math.max(0, this.field_70899_e - 1);
      }

      super.func_70636_d();
   }

   public int func_70667_aM() {
      return 8;
   }

   protected void func_70088_a() {
      super.func_70088_a();
      this.field_70180_af.func_75682_a(16, new Byte((byte)0));
   }

   protected void func_70628_a(boolean p_70628_1_, int p_70628_2_) {
      if(!this.func_70892_o()) {
         this.func_70099_a(new ItemStack(Block.field_72101_ab.field_71990_ca, 1, this.func_70896_n()), 0.0F);
      }

   }

   protected int func_70633_aT() {
      return Block.field_72101_ab.field_71990_ca;
   }

   public void func_70103_a(byte p_70103_1_) {
      if(p_70103_1_ == 10) {
         this.field_70899_e = 40;
      } else {
         super.func_70103_a(p_70103_1_);
      }

   }

   public float func_70894_j(float p_70894_1_) {
      return this.field_70899_e <= 0?0.0F:(this.field_70899_e >= 4 && this.field_70899_e <= 36?1.0F:(this.field_70899_e < 4?((float)this.field_70899_e - p_70894_1_) / 4.0F:-((float)(this.field_70899_e - 40) - p_70894_1_) / 4.0F));
   }

   public float func_70890_k(float p_70890_1_) {
      if(this.field_70899_e > 4 && this.field_70899_e <= 36) {
         float var2 = ((float)(this.field_70899_e - 4) - p_70890_1_) / 32.0F;
         return 0.62831855F + 0.21991149F * MathHelper.func_76126_a(var2 * 28.7F);
      } else {
         return this.field_70899_e > 0?0.62831855F:this.field_70125_A / 57.295776F;
      }
   }

   public boolean func_70085_c(EntityPlayer p_70085_1_) {
      ItemStack var2 = p_70085_1_.field_71071_by.func_70448_g();
      if(var2 != null && var2.field_77993_c == Item.field_77745_be.field_77779_bT && !this.func_70892_o() && !this.func_70631_g_()) {
         if(!this.field_70170_p.field_72995_K) {
            this.func_70893_e(true);
            int var3 = 1 + this.field_70146_Z.nextInt(3);

            for(int var4 = 0; var4 < var3; ++var4) {
               EntityItem var5 = this.func_70099_a(new ItemStack(Block.field_72101_ab.field_71990_ca, 1, this.func_70896_n()), 1.0F);
               var5.field_70181_x += (double)(this.field_70146_Z.nextFloat() * 0.05F);
               var5.field_70159_w += (double)((this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.1F);
               var5.field_70179_y += (double)((this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.1F);
            }
         }

         var2.func_77972_a(1, p_70085_1_);
      }

      return super.func_70085_c(p_70085_1_);
   }

   public void func_70014_b(NBTTagCompound p_70014_1_) {
      super.func_70014_b(p_70014_1_);
      p_70014_1_.func_74757_a("Sheared", this.func_70892_o());
      p_70014_1_.func_74774_a("Color", (byte)this.func_70896_n());
   }

   public void func_70037_a(NBTTagCompound p_70037_1_) {
      super.func_70037_a(p_70037_1_);
      this.func_70893_e(p_70037_1_.func_74767_n("Sheared"));
      this.func_70891_b(p_70037_1_.func_74771_c("Color"));
   }

   protected String func_70639_aQ() {
      return "mob.sheep";
   }

   protected String func_70621_aR() {
      return "mob.sheep";
   }

   protected String func_70673_aS() {
      return "mob.sheep";
   }

   public int func_70896_n() {
      return this.field_70180_af.func_75683_a(16) & 15;
   }

   public void func_70891_b(int p_70891_1_) {
      byte var2 = this.field_70180_af.func_75683_a(16);
      this.field_70180_af.func_75692_b(16, Byte.valueOf((byte)(var2 & 240 | p_70891_1_ & 15)));
   }

   public boolean func_70892_o() {
      return (this.field_70180_af.func_75683_a(16) & 16) != 0;
   }

   public void func_70893_e(boolean p_70893_1_) {
      byte var2 = this.field_70180_af.func_75683_a(16);
      if(p_70893_1_) {
         this.field_70180_af.func_75692_b(16, Byte.valueOf((byte)(var2 | 16)));
      } else {
         this.field_70180_af.func_75692_b(16, Byte.valueOf((byte)(var2 & -17)));
      }

   }

   public static int func_70895_a(Random p_70895_0_) {
      int var1 = p_70895_0_.nextInt(100);
      return var1 < 5?15:(var1 < 10?7:(var1 < 15?8:(var1 < 18?12:(p_70895_0_.nextInt(500) == 0?6:0))));
   }

   public EntityAnimal func_70879_a(EntityAnimal p_70879_1_) {
      EntitySheep var2 = (EntitySheep)p_70879_1_;
      EntitySheep var3 = new EntitySheep(this.field_70170_p);
      if(this.field_70146_Z.nextBoolean()) {
         var3.func_70891_b(this.func_70896_n());
      } else {
         var3.func_70891_b(var2.func_70896_n());
      }

      return var3;
   }

   public void func_70615_aA() {
      this.func_70893_e(false);
      if(this.func_70631_g_()) {
         int var1 = this.func_70874_b() + 1200;
         if(var1 > 0) {
            var1 = 0;
         }

         this.func_70873_a(var1);
      }

   }

}
