package net.minecraft.src;

import java.io.File;
import java.util.Random;
import net.minecraft.src.CodecMus;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.GameSettings;
import net.minecraft.src.MathHelper;
import net.minecraft.src.SoundPool;
import net.minecraft.src.SoundPoolEntry;
import paulscode.sound.SoundSystem;
import paulscode.sound.SoundSystemConfig;
import paulscode.sound.codecs.CodecJOrbis;
import paulscode.sound.codecs.CodecWav;
import paulscode.sound.libraries.LibraryLWJGLOpenAL;

public class SoundManager {

   private static SoundSystem field_77381_a;
   private SoundPool field_77379_b = new SoundPool();
   private SoundPool field_77380_c = new SoundPool();
   private SoundPool field_77377_d = new SoundPool();
   private int field_77378_e = 0;
   private GameSettings field_77375_f;
   private static boolean field_77376_g = false;
   private Random field_77382_h = new Random();
   private int field_77383_i;


   public SoundManager() {
      this.field_77383_i = this.field_77382_h.nextInt(12000);
   }

   public void func_77373_a(GameSettings p_77373_1_) {
      this.field_77380_c.field_77463_b = false;
      this.field_77375_f = p_77373_1_;
      if(!field_77376_g && (p_77373_1_ == null || p_77373_1_.field_74340_b != 0.0F || p_77373_1_.field_74342_a != 0.0F)) {
         this.func_77363_d();
      }

   }

   private void func_77363_d() {
      try {
         float var1 = this.field_77375_f.field_74340_b;
         float var2 = this.field_77375_f.field_74342_a;
         this.field_77375_f.field_74340_b = 0.0F;
         this.field_77375_f.field_74342_a = 0.0F;
         this.field_77375_f.func_74303_b();
         SoundSystemConfig.addLibrary(LibraryLWJGLOpenAL.class);
         SoundSystemConfig.setCodec("ogg", CodecJOrbis.class);
         SoundSystemConfig.setCodec("mus", CodecMus.class);
         SoundSystemConfig.setCodec("wav", CodecWav.class);
         field_77381_a = new SoundSystem();
         this.field_77375_f.field_74340_b = var1;
         this.field_77375_f.field_74342_a = var2;
         this.field_77375_f.func_74303_b();
      } catch (Throwable var3) {
         var3.printStackTrace();
         System.err.println("error linking with the LibraryJavaSound plug-in");
      }

      field_77376_g = true;
   }

   public void func_77367_a() {
      if(!field_77376_g && (this.field_77375_f.field_74340_b != 0.0F || this.field_77375_f.field_74342_a != 0.0F)) {
         this.func_77363_d();
      }

      if(field_77376_g) {
         if(this.field_77375_f.field_74342_a == 0.0F) {
            field_77381_a.stop("BgMusic");
         } else {
            field_77381_a.setVolume("BgMusic", this.field_77375_f.field_74342_a);
         }
      }

   }

   public void func_77370_b() {
      if(field_77376_g) {
         field_77381_a.cleanup();
      }

   }

   public void func_77372_a(String p_77372_1_, File p_77372_2_) {
      this.field_77379_b.func_77459_a(p_77372_1_, p_77372_2_);
   }

   public void func_77374_b(String p_77374_1_, File p_77374_2_) {
      this.field_77380_c.func_77459_a(p_77374_1_, p_77374_2_);
   }

   public void func_77365_c(String p_77365_1_, File p_77365_2_) {
      this.field_77377_d.func_77459_a(p_77365_1_, p_77365_2_);
   }

   public void func_77371_c() {
      if(field_77376_g && this.field_77375_f.field_74342_a != 0.0F) {
         if(!field_77381_a.playing("BgMusic") && !field_77381_a.playing("streaming")) {
            if(this.field_77383_i > 0) {
               --this.field_77383_i;
               return;
            }

            SoundPoolEntry var1 = this.field_77377_d.func_77460_a();
            if(var1 != null) {
               this.field_77383_i = this.field_77382_h.nextInt(12000) + 12000;
               field_77381_a.backgroundMusic("BgMusic", var1.field_77384_b, var1.field_77385_a, false);
               field_77381_a.setVolume("BgMusic", this.field_77375_f.field_74342_a);
               field_77381_a.play("BgMusic");
            }
         }

      }
   }

   public void func_77369_a(EntityLiving p_77369_1_, float p_77369_2_) {
      if(field_77376_g && this.field_77375_f.field_74340_b != 0.0F) {
         if(p_77369_1_ != null) {
            float var3 = p_77369_1_.field_70126_B + (p_77369_1_.field_70177_z - p_77369_1_.field_70126_B) * p_77369_2_;
            double var4 = p_77369_1_.field_70169_q + (p_77369_1_.field_70165_t - p_77369_1_.field_70169_q) * (double)p_77369_2_;
            double var6 = p_77369_1_.field_70167_r + (p_77369_1_.field_70163_u - p_77369_1_.field_70167_r) * (double)p_77369_2_;
            double var8 = p_77369_1_.field_70166_s + (p_77369_1_.field_70161_v - p_77369_1_.field_70166_s) * (double)p_77369_2_;
            float var10 = MathHelper.func_76134_b(-var3 * 0.017453292F - 3.1415927F);
            float var11 = MathHelper.func_76126_a(-var3 * 0.017453292F - 3.1415927F);
            float var12 = -var11;
            float var13 = 0.0F;
            float var14 = -var10;
            float var15 = 0.0F;
            float var16 = 1.0F;
            float var17 = 0.0F;
            field_77381_a.setListenerPosition((float)var4, (float)var6, (float)var8);
            field_77381_a.setListenerOrientation(var12, var13, var14, var15, var16, var17);
         }
      }
   }

   public void func_77368_a(String p_77368_1_, float p_77368_2_, float p_77368_3_, float p_77368_4_, float p_77368_5_, float p_77368_6_) {
      if(field_77376_g && (this.field_77375_f.field_74340_b != 0.0F || p_77368_1_ == null)) {
         String var7 = "streaming";
         if(field_77381_a.playing("streaming")) {
            field_77381_a.stop("streaming");
         }

         if(p_77368_1_ != null) {
            SoundPoolEntry var8 = this.field_77380_c.func_77458_a(p_77368_1_);
            if(var8 != null && p_77368_5_ > 0.0F) {
               if(field_77381_a.playing("BgMusic")) {
                  field_77381_a.stop("BgMusic");
               }

               float var9 = 16.0F;
               field_77381_a.newStreamingSource(true, var7, var8.field_77384_b, var8.field_77385_a, false, p_77368_2_, p_77368_3_, p_77368_4_, 2, var9 * 4.0F);
               field_77381_a.setVolume(var7, 0.5F * this.field_77375_f.field_74340_b);
               field_77381_a.play(var7);
            }

         }
      }
   }

   public void func_77364_b(String p_77364_1_, float p_77364_2_, float p_77364_3_, float p_77364_4_, float p_77364_5_, float p_77364_6_) {
      if(field_77376_g && this.field_77375_f.field_74340_b != 0.0F) {
         SoundPoolEntry var7 = this.field_77379_b.func_77458_a(p_77364_1_);
         if(var7 != null && p_77364_5_ > 0.0F) {
            this.field_77378_e = (this.field_77378_e + 1) % 256;
            String var8 = "sound_" + this.field_77378_e;
            float var9 = 16.0F;
            if(p_77364_5_ > 1.0F) {
               var9 *= p_77364_5_;
            }

            field_77381_a.newSource(p_77364_5_ > 1.0F, var8, var7.field_77384_b, var7.field_77385_a, false, p_77364_2_, p_77364_3_, p_77364_4_, 2, var9);
            field_77381_a.setPitch(var8, p_77364_6_);
            if(p_77364_5_ > 1.0F) {
               p_77364_5_ = 1.0F;
            }

            field_77381_a.setVolume(var8, p_77364_5_ * this.field_77375_f.field_74340_b);
            field_77381_a.play(var8);
         }

      }
   }

   public void func_77366_a(String p_77366_1_, float p_77366_2_, float p_77366_3_) {
      if(field_77376_g && this.field_77375_f.field_74340_b != 0.0F) {
         SoundPoolEntry var4 = this.field_77379_b.func_77458_a(p_77366_1_);
         if(var4 != null) {
            this.field_77378_e = (this.field_77378_e + 1) % 256;
            String var5 = "sound_" + this.field_77378_e;
            field_77381_a.newSource(false, var5, var4.field_77384_b, var4.field_77385_a, false, 0.0F, 0.0F, 0.0F, 0, 0.0F);
            if(p_77366_2_ > 1.0F) {
               p_77366_2_ = 1.0F;
            }

            p_77366_2_ *= 0.25F;
            field_77381_a.setPitch(var5, p_77366_3_);
            field_77381_a.setVolume(var5, p_77366_2_ * this.field_77375_f.field_74340_b);
            field_77381_a.play(var5);
         }

      }
   }

}
