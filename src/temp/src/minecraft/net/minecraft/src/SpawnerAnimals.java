package net.minecraft.src;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import net.minecraft.src.BiomeGenBase;
import net.minecraft.src.Block;
import net.minecraft.src.Chunk;
import net.minecraft.src.ChunkCoordIntPair;
import net.minecraft.src.ChunkCoordinates;
import net.minecraft.src.ChunkPosition;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityOcelot;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EntitySheep;
import net.minecraft.src.EntitySkeleton;
import net.minecraft.src.EntitySpider;
import net.minecraft.src.EntityZombie;
import net.minecraft.src.EnumCreatureType;
import net.minecraft.src.Material;
import net.minecraft.src.MathHelper;
import net.minecraft.src.SpawnListEntry;
import net.minecraft.src.WeightedRandom;
import net.minecraft.src.World;
import net.minecraft.src.WorldServer;

public final class SpawnerAnimals {

   private static HashMap field_77193_b = new HashMap();
   protected static final Class[] field_77194_a = new Class[]{EntitySpider.class, EntityZombie.class, EntitySkeleton.class};


   protected static ChunkPosition func_77189_a(World p_77189_0_, int p_77189_1_, int p_77189_2_) {
      Chunk var3 = p_77189_0_.func_72964_e(p_77189_1_, p_77189_2_);
      int var4 = p_77189_1_ * 16 + p_77189_0_.field_73012_v.nextInt(16);
      int var5 = p_77189_2_ * 16 + p_77189_0_.field_73012_v.nextInt(16);
      int var6 = p_77189_0_.field_73012_v.nextInt(var3 == null?p_77189_0_.func_72940_L():var3.func_76625_h() + 16 - 1);
      return new ChunkPosition(var4, var6, var5);
   }

   public static final int func_77192_a(WorldServer p_77192_0_, boolean p_77192_1_, boolean p_77192_2_) {
      if(!p_77192_1_ && !p_77192_2_) {
         return 0;
      } else {
         field_77193_b.clear();

         int var3;
         int var6;
         for(var3 = 0; var3 < p_77192_0_.field_73010_i.size(); ++var3) {
            EntityPlayer var4 = (EntityPlayer)p_77192_0_.field_73010_i.get(var3);
            int var5 = MathHelper.func_76128_c(var4.field_70165_t / 16.0D);
            var6 = MathHelper.func_76128_c(var4.field_70161_v / 16.0D);
            byte var7 = 8;

            for(int var8 = -var7; var8 <= var7; ++var8) {
               for(int var9 = -var7; var9 <= var7; ++var9) {
                  boolean var10 = var8 == -var7 || var8 == var7 || var9 == -var7 || var9 == var7;
                  ChunkCoordIntPair var11 = new ChunkCoordIntPair(var8 + var5, var9 + var6);
                  if(!var10) {
                     field_77193_b.put(var11, Boolean.valueOf(false));
                  } else if(!field_77193_b.containsKey(var11)) {
                     field_77193_b.put(var11, Boolean.valueOf(true));
                  }
               }
            }
         }

         var3 = 0;
         ChunkCoordinates var31 = p_77192_0_.func_72861_E();
         EnumCreatureType[] var32 = EnumCreatureType.values();
         var6 = var32.length;

         for(int var33 = 0; var33 < var6; ++var33) {
            EnumCreatureType var34 = var32[var33];
            if((!var34.func_75599_d() || p_77192_2_) && (var34.func_75599_d() || p_77192_1_) && p_77192_0_.func_72907_a(var34.func_75598_a()) <= var34.func_75601_b() * field_77193_b.size() / 256) {
               Iterator var35 = field_77193_b.keySet().iterator();

               label108:
               while(var35.hasNext()) {
                  ChunkCoordIntPair var37 = (ChunkCoordIntPair)var35.next();
                  if(!((Boolean)field_77193_b.get(var37)).booleanValue()) {
                     ChunkPosition var36 = func_77189_a(p_77192_0_, var37.field_77276_a, var37.field_77275_b);
                     int var12 = var36.field_76930_a;
                     int var13 = var36.field_76928_b;
                     int var14 = var36.field_76929_c;
                     if(!p_77192_0_.func_72809_s(var12, var13, var14) && p_77192_0_.func_72803_f(var12, var13, var14) == var34.func_75600_c()) {
                        int var15 = 0;
                        int var16 = 0;

                        while(var16 < 3) {
                           int var17 = var12;
                           int var18 = var13;
                           int var19 = var14;
                           byte var20 = 6;
                           SpawnListEntry var21 = null;
                           int var22 = 0;

                           while(true) {
                              if(var22 < 4) {
                                 label101: {
                                    var17 += p_77192_0_.field_73012_v.nextInt(var20) - p_77192_0_.field_73012_v.nextInt(var20);
                                    var18 += p_77192_0_.field_73012_v.nextInt(1) - p_77192_0_.field_73012_v.nextInt(1);
                                    var19 += p_77192_0_.field_73012_v.nextInt(var20) - p_77192_0_.field_73012_v.nextInt(var20);
                                    if(func_77190_a(var34, p_77192_0_, var17, var18, var19)) {
                                       float var23 = (float)var17 + 0.5F;
                                       float var24 = (float)var18;
                                       float var25 = (float)var19 + 0.5F;
                                       if(p_77192_0_.func_72977_a((double)var23, (double)var24, (double)var25, 24.0D) == null) {
                                          float var26 = var23 - (float)var31.field_71574_a;
                                          float var27 = var24 - (float)var31.field_71572_b;
                                          float var28 = var25 - (float)var31.field_71573_c;
                                          float var29 = var26 * var26 + var27 * var27 + var28 * var28;
                                          if(var29 >= 576.0F) {
                                             if(var21 == null) {
                                                var21 = p_77192_0_.func_73057_a(var34, var17, var18, var19);
                                                if(var21 == null) {
                                                   break label101;
                                                }
                                             }

                                             EntityLiving var38;
                                             try {
                                                var38 = (EntityLiving)var21.field_76300_b.getConstructor(new Class[]{World.class}).newInstance(new Object[]{p_77192_0_});
                                             } catch (Exception var30) {
                                                var30.printStackTrace();
                                                return var3;
                                             }

                                             var38.func_70012_b((double)var23, (double)var24, (double)var25, p_77192_0_.field_73012_v.nextFloat() * 360.0F, 0.0F);
                                             if(var38.func_70601_bi()) {
                                                ++var15;
                                                p_77192_0_.func_72838_d(var38);
                                                func_77188_a(var38, p_77192_0_, var23, var24, var25);
                                                if(var15 >= var38.func_70641_bl()) {
                                                   continue label108;
                                                }
                                             }

                                             var3 += var15;
                                          }
                                       }
                                    }

                                    ++var22;
                                    continue;
                                 }
                              }

                              ++var16;
                              break;
                           }
                        }
                     }
                  }
               }
            }
         }

         return var3;
      }
   }

   public static boolean func_77190_a(EnumCreatureType p_77190_0_, World p_77190_1_, int p_77190_2_, int p_77190_3_, int p_77190_4_) {
      if(p_77190_0_.func_75600_c() == Material.field_76244_g) {
         return p_77190_1_.func_72803_f(p_77190_2_, p_77190_3_, p_77190_4_).func_76224_d() && !p_77190_1_.func_72809_s(p_77190_2_, p_77190_3_ + 1, p_77190_4_);
      } else if(!p_77190_1_.func_72797_t(p_77190_2_, p_77190_3_ - 1, p_77190_4_)) {
         return false;
      } else {
         int var5 = p_77190_1_.func_72798_a(p_77190_2_, p_77190_3_ - 1, p_77190_4_);
         return var5 != Block.field_71986_z.field_71990_ca && !p_77190_1_.func_72809_s(p_77190_2_, p_77190_3_, p_77190_4_) && !p_77190_1_.func_72803_f(p_77190_2_, p_77190_3_, p_77190_4_).func_76224_d() && !p_77190_1_.func_72809_s(p_77190_2_, p_77190_3_ + 1, p_77190_4_);
      }
   }

   private static void func_77188_a(EntityLiving p_77188_0_, World p_77188_1_, float p_77188_2_, float p_77188_3_, float p_77188_4_) {
      if(p_77188_0_ instanceof EntitySpider && p_77188_1_.field_73012_v.nextInt(100) == 0) {
         EntitySkeleton var7 = new EntitySkeleton(p_77188_1_);
         var7.func_70012_b((double)p_77188_2_, (double)p_77188_3_, (double)p_77188_4_, p_77188_0_.field_70177_z, 0.0F);
         p_77188_1_.func_72838_d(var7);
         var7.func_70078_a(p_77188_0_);
      } else if(p_77188_0_ instanceof EntitySheep) {
         ((EntitySheep)p_77188_0_).func_70891_b(EntitySheep.func_70895_a(p_77188_1_.field_73012_v));
      } else if(p_77188_0_ instanceof EntityOcelot && p_77188_1_.field_73012_v.nextInt(7) == 0) {
         for(int var5 = 0; var5 < 2; ++var5) {
            EntityOcelot var6 = new EntityOcelot(p_77188_1_);
            var6.func_70012_b((double)p_77188_2_, (double)p_77188_3_, (double)p_77188_4_, p_77188_0_.field_70177_z, 0.0F);
            var6.func_70873_a(-24000);
            p_77188_1_.func_72838_d(var6);
         }
      }

   }

   public static void func_77191_a(World p_77191_0_, BiomeGenBase p_77191_1_, int p_77191_2_, int p_77191_3_, int p_77191_4_, int p_77191_5_, Random p_77191_6_) {
      List var7 = p_77191_1_.func_76747_a(EnumCreatureType.creature);
      if(!var7.isEmpty()) {
         while(p_77191_6_.nextFloat() < p_77191_1_.func_76741_f()) {
            SpawnListEntry var8 = (SpawnListEntry)WeightedRandom.func_76271_a(p_77191_0_.field_73012_v, var7);
            int var9 = var8.field_76301_c + p_77191_6_.nextInt(1 + var8.field_76299_d - var8.field_76301_c);
            int var10 = p_77191_2_ + p_77191_6_.nextInt(p_77191_4_);
            int var11 = p_77191_3_ + p_77191_6_.nextInt(p_77191_5_);
            int var12 = var10;
            int var13 = var11;

            for(int var14 = 0; var14 < var9; ++var14) {
               boolean var15 = false;

               for(int var16 = 0; !var15 && var16 < 4; ++var16) {
                  int var17 = p_77191_0_.func_72825_h(var10, var11);
                  if(func_77190_a(EnumCreatureType.creature, p_77191_0_, var10, var17, var11)) {
                     float var18 = (float)var10 + 0.5F;
                     float var19 = (float)var17;
                     float var20 = (float)var11 + 0.5F;

                     EntityLiving var21;
                     try {
                        var21 = (EntityLiving)var8.field_76300_b.getConstructor(new Class[]{World.class}).newInstance(new Object[]{p_77191_0_});
                     } catch (Exception var23) {
                        var23.printStackTrace();
                        continue;
                     }

                     var21.func_70012_b((double)var18, (double)var19, (double)var20, p_77191_6_.nextFloat() * 360.0F, 0.0F);
                     p_77191_0_.func_72838_d(var21);
                     func_77188_a(var21, p_77191_0_, var18, var19, var20);
                     var15 = true;
                  }

                  var10 += p_77191_6_.nextInt(5) - p_77191_6_.nextInt(5);

                  for(var11 += p_77191_6_.nextInt(5) - p_77191_6_.nextInt(5); var10 < p_77191_2_ || var10 >= p_77191_2_ + p_77191_4_ || var11 < p_77191_3_ || var11 >= p_77191_3_ + p_77191_4_; var11 = var13 + p_77191_6_.nextInt(5) - p_77191_6_.nextInt(5)) {
                     var10 = var12 + p_77191_6_.nextInt(5) - p_77191_6_.nextInt(5);
                  }
               }
            }
         }

      }
   }

}
