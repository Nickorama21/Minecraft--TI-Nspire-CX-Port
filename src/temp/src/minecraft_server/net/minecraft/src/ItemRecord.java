package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.BlockJukeBox;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.World;

public class ItemRecord extends Item {

   public final String field_77837_a;


   protected ItemRecord(int p_i3677_1_, String p_i3677_2_) {
      super(p_i3677_1_);
      this.field_77837_a = p_i3677_2_;
      this.field_77777_bU = 1;
      this.func_77637_a(CreativeTabs.field_78026_f);
   }

   public boolean func_77648_a(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
      if(p_77648_3_.func_72798_a(p_77648_4_, p_77648_5_, p_77648_6_) == Block.field_72032_aY.field_71990_ca && p_77648_3_.func_72805_g(p_77648_4_, p_77648_5_, p_77648_6_) == 0) {
         if(p_77648_3_.field_72995_K) {
            return true;
         } else {
            ((BlockJukeBox)Block.field_72032_aY).func_72277_e(p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_, this.field_77779_bT);
            p_77648_3_.func_72889_a((EntityPlayer)null, 1005, p_77648_4_, p_77648_5_, p_77648_6_, this.field_77779_bT);
            --p_77648_1_.field_77994_a;
            return true;
         }
      } else {
         return false;
      }
   }
}
