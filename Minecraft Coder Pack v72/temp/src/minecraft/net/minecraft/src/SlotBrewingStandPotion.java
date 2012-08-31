package net.minecraft.src;

import net.minecraft.src.AchievementList;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.IInventory;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Slot;

class SlotBrewingStandPotion extends Slot {

   private EntityPlayer field_75244_a;


   public SlotBrewingStandPotion(EntityPlayer p_i3599_1_, IInventory p_i3599_2_, int p_i3599_3_, int p_i3599_4_, int p_i3599_5_) {
      super(p_i3599_2_, p_i3599_3_, p_i3599_4_, p_i3599_5_);
      this.field_75244_a = p_i3599_1_;
   }

   public boolean func_75214_a(ItemStack p_75214_1_) {
      return func_75243_a_(p_75214_1_);
   }

   public int func_75219_a() {
      return 1;
   }

   public void func_75213_b(ItemStack p_75213_1_) {
      if(p_75213_1_.field_77993_c == Item.field_77726_bs.field_77779_bT && p_75213_1_.func_77960_j() > 0) {
         this.field_75244_a.func_71064_a(AchievementList.field_76001_A, 1);
      }

      super.func_75213_b(p_75213_1_);
   }

   public static boolean func_75243_a_(ItemStack p_75243_0_) {
      return p_75243_0_ != null && (p_75243_0_.field_77993_c == Item.field_77726_bs.field_77779_bT || p_75243_0_.field_77993_c == Item.field_77729_bt.field_77779_bT);
   }
}
