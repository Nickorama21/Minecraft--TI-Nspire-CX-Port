package net.minecraft.src;

import net.minecraft.client.Minecraft;
import net.minecraft.src.Block;
import net.minecraft.src.BlockBed;
import net.minecraft.src.BlockBrewingStand;
import net.minecraft.src.BlockCauldron;
import net.minecraft.src.BlockCocoa;
import net.minecraft.src.BlockDirectional;
import net.minecraft.src.BlockDoor;
import net.minecraft.src.BlockDragonEgg;
import net.minecraft.src.BlockEndPortalFrame;
import net.minecraft.src.BlockFence;
import net.minecraft.src.BlockFenceGate;
import net.minecraft.src.BlockFluid;
import net.minecraft.src.BlockPane;
import net.minecraft.src.BlockPistonBase;
import net.minecraft.src.BlockPistonExtension;
import net.minecraft.src.BlockRail;
import net.minecraft.src.BlockRedstoneRepeater;
import net.minecraft.src.BlockRedstoneWire;
import net.minecraft.src.BlockStem;
import net.minecraft.src.BlockTripWire;
import net.minecraft.src.ChestItemRenderHelper;
import net.minecraft.src.Direction;
import net.minecraft.src.EntityRenderer;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.Material;
import net.minecraft.src.MathHelper;
import net.minecraft.src.Tessellator;
import net.minecraft.src.Vec3;
import net.minecraft.src.World;
import org.lwjgl.opengl.GL11;

public class RenderBlocks {

   public IBlockAccess field_78669_a;
   private int field_78664_d = -1;
   private boolean field_78666_e = false;
   private boolean field_78661_f = false;
   public static boolean field_78667_b = true;
   public boolean field_78668_c = true;
   private int field_78662_g = 0;
   private int field_78683_h = 0;
   private int field_78685_i = 0;
   private int field_78679_j = 0;
   private int field_78681_k = 0;
   private int field_78675_l = 0;
   private boolean field_78677_m;
   private float field_78671_n;
   private float field_78673_o;
   private float field_78701_p;
   private float field_78699_q;
   private float field_78697_r;
   private float field_78695_s;
   private float field_78693_t;
   private float field_78691_u;
   private float field_78689_v;
   private float field_78687_w;
   private float field_78712_x;
   private float field_78710_y;
   private float field_78708_z;
   private float field_78628_A;
   private float field_78629_B;
   private float field_78630_C;
   private float field_78624_D;
   private float field_78625_E;
   private float field_78626_F;
   private float field_78627_G;
   private float field_78634_H;
   private float field_78635_I;
   private float field_78636_J;
   private float field_78637_K;
   private float field_78631_L;
   private float field_78632_M;
   private float field_78633_N;
   private int field_78649_S;
   private int field_78641_T;
   private int field_78639_U;
   private int field_78645_V;
   private int field_78643_W;
   private int field_78657_X;
   private int field_78655_Y;
   private int field_78660_Z;
   private int field_78704_aa;
   private int field_78705_ab;
   private int field_78702_ac;
   private int field_78703_ad;
   private int field_78709_ae;
   private int field_78711_af;
   private int field_78706_ag;
   private int field_78707_ah;
   private int field_78690_ai;
   private int field_78692_aj;
   private int field_78686_ak;
   private int field_78688_al;
   private int field_78698_am = 1;
   private int field_78700_an;
   private int field_78694_ao;
   private int field_78696_ap;
   private int field_78676_aq;
   private float field_78674_ar;
   private float field_78672_as;
   private float field_78670_at;
   private float field_78684_au;
   private float field_78682_av;
   private float field_78680_aw;
   private float field_78678_ax;
   private float field_78665_ay;
   private float field_78663_az;
   private float field_78650_aA;
   private float field_78651_aB;
   private float field_78652_aC;
   private boolean field_78653_aD;
   private boolean field_78654_aE;
   private boolean field_78656_aF;
   private boolean field_78658_aG;
   private boolean field_78659_aH;
   private boolean field_78638_aI;
   private boolean field_78640_aJ;
   private boolean field_78642_aK;
   private boolean field_78644_aL;
   private boolean field_78646_aM;
   private boolean field_78647_aN;
   private boolean field_78648_aO;


   public RenderBlocks(IBlockAccess p_i3187_1_) {
      this.field_78669_a = p_i3187_1_;
   }

   public RenderBlocks() {}

   public void func_78595_a() {
      this.field_78664_d = -1;
   }

   public void func_78604_a(Block p_78604_1_, int p_78604_2_, int p_78604_3_, int p_78604_4_, int p_78604_5_) {
      this.field_78664_d = p_78604_5_;
      this.func_78612_b(p_78604_1_, p_78604_2_, p_78604_3_, p_78604_4_);
      this.field_78664_d = -1;
   }

   public void func_78583_a(Block p_78583_1_, int p_78583_2_, int p_78583_3_, int p_78583_4_) {
      this.field_78661_f = true;
      this.func_78612_b(p_78583_1_, p_78583_2_, p_78583_3_, p_78583_4_);
      this.field_78661_f = false;
   }

   public boolean func_78612_b(Block p_78612_1_, int p_78612_2_, int p_78612_3_, int p_78612_4_) {
      int var5 = p_78612_1_.func_71857_b();
      p_78612_1_.func_71902_a(this.field_78669_a, p_78612_2_, p_78612_3_, p_78612_4_);
      return var5 == 0?this.func_78570_q(p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_):(var5 == 31?this.func_78581_r(p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_):(var5 == 4?this.func_78621_p(p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_):(var5 == 13?this.func_78584_s(p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_):(var5 == 1?this.func_78620_l(p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_):(var5 == 19?this.func_78603_m(p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_):(var5 == 23?this.func_78566_o(p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_):(var5 == 6?this.func_78614_n(p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_):(var5 == 2?this.func_78572_c(p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_):(var5 == 3?this.func_78590_h(p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_):(var5 == 5?this.func_78589_i(p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_):(var5 == 8?this.func_78576_j(p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_):(var5 == 7?this.func_78601_u(p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_):(var5 == 9?this.func_78586_a((BlockRail)p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_):(var5 == 10?this.func_78565_t(p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_):(var5 == 27?this.func_78618_a((BlockDragonEgg)p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_):(var5 == 11?this.func_78582_a((BlockFence)p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_):(var5 == 12?this.func_78594_e(p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_):(var5 == 29?this.func_78577_f(p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_):(var5 == 30?this.func_78619_g(p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_):(var5 == 14?this.func_78574_w(p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_):(var5 == 15?this.func_78610_x(p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_):(var5 == 16?this.func_78593_b(p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_, false):(var5 == 17?this.func_78608_c(p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_, true):(var5 == 18?this.func_78592_a((BlockPane)p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_):(var5 == 20?this.func_78598_k(p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_):(var5 == 21?this.func_78580_a((BlockFenceGate)p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_):(var5 == 24?this.func_78615_a((BlockCauldron)p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_):(var5 == 25?this.func_78585_a((BlockBrewingStand)p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_):(var5 == 26?this.func_78567_v(p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_):(var5 == 28?this.func_78616_a((BlockCocoa)p_78612_1_, p_78612_2_, p_78612_3_, p_78612_4_):false))))))))))))))))))))))))))))));
   }

   private boolean func_78567_v(Block p_78567_1_, int p_78567_2_, int p_78567_3_, int p_78567_4_) {
      int var5 = this.field_78669_a.func_72805_g(p_78567_2_, p_78567_3_, p_78567_4_);
      int var6 = var5 & 3;
      if(var6 == 0) {
         this.field_78681_k = 3;
      } else if(var6 == 3) {
         this.field_78681_k = 1;
      } else if(var6 == 1) {
         this.field_78681_k = 2;
      }

      if(!BlockEndPortalFrame.func_72165_e(var5)) {
         p_78567_1_.func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 0.8125F, 1.0F);
         this.func_78570_q(p_78567_1_, p_78567_2_, p_78567_3_, p_78567_4_);
         p_78567_1_.func_71919_f();
         this.field_78681_k = 0;
         return true;
      } else {
         p_78567_1_.func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 0.8125F, 1.0F);
         this.func_78570_q(p_78567_1_, p_78567_2_, p_78567_3_, p_78567_4_);
         this.field_78664_d = 174;
         p_78567_1_.func_71905_a(0.25F, 0.8125F, 0.25F, 0.75F, 1.0F, 0.75F);
         this.func_78570_q(p_78567_1_, p_78567_2_, p_78567_3_, p_78567_4_);
         this.func_78595_a();
         p_78567_1_.func_71919_f();
         this.field_78681_k = 0;
         return true;
      }
   }

   private boolean func_78574_w(Block p_78574_1_, int p_78574_2_, int p_78574_3_, int p_78574_4_) {
      Tessellator var5 = Tessellator.field_78398_a;
      int var6 = this.field_78669_a.func_72805_g(p_78574_2_, p_78574_3_, p_78574_4_);
      int var7 = BlockBed.func_72217_d(var6);
      boolean var8 = BlockBed.func_72229_a_(var6);
      float var9 = 0.5F;
      float var10 = 1.0F;
      float var11 = 0.8F;
      float var12 = 0.6F;
      int var25 = p_78574_1_.func_71874_e(this.field_78669_a, p_78574_2_, p_78574_3_, p_78574_4_);
      var5.func_78380_c(var25);
      var5.func_78386_a(var9, var9, var9);
      int var27 = p_78574_1_.func_71895_b(this.field_78669_a, p_78574_2_, p_78574_3_, p_78574_4_, 0);
      int var28 = (var27 & 15) << 4;
      int var29 = var27 & 240;
      double var30 = (double)((float)var28 / 256.0F);
      double var32 = ((double)(var28 + 16) - 0.01D) / 256.0D;
      double var34 = (double)((float)var29 / 256.0F);
      double var36 = ((double)(var29 + 16) - 0.01D) / 256.0D;
      double var38 = (double)p_78574_2_ + p_78574_1_.field_72026_ch;
      double var40 = (double)p_78574_2_ + p_78574_1_.field_72021_ck;
      double var42 = (double)p_78574_3_ + p_78574_1_.field_72023_ci + 0.1875D;
      double var44 = (double)p_78574_4_ + p_78574_1_.field_72024_cj;
      double var46 = (double)p_78574_4_ + p_78574_1_.field_72019_cm;
      var5.func_78374_a(var38, var42, var46, var30, var36);
      var5.func_78374_a(var38, var42, var44, var30, var34);
      var5.func_78374_a(var40, var42, var44, var32, var34);
      var5.func_78374_a(var40, var42, var46, var32, var36);
      var5.func_78380_c(p_78574_1_.func_71874_e(this.field_78669_a, p_78574_2_, p_78574_3_ + 1, p_78574_4_));
      var5.func_78386_a(var10, var10, var10);
      var27 = p_78574_1_.func_71895_b(this.field_78669_a, p_78574_2_, p_78574_3_, p_78574_4_, 1);
      var28 = (var27 & 15) << 4;
      var29 = var27 & 240;
      var30 = (double)((float)var28 / 256.0F);
      var32 = ((double)(var28 + 16) - 0.01D) / 256.0D;
      var34 = (double)((float)var29 / 256.0F);
      var36 = ((double)(var29 + 16) - 0.01D) / 256.0D;
      var38 = var30;
      var40 = var32;
      var42 = var34;
      var44 = var34;
      var46 = var30;
      double var48 = var32;
      double var50 = var36;
      double var52 = var36;
      if(var7 == 0) {
         var40 = var30;
         var42 = var36;
         var46 = var32;
         var52 = var34;
      } else if(var7 == 2) {
         var38 = var32;
         var44 = var36;
         var48 = var30;
         var50 = var34;
      } else if(var7 == 3) {
         var38 = var32;
         var44 = var36;
         var48 = var30;
         var50 = var34;
         var40 = var30;
         var42 = var36;
         var46 = var32;
         var52 = var34;
      }

      double var54 = (double)p_78574_2_ + p_78574_1_.field_72026_ch;
      double var56 = (double)p_78574_2_ + p_78574_1_.field_72021_ck;
      double var58 = (double)p_78574_3_ + p_78574_1_.field_72022_cl;
      double var60 = (double)p_78574_4_ + p_78574_1_.field_72024_cj;
      double var62 = (double)p_78574_4_ + p_78574_1_.field_72019_cm;
      var5.func_78374_a(var56, var58, var62, var46, var50);
      var5.func_78374_a(var56, var58, var60, var38, var42);
      var5.func_78374_a(var54, var58, var60, var40, var44);
      var5.func_78374_a(var54, var58, var62, var48, var52);
      int var64 = Direction.field_71582_c[var7];
      if(var8) {
         var64 = Direction.field_71582_c[Direction.field_71580_e[var7]];
      }

      byte var65 = 4;
      switch(var7) {
      case 0:
         var65 = 5;
         break;
      case 1:
         var65 = 3;
      case 2:
      default:
         break;
      case 3:
         var65 = 2;
      }

      if(var64 != 2 && (this.field_78661_f || p_78574_1_.func_71877_c(this.field_78669_a, p_78574_2_, p_78574_3_, p_78574_4_ - 1, 2))) {
         var5.func_78380_c(p_78574_1_.field_72024_cj > 0.0D?var25:p_78574_1_.func_71874_e(this.field_78669_a, p_78574_2_, p_78574_3_, p_78574_4_ - 1));
         var5.func_78386_a(var11, var11, var11);
         this.field_78666_e = var65 == 2;
         this.func_78611_c(p_78574_1_, (double)p_78574_2_, (double)p_78574_3_, (double)p_78574_4_, p_78574_1_.func_71895_b(this.field_78669_a, p_78574_2_, p_78574_3_, p_78574_4_, 2));
      }

      if(var64 != 3 && (this.field_78661_f || p_78574_1_.func_71877_c(this.field_78669_a, p_78574_2_, p_78574_3_, p_78574_4_ + 1, 3))) {
         var5.func_78380_c(p_78574_1_.field_72019_cm < 1.0D?var25:p_78574_1_.func_71874_e(this.field_78669_a, p_78574_2_, p_78574_3_, p_78574_4_ + 1));
         var5.func_78386_a(var11, var11, var11);
         this.field_78666_e = var65 == 3;
         this.func_78622_d(p_78574_1_, (double)p_78574_2_, (double)p_78574_3_, (double)p_78574_4_, p_78574_1_.func_71895_b(this.field_78669_a, p_78574_2_, p_78574_3_, p_78574_4_, 3));
      }

      if(var64 != 4 && (this.field_78661_f || p_78574_1_.func_71877_c(this.field_78669_a, p_78574_2_ - 1, p_78574_3_, p_78574_4_, 4))) {
         var5.func_78380_c(p_78574_1_.field_72024_cj > 0.0D?var25:p_78574_1_.func_71874_e(this.field_78669_a, p_78574_2_ - 1, p_78574_3_, p_78574_4_));
         var5.func_78386_a(var12, var12, var12);
         this.field_78666_e = var65 == 4;
         this.func_78573_e(p_78574_1_, (double)p_78574_2_, (double)p_78574_3_, (double)p_78574_4_, p_78574_1_.func_71895_b(this.field_78669_a, p_78574_2_, p_78574_3_, p_78574_4_, 4));
      }

      if(var64 != 5 && (this.field_78661_f || p_78574_1_.func_71877_c(this.field_78669_a, p_78574_2_ + 1, p_78574_3_, p_78574_4_, 5))) {
         var5.func_78380_c(p_78574_1_.field_72019_cm < 1.0D?var25:p_78574_1_.func_71874_e(this.field_78669_a, p_78574_2_ + 1, p_78574_3_, p_78574_4_));
         var5.func_78386_a(var12, var12, var12);
         this.field_78666_e = var65 == 5;
         this.func_78605_f(p_78574_1_, (double)p_78574_2_, (double)p_78574_3_, (double)p_78574_4_, p_78574_1_.func_71895_b(this.field_78669_a, p_78574_2_, p_78574_3_, p_78574_4_, 5));
      }

      this.field_78666_e = false;
      return true;
   }

   private boolean func_78585_a(BlockBrewingStand p_78585_1_, int p_78585_2_, int p_78585_3_, int p_78585_4_) {
      p_78585_1_.func_71905_a(0.4375F, 0.0F, 0.4375F, 0.5625F, 0.875F, 0.5625F);
      this.func_78570_q(p_78585_1_, p_78585_2_, p_78585_3_, p_78585_4_);
      this.field_78664_d = 156;
      p_78585_1_.func_71905_a(0.5625F, 0.0F, 0.3125F, 0.9375F, 0.125F, 0.6875F);
      this.func_78570_q(p_78585_1_, p_78585_2_, p_78585_3_, p_78585_4_);
      p_78585_1_.func_71905_a(0.125F, 0.0F, 0.0625F, 0.5F, 0.125F, 0.4375F);
      this.func_78570_q(p_78585_1_, p_78585_2_, p_78585_3_, p_78585_4_);
      p_78585_1_.func_71905_a(0.125F, 0.0F, 0.5625F, 0.5F, 0.125F, 0.9375F);
      this.func_78570_q(p_78585_1_, p_78585_2_, p_78585_3_, p_78585_4_);
      this.func_78595_a();
      Tessellator var5 = Tessellator.field_78398_a;
      var5.func_78380_c(p_78585_1_.func_71874_e(this.field_78669_a, p_78585_2_, p_78585_3_, p_78585_4_));
      float var6 = 1.0F;
      int var7 = p_78585_1_.func_71920_b(this.field_78669_a, p_78585_2_, p_78585_3_, p_78585_4_);
      float var8 = (float)(var7 >> 16 & 255) / 255.0F;
      float var9 = (float)(var7 >> 8 & 255) / 255.0F;
      float var10 = (float)(var7 & 255) / 255.0F;
      if(EntityRenderer.field_78517_a) {
         float var11 = (var8 * 30.0F + var9 * 59.0F + var10 * 11.0F) / 100.0F;
         float var12 = (var8 * 30.0F + var9 * 70.0F) / 100.0F;
         float var13 = (var8 * 30.0F + var10 * 70.0F) / 100.0F;
         var8 = var11;
         var9 = var12;
         var10 = var13;
      }

      var5.func_78386_a(var6 * var8, var6 * var9, var6 * var10);
      int var34 = p_78585_1_.func_71858_a(0, 0);
      if(this.field_78664_d >= 0) {
         var34 = this.field_78664_d;
      }

      int var35 = (var34 & 15) << 4;
      int var36 = var34 & 240;
      double var14 = (double)((float)var36 / 256.0F);
      double var16 = (double)(((float)var36 + 15.99F) / 256.0F);
      int var18 = this.field_78669_a.func_72805_g(p_78585_2_, p_78585_3_, p_78585_4_);

      for(int var19 = 0; var19 < 3; ++var19) {
         double var20 = (double)var19 * 3.141592653589793D * 2.0D / 3.0D + 1.5707963267948966D;
         double var22 = (double)(((float)var35 + 8.0F) / 256.0F);
         double var24 = (double)(((float)var35 + 15.99F) / 256.0F);
         if((var18 & 1 << var19) != 0) {
            var22 = (double)(((float)var35 + 7.99F) / 256.0F);
            var24 = (double)(((float)var35 + 0.0F) / 256.0F);
         }

         double var26 = (double)p_78585_2_ + 0.5D;
         double var28 = (double)p_78585_2_ + 0.5D + Math.sin(var20) * 8.0D / 16.0D;
         double var30 = (double)p_78585_4_ + 0.5D;
         double var32 = (double)p_78585_4_ + 0.5D + Math.cos(var20) * 8.0D / 16.0D;
         var5.func_78374_a(var26, (double)(p_78585_3_ + 1), var30, var22, var14);
         var5.func_78374_a(var26, (double)(p_78585_3_ + 0), var30, var22, var16);
         var5.func_78374_a(var28, (double)(p_78585_3_ + 0), var32, var24, var16);
         var5.func_78374_a(var28, (double)(p_78585_3_ + 1), var32, var24, var14);
         var5.func_78374_a(var28, (double)(p_78585_3_ + 1), var32, var24, var14);
         var5.func_78374_a(var28, (double)(p_78585_3_ + 0), var32, var24, var16);
         var5.func_78374_a(var26, (double)(p_78585_3_ + 0), var30, var22, var16);
         var5.func_78374_a(var26, (double)(p_78585_3_ + 1), var30, var22, var14);
      }

      p_78585_1_.func_71919_f();
      return true;
   }

   private boolean func_78615_a(BlockCauldron p_78615_1_, int p_78615_2_, int p_78615_3_, int p_78615_4_) {
      this.func_78570_q(p_78615_1_, p_78615_2_, p_78615_3_, p_78615_4_);
      Tessellator var5 = Tessellator.field_78398_a;
      var5.func_78380_c(p_78615_1_.func_71874_e(this.field_78669_a, p_78615_2_, p_78615_3_, p_78615_4_));
      float var6 = 1.0F;
      int var7 = p_78615_1_.func_71920_b(this.field_78669_a, p_78615_2_, p_78615_3_, p_78615_4_);
      float var8 = (float)(var7 >> 16 & 255) / 255.0F;
      float var9 = (float)(var7 >> 8 & 255) / 255.0F;
      float var10 = (float)(var7 & 255) / 255.0F;
      float var12;
      if(EntityRenderer.field_78517_a) {
         float var11 = (var8 * 30.0F + var9 * 59.0F + var10 * 11.0F) / 100.0F;
         var12 = (var8 * 30.0F + var9 * 70.0F) / 100.0F;
         float var13 = (var8 * 30.0F + var10 * 70.0F) / 100.0F;
         var8 = var11;
         var9 = var12;
         var10 = var13;
      }

      var5.func_78386_a(var6 * var8, var6 * var9, var6 * var10);
      short var16 = 154;
      var12 = 0.125F;
      this.func_78605_f(p_78615_1_, (double)((float)p_78615_2_ - 1.0F + var12), (double)p_78615_3_, (double)p_78615_4_, var16);
      this.func_78573_e(p_78615_1_, (double)((float)p_78615_2_ + 1.0F - var12), (double)p_78615_3_, (double)p_78615_4_, var16);
      this.func_78622_d(p_78615_1_, (double)p_78615_2_, (double)p_78615_3_, (double)((float)p_78615_4_ - 1.0F + var12), var16);
      this.func_78611_c(p_78615_1_, (double)p_78615_2_, (double)p_78615_3_, (double)((float)p_78615_4_ + 1.0F - var12), var16);
      short var17 = 139;
      this.func_78617_b(p_78615_1_, (double)p_78615_2_, (double)((float)p_78615_3_ - 1.0F + 0.25F), (double)p_78615_4_, var17);
      this.func_78613_a(p_78615_1_, (double)p_78615_2_, (double)((float)p_78615_3_ + 1.0F - 0.75F), (double)p_78615_4_, var17);
      int var14 = this.field_78669_a.func_72805_g(p_78615_2_, p_78615_3_, p_78615_4_);
      if(var14 > 0) {
         short var15 = 205;
         if(var14 > 3) {
            var14 = 3;
         }

         this.func_78617_b(p_78615_1_, (double)p_78615_2_, (double)((float)p_78615_3_ - 1.0F + (6.0F + (float)var14 * 3.0F) / 16.0F), (double)p_78615_4_, var15);
      }

      return true;
   }

   public boolean func_78572_c(Block p_78572_1_, int p_78572_2_, int p_78572_3_, int p_78572_4_) {
      int var5 = this.field_78669_a.func_72805_g(p_78572_2_, p_78572_3_, p_78572_4_);
      Tessellator var6 = Tessellator.field_78398_a;
      var6.func_78380_c(p_78572_1_.func_71874_e(this.field_78669_a, p_78572_2_, p_78572_3_, p_78572_4_));
      var6.func_78386_a(1.0F, 1.0F, 1.0F);
      double var7 = 0.4000000059604645D;
      double var9 = 0.5D - var7;
      double var11 = 0.20000000298023224D;
      if(var5 == 1) {
         this.func_78623_a(p_78572_1_, (double)p_78572_2_ - var9, (double)p_78572_3_ + var11, (double)p_78572_4_, -var7, 0.0D);
      } else if(var5 == 2) {
         this.func_78623_a(p_78572_1_, (double)p_78572_2_ + var9, (double)p_78572_3_ + var11, (double)p_78572_4_, var7, 0.0D);
      } else if(var5 == 3) {
         this.func_78623_a(p_78572_1_, (double)p_78572_2_, (double)p_78572_3_ + var11, (double)p_78572_4_ - var9, 0.0D, -var7);
      } else if(var5 == 4) {
         this.func_78623_a(p_78572_1_, (double)p_78572_2_, (double)p_78572_3_ + var11, (double)p_78572_4_ + var9, 0.0D, var7);
      } else {
         this.func_78623_a(p_78572_1_, (double)p_78572_2_, (double)p_78572_3_, (double)p_78572_4_, 0.0D, 0.0D);
      }

      return true;
   }

   private boolean func_78610_x(Block p_78610_1_, int p_78610_2_, int p_78610_3_, int p_78610_4_) {
      int var5 = this.field_78669_a.func_72805_g(p_78610_2_, p_78610_3_, p_78610_4_);
      int var6 = var5 & 3;
      int var7 = (var5 & 12) >> 2;
      this.func_78570_q(p_78610_1_, p_78610_2_, p_78610_3_, p_78610_4_);
      Tessellator var8 = Tessellator.field_78398_a;
      var8.func_78380_c(p_78610_1_.func_71874_e(this.field_78669_a, p_78610_2_, p_78610_3_, p_78610_4_));
      var8.func_78386_a(1.0F, 1.0F, 1.0F);
      double var9 = -0.1875D;
      double var11 = 0.0D;
      double var13 = 0.0D;
      double var15 = 0.0D;
      double var17 = 0.0D;
      switch(var6) {
      case 0:
         var17 = -0.3125D;
         var13 = BlockRedstoneRepeater.field_72223_a[var7];
         break;
      case 1:
         var15 = 0.3125D;
         var11 = -BlockRedstoneRepeater.field_72223_a[var7];
         break;
      case 2:
         var17 = 0.3125D;
         var13 = -BlockRedstoneRepeater.field_72223_a[var7];
         break;
      case 3:
         var15 = -0.3125D;
         var11 = BlockRedstoneRepeater.field_72223_a[var7];
      }

      this.func_78623_a(p_78610_1_, (double)p_78610_2_ + var11, (double)p_78610_3_ + var9, (double)p_78610_4_ + var13, 0.0D, 0.0D);
      this.func_78623_a(p_78610_1_, (double)p_78610_2_ + var15, (double)p_78610_3_ + var9, (double)p_78610_4_ + var17, 0.0D, 0.0D);
      int var19 = p_78610_1_.func_71851_a(1);
      int var20 = (var19 & 15) << 4;
      int var21 = var19 & 240;
      double var22 = (double)((float)var20 / 256.0F);
      double var24 = (double)(((float)var20 + 15.99F) / 256.0F);
      double var26 = (double)((float)var21 / 256.0F);
      double var28 = (double)(((float)var21 + 15.99F) / 256.0F);
      double var30 = 0.125D;
      double var32 = (double)(p_78610_2_ + 1);
      double var34 = (double)(p_78610_2_ + 1);
      double var36 = (double)(p_78610_2_ + 0);
      double var38 = (double)(p_78610_2_ + 0);
      double var40 = (double)(p_78610_4_ + 0);
      double var42 = (double)(p_78610_4_ + 1);
      double var44 = (double)(p_78610_4_ + 1);
      double var46 = (double)(p_78610_4_ + 0);
      double var48 = (double)p_78610_3_ + var30;
      if(var6 == 2) {
         var32 = var34 = (double)(p_78610_2_ + 0);
         var36 = var38 = (double)(p_78610_2_ + 1);
         var40 = var46 = (double)(p_78610_4_ + 1);
         var42 = var44 = (double)(p_78610_4_ + 0);
      } else if(var6 == 3) {
         var32 = var38 = (double)(p_78610_2_ + 0);
         var34 = var36 = (double)(p_78610_2_ + 1);
         var40 = var42 = (double)(p_78610_4_ + 0);
         var44 = var46 = (double)(p_78610_4_ + 1);
      } else if(var6 == 1) {
         var32 = var38 = (double)(p_78610_2_ + 1);
         var34 = var36 = (double)(p_78610_2_ + 0);
         var40 = var42 = (double)(p_78610_4_ + 1);
         var44 = var46 = (double)(p_78610_4_ + 0);
      }

      var8.func_78374_a(var38, var48, var46, var22, var26);
      var8.func_78374_a(var36, var48, var44, var22, var28);
      var8.func_78374_a(var34, var48, var42, var24, var28);
      var8.func_78374_a(var32, var48, var40, var24, var26);
      return true;
   }

   public void func_78568_d(Block p_78568_1_, int p_78568_2_, int p_78568_3_, int p_78568_4_) {
      this.field_78661_f = true;
      this.func_78593_b(p_78568_1_, p_78568_2_, p_78568_3_, p_78568_4_, true);
      this.field_78661_f = false;
   }

   private boolean func_78593_b(Block p_78593_1_, int p_78593_2_, int p_78593_3_, int p_78593_4_, boolean p_78593_5_) {
      int var6 = this.field_78669_a.func_72805_g(p_78593_2_, p_78593_3_, p_78593_4_);
      boolean var7 = p_78593_5_ || (var6 & 8) != 0;
      int var8 = BlockPistonBase.func_72117_e(var6);
      if(var7) {
         switch(var8) {
         case 0:
            this.field_78662_g = 3;
            this.field_78683_h = 3;
            this.field_78685_i = 3;
            this.field_78679_j = 3;
            p_78593_1_.func_71905_a(0.0F, 0.25F, 0.0F, 1.0F, 1.0F, 1.0F);
            break;
         case 1:
            p_78593_1_.func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 0.75F, 1.0F);
            break;
         case 2:
            this.field_78685_i = 1;
            this.field_78679_j = 2;
            p_78593_1_.func_71905_a(0.0F, 0.0F, 0.25F, 1.0F, 1.0F, 1.0F);
            break;
         case 3:
            this.field_78685_i = 2;
            this.field_78679_j = 1;
            this.field_78681_k = 3;
            this.field_78675_l = 3;
            p_78593_1_.func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.75F);
            break;
         case 4:
            this.field_78662_g = 1;
            this.field_78683_h = 2;
            this.field_78681_k = 2;
            this.field_78675_l = 1;
            p_78593_1_.func_71905_a(0.25F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
            break;
         case 5:
            this.field_78662_g = 2;
            this.field_78683_h = 1;
            this.field_78681_k = 1;
            this.field_78675_l = 2;
            p_78593_1_.func_71905_a(0.0F, 0.0F, 0.0F, 0.75F, 1.0F, 1.0F);
         }

         this.func_78570_q(p_78593_1_, p_78593_2_, p_78593_3_, p_78593_4_);
         this.field_78662_g = 0;
         this.field_78683_h = 0;
         this.field_78685_i = 0;
         this.field_78679_j = 0;
         this.field_78681_k = 0;
         this.field_78675_l = 0;
         p_78593_1_.func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
      } else {
         switch(var8) {
         case 0:
            this.field_78662_g = 3;
            this.field_78683_h = 3;
            this.field_78685_i = 3;
            this.field_78679_j = 3;
         case 1:
         default:
            break;
         case 2:
            this.field_78685_i = 1;
            this.field_78679_j = 2;
            break;
         case 3:
            this.field_78685_i = 2;
            this.field_78679_j = 1;
            this.field_78681_k = 3;
            this.field_78675_l = 3;
            break;
         case 4:
            this.field_78662_g = 1;
            this.field_78683_h = 2;
            this.field_78681_k = 2;
            this.field_78675_l = 1;
            break;
         case 5:
            this.field_78662_g = 2;
            this.field_78683_h = 1;
            this.field_78681_k = 1;
            this.field_78675_l = 2;
         }

         this.func_78570_q(p_78593_1_, p_78593_2_, p_78593_3_, p_78593_4_);
         this.field_78662_g = 0;
         this.field_78683_h = 0;
         this.field_78685_i = 0;
         this.field_78679_j = 0;
         this.field_78681_k = 0;
         this.field_78675_l = 0;
      }

      return true;
   }

   private void func_78591_a(double p_78591_1_, double p_78591_3_, double p_78591_5_, double p_78591_7_, double p_78591_9_, double p_78591_11_, float p_78591_13_, double p_78591_14_) {
      int var16 = 108;
      if(this.field_78664_d >= 0) {
         var16 = this.field_78664_d;
      }

      int var17 = (var16 & 15) << 4;
      int var18 = var16 & 240;
      Tessellator var19 = Tessellator.field_78398_a;
      double var20 = (double)((float)(var17 + 0) / 256.0F);
      double var22 = (double)((float)(var18 + 0) / 256.0F);
      double var24 = ((double)var17 + p_78591_14_ - 0.01D) / 256.0D;
      double var26 = ((double)((float)var18 + 4.0F) - 0.01D) / 256.0D;
      var19.func_78386_a(p_78591_13_, p_78591_13_, p_78591_13_);
      var19.func_78374_a(p_78591_1_, p_78591_7_, p_78591_9_, var24, var22);
      var19.func_78374_a(p_78591_1_, p_78591_5_, p_78591_9_, var20, var22);
      var19.func_78374_a(p_78591_3_, p_78591_5_, p_78591_11_, var20, var26);
      var19.func_78374_a(p_78591_3_, p_78591_7_, p_78591_11_, var24, var26);
   }

   private void func_78607_b(double p_78607_1_, double p_78607_3_, double p_78607_5_, double p_78607_7_, double p_78607_9_, double p_78607_11_, float p_78607_13_, double p_78607_14_) {
      int var16 = 108;
      if(this.field_78664_d >= 0) {
         var16 = this.field_78664_d;
      }

      int var17 = (var16 & 15) << 4;
      int var18 = var16 & 240;
      Tessellator var19 = Tessellator.field_78398_a;
      double var20 = (double)((float)(var17 + 0) / 256.0F);
      double var22 = (double)((float)(var18 + 0) / 256.0F);
      double var24 = ((double)var17 + p_78607_14_ - 0.01D) / 256.0D;
      double var26 = ((double)((float)var18 + 4.0F) - 0.01D) / 256.0D;
      var19.func_78386_a(p_78607_13_, p_78607_13_, p_78607_13_);
      var19.func_78374_a(p_78607_1_, p_78607_5_, p_78607_11_, var24, var22);
      var19.func_78374_a(p_78607_1_, p_78607_5_, p_78607_9_, var20, var22);
      var19.func_78374_a(p_78607_3_, p_78607_7_, p_78607_9_, var20, var26);
      var19.func_78374_a(p_78607_3_, p_78607_7_, p_78607_11_, var24, var26);
   }

   private void func_78571_c(double p_78571_1_, double p_78571_3_, double p_78571_5_, double p_78571_7_, double p_78571_9_, double p_78571_11_, float p_78571_13_, double p_78571_14_) {
      int var16 = 108;
      if(this.field_78664_d >= 0) {
         var16 = this.field_78664_d;
      }

      int var17 = (var16 & 15) << 4;
      int var18 = var16 & 240;
      Tessellator var19 = Tessellator.field_78398_a;
      double var20 = (double)((float)(var17 + 0) / 256.0F);
      double var22 = (double)((float)(var18 + 0) / 256.0F);
      double var24 = ((double)var17 + p_78571_14_ - 0.01D) / 256.0D;
      double var26 = ((double)((float)var18 + 4.0F) - 0.01D) / 256.0D;
      var19.func_78386_a(p_78571_13_, p_78571_13_, p_78571_13_);
      var19.func_78374_a(p_78571_3_, p_78571_5_, p_78571_9_, var24, var22);
      var19.func_78374_a(p_78571_1_, p_78571_5_, p_78571_9_, var20, var22);
      var19.func_78374_a(p_78571_1_, p_78571_7_, p_78571_11_, var20, var26);
      var19.func_78374_a(p_78571_3_, p_78571_7_, p_78571_11_, var24, var26);
   }

   public void func_78587_a(Block p_78587_1_, int p_78587_2_, int p_78587_3_, int p_78587_4_, boolean p_78587_5_) {
      this.field_78661_f = true;
      this.func_78608_c(p_78587_1_, p_78587_2_, p_78587_3_, p_78587_4_, p_78587_5_);
      this.field_78661_f = false;
   }

   private boolean func_78608_c(Block p_78608_1_, int p_78608_2_, int p_78608_3_, int p_78608_4_, boolean p_78608_5_) {
      int var6 = this.field_78669_a.func_72805_g(p_78608_2_, p_78608_3_, p_78608_4_);
      int var7 = BlockPistonExtension.func_72121_f(var6);
      float var11 = p_78608_1_.func_71870_f(this.field_78669_a, p_78608_2_, p_78608_3_, p_78608_4_);
      float var12 = p_78608_5_?1.0F:0.5F;
      double var13 = p_78608_5_?16.0D:8.0D;
      switch(var7) {
      case 0:
         this.field_78662_g = 3;
         this.field_78683_h = 3;
         this.field_78685_i = 3;
         this.field_78679_j = 3;
         p_78608_1_.func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 0.25F, 1.0F);
         this.func_78570_q(p_78608_1_, p_78608_2_, p_78608_3_, p_78608_4_);
         this.func_78591_a((double)((float)p_78608_2_ + 0.375F), (double)((float)p_78608_2_ + 0.625F), (double)((float)p_78608_3_ + 0.25F), (double)((float)p_78608_3_ + 0.25F + var12), (double)((float)p_78608_4_ + 0.625F), (double)((float)p_78608_4_ + 0.625F), var11 * 0.8F, var13);
         this.func_78591_a((double)((float)p_78608_2_ + 0.625F), (double)((float)p_78608_2_ + 0.375F), (double)((float)p_78608_3_ + 0.25F), (double)((float)p_78608_3_ + 0.25F + var12), (double)((float)p_78608_4_ + 0.375F), (double)((float)p_78608_4_ + 0.375F), var11 * 0.8F, var13);
         this.func_78591_a((double)((float)p_78608_2_ + 0.375F), (double)((float)p_78608_2_ + 0.375F), (double)((float)p_78608_3_ + 0.25F), (double)((float)p_78608_3_ + 0.25F + var12), (double)((float)p_78608_4_ + 0.375F), (double)((float)p_78608_4_ + 0.625F), var11 * 0.6F, var13);
         this.func_78591_a((double)((float)p_78608_2_ + 0.625F), (double)((float)p_78608_2_ + 0.625F), (double)((float)p_78608_3_ + 0.25F), (double)((float)p_78608_3_ + 0.25F + var12), (double)((float)p_78608_4_ + 0.625F), (double)((float)p_78608_4_ + 0.375F), var11 * 0.6F, var13);
         break;
      case 1:
         p_78608_1_.func_71905_a(0.0F, 0.75F, 0.0F, 1.0F, 1.0F, 1.0F);
         this.func_78570_q(p_78608_1_, p_78608_2_, p_78608_3_, p_78608_4_);
         this.func_78591_a((double)((float)p_78608_2_ + 0.375F), (double)((float)p_78608_2_ + 0.625F), (double)((float)p_78608_3_ - 0.25F + 1.0F - var12), (double)((float)p_78608_3_ - 0.25F + 1.0F), (double)((float)p_78608_4_ + 0.625F), (double)((float)p_78608_4_ + 0.625F), var11 * 0.8F, var13);
         this.func_78591_a((double)((float)p_78608_2_ + 0.625F), (double)((float)p_78608_2_ + 0.375F), (double)((float)p_78608_3_ - 0.25F + 1.0F - var12), (double)((float)p_78608_3_ - 0.25F + 1.0F), (double)((float)p_78608_4_ + 0.375F), (double)((float)p_78608_4_ + 0.375F), var11 * 0.8F, var13);
         this.func_78591_a((double)((float)p_78608_2_ + 0.375F), (double)((float)p_78608_2_ + 0.375F), (double)((float)p_78608_3_ - 0.25F + 1.0F - var12), (double)((float)p_78608_3_ - 0.25F + 1.0F), (double)((float)p_78608_4_ + 0.375F), (double)((float)p_78608_4_ + 0.625F), var11 * 0.6F, var13);
         this.func_78591_a((double)((float)p_78608_2_ + 0.625F), (double)((float)p_78608_2_ + 0.625F), (double)((float)p_78608_3_ - 0.25F + 1.0F - var12), (double)((float)p_78608_3_ - 0.25F + 1.0F), (double)((float)p_78608_4_ + 0.625F), (double)((float)p_78608_4_ + 0.375F), var11 * 0.6F, var13);
         break;
      case 2:
         this.field_78685_i = 1;
         this.field_78679_j = 2;
         p_78608_1_.func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.25F);
         this.func_78570_q(p_78608_1_, p_78608_2_, p_78608_3_, p_78608_4_);
         this.func_78607_b((double)((float)p_78608_2_ + 0.375F), (double)((float)p_78608_2_ + 0.375F), (double)((float)p_78608_3_ + 0.625F), (double)((float)p_78608_3_ + 0.375F), (double)((float)p_78608_4_ + 0.25F), (double)((float)p_78608_4_ + 0.25F + var12), var11 * 0.6F, var13);
         this.func_78607_b((double)((float)p_78608_2_ + 0.625F), (double)((float)p_78608_2_ + 0.625F), (double)((float)p_78608_3_ + 0.375F), (double)((float)p_78608_3_ + 0.625F), (double)((float)p_78608_4_ + 0.25F), (double)((float)p_78608_4_ + 0.25F + var12), var11 * 0.6F, var13);
         this.func_78607_b((double)((float)p_78608_2_ + 0.375F), (double)((float)p_78608_2_ + 0.625F), (double)((float)p_78608_3_ + 0.375F), (double)((float)p_78608_3_ + 0.375F), (double)((float)p_78608_4_ + 0.25F), (double)((float)p_78608_4_ + 0.25F + var12), var11 * 0.5F, var13);
         this.func_78607_b((double)((float)p_78608_2_ + 0.625F), (double)((float)p_78608_2_ + 0.375F), (double)((float)p_78608_3_ + 0.625F), (double)((float)p_78608_3_ + 0.625F), (double)((float)p_78608_4_ + 0.25F), (double)((float)p_78608_4_ + 0.25F + var12), var11, var13);
         break;
      case 3:
         this.field_78685_i = 2;
         this.field_78679_j = 1;
         this.field_78681_k = 3;
         this.field_78675_l = 3;
         p_78608_1_.func_71905_a(0.0F, 0.0F, 0.75F, 1.0F, 1.0F, 1.0F);
         this.func_78570_q(p_78608_1_, p_78608_2_, p_78608_3_, p_78608_4_);
         this.func_78607_b((double)((float)p_78608_2_ + 0.375F), (double)((float)p_78608_2_ + 0.375F), (double)((float)p_78608_3_ + 0.625F), (double)((float)p_78608_3_ + 0.375F), (double)((float)p_78608_4_ - 0.25F + 1.0F - var12), (double)((float)p_78608_4_ - 0.25F + 1.0F), var11 * 0.6F, var13);
         this.func_78607_b((double)((float)p_78608_2_ + 0.625F), (double)((float)p_78608_2_ + 0.625F), (double)((float)p_78608_3_ + 0.375F), (double)((float)p_78608_3_ + 0.625F), (double)((float)p_78608_4_ - 0.25F + 1.0F - var12), (double)((float)p_78608_4_ - 0.25F + 1.0F), var11 * 0.6F, var13);
         this.func_78607_b((double)((float)p_78608_2_ + 0.375F), (double)((float)p_78608_2_ + 0.625F), (double)((float)p_78608_3_ + 0.375F), (double)((float)p_78608_3_ + 0.375F), (double)((float)p_78608_4_ - 0.25F + 1.0F - var12), (double)((float)p_78608_4_ - 0.25F + 1.0F), var11 * 0.5F, var13);
         this.func_78607_b((double)((float)p_78608_2_ + 0.625F), (double)((float)p_78608_2_ + 0.375F), (double)((float)p_78608_3_ + 0.625F), (double)((float)p_78608_3_ + 0.625F), (double)((float)p_78608_4_ - 0.25F + 1.0F - var12), (double)((float)p_78608_4_ - 0.25F + 1.0F), var11, var13);
         break;
      case 4:
         this.field_78662_g = 1;
         this.field_78683_h = 2;
         this.field_78681_k = 2;
         this.field_78675_l = 1;
         p_78608_1_.func_71905_a(0.0F, 0.0F, 0.0F, 0.25F, 1.0F, 1.0F);
         this.func_78570_q(p_78608_1_, p_78608_2_, p_78608_3_, p_78608_4_);
         this.func_78571_c((double)((float)p_78608_2_ + 0.25F), (double)((float)p_78608_2_ + 0.25F + var12), (double)((float)p_78608_3_ + 0.375F), (double)((float)p_78608_3_ + 0.375F), (double)((float)p_78608_4_ + 0.625F), (double)((float)p_78608_4_ + 0.375F), var11 * 0.5F, var13);
         this.func_78571_c((double)((float)p_78608_2_ + 0.25F), (double)((float)p_78608_2_ + 0.25F + var12), (double)((float)p_78608_3_ + 0.625F), (double)((float)p_78608_3_ + 0.625F), (double)((float)p_78608_4_ + 0.375F), (double)((float)p_78608_4_ + 0.625F), var11, var13);
         this.func_78571_c((double)((float)p_78608_2_ + 0.25F), (double)((float)p_78608_2_ + 0.25F + var12), (double)((float)p_78608_3_ + 0.375F), (double)((float)p_78608_3_ + 0.625F), (double)((float)p_78608_4_ + 0.375F), (double)((float)p_78608_4_ + 0.375F), var11 * 0.6F, var13);
         this.func_78571_c((double)((float)p_78608_2_ + 0.25F), (double)((float)p_78608_2_ + 0.25F + var12), (double)((float)p_78608_3_ + 0.625F), (double)((float)p_78608_3_ + 0.375F), (double)((float)p_78608_4_ + 0.625F), (double)((float)p_78608_4_ + 0.625F), var11 * 0.6F, var13);
         break;
      case 5:
         this.field_78662_g = 2;
         this.field_78683_h = 1;
         this.field_78681_k = 1;
         this.field_78675_l = 2;
         p_78608_1_.func_71905_a(0.75F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
         this.func_78570_q(p_78608_1_, p_78608_2_, p_78608_3_, p_78608_4_);
         this.func_78571_c((double)((float)p_78608_2_ - 0.25F + 1.0F - var12), (double)((float)p_78608_2_ - 0.25F + 1.0F), (double)((float)p_78608_3_ + 0.375F), (double)((float)p_78608_3_ + 0.375F), (double)((float)p_78608_4_ + 0.625F), (double)((float)p_78608_4_ + 0.375F), var11 * 0.5F, var13);
         this.func_78571_c((double)((float)p_78608_2_ - 0.25F + 1.0F - var12), (double)((float)p_78608_2_ - 0.25F + 1.0F), (double)((float)p_78608_3_ + 0.625F), (double)((float)p_78608_3_ + 0.625F), (double)((float)p_78608_4_ + 0.375F), (double)((float)p_78608_4_ + 0.625F), var11, var13);
         this.func_78571_c((double)((float)p_78608_2_ - 0.25F + 1.0F - var12), (double)((float)p_78608_2_ - 0.25F + 1.0F), (double)((float)p_78608_3_ + 0.375F), (double)((float)p_78608_3_ + 0.625F), (double)((float)p_78608_4_ + 0.375F), (double)((float)p_78608_4_ + 0.375F), var11 * 0.6F, var13);
         this.func_78571_c((double)((float)p_78608_2_ - 0.25F + 1.0F - var12), (double)((float)p_78608_2_ - 0.25F + 1.0F), (double)((float)p_78608_3_ + 0.625F), (double)((float)p_78608_3_ + 0.375F), (double)((float)p_78608_4_ + 0.625F), (double)((float)p_78608_4_ + 0.625F), var11 * 0.6F, var13);
      }

      this.field_78662_g = 0;
      this.field_78683_h = 0;
      this.field_78685_i = 0;
      this.field_78679_j = 0;
      this.field_78681_k = 0;
      this.field_78675_l = 0;
      p_78608_1_.func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
      return true;
   }

   public boolean func_78594_e(Block p_78594_1_, int p_78594_2_, int p_78594_3_, int p_78594_4_) {
      int var5 = this.field_78669_a.func_72805_g(p_78594_2_, p_78594_3_, p_78594_4_);
      int var6 = var5 & 7;
      boolean var7 = (var5 & 8) > 0;
      Tessellator var8 = Tessellator.field_78398_a;
      boolean var9 = this.field_78664_d >= 0;
      if(!var9) {
         this.field_78664_d = Block.field_71978_w.field_72059_bZ;
      }

      float var10 = 0.25F;
      float var11 = 0.1875F;
      float var12 = 0.1875F;
      if(var6 == 5) {
         p_78594_1_.func_71905_a(0.5F - var11, 0.0F, 0.5F - var10, 0.5F + var11, var12, 0.5F + var10);
      } else if(var6 == 6) {
         p_78594_1_.func_71905_a(0.5F - var10, 0.0F, 0.5F - var11, 0.5F + var10, var12, 0.5F + var11);
      } else if(var6 == 4) {
         p_78594_1_.func_71905_a(0.5F - var11, 0.5F - var10, 1.0F - var12, 0.5F + var11, 0.5F + var10, 1.0F);
      } else if(var6 == 3) {
         p_78594_1_.func_71905_a(0.5F - var11, 0.5F - var10, 0.0F, 0.5F + var11, 0.5F + var10, var12);
      } else if(var6 == 2) {
         p_78594_1_.func_71905_a(1.0F - var12, 0.5F - var10, 0.5F - var11, 1.0F, 0.5F + var10, 0.5F + var11);
      } else if(var6 == 1) {
         p_78594_1_.func_71905_a(0.0F, 0.5F - var10, 0.5F - var11, var12, 0.5F + var10, 0.5F + var11);
      } else if(var6 == 0) {
         p_78594_1_.func_71905_a(0.5F - var10, 1.0F - var12, 0.5F - var11, 0.5F + var10, 1.0F, 0.5F + var11);
      } else if(var6 == 7) {
         p_78594_1_.func_71905_a(0.5F - var11, 1.0F - var12, 0.5F - var10, 0.5F + var11, 1.0F, 0.5F + var10);
      }

      this.func_78570_q(p_78594_1_, p_78594_2_, p_78594_3_, p_78594_4_);
      if(!var9) {
         this.field_78664_d = -1;
      }

      var8.func_78380_c(p_78594_1_.func_71874_e(this.field_78669_a, p_78594_2_, p_78594_3_, p_78594_4_));
      float var13 = 1.0F;
      if(Block.field_71984_q[p_78594_1_.field_71990_ca] > 0) {
         var13 = 1.0F;
      }

      var8.func_78386_a(var13, var13, var13);
      int var14 = p_78594_1_.func_71851_a(0);
      if(this.field_78664_d >= 0) {
         var14 = this.field_78664_d;
      }

      int var15 = (var14 & 15) << 4;
      int var16 = var14 & 240;
      float var17 = (float)var15 / 256.0F;
      float var18 = ((float)var15 + 15.99F) / 256.0F;
      float var19 = (float)var16 / 256.0F;
      float var20 = ((float)var16 + 15.99F) / 256.0F;
      Vec3[] var21 = new Vec3[8];
      float var22 = 0.0625F;
      float var23 = 0.0625F;
      float var24 = 0.625F;
      var21[0] = Vec3.func_72437_a().func_72345_a((double)(-var22), 0.0D, (double)(-var23));
      var21[1] = Vec3.func_72437_a().func_72345_a((double)var22, 0.0D, (double)(-var23));
      var21[2] = Vec3.func_72437_a().func_72345_a((double)var22, 0.0D, (double)var23);
      var21[3] = Vec3.func_72437_a().func_72345_a((double)(-var22), 0.0D, (double)var23);
      var21[4] = Vec3.func_72437_a().func_72345_a((double)(-var22), (double)var24, (double)(-var23));
      var21[5] = Vec3.func_72437_a().func_72345_a((double)var22, (double)var24, (double)(-var23));
      var21[6] = Vec3.func_72437_a().func_72345_a((double)var22, (double)var24, (double)var23);
      var21[7] = Vec3.func_72437_a().func_72345_a((double)(-var22), (double)var24, (double)var23);

      for(int var25 = 0; var25 < 8; ++var25) {
         if(var7) {
            var21[var25].field_72449_c -= 0.0625D;
            var21[var25].func_72440_a(0.69813174F);
         } else {
            var21[var25].field_72449_c += 0.0625D;
            var21[var25].func_72440_a(-0.69813174F);
         }

         if(var6 == 0 || var6 == 7) {
            var21[var25].func_72446_c(3.1415927F);
         }

         if(var6 == 6 || var6 == 0) {
            var21[var25].func_72442_b(1.5707964F);
         }

         if(var6 > 0 && var6 < 5) {
            var21[var25].field_72448_b -= 0.375D;
            var21[var25].func_72440_a(1.5707964F);
            if(var6 == 4) {
               var21[var25].func_72442_b(0.0F);
            }

            if(var6 == 3) {
               var21[var25].func_72442_b(3.1415927F);
            }

            if(var6 == 2) {
               var21[var25].func_72442_b(1.5707964F);
            }

            if(var6 == 1) {
               var21[var25].func_72442_b(-1.5707964F);
            }

            var21[var25].field_72450_a += (double)p_78594_2_ + 0.5D;
            var21[var25].field_72448_b += (double)((float)p_78594_3_ + 0.5F);
            var21[var25].field_72449_c += (double)p_78594_4_ + 0.5D;
         } else if(var6 != 0 && var6 != 7) {
            var21[var25].field_72450_a += (double)p_78594_2_ + 0.5D;
            var21[var25].field_72448_b += (double)((float)p_78594_3_ + 0.125F);
            var21[var25].field_72449_c += (double)p_78594_4_ + 0.5D;
         } else {
            var21[var25].field_72450_a += (double)p_78594_2_ + 0.5D;
            var21[var25].field_72448_b += (double)((float)p_78594_3_ + 0.875F);
            var21[var25].field_72449_c += (double)p_78594_4_ + 0.5D;
         }
      }

      Vec3 var30 = null;
      Vec3 var26 = null;
      Vec3 var27 = null;
      Vec3 var28 = null;

      for(int var29 = 0; var29 < 6; ++var29) {
         if(var29 == 0) {
            var17 = (float)(var15 + 7) / 256.0F;
            var18 = ((float)(var15 + 9) - 0.01F) / 256.0F;
            var19 = (float)(var16 + 6) / 256.0F;
            var20 = ((float)(var16 + 8) - 0.01F) / 256.0F;
         } else if(var29 == 2) {
            var17 = (float)(var15 + 7) / 256.0F;
            var18 = ((float)(var15 + 9) - 0.01F) / 256.0F;
            var19 = (float)(var16 + 6) / 256.0F;
            var20 = ((float)(var16 + 16) - 0.01F) / 256.0F;
         }

         if(var29 == 0) {
            var30 = var21[0];
            var26 = var21[1];
            var27 = var21[2];
            var28 = var21[3];
         } else if(var29 == 1) {
            var30 = var21[7];
            var26 = var21[6];
            var27 = var21[5];
            var28 = var21[4];
         } else if(var29 == 2) {
            var30 = var21[1];
            var26 = var21[0];
            var27 = var21[4];
            var28 = var21[5];
         } else if(var29 == 3) {
            var30 = var21[2];
            var26 = var21[1];
            var27 = var21[5];
            var28 = var21[6];
         } else if(var29 == 4) {
            var30 = var21[3];
            var26 = var21[2];
            var27 = var21[6];
            var28 = var21[7];
         } else if(var29 == 5) {
            var30 = var21[0];
            var26 = var21[3];
            var27 = var21[7];
            var28 = var21[4];
         }

         var8.func_78374_a(var30.field_72450_a, var30.field_72448_b, var30.field_72449_c, (double)var17, (double)var20);
         var8.func_78374_a(var26.field_72450_a, var26.field_72448_b, var26.field_72449_c, (double)var18, (double)var20);
         var8.func_78374_a(var27.field_72450_a, var27.field_72448_b, var27.field_72449_c, (double)var18, (double)var19);
         var8.func_78374_a(var28.field_72450_a, var28.field_72448_b, var28.field_72449_c, (double)var17, (double)var19);
      }

      return true;
   }

   public boolean func_78577_f(Block p_78577_1_, int p_78577_2_, int p_78577_3_, int p_78577_4_) {
      Tessellator var5 = Tessellator.field_78398_a;
      int var6 = this.field_78669_a.func_72805_g(p_78577_2_, p_78577_3_, p_78577_4_);
      int var7 = var6 & 3;
      boolean var8 = (var6 & 4) == 4;
      boolean var9 = (var6 & 8) == 8;
      boolean var10 = !this.field_78669_a.func_72797_t(p_78577_2_, p_78577_3_ - 1, p_78577_4_);
      boolean var11 = this.field_78664_d >= 0;
      if(!var11) {
         this.field_78664_d = Block.field_71988_x.field_72059_bZ;
      }

      float var12 = 0.25F;
      float var13 = 0.125F;
      float var14 = 0.125F;
      float var15 = 0.3F - var12;
      float var16 = 0.3F + var12;
      if(var7 == 2) {
         p_78577_1_.func_71905_a(0.5F - var13, var15, 1.0F - var14, 0.5F + var13, var16, 1.0F);
      } else if(var7 == 0) {
         p_78577_1_.func_71905_a(0.5F - var13, var15, 0.0F, 0.5F + var13, var16, var14);
      } else if(var7 == 1) {
         p_78577_1_.func_71905_a(1.0F - var14, var15, 0.5F - var13, 1.0F, var16, 0.5F + var13);
      } else if(var7 == 3) {
         p_78577_1_.func_71905_a(0.0F, var15, 0.5F - var13, var14, var16, 0.5F + var13);
      }

      this.func_78570_q(p_78577_1_, p_78577_2_, p_78577_3_, p_78577_4_);
      if(!var11) {
         this.field_78664_d = -1;
      }

      var5.func_78380_c(p_78577_1_.func_71874_e(this.field_78669_a, p_78577_2_, p_78577_3_, p_78577_4_));
      float var17 = 1.0F;
      if(Block.field_71984_q[p_78577_1_.field_71990_ca] > 0) {
         var17 = 1.0F;
      }

      var5.func_78386_a(var17, var17, var17);
      int var18 = p_78577_1_.func_71851_a(0);
      if(this.field_78664_d >= 0) {
         var18 = this.field_78664_d;
      }

      int var19 = (var18 & 15) << 4;
      int var20 = var18 & 240;
      float var21 = (float)var19 / 256.0F;
      float var22 = ((float)var19 + 15.99F) / 256.0F;
      float var23 = (float)var20 / 256.0F;
      float var24 = ((float)var20 + 15.99F) / 256.0F;
      Vec3[] var25 = new Vec3[8];
      float var26 = 0.046875F;
      float var27 = 0.046875F;
      float var28 = 0.3125F;
      var25[0] = Vec3.func_72437_a().func_72345_a((double)(-var26), 0.0D, (double)(-var27));
      var25[1] = Vec3.func_72437_a().func_72345_a((double)var26, 0.0D, (double)(-var27));
      var25[2] = Vec3.func_72437_a().func_72345_a((double)var26, 0.0D, (double)var27);
      var25[3] = Vec3.func_72437_a().func_72345_a((double)(-var26), 0.0D, (double)var27);
      var25[4] = Vec3.func_72437_a().func_72345_a((double)(-var26), (double)var28, (double)(-var27));
      var25[5] = Vec3.func_72437_a().func_72345_a((double)var26, (double)var28, (double)(-var27));
      var25[6] = Vec3.func_72437_a().func_72345_a((double)var26, (double)var28, (double)var27);
      var25[7] = Vec3.func_72437_a().func_72345_a((double)(-var26), (double)var28, (double)var27);

      for(int var29 = 0; var29 < 8; ++var29) {
         var25[var29].field_72449_c += 0.0625D;
         if(var9) {
            var25[var29].func_72440_a(0.5235988F);
            var25[var29].field_72448_b -= 0.4375D;
         } else if(var8) {
            var25[var29].func_72440_a(0.08726647F);
            var25[var29].field_72448_b -= 0.4375D;
         } else {
            var25[var29].func_72440_a(-0.69813174F);
            var25[var29].field_72448_b -= 0.375D;
         }

         var25[var29].func_72440_a(1.5707964F);
         if(var7 == 2) {
            var25[var29].func_72442_b(0.0F);
         }

         if(var7 == 0) {
            var25[var29].func_72442_b(3.1415927F);
         }

         if(var7 == 1) {
            var25[var29].func_72442_b(1.5707964F);
         }

         if(var7 == 3) {
            var25[var29].func_72442_b(-1.5707964F);
         }

         var25[var29].field_72450_a += (double)p_78577_2_ + 0.5D;
         var25[var29].field_72448_b += (double)((float)p_78577_3_ + 0.3125F);
         var25[var29].field_72449_c += (double)p_78577_4_ + 0.5D;
      }

      Vec3 var61 = null;
      Vec3 var30 = null;
      Vec3 var31 = null;
      Vec3 var32 = null;
      byte var33 = 7;
      byte var34 = 9;
      byte var35 = 9;
      byte var36 = 16;

      for(int var37 = 0; var37 < 6; ++var37) {
         if(var37 == 0) {
            var61 = var25[0];
            var30 = var25[1];
            var31 = var25[2];
            var32 = var25[3];
            var21 = (float)(var19 + var33) / 256.0F;
            var22 = (float)(var19 + var34) / 256.0F;
            var23 = (float)(var20 + var35) / 256.0F;
            var24 = (float)(var20 + var35 + 2) / 256.0F;
         } else if(var37 == 1) {
            var61 = var25[7];
            var30 = var25[6];
            var31 = var25[5];
            var32 = var25[4];
         } else if(var37 == 2) {
            var61 = var25[1];
            var30 = var25[0];
            var31 = var25[4];
            var32 = var25[5];
            var21 = (float)(var19 + var33) / 256.0F;
            var22 = (float)(var19 + var34) / 256.0F;
            var23 = (float)(var20 + var35) / 256.0F;
            var24 = (float)(var20 + var36) / 256.0F;
         } else if(var37 == 3) {
            var61 = var25[2];
            var30 = var25[1];
            var31 = var25[5];
            var32 = var25[6];
         } else if(var37 == 4) {
            var61 = var25[3];
            var30 = var25[2];
            var31 = var25[6];
            var32 = var25[7];
         } else if(var37 == 5) {
            var61 = var25[0];
            var30 = var25[3];
            var31 = var25[7];
            var32 = var25[4];
         }

         var5.func_78374_a(var61.field_72450_a, var61.field_72448_b, var61.field_72449_c, (double)var21, (double)var24);
         var5.func_78374_a(var30.field_72450_a, var30.field_72448_b, var30.field_72449_c, (double)var22, (double)var24);
         var5.func_78374_a(var31.field_72450_a, var31.field_72448_b, var31.field_72449_c, (double)var22, (double)var23);
         var5.func_78374_a(var32.field_72450_a, var32.field_72448_b, var32.field_72449_c, (double)var21, (double)var23);
      }

      float var62 = 0.09375F;
      float var38 = 0.09375F;
      float var39 = 0.03125F;
      var25[0] = Vec3.func_72437_a().func_72345_a((double)(-var62), 0.0D, (double)(-var38));
      var25[1] = Vec3.func_72437_a().func_72345_a((double)var62, 0.0D, (double)(-var38));
      var25[2] = Vec3.func_72437_a().func_72345_a((double)var62, 0.0D, (double)var38);
      var25[3] = Vec3.func_72437_a().func_72345_a((double)(-var62), 0.0D, (double)var38);
      var25[4] = Vec3.func_72437_a().func_72345_a((double)(-var62), (double)var39, (double)(-var38));
      var25[5] = Vec3.func_72437_a().func_72345_a((double)var62, (double)var39, (double)(-var38));
      var25[6] = Vec3.func_72437_a().func_72345_a((double)var62, (double)var39, (double)var38);
      var25[7] = Vec3.func_72437_a().func_72345_a((double)(-var62), (double)var39, (double)var38);

      for(int var40 = 0; var40 < 8; ++var40) {
         var25[var40].field_72449_c += 0.21875D;
         if(var9) {
            var25[var40].field_72448_b -= 0.09375D;
            var25[var40].field_72449_c -= 0.1625D;
            var25[var40].func_72440_a(0.0F);
         } else if(var8) {
            var25[var40].field_72448_b += 0.015625D;
            var25[var40].field_72449_c -= 0.171875D;
            var25[var40].func_72440_a(0.17453294F);
         } else {
            var25[var40].func_72440_a(0.87266463F);
         }

         if(var7 == 2) {
            var25[var40].func_72442_b(0.0F);
         }

         if(var7 == 0) {
            var25[var40].func_72442_b(3.1415927F);
         }

         if(var7 == 1) {
            var25[var40].func_72442_b(1.5707964F);
         }

         if(var7 == 3) {
            var25[var40].func_72442_b(-1.5707964F);
         }

         var25[var40].field_72450_a += (double)p_78577_2_ + 0.5D;
         var25[var40].field_72448_b += (double)((float)p_78577_3_ + 0.3125F);
         var25[var40].field_72449_c += (double)p_78577_4_ + 0.5D;
      }

      byte var63 = 5;
      byte var41 = 11;
      byte var42 = 3;
      byte var43 = 9;

      for(int var44 = 0; var44 < 6; ++var44) {
         if(var44 == 0) {
            var61 = var25[0];
            var30 = var25[1];
            var31 = var25[2];
            var32 = var25[3];
            var21 = (float)(var19 + var63) / 256.0F;
            var22 = (float)(var19 + var41) / 256.0F;
            var23 = (float)(var20 + var42) / 256.0F;
            var24 = (float)(var20 + var43) / 256.0F;
         } else if(var44 == 1) {
            var61 = var25[7];
            var30 = var25[6];
            var31 = var25[5];
            var32 = var25[4];
         } else if(var44 == 2) {
            var61 = var25[1];
            var30 = var25[0];
            var31 = var25[4];
            var32 = var25[5];
            var21 = (float)(var19 + var63) / 256.0F;
            var22 = (float)(var19 + var41) / 256.0F;
            var23 = (float)(var20 + var42) / 256.0F;
            var24 = (float)(var20 + var42 + 2) / 256.0F;
         } else if(var44 == 3) {
            var61 = var25[2];
            var30 = var25[1];
            var31 = var25[5];
            var32 = var25[6];
         } else if(var44 == 4) {
            var61 = var25[3];
            var30 = var25[2];
            var31 = var25[6];
            var32 = var25[7];
         } else if(var44 == 5) {
            var61 = var25[0];
            var30 = var25[3];
            var31 = var25[7];
            var32 = var25[4];
         }

         var5.func_78374_a(var61.field_72450_a, var61.field_72448_b, var61.field_72449_c, (double)var21, (double)var24);
         var5.func_78374_a(var30.field_72450_a, var30.field_72448_b, var30.field_72449_c, (double)var22, (double)var24);
         var5.func_78374_a(var31.field_72450_a, var31.field_72448_b, var31.field_72449_c, (double)var22, (double)var23);
         var5.func_78374_a(var32.field_72450_a, var32.field_72448_b, var32.field_72449_c, (double)var21, (double)var23);
      }

      if(var8) {
         double var64 = var25[0].field_72448_b;
         float var46 = 0.03125F;
         float var47 = 0.5F - var46 / 2.0F;
         float var48 = var47 + var46;
         int var49 = (Block.field_72062_bU.field_72059_bZ & 15) << 4;
         int var50 = Block.field_72062_bU.field_72059_bZ & 240;
         double var51 = (double)((float)var49 / 256.0F);
         double var53 = (double)((float)(var49 + 16) / 256.0F);
         double var55 = (double)((float)(var50 + (var8?2:0)) / 256.0F);
         double var57 = (double)((float)(var50 + (var8?4:2)) / 256.0F);
         double var59 = (double)(var10?3.5F:1.5F) / 16.0D;
         var17 = p_78577_1_.func_71870_f(this.field_78669_a, p_78577_2_, p_78577_3_, p_78577_4_) * 0.75F;
         var5.func_78386_a(var17, var17, var17);
         if(var7 == 2) {
            var5.func_78374_a((double)((float)p_78577_2_ + var47), (double)p_78577_3_ + var59, (double)p_78577_4_ + 0.25D, var51, var55);
            var5.func_78374_a((double)((float)p_78577_2_ + var48), (double)p_78577_3_ + var59, (double)p_78577_4_ + 0.25D, var51, var57);
            var5.func_78374_a((double)((float)p_78577_2_ + var48), (double)p_78577_3_ + var59, (double)p_78577_4_, var53, var57);
            var5.func_78374_a((double)((float)p_78577_2_ + var47), (double)p_78577_3_ + var59, (double)p_78577_4_, var53, var55);
            var5.func_78374_a((double)((float)p_78577_2_ + var47), var64, (double)p_78577_4_ + 0.5D, var51, var55);
            var5.func_78374_a((double)((float)p_78577_2_ + var48), var64, (double)p_78577_4_ + 0.5D, var51, var57);
            var5.func_78374_a((double)((float)p_78577_2_ + var48), (double)p_78577_3_ + var59, (double)p_78577_4_ + 0.25D, var53, var57);
            var5.func_78374_a((double)((float)p_78577_2_ + var47), (double)p_78577_3_ + var59, (double)p_78577_4_ + 0.25D, var53, var55);
         } else if(var7 == 0) {
            var5.func_78374_a((double)((float)p_78577_2_ + var47), (double)p_78577_3_ + var59, (double)p_78577_4_ + 0.75D, var51, var55);
            var5.func_78374_a((double)((float)p_78577_2_ + var48), (double)p_78577_3_ + var59, (double)p_78577_4_ + 0.75D, var51, var57);
            var5.func_78374_a((double)((float)p_78577_2_ + var48), var64, (double)p_78577_4_ + 0.5D, var53, var57);
            var5.func_78374_a((double)((float)p_78577_2_ + var47), var64, (double)p_78577_4_ + 0.5D, var53, var55);
            var5.func_78374_a((double)((float)p_78577_2_ + var47), (double)p_78577_3_ + var59, (double)(p_78577_4_ + 1), var51, var55);
            var5.func_78374_a((double)((float)p_78577_2_ + var48), (double)p_78577_3_ + var59, (double)(p_78577_4_ + 1), var51, var57);
            var5.func_78374_a((double)((float)p_78577_2_ + var48), (double)p_78577_3_ + var59, (double)p_78577_4_ + 0.75D, var53, var57);
            var5.func_78374_a((double)((float)p_78577_2_ + var47), (double)p_78577_3_ + var59, (double)p_78577_4_ + 0.75D, var53, var55);
         } else if(var7 == 1) {
            var5.func_78374_a((double)p_78577_2_, (double)p_78577_3_ + var59, (double)((float)p_78577_4_ + var48), var51, var57);
            var5.func_78374_a((double)p_78577_2_ + 0.25D, (double)p_78577_3_ + var59, (double)((float)p_78577_4_ + var48), var53, var57);
            var5.func_78374_a((double)p_78577_2_ + 0.25D, (double)p_78577_3_ + var59, (double)((float)p_78577_4_ + var47), var53, var55);
            var5.func_78374_a((double)p_78577_2_, (double)p_78577_3_ + var59, (double)((float)p_78577_4_ + var47), var51, var55);
            var5.func_78374_a((double)p_78577_2_ + 0.25D, (double)p_78577_3_ + var59, (double)((float)p_78577_4_ + var48), var51, var57);
            var5.func_78374_a((double)p_78577_2_ + 0.5D, var64, (double)((float)p_78577_4_ + var48), var53, var57);
            var5.func_78374_a((double)p_78577_2_ + 0.5D, var64, (double)((float)p_78577_4_ + var47), var53, var55);
            var5.func_78374_a((double)p_78577_2_ + 0.25D, (double)p_78577_3_ + var59, (double)((float)p_78577_4_ + var47), var51, var55);
         } else {
            var5.func_78374_a((double)p_78577_2_ + 0.5D, var64, (double)((float)p_78577_4_ + var48), var51, var57);
            var5.func_78374_a((double)p_78577_2_ + 0.75D, (double)p_78577_3_ + var59, (double)((float)p_78577_4_ + var48), var53, var57);
            var5.func_78374_a((double)p_78577_2_ + 0.75D, (double)p_78577_3_ + var59, (double)((float)p_78577_4_ + var47), var53, var55);
            var5.func_78374_a((double)p_78577_2_ + 0.5D, var64, (double)((float)p_78577_4_ + var47), var51, var55);
            var5.func_78374_a((double)p_78577_2_ + 0.75D, (double)p_78577_3_ + var59, (double)((float)p_78577_4_ + var48), var51, var57);
            var5.func_78374_a((double)(p_78577_2_ + 1), (double)p_78577_3_ + var59, (double)((float)p_78577_4_ + var48), var53, var57);
            var5.func_78374_a((double)(p_78577_2_ + 1), (double)p_78577_3_ + var59, (double)((float)p_78577_4_ + var47), var53, var55);
            var5.func_78374_a((double)p_78577_2_ + 0.75D, (double)p_78577_3_ + var59, (double)((float)p_78577_4_ + var47), var51, var55);
         }
      }

      return true;
   }

   public boolean func_78619_g(Block p_78619_1_, int p_78619_2_, int p_78619_3_, int p_78619_4_) {
      Tessellator var5 = Tessellator.field_78398_a;
      int var6 = p_78619_1_.func_71851_a(0);
      int var7 = this.field_78669_a.func_72805_g(p_78619_2_, p_78619_3_, p_78619_4_);
      boolean var8 = (var7 & 4) == 4;
      boolean var9 = (var7 & 2) == 2;
      if(this.field_78664_d >= 0) {
         var6 = this.field_78664_d;
      }

      var5.func_78380_c(p_78619_1_.func_71874_e(this.field_78669_a, p_78619_2_, p_78619_3_, p_78619_4_));
      float var10 = p_78619_1_.func_71870_f(this.field_78669_a, p_78619_2_, p_78619_3_, p_78619_4_) * 0.75F;
      var5.func_78386_a(var10, var10, var10);
      int var11 = (var6 & 15) << 4;
      int var12 = var6 & 240;
      double var13 = (double)((float)var11 / 256.0F);
      double var15 = (double)((float)(var11 + 16) / 256.0F);
      double var17 = (double)((float)(var12 + (var8?2:0)) / 256.0F);
      double var19 = (double)((float)(var12 + (var8?4:2)) / 256.0F);
      double var21 = (double)(var9?3.5F:1.5F) / 16.0D;
      boolean var23 = BlockTripWire.func_72148_a(this.field_78669_a, p_78619_2_, p_78619_3_, p_78619_4_, var7, 1);
      boolean var24 = BlockTripWire.func_72148_a(this.field_78669_a, p_78619_2_, p_78619_3_, p_78619_4_, var7, 3);
      boolean var25 = BlockTripWire.func_72148_a(this.field_78669_a, p_78619_2_, p_78619_3_, p_78619_4_, var7, 2);
      boolean var26 = BlockTripWire.func_72148_a(this.field_78669_a, p_78619_2_, p_78619_3_, p_78619_4_, var7, 0);
      float var27 = 0.03125F;
      float var28 = 0.5F - var27 / 2.0F;
      float var29 = var28 + var27;
      if(!var25 && !var24 && !var26 && !var23) {
         var25 = true;
         var26 = true;
      }

      if(var25) {
         var5.func_78374_a((double)((float)p_78619_2_ + var28), (double)p_78619_3_ + var21, (double)p_78619_4_ + 0.25D, var13, var17);
         var5.func_78374_a((double)((float)p_78619_2_ + var29), (double)p_78619_3_ + var21, (double)p_78619_4_ + 0.25D, var13, var19);
         var5.func_78374_a((double)((float)p_78619_2_ + var29), (double)p_78619_3_ + var21, (double)p_78619_4_, var15, var19);
         var5.func_78374_a((double)((float)p_78619_2_ + var28), (double)p_78619_3_ + var21, (double)p_78619_4_, var15, var17);
         var5.func_78374_a((double)((float)p_78619_2_ + var28), (double)p_78619_3_ + var21, (double)p_78619_4_, var15, var17);
         var5.func_78374_a((double)((float)p_78619_2_ + var29), (double)p_78619_3_ + var21, (double)p_78619_4_, var15, var19);
         var5.func_78374_a((double)((float)p_78619_2_ + var29), (double)p_78619_3_ + var21, (double)p_78619_4_ + 0.25D, var13, var19);
         var5.func_78374_a((double)((float)p_78619_2_ + var28), (double)p_78619_3_ + var21, (double)p_78619_4_ + 0.25D, var13, var17);
      }

      if(var25 || var26 && !var24 && !var23) {
         var5.func_78374_a((double)((float)p_78619_2_ + var28), (double)p_78619_3_ + var21, (double)p_78619_4_ + 0.5D, var13, var17);
         var5.func_78374_a((double)((float)p_78619_2_ + var29), (double)p_78619_3_ + var21, (double)p_78619_4_ + 0.5D, var13, var19);
         var5.func_78374_a((double)((float)p_78619_2_ + var29), (double)p_78619_3_ + var21, (double)p_78619_4_ + 0.25D, var15, var19);
         var5.func_78374_a((double)((float)p_78619_2_ + var28), (double)p_78619_3_ + var21, (double)p_78619_4_ + 0.25D, var15, var17);
         var5.func_78374_a((double)((float)p_78619_2_ + var28), (double)p_78619_3_ + var21, (double)p_78619_4_ + 0.25D, var15, var17);
         var5.func_78374_a((double)((float)p_78619_2_ + var29), (double)p_78619_3_ + var21, (double)p_78619_4_ + 0.25D, var15, var19);
         var5.func_78374_a((double)((float)p_78619_2_ + var29), (double)p_78619_3_ + var21, (double)p_78619_4_ + 0.5D, var13, var19);
         var5.func_78374_a((double)((float)p_78619_2_ + var28), (double)p_78619_3_ + var21, (double)p_78619_4_ + 0.5D, var13, var17);
      }

      if(var26 || var25 && !var24 && !var23) {
         var5.func_78374_a((double)((float)p_78619_2_ + var28), (double)p_78619_3_ + var21, (double)p_78619_4_ + 0.75D, var13, var17);
         var5.func_78374_a((double)((float)p_78619_2_ + var29), (double)p_78619_3_ + var21, (double)p_78619_4_ + 0.75D, var13, var19);
         var5.func_78374_a((double)((float)p_78619_2_ + var29), (double)p_78619_3_ + var21, (double)p_78619_4_ + 0.5D, var15, var19);
         var5.func_78374_a((double)((float)p_78619_2_ + var28), (double)p_78619_3_ + var21, (double)p_78619_4_ + 0.5D, var15, var17);
         var5.func_78374_a((double)((float)p_78619_2_ + var28), (double)p_78619_3_ + var21, (double)p_78619_4_ + 0.5D, var15, var17);
         var5.func_78374_a((double)((float)p_78619_2_ + var29), (double)p_78619_3_ + var21, (double)p_78619_4_ + 0.5D, var15, var19);
         var5.func_78374_a((double)((float)p_78619_2_ + var29), (double)p_78619_3_ + var21, (double)p_78619_4_ + 0.75D, var13, var19);
         var5.func_78374_a((double)((float)p_78619_2_ + var28), (double)p_78619_3_ + var21, (double)p_78619_4_ + 0.75D, var13, var17);
      }

      if(var26) {
         var5.func_78374_a((double)((float)p_78619_2_ + var28), (double)p_78619_3_ + var21, (double)(p_78619_4_ + 1), var13, var17);
         var5.func_78374_a((double)((float)p_78619_2_ + var29), (double)p_78619_3_ + var21, (double)(p_78619_4_ + 1), var13, var19);
         var5.func_78374_a((double)((float)p_78619_2_ + var29), (double)p_78619_3_ + var21, (double)p_78619_4_ + 0.75D, var15, var19);
         var5.func_78374_a((double)((float)p_78619_2_ + var28), (double)p_78619_3_ + var21, (double)p_78619_4_ + 0.75D, var15, var17);
         var5.func_78374_a((double)((float)p_78619_2_ + var28), (double)p_78619_3_ + var21, (double)p_78619_4_ + 0.75D, var15, var17);
         var5.func_78374_a((double)((float)p_78619_2_ + var29), (double)p_78619_3_ + var21, (double)p_78619_4_ + 0.75D, var15, var19);
         var5.func_78374_a((double)((float)p_78619_2_ + var29), (double)p_78619_3_ + var21, (double)(p_78619_4_ + 1), var13, var19);
         var5.func_78374_a((double)((float)p_78619_2_ + var28), (double)p_78619_3_ + var21, (double)(p_78619_4_ + 1), var13, var17);
      }

      if(var23) {
         var5.func_78374_a((double)p_78619_2_, (double)p_78619_3_ + var21, (double)((float)p_78619_4_ + var29), var13, var19);
         var5.func_78374_a((double)p_78619_2_ + 0.25D, (double)p_78619_3_ + var21, (double)((float)p_78619_4_ + var29), var15, var19);
         var5.func_78374_a((double)p_78619_2_ + 0.25D, (double)p_78619_3_ + var21, (double)((float)p_78619_4_ + var28), var15, var17);
         var5.func_78374_a((double)p_78619_2_, (double)p_78619_3_ + var21, (double)((float)p_78619_4_ + var28), var13, var17);
         var5.func_78374_a((double)p_78619_2_, (double)p_78619_3_ + var21, (double)((float)p_78619_4_ + var28), var13, var17);
         var5.func_78374_a((double)p_78619_2_ + 0.25D, (double)p_78619_3_ + var21, (double)((float)p_78619_4_ + var28), var15, var17);
         var5.func_78374_a((double)p_78619_2_ + 0.25D, (double)p_78619_3_ + var21, (double)((float)p_78619_4_ + var29), var15, var19);
         var5.func_78374_a((double)p_78619_2_, (double)p_78619_3_ + var21, (double)((float)p_78619_4_ + var29), var13, var19);
      }

      if(var23 || var24 && !var25 && !var26) {
         var5.func_78374_a((double)p_78619_2_ + 0.25D, (double)p_78619_3_ + var21, (double)((float)p_78619_4_ + var29), var13, var19);
         var5.func_78374_a((double)p_78619_2_ + 0.5D, (double)p_78619_3_ + var21, (double)((float)p_78619_4_ + var29), var15, var19);
         var5.func_78374_a((double)p_78619_2_ + 0.5D, (double)p_78619_3_ + var21, (double)((float)p_78619_4_ + var28), var15, var17);
         var5.func_78374_a((double)p_78619_2_ + 0.25D, (double)p_78619_3_ + var21, (double)((float)p_78619_4_ + var28), var13, var17);
         var5.func_78374_a((double)p_78619_2_ + 0.25D, (double)p_78619_3_ + var21, (double)((float)p_78619_4_ + var28), var13, var17);
         var5.func_78374_a((double)p_78619_2_ + 0.5D, (double)p_78619_3_ + var21, (double)((float)p_78619_4_ + var28), var15, var17);
         var5.func_78374_a((double)p_78619_2_ + 0.5D, (double)p_78619_3_ + var21, (double)((float)p_78619_4_ + var29), var15, var19);
         var5.func_78374_a((double)p_78619_2_ + 0.25D, (double)p_78619_3_ + var21, (double)((float)p_78619_4_ + var29), var13, var19);
      }

      if(var24 || var23 && !var25 && !var26) {
         var5.func_78374_a((double)p_78619_2_ + 0.5D, (double)p_78619_3_ + var21, (double)((float)p_78619_4_ + var29), var13, var19);
         var5.func_78374_a((double)p_78619_2_ + 0.75D, (double)p_78619_3_ + var21, (double)((float)p_78619_4_ + var29), var15, var19);
         var5.func_78374_a((double)p_78619_2_ + 0.75D, (double)p_78619_3_ + var21, (double)((float)p_78619_4_ + var28), var15, var17);
         var5.func_78374_a((double)p_78619_2_ + 0.5D, (double)p_78619_3_ + var21, (double)((float)p_78619_4_ + var28), var13, var17);
         var5.func_78374_a((double)p_78619_2_ + 0.5D, (double)p_78619_3_ + var21, (double)((float)p_78619_4_ + var28), var13, var17);
         var5.func_78374_a((double)p_78619_2_ + 0.75D, (double)p_78619_3_ + var21, (double)((float)p_78619_4_ + var28), var15, var17);
         var5.func_78374_a((double)p_78619_2_ + 0.75D, (double)p_78619_3_ + var21, (double)((float)p_78619_4_ + var29), var15, var19);
         var5.func_78374_a((double)p_78619_2_ + 0.5D, (double)p_78619_3_ + var21, (double)((float)p_78619_4_ + var29), var13, var19);
      }

      if(var24) {
         var5.func_78374_a((double)p_78619_2_ + 0.75D, (double)p_78619_3_ + var21, (double)((float)p_78619_4_ + var29), var13, var19);
         var5.func_78374_a((double)(p_78619_2_ + 1), (double)p_78619_3_ + var21, (double)((float)p_78619_4_ + var29), var15, var19);
         var5.func_78374_a((double)(p_78619_2_ + 1), (double)p_78619_3_ + var21, (double)((float)p_78619_4_ + var28), var15, var17);
         var5.func_78374_a((double)p_78619_2_ + 0.75D, (double)p_78619_3_ + var21, (double)((float)p_78619_4_ + var28), var13, var17);
         var5.func_78374_a((double)p_78619_2_ + 0.75D, (double)p_78619_3_ + var21, (double)((float)p_78619_4_ + var28), var13, var17);
         var5.func_78374_a((double)(p_78619_2_ + 1), (double)p_78619_3_ + var21, (double)((float)p_78619_4_ + var28), var15, var17);
         var5.func_78374_a((double)(p_78619_2_ + 1), (double)p_78619_3_ + var21, (double)((float)p_78619_4_ + var29), var15, var19);
         var5.func_78374_a((double)p_78619_2_ + 0.75D, (double)p_78619_3_ + var21, (double)((float)p_78619_4_ + var29), var13, var19);
      }

      return true;
   }

   public boolean func_78590_h(Block p_78590_1_, int p_78590_2_, int p_78590_3_, int p_78590_4_) {
      Tessellator var5 = Tessellator.field_78398_a;
      int var6 = p_78590_1_.func_71851_a(0);
      if(this.field_78664_d >= 0) {
         var6 = this.field_78664_d;
      }

      var5.func_78386_a(1.0F, 1.0F, 1.0F);
      var5.func_78380_c(p_78590_1_.func_71874_e(this.field_78669_a, p_78590_2_, p_78590_3_, p_78590_4_));
      int var7 = (var6 & 15) << 4;
      int var8 = var6 & 240;
      double var9 = (double)((float)var7 / 256.0F);
      double var11 = (double)(((float)var7 + 15.99F) / 256.0F);
      double var13 = (double)((float)var8 / 256.0F);
      double var15 = (double)(((float)var8 + 15.99F) / 256.0F);
      float var17 = 1.4F;
      double var20;
      double var22;
      double var24;
      double var26;
      double var28;
      double var30;
      double var32;
      if(!this.field_78669_a.func_72797_t(p_78590_2_, p_78590_3_ - 1, p_78590_4_) && !Block.field_72067_ar.func_72256_d(this.field_78669_a, p_78590_2_, p_78590_3_ - 1, p_78590_4_)) {
         float var36 = 0.2F;
         float var19 = 0.0625F;
         if((p_78590_2_ + p_78590_3_ + p_78590_4_ & 1) == 1) {
            var9 = (double)((float)var7 / 256.0F);
            var11 = (double)(((float)var7 + 15.99F) / 256.0F);
            var13 = (double)((float)(var8 + 16) / 256.0F);
            var15 = (double)(((float)var8 + 15.99F + 16.0F) / 256.0F);
         }

         if((p_78590_2_ / 2 + p_78590_3_ / 2 + p_78590_4_ / 2 & 1) == 1) {
            var20 = var11;
            var11 = var9;
            var9 = var20;
         }

         if(Block.field_72067_ar.func_72256_d(this.field_78669_a, p_78590_2_ - 1, p_78590_3_, p_78590_4_)) {
            var5.func_78374_a((double)((float)p_78590_2_ + var36), (double)((float)p_78590_3_ + var17 + var19), (double)(p_78590_4_ + 1), var11, var13);
            var5.func_78374_a((double)(p_78590_2_ + 0), (double)((float)(p_78590_3_ + 0) + var19), (double)(p_78590_4_ + 1), var11, var15);
            var5.func_78374_a((double)(p_78590_2_ + 0), (double)((float)(p_78590_3_ + 0) + var19), (double)(p_78590_4_ + 0), var9, var15);
            var5.func_78374_a((double)((float)p_78590_2_ + var36), (double)((float)p_78590_3_ + var17 + var19), (double)(p_78590_4_ + 0), var9, var13);
            var5.func_78374_a((double)((float)p_78590_2_ + var36), (double)((float)p_78590_3_ + var17 + var19), (double)(p_78590_4_ + 0), var9, var13);
            var5.func_78374_a((double)(p_78590_2_ + 0), (double)((float)(p_78590_3_ + 0) + var19), (double)(p_78590_4_ + 0), var9, var15);
            var5.func_78374_a((double)(p_78590_2_ + 0), (double)((float)(p_78590_3_ + 0) + var19), (double)(p_78590_4_ + 1), var11, var15);
            var5.func_78374_a((double)((float)p_78590_2_ + var36), (double)((float)p_78590_3_ + var17 + var19), (double)(p_78590_4_ + 1), var11, var13);
         }

         if(Block.field_72067_ar.func_72256_d(this.field_78669_a, p_78590_2_ + 1, p_78590_3_, p_78590_4_)) {
            var5.func_78374_a((double)((float)(p_78590_2_ + 1) - var36), (double)((float)p_78590_3_ + var17 + var19), (double)(p_78590_4_ + 0), var9, var13);
            var5.func_78374_a((double)(p_78590_2_ + 1 - 0), (double)((float)(p_78590_3_ + 0) + var19), (double)(p_78590_4_ + 0), var9, var15);
            var5.func_78374_a((double)(p_78590_2_ + 1 - 0), (double)((float)(p_78590_3_ + 0) + var19), (double)(p_78590_4_ + 1), var11, var15);
            var5.func_78374_a((double)((float)(p_78590_2_ + 1) - var36), (double)((float)p_78590_3_ + var17 + var19), (double)(p_78590_4_ + 1), var11, var13);
            var5.func_78374_a((double)((float)(p_78590_2_ + 1) - var36), (double)((float)p_78590_3_ + var17 + var19), (double)(p_78590_4_ + 1), var11, var13);
            var5.func_78374_a((double)(p_78590_2_ + 1 - 0), (double)((float)(p_78590_3_ + 0) + var19), (double)(p_78590_4_ + 1), var11, var15);
            var5.func_78374_a((double)(p_78590_2_ + 1 - 0), (double)((float)(p_78590_3_ + 0) + var19), (double)(p_78590_4_ + 0), var9, var15);
            var5.func_78374_a((double)((float)(p_78590_2_ + 1) - var36), (double)((float)p_78590_3_ + var17 + var19), (double)(p_78590_4_ + 0), var9, var13);
         }

         if(Block.field_72067_ar.func_72256_d(this.field_78669_a, p_78590_2_, p_78590_3_, p_78590_4_ - 1)) {
            var5.func_78374_a((double)(p_78590_2_ + 0), (double)((float)p_78590_3_ + var17 + var19), (double)((float)p_78590_4_ + var36), var11, var13);
            var5.func_78374_a((double)(p_78590_2_ + 0), (double)((float)(p_78590_3_ + 0) + var19), (double)(p_78590_4_ + 0), var11, var15);
            var5.func_78374_a((double)(p_78590_2_ + 1), (double)((float)(p_78590_3_ + 0) + var19), (double)(p_78590_4_ + 0), var9, var15);
            var5.func_78374_a((double)(p_78590_2_ + 1), (double)((float)p_78590_3_ + var17 + var19), (double)((float)p_78590_4_ + var36), var9, var13);
            var5.func_78374_a((double)(p_78590_2_ + 1), (double)((float)p_78590_3_ + var17 + var19), (double)((float)p_78590_4_ + var36), var9, var13);
            var5.func_78374_a((double)(p_78590_2_ + 1), (double)((float)(p_78590_3_ + 0) + var19), (double)(p_78590_4_ + 0), var9, var15);
            var5.func_78374_a((double)(p_78590_2_ + 0), (double)((float)(p_78590_3_ + 0) + var19), (double)(p_78590_4_ + 0), var11, var15);
            var5.func_78374_a((double)(p_78590_2_ + 0), (double)((float)p_78590_3_ + var17 + var19), (double)((float)p_78590_4_ + var36), var11, var13);
         }

         if(Block.field_72067_ar.func_72256_d(this.field_78669_a, p_78590_2_, p_78590_3_, p_78590_4_ + 1)) {
            var5.func_78374_a((double)(p_78590_2_ + 1), (double)((float)p_78590_3_ + var17 + var19), (double)((float)(p_78590_4_ + 1) - var36), var9, var13);
            var5.func_78374_a((double)(p_78590_2_ + 1), (double)((float)(p_78590_3_ + 0) + var19), (double)(p_78590_4_ + 1 - 0), var9, var15);
            var5.func_78374_a((double)(p_78590_2_ + 0), (double)((float)(p_78590_3_ + 0) + var19), (double)(p_78590_4_ + 1 - 0), var11, var15);
            var5.func_78374_a((double)(p_78590_2_ + 0), (double)((float)p_78590_3_ + var17 + var19), (double)((float)(p_78590_4_ + 1) - var36), var11, var13);
            var5.func_78374_a((double)(p_78590_2_ + 0), (double)((float)p_78590_3_ + var17 + var19), (double)((float)(p_78590_4_ + 1) - var36), var11, var13);
            var5.func_78374_a((double)(p_78590_2_ + 0), (double)((float)(p_78590_3_ + 0) + var19), (double)(p_78590_4_ + 1 - 0), var11, var15);
            var5.func_78374_a((double)(p_78590_2_ + 1), (double)((float)(p_78590_3_ + 0) + var19), (double)(p_78590_4_ + 1 - 0), var9, var15);
            var5.func_78374_a((double)(p_78590_2_ + 1), (double)((float)p_78590_3_ + var17 + var19), (double)((float)(p_78590_4_ + 1) - var36), var9, var13);
         }

         if(Block.field_72067_ar.func_72256_d(this.field_78669_a, p_78590_2_, p_78590_3_ + 1, p_78590_4_)) {
            var20 = (double)p_78590_2_ + 0.5D + 0.5D;
            var22 = (double)p_78590_2_ + 0.5D - 0.5D;
            var24 = (double)p_78590_4_ + 0.5D + 0.5D;
            var26 = (double)p_78590_4_ + 0.5D - 0.5D;
            var28 = (double)p_78590_2_ + 0.5D - 0.5D;
            var30 = (double)p_78590_2_ + 0.5D + 0.5D;
            var32 = (double)p_78590_4_ + 0.5D - 0.5D;
            double var34 = (double)p_78590_4_ + 0.5D + 0.5D;
            var9 = (double)((float)var7 / 256.0F);
            var11 = (double)(((float)var7 + 15.99F) / 256.0F);
            var13 = (double)((float)var8 / 256.0F);
            var15 = (double)(((float)var8 + 15.99F) / 256.0F);
            ++p_78590_3_;
            var17 = -0.2F;
            if((p_78590_2_ + p_78590_3_ + p_78590_4_ & 1) == 0) {
               var5.func_78374_a(var28, (double)((float)p_78590_3_ + var17), (double)(p_78590_4_ + 0), var11, var13);
               var5.func_78374_a(var20, (double)(p_78590_3_ + 0), (double)(p_78590_4_ + 0), var11, var15);
               var5.func_78374_a(var20, (double)(p_78590_3_ + 0), (double)(p_78590_4_ + 1), var9, var15);
               var5.func_78374_a(var28, (double)((float)p_78590_3_ + var17), (double)(p_78590_4_ + 1), var9, var13);
               var9 = (double)((float)var7 / 256.0F);
               var11 = (double)(((float)var7 + 15.99F) / 256.0F);
               var13 = (double)((float)(var8 + 16) / 256.0F);
               var15 = (double)(((float)var8 + 15.99F + 16.0F) / 256.0F);
               var5.func_78374_a(var30, (double)((float)p_78590_3_ + var17), (double)(p_78590_4_ + 1), var11, var13);
               var5.func_78374_a(var22, (double)(p_78590_3_ + 0), (double)(p_78590_4_ + 1), var11, var15);
               var5.func_78374_a(var22, (double)(p_78590_3_ + 0), (double)(p_78590_4_ + 0), var9, var15);
               var5.func_78374_a(var30, (double)((float)p_78590_3_ + var17), (double)(p_78590_4_ + 0), var9, var13);
            } else {
               var5.func_78374_a((double)(p_78590_2_ + 0), (double)((float)p_78590_3_ + var17), var34, var11, var13);
               var5.func_78374_a((double)(p_78590_2_ + 0), (double)(p_78590_3_ + 0), var26, var11, var15);
               var5.func_78374_a((double)(p_78590_2_ + 1), (double)(p_78590_3_ + 0), var26, var9, var15);
               var5.func_78374_a((double)(p_78590_2_ + 1), (double)((float)p_78590_3_ + var17), var34, var9, var13);
               var9 = (double)((float)var7 / 256.0F);
               var11 = (double)(((float)var7 + 15.99F) / 256.0F);
               var13 = (double)((float)(var8 + 16) / 256.0F);
               var15 = (double)(((float)var8 + 15.99F + 16.0F) / 256.0F);
               var5.func_78374_a((double)(p_78590_2_ + 1), (double)((float)p_78590_3_ + var17), var32, var11, var13);
               var5.func_78374_a((double)(p_78590_2_ + 1), (double)(p_78590_3_ + 0), var24, var11, var15);
               var5.func_78374_a((double)(p_78590_2_ + 0), (double)(p_78590_3_ + 0), var24, var9, var15);
               var5.func_78374_a((double)(p_78590_2_ + 0), (double)((float)p_78590_3_ + var17), var32, var9, var13);
            }
         }
      } else {
         double var18 = (double)p_78590_2_ + 0.5D + 0.2D;
         var20 = (double)p_78590_2_ + 0.5D - 0.2D;
         var22 = (double)p_78590_4_ + 0.5D + 0.2D;
         var24 = (double)p_78590_4_ + 0.5D - 0.2D;
         var26 = (double)p_78590_2_ + 0.5D - 0.3D;
         var28 = (double)p_78590_2_ + 0.5D + 0.3D;
         var30 = (double)p_78590_4_ + 0.5D - 0.3D;
         var32 = (double)p_78590_4_ + 0.5D + 0.3D;
         var5.func_78374_a(var26, (double)((float)p_78590_3_ + var17), (double)(p_78590_4_ + 1), var11, var13);
         var5.func_78374_a(var18, (double)(p_78590_3_ + 0), (double)(p_78590_4_ + 1), var11, var15);
         var5.func_78374_a(var18, (double)(p_78590_3_ + 0), (double)(p_78590_4_ + 0), var9, var15);
         var5.func_78374_a(var26, (double)((float)p_78590_3_ + var17), (double)(p_78590_4_ + 0), var9, var13);
         var5.func_78374_a(var28, (double)((float)p_78590_3_ + var17), (double)(p_78590_4_ + 0), var11, var13);
         var5.func_78374_a(var20, (double)(p_78590_3_ + 0), (double)(p_78590_4_ + 0), var11, var15);
         var5.func_78374_a(var20, (double)(p_78590_3_ + 0), (double)(p_78590_4_ + 1), var9, var15);
         var5.func_78374_a(var28, (double)((float)p_78590_3_ + var17), (double)(p_78590_4_ + 1), var9, var13);
         var9 = (double)((float)var7 / 256.0F);
         var11 = (double)(((float)var7 + 15.99F) / 256.0F);
         var13 = (double)((float)(var8 + 16) / 256.0F);
         var15 = (double)(((float)var8 + 15.99F + 16.0F) / 256.0F);
         var5.func_78374_a((double)(p_78590_2_ + 1), (double)((float)p_78590_3_ + var17), var32, var11, var13);
         var5.func_78374_a((double)(p_78590_2_ + 1), (double)(p_78590_3_ + 0), var24, var11, var15);
         var5.func_78374_a((double)(p_78590_2_ + 0), (double)(p_78590_3_ + 0), var24, var9, var15);
         var5.func_78374_a((double)(p_78590_2_ + 0), (double)((float)p_78590_3_ + var17), var32, var9, var13);
         var5.func_78374_a((double)(p_78590_2_ + 0), (double)((float)p_78590_3_ + var17), var30, var11, var13);
         var5.func_78374_a((double)(p_78590_2_ + 0), (double)(p_78590_3_ + 0), var22, var11, var15);
         var5.func_78374_a((double)(p_78590_2_ + 1), (double)(p_78590_3_ + 0), var22, var9, var15);
         var5.func_78374_a((double)(p_78590_2_ + 1), (double)((float)p_78590_3_ + var17), var30, var9, var13);
         var18 = (double)p_78590_2_ + 0.5D - 0.5D;
         var20 = (double)p_78590_2_ + 0.5D + 0.5D;
         var22 = (double)p_78590_4_ + 0.5D - 0.5D;
         var24 = (double)p_78590_4_ + 0.5D + 0.5D;
         var26 = (double)p_78590_2_ + 0.5D - 0.4D;
         var28 = (double)p_78590_2_ + 0.5D + 0.4D;
         var30 = (double)p_78590_4_ + 0.5D - 0.4D;
         var32 = (double)p_78590_4_ + 0.5D + 0.4D;
         var5.func_78374_a(var26, (double)((float)p_78590_3_ + var17), (double)(p_78590_4_ + 0), var9, var13);
         var5.func_78374_a(var18, (double)(p_78590_3_ + 0), (double)(p_78590_4_ + 0), var9, var15);
         var5.func_78374_a(var18, (double)(p_78590_3_ + 0), (double)(p_78590_4_ + 1), var11, var15);
         var5.func_78374_a(var26, (double)((float)p_78590_3_ + var17), (double)(p_78590_4_ + 1), var11, var13);
         var5.func_78374_a(var28, (double)((float)p_78590_3_ + var17), (double)(p_78590_4_ + 1), var9, var13);
         var5.func_78374_a(var20, (double)(p_78590_3_ + 0), (double)(p_78590_4_ + 1), var9, var15);
         var5.func_78374_a(var20, (double)(p_78590_3_ + 0), (double)(p_78590_4_ + 0), var11, var15);
         var5.func_78374_a(var28, (double)((float)p_78590_3_ + var17), (double)(p_78590_4_ + 0), var11, var13);
         var9 = (double)((float)var7 / 256.0F);
         var11 = (double)(((float)var7 + 15.99F) / 256.0F);
         var13 = (double)((float)var8 / 256.0F);
         var15 = (double)(((float)var8 + 15.99F) / 256.0F);
         var5.func_78374_a((double)(p_78590_2_ + 0), (double)((float)p_78590_3_ + var17), var32, var9, var13);
         var5.func_78374_a((double)(p_78590_2_ + 0), (double)(p_78590_3_ + 0), var24, var9, var15);
         var5.func_78374_a((double)(p_78590_2_ + 1), (double)(p_78590_3_ + 0), var24, var11, var15);
         var5.func_78374_a((double)(p_78590_2_ + 1), (double)((float)p_78590_3_ + var17), var32, var11, var13);
         var5.func_78374_a((double)(p_78590_2_ + 1), (double)((float)p_78590_3_ + var17), var30, var9, var13);
         var5.func_78374_a((double)(p_78590_2_ + 1), (double)(p_78590_3_ + 0), var22, var9, var15);
         var5.func_78374_a((double)(p_78590_2_ + 0), (double)(p_78590_3_ + 0), var22, var11, var15);
         var5.func_78374_a((double)(p_78590_2_ + 0), (double)((float)p_78590_3_ + var17), var30, var11, var13);
      }

      return true;
   }

   public boolean func_78589_i(Block p_78589_1_, int p_78589_2_, int p_78589_3_, int p_78589_4_) {
      Tessellator var5 = Tessellator.field_78398_a;
      int var6 = this.field_78669_a.func_72805_g(p_78589_2_, p_78589_3_, p_78589_4_);
      int var7 = p_78589_1_.func_71858_a(1, var6);
      if(this.field_78664_d >= 0) {
         var7 = this.field_78664_d;
      }

      var5.func_78380_c(p_78589_1_.func_71874_e(this.field_78669_a, p_78589_2_, p_78589_3_, p_78589_4_));
      float var8 = 1.0F;
      float var9 = (float)var6 / 15.0F;
      float var10 = var9 * 0.6F + 0.4F;
      if(var6 == 0) {
         var10 = 0.3F;
      }

      float var11 = var9 * var9 * 0.7F - 0.5F;
      float var12 = var9 * var9 * 0.6F - 0.7F;
      if(var11 < 0.0F) {
         var11 = 0.0F;
      }

      if(var12 < 0.0F) {
         var12 = 0.0F;
      }

      var5.func_78386_a(var10, var11, var12);
      int var13 = (var7 & 15) << 4;
      int var14 = var7 & 240;
      double var15 = (double)((float)var13 / 256.0F);
      double var17 = (double)(((float)var13 + 15.99F) / 256.0F);
      double var19 = (double)((float)var14 / 256.0F);
      double var21 = (double)(((float)var14 + 15.99F) / 256.0F);
      boolean var29 = BlockRedstoneWire.func_72173_e(this.field_78669_a, p_78589_2_ - 1, p_78589_3_, p_78589_4_, 1) || !this.field_78669_a.func_72809_s(p_78589_2_ - 1, p_78589_3_, p_78589_4_) && BlockRedstoneWire.func_72173_e(this.field_78669_a, p_78589_2_ - 1, p_78589_3_ - 1, p_78589_4_, -1);
      boolean var30 = BlockRedstoneWire.func_72173_e(this.field_78669_a, p_78589_2_ + 1, p_78589_3_, p_78589_4_, 3) || !this.field_78669_a.func_72809_s(p_78589_2_ + 1, p_78589_3_, p_78589_4_) && BlockRedstoneWire.func_72173_e(this.field_78669_a, p_78589_2_ + 1, p_78589_3_ - 1, p_78589_4_, -1);
      boolean var31 = BlockRedstoneWire.func_72173_e(this.field_78669_a, p_78589_2_, p_78589_3_, p_78589_4_ - 1, 2) || !this.field_78669_a.func_72809_s(p_78589_2_, p_78589_3_, p_78589_4_ - 1) && BlockRedstoneWire.func_72173_e(this.field_78669_a, p_78589_2_, p_78589_3_ - 1, p_78589_4_ - 1, -1);
      boolean var32 = BlockRedstoneWire.func_72173_e(this.field_78669_a, p_78589_2_, p_78589_3_, p_78589_4_ + 1, 0) || !this.field_78669_a.func_72809_s(p_78589_2_, p_78589_3_, p_78589_4_ + 1) && BlockRedstoneWire.func_72173_e(this.field_78669_a, p_78589_2_, p_78589_3_ - 1, p_78589_4_ + 1, -1);
      if(!this.field_78669_a.func_72809_s(p_78589_2_, p_78589_3_ + 1, p_78589_4_)) {
         if(this.field_78669_a.func_72809_s(p_78589_2_ - 1, p_78589_3_, p_78589_4_) && BlockRedstoneWire.func_72173_e(this.field_78669_a, p_78589_2_ - 1, p_78589_3_ + 1, p_78589_4_, -1)) {
            var29 = true;
         }

         if(this.field_78669_a.func_72809_s(p_78589_2_ + 1, p_78589_3_, p_78589_4_) && BlockRedstoneWire.func_72173_e(this.field_78669_a, p_78589_2_ + 1, p_78589_3_ + 1, p_78589_4_, -1)) {
            var30 = true;
         }

         if(this.field_78669_a.func_72809_s(p_78589_2_, p_78589_3_, p_78589_4_ - 1) && BlockRedstoneWire.func_72173_e(this.field_78669_a, p_78589_2_, p_78589_3_ + 1, p_78589_4_ - 1, -1)) {
            var31 = true;
         }

         if(this.field_78669_a.func_72809_s(p_78589_2_, p_78589_3_, p_78589_4_ + 1) && BlockRedstoneWire.func_72173_e(this.field_78669_a, p_78589_2_, p_78589_3_ + 1, p_78589_4_ + 1, -1)) {
            var32 = true;
         }
      }

      float var34 = (float)(p_78589_2_ + 0);
      float var35 = (float)(p_78589_2_ + 1);
      float var36 = (float)(p_78589_4_ + 0);
      float var37 = (float)(p_78589_4_ + 1);
      byte var38 = 0;
      if((var29 || var30) && !var31 && !var32) {
         var38 = 1;
      }

      if((var31 || var32) && !var30 && !var29) {
         var38 = 2;
      }

      if(var38 != 0) {
         var15 = (double)((float)(var13 + 16) / 256.0F);
         var17 = (double)(((float)(var13 + 16) + 15.99F) / 256.0F);
         var19 = (double)((float)var14 / 256.0F);
         var21 = (double)(((float)var14 + 15.99F) / 256.0F);
      }

      if(var38 == 0) {
         if(!var29) {
            var34 += 0.3125F;
         }

         if(!var29) {
            var15 += 0.01953125D;
         }

         if(!var30) {
            var35 -= 0.3125F;
         }

         if(!var30) {
            var17 -= 0.01953125D;
         }

         if(!var31) {
            var36 += 0.3125F;
         }

         if(!var31) {
            var19 += 0.01953125D;
         }

         if(!var32) {
            var37 -= 0.3125F;
         }

         if(!var32) {
            var21 -= 0.01953125D;
         }

         var5.func_78374_a((double)var35, (double)p_78589_3_ + 0.015625D, (double)var37, var17, var21);
         var5.func_78374_a((double)var35, (double)p_78589_3_ + 0.015625D, (double)var36, var17, var19);
         var5.func_78374_a((double)var34, (double)p_78589_3_ + 0.015625D, (double)var36, var15, var19);
         var5.func_78374_a((double)var34, (double)p_78589_3_ + 0.015625D, (double)var37, var15, var21);
         var5.func_78386_a(var8, var8, var8);
         var5.func_78374_a((double)var35, (double)p_78589_3_ + 0.015625D, (double)var37, var17, var21 + 0.0625D);
         var5.func_78374_a((double)var35, (double)p_78589_3_ + 0.015625D, (double)var36, var17, var19 + 0.0625D);
         var5.func_78374_a((double)var34, (double)p_78589_3_ + 0.015625D, (double)var36, var15, var19 + 0.0625D);
         var5.func_78374_a((double)var34, (double)p_78589_3_ + 0.015625D, (double)var37, var15, var21 + 0.0625D);
      } else if(var38 == 1) {
         var5.func_78374_a((double)var35, (double)p_78589_3_ + 0.015625D, (double)var37, var17, var21);
         var5.func_78374_a((double)var35, (double)p_78589_3_ + 0.015625D, (double)var36, var17, var19);
         var5.func_78374_a((double)var34, (double)p_78589_3_ + 0.015625D, (double)var36, var15, var19);
         var5.func_78374_a((double)var34, (double)p_78589_3_ + 0.015625D, (double)var37, var15, var21);
         var5.func_78386_a(var8, var8, var8);
         var5.func_78374_a((double)var35, (double)p_78589_3_ + 0.015625D, (double)var37, var17, var21 + 0.0625D);
         var5.func_78374_a((double)var35, (double)p_78589_3_ + 0.015625D, (double)var36, var17, var19 + 0.0625D);
         var5.func_78374_a((double)var34, (double)p_78589_3_ + 0.015625D, (double)var36, var15, var19 + 0.0625D);
         var5.func_78374_a((double)var34, (double)p_78589_3_ + 0.015625D, (double)var37, var15, var21 + 0.0625D);
      } else if(var38 == 2) {
         var5.func_78374_a((double)var35, (double)p_78589_3_ + 0.015625D, (double)var37, var17, var21);
         var5.func_78374_a((double)var35, (double)p_78589_3_ + 0.015625D, (double)var36, var15, var21);
         var5.func_78374_a((double)var34, (double)p_78589_3_ + 0.015625D, (double)var36, var15, var19);
         var5.func_78374_a((double)var34, (double)p_78589_3_ + 0.015625D, (double)var37, var17, var19);
         var5.func_78386_a(var8, var8, var8);
         var5.func_78374_a((double)var35, (double)p_78589_3_ + 0.015625D, (double)var37, var17, var21 + 0.0625D);
         var5.func_78374_a((double)var35, (double)p_78589_3_ + 0.015625D, (double)var36, var15, var21 + 0.0625D);
         var5.func_78374_a((double)var34, (double)p_78589_3_ + 0.015625D, (double)var36, var15, var19 + 0.0625D);
         var5.func_78374_a((double)var34, (double)p_78589_3_ + 0.015625D, (double)var37, var17, var19 + 0.0625D);
      }

      if(!this.field_78669_a.func_72809_s(p_78589_2_, p_78589_3_ + 1, p_78589_4_)) {
         var15 = (double)((float)(var13 + 16) / 256.0F);
         var17 = (double)(((float)(var13 + 16) + 15.99F) / 256.0F);
         var19 = (double)((float)var14 / 256.0F);
         var21 = (double)(((float)var14 + 15.99F) / 256.0F);
         if(this.field_78669_a.func_72809_s(p_78589_2_ - 1, p_78589_3_, p_78589_4_) && this.field_78669_a.func_72798_a(p_78589_2_ - 1, p_78589_3_ + 1, p_78589_4_) == Block.field_72075_av.field_71990_ca) {
            var5.func_78386_a(var8 * var10, var8 * var11, var8 * var12);
            var5.func_78374_a((double)p_78589_2_ + 0.015625D, (double)((float)(p_78589_3_ + 1) + 0.021875F), (double)(p_78589_4_ + 1), var17, var19);
            var5.func_78374_a((double)p_78589_2_ + 0.015625D, (double)(p_78589_3_ + 0), (double)(p_78589_4_ + 1), var15, var19);
            var5.func_78374_a((double)p_78589_2_ + 0.015625D, (double)(p_78589_3_ + 0), (double)(p_78589_4_ + 0), var15, var21);
            var5.func_78374_a((double)p_78589_2_ + 0.015625D, (double)((float)(p_78589_3_ + 1) + 0.021875F), (double)(p_78589_4_ + 0), var17, var21);
            var5.func_78386_a(var8, var8, var8);
            var5.func_78374_a((double)p_78589_2_ + 0.015625D, (double)((float)(p_78589_3_ + 1) + 0.021875F), (double)(p_78589_4_ + 1), var17, var19 + 0.0625D);
            var5.func_78374_a((double)p_78589_2_ + 0.015625D, (double)(p_78589_3_ + 0), (double)(p_78589_4_ + 1), var15, var19 + 0.0625D);
            var5.func_78374_a((double)p_78589_2_ + 0.015625D, (double)(p_78589_3_ + 0), (double)(p_78589_4_ + 0), var15, var21 + 0.0625D);
            var5.func_78374_a((double)p_78589_2_ + 0.015625D, (double)((float)(p_78589_3_ + 1) + 0.021875F), (double)(p_78589_4_ + 0), var17, var21 + 0.0625D);
         }

         if(this.field_78669_a.func_72809_s(p_78589_2_ + 1, p_78589_3_, p_78589_4_) && this.field_78669_a.func_72798_a(p_78589_2_ + 1, p_78589_3_ + 1, p_78589_4_) == Block.field_72075_av.field_71990_ca) {
            var5.func_78386_a(var8 * var10, var8 * var11, var8 * var12);
            var5.func_78374_a((double)(p_78589_2_ + 1) - 0.015625D, (double)(p_78589_3_ + 0), (double)(p_78589_4_ + 1), var15, var21);
            var5.func_78374_a((double)(p_78589_2_ + 1) - 0.015625D, (double)((float)(p_78589_3_ + 1) + 0.021875F), (double)(p_78589_4_ + 1), var17, var21);
            var5.func_78374_a((double)(p_78589_2_ + 1) - 0.015625D, (double)((float)(p_78589_3_ + 1) + 0.021875F), (double)(p_78589_4_ + 0), var17, var19);
            var5.func_78374_a((double)(p_78589_2_ + 1) - 0.015625D, (double)(p_78589_3_ + 0), (double)(p_78589_4_ + 0), var15, var19);
            var5.func_78386_a(var8, var8, var8);
            var5.func_78374_a((double)(p_78589_2_ + 1) - 0.015625D, (double)(p_78589_3_ + 0), (double)(p_78589_4_ + 1), var15, var21 + 0.0625D);
            var5.func_78374_a((double)(p_78589_2_ + 1) - 0.015625D, (double)((float)(p_78589_3_ + 1) + 0.021875F), (double)(p_78589_4_ + 1), var17, var21 + 0.0625D);
            var5.func_78374_a((double)(p_78589_2_ + 1) - 0.015625D, (double)((float)(p_78589_3_ + 1) + 0.021875F), (double)(p_78589_4_ + 0), var17, var19 + 0.0625D);
            var5.func_78374_a((double)(p_78589_2_ + 1) - 0.015625D, (double)(p_78589_3_ + 0), (double)(p_78589_4_ + 0), var15, var19 + 0.0625D);
         }

         if(this.field_78669_a.func_72809_s(p_78589_2_, p_78589_3_, p_78589_4_ - 1) && this.field_78669_a.func_72798_a(p_78589_2_, p_78589_3_ + 1, p_78589_4_ - 1) == Block.field_72075_av.field_71990_ca) {
            var5.func_78386_a(var8 * var10, var8 * var11, var8 * var12);
            var5.func_78374_a((double)(p_78589_2_ + 1), (double)(p_78589_3_ + 0), (double)p_78589_4_ + 0.015625D, var15, var21);
            var5.func_78374_a((double)(p_78589_2_ + 1), (double)((float)(p_78589_3_ + 1) + 0.021875F), (double)p_78589_4_ + 0.015625D, var17, var21);
            var5.func_78374_a((double)(p_78589_2_ + 0), (double)((float)(p_78589_3_ + 1) + 0.021875F), (double)p_78589_4_ + 0.015625D, var17, var19);
            var5.func_78374_a((double)(p_78589_2_ + 0), (double)(p_78589_3_ + 0), (double)p_78589_4_ + 0.015625D, var15, var19);
            var5.func_78386_a(var8, var8, var8);
            var5.func_78374_a((double)(p_78589_2_ + 1), (double)(p_78589_3_ + 0), (double)p_78589_4_ + 0.015625D, var15, var21 + 0.0625D);
            var5.func_78374_a((double)(p_78589_2_ + 1), (double)((float)(p_78589_3_ + 1) + 0.021875F), (double)p_78589_4_ + 0.015625D, var17, var21 + 0.0625D);
            var5.func_78374_a((double)(p_78589_2_ + 0), (double)((float)(p_78589_3_ + 1) + 0.021875F), (double)p_78589_4_ + 0.015625D, var17, var19 + 0.0625D);
            var5.func_78374_a((double)(p_78589_2_ + 0), (double)(p_78589_3_ + 0), (double)p_78589_4_ + 0.015625D, var15, var19 + 0.0625D);
         }

         if(this.field_78669_a.func_72809_s(p_78589_2_, p_78589_3_, p_78589_4_ + 1) && this.field_78669_a.func_72798_a(p_78589_2_, p_78589_3_ + 1, p_78589_4_ + 1) == Block.field_72075_av.field_71990_ca) {
            var5.func_78386_a(var8 * var10, var8 * var11, var8 * var12);
            var5.func_78374_a((double)(p_78589_2_ + 1), (double)((float)(p_78589_3_ + 1) + 0.021875F), (double)(p_78589_4_ + 1) - 0.015625D, var17, var19);
            var5.func_78374_a((double)(p_78589_2_ + 1), (double)(p_78589_3_ + 0), (double)(p_78589_4_ + 1) - 0.015625D, var15, var19);
            var5.func_78374_a((double)(p_78589_2_ + 0), (double)(p_78589_3_ + 0), (double)(p_78589_4_ + 1) - 0.015625D, var15, var21);
            var5.func_78374_a((double)(p_78589_2_ + 0), (double)((float)(p_78589_3_ + 1) + 0.021875F), (double)(p_78589_4_ + 1) - 0.015625D, var17, var21);
            var5.func_78386_a(var8, var8, var8);
            var5.func_78374_a((double)(p_78589_2_ + 1), (double)((float)(p_78589_3_ + 1) + 0.021875F), (double)(p_78589_4_ + 1) - 0.015625D, var17, var19 + 0.0625D);
            var5.func_78374_a((double)(p_78589_2_ + 1), (double)(p_78589_3_ + 0), (double)(p_78589_4_ + 1) - 0.015625D, var15, var19 + 0.0625D);
            var5.func_78374_a((double)(p_78589_2_ + 0), (double)(p_78589_3_ + 0), (double)(p_78589_4_ + 1) - 0.015625D, var15, var21 + 0.0625D);
            var5.func_78374_a((double)(p_78589_2_ + 0), (double)((float)(p_78589_3_ + 1) + 0.021875F), (double)(p_78589_4_ + 1) - 0.015625D, var17, var21 + 0.0625D);
         }
      }

      return true;
   }

   public boolean func_78586_a(BlockRail p_78586_1_, int p_78586_2_, int p_78586_3_, int p_78586_4_) {
      Tessellator var5 = Tessellator.field_78398_a;
      int var6 = this.field_78669_a.func_72805_g(p_78586_2_, p_78586_3_, p_78586_4_);
      int var7 = p_78586_1_.func_71858_a(0, var6);
      if(this.field_78664_d >= 0) {
         var7 = this.field_78664_d;
      }

      if(p_78586_1_.func_72183_n()) {
         var6 &= 7;
      }

      var5.func_78380_c(p_78586_1_.func_71874_e(this.field_78669_a, p_78586_2_, p_78586_3_, p_78586_4_));
      var5.func_78386_a(1.0F, 1.0F, 1.0F);
      int var8 = (var7 & 15) << 4;
      int var9 = var7 & 240;
      double var10 = (double)((float)var8 / 256.0F);
      double var12 = (double)(((float)var8 + 15.99F) / 256.0F);
      double var14 = (double)((float)var9 / 256.0F);
      double var16 = (double)(((float)var9 + 15.99F) / 256.0F);
      double var18 = 0.0625D;
      double var20 = (double)(p_78586_2_ + 1);
      double var22 = (double)(p_78586_2_ + 1);
      double var24 = (double)(p_78586_2_ + 0);
      double var26 = (double)(p_78586_2_ + 0);
      double var28 = (double)(p_78586_4_ + 0);
      double var30 = (double)(p_78586_4_ + 1);
      double var32 = (double)(p_78586_4_ + 1);
      double var34 = (double)(p_78586_4_ + 0);
      double var36 = (double)p_78586_3_ + var18;
      double var38 = (double)p_78586_3_ + var18;
      double var40 = (double)p_78586_3_ + var18;
      double var42 = (double)p_78586_3_ + var18;
      if(var6 != 1 && var6 != 2 && var6 != 3 && var6 != 7) {
         if(var6 == 8) {
            var20 = var22 = (double)(p_78586_2_ + 0);
            var24 = var26 = (double)(p_78586_2_ + 1);
            var28 = var34 = (double)(p_78586_4_ + 1);
            var30 = var32 = (double)(p_78586_4_ + 0);
         } else if(var6 == 9) {
            var20 = var26 = (double)(p_78586_2_ + 0);
            var22 = var24 = (double)(p_78586_2_ + 1);
            var28 = var30 = (double)(p_78586_4_ + 0);
            var32 = var34 = (double)(p_78586_4_ + 1);
         }
      } else {
         var20 = var26 = (double)(p_78586_2_ + 1);
         var22 = var24 = (double)(p_78586_2_ + 0);
         var28 = var30 = (double)(p_78586_4_ + 1);
         var32 = var34 = (double)(p_78586_4_ + 0);
      }

      if(var6 != 2 && var6 != 4) {
         if(var6 == 3 || var6 == 5) {
            ++var38;
            ++var40;
         }
      } else {
         ++var36;
         ++var42;
      }

      var5.func_78374_a(var20, var36, var28, var12, var14);
      var5.func_78374_a(var22, var38, var30, var12, var16);
      var5.func_78374_a(var24, var40, var32, var10, var16);
      var5.func_78374_a(var26, var42, var34, var10, var14);
      var5.func_78374_a(var26, var42, var34, var10, var14);
      var5.func_78374_a(var24, var40, var32, var10, var16);
      var5.func_78374_a(var22, var38, var30, var12, var16);
      var5.func_78374_a(var20, var36, var28, var12, var14);
      return true;
   }

   public boolean func_78576_j(Block p_78576_1_, int p_78576_2_, int p_78576_3_, int p_78576_4_) {
      Tessellator var5 = Tessellator.field_78398_a;
      int var6 = p_78576_1_.func_71851_a(0);
      if(this.field_78664_d >= 0) {
         var6 = this.field_78664_d;
      }

      var5.func_78380_c(p_78576_1_.func_71874_e(this.field_78669_a, p_78576_2_, p_78576_3_, p_78576_4_));
      float var7 = 1.0F;
      var5.func_78386_a(var7, var7, var7);
      int var22 = (var6 & 15) << 4;
      int var8 = var6 & 240;
      double var9 = (double)((float)var22 / 256.0F);
      double var11 = (double)(((float)var22 + 15.99F) / 256.0F);
      double var13 = (double)((float)var8 / 256.0F);
      double var15 = (double)(((float)var8 + 15.99F) / 256.0F);
      int var17 = this.field_78669_a.func_72805_g(p_78576_2_, p_78576_3_, p_78576_4_);
      double var18 = 0.0D;
      double var20 = 0.05000000074505806D;
      if(var17 == 5) {
         var5.func_78374_a((double)p_78576_2_ + var20, (double)(p_78576_3_ + 1) + var18, (double)(p_78576_4_ + 1) + var18, var9, var13);
         var5.func_78374_a((double)p_78576_2_ + var20, (double)(p_78576_3_ + 0) - var18, (double)(p_78576_4_ + 1) + var18, var9, var15);
         var5.func_78374_a((double)p_78576_2_ + var20, (double)(p_78576_3_ + 0) - var18, (double)(p_78576_4_ + 0) - var18, var11, var15);
         var5.func_78374_a((double)p_78576_2_ + var20, (double)(p_78576_3_ + 1) + var18, (double)(p_78576_4_ + 0) - var18, var11, var13);
      }

      if(var17 == 4) {
         var5.func_78374_a((double)(p_78576_2_ + 1) - var20, (double)(p_78576_3_ + 0) - var18, (double)(p_78576_4_ + 1) + var18, var11, var15);
         var5.func_78374_a((double)(p_78576_2_ + 1) - var20, (double)(p_78576_3_ + 1) + var18, (double)(p_78576_4_ + 1) + var18, var11, var13);
         var5.func_78374_a((double)(p_78576_2_ + 1) - var20, (double)(p_78576_3_ + 1) + var18, (double)(p_78576_4_ + 0) - var18, var9, var13);
         var5.func_78374_a((double)(p_78576_2_ + 1) - var20, (double)(p_78576_3_ + 0) - var18, (double)(p_78576_4_ + 0) - var18, var9, var15);
      }

      if(var17 == 3) {
         var5.func_78374_a((double)(p_78576_2_ + 1) + var18, (double)(p_78576_3_ + 0) - var18, (double)p_78576_4_ + var20, var11, var15);
         var5.func_78374_a((double)(p_78576_2_ + 1) + var18, (double)(p_78576_3_ + 1) + var18, (double)p_78576_4_ + var20, var11, var13);
         var5.func_78374_a((double)(p_78576_2_ + 0) - var18, (double)(p_78576_3_ + 1) + var18, (double)p_78576_4_ + var20, var9, var13);
         var5.func_78374_a((double)(p_78576_2_ + 0) - var18, (double)(p_78576_3_ + 0) - var18, (double)p_78576_4_ + var20, var9, var15);
      }

      if(var17 == 2) {
         var5.func_78374_a((double)(p_78576_2_ + 1) + var18, (double)(p_78576_3_ + 1) + var18, (double)(p_78576_4_ + 1) - var20, var9, var13);
         var5.func_78374_a((double)(p_78576_2_ + 1) + var18, (double)(p_78576_3_ + 0) - var18, (double)(p_78576_4_ + 1) - var20, var9, var15);
         var5.func_78374_a((double)(p_78576_2_ + 0) - var18, (double)(p_78576_3_ + 0) - var18, (double)(p_78576_4_ + 1) - var20, var11, var15);
         var5.func_78374_a((double)(p_78576_2_ + 0) - var18, (double)(p_78576_3_ + 1) + var18, (double)(p_78576_4_ + 1) - var20, var11, var13);
      }

      return true;
   }

   public boolean func_78598_k(Block p_78598_1_, int p_78598_2_, int p_78598_3_, int p_78598_4_) {
      Tessellator var5 = Tessellator.field_78398_a;
      int var6 = p_78598_1_.func_71851_a(0);
      if(this.field_78664_d >= 0) {
         var6 = this.field_78664_d;
      }

      float var7 = 1.0F;
      var5.func_78380_c(p_78598_1_.func_71874_e(this.field_78669_a, p_78598_2_, p_78598_3_, p_78598_4_));
      int var8 = p_78598_1_.func_71920_b(this.field_78669_a, p_78598_2_, p_78598_3_, p_78598_4_);
      float var9 = (float)(var8 >> 16 & 255) / 255.0F;
      float var10 = (float)(var8 >> 8 & 255) / 255.0F;
      float var11 = (float)(var8 & 255) / 255.0F;
      var5.func_78386_a(var7 * var9, var7 * var10, var7 * var11);
      var8 = (var6 & 15) << 4;
      int var21 = var6 & 240;
      double var22 = (double)((float)var8 / 256.0F);
      double var12 = (double)(((float)var8 + 15.99F) / 256.0F);
      double var14 = (double)((float)var21 / 256.0F);
      double var16 = (double)(((float)var21 + 15.99F) / 256.0F);
      double var18 = 0.05000000074505806D;
      int var20 = this.field_78669_a.func_72805_g(p_78598_2_, p_78598_3_, p_78598_4_);
      if((var20 & 2) != 0) {
         var5.func_78374_a((double)p_78598_2_ + var18, (double)(p_78598_3_ + 1), (double)(p_78598_4_ + 1), var22, var14);
         var5.func_78374_a((double)p_78598_2_ + var18, (double)(p_78598_3_ + 0), (double)(p_78598_4_ + 1), var22, var16);
         var5.func_78374_a((double)p_78598_2_ + var18, (double)(p_78598_3_ + 0), (double)(p_78598_4_ + 0), var12, var16);
         var5.func_78374_a((double)p_78598_2_ + var18, (double)(p_78598_3_ + 1), (double)(p_78598_4_ + 0), var12, var14);
         var5.func_78374_a((double)p_78598_2_ + var18, (double)(p_78598_3_ + 1), (double)(p_78598_4_ + 0), var12, var14);
         var5.func_78374_a((double)p_78598_2_ + var18, (double)(p_78598_3_ + 0), (double)(p_78598_4_ + 0), var12, var16);
         var5.func_78374_a((double)p_78598_2_ + var18, (double)(p_78598_3_ + 0), (double)(p_78598_4_ + 1), var22, var16);
         var5.func_78374_a((double)p_78598_2_ + var18, (double)(p_78598_3_ + 1), (double)(p_78598_4_ + 1), var22, var14);
      }

      if((var20 & 8) != 0) {
         var5.func_78374_a((double)(p_78598_2_ + 1) - var18, (double)(p_78598_3_ + 0), (double)(p_78598_4_ + 1), var12, var16);
         var5.func_78374_a((double)(p_78598_2_ + 1) - var18, (double)(p_78598_3_ + 1), (double)(p_78598_4_ + 1), var12, var14);
         var5.func_78374_a((double)(p_78598_2_ + 1) - var18, (double)(p_78598_3_ + 1), (double)(p_78598_4_ + 0), var22, var14);
         var5.func_78374_a((double)(p_78598_2_ + 1) - var18, (double)(p_78598_3_ + 0), (double)(p_78598_4_ + 0), var22, var16);
         var5.func_78374_a((double)(p_78598_2_ + 1) - var18, (double)(p_78598_3_ + 0), (double)(p_78598_4_ + 0), var22, var16);
         var5.func_78374_a((double)(p_78598_2_ + 1) - var18, (double)(p_78598_3_ + 1), (double)(p_78598_4_ + 0), var22, var14);
         var5.func_78374_a((double)(p_78598_2_ + 1) - var18, (double)(p_78598_3_ + 1), (double)(p_78598_4_ + 1), var12, var14);
         var5.func_78374_a((double)(p_78598_2_ + 1) - var18, (double)(p_78598_3_ + 0), (double)(p_78598_4_ + 1), var12, var16);
      }

      if((var20 & 4) != 0) {
         var5.func_78374_a((double)(p_78598_2_ + 1), (double)(p_78598_3_ + 0), (double)p_78598_4_ + var18, var12, var16);
         var5.func_78374_a((double)(p_78598_2_ + 1), (double)(p_78598_3_ + 1), (double)p_78598_4_ + var18, var12, var14);
         var5.func_78374_a((double)(p_78598_2_ + 0), (double)(p_78598_3_ + 1), (double)p_78598_4_ + var18, var22, var14);
         var5.func_78374_a((double)(p_78598_2_ + 0), (double)(p_78598_3_ + 0), (double)p_78598_4_ + var18, var22, var16);
         var5.func_78374_a((double)(p_78598_2_ + 0), (double)(p_78598_3_ + 0), (double)p_78598_4_ + var18, var22, var16);
         var5.func_78374_a((double)(p_78598_2_ + 0), (double)(p_78598_3_ + 1), (double)p_78598_4_ + var18, var22, var14);
         var5.func_78374_a((double)(p_78598_2_ + 1), (double)(p_78598_3_ + 1), (double)p_78598_4_ + var18, var12, var14);
         var5.func_78374_a((double)(p_78598_2_ + 1), (double)(p_78598_3_ + 0), (double)p_78598_4_ + var18, var12, var16);
      }

      if((var20 & 1) != 0) {
         var5.func_78374_a((double)(p_78598_2_ + 1), (double)(p_78598_3_ + 1), (double)(p_78598_4_ + 1) - var18, var22, var14);
         var5.func_78374_a((double)(p_78598_2_ + 1), (double)(p_78598_3_ + 0), (double)(p_78598_4_ + 1) - var18, var22, var16);
         var5.func_78374_a((double)(p_78598_2_ + 0), (double)(p_78598_3_ + 0), (double)(p_78598_4_ + 1) - var18, var12, var16);
         var5.func_78374_a((double)(p_78598_2_ + 0), (double)(p_78598_3_ + 1), (double)(p_78598_4_ + 1) - var18, var12, var14);
         var5.func_78374_a((double)(p_78598_2_ + 0), (double)(p_78598_3_ + 1), (double)(p_78598_4_ + 1) - var18, var12, var14);
         var5.func_78374_a((double)(p_78598_2_ + 0), (double)(p_78598_3_ + 0), (double)(p_78598_4_ + 1) - var18, var12, var16);
         var5.func_78374_a((double)(p_78598_2_ + 1), (double)(p_78598_3_ + 0), (double)(p_78598_4_ + 1) - var18, var22, var16);
         var5.func_78374_a((double)(p_78598_2_ + 1), (double)(p_78598_3_ + 1), (double)(p_78598_4_ + 1) - var18, var22, var14);
      }

      if(this.field_78669_a.func_72809_s(p_78598_2_, p_78598_3_ + 1, p_78598_4_)) {
         var5.func_78374_a((double)(p_78598_2_ + 1), (double)(p_78598_3_ + 1) - var18, (double)(p_78598_4_ + 0), var22, var14);
         var5.func_78374_a((double)(p_78598_2_ + 1), (double)(p_78598_3_ + 1) - var18, (double)(p_78598_4_ + 1), var22, var16);
         var5.func_78374_a((double)(p_78598_2_ + 0), (double)(p_78598_3_ + 1) - var18, (double)(p_78598_4_ + 1), var12, var16);
         var5.func_78374_a((double)(p_78598_2_ + 0), (double)(p_78598_3_ + 1) - var18, (double)(p_78598_4_ + 0), var12, var14);
      }

      return true;
   }

   public boolean func_78592_a(BlockPane p_78592_1_, int p_78592_2_, int p_78592_3_, int p_78592_4_) {
      int var5 = this.field_78669_a.func_72800_K();
      Tessellator var6 = Tessellator.field_78398_a;
      var6.func_78380_c(p_78592_1_.func_71874_e(this.field_78669_a, p_78592_2_, p_78592_3_, p_78592_4_));
      float var7 = 1.0F;
      int var8 = p_78592_1_.func_71920_b(this.field_78669_a, p_78592_2_, p_78592_3_, p_78592_4_);
      float var9 = (float)(var8 >> 16 & 255) / 255.0F;
      float var10 = (float)(var8 >> 8 & 255) / 255.0F;
      float var11 = (float)(var8 & 255) / 255.0F;
      if(EntityRenderer.field_78517_a) {
         float var12 = (var9 * 30.0F + var10 * 59.0F + var11 * 11.0F) / 100.0F;
         float var13 = (var9 * 30.0F + var10 * 70.0F) / 100.0F;
         float var14 = (var9 * 30.0F + var11 * 70.0F) / 100.0F;
         var9 = var12;
         var10 = var13;
         var11 = var14;
      }

      var6.func_78386_a(var7 * var9, var7 * var10, var7 * var11);
      boolean var64 = false;
      boolean var67 = false;
      int var68;
      int var65;
      int var66;
      if(this.field_78664_d >= 0) {
         var65 = this.field_78664_d;
         var66 = this.field_78664_d;
      } else {
         var68 = this.field_78669_a.func_72805_g(p_78592_2_, p_78592_3_, p_78592_4_);
         var65 = p_78592_1_.func_71858_a(0, var68);
         var66 = p_78592_1_.func_72162_n();
      }

      var68 = (var65 & 15) << 4;
      int var15 = var65 & 240;
      double var16 = (double)((float)var68 / 256.0F);
      double var18 = (double)(((float)var68 + 7.99F) / 256.0F);
      double var20 = (double)(((float)var68 + 15.99F) / 256.0F);
      double var22 = (double)((float)var15 / 256.0F);
      double var24 = (double)(((float)var15 + 15.99F) / 256.0F);
      int var26 = (var66 & 15) << 4;
      int var27 = var66 & 240;
      double var28 = (double)((float)(var26 + 7) / 256.0F);
      double var30 = (double)(((float)var26 + 8.99F) / 256.0F);
      double var32 = (double)((float)var27 / 256.0F);
      double var34 = (double)((float)(var27 + 8) / 256.0F);
      double var36 = (double)(((float)var27 + 15.99F) / 256.0F);
      double var38 = (double)p_78592_2_;
      double var40 = (double)p_78592_2_ + 0.5D;
      double var42 = (double)(p_78592_2_ + 1);
      double var44 = (double)p_78592_4_;
      double var46 = (double)p_78592_4_ + 0.5D;
      double var48 = (double)(p_78592_4_ + 1);
      double var50 = (double)p_78592_2_ + 0.5D - 0.0625D;
      double var52 = (double)p_78592_2_ + 0.5D + 0.0625D;
      double var54 = (double)p_78592_4_ + 0.5D - 0.0625D;
      double var56 = (double)p_78592_4_ + 0.5D + 0.0625D;
      boolean var58 = p_78592_1_.func_72161_e(this.field_78669_a.func_72798_a(p_78592_2_, p_78592_3_, p_78592_4_ - 1));
      boolean var59 = p_78592_1_.func_72161_e(this.field_78669_a.func_72798_a(p_78592_2_, p_78592_3_, p_78592_4_ + 1));
      boolean var60 = p_78592_1_.func_72161_e(this.field_78669_a.func_72798_a(p_78592_2_ - 1, p_78592_3_, p_78592_4_));
      boolean var61 = p_78592_1_.func_72161_e(this.field_78669_a.func_72798_a(p_78592_2_ + 1, p_78592_3_, p_78592_4_));
      boolean var62 = p_78592_1_.func_71877_c(this.field_78669_a, p_78592_2_, p_78592_3_ + 1, p_78592_4_, 1);
      boolean var63 = p_78592_1_.func_71877_c(this.field_78669_a, p_78592_2_, p_78592_3_ - 1, p_78592_4_, 0);
      if((!var60 || !var61) && (var60 || var61 || var58 || var59)) {
         if(var60 && !var61) {
            var6.func_78374_a(var38, (double)(p_78592_3_ + 1), var46, var16, var22);
            var6.func_78374_a(var38, (double)(p_78592_3_ + 0), var46, var16, var24);
            var6.func_78374_a(var40, (double)(p_78592_3_ + 0), var46, var18, var24);
            var6.func_78374_a(var40, (double)(p_78592_3_ + 1), var46, var18, var22);
            var6.func_78374_a(var40, (double)(p_78592_3_ + 1), var46, var16, var22);
            var6.func_78374_a(var40, (double)(p_78592_3_ + 0), var46, var16, var24);
            var6.func_78374_a(var38, (double)(p_78592_3_ + 0), var46, var18, var24);
            var6.func_78374_a(var38, (double)(p_78592_3_ + 1), var46, var18, var22);
            if(!var59 && !var58) {
               var6.func_78374_a(var40, (double)(p_78592_3_ + 1), var56, var28, var32);
               var6.func_78374_a(var40, (double)(p_78592_3_ + 0), var56, var28, var36);
               var6.func_78374_a(var40, (double)(p_78592_3_ + 0), var54, var30, var36);
               var6.func_78374_a(var40, (double)(p_78592_3_ + 1), var54, var30, var32);
               var6.func_78374_a(var40, (double)(p_78592_3_ + 1), var54, var28, var32);
               var6.func_78374_a(var40, (double)(p_78592_3_ + 0), var54, var28, var36);
               var6.func_78374_a(var40, (double)(p_78592_3_ + 0), var56, var30, var36);
               var6.func_78374_a(var40, (double)(p_78592_3_ + 1), var56, var30, var32);
            }

            if(var62 || p_78592_3_ < var5 - 1 && this.field_78669_a.func_72799_c(p_78592_2_ - 1, p_78592_3_ + 1, p_78592_4_)) {
               var6.func_78374_a(var38, (double)(p_78592_3_ + 1) + 0.01D, var56, var30, var34);
               var6.func_78374_a(var40, (double)(p_78592_3_ + 1) + 0.01D, var56, var30, var36);
               var6.func_78374_a(var40, (double)(p_78592_3_ + 1) + 0.01D, var54, var28, var36);
               var6.func_78374_a(var38, (double)(p_78592_3_ + 1) + 0.01D, var54, var28, var34);
               var6.func_78374_a(var40, (double)(p_78592_3_ + 1) + 0.01D, var56, var30, var34);
               var6.func_78374_a(var38, (double)(p_78592_3_ + 1) + 0.01D, var56, var30, var36);
               var6.func_78374_a(var38, (double)(p_78592_3_ + 1) + 0.01D, var54, var28, var36);
               var6.func_78374_a(var40, (double)(p_78592_3_ + 1) + 0.01D, var54, var28, var34);
            }

            if(var63 || p_78592_3_ > 1 && this.field_78669_a.func_72799_c(p_78592_2_ - 1, p_78592_3_ - 1, p_78592_4_)) {
               var6.func_78374_a(var38, (double)p_78592_3_ - 0.01D, var56, var30, var34);
               var6.func_78374_a(var40, (double)p_78592_3_ - 0.01D, var56, var30, var36);
               var6.func_78374_a(var40, (double)p_78592_3_ - 0.01D, var54, var28, var36);
               var6.func_78374_a(var38, (double)p_78592_3_ - 0.01D, var54, var28, var34);
               var6.func_78374_a(var40, (double)p_78592_3_ - 0.01D, var56, var30, var34);
               var6.func_78374_a(var38, (double)p_78592_3_ - 0.01D, var56, var30, var36);
               var6.func_78374_a(var38, (double)p_78592_3_ - 0.01D, var54, var28, var36);
               var6.func_78374_a(var40, (double)p_78592_3_ - 0.01D, var54, var28, var34);
            }
         } else if(!var60 && var61) {
            var6.func_78374_a(var40, (double)(p_78592_3_ + 1), var46, var18, var22);
            var6.func_78374_a(var40, (double)(p_78592_3_ + 0), var46, var18, var24);
            var6.func_78374_a(var42, (double)(p_78592_3_ + 0), var46, var20, var24);
            var6.func_78374_a(var42, (double)(p_78592_3_ + 1), var46, var20, var22);
            var6.func_78374_a(var42, (double)(p_78592_3_ + 1), var46, var18, var22);
            var6.func_78374_a(var42, (double)(p_78592_3_ + 0), var46, var18, var24);
            var6.func_78374_a(var40, (double)(p_78592_3_ + 0), var46, var20, var24);
            var6.func_78374_a(var40, (double)(p_78592_3_ + 1), var46, var20, var22);
            if(!var59 && !var58) {
               var6.func_78374_a(var40, (double)(p_78592_3_ + 1), var54, var28, var32);
               var6.func_78374_a(var40, (double)(p_78592_3_ + 0), var54, var28, var36);
               var6.func_78374_a(var40, (double)(p_78592_3_ + 0), var56, var30, var36);
               var6.func_78374_a(var40, (double)(p_78592_3_ + 1), var56, var30, var32);
               var6.func_78374_a(var40, (double)(p_78592_3_ + 1), var56, var28, var32);
               var6.func_78374_a(var40, (double)(p_78592_3_ + 0), var56, var28, var36);
               var6.func_78374_a(var40, (double)(p_78592_3_ + 0), var54, var30, var36);
               var6.func_78374_a(var40, (double)(p_78592_3_ + 1), var54, var30, var32);
            }

            if(var62 || p_78592_3_ < var5 - 1 && this.field_78669_a.func_72799_c(p_78592_2_ + 1, p_78592_3_ + 1, p_78592_4_)) {
               var6.func_78374_a(var40, (double)(p_78592_3_ + 1) + 0.01D, var56, var30, var32);
               var6.func_78374_a(var42, (double)(p_78592_3_ + 1) + 0.01D, var56, var30, var34);
               var6.func_78374_a(var42, (double)(p_78592_3_ + 1) + 0.01D, var54, var28, var34);
               var6.func_78374_a(var40, (double)(p_78592_3_ + 1) + 0.01D, var54, var28, var32);
               var6.func_78374_a(var42, (double)(p_78592_3_ + 1) + 0.01D, var56, var30, var32);
               var6.func_78374_a(var40, (double)(p_78592_3_ + 1) + 0.01D, var56, var30, var34);
               var6.func_78374_a(var40, (double)(p_78592_3_ + 1) + 0.01D, var54, var28, var34);
               var6.func_78374_a(var42, (double)(p_78592_3_ + 1) + 0.01D, var54, var28, var32);
            }

            if(var63 || p_78592_3_ > 1 && this.field_78669_a.func_72799_c(p_78592_2_ + 1, p_78592_3_ - 1, p_78592_4_)) {
               var6.func_78374_a(var40, (double)p_78592_3_ - 0.01D, var56, var30, var32);
               var6.func_78374_a(var42, (double)p_78592_3_ - 0.01D, var56, var30, var34);
               var6.func_78374_a(var42, (double)p_78592_3_ - 0.01D, var54, var28, var34);
               var6.func_78374_a(var40, (double)p_78592_3_ - 0.01D, var54, var28, var32);
               var6.func_78374_a(var42, (double)p_78592_3_ - 0.01D, var56, var30, var32);
               var6.func_78374_a(var40, (double)p_78592_3_ - 0.01D, var56, var30, var34);
               var6.func_78374_a(var40, (double)p_78592_3_ - 0.01D, var54, var28, var34);
               var6.func_78374_a(var42, (double)p_78592_3_ - 0.01D, var54, var28, var32);
            }
         }
      } else {
         var6.func_78374_a(var38, (double)(p_78592_3_ + 1), var46, var16, var22);
         var6.func_78374_a(var38, (double)(p_78592_3_ + 0), var46, var16, var24);
         var6.func_78374_a(var42, (double)(p_78592_3_ + 0), var46, var20, var24);
         var6.func_78374_a(var42, (double)(p_78592_3_ + 1), var46, var20, var22);
         var6.func_78374_a(var42, (double)(p_78592_3_ + 1), var46, var16, var22);
         var6.func_78374_a(var42, (double)(p_78592_3_ + 0), var46, var16, var24);
         var6.func_78374_a(var38, (double)(p_78592_3_ + 0), var46, var20, var24);
         var6.func_78374_a(var38, (double)(p_78592_3_ + 1), var46, var20, var22);
         if(var62) {
            var6.func_78374_a(var38, (double)(p_78592_3_ + 1) + 0.01D, var56, var30, var36);
            var6.func_78374_a(var42, (double)(p_78592_3_ + 1) + 0.01D, var56, var30, var32);
            var6.func_78374_a(var42, (double)(p_78592_3_ + 1) + 0.01D, var54, var28, var32);
            var6.func_78374_a(var38, (double)(p_78592_3_ + 1) + 0.01D, var54, var28, var36);
            var6.func_78374_a(var42, (double)(p_78592_3_ + 1) + 0.01D, var56, var30, var36);
            var6.func_78374_a(var38, (double)(p_78592_3_ + 1) + 0.01D, var56, var30, var32);
            var6.func_78374_a(var38, (double)(p_78592_3_ + 1) + 0.01D, var54, var28, var32);
            var6.func_78374_a(var42, (double)(p_78592_3_ + 1) + 0.01D, var54, var28, var36);
         } else {
            if(p_78592_3_ < var5 - 1 && this.field_78669_a.func_72799_c(p_78592_2_ - 1, p_78592_3_ + 1, p_78592_4_)) {
               var6.func_78374_a(var38, (double)(p_78592_3_ + 1) + 0.01D, var56, var30, var34);
               var6.func_78374_a(var40, (double)(p_78592_3_ + 1) + 0.01D, var56, var30, var36);
               var6.func_78374_a(var40, (double)(p_78592_3_ + 1) + 0.01D, var54, var28, var36);
               var6.func_78374_a(var38, (double)(p_78592_3_ + 1) + 0.01D, var54, var28, var34);
               var6.func_78374_a(var40, (double)(p_78592_3_ + 1) + 0.01D, var56, var30, var34);
               var6.func_78374_a(var38, (double)(p_78592_3_ + 1) + 0.01D, var56, var30, var36);
               var6.func_78374_a(var38, (double)(p_78592_3_ + 1) + 0.01D, var54, var28, var36);
               var6.func_78374_a(var40, (double)(p_78592_3_ + 1) + 0.01D, var54, var28, var34);
            }

            if(p_78592_3_ < var5 - 1 && this.field_78669_a.func_72799_c(p_78592_2_ + 1, p_78592_3_ + 1, p_78592_4_)) {
               var6.func_78374_a(var40, (double)(p_78592_3_ + 1) + 0.01D, var56, var30, var32);
               var6.func_78374_a(var42, (double)(p_78592_3_ + 1) + 0.01D, var56, var30, var34);
               var6.func_78374_a(var42, (double)(p_78592_3_ + 1) + 0.01D, var54, var28, var34);
               var6.func_78374_a(var40, (double)(p_78592_3_ + 1) + 0.01D, var54, var28, var32);
               var6.func_78374_a(var42, (double)(p_78592_3_ + 1) + 0.01D, var56, var30, var32);
               var6.func_78374_a(var40, (double)(p_78592_3_ + 1) + 0.01D, var56, var30, var34);
               var6.func_78374_a(var40, (double)(p_78592_3_ + 1) + 0.01D, var54, var28, var34);
               var6.func_78374_a(var42, (double)(p_78592_3_ + 1) + 0.01D, var54, var28, var32);
            }
         }

         if(var63) {
            var6.func_78374_a(var38, (double)p_78592_3_ - 0.01D, var56, var30, var36);
            var6.func_78374_a(var42, (double)p_78592_3_ - 0.01D, var56, var30, var32);
            var6.func_78374_a(var42, (double)p_78592_3_ - 0.01D, var54, var28, var32);
            var6.func_78374_a(var38, (double)p_78592_3_ - 0.01D, var54, var28, var36);
            var6.func_78374_a(var42, (double)p_78592_3_ - 0.01D, var56, var30, var36);
            var6.func_78374_a(var38, (double)p_78592_3_ - 0.01D, var56, var30, var32);
            var6.func_78374_a(var38, (double)p_78592_3_ - 0.01D, var54, var28, var32);
            var6.func_78374_a(var42, (double)p_78592_3_ - 0.01D, var54, var28, var36);
         } else {
            if(p_78592_3_ > 1 && this.field_78669_a.func_72799_c(p_78592_2_ - 1, p_78592_3_ - 1, p_78592_4_)) {
               var6.func_78374_a(var38, (double)p_78592_3_ - 0.01D, var56, var30, var34);
               var6.func_78374_a(var40, (double)p_78592_3_ - 0.01D, var56, var30, var36);
               var6.func_78374_a(var40, (double)p_78592_3_ - 0.01D, var54, var28, var36);
               var6.func_78374_a(var38, (double)p_78592_3_ - 0.01D, var54, var28, var34);
               var6.func_78374_a(var40, (double)p_78592_3_ - 0.01D, var56, var30, var34);
               var6.func_78374_a(var38, (double)p_78592_3_ - 0.01D, var56, var30, var36);
               var6.func_78374_a(var38, (double)p_78592_3_ - 0.01D, var54, var28, var36);
               var6.func_78374_a(var40, (double)p_78592_3_ - 0.01D, var54, var28, var34);
            }

            if(p_78592_3_ > 1 && this.field_78669_a.func_72799_c(p_78592_2_ + 1, p_78592_3_ - 1, p_78592_4_)) {
               var6.func_78374_a(var40, (double)p_78592_3_ - 0.01D, var56, var30, var32);
               var6.func_78374_a(var42, (double)p_78592_3_ - 0.01D, var56, var30, var34);
               var6.func_78374_a(var42, (double)p_78592_3_ - 0.01D, var54, var28, var34);
               var6.func_78374_a(var40, (double)p_78592_3_ - 0.01D, var54, var28, var32);
               var6.func_78374_a(var42, (double)p_78592_3_ - 0.01D, var56, var30, var32);
               var6.func_78374_a(var40, (double)p_78592_3_ - 0.01D, var56, var30, var34);
               var6.func_78374_a(var40, (double)p_78592_3_ - 0.01D, var54, var28, var34);
               var6.func_78374_a(var42, (double)p_78592_3_ - 0.01D, var54, var28, var32);
            }
         }
      }

      if((!var58 || !var59) && (var60 || var61 || var58 || var59)) {
         if(var58 && !var59) {
            var6.func_78374_a(var40, (double)(p_78592_3_ + 1), var44, var16, var22);
            var6.func_78374_a(var40, (double)(p_78592_3_ + 0), var44, var16, var24);
            var6.func_78374_a(var40, (double)(p_78592_3_ + 0), var46, var18, var24);
            var6.func_78374_a(var40, (double)(p_78592_3_ + 1), var46, var18, var22);
            var6.func_78374_a(var40, (double)(p_78592_3_ + 1), var46, var16, var22);
            var6.func_78374_a(var40, (double)(p_78592_3_ + 0), var46, var16, var24);
            var6.func_78374_a(var40, (double)(p_78592_3_ + 0), var44, var18, var24);
            var6.func_78374_a(var40, (double)(p_78592_3_ + 1), var44, var18, var22);
            if(!var61 && !var60) {
               var6.func_78374_a(var50, (double)(p_78592_3_ + 1), var46, var28, var32);
               var6.func_78374_a(var50, (double)(p_78592_3_ + 0), var46, var28, var36);
               var6.func_78374_a(var52, (double)(p_78592_3_ + 0), var46, var30, var36);
               var6.func_78374_a(var52, (double)(p_78592_3_ + 1), var46, var30, var32);
               var6.func_78374_a(var52, (double)(p_78592_3_ + 1), var46, var28, var32);
               var6.func_78374_a(var52, (double)(p_78592_3_ + 0), var46, var28, var36);
               var6.func_78374_a(var50, (double)(p_78592_3_ + 0), var46, var30, var36);
               var6.func_78374_a(var50, (double)(p_78592_3_ + 1), var46, var30, var32);
            }

            if(var62 || p_78592_3_ < var5 - 1 && this.field_78669_a.func_72799_c(p_78592_2_, p_78592_3_ + 1, p_78592_4_ - 1)) {
               var6.func_78374_a(var50, (double)(p_78592_3_ + 1), var44, var30, var32);
               var6.func_78374_a(var50, (double)(p_78592_3_ + 1), var46, var30, var34);
               var6.func_78374_a(var52, (double)(p_78592_3_ + 1), var46, var28, var34);
               var6.func_78374_a(var52, (double)(p_78592_3_ + 1), var44, var28, var32);
               var6.func_78374_a(var50, (double)(p_78592_3_ + 1), var46, var30, var32);
               var6.func_78374_a(var50, (double)(p_78592_3_ + 1), var44, var30, var34);
               var6.func_78374_a(var52, (double)(p_78592_3_ + 1), var44, var28, var34);
               var6.func_78374_a(var52, (double)(p_78592_3_ + 1), var46, var28, var32);
            }

            if(var63 || p_78592_3_ > 1 && this.field_78669_a.func_72799_c(p_78592_2_, p_78592_3_ - 1, p_78592_4_ - 1)) {
               var6.func_78374_a(var50, (double)p_78592_3_, var44, var30, var32);
               var6.func_78374_a(var50, (double)p_78592_3_, var46, var30, var34);
               var6.func_78374_a(var52, (double)p_78592_3_, var46, var28, var34);
               var6.func_78374_a(var52, (double)p_78592_3_, var44, var28, var32);
               var6.func_78374_a(var50, (double)p_78592_3_, var46, var30, var32);
               var6.func_78374_a(var50, (double)p_78592_3_, var44, var30, var34);
               var6.func_78374_a(var52, (double)p_78592_3_, var44, var28, var34);
               var6.func_78374_a(var52, (double)p_78592_3_, var46, var28, var32);
            }
         } else if(!var58 && var59) {
            var6.func_78374_a(var40, (double)(p_78592_3_ + 1), var46, var18, var22);
            var6.func_78374_a(var40, (double)(p_78592_3_ + 0), var46, var18, var24);
            var6.func_78374_a(var40, (double)(p_78592_3_ + 0), var48, var20, var24);
            var6.func_78374_a(var40, (double)(p_78592_3_ + 1), var48, var20, var22);
            var6.func_78374_a(var40, (double)(p_78592_3_ + 1), var48, var18, var22);
            var6.func_78374_a(var40, (double)(p_78592_3_ + 0), var48, var18, var24);
            var6.func_78374_a(var40, (double)(p_78592_3_ + 0), var46, var20, var24);
            var6.func_78374_a(var40, (double)(p_78592_3_ + 1), var46, var20, var22);
            if(!var61 && !var60) {
               var6.func_78374_a(var52, (double)(p_78592_3_ + 1), var46, var28, var32);
               var6.func_78374_a(var52, (double)(p_78592_3_ + 0), var46, var28, var36);
               var6.func_78374_a(var50, (double)(p_78592_3_ + 0), var46, var30, var36);
               var6.func_78374_a(var50, (double)(p_78592_3_ + 1), var46, var30, var32);
               var6.func_78374_a(var50, (double)(p_78592_3_ + 1), var46, var28, var32);
               var6.func_78374_a(var50, (double)(p_78592_3_ + 0), var46, var28, var36);
               var6.func_78374_a(var52, (double)(p_78592_3_ + 0), var46, var30, var36);
               var6.func_78374_a(var52, (double)(p_78592_3_ + 1), var46, var30, var32);
            }

            if(var62 || p_78592_3_ < var5 - 1 && this.field_78669_a.func_72799_c(p_78592_2_, p_78592_3_ + 1, p_78592_4_ + 1)) {
               var6.func_78374_a(var50, (double)(p_78592_3_ + 1), var46, var28, var34);
               var6.func_78374_a(var50, (double)(p_78592_3_ + 1), var48, var28, var36);
               var6.func_78374_a(var52, (double)(p_78592_3_ + 1), var48, var30, var36);
               var6.func_78374_a(var52, (double)(p_78592_3_ + 1), var46, var30, var34);
               var6.func_78374_a(var50, (double)(p_78592_3_ + 1), var48, var28, var34);
               var6.func_78374_a(var50, (double)(p_78592_3_ + 1), var46, var28, var36);
               var6.func_78374_a(var52, (double)(p_78592_3_ + 1), var46, var30, var36);
               var6.func_78374_a(var52, (double)(p_78592_3_ + 1), var48, var30, var34);
            }

            if(var63 || p_78592_3_ > 1 && this.field_78669_a.func_72799_c(p_78592_2_, p_78592_3_ - 1, p_78592_4_ + 1)) {
               var6.func_78374_a(var50, (double)p_78592_3_, var46, var28, var34);
               var6.func_78374_a(var50, (double)p_78592_3_, var48, var28, var36);
               var6.func_78374_a(var52, (double)p_78592_3_, var48, var30, var36);
               var6.func_78374_a(var52, (double)p_78592_3_, var46, var30, var34);
               var6.func_78374_a(var50, (double)p_78592_3_, var48, var28, var34);
               var6.func_78374_a(var50, (double)p_78592_3_, var46, var28, var36);
               var6.func_78374_a(var52, (double)p_78592_3_, var46, var30, var36);
               var6.func_78374_a(var52, (double)p_78592_3_, var48, var30, var34);
            }
         }
      } else {
         var6.func_78374_a(var40, (double)(p_78592_3_ + 1), var48, var16, var22);
         var6.func_78374_a(var40, (double)(p_78592_3_ + 0), var48, var16, var24);
         var6.func_78374_a(var40, (double)(p_78592_3_ + 0), var44, var20, var24);
         var6.func_78374_a(var40, (double)(p_78592_3_ + 1), var44, var20, var22);
         var6.func_78374_a(var40, (double)(p_78592_3_ + 1), var44, var16, var22);
         var6.func_78374_a(var40, (double)(p_78592_3_ + 0), var44, var16, var24);
         var6.func_78374_a(var40, (double)(p_78592_3_ + 0), var48, var20, var24);
         var6.func_78374_a(var40, (double)(p_78592_3_ + 1), var48, var20, var22);
         if(var62) {
            var6.func_78374_a(var52, (double)(p_78592_3_ + 1), var48, var30, var36);
            var6.func_78374_a(var52, (double)(p_78592_3_ + 1), var44, var30, var32);
            var6.func_78374_a(var50, (double)(p_78592_3_ + 1), var44, var28, var32);
            var6.func_78374_a(var50, (double)(p_78592_3_ + 1), var48, var28, var36);
            var6.func_78374_a(var52, (double)(p_78592_3_ + 1), var44, var30, var36);
            var6.func_78374_a(var52, (double)(p_78592_3_ + 1), var48, var30, var32);
            var6.func_78374_a(var50, (double)(p_78592_3_ + 1), var48, var28, var32);
            var6.func_78374_a(var50, (double)(p_78592_3_ + 1), var44, var28, var36);
         } else {
            if(p_78592_3_ < var5 - 1 && this.field_78669_a.func_72799_c(p_78592_2_, p_78592_3_ + 1, p_78592_4_ - 1)) {
               var6.func_78374_a(var50, (double)(p_78592_3_ + 1), var44, var30, var32);
               var6.func_78374_a(var50, (double)(p_78592_3_ + 1), var46, var30, var34);
               var6.func_78374_a(var52, (double)(p_78592_3_ + 1), var46, var28, var34);
               var6.func_78374_a(var52, (double)(p_78592_3_ + 1), var44, var28, var32);
               var6.func_78374_a(var50, (double)(p_78592_3_ + 1), var46, var30, var32);
               var6.func_78374_a(var50, (double)(p_78592_3_ + 1), var44, var30, var34);
               var6.func_78374_a(var52, (double)(p_78592_3_ + 1), var44, var28, var34);
               var6.func_78374_a(var52, (double)(p_78592_3_ + 1), var46, var28, var32);
            }

            if(p_78592_3_ < var5 - 1 && this.field_78669_a.func_72799_c(p_78592_2_, p_78592_3_ + 1, p_78592_4_ + 1)) {
               var6.func_78374_a(var50, (double)(p_78592_3_ + 1), var46, var28, var34);
               var6.func_78374_a(var50, (double)(p_78592_3_ + 1), var48, var28, var36);
               var6.func_78374_a(var52, (double)(p_78592_3_ + 1), var48, var30, var36);
               var6.func_78374_a(var52, (double)(p_78592_3_ + 1), var46, var30, var34);
               var6.func_78374_a(var50, (double)(p_78592_3_ + 1), var48, var28, var34);
               var6.func_78374_a(var50, (double)(p_78592_3_ + 1), var46, var28, var36);
               var6.func_78374_a(var52, (double)(p_78592_3_ + 1), var46, var30, var36);
               var6.func_78374_a(var52, (double)(p_78592_3_ + 1), var48, var30, var34);
            }
         }

         if(var63) {
            var6.func_78374_a(var52, (double)p_78592_3_, var48, var30, var36);
            var6.func_78374_a(var52, (double)p_78592_3_, var44, var30, var32);
            var6.func_78374_a(var50, (double)p_78592_3_, var44, var28, var32);
            var6.func_78374_a(var50, (double)p_78592_3_, var48, var28, var36);
            var6.func_78374_a(var52, (double)p_78592_3_, var44, var30, var36);
            var6.func_78374_a(var52, (double)p_78592_3_, var48, var30, var32);
            var6.func_78374_a(var50, (double)p_78592_3_, var48, var28, var32);
            var6.func_78374_a(var50, (double)p_78592_3_, var44, var28, var36);
         } else {
            if(p_78592_3_ > 1 && this.field_78669_a.func_72799_c(p_78592_2_, p_78592_3_ - 1, p_78592_4_ - 1)) {
               var6.func_78374_a(var50, (double)p_78592_3_, var44, var30, var32);
               var6.func_78374_a(var50, (double)p_78592_3_, var46, var30, var34);
               var6.func_78374_a(var52, (double)p_78592_3_, var46, var28, var34);
               var6.func_78374_a(var52, (double)p_78592_3_, var44, var28, var32);
               var6.func_78374_a(var50, (double)p_78592_3_, var46, var30, var32);
               var6.func_78374_a(var50, (double)p_78592_3_, var44, var30, var34);
               var6.func_78374_a(var52, (double)p_78592_3_, var44, var28, var34);
               var6.func_78374_a(var52, (double)p_78592_3_, var46, var28, var32);
            }

            if(p_78592_3_ > 1 && this.field_78669_a.func_72799_c(p_78592_2_, p_78592_3_ - 1, p_78592_4_ + 1)) {
               var6.func_78374_a(var50, (double)p_78592_3_, var46, var28, var34);
               var6.func_78374_a(var50, (double)p_78592_3_, var48, var28, var36);
               var6.func_78374_a(var52, (double)p_78592_3_, var48, var30, var36);
               var6.func_78374_a(var52, (double)p_78592_3_, var46, var30, var34);
               var6.func_78374_a(var50, (double)p_78592_3_, var48, var28, var34);
               var6.func_78374_a(var50, (double)p_78592_3_, var46, var28, var36);
               var6.func_78374_a(var52, (double)p_78592_3_, var46, var30, var36);
               var6.func_78374_a(var52, (double)p_78592_3_, var48, var30, var34);
            }
         }
      }

      return true;
   }

   public boolean func_78620_l(Block p_78620_1_, int p_78620_2_, int p_78620_3_, int p_78620_4_) {
      Tessellator var5 = Tessellator.field_78398_a;
      var5.func_78380_c(p_78620_1_.func_71874_e(this.field_78669_a, p_78620_2_, p_78620_3_, p_78620_4_));
      float var6 = 1.0F;
      int var7 = p_78620_1_.func_71920_b(this.field_78669_a, p_78620_2_, p_78620_3_, p_78620_4_);
      float var8 = (float)(var7 >> 16 & 255) / 255.0F;
      float var9 = (float)(var7 >> 8 & 255) / 255.0F;
      float var10 = (float)(var7 & 255) / 255.0F;
      if(EntityRenderer.field_78517_a) {
         float var11 = (var8 * 30.0F + var9 * 59.0F + var10 * 11.0F) / 100.0F;
         float var12 = (var8 * 30.0F + var9 * 70.0F) / 100.0F;
         float var13 = (var8 * 30.0F + var10 * 70.0F) / 100.0F;
         var8 = var11;
         var9 = var12;
         var10 = var13;
      }

      var5.func_78386_a(var6 * var8, var6 * var9, var6 * var10);
      double var19 = (double)p_78620_2_;
      double var20 = (double)p_78620_3_;
      double var15 = (double)p_78620_4_;
      if(p_78620_1_ == Block.field_71962_X) {
         long var17 = (long)(p_78620_2_ * 3129871) ^ (long)p_78620_4_ * 116129781L ^ (long)p_78620_3_;
         var17 = var17 * var17 * 42317861L + var17 * 11L;
         var19 += ((double)((float)(var17 >> 16 & 15L) / 15.0F) - 0.5D) * 0.5D;
         var20 += ((double)((float)(var17 >> 20 & 15L) / 15.0F) - 1.0D) * 0.2D;
         var15 += ((double)((float)(var17 >> 24 & 15L) / 15.0F) - 0.5D) * 0.5D;
      }

      this.func_78599_a(p_78620_1_, this.field_78669_a.func_72805_g(p_78620_2_, p_78620_3_, p_78620_4_), var19, var20, var15);
      return true;
   }

   public boolean func_78603_m(Block p_78603_1_, int p_78603_2_, int p_78603_3_, int p_78603_4_) {
      BlockStem var5 = (BlockStem)p_78603_1_;
      Tessellator var6 = Tessellator.field_78398_a;
      var6.func_78380_c(var5.func_71874_e(this.field_78669_a, p_78603_2_, p_78603_3_, p_78603_4_));
      float var7 = 1.0F;
      int var8 = var5.func_71920_b(this.field_78669_a, p_78603_2_, p_78603_3_, p_78603_4_);
      float var9 = (float)(var8 >> 16 & 255) / 255.0F;
      float var10 = (float)(var8 >> 8 & 255) / 255.0F;
      float var11 = (float)(var8 & 255) / 255.0F;
      if(EntityRenderer.field_78517_a) {
         float var12 = (var9 * 30.0F + var10 * 59.0F + var11 * 11.0F) / 100.0F;
         float var13 = (var9 * 30.0F + var10 * 70.0F) / 100.0F;
         float var14 = (var9 * 30.0F + var11 * 70.0F) / 100.0F;
         var9 = var12;
         var10 = var13;
         var11 = var14;
      }

      var6.func_78386_a(var7 * var9, var7 * var10, var7 * var11);
      var5.func_71902_a(this.field_78669_a, p_78603_2_, p_78603_3_, p_78603_4_);
      int var15 = var5.func_72265_d(this.field_78669_a, p_78603_2_, p_78603_3_, p_78603_4_);
      if(var15 < 0) {
         this.func_78575_a(var5, this.field_78669_a.func_72805_g(p_78603_2_, p_78603_3_, p_78603_4_), var5.field_72022_cl, (double)p_78603_2_, (double)((float)p_78603_3_ - 0.0625F), (double)p_78603_4_);
      } else {
         this.func_78575_a(var5, this.field_78669_a.func_72805_g(p_78603_2_, p_78603_3_, p_78603_4_), 0.5D, (double)p_78603_2_, (double)((float)p_78603_3_ - 0.0625F), (double)p_78603_4_);
         this.func_78606_a(var5, this.field_78669_a.func_72805_g(p_78603_2_, p_78603_3_, p_78603_4_), var15, var5.field_72022_cl, (double)p_78603_2_, (double)((float)p_78603_3_ - 0.0625F), (double)p_78603_4_);
      }

      return true;
   }

   public boolean func_78614_n(Block p_78614_1_, int p_78614_2_, int p_78614_3_, int p_78614_4_) {
      Tessellator var5 = Tessellator.field_78398_a;
      var5.func_78380_c(p_78614_1_.func_71874_e(this.field_78669_a, p_78614_2_, p_78614_3_, p_78614_4_));
      var5.func_78386_a(1.0F, 1.0F, 1.0F);
      this.func_78579_b(p_78614_1_, this.field_78669_a.func_72805_g(p_78614_2_, p_78614_3_, p_78614_4_), (double)p_78614_2_, (double)((float)p_78614_3_ - 0.0625F), (double)p_78614_4_);
      return true;
   }

   public void func_78623_a(Block p_78623_1_, double p_78623_2_, double p_78623_4_, double p_78623_6_, double p_78623_8_, double p_78623_10_) {
      Tessellator var12 = Tessellator.field_78398_a;
      int var13 = p_78623_1_.func_71851_a(0);
      if(this.field_78664_d >= 0) {
         var13 = this.field_78664_d;
      }

      int var14 = (var13 & 15) << 4;
      int var15 = var13 & 240;
      float var16 = (float)var14 / 256.0F;
      float var17 = ((float)var14 + 15.99F) / 256.0F;
      float var18 = (float)var15 / 256.0F;
      float var19 = ((float)var15 + 15.99F) / 256.0F;
      double var20 = (double)var16 + 0.02734375D;
      double var22 = (double)var18 + 0.0234375D;
      double var24 = (double)var16 + 0.03515625D;
      double var26 = (double)var18 + 0.03125D;
      p_78623_2_ += 0.5D;
      p_78623_6_ += 0.5D;
      double var28 = p_78623_2_ - 0.5D;
      double var30 = p_78623_2_ + 0.5D;
      double var32 = p_78623_6_ - 0.5D;
      double var34 = p_78623_6_ + 0.5D;
      double var36 = 0.0625D;
      double var38 = 0.625D;
      var12.func_78374_a(p_78623_2_ + p_78623_8_ * (1.0D - var38) - var36, p_78623_4_ + var38, p_78623_6_ + p_78623_10_ * (1.0D - var38) - var36, var20, var22);
      var12.func_78374_a(p_78623_2_ + p_78623_8_ * (1.0D - var38) - var36, p_78623_4_ + var38, p_78623_6_ + p_78623_10_ * (1.0D - var38) + var36, var20, var26);
      var12.func_78374_a(p_78623_2_ + p_78623_8_ * (1.0D - var38) + var36, p_78623_4_ + var38, p_78623_6_ + p_78623_10_ * (1.0D - var38) + var36, var24, var26);
      var12.func_78374_a(p_78623_2_ + p_78623_8_ * (1.0D - var38) + var36, p_78623_4_ + var38, p_78623_6_ + p_78623_10_ * (1.0D - var38) - var36, var24, var22);
      var12.func_78374_a(p_78623_2_ - var36, p_78623_4_ + 1.0D, var32, (double)var16, (double)var18);
      var12.func_78374_a(p_78623_2_ - var36 + p_78623_8_, p_78623_4_ + 0.0D, var32 + p_78623_10_, (double)var16, (double)var19);
      var12.func_78374_a(p_78623_2_ - var36 + p_78623_8_, p_78623_4_ + 0.0D, var34 + p_78623_10_, (double)var17, (double)var19);
      var12.func_78374_a(p_78623_2_ - var36, p_78623_4_ + 1.0D, var34, (double)var17, (double)var18);
      var12.func_78374_a(p_78623_2_ + var36, p_78623_4_ + 1.0D, var34, (double)var16, (double)var18);
      var12.func_78374_a(p_78623_2_ + p_78623_8_ + var36, p_78623_4_ + 0.0D, var34 + p_78623_10_, (double)var16, (double)var19);
      var12.func_78374_a(p_78623_2_ + p_78623_8_ + var36, p_78623_4_ + 0.0D, var32 + p_78623_10_, (double)var17, (double)var19);
      var12.func_78374_a(p_78623_2_ + var36, p_78623_4_ + 1.0D, var32, (double)var17, (double)var18);
      var12.func_78374_a(var28, p_78623_4_ + 1.0D, p_78623_6_ + var36, (double)var16, (double)var18);
      var12.func_78374_a(var28 + p_78623_8_, p_78623_4_ + 0.0D, p_78623_6_ + var36 + p_78623_10_, (double)var16, (double)var19);
      var12.func_78374_a(var30 + p_78623_8_, p_78623_4_ + 0.0D, p_78623_6_ + var36 + p_78623_10_, (double)var17, (double)var19);
      var12.func_78374_a(var30, p_78623_4_ + 1.0D, p_78623_6_ + var36, (double)var17, (double)var18);
      var12.func_78374_a(var30, p_78623_4_ + 1.0D, p_78623_6_ - var36, (double)var16, (double)var18);
      var12.func_78374_a(var30 + p_78623_8_, p_78623_4_ + 0.0D, p_78623_6_ - var36 + p_78623_10_, (double)var16, (double)var19);
      var12.func_78374_a(var28 + p_78623_8_, p_78623_4_ + 0.0D, p_78623_6_ - var36 + p_78623_10_, (double)var17, (double)var19);
      var12.func_78374_a(var28, p_78623_4_ + 1.0D, p_78623_6_ - var36, (double)var17, (double)var18);
   }

   public void func_78599_a(Block p_78599_1_, int p_78599_2_, double p_78599_3_, double p_78599_5_, double p_78599_7_) {
      Tessellator var9 = Tessellator.field_78398_a;
      int var10 = p_78599_1_.func_71858_a(0, p_78599_2_);
      if(this.field_78664_d >= 0) {
         var10 = this.field_78664_d;
      }

      int var11 = (var10 & 15) << 4;
      int var12 = var10 & 240;
      double var13 = (double)((float)var11 / 256.0F);
      double var15 = (double)(((float)var11 + 15.99F) / 256.0F);
      double var17 = (double)((float)var12 / 256.0F);
      double var19 = (double)(((float)var12 + 15.99F) / 256.0F);
      double var21 = p_78599_3_ + 0.5D - 0.45D;
      double var23 = p_78599_3_ + 0.5D + 0.45D;
      double var25 = p_78599_7_ + 0.5D - 0.45D;
      double var27 = p_78599_7_ + 0.5D + 0.45D;
      var9.func_78374_a(var21, p_78599_5_ + 1.0D, var25, var13, var17);
      var9.func_78374_a(var21, p_78599_5_ + 0.0D, var25, var13, var19);
      var9.func_78374_a(var23, p_78599_5_ + 0.0D, var27, var15, var19);
      var9.func_78374_a(var23, p_78599_5_ + 1.0D, var27, var15, var17);
      var9.func_78374_a(var23, p_78599_5_ + 1.0D, var27, var13, var17);
      var9.func_78374_a(var23, p_78599_5_ + 0.0D, var27, var13, var19);
      var9.func_78374_a(var21, p_78599_5_ + 0.0D, var25, var15, var19);
      var9.func_78374_a(var21, p_78599_5_ + 1.0D, var25, var15, var17);
      var9.func_78374_a(var21, p_78599_5_ + 1.0D, var27, var13, var17);
      var9.func_78374_a(var21, p_78599_5_ + 0.0D, var27, var13, var19);
      var9.func_78374_a(var23, p_78599_5_ + 0.0D, var25, var15, var19);
      var9.func_78374_a(var23, p_78599_5_ + 1.0D, var25, var15, var17);
      var9.func_78374_a(var23, p_78599_5_ + 1.0D, var25, var13, var17);
      var9.func_78374_a(var23, p_78599_5_ + 0.0D, var25, var13, var19);
      var9.func_78374_a(var21, p_78599_5_ + 0.0D, var27, var15, var19);
      var9.func_78374_a(var21, p_78599_5_ + 1.0D, var27, var15, var17);
   }

   public void func_78575_a(Block p_78575_1_, int p_78575_2_, double p_78575_3_, double p_78575_5_, double p_78575_7_, double p_78575_9_) {
      Tessellator var11 = Tessellator.field_78398_a;
      int var12 = p_78575_1_.func_71858_a(0, p_78575_2_);
      if(this.field_78664_d >= 0) {
         var12 = this.field_78664_d;
      }

      int var13 = (var12 & 15) << 4;
      int var14 = var12 & 240;
      double var15 = (double)((float)var13 / 256.0F);
      double var17 = (double)(((float)var13 + 15.99F) / 256.0F);
      double var19 = (double)((float)var14 / 256.0F);
      double var21 = ((double)var14 + 15.989999771118164D * p_78575_3_) / 256.0D;
      double var23 = p_78575_5_ + 0.5D - 0.44999998807907104D;
      double var25 = p_78575_5_ + 0.5D + 0.44999998807907104D;
      double var27 = p_78575_9_ + 0.5D - 0.44999998807907104D;
      double var29 = p_78575_9_ + 0.5D + 0.44999998807907104D;
      var11.func_78374_a(var23, p_78575_7_ + p_78575_3_, var27, var15, var19);
      var11.func_78374_a(var23, p_78575_7_ + 0.0D, var27, var15, var21);
      var11.func_78374_a(var25, p_78575_7_ + 0.0D, var29, var17, var21);
      var11.func_78374_a(var25, p_78575_7_ + p_78575_3_, var29, var17, var19);
      var11.func_78374_a(var25, p_78575_7_ + p_78575_3_, var29, var15, var19);
      var11.func_78374_a(var25, p_78575_7_ + 0.0D, var29, var15, var21);
      var11.func_78374_a(var23, p_78575_7_ + 0.0D, var27, var17, var21);
      var11.func_78374_a(var23, p_78575_7_ + p_78575_3_, var27, var17, var19);
      var11.func_78374_a(var23, p_78575_7_ + p_78575_3_, var29, var15, var19);
      var11.func_78374_a(var23, p_78575_7_ + 0.0D, var29, var15, var21);
      var11.func_78374_a(var25, p_78575_7_ + 0.0D, var27, var17, var21);
      var11.func_78374_a(var25, p_78575_7_ + p_78575_3_, var27, var17, var19);
      var11.func_78374_a(var25, p_78575_7_ + p_78575_3_, var27, var15, var19);
      var11.func_78374_a(var25, p_78575_7_ + 0.0D, var27, var15, var21);
      var11.func_78374_a(var23, p_78575_7_ + 0.0D, var29, var17, var21);
      var11.func_78374_a(var23, p_78575_7_ + p_78575_3_, var29, var17, var19);
   }

   public boolean func_78566_o(Block p_78566_1_, int p_78566_2_, int p_78566_3_, int p_78566_4_) {
      Tessellator var5 = Tessellator.field_78398_a;
      int var6 = p_78566_1_.field_72059_bZ;
      if(this.field_78664_d >= 0) {
         var6 = this.field_78664_d;
      }

      int var7 = (var6 & 15) << 4;
      int var8 = var6 & 240;
      float var9 = 0.015625F;
      double var10 = (double)((float)var7 / 256.0F);
      double var12 = (double)(((float)var7 + 15.99F) / 256.0F);
      double var14 = (double)((float)var8 / 256.0F);
      double var16 = (double)(((float)var8 + 15.99F) / 256.0F);
      long var18 = (long)(p_78566_2_ * 3129871) ^ (long)p_78566_4_ * 116129781L ^ (long)p_78566_3_;
      var18 = var18 * var18 * 42317861L + var18 * 11L;
      int var20 = (int)(var18 >> 16 & 3L);
      var5.func_78380_c(p_78566_1_.func_71874_e(this.field_78669_a, p_78566_2_, p_78566_3_, p_78566_4_));
      float var21 = (float)p_78566_2_ + 0.5F;
      float var22 = (float)p_78566_4_ + 0.5F;
      float var23 = (float)(var20 & 1) * 0.5F * (float)(1 - var20 / 2 % 2 * 2);
      float var24 = (float)(var20 + 1 & 1) * 0.5F * (float)(1 - (var20 + 1) / 2 % 2 * 2);
      var5.func_78378_d(p_78566_1_.func_71933_m());
      var5.func_78374_a((double)(var21 + var23 - var24), (double)((float)p_78566_3_ + var9), (double)(var22 + var23 + var24), var10, var14);
      var5.func_78374_a((double)(var21 + var23 + var24), (double)((float)p_78566_3_ + var9), (double)(var22 - var23 + var24), var12, var14);
      var5.func_78374_a((double)(var21 - var23 + var24), (double)((float)p_78566_3_ + var9), (double)(var22 - var23 - var24), var12, var16);
      var5.func_78374_a((double)(var21 - var23 - var24), (double)((float)p_78566_3_ + var9), (double)(var22 + var23 - var24), var10, var16);
      var5.func_78378_d((p_78566_1_.func_71933_m() & 16711422) >> 1);
      var5.func_78374_a((double)(var21 - var23 - var24), (double)((float)p_78566_3_ + var9), (double)(var22 + var23 - var24), var10, var16);
      var5.func_78374_a((double)(var21 - var23 + var24), (double)((float)p_78566_3_ + var9), (double)(var22 - var23 - var24), var12, var16);
      var5.func_78374_a((double)(var21 + var23 + var24), (double)((float)p_78566_3_ + var9), (double)(var22 - var23 + var24), var12, var14);
      var5.func_78374_a((double)(var21 + var23 - var24), (double)((float)p_78566_3_ + var9), (double)(var22 + var23 + var24), var10, var14);
      return true;
   }

   public void func_78606_a(Block p_78606_1_, int p_78606_2_, int p_78606_3_, double p_78606_4_, double p_78606_6_, double p_78606_8_, double p_78606_10_) {
      Tessellator var12 = Tessellator.field_78398_a;
      int var13 = p_78606_1_.func_71858_a(0, p_78606_2_) + 16;
      if(this.field_78664_d >= 0) {
         var13 = this.field_78664_d;
      }

      int var14 = (var13 & 15) << 4;
      int var15 = var13 & 240;
      double var16 = (double)((float)var14 / 256.0F);
      double var18 = (double)(((float)var14 + 15.99F) / 256.0F);
      double var20 = (double)((float)var15 / 256.0F);
      double var22 = ((double)var15 + 15.989999771118164D * p_78606_4_) / 256.0D;
      double var24 = p_78606_6_ + 0.5D - 0.5D;
      double var26 = p_78606_6_ + 0.5D + 0.5D;
      double var28 = p_78606_10_ + 0.5D - 0.5D;
      double var30 = p_78606_10_ + 0.5D + 0.5D;
      double var32 = p_78606_6_ + 0.5D;
      double var34 = p_78606_10_ + 0.5D;
      if((p_78606_3_ + 1) / 2 % 2 == 1) {
         double var36 = var18;
         var18 = var16;
         var16 = var36;
      }

      if(p_78606_3_ < 2) {
         var12.func_78374_a(var24, p_78606_8_ + p_78606_4_, var34, var16, var20);
         var12.func_78374_a(var24, p_78606_8_ + 0.0D, var34, var16, var22);
         var12.func_78374_a(var26, p_78606_8_ + 0.0D, var34, var18, var22);
         var12.func_78374_a(var26, p_78606_8_ + p_78606_4_, var34, var18, var20);
         var12.func_78374_a(var26, p_78606_8_ + p_78606_4_, var34, var18, var20);
         var12.func_78374_a(var26, p_78606_8_ + 0.0D, var34, var18, var22);
         var12.func_78374_a(var24, p_78606_8_ + 0.0D, var34, var16, var22);
         var12.func_78374_a(var24, p_78606_8_ + p_78606_4_, var34, var16, var20);
      } else {
         var12.func_78374_a(var32, p_78606_8_ + p_78606_4_, var30, var16, var20);
         var12.func_78374_a(var32, p_78606_8_ + 0.0D, var30, var16, var22);
         var12.func_78374_a(var32, p_78606_8_ + 0.0D, var28, var18, var22);
         var12.func_78374_a(var32, p_78606_8_ + p_78606_4_, var28, var18, var20);
         var12.func_78374_a(var32, p_78606_8_ + p_78606_4_, var28, var18, var20);
         var12.func_78374_a(var32, p_78606_8_ + 0.0D, var28, var18, var22);
         var12.func_78374_a(var32, p_78606_8_ + 0.0D, var30, var16, var22);
         var12.func_78374_a(var32, p_78606_8_ + p_78606_4_, var30, var16, var20);
      }

   }

   public void func_78579_b(Block p_78579_1_, int p_78579_2_, double p_78579_3_, double p_78579_5_, double p_78579_7_) {
      Tessellator var9 = Tessellator.field_78398_a;
      int var10 = p_78579_1_.func_71858_a(0, p_78579_2_);
      if(this.field_78664_d >= 0) {
         var10 = this.field_78664_d;
      }

      int var11 = (var10 & 15) << 4;
      int var12 = var10 & 240;
      double var13 = (double)((float)var11 / 256.0F);
      double var15 = (double)(((float)var11 + 15.99F) / 256.0F);
      double var17 = (double)((float)var12 / 256.0F);
      double var19 = (double)(((float)var12 + 15.99F) / 256.0F);
      double var21 = p_78579_3_ + 0.5D - 0.25D;
      double var23 = p_78579_3_ + 0.5D + 0.25D;
      double var25 = p_78579_7_ + 0.5D - 0.5D;
      double var27 = p_78579_7_ + 0.5D + 0.5D;
      var9.func_78374_a(var21, p_78579_5_ + 1.0D, var25, var13, var17);
      var9.func_78374_a(var21, p_78579_5_ + 0.0D, var25, var13, var19);
      var9.func_78374_a(var21, p_78579_5_ + 0.0D, var27, var15, var19);
      var9.func_78374_a(var21, p_78579_5_ + 1.0D, var27, var15, var17);
      var9.func_78374_a(var21, p_78579_5_ + 1.0D, var27, var13, var17);
      var9.func_78374_a(var21, p_78579_5_ + 0.0D, var27, var13, var19);
      var9.func_78374_a(var21, p_78579_5_ + 0.0D, var25, var15, var19);
      var9.func_78374_a(var21, p_78579_5_ + 1.0D, var25, var15, var17);
      var9.func_78374_a(var23, p_78579_5_ + 1.0D, var27, var13, var17);
      var9.func_78374_a(var23, p_78579_5_ + 0.0D, var27, var13, var19);
      var9.func_78374_a(var23, p_78579_5_ + 0.0D, var25, var15, var19);
      var9.func_78374_a(var23, p_78579_5_ + 1.0D, var25, var15, var17);
      var9.func_78374_a(var23, p_78579_5_ + 1.0D, var25, var13, var17);
      var9.func_78374_a(var23, p_78579_5_ + 0.0D, var25, var13, var19);
      var9.func_78374_a(var23, p_78579_5_ + 0.0D, var27, var15, var19);
      var9.func_78374_a(var23, p_78579_5_ + 1.0D, var27, var15, var17);
      var21 = p_78579_3_ + 0.5D - 0.5D;
      var23 = p_78579_3_ + 0.5D + 0.5D;
      var25 = p_78579_7_ + 0.5D - 0.25D;
      var27 = p_78579_7_ + 0.5D + 0.25D;
      var9.func_78374_a(var21, p_78579_5_ + 1.0D, var25, var13, var17);
      var9.func_78374_a(var21, p_78579_5_ + 0.0D, var25, var13, var19);
      var9.func_78374_a(var23, p_78579_5_ + 0.0D, var25, var15, var19);
      var9.func_78374_a(var23, p_78579_5_ + 1.0D, var25, var15, var17);
      var9.func_78374_a(var23, p_78579_5_ + 1.0D, var25, var13, var17);
      var9.func_78374_a(var23, p_78579_5_ + 0.0D, var25, var13, var19);
      var9.func_78374_a(var21, p_78579_5_ + 0.0D, var25, var15, var19);
      var9.func_78374_a(var21, p_78579_5_ + 1.0D, var25, var15, var17);
      var9.func_78374_a(var23, p_78579_5_ + 1.0D, var27, var13, var17);
      var9.func_78374_a(var23, p_78579_5_ + 0.0D, var27, var13, var19);
      var9.func_78374_a(var21, p_78579_5_ + 0.0D, var27, var15, var19);
      var9.func_78374_a(var21, p_78579_5_ + 1.0D, var27, var15, var17);
      var9.func_78374_a(var21, p_78579_5_ + 1.0D, var27, var13, var17);
      var9.func_78374_a(var21, p_78579_5_ + 0.0D, var27, var13, var19);
      var9.func_78374_a(var23, p_78579_5_ + 0.0D, var27, var15, var19);
      var9.func_78374_a(var23, p_78579_5_ + 1.0D, var27, var15, var17);
   }

   public boolean func_78621_p(Block p_78621_1_, int p_78621_2_, int p_78621_3_, int p_78621_4_) {
      Tessellator var5 = Tessellator.field_78398_a;
      int var6 = p_78621_1_.func_71920_b(this.field_78669_a, p_78621_2_, p_78621_3_, p_78621_4_);
      float var7 = (float)(var6 >> 16 & 255) / 255.0F;
      float var8 = (float)(var6 >> 8 & 255) / 255.0F;
      float var9 = (float)(var6 & 255) / 255.0F;
      boolean var10 = p_78621_1_.func_71877_c(this.field_78669_a, p_78621_2_, p_78621_3_ + 1, p_78621_4_, 1);
      boolean var11 = p_78621_1_.func_71877_c(this.field_78669_a, p_78621_2_, p_78621_3_ - 1, p_78621_4_, 0);
      boolean[] var12 = new boolean[]{p_78621_1_.func_71877_c(this.field_78669_a, p_78621_2_, p_78621_3_, p_78621_4_ - 1, 2), p_78621_1_.func_71877_c(this.field_78669_a, p_78621_2_, p_78621_3_, p_78621_4_ + 1, 3), p_78621_1_.func_71877_c(this.field_78669_a, p_78621_2_ - 1, p_78621_3_, p_78621_4_, 4), p_78621_1_.func_71877_c(this.field_78669_a, p_78621_2_ + 1, p_78621_3_, p_78621_4_, 5)};
      if(!var10 && !var11 && !var12[0] && !var12[1] && !var12[2] && !var12[3]) {
         return false;
      } else {
         boolean var13 = false;
         float var14 = 0.5F;
         float var15 = 1.0F;
         float var16 = 0.8F;
         float var17 = 0.6F;
         double var18 = 0.0D;
         double var20 = 1.0D;
         Material var22 = p_78621_1_.field_72018_cp;
         int var23 = this.field_78669_a.func_72805_g(p_78621_2_, p_78621_3_, p_78621_4_);
         double var24 = (double)this.func_78596_a(p_78621_2_, p_78621_3_, p_78621_4_, var22);
         double var26 = (double)this.func_78596_a(p_78621_2_, p_78621_3_, p_78621_4_ + 1, var22);
         double var28 = (double)this.func_78596_a(p_78621_2_ + 1, p_78621_3_, p_78621_4_ + 1, var22);
         double var30 = (double)this.func_78596_a(p_78621_2_ + 1, p_78621_3_, p_78621_4_, var22);
         double var32 = 0.0010000000474974513D;
         int var34;
         int var37;
         if(this.field_78661_f || var10) {
            var13 = true;
            var34 = p_78621_1_.func_71858_a(1, var23);
            float var35 = (float)BlockFluid.func_72204_a(this.field_78669_a, p_78621_2_, p_78621_3_, p_78621_4_, var22);
            if(var35 > -999.0F) {
               var34 = p_78621_1_.func_71858_a(2, var23);
            }

            var24 -= var32;
            var26 -= var32;
            var28 -= var32;
            var30 -= var32;
            int var36 = (var34 & 15) << 4;
            var37 = var34 & 240;
            double var38 = ((double)var36 + 8.0D) / 256.0D;
            double var40 = ((double)var37 + 8.0D) / 256.0D;
            if(var35 < -999.0F) {
               var35 = 0.0F;
            } else {
               var38 = (double)((float)(var36 + 16) / 256.0F);
               var40 = (double)((float)(var37 + 16) / 256.0F);
            }

            double var42 = (double)(MathHelper.func_76126_a(var35) * 8.0F) / 256.0D;
            double var44 = (double)(MathHelper.func_76134_b(var35) * 8.0F) / 256.0D;
            var5.func_78380_c(p_78621_1_.func_71874_e(this.field_78669_a, p_78621_2_, p_78621_3_, p_78621_4_));
            float var46 = 1.0F;
            var5.func_78386_a(var15 * var46 * var7, var15 * var46 * var8, var15 * var46 * var9);
            var5.func_78374_a((double)(p_78621_2_ + 0), (double)p_78621_3_ + var24, (double)(p_78621_4_ + 0), var38 - var44 - var42, var40 - var44 + var42);
            var5.func_78374_a((double)(p_78621_2_ + 0), (double)p_78621_3_ + var26, (double)(p_78621_4_ + 1), var38 - var44 + var42, var40 + var44 + var42);
            var5.func_78374_a((double)(p_78621_2_ + 1), (double)p_78621_3_ + var28, (double)(p_78621_4_ + 1), var38 + var44 + var42, var40 + var44 - var42);
            var5.func_78374_a((double)(p_78621_2_ + 1), (double)p_78621_3_ + var30, (double)(p_78621_4_ + 0), var38 + var44 - var42, var40 - var44 - var42);
         }

         if(this.field_78661_f || var11) {
            var5.func_78380_c(p_78621_1_.func_71874_e(this.field_78669_a, p_78621_2_, p_78621_3_ - 1, p_78621_4_));
            float var65 = 1.0F;
            var5.func_78386_a(var14 * var65, var14 * var65, var14 * var65);
            this.func_78613_a(p_78621_1_, (double)p_78621_2_, (double)p_78621_3_ + var32, (double)p_78621_4_, p_78621_1_.func_71851_a(0));
            var13 = true;
         }

         for(var34 = 0; var34 < 4; ++var34) {
            int var64 = p_78621_2_;
            var37 = p_78621_4_;
            if(var34 == 0) {
               var37 = p_78621_4_ - 1;
            }

            if(var34 == 1) {
               ++var37;
            }

            if(var34 == 2) {
               var64 = p_78621_2_ - 1;
            }

            if(var34 == 3) {
               ++var64;
            }

            int var66 = p_78621_1_.func_71858_a(var34 + 2, var23);
            int var39 = (var66 & 15) << 4;
            int var67 = var66 & 240;
            if(this.field_78661_f || var12[var34]) {
               double var43;
               double var41;
               double var47;
               double var45;
               double var51;
               double var49;
               if(var34 == 0) {
                  var41 = var24;
                  var43 = var30;
                  var45 = (double)p_78621_2_;
                  var49 = (double)(p_78621_2_ + 1);
                  var47 = (double)p_78621_4_ + var32;
                  var51 = (double)p_78621_4_ + var32;
               } else if(var34 == 1) {
                  var41 = var28;
                  var43 = var26;
                  var45 = (double)(p_78621_2_ + 1);
                  var49 = (double)p_78621_2_;
                  var47 = (double)(p_78621_4_ + 1) - var32;
                  var51 = (double)(p_78621_4_ + 1) - var32;
               } else if(var34 == 2) {
                  var41 = var26;
                  var43 = var24;
                  var45 = (double)p_78621_2_ + var32;
                  var49 = (double)p_78621_2_ + var32;
                  var47 = (double)(p_78621_4_ + 1);
                  var51 = (double)p_78621_4_;
               } else {
                  var41 = var30;
                  var43 = var28;
                  var45 = (double)(p_78621_2_ + 1) - var32;
                  var49 = (double)(p_78621_2_ + 1) - var32;
                  var47 = (double)p_78621_4_;
                  var51 = (double)(p_78621_4_ + 1);
               }

               var13 = true;
               double var53 = (double)((float)(var39 + 0) / 256.0F);
               double var55 = ((double)(var39 + 16) - 0.01D) / 256.0D;
               double var57 = ((double)var67 + (1.0D - var41) * 16.0D) / 256.0D;
               double var59 = ((double)var67 + (1.0D - var43) * 16.0D) / 256.0D;
               double var61 = ((double)(var67 + 16) - 0.01D) / 256.0D;
               var5.func_78380_c(p_78621_1_.func_71874_e(this.field_78669_a, var64, p_78621_3_, var37));
               float var63 = 1.0F;
               if(var34 < 2) {
                  var63 *= var16;
               } else {
                  var63 *= var17;
               }

               var5.func_78386_a(var15 * var63 * var7, var15 * var63 * var8, var15 * var63 * var9);
               var5.func_78374_a(var45, (double)p_78621_3_ + var41, var47, var53, var57);
               var5.func_78374_a(var49, (double)p_78621_3_ + var43, var51, var55, var59);
               var5.func_78374_a(var49, (double)(p_78621_3_ + 0), var51, var55, var61);
               var5.func_78374_a(var45, (double)(p_78621_3_ + 0), var47, var53, var61);
            }
         }

         p_78621_1_.field_72023_ci = var18;
         p_78621_1_.field_72022_cl = var20;
         return var13;
      }
   }

   private float func_78596_a(int p_78596_1_, int p_78596_2_, int p_78596_3_, Material p_78596_4_) {
      int var5 = 0;
      float var6 = 0.0F;

      for(int var7 = 0; var7 < 4; ++var7) {
         int var8 = p_78596_1_ - (var7 & 1);
         int var10 = p_78596_3_ - (var7 >> 1 & 1);
         if(this.field_78669_a.func_72803_f(var8, p_78596_2_ + 1, var10) == p_78596_4_) {
            return 1.0F;
         }

         Material var11 = this.field_78669_a.func_72803_f(var8, p_78596_2_, var10);
         if(var11 == p_78596_4_) {
            int var12 = this.field_78669_a.func_72805_g(var8, p_78596_2_, var10);
            if(var12 >= 8 || var12 == 0) {
               var6 += BlockFluid.func_72199_d(var12) * 10.0F;
               var5 += 10;
            }

            var6 += BlockFluid.func_72199_d(var12);
            ++var5;
         } else if(!var11.func_76220_a()) {
            ++var6;
            ++var5;
         }
      }

      return 1.0F - var6 / (float)var5;
   }

   public void func_78588_a(Block p_78588_1_, World p_78588_2_, int p_78588_3_, int p_78588_4_, int p_78588_5_, int p_78588_6_) {
      float var7 = 0.5F;
      float var8 = 1.0F;
      float var9 = 0.8F;
      float var10 = 0.6F;
      Tessellator var11 = Tessellator.field_78398_a;
      var11.func_78382_b();
      var11.func_78380_c(p_78588_1_.func_71874_e(p_78588_2_, p_78588_3_, p_78588_4_, p_78588_5_));
      float var12 = 1.0F;
      float var13 = 1.0F;
      if(var13 < var12) {
         var13 = var12;
      }

      var11.func_78386_a(var7 * var13, var7 * var13, var7 * var13);
      this.func_78613_a(p_78588_1_, -0.5D, -0.5D, -0.5D, p_78588_1_.func_71858_a(0, p_78588_6_));
      var13 = 1.0F;
      if(var13 < var12) {
         var13 = var12;
      }

      var11.func_78386_a(var8 * var13, var8 * var13, var8 * var13);
      this.func_78617_b(p_78588_1_, -0.5D, -0.5D, -0.5D, p_78588_1_.func_71858_a(1, p_78588_6_));
      var13 = 1.0F;
      if(var13 < var12) {
         var13 = var12;
      }

      var11.func_78386_a(var9 * var13, var9 * var13, var9 * var13);
      this.func_78611_c(p_78588_1_, -0.5D, -0.5D, -0.5D, p_78588_1_.func_71858_a(2, p_78588_6_));
      var13 = 1.0F;
      if(var13 < var12) {
         var13 = var12;
      }

      var11.func_78386_a(var9 * var13, var9 * var13, var9 * var13);
      this.func_78622_d(p_78588_1_, -0.5D, -0.5D, -0.5D, p_78588_1_.func_71858_a(3, p_78588_6_));
      var13 = 1.0F;
      if(var13 < var12) {
         var13 = var12;
      }

      var11.func_78386_a(var10 * var13, var10 * var13, var10 * var13);
      this.func_78573_e(p_78588_1_, -0.5D, -0.5D, -0.5D, p_78588_1_.func_71858_a(4, p_78588_6_));
      var13 = 1.0F;
      if(var13 < var12) {
         var13 = var12;
      }

      var11.func_78386_a(var10 * var13, var10 * var13, var10 * var13);
      this.func_78605_f(p_78588_1_, -0.5D, -0.5D, -0.5D, p_78588_1_.func_71858_a(5, p_78588_6_));
      var11.func_78381_a();
   }

   public boolean func_78570_q(Block p_78570_1_, int p_78570_2_, int p_78570_3_, int p_78570_4_) {
      int var5 = p_78570_1_.func_71920_b(this.field_78669_a, p_78570_2_, p_78570_3_, p_78570_4_);
      float var6 = (float)(var5 >> 16 & 255) / 255.0F;
      float var7 = (float)(var5 >> 8 & 255) / 255.0F;
      float var8 = (float)(var5 & 255) / 255.0F;
      if(EntityRenderer.field_78517_a) {
         float var9 = (var6 * 30.0F + var7 * 59.0F + var8 * 11.0F) / 100.0F;
         float var10 = (var6 * 30.0F + var7 * 70.0F) / 100.0F;
         float var11 = (var6 * 30.0F + var8 * 70.0F) / 100.0F;
         var6 = var9;
         var7 = var10;
         var8 = var11;
      }

      return Minecraft.func_71379_u() && Block.field_71984_q[p_78570_1_.field_71990_ca] == 0?this.func_78578_a(p_78570_1_, p_78570_2_, p_78570_3_, p_78570_4_, var6, var7, var8):this.func_78609_c(p_78570_1_, p_78570_2_, p_78570_3_, p_78570_4_, var6, var7, var8);
   }

   public boolean func_78581_r(Block p_78581_1_, int p_78581_2_, int p_78581_3_, int p_78581_4_) {
      int var5 = this.field_78669_a.func_72805_g(p_78581_2_, p_78581_3_, p_78581_4_);
      int var6 = var5 & 12;
      if(var6 == 4) {
         this.field_78662_g = 1;
         this.field_78683_h = 1;
         this.field_78681_k = 1;
         this.field_78675_l = 1;
      } else if(var6 == 8) {
         this.field_78685_i = 1;
         this.field_78679_j = 1;
      }

      boolean var7 = this.func_78570_q(p_78581_1_, p_78581_2_, p_78581_3_, p_78581_4_);
      this.field_78685_i = 0;
      this.field_78662_g = 0;
      this.field_78683_h = 0;
      this.field_78679_j = 0;
      this.field_78681_k = 0;
      this.field_78675_l = 0;
      return var7;
   }

   public boolean func_78578_a(Block p_78578_1_, int p_78578_2_, int p_78578_3_, int p_78578_4_, float p_78578_5_, float p_78578_6_, float p_78578_7_) {
      this.field_78677_m = true;
      boolean var8 = false;
      float var9 = this.field_78671_n;
      float var10 = this.field_78671_n;
      float var11 = this.field_78671_n;
      float var12 = this.field_78671_n;
      boolean var13 = true;
      boolean var14 = true;
      boolean var15 = true;
      boolean var16 = true;
      boolean var17 = true;
      boolean var18 = true;
      this.field_78671_n = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_);
      this.field_78673_o = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_ - 1, p_78578_3_, p_78578_4_);
      this.field_78701_p = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_, p_78578_3_ - 1, p_78578_4_);
      this.field_78699_q = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_ - 1);
      this.field_78697_r = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_ + 1, p_78578_3_, p_78578_4_);
      this.field_78695_s = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_, p_78578_3_ + 1, p_78578_4_);
      this.field_78693_t = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_ + 1);
      int var19 = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_);
      int var20 = var19;
      int var21 = var19;
      int var22 = var19;
      int var23 = var19;
      int var24 = var19;
      int var25 = var19;
      if(p_78578_1_.field_72023_ci <= 0.0D) {
         var21 = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_, p_78578_3_ - 1, p_78578_4_);
      }

      if(p_78578_1_.field_72022_cl >= 1.0D) {
         var24 = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_, p_78578_3_ + 1, p_78578_4_);
      }

      if(p_78578_1_.field_72026_ch <= 0.0D) {
         var20 = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_ - 1, p_78578_3_, p_78578_4_);
      }

      if(p_78578_1_.field_72021_ck >= 1.0D) {
         var23 = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_ + 1, p_78578_3_, p_78578_4_);
      }

      if(p_78578_1_.field_72024_cj <= 0.0D) {
         var22 = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_ - 1);
      }

      if(p_78578_1_.field_72019_cm >= 1.0D) {
         var25 = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_ + 1);
      }

      Tessellator var26 = Tessellator.field_78398_a;
      var26.func_78380_c(983055);
      this.field_78654_aE = Block.field_71985_p[this.field_78669_a.func_72798_a(p_78578_2_ + 1, p_78578_3_ + 1, p_78578_4_)];
      this.field_78646_aM = Block.field_71985_p[this.field_78669_a.func_72798_a(p_78578_2_ + 1, p_78578_3_ - 1, p_78578_4_)];
      this.field_78638_aI = Block.field_71985_p[this.field_78669_a.func_72798_a(p_78578_2_ + 1, p_78578_3_, p_78578_4_ + 1)];
      this.field_78642_aK = Block.field_71985_p[this.field_78669_a.func_72798_a(p_78578_2_ + 1, p_78578_3_, p_78578_4_ - 1)];
      this.field_78656_aF = Block.field_71985_p[this.field_78669_a.func_72798_a(p_78578_2_ - 1, p_78578_3_ + 1, p_78578_4_)];
      this.field_78647_aN = Block.field_71985_p[this.field_78669_a.func_72798_a(p_78578_2_ - 1, p_78578_3_ - 1, p_78578_4_)];
      this.field_78659_aH = Block.field_71985_p[this.field_78669_a.func_72798_a(p_78578_2_ - 1, p_78578_3_, p_78578_4_ - 1)];
      this.field_78640_aJ = Block.field_71985_p[this.field_78669_a.func_72798_a(p_78578_2_ - 1, p_78578_3_, p_78578_4_ + 1)];
      this.field_78658_aG = Block.field_71985_p[this.field_78669_a.func_72798_a(p_78578_2_, p_78578_3_ + 1, p_78578_4_ + 1)];
      this.field_78653_aD = Block.field_71985_p[this.field_78669_a.func_72798_a(p_78578_2_, p_78578_3_ + 1, p_78578_4_ - 1)];
      this.field_78648_aO = Block.field_71985_p[this.field_78669_a.func_72798_a(p_78578_2_, p_78578_3_ - 1, p_78578_4_ + 1)];
      this.field_78644_aL = Block.field_71985_p[this.field_78669_a.func_72798_a(p_78578_2_, p_78578_3_ - 1, p_78578_4_ - 1)];
      if(p_78578_1_.field_72059_bZ == 3) {
         var18 = false;
         var17 = false;
         var16 = false;
         var15 = false;
         var13 = false;
      }

      if(this.field_78664_d >= 0) {
         var18 = false;
         var17 = false;
         var16 = false;
         var15 = false;
         var13 = false;
      }

      if(this.field_78661_f || p_78578_1_.func_71877_c(this.field_78669_a, p_78578_2_, p_78578_3_ - 1, p_78578_4_, 0)) {
         if(this.field_78698_am > 0) {
            if(p_78578_1_.field_72023_ci <= 0.0D) {
               --p_78578_3_;
            }

            this.field_78641_T = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_ - 1, p_78578_3_, p_78578_4_);
            this.field_78645_V = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_ - 1);
            this.field_78643_W = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_ + 1);
            this.field_78655_Y = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_ + 1, p_78578_3_, p_78578_4_);
            this.field_78689_v = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_ - 1, p_78578_3_, p_78578_4_);
            this.field_78712_x = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_ - 1);
            this.field_78710_y = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_ + 1);
            this.field_78628_A = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_ + 1, p_78578_3_, p_78578_4_);
            if(!this.field_78644_aL && !this.field_78647_aN) {
               this.field_78691_u = this.field_78689_v;
               this.field_78649_S = this.field_78641_T;
            } else {
               this.field_78691_u = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_ - 1, p_78578_3_, p_78578_4_ - 1);
               this.field_78649_S = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_ - 1, p_78578_3_, p_78578_4_ - 1);
            }

            if(!this.field_78648_aO && !this.field_78647_aN) {
               this.field_78687_w = this.field_78689_v;
               this.field_78639_U = this.field_78641_T;
            } else {
               this.field_78687_w = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_ - 1, p_78578_3_, p_78578_4_ + 1);
               this.field_78639_U = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_ - 1, p_78578_3_, p_78578_4_ + 1);
            }

            if(!this.field_78644_aL && !this.field_78646_aM) {
               this.field_78708_z = this.field_78628_A;
               this.field_78657_X = this.field_78655_Y;
            } else {
               this.field_78708_z = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_ + 1, p_78578_3_, p_78578_4_ - 1);
               this.field_78657_X = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_ + 1, p_78578_3_, p_78578_4_ - 1);
            }

            if(!this.field_78648_aO && !this.field_78646_aM) {
               this.field_78629_B = this.field_78628_A;
               this.field_78660_Z = this.field_78655_Y;
            } else {
               this.field_78629_B = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_ + 1, p_78578_3_, p_78578_4_ + 1);
               this.field_78660_Z = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_ + 1, p_78578_3_, p_78578_4_ + 1);
            }

            if(p_78578_1_.field_72023_ci <= 0.0D) {
               ++p_78578_3_;
            }

            var9 = (this.field_78687_w + this.field_78689_v + this.field_78710_y + this.field_78701_p) / 4.0F;
            var12 = (this.field_78710_y + this.field_78701_p + this.field_78629_B + this.field_78628_A) / 4.0F;
            var11 = (this.field_78701_p + this.field_78712_x + this.field_78628_A + this.field_78708_z) / 4.0F;
            var10 = (this.field_78689_v + this.field_78691_u + this.field_78701_p + this.field_78712_x) / 4.0F;
            this.field_78700_an = this.func_78602_a(this.field_78639_U, this.field_78641_T, this.field_78643_W, var21);
            this.field_78676_aq = this.func_78602_a(this.field_78643_W, this.field_78660_Z, this.field_78655_Y, var21);
            this.field_78696_ap = this.func_78602_a(this.field_78645_V, this.field_78655_Y, this.field_78657_X, var21);
            this.field_78694_ao = this.func_78602_a(this.field_78641_T, this.field_78649_S, this.field_78645_V, var21);
         } else {
            var12 = this.field_78701_p;
            var11 = this.field_78701_p;
            var10 = this.field_78701_p;
            var9 = this.field_78701_p;
            this.field_78700_an = this.field_78694_ao = this.field_78696_ap = this.field_78676_aq = this.field_78641_T;
         }

         this.field_78674_ar = this.field_78672_as = this.field_78670_at = this.field_78684_au = (var13?p_78578_5_:1.0F) * 0.5F;
         this.field_78682_av = this.field_78680_aw = this.field_78678_ax = this.field_78665_ay = (var13?p_78578_6_:1.0F) * 0.5F;
         this.field_78663_az = this.field_78650_aA = this.field_78651_aB = this.field_78652_aC = (var13?p_78578_7_:1.0F) * 0.5F;
         this.field_78674_ar *= var9;
         this.field_78682_av *= var9;
         this.field_78663_az *= var9;
         this.field_78672_as *= var10;
         this.field_78680_aw *= var10;
         this.field_78650_aA *= var10;
         this.field_78670_at *= var11;
         this.field_78678_ax *= var11;
         this.field_78651_aB *= var11;
         this.field_78684_au *= var12;
         this.field_78665_ay *= var12;
         this.field_78652_aC *= var12;
         this.func_78613_a(p_78578_1_, (double)p_78578_2_, (double)p_78578_3_, (double)p_78578_4_, p_78578_1_.func_71895_b(this.field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_, 0));
         var8 = true;
      }

      if(this.field_78661_f || p_78578_1_.func_71877_c(this.field_78669_a, p_78578_2_, p_78578_3_ + 1, p_78578_4_, 1)) {
         if(this.field_78698_am > 0) {
            if(p_78578_1_.field_72022_cl >= 1.0D) {
               ++p_78578_3_;
            }

            this.field_78705_ab = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_ - 1, p_78578_3_, p_78578_4_);
            this.field_78711_af = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_ + 1, p_78578_3_, p_78578_4_);
            this.field_78703_ad = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_ - 1);
            this.field_78706_ag = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_ + 1);
            this.field_78624_D = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_ - 1, p_78578_3_, p_78578_4_);
            this.field_78634_H = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_ + 1, p_78578_3_, p_78578_4_);
            this.field_78626_F = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_ - 1);
            this.field_78635_I = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_ + 1);
            if(!this.field_78653_aD && !this.field_78656_aF) {
               this.field_78630_C = this.field_78624_D;
               this.field_78704_aa = this.field_78705_ab;
            } else {
               this.field_78630_C = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_ - 1, p_78578_3_, p_78578_4_ - 1);
               this.field_78704_aa = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_ - 1, p_78578_3_, p_78578_4_ - 1);
            }

            if(!this.field_78653_aD && !this.field_78654_aE) {
               this.field_78627_G = this.field_78634_H;
               this.field_78709_ae = this.field_78711_af;
            } else {
               this.field_78627_G = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_ + 1, p_78578_3_, p_78578_4_ - 1);
               this.field_78709_ae = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_ + 1, p_78578_3_, p_78578_4_ - 1);
            }

            if(!this.field_78658_aG && !this.field_78656_aF) {
               this.field_78625_E = this.field_78624_D;
               this.field_78702_ac = this.field_78705_ab;
            } else {
               this.field_78625_E = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_ - 1, p_78578_3_, p_78578_4_ + 1);
               this.field_78702_ac = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_ - 1, p_78578_3_, p_78578_4_ + 1);
            }

            if(!this.field_78658_aG && !this.field_78654_aE) {
               this.field_78636_J = this.field_78634_H;
               this.field_78707_ah = this.field_78711_af;
            } else {
               this.field_78636_J = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_ + 1, p_78578_3_, p_78578_4_ + 1);
               this.field_78707_ah = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_ + 1, p_78578_3_, p_78578_4_ + 1);
            }

            if(p_78578_1_.field_72022_cl >= 1.0D) {
               --p_78578_3_;
            }

            var12 = (this.field_78625_E + this.field_78624_D + this.field_78635_I + this.field_78695_s) / 4.0F;
            var9 = (this.field_78635_I + this.field_78695_s + this.field_78636_J + this.field_78634_H) / 4.0F;
            var10 = (this.field_78695_s + this.field_78626_F + this.field_78634_H + this.field_78627_G) / 4.0F;
            var11 = (this.field_78624_D + this.field_78630_C + this.field_78695_s + this.field_78626_F) / 4.0F;
            this.field_78676_aq = this.func_78602_a(this.field_78702_ac, this.field_78705_ab, this.field_78706_ag, var24);
            this.field_78700_an = this.func_78602_a(this.field_78706_ag, this.field_78707_ah, this.field_78711_af, var24);
            this.field_78694_ao = this.func_78602_a(this.field_78703_ad, this.field_78711_af, this.field_78709_ae, var24);
            this.field_78696_ap = this.func_78602_a(this.field_78705_ab, this.field_78704_aa, this.field_78703_ad, var24);
         } else {
            var12 = this.field_78695_s;
            var11 = this.field_78695_s;
            var10 = this.field_78695_s;
            var9 = this.field_78695_s;
            this.field_78700_an = this.field_78694_ao = this.field_78696_ap = this.field_78676_aq = var24;
         }

         this.field_78674_ar = this.field_78672_as = this.field_78670_at = this.field_78684_au = var14?p_78578_5_:1.0F;
         this.field_78682_av = this.field_78680_aw = this.field_78678_ax = this.field_78665_ay = var14?p_78578_6_:1.0F;
         this.field_78663_az = this.field_78650_aA = this.field_78651_aB = this.field_78652_aC = var14?p_78578_7_:1.0F;
         this.field_78674_ar *= var9;
         this.field_78682_av *= var9;
         this.field_78663_az *= var9;
         this.field_78672_as *= var10;
         this.field_78680_aw *= var10;
         this.field_78650_aA *= var10;
         this.field_78670_at *= var11;
         this.field_78678_ax *= var11;
         this.field_78651_aB *= var11;
         this.field_78684_au *= var12;
         this.field_78665_ay *= var12;
         this.field_78652_aC *= var12;
         this.func_78617_b(p_78578_1_, (double)p_78578_2_, (double)p_78578_3_, (double)p_78578_4_, p_78578_1_.func_71895_b(this.field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_, 1));
         var8 = true;
      }

      int var27;
      if(this.field_78661_f || p_78578_1_.func_71877_c(this.field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_ - 1, 2)) {
         if(this.field_78698_am > 0) {
            if(p_78578_1_.field_72024_cj <= 0.0D) {
               --p_78578_4_;
            }

            this.field_78637_K = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_ - 1, p_78578_3_, p_78578_4_);
            this.field_78712_x = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_, p_78578_3_ - 1, p_78578_4_);
            this.field_78626_F = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_, p_78578_3_ + 1, p_78578_4_);
            this.field_78631_L = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_ + 1, p_78578_3_, p_78578_4_);
            this.field_78690_ai = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_ - 1, p_78578_3_, p_78578_4_);
            this.field_78645_V = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_, p_78578_3_ - 1, p_78578_4_);
            this.field_78703_ad = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_, p_78578_3_ + 1, p_78578_4_);
            this.field_78692_aj = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_ + 1, p_78578_3_, p_78578_4_);
            if(!this.field_78659_aH && !this.field_78644_aL) {
               this.field_78691_u = this.field_78637_K;
               this.field_78649_S = this.field_78690_ai;
            } else {
               this.field_78691_u = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_ - 1, p_78578_3_ - 1, p_78578_4_);
               this.field_78649_S = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_ - 1, p_78578_3_ - 1, p_78578_4_);
            }

            if(!this.field_78659_aH && !this.field_78653_aD) {
               this.field_78630_C = this.field_78637_K;
               this.field_78704_aa = this.field_78690_ai;
            } else {
               this.field_78630_C = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_ - 1, p_78578_3_ + 1, p_78578_4_);
               this.field_78704_aa = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_ - 1, p_78578_3_ + 1, p_78578_4_);
            }

            if(!this.field_78642_aK && !this.field_78644_aL) {
               this.field_78708_z = this.field_78631_L;
               this.field_78657_X = this.field_78692_aj;
            } else {
               this.field_78708_z = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_ + 1, p_78578_3_ - 1, p_78578_4_);
               this.field_78657_X = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_ + 1, p_78578_3_ - 1, p_78578_4_);
            }

            if(!this.field_78642_aK && !this.field_78653_aD) {
               this.field_78627_G = this.field_78631_L;
               this.field_78709_ae = this.field_78692_aj;
            } else {
               this.field_78627_G = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_ + 1, p_78578_3_ + 1, p_78578_4_);
               this.field_78709_ae = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_ + 1, p_78578_3_ + 1, p_78578_4_);
            }

            if(p_78578_1_.field_72024_cj <= 0.0D) {
               ++p_78578_4_;
            }

            var9 = (this.field_78637_K + this.field_78630_C + this.field_78699_q + this.field_78626_F) / 4.0F;
            var10 = (this.field_78699_q + this.field_78626_F + this.field_78631_L + this.field_78627_G) / 4.0F;
            var11 = (this.field_78712_x + this.field_78699_q + this.field_78708_z + this.field_78631_L) / 4.0F;
            var12 = (this.field_78691_u + this.field_78637_K + this.field_78712_x + this.field_78699_q) / 4.0F;
            this.field_78700_an = this.func_78602_a(this.field_78690_ai, this.field_78704_aa, this.field_78703_ad, var22);
            this.field_78694_ao = this.func_78602_a(this.field_78703_ad, this.field_78692_aj, this.field_78709_ae, var22);
            this.field_78696_ap = this.func_78602_a(this.field_78645_V, this.field_78657_X, this.field_78692_aj, var22);
            this.field_78676_aq = this.func_78602_a(this.field_78649_S, this.field_78690_ai, this.field_78645_V, var22);
         } else {
            var12 = this.field_78699_q;
            var11 = this.field_78699_q;
            var10 = this.field_78699_q;
            var9 = this.field_78699_q;
            this.field_78700_an = this.field_78694_ao = this.field_78696_ap = this.field_78676_aq = var22;
         }

         this.field_78674_ar = this.field_78672_as = this.field_78670_at = this.field_78684_au = (var15?p_78578_5_:1.0F) * 0.8F;
         this.field_78682_av = this.field_78680_aw = this.field_78678_ax = this.field_78665_ay = (var15?p_78578_6_:1.0F) * 0.8F;
         this.field_78663_az = this.field_78650_aA = this.field_78651_aB = this.field_78652_aC = (var15?p_78578_7_:1.0F) * 0.8F;
         this.field_78674_ar *= var9;
         this.field_78682_av *= var9;
         this.field_78663_az *= var9;
         this.field_78672_as *= var10;
         this.field_78680_aw *= var10;
         this.field_78650_aA *= var10;
         this.field_78670_at *= var11;
         this.field_78678_ax *= var11;
         this.field_78651_aB *= var11;
         this.field_78684_au *= var12;
         this.field_78665_ay *= var12;
         this.field_78652_aC *= var12;
         var27 = p_78578_1_.func_71895_b(this.field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_, 2);
         this.func_78611_c(p_78578_1_, (double)p_78578_2_, (double)p_78578_3_, (double)p_78578_4_, var27);
         if(field_78667_b && var27 == 3 && this.field_78664_d < 0) {
            this.field_78674_ar *= p_78578_5_;
            this.field_78672_as *= p_78578_5_;
            this.field_78670_at *= p_78578_5_;
            this.field_78684_au *= p_78578_5_;
            this.field_78682_av *= p_78578_6_;
            this.field_78680_aw *= p_78578_6_;
            this.field_78678_ax *= p_78578_6_;
            this.field_78665_ay *= p_78578_6_;
            this.field_78663_az *= p_78578_7_;
            this.field_78650_aA *= p_78578_7_;
            this.field_78651_aB *= p_78578_7_;
            this.field_78652_aC *= p_78578_7_;
            this.func_78611_c(p_78578_1_, (double)p_78578_2_, (double)p_78578_3_, (double)p_78578_4_, 38);
         }

         var8 = true;
      }

      if(this.field_78661_f || p_78578_1_.func_71877_c(this.field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_ + 1, 3)) {
         if(this.field_78698_am > 0) {
            if(p_78578_1_.field_72019_cm >= 1.0D) {
               ++p_78578_4_;
            }

            this.field_78632_M = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_ - 1, p_78578_3_, p_78578_4_);
            this.field_78633_N = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_ + 1, p_78578_3_, p_78578_4_);
            this.field_78710_y = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_, p_78578_3_ - 1, p_78578_4_);
            this.field_78635_I = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_, p_78578_3_ + 1, p_78578_4_);
            this.field_78686_ak = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_ - 1, p_78578_3_, p_78578_4_);
            this.field_78688_al = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_ + 1, p_78578_3_, p_78578_4_);
            this.field_78643_W = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_, p_78578_3_ - 1, p_78578_4_);
            this.field_78706_ag = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_, p_78578_3_ + 1, p_78578_4_);
            if(!this.field_78640_aJ && !this.field_78648_aO) {
               this.field_78687_w = this.field_78632_M;
               this.field_78639_U = this.field_78686_ak;
            } else {
               this.field_78687_w = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_ - 1, p_78578_3_ - 1, p_78578_4_);
               this.field_78639_U = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_ - 1, p_78578_3_ - 1, p_78578_4_);
            }

            if(!this.field_78640_aJ && !this.field_78658_aG) {
               this.field_78625_E = this.field_78632_M;
               this.field_78702_ac = this.field_78686_ak;
            } else {
               this.field_78625_E = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_ - 1, p_78578_3_ + 1, p_78578_4_);
               this.field_78702_ac = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_ - 1, p_78578_3_ + 1, p_78578_4_);
            }

            if(!this.field_78638_aI && !this.field_78648_aO) {
               this.field_78629_B = this.field_78633_N;
               this.field_78660_Z = this.field_78688_al;
            } else {
               this.field_78629_B = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_ + 1, p_78578_3_ - 1, p_78578_4_);
               this.field_78660_Z = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_ + 1, p_78578_3_ - 1, p_78578_4_);
            }

            if(!this.field_78638_aI && !this.field_78658_aG) {
               this.field_78636_J = this.field_78633_N;
               this.field_78707_ah = this.field_78688_al;
            } else {
               this.field_78636_J = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_ + 1, p_78578_3_ + 1, p_78578_4_);
               this.field_78707_ah = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_ + 1, p_78578_3_ + 1, p_78578_4_);
            }

            if(p_78578_1_.field_72019_cm >= 1.0D) {
               --p_78578_4_;
            }

            var9 = (this.field_78632_M + this.field_78625_E + this.field_78693_t + this.field_78635_I) / 4.0F;
            var12 = (this.field_78693_t + this.field_78635_I + this.field_78633_N + this.field_78636_J) / 4.0F;
            var11 = (this.field_78710_y + this.field_78693_t + this.field_78629_B + this.field_78633_N) / 4.0F;
            var10 = (this.field_78687_w + this.field_78632_M + this.field_78710_y + this.field_78693_t) / 4.0F;
            this.field_78700_an = this.func_78602_a(this.field_78686_ak, this.field_78702_ac, this.field_78706_ag, var25);
            this.field_78676_aq = this.func_78602_a(this.field_78706_ag, this.field_78688_al, this.field_78707_ah, var25);
            this.field_78696_ap = this.func_78602_a(this.field_78643_W, this.field_78660_Z, this.field_78688_al, var25);
            this.field_78694_ao = this.func_78602_a(this.field_78639_U, this.field_78686_ak, this.field_78643_W, var25);
         } else {
            var12 = this.field_78693_t;
            var11 = this.field_78693_t;
            var10 = this.field_78693_t;
            var9 = this.field_78693_t;
            this.field_78700_an = this.field_78694_ao = this.field_78696_ap = this.field_78676_aq = var25;
         }

         this.field_78674_ar = this.field_78672_as = this.field_78670_at = this.field_78684_au = (var16?p_78578_5_:1.0F) * 0.8F;
         this.field_78682_av = this.field_78680_aw = this.field_78678_ax = this.field_78665_ay = (var16?p_78578_6_:1.0F) * 0.8F;
         this.field_78663_az = this.field_78650_aA = this.field_78651_aB = this.field_78652_aC = (var16?p_78578_7_:1.0F) * 0.8F;
         this.field_78674_ar *= var9;
         this.field_78682_av *= var9;
         this.field_78663_az *= var9;
         this.field_78672_as *= var10;
         this.field_78680_aw *= var10;
         this.field_78650_aA *= var10;
         this.field_78670_at *= var11;
         this.field_78678_ax *= var11;
         this.field_78651_aB *= var11;
         this.field_78684_au *= var12;
         this.field_78665_ay *= var12;
         this.field_78652_aC *= var12;
         var27 = p_78578_1_.func_71895_b(this.field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_, 3);
         this.func_78622_d(p_78578_1_, (double)p_78578_2_, (double)p_78578_3_, (double)p_78578_4_, p_78578_1_.func_71895_b(this.field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_, 3));
         if(field_78667_b && var27 == 3 && this.field_78664_d < 0) {
            this.field_78674_ar *= p_78578_5_;
            this.field_78672_as *= p_78578_5_;
            this.field_78670_at *= p_78578_5_;
            this.field_78684_au *= p_78578_5_;
            this.field_78682_av *= p_78578_6_;
            this.field_78680_aw *= p_78578_6_;
            this.field_78678_ax *= p_78578_6_;
            this.field_78665_ay *= p_78578_6_;
            this.field_78663_az *= p_78578_7_;
            this.field_78650_aA *= p_78578_7_;
            this.field_78651_aB *= p_78578_7_;
            this.field_78652_aC *= p_78578_7_;
            this.func_78622_d(p_78578_1_, (double)p_78578_2_, (double)p_78578_3_, (double)p_78578_4_, 38);
         }

         var8 = true;
      }

      if(this.field_78661_f || p_78578_1_.func_71877_c(this.field_78669_a, p_78578_2_ - 1, p_78578_3_, p_78578_4_, 4)) {
         if(this.field_78698_am > 0) {
            if(p_78578_1_.field_72026_ch <= 0.0D) {
               --p_78578_2_;
            }

            this.field_78689_v = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_, p_78578_3_ - 1, p_78578_4_);
            this.field_78637_K = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_ - 1);
            this.field_78632_M = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_ + 1);
            this.field_78624_D = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_, p_78578_3_ + 1, p_78578_4_);
            this.field_78641_T = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_, p_78578_3_ - 1, p_78578_4_);
            this.field_78690_ai = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_ - 1);
            this.field_78686_ak = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_ + 1);
            this.field_78705_ab = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_, p_78578_3_ + 1, p_78578_4_);
            if(!this.field_78659_aH && !this.field_78647_aN) {
               this.field_78691_u = this.field_78637_K;
               this.field_78649_S = this.field_78690_ai;
            } else {
               this.field_78691_u = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_, p_78578_3_ - 1, p_78578_4_ - 1);
               this.field_78649_S = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_, p_78578_3_ - 1, p_78578_4_ - 1);
            }

            if(!this.field_78640_aJ && !this.field_78647_aN) {
               this.field_78687_w = this.field_78632_M;
               this.field_78639_U = this.field_78686_ak;
            } else {
               this.field_78687_w = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_, p_78578_3_ - 1, p_78578_4_ + 1);
               this.field_78639_U = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_, p_78578_3_ - 1, p_78578_4_ + 1);
            }

            if(!this.field_78659_aH && !this.field_78656_aF) {
               this.field_78630_C = this.field_78637_K;
               this.field_78704_aa = this.field_78690_ai;
            } else {
               this.field_78630_C = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_, p_78578_3_ + 1, p_78578_4_ - 1);
               this.field_78704_aa = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_, p_78578_3_ + 1, p_78578_4_ - 1);
            }

            if(!this.field_78640_aJ && !this.field_78656_aF) {
               this.field_78625_E = this.field_78632_M;
               this.field_78702_ac = this.field_78686_ak;
            } else {
               this.field_78625_E = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_, p_78578_3_ + 1, p_78578_4_ + 1);
               this.field_78702_ac = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_, p_78578_3_ + 1, p_78578_4_ + 1);
            }

            if(p_78578_1_.field_72026_ch <= 0.0D) {
               ++p_78578_2_;
            }

            var12 = (this.field_78689_v + this.field_78687_w + this.field_78673_o + this.field_78632_M) / 4.0F;
            var9 = (this.field_78673_o + this.field_78632_M + this.field_78624_D + this.field_78625_E) / 4.0F;
            var10 = (this.field_78637_K + this.field_78673_o + this.field_78630_C + this.field_78624_D) / 4.0F;
            var11 = (this.field_78691_u + this.field_78689_v + this.field_78637_K + this.field_78673_o) / 4.0F;
            this.field_78676_aq = this.func_78602_a(this.field_78641_T, this.field_78639_U, this.field_78686_ak, var20);
            this.field_78700_an = this.func_78602_a(this.field_78686_ak, this.field_78705_ab, this.field_78702_ac, var20);
            this.field_78694_ao = this.func_78602_a(this.field_78690_ai, this.field_78704_aa, this.field_78705_ab, var20);
            this.field_78696_ap = this.func_78602_a(this.field_78649_S, this.field_78641_T, this.field_78690_ai, var20);
         } else {
            var12 = this.field_78673_o;
            var11 = this.field_78673_o;
            var10 = this.field_78673_o;
            var9 = this.field_78673_o;
            this.field_78700_an = this.field_78694_ao = this.field_78696_ap = this.field_78676_aq = var20;
         }

         this.field_78674_ar = this.field_78672_as = this.field_78670_at = this.field_78684_au = (var17?p_78578_5_:1.0F) * 0.6F;
         this.field_78682_av = this.field_78680_aw = this.field_78678_ax = this.field_78665_ay = (var17?p_78578_6_:1.0F) * 0.6F;
         this.field_78663_az = this.field_78650_aA = this.field_78651_aB = this.field_78652_aC = (var17?p_78578_7_:1.0F) * 0.6F;
         this.field_78674_ar *= var9;
         this.field_78682_av *= var9;
         this.field_78663_az *= var9;
         this.field_78672_as *= var10;
         this.field_78680_aw *= var10;
         this.field_78650_aA *= var10;
         this.field_78670_at *= var11;
         this.field_78678_ax *= var11;
         this.field_78651_aB *= var11;
         this.field_78684_au *= var12;
         this.field_78665_ay *= var12;
         this.field_78652_aC *= var12;
         var27 = p_78578_1_.func_71895_b(this.field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_, 4);
         this.func_78573_e(p_78578_1_, (double)p_78578_2_, (double)p_78578_3_, (double)p_78578_4_, var27);
         if(field_78667_b && var27 == 3 && this.field_78664_d < 0) {
            this.field_78674_ar *= p_78578_5_;
            this.field_78672_as *= p_78578_5_;
            this.field_78670_at *= p_78578_5_;
            this.field_78684_au *= p_78578_5_;
            this.field_78682_av *= p_78578_6_;
            this.field_78680_aw *= p_78578_6_;
            this.field_78678_ax *= p_78578_6_;
            this.field_78665_ay *= p_78578_6_;
            this.field_78663_az *= p_78578_7_;
            this.field_78650_aA *= p_78578_7_;
            this.field_78651_aB *= p_78578_7_;
            this.field_78652_aC *= p_78578_7_;
            this.func_78573_e(p_78578_1_, (double)p_78578_2_, (double)p_78578_3_, (double)p_78578_4_, 38);
         }

         var8 = true;
      }

      if(this.field_78661_f || p_78578_1_.func_71877_c(this.field_78669_a, p_78578_2_ + 1, p_78578_3_, p_78578_4_, 5)) {
         if(this.field_78698_am > 0) {
            if(p_78578_1_.field_72021_ck >= 1.0D) {
               ++p_78578_2_;
            }

            this.field_78628_A = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_, p_78578_3_ - 1, p_78578_4_);
            this.field_78631_L = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_ - 1);
            this.field_78633_N = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_ + 1);
            this.field_78634_H = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_, p_78578_3_ + 1, p_78578_4_);
            this.field_78655_Y = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_, p_78578_3_ - 1, p_78578_4_);
            this.field_78692_aj = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_ - 1);
            this.field_78688_al = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_ + 1);
            this.field_78711_af = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_, p_78578_3_ + 1, p_78578_4_);
            if(!this.field_78646_aM && !this.field_78642_aK) {
               this.field_78708_z = this.field_78631_L;
               this.field_78657_X = this.field_78692_aj;
            } else {
               this.field_78708_z = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_, p_78578_3_ - 1, p_78578_4_ - 1);
               this.field_78657_X = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_, p_78578_3_ - 1, p_78578_4_ - 1);
            }

            if(!this.field_78646_aM && !this.field_78638_aI) {
               this.field_78629_B = this.field_78633_N;
               this.field_78660_Z = this.field_78688_al;
            } else {
               this.field_78629_B = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_, p_78578_3_ - 1, p_78578_4_ + 1);
               this.field_78660_Z = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_, p_78578_3_ - 1, p_78578_4_ + 1);
            }

            if(!this.field_78654_aE && !this.field_78642_aK) {
               this.field_78627_G = this.field_78631_L;
               this.field_78709_ae = this.field_78692_aj;
            } else {
               this.field_78627_G = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_, p_78578_3_ + 1, p_78578_4_ - 1);
               this.field_78709_ae = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_, p_78578_3_ + 1, p_78578_4_ - 1);
            }

            if(!this.field_78654_aE && !this.field_78638_aI) {
               this.field_78636_J = this.field_78633_N;
               this.field_78707_ah = this.field_78688_al;
            } else {
               this.field_78636_J = p_78578_1_.func_71888_h(this.field_78669_a, p_78578_2_, p_78578_3_ + 1, p_78578_4_ + 1);
               this.field_78707_ah = p_78578_1_.func_71874_e(this.field_78669_a, p_78578_2_, p_78578_3_ + 1, p_78578_4_ + 1);
            }

            if(p_78578_1_.field_72021_ck >= 1.0D) {
               --p_78578_2_;
            }

            var9 = (this.field_78628_A + this.field_78629_B + this.field_78697_r + this.field_78633_N) / 4.0F;
            var12 = (this.field_78697_r + this.field_78633_N + this.field_78634_H + this.field_78636_J) / 4.0F;
            var11 = (this.field_78631_L + this.field_78697_r + this.field_78627_G + this.field_78634_H) / 4.0F;
            var10 = (this.field_78708_z + this.field_78628_A + this.field_78631_L + this.field_78697_r) / 4.0F;
            this.field_78700_an = this.func_78602_a(this.field_78655_Y, this.field_78660_Z, this.field_78688_al, var23);
            this.field_78676_aq = this.func_78602_a(this.field_78688_al, this.field_78711_af, this.field_78707_ah, var23);
            this.field_78696_ap = this.func_78602_a(this.field_78692_aj, this.field_78709_ae, this.field_78711_af, var23);
            this.field_78694_ao = this.func_78602_a(this.field_78657_X, this.field_78655_Y, this.field_78692_aj, var23);
         } else {
            var12 = this.field_78697_r;
            var11 = this.field_78697_r;
            var10 = this.field_78697_r;
            var9 = this.field_78697_r;
            this.field_78700_an = this.field_78694_ao = this.field_78696_ap = this.field_78676_aq = var23;
         }

         this.field_78674_ar = this.field_78672_as = this.field_78670_at = this.field_78684_au = (var18?p_78578_5_:1.0F) * 0.6F;
         this.field_78682_av = this.field_78680_aw = this.field_78678_ax = this.field_78665_ay = (var18?p_78578_6_:1.0F) * 0.6F;
         this.field_78663_az = this.field_78650_aA = this.field_78651_aB = this.field_78652_aC = (var18?p_78578_7_:1.0F) * 0.6F;
         this.field_78674_ar *= var9;
         this.field_78682_av *= var9;
         this.field_78663_az *= var9;
         this.field_78672_as *= var10;
         this.field_78680_aw *= var10;
         this.field_78650_aA *= var10;
         this.field_78670_at *= var11;
         this.field_78678_ax *= var11;
         this.field_78651_aB *= var11;
         this.field_78684_au *= var12;
         this.field_78665_ay *= var12;
         this.field_78652_aC *= var12;
         var27 = p_78578_1_.func_71895_b(this.field_78669_a, p_78578_2_, p_78578_3_, p_78578_4_, 5);
         this.func_78605_f(p_78578_1_, (double)p_78578_2_, (double)p_78578_3_, (double)p_78578_4_, var27);
         if(field_78667_b && var27 == 3 && this.field_78664_d < 0) {
            this.field_78674_ar *= p_78578_5_;
            this.field_78672_as *= p_78578_5_;
            this.field_78670_at *= p_78578_5_;
            this.field_78684_au *= p_78578_5_;
            this.field_78682_av *= p_78578_6_;
            this.field_78680_aw *= p_78578_6_;
            this.field_78678_ax *= p_78578_6_;
            this.field_78665_ay *= p_78578_6_;
            this.field_78663_az *= p_78578_7_;
            this.field_78650_aA *= p_78578_7_;
            this.field_78651_aB *= p_78578_7_;
            this.field_78652_aC *= p_78578_7_;
            this.func_78605_f(p_78578_1_, (double)p_78578_2_, (double)p_78578_3_, (double)p_78578_4_, 38);
         }

         var8 = true;
      }

      this.field_78677_m = false;
      return var8;
   }

   private int func_78602_a(int p_78602_1_, int p_78602_2_, int p_78602_3_, int p_78602_4_) {
      if(p_78602_1_ == 0) {
         p_78602_1_ = p_78602_4_;
      }

      if(p_78602_2_ == 0) {
         p_78602_2_ = p_78602_4_;
      }

      if(p_78602_3_ == 0) {
         p_78602_3_ = p_78602_4_;
      }

      return p_78602_1_ + p_78602_2_ + p_78602_3_ + p_78602_4_ >> 2 & 16711935;
   }

   public boolean func_78609_c(Block p_78609_1_, int p_78609_2_, int p_78609_3_, int p_78609_4_, float p_78609_5_, float p_78609_6_, float p_78609_7_) {
      this.field_78677_m = false;
      Tessellator var8 = Tessellator.field_78398_a;
      boolean var9 = false;
      float var10 = 0.5F;
      float var11 = 1.0F;
      float var12 = 0.8F;
      float var13 = 0.6F;
      float var14 = var11 * p_78609_5_;
      float var15 = var11 * p_78609_6_;
      float var16 = var11 * p_78609_7_;
      float var17 = var10;
      float var18 = var12;
      float var19 = var13;
      float var20 = var10;
      float var21 = var12;
      float var22 = var13;
      float var23 = var10;
      float var24 = var12;
      float var25 = var13;
      if(p_78609_1_ != Block.field_71980_u) {
         var17 = var10 * p_78609_5_;
         var18 = var12 * p_78609_5_;
         var19 = var13 * p_78609_5_;
         var20 = var10 * p_78609_6_;
         var21 = var12 * p_78609_6_;
         var22 = var13 * p_78609_6_;
         var23 = var10 * p_78609_7_;
         var24 = var12 * p_78609_7_;
         var25 = var13 * p_78609_7_;
      }

      int var26 = p_78609_1_.func_71874_e(this.field_78669_a, p_78609_2_, p_78609_3_, p_78609_4_);
      if(this.field_78661_f || p_78609_1_.func_71877_c(this.field_78669_a, p_78609_2_, p_78609_3_ - 1, p_78609_4_, 0)) {
         var8.func_78380_c(p_78609_1_.field_72023_ci > 0.0D?var26:p_78609_1_.func_71874_e(this.field_78669_a, p_78609_2_, p_78609_3_ - 1, p_78609_4_));
         var8.func_78386_a(var17, var20, var23);
         this.func_78613_a(p_78609_1_, (double)p_78609_2_, (double)p_78609_3_, (double)p_78609_4_, p_78609_1_.func_71895_b(this.field_78669_a, p_78609_2_, p_78609_3_, p_78609_4_, 0));
         var9 = true;
      }

      if(this.field_78661_f || p_78609_1_.func_71877_c(this.field_78669_a, p_78609_2_, p_78609_3_ + 1, p_78609_4_, 1)) {
         var8.func_78380_c(p_78609_1_.field_72022_cl < 1.0D?var26:p_78609_1_.func_71874_e(this.field_78669_a, p_78609_2_, p_78609_3_ + 1, p_78609_4_));
         var8.func_78386_a(var14, var15, var16);
         this.func_78617_b(p_78609_1_, (double)p_78609_2_, (double)p_78609_3_, (double)p_78609_4_, p_78609_1_.func_71895_b(this.field_78669_a, p_78609_2_, p_78609_3_, p_78609_4_, 1));
         var9 = true;
      }

      int var28;
      if(this.field_78661_f || p_78609_1_.func_71877_c(this.field_78669_a, p_78609_2_, p_78609_3_, p_78609_4_ - 1, 2)) {
         var8.func_78380_c(p_78609_1_.field_72024_cj > 0.0D?var26:p_78609_1_.func_71874_e(this.field_78669_a, p_78609_2_, p_78609_3_, p_78609_4_ - 1));
         var8.func_78386_a(var18, var21, var24);
         var28 = p_78609_1_.func_71895_b(this.field_78669_a, p_78609_2_, p_78609_3_, p_78609_4_, 2);
         this.func_78611_c(p_78609_1_, (double)p_78609_2_, (double)p_78609_3_, (double)p_78609_4_, var28);
         if(field_78667_b && var28 == 3 && this.field_78664_d < 0) {
            var8.func_78386_a(var18 * p_78609_5_, var21 * p_78609_6_, var24 * p_78609_7_);
            this.func_78611_c(p_78609_1_, (double)p_78609_2_, (double)p_78609_3_, (double)p_78609_4_, 38);
         }

         var9 = true;
      }

      if(this.field_78661_f || p_78609_1_.func_71877_c(this.field_78669_a, p_78609_2_, p_78609_3_, p_78609_4_ + 1, 3)) {
         var8.func_78380_c(p_78609_1_.field_72019_cm < 1.0D?var26:p_78609_1_.func_71874_e(this.field_78669_a, p_78609_2_, p_78609_3_, p_78609_4_ + 1));
         var8.func_78386_a(var18, var21, var24);
         var28 = p_78609_1_.func_71895_b(this.field_78669_a, p_78609_2_, p_78609_3_, p_78609_4_, 3);
         this.func_78622_d(p_78609_1_, (double)p_78609_2_, (double)p_78609_3_, (double)p_78609_4_, var28);
         if(field_78667_b && var28 == 3 && this.field_78664_d < 0) {
            var8.func_78386_a(var18 * p_78609_5_, var21 * p_78609_6_, var24 * p_78609_7_);
            this.func_78622_d(p_78609_1_, (double)p_78609_2_, (double)p_78609_3_, (double)p_78609_4_, 38);
         }

         var9 = true;
      }

      if(this.field_78661_f || p_78609_1_.func_71877_c(this.field_78669_a, p_78609_2_ - 1, p_78609_3_, p_78609_4_, 4)) {
         var8.func_78380_c(p_78609_1_.field_72026_ch > 0.0D?var26:p_78609_1_.func_71874_e(this.field_78669_a, p_78609_2_ - 1, p_78609_3_, p_78609_4_));
         var8.func_78386_a(var19, var22, var25);
         var28 = p_78609_1_.func_71895_b(this.field_78669_a, p_78609_2_, p_78609_3_, p_78609_4_, 4);
         this.func_78573_e(p_78609_1_, (double)p_78609_2_, (double)p_78609_3_, (double)p_78609_4_, var28);
         if(field_78667_b && var28 == 3 && this.field_78664_d < 0) {
            var8.func_78386_a(var19 * p_78609_5_, var22 * p_78609_6_, var25 * p_78609_7_);
            this.func_78573_e(p_78609_1_, (double)p_78609_2_, (double)p_78609_3_, (double)p_78609_4_, 38);
         }

         var9 = true;
      }

      if(this.field_78661_f || p_78609_1_.func_71877_c(this.field_78669_a, p_78609_2_ + 1, p_78609_3_, p_78609_4_, 5)) {
         var8.func_78380_c(p_78609_1_.field_72021_ck < 1.0D?var26:p_78609_1_.func_71874_e(this.field_78669_a, p_78609_2_ + 1, p_78609_3_, p_78609_4_));
         var8.func_78386_a(var19, var22, var25);
         var28 = p_78609_1_.func_71895_b(this.field_78669_a, p_78609_2_, p_78609_3_, p_78609_4_, 5);
         this.func_78605_f(p_78609_1_, (double)p_78609_2_, (double)p_78609_3_, (double)p_78609_4_, var28);
         if(field_78667_b && var28 == 3 && this.field_78664_d < 0) {
            var8.func_78386_a(var19 * p_78609_5_, var22 * p_78609_6_, var25 * p_78609_7_);
            this.func_78605_f(p_78609_1_, (double)p_78609_2_, (double)p_78609_3_, (double)p_78609_4_, 38);
         }

         var9 = true;
      }

      return var9;
   }

   private boolean func_78616_a(BlockCocoa p_78616_1_, int p_78616_2_, int p_78616_3_, int p_78616_4_) {
      Tessellator var5 = Tessellator.field_78398_a;
      var5.func_78380_c(p_78616_1_.func_71874_e(this.field_78669_a, p_78616_2_, p_78616_3_, p_78616_4_));
      var5.func_78386_a(1.0F, 1.0F, 1.0F);
      int var6 = this.field_78669_a.func_72805_g(p_78616_2_, p_78616_3_, p_78616_4_);
      int var7 = p_78616_1_.func_71851_a(1);
      int var8 = BlockDirectional.func_72217_d(var6);
      int var9 = BlockCocoa.func_72219_c(var6);
      var7 = var7 + 2 - var9;
      int var10 = 4 + var9 * 2;
      int var11 = 5 + var9 * 2;
      int var12 = (var7 & 15) << 4;
      int var13 = var7 & 240;
      double var14 = 15.0D - (double)var10;
      double var16 = 15.0D;
      double var18 = 4.0D;
      double var20 = 4.0D + (double)var11;
      double var22 = ((double)var12 + var14) / 256.0D;
      double var24 = ((double)var12 + var16 - 0.01D) / 256.0D;
      double var26 = ((double)var13 + var18) / 256.0D;
      double var28 = ((double)var13 + var20 - 0.01D) / 256.0D;
      double var30 = 0.0D;
      double var32 = 0.0D;
      switch(var8) {
      case 0:
         var30 = 8.0D - (double)(var10 / 2);
         var32 = 15.0D - (double)var10;
         break;
      case 1:
         var30 = 1.0D;
         var32 = 8.0D - (double)(var10 / 2);
         break;
      case 2:
         var30 = 8.0D - (double)(var10 / 2);
         var32 = 1.0D;
         break;
      case 3:
         var30 = 15.0D - (double)var10;
         var32 = 8.0D - (double)(var10 / 2);
      }

      double var34 = (double)p_78616_2_ + var30 / 16.0D;
      double var36 = (double)p_78616_2_ + (var30 + (double)var10) / 16.0D;
      double var38 = (double)p_78616_3_ + (12.0D - (double)var11) / 16.0D;
      double var40 = (double)p_78616_3_ + 0.75D;
      double var42 = (double)p_78616_4_ + var32 / 16.0D;
      double var44 = (double)p_78616_4_ + (var32 + (double)var10) / 16.0D;
      var5.func_78374_a(var34, var38, var42, var22, var28);
      var5.func_78374_a(var34, var38, var44, var24, var28);
      var5.func_78374_a(var34, var40, var44, var24, var26);
      var5.func_78374_a(var34, var40, var42, var22, var26);
      var5.func_78374_a(var36, var38, var44, var22, var28);
      var5.func_78374_a(var36, var38, var42, var24, var28);
      var5.func_78374_a(var36, var40, var42, var24, var26);
      var5.func_78374_a(var36, var40, var44, var22, var26);
      var5.func_78374_a(var36, var38, var42, var22, var28);
      var5.func_78374_a(var34, var38, var42, var24, var28);
      var5.func_78374_a(var34, var40, var42, var24, var26);
      var5.func_78374_a(var36, var40, var42, var22, var26);
      var5.func_78374_a(var34, var38, var44, var22, var28);
      var5.func_78374_a(var36, var38, var44, var24, var28);
      var5.func_78374_a(var36, var40, var44, var24, var26);
      var5.func_78374_a(var34, var40, var44, var22, var26);
      int var46 = var10;
      if(var9 >= 2) {
         var46 = var10 - 1;
      }

      var22 = (double)((float)(var12 + 0) / 256.0F);
      var24 = ((double)(var12 + var46) - 0.01D) / 256.0D;
      var26 = (double)((float)(var13 + 0) / 256.0F);
      var28 = ((double)(var13 + var46) - 0.01D) / 256.0D;
      var5.func_78374_a(var34, var40, var44, var22, var28);
      var5.func_78374_a(var36, var40, var44, var24, var28);
      var5.func_78374_a(var36, var40, var42, var24, var26);
      var5.func_78374_a(var34, var40, var42, var22, var26);
      var5.func_78374_a(var34, var38, var42, var22, var26);
      var5.func_78374_a(var36, var38, var42, var24, var26);
      var5.func_78374_a(var36, var38, var44, var24, var28);
      var5.func_78374_a(var34, var38, var44, var22, var28);
      var22 = (double)((float)(var12 + 12) / 256.0F);
      var24 = ((double)(var12 + 16) - 0.01D) / 256.0D;
      var26 = (double)((float)(var13 + 0) / 256.0F);
      var28 = ((double)(var13 + 4) - 0.01D) / 256.0D;
      var30 = 8.0D;
      var32 = 0.0D;
      double var47;
      switch(var8) {
      case 0:
         var30 = 8.0D;
         var32 = 12.0D;
         var47 = var22;
         var22 = var24;
         var24 = var47;
         break;
      case 1:
         var30 = 0.0D;
         var32 = 8.0D;
         break;
      case 2:
         var30 = 8.0D;
         var32 = 0.0D;
         break;
      case 3:
         var30 = 12.0D;
         var32 = 8.0D;
         var47 = var22;
         var22 = var24;
         var24 = var47;
      }

      var34 = (double)p_78616_2_ + var30 / 16.0D;
      var36 = (double)p_78616_2_ + (var30 + 4.0D) / 16.0D;
      var38 = (double)p_78616_3_ + 0.75D;
      var40 = (double)p_78616_3_ + 1.0D;
      var42 = (double)p_78616_4_ + var32 / 16.0D;
      var44 = (double)p_78616_4_ + (var32 + 4.0D) / 16.0D;
      if(var8 != 2 && var8 != 0) {
         if(var8 == 1 || var8 == 3) {
            var5.func_78374_a(var36, var38, var42, var22, var28);
            var5.func_78374_a(var34, var38, var42, var24, var28);
            var5.func_78374_a(var34, var40, var42, var24, var26);
            var5.func_78374_a(var36, var40, var42, var22, var26);
            var5.func_78374_a(var34, var38, var42, var24, var28);
            var5.func_78374_a(var36, var38, var42, var22, var28);
            var5.func_78374_a(var36, var40, var42, var22, var26);
            var5.func_78374_a(var34, var40, var42, var24, var26);
         }
      } else {
         var5.func_78374_a(var34, var38, var42, var24, var28);
         var5.func_78374_a(var34, var38, var44, var22, var28);
         var5.func_78374_a(var34, var40, var44, var22, var26);
         var5.func_78374_a(var34, var40, var42, var24, var26);
         var5.func_78374_a(var34, var38, var44, var22, var28);
         var5.func_78374_a(var34, var38, var42, var24, var28);
         var5.func_78374_a(var34, var40, var42, var24, var26);
         var5.func_78374_a(var34, var40, var44, var22, var26);
      }

      return true;
   }

   public boolean func_78584_s(Block p_78584_1_, int p_78584_2_, int p_78584_3_, int p_78584_4_) {
      int var5 = p_78584_1_.func_71920_b(this.field_78669_a, p_78584_2_, p_78584_3_, p_78584_4_);
      float var6 = (float)(var5 >> 16 & 255) / 255.0F;
      float var7 = (float)(var5 >> 8 & 255) / 255.0F;
      float var8 = (float)(var5 & 255) / 255.0F;
      if(EntityRenderer.field_78517_a) {
         float var9 = (var6 * 30.0F + var7 * 59.0F + var8 * 11.0F) / 100.0F;
         float var10 = (var6 * 30.0F + var7 * 70.0F) / 100.0F;
         float var11 = (var6 * 30.0F + var8 * 70.0F) / 100.0F;
         var6 = var9;
         var7 = var10;
         var8 = var11;
      }

      return this.func_78569_d(p_78584_1_, p_78584_2_, p_78584_3_, p_78584_4_, var6, var7, var8);
   }

   public boolean func_78569_d(Block p_78569_1_, int p_78569_2_, int p_78569_3_, int p_78569_4_, float p_78569_5_, float p_78569_6_, float p_78569_7_) {
      Tessellator var8 = Tessellator.field_78398_a;
      boolean var9 = false;
      float var10 = 0.5F;
      float var11 = 1.0F;
      float var12 = 0.8F;
      float var13 = 0.6F;
      float var14 = var10 * p_78569_5_;
      float var15 = var11 * p_78569_5_;
      float var16 = var12 * p_78569_5_;
      float var17 = var13 * p_78569_5_;
      float var18 = var10 * p_78569_6_;
      float var19 = var11 * p_78569_6_;
      float var20 = var12 * p_78569_6_;
      float var21 = var13 * p_78569_6_;
      float var22 = var10 * p_78569_7_;
      float var23 = var11 * p_78569_7_;
      float var24 = var12 * p_78569_7_;
      float var25 = var13 * p_78569_7_;
      float var26 = 0.0625F;
      int var28 = p_78569_1_.func_71874_e(this.field_78669_a, p_78569_2_, p_78569_3_, p_78569_4_);
      if(this.field_78661_f || p_78569_1_.func_71877_c(this.field_78669_a, p_78569_2_, p_78569_3_ - 1, p_78569_4_, 0)) {
         var8.func_78380_c(p_78569_1_.field_72023_ci > 0.0D?var28:p_78569_1_.func_71874_e(this.field_78669_a, p_78569_2_, p_78569_3_ - 1, p_78569_4_));
         var8.func_78386_a(var14, var18, var22);
         this.func_78613_a(p_78569_1_, (double)p_78569_2_, (double)p_78569_3_, (double)p_78569_4_, p_78569_1_.func_71895_b(this.field_78669_a, p_78569_2_, p_78569_3_, p_78569_4_, 0));
         var9 = true;
      }

      if(this.field_78661_f || p_78569_1_.func_71877_c(this.field_78669_a, p_78569_2_, p_78569_3_ + 1, p_78569_4_, 1)) {
         var8.func_78380_c(p_78569_1_.field_72022_cl < 1.0D?var28:p_78569_1_.func_71874_e(this.field_78669_a, p_78569_2_, p_78569_3_ + 1, p_78569_4_));
         var8.func_78386_a(var15, var19, var23);
         this.func_78617_b(p_78569_1_, (double)p_78569_2_, (double)p_78569_3_, (double)p_78569_4_, p_78569_1_.func_71895_b(this.field_78669_a, p_78569_2_, p_78569_3_, p_78569_4_, 1));
         var9 = true;
      }

      if(this.field_78661_f || p_78569_1_.func_71877_c(this.field_78669_a, p_78569_2_, p_78569_3_, p_78569_4_ - 1, 2)) {
         var8.func_78380_c(p_78569_1_.field_72024_cj > 0.0D?var28:p_78569_1_.func_71874_e(this.field_78669_a, p_78569_2_, p_78569_3_, p_78569_4_ - 1));
         var8.func_78386_a(var16, var20, var24);
         var8.func_78372_c(0.0F, 0.0F, var26);
         this.func_78611_c(p_78569_1_, (double)p_78569_2_, (double)p_78569_3_, (double)p_78569_4_, p_78569_1_.func_71895_b(this.field_78669_a, p_78569_2_, p_78569_3_, p_78569_4_, 2));
         var8.func_78372_c(0.0F, 0.0F, -var26);
         var9 = true;
      }

      if(this.field_78661_f || p_78569_1_.func_71877_c(this.field_78669_a, p_78569_2_, p_78569_3_, p_78569_4_ + 1, 3)) {
         var8.func_78380_c(p_78569_1_.field_72019_cm < 1.0D?var28:p_78569_1_.func_71874_e(this.field_78669_a, p_78569_2_, p_78569_3_, p_78569_4_ + 1));
         var8.func_78386_a(var16, var20, var24);
         var8.func_78372_c(0.0F, 0.0F, -var26);
         this.func_78622_d(p_78569_1_, (double)p_78569_2_, (double)p_78569_3_, (double)p_78569_4_, p_78569_1_.func_71895_b(this.field_78669_a, p_78569_2_, p_78569_3_, p_78569_4_, 3));
         var8.func_78372_c(0.0F, 0.0F, var26);
         var9 = true;
      }

      if(this.field_78661_f || p_78569_1_.func_71877_c(this.field_78669_a, p_78569_2_ - 1, p_78569_3_, p_78569_4_, 4)) {
         var8.func_78380_c(p_78569_1_.field_72026_ch > 0.0D?var28:p_78569_1_.func_71874_e(this.field_78669_a, p_78569_2_ - 1, p_78569_3_, p_78569_4_));
         var8.func_78386_a(var17, var21, var25);
         var8.func_78372_c(var26, 0.0F, 0.0F);
         this.func_78573_e(p_78569_1_, (double)p_78569_2_, (double)p_78569_3_, (double)p_78569_4_, p_78569_1_.func_71895_b(this.field_78669_a, p_78569_2_, p_78569_3_, p_78569_4_, 4));
         var8.func_78372_c(-var26, 0.0F, 0.0F);
         var9 = true;
      }

      if(this.field_78661_f || p_78569_1_.func_71877_c(this.field_78669_a, p_78569_2_ + 1, p_78569_3_, p_78569_4_, 5)) {
         var8.func_78380_c(p_78569_1_.field_72021_ck < 1.0D?var28:p_78569_1_.func_71874_e(this.field_78669_a, p_78569_2_ + 1, p_78569_3_, p_78569_4_));
         var8.func_78386_a(var17, var21, var25);
         var8.func_78372_c(-var26, 0.0F, 0.0F);
         this.func_78605_f(p_78569_1_, (double)p_78569_2_, (double)p_78569_3_, (double)p_78569_4_, p_78569_1_.func_71895_b(this.field_78669_a, p_78569_2_, p_78569_3_, p_78569_4_, 5));
         var8.func_78372_c(var26, 0.0F, 0.0F);
         var9 = true;
      }

      return var9;
   }

   public boolean func_78582_a(BlockFence p_78582_1_, int p_78582_2_, int p_78582_3_, int p_78582_4_) {
      boolean var5 = false;
      float var6 = 0.375F;
      float var7 = 0.625F;
      p_78582_1_.func_71905_a(var6, 0.0F, var6, var7, 1.0F, var7);
      this.func_78570_q(p_78582_1_, p_78582_2_, p_78582_3_, p_78582_4_);
      var5 = true;
      boolean var8 = false;
      boolean var9 = false;
      if(p_78582_1_.func_72250_d(this.field_78669_a, p_78582_2_ - 1, p_78582_3_, p_78582_4_) || p_78582_1_.func_72250_d(this.field_78669_a, p_78582_2_ + 1, p_78582_3_, p_78582_4_)) {
         var8 = true;
      }

      if(p_78582_1_.func_72250_d(this.field_78669_a, p_78582_2_, p_78582_3_, p_78582_4_ - 1) || p_78582_1_.func_72250_d(this.field_78669_a, p_78582_2_, p_78582_3_, p_78582_4_ + 1)) {
         var9 = true;
      }

      boolean var10 = p_78582_1_.func_72250_d(this.field_78669_a, p_78582_2_ - 1, p_78582_3_, p_78582_4_);
      boolean var11 = p_78582_1_.func_72250_d(this.field_78669_a, p_78582_2_ + 1, p_78582_3_, p_78582_4_);
      boolean var12 = p_78582_1_.func_72250_d(this.field_78669_a, p_78582_2_, p_78582_3_, p_78582_4_ - 1);
      boolean var13 = p_78582_1_.func_72250_d(this.field_78669_a, p_78582_2_, p_78582_3_, p_78582_4_ + 1);
      if(!var8 && !var9) {
         var8 = true;
      }

      var6 = 0.4375F;
      var7 = 0.5625F;
      float var14 = 0.75F;
      float var15 = 0.9375F;
      float var16 = var10?0.0F:var6;
      float var17 = var11?1.0F:var7;
      float var18 = var12?0.0F:var6;
      float var19 = var13?1.0F:var7;
      if(var8) {
         p_78582_1_.func_71905_a(var16, var14, var6, var17, var15, var7);
         this.func_78570_q(p_78582_1_, p_78582_2_, p_78582_3_, p_78582_4_);
         var5 = true;
      }

      if(var9) {
         p_78582_1_.func_71905_a(var6, var14, var18, var7, var15, var19);
         this.func_78570_q(p_78582_1_, p_78582_2_, p_78582_3_, p_78582_4_);
         var5 = true;
      }

      var14 = 0.375F;
      var15 = 0.5625F;
      if(var8) {
         p_78582_1_.func_71905_a(var16, var14, var6, var17, var15, var7);
         this.func_78570_q(p_78582_1_, p_78582_2_, p_78582_3_, p_78582_4_);
         var5 = true;
      }

      if(var9) {
         p_78582_1_.func_71905_a(var6, var14, var18, var7, var15, var19);
         this.func_78570_q(p_78582_1_, p_78582_2_, p_78582_3_, p_78582_4_);
         var5 = true;
      }

      p_78582_1_.func_71902_a(this.field_78669_a, p_78582_2_, p_78582_3_, p_78582_4_);
      return var5;
   }

   public boolean func_78618_a(BlockDragonEgg p_78618_1_, int p_78618_2_, int p_78618_3_, int p_78618_4_) {
      boolean var5 = false;
      int var6 = 0;

      for(int var7 = 0; var7 < 8; ++var7) {
         byte var8 = 0;
         byte var9 = 1;
         if(var7 == 0) {
            var8 = 2;
         }

         if(var7 == 1) {
            var8 = 3;
         }

         if(var7 == 2) {
            var8 = 4;
         }

         if(var7 == 3) {
            var8 = 5;
            var9 = 2;
         }

         if(var7 == 4) {
            var8 = 6;
            var9 = 3;
         }

         if(var7 == 5) {
            var8 = 7;
            var9 = 5;
         }

         if(var7 == 6) {
            var8 = 6;
            var9 = 2;
         }

         if(var7 == 7) {
            var8 = 3;
         }

         float var10 = (float)var8 / 16.0F;
         float var11 = 1.0F - (float)var6 / 16.0F;
         float var12 = 1.0F - (float)(var6 + var9) / 16.0F;
         var6 += var9;
         p_78618_1_.func_71905_a(0.5F - var10, var12, 0.5F - var10, 0.5F + var10, var11, 0.5F + var10);
         this.func_78570_q(p_78618_1_, p_78618_2_, p_78618_3_, p_78618_4_);
      }

      var5 = true;
      p_78618_1_.func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
      return var5;
   }

   public boolean func_78580_a(BlockFenceGate p_78580_1_, int p_78580_2_, int p_78580_3_, int p_78580_4_) {
      boolean var5 = true;
      int var6 = this.field_78669_a.func_72805_g(p_78580_2_, p_78580_3_, p_78580_4_);
      boolean var7 = BlockFenceGate.func_72224_c(var6);
      int var8 = BlockDirectional.func_72217_d(var6);
      float var15;
      float var17;
      float var16;
      float var18;
      if(var8 != 3 && var8 != 1) {
         var15 = 0.0F;
         var16 = 0.125F;
         var17 = 0.4375F;
         var18 = 0.5625F;
         p_78580_1_.func_71905_a(var15, 0.3125F, var17, var16, 1.0F, var18);
         this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
         var15 = 0.875F;
         var16 = 1.0F;
         p_78580_1_.func_71905_a(var15, 0.3125F, var17, var16, 1.0F, var18);
         this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
      } else {
         var15 = 0.4375F;
         var16 = 0.5625F;
         var17 = 0.0F;
         var18 = 0.125F;
         p_78580_1_.func_71905_a(var15, 0.3125F, var17, var16, 1.0F, var18);
         this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
         var17 = 0.875F;
         var18 = 1.0F;
         p_78580_1_.func_71905_a(var15, 0.3125F, var17, var16, 1.0F, var18);
         this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
      }

      if(var7) {
         if(var8 == 3) {
            p_78580_1_.func_71905_a(0.8125F, 0.375F, 0.0F, 0.9375F, 0.9375F, 0.125F);
            this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
            p_78580_1_.func_71905_a(0.8125F, 0.375F, 0.875F, 0.9375F, 0.9375F, 1.0F);
            this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
            p_78580_1_.func_71905_a(0.5625F, 0.375F, 0.0F, 0.8125F, 0.5625F, 0.125F);
            this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
            p_78580_1_.func_71905_a(0.5625F, 0.375F, 0.875F, 0.8125F, 0.5625F, 1.0F);
            this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
            p_78580_1_.func_71905_a(0.5625F, 0.75F, 0.0F, 0.8125F, 0.9375F, 0.125F);
            this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
            p_78580_1_.func_71905_a(0.5625F, 0.75F, 0.875F, 0.8125F, 0.9375F, 1.0F);
            this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
         } else if(var8 == 1) {
            p_78580_1_.func_71905_a(0.0625F, 0.375F, 0.0F, 0.1875F, 0.9375F, 0.125F);
            this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
            p_78580_1_.func_71905_a(0.0625F, 0.375F, 0.875F, 0.1875F, 0.9375F, 1.0F);
            this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
            p_78580_1_.func_71905_a(0.1875F, 0.375F, 0.0F, 0.4375F, 0.5625F, 0.125F);
            this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
            p_78580_1_.func_71905_a(0.1875F, 0.375F, 0.875F, 0.4375F, 0.5625F, 1.0F);
            this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
            p_78580_1_.func_71905_a(0.1875F, 0.75F, 0.0F, 0.4375F, 0.9375F, 0.125F);
            this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
            p_78580_1_.func_71905_a(0.1875F, 0.75F, 0.875F, 0.4375F, 0.9375F, 1.0F);
            this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
         } else if(var8 == 0) {
            p_78580_1_.func_71905_a(0.0F, 0.375F, 0.8125F, 0.125F, 0.9375F, 0.9375F);
            this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
            p_78580_1_.func_71905_a(0.875F, 0.375F, 0.8125F, 1.0F, 0.9375F, 0.9375F);
            this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
            p_78580_1_.func_71905_a(0.0F, 0.375F, 0.5625F, 0.125F, 0.5625F, 0.8125F);
            this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
            p_78580_1_.func_71905_a(0.875F, 0.375F, 0.5625F, 1.0F, 0.5625F, 0.8125F);
            this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
            p_78580_1_.func_71905_a(0.0F, 0.75F, 0.5625F, 0.125F, 0.9375F, 0.8125F);
            this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
            p_78580_1_.func_71905_a(0.875F, 0.75F, 0.5625F, 1.0F, 0.9375F, 0.8125F);
            this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
         } else if(var8 == 2) {
            p_78580_1_.func_71905_a(0.0F, 0.375F, 0.0625F, 0.125F, 0.9375F, 0.1875F);
            this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
            p_78580_1_.func_71905_a(0.875F, 0.375F, 0.0625F, 1.0F, 0.9375F, 0.1875F);
            this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
            p_78580_1_.func_71905_a(0.0F, 0.375F, 0.1875F, 0.125F, 0.5625F, 0.4375F);
            this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
            p_78580_1_.func_71905_a(0.875F, 0.375F, 0.1875F, 1.0F, 0.5625F, 0.4375F);
            this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
            p_78580_1_.func_71905_a(0.0F, 0.75F, 0.1875F, 0.125F, 0.9375F, 0.4375F);
            this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
            p_78580_1_.func_71905_a(0.875F, 0.75F, 0.1875F, 1.0F, 0.9375F, 0.4375F);
            this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
         }
      } else if(var8 != 3 && var8 != 1) {
         var15 = 0.375F;
         var16 = 0.5F;
         var17 = 0.4375F;
         var18 = 0.5625F;
         p_78580_1_.func_71905_a(var15, 0.375F, var17, var16, 0.9375F, var18);
         this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
         var15 = 0.5F;
         var16 = 0.625F;
         p_78580_1_.func_71905_a(var15, 0.375F, var17, var16, 0.9375F, var18);
         this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
         var15 = 0.625F;
         var16 = 0.875F;
         p_78580_1_.func_71905_a(var15, 0.375F, var17, var16, 0.5625F, var18);
         this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
         p_78580_1_.func_71905_a(var15, 0.75F, var17, var16, 0.9375F, var18);
         this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
         var15 = 0.125F;
         var16 = 0.375F;
         p_78580_1_.func_71905_a(var15, 0.375F, var17, var16, 0.5625F, var18);
         this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
         p_78580_1_.func_71905_a(var15, 0.75F, var17, var16, 0.9375F, var18);
         this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
      } else {
         var15 = 0.4375F;
         var16 = 0.5625F;
         var17 = 0.375F;
         var18 = 0.5F;
         p_78580_1_.func_71905_a(var15, 0.375F, var17, var16, 0.9375F, var18);
         this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
         var17 = 0.5F;
         var18 = 0.625F;
         p_78580_1_.func_71905_a(var15, 0.375F, var17, var16, 0.9375F, var18);
         this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
         var17 = 0.625F;
         var18 = 0.875F;
         p_78580_1_.func_71905_a(var15, 0.375F, var17, var16, 0.5625F, var18);
         this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
         p_78580_1_.func_71905_a(var15, 0.75F, var17, var16, 0.9375F, var18);
         this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
         var17 = 0.125F;
         var18 = 0.375F;
         p_78580_1_.func_71905_a(var15, 0.375F, var17, var16, 0.5625F, var18);
         this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
         p_78580_1_.func_71905_a(var15, 0.75F, var17, var16, 0.9375F, var18);
         this.func_78570_q(p_78580_1_, p_78580_2_, p_78580_3_, p_78580_4_);
      }

      p_78580_1_.func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
      return var5;
   }

   public boolean func_78565_t(Block p_78565_1_, int p_78565_2_, int p_78565_3_, int p_78565_4_) {
      int var5 = this.field_78669_a.func_72805_g(p_78565_2_, p_78565_3_, p_78565_4_);
      int var6 = var5 & 3;
      float var7 = 0.0F;
      float var8 = 0.5F;
      float var9 = 0.5F;
      float var10 = 1.0F;
      if((var5 & 4) != 0) {
         var7 = 0.5F;
         var8 = 1.0F;
         var9 = 0.0F;
         var10 = 0.5F;
      }

      p_78565_1_.func_71905_a(0.0F, var7, 0.0F, 1.0F, var8, 1.0F);
      this.func_78570_q(p_78565_1_, p_78565_2_, p_78565_3_, p_78565_4_);
      if(var6 == 0) {
         p_78565_1_.func_71905_a(0.5F, var9, 0.0F, 1.0F, var10, 1.0F);
         this.func_78570_q(p_78565_1_, p_78565_2_, p_78565_3_, p_78565_4_);
      } else if(var6 == 1) {
         p_78565_1_.func_71905_a(0.0F, var9, 0.0F, 0.5F, var10, 1.0F);
         this.func_78570_q(p_78565_1_, p_78565_2_, p_78565_3_, p_78565_4_);
      } else if(var6 == 2) {
         p_78565_1_.func_71905_a(0.0F, var9, 0.5F, 1.0F, var10, 1.0F);
         this.func_78570_q(p_78565_1_, p_78565_2_, p_78565_3_, p_78565_4_);
      } else if(var6 == 3) {
         p_78565_1_.func_71905_a(0.0F, var9, 0.0F, 1.0F, var10, 0.5F);
         this.func_78570_q(p_78565_1_, p_78565_2_, p_78565_3_, p_78565_4_);
      }

      p_78565_1_.func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
      return true;
   }

   public boolean func_78601_u(Block p_78601_1_, int p_78601_2_, int p_78601_3_, int p_78601_4_) {
      Tessellator var5 = Tessellator.field_78398_a;
      BlockDoor var6 = (BlockDoor)p_78601_1_;
      boolean var7 = false;
      float var8 = 0.5F;
      float var9 = 1.0F;
      float var10 = 0.8F;
      float var11 = 0.6F;
      int var12 = p_78601_1_.func_71874_e(this.field_78669_a, p_78601_2_, p_78601_3_, p_78601_4_);
      var5.func_78380_c(p_78601_1_.field_72023_ci > 0.0D?var12:p_78601_1_.func_71874_e(this.field_78669_a, p_78601_2_, p_78601_3_ - 1, p_78601_4_));
      var5.func_78386_a(var8, var8, var8);
      this.func_78613_a(p_78601_1_, (double)p_78601_2_, (double)p_78601_3_, (double)p_78601_4_, p_78601_1_.func_71895_b(this.field_78669_a, p_78601_2_, p_78601_3_, p_78601_4_, 0));
      var7 = true;
      var5.func_78380_c(p_78601_1_.field_72022_cl < 1.0D?var12:p_78601_1_.func_71874_e(this.field_78669_a, p_78601_2_, p_78601_3_ + 1, p_78601_4_));
      var5.func_78386_a(var9, var9, var9);
      this.func_78617_b(p_78601_1_, (double)p_78601_2_, (double)p_78601_3_, (double)p_78601_4_, p_78601_1_.func_71895_b(this.field_78669_a, p_78601_2_, p_78601_3_, p_78601_4_, 1));
      var7 = true;
      var5.func_78380_c(p_78601_1_.field_72024_cj > 0.0D?var12:p_78601_1_.func_71874_e(this.field_78669_a, p_78601_2_, p_78601_3_, p_78601_4_ - 1));
      var5.func_78386_a(var10, var10, var10);
      int var14 = p_78601_1_.func_71895_b(this.field_78669_a, p_78601_2_, p_78601_3_, p_78601_4_, 2);
      if(var14 < 0) {
         this.field_78666_e = true;
         var14 = -var14;
      }

      this.func_78611_c(p_78601_1_, (double)p_78601_2_, (double)p_78601_3_, (double)p_78601_4_, var14);
      var7 = true;
      this.field_78666_e = false;
      var5.func_78380_c(p_78601_1_.field_72019_cm < 1.0D?var12:p_78601_1_.func_71874_e(this.field_78669_a, p_78601_2_, p_78601_3_, p_78601_4_ + 1));
      var5.func_78386_a(var10, var10, var10);
      var14 = p_78601_1_.func_71895_b(this.field_78669_a, p_78601_2_, p_78601_3_, p_78601_4_, 3);
      if(var14 < 0) {
         this.field_78666_e = true;
         var14 = -var14;
      }

      this.func_78622_d(p_78601_1_, (double)p_78601_2_, (double)p_78601_3_, (double)p_78601_4_, var14);
      var7 = true;
      this.field_78666_e = false;
      var5.func_78380_c(p_78601_1_.field_72026_ch > 0.0D?var12:p_78601_1_.func_71874_e(this.field_78669_a, p_78601_2_ - 1, p_78601_3_, p_78601_4_));
      var5.func_78386_a(var11, var11, var11);
      var14 = p_78601_1_.func_71895_b(this.field_78669_a, p_78601_2_, p_78601_3_, p_78601_4_, 4);
      if(var14 < 0) {
         this.field_78666_e = true;
         var14 = -var14;
      }

      this.func_78573_e(p_78601_1_, (double)p_78601_2_, (double)p_78601_3_, (double)p_78601_4_, var14);
      var7 = true;
      this.field_78666_e = false;
      var5.func_78380_c(p_78601_1_.field_72021_ck < 1.0D?var12:p_78601_1_.func_71874_e(this.field_78669_a, p_78601_2_ + 1, p_78601_3_, p_78601_4_));
      var5.func_78386_a(var11, var11, var11);
      var14 = p_78601_1_.func_71895_b(this.field_78669_a, p_78601_2_, p_78601_3_, p_78601_4_, 5);
      if(var14 < 0) {
         this.field_78666_e = true;
         var14 = -var14;
      }

      this.func_78605_f(p_78601_1_, (double)p_78601_2_, (double)p_78601_3_, (double)p_78601_4_, var14);
      var7 = true;
      this.field_78666_e = false;
      return var7;
   }

   public void func_78613_a(Block p_78613_1_, double p_78613_2_, double p_78613_4_, double p_78613_6_, int p_78613_8_) {
      Tessellator var9 = Tessellator.field_78398_a;
      if(this.field_78664_d >= 0) {
         p_78613_8_ = this.field_78664_d;
      }

      int var10 = (p_78613_8_ & 15) << 4;
      int var11 = p_78613_8_ & 240;
      double var12 = ((double)var10 + p_78613_1_.field_72026_ch * 16.0D) / 256.0D;
      double var14 = ((double)var10 + p_78613_1_.field_72021_ck * 16.0D - 0.01D) / 256.0D;
      double var16 = ((double)var11 + p_78613_1_.field_72024_cj * 16.0D) / 256.0D;
      double var18 = ((double)var11 + p_78613_1_.field_72019_cm * 16.0D - 0.01D) / 256.0D;
      if(p_78613_1_.field_72026_ch < 0.0D || p_78613_1_.field_72021_ck > 1.0D) {
         var12 = (double)(((float)var10 + 0.0F) / 256.0F);
         var14 = (double)(((float)var10 + 15.99F) / 256.0F);
      }

      if(p_78613_1_.field_72024_cj < 0.0D || p_78613_1_.field_72019_cm > 1.0D) {
         var16 = (double)(((float)var11 + 0.0F) / 256.0F);
         var18 = (double)(((float)var11 + 15.99F) / 256.0F);
      }

      double var20 = var14;
      double var22 = var12;
      double var24 = var16;
      double var26 = var18;
      if(this.field_78675_l == 2) {
         var12 = ((double)var10 + p_78613_1_.field_72024_cj * 16.0D) / 256.0D;
         var16 = ((double)(var11 + 16) - p_78613_1_.field_72021_ck * 16.0D) / 256.0D;
         var14 = ((double)var10 + p_78613_1_.field_72019_cm * 16.0D) / 256.0D;
         var18 = ((double)(var11 + 16) - p_78613_1_.field_72026_ch * 16.0D) / 256.0D;
         var24 = var16;
         var26 = var18;
         var20 = var12;
         var22 = var14;
         var16 = var18;
         var18 = var24;
      } else if(this.field_78675_l == 1) {
         var12 = ((double)(var10 + 16) - p_78613_1_.field_72019_cm * 16.0D) / 256.0D;
         var16 = ((double)var11 + p_78613_1_.field_72026_ch * 16.0D) / 256.0D;
         var14 = ((double)(var10 + 16) - p_78613_1_.field_72024_cj * 16.0D) / 256.0D;
         var18 = ((double)var11 + p_78613_1_.field_72021_ck * 16.0D) / 256.0D;
         var20 = var14;
         var22 = var12;
         var12 = var14;
         var14 = var22;
         var24 = var18;
         var26 = var16;
      } else if(this.field_78675_l == 3) {
         var12 = ((double)(var10 + 16) - p_78613_1_.field_72026_ch * 16.0D) / 256.0D;
         var14 = ((double)(var10 + 16) - p_78613_1_.field_72021_ck * 16.0D - 0.01D) / 256.0D;
         var16 = ((double)(var11 + 16) - p_78613_1_.field_72024_cj * 16.0D) / 256.0D;
         var18 = ((double)(var11 + 16) - p_78613_1_.field_72019_cm * 16.0D - 0.01D) / 256.0D;
         var20 = var14;
         var22 = var12;
         var24 = var16;
         var26 = var18;
      }

      double var28 = p_78613_2_ + p_78613_1_.field_72026_ch;
      double var30 = p_78613_2_ + p_78613_1_.field_72021_ck;
      double var32 = p_78613_4_ + p_78613_1_.field_72023_ci;
      double var34 = p_78613_6_ + p_78613_1_.field_72024_cj;
      double var36 = p_78613_6_ + p_78613_1_.field_72019_cm;
      if(this.field_78677_m) {
         var9.func_78386_a(this.field_78674_ar, this.field_78682_av, this.field_78663_az);
         var9.func_78380_c(this.field_78700_an);
         var9.func_78374_a(var28, var32, var36, var22, var26);
         var9.func_78386_a(this.field_78672_as, this.field_78680_aw, this.field_78650_aA);
         var9.func_78380_c(this.field_78694_ao);
         var9.func_78374_a(var28, var32, var34, var12, var16);
         var9.func_78386_a(this.field_78670_at, this.field_78678_ax, this.field_78651_aB);
         var9.func_78380_c(this.field_78696_ap);
         var9.func_78374_a(var30, var32, var34, var20, var24);
         var9.func_78386_a(this.field_78684_au, this.field_78665_ay, this.field_78652_aC);
         var9.func_78380_c(this.field_78676_aq);
         var9.func_78374_a(var30, var32, var36, var14, var18);
      } else {
         var9.func_78374_a(var28, var32, var36, var22, var26);
         var9.func_78374_a(var28, var32, var34, var12, var16);
         var9.func_78374_a(var30, var32, var34, var20, var24);
         var9.func_78374_a(var30, var32, var36, var14, var18);
      }

   }

   public void func_78617_b(Block p_78617_1_, double p_78617_2_, double p_78617_4_, double p_78617_6_, int p_78617_8_) {
      Tessellator var9 = Tessellator.field_78398_a;
      if(this.field_78664_d >= 0) {
         p_78617_8_ = this.field_78664_d;
      }

      int var10 = (p_78617_8_ & 15) << 4;
      int var11 = p_78617_8_ & 240;
      double var12 = ((double)var10 + p_78617_1_.field_72026_ch * 16.0D) / 256.0D;
      double var14 = ((double)var10 + p_78617_1_.field_72021_ck * 16.0D - 0.01D) / 256.0D;
      double var16 = ((double)var11 + p_78617_1_.field_72024_cj * 16.0D) / 256.0D;
      double var18 = ((double)var11 + p_78617_1_.field_72019_cm * 16.0D - 0.01D) / 256.0D;
      if(p_78617_1_.field_72026_ch < 0.0D || p_78617_1_.field_72021_ck > 1.0D) {
         var12 = (double)(((float)var10 + 0.0F) / 256.0F);
         var14 = (double)(((float)var10 + 15.99F) / 256.0F);
      }

      if(p_78617_1_.field_72024_cj < 0.0D || p_78617_1_.field_72019_cm > 1.0D) {
         var16 = (double)(((float)var11 + 0.0F) / 256.0F);
         var18 = (double)(((float)var11 + 15.99F) / 256.0F);
      }

      double var20 = var14;
      double var22 = var12;
      double var24 = var16;
      double var26 = var18;
      if(this.field_78681_k == 1) {
         var12 = ((double)var10 + p_78617_1_.field_72024_cj * 16.0D) / 256.0D;
         var16 = ((double)(var11 + 16) - p_78617_1_.field_72021_ck * 16.0D) / 256.0D;
         var14 = ((double)var10 + p_78617_1_.field_72019_cm * 16.0D) / 256.0D;
         var18 = ((double)(var11 + 16) - p_78617_1_.field_72026_ch * 16.0D) / 256.0D;
         var24 = var16;
         var26 = var18;
         var20 = var12;
         var22 = var14;
         var16 = var18;
         var18 = var24;
      } else if(this.field_78681_k == 2) {
         var12 = ((double)(var10 + 16) - p_78617_1_.field_72019_cm * 16.0D) / 256.0D;
         var16 = ((double)var11 + p_78617_1_.field_72026_ch * 16.0D) / 256.0D;
         var14 = ((double)(var10 + 16) - p_78617_1_.field_72024_cj * 16.0D) / 256.0D;
         var18 = ((double)var11 + p_78617_1_.field_72021_ck * 16.0D) / 256.0D;
         var20 = var14;
         var22 = var12;
         var12 = var14;
         var14 = var22;
         var24 = var18;
         var26 = var16;
      } else if(this.field_78681_k == 3) {
         var12 = ((double)(var10 + 16) - p_78617_1_.field_72026_ch * 16.0D) / 256.0D;
         var14 = ((double)(var10 + 16) - p_78617_1_.field_72021_ck * 16.0D - 0.01D) / 256.0D;
         var16 = ((double)(var11 + 16) - p_78617_1_.field_72024_cj * 16.0D) / 256.0D;
         var18 = ((double)(var11 + 16) - p_78617_1_.field_72019_cm * 16.0D - 0.01D) / 256.0D;
         var20 = var14;
         var22 = var12;
         var24 = var16;
         var26 = var18;
      }

      double var28 = p_78617_2_ + p_78617_1_.field_72026_ch;
      double var30 = p_78617_2_ + p_78617_1_.field_72021_ck;
      double var32 = p_78617_4_ + p_78617_1_.field_72022_cl;
      double var34 = p_78617_6_ + p_78617_1_.field_72024_cj;
      double var36 = p_78617_6_ + p_78617_1_.field_72019_cm;
      if(this.field_78677_m) {
         var9.func_78386_a(this.field_78674_ar, this.field_78682_av, this.field_78663_az);
         var9.func_78380_c(this.field_78700_an);
         var9.func_78374_a(var30, var32, var36, var14, var18);
         var9.func_78386_a(this.field_78672_as, this.field_78680_aw, this.field_78650_aA);
         var9.func_78380_c(this.field_78694_ao);
         var9.func_78374_a(var30, var32, var34, var20, var24);
         var9.func_78386_a(this.field_78670_at, this.field_78678_ax, this.field_78651_aB);
         var9.func_78380_c(this.field_78696_ap);
         var9.func_78374_a(var28, var32, var34, var12, var16);
         var9.func_78386_a(this.field_78684_au, this.field_78665_ay, this.field_78652_aC);
         var9.func_78380_c(this.field_78676_aq);
         var9.func_78374_a(var28, var32, var36, var22, var26);
      } else {
         var9.func_78374_a(var30, var32, var36, var14, var18);
         var9.func_78374_a(var30, var32, var34, var20, var24);
         var9.func_78374_a(var28, var32, var34, var12, var16);
         var9.func_78374_a(var28, var32, var36, var22, var26);
      }

   }

   public void func_78611_c(Block p_78611_1_, double p_78611_2_, double p_78611_4_, double p_78611_6_, int p_78611_8_) {
      Tessellator var9 = Tessellator.field_78398_a;
      if(this.field_78664_d >= 0) {
         p_78611_8_ = this.field_78664_d;
      }

      int var10 = (p_78611_8_ & 15) << 4;
      int var11 = p_78611_8_ & 240;
      double var12 = ((double)var10 + p_78611_1_.field_72026_ch * 16.0D) / 256.0D;
      double var14 = ((double)var10 + p_78611_1_.field_72021_ck * 16.0D - 0.01D) / 256.0D;
      double var16 = ((double)(var11 + 16) - p_78611_1_.field_72022_cl * 16.0D) / 256.0D;
      double var18 = ((double)(var11 + 16) - p_78611_1_.field_72023_ci * 16.0D - 0.01D) / 256.0D;
      double var20;
      if(this.field_78666_e) {
         var20 = var12;
         var12 = var14;
         var14 = var20;
      }

      if(p_78611_1_.field_72026_ch < 0.0D || p_78611_1_.field_72021_ck > 1.0D) {
         var12 = (double)(((float)var10 + 0.0F) / 256.0F);
         var14 = (double)(((float)var10 + 15.99F) / 256.0F);
      }

      if(p_78611_1_.field_72023_ci < 0.0D || p_78611_1_.field_72022_cl > 1.0D) {
         var16 = (double)(((float)var11 + 0.0F) / 256.0F);
         var18 = (double)(((float)var11 + 15.99F) / 256.0F);
      }

      var20 = var14;
      double var22 = var12;
      double var24 = var16;
      double var26 = var18;
      if(this.field_78662_g == 2) {
         var12 = ((double)var10 + p_78611_1_.field_72023_ci * 16.0D) / 256.0D;
         var16 = ((double)(var11 + 16) - p_78611_1_.field_72026_ch * 16.0D) / 256.0D;
         var14 = ((double)var10 + p_78611_1_.field_72022_cl * 16.0D) / 256.0D;
         var18 = ((double)(var11 + 16) - p_78611_1_.field_72021_ck * 16.0D) / 256.0D;
         var24 = var16;
         var26 = var18;
         var20 = var12;
         var22 = var14;
         var16 = var18;
         var18 = var24;
      } else if(this.field_78662_g == 1) {
         var12 = ((double)(var10 + 16) - p_78611_1_.field_72022_cl * 16.0D) / 256.0D;
         var16 = ((double)var11 + p_78611_1_.field_72021_ck * 16.0D) / 256.0D;
         var14 = ((double)(var10 + 16) - p_78611_1_.field_72023_ci * 16.0D) / 256.0D;
         var18 = ((double)var11 + p_78611_1_.field_72026_ch * 16.0D) / 256.0D;
         var20 = var14;
         var22 = var12;
         var12 = var14;
         var14 = var22;
         var24 = var18;
         var26 = var16;
      } else if(this.field_78662_g == 3) {
         var12 = ((double)(var10 + 16) - p_78611_1_.field_72026_ch * 16.0D) / 256.0D;
         var14 = ((double)(var10 + 16) - p_78611_1_.field_72021_ck * 16.0D - 0.01D) / 256.0D;
         var16 = ((double)var11 + p_78611_1_.field_72022_cl * 16.0D) / 256.0D;
         var18 = ((double)var11 + p_78611_1_.field_72023_ci * 16.0D - 0.01D) / 256.0D;
         var20 = var14;
         var22 = var12;
         var24 = var16;
         var26 = var18;
      }

      double var28 = p_78611_2_ + p_78611_1_.field_72026_ch;
      double var30 = p_78611_2_ + p_78611_1_.field_72021_ck;
      double var32 = p_78611_4_ + p_78611_1_.field_72023_ci;
      double var34 = p_78611_4_ + p_78611_1_.field_72022_cl;
      double var36 = p_78611_6_ + p_78611_1_.field_72024_cj;
      if(this.field_78677_m) {
         var9.func_78386_a(this.field_78674_ar, this.field_78682_av, this.field_78663_az);
         var9.func_78380_c(this.field_78700_an);
         var9.func_78374_a(var28, var34, var36, var20, var24);
         var9.func_78386_a(this.field_78672_as, this.field_78680_aw, this.field_78650_aA);
         var9.func_78380_c(this.field_78694_ao);
         var9.func_78374_a(var30, var34, var36, var12, var16);
         var9.func_78386_a(this.field_78670_at, this.field_78678_ax, this.field_78651_aB);
         var9.func_78380_c(this.field_78696_ap);
         var9.func_78374_a(var30, var32, var36, var22, var26);
         var9.func_78386_a(this.field_78684_au, this.field_78665_ay, this.field_78652_aC);
         var9.func_78380_c(this.field_78676_aq);
         var9.func_78374_a(var28, var32, var36, var14, var18);
      } else {
         var9.func_78374_a(var28, var34, var36, var20, var24);
         var9.func_78374_a(var30, var34, var36, var12, var16);
         var9.func_78374_a(var30, var32, var36, var22, var26);
         var9.func_78374_a(var28, var32, var36, var14, var18);
      }

   }

   public void func_78622_d(Block p_78622_1_, double p_78622_2_, double p_78622_4_, double p_78622_6_, int p_78622_8_) {
      Tessellator var9 = Tessellator.field_78398_a;
      if(this.field_78664_d >= 0) {
         p_78622_8_ = this.field_78664_d;
      }

      int var10 = (p_78622_8_ & 15) << 4;
      int var11 = p_78622_8_ & 240;
      double var12 = ((double)var10 + p_78622_1_.field_72026_ch * 16.0D) / 256.0D;
      double var14 = ((double)var10 + p_78622_1_.field_72021_ck * 16.0D - 0.01D) / 256.0D;
      double var16 = ((double)(var11 + 16) - p_78622_1_.field_72022_cl * 16.0D) / 256.0D;
      double var18 = ((double)(var11 + 16) - p_78622_1_.field_72023_ci * 16.0D - 0.01D) / 256.0D;
      double var20;
      if(this.field_78666_e) {
         var20 = var12;
         var12 = var14;
         var14 = var20;
      }

      if(p_78622_1_.field_72026_ch < 0.0D || p_78622_1_.field_72021_ck > 1.0D) {
         var12 = (double)(((float)var10 + 0.0F) / 256.0F);
         var14 = (double)(((float)var10 + 15.99F) / 256.0F);
      }

      if(p_78622_1_.field_72023_ci < 0.0D || p_78622_1_.field_72022_cl > 1.0D) {
         var16 = (double)(((float)var11 + 0.0F) / 256.0F);
         var18 = (double)(((float)var11 + 15.99F) / 256.0F);
      }

      var20 = var14;
      double var22 = var12;
      double var24 = var16;
      double var26 = var18;
      if(this.field_78683_h == 1) {
         var12 = ((double)var10 + p_78622_1_.field_72023_ci * 16.0D) / 256.0D;
         var18 = ((double)(var11 + 16) - p_78622_1_.field_72026_ch * 16.0D) / 256.0D;
         var14 = ((double)var10 + p_78622_1_.field_72022_cl * 16.0D) / 256.0D;
         var16 = ((double)(var11 + 16) - p_78622_1_.field_72021_ck * 16.0D) / 256.0D;
         var24 = var16;
         var26 = var18;
         var20 = var12;
         var22 = var14;
         var16 = var18;
         var18 = var24;
      } else if(this.field_78683_h == 2) {
         var12 = ((double)(var10 + 16) - p_78622_1_.field_72022_cl * 16.0D) / 256.0D;
         var16 = ((double)var11 + p_78622_1_.field_72026_ch * 16.0D) / 256.0D;
         var14 = ((double)(var10 + 16) - p_78622_1_.field_72023_ci * 16.0D) / 256.0D;
         var18 = ((double)var11 + p_78622_1_.field_72021_ck * 16.0D) / 256.0D;
         var20 = var14;
         var22 = var12;
         var12 = var14;
         var14 = var22;
         var24 = var18;
         var26 = var16;
      } else if(this.field_78683_h == 3) {
         var12 = ((double)(var10 + 16) - p_78622_1_.field_72026_ch * 16.0D) / 256.0D;
         var14 = ((double)(var10 + 16) - p_78622_1_.field_72021_ck * 16.0D - 0.01D) / 256.0D;
         var16 = ((double)var11 + p_78622_1_.field_72022_cl * 16.0D) / 256.0D;
         var18 = ((double)var11 + p_78622_1_.field_72023_ci * 16.0D - 0.01D) / 256.0D;
         var20 = var14;
         var22 = var12;
         var24 = var16;
         var26 = var18;
      }

      double var28 = p_78622_2_ + p_78622_1_.field_72026_ch;
      double var30 = p_78622_2_ + p_78622_1_.field_72021_ck;
      double var32 = p_78622_4_ + p_78622_1_.field_72023_ci;
      double var34 = p_78622_4_ + p_78622_1_.field_72022_cl;
      double var36 = p_78622_6_ + p_78622_1_.field_72019_cm;
      if(this.field_78677_m) {
         var9.func_78386_a(this.field_78674_ar, this.field_78682_av, this.field_78663_az);
         var9.func_78380_c(this.field_78700_an);
         var9.func_78374_a(var28, var34, var36, var12, var16);
         var9.func_78386_a(this.field_78672_as, this.field_78680_aw, this.field_78650_aA);
         var9.func_78380_c(this.field_78694_ao);
         var9.func_78374_a(var28, var32, var36, var22, var26);
         var9.func_78386_a(this.field_78670_at, this.field_78678_ax, this.field_78651_aB);
         var9.func_78380_c(this.field_78696_ap);
         var9.func_78374_a(var30, var32, var36, var14, var18);
         var9.func_78386_a(this.field_78684_au, this.field_78665_ay, this.field_78652_aC);
         var9.func_78380_c(this.field_78676_aq);
         var9.func_78374_a(var30, var34, var36, var20, var24);
      } else {
         var9.func_78374_a(var28, var34, var36, var12, var16);
         var9.func_78374_a(var28, var32, var36, var22, var26);
         var9.func_78374_a(var30, var32, var36, var14, var18);
         var9.func_78374_a(var30, var34, var36, var20, var24);
      }

   }

   public void func_78573_e(Block p_78573_1_, double p_78573_2_, double p_78573_4_, double p_78573_6_, int p_78573_8_) {
      Tessellator var9 = Tessellator.field_78398_a;
      if(this.field_78664_d >= 0) {
         p_78573_8_ = this.field_78664_d;
      }

      int var10 = (p_78573_8_ & 15) << 4;
      int var11 = p_78573_8_ & 240;
      double var12 = ((double)var10 + p_78573_1_.field_72024_cj * 16.0D) / 256.0D;
      double var14 = ((double)var10 + p_78573_1_.field_72019_cm * 16.0D - 0.01D) / 256.0D;
      double var16 = ((double)(var11 + 16) - p_78573_1_.field_72022_cl * 16.0D) / 256.0D;
      double var18 = ((double)(var11 + 16) - p_78573_1_.field_72023_ci * 16.0D - 0.01D) / 256.0D;
      double var20;
      if(this.field_78666_e) {
         var20 = var12;
         var12 = var14;
         var14 = var20;
      }

      if(p_78573_1_.field_72024_cj < 0.0D || p_78573_1_.field_72019_cm > 1.0D) {
         var12 = (double)(((float)var10 + 0.0F) / 256.0F);
         var14 = (double)(((float)var10 + 15.99F) / 256.0F);
      }

      if(p_78573_1_.field_72023_ci < 0.0D || p_78573_1_.field_72022_cl > 1.0D) {
         var16 = (double)(((float)var11 + 0.0F) / 256.0F);
         var18 = (double)(((float)var11 + 15.99F) / 256.0F);
      }

      var20 = var14;
      double var22 = var12;
      double var24 = var16;
      double var26 = var18;
      if(this.field_78679_j == 1) {
         var12 = ((double)var10 + p_78573_1_.field_72023_ci * 16.0D) / 256.0D;
         var16 = ((double)(var11 + 16) - p_78573_1_.field_72019_cm * 16.0D) / 256.0D;
         var14 = ((double)var10 + p_78573_1_.field_72022_cl * 16.0D) / 256.0D;
         var18 = ((double)(var11 + 16) - p_78573_1_.field_72024_cj * 16.0D) / 256.0D;
         var24 = var16;
         var26 = var18;
         var20 = var12;
         var22 = var14;
         var16 = var18;
         var18 = var24;
      } else if(this.field_78679_j == 2) {
         var12 = ((double)(var10 + 16) - p_78573_1_.field_72022_cl * 16.0D) / 256.0D;
         var16 = ((double)var11 + p_78573_1_.field_72024_cj * 16.0D) / 256.0D;
         var14 = ((double)(var10 + 16) - p_78573_1_.field_72023_ci * 16.0D) / 256.0D;
         var18 = ((double)var11 + p_78573_1_.field_72019_cm * 16.0D) / 256.0D;
         var20 = var14;
         var22 = var12;
         var12 = var14;
         var14 = var22;
         var24 = var18;
         var26 = var16;
      } else if(this.field_78679_j == 3) {
         var12 = ((double)(var10 + 16) - p_78573_1_.field_72024_cj * 16.0D) / 256.0D;
         var14 = ((double)(var10 + 16) - p_78573_1_.field_72019_cm * 16.0D - 0.01D) / 256.0D;
         var16 = ((double)var11 + p_78573_1_.field_72022_cl * 16.0D) / 256.0D;
         var18 = ((double)var11 + p_78573_1_.field_72023_ci * 16.0D - 0.01D) / 256.0D;
         var20 = var14;
         var22 = var12;
         var24 = var16;
         var26 = var18;
      }

      double var28 = p_78573_2_ + p_78573_1_.field_72026_ch;
      double var30 = p_78573_4_ + p_78573_1_.field_72023_ci;
      double var32 = p_78573_4_ + p_78573_1_.field_72022_cl;
      double var34 = p_78573_6_ + p_78573_1_.field_72024_cj;
      double var36 = p_78573_6_ + p_78573_1_.field_72019_cm;
      if(this.field_78677_m) {
         var9.func_78386_a(this.field_78674_ar, this.field_78682_av, this.field_78663_az);
         var9.func_78380_c(this.field_78700_an);
         var9.func_78374_a(var28, var32, var36, var20, var24);
         var9.func_78386_a(this.field_78672_as, this.field_78680_aw, this.field_78650_aA);
         var9.func_78380_c(this.field_78694_ao);
         var9.func_78374_a(var28, var32, var34, var12, var16);
         var9.func_78386_a(this.field_78670_at, this.field_78678_ax, this.field_78651_aB);
         var9.func_78380_c(this.field_78696_ap);
         var9.func_78374_a(var28, var30, var34, var22, var26);
         var9.func_78386_a(this.field_78684_au, this.field_78665_ay, this.field_78652_aC);
         var9.func_78380_c(this.field_78676_aq);
         var9.func_78374_a(var28, var30, var36, var14, var18);
      } else {
         var9.func_78374_a(var28, var32, var36, var20, var24);
         var9.func_78374_a(var28, var32, var34, var12, var16);
         var9.func_78374_a(var28, var30, var34, var22, var26);
         var9.func_78374_a(var28, var30, var36, var14, var18);
      }

   }

   public void func_78605_f(Block p_78605_1_, double p_78605_2_, double p_78605_4_, double p_78605_6_, int p_78605_8_) {
      Tessellator var9 = Tessellator.field_78398_a;
      if(this.field_78664_d >= 0) {
         p_78605_8_ = this.field_78664_d;
      }

      int var10 = (p_78605_8_ & 15) << 4;
      int var11 = p_78605_8_ & 240;
      double var12 = ((double)var10 + p_78605_1_.field_72024_cj * 16.0D) / 256.0D;
      double var14 = ((double)var10 + p_78605_1_.field_72019_cm * 16.0D - 0.01D) / 256.0D;
      double var16 = ((double)(var11 + 16) - p_78605_1_.field_72022_cl * 16.0D) / 256.0D;
      double var18 = ((double)(var11 + 16) - p_78605_1_.field_72023_ci * 16.0D - 0.01D) / 256.0D;
      double var20;
      if(this.field_78666_e) {
         var20 = var12;
         var12 = var14;
         var14 = var20;
      }

      if(p_78605_1_.field_72024_cj < 0.0D || p_78605_1_.field_72019_cm > 1.0D) {
         var12 = (double)(((float)var10 + 0.0F) / 256.0F);
         var14 = (double)(((float)var10 + 15.99F) / 256.0F);
      }

      if(p_78605_1_.field_72023_ci < 0.0D || p_78605_1_.field_72022_cl > 1.0D) {
         var16 = (double)(((float)var11 + 0.0F) / 256.0F);
         var18 = (double)(((float)var11 + 15.99F) / 256.0F);
      }

      var20 = var14;
      double var22 = var12;
      double var24 = var16;
      double var26 = var18;
      if(this.field_78685_i == 2) {
         var12 = ((double)var10 + p_78605_1_.field_72023_ci * 16.0D) / 256.0D;
         var16 = ((double)(var11 + 16) - p_78605_1_.field_72024_cj * 16.0D) / 256.0D;
         var14 = ((double)var10 + p_78605_1_.field_72022_cl * 16.0D) / 256.0D;
         var18 = ((double)(var11 + 16) - p_78605_1_.field_72019_cm * 16.0D) / 256.0D;
         var24 = var16;
         var26 = var18;
         var20 = var12;
         var22 = var14;
         var16 = var18;
         var18 = var24;
      } else if(this.field_78685_i == 1) {
         var12 = ((double)(var10 + 16) - p_78605_1_.field_72022_cl * 16.0D) / 256.0D;
         var16 = ((double)var11 + p_78605_1_.field_72019_cm * 16.0D) / 256.0D;
         var14 = ((double)(var10 + 16) - p_78605_1_.field_72023_ci * 16.0D) / 256.0D;
         var18 = ((double)var11 + p_78605_1_.field_72024_cj * 16.0D) / 256.0D;
         var20 = var14;
         var22 = var12;
         var12 = var14;
         var14 = var22;
         var24 = var18;
         var26 = var16;
      } else if(this.field_78685_i == 3) {
         var12 = ((double)(var10 + 16) - p_78605_1_.field_72024_cj * 16.0D) / 256.0D;
         var14 = ((double)(var10 + 16) - p_78605_1_.field_72019_cm * 16.0D - 0.01D) / 256.0D;
         var16 = ((double)var11 + p_78605_1_.field_72022_cl * 16.0D) / 256.0D;
         var18 = ((double)var11 + p_78605_1_.field_72023_ci * 16.0D - 0.01D) / 256.0D;
         var20 = var14;
         var22 = var12;
         var24 = var16;
         var26 = var18;
      }

      double var28 = p_78605_2_ + p_78605_1_.field_72021_ck;
      double var30 = p_78605_4_ + p_78605_1_.field_72023_ci;
      double var32 = p_78605_4_ + p_78605_1_.field_72022_cl;
      double var34 = p_78605_6_ + p_78605_1_.field_72024_cj;
      double var36 = p_78605_6_ + p_78605_1_.field_72019_cm;
      if(this.field_78677_m) {
         var9.func_78386_a(this.field_78674_ar, this.field_78682_av, this.field_78663_az);
         var9.func_78380_c(this.field_78700_an);
         var9.func_78374_a(var28, var30, var36, var22, var26);
         var9.func_78386_a(this.field_78672_as, this.field_78680_aw, this.field_78650_aA);
         var9.func_78380_c(this.field_78694_ao);
         var9.func_78374_a(var28, var30, var34, var14, var18);
         var9.func_78386_a(this.field_78670_at, this.field_78678_ax, this.field_78651_aB);
         var9.func_78380_c(this.field_78696_ap);
         var9.func_78374_a(var28, var32, var34, var20, var24);
         var9.func_78386_a(this.field_78684_au, this.field_78665_ay, this.field_78652_aC);
         var9.func_78380_c(this.field_78676_aq);
         var9.func_78374_a(var28, var32, var36, var12, var16);
      } else {
         var9.func_78374_a(var28, var30, var36, var22, var26);
         var9.func_78374_a(var28, var30, var34, var14, var18);
         var9.func_78374_a(var28, var32, var34, var20, var24);
         var9.func_78374_a(var28, var32, var36, var12, var16);
      }

   }

   public void func_78600_a(Block p_78600_1_, int p_78600_2_, float p_78600_3_) {
      Tessellator var4 = Tessellator.field_78398_a;
      boolean var5 = p_78600_1_.field_71990_ca == Block.field_71980_u.field_71990_ca;
      int var6;
      float var7;
      float var8;
      float var9;
      if(this.field_78668_c) {
         var6 = p_78600_1_.func_71889_f_(p_78600_2_);
         if(var5) {
            var6 = 16777215;
         }

         var7 = (float)(var6 >> 16 & 255) / 255.0F;
         var8 = (float)(var6 >> 8 & 255) / 255.0F;
         var9 = (float)(var6 & 255) / 255.0F;
         GL11.glColor4f(var7 * p_78600_3_, var8 * p_78600_3_, var9 * p_78600_3_, 1.0F);
      }

      var6 = p_78600_1_.func_71857_b();
      int var14;
      if(var6 != 0 && var6 != 31 && var6 != 16 && var6 != 26) {
         if(var6 == 1) {
            var4.func_78382_b();
            var4.func_78375_b(0.0F, -1.0F, 0.0F);
            this.func_78599_a(p_78600_1_, p_78600_2_, -0.5D, -0.5D, -0.5D);
            var4.func_78381_a();
         } else if(var6 == 19) {
            var4.func_78382_b();
            var4.func_78375_b(0.0F, -1.0F, 0.0F);
            p_78600_1_.func_71919_f();
            this.func_78575_a(p_78600_1_, p_78600_2_, p_78600_1_.field_72022_cl, -0.5D, -0.5D, -0.5D);
            var4.func_78381_a();
         } else if(var6 == 23) {
            var4.func_78382_b();
            var4.func_78375_b(0.0F, -1.0F, 0.0F);
            p_78600_1_.func_71919_f();
            var4.func_78381_a();
         } else if(var6 == 13) {
            p_78600_1_.func_71919_f();
            GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
            var7 = 0.0625F;
            var4.func_78382_b();
            var4.func_78375_b(0.0F, -1.0F, 0.0F);
            this.func_78613_a(p_78600_1_, 0.0D, 0.0D, 0.0D, p_78600_1_.func_71851_a(0));
            var4.func_78381_a();
            var4.func_78382_b();
            var4.func_78375_b(0.0F, 1.0F, 0.0F);
            this.func_78617_b(p_78600_1_, 0.0D, 0.0D, 0.0D, p_78600_1_.func_71851_a(1));
            var4.func_78381_a();
            var4.func_78382_b();
            var4.func_78375_b(0.0F, 0.0F, -1.0F);
            var4.func_78372_c(0.0F, 0.0F, var7);
            this.func_78611_c(p_78600_1_, 0.0D, 0.0D, 0.0D, p_78600_1_.func_71851_a(2));
            var4.func_78372_c(0.0F, 0.0F, -var7);
            var4.func_78381_a();
            var4.func_78382_b();
            var4.func_78375_b(0.0F, 0.0F, 1.0F);
            var4.func_78372_c(0.0F, 0.0F, -var7);
            this.func_78622_d(p_78600_1_, 0.0D, 0.0D, 0.0D, p_78600_1_.func_71851_a(3));
            var4.func_78372_c(0.0F, 0.0F, var7);
            var4.func_78381_a();
            var4.func_78382_b();
            var4.func_78375_b(-1.0F, 0.0F, 0.0F);
            var4.func_78372_c(var7, 0.0F, 0.0F);
            this.func_78573_e(p_78600_1_, 0.0D, 0.0D, 0.0D, p_78600_1_.func_71851_a(4));
            var4.func_78372_c(-var7, 0.0F, 0.0F);
            var4.func_78381_a();
            var4.func_78382_b();
            var4.func_78375_b(1.0F, 0.0F, 0.0F);
            var4.func_78372_c(-var7, 0.0F, 0.0F);
            this.func_78605_f(p_78600_1_, 0.0D, 0.0D, 0.0D, p_78600_1_.func_71851_a(5));
            var4.func_78372_c(var7, 0.0F, 0.0F);
            var4.func_78381_a();
            GL11.glTranslatef(0.5F, 0.5F, 0.5F);
         } else if(var6 == 22) {
            GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
            GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
            ChestItemRenderHelper.field_78545_a.func_78542_a(p_78600_1_, p_78600_2_, p_78600_3_);
            GL11.glEnable('\u803a');
         } else if(var6 == 6) {
            var4.func_78382_b();
            var4.func_78375_b(0.0F, -1.0F, 0.0F);
            this.func_78579_b(p_78600_1_, p_78600_2_, -0.5D, -0.5D, -0.5D);
            var4.func_78381_a();
         } else if(var6 == 2) {
            var4.func_78382_b();
            var4.func_78375_b(0.0F, -1.0F, 0.0F);
            this.func_78623_a(p_78600_1_, -0.5D, -0.5D, -0.5D, 0.0D, 0.0D);
            var4.func_78381_a();
         } else if(var6 == 10) {
            for(var14 = 0; var14 < 2; ++var14) {
               if(var14 == 0) {
                  p_78600_1_.func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.5F);
               }

               if(var14 == 1) {
                  p_78600_1_.func_71905_a(0.0F, 0.0F, 0.5F, 1.0F, 0.5F, 1.0F);
               }

               GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
               var4.func_78382_b();
               var4.func_78375_b(0.0F, -1.0F, 0.0F);
               this.func_78613_a(p_78600_1_, 0.0D, 0.0D, 0.0D, p_78600_1_.func_71851_a(0));
               var4.func_78381_a();
               var4.func_78382_b();
               var4.func_78375_b(0.0F, 1.0F, 0.0F);
               this.func_78617_b(p_78600_1_, 0.0D, 0.0D, 0.0D, p_78600_1_.func_71851_a(1));
               var4.func_78381_a();
               var4.func_78382_b();
               var4.func_78375_b(0.0F, 0.0F, -1.0F);
               this.func_78611_c(p_78600_1_, 0.0D, 0.0D, 0.0D, p_78600_1_.func_71851_a(2));
               var4.func_78381_a();
               var4.func_78382_b();
               var4.func_78375_b(0.0F, 0.0F, 1.0F);
               this.func_78622_d(p_78600_1_, 0.0D, 0.0D, 0.0D, p_78600_1_.func_71851_a(3));
               var4.func_78381_a();
               var4.func_78382_b();
               var4.func_78375_b(-1.0F, 0.0F, 0.0F);
               this.func_78573_e(p_78600_1_, 0.0D, 0.0D, 0.0D, p_78600_1_.func_71851_a(4));
               var4.func_78381_a();
               var4.func_78382_b();
               var4.func_78375_b(1.0F, 0.0F, 0.0F);
               this.func_78605_f(p_78600_1_, 0.0D, 0.0D, 0.0D, p_78600_1_.func_71851_a(5));
               var4.func_78381_a();
               GL11.glTranslatef(0.5F, 0.5F, 0.5F);
            }
         } else if(var6 == 27) {
            var14 = 0;
            GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
            var4.func_78382_b();

            for(int var15 = 0; var15 < 8; ++var15) {
               byte var16 = 0;
               byte var17 = 1;
               if(var15 == 0) {
                  var16 = 2;
               }

               if(var15 == 1) {
                  var16 = 3;
               }

               if(var15 == 2) {
                  var16 = 4;
               }

               if(var15 == 3) {
                  var16 = 5;
                  var17 = 2;
               }

               if(var15 == 4) {
                  var16 = 6;
                  var17 = 3;
               }

               if(var15 == 5) {
                  var16 = 7;
                  var17 = 5;
               }

               if(var15 == 6) {
                  var16 = 6;
                  var17 = 2;
               }

               if(var15 == 7) {
                  var16 = 3;
               }

               float var11 = (float)var16 / 16.0F;
               float var12 = 1.0F - (float)var14 / 16.0F;
               float var13 = 1.0F - (float)(var14 + var17) / 16.0F;
               var14 += var17;
               p_78600_1_.func_71905_a(0.5F - var11, var13, 0.5F - var11, 0.5F + var11, var12, 0.5F + var11);
               var4.func_78375_b(0.0F, -1.0F, 0.0F);
               this.func_78613_a(p_78600_1_, 0.0D, 0.0D, 0.0D, p_78600_1_.func_71851_a(0));
               var4.func_78375_b(0.0F, 1.0F, 0.0F);
               this.func_78617_b(p_78600_1_, 0.0D, 0.0D, 0.0D, p_78600_1_.func_71851_a(1));
               var4.func_78375_b(0.0F, 0.0F, -1.0F);
               this.func_78611_c(p_78600_1_, 0.0D, 0.0D, 0.0D, p_78600_1_.func_71851_a(2));
               var4.func_78375_b(0.0F, 0.0F, 1.0F);
               this.func_78622_d(p_78600_1_, 0.0D, 0.0D, 0.0D, p_78600_1_.func_71851_a(3));
               var4.func_78375_b(-1.0F, 0.0F, 0.0F);
               this.func_78573_e(p_78600_1_, 0.0D, 0.0D, 0.0D, p_78600_1_.func_71851_a(4));
               var4.func_78375_b(1.0F, 0.0F, 0.0F);
               this.func_78605_f(p_78600_1_, 0.0D, 0.0D, 0.0D, p_78600_1_.func_71851_a(5));
            }

            var4.func_78381_a();
            GL11.glTranslatef(0.5F, 0.5F, 0.5F);
            p_78600_1_.func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
         } else if(var6 == 11) {
            for(var14 = 0; var14 < 4; ++var14) {
               var8 = 0.125F;
               if(var14 == 0) {
                  p_78600_1_.func_71905_a(0.5F - var8, 0.0F, 0.0F, 0.5F + var8, 1.0F, var8 * 2.0F);
               }

               if(var14 == 1) {
                  p_78600_1_.func_71905_a(0.5F - var8, 0.0F, 1.0F - var8 * 2.0F, 0.5F + var8, 1.0F, 1.0F);
               }

               var8 = 0.0625F;
               if(var14 == 2) {
                  p_78600_1_.func_71905_a(0.5F - var8, 1.0F - var8 * 3.0F, -var8 * 2.0F, 0.5F + var8, 1.0F - var8, 1.0F + var8 * 2.0F);
               }

               if(var14 == 3) {
                  p_78600_1_.func_71905_a(0.5F - var8, 0.5F - var8 * 3.0F, -var8 * 2.0F, 0.5F + var8, 0.5F - var8, 1.0F + var8 * 2.0F);
               }

               GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
               var4.func_78382_b();
               var4.func_78375_b(0.0F, -1.0F, 0.0F);
               this.func_78613_a(p_78600_1_, 0.0D, 0.0D, 0.0D, p_78600_1_.func_71851_a(0));
               var4.func_78381_a();
               var4.func_78382_b();
               var4.func_78375_b(0.0F, 1.0F, 0.0F);
               this.func_78617_b(p_78600_1_, 0.0D, 0.0D, 0.0D, p_78600_1_.func_71851_a(1));
               var4.func_78381_a();
               var4.func_78382_b();
               var4.func_78375_b(0.0F, 0.0F, -1.0F);
               this.func_78611_c(p_78600_1_, 0.0D, 0.0D, 0.0D, p_78600_1_.func_71851_a(2));
               var4.func_78381_a();
               var4.func_78382_b();
               var4.func_78375_b(0.0F, 0.0F, 1.0F);
               this.func_78622_d(p_78600_1_, 0.0D, 0.0D, 0.0D, p_78600_1_.func_71851_a(3));
               var4.func_78381_a();
               var4.func_78382_b();
               var4.func_78375_b(-1.0F, 0.0F, 0.0F);
               this.func_78573_e(p_78600_1_, 0.0D, 0.0D, 0.0D, p_78600_1_.func_71851_a(4));
               var4.func_78381_a();
               var4.func_78382_b();
               var4.func_78375_b(1.0F, 0.0F, 0.0F);
               this.func_78605_f(p_78600_1_, 0.0D, 0.0D, 0.0D, p_78600_1_.func_71851_a(5));
               var4.func_78381_a();
               GL11.glTranslatef(0.5F, 0.5F, 0.5F);
            }

            p_78600_1_.func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
         } else if(var6 == 21) {
            for(var14 = 0; var14 < 3; ++var14) {
               var8 = 0.0625F;
               if(var14 == 0) {
                  p_78600_1_.func_71905_a(0.5F - var8, 0.3F, 0.0F, 0.5F + var8, 1.0F, var8 * 2.0F);
               }

               if(var14 == 1) {
                  p_78600_1_.func_71905_a(0.5F - var8, 0.3F, 1.0F - var8 * 2.0F, 0.5F + var8, 1.0F, 1.0F);
               }

               var8 = 0.0625F;
               if(var14 == 2) {
                  p_78600_1_.func_71905_a(0.5F - var8, 0.5F, 0.0F, 0.5F + var8, 1.0F - var8, 1.0F);
               }

               GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
               var4.func_78382_b();
               var4.func_78375_b(0.0F, -1.0F, 0.0F);
               this.func_78613_a(p_78600_1_, 0.0D, 0.0D, 0.0D, p_78600_1_.func_71851_a(0));
               var4.func_78381_a();
               var4.func_78382_b();
               var4.func_78375_b(0.0F, 1.0F, 0.0F);
               this.func_78617_b(p_78600_1_, 0.0D, 0.0D, 0.0D, p_78600_1_.func_71851_a(1));
               var4.func_78381_a();
               var4.func_78382_b();
               var4.func_78375_b(0.0F, 0.0F, -1.0F);
               this.func_78611_c(p_78600_1_, 0.0D, 0.0D, 0.0D, p_78600_1_.func_71851_a(2));
               var4.func_78381_a();
               var4.func_78382_b();
               var4.func_78375_b(0.0F, 0.0F, 1.0F);
               this.func_78622_d(p_78600_1_, 0.0D, 0.0D, 0.0D, p_78600_1_.func_71851_a(3));
               var4.func_78381_a();
               var4.func_78382_b();
               var4.func_78375_b(-1.0F, 0.0F, 0.0F);
               this.func_78573_e(p_78600_1_, 0.0D, 0.0D, 0.0D, p_78600_1_.func_71851_a(4));
               var4.func_78381_a();
               var4.func_78382_b();
               var4.func_78375_b(1.0F, 0.0F, 0.0F);
               this.func_78605_f(p_78600_1_, 0.0D, 0.0D, 0.0D, p_78600_1_.func_71851_a(5));
               var4.func_78381_a();
               GL11.glTranslatef(0.5F, 0.5F, 0.5F);
            }

            p_78600_1_.func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
         }
      } else {
         if(var6 == 16) {
            p_78600_2_ = 1;
         }

         p_78600_1_.func_71919_f();
         GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
         GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
         var4.func_78382_b();
         var4.func_78375_b(0.0F, -1.0F, 0.0F);
         this.func_78613_a(p_78600_1_, 0.0D, 0.0D, 0.0D, p_78600_1_.func_71858_a(0, p_78600_2_));
         var4.func_78381_a();
         if(var5 && this.field_78668_c) {
            var14 = p_78600_1_.func_71889_f_(p_78600_2_);
            var8 = (float)(var14 >> 16 & 255) / 255.0F;
            var9 = (float)(var14 >> 8 & 255) / 255.0F;
            float var10 = (float)(var14 & 255) / 255.0F;
            GL11.glColor4f(var8 * p_78600_3_, var9 * p_78600_3_, var10 * p_78600_3_, 1.0F);
         }

         var4.func_78382_b();
         var4.func_78375_b(0.0F, 1.0F, 0.0F);
         this.func_78617_b(p_78600_1_, 0.0D, 0.0D, 0.0D, p_78600_1_.func_71858_a(1, p_78600_2_));
         var4.func_78381_a();
         if(var5 && this.field_78668_c) {
            GL11.glColor4f(p_78600_3_, p_78600_3_, p_78600_3_, 1.0F);
         }

         var4.func_78382_b();
         var4.func_78375_b(0.0F, 0.0F, -1.0F);
         this.func_78611_c(p_78600_1_, 0.0D, 0.0D, 0.0D, p_78600_1_.func_71858_a(2, p_78600_2_));
         var4.func_78381_a();
         var4.func_78382_b();
         var4.func_78375_b(0.0F, 0.0F, 1.0F);
         this.func_78622_d(p_78600_1_, 0.0D, 0.0D, 0.0D, p_78600_1_.func_71858_a(3, p_78600_2_));
         var4.func_78381_a();
         var4.func_78382_b();
         var4.func_78375_b(-1.0F, 0.0F, 0.0F);
         this.func_78573_e(p_78600_1_, 0.0D, 0.0D, 0.0D, p_78600_1_.func_71858_a(4, p_78600_2_));
         var4.func_78381_a();
         var4.func_78382_b();
         var4.func_78375_b(1.0F, 0.0F, 0.0F);
         this.func_78605_f(p_78600_1_, 0.0D, 0.0D, 0.0D, p_78600_1_.func_71858_a(5, p_78600_2_));
         var4.func_78381_a();
         GL11.glTranslatef(0.5F, 0.5F, 0.5F);
      }

   }

   public static boolean func_78597_b(int p_78597_0_) {
      return p_78597_0_ == 0?true:(p_78597_0_ == 31?true:(p_78597_0_ == 13?true:(p_78597_0_ == 10?true:(p_78597_0_ == 11?true:(p_78597_0_ == 27?true:(p_78597_0_ == 22?true:(p_78597_0_ == 21?true:(p_78597_0_ == 16?true:p_78597_0_ == 26))))))));
   }

}
