package net.minecraft.src;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.BiomeGenBase;
import net.minecraft.src.Block;
import net.minecraft.src.BlockFluid;
import net.minecraft.src.BlockHalfSlab;
import net.minecraft.src.BlockStairs;
import net.minecraft.src.CallableLvl1;
import net.minecraft.src.CallableLvl2;
import net.minecraft.src.CallableLvl3;
import net.minecraft.src.Chunk;
import net.minecraft.src.ChunkCache;
import net.minecraft.src.ChunkCoordIntPair;
import net.minecraft.src.ChunkCoordinates;
import net.minecraft.src.ChunkPosition;
import net.minecraft.src.CrashReport;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EnumSkyBlock;
import net.minecraft.src.Explosion;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.IChunkProvider;
import net.minecraft.src.ISaveHandler;
import net.minecraft.src.IWorldAccess;
import net.minecraft.src.MapStorage;
import net.minecraft.src.Material;
import net.minecraft.src.MathHelper;
import net.minecraft.src.MinecraftException;
import net.minecraft.src.MovingObjectPosition;
import net.minecraft.src.PathEntity;
import net.minecraft.src.PathFinder;
import net.minecraft.src.Profiler;
import net.minecraft.src.TileEntity;
import net.minecraft.src.Vec3;
import net.minecraft.src.VillageCollection;
import net.minecraft.src.VillageSiege;
import net.minecraft.src.WorldChunkManager;
import net.minecraft.src.WorldInfo;
import net.minecraft.src.WorldProvider;
import net.minecraft.src.WorldSavedData;
import net.minecraft.src.WorldSettings;
import net.minecraft.src.WorldType;

public abstract class World implements IBlockAccess {

   public boolean field_72999_e = false;
   public List field_72996_f = new ArrayList();
   protected List field_72997_g = new ArrayList();
   public List field_73009_h = new ArrayList();
   private List field_73002_a = new ArrayList();
   private List field_73000_b = new ArrayList();
   public List field_73010_i = new ArrayList();
   public List field_73007_j = new ArrayList();
   private long field_73001_c = 16777215L;
   public int field_73008_k = 0;
   protected int field_73005_l = (new Random()).nextInt();
   protected final int field_73006_m = 1013904223;
   protected float field_73003_n;
   protected float field_73004_o;
   protected float field_73018_p;
   protected float field_73017_q;
   protected int field_73016_r = 0;
   public int field_73015_s = 0;
   public boolean field_73014_t = false;
   public int field_73013_u;
   public Random field_73012_v = new Random();
   public final WorldProvider field_73011_w;
   protected List field_73021_x = new ArrayList();
   protected IChunkProvider field_73020_y;
   protected final ISaveHandler field_73019_z;
   protected WorldInfo field_72986_A;
   public boolean field_72987_B;
   public MapStorage field_72988_C;
   public final VillageCollection field_72982_D = new VillageCollection(this);
   protected final VillageSiege field_72983_E = new VillageSiege(this);
   public final Profiler field_72984_F;
   private ArrayList field_72998_d = new ArrayList();
   private boolean field_72989_L;
   protected boolean field_72985_G = true;
   protected boolean field_72992_H = true;
   protected Set field_72993_I = new HashSet();
   private int field_72990_M;
   int[] field_72994_J;
   private List field_72991_N;
   public boolean field_72995_K;


   public BiomeGenBase func_72807_a(int p_72807_1_, int p_72807_2_) {
      if(this.func_72899_e(p_72807_1_, 0, p_72807_2_)) {
         Chunk var3 = this.func_72938_d(p_72807_1_, p_72807_2_);
         if(var3 != null) {
            return var3.func_76591_a(p_72807_1_ & 15, p_72807_2_ & 15, this.field_73011_w.field_76578_c);
         }
      }

      return this.field_73011_w.field_76578_c.func_76935_a(p_72807_1_, p_72807_2_);
   }

   public WorldChunkManager func_72959_q() {
      return this.field_73011_w.field_76578_c;
   }

   public World(ISaveHandler p_i3731_1_, String p_i3731_2_, WorldProvider p_i3731_3_, WorldSettings p_i3731_4_, Profiler p_i3731_5_) {
      this.field_72990_M = this.field_73012_v.nextInt(12000);
      this.field_72994_J = new int['\u8000'];
      this.field_72991_N = new ArrayList();
      this.field_72995_K = false;
      this.field_73019_z = p_i3731_1_;
      this.field_72984_F = p_i3731_5_;
      this.field_72986_A = new WorldInfo(p_i3731_4_, p_i3731_2_);
      this.field_73011_w = p_i3731_3_;
      this.field_72988_C = new MapStorage(p_i3731_1_);
      p_i3731_3_.func_76558_a(this);
      this.field_73020_y = this.func_72970_h();
      this.func_72966_v();
      this.func_72947_a();
   }

   public World(ISaveHandler p_i3732_1_, String p_i3732_2_, WorldSettings p_i3732_3_, WorldProvider p_i3732_4_, Profiler p_i3732_5_) {
      this.field_72990_M = this.field_73012_v.nextInt(12000);
      this.field_72994_J = new int['\u8000'];
      this.field_72991_N = new ArrayList();
      this.field_72995_K = false;
      this.field_73019_z = p_i3732_1_;
      this.field_72984_F = p_i3732_5_;
      this.field_72988_C = new MapStorage(p_i3732_1_);
      this.field_72986_A = p_i3732_1_.func_75757_d();
      if(p_i3732_4_ != null) {
         this.field_73011_w = p_i3732_4_;
      } else if(this.field_72986_A != null && this.field_72986_A.func_76076_i() != 0) {
         this.field_73011_w = WorldProvider.func_76570_a(this.field_72986_A.func_76076_i());
      } else {
         this.field_73011_w = WorldProvider.func_76570_a(0);
      }

      if(this.field_72986_A == null) {
         this.field_72986_A = new WorldInfo(p_i3732_3_, p_i3732_2_);
      } else {
         this.field_72986_A.func_76062_a(p_i3732_2_);
      }

      this.field_73011_w.func_76558_a(this);
      this.field_73020_y = this.func_72970_h();
      if(!this.field_72986_A.func_76070_v()) {
         this.func_72963_a(p_i3732_3_);
         this.field_72986_A.func_76091_d(true);
      }

      this.func_72966_v();
      this.func_72947_a();
   }

   protected abstract IChunkProvider func_72970_h();

   protected void func_72963_a(WorldSettings p_72963_1_) {
      this.field_72986_A.func_76091_d(true);
   }

   public void func_72974_f() {
      this.func_72950_A(8, 64, 8);
   }

   public int func_72922_b(int p_72922_1_, int p_72922_2_) {
      int var3;
      for(var3 = 63; !this.func_72799_c(p_72922_1_, var3 + 1, p_72922_2_); ++var3) {
         ;
      }

      return this.func_72798_a(p_72922_1_, var3, p_72922_2_);
   }

   public int func_72798_a(int p_72798_1_, int p_72798_2_, int p_72798_3_) {
      return p_72798_1_ >= -30000000 && p_72798_3_ >= -30000000 && p_72798_1_ < 30000000 && p_72798_3_ < 30000000?(p_72798_2_ < 0?0:(p_72798_2_ >= 256?0:this.func_72964_e(p_72798_1_ >> 4, p_72798_3_ >> 4).func_76610_a(p_72798_1_ & 15, p_72798_2_, p_72798_3_ & 15))):0;
   }

   public int func_72952_b(int p_72952_1_, int p_72952_2_, int p_72952_3_) {
      return p_72952_1_ >= -30000000 && p_72952_3_ >= -30000000 && p_72952_1_ < 30000000 && p_72952_3_ < 30000000?(p_72952_2_ < 0?0:(p_72952_2_ >= 256?0:this.func_72964_e(p_72952_1_ >> 4, p_72952_3_ >> 4).func_76596_b(p_72952_1_ & 15, p_72952_2_, p_72952_3_ & 15))):0;
   }

   public boolean func_72799_c(int p_72799_1_, int p_72799_2_, int p_72799_3_) {
      return this.func_72798_a(p_72799_1_, p_72799_2_, p_72799_3_) == 0;
   }

   public boolean func_72927_d(int p_72927_1_, int p_72927_2_, int p_72927_3_) {
      int var4 = this.func_72798_a(p_72927_1_, p_72927_2_, p_72927_3_);
      return Block.field_71973_m[var4] != null && Block.field_71973_m[var4].func_71887_s();
   }

   public boolean func_72899_e(int p_72899_1_, int p_72899_2_, int p_72899_3_) {
      return p_72899_2_ >= 0 && p_72899_2_ < 256?this.func_72916_c(p_72899_1_ >> 4, p_72899_3_ >> 4):false;
   }

   public boolean func_72873_a(int p_72873_1_, int p_72873_2_, int p_72873_3_, int p_72873_4_) {
      return this.func_72904_c(p_72873_1_ - p_72873_4_, p_72873_2_ - p_72873_4_, p_72873_3_ - p_72873_4_, p_72873_1_ + p_72873_4_, p_72873_2_ + p_72873_4_, p_72873_3_ + p_72873_4_);
   }

   public boolean func_72904_c(int p_72904_1_, int p_72904_2_, int p_72904_3_, int p_72904_4_, int p_72904_5_, int p_72904_6_) {
      if(p_72904_5_ >= 0 && p_72904_2_ < 256) {
         p_72904_1_ >>= 4;
         p_72904_3_ >>= 4;
         p_72904_4_ >>= 4;
         p_72904_6_ >>= 4;

         for(int var7 = p_72904_1_; var7 <= p_72904_4_; ++var7) {
            for(int var8 = p_72904_3_; var8 <= p_72904_6_; ++var8) {
               if(!this.func_72916_c(var7, var8)) {
                  return false;
               }
            }
         }

         return true;
      } else {
         return false;
      }
   }

   protected boolean func_72916_c(int p_72916_1_, int p_72916_2_) {
      return this.field_73020_y.func_73149_a(p_72916_1_, p_72916_2_);
   }

   public Chunk func_72938_d(int p_72938_1_, int p_72938_2_) {
      return this.func_72964_e(p_72938_1_ >> 4, p_72938_2_ >> 4);
   }

   public Chunk func_72964_e(int p_72964_1_, int p_72964_2_) {
      return this.field_73020_y.func_73154_d(p_72964_1_, p_72964_2_);
   }

   public boolean func_72961_c(int p_72961_1_, int p_72961_2_, int p_72961_3_, int p_72961_4_, int p_72961_5_) {
      return this.func_72930_a(p_72961_1_, p_72961_2_, p_72961_3_, p_72961_4_, p_72961_5_, true);
   }

   public boolean func_72930_a(int p_72930_1_, int p_72930_2_, int p_72930_3_, int p_72930_4_, int p_72930_5_, boolean p_72930_6_) {
      if(p_72930_1_ >= -30000000 && p_72930_3_ >= -30000000 && p_72930_1_ < 30000000 && p_72930_3_ < 30000000) {
         if(p_72930_2_ < 0) {
            return false;
         } else if(p_72930_2_ >= 256) {
            return false;
         } else {
            Chunk var7 = this.func_72964_e(p_72930_1_ >> 4, p_72930_3_ >> 4);
            boolean var8 = var7.func_76592_a(p_72930_1_ & 15, p_72930_2_, p_72930_3_ & 15, p_72930_4_, p_72930_5_);
            this.field_72984_F.func_76320_a("checkLight");
            this.func_72969_x(p_72930_1_, p_72930_2_, p_72930_3_);
            this.field_72984_F.func_76319_b();
            if(p_72930_6_ && var8 && (this.field_72995_K || var7.field_76642_o)) {
               this.func_72845_h(p_72930_1_, p_72930_2_, p_72930_3_);
            }

            return var8;
         }
      } else {
         return false;
      }
   }

   public boolean func_72822_b(int p_72822_1_, int p_72822_2_, int p_72822_3_, int p_72822_4_) {
      if(p_72822_1_ >= -30000000 && p_72822_3_ >= -30000000 && p_72822_1_ < 30000000 && p_72822_3_ < 30000000) {
         if(p_72822_2_ < 0) {
            return false;
         } else if(p_72822_2_ >= 256) {
            return false;
         } else {
            Chunk var5 = this.func_72964_e(p_72822_1_ >> 4, p_72822_3_ >> 4);
            boolean var6 = var5.func_76598_a(p_72822_1_ & 15, p_72822_2_, p_72822_3_ & 15, p_72822_4_);
            this.field_72984_F.func_76320_a("checkLight");
            this.func_72969_x(p_72822_1_, p_72822_2_, p_72822_3_);
            this.field_72984_F.func_76319_b();
            if(var6 && (this.field_72995_K || var5.field_76642_o)) {
               this.func_72845_h(p_72822_1_, p_72822_2_, p_72822_3_);
            }

            return var6;
         }
      } else {
         return false;
      }
   }

   public Material func_72803_f(int p_72803_1_, int p_72803_2_, int p_72803_3_) {
      int var4 = this.func_72798_a(p_72803_1_, p_72803_2_, p_72803_3_);
      return var4 == 0?Material.field_76249_a:Block.field_71973_m[var4].field_72018_cp;
   }

   public int func_72805_g(int p_72805_1_, int p_72805_2_, int p_72805_3_) {
      if(p_72805_1_ >= -30000000 && p_72805_3_ >= -30000000 && p_72805_1_ < 30000000 && p_72805_3_ < 30000000) {
         if(p_72805_2_ < 0) {
            return 0;
         } else if(p_72805_2_ >= 256) {
            return 0;
         } else {
            Chunk var4 = this.func_72964_e(p_72805_1_ >> 4, p_72805_3_ >> 4);
            p_72805_1_ &= 15;
            p_72805_3_ &= 15;
            return var4.func_76628_c(p_72805_1_, p_72805_2_, p_72805_3_);
         }
      } else {
         return 0;
      }
   }

   public void func_72921_c(int p_72921_1_, int p_72921_2_, int p_72921_3_, int p_72921_4_) {
      if(this.func_72881_d(p_72921_1_, p_72921_2_, p_72921_3_, p_72921_4_)) {
         this.func_72851_f(p_72921_1_, p_72921_2_, p_72921_3_, this.func_72798_a(p_72921_1_, p_72921_2_, p_72921_3_));
      }

   }

   public boolean func_72881_d(int p_72881_1_, int p_72881_2_, int p_72881_3_, int p_72881_4_) {
      if(p_72881_1_ >= -30000000 && p_72881_3_ >= -30000000 && p_72881_1_ < 30000000 && p_72881_3_ < 30000000) {
         if(p_72881_2_ < 0) {
            return false;
         } else if(p_72881_2_ >= 256) {
            return false;
         } else {
            Chunk var5 = this.func_72964_e(p_72881_1_ >> 4, p_72881_3_ >> 4);
            int var6 = p_72881_1_ & 15;
            int var7 = p_72881_3_ & 15;
            boolean var8 = var5.func_76589_b(var6, p_72881_2_, var7, p_72881_4_);
            if(var8 && (this.field_72995_K || var5.field_76642_o && Block.field_71983_r[var5.func_76610_a(var6, p_72881_2_, var7) & 4095])) {
               this.func_72845_h(p_72881_1_, p_72881_2_, p_72881_3_);
            }

            return var8;
         }
      } else {
         return false;
      }
   }

   public boolean func_72859_e(int p_72859_1_, int p_72859_2_, int p_72859_3_, int p_72859_4_) {
      if(this.func_72822_b(p_72859_1_, p_72859_2_, p_72859_3_, p_72859_4_)) {
         this.func_72851_f(p_72859_1_, p_72859_2_, p_72859_3_, p_72859_4_);
         return true;
      } else {
         return false;
      }
   }

   public boolean func_72832_d(int p_72832_1_, int p_72832_2_, int p_72832_3_, int p_72832_4_, int p_72832_5_) {
      if(this.func_72961_c(p_72832_1_, p_72832_2_, p_72832_3_, p_72832_4_, p_72832_5_)) {
         this.func_72851_f(p_72832_1_, p_72832_2_, p_72832_3_, p_72832_4_);
         return true;
      } else {
         return false;
      }
   }

   public void func_72845_h(int p_72845_1_, int p_72845_2_, int p_72845_3_) {
      Iterator var4 = this.field_73021_x.iterator();

      while(var4.hasNext()) {
         IWorldAccess var5 = (IWorldAccess)var4.next();
         var5.func_72710_a(p_72845_1_, p_72845_2_, p_72845_3_);
      }

   }

   public void func_72851_f(int p_72851_1_, int p_72851_2_, int p_72851_3_, int p_72851_4_) {
      this.func_72898_h(p_72851_1_, p_72851_2_, p_72851_3_, p_72851_4_);
   }

   public void func_72975_g(int p_72975_1_, int p_72975_2_, int p_72975_3_, int p_72975_4_) {
      int var5;
      if(p_72975_3_ > p_72975_4_) {
         var5 = p_72975_4_;
         p_72975_4_ = p_72975_3_;
         p_72975_3_ = var5;
      }

      if(!this.field_73011_w.field_76576_e) {
         for(var5 = p_72975_3_; var5 <= p_72975_4_; ++var5) {
            this.func_72936_c(EnumSkyBlock.Sky, p_72975_1_, var5, p_72975_2_);
         }
      }

      this.func_72909_d(p_72975_1_, p_72975_3_, p_72975_2_, p_72975_1_, p_72975_4_, p_72975_2_);
   }

   public void func_72862_i(int p_72862_1_, int p_72862_2_, int p_72862_3_) {
      Iterator var4 = this.field_73021_x.iterator();

      while(var4.hasNext()) {
         IWorldAccess var5 = (IWorldAccess)var4.next();
         var5.func_72707_a(p_72862_1_, p_72862_2_, p_72862_3_, p_72862_1_, p_72862_2_, p_72862_3_);
      }

   }

   public void func_72909_d(int p_72909_1_, int p_72909_2_, int p_72909_3_, int p_72909_4_, int p_72909_5_, int p_72909_6_) {
      Iterator var7 = this.field_73021_x.iterator();

      while(var7.hasNext()) {
         IWorldAccess var8 = (IWorldAccess)var7.next();
         var8.func_72707_a(p_72909_1_, p_72909_2_, p_72909_3_, p_72909_4_, p_72909_5_, p_72909_6_);
      }

   }

   public void func_72898_h(int p_72898_1_, int p_72898_2_, int p_72898_3_, int p_72898_4_) {
      this.func_72821_m(p_72898_1_ - 1, p_72898_2_, p_72898_3_, p_72898_4_);
      this.func_72821_m(p_72898_1_ + 1, p_72898_2_, p_72898_3_, p_72898_4_);
      this.func_72821_m(p_72898_1_, p_72898_2_ - 1, p_72898_3_, p_72898_4_);
      this.func_72821_m(p_72898_1_, p_72898_2_ + 1, p_72898_3_, p_72898_4_);
      this.func_72821_m(p_72898_1_, p_72898_2_, p_72898_3_ - 1, p_72898_4_);
      this.func_72821_m(p_72898_1_, p_72898_2_, p_72898_3_ + 1, p_72898_4_);
   }

   private void func_72821_m(int p_72821_1_, int p_72821_2_, int p_72821_3_, int p_72821_4_) {
      if(!this.field_73014_t && !this.field_72995_K) {
         Block var5 = Block.field_71973_m[this.func_72798_a(p_72821_1_, p_72821_2_, p_72821_3_)];
         if(var5 != null) {
            var5.func_71863_a(this, p_72821_1_, p_72821_2_, p_72821_3_, p_72821_4_);
         }

      }
   }

   public boolean func_72937_j(int p_72937_1_, int p_72937_2_, int p_72937_3_) {
      return this.func_72964_e(p_72937_1_ >> 4, p_72937_3_ >> 4).func_76619_d(p_72937_1_ & 15, p_72937_2_, p_72937_3_ & 15);
   }

   public int func_72883_k(int p_72883_1_, int p_72883_2_, int p_72883_3_) {
      if(p_72883_2_ < 0) {
         return 0;
      } else {
         if(p_72883_2_ >= 256) {
            p_72883_2_ = 255;
         }

         return this.func_72964_e(p_72883_1_ >> 4, p_72883_3_ >> 4).func_76629_c(p_72883_1_ & 15, p_72883_2_, p_72883_3_ & 15, 0);
      }
   }

   public int func_72957_l(int p_72957_1_, int p_72957_2_, int p_72957_3_) {
      return this.func_72849_a(p_72957_1_, p_72957_2_, p_72957_3_, true);
   }

   public int func_72849_a(int p_72849_1_, int p_72849_2_, int p_72849_3_, boolean p_72849_4_) {
      if(p_72849_1_ >= -30000000 && p_72849_3_ >= -30000000 && p_72849_1_ < 30000000 && p_72849_3_ < 30000000) {
         if(p_72849_4_) {
            int var5 = this.func_72798_a(p_72849_1_, p_72849_2_, p_72849_3_);
            if(var5 == Block.field_72079_ak.field_71990_ca || var5 == Block.field_72092_bO.field_71990_ca || var5 == Block.field_72050_aA.field_71990_ca || var5 == Block.field_72057_aH.field_71990_ca || var5 == Block.field_72063_at.field_71990_ca) {
               int var6 = this.func_72849_a(p_72849_1_, p_72849_2_ + 1, p_72849_3_, false);
               int var7 = this.func_72849_a(p_72849_1_ + 1, p_72849_2_, p_72849_3_, false);
               int var8 = this.func_72849_a(p_72849_1_ - 1, p_72849_2_, p_72849_3_, false);
               int var9 = this.func_72849_a(p_72849_1_, p_72849_2_, p_72849_3_ + 1, false);
               int var10 = this.func_72849_a(p_72849_1_, p_72849_2_, p_72849_3_ - 1, false);
               if(var7 > var6) {
                  var6 = var7;
               }

               if(var8 > var6) {
                  var6 = var8;
               }

               if(var9 > var6) {
                  var6 = var9;
               }

               if(var10 > var6) {
                  var6 = var10;
               }

               return var6;
            }
         }

         if(p_72849_2_ < 0) {
            return 0;
         } else {
            if(p_72849_2_ >= 256) {
               p_72849_2_ = 255;
            }

            Chunk var11 = this.func_72964_e(p_72849_1_ >> 4, p_72849_3_ >> 4);
            p_72849_1_ &= 15;
            p_72849_3_ &= 15;
            return var11.func_76629_c(p_72849_1_, p_72849_2_, p_72849_3_, this.field_73008_k);
         }
      } else {
         return 15;
      }
   }

   public int func_72976_f(int p_72976_1_, int p_72976_2_) {
      if(p_72976_1_ >= -30000000 && p_72976_2_ >= -30000000 && p_72976_1_ < 30000000 && p_72976_2_ < 30000000) {
         if(!this.func_72916_c(p_72976_1_ >> 4, p_72976_2_ >> 4)) {
            return 0;
         } else {
            Chunk var3 = this.func_72964_e(p_72976_1_ >> 4, p_72976_2_ >> 4);
            return var3.func_76611_b(p_72976_1_ & 15, p_72976_2_ & 15);
         }
      } else {
         return 0;
      }
   }

   public int func_72925_a(EnumSkyBlock p_72925_1_, int p_72925_2_, int p_72925_3_, int p_72925_4_) {
      if(this.field_73011_w.field_76576_e && p_72925_1_ == EnumSkyBlock.Sky) {
         return 0;
      } else {
         if(p_72925_3_ < 0) {
            p_72925_3_ = 0;
         }

         if(p_72925_3_ >= 256) {
            return p_72925_1_.field_77198_c;
         } else if(p_72925_2_ >= -30000000 && p_72925_4_ >= -30000000 && p_72925_2_ < 30000000 && p_72925_4_ < 30000000) {
            int var5 = p_72925_2_ >> 4;
            int var6 = p_72925_4_ >> 4;
            if(!this.func_72916_c(var5, var6)) {
               return p_72925_1_.field_77198_c;
            } else if(Block.field_71982_s[this.func_72798_a(p_72925_2_, p_72925_3_, p_72925_4_)]) {
               int var12 = this.func_72972_b(p_72925_1_, p_72925_2_, p_72925_3_ + 1, p_72925_4_);
               int var8 = this.func_72972_b(p_72925_1_, p_72925_2_ + 1, p_72925_3_, p_72925_4_);
               int var9 = this.func_72972_b(p_72925_1_, p_72925_2_ - 1, p_72925_3_, p_72925_4_);
               int var10 = this.func_72972_b(p_72925_1_, p_72925_2_, p_72925_3_, p_72925_4_ + 1);
               int var11 = this.func_72972_b(p_72925_1_, p_72925_2_, p_72925_3_, p_72925_4_ - 1);
               if(var8 > var12) {
                  var12 = var8;
               }

               if(var9 > var12) {
                  var12 = var9;
               }

               if(var10 > var12) {
                  var12 = var10;
               }

               if(var11 > var12) {
                  var12 = var11;
               }

               return var12;
            } else {
               Chunk var7 = this.func_72964_e(var5, var6);
               return var7.func_76614_a(p_72925_1_, p_72925_2_ & 15, p_72925_3_, p_72925_4_ & 15);
            }
         } else {
            return p_72925_1_.field_77198_c;
         }
      }
   }

   public int func_72972_b(EnumSkyBlock p_72972_1_, int p_72972_2_, int p_72972_3_, int p_72972_4_) {
      if(p_72972_3_ < 0) {
         p_72972_3_ = 0;
      }

      if(p_72972_3_ >= 256) {
         p_72972_3_ = 255;
      }

      if(p_72972_2_ >= -30000000 && p_72972_4_ >= -30000000 && p_72972_2_ < 30000000 && p_72972_4_ < 30000000) {
         int var5 = p_72972_2_ >> 4;
         int var6 = p_72972_4_ >> 4;
         if(!this.func_72916_c(var5, var6)) {
            return p_72972_1_.field_77198_c;
         } else {
            Chunk var7 = this.func_72964_e(var5, var6);
            return var7.func_76614_a(p_72972_1_, p_72972_2_ & 15, p_72972_3_, p_72972_4_ & 15);
         }
      } else {
         return p_72972_1_.field_77198_c;
      }
   }

   public void func_72915_b(EnumSkyBlock p_72915_1_, int p_72915_2_, int p_72915_3_, int p_72915_4_, int p_72915_5_) {
      if(p_72915_2_ >= -30000000 && p_72915_4_ >= -30000000 && p_72915_2_ < 30000000 && p_72915_4_ < 30000000) {
         if(p_72915_3_ >= 0) {
            if(p_72915_3_ < 256) {
               if(this.func_72916_c(p_72915_2_ >> 4, p_72915_4_ >> 4)) {
                  Chunk var6 = this.func_72964_e(p_72915_2_ >> 4, p_72915_4_ >> 4);
                  var6.func_76633_a(p_72915_1_, p_72915_2_ & 15, p_72915_3_, p_72915_4_ & 15, p_72915_5_);
                  Iterator var7 = this.field_73021_x.iterator();

                  while(var7.hasNext()) {
                     IWorldAccess var8 = (IWorldAccess)var7.next();
                     var8.func_72711_b(p_72915_2_, p_72915_3_, p_72915_4_);
                  }

               }
            }
         }
      }
   }

   public void func_72902_n(int p_72902_1_, int p_72902_2_, int p_72902_3_) {
      Iterator var4 = this.field_73021_x.iterator();

      while(var4.hasNext()) {
         IWorldAccess var5 = (IWorldAccess)var4.next();
         var5.func_72711_b(p_72902_1_, p_72902_2_, p_72902_3_);
      }

   }

   public int func_72802_i(int p_72802_1_, int p_72802_2_, int p_72802_3_, int p_72802_4_) {
      int var5 = this.func_72925_a(EnumSkyBlock.Sky, p_72802_1_, p_72802_2_, p_72802_3_);
      int var6 = this.func_72925_a(EnumSkyBlock.Block, p_72802_1_, p_72802_2_, p_72802_3_);
      if(var6 < p_72802_4_) {
         var6 = p_72802_4_;
      }

      return var5 << 20 | var6 << 4;
   }

   public float func_72808_j(int p_72808_1_, int p_72808_2_, int p_72808_3_, int p_72808_4_) {
      int var5 = this.func_72957_l(p_72808_1_, p_72808_2_, p_72808_3_);
      if(var5 < p_72808_4_) {
         var5 = p_72808_4_;
      }

      return this.field_73011_w.field_76573_f[var5];
   }

   public float func_72801_o(int p_72801_1_, int p_72801_2_, int p_72801_3_) {
      return this.field_73011_w.field_76573_f[this.func_72957_l(p_72801_1_, p_72801_2_, p_72801_3_)];
   }

   public boolean func_72935_r() {
      return this.field_73008_k < 4;
   }

   public MovingObjectPosition func_72933_a(Vec3 p_72933_1_, Vec3 p_72933_2_) {
      return this.func_72831_a(p_72933_1_, p_72933_2_, false, false);
   }

   public MovingObjectPosition func_72901_a(Vec3 p_72901_1_, Vec3 p_72901_2_, boolean p_72901_3_) {
      return this.func_72831_a(p_72901_1_, p_72901_2_, p_72901_3_, false);
   }

   public MovingObjectPosition func_72831_a(Vec3 p_72831_1_, Vec3 p_72831_2_, boolean p_72831_3_, boolean p_72831_4_) {
      if(!Double.isNaN(p_72831_1_.field_72450_a) && !Double.isNaN(p_72831_1_.field_72448_b) && !Double.isNaN(p_72831_1_.field_72449_c)) {
         if(!Double.isNaN(p_72831_2_.field_72450_a) && !Double.isNaN(p_72831_2_.field_72448_b) && !Double.isNaN(p_72831_2_.field_72449_c)) {
            int var5 = MathHelper.func_76128_c(p_72831_2_.field_72450_a);
            int var6 = MathHelper.func_76128_c(p_72831_2_.field_72448_b);
            int var7 = MathHelper.func_76128_c(p_72831_2_.field_72449_c);
            int var8 = MathHelper.func_76128_c(p_72831_1_.field_72450_a);
            int var9 = MathHelper.func_76128_c(p_72831_1_.field_72448_b);
            int var10 = MathHelper.func_76128_c(p_72831_1_.field_72449_c);
            int var11 = this.func_72798_a(var8, var9, var10);
            int var12 = this.func_72805_g(var8, var9, var10);
            Block var13 = Block.field_71973_m[var11];
            if((!p_72831_4_ || var13 == null || var13.func_71872_e(this, var8, var9, var10) != null) && var11 > 0 && var13.func_71913_a(var12, p_72831_3_)) {
               MovingObjectPosition var14 = var13.func_71878_a(this, var8, var9, var10, p_72831_1_, p_72831_2_);
               if(var14 != null) {
                  return var14;
               }
            }

            var11 = 200;

            while(var11-- >= 0) {
               if(Double.isNaN(p_72831_1_.field_72450_a) || Double.isNaN(p_72831_1_.field_72448_b) || Double.isNaN(p_72831_1_.field_72449_c)) {
                  return null;
               }

               if(var8 == var5 && var9 == var6 && var10 == var7) {
                  return null;
               }

               boolean var39 = true;
               boolean var40 = true;
               boolean var41 = true;
               double var15 = 999.0D;
               double var17 = 999.0D;
               double var19 = 999.0D;
               if(var5 > var8) {
                  var15 = (double)var8 + 1.0D;
               } else if(var5 < var8) {
                  var15 = (double)var8 + 0.0D;
               } else {
                  var39 = false;
               }

               if(var6 > var9) {
                  var17 = (double)var9 + 1.0D;
               } else if(var6 < var9) {
                  var17 = (double)var9 + 0.0D;
               } else {
                  var40 = false;
               }

               if(var7 > var10) {
                  var19 = (double)var10 + 1.0D;
               } else if(var7 < var10) {
                  var19 = (double)var10 + 0.0D;
               } else {
                  var41 = false;
               }

               double var21 = 999.0D;
               double var23 = 999.0D;
               double var25 = 999.0D;
               double var27 = p_72831_2_.field_72450_a - p_72831_1_.field_72450_a;
               double var29 = p_72831_2_.field_72448_b - p_72831_1_.field_72448_b;
               double var31 = p_72831_2_.field_72449_c - p_72831_1_.field_72449_c;
               if(var39) {
                  var21 = (var15 - p_72831_1_.field_72450_a) / var27;
               }

               if(var40) {
                  var23 = (var17 - p_72831_1_.field_72448_b) / var29;
               }

               if(var41) {
                  var25 = (var19 - p_72831_1_.field_72449_c) / var31;
               }

               boolean var33 = false;
               byte var42;
               if(var21 < var23 && var21 < var25) {
                  if(var5 > var8) {
                     var42 = 4;
                  } else {
                     var42 = 5;
                  }

                  p_72831_1_.field_72450_a = var15;
                  p_72831_1_.field_72448_b += var29 * var21;
                  p_72831_1_.field_72449_c += var31 * var21;
               } else if(var23 < var25) {
                  if(var6 > var9) {
                     var42 = 0;
                  } else {
                     var42 = 1;
                  }

                  p_72831_1_.field_72450_a += var27 * var23;
                  p_72831_1_.field_72448_b = var17;
                  p_72831_1_.field_72449_c += var31 * var23;
               } else {
                  if(var7 > var10) {
                     var42 = 2;
                  } else {
                     var42 = 3;
                  }

                  p_72831_1_.field_72450_a += var27 * var25;
                  p_72831_1_.field_72448_b += var29 * var25;
                  p_72831_1_.field_72449_c = var19;
               }

               Vec3 var34 = Vec3.func_72437_a().func_72345_a(p_72831_1_.field_72450_a, p_72831_1_.field_72448_b, p_72831_1_.field_72449_c);
               var8 = (int)(var34.field_72450_a = (double)MathHelper.func_76128_c(p_72831_1_.field_72450_a));
               if(var42 == 5) {
                  --var8;
                  ++var34.field_72450_a;
               }

               var9 = (int)(var34.field_72448_b = (double)MathHelper.func_76128_c(p_72831_1_.field_72448_b));
               if(var42 == 1) {
                  --var9;
                  ++var34.field_72448_b;
               }

               var10 = (int)(var34.field_72449_c = (double)MathHelper.func_76128_c(p_72831_1_.field_72449_c));
               if(var42 == 3) {
                  --var10;
                  ++var34.field_72449_c;
               }

               int var35 = this.func_72798_a(var8, var9, var10);
               int var36 = this.func_72805_g(var8, var9, var10);
               Block var37 = Block.field_71973_m[var35];
               if((!p_72831_4_ || var37 == null || var37.func_71872_e(this, var8, var9, var10) != null) && var35 > 0 && var37.func_71913_a(var36, p_72831_3_)) {
                  MovingObjectPosition var38 = var37.func_71878_a(this, var8, var9, var10, p_72831_1_, p_72831_2_);
                  if(var38 != null) {
                     return var38;
                  }
               }
            }

            return null;
         } else {
            return null;
         }
      } else {
         return null;
      }
   }

   public void func_72956_a(Entity p_72956_1_, String p_72956_2_, float p_72956_3_, float p_72956_4_) {
      if(p_72956_1_ != null && p_72956_2_ != null) {
         Iterator var5 = this.field_73021_x.iterator();

         while(var5.hasNext()) {
            IWorldAccess var6 = (IWorldAccess)var5.next();
            var6.func_72704_a(p_72956_2_, p_72956_1_.field_70165_t, p_72956_1_.field_70163_u - (double)p_72956_1_.field_70129_M, p_72956_1_.field_70161_v, p_72956_3_, p_72956_4_);
         }

      }
   }

   public void func_72908_a(double p_72908_1_, double p_72908_3_, double p_72908_5_, String p_72908_7_, float p_72908_8_, float p_72908_9_) {
      if(p_72908_7_ != null) {
         Iterator var10 = this.field_73021_x.iterator();

         while(var10.hasNext()) {
            IWorldAccess var11 = (IWorldAccess)var10.next();
            var11.func_72704_a(p_72908_7_, p_72908_1_, p_72908_3_, p_72908_5_, p_72908_8_, p_72908_9_);
         }

      }
   }

   public void func_72980_b(double p_72980_1_, double p_72980_3_, double p_72980_5_, String p_72980_7_, float p_72980_8_, float p_72980_9_) {}

   public void func_72934_a(String p_72934_1_, int p_72934_2_, int p_72934_3_, int p_72934_4_) {
      Iterator var5 = this.field_73021_x.iterator();

      while(var5.hasNext()) {
         IWorldAccess var6 = (IWorldAccess)var5.next();
         var6.func_72702_a(p_72934_1_, p_72934_2_, p_72934_3_, p_72934_4_);
      }

   }

   public void func_72869_a(String p_72869_1_, double p_72869_2_, double p_72869_4_, double p_72869_6_, double p_72869_8_, double p_72869_10_, double p_72869_12_) {
      Iterator var14 = this.field_73021_x.iterator();

      while(var14.hasNext()) {
         IWorldAccess var15 = (IWorldAccess)var14.next();
         var15.func_72708_a(p_72869_1_, p_72869_2_, p_72869_4_, p_72869_6_, p_72869_8_, p_72869_10_, p_72869_12_);
      }

   }

   public boolean func_72942_c(Entity p_72942_1_) {
      this.field_73007_j.add(p_72942_1_);
      return true;
   }

   public boolean func_72838_d(Entity p_72838_1_) {
      int var2 = MathHelper.func_76128_c(p_72838_1_.field_70165_t / 16.0D);
      int var3 = MathHelper.func_76128_c(p_72838_1_.field_70161_v / 16.0D);
      boolean var4 = false;
      if(p_72838_1_ instanceof EntityPlayer) {
         var4 = true;
      }

      if(!var4 && !this.func_72916_c(var2, var3)) {
         return false;
      } else {
         if(p_72838_1_ instanceof EntityPlayer) {
            EntityPlayer var5 = (EntityPlayer)p_72838_1_;
            this.field_73010_i.add(var5);
            this.func_72854_c();
         }

         this.func_72964_e(var2, var3).func_76612_a(p_72838_1_);
         this.field_72996_f.add(p_72838_1_);
         this.func_72923_a(p_72838_1_);
         return true;
      }
   }

   protected void func_72923_a(Entity p_72923_1_) {
      Iterator var2 = this.field_73021_x.iterator();

      while(var2.hasNext()) {
         IWorldAccess var3 = (IWorldAccess)var2.next();
         var3.func_72703_a(p_72923_1_);
      }

   }

   protected void func_72847_b(Entity p_72847_1_) {
      Iterator var2 = this.field_73021_x.iterator();

      while(var2.hasNext()) {
         IWorldAccess var3 = (IWorldAccess)var2.next();
         var3.func_72709_b(p_72847_1_);
      }

   }

   public void func_72900_e(Entity p_72900_1_) {
      if(p_72900_1_.field_70153_n != null) {
         p_72900_1_.field_70153_n.func_70078_a((Entity)null);
      }

      if(p_72900_1_.field_70154_o != null) {
         p_72900_1_.func_70078_a((Entity)null);
      }

      p_72900_1_.func_70106_y();
      if(p_72900_1_ instanceof EntityPlayer) {
         this.field_73010_i.remove(p_72900_1_);
         this.func_72854_c();
      }

   }

   public void func_72973_f(Entity p_72973_1_) {
      p_72973_1_.func_70106_y();
      if(p_72973_1_ instanceof EntityPlayer) {
         this.field_73010_i.remove(p_72973_1_);
         this.func_72854_c();
      }

      int var2 = p_72973_1_.field_70176_ah;
      int var3 = p_72973_1_.field_70164_aj;
      if(p_72973_1_.field_70175_ag && this.func_72916_c(var2, var3)) {
         this.func_72964_e(var2, var3).func_76622_b(p_72973_1_);
      }

      this.field_72996_f.remove(p_72973_1_);
      this.func_72847_b(p_72973_1_);
   }

   public void func_72954_a(IWorldAccess p_72954_1_) {
      this.field_73021_x.add(p_72954_1_);
   }

   public void func_72848_b(IWorldAccess p_72848_1_) {
      this.field_73021_x.remove(p_72848_1_);
   }

   public List func_72945_a(Entity p_72945_1_, AxisAlignedBB p_72945_2_) {
      this.field_72998_d.clear();
      int var3 = MathHelper.func_76128_c(p_72945_2_.field_72340_a);
      int var4 = MathHelper.func_76128_c(p_72945_2_.field_72336_d + 1.0D);
      int var5 = MathHelper.func_76128_c(p_72945_2_.field_72338_b);
      int var6 = MathHelper.func_76128_c(p_72945_2_.field_72337_e + 1.0D);
      int var7 = MathHelper.func_76128_c(p_72945_2_.field_72339_c);
      int var8 = MathHelper.func_76128_c(p_72945_2_.field_72334_f + 1.0D);

      for(int var9 = var3; var9 < var4; ++var9) {
         for(int var10 = var7; var10 < var8; ++var10) {
            if(this.func_72899_e(var9, 64, var10)) {
               for(int var11 = var5 - 1; var11 < var6; ++var11) {
                  Block var12 = Block.field_71973_m[this.func_72798_a(var9, var11, var10)];
                  if(var12 != null) {
                     var12.func_71871_a(this, var9, var11, var10, p_72945_2_, this.field_72998_d, p_72945_1_);
                  }
               }
            }
         }
      }

      double var15 = 0.25D;
      List var17 = this.func_72839_b(p_72945_1_, p_72945_2_.func_72314_b(var15, var15, var15));
      Iterator var16 = var17.iterator();

      while(var16.hasNext()) {
         Entity var13 = (Entity)var16.next();
         AxisAlignedBB var14 = var13.func_70046_E();
         if(var14 != null && var14.func_72326_a(p_72945_2_)) {
            this.field_72998_d.add(var14);
         }

         var14 = p_72945_1_.func_70114_g(var13);
         if(var14 != null && var14.func_72326_a(p_72945_2_)) {
            this.field_72998_d.add(var14);
         }
      }

      return this.field_72998_d;
   }

   public List func_72840_a(AxisAlignedBB p_72840_1_) {
      this.field_72998_d.clear();
      int var2 = MathHelper.func_76128_c(p_72840_1_.field_72340_a);
      int var3 = MathHelper.func_76128_c(p_72840_1_.field_72336_d + 1.0D);
      int var4 = MathHelper.func_76128_c(p_72840_1_.field_72338_b);
      int var5 = MathHelper.func_76128_c(p_72840_1_.field_72337_e + 1.0D);
      int var6 = MathHelper.func_76128_c(p_72840_1_.field_72339_c);
      int var7 = MathHelper.func_76128_c(p_72840_1_.field_72334_f + 1.0D);

      for(int var8 = var2; var8 < var3; ++var8) {
         for(int var9 = var6; var9 < var7; ++var9) {
            if(this.func_72899_e(var8, 64, var9)) {
               for(int var10 = var4 - 1; var10 < var5; ++var10) {
                  Block var11 = Block.field_71973_m[this.func_72798_a(var8, var10, var9)];
                  if(var11 != null) {
                     var11.func_71871_a(this, var8, var10, var9, p_72840_1_, this.field_72998_d, (Entity)null);
                  }
               }
            }
         }
      }

      return this.field_72998_d;
   }

   public int func_72967_a(float p_72967_1_) {
      float var2 = this.func_72826_c(p_72967_1_);
      float var3 = 1.0F - (MathHelper.func_76134_b(var2 * 3.1415927F * 2.0F) * 2.0F + 0.5F);
      if(var3 < 0.0F) {
         var3 = 0.0F;
      }

      if(var3 > 1.0F) {
         var3 = 1.0F;
      }

      var3 = 1.0F - var3;
      var3 = (float)((double)var3 * (1.0D - (double)(this.func_72867_j(p_72967_1_) * 5.0F) / 16.0D));
      var3 = (float)((double)var3 * (1.0D - (double)(this.func_72819_i(p_72967_1_) * 5.0F) / 16.0D));
      var3 = 1.0F - var3;
      return (int)(var3 * 11.0F);
   }

   public float func_72971_b(float p_72971_1_) {
      float var2 = this.func_72826_c(p_72971_1_);
      float var3 = 1.0F - (MathHelper.func_76134_b(var2 * 3.1415927F * 2.0F) * 2.0F + 0.2F);
      if(var3 < 0.0F) {
         var3 = 0.0F;
      }

      if(var3 > 1.0F) {
         var3 = 1.0F;
      }

      var3 = 1.0F - var3;
      var3 = (float)((double)var3 * (1.0D - (double)(this.func_72867_j(p_72971_1_) * 5.0F) / 16.0D));
      var3 = (float)((double)var3 * (1.0D - (double)(this.func_72819_i(p_72971_1_) * 5.0F) / 16.0D));
      return var3 * 0.8F + 0.2F;
   }

   public Vec3 func_72833_a(Entity p_72833_1_, float p_72833_2_) {
      float var3 = this.func_72826_c(p_72833_2_);
      float var4 = MathHelper.func_76134_b(var3 * 3.1415927F * 2.0F) * 2.0F + 0.5F;
      if(var4 < 0.0F) {
         var4 = 0.0F;
      }

      if(var4 > 1.0F) {
         var4 = 1.0F;
      }

      int var5 = MathHelper.func_76128_c(p_72833_1_.field_70165_t);
      int var6 = MathHelper.func_76128_c(p_72833_1_.field_70161_v);
      BiomeGenBase var7 = this.func_72807_a(var5, var6);
      float var8 = var7.func_76743_j();
      int var9 = var7.func_76731_a(var8);
      float var10 = (float)(var9 >> 16 & 255) / 255.0F;
      float var11 = (float)(var9 >> 8 & 255) / 255.0F;
      float var12 = (float)(var9 & 255) / 255.0F;
      var10 *= var4;
      var11 *= var4;
      var12 *= var4;
      float var13 = this.func_72867_j(p_72833_2_);
      float var14;
      float var15;
      if(var13 > 0.0F) {
         var14 = (var10 * 0.3F + var11 * 0.59F + var12 * 0.11F) * 0.6F;
         var15 = 1.0F - var13 * 0.75F;
         var10 = var10 * var15 + var14 * (1.0F - var15);
         var11 = var11 * var15 + var14 * (1.0F - var15);
         var12 = var12 * var15 + var14 * (1.0F - var15);
      }

      var14 = this.func_72819_i(p_72833_2_);
      if(var14 > 0.0F) {
         var15 = (var10 * 0.3F + var11 * 0.59F + var12 * 0.11F) * 0.2F;
         float var16 = 1.0F - var14 * 0.75F;
         var10 = var10 * var16 + var15 * (1.0F - var16);
         var11 = var11 * var16 + var15 * (1.0F - var16);
         var12 = var12 * var16 + var15 * (1.0F - var16);
      }

      if(this.field_73015_s > 0) {
         var15 = (float)this.field_73015_s - p_72833_2_;
         if(var15 > 1.0F) {
            var15 = 1.0F;
         }

         var15 *= 0.45F;
         var10 = var10 * (1.0F - var15) + 0.8F * var15;
         var11 = var11 * (1.0F - var15) + 0.8F * var15;
         var12 = var12 * (1.0F - var15) + 1.0F * var15;
      }

      return Vec3.func_72437_a().func_72345_a((double)var10, (double)var11, (double)var12);
   }

   public float func_72826_c(float p_72826_1_) {
      return this.field_73011_w.func_76563_a(this.field_72986_A.func_76073_f(), p_72826_1_);
   }

   public int func_72853_d(float p_72853_1_) {
      return this.field_73011_w.func_76559_b(this.field_72986_A.func_76073_f(), p_72853_1_);
   }

   public float func_72929_e(float p_72929_1_) {
      float var2 = this.func_72826_c(p_72929_1_);
      return var2 * 3.1415927F * 2.0F;
   }

   public Vec3 func_72824_f(float p_72824_1_) {
      float var2 = this.func_72826_c(p_72824_1_);
      float var3 = MathHelper.func_76134_b(var2 * 3.1415927F * 2.0F) * 2.0F + 0.5F;
      if(var3 < 0.0F) {
         var3 = 0.0F;
      }

      if(var3 > 1.0F) {
         var3 = 1.0F;
      }

      float var4 = (float)(this.field_73001_c >> 16 & 255L) / 255.0F;
      float var5 = (float)(this.field_73001_c >> 8 & 255L) / 255.0F;
      float var6 = (float)(this.field_73001_c & 255L) / 255.0F;
      float var7 = this.func_72867_j(p_72824_1_);
      float var8;
      float var9;
      if(var7 > 0.0F) {
         var8 = (var4 * 0.3F + var5 * 0.59F + var6 * 0.11F) * 0.6F;
         var9 = 1.0F - var7 * 0.95F;
         var4 = var4 * var9 + var8 * (1.0F - var9);
         var5 = var5 * var9 + var8 * (1.0F - var9);
         var6 = var6 * var9 + var8 * (1.0F - var9);
      }

      var4 *= var3 * 0.9F + 0.1F;
      var5 *= var3 * 0.9F + 0.1F;
      var6 *= var3 * 0.85F + 0.15F;
      var8 = this.func_72819_i(p_72824_1_);
      if(var8 > 0.0F) {
         var9 = (var4 * 0.3F + var5 * 0.59F + var6 * 0.11F) * 0.2F;
         float var10 = 1.0F - var8 * 0.95F;
         var4 = var4 * var10 + var9 * (1.0F - var10);
         var5 = var5 * var10 + var9 * (1.0F - var10);
         var6 = var6 * var10 + var9 * (1.0F - var10);
      }

      return Vec3.func_72437_a().func_72345_a((double)var4, (double)var5, (double)var6);
   }

   public Vec3 func_72948_g(float p_72948_1_) {
      float var2 = this.func_72826_c(p_72948_1_);
      return this.field_73011_w.func_76562_b(var2, p_72948_1_);
   }

   public int func_72874_g(int p_72874_1_, int p_72874_2_) {
      return this.func_72938_d(p_72874_1_, p_72874_2_).func_76626_d(p_72874_1_ & 15, p_72874_2_ & 15);
   }

   public int func_72825_h(int p_72825_1_, int p_72825_2_) {
      Chunk var3 = this.func_72938_d(p_72825_1_, p_72825_2_);
      int var4 = var3.func_76625_h() + 15;
      p_72825_1_ &= 15;

      for(p_72825_2_ &= 15; var4 > 0; --var4) {
         int var5 = var3.func_76610_a(p_72825_1_, var4, p_72825_2_);
         if(var5 != 0 && Block.field_71973_m[var5].field_72018_cp.func_76230_c() && Block.field_71973_m[var5].field_72018_cp != Material.field_76257_i) {
            return var4 + 1;
         }
      }

      return -1;
   }

   public float func_72880_h(float p_72880_1_) {
      float var2 = this.func_72826_c(p_72880_1_);
      float var3 = 1.0F - (MathHelper.func_76134_b(var2 * 3.1415927F * 2.0F) * 2.0F + 0.25F);
      if(var3 < 0.0F) {
         var3 = 0.0F;
      }

      if(var3 > 1.0F) {
         var3 = 1.0F;
      }

      return var3 * var3 * 0.5F;
   }

   public void func_72836_a(int p_72836_1_, int p_72836_2_, int p_72836_3_, int p_72836_4_, int p_72836_5_) {}

   public void func_72892_b(int p_72892_1_, int p_72892_2_, int p_72892_3_, int p_72892_4_, int p_72892_5_) {}

   public void func_72939_s() {
      this.field_72984_F.func_76320_a("entities");
      this.field_72984_F.func_76320_a("global");

      int var1;
      Entity var2;
      for(var1 = 0; var1 < this.field_73007_j.size(); ++var1) {
         var2 = (Entity)this.field_73007_j.get(var1);
         var2.func_70071_h_();
         if(var2.field_70128_L) {
            this.field_73007_j.remove(var1--);
         }
      }

      this.field_72984_F.func_76318_c("remove");
      this.field_72996_f.removeAll(this.field_72997_g);
      Iterator var5 = this.field_72997_g.iterator();

      int var3;
      int var4;
      while(var5.hasNext()) {
         var2 = (Entity)var5.next();
         var3 = var2.field_70176_ah;
         var4 = var2.field_70164_aj;
         if(var2.field_70175_ag && this.func_72916_c(var3, var4)) {
            this.func_72964_e(var3, var4).func_76622_b(var2);
         }
      }

      var5 = this.field_72997_g.iterator();

      while(var5.hasNext()) {
         var2 = (Entity)var5.next();
         this.func_72847_b(var2);
      }

      this.field_72997_g.clear();
      this.field_72984_F.func_76318_c("regular");

      for(var1 = 0; var1 < this.field_72996_f.size(); ++var1) {
         var2 = (Entity)this.field_72996_f.get(var1);
         if(var2.field_70154_o != null) {
            if(!var2.field_70154_o.field_70128_L && var2.field_70154_o.field_70153_n == var2) {
               continue;
            }

            var2.field_70154_o.field_70153_n = null;
            var2.field_70154_o = null;
         }

         this.field_72984_F.func_76320_a("tick");
         if(!var2.field_70128_L) {
            this.func_72870_g(var2);
         }

         this.field_72984_F.func_76319_b();
         this.field_72984_F.func_76320_a("remove");
         if(var2.field_70128_L) {
            var3 = var2.field_70176_ah;
            var4 = var2.field_70164_aj;
            if(var2.field_70175_ag && this.func_72916_c(var3, var4)) {
               this.func_72964_e(var3, var4).func_76622_b(var2);
            }

            this.field_72996_f.remove(var1--);
            this.func_72847_b(var2);
         }

         this.field_72984_F.func_76319_b();
      }

      this.field_72984_F.func_76318_c("tileEntities");
      this.field_72989_L = true;
      var5 = this.field_73009_h.iterator();

      while(var5.hasNext()) {
         TileEntity var6 = (TileEntity)var5.next();
         if(!var6.func_70320_p() && var6.func_70309_m() && this.func_72899_e(var6.field_70329_l, var6.field_70330_m, var6.field_70327_n)) {
            var6.func_70316_g();
         }

         if(var6.func_70320_p()) {
            var5.remove();
            if(this.func_72916_c(var6.field_70329_l >> 4, var6.field_70327_n >> 4)) {
               Chunk var8 = this.func_72964_e(var6.field_70329_l >> 4, var6.field_70327_n >> 4);
               if(var8 != null) {
                  var8.func_76627_f(var6.field_70329_l & 15, var6.field_70330_m, var6.field_70327_n & 15);
               }
            }
         }
      }

      this.field_72989_L = false;
      if(!this.field_73000_b.isEmpty()) {
         this.field_73009_h.removeAll(this.field_73000_b);
         this.field_73000_b.clear();
      }

      this.field_72984_F.func_76318_c("pendingTileEntities");
      if(!this.field_73002_a.isEmpty()) {
         Iterator var7 = this.field_73002_a.iterator();

         while(var7.hasNext()) {
            TileEntity var9 = (TileEntity)var7.next();
            if(!var9.func_70320_p()) {
               if(!this.field_73009_h.contains(var9)) {
                  this.field_73009_h.add(var9);
               }

               if(this.func_72916_c(var9.field_70329_l >> 4, var9.field_70327_n >> 4)) {
                  Chunk var10 = this.func_72964_e(var9.field_70329_l >> 4, var9.field_70327_n >> 4);
                  if(var10 != null) {
                     var10.func_76604_a(var9.field_70329_l & 15, var9.field_70330_m, var9.field_70327_n & 15, var9);
                  }
               }

               this.func_72845_h(var9.field_70329_l, var9.field_70330_m, var9.field_70327_n);
            }
         }

         this.field_73002_a.clear();
      }

      this.field_72984_F.func_76319_b();
      this.field_72984_F.func_76319_b();
   }

   public void func_72852_a(Collection p_72852_1_) {
      if(this.field_72989_L) {
         this.field_73002_a.addAll(p_72852_1_);
      } else {
         this.field_73009_h.addAll(p_72852_1_);
      }

   }

   public void func_72870_g(Entity p_72870_1_) {
      this.func_72866_a(p_72870_1_, true);
   }

   public void func_72866_a(Entity p_72866_1_, boolean p_72866_2_) {
      int var3 = MathHelper.func_76128_c(p_72866_1_.field_70165_t);
      int var4 = MathHelper.func_76128_c(p_72866_1_.field_70161_v);
      byte var5 = 32;
      if(!p_72866_2_ || this.func_72904_c(var3 - var5, 0, var4 - var5, var3 + var5, 0, var4 + var5)) {
         p_72866_1_.field_70142_S = p_72866_1_.field_70165_t;
         p_72866_1_.field_70137_T = p_72866_1_.field_70163_u;
         p_72866_1_.field_70136_U = p_72866_1_.field_70161_v;
         p_72866_1_.field_70126_B = p_72866_1_.field_70177_z;
         p_72866_1_.field_70127_C = p_72866_1_.field_70125_A;
         if(p_72866_2_ && p_72866_1_.field_70175_ag) {
            if(p_72866_1_.field_70154_o != null) {
               p_72866_1_.func_70098_U();
            } else {
               p_72866_1_.func_70071_h_();
            }
         }

         this.field_72984_F.func_76320_a("chunkCheck");
         if(Double.isNaN(p_72866_1_.field_70165_t) || Double.isInfinite(p_72866_1_.field_70165_t)) {
            p_72866_1_.field_70165_t = p_72866_1_.field_70142_S;
         }

         if(Double.isNaN(p_72866_1_.field_70163_u) || Double.isInfinite(p_72866_1_.field_70163_u)) {
            p_72866_1_.field_70163_u = p_72866_1_.field_70137_T;
         }

         if(Double.isNaN(p_72866_1_.field_70161_v) || Double.isInfinite(p_72866_1_.field_70161_v)) {
            p_72866_1_.field_70161_v = p_72866_1_.field_70136_U;
         }

         if(Double.isNaN((double)p_72866_1_.field_70125_A) || Double.isInfinite((double)p_72866_1_.field_70125_A)) {
            p_72866_1_.field_70125_A = p_72866_1_.field_70127_C;
         }

         if(Double.isNaN((double)p_72866_1_.field_70177_z) || Double.isInfinite((double)p_72866_1_.field_70177_z)) {
            p_72866_1_.field_70177_z = p_72866_1_.field_70126_B;
         }

         int var6 = MathHelper.func_76128_c(p_72866_1_.field_70165_t / 16.0D);
         int var7 = MathHelper.func_76128_c(p_72866_1_.field_70163_u / 16.0D);
         int var8 = MathHelper.func_76128_c(p_72866_1_.field_70161_v / 16.0D);
         if(!p_72866_1_.field_70175_ag || p_72866_1_.field_70176_ah != var6 || p_72866_1_.field_70162_ai != var7 || p_72866_1_.field_70164_aj != var8) {
            if(p_72866_1_.field_70175_ag && this.func_72916_c(p_72866_1_.field_70176_ah, p_72866_1_.field_70164_aj)) {
               this.func_72964_e(p_72866_1_.field_70176_ah, p_72866_1_.field_70164_aj).func_76608_a(p_72866_1_, p_72866_1_.field_70162_ai);
            }

            if(this.func_72916_c(var6, var8)) {
               p_72866_1_.field_70175_ag = true;
               this.func_72964_e(var6, var8).func_76612_a(p_72866_1_);
            } else {
               p_72866_1_.field_70175_ag = false;
            }
         }

         this.field_72984_F.func_76319_b();
         if(p_72866_2_ && p_72866_1_.field_70175_ag && p_72866_1_.field_70153_n != null) {
            if(!p_72866_1_.field_70153_n.field_70128_L && p_72866_1_.field_70153_n.field_70154_o == p_72866_1_) {
               this.func_72870_g(p_72866_1_.field_70153_n);
            } else {
               p_72866_1_.field_70153_n.field_70154_o = null;
               p_72866_1_.field_70153_n = null;
            }
         }

      }
   }

   public boolean func_72855_b(AxisAlignedBB p_72855_1_) {
      return this.func_72917_a(p_72855_1_, (Entity)null);
   }

   public boolean func_72917_a(AxisAlignedBB p_72917_1_, Entity p_72917_2_) {
      List var3 = this.func_72839_b((Entity)null, p_72917_1_);
      Iterator var4 = var3.iterator();

      Entity var5;
      do {
         if(!var4.hasNext()) {
            return true;
         }

         var5 = (Entity)var4.next();
      } while(var5.field_70128_L || !var5.field_70156_m || var5 == p_72917_2_);

      return false;
   }

   public boolean func_72829_c(AxisAlignedBB p_72829_1_) {
      int var2 = MathHelper.func_76128_c(p_72829_1_.field_72340_a);
      int var3 = MathHelper.func_76128_c(p_72829_1_.field_72336_d + 1.0D);
      int var4 = MathHelper.func_76128_c(p_72829_1_.field_72338_b);
      int var5 = MathHelper.func_76128_c(p_72829_1_.field_72337_e + 1.0D);
      int var6 = MathHelper.func_76128_c(p_72829_1_.field_72339_c);
      int var7 = MathHelper.func_76128_c(p_72829_1_.field_72334_f + 1.0D);
      if(p_72829_1_.field_72340_a < 0.0D) {
         --var2;
      }

      if(p_72829_1_.field_72338_b < 0.0D) {
         --var4;
      }

      if(p_72829_1_.field_72339_c < 0.0D) {
         --var6;
      }

      for(int var8 = var2; var8 < var3; ++var8) {
         for(int var9 = var4; var9 < var5; ++var9) {
            for(int var10 = var6; var10 < var7; ++var10) {
               Block var11 = Block.field_71973_m[this.func_72798_a(var8, var9, var10)];
               if(var11 != null) {
                  return true;
               }
            }
         }
      }

      return false;
   }

   public boolean func_72953_d(AxisAlignedBB p_72953_1_) {
      int var2 = MathHelper.func_76128_c(p_72953_1_.field_72340_a);
      int var3 = MathHelper.func_76128_c(p_72953_1_.field_72336_d + 1.0D);
      int var4 = MathHelper.func_76128_c(p_72953_1_.field_72338_b);
      int var5 = MathHelper.func_76128_c(p_72953_1_.field_72337_e + 1.0D);
      int var6 = MathHelper.func_76128_c(p_72953_1_.field_72339_c);
      int var7 = MathHelper.func_76128_c(p_72953_1_.field_72334_f + 1.0D);
      if(p_72953_1_.field_72340_a < 0.0D) {
         --var2;
      }

      if(p_72953_1_.field_72338_b < 0.0D) {
         --var4;
      }

      if(p_72953_1_.field_72339_c < 0.0D) {
         --var6;
      }

      for(int var8 = var2; var8 < var3; ++var8) {
         for(int var9 = var4; var9 < var5; ++var9) {
            for(int var10 = var6; var10 < var7; ++var10) {
               Block var11 = Block.field_71973_m[this.func_72798_a(var8, var9, var10)];
               if(var11 != null && var11.field_72018_cp.func_76224_d()) {
                  return true;
               }
            }
         }
      }

      return false;
   }

   public boolean func_72978_e(AxisAlignedBB p_72978_1_) {
      int var2 = MathHelper.func_76128_c(p_72978_1_.field_72340_a);
      int var3 = MathHelper.func_76128_c(p_72978_1_.field_72336_d + 1.0D);
      int var4 = MathHelper.func_76128_c(p_72978_1_.field_72338_b);
      int var5 = MathHelper.func_76128_c(p_72978_1_.field_72337_e + 1.0D);
      int var6 = MathHelper.func_76128_c(p_72978_1_.field_72339_c);
      int var7 = MathHelper.func_76128_c(p_72978_1_.field_72334_f + 1.0D);
      if(this.func_72904_c(var2, var4, var6, var3, var5, var7)) {
         for(int var8 = var2; var8 < var3; ++var8) {
            for(int var9 = var4; var9 < var5; ++var9) {
               for(int var10 = var6; var10 < var7; ++var10) {
                  int var11 = this.func_72798_a(var8, var9, var10);
                  if(var11 == Block.field_72067_ar.field_71990_ca || var11 == Block.field_71944_C.field_71990_ca || var11 == Block.field_71938_D.field_71990_ca) {
                     return true;
                  }
               }
            }
         }
      }

      return false;
   }

   public boolean func_72918_a(AxisAlignedBB p_72918_1_, Material p_72918_2_, Entity p_72918_3_) {
      int var4 = MathHelper.func_76128_c(p_72918_1_.field_72340_a);
      int var5 = MathHelper.func_76128_c(p_72918_1_.field_72336_d + 1.0D);
      int var6 = MathHelper.func_76128_c(p_72918_1_.field_72338_b);
      int var7 = MathHelper.func_76128_c(p_72918_1_.field_72337_e + 1.0D);
      int var8 = MathHelper.func_76128_c(p_72918_1_.field_72339_c);
      int var9 = MathHelper.func_76128_c(p_72918_1_.field_72334_f + 1.0D);
      if(!this.func_72904_c(var4, var6, var8, var5, var7, var9)) {
         return false;
      } else {
         boolean var10 = false;
         Vec3 var11 = Vec3.func_72437_a().func_72345_a(0.0D, 0.0D, 0.0D);

         for(int var12 = var4; var12 < var5; ++var12) {
            for(int var13 = var6; var13 < var7; ++var13) {
               for(int var14 = var8; var14 < var9; ++var14) {
                  Block var15 = Block.field_71973_m[this.func_72798_a(var12, var13, var14)];
                  if(var15 != null && var15.field_72018_cp == p_72918_2_) {
                     double var16 = (double)((float)(var13 + 1) - BlockFluid.func_72199_d(this.func_72805_g(var12, var13, var14)));
                     if((double)var7 >= var16) {
                        var10 = true;
                        var15.func_71901_a(this, var12, var13, var14, p_72918_3_, var11);
                     }
                  }
               }
            }
         }

         if(var11.func_72433_c() > 0.0D) {
            var11 = var11.func_72432_b();
            double var18 = 0.014D;
            p_72918_3_.field_70159_w += var11.field_72450_a * var18;
            p_72918_3_.field_70181_x += var11.field_72448_b * var18;
            p_72918_3_.field_70179_y += var11.field_72449_c * var18;
         }

         return var10;
      }
   }

   public boolean func_72875_a(AxisAlignedBB p_72875_1_, Material p_72875_2_) {
      int var3 = MathHelper.func_76128_c(p_72875_1_.field_72340_a);
      int var4 = MathHelper.func_76128_c(p_72875_1_.field_72336_d + 1.0D);
      int var5 = MathHelper.func_76128_c(p_72875_1_.field_72338_b);
      int var6 = MathHelper.func_76128_c(p_72875_1_.field_72337_e + 1.0D);
      int var7 = MathHelper.func_76128_c(p_72875_1_.field_72339_c);
      int var8 = MathHelper.func_76128_c(p_72875_1_.field_72334_f + 1.0D);

      for(int var9 = var3; var9 < var4; ++var9) {
         for(int var10 = var5; var10 < var6; ++var10) {
            for(int var11 = var7; var11 < var8; ++var11) {
               Block var12 = Block.field_71973_m[this.func_72798_a(var9, var10, var11)];
               if(var12 != null && var12.field_72018_cp == p_72875_2_) {
                  return true;
               }
            }
         }
      }

      return false;
   }

   public boolean func_72830_b(AxisAlignedBB p_72830_1_, Material p_72830_2_) {
      int var3 = MathHelper.func_76128_c(p_72830_1_.field_72340_a);
      int var4 = MathHelper.func_76128_c(p_72830_1_.field_72336_d + 1.0D);
      int var5 = MathHelper.func_76128_c(p_72830_1_.field_72338_b);
      int var6 = MathHelper.func_76128_c(p_72830_1_.field_72337_e + 1.0D);
      int var7 = MathHelper.func_76128_c(p_72830_1_.field_72339_c);
      int var8 = MathHelper.func_76128_c(p_72830_1_.field_72334_f + 1.0D);

      for(int var9 = var3; var9 < var4; ++var9) {
         for(int var10 = var5; var10 < var6; ++var10) {
            for(int var11 = var7; var11 < var8; ++var11) {
               Block var12 = Block.field_71973_m[this.func_72798_a(var9, var10, var11)];
               if(var12 != null && var12.field_72018_cp == p_72830_2_) {
                  int var13 = this.func_72805_g(var9, var10, var11);
                  double var14 = (double)(var10 + 1);
                  if(var13 < 8) {
                     var14 = (double)(var10 + 1) - (double)var13 / 8.0D;
                  }

                  if(var14 >= p_72830_1_.field_72338_b) {
                     return true;
                  }
               }
            }
         }
      }

      return false;
   }

   public Explosion func_72876_a(Entity p_72876_1_, double p_72876_2_, double p_72876_4_, double p_72876_6_, float p_72876_8_) {
      return this.func_72885_a(p_72876_1_, p_72876_2_, p_72876_4_, p_72876_6_, p_72876_8_, false);
   }

   public Explosion func_72885_a(Entity p_72885_1_, double p_72885_2_, double p_72885_4_, double p_72885_6_, float p_72885_8_, boolean p_72885_9_) {
      Explosion var10 = new Explosion(this, p_72885_1_, p_72885_2_, p_72885_4_, p_72885_6_, p_72885_8_);
      var10.field_77286_a = p_72885_9_;
      var10.func_77278_a();
      var10.func_77279_a(true);
      return var10;
   }

   public float func_72842_a(Vec3 p_72842_1_, AxisAlignedBB p_72842_2_) {
      double var3 = 1.0D / ((p_72842_2_.field_72336_d - p_72842_2_.field_72340_a) * 2.0D + 1.0D);
      double var5 = 1.0D / ((p_72842_2_.field_72337_e - p_72842_2_.field_72338_b) * 2.0D + 1.0D);
      double var7 = 1.0D / ((p_72842_2_.field_72334_f - p_72842_2_.field_72339_c) * 2.0D + 1.0D);
      int var9 = 0;
      int var10 = 0;

      for(float var11 = 0.0F; var11 <= 1.0F; var11 = (float)((double)var11 + var3)) {
         for(float var12 = 0.0F; var12 <= 1.0F; var12 = (float)((double)var12 + var5)) {
            for(float var13 = 0.0F; var13 <= 1.0F; var13 = (float)((double)var13 + var7)) {
               double var14 = p_72842_2_.field_72340_a + (p_72842_2_.field_72336_d - p_72842_2_.field_72340_a) * (double)var11;
               double var16 = p_72842_2_.field_72338_b + (p_72842_2_.field_72337_e - p_72842_2_.field_72338_b) * (double)var12;
               double var18 = p_72842_2_.field_72339_c + (p_72842_2_.field_72334_f - p_72842_2_.field_72339_c) * (double)var13;
               if(this.func_72933_a(Vec3.func_72437_a().func_72345_a(var14, var16, var18), p_72842_1_) == null) {
                  ++var9;
               }

               ++var10;
            }
         }
      }

      return (float)var9 / (float)var10;
   }

   public boolean func_72886_a(EntityPlayer p_72886_1_, int p_72886_2_, int p_72886_3_, int p_72886_4_, int p_72886_5_) {
      if(p_72886_5_ == 0) {
         --p_72886_3_;
      }

      if(p_72886_5_ == 1) {
         ++p_72886_3_;
      }

      if(p_72886_5_ == 2) {
         --p_72886_4_;
      }

      if(p_72886_5_ == 3) {
         ++p_72886_4_;
      }

      if(p_72886_5_ == 4) {
         --p_72886_2_;
      }

      if(p_72886_5_ == 5) {
         ++p_72886_2_;
      }

      if(this.func_72798_a(p_72886_2_, p_72886_3_, p_72886_4_) == Block.field_72067_ar.field_71990_ca) {
         this.func_72889_a(p_72886_1_, 1004, p_72886_2_, p_72886_3_, p_72886_4_, 0);
         this.func_72859_e(p_72886_2_, p_72886_3_, p_72886_4_, 0);
         return true;
      } else {
         return false;
      }
   }

   public String func_72981_t() {
      return "All: " + this.field_72996_f.size();
   }

   public String func_72827_u() {
      return this.field_73020_y.func_73148_d();
   }

   public TileEntity func_72796_p(int p_72796_1_, int p_72796_2_, int p_72796_3_) {
      if(p_72796_2_ >= 256) {
         return null;
      } else {
         Chunk var4 = this.func_72964_e(p_72796_1_ >> 4, p_72796_3_ >> 4);
         if(var4 == null) {
            return null;
         } else {
            TileEntity var5 = var4.func_76597_e(p_72796_1_ & 15, p_72796_2_, p_72796_3_ & 15);
            if(var5 == null) {
               Iterator var6 = this.field_73002_a.iterator();

               while(var6.hasNext()) {
                  TileEntity var7 = (TileEntity)var6.next();
                  if(!var7.func_70320_p() && var7.field_70329_l == p_72796_1_ && var7.field_70330_m == p_72796_2_ && var7.field_70327_n == p_72796_3_) {
                     var5 = var7;
                     break;
                  }
               }
            }

            return var5;
         }
      }
   }

   public void func_72837_a(int p_72837_1_, int p_72837_2_, int p_72837_3_, TileEntity p_72837_4_) {
      if(p_72837_4_ != null && !p_72837_4_.func_70320_p()) {
         if(this.field_72989_L) {
            p_72837_4_.field_70329_l = p_72837_1_;
            p_72837_4_.field_70330_m = p_72837_2_;
            p_72837_4_.field_70327_n = p_72837_3_;
            this.field_73002_a.add(p_72837_4_);
         } else {
            this.field_73009_h.add(p_72837_4_);
            Chunk var5 = this.func_72964_e(p_72837_1_ >> 4, p_72837_3_ >> 4);
            if(var5 != null) {
               var5.func_76604_a(p_72837_1_ & 15, p_72837_2_, p_72837_3_ & 15, p_72837_4_);
            }
         }
      }

   }

   public void func_72932_q(int p_72932_1_, int p_72932_2_, int p_72932_3_) {
      TileEntity var4 = this.func_72796_p(p_72932_1_, p_72932_2_, p_72932_3_);
      if(var4 != null && this.field_72989_L) {
         var4.func_70313_j();
         this.field_73002_a.remove(var4);
      } else {
         if(var4 != null) {
            this.field_73002_a.remove(var4);
            this.field_73009_h.remove(var4);
         }

         Chunk var5 = this.func_72964_e(p_72932_1_ >> 4, p_72932_3_ >> 4);
         if(var5 != null) {
            var5.func_76627_f(p_72932_1_ & 15, p_72932_2_, p_72932_3_ & 15);
         }
      }

   }

   public void func_72928_a(TileEntity p_72928_1_) {
      this.field_73000_b.add(p_72928_1_);
   }

   public boolean func_72804_r(int p_72804_1_, int p_72804_2_, int p_72804_3_) {
      Block var4 = Block.field_71973_m[this.func_72798_a(p_72804_1_, p_72804_2_, p_72804_3_)];
      return var4 == null?false:var4.func_71926_d();
   }

   public boolean func_72809_s(int p_72809_1_, int p_72809_2_, int p_72809_3_) {
      return Block.func_71932_i(this.func_72798_a(p_72809_1_, p_72809_2_, p_72809_3_));
   }

   public boolean func_72797_t(int p_72797_1_, int p_72797_2_, int p_72797_3_) {
      Block var4 = Block.field_71973_m[this.func_72798_a(p_72797_1_, p_72797_2_, p_72797_3_)];
      return var4 == null?false:(var4.field_72018_cp.func_76218_k() && var4.func_71886_c()?true:(var4 instanceof BlockStairs?(this.func_72805_g(p_72797_1_, p_72797_2_, p_72797_3_) & 4) == 4:(var4 instanceof BlockHalfSlab?(this.func_72805_g(p_72797_1_, p_72797_2_, p_72797_3_) & 8) == 8:false)));
   }

   public boolean func_72887_b(int p_72887_1_, int p_72887_2_, int p_72887_3_, boolean p_72887_4_) {
      if(p_72887_1_ >= -30000000 && p_72887_3_ >= -30000000 && p_72887_1_ < 30000000 && p_72887_3_ < 30000000) {
         Chunk var5 = this.field_73020_y.func_73154_d(p_72887_1_ >> 4, p_72887_3_ >> 4);
         if(var5 != null && !var5.func_76621_g()) {
            Block var6 = Block.field_71973_m[this.func_72798_a(p_72887_1_, p_72887_2_, p_72887_3_)];
            return var6 == null?false:var6.field_72018_cp.func_76218_k() && var6.func_71886_c();
         } else {
            return p_72887_4_;
         }
      } else {
         return p_72887_4_;
      }
   }

   public void func_72966_v() {
      int var1 = this.func_72967_a(1.0F);
      if(var1 != this.field_73008_k) {
         this.field_73008_k = var1;
      }

   }

   public void func_72891_a(boolean p_72891_1_, boolean p_72891_2_) {
      this.field_72985_G = p_72891_1_;
      this.field_72992_H = p_72891_2_;
   }

   public void func_72835_b() {
      this.func_72979_l();
   }

   private void func_72947_a() {
      if(this.field_72986_A.func_76059_o()) {
         this.field_73004_o = 1.0F;
         if(this.field_72986_A.func_76061_m()) {
            this.field_73017_q = 1.0F;
         }
      }

   }

   protected void func_72979_l() {
      if(!this.field_73011_w.field_76576_e) {
         if(this.field_73016_r > 0) {
            --this.field_73016_r;
         }

         int var1 = this.field_72986_A.func_76071_n();
         if(var1 <= 0) {
            if(this.field_72986_A.func_76061_m()) {
               this.field_72986_A.func_76090_f(this.field_73012_v.nextInt(12000) + 3600);
            } else {
               this.field_72986_A.func_76090_f(this.field_73012_v.nextInt(168000) + 12000);
            }
         } else {
            --var1;
            this.field_72986_A.func_76090_f(var1);
            if(var1 <= 0) {
               this.field_72986_A.func_76069_a(!this.field_72986_A.func_76061_m());
            }
         }

         int var2 = this.field_72986_A.func_76083_p();
         if(var2 <= 0) {
            if(this.field_72986_A.func_76059_o()) {
               this.field_72986_A.func_76080_g(this.field_73012_v.nextInt(12000) + 12000);
            } else {
               this.field_72986_A.func_76080_g(this.field_73012_v.nextInt(168000) + 12000);
            }
         } else {
            --var2;
            this.field_72986_A.func_76080_g(var2);
            if(var2 <= 0) {
               this.field_72986_A.func_76084_b(!this.field_72986_A.func_76059_o());
            }
         }

         this.field_73003_n = this.field_73004_o;
         if(this.field_72986_A.func_76059_o()) {
            this.field_73004_o = (float)((double)this.field_73004_o + 0.01D);
         } else {
            this.field_73004_o = (float)((double)this.field_73004_o - 0.01D);
         }

         if(this.field_73004_o < 0.0F) {
            this.field_73004_o = 0.0F;
         }

         if(this.field_73004_o > 1.0F) {
            this.field_73004_o = 1.0F;
         }

         this.field_73018_p = this.field_73017_q;
         if(this.field_72986_A.func_76061_m()) {
            this.field_73017_q = (float)((double)this.field_73017_q + 0.01D);
         } else {
            this.field_73017_q = (float)((double)this.field_73017_q - 0.01D);
         }

         if(this.field_73017_q < 0.0F) {
            this.field_73017_q = 0.0F;
         }

         if(this.field_73017_q > 1.0F) {
            this.field_73017_q = 1.0F;
         }

      }
   }

   public void func_72913_w() {
      this.field_72986_A.func_76080_g(1);
   }

   protected void func_72903_x() {
      this.field_72993_I.clear();
      this.field_72984_F.func_76320_a("buildList");

      int var1;
      EntityPlayer var2;
      int var3;
      int var4;
      for(var1 = 0; var1 < this.field_73010_i.size(); ++var1) {
         var2 = (EntityPlayer)this.field_73010_i.get(var1);
         var3 = MathHelper.func_76128_c(var2.field_70165_t / 16.0D);
         var4 = MathHelper.func_76128_c(var2.field_70161_v / 16.0D);
         byte var5 = 7;

         for(int var6 = -var5; var6 <= var5; ++var6) {
            for(int var7 = -var5; var7 <= var5; ++var7) {
               this.field_72993_I.add(new ChunkCoordIntPair(var6 + var3, var7 + var4));
            }
         }
      }

      this.field_72984_F.func_76319_b();
      if(this.field_72990_M > 0) {
         --this.field_72990_M;
      }

      this.field_72984_F.func_76320_a("playerCheckLight");
      if(!this.field_73010_i.isEmpty()) {
         var1 = this.field_73012_v.nextInt(this.field_73010_i.size());
         var2 = (EntityPlayer)this.field_73010_i.get(var1);
         var3 = MathHelper.func_76128_c(var2.field_70165_t) + this.field_73012_v.nextInt(11) - 5;
         var4 = MathHelper.func_76128_c(var2.field_70163_u) + this.field_73012_v.nextInt(11) - 5;
         int var8 = MathHelper.func_76128_c(var2.field_70161_v) + this.field_73012_v.nextInt(11) - 5;
         this.func_72969_x(var3, var4, var8);
      }

      this.field_72984_F.func_76319_b();
   }

   protected void func_72941_a(int p_72941_1_, int p_72941_2_, Chunk p_72941_3_) {
      this.field_72984_F.func_76318_c("moodSound");
      if(this.field_72990_M == 0) {
         this.field_73005_l = this.field_73005_l * 3 + 1013904223;
         int var4 = this.field_73005_l >> 2;
         int var5 = var4 & 15;
         int var6 = var4 >> 8 & 15;
         int var7 = var4 >> 16 & 127;
         int var8 = p_72941_3_.func_76610_a(var5, var7, var6);
         var5 += p_72941_1_;
         var6 += p_72941_2_;
         if(var8 == 0 && this.func_72883_k(var5, var7, var6) <= this.field_73012_v.nextInt(8) && this.func_72972_b(EnumSkyBlock.Sky, var5, var7, var6) <= 0) {
            EntityPlayer var9 = this.func_72977_a((double)var5 + 0.5D, (double)var7 + 0.5D, (double)var6 + 0.5D, 8.0D);
            if(var9 != null && var9.func_70092_e((double)var5 + 0.5D, (double)var7 + 0.5D, (double)var6 + 0.5D) > 4.0D) {
               this.func_72908_a((double)var5 + 0.5D, (double)var7 + 0.5D, (double)var6 + 0.5D, "ambient.cave.cave", 0.7F, 0.8F + this.field_73012_v.nextFloat() * 0.2F);
               this.field_72990_M = this.field_73012_v.nextInt(12000) + 6000;
            }
         }
      }

      this.field_72984_F.func_76318_c("checkLight");
      p_72941_3_.func_76594_o();
   }

   protected void func_72893_g() {
      this.func_72903_x();
   }

   public boolean func_72884_u(int p_72884_1_, int p_72884_2_, int p_72884_3_) {
      return this.func_72834_c(p_72884_1_, p_72884_2_, p_72884_3_, false);
   }

   public boolean func_72850_v(int p_72850_1_, int p_72850_2_, int p_72850_3_) {
      return this.func_72834_c(p_72850_1_, p_72850_2_, p_72850_3_, true);
   }

   public boolean func_72834_c(int p_72834_1_, int p_72834_2_, int p_72834_3_, boolean p_72834_4_) {
      BiomeGenBase var5 = this.func_72807_a(p_72834_1_, p_72834_3_);
      float var6 = var5.func_76743_j();
      if(var6 > 0.15F) {
         return false;
      } else {
         if(p_72834_2_ >= 0 && p_72834_2_ < 256 && this.func_72972_b(EnumSkyBlock.Block, p_72834_1_, p_72834_2_, p_72834_3_) < 10) {
            int var7 = this.func_72798_a(p_72834_1_, p_72834_2_, p_72834_3_);
            if((var7 == Block.field_71943_B.field_71990_ca || var7 == Block.field_71942_A.field_71990_ca) && this.func_72805_g(p_72834_1_, p_72834_2_, p_72834_3_) == 0) {
               if(!p_72834_4_) {
                  return true;
               }

               boolean var8 = true;
               if(var8 && this.func_72803_f(p_72834_1_ - 1, p_72834_2_, p_72834_3_) != Material.field_76244_g) {
                  var8 = false;
               }

               if(var8 && this.func_72803_f(p_72834_1_ + 1, p_72834_2_, p_72834_3_) != Material.field_76244_g) {
                  var8 = false;
               }

               if(var8 && this.func_72803_f(p_72834_1_, p_72834_2_, p_72834_3_ - 1) != Material.field_76244_g) {
                  var8 = false;
               }

               if(var8 && this.func_72803_f(p_72834_1_, p_72834_2_, p_72834_3_ + 1) != Material.field_76244_g) {
                  var8 = false;
               }

               if(!var8) {
                  return true;
               }
            }
         }

         return false;
      }
   }

   public boolean func_72858_w(int p_72858_1_, int p_72858_2_, int p_72858_3_) {
      BiomeGenBase var4 = this.func_72807_a(p_72858_1_, p_72858_3_);
      float var5 = var4.func_76743_j();
      if(var5 > 0.15F) {
         return false;
      } else {
         if(p_72858_2_ >= 0 && p_72858_2_ < 256 && this.func_72972_b(EnumSkyBlock.Block, p_72858_1_, p_72858_2_, p_72858_3_) < 10) {
            int var6 = this.func_72798_a(p_72858_1_, p_72858_2_ - 1, p_72858_3_);
            int var7 = this.func_72798_a(p_72858_1_, p_72858_2_, p_72858_3_);
            if(var7 == 0 && Block.field_72037_aS.func_71930_b(this, p_72858_1_, p_72858_2_, p_72858_3_) && var6 != 0 && var6 != Block.field_72036_aT.field_71990_ca && Block.field_71973_m[var6].field_72018_cp.func_76230_c()) {
               return true;
            }
         }

         return false;
      }
   }

   public void func_72969_x(int p_72969_1_, int p_72969_2_, int p_72969_3_) {
      if(!this.field_73011_w.field_76576_e) {
         this.func_72936_c(EnumSkyBlock.Sky, p_72969_1_, p_72969_2_, p_72969_3_);
      }

      this.func_72936_c(EnumSkyBlock.Block, p_72969_1_, p_72969_2_, p_72969_3_);
   }

   private int func_72949_a(int p_72949_1_, int p_72949_2_, int p_72949_3_, int p_72949_4_, int p_72949_5_, int p_72949_6_) {
      int var7 = 0;
      if(this.func_72937_j(p_72949_2_, p_72949_3_, p_72949_4_)) {
         var7 = 15;
      } else {
         if(p_72949_6_ == 0) {
            p_72949_6_ = 1;
         }

         int var8 = this.func_72972_b(EnumSkyBlock.Sky, p_72949_2_ - 1, p_72949_3_, p_72949_4_) - p_72949_6_;
         int var9 = this.func_72972_b(EnumSkyBlock.Sky, p_72949_2_ + 1, p_72949_3_, p_72949_4_) - p_72949_6_;
         int var10 = this.func_72972_b(EnumSkyBlock.Sky, p_72949_2_, p_72949_3_ - 1, p_72949_4_) - p_72949_6_;
         int var11 = this.func_72972_b(EnumSkyBlock.Sky, p_72949_2_, p_72949_3_ + 1, p_72949_4_) - p_72949_6_;
         int var12 = this.func_72972_b(EnumSkyBlock.Sky, p_72949_2_, p_72949_3_, p_72949_4_ - 1) - p_72949_6_;
         int var13 = this.func_72972_b(EnumSkyBlock.Sky, p_72949_2_, p_72949_3_, p_72949_4_ + 1) - p_72949_6_;
         if(var8 > var7) {
            var7 = var8;
         }

         if(var9 > var7) {
            var7 = var9;
         }

         if(var10 > var7) {
            var7 = var10;
         }

         if(var11 > var7) {
            var7 = var11;
         }

         if(var12 > var7) {
            var7 = var12;
         }

         if(var13 > var7) {
            var7 = var13;
         }
      }

      return var7;
   }

   private int func_72895_f(int p_72895_1_, int p_72895_2_, int p_72895_3_, int p_72895_4_, int p_72895_5_, int p_72895_6_) {
      int var7 = Block.field_71984_q[p_72895_5_];
      int var8 = this.func_72972_b(EnumSkyBlock.Block, p_72895_2_ - 1, p_72895_3_, p_72895_4_) - p_72895_6_;
      int var9 = this.func_72972_b(EnumSkyBlock.Block, p_72895_2_ + 1, p_72895_3_, p_72895_4_) - p_72895_6_;
      int var10 = this.func_72972_b(EnumSkyBlock.Block, p_72895_2_, p_72895_3_ - 1, p_72895_4_) - p_72895_6_;
      int var11 = this.func_72972_b(EnumSkyBlock.Block, p_72895_2_, p_72895_3_ + 1, p_72895_4_) - p_72895_6_;
      int var12 = this.func_72972_b(EnumSkyBlock.Block, p_72895_2_, p_72895_3_, p_72895_4_ - 1) - p_72895_6_;
      int var13 = this.func_72972_b(EnumSkyBlock.Block, p_72895_2_, p_72895_3_, p_72895_4_ + 1) - p_72895_6_;
      if(var8 > var7) {
         var7 = var8;
      }

      if(var9 > var7) {
         var7 = var9;
      }

      if(var10 > var7) {
         var7 = var10;
      }

      if(var11 > var7) {
         var7 = var11;
      }

      if(var12 > var7) {
         var7 = var12;
      }

      if(var13 > var7) {
         var7 = var13;
      }

      return var7;
   }

   public void func_72936_c(EnumSkyBlock p_72936_1_, int p_72936_2_, int p_72936_3_, int p_72936_4_) {
      if(this.func_72873_a(p_72936_2_, p_72936_3_, p_72936_4_, 17)) {
         int var5 = 0;
         int var6 = 0;
         this.field_72984_F.func_76320_a("getBrightness");
         int var7 = this.func_72972_b(p_72936_1_, p_72936_2_, p_72936_3_, p_72936_4_);
         boolean var8 = false;
         int var9 = this.func_72798_a(p_72936_2_, p_72936_3_, p_72936_4_);
         int var10 = this.func_72952_b(p_72936_2_, p_72936_3_, p_72936_4_);
         if(var10 == 0) {
            var10 = 1;
         }

         boolean var11 = false;
         int var24;
         if(p_72936_1_ == EnumSkyBlock.Sky) {
            var24 = this.func_72949_a(var7, p_72936_2_, p_72936_3_, p_72936_4_, var9, var10);
         } else {
            var24 = this.func_72895_f(var7, p_72936_2_, p_72936_3_, p_72936_4_, var9, var10);
         }

         int var12;
         int var13;
         int var14;
         int var15;
         int var17;
         int var16;
         int var19;
         int var18;
         if(var24 > var7) {
            this.field_72994_J[var6++] = 133152;
         } else if(var24 < var7) {
            if(p_72936_1_ != EnumSkyBlock.Block) {
               ;
            }

            this.field_72994_J[var6++] = 133152 + (var7 << 18);

            while(var5 < var6) {
               var9 = this.field_72994_J[var5++];
               var10 = (var9 & 63) - 32 + p_72936_2_;
               var24 = (var9 >> 6 & 63) - 32 + p_72936_3_;
               var12 = (var9 >> 12 & 63) - 32 + p_72936_4_;
               var13 = var9 >> 18 & 15;
               var14 = this.func_72972_b(p_72936_1_, var10, var24, var12);
               if(var14 == var13) {
                  this.func_72915_b(p_72936_1_, var10, var24, var12, 0);
                  if(var13 > 0) {
                     var15 = var10 - p_72936_2_;
                     var16 = var24 - p_72936_3_;
                     var17 = var12 - p_72936_4_;
                     if(var15 < 0) {
                        var15 = -var15;
                     }

                     if(var16 < 0) {
                        var16 = -var16;
                     }

                     if(var17 < 0) {
                        var17 = -var17;
                     }

                     if(var15 + var16 + var17 < 17) {
                        for(var18 = 0; var18 < 6; ++var18) {
                           var19 = var18 % 2 * 2 - 1;
                           int var20 = var10 + var18 / 2 % 3 / 2 * var19;
                           int var21 = var24 + (var18 / 2 + 1) % 3 / 2 * var19;
                           int var22 = var12 + (var18 / 2 + 2) % 3 / 2 * var19;
                           var14 = this.func_72972_b(p_72936_1_, var20, var21, var22);
                           int var23 = Block.field_71971_o[this.func_72798_a(var20, var21, var22)];
                           if(var23 == 0) {
                              var23 = 1;
                           }

                           if(var14 == var13 - var23 && var6 < this.field_72994_J.length) {
                              this.field_72994_J[var6++] = var20 - p_72936_2_ + 32 + (var21 - p_72936_3_ + 32 << 6) + (var22 - p_72936_4_ + 32 << 12) + (var13 - var23 << 18);
                           }
                        }
                     }
                  }
               }
            }

            var5 = 0;
         }

         this.field_72984_F.func_76319_b();
         this.field_72984_F.func_76320_a("tcp < tcc");

         while(var5 < var6) {
            var9 = this.field_72994_J[var5++];
            var10 = (var9 & 63) - 32 + p_72936_2_;
            var24 = (var9 >> 6 & 63) - 32 + p_72936_3_;
            var12 = (var9 >> 12 & 63) - 32 + p_72936_4_;
            var13 = this.func_72972_b(p_72936_1_, var10, var24, var12);
            var14 = this.func_72798_a(var10, var24, var12);
            var15 = Block.field_71971_o[var14];
            if(var15 == 0) {
               var15 = 1;
            }

            boolean var25 = false;
            if(p_72936_1_ == EnumSkyBlock.Sky) {
               var16 = this.func_72949_a(var13, var10, var24, var12, var14, var15);
            } else {
               var16 = this.func_72895_f(var13, var10, var24, var12, var14, var15);
            }

            if(var16 != var13) {
               this.func_72915_b(p_72936_1_, var10, var24, var12, var16);
               if(var16 > var13) {
                  var17 = var10 - p_72936_2_;
                  var18 = var24 - p_72936_3_;
                  var19 = var12 - p_72936_4_;
                  if(var17 < 0) {
                     var17 = -var17;
                  }

                  if(var18 < 0) {
                     var18 = -var18;
                  }

                  if(var19 < 0) {
                     var19 = -var19;
                  }

                  if(var17 + var18 + var19 < 17 && var6 < this.field_72994_J.length - 6) {
                     if(this.func_72972_b(p_72936_1_, var10 - 1, var24, var12) < var16) {
                        this.field_72994_J[var6++] = var10 - 1 - p_72936_2_ + 32 + (var24 - p_72936_3_ + 32 << 6) + (var12 - p_72936_4_ + 32 << 12);
                     }

                     if(this.func_72972_b(p_72936_1_, var10 + 1, var24, var12) < var16) {
                        this.field_72994_J[var6++] = var10 + 1 - p_72936_2_ + 32 + (var24 - p_72936_3_ + 32 << 6) + (var12 - p_72936_4_ + 32 << 12);
                     }

                     if(this.func_72972_b(p_72936_1_, var10, var24 - 1, var12) < var16) {
                        this.field_72994_J[var6++] = var10 - p_72936_2_ + 32 + (var24 - 1 - p_72936_3_ + 32 << 6) + (var12 - p_72936_4_ + 32 << 12);
                     }

                     if(this.func_72972_b(p_72936_1_, var10, var24 + 1, var12) < var16) {
                        this.field_72994_J[var6++] = var10 - p_72936_2_ + 32 + (var24 + 1 - p_72936_3_ + 32 << 6) + (var12 - p_72936_4_ + 32 << 12);
                     }

                     if(this.func_72972_b(p_72936_1_, var10, var24, var12 - 1) < var16) {
                        this.field_72994_J[var6++] = var10 - p_72936_2_ + 32 + (var24 - p_72936_3_ + 32 << 6) + (var12 - 1 - p_72936_4_ + 32 << 12);
                     }

                     if(this.func_72972_b(p_72936_1_, var10, var24, var12 + 1) < var16) {
                        this.field_72994_J[var6++] = var10 - p_72936_2_ + 32 + (var24 - p_72936_3_ + 32 << 6) + (var12 + 1 - p_72936_4_ + 32 << 12);
                     }
                  }
               }
            }
         }

         this.field_72984_F.func_76319_b();
      }
   }

   public boolean func_72955_a(boolean p_72955_1_) {
      return false;
   }

   public List func_72920_a(Chunk p_72920_1_, boolean p_72920_2_) {
      return null;
   }

   public List func_72839_b(Entity p_72839_1_, AxisAlignedBB p_72839_2_) {
      this.field_72991_N.clear();
      int var3 = MathHelper.func_76128_c((p_72839_2_.field_72340_a - 2.0D) / 16.0D);
      int var4 = MathHelper.func_76128_c((p_72839_2_.field_72336_d + 2.0D) / 16.0D);
      int var5 = MathHelper.func_76128_c((p_72839_2_.field_72339_c - 2.0D) / 16.0D);
      int var6 = MathHelper.func_76128_c((p_72839_2_.field_72334_f + 2.0D) / 16.0D);

      for(int var7 = var3; var7 <= var4; ++var7) {
         for(int var8 = var5; var8 <= var6; ++var8) {
            if(this.func_72916_c(var7, var8)) {
               this.func_72964_e(var7, var8).func_76588_a(p_72839_1_, p_72839_2_, this.field_72991_N);
            }
         }
      }

      return this.field_72991_N;
   }

   public List func_72872_a(Class p_72872_1_, AxisAlignedBB p_72872_2_) {
      int var3 = MathHelper.func_76128_c((p_72872_2_.field_72340_a - 2.0D) / 16.0D);
      int var4 = MathHelper.func_76128_c((p_72872_2_.field_72336_d + 2.0D) / 16.0D);
      int var5 = MathHelper.func_76128_c((p_72872_2_.field_72339_c - 2.0D) / 16.0D);
      int var6 = MathHelper.func_76128_c((p_72872_2_.field_72334_f + 2.0D) / 16.0D);
      ArrayList var7 = new ArrayList();

      for(int var8 = var3; var8 <= var4; ++var8) {
         for(int var9 = var5; var9 <= var6; ++var9) {
            if(this.func_72916_c(var8, var9)) {
               this.func_72964_e(var8, var9).func_76618_a(p_72872_1_, p_72872_2_, var7);
            }
         }
      }

      return var7;
   }

   public Entity func_72857_a(Class p_72857_1_, AxisAlignedBB p_72857_2_, Entity p_72857_3_) {
      List var4 = this.func_72872_a(p_72857_1_, p_72857_2_);
      Entity var5 = null;
      double var6 = Double.MAX_VALUE;
      Iterator var8 = var4.iterator();

      while(var8.hasNext()) {
         Entity var9 = (Entity)var8.next();
         if(var9 != p_72857_3_) {
            double var10 = p_72857_3_.func_70068_e(var9);
            if(var10 <= var6) {
               var5 = var9;
               var6 = var10;
            }
         }
      }

      return var5;
   }

   public List func_72910_y() {
      return this.field_72996_f;
   }

   public void func_72944_b(int p_72944_1_, int p_72944_2_, int p_72944_3_, TileEntity p_72944_4_) {
      if(this.func_72899_e(p_72944_1_, p_72944_2_, p_72944_3_)) {
         this.func_72938_d(p_72944_1_, p_72944_3_).func_76630_e();
      }

   }

   public int func_72907_a(Class p_72907_1_) {
      int var2 = 0;

      for(int var3 = 0; var3 < this.field_72996_f.size(); ++var3) {
         Entity var4 = (Entity)this.field_72996_f.get(var3);
         if(p_72907_1_.isAssignableFrom(var4.getClass())) {
            ++var2;
         }
      }

      return var2;
   }

   public void func_72868_a(List p_72868_1_) {
      this.field_72996_f.addAll(p_72868_1_);

      for(int var2 = 0; var2 < p_72868_1_.size(); ++var2) {
         this.func_72923_a((Entity)p_72868_1_.get(var2));
      }

   }

   public void func_72828_b(List p_72828_1_) {
      this.field_72997_g.addAll(p_72828_1_);
   }

   public boolean func_72931_a(int p_72931_1_, int p_72931_2_, int p_72931_3_, int p_72931_4_, boolean p_72931_5_, int p_72931_6_, Entity p_72931_7_) {
      int var8 = this.func_72798_a(p_72931_2_, p_72931_3_, p_72931_4_);
      Block var9 = Block.field_71973_m[var8];
      Block var10 = Block.field_71973_m[p_72931_1_];
      AxisAlignedBB var11 = var10.func_71872_e(this, p_72931_2_, p_72931_3_, p_72931_4_);
      if(p_72931_5_) {
         var11 = null;
      }

      if(var11 != null && !this.func_72917_a(var11, p_72931_7_)) {
         return false;
      } else {
         if(var9 != null && (var9 == Block.field_71942_A || var9 == Block.field_71943_B || var9 == Block.field_71944_C || var9 == Block.field_71938_D || var9 == Block.field_72067_ar || var9.field_72018_cp.func_76222_j())) {
            var9 = null;
         }

         return p_72931_1_ > 0 && var9 == null && var10.func_71850_a_(this, p_72931_2_, p_72931_3_, p_72931_4_, p_72931_6_);
      }
   }

   public PathEntity func_72865_a(Entity p_72865_1_, Entity p_72865_2_, float p_72865_3_, boolean p_72865_4_, boolean p_72865_5_, boolean p_72865_6_, boolean p_72865_7_) {
      this.field_72984_F.func_76320_a("pathfind");
      int var8 = MathHelper.func_76128_c(p_72865_1_.field_70165_t);
      int var9 = MathHelper.func_76128_c(p_72865_1_.field_70163_u + 1.0D);
      int var10 = MathHelper.func_76128_c(p_72865_1_.field_70161_v);
      int var11 = (int)(p_72865_3_ + 16.0F);
      int var12 = var8 - var11;
      int var13 = var9 - var11;
      int var14 = var10 - var11;
      int var15 = var8 + var11;
      int var16 = var9 + var11;
      int var17 = var10 + var11;
      ChunkCache var18 = new ChunkCache(this, var12, var13, var14, var15, var16, var17);
      PathEntity var19 = (new PathFinder(var18, p_72865_4_, p_72865_5_, p_72865_6_, p_72865_7_)).func_75856_a(p_72865_1_, p_72865_2_, p_72865_3_);
      this.field_72984_F.func_76319_b();
      return var19;
   }

   public PathEntity func_72844_a(Entity p_72844_1_, int p_72844_2_, int p_72844_3_, int p_72844_4_, float p_72844_5_, boolean p_72844_6_, boolean p_72844_7_, boolean p_72844_8_, boolean p_72844_9_) {
      this.field_72984_F.func_76320_a("pathfind");
      int var10 = MathHelper.func_76128_c(p_72844_1_.field_70165_t);
      int var11 = MathHelper.func_76128_c(p_72844_1_.field_70163_u);
      int var12 = MathHelper.func_76128_c(p_72844_1_.field_70161_v);
      int var13 = (int)(p_72844_5_ + 8.0F);
      int var14 = var10 - var13;
      int var15 = var11 - var13;
      int var16 = var12 - var13;
      int var17 = var10 + var13;
      int var18 = var11 + var13;
      int var19 = var12 + var13;
      ChunkCache var20 = new ChunkCache(this, var14, var15, var16, var17, var18, var19);
      PathEntity var21 = (new PathFinder(var20, p_72844_6_, p_72844_7_, p_72844_8_, p_72844_9_)).func_75859_a(p_72844_1_, p_72844_2_, p_72844_3_, p_72844_4_, p_72844_5_);
      this.field_72984_F.func_76319_b();
      return var21;
   }

   public boolean func_72879_k(int p_72879_1_, int p_72879_2_, int p_72879_3_, int p_72879_4_) {
      int var5 = this.func_72798_a(p_72879_1_, p_72879_2_, p_72879_3_);
      return var5 == 0?false:Block.field_71973_m[var5].func_71855_c(this, p_72879_1_, p_72879_2_, p_72879_3_, p_72879_4_);
   }

   public boolean func_72871_y(int p_72871_1_, int p_72871_2_, int p_72871_3_) {
      return this.func_72879_k(p_72871_1_, p_72871_2_ - 1, p_72871_3_, 0)?true:(this.func_72879_k(p_72871_1_, p_72871_2_ + 1, p_72871_3_, 1)?true:(this.func_72879_k(p_72871_1_, p_72871_2_, p_72871_3_ - 1, 2)?true:(this.func_72879_k(p_72871_1_, p_72871_2_, p_72871_3_ + 1, 3)?true:(this.func_72879_k(p_72871_1_ - 1, p_72871_2_, p_72871_3_, 4)?true:this.func_72879_k(p_72871_1_ + 1, p_72871_2_, p_72871_3_, 5)))));
   }

   public boolean func_72878_l(int p_72878_1_, int p_72878_2_, int p_72878_3_, int p_72878_4_) {
      if(this.func_72809_s(p_72878_1_, p_72878_2_, p_72878_3_)) {
         return this.func_72871_y(p_72878_1_, p_72878_2_, p_72878_3_);
      } else {
         int var5 = this.func_72798_a(p_72878_1_, p_72878_2_, p_72878_3_);
         return var5 == 0?false:Block.field_71973_m[var5].func_71865_a(this, p_72878_1_, p_72878_2_, p_72878_3_, p_72878_4_);
      }
   }

   public boolean func_72864_z(int p_72864_1_, int p_72864_2_, int p_72864_3_) {
      return this.func_72878_l(p_72864_1_, p_72864_2_ - 1, p_72864_3_, 0)?true:(this.func_72878_l(p_72864_1_, p_72864_2_ + 1, p_72864_3_, 1)?true:(this.func_72878_l(p_72864_1_, p_72864_2_, p_72864_3_ - 1, 2)?true:(this.func_72878_l(p_72864_1_, p_72864_2_, p_72864_3_ + 1, 3)?true:(this.func_72878_l(p_72864_1_ - 1, p_72864_2_, p_72864_3_, 4)?true:this.func_72878_l(p_72864_1_ + 1, p_72864_2_, p_72864_3_, 5)))));
   }

   public EntityPlayer func_72890_a(Entity p_72890_1_, double p_72890_2_) {
      return this.func_72977_a(p_72890_1_.field_70165_t, p_72890_1_.field_70163_u, p_72890_1_.field_70161_v, p_72890_2_);
   }

   public EntityPlayer func_72977_a(double p_72977_1_, double p_72977_3_, double p_72977_5_, double p_72977_7_) {
      double var9 = -1.0D;
      EntityPlayer var11 = null;

      for(int var12 = 0; var12 < this.field_73010_i.size(); ++var12) {
         EntityPlayer var13 = (EntityPlayer)this.field_73010_i.get(var12);
         double var14 = var13.func_70092_e(p_72977_1_, p_72977_3_, p_72977_5_);
         if((p_72977_7_ < 0.0D || var14 < p_72977_7_ * p_72977_7_) && (var9 == -1.0D || var14 < var9)) {
            var9 = var14;
            var11 = var13;
         }
      }

      return var11;
   }

   public EntityPlayer func_72856_b(Entity p_72856_1_, double p_72856_2_) {
      return this.func_72846_b(p_72856_1_.field_70165_t, p_72856_1_.field_70163_u, p_72856_1_.field_70161_v, p_72856_2_);
   }

   public EntityPlayer func_72846_b(double p_72846_1_, double p_72846_3_, double p_72846_5_, double p_72846_7_) {
      double var9 = -1.0D;
      EntityPlayer var11 = null;

      for(int var12 = 0; var12 < this.field_73010_i.size(); ++var12) {
         EntityPlayer var13 = (EntityPlayer)this.field_73010_i.get(var12);
         if(!var13.field_71075_bZ.field_75102_a) {
            double var14 = var13.func_70092_e(p_72846_1_, p_72846_3_, p_72846_5_);
            if((p_72846_7_ < 0.0D || var14 < p_72846_7_ * p_72846_7_) && (var9 == -1.0D || var14 < var9)) {
               var9 = var14;
               var11 = var13;
            }
         }
      }

      return var11;
   }

   public EntityPlayer func_72924_a(String p_72924_1_) {
      for(int var2 = 0; var2 < this.field_73010_i.size(); ++var2) {
         if(p_72924_1_.equals(((EntityPlayer)this.field_73010_i.get(var2)).field_71092_bJ)) {
            return (EntityPlayer)this.field_73010_i.get(var2);
         }
      }

      return null;
   }

   public void func_72882_A() {}

   public void func_72906_B() throws MinecraftException {
      this.field_73019_z.func_75762_c();
   }

   public void func_72877_b(long p_72877_1_) {
      this.field_72986_A.func_76068_b(p_72877_1_);
   }

   public long func_72905_C() {
      return this.field_72986_A.func_76063_b();
   }

   public long func_72820_D() {
      return this.field_72986_A.func_76073_f();
   }

   public ChunkCoordinates func_72861_E() {
      return new ChunkCoordinates(this.field_72986_A.func_76079_c(), this.field_72986_A.func_76075_d(), this.field_72986_A.func_76074_e());
   }

   public void func_72950_A(int p_72950_1_, int p_72950_2_, int p_72950_3_) {
      this.field_72986_A.func_76081_a(p_72950_1_, p_72950_2_, p_72950_3_);
   }

   public void func_72897_h(Entity p_72897_1_) {
      int var2 = MathHelper.func_76128_c(p_72897_1_.field_70165_t / 16.0D);
      int var3 = MathHelper.func_76128_c(p_72897_1_.field_70161_v / 16.0D);
      byte var4 = 2;

      for(int var5 = var2 - var4; var5 <= var2 + var4; ++var5) {
         for(int var6 = var3 - var4; var6 <= var3 + var4; ++var6) {
            this.func_72964_e(var5, var6);
         }
      }

      if(!this.field_72996_f.contains(p_72897_1_)) {
         this.field_72996_f.add(p_72897_1_);
      }

   }

   public boolean func_72962_a(EntityPlayer p_72962_1_, int p_72962_2_, int p_72962_3_, int p_72962_4_) {
      return true;
   }

   public void func_72960_a(Entity p_72960_1_, byte p_72960_2_) {}

   public IChunkProvider func_72863_F() {
      return this.field_73020_y;
   }

   public void func_72965_b(int p_72965_1_, int p_72965_2_, int p_72965_3_, int p_72965_4_, int p_72965_5_, int p_72965_6_) {
      if(p_72965_4_ > 0) {
         Block.field_71973_m[p_72965_4_].func_71883_b(this, p_72965_1_, p_72965_2_, p_72965_3_, p_72965_5_, p_72965_6_);
      }

   }

   public ISaveHandler func_72860_G() {
      return this.field_73019_z;
   }

   public WorldInfo func_72912_H() {
      return this.field_72986_A;
   }

   public void func_72854_c() {}

   public float func_72819_i(float p_72819_1_) {
      return (this.field_73018_p + (this.field_73017_q - this.field_73018_p) * p_72819_1_) * this.func_72867_j(p_72819_1_);
   }

   public float func_72867_j(float p_72867_1_) {
      return this.field_73003_n + (this.field_73004_o - this.field_73003_n) * p_72867_1_;
   }

   public void func_72894_k(float p_72894_1_) {
      this.field_73003_n = p_72894_1_;
      this.field_73004_o = p_72894_1_;
   }

   public boolean func_72911_I() {
      return (double)this.func_72819_i(1.0F) > 0.9D;
   }

   public boolean func_72896_J() {
      return (double)this.func_72867_j(1.0F) > 0.2D;
   }

   public boolean func_72951_B(int p_72951_1_, int p_72951_2_, int p_72951_3_) {
      if(!this.func_72896_J()) {
         return false;
      } else if(!this.func_72937_j(p_72951_1_, p_72951_2_, p_72951_3_)) {
         return false;
      } else if(this.func_72874_g(p_72951_1_, p_72951_3_) > p_72951_2_) {
         return false;
      } else {
         BiomeGenBase var4 = this.func_72807_a(p_72951_1_, p_72951_3_);
         return var4.func_76746_c()?false:var4.func_76738_d();
      }
   }

   public boolean func_72958_C(int p_72958_1_, int p_72958_2_, int p_72958_3_) {
      BiomeGenBase var4 = this.func_72807_a(p_72958_1_, p_72958_3_);
      return var4.func_76736_e();
   }

   public void func_72823_a(String p_72823_1_, WorldSavedData p_72823_2_) {
      this.field_72988_C.func_75745_a(p_72823_1_, p_72823_2_);
   }

   public WorldSavedData func_72943_a(Class p_72943_1_, String p_72943_2_) {
      return this.field_72988_C.func_75742_a(p_72943_1_, p_72943_2_);
   }

   public int func_72841_b(String p_72841_1_) {
      return this.field_72988_C.func_75743_a(p_72841_1_);
   }

   public void func_72926_e(int p_72926_1_, int p_72926_2_, int p_72926_3_, int p_72926_4_, int p_72926_5_) {
      this.func_72889_a((EntityPlayer)null, p_72926_1_, p_72926_2_, p_72926_3_, p_72926_4_, p_72926_5_);
   }

   public void func_72889_a(EntityPlayer p_72889_1_, int p_72889_2_, int p_72889_3_, int p_72889_4_, int p_72889_5_, int p_72889_6_) {
      for(int var7 = 0; var7 < this.field_73021_x.size(); ++var7) {
         ((IWorldAccess)this.field_73021_x.get(var7)).func_72706_a(p_72889_1_, p_72889_2_, p_72889_3_, p_72889_4_, p_72889_5_, p_72889_6_);
      }

   }

   public int func_72800_K() {
      return 256;
   }

   public int func_72940_L() {
      return this.field_73011_w.field_76576_e?128:256;
   }

   public Random func_72843_D(int p_72843_1_, int p_72843_2_, int p_72843_3_) {
      long var4 = (long)p_72843_1_ * 341873128712L + (long)p_72843_2_ * 132897987541L + this.func_72912_H().func_76063_b() + (long)p_72843_3_;
      this.field_73012_v.setSeed(var4);
      return this.field_73012_v;
   }

   public boolean func_72968_M() {
      return false;
   }

   public ChunkPosition func_72946_b(String p_72946_1_, int p_72946_2_, int p_72946_3_, int p_72946_4_) {
      return this.func_72863_F().func_73150_a(this, p_72946_1_, p_72946_2_, p_72946_3_, p_72946_4_);
   }

   public boolean func_72806_N() {
      return false;
   }

   public double func_72919_O() {
      return this.field_72986_A.func_76067_t() == WorldType.field_77138_c?0.0D:63.0D;
   }

   public CrashReport func_72914_a(CrashReport p_72914_1_) {
      p_72914_1_.func_71500_a("World " + this.field_72986_A.func_76065_j() + " Entities", new CallableLvl1(this));
      p_72914_1_.func_71500_a("World " + this.field_72986_A.func_76065_j() + " Players", new CallableLvl2(this));
      p_72914_1_.func_71500_a("World " + this.field_72986_A.func_76065_j() + " Chunk Stats", new CallableLvl3(this));
      return p_72914_1_;
   }

   public void func_72888_f(int p_72888_1_, int p_72888_2_, int p_72888_3_, int p_72888_4_, int p_72888_5_) {
      Iterator var6 = this.field_73021_x.iterator();

      while(var6.hasNext()) {
         IWorldAccess var7 = (IWorldAccess)var6.next();
         var7.func_72705_a(p_72888_1_, p_72888_2_, p_72888_3_, p_72888_4_, p_72888_5_);
      }

   }
}
