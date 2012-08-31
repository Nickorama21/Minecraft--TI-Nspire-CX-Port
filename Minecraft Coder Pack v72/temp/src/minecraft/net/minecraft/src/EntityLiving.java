package net.minecraft.src;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.ChunkCoordinates;
import net.minecraft.src.DamageSource;
import net.minecraft.src.EnchantmentHelper;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityAITasks;
import net.minecraft.src.EntityBodyHelper;
import net.minecraft.src.EntityCreeper;
import net.minecraft.src.EntityGhast;
import net.minecraft.src.EntityJumpHelper;
import net.minecraft.src.EntityLookHelper;
import net.minecraft.src.EntityMoveHelper;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EntitySenses;
import net.minecraft.src.EntityWolf;
import net.minecraft.src.EntityXPOrb;
import net.minecraft.src.EnumCreatureAttribute;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.MathHelper;
import net.minecraft.src.MovingObjectPosition;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.NBTTagList;
import net.minecraft.src.PathNavigate;
import net.minecraft.src.Potion;
import net.minecraft.src.PotionEffect;
import net.minecraft.src.PotionHelper;
import net.minecraft.src.StepSound;
import net.minecraft.src.Vec3;
import net.minecraft.src.World;

public abstract class EntityLiving extends Entity {

   public int field_70771_an = 20;
   public float field_70769_ao;
   public float field_70770_ap;
   public float field_70761_aq = 0.0F;
   public float field_70760_ar = 0.0F;
   public float field_70759_as = 0.0F;
   public float field_70758_at = 0.0F;
   protected float field_70768_au;
   protected float field_70766_av;
   protected float field_70764_aw;
   protected float field_70763_ax;
   protected boolean field_70753_ay = true;
   protected String field_70750_az = "/mob/char.png";
   protected boolean field_70740_aA = true;
   protected float field_70741_aB = 0.0F;
   protected String field_70742_aC = null;
   protected float field_70743_aD = 1.0F;
   protected int field_70744_aE = 0;
   protected float field_70745_aF = 0.0F;
   public float field_70746_aG = 0.1F;
   public float field_70747_aH = 0.02F;
   public float field_70732_aI;
   public float field_70733_aJ;
   protected int field_70734_aK = this.func_70667_aM();
   public int field_70735_aL;
   protected int field_70736_aM;
   private int field_70757_a;
   public int field_70737_aN;
   public int field_70738_aO;
   public float field_70739_aP = 0.0F;
   public int field_70725_aQ = 0;
   public int field_70724_aR = 0;
   public float field_70727_aS;
   public float field_70726_aT;
   protected boolean field_70729_aU = false;
   protected int field_70728_aV;
   public int field_70731_aW = -1;
   public float field_70730_aX = (float)(Math.random() * 0.8999999761581421D + 0.10000000149011612D);
   public float field_70722_aY;
   public float field_70721_aZ;
   public float field_70754_ba;
   protected EntityPlayer field_70717_bb = null;
   protected int field_70718_bc = 0;
   private EntityLiving field_70755_b = null;
   private int field_70756_c = 0;
   private EntityLiving field_70751_d = null;
   public int field_70719_bd = 0;
   public int field_70720_be = 0;
   protected HashMap field_70713_bf = new HashMap();
   private boolean field_70752_e = true;
   private int field_70748_f;
   private EntityLookHelper field_70749_g;
   private EntityMoveHelper field_70765_h;
   private EntityJumpHelper field_70767_i;
   private EntityBodyHelper field_70762_j;
   private PathNavigate field_70699_by;
   protected final EntityAITasks field_70714_bg;
   protected final EntityAITasks field_70715_bh;
   private EntityLiving field_70696_bz;
   private EntitySenses field_70723_bA;
   private float field_70774_bB;
   private ChunkCoordinates field_70775_bC = new ChunkCoordinates(0, 0, 0);
   private float field_70772_bD = -1.0F;
   protected int field_70716_bi;
   protected double field_70709_bj;
   protected double field_70710_bk;
   protected double field_70711_bl;
   protected double field_70712_bm;
   protected double field_70705_bn;
   float field_70706_bo = 0.0F;
   protected int field_70707_bp = 0;
   protected int field_70708_bq = 0;
   protected float field_70702_br;
   protected float field_70701_bs;
   protected float field_70704_bt;
   protected boolean field_70703_bu = false;
   protected float field_70698_bv = 0.0F;
   protected float field_70697_bw = 0.7F;
   private int field_70773_bE = 0;
   private Entity field_70776_bF;
   protected int field_70700_bx = 0;


   public EntityLiving(World p_i3443_1_) {
      super(p_i3443_1_);
      this.field_70156_m = true;
      this.field_70714_bg = new EntityAITasks(p_i3443_1_ != null && p_i3443_1_.field_72984_F != null?p_i3443_1_.field_72984_F:null);
      this.field_70715_bh = new EntityAITasks(p_i3443_1_ != null && p_i3443_1_.field_72984_F != null?p_i3443_1_.field_72984_F:null);
      this.field_70749_g = new EntityLookHelper(this);
      this.field_70765_h = new EntityMoveHelper(this);
      this.field_70767_i = new EntityJumpHelper(this);
      this.field_70762_j = new EntityBodyHelper(this);
      this.field_70699_by = new PathNavigate(this, p_i3443_1_, 16.0F);
      this.field_70723_bA = new EntitySenses(this);
      this.field_70770_ap = (float)(Math.random() + 1.0D) * 0.01F;
      this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
      this.field_70769_ao = (float)Math.random() * 12398.0F;
      this.field_70177_z = (float)(Math.random() * 3.1415927410125732D * 2.0D);
      this.field_70759_as = this.field_70177_z;
      this.field_70138_W = 0.5F;
   }

   public EntityLookHelper func_70671_ap() {
      return this.field_70749_g;
   }

   public EntityMoveHelper func_70605_aq() {
      return this.field_70765_h;
   }

   public EntityJumpHelper func_70683_ar() {
      return this.field_70767_i;
   }

   public PathNavigate func_70661_as() {
      return this.field_70699_by;
   }

   public EntitySenses func_70635_at() {
      return this.field_70723_bA;
   }

   public Random func_70681_au() {
      return this.field_70146_Z;
   }

   public EntityLiving func_70643_av() {
      return this.field_70755_b;
   }

   public EntityLiving func_70680_aw() {
      return this.field_70751_d;
   }

   public void func_70607_j(Entity p_70607_1_) {
      if(p_70607_1_ instanceof EntityLiving) {
         this.field_70751_d = (EntityLiving)p_70607_1_;
      }

   }

   public int func_70654_ax() {
      return this.field_70708_bq;
   }

   public float func_70079_am() {
      return this.field_70759_as;
   }

   public void func_70034_d(float p_70034_1_) {
      this.field_70759_as = p_70034_1_;
   }

   public float func_70689_ay() {
      return this.field_70774_bB;
   }

   public void func_70659_e(float p_70659_1_) {
      this.field_70774_bB = p_70659_1_;
      this.func_70657_f(p_70659_1_);
   }

   public boolean func_70652_k(Entity p_70652_1_) {
      this.func_70607_j(p_70652_1_);
      return false;
   }

   public EntityLiving func_70638_az() {
      return this.field_70696_bz;
   }

   public void func_70624_b(EntityLiving p_70624_1_) {
      this.field_70696_bz = p_70624_1_;
   }

   public boolean func_70686_a(Class p_70686_1_) {
      return EntityCreeper.class != p_70686_1_ && EntityGhast.class != p_70686_1_;
   }

   public void func_70615_aA() {}

   public boolean func_70611_aB() {
      return this.func_70649_d(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70163_u), MathHelper.func_76128_c(this.field_70161_v));
   }

   public boolean func_70649_d(int p_70649_1_, int p_70649_2_, int p_70649_3_) {
      return this.field_70772_bD == -1.0F?true:this.field_70775_bC.func_71569_e(p_70649_1_, p_70649_2_, p_70649_3_) < this.field_70772_bD * this.field_70772_bD;
   }

   public void func_70598_b(int p_70598_1_, int p_70598_2_, int p_70598_3_, int p_70598_4_) {
      this.field_70775_bC.func_71571_b(p_70598_1_, p_70598_2_, p_70598_3_);
      this.field_70772_bD = (float)p_70598_4_;
   }

   public ChunkCoordinates func_70602_aC() {
      return this.field_70775_bC;
   }

   public float func_70640_aD() {
      return this.field_70772_bD;
   }

   public void func_70677_aE() {
      this.field_70772_bD = -1.0F;
   }

   public boolean func_70622_aF() {
      return this.field_70772_bD != -1.0F;
   }

   public void func_70604_c(EntityLiving p_70604_1_) {
      this.field_70755_b = p_70604_1_;
      this.field_70756_c = this.field_70755_b != null?60:0;
   }

   protected void func_70088_a() {
      this.field_70180_af.func_75682_a(8, Integer.valueOf(this.field_70748_f));
   }

   public boolean func_70685_l(Entity p_70685_1_) {
      return this.field_70170_p.func_72933_a(Vec3.func_72437_a().func_72345_a(this.field_70165_t, this.field_70163_u + (double)this.func_70047_e(), this.field_70161_v), Vec3.func_72437_a().func_72345_a(p_70685_1_.field_70165_t, p_70685_1_.field_70163_u + (double)p_70685_1_.func_70047_e(), p_70685_1_.field_70161_v)) == null;
   }

   public String func_70073_O() {
      return this.field_70750_az;
   }

   public boolean func_70067_L() {
      return !this.field_70128_L;
   }

   public boolean func_70104_M() {
      return !this.field_70128_L;
   }

   public float func_70047_e() {
      return this.field_70131_O * 0.85F;
   }

   public int func_70627_aG() {
      return 80;
   }

   public void func_70642_aH() {
      String var1 = this.func_70639_aQ();
      if(var1 != null) {
         this.field_70170_p.func_72956_a(this, var1, this.func_70599_aP(), this.func_70647_i());
      }

   }

   public void func_70030_z() {
      this.field_70732_aI = this.field_70733_aJ;
      super.func_70030_z();
      this.field_70170_p.field_72984_F.func_76320_a("mobBaseTick");
      if(this.func_70089_S() && this.field_70146_Z.nextInt(1000) < this.field_70757_a++) {
         this.field_70757_a = -this.func_70627_aG();
         this.func_70642_aH();
      }

      if(this.func_70089_S() && this.func_70094_T()) {
         this.func_70097_a(DamageSource.field_76368_d, 1);
      }

      if(this.func_70045_F() || this.field_70170_p.field_72995_K) {
         this.func_70066_B();
      }

      if(this.func_70089_S() && this.func_70055_a(Material.field_76244_g) && !this.func_70648_aU() && !this.field_70713_bf.containsKey(Integer.valueOf(Potion.field_76427_o.field_76415_H))) {
         this.func_70050_g(this.func_70682_h(this.func_70086_ai()));
         if(this.func_70086_ai() == -20) {
            this.func_70050_g(0);

            for(int var1 = 0; var1 < 8; ++var1) {
               float var2 = this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat();
               float var3 = this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat();
               float var4 = this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat();
               this.field_70170_p.func_72869_a("bubble", this.field_70165_t + (double)var2, this.field_70163_u + (double)var3, this.field_70161_v + (double)var4, this.field_70159_w, this.field_70181_x, this.field_70179_y);
            }

            this.func_70097_a(DamageSource.field_76369_e, 2);
         }

         this.func_70066_B();
      } else {
         this.func_70050_g(300);
      }

      this.field_70727_aS = this.field_70726_aT;
      if(this.field_70724_aR > 0) {
         --this.field_70724_aR;
      }

      if(this.field_70737_aN > 0) {
         --this.field_70737_aN;
      }

      if(this.field_70172_ad > 0) {
         --this.field_70172_ad;
      }

      if(this.field_70734_aK <= 0) {
         this.func_70609_aI();
      }

      if(this.field_70718_bc > 0) {
         --this.field_70718_bc;
      } else {
         this.field_70717_bb = null;
      }

      if(this.field_70751_d != null && !this.field_70751_d.func_70089_S()) {
         this.field_70751_d = null;
      }

      if(this.field_70755_b != null) {
         if(!this.field_70755_b.func_70089_S()) {
            this.func_70604_c((EntityLiving)null);
         } else if(this.field_70756_c > 0) {
            --this.field_70756_c;
         } else {
            this.func_70604_c((EntityLiving)null);
         }
      }

      this.func_70679_bo();
      this.field_70763_ax = this.field_70764_aw;
      this.field_70760_ar = this.field_70761_aq;
      this.field_70758_at = this.field_70759_as;
      this.field_70126_B = this.field_70177_z;
      this.field_70127_C = this.field_70125_A;
      this.field_70170_p.field_72984_F.func_76319_b();
   }

   protected void func_70609_aI() {
      ++this.field_70725_aQ;
      if(this.field_70725_aQ == 20) {
         int var1;
         if(!this.field_70170_p.field_72995_K && (this.field_70718_bc > 0 || this.func_70684_aJ()) && !this.func_70631_g_()) {
            var1 = this.func_70693_a(this.field_70717_bb);

            while(var1 > 0) {
               int var2 = EntityXPOrb.func_70527_a(var1);
               var1 -= var2;
               this.field_70170_p.func_72838_d(new EntityXPOrb(this.field_70170_p, this.field_70165_t, this.field_70163_u, this.field_70161_v, var2));
            }
         }

         this.func_70106_y();

         for(var1 = 0; var1 < 20; ++var1) {
            double var8 = this.field_70146_Z.nextGaussian() * 0.02D;
            double var4 = this.field_70146_Z.nextGaussian() * 0.02D;
            double var6 = this.field_70146_Z.nextGaussian() * 0.02D;
            this.field_70170_p.func_72869_a("explode", this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * this.field_70130_N * 2.0F) - (double)this.field_70130_N, this.field_70163_u + (double)(this.field_70146_Z.nextFloat() * this.field_70131_O), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * this.field_70130_N * 2.0F) - (double)this.field_70130_N, var8, var4, var6);
         }
      }

   }

   protected int func_70682_h(int p_70682_1_) {
      return p_70682_1_ - 1;
   }

   protected int func_70693_a(EntityPlayer p_70693_1_) {
      return this.field_70728_aV;
   }

   protected boolean func_70684_aJ() {
      return false;
   }

   public void func_70656_aK() {
      for(int var1 = 0; var1 < 20; ++var1) {
         double var2 = this.field_70146_Z.nextGaussian() * 0.02D;
         double var4 = this.field_70146_Z.nextGaussian() * 0.02D;
         double var6 = this.field_70146_Z.nextGaussian() * 0.02D;
         double var8 = 10.0D;
         this.field_70170_p.func_72869_a("explode", this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * this.field_70130_N * 2.0F) - (double)this.field_70130_N - var2 * var8, this.field_70163_u + (double)(this.field_70146_Z.nextFloat() * this.field_70131_O) - var4 * var8, this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * this.field_70130_N * 2.0F) - (double)this.field_70130_N - var6 * var8, var2, var4, var6);
      }

   }

   public void func_70098_U() {
      super.func_70098_U();
      this.field_70768_au = this.field_70766_av;
      this.field_70766_av = 0.0F;
      this.field_70143_R = 0.0F;
   }

   public void func_70056_a(double p_70056_1_, double p_70056_3_, double p_70056_5_, float p_70056_7_, float p_70056_8_, int p_70056_9_) {
      this.field_70129_M = 0.0F;
      this.field_70709_bj = p_70056_1_;
      this.field_70710_bk = p_70056_3_;
      this.field_70711_bl = p_70056_5_;
      this.field_70712_bm = (double)p_70056_7_;
      this.field_70705_bn = (double)p_70056_8_;
      this.field_70716_bi = p_70056_9_;
   }

   public void func_70071_h_() {
      super.func_70071_h_();
      if(this.field_70719_bd > 0) {
         if(this.field_70720_be <= 0) {
            this.field_70720_be = 60;
         }

         --this.field_70720_be;
         if(this.field_70720_be <= 0) {
            --this.field_70719_bd;
         }
      }

      this.func_70636_d();
      double var1 = this.field_70165_t - this.field_70169_q;
      double var3 = this.field_70161_v - this.field_70166_s;
      float var5 = (float)(var1 * var1 + var3 * var3);
      float var6 = this.field_70761_aq;
      float var7 = 0.0F;
      this.field_70768_au = this.field_70766_av;
      float var8 = 0.0F;
      if(var5 > 0.0025000002F) {
         var8 = 1.0F;
         var7 = (float)Math.sqrt((double)var5) * 3.0F;
         var6 = (float)Math.atan2(var3, var1) * 180.0F / 3.1415927F - 90.0F;
      }

      if(this.field_70733_aJ > 0.0F) {
         var6 = this.field_70177_z;
      }

      if(!this.field_70122_E) {
         var8 = 0.0F;
      }

      this.field_70766_av += (var8 - this.field_70766_av) * 0.3F;
      this.field_70170_p.field_72984_F.func_76320_a("headTurn");
      if(this.func_70650_aV()) {
         this.field_70762_j.func_75664_a();
      } else {
         float var9 = MathHelper.func_76142_g(var6 - this.field_70761_aq);
         this.field_70761_aq += var9 * 0.3F;
         float var10 = MathHelper.func_76142_g(this.field_70177_z - this.field_70761_aq);
         boolean var11 = var10 < -90.0F || var10 >= 90.0F;
         if(var10 < -75.0F) {
            var10 = -75.0F;
         }

         if(var10 >= 75.0F) {
            var10 = 75.0F;
         }

         this.field_70761_aq = this.field_70177_z - var10;
         if(var10 * var10 > 2500.0F) {
            this.field_70761_aq += var10 * 0.2F;
         }

         if(var11) {
            var7 *= -1.0F;
         }
      }

      this.field_70170_p.field_72984_F.func_76319_b();
      this.field_70170_p.field_72984_F.func_76320_a("rangeChecks");

      while(this.field_70177_z - this.field_70126_B < -180.0F) {
         this.field_70126_B -= 360.0F;
      }

      while(this.field_70177_z - this.field_70126_B >= 180.0F) {
         this.field_70126_B += 360.0F;
      }

      while(this.field_70761_aq - this.field_70760_ar < -180.0F) {
         this.field_70760_ar -= 360.0F;
      }

      while(this.field_70761_aq - this.field_70760_ar >= 180.0F) {
         this.field_70760_ar += 360.0F;
      }

      while(this.field_70125_A - this.field_70127_C < -180.0F) {
         this.field_70127_C -= 360.0F;
      }

      while(this.field_70125_A - this.field_70127_C >= 180.0F) {
         this.field_70127_C += 360.0F;
      }

      while(this.field_70759_as - this.field_70758_at < -180.0F) {
         this.field_70758_at -= 360.0F;
      }

      while(this.field_70759_as - this.field_70758_at >= 180.0F) {
         this.field_70758_at += 360.0F;
      }

      this.field_70170_p.field_72984_F.func_76319_b();
      this.field_70764_aw += var7;
   }

   public void func_70691_i(int p_70691_1_) {
      if(this.field_70734_aK > 0) {
         this.field_70734_aK += p_70691_1_;
         if(this.field_70734_aK > this.func_70667_aM()) {
            this.field_70734_aK = this.func_70667_aM();
         }

         this.field_70172_ad = this.field_70771_an / 2;
      }
   }

   public abstract int func_70667_aM();

   public int func_70630_aN() {
      return this.field_70734_aK;
   }

   public void func_70606_j(int p_70606_1_) {
      this.field_70734_aK = p_70606_1_;
      if(p_70606_1_ > this.func_70667_aM()) {
         p_70606_1_ = this.func_70667_aM();
      }

   }

   public boolean func_70097_a(DamageSource p_70097_1_, int p_70097_2_) {
      if(this.field_70170_p.field_72995_K) {
         return false;
      } else {
         this.field_70708_bq = 0;
         if(this.field_70734_aK <= 0) {
            return false;
         } else if(p_70097_1_.func_76347_k() && this.func_70644_a(Potion.field_76426_n)) {
            return false;
         } else {
            this.field_70721_aZ = 1.5F;
            boolean var3 = true;
            if((float)this.field_70172_ad > (float)this.field_70771_an / 2.0F) {
               if(p_70097_2_ <= this.field_70707_bp) {
                  return false;
               }

               this.func_70665_d(p_70097_1_, p_70097_2_ - this.field_70707_bp);
               this.field_70707_bp = p_70097_2_;
               var3 = false;
            } else {
               this.field_70707_bp = p_70097_2_;
               this.field_70735_aL = this.field_70734_aK;
               this.field_70172_ad = this.field_70771_an;
               this.func_70665_d(p_70097_1_, p_70097_2_);
               this.field_70737_aN = this.field_70738_aO = 10;
            }

            this.field_70739_aP = 0.0F;
            Entity var4 = p_70097_1_.func_76346_g();
            if(var4 != null) {
               if(var4 instanceof EntityLiving) {
                  this.func_70604_c((EntityLiving)var4);
               }

               if(var4 instanceof EntityPlayer) {
                  this.field_70718_bc = 60;
                  this.field_70717_bb = (EntityPlayer)var4;
               } else if(var4 instanceof EntityWolf) {
                  EntityWolf var5 = (EntityWolf)var4;
                  if(var5.func_70909_n()) {
                     this.field_70718_bc = 60;
                     this.field_70717_bb = null;
                  }
               }
            }

            if(var3) {
               this.field_70170_p.func_72960_a(this, (byte)2);
               if(p_70097_1_ != DamageSource.field_76369_e && p_70097_1_ != DamageSource.field_76375_l) {
                  this.func_70018_K();
               }

               if(var4 != null) {
                  double var9 = var4.field_70165_t - this.field_70165_t;

                  double var7;
                  for(var7 = var4.field_70161_v - this.field_70161_v; var9 * var9 + var7 * var7 < 1.0E-4D; var7 = (Math.random() - Math.random()) * 0.01D) {
                     var9 = (Math.random() - Math.random()) * 0.01D;
                  }

                  this.field_70739_aP = (float)(Math.atan2(var7, var9) * 180.0D / 3.1415927410125732D) - this.field_70177_z;
                  this.func_70653_a(var4, p_70097_2_, var9, var7);
               } else {
                  this.field_70739_aP = (float)((int)(Math.random() * 2.0D) * 180);
               }
            }

            if(this.field_70734_aK <= 0) {
               if(var3) {
                  this.field_70170_p.func_72956_a(this, this.func_70673_aS(), this.func_70599_aP(), this.func_70647_i());
               }

               this.func_70645_a(p_70097_1_);
            } else if(var3) {
               this.field_70170_p.func_72956_a(this, this.func_70621_aR(), this.func_70599_aP(), this.func_70647_i());
            }

            return true;
         }
      }
   }

   private float func_70647_i() {
      return this.func_70631_g_()?(this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.2F + 1.5F:(this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.2F + 1.0F;
   }

   public void func_70057_ab() {
      this.field_70737_aN = this.field_70738_aO = 10;
      this.field_70739_aP = 0.0F;
   }

   public int func_70658_aO() {
      return 0;
   }

   protected void func_70675_k(int p_70675_1_) {}

   protected int func_70655_b(DamageSource p_70655_1_, int p_70655_2_) {
      if(!p_70655_1_.func_76363_c()) {
         int var3 = 25 - this.func_70658_aO();
         int var4 = p_70655_2_ * var3 + this.field_70736_aM;
         this.func_70675_k(p_70655_2_);
         p_70655_2_ = var4 / 25;
         this.field_70736_aM = var4 % 25;
      }

      return p_70655_2_;
   }

   protected int func_70672_c(DamageSource p_70672_1_, int p_70672_2_) {
      if(this.func_70644_a(Potion.field_76429_m)) {
         int var3 = (this.func_70660_b(Potion.field_76429_m).func_76458_c() + 1) * 5;
         int var4 = 25 - var3;
         int var5 = p_70672_2_ * var4 + this.field_70736_aM;
         p_70672_2_ = var5 / 25;
         this.field_70736_aM = var5 % 25;
      }

      return p_70672_2_;
   }

   protected void func_70665_d(DamageSource p_70665_1_, int p_70665_2_) {
      p_70665_2_ = this.func_70655_b(p_70665_1_, p_70665_2_);
      p_70665_2_ = this.func_70672_c(p_70665_1_, p_70665_2_);
      this.field_70734_aK -= p_70665_2_;
   }

   protected float func_70599_aP() {
      return 1.0F;
   }

   protected String func_70639_aQ() {
      return null;
   }

   protected String func_70621_aR() {
      return "damage.hurtflesh";
   }

   protected String func_70673_aS() {
      return "damage.hurtflesh";
   }

   public void func_70653_a(Entity p_70653_1_, int p_70653_2_, double p_70653_3_, double p_70653_5_) {
      this.field_70160_al = true;
      float var7 = MathHelper.func_76133_a(p_70653_3_ * p_70653_3_ + p_70653_5_ * p_70653_5_);
      float var8 = 0.4F;
      this.field_70159_w /= 2.0D;
      this.field_70181_x /= 2.0D;
      this.field_70179_y /= 2.0D;
      this.field_70159_w -= p_70653_3_ / (double)var7 * (double)var8;
      this.field_70181_x += (double)var8;
      this.field_70179_y -= p_70653_5_ / (double)var7 * (double)var8;
      if(this.field_70181_x > 0.4000000059604645D) {
         this.field_70181_x = 0.4000000059604645D;
      }

   }

   public void func_70645_a(DamageSource p_70645_1_) {
      Entity var2 = p_70645_1_.func_76346_g();
      if(this.field_70744_aE >= 0 && var2 != null) {
         var2.func_70084_c(this, this.field_70744_aE);
      }

      if(var2 != null) {
         var2.func_70074_a(this);
      }

      this.field_70729_aU = true;
      if(!this.field_70170_p.field_72995_K) {
         int var3 = 0;
         if(var2 instanceof EntityPlayer) {
            var3 = EnchantmentHelper.func_77519_f(((EntityPlayer)var2).field_71071_by);
         }

         if(!this.func_70631_g_()) {
            this.func_70628_a(this.field_70718_bc > 0, var3);
            if(this.field_70718_bc > 0) {
               int var4 = this.field_70146_Z.nextInt(200) - var3;
               if(var4 < 5) {
                  this.func_70600_l(var4 <= 0?1:0);
               }
            }
         }
      }

      this.field_70170_p.func_72960_a(this, (byte)3);
   }

   protected void func_70600_l(int p_70600_1_) {}

   protected void func_70628_a(boolean p_70628_1_, int p_70628_2_) {
      int var3 = this.func_70633_aT();
      if(var3 > 0) {
         int var4 = this.field_70146_Z.nextInt(3);
         if(p_70628_2_ > 0) {
            var4 += this.field_70146_Z.nextInt(p_70628_2_ + 1);
         }

         for(int var5 = 0; var5 < var4; ++var5) {
            this.func_70025_b(var3, 1);
         }
      }

   }

   protected int func_70633_aT() {
      return 0;
   }

   protected void func_70069_a(float p_70069_1_) {
      super.func_70069_a(p_70069_1_);
      int var2 = MathHelper.func_76123_f(p_70069_1_ - 3.0F);
      if(var2 > 0) {
         if(var2 > 4) {
            this.field_70170_p.func_72956_a(this, "damage.fallbig", 1.0F, 1.0F);
         } else {
            this.field_70170_p.func_72956_a(this, "damage.fallsmall", 1.0F, 1.0F);
         }

         this.func_70097_a(DamageSource.field_76379_h, var2);
         int var3 = this.field_70170_p.func_72798_a(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70163_u - 0.20000000298023224D - (double)this.field_70129_M), MathHelper.func_76128_c(this.field_70161_v));
         if(var3 > 0) {
            StepSound var4 = Block.field_71973_m[var3].field_72020_cn;
            this.field_70170_p.func_72956_a(this, var4.func_72675_d(), var4.func_72677_b() * 0.5F, var4.func_72678_c() * 0.75F);
         }
      }

   }

   public void func_70612_e(float p_70612_1_, float p_70612_2_) {
      double var9;
      if(this.func_70090_H() && (!(this instanceof EntityPlayer) || !((EntityPlayer)this).field_71075_bZ.field_75100_b)) {
         var9 = this.field_70163_u;
         this.func_70060_a(p_70612_1_, p_70612_2_, this.func_70650_aV()?0.04F:0.02F);
         this.func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
         this.field_70159_w *= 0.800000011920929D;
         this.field_70181_x *= 0.800000011920929D;
         this.field_70179_y *= 0.800000011920929D;
         this.field_70181_x -= 0.02D;
         if(this.field_70123_F && this.func_70038_c(this.field_70159_w, this.field_70181_x + 0.6000000238418579D - this.field_70163_u + var9, this.field_70179_y)) {
            this.field_70181_x = 0.30000001192092896D;
         }
      } else if(this.func_70058_J() && (!(this instanceof EntityPlayer) || !((EntityPlayer)this).field_71075_bZ.field_75100_b)) {
         var9 = this.field_70163_u;
         this.func_70060_a(p_70612_1_, p_70612_2_, 0.02F);
         this.func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
         this.field_70159_w *= 0.5D;
         this.field_70181_x *= 0.5D;
         this.field_70179_y *= 0.5D;
         this.field_70181_x -= 0.02D;
         if(this.field_70123_F && this.func_70038_c(this.field_70159_w, this.field_70181_x + 0.6000000238418579D - this.field_70163_u + var9, this.field_70179_y)) {
            this.field_70181_x = 0.30000001192092896D;
         }
      } else {
         float var3 = 0.91F;
         if(this.field_70122_E) {
            var3 = 0.54600006F;
            int var4 = this.field_70170_p.func_72798_a(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70121_D.field_72338_b) - 1, MathHelper.func_76128_c(this.field_70161_v));
            if(var4 > 0) {
               var3 = Block.field_71973_m[var4].field_72016_cq * 0.91F;
            }
         }

         float var8 = 0.16277136F / (var3 * var3 * var3);
         float var5;
         if(this.field_70122_E) {
            if(this.func_70650_aV()) {
               var5 = this.func_70689_ay();
            } else {
               var5 = this.field_70746_aG;
            }

            var5 *= var8;
         } else {
            var5 = this.field_70747_aH;
         }

         this.func_70060_a(p_70612_1_, p_70612_2_, var5);
         var3 = 0.91F;
         if(this.field_70122_E) {
            var3 = 0.54600006F;
            int var6 = this.field_70170_p.func_72798_a(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70121_D.field_72338_b) - 1, MathHelper.func_76128_c(this.field_70161_v));
            if(var6 > 0) {
               var3 = Block.field_71973_m[var6].field_72016_cq * 0.91F;
            }
         }

         if(this.func_70617_f_()) {
            float var10 = 0.15F;
            if(this.field_70159_w < (double)(-var10)) {
               this.field_70159_w = (double)(-var10);
            }

            if(this.field_70159_w > (double)var10) {
               this.field_70159_w = (double)var10;
            }

            if(this.field_70179_y < (double)(-var10)) {
               this.field_70179_y = (double)(-var10);
            }

            if(this.field_70179_y > (double)var10) {
               this.field_70179_y = (double)var10;
            }

            this.field_70143_R = 0.0F;
            if(this.field_70181_x < -0.15D) {
               this.field_70181_x = -0.15D;
            }

            boolean var7 = this.func_70093_af() && this instanceof EntityPlayer;
            if(var7 && this.field_70181_x < 0.0D) {
               this.field_70181_x = 0.0D;
            }
         }

         this.func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
         if(this.field_70123_F && this.func_70617_f_()) {
            this.field_70181_x = 0.2D;
         }

         this.field_70181_x -= 0.08D;
         this.field_70181_x *= 0.9800000190734863D;
         this.field_70159_w *= (double)var3;
         this.field_70179_y *= (double)var3;
      }

      this.field_70722_aY = this.field_70721_aZ;
      var9 = this.field_70165_t - this.field_70169_q;
      double var12 = this.field_70161_v - this.field_70166_s;
      float var11 = MathHelper.func_76133_a(var9 * var9 + var12 * var12) * 4.0F;
      if(var11 > 1.0F) {
         var11 = 1.0F;
      }

      this.field_70721_aZ += (var11 - this.field_70721_aZ) * 0.4F;
      this.field_70754_ba += this.field_70721_aZ;
   }

   public boolean func_70617_f_() {
      int var1 = MathHelper.func_76128_c(this.field_70165_t);
      int var2 = MathHelper.func_76128_c(this.field_70121_D.field_72338_b);
      int var3 = MathHelper.func_76128_c(this.field_70161_v);
      int var4 = this.field_70170_p.func_72798_a(var1, var2, var3);
      return var4 == Block.field_72055_aF.field_71990_ca || var4 == Block.field_71998_bu.field_71990_ca;
   }

   public void func_70014_b(NBTTagCompound p_70014_1_) {
      p_70014_1_.func_74777_a("Health", (short)this.field_70734_aK);
      p_70014_1_.func_74777_a("HurtTime", (short)this.field_70737_aN);
      p_70014_1_.func_74777_a("DeathTime", (short)this.field_70725_aQ);
      p_70014_1_.func_74777_a("AttackTime", (short)this.field_70724_aR);
      if(!this.field_70713_bf.isEmpty()) {
         NBTTagList var2 = new NBTTagList();
         Iterator var3 = this.field_70713_bf.values().iterator();

         while(var3.hasNext()) {
            PotionEffect var4 = (PotionEffect)var3.next();
            NBTTagCompound var5 = new NBTTagCompound();
            var5.func_74774_a("Id", (byte)var4.func_76456_a());
            var5.func_74774_a("Amplifier", (byte)var4.func_76458_c());
            var5.func_74768_a("Duration", var4.func_76459_b());
            var2.func_74742_a(var5);
         }

         p_70014_1_.func_74782_a("ActiveEffects", var2);
      }

   }

   public void func_70037_a(NBTTagCompound p_70037_1_) {
      if(this.field_70734_aK < -32768) {
         this.field_70734_aK = -32768;
      }

      this.field_70734_aK = p_70037_1_.func_74765_d("Health");
      if(!p_70037_1_.func_74764_b("Health")) {
         this.field_70734_aK = this.func_70667_aM();
      }

      this.field_70737_aN = p_70037_1_.func_74765_d("HurtTime");
      this.field_70725_aQ = p_70037_1_.func_74765_d("DeathTime");
      this.field_70724_aR = p_70037_1_.func_74765_d("AttackTime");
      if(p_70037_1_.func_74764_b("ActiveEffects")) {
         NBTTagList var2 = p_70037_1_.func_74761_m("ActiveEffects");

         for(int var3 = 0; var3 < var2.func_74745_c(); ++var3) {
            NBTTagCompound var4 = (NBTTagCompound)var2.func_74743_b(var3);
            byte var5 = var4.func_74771_c("Id");
            byte var6 = var4.func_74771_c("Amplifier");
            int var7 = var4.func_74762_e("Duration");
            this.field_70713_bf.put(Integer.valueOf(var5), new PotionEffect(var5, var7, var6));
         }
      }

   }

   public boolean func_70089_S() {
      return !this.field_70128_L && this.field_70734_aK > 0;
   }

   public boolean func_70648_aU() {
      return false;
   }

   public void func_70657_f(float p_70657_1_) {
      this.field_70701_bs = p_70657_1_;
   }

   public void func_70637_d(boolean p_70637_1_) {
      this.field_70703_bu = p_70637_1_;
   }

   public void func_70636_d() {
      if(this.field_70773_bE > 0) {
         --this.field_70773_bE;
      }

      if(this.field_70716_bi > 0) {
         double var1 = this.field_70165_t + (this.field_70709_bj - this.field_70165_t) / (double)this.field_70716_bi;
         double var3 = this.field_70163_u + (this.field_70710_bk - this.field_70163_u) / (double)this.field_70716_bi;
         double var5 = this.field_70161_v + (this.field_70711_bl - this.field_70161_v) / (double)this.field_70716_bi;
         double var7 = MathHelper.func_76138_g(this.field_70712_bm - (double)this.field_70177_z);
         this.field_70177_z = (float)((double)this.field_70177_z + var7 / (double)this.field_70716_bi);
         this.field_70125_A = (float)((double)this.field_70125_A + (this.field_70705_bn - (double)this.field_70125_A) / (double)this.field_70716_bi);
         --this.field_70716_bi;
         this.func_70107_b(var1, var3, var5);
         this.func_70101_b(this.field_70177_z, this.field_70125_A);
      }

      if(Math.abs(this.field_70159_w) < 0.0050D) {
         this.field_70159_w = 0.0D;
      }

      if(Math.abs(this.field_70181_x) < 0.0050D) {
         this.field_70181_x = 0.0D;
      }

      if(Math.abs(this.field_70179_y) < 0.0050D) {
         this.field_70179_y = 0.0D;
      }

      this.field_70170_p.field_72984_F.func_76320_a("ai");
      if(this.func_70610_aX()) {
         this.field_70703_bu = false;
         this.field_70702_br = 0.0F;
         this.field_70701_bs = 0.0F;
         this.field_70704_bt = 0.0F;
      } else if(this.func_70613_aW()) {
         if(this.func_70650_aV()) {
            this.field_70170_p.field_72984_F.func_76320_a("newAi");
            this.func_70619_bc();
            this.field_70170_p.field_72984_F.func_76319_b();
         } else {
            this.field_70170_p.field_72984_F.func_76320_a("oldAi");
            this.func_70626_be();
            this.field_70170_p.field_72984_F.func_76319_b();
            this.field_70759_as = this.field_70177_z;
         }
      }

      this.field_70170_p.field_72984_F.func_76319_b();
      this.field_70170_p.field_72984_F.func_76320_a("jump");
      if(this.field_70703_bu) {
         if(!this.func_70090_H() && !this.func_70058_J()) {
            if(this.field_70122_E && this.field_70773_bE == 0) {
               this.func_70664_aZ();
               this.field_70773_bE = 10;
            }
         } else {
            this.field_70181_x += 0.03999999910593033D;
         }
      } else {
         this.field_70773_bE = 0;
      }

      this.field_70170_p.field_72984_F.func_76319_b();
      this.field_70170_p.field_72984_F.func_76320_a("travel");
      this.field_70702_br *= 0.98F;
      this.field_70701_bs *= 0.98F;
      this.field_70704_bt *= 0.9F;
      float var9 = this.field_70746_aG;
      this.field_70746_aG *= this.func_70616_bs();
      this.func_70612_e(this.field_70702_br, this.field_70701_bs);
      this.field_70746_aG = var9;
      this.field_70170_p.field_72984_F.func_76319_b();
      this.field_70170_p.field_72984_F.func_76320_a("push");
      if(!this.field_70170_p.field_72995_K) {
         List var2 = this.field_70170_p.func_72839_b(this, this.field_70121_D.func_72314_b(0.20000000298023224D, 0.0D, 0.20000000298023224D));
         if(var2 != null && !var2.isEmpty()) {
            Iterator var10 = var2.iterator();

            while(var10.hasNext()) {
               Entity var4 = (Entity)var10.next();
               if(var4.func_70104_M()) {
                  var4.func_70108_f(this);
               }
            }
         }
      }

      this.field_70170_p.field_72984_F.func_76319_b();
   }

   protected boolean func_70650_aV() {
      return false;
   }

   protected boolean func_70613_aW() {
      return !this.field_70170_p.field_72995_K;
   }

   protected boolean func_70610_aX() {
      return this.field_70734_aK <= 0;
   }

   public boolean func_70632_aY() {
      return false;
   }

   protected void func_70664_aZ() {
      this.field_70181_x = 0.41999998688697815D;
      if(this.func_70644_a(Potion.field_76430_j)) {
         this.field_70181_x += (double)((float)(this.func_70660_b(Potion.field_76430_j).func_76458_c() + 1) * 0.1F);
      }

      if(this.func_70051_ag()) {
         float var1 = this.field_70177_z * 0.017453292F;
         this.field_70159_w -= (double)(MathHelper.func_76126_a(var1) * 0.2F);
         this.field_70179_y += (double)(MathHelper.func_76134_b(var1) * 0.2F);
      }

      this.field_70160_al = true;
   }

   protected boolean func_70692_ba() {
      return true;
   }

   protected void func_70623_bb() {
      EntityPlayer var1 = this.field_70170_p.func_72890_a(this, -1.0D);
      if(var1 != null) {
         double var2 = var1.field_70165_t - this.field_70165_t;
         double var4 = var1.field_70163_u - this.field_70163_u;
         double var6 = var1.field_70161_v - this.field_70161_v;
         double var8 = var2 * var2 + var4 * var4 + var6 * var6;
         if(this.func_70692_ba() && var8 > 16384.0D) {
            this.func_70106_y();
         }

         if(this.field_70708_bq > 600 && this.field_70146_Z.nextInt(800) == 0 && var8 > 1024.0D && this.func_70692_ba()) {
            this.func_70106_y();
         } else if(var8 < 1024.0D) {
            this.field_70708_bq = 0;
         }
      }

   }

   protected void func_70619_bc() {
      ++this.field_70708_bq;
      this.field_70170_p.field_72984_F.func_76320_a("checkDespawn");
      this.func_70623_bb();
      this.field_70170_p.field_72984_F.func_76319_b();
      this.field_70170_p.field_72984_F.func_76320_a("sensing");
      this.field_70723_bA.func_75523_a();
      this.field_70170_p.field_72984_F.func_76319_b();
      this.field_70170_p.field_72984_F.func_76320_a("targetSelector");
      this.field_70715_bh.func_75774_a();
      this.field_70170_p.field_72984_F.func_76319_b();
      this.field_70170_p.field_72984_F.func_76320_a("goalSelector");
      this.field_70714_bg.func_75774_a();
      this.field_70170_p.field_72984_F.func_76319_b();
      this.field_70170_p.field_72984_F.func_76320_a("navigation");
      this.field_70699_by.func_75501_e();
      this.field_70170_p.field_72984_F.func_76319_b();
      this.field_70170_p.field_72984_F.func_76320_a("mob tick");
      this.func_70629_bd();
      this.field_70170_p.field_72984_F.func_76319_b();
      this.field_70170_p.field_72984_F.func_76320_a("controls");
      this.field_70170_p.field_72984_F.func_76320_a("move");
      this.field_70765_h.func_75641_c();
      this.field_70170_p.field_72984_F.func_76318_c("look");
      this.field_70749_g.func_75649_a();
      this.field_70170_p.field_72984_F.func_76318_c("jump");
      this.field_70767_i.func_75661_b();
      this.field_70170_p.field_72984_F.func_76319_b();
      this.field_70170_p.field_72984_F.func_76319_b();
   }

   protected void func_70629_bd() {}

   protected void func_70626_be() {
      ++this.field_70708_bq;
      this.func_70623_bb();
      this.field_70702_br = 0.0F;
      this.field_70701_bs = 0.0F;
      float var1 = 8.0F;
      if(this.field_70146_Z.nextFloat() < 0.02F) {
         EntityPlayer var2 = this.field_70170_p.func_72890_a(this, (double)var1);
         if(var2 != null) {
            this.field_70776_bF = var2;
            this.field_70700_bx = 10 + this.field_70146_Z.nextInt(20);
         } else {
            this.field_70704_bt = (this.field_70146_Z.nextFloat() - 0.5F) * 20.0F;
         }
      }

      if(this.field_70776_bF != null) {
         this.func_70625_a(this.field_70776_bF, 10.0F, (float)this.func_70646_bf());
         if(this.field_70700_bx-- <= 0 || this.field_70776_bF.field_70128_L || this.field_70776_bF.func_70068_e(this) > (double)(var1 * var1)) {
            this.field_70776_bF = null;
         }
      } else {
         if(this.field_70146_Z.nextFloat() < 0.05F) {
            this.field_70704_bt = (this.field_70146_Z.nextFloat() - 0.5F) * 20.0F;
         }

         this.field_70177_z += this.field_70704_bt;
         this.field_70125_A = this.field_70698_bv;
      }

      boolean var4 = this.func_70090_H();
      boolean var3 = this.func_70058_J();
      if(var4 || var3) {
         this.field_70703_bu = this.field_70146_Z.nextFloat() < 0.8F;
      }

   }

   public int func_70646_bf() {
      return 40;
   }

   public void func_70625_a(Entity p_70625_1_, float p_70625_2_, float p_70625_3_) {
      double var4 = p_70625_1_.field_70165_t - this.field_70165_t;
      double var8 = p_70625_1_.field_70161_v - this.field_70161_v;
      double var6;
      if(p_70625_1_ instanceof EntityLiving) {
         EntityLiving var10 = (EntityLiving)p_70625_1_;
         var6 = this.field_70163_u + (double)this.func_70047_e() - (var10.field_70163_u + (double)var10.func_70047_e());
      } else {
         var6 = (p_70625_1_.field_70121_D.field_72338_b + p_70625_1_.field_70121_D.field_72337_e) / 2.0D - (this.field_70163_u + (double)this.func_70047_e());
      }

      double var14 = (double)MathHelper.func_76133_a(var4 * var4 + var8 * var8);
      float var12 = (float)(Math.atan2(var8, var4) * 180.0D / 3.1415927410125732D) - 90.0F;
      float var13 = (float)(-(Math.atan2(var6, var14) * 180.0D / 3.1415927410125732D));
      this.field_70125_A = -this.func_70663_b(this.field_70125_A, var13, p_70625_3_);
      this.field_70177_z = this.func_70663_b(this.field_70177_z, var12, p_70625_2_);
   }

   private float func_70663_b(float p_70663_1_, float p_70663_2_, float p_70663_3_) {
      float var4 = MathHelper.func_76142_g(p_70663_2_ - p_70663_1_);
      if(var4 > p_70663_3_) {
         var4 = p_70663_3_;
      }

      if(var4 < -p_70663_3_) {
         var4 = -p_70663_3_;
      }

      return p_70663_1_ + var4;
   }

   public boolean func_70601_bi() {
      return this.field_70170_p.func_72855_b(this.field_70121_D) && this.field_70170_p.func_72945_a(this, this.field_70121_D).isEmpty() && !this.field_70170_p.func_72953_d(this.field_70121_D);
   }

   protected void func_70076_C() {
      this.func_70097_a(DamageSource.field_76380_i, 4);
   }

   public float func_70678_g(float p_70678_1_) {
      float var2 = this.field_70733_aJ - this.field_70732_aI;
      if(var2 < 0.0F) {
         ++var2;
      }

      return this.field_70732_aI + var2 * p_70678_1_;
   }

   public Vec3 func_70666_h(float p_70666_1_) {
      if(p_70666_1_ == 1.0F) {
         return Vec3.func_72437_a().func_72345_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
      } else {
         double var2 = this.field_70169_q + (this.field_70165_t - this.field_70169_q) * (double)p_70666_1_;
         double var4 = this.field_70167_r + (this.field_70163_u - this.field_70167_r) * (double)p_70666_1_;
         double var6 = this.field_70166_s + (this.field_70161_v - this.field_70166_s) * (double)p_70666_1_;
         return Vec3.func_72437_a().func_72345_a(var2, var4, var6);
      }
   }

   public Vec3 func_70040_Z() {
      return this.func_70676_i(1.0F);
   }

   public Vec3 func_70676_i(float p_70676_1_) {
      float var2;
      float var3;
      float var4;
      float var5;
      if(p_70676_1_ == 1.0F) {
         var2 = MathHelper.func_76134_b(-this.field_70177_z * 0.017453292F - 3.1415927F);
         var3 = MathHelper.func_76126_a(-this.field_70177_z * 0.017453292F - 3.1415927F);
         var4 = -MathHelper.func_76134_b(-this.field_70125_A * 0.017453292F);
         var5 = MathHelper.func_76126_a(-this.field_70125_A * 0.017453292F);
         return Vec3.func_72437_a().func_72345_a((double)(var3 * var4), (double)var5, (double)(var2 * var4));
      } else {
         var2 = this.field_70127_C + (this.field_70125_A - this.field_70127_C) * p_70676_1_;
         var3 = this.field_70126_B + (this.field_70177_z - this.field_70126_B) * p_70676_1_;
         var4 = MathHelper.func_76134_b(-var3 * 0.017453292F - 3.1415927F);
         var5 = MathHelper.func_76126_a(-var3 * 0.017453292F - 3.1415927F);
         float var6 = -MathHelper.func_76134_b(-var2 * 0.017453292F);
         float var7 = MathHelper.func_76126_a(-var2 * 0.017453292F);
         return Vec3.func_72437_a().func_72345_a((double)(var5 * var6), (double)var7, (double)(var4 * var6));
      }
   }

   public float func_70603_bj() {
      return 1.0F;
   }

   public MovingObjectPosition func_70614_a(double p_70614_1_, float p_70614_3_) {
      Vec3 var4 = this.func_70666_h(p_70614_3_);
      Vec3 var5 = this.func_70676_i(p_70614_3_);
      Vec3 var6 = var4.func_72441_c(var5.field_72450_a * p_70614_1_, var5.field_72448_b * p_70614_1_, var5.field_72449_c * p_70614_1_);
      return this.field_70170_p.func_72933_a(var4, var6);
   }

   public int func_70641_bl() {
      return 4;
   }

   public ItemStack func_70694_bm() {
      return null;
   }

   public void func_70103_a(byte p_70103_1_) {
      if(p_70103_1_ == 2) {
         this.field_70721_aZ = 1.5F;
         this.field_70172_ad = this.field_70771_an;
         this.field_70737_aN = this.field_70738_aO = 10;
         this.field_70739_aP = 0.0F;
         this.field_70170_p.func_72956_a(this, this.func_70621_aR(), this.func_70599_aP(), (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.2F + 1.0F);
         this.func_70097_a(DamageSource.field_76377_j, 0);
      } else if(p_70103_1_ == 3) {
         this.field_70170_p.func_72956_a(this, this.func_70673_aS(), this.func_70599_aP(), (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.2F + 1.0F);
         this.field_70734_aK = 0;
         this.func_70645_a(DamageSource.field_76377_j);
      } else {
         super.func_70103_a(p_70103_1_);
      }

   }

   public boolean func_70608_bn() {
      return false;
   }

   public int func_70620_b(ItemStack p_70620_1_, int p_70620_2_) {
      return p_70620_1_.func_77954_c();
   }

   protected void func_70679_bo() {
      Iterator var1 = this.field_70713_bf.keySet().iterator();

      while(var1.hasNext()) {
         Integer var2 = (Integer)var1.next();
         PotionEffect var3 = (PotionEffect)this.field_70713_bf.get(var2);
         if(!var3.func_76455_a(this) && !this.field_70170_p.field_72995_K) {
            var1.remove();
            this.func_70688_c(var3);
         }
      }

      int var9;
      if(this.field_70752_e) {
         if(!this.field_70170_p.field_72995_K) {
            if(this.field_70713_bf.isEmpty()) {
               this.field_70180_af.func_75692_b(8, Integer.valueOf(0));
            } else {
               var9 = PotionHelper.func_77911_a(this.field_70713_bf.values());
               this.field_70180_af.func_75692_b(8, Integer.valueOf(var9));
            }
         }

         this.field_70752_e = false;
      }

      if(this.field_70146_Z.nextBoolean()) {
         var9 = this.field_70180_af.func_75679_c(8);
         if(var9 > 0) {
            double var10 = (double)(var9 >> 16 & 255) / 255.0D;
            double var5 = (double)(var9 >> 8 & 255) / 255.0D;
            double var7 = (double)(var9 >> 0 & 255) / 255.0D;
            this.field_70170_p.func_72869_a("mobSpell", this.field_70165_t + (this.field_70146_Z.nextDouble() - 0.5D) * (double)this.field_70130_N, this.field_70163_u + this.field_70146_Z.nextDouble() * (double)this.field_70131_O - (double)this.field_70129_M, this.field_70161_v + (this.field_70146_Z.nextDouble() - 0.5D) * (double)this.field_70130_N, var10, var5, var7);
         }
      }

   }

   public void func_70674_bp() {
      Iterator var1 = this.field_70713_bf.keySet().iterator();

      while(var1.hasNext()) {
         Integer var2 = (Integer)var1.next();
         PotionEffect var3 = (PotionEffect)this.field_70713_bf.get(var2);
         if(!this.field_70170_p.field_72995_K) {
            var1.remove();
            this.func_70688_c(var3);
         }
      }

   }

   public Collection func_70651_bq() {
      return this.field_70713_bf.values();
   }

   public boolean func_70644_a(Potion p_70644_1_) {
      return this.field_70713_bf.containsKey(Integer.valueOf(p_70644_1_.field_76415_H));
   }

   public PotionEffect func_70660_b(Potion p_70660_1_) {
      return (PotionEffect)this.field_70713_bf.get(Integer.valueOf(p_70660_1_.field_76415_H));
   }

   public void func_70690_d(PotionEffect p_70690_1_) {
      if(this.func_70687_e(p_70690_1_)) {
         if(this.field_70713_bf.containsKey(Integer.valueOf(p_70690_1_.func_76456_a()))) {
            ((PotionEffect)this.field_70713_bf.get(Integer.valueOf(p_70690_1_.func_76456_a()))).func_76452_a(p_70690_1_);
            this.func_70695_b((PotionEffect)this.field_70713_bf.get(Integer.valueOf(p_70690_1_.func_76456_a())));
         } else {
            this.field_70713_bf.put(Integer.valueOf(p_70690_1_.func_76456_a()), p_70690_1_);
            this.func_70670_a(p_70690_1_);
         }

      }
   }

   public boolean func_70687_e(PotionEffect p_70687_1_) {
      if(this.func_70668_bt() == EnumCreatureAttribute.UNDEAD) {
         int var2 = p_70687_1_.func_76456_a();
         if(var2 == Potion.field_76428_l.field_76415_H || var2 == Potion.field_76436_u.field_76415_H) {
            return false;
         }
      }

      return true;
   }

   public boolean func_70662_br() {
      return this.func_70668_bt() == EnumCreatureAttribute.UNDEAD;
   }

   public void func_70618_n(int p_70618_1_) {
      this.field_70713_bf.remove(Integer.valueOf(p_70618_1_));
   }

   protected void func_70670_a(PotionEffect p_70670_1_) {
      this.field_70752_e = true;
   }

   protected void func_70695_b(PotionEffect p_70695_1_) {
      this.field_70752_e = true;
   }

   protected void func_70688_c(PotionEffect p_70688_1_) {
      this.field_70752_e = true;
   }

   protected float func_70616_bs() {
      float var1 = 1.0F;
      if(this.func_70644_a(Potion.field_76424_c)) {
         var1 *= 1.0F + 0.2F * (float)(this.func_70660_b(Potion.field_76424_c).func_76458_c() + 1);
      }

      if(this.func_70644_a(Potion.field_76421_d)) {
         var1 *= 1.0F - 0.15F * (float)(this.func_70660_b(Potion.field_76421_d).func_76458_c() + 1);
      }

      return var1;
   }

   public void func_70634_a(double p_70634_1_, double p_70634_3_, double p_70634_5_) {
      this.func_70012_b(p_70634_1_, p_70634_3_, p_70634_5_, this.field_70177_z, this.field_70125_A);
   }

   public boolean func_70631_g_() {
      return false;
   }

   public EnumCreatureAttribute func_70668_bt() {
      return EnumCreatureAttribute.UNDEFINED;
   }

   public void func_70669_a(ItemStack p_70669_1_) {
      this.field_70170_p.func_72956_a(this, "random.break", 0.8F, 0.8F + this.field_70170_p.field_73012_v.nextFloat() * 0.4F);

      for(int var2 = 0; var2 < 5; ++var2) {
         Vec3 var3 = Vec3.func_72437_a().func_72345_a(((double)this.field_70146_Z.nextFloat() - 0.5D) * 0.1D, Math.random() * 0.1D + 0.1D, 0.0D);
         var3.func_72440_a(-this.field_70125_A * 3.1415927F / 180.0F);
         var3.func_72442_b(-this.field_70177_z * 3.1415927F / 180.0F);
         Vec3 var4 = Vec3.func_72437_a().func_72345_a(((double)this.field_70146_Z.nextFloat() - 0.5D) * 0.3D, (double)(-this.field_70146_Z.nextFloat()) * 0.6D - 0.3D, 0.6D);
         var4.func_72440_a(-this.field_70125_A * 3.1415927F / 180.0F);
         var4.func_72442_b(-this.field_70177_z * 3.1415927F / 180.0F);
         var4 = var4.func_72441_c(this.field_70165_t, this.field_70163_u + (double)this.func_70047_e(), this.field_70161_v);
         this.field_70170_p.func_72869_a("iconcrack_" + p_70669_1_.func_77973_b().field_77779_bT, var4.field_72450_a, var4.field_72448_b, var4.field_72449_c, var3.field_72450_a, var3.field_72448_b + 0.05D, var3.field_72449_c);
      }

   }
}
