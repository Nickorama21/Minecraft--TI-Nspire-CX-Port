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
import net.minecraft.src.ItemStack;
import net.minecraft.src.World;

public class EntityCow extends EntityAnimal {

   public EntityCow(World p_i3516_1_) {
      super(p_i3516_1_);
      this.field_70750_az = "/mob/cow.png";
      this.func_70105_a(0.9F, 1.3F);
      this.func_70661_as().func_75491_a(true);
      this.field_70714_bg.func_75776_a(0, new EntityAISwimming(this));
      this.field_70714_bg.func_75776_a(1, new EntityAIPanic(this, 0.38F));
      this.field_70714_bg.func_75776_a(2, new EntityAIMate(this, 0.2F));
      this.field_70714_bg.func_75776_a(3, new EntityAITempt(this, 0.25F, Item.field_77685_T.field_77779_bT, false));
      this.field_70714_bg.func_75776_a(4, new EntityAIFollowParent(this, 0.25F));
      this.field_70714_bg.func_75776_a(5, new EntityAIWander(this, 0.2F));
      this.field_70714_bg.func_75776_a(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
      this.field_70714_bg.func_75776_a(7, new EntityAILookIdle(this));
   }

   public boolean func_70650_aV() {
      return true;
   }

   public int func_70667_aM() {
      return 10;
   }

   protected String func_70639_aQ() {
      return "mob.cow";
   }

   protected String func_70621_aR() {
      return "mob.cowhurt";
   }

   protected String func_70673_aS() {
      return "mob.cowhurt";
   }

   protected float func_70599_aP() {
      return 0.4F;
   }

   protected int func_70633_aT() {
      return Item.field_77770_aF.field_77779_bT;
   }

   protected void func_70628_a(boolean p_70628_1_, int p_70628_2_) {
      int var3 = this.field_70146_Z.nextInt(3) + this.field_70146_Z.nextInt(1 + p_70628_2_);

      int var4;
      for(var4 = 0; var4 < var3; ++var4) {
         this.func_70025_b(Item.field_77770_aF.field_77779_bT, 1);
      }

      var3 = this.field_70146_Z.nextInt(3) + 1 + this.field_70146_Z.nextInt(1 + p_70628_2_);

      for(var4 = 0; var4 < var3; ++var4) {
         if(this.func_70027_ad()) {
            this.func_70025_b(Item.field_77734_bj.field_77779_bT, 1);
         } else {
            this.func_70025_b(Item.field_77741_bi.field_77779_bT, 1);
         }
      }

   }

   public boolean func_70085_c(EntityPlayer p_70085_1_) {
      ItemStack var2 = p_70085_1_.field_71071_by.func_70448_g();
      if(var2 != null && var2.field_77993_c == Item.field_77788_aw.field_77779_bT) {
         if(--var2.field_77994_a <= 0) {
            p_70085_1_.field_71071_by.func_70299_a(p_70085_1_.field_71071_by.field_70461_c, new ItemStack(Item.field_77771_aG));
         } else if(!p_70085_1_.field_71071_by.func_70441_a(new ItemStack(Item.field_77771_aG))) {
            p_70085_1_.func_71021_b(new ItemStack(Item.field_77771_aG.field_77779_bT, 1, 0));
         }

         return true;
      } else {
         return super.func_70085_c(p_70085_1_);
      }
   }

   public EntityAnimal func_70879_a(EntityAnimal p_70879_1_) {
      return new EntityCow(this.field_70170_p);
   }
}
