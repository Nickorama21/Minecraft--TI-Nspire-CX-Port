package net.minecraft.src;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import net.minecraft.src.BiomeGenBase;
import net.minecraft.src.MapGenStructure;
import net.minecraft.src.StructureScatteredFeatureStart;
import net.minecraft.src.StructureStart;

public class MapGenScatteredFeature extends MapGenStructure {

   private static List field_75061_e = Arrays.asList(new BiomeGenBase[]{BiomeGenBase.field_76769_d, BiomeGenBase.field_76786_s, BiomeGenBase.field_76782_w});


   protected boolean func_75047_a(int p_75047_1_, int p_75047_2_) {
      byte var3 = 32;
      byte var4 = 8;
      int var5 = p_75047_1_;
      int var6 = p_75047_2_;
      if(p_75047_1_ < 0) {
         p_75047_1_ -= var3 - 1;
      }

      if(p_75047_2_ < 0) {
         p_75047_2_ -= var3 - 1;
      }

      int var7 = p_75047_1_ / var3;
      int var8 = p_75047_2_ / var3;
      Random var9 = this.field_75039_c.func_72843_D(var7, var8, 14357617);
      var7 *= var3;
      var8 *= var3;
      var7 += var9.nextInt(var3 - var4);
      var8 += var9.nextInt(var3 - var4);
      if(var5 == var7 && var6 == var8) {
         boolean var10 = this.field_75039_c.func_72959_q().func_76940_a(var5 * 16 + 8, var6 * 16 + 8, 0, field_75061_e);
         if(var10) {
            return true;
         }
      }

      return false;
   }

   protected StructureStart func_75049_b(int p_75049_1_, int p_75049_2_) {
      return new StructureScatteredFeatureStart(this.field_75039_c, this.field_75038_b, p_75049_1_, p_75049_2_);
   }

}
