package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.BiomeGenBase;
import net.minecraft.src.Block;
import net.minecraft.src.World;

public class BiomeGenHills extends BiomeGenBase {

   protected BiomeGenHills(int p_i3754_1_) {
      super(p_i3754_1_);
   }

   public void func_76728_a(World p_76728_1_, Random p_76728_2_, int p_76728_3_, int p_76728_4_) {
      super.func_76728_a(p_76728_1_, p_76728_2_, p_76728_3_, p_76728_4_);
      int var5 = 3 + p_76728_2_.nextInt(6);

      for(int var6 = 0; var6 < var5; ++var6) {
         int var7 = p_76728_3_ + p_76728_2_.nextInt(16);
         int var8 = p_76728_2_.nextInt(28) + 4;
         int var9 = p_76728_4_ + p_76728_2_.nextInt(16);
         int var10 = p_76728_1_.func_72798_a(var7, var8, var9);
         if(var10 == Block.field_71981_t.field_71990_ca) {
            p_76728_1_.func_72822_b(var7, var8, var9, Block.field_72068_bR.field_71990_ca);
         }
      }

   }
}
