package net.minecraft.src;

import java.util.ArrayList;
import java.util.Random;
import net.minecraft.src.ChunkPosition;
import net.minecraft.src.ComponentStrongholdPortalRoom;
import net.minecraft.src.ComponentStrongholdStairs;
import net.minecraft.src.StructureStrongholdPieceWeight;

public class ComponentStrongholdStairs2 extends ComponentStrongholdStairs {

   public StructureStrongholdPieceWeight field_75027_a;
   public ComponentStrongholdPortalRoom field_75025_b;
   public ArrayList field_75026_c = new ArrayList();


   public ComponentStrongholdStairs2(int p_i3852_1_, Random p_i3852_2_, int p_i3852_3_, int p_i3852_4_) {
      super(0, p_i3852_2_, p_i3852_3_, p_i3852_4_);
   }

   public ChunkPosition func_74868_a() {
      return this.field_75025_b != null?this.field_75025_b.func_74868_a():super.func_74868_a();
   }
}
