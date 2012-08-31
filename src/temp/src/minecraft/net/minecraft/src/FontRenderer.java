package net.minecraft.src;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.text.Bidi;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import javax.imageio.ImageIO;
import net.minecraft.src.ChatAllowedCharacters;
import net.minecraft.src.GameSettings;
import net.minecraft.src.RenderEngine;
import net.minecraft.src.Tessellator;
import org.lwjgl.opengl.GL11;

public class FontRenderer {

   private int[] field_78286_d = new int[256];
   public int field_78290_a = 0;
   public int field_78288_b = 9;
   public Random field_78289_c = new Random();
   private byte[] field_78287_e = new byte[65536];
   private final int[] field_78284_f = new int[256];
   private int[] field_78285_g = new int[32];
   private int field_78297_h;
   private final RenderEngine field_78298_i;
   private float field_78295_j;
   private float field_78296_k;
   private boolean field_78293_l;
   private boolean field_78294_m;
   private float field_78291_n;
   private float field_78292_o;
   private float field_78306_p;
   private float field_78305_q;
   private int field_78304_r;
   private boolean field_78303_s = false;
   private boolean field_78302_t = false;
   private boolean field_78301_u = false;
   private boolean field_78300_v = false;
   private boolean field_78299_w = false;


   FontRenderer() {
      this.field_78298_i = null;
   }

   public FontRenderer(GameSettings p_i3067_1_, String p_i3067_2_, RenderEngine p_i3067_3_, boolean p_i3067_4_) {
      this.field_78298_i = p_i3067_3_;
      this.field_78293_l = p_i3067_4_;

      BufferedImage var5;
      try {
         var5 = ImageIO.read(RenderEngine.class.getResourceAsStream(p_i3067_2_));
         InputStream var6 = RenderEngine.class.getResourceAsStream("/font/glyph_sizes.bin");
         var6.read(this.field_78287_e);
      } catch (IOException var18) {
         throw new RuntimeException(var18);
      }

      int var19 = var5.getWidth();
      int var7 = var5.getHeight();
      int[] var8 = new int[var19 * var7];
      var5.getRGB(0, 0, var19, var7, var8, 0, var19);
      int var9 = 0;

      int var10;
      int var11;
      int var12;
      int var13;
      int var15;
      int var16;
      while(var9 < 256) {
         var10 = var9 % 16;
         var11 = var9 / 16;
         var12 = 7;

         while(true) {
            if(var12 >= 0) {
               var13 = var10 * 8 + var12;
               boolean var14 = true;

               for(var15 = 0; var15 < 8 && var14; ++var15) {
                  var16 = (var11 * 8 + var15) * var19;
                  int var17 = var8[var13 + var16] & 255;
                  if(var17 > 0) {
                     var14 = false;
                  }
               }

               if(var14) {
                  --var12;
                  continue;
               }
            }

            if(var9 == 32) {
               var12 = 2;
            }

            this.field_78286_d[var9] = var12 + 2;
            ++var9;
            break;
         }
      }

      this.field_78290_a = p_i3067_3_.func_78353_a(var5);

      for(var9 = 0; var9 < 32; ++var9) {
         var10 = (var9 >> 3 & 1) * 85;
         var11 = (var9 >> 2 & 1) * 170 + var10;
         var12 = (var9 >> 1 & 1) * 170 + var10;
         var13 = (var9 >> 0 & 1) * 170 + var10;
         if(var9 == 6) {
            var11 += 85;
         }

         if(p_i3067_1_.field_74337_g) {
            int var20 = (var11 * 30 + var12 * 59 + var13 * 11) / 100;
            var15 = (var11 * 30 + var12 * 70) / 100;
            var16 = (var11 * 30 + var13 * 70) / 100;
            var11 = var20;
            var12 = var15;
            var13 = var16;
         }

         if(var9 >= 16) {
            var11 /= 4;
            var12 /= 4;
            var13 /= 4;
         }

         this.field_78285_g[var9] = (var11 & 255) << 16 | (var12 & 255) << 8 | var13 & 255;
      }

   }

   private float func_78278_a(int p_78278_1_, char p_78278_2_, boolean p_78278_3_) {
      return p_78278_2_ == 32?4.0F:(p_78278_1_ > 0 && !this.field_78293_l?this.func_78266_a(p_78278_1_ + 32, p_78278_3_):this.func_78277_a(p_78278_2_, p_78278_3_));
   }

   private float func_78266_a(int p_78266_1_, boolean p_78266_2_) {
      float var3 = (float)(p_78266_1_ % 16 * 8);
      float var4 = (float)(p_78266_1_ / 16 * 8);
      float var5 = p_78266_2_?1.0F:0.0F;
      if(this.field_78297_h != this.field_78290_a) {
         GL11.glBindTexture(3553, this.field_78290_a);
         this.field_78297_h = this.field_78290_a;
      }

      float var6 = (float)this.field_78286_d[p_78266_1_] - 0.01F;
      GL11.glBegin(5);
      GL11.glTexCoord2f(var3 / 128.0F, var4 / 128.0F);
      GL11.glVertex3f(this.field_78295_j + var5, this.field_78296_k, 0.0F);
      GL11.glTexCoord2f(var3 / 128.0F, (var4 + 7.99F) / 128.0F);
      GL11.glVertex3f(this.field_78295_j - var5, this.field_78296_k + 7.99F, 0.0F);
      GL11.glTexCoord2f((var3 + var6) / 128.0F, var4 / 128.0F);
      GL11.glVertex3f(this.field_78295_j + var6 + var5, this.field_78296_k, 0.0F);
      GL11.glTexCoord2f((var3 + var6) / 128.0F, (var4 + 7.99F) / 128.0F);
      GL11.glVertex3f(this.field_78295_j + var6 - var5, this.field_78296_k + 7.99F, 0.0F);
      GL11.glEnd();
      return (float)this.field_78286_d[p_78266_1_];
   }

   private void func_78257_a(int p_78257_1_) {
      String var3 = String.format("/font/glyph_%02X.png", new Object[]{Integer.valueOf(p_78257_1_)});

      BufferedImage var2;
      try {
         var2 = ImageIO.read(RenderEngine.class.getResourceAsStream(var3));
      } catch (IOException var5) {
         throw new RuntimeException(var5);
      }

      this.field_78284_f[p_78257_1_] = this.field_78298_i.func_78353_a(var2);
      this.field_78297_h = this.field_78284_f[p_78257_1_];
   }

   private float func_78277_a(char p_78277_1_, boolean p_78277_2_) {
      if(this.field_78287_e[p_78277_1_] == 0) {
         return 0.0F;
      } else {
         int var3 = p_78277_1_ / 256;
         if(this.field_78284_f[var3] == 0) {
            this.func_78257_a(var3);
         }

         if(this.field_78297_h != this.field_78284_f[var3]) {
            GL11.glBindTexture(3553, this.field_78284_f[var3]);
            this.field_78297_h = this.field_78284_f[var3];
         }

         int var4 = this.field_78287_e[p_78277_1_] >>> 4;
         int var5 = this.field_78287_e[p_78277_1_] & 15;
         float var6 = (float)var4;
         float var7 = (float)(var5 + 1);
         float var8 = (float)(p_78277_1_ % 16 * 16) + var6;
         float var9 = (float)((p_78277_1_ & 255) / 16 * 16);
         float var10 = var7 - var6 - 0.02F;
         float var11 = p_78277_2_?1.0F:0.0F;
         GL11.glBegin(5);
         GL11.glTexCoord2f(var8 / 256.0F, var9 / 256.0F);
         GL11.glVertex3f(this.field_78295_j + var11, this.field_78296_k, 0.0F);
         GL11.glTexCoord2f(var8 / 256.0F, (var9 + 15.98F) / 256.0F);
         GL11.glVertex3f(this.field_78295_j - var11, this.field_78296_k + 7.99F, 0.0F);
         GL11.glTexCoord2f((var8 + var10) / 256.0F, var9 / 256.0F);
         GL11.glVertex3f(this.field_78295_j + var10 / 2.0F + var11, this.field_78296_k, 0.0F);
         GL11.glTexCoord2f((var8 + var10) / 256.0F, (var9 + 15.98F) / 256.0F);
         GL11.glVertex3f(this.field_78295_j + var10 / 2.0F - var11, this.field_78296_k + 7.99F, 0.0F);
         GL11.glEnd();
         return (var7 - var6) / 2.0F + 1.0F;
      }
   }

   public int func_78261_a(String p_78261_1_, int p_78261_2_, int p_78261_3_, int p_78261_4_) {
      this.func_78265_b();
      if(this.field_78294_m) {
         p_78261_1_ = this.func_78283_c(p_78261_1_);
      }

      int var5 = this.func_78258_a(p_78261_1_, p_78261_2_ + 1, p_78261_3_ + 1, p_78261_4_, true);
      var5 = Math.max(var5, this.func_78258_a(p_78261_1_, p_78261_2_, p_78261_3_, p_78261_4_, false));
      return var5;
   }

   public void func_78276_b(String p_78276_1_, int p_78276_2_, int p_78276_3_, int p_78276_4_) {
      this.func_78265_b();
      if(this.field_78294_m) {
         p_78276_1_ = this.func_78283_c(p_78276_1_);
      }

      this.func_78258_a(p_78276_1_, p_78276_2_, p_78276_3_, p_78276_4_, false);
   }

   private String func_78283_c(String p_78283_1_) {
      if(p_78283_1_ != null && Bidi.requiresBidi(p_78283_1_.toCharArray(), 0, p_78283_1_.length())) {
         Bidi var2 = new Bidi(p_78283_1_, -2);
         byte[] var3 = new byte[var2.getRunCount()];
         String[] var4 = new String[var3.length];

         int var7;
         for(int var5 = 0; var5 < var3.length; ++var5) {
            int var6 = var2.getRunStart(var5);
            var7 = var2.getRunLimit(var5);
            int var8 = var2.getRunLevel(var5);
            String var9 = p_78283_1_.substring(var6, var7);
            var3[var5] = (byte)var8;
            var4[var5] = var9;
         }

         String[] var11 = (String[])var4.clone();
         Bidi.reorderVisually(var3, 0, var4, 0, var3.length);
         StringBuilder var12 = new StringBuilder();
         var7 = 0;

         while(var7 < var4.length) {
            byte var13 = var3[var7];
            int var14 = 0;

            while(true) {
               if(var14 < var11.length) {
                  if(!var11[var14].equals(var4[var7])) {
                     ++var14;
                     continue;
                  }

                  var13 = var3[var14];
               }

               if((var13 & 1) == 0) {
                  var12.append(var4[var7]);
               } else {
                  for(var14 = var4[var7].length() - 1; var14 >= 0; --var14) {
                     char var10 = var4[var7].charAt(var14);
                     if(var10 == 40) {
                        var10 = 41;
                     } else if(var10 == 41) {
                        var10 = 40;
                     }

                     var12.append(var10);
                  }
               }

               ++var7;
               break;
            }
         }

         return var12.toString();
      } else {
         return p_78283_1_;
      }
   }

   private void func_78265_b() {
      this.field_78303_s = false;
      this.field_78302_t = false;
      this.field_78301_u = false;
      this.field_78300_v = false;
      this.field_78299_w = false;
   }

   private void func_78255_a(String p_78255_1_, boolean p_78255_2_) {
      for(int var3 = 0; var3 < p_78255_1_.length(); ++var3) {
         char var4 = p_78255_1_.charAt(var3);
         int var5;
         int var6;
         if(var4 == 167 && var3 + 1 < p_78255_1_.length()) {
            var5 = "0123456789abcdefklmnor".indexOf(p_78255_1_.toLowerCase().charAt(var3 + 1));
            if(var5 < 16) {
               this.field_78303_s = false;
               this.field_78302_t = false;
               this.field_78299_w = false;
               this.field_78300_v = false;
               this.field_78301_u = false;
               if(var5 < 0 || var5 > 15) {
                  var5 = 15;
               }

               if(p_78255_2_) {
                  var5 += 16;
               }

               var6 = this.field_78285_g[var5];
               this.field_78304_r = var6;
               GL11.glColor4f((float)(var6 >> 16) / 255.0F, (float)(var6 >> 8 & 255) / 255.0F, (float)(var6 & 255) / 255.0F, this.field_78305_q);
            } else if(var5 == 16) {
               this.field_78303_s = true;
            } else if(var5 == 17) {
               this.field_78302_t = true;
            } else if(var5 == 18) {
               this.field_78299_w = true;
            } else if(var5 == 19) {
               this.field_78300_v = true;
            } else if(var5 == 20) {
               this.field_78301_u = true;
            } else if(var5 == 21) {
               this.field_78303_s = false;
               this.field_78302_t = false;
               this.field_78299_w = false;
               this.field_78300_v = false;
               this.field_78301_u = false;
               GL11.glColor4f(this.field_78291_n, this.field_78292_o, this.field_78306_p, this.field_78305_q);
            }

            ++var3;
         } else {
            var5 = ChatAllowedCharacters.field_71568_a.indexOf(var4);
            if(this.field_78303_s && var5 > 0) {
               do {
                  var6 = this.field_78289_c.nextInt(ChatAllowedCharacters.field_71568_a.length());
               } while(this.field_78286_d[var5 + 32] != this.field_78286_d[var6 + 32]);

               var5 = var6;
            }

            float var9 = this.func_78278_a(var5, var4, this.field_78301_u);
            if(this.field_78302_t) {
               ++this.field_78295_j;
               this.func_78278_a(var5, var4, this.field_78301_u);
               --this.field_78295_j;
               ++var9;
            }

            Tessellator var7;
            if(this.field_78299_w) {
               var7 = Tessellator.field_78398_a;
               GL11.glDisable(3553);
               var7.func_78382_b();
               var7.func_78377_a((double)this.field_78295_j, (double)(this.field_78296_k + (float)(this.field_78288_b / 2)), 0.0D);
               var7.func_78377_a((double)(this.field_78295_j + var9), (double)(this.field_78296_k + (float)(this.field_78288_b / 2)), 0.0D);
               var7.func_78377_a((double)(this.field_78295_j + var9), (double)(this.field_78296_k + (float)(this.field_78288_b / 2) - 1.0F), 0.0D);
               var7.func_78377_a((double)this.field_78295_j, (double)(this.field_78296_k + (float)(this.field_78288_b / 2) - 1.0F), 0.0D);
               var7.func_78381_a();
               GL11.glEnable(3553);
            }

            if(this.field_78300_v) {
               var7 = Tessellator.field_78398_a;
               GL11.glDisable(3553);
               var7.func_78382_b();
               int var8 = this.field_78300_v?-1:0;
               var7.func_78377_a((double)(this.field_78295_j + (float)var8), (double)(this.field_78296_k + (float)this.field_78288_b), 0.0D);
               var7.func_78377_a((double)(this.field_78295_j + var9), (double)(this.field_78296_k + (float)this.field_78288_b), 0.0D);
               var7.func_78377_a((double)(this.field_78295_j + var9), (double)(this.field_78296_k + (float)this.field_78288_b - 1.0F), 0.0D);
               var7.func_78377_a((double)(this.field_78295_j + (float)var8), (double)(this.field_78296_k + (float)this.field_78288_b - 1.0F), 0.0D);
               var7.func_78381_a();
               GL11.glEnable(3553);
            }

            this.field_78295_j += (float)((int)var9);
         }
      }

   }

   private int func_78274_b(String p_78274_1_, int p_78274_2_, int p_78274_3_, int p_78274_4_, int p_78274_5_, boolean p_78274_6_) {
      if(this.field_78294_m) {
         p_78274_1_ = this.func_78283_c(p_78274_1_);
         int var7 = this.func_78256_a(p_78274_1_);
         p_78274_2_ = p_78274_2_ + p_78274_4_ - var7;
      }

      return this.func_78258_a(p_78274_1_, p_78274_2_, p_78274_3_, p_78274_5_, p_78274_6_);
   }

   private int func_78258_a(String p_78258_1_, int p_78258_2_, int p_78258_3_, int p_78258_4_, boolean p_78258_5_) {
      if(p_78258_1_ != null) {
         this.field_78297_h = 0;
         if((p_78258_4_ & -67108864) == 0) {
            p_78258_4_ |= -16777216;
         }

         if(p_78258_5_) {
            p_78258_4_ = (p_78258_4_ & 16579836) >> 2 | p_78258_4_ & -16777216;
         }

         this.field_78291_n = (float)(p_78258_4_ >> 16 & 255) / 255.0F;
         this.field_78292_o = (float)(p_78258_4_ >> 8 & 255) / 255.0F;
         this.field_78306_p = (float)(p_78258_4_ & 255) / 255.0F;
         this.field_78305_q = (float)(p_78258_4_ >> 24 & 255) / 255.0F;
         GL11.glColor4f(this.field_78291_n, this.field_78292_o, this.field_78306_p, this.field_78305_q);
         this.field_78295_j = (float)p_78258_2_;
         this.field_78296_k = (float)p_78258_3_;
         this.func_78255_a(p_78258_1_, p_78258_5_);
         return (int)this.field_78295_j;
      } else {
         return 0;
      }
   }

   public int func_78256_a(String p_78256_1_) {
      if(p_78256_1_ == null) {
         return 0;
      } else {
         int var2 = 0;
         boolean var3 = false;

         for(int var4 = 0; var4 < p_78256_1_.length(); ++var4) {
            char var5 = p_78256_1_.charAt(var4);
            int var6 = this.func_78263_a(var5);
            if(var6 < 0 && var4 < p_78256_1_.length() - 1) {
               ++var4;
               var5 = p_78256_1_.charAt(var4);
               if(var5 != 108 && var5 != 76) {
                  if(var5 == 114 || var5 == 82) {
                     var3 = false;
                  }
               } else {
                  var3 = true;
               }

               var6 = this.func_78263_a(var5);
            }

            var2 += var6;
            if(var3) {
               ++var2;
            }
         }

         return var2;
      }
   }

   public int func_78263_a(char p_78263_1_) {
      if(p_78263_1_ == 167) {
         return -1;
      } else if(p_78263_1_ == 32) {
         return 4;
      } else {
         int var2 = ChatAllowedCharacters.field_71568_a.indexOf(p_78263_1_);
         if(var2 >= 0 && !this.field_78293_l) {
            return this.field_78286_d[var2 + 32];
         } else if(this.field_78287_e[p_78263_1_] != 0) {
            int var3 = this.field_78287_e[p_78263_1_] >>> 4;
            int var4 = this.field_78287_e[p_78263_1_] & 15;
            if(var4 > 7) {
               var4 = 15;
               var3 = 0;
            }

            ++var4;
            return (var4 - var3) / 2 + 1;
         } else {
            return 0;
         }
      }
   }

   public String func_78269_a(String p_78269_1_, int p_78269_2_) {
      return this.func_78262_a(p_78269_1_, p_78269_2_, false);
   }

   public String func_78262_a(String p_78262_1_, int p_78262_2_, boolean p_78262_3_) {
      StringBuilder var4 = new StringBuilder();
      int var5 = 0;
      int var6 = p_78262_3_?p_78262_1_.length() - 1:0;
      int var7 = p_78262_3_?-1:1;
      boolean var8 = false;
      boolean var9 = false;

      for(int var10 = var6; var10 >= 0 && var10 < p_78262_1_.length() && var5 < p_78262_2_; var10 += var7) {
         char var11 = p_78262_1_.charAt(var10);
         int var12 = this.func_78263_a(var11);
         if(var8) {
            var8 = false;
            if(var11 != 108 && var11 != 76) {
               if(var11 == 114 || var11 == 82) {
                  var9 = false;
               }
            } else {
               var9 = true;
            }
         } else if(var12 < 0) {
            var8 = true;
         } else {
            var5 += var12;
            if(var9) {
               ++var5;
            }
         }

         if(var5 > p_78262_2_) {
            break;
         }

         if(p_78262_3_) {
            var4.insert(0, var11);
         } else {
            var4.append(var11);
         }
      }

      return var4.toString();
   }

   private String func_78273_d(String p_78273_1_) {
      while(p_78273_1_ != null && p_78273_1_.endsWith("\n")) {
         p_78273_1_ = p_78273_1_.substring(0, p_78273_1_.length() - 1);
      }

      return p_78273_1_;
   }

   public void func_78279_b(String p_78279_1_, int p_78279_2_, int p_78279_3_, int p_78279_4_, int p_78279_5_) {
      this.func_78265_b();
      this.field_78304_r = p_78279_5_;
      p_78279_1_ = this.func_78273_d(p_78279_1_);
      this.func_78281_c(p_78279_1_, p_78279_2_, p_78279_3_, p_78279_4_, p_78279_5_);
   }

   private void func_78281_c(String p_78281_1_, int p_78281_2_, int p_78281_3_, int p_78281_4_, int p_78281_5_) {
      this.field_78304_r = p_78281_5_;
      this.func_78268_b(p_78281_1_, p_78281_2_, p_78281_3_, p_78281_4_, false);
   }

   private void func_78268_b(String p_78268_1_, int p_78268_2_, int p_78268_3_, int p_78268_4_, boolean p_78268_5_) {
      String[] var6 = p_78268_1_.split("\n");
      if(var6.length > 1) {
         boolean var12 = false;
         String[] var13 = var6;
         int var14 = var6.length;

         for(int var15 = 0; var15 < var14; ++var15) {
            String var16 = var13[var15];
            if(var12) {
               var16 = "\u00a7" + var16;
               var12 = false;
            }

            if(var16.endsWith("\u00a7")) {
               var12 = true;
               var16 = var16.substring(0, var16.length() - 1);
            }

            this.func_78268_b(var16, p_78268_2_, p_78268_3_, p_78268_4_, p_78268_5_);
            p_78268_3_ += this.func_78267_b(var16, p_78268_4_);
         }

      } else {
         String[] var7 = p_78268_1_.split(" ");
         int var8 = 0;

         String var9;
         for(var9 = ""; var8 < var7.length; ++var8) {
            String var10 = var7[var8];
            if(this.func_78256_a(var10) >= p_78268_4_) {
               if(var9.length() > 0) {
                  this.func_78274_b(var9, p_78268_2_, p_78268_3_, p_78268_4_, this.field_78304_r, p_78268_5_);
                  p_78268_3_ += this.field_78288_b;
               }

               do {
                  int var11;
                  for(var11 = 1; this.func_78256_a(var10.substring(0, var11)) < p_78268_4_; ++var11) {
                     ;
                  }

                  this.func_78274_b(var10.substring(0, var11 - 1), p_78268_2_, p_78268_3_, p_78268_4_, this.field_78304_r, p_78268_5_);
                  p_78268_3_ += this.field_78288_b;
                  var10 = var10.substring(var11 - 1);
               } while(this.func_78256_a(var10) >= p_78268_4_);

               var9 = var10;
            } else if(this.func_78256_a(var9 + " " + var10) >= p_78268_4_) {
               this.func_78274_b(var9, p_78268_2_, p_78268_3_, p_78268_4_, this.field_78304_r, p_78268_5_);
               p_78268_3_ += this.field_78288_b;
               var9 = var10;
            } else {
               if(var9.length() > 0) {
                  var9 = var9 + " ";
               }

               var9 = var9 + var10;
            }
         }

         this.func_78274_b(var9, p_78268_2_, p_78268_3_, p_78268_4_, this.field_78304_r, p_78268_5_);
      }
   }

   public int func_78267_b(String p_78267_1_, int p_78267_2_) {
      String[] var3 = p_78267_1_.split("\n");
      int var6;
      String var8;
      if(var3.length > 1) {
         int var10 = 0;
         String[] var11 = var3;
         var6 = var3.length;

         for(int var12 = 0; var12 < var6; ++var12) {
            var8 = var11[var12];
            var10 += this.func_78267_b(var8, p_78267_2_);
         }

         return var10;
      } else {
         String[] var4 = p_78267_1_.split(" ");
         int var5 = 0;
         var6 = 0;

         String var7;
         for(var7 = ""; var6 < var4.length; ++var6) {
            var8 = var4[var6];
            if(this.func_78256_a(var8) >= p_78267_2_) {
               if(var7.length() > 0) {
                  var5 += this.field_78288_b;
               }

               do {
                  int var9;
                  for(var9 = 1; this.func_78256_a(var8.substring(0, var9)) < p_78267_2_; ++var9) {
                     ;
                  }

                  var5 += this.field_78288_b;
                  var8 = var8.substring(var9 - 1);
               } while(this.func_78256_a(var8) >= p_78267_2_);

               var7 = var8;
            } else if(this.func_78256_a(var7 + " " + var8) >= p_78267_2_) {
               var5 += this.field_78288_b;
               var7 = var8;
            } else {
               if(var7.length() > 0) {
                  var7 = var7 + " ";
               }

               var7 = var7 + var8;
            }
         }

         if(var7.length() > 0) {
            var5 += this.field_78288_b;
         }

         return var5;
      }
   }

   public void func_78264_a(boolean p_78264_1_) {
      this.field_78293_l = p_78264_1_;
   }

   public void func_78275_b(boolean p_78275_1_) {
      this.field_78294_m = p_78275_1_;
   }

   public List func_78271_c(String p_78271_1_, int p_78271_2_) {
      return Arrays.asList(this.func_78280_d(p_78271_1_, p_78271_2_).split("\n"));
   }

   String func_78280_d(String p_78280_1_, int p_78280_2_) {
      int var3 = this.func_78259_e(p_78280_1_, p_78280_2_);
      if(p_78280_1_.length() <= var3) {
         return p_78280_1_;
      } else {
         String var4 = p_78280_1_.substring(0, var3);
         String var5 = func_78282_e(var4) + p_78280_1_.substring(var3 + (p_78280_1_.charAt(var3) == 32?1:0));
         return var4 + "\n" + this.func_78280_d(var5, p_78280_2_);
      }
   }

   private int func_78259_e(String p_78259_1_, int p_78259_2_) {
      int var3 = p_78259_1_.length();
      int var4 = 0;
      int var5 = 0;
      int var6 = -1;

      for(boolean var7 = false; var5 < var3; ++var5) {
         char var8 = p_78259_1_.charAt(var5);
         switch(var8) {
         case 32:
            var6 = var5;
         case 167:
            if(var5 < var3 - 1) {
               ++var5;
               char var9 = p_78259_1_.charAt(var5);
               if(var9 != 108 && var9 != 76) {
                  if(var9 == 114 || var9 == 82) {
                     var7 = false;
                  }
               } else {
                  var7 = true;
               }
            }
            break;
         default:
            var4 += this.func_78263_a(var8);
            if(var7) {
               ++var4;
            }
         }

         if(var8 == 10) {
            ++var5;
            var6 = var5;
            break;
         }

         if(var4 > p_78259_2_) {
            break;
         }
      }

      return var5 != var3 && var6 != -1 && var6 < var5?var6:var5;
   }

   private static boolean func_78272_b(char p_78272_0_) {
      return p_78272_0_ >= 48 && p_78272_0_ <= 57 || p_78272_0_ >= 97 && p_78272_0_ <= 102 || p_78272_0_ >= 65 && p_78272_0_ <= 70;
   }

   private static boolean func_78270_c(char p_78270_0_) {
      return p_78270_0_ >= 107 && p_78270_0_ <= 111 || p_78270_0_ >= 75 && p_78270_0_ <= 79 || p_78270_0_ == 114 || p_78270_0_ == 82;
   }

   private static String func_78282_e(String p_78282_0_) {
      String var1 = "";
      int var2 = -1;
      int var3 = p_78282_0_.length();

      while((var2 = p_78282_0_.indexOf(167, var2 + 1)) != -1) {
         if(var2 < var3 - 1) {
            char var4 = p_78282_0_.charAt(var2 + 1);
            if(func_78272_b(var4)) {
               var1 = "\u00a7" + var4;
            } else if(func_78270_c(var4)) {
               var1 = var1 + "\u00a7" + var4;
            }
         }
      }

      return var1;
   }

   public boolean func_78260_a() {
      return this.field_78294_m;
   }
}
