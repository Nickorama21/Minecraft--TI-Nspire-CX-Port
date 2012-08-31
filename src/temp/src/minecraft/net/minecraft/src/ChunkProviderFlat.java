package net.minecraft.src;

import java.util.List;
import java.util.Random;
import net.minecraft.src.BiomeGenBase;
import net.minecraft.src.Block;
import net.minecraft.src.Chunk;
import net.minecraft.src.ChunkPosition;
import net.minecraft.src.EnumCreatureType;
import net.minecraft.src.IChunkProvider;
import net.minecraft.src.IProgressUpdate;
import net.minecraft.src.MapGenVillage;
import net.minecraft.src.World;

public class ChunkProviderFlat implements IChunkProvider {

   private World field_73163_a;
   private Random field_73161_b;
   private final boolean field_73162_c;
   private MapGenVillage field_73160_d = new MapGenVillage(1);


   public ChunkProviderFlat(World p_i3780_1_, long p_i3780_2_, boolean p_i3780_4_) {
      this.field_73163_a = p_i3780_1_;
      this.field_73162_c = p_i3780_4_;
      this.field_73161_b = new Random(p_i3780_2_);
   }

   private void func_73159_a(byte[] p_73159_1_) {
      int var2 = p_73159_1_.length / 256;

      for(int var3 = 0; var3 < 16; ++var3) {
         for(int var4 = 0; var4 < 16; ++var4) {
            for(int var5 = 0; var5 < var2; ++var5) {
               int var6 = 0;
               if(var5 == 0) {
                  var6 = Block.field_71986_z.field_71990_ca;
               } else if(var5 <= 2) {
                  var6 = Block.field_71979_v.field_71990_ca;
               } else if(var5 == 3) {
                  var6 = Block.field_71980_u.field_71990_ca;
               }

               p_73159_1_[var3 << 11 | var4 << 7 | var5] = (byte)var6;
            }
         }
      }

   }

   public Chunk func_73158_c(int p_73158_1_, int p_73158_2_) {
      return this.func_73154_d(p_73158_1_, p_73158_2_);
   }

   public Chunk func_73154_d(int p_73154_1_, int p_73154_2_) {
      byte[] var3 = new byte['\u8000'];
      this.func_73159_a(var3);
      Chunk var4 = new Chunk(this.field_73163_a, var3, p_73154_1_, p_73154_2_);
      if(this.field_73162_c) {
         this.field_73160_d.func_75036_a(this, this.field_73163_a, p_73154_1_, p_73154_2_, var3);
      }

      BiomeGenBase[] var5 = this.field_73163_a.func_72959_q().func_76933_b((BiomeGenBase[])null, p_73154_1_ * 16, p_73154_2_ * 16, 16, 16);
      byte[] var6 = var4.func_76605_m();

      for(int var7 = 0; var7 < var6.length; ++var7) {
         var6[var7] = (byte)var5[var7].field_76756_M;
      }

      var4.func_76603_b();
      return var4;
   }

   public boolean func_73149_a(int p_73149_1_, int p_73149_2_) {
      return true;
   }

   public void func_73153_a(IChunkProvider p_73153_1_, int p_73153_2_, int p_73153_3_) {
      this.field_73161_b.setSeed(this.field_73163_a.func_72905_C());
      long var4 = this.field_73161_b.nextLong() / 2L * 2L + 1L;
      long var6 = this.field_73161_b.nextLong() / 2L * 2L + 1L;
      this.field_73161_b.setSeed((long)p_73153_2_ * var4 + (long)p_73153_3_ * var6 ^ this.field_73163_a.func_72905_C());
      if(this.field_73162_c) {
         this.field_73160_d.func_75051_a(this.field_73163_a, this.field_73161_b, p_73153_2_, p_73153_3_);
      }

   }

   public boolean func_73151_a(boolean p_73151_1_, IProgressUpdate p_73151_2_) {
      return true;
   }

   public boolean func_73156_b() {
      return false;
   }

   public boolean func_73157_c() {
      return true;
   }

   public String func_73148_d() {
      return "FlatLevelSource";
   }

   public List func_73155_a(EnumCreatureType p_73155_1_, int p_73155_2_, int p_73155_3_, int p_73155_4_) {
      BiomeGenBase var5 = this.field_73163_a.func_72807_a(p_73155_2_, p_73155_4_);
      return var5 == null?null:var5.func_76747_a(p_73155_1_);
   }

   public ChunkPosition func_73150_a(World p_73150_1_, String p_73150_2_, int p_73150_3_, int p_73150_4_, int p_73150_5_) {
      return null;
   }

   public int func_73152_e() {
      return 0;
   }
}
