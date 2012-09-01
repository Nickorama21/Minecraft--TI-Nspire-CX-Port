package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EntitySilverfish;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.World;

public class BlockSilverfish extends Block {

   public static final String[] field_72155_a = new String[]{"stone", "cobble", "brick"};


   public BlockSilverfish(int p_i3999_1_) {
      super(p_i3999_1_, 1, Material.field_76267_y);
      this.func_71848_c(0.0F);
      this.func_71849_a(CreativeTabs.field_78031_c);
   }

   public int func_71858_a(int p_71858_1_, int p_71858_2_) {
      return p_71858_2_ == 1?Block.field_71978_w.field_72059_bZ:(p_71858_2_ == 2?Block.field_72007_bm.field_72059_bZ:Block.field_71981_t.field_72059_bZ);
   }

   public void func_71898_d(World p_71898_1_, int p_71898_2_, int p_71898_3_, int p_71898_4_, int p_71898_5_) {
      if(!p_71898_1_.field_72995_K) {
         EntitySilverfish var6 = new EntitySilverfish(p_71898_1_);
         var6.func_70012_b((double)p_71898_2_ + 0.5D, (double)p_71898_3_, (double)p_71898_4_ + 0.5D, 0.0F, 0.0F);
         p_71898_1_.func_72838_d(var6);
         var6.func_70656_aK();
      }

      super.func_71898_d(p_71898_1_, p_71898_2_, p_71898_3_, p_71898_4_, p_71898_5_);
   }

   public int func_71925_a(Random p_71925_1_) {
      return 0;
   }

   public static boolean func_72154_e(int p_72154_0_) {
      return p_72154_0_ == Block.field_71981_t.field_71990_ca || p_72154_0_ == Block.field_71978_w.field_71990_ca || p_72154_0_ == Block.field_72007_bm.field_71990_ca;
   }

   public static int func_72153_f(int p_72153_0_) {
      return p_72153_0_ == Block.field_71978_w.field_71990_ca?1:(p_72153_0_ == Block.field_72007_bm.field_71990_ca?2:0);
   }

   protected ItemStack func_71880_c_(int p_71880_1_) {
      Block var2 = Block.field_71981_t;
      if(p_71880_1_ == 1) {
         var2 = Block.field_71978_w;
      }

      if(p_71880_1_ == 2) {
         var2 = Block.field_72007_bm;
      }

      return new ItemStack(var2);
   }

}
