package net.minecraft.src;

import net.minecraft.src.EnumGameType;
import net.minecraft.src.WorldInfo;
import net.minecraft.src.WorldType;

public final class WorldSettings {

   private final long field_77174_a;
   private final EnumGameType field_77172_b;
   private final boolean field_77173_c;
   private final boolean field_77170_d;
   private final WorldType field_77171_e;
   private boolean field_77168_f;
   private boolean field_77169_g;


   public WorldSettings(long p_i3735_1_, EnumGameType p_i3735_3_, boolean p_i3735_4_, boolean p_i3735_5_, WorldType p_i3735_6_) {
      this.field_77174_a = p_i3735_1_;
      this.field_77172_b = p_i3735_3_;
      this.field_77173_c = p_i3735_4_;
      this.field_77170_d = p_i3735_5_;
      this.field_77171_e = p_i3735_6_;
   }

   public WorldSettings(WorldInfo p_i3736_1_) {
      this(p_i3736_1_.func_76063_b(), p_i3736_1_.func_76077_q(), p_i3736_1_.func_76089_r(), p_i3736_1_.func_76093_s(), p_i3736_1_.func_76067_t());
   }

   public WorldSettings func_77159_a() {
      this.field_77169_g = true;
      return this;
   }

   public boolean func_77167_c() {
      return this.field_77169_g;
   }

   public long func_77160_d() {
      return this.field_77174_a;
   }

   public EnumGameType func_77162_e() {
      return this.field_77172_b;
   }

   public boolean func_77158_f() {
      return this.field_77170_d;
   }

   public boolean func_77164_g() {
      return this.field_77173_c;
   }

   public WorldType func_77165_h() {
      return this.field_77171_e;
   }

   public boolean func_77163_i() {
      return this.field_77168_f;
   }

   public static EnumGameType func_77161_a(int p_77161_0_) {
      return EnumGameType.func_77146_a(p_77161_0_);
   }
}
