package net.minecraft.src;

import net.minecraft.src.EnumGameType;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.WorldSettings;
import net.minecraft.src.WorldType;

public class WorldInfo {

   private long field_76100_a;
   private WorldType field_76098_b;
   private int field_76099_c;
   private int field_76096_d;
   private int field_76097_e;
   private long field_76094_f;
   private long field_76095_g;
   private long field_76107_h;
   private NBTTagCompound field_76108_i;
   private int field_76105_j;
   private String field_76106_k;
   private int field_76103_l;
   private boolean field_76104_m;
   private int field_76101_n;
   private boolean field_76102_o;
   private int field_76114_p;
   private EnumGameType field_76113_q;
   private boolean field_76112_r;
   private boolean field_76111_s;
   private boolean field_76110_t;
   private boolean field_76109_u;


   protected WorldInfo() {
      this.field_76098_b = WorldType.field_77137_b;
   }

   public WorldInfo(NBTTagCompound p_i3914_1_) {
      this.field_76098_b = WorldType.field_77137_b;
      this.field_76100_a = p_i3914_1_.func_74763_f("RandomSeed");
      if(p_i3914_1_.func_74764_b("generatorName")) {
         String var2 = p_i3914_1_.func_74779_i("generatorName");
         this.field_76098_b = WorldType.func_77130_a(var2);
         if(this.field_76098_b == null) {
            this.field_76098_b = WorldType.field_77137_b;
         } else if(this.field_76098_b.func_77125_e()) {
            int var3 = 0;
            if(p_i3914_1_.func_74764_b("generatorVersion")) {
               var3 = p_i3914_1_.func_74762_e("generatorVersion");
            }

            this.field_76098_b = this.field_76098_b.func_77132_a(var3);
         }
      }

      this.field_76113_q = EnumGameType.func_77146_a(p_i3914_1_.func_74762_e("GameType"));
      if(p_i3914_1_.func_74764_b("MapFeatures")) {
         this.field_76112_r = p_i3914_1_.func_74767_n("MapFeatures");
      } else {
         this.field_76112_r = true;
      }

      this.field_76099_c = p_i3914_1_.func_74762_e("SpawnX");
      this.field_76096_d = p_i3914_1_.func_74762_e("SpawnY");
      this.field_76097_e = p_i3914_1_.func_74762_e("SpawnZ");
      this.field_76094_f = p_i3914_1_.func_74763_f("Time");
      this.field_76095_g = p_i3914_1_.func_74763_f("LastPlayed");
      this.field_76107_h = p_i3914_1_.func_74763_f("SizeOnDisk");
      this.field_76106_k = p_i3914_1_.func_74779_i("LevelName");
      this.field_76103_l = p_i3914_1_.func_74762_e("version");
      this.field_76101_n = p_i3914_1_.func_74762_e("rainTime");
      this.field_76104_m = p_i3914_1_.func_74767_n("raining");
      this.field_76114_p = p_i3914_1_.func_74762_e("thunderTime");
      this.field_76102_o = p_i3914_1_.func_74767_n("thundering");
      this.field_76111_s = p_i3914_1_.func_74767_n("hardcore");
      if(p_i3914_1_.func_74764_b("initialized")) {
         this.field_76109_u = p_i3914_1_.func_74767_n("initialized");
      } else {
         this.field_76109_u = true;
      }

      if(p_i3914_1_.func_74764_b("allowCommands")) {
         this.field_76110_t = p_i3914_1_.func_74767_n("allowCommands");
      } else {
         this.field_76110_t = this.field_76113_q == EnumGameType.CREATIVE;
      }

      if(p_i3914_1_.func_74764_b("Player")) {
         this.field_76108_i = p_i3914_1_.func_74775_l("Player");
         this.field_76105_j = this.field_76108_i.func_74762_e("Dimension");
      }

   }

   public WorldInfo(WorldSettings p_i3915_1_, String p_i3915_2_) {
      this.field_76098_b = WorldType.field_77137_b;
      this.field_76100_a = p_i3915_1_.func_77160_d();
      this.field_76113_q = p_i3915_1_.func_77162_e();
      this.field_76112_r = p_i3915_1_.func_77164_g();
      this.field_76106_k = p_i3915_2_;
      this.field_76111_s = p_i3915_1_.func_77158_f();
      this.field_76098_b = p_i3915_1_.func_77165_h();
      this.field_76110_t = p_i3915_1_.func_77163_i();
      this.field_76109_u = false;
   }

   public WorldInfo(WorldInfo p_i3916_1_) {
      this.field_76098_b = WorldType.field_77137_b;
      this.field_76100_a = p_i3916_1_.field_76100_a;
      this.field_76098_b = p_i3916_1_.field_76098_b;
      this.field_76113_q = p_i3916_1_.field_76113_q;
      this.field_76112_r = p_i3916_1_.field_76112_r;
      this.field_76099_c = p_i3916_1_.field_76099_c;
      this.field_76096_d = p_i3916_1_.field_76096_d;
      this.field_76097_e = p_i3916_1_.field_76097_e;
      this.field_76094_f = p_i3916_1_.field_76094_f;
      this.field_76095_g = p_i3916_1_.field_76095_g;
      this.field_76107_h = p_i3916_1_.field_76107_h;
      this.field_76108_i = p_i3916_1_.field_76108_i;
      this.field_76105_j = p_i3916_1_.field_76105_j;
      this.field_76106_k = p_i3916_1_.field_76106_k;
      this.field_76103_l = p_i3916_1_.field_76103_l;
      this.field_76101_n = p_i3916_1_.field_76101_n;
      this.field_76104_m = p_i3916_1_.field_76104_m;
      this.field_76114_p = p_i3916_1_.field_76114_p;
      this.field_76102_o = p_i3916_1_.field_76102_o;
      this.field_76111_s = p_i3916_1_.field_76111_s;
      this.field_76110_t = p_i3916_1_.field_76110_t;
      this.field_76109_u = p_i3916_1_.field_76109_u;
   }

   public NBTTagCompound func_76066_a() {
      NBTTagCompound var1 = new NBTTagCompound();
      this.func_76064_a(var1, this.field_76108_i);
      return var1;
   }

   public NBTTagCompound func_76082_a(NBTTagCompound p_76082_1_) {
      NBTTagCompound var2 = new NBTTagCompound();
      this.func_76064_a(var2, p_76082_1_);
      return var2;
   }

   private void func_76064_a(NBTTagCompound p_76064_1_, NBTTagCompound p_76064_2_) {
      p_76064_1_.func_74772_a("RandomSeed", this.field_76100_a);
      p_76064_1_.func_74778_a("generatorName", this.field_76098_b.func_77127_a());
      p_76064_1_.func_74768_a("generatorVersion", this.field_76098_b.func_77131_c());
      p_76064_1_.func_74768_a("GameType", this.field_76113_q.func_77148_a());
      p_76064_1_.func_74757_a("MapFeatures", this.field_76112_r);
      p_76064_1_.func_74768_a("SpawnX", this.field_76099_c);
      p_76064_1_.func_74768_a("SpawnY", this.field_76096_d);
      p_76064_1_.func_74768_a("SpawnZ", this.field_76097_e);
      p_76064_1_.func_74772_a("Time", this.field_76094_f);
      p_76064_1_.func_74772_a("SizeOnDisk", this.field_76107_h);
      p_76064_1_.func_74772_a("LastPlayed", System.currentTimeMillis());
      p_76064_1_.func_74778_a("LevelName", this.field_76106_k);
      p_76064_1_.func_74768_a("version", this.field_76103_l);
      p_76064_1_.func_74768_a("rainTime", this.field_76101_n);
      p_76064_1_.func_74757_a("raining", this.field_76104_m);
      p_76064_1_.func_74768_a("thunderTime", this.field_76114_p);
      p_76064_1_.func_74757_a("thundering", this.field_76102_o);
      p_76064_1_.func_74757_a("hardcore", this.field_76111_s);
      p_76064_1_.func_74757_a("allowCommands", this.field_76110_t);
      p_76064_1_.func_74757_a("initialized", this.field_76109_u);
      if(p_76064_2_ != null) {
         p_76064_1_.func_74766_a("Player", p_76064_2_);
      }

   }

   public long func_76063_b() {
      return this.field_76100_a;
   }

   public int func_76079_c() {
      return this.field_76099_c;
   }

   public int func_76075_d() {
      return this.field_76096_d;
   }

   public int func_76074_e() {
      return this.field_76097_e;
   }

   public long func_76073_f() {
      return this.field_76094_f;
   }

   public long func_76092_g() {
      return this.field_76107_h;
   }

   public NBTTagCompound func_76072_h() {
      return this.field_76108_i;
   }

   public int func_76076_i() {
      return this.field_76105_j;
   }

   public void func_76058_a(int p_76058_1_) {
      this.field_76099_c = p_76058_1_;
   }

   public void func_76056_b(int p_76056_1_) {
      this.field_76096_d = p_76056_1_;
   }

   public void func_76087_c(int p_76087_1_) {
      this.field_76097_e = p_76087_1_;
   }

   public void func_76068_b(long p_76068_1_) {
      this.field_76094_f = p_76068_1_;
   }

   public void func_76081_a(int p_76081_1_, int p_76081_2_, int p_76081_3_) {
      this.field_76099_c = p_76081_1_;
      this.field_76096_d = p_76081_2_;
      this.field_76097_e = p_76081_3_;
   }

   public String func_76065_j() {
      return this.field_76106_k;
   }

   public void func_76062_a(String p_76062_1_) {
      this.field_76106_k = p_76062_1_;
   }

   public int func_76088_k() {
      return this.field_76103_l;
   }

   public void func_76078_e(int p_76078_1_) {
      this.field_76103_l = p_76078_1_;
   }

   public long func_76057_l() {
      return this.field_76095_g;
   }

   public boolean func_76061_m() {
      return this.field_76102_o;
   }

   public void func_76069_a(boolean p_76069_1_) {
      this.field_76102_o = p_76069_1_;
   }

   public int func_76071_n() {
      return this.field_76114_p;
   }

   public void func_76090_f(int p_76090_1_) {
      this.field_76114_p = p_76090_1_;
   }

   public boolean func_76059_o() {
      return this.field_76104_m;
   }

   public void func_76084_b(boolean p_76084_1_) {
      this.field_76104_m = p_76084_1_;
   }

   public int func_76083_p() {
      return this.field_76101_n;
   }

   public void func_76080_g(int p_76080_1_) {
      this.field_76101_n = p_76080_1_;
   }

   public EnumGameType func_76077_q() {
      return this.field_76113_q;
   }

   public boolean func_76089_r() {
      return this.field_76112_r;
   }

   public void func_76060_a(EnumGameType p_76060_1_) {
      this.field_76113_q = p_76060_1_;
   }

   public boolean func_76093_s() {
      return this.field_76111_s;
   }

   public WorldType func_76067_t() {
      return this.field_76098_b;
   }

   public void func_76085_a(WorldType p_76085_1_) {
      this.field_76098_b = p_76085_1_;
   }

   public boolean func_76086_u() {
      return this.field_76110_t;
   }

   public boolean func_76070_v() {
      return this.field_76109_u;
   }

   public void func_76091_d(boolean p_76091_1_) {
      this.field_76109_u = p_76091_1_;
   }
}
