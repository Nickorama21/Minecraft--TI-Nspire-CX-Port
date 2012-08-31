package net.minecraft.src;

import java.util.Iterator;
import java.util.List;
import net.minecraft.src.DamageSource;
import net.minecraft.src.EnchantmentHelper;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EntityZombie;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.World;

public class EntityPigZombie extends EntityZombie {

   private int field_70837_d = 0;
   private int field_70838_e = 0;
   private static final ItemStack field_70836_g = new ItemStack(Item.field_77672_G, 1);


   public EntityPigZombie(World p_i3553_1_) {
      super(p_i3553_1_);
      this.field_70750_az = "/mob/pigzombie.png";
      this.field_70697_bw = 0.5F;
      this.field_70815_f = 5;
      this.field_70178_ae = true;
   }

   protected boolean func_70650_aV() {
      return false;
   }

   public void func_70071_h_() {
      this.field_70697_bw = this.field_70789_a != null?0.95F:0.5F;
      if(this.field_70838_e > 0 && --this.field_70838_e == 0) {
         this.field_70170_p.func_72956_a(this, "mob.zombiepig.zpigangry", this.func_70599_aP() * 2.0F, ((this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.2F + 1.0F) * 1.8F);
      }

      super.func_70071_h_();
   }

   public boolean func_70601_bi() {
      return this.field_70170_p.field_73013_u > 0 && this.field_70170_p.func_72855_b(this.field_70121_D) && this.field_70170_p.func_72945_a(this, this.field_70121_D).isEmpty() && !this.field_70170_p.func_72953_d(this.field_70121_D);
   }

   public void func_70014_b(NBTTagCompound p_70014_1_) {
      super.func_70014_b(p_70014_1_);
      p_70014_1_.func_74777_a("Anger", (short)this.field_70837_d);
   }

   public void func_70037_a(NBTTagCompound p_70037_1_) {
      super.func_70037_a(p_70037_1_);
      this.field_70837_d = p_70037_1_.func_74765_d("Anger");
   }

   protected Entity func_70782_k() {
      return this.field_70837_d == 0?null:super.func_70782_k();
   }

   public boolean func_70097_a(DamageSource p_70097_1_, int p_70097_2_) {
      Entity var3 = p_70097_1_.func_76346_g();
      if(var3 instanceof EntityPlayer) {
         List var4 = this.field_70170_p.func_72839_b(this, this.field_70121_D.func_72314_b(32.0D, 32.0D, 32.0D));
         Iterator var5 = var4.iterator();

         while(var5.hasNext()) {
            Entity var6 = (Entity)var5.next();
            if(var6 instanceof EntityPigZombie) {
               EntityPigZombie var7 = (EntityPigZombie)var6;
               var7.func_70835_c(var3);
            }
         }

         this.func_70835_c(var3);
      }

      return super.func_70097_a(p_70097_1_, p_70097_2_);
   }

   private void func_70835_c(Entity p_70835_1_) {
      this.field_70789_a = p_70835_1_;
      this.field_70837_d = 400 + this.field_70146_Z.nextInt(400);
      this.field_70838_e = this.field_70146_Z.nextInt(40);
   }

   protected String func_70639_aQ() {
      return "mob.zombiepig.zpig";
   }

   protected String func_70621_aR() {
      return "mob.zombiepig.zpighurt";
   }

   protected String func_70673_aS() {
      return "mob.zombiepig.zpigdeath";
   }

   protected void func_70628_a(boolean p_70628_1_, int p_70628_2_) {
      int var3 = this.field_70146_Z.nextInt(2 + p_70628_2_);

      int var4;
      for(var4 = 0; var4 < var3; ++var4) {
         this.func_70025_b(Item.field_77737_bm.field_77779_bT, 1);
      }

      var3 = this.field_70146_Z.nextInt(2 + p_70628_2_);

      for(var4 = 0; var4 < var3; ++var4) {
         this.func_70025_b(Item.field_77733_bq.field_77779_bT, 1);
      }

   }

   protected void func_70600_l(int p_70600_1_) {
      if(p_70600_1_ > 0) {
         ItemStack var2 = new ItemStack(Item.field_77672_G);
         EnchantmentHelper.func_77504_a(this.field_70146_Z, var2, 5);
         this.func_70099_a(var2, 0.0F);
      } else {
         int var3 = this.field_70146_Z.nextInt(3);
         if(var3 == 0) {
            this.func_70025_b(Item.field_77717_p.field_77779_bT, 1);
         } else if(var3 == 1) {
            this.func_70025_b(Item.field_77672_G.field_77779_bT, 1);
         } else if(var3 == 2) {
            this.func_70025_b(Item.field_77796_al.field_77779_bT, 1);
         }
      }

   }

   protected int func_70633_aT() {
      return Item.field_77737_bm.field_77779_bT;
   }

   public ItemStack func_70694_bm() {
      return field_70836_g;
   }

}
