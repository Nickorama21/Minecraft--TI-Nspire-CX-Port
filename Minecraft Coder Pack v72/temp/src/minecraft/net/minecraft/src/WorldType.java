package net.minecraft.src;


public class WorldType {

   public static final WorldType[] field_77139_a = new WorldType[16];
   public static final WorldType field_77137_b = (new WorldType(0, "default", 1)).func_77129_f();
   public static final WorldType field_77138_c = new WorldType(1, "flat");
   public static final WorldType field_77135_d = new WorldType(2, "largeBiomes");
   public static final WorldType field_77136_e = (new WorldType(8, "default_1_1", 0)).func_77124_a(false);
   private final String field_77133_f;
   private final int field_77134_g;
   private boolean field_77140_h;
   private boolean field_77141_i;


   private WorldType(int p_i3737_1_, String p_i3737_2_) {
      this(p_i3737_1_, p_i3737_2_, 0);
   }

   private WorldType(int p_i3738_1_, String p_i3738_2_, int p_i3738_3_) {
      this.field_77133_f = p_i3738_2_;
      this.field_77134_g = p_i3738_3_;
      this.field_77140_h = true;
      field_77139_a[p_i3738_1_] = this;
   }

   public String func_77127_a() {
      return this.field_77133_f;
   }

   public String func_77128_b() {
      return "generator." + this.field_77133_f;
   }

   public int func_77131_c() {
      return this.field_77134_g;
   }

   public WorldType func_77132_a(int p_77132_1_) {
      return this == field_77137_b && p_77132_1_ == 0?field_77136_e:this;
   }

   private WorldType func_77124_a(boolean p_77124_1_) {
      this.field_77140_h = p_77124_1_;
      return this;
   }

   public boolean func_77126_d() {
      return this.field_77140_h;
   }

   private WorldType func_77129_f() {
      this.field_77141_i = true;
      return this;
   }

   public boolean func_77125_e() {
      return this.field_77141_i;
   }

   public static WorldType func_77130_a(String p_77130_0_) {
      WorldType[] var1 = field_77139_a;
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         WorldType var4 = var1[var3];
         if(var4 != null && var4.field_77133_f.equalsIgnoreCase(p_77130_0_)) {
            return var4;
         }
      }

      return null;
   }

}
