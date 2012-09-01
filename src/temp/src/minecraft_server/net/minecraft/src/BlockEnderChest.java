package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.BlockContainer;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.InventoryEnderChest;
import net.minecraft.src.Material;
import net.minecraft.src.MathHelper;
import net.minecraft.src.TileEntity;
import net.minecraft.src.TileEntityEnderChest;
import net.minecraft.src.World;

public class BlockEnderChest extends BlockContainer {

   protected BlockEnderChest(int p_i3942_1_) {
      super(p_i3942_1_, Material.field_76246_e);
      this.field_72059_bZ = 37;
      this.func_71849_a(CreativeTabs.field_78031_c);
   }

   public boolean func_71926_d() {
      return false;
   }

   public boolean func_71886_c() {
      return false;
   }

   public int func_71857_b() {
      return 22;
   }

   public int func_71885_a(int p_71885_1_, Random p_71885_2_, int p_71885_3_) {
      return Block.field_72089_ap.field_71990_ca;
   }

   public int func_71925_a(Random p_71925_1_) {
      return 8;
   }

   protected boolean func_71906_q_() {
      return true;
   }

   public void func_71860_a(World p_71860_1_, int p_71860_2_, int p_71860_3_, int p_71860_4_, EntityLiving p_71860_5_) {
      byte var6 = 0;
      int var7 = MathHelper.func_76128_c((double)(p_71860_5_.field_70177_z * 4.0F / 360.0F) + 0.5D) & 3;
      if(var7 == 0) {
         var6 = 2;
      }

      if(var7 == 1) {
         var6 = 5;
      }

      if(var7 == 2) {
         var6 = 3;
      }

      if(var7 == 3) {
         var6 = 4;
      }

      p_71860_1_.func_72921_c(p_71860_2_, p_71860_3_, p_71860_4_, var6);
   }

   public boolean func_71903_a(World p_71903_1_, int p_71903_2_, int p_71903_3_, int p_71903_4_, EntityPlayer p_71903_5_, int p_71903_6_, float p_71903_7_, float p_71903_8_, float p_71903_9_) {
      InventoryEnderChest var10 = p_71903_5_.func_71005_bN();
      TileEntityEnderChest var11 = (TileEntityEnderChest)p_71903_1_.func_72796_p(p_71903_2_, p_71903_3_, p_71903_4_);
      if(var10 != null && var11 != null) {
         if(p_71903_1_.func_72809_s(p_71903_2_, p_71903_3_ + 1, p_71903_4_)) {
            return true;
         } else if(p_71903_1_.field_72995_K) {
            return true;
         } else {
            var10.func_70485_a(var11);
            p_71903_5_.func_71007_a(var10);
            return true;
         }
      } else {
         return true;
      }
   }

   public TileEntity func_72274_a(World p_72274_1_) {
      return new TileEntityEnderChest();
   }
}
