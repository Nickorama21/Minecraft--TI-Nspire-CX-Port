package net.minecraft.src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.ItemStack;
import net.minecraft.src.MapCoord;
import net.minecraft.src.MapInfo;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.World;
import net.minecraft.src.WorldSavedData;

public class MapData extends WorldSavedData {

   public int field_76201_a;
   public int field_76199_b;
   public byte field_76200_c;
   public byte field_76197_d;
   public byte[] field_76198_e = new byte[16384];
   public int field_76195_f;
   public List field_76196_g = new ArrayList();
   private Map field_76202_j = new HashMap();
   public List field_76203_h = new ArrayList();


   public MapData(String p_i3906_1_) {
      super(p_i3906_1_);
   }

   public void func_76184_a(NBTTagCompound p_76184_1_) {
      this.field_76200_c = p_76184_1_.func_74771_c("dimension");
      this.field_76201_a = p_76184_1_.func_74762_e("xCenter");
      this.field_76199_b = p_76184_1_.func_74762_e("zCenter");
      this.field_76197_d = p_76184_1_.func_74771_c("scale");
      if(this.field_76197_d < 0) {
         this.field_76197_d = 0;
      }

      if(this.field_76197_d > 4) {
         this.field_76197_d = 4;
      }

      short var2 = p_76184_1_.func_74765_d("width");
      short var3 = p_76184_1_.func_74765_d("height");
      if(var2 == 128 && var3 == 128) {
         this.field_76198_e = p_76184_1_.func_74770_j("colors");
      } else {
         byte[] var4 = p_76184_1_.func_74770_j("colors");
         this.field_76198_e = new byte[16384];
         int var5 = (128 - var2) / 2;
         int var6 = (128 - var3) / 2;

         for(int var7 = 0; var7 < var3; ++var7) {
            int var8 = var7 + var6;
            if(var8 >= 0 || var8 < 128) {
               for(int var9 = 0; var9 < var2; ++var9) {
                  int var10 = var9 + var5;
                  if(var10 >= 0 || var10 < 128) {
                     this.field_76198_e[var10 + var8 * 128] = var4[var9 + var7 * var2];
                  }
               }
            }
         }
      }

   }

   public void func_76187_b(NBTTagCompound p_76187_1_) {
      p_76187_1_.func_74774_a("dimension", this.field_76200_c);
      p_76187_1_.func_74768_a("xCenter", this.field_76201_a);
      p_76187_1_.func_74768_a("zCenter", this.field_76199_b);
      p_76187_1_.func_74774_a("scale", this.field_76197_d);
      p_76187_1_.func_74777_a("width", (short)128);
      p_76187_1_.func_74777_a("height", (short)128);
      p_76187_1_.func_74773_a("colors", this.field_76198_e);
   }

   public void func_76191_a(EntityPlayer p_76191_1_, ItemStack p_76191_2_) {
      if(!this.field_76202_j.containsKey(p_76191_1_)) {
         MapInfo var3 = new MapInfo(this, p_76191_1_);
         this.field_76202_j.put(p_76191_1_, var3);
         this.field_76196_g.add(var3);
      }

      this.field_76203_h.clear();

      for(int var14 = 0; var14 < this.field_76196_g.size(); ++var14) {
         MapInfo var4 = (MapInfo)this.field_76196_g.get(var14);
         if(!var4.field_76211_a.field_70128_L && var4.field_76211_a.field_71071_by.func_70431_c(p_76191_2_)) {
            float var5 = (float)(var4.field_76211_a.field_70165_t - (double)this.field_76201_a) / (float)(1 << this.field_76197_d);
            float var6 = (float)(var4.field_76211_a.field_70161_v - (double)this.field_76199_b) / (float)(1 << this.field_76197_d);
            byte var7 = 64;
            byte var8 = 64;
            if(var5 >= (float)(-var7) && var6 >= (float)(-var8) && var5 <= (float)var7 && var6 <= (float)var8) {
               byte var9 = 0;
               byte var10 = (byte)((int)((double)(var5 * 2.0F) + 0.5D));
               byte var11 = (byte)((int)((double)(var6 * 2.0F) + 0.5D));
               byte var12 = (byte)((int)((double)var4.field_76211_a.field_70177_z * 16.0D / 360.0D));
               if(this.field_76200_c < 0) {
                  int var13 = this.field_76195_f / 10;
                  var12 = (byte)(var13 * var13 * 34187121 + var13 * 121 >> 15 & 15);
               }

               if(var4.field_76211_a.field_71093_bK == this.field_76200_c) {
                  this.field_76203_h.add(new MapCoord(this, var9, var10, var11, var12));
               }
            }
         } else {
            this.field_76202_j.remove(var4.field_76211_a);
            this.field_76196_g.remove(var4);
         }
      }

   }

   public byte[] func_76193_a(ItemStack p_76193_1_, World p_76193_2_, EntityPlayer p_76193_3_) {
      MapInfo var4 = (MapInfo)this.field_76202_j.get(p_76193_3_);
      return var4 == null?null:var4.func_76204_a(p_76193_1_);
   }

   public void func_76194_a(int p_76194_1_, int p_76194_2_, int p_76194_3_) {
      super.func_76185_a();

      for(int var4 = 0; var4 < this.field_76196_g.size(); ++var4) {
         MapInfo var5 = (MapInfo)this.field_76196_g.get(var4);
         if(var5.field_76209_b[p_76194_1_] < 0 || var5.field_76209_b[p_76194_1_] > p_76194_2_) {
            var5.field_76209_b[p_76194_1_] = p_76194_2_;
         }

         if(var5.field_76210_c[p_76194_1_] < 0 || var5.field_76210_c[p_76194_1_] < p_76194_3_) {
            var5.field_76210_c[p_76194_1_] = p_76194_3_;
         }
      }

   }
}
