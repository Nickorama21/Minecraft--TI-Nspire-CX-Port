package net.minecraft.src;

import net.minecraft.src.MapGenStructure;
import net.minecraft.src.StructureMineshaftStart;
import net.minecraft.src.StructureStart;

public class MapGenMineshaft extends MapGenStructure {

   protected boolean func_75047_a(int p_75047_1_, int p_75047_2_) {
      return this.field_75038_b.nextInt(100) == 0 && this.field_75038_b.nextInt(80) < Math.max(Math.abs(p_75047_1_), Math.abs(p_75047_2_));
   }

   protected StructureStart func_75049_b(int p_75049_1_, int p_75049_2_) {
      return new StructureMineshaftStart(this.field_75039_c, this.field_75038_b, p_75049_1_, p_75049_2_);
   }
}
