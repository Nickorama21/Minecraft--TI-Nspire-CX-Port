package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.BiomeGenBase;
import net.minecraft.src.ComponentScatteredFeatureDesertPyramid;
import net.minecraft.src.ComponentScatteredFeatureJunglePyramid;
import net.minecraft.src.StructureStart;
import net.minecraft.src.World;

public class StructureScatteredFeatureStart extends StructureStart {

   public StructureScatteredFeatureStart(World p_i3832_1_, Random p_i3832_2_, int p_i3832_3_, int p_i3832_4_) {
      if(p_i3832_1_.func_72807_a(p_i3832_3_ * 16 + 8, p_i3832_4_ * 16 + 8) == BiomeGenBase.field_76782_w) {
         ComponentScatteredFeatureJunglePyramid var5 = new ComponentScatteredFeatureJunglePyramid(p_i3832_2_, p_i3832_3_ * 16, p_i3832_4_ * 16);
         this.field_75075_a.add(var5);
      } else {
         ComponentScatteredFeatureDesertPyramid var6 = new ComponentScatteredFeatureDesertPyramid(p_i3832_2_, p_i3832_3_ * 16, p_i3832_4_ * 16);
         this.field_75075_a.add(var6);
      }

      this.func_75072_c();
   }
}
