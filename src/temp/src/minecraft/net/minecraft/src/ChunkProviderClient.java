package net.minecraft.src;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.src.Chunk;
import net.minecraft.src.ChunkCoordIntPair;
import net.minecraft.src.ChunkPosition;
import net.minecraft.src.EmptyChunk;
import net.minecraft.src.EnumCreatureType;
import net.minecraft.src.IChunkProvider;
import net.minecraft.src.IProgressUpdate;
import net.minecraft.src.LongHashMap;
import net.minecraft.src.World;

public class ChunkProviderClient implements IChunkProvider {

   private Chunk field_73238_a;
   private LongHashMap field_73236_b = new LongHashMap();
   private List field_73237_c = new ArrayList();
   private World field_73235_d;


   public ChunkProviderClient(World p_i3112_1_) {
      this.field_73238_a = new EmptyChunk(p_i3112_1_, 0, 0);
      this.field_73235_d = p_i3112_1_;
   }

   public boolean func_73149_a(int p_73149_1_, int p_73149_2_) {
      return true;
   }

   public void func_73234_b(int p_73234_1_, int p_73234_2_) {
      Chunk var3 = this.func_73154_d(p_73234_1_, p_73234_2_);
      if(!var3.func_76621_g()) {
         var3.func_76623_d();
      }

      this.field_73236_b.func_76159_d(ChunkCoordIntPair.func_77272_a(p_73234_1_, p_73234_2_));
      this.field_73237_c.remove(var3);
   }

   public Chunk func_73158_c(int p_73158_1_, int p_73158_2_) {
      Chunk var3 = new Chunk(this.field_73235_d, p_73158_1_, p_73158_2_);
      this.field_73236_b.func_76163_a(ChunkCoordIntPair.func_77272_a(p_73158_1_, p_73158_2_), var3);
      var3.field_76636_d = true;
      return var3;
   }

   public Chunk func_73154_d(int p_73154_1_, int p_73154_2_) {
      Chunk var3 = (Chunk)this.field_73236_b.func_76164_a(ChunkCoordIntPair.func_77272_a(p_73154_1_, p_73154_2_));
      return var3 == null?this.field_73238_a:var3;
   }

   public boolean func_73151_a(boolean p_73151_1_, IProgressUpdate p_73151_2_) {
      return true;
   }

   public boolean func_73156_b() {
      return false;
   }

   public boolean func_73157_c() {
      return false;
   }

   public void func_73153_a(IChunkProvider p_73153_1_, int p_73153_2_, int p_73153_3_) {}

   public String func_73148_d() {
      return "MultiplayerChunkCache: " + this.field_73236_b.func_76162_a();
   }

   public List func_73155_a(EnumCreatureType p_73155_1_, int p_73155_2_, int p_73155_3_, int p_73155_4_) {
      return null;
   }

   public ChunkPosition func_73150_a(World p_73150_1_, String p_73150_2_, int p_73150_3_, int p_73150_4_, int p_73150_5_) {
      return null;
   }

   public int func_73152_e() {
      return this.field_73237_c.size();
   }
}
