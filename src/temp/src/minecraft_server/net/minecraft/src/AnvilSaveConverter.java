package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import net.minecraft.src.AnvilConverterData;
import net.minecraft.src.AnvilSaveConverterFileFilter;
import net.minecraft.src.AnvilSaveHandler;
import net.minecraft.src.BiomeGenBase;
import net.minecraft.src.ChunkLoader;
import net.minecraft.src.CompressedStreamTools;
import net.minecraft.src.IProgressUpdate;
import net.minecraft.src.ISaveHandler;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.RegionFile;
import net.minecraft.src.RegionFileCache;
import net.minecraft.src.SaveFormatOld;
import net.minecraft.src.WorldChunkManager;
import net.minecraft.src.WorldChunkManagerHell;
import net.minecraft.src.WorldInfo;
import net.minecraft.src.WorldType;

public class AnvilSaveConverter extends SaveFormatOld {

   public AnvilSaveConverter(File p_i3910_1_) {
      super(p_i3910_1_);
   }

   protected int func_75812_c() {
      return 19133;
   }

   public void func_75800_d() {
      RegionFileCache.func_76551_a();
   }

   public ISaveHandler func_75804_a(String p_75804_1_, boolean p_75804_2_) {
      return new AnvilSaveHandler(this.field_75808_a, p_75804_1_, p_75804_2_);
   }

   public boolean func_75801_b(String p_75801_1_) {
      WorldInfo var2 = this.func_75803_c(p_75801_1_);
      return var2 != null && var2.func_76088_k() != this.func_75812_c();
   }

   public boolean func_75805_a(String p_75805_1_, IProgressUpdate p_75805_2_) {
      p_75805_2_.func_73718_a(0);
      ArrayList var3 = new ArrayList();
      ArrayList var4 = new ArrayList();
      ArrayList var5 = new ArrayList();
      File var6 = new File(this.field_75808_a, p_75805_1_);
      File var7 = new File(var6, "DIM-1");
      File var8 = new File(var6, "DIM1");
      System.out.println("Scanning folders...");
      this.func_75810_a(var6, var3);
      if(var7.exists()) {
         this.func_75810_a(var7, var4);
      }

      if(var8.exists()) {
         this.func_75810_a(var8, var5);
      }

      int var9 = var3.size() + var4.size() + var5.size();
      System.out.println("Total conversion count is " + var9);
      WorldInfo var10 = this.func_75803_c(p_75805_1_);
      Object var11 = null;
      if(var10.func_76067_t() == WorldType.field_77138_c) {
         var11 = new WorldChunkManagerHell(BiomeGenBase.field_76772_c, 0.5F, 0.5F);
      } else {
         var11 = new WorldChunkManager(var10.func_76063_b(), var10.func_76067_t());
      }

      this.func_75813_a(new File(var6, "region"), var3, (WorldChunkManager)var11, 0, var9, p_75805_2_);
      this.func_75813_a(new File(var7, "region"), var4, new WorldChunkManagerHell(BiomeGenBase.field_76778_j, 1.0F, 0.0F), var3.size(), var9, p_75805_2_);
      this.func_75813_a(new File(var8, "region"), var5, new WorldChunkManagerHell(BiomeGenBase.field_76779_k, 0.5F, 0.0F), var3.size() + var4.size(), var9, p_75805_2_);
      var10.func_76078_e(19133);
      if(var10.func_76067_t() == WorldType.field_77136_e) {
         var10.func_76085_a(WorldType.field_77137_b);
      }

      this.func_75809_f(p_75805_1_);
      ISaveHandler var12 = this.func_75804_a(p_75805_1_, false);
      var12.func_75761_a(var10);
      return true;
   }

   private void func_75809_f(String p_75809_1_) {
      File var2 = new File(this.field_75808_a, p_75809_1_);
      if(!var2.exists()) {
         System.out.println("Warning: Unable to create level.dat_mcr backup");
      } else {
         File var3 = new File(var2, "level.dat");
         if(!var3.exists()) {
            System.out.println("Warning: Unable to create level.dat_mcr backup");
         } else {
            File var4 = new File(var2, "level.dat_mcr");
            if(!var3.renameTo(var4)) {
               System.out.println("Warning: Unable to create level.dat_mcr backup");
            }

         }
      }
   }

   private void func_75813_a(File p_75813_1_, Iterable p_75813_2_, WorldChunkManager p_75813_3_, int p_75813_4_, int p_75813_5_, IProgressUpdate p_75813_6_) {
      Iterator var7 = p_75813_2_.iterator();

      while(var7.hasNext()) {
         File var8 = (File)var7.next();
         this.func_75811_a(p_75813_1_, var8, p_75813_3_, p_75813_4_, p_75813_5_, p_75813_6_);
         ++p_75813_4_;
         int var9 = (int)Math.round(100.0D * (double)p_75813_4_ / (double)p_75813_5_);
         p_75813_6_.func_73718_a(var9);
      }

   }

   private void func_75811_a(File p_75811_1_, File p_75811_2_, WorldChunkManager p_75811_3_, int p_75811_4_, int p_75811_5_, IProgressUpdate p_75811_6_) {
      try {
         String var7 = p_75811_2_.getName();
         RegionFile var8 = new RegionFile(p_75811_2_);
         RegionFile var9 = new RegionFile(new File(p_75811_1_, var7.substring(0, var7.length() - ".mcr".length()) + ".mca"));

         for(int var10 = 0; var10 < 32; ++var10) {
            int var11;
            for(var11 = 0; var11 < 32; ++var11) {
               if(var8.func_76709_c(var10, var11) && !var9.func_76709_c(var10, var11)) {
                  DataInputStream var12 = var8.func_76704_a(var10, var11);
                  if(var12 == null) {
                     System.out.println("Failed to fetch input stream");
                  } else {
                     NBTTagCompound var13 = CompressedStreamTools.func_74794_a(var12);
                     var12.close();
                     NBTTagCompound var14 = var13.func_74775_l("Level");
                     AnvilConverterData var15 = ChunkLoader.func_76691_a(var14);
                     NBTTagCompound var16 = new NBTTagCompound();
                     NBTTagCompound var17 = new NBTTagCompound();
                     var16.func_74782_a("Level", var17);
                     ChunkLoader.func_76690_a(var15, var17, p_75811_3_);
                     DataOutputStream var18 = var9.func_76710_b(var10, var11);
                     CompressedStreamTools.func_74800_a(var16, var18);
                     var18.close();
                  }
               }
            }

            var11 = (int)Math.round(100.0D * (double)(p_75811_4_ * 1024) / (double)(p_75811_5_ * 1024));
            int var20 = (int)Math.round(100.0D * (double)((var10 + 1) * 32 + p_75811_4_ * 1024) / (double)(p_75811_5_ * 1024));
            if(var20 > var11) {
               p_75811_6_.func_73718_a(var20);
            }
         }

         var8.func_76708_c();
         var9.func_76708_c();
      } catch (IOException var19) {
         var19.printStackTrace();
      }

   }

   private void func_75810_a(File p_75810_1_, Collection p_75810_2_) {
      File var3 = new File(p_75810_1_, "region");
      File[] var4 = var3.listFiles(new AnvilSaveConverterFileFilter(this));
      if(var4 != null) {
         Collections.addAll(p_75810_2_, var4);
      }

   }
}
