package net.minecraft.src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import net.minecraft.src.BiomeGenBase;
import net.minecraft.src.ChunkCoordIntPair;
import net.minecraft.src.ChunkPosition;
import net.minecraft.src.ComponentStrongholdStairs2;
import net.minecraft.src.MapGenStructure;
import net.minecraft.src.StructureStart;
import net.minecraft.src.StructureStrongholdStart;

public class MapGenStronghold extends MapGenStructure {

   private BiomeGenBase[] field_75058_e;
   private boolean field_75056_f;
   private ChunkCoordIntPair[] field_75057_g;


   public MapGenStronghold() {
      this.field_75058_e = new BiomeGenBase[]{BiomeGenBase.field_76769_d, BiomeGenBase.field_76767_f, BiomeGenBase.field_76770_e, BiomeGenBase.field_76780_h, BiomeGenBase.field_76768_g, BiomeGenBase.field_76774_n, BiomeGenBase.field_76775_o, BiomeGenBase.field_76786_s, BiomeGenBase.field_76785_t, BiomeGenBase.field_76783_v, BiomeGenBase.field_76782_w, BiomeGenBase.field_76792_x};
      this.field_75057_g = new ChunkCoordIntPair[3];
   }

   protected boolean func_75047_a(int p_75047_1_, int p_75047_2_) {
      if(!this.field_75056_f) {
         Random var3 = new Random();
         var3.setSeed(this.field_75039_c.func_72905_C());
         double var4 = var3.nextDouble() * 3.141592653589793D * 2.0D;

         for(int var6 = 0; var6 < this.field_75057_g.length; ++var6) {
            double var7 = (1.25D + var3.nextDouble()) * 32.0D;
            int var9 = (int)Math.round(Math.cos(var4) * var7);
            int var10 = (int)Math.round(Math.sin(var4) * var7);
            ArrayList var11 = new ArrayList();
            Collections.addAll(var11, this.field_75058_e);
            ChunkPosition var12 = this.field_75039_c.func_72959_q().func_76941_a((var9 << 4) + 8, (var10 << 4) + 8, 112, var11, var3);
            if(var12 != null) {
               var9 = var12.field_76930_a >> 4;
               var10 = var12.field_76929_c >> 4;
            } else {
               System.out.println("Placed stronghold in INVALID biome at (" + var9 + ", " + var10 + ")");
            }

            this.field_75057_g[var6] = new ChunkCoordIntPair(var9, var10);
            var4 += 6.283185307179586D / (double)this.field_75057_g.length;
         }

         this.field_75056_f = true;
      }

      ChunkCoordIntPair[] var13 = this.field_75057_g;
      int var14 = var13.length;

      for(int var5 = 0; var5 < var14; ++var5) {
         ChunkCoordIntPair var15 = var13[var5];
         if(p_75047_1_ == var15.field_77276_a && p_75047_2_ == var15.field_77275_b) {
            System.out.println(p_75047_1_ + ", " + p_75047_2_);
            return true;
         }
      }

      return false;
   }

   protected List func_75052_o_() {
      ArrayList var1 = new ArrayList();
      ChunkCoordIntPair[] var2 = this.field_75057_g;
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         ChunkCoordIntPair var5 = var2[var4];
         if(var5 != null) {
            var1.add(var5.func_77271_a(64));
         }
      }

      return var1;
   }

   protected StructureStart func_75049_b(int p_75049_1_, int p_75049_2_) {
      StructureStrongholdStart var3;
      for(var3 = new StructureStrongholdStart(this.field_75039_c, this.field_75038_b, p_75049_1_, p_75049_2_); var3.func_75073_b().isEmpty() || ((ComponentStrongholdStairs2)var3.func_75073_b().get(0)).field_75025_b == null; var3 = new StructureStrongholdStart(this.field_75039_c, this.field_75038_b, p_75049_1_, p_75049_2_)) {
         ;
      }

      return var3;
   }
}
