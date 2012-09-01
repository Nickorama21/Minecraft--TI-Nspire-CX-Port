package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Material;
import net.minecraft.src.World;

public class BlockLadder extends Block {

   protected BlockLadder(int p_i3960_1_, int p_i3960_2_) {
      super(p_i3960_1_, p_i3960_2_, Material.field_76265_p);
      this.func_71849_a(CreativeTabs.field_78031_c);
   }

   public AxisAlignedBB func_71872_e(World p_71872_1_, int p_71872_2_, int p_71872_3_, int p_71872_4_) {
      int var5 = p_71872_1_.func_72805_g(p_71872_2_, p_71872_3_, p_71872_4_);
      float var6 = 0.125F;
      if(var5 == 2) {
         this.func_71905_a(0.0F, 0.0F, 1.0F - var6, 1.0F, 1.0F, 1.0F);
      }

      if(var5 == 3) {
         this.func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, var6);
      }

      if(var5 == 4) {
         this.func_71905_a(1.0F - var6, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
      }

      if(var5 == 5) {
         this.func_71905_a(0.0F, 0.0F, 0.0F, var6, 1.0F, 1.0F);
      }

      return super.func_71872_e(p_71872_1_, p_71872_2_, p_71872_3_, p_71872_4_);
   }

   public boolean func_71926_d() {
      return false;
   }

   public boolean func_71886_c() {
      return false;
   }

   public int func_71857_b() {
      return 8;
   }

   public boolean func_71930_b(World p_71930_1_, int p_71930_2_, int p_71930_3_, int p_71930_4_) {
      return p_71930_1_.func_72809_s(p_71930_2_ - 1, p_71930_3_, p_71930_4_)?true:(p_71930_1_.func_72809_s(p_71930_2_ + 1, p_71930_3_, p_71930_4_)?true:(p_71930_1_.func_72809_s(p_71930_2_, p_71930_3_, p_71930_4_ - 1)?true:p_71930_1_.func_72809_s(p_71930_2_, p_71930_3_, p_71930_4_ + 1)));
   }

   public void func_71909_a(World p_71909_1_, int p_71909_2_, int p_71909_3_, int p_71909_4_, int p_71909_5_, float p_71909_6_, float p_71909_7_, float p_71909_8_) {
      int var9 = p_71909_1_.func_72805_g(p_71909_2_, p_71909_3_, p_71909_4_);
      if((var9 == 0 || p_71909_5_ == 2) && p_71909_1_.func_72809_s(p_71909_2_, p_71909_3_, p_71909_4_ + 1)) {
         var9 = 2;
      }

      if((var9 == 0 || p_71909_5_ == 3) && p_71909_1_.func_72809_s(p_71909_2_, p_71909_3_, p_71909_4_ - 1)) {
         var9 = 3;
      }

      if((var9 == 0 || p_71909_5_ == 4) && p_71909_1_.func_72809_s(p_71909_2_ + 1, p_71909_3_, p_71909_4_)) {
         var9 = 4;
      }

      if((var9 == 0 || p_71909_5_ == 5) && p_71909_1_.func_72809_s(p_71909_2_ - 1, p_71909_3_, p_71909_4_)) {
         var9 = 5;
      }

      p_71909_1_.func_72921_c(p_71909_2_, p_71909_3_, p_71909_4_, var9);
   }

   public void func_71863_a(World p_71863_1_, int p_71863_2_, int p_71863_3_, int p_71863_4_, int p_71863_5_) {
      int var6 = p_71863_1_.func_72805_g(p_71863_2_, p_71863_3_, p_71863_4_);
      boolean var7 = false;
      if(var6 == 2 && p_71863_1_.func_72809_s(p_71863_2_, p_71863_3_, p_71863_4_ + 1)) {
         var7 = true;
      }

      if(var6 == 3 && p_71863_1_.func_72809_s(p_71863_2_, p_71863_3_, p_71863_4_ - 1)) {
         var7 = true;
      }

      if(var6 == 4 && p_71863_1_.func_72809_s(p_71863_2_ + 1, p_71863_3_, p_71863_4_)) {
         var7 = true;
      }

      if(var6 == 5 && p_71863_1_.func_72809_s(p_71863_2_ - 1, p_71863_3_, p_71863_4_)) {
         var7 = true;
      }

      if(!var7) {
         this.func_71897_c(p_71863_1_, p_71863_2_, p_71863_3_, p_71863_4_, var6, 0);
         p_71863_1_.func_72859_e(p_71863_2_, p_71863_3_, p_71863_4_, 0);
      }

      super.func_71863_a(p_71863_1_, p_71863_2_, p_71863_3_, p_71863_4_, p_71863_5_);
   }

   public int func_71925_a(Random p_71925_1_) {
      return 1;
   }
}
