package net.minecraft.src;

import net.minecraft.src.EntityAIFollowParent;
import net.minecraft.src.EntityAILookIdle;
import net.minecraft.src.EntityAIMate;
import net.minecraft.src.EntityAIPanic;
import net.minecraft.src.EntityAISwimming;
import net.minecraft.src.EntityAITempt;
import net.minecraft.src.EntityAIWander;
import net.minecraft.src.EntityAIWatchClosest;
import net.minecraft.src.EntityAnimal;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.World;

public class EntityChicken extends EntityAnimal {

   public boolean field_70885_d = false;
   public float field_70886_e = 0.0F;
   public float field_70883_f = 0.0F;
   public float field_70884_g;
   public float field_70888_h;
   public float field_70889_i = 1.0F;
   public int field_70887_j;


   public EntityChicken(World p_i3515_1_) {
      super(p_i3515_1_);
      this.field_70750_az = "/mob/chicken.png";
      this.func_70105_a(0.3F, 0.7F);
      this.field_70887_j = this.field_70146_Z.nextInt(6000) + 6000;
      float var2 = 0.25F;
      this.field_70714_bg.func_75776_a(0, new EntityAISwimming(this));
      this.field_70714_bg.func_75776_a(1, new EntityAIPanic(this, 0.38F));
      this.field_70714_bg.func_75776_a(2, new EntityAIMate(this, var2));
      this.field_70714_bg.func_75776_a(3, new EntityAITempt(this, 0.25F, Item.field_77685_T.field_77779_bT, false));
      this.field_70714_bg.func_75776_a(4, new EntityAIFollowParent(this, 0.28F));
      this.field_70714_bg.func_75776_a(5, new EntityAIWander(this, var2));
      this.field_70714_bg.func_75776_a(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
      this.field_70714_bg.func_75776_a(7, new EntityAILookIdle(this));
   }

   public boolean func_70650_aV() {
      return true;
   }

   public int func_70667_aM() {
      return 4;
   }

   public void func_70636_d() {
      super.func_70636_d();
      this.field_70888_h = this.field_70886_e;
      this.field_70884_g = this.field_70883_f;
      this.field_70883_f = (float)((double)this.field_70883_f + (double)(this.field_70122_E?-1:4) * 0.3D);
      if(this.field_70883_f < 0.0F) {
         this.field_70883_f = 0.0F;
      }

      if(this.field_70883_f > 1.0F) {
         this.field_70883_f = 1.0F;
      }

      if(!this.field_70122_E && this.field_70889_i < 1.0F) {
         this.field_70889_i = 1.0F;
      }

      this.field_70889_i = (float)((double)this.field_70889_i * 0.9D);
      if(!this.field_70122_E && this.field_70181_x < 0.0D) {
         this.field_70181_x *= 0.6D;
      }

      this.field_70886_e += this.field_70889_i * 2.0F;
      if(!this.func_70631_g_() && !this.field_70170_p.field_72995_K && --this.field_70887_j <= 0) {
         this.field_70170_p.func_72956_a(this, "mob.chickenplop", 1.0F, (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.2F + 1.0F);
         this.func_70025_b(Item.field_77764_aP.field_77779_bT, 1);
         this.field_70887_j = this.field_70146_Z.nextInt(6000) + 6000;
      }

   }

   protected void func_70069_a(float p_70069_1_) {}

   protected String func_70639_aQ() {
      return "mob.chicken";
   }

   protected String func_70621_aR() {
      return "mob.chickenhurt";
   }

   protected String func_70673_aS() {
      return "mob.chickenhurt";
   }

   protected int func_70633_aT() {
      return Item.field_77676_L.field_77779_bT;
   }

   protected void func_70628_a(boolean p_70628_1_, int p_70628_2_) {
      int var3 = this.field_70146_Z.nextInt(3) + this.field_70146_Z.nextInt(1 + p_70628_2_);

      for(int var4 = 0; var4 < var3; ++var4) {
         this.func_70025_b(Item.field_77676_L.field_77779_bT, 1);
      }

      if(this.func_70027_ad()) {
         this.func_70025_b(Item.field_77736_bl.field_77779_bT, 1);
      } else {
         this.func_70025_b(Item.field_77735_bk.field_77779_bT, 1);
      }

   }

   public EntityAnimal func_70879_a(EntityAnimal p_70879_1_) {
      return new EntityChicken(this.field_70170_p);
   }
}
