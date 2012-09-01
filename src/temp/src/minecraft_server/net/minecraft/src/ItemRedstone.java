package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.World;

public class ItemRedstone extends Item {

   public ItemRedstone(int p_i3678_1_) {
      super(p_i3678_1_);
      this.func_77637_a(CreativeTabs.field_78028_d);
   }

   public boolean func_77648_a(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
      if(p_77648_3_.func_72798_a(p_77648_4_, p_77648_5_, p_77648_6_) != Block.field_72037_aS.field_71990_ca) {
         if(p_77648_7_ == 0) {
            --p_77648_5_;
         }

         if(p_77648_7_ == 1) {
            ++p_77648_5_;
         }

         if(p_77648_7_ == 2) {
            --p_77648_6_;
         }

         if(p_77648_7_ == 3) {
            ++p_77648_6_;
         }

         if(p_77648_7_ == 4) {
            --p_77648_4_;
         }

         if(p_77648_7_ == 5) {
            ++p_77648_4_;
         }

         if(!p_77648_3_.func_72799_c(p_77648_4_, p_77648_5_, p_77648_6_)) {
            return false;
         }
      }

      if(!p_77648_2_.func_71031_e(p_77648_4_, p_77648_5_, p_77648_6_)) {
         return false;
      } else {
         if(Block.field_72075_av.func_71930_b(p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_)) {
            --p_77648_1_.field_77994_a;
            p_77648_3_.func_72859_e(p_77648_4_, p_77648_5_, p_77648_6_, Block.field_72075_av.field_71990_ca);
         }

         return true;
      }
   }
}
