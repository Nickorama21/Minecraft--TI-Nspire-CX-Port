package net.minecraft.src;

import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EntityPainting;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.World;

public class ItemPainting extends Item {

   public ItemPainting(int p_i3672_1_) {
      super(p_i3672_1_);
      this.func_77637_a(CreativeTabs.field_78031_c);
   }

   public boolean func_77648_a(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
      if(p_77648_7_ == 0) {
         return false;
      } else if(p_77648_7_ == 1) {
         return false;
      } else {
         byte var11 = 0;
         if(p_77648_7_ == 4) {
            var11 = 1;
         }

         if(p_77648_7_ == 3) {
            var11 = 2;
         }

         if(p_77648_7_ == 5) {
            var11 = 3;
         }

         if(!p_77648_2_.func_71031_e(p_77648_4_, p_77648_5_, p_77648_6_)) {
            return false;
         } else {
            EntityPainting var12 = new EntityPainting(p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_, var11);
            if(var12.func_70518_d()) {
               if(!p_77648_3_.field_72995_K) {
                  p_77648_3_.func_72838_d(var12);
               }

               --p_77648_1_.field_77994_a;
            }

            return true;
         }
      }
   }
}
