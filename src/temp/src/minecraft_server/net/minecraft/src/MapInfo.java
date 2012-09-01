package net.minecraft.src;

import net.minecraft.src.EntityPlayer;
import net.minecraft.src.ItemStack;
import net.minecraft.src.MapCoord;
import net.minecraft.src.MapData;

public class MapInfo {

   public final EntityPlayer field_76211_a;
   public int[] field_76209_b;
   public int[] field_76210_c;
   private int field_76208_e;
   private int field_76205_f;
   private byte[] field_76206_g;
   // $FF: synthetic field
   final MapData field_76207_d;


   public MapInfo(MapData p_i3904_1_, EntityPlayer p_i3904_2_) {
      this.field_76207_d = p_i3904_1_;
      this.field_76209_b = new int[128];
      this.field_76210_c = new int[128];
      this.field_76208_e = 0;
      this.field_76205_f = 0;
      this.field_76211_a = p_i3904_2_;

      for(int var3 = 0; var3 < this.field_76209_b.length; ++var3) {
         this.field_76209_b[var3] = 0;
         this.field_76210_c[var3] = 127;
      }

   }

   public byte[] func_76204_a(ItemStack p_76204_1_) {
      int var3;
      int var10;
      if(--this.field_76205_f < 0) {
         this.field_76205_f = 4;
         byte[] var2 = new byte[this.field_76207_d.field_76203_h.size() * 3 + 1];
         var2[0] = 1;

         for(var3 = 0; var3 < this.field_76207_d.field_76203_h.size(); ++var3) {
            MapCoord var4 = (MapCoord)this.field_76207_d.field_76203_h.get(var3);
            var2[var3 * 3 + 1] = (byte)(var4.field_76216_a + (var4.field_76212_d & 15) * 16);
            var2[var3 * 3 + 2] = var4.field_76214_b;
            var2[var3 * 3 + 3] = var4.field_76215_c;
         }

         boolean var9 = true;
         if(this.field_76206_g != null && this.field_76206_g.length == var2.length) {
            for(var10 = 0; var10 < var2.length; ++var10) {
               if(var2[var10] != this.field_76206_g[var10]) {
                  var9 = false;
                  break;
               }
            }
         } else {
            var9 = false;
         }

         if(!var9) {
            this.field_76206_g = var2;
            return var2;
         }
      }

      for(int var8 = 0; var8 < 10; ++var8) {
         var3 = this.field_76208_e * 11 % 128;
         ++this.field_76208_e;
         if(this.field_76209_b[var3] >= 0) {
            var10 = this.field_76210_c[var3] - this.field_76209_b[var3] + 1;
            int var5 = this.field_76209_b[var3];
            byte[] var6 = new byte[var10 + 3];
            var6[0] = 0;
            var6[1] = (byte)var3;
            var6[2] = (byte)var5;

            for(int var7 = 0; var7 < var6.length - 3; ++var7) {
               var6[var7 + 3] = this.field_76207_d.field_76198_e[(var7 + var5) * 128 + var3];
            }

            this.field_76210_c[var3] = -1;
            this.field_76209_b[var3] = -1;
            return var6;
         }
      }

      return null;
   }
}
