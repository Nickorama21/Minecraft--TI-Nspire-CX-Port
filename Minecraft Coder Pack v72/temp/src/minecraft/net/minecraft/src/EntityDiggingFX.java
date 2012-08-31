package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.EntityFX;
import net.minecraft.src.Tessellator;
import net.minecraft.src.World;

public class EntityDiggingFX extends EntityFX {

   private Block field_70597_a;


   public EntityDiggingFX(World p_i3185_1_, double p_i3185_2_, double p_i3185_4_, double p_i3185_6_, double p_i3185_8_, double p_i3185_10_, double p_i3185_12_, Block p_i3185_14_, int p_i3185_15_, int p_i3185_16_) {
      super(p_i3185_1_, p_i3185_2_, p_i3185_4_, p_i3185_6_, p_i3185_8_, p_i3185_10_, p_i3185_12_);
      this.field_70597_a = p_i3185_14_;
      this.func_70536_a(p_i3185_14_.func_71858_a(0, p_i3185_16_));
      this.field_70545_g = p_i3185_14_.field_72017_co;
      this.field_70552_h = this.field_70553_i = this.field_70551_j = 0.6F;
      this.field_70544_f /= 2.0F;
   }

   public EntityDiggingFX func_70596_a(int p_70596_1_, int p_70596_2_, int p_70596_3_) {
      if(this.field_70597_a == Block.field_71980_u) {
         return this;
      } else {
         int var4 = this.field_70597_a.func_71920_b(this.field_70170_p, p_70596_1_, p_70596_2_, p_70596_3_);
         this.field_70552_h *= (float)(var4 >> 16 & 255) / 255.0F;
         this.field_70553_i *= (float)(var4 >> 8 & 255) / 255.0F;
         this.field_70551_j *= (float)(var4 & 255) / 255.0F;
         return this;
      }
   }

   public int func_70537_b() {
      return 1;
   }

   public void func_70539_a(Tessellator p_70539_1_, float p_70539_2_, float p_70539_3_, float p_70539_4_, float p_70539_5_, float p_70539_6_, float p_70539_7_) {
      float var8 = ((float)(this.func_70540_h() % 16) + this.field_70548_b / 4.0F) / 16.0F;
      float var9 = var8 + 0.015609375F;
      float var10 = ((float)(this.func_70540_h() / 16) + this.field_70549_c / 4.0F) / 16.0F;
      float var11 = var10 + 0.015609375F;
      float var12 = 0.1F * this.field_70544_f;
      float var13 = (float)(this.field_70169_q + (this.field_70165_t - this.field_70169_q) * (double)p_70539_2_ - field_70556_an);
      float var14 = (float)(this.field_70167_r + (this.field_70163_u - this.field_70167_r) * (double)p_70539_2_ - field_70554_ao);
      float var15 = (float)(this.field_70166_s + (this.field_70161_v - this.field_70166_s) * (double)p_70539_2_ - field_70555_ap);
      float var16 = 1.0F;
      p_70539_1_.func_78386_a(var16 * this.field_70552_h, var16 * this.field_70553_i, var16 * this.field_70551_j);
      p_70539_1_.func_78374_a((double)(var13 - p_70539_3_ * var12 - p_70539_6_ * var12), (double)(var14 - p_70539_4_ * var12), (double)(var15 - p_70539_5_ * var12 - p_70539_7_ * var12), (double)var8, (double)var11);
      p_70539_1_.func_78374_a((double)(var13 - p_70539_3_ * var12 + p_70539_6_ * var12), (double)(var14 + p_70539_4_ * var12), (double)(var15 - p_70539_5_ * var12 + p_70539_7_ * var12), (double)var8, (double)var10);
      p_70539_1_.func_78374_a((double)(var13 + p_70539_3_ * var12 + p_70539_6_ * var12), (double)(var14 + p_70539_4_ * var12), (double)(var15 + p_70539_5_ * var12 + p_70539_7_ * var12), (double)var9, (double)var10);
      p_70539_1_.func_78374_a((double)(var13 + p_70539_3_ * var12 - p_70539_6_ * var12), (double)(var14 - p_70539_4_ * var12), (double)(var15 + p_70539_5_ * var12 - p_70539_7_ * var12), (double)var9, (double)var11);
   }
}
