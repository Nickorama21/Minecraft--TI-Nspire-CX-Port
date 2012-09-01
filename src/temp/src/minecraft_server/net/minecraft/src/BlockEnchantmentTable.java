package net.minecraft.src;

import net.minecraft.src.BlockContainer;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Material;
import net.minecraft.src.TileEntity;
import net.minecraft.src.TileEntityEnchantmentTable;
import net.minecraft.src.World;

public class BlockEnchantmentTable extends BlockContainer {

   protected BlockEnchantmentTable(int p_i3941_1_) {
      super(p_i3941_1_, 166, Material.field_76246_e);
      this.func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 0.75F, 1.0F);
      this.func_71868_h(0);
      this.func_71849_a(CreativeTabs.field_78031_c);
   }

   public boolean func_71886_c() {
      return false;
   }

   public boolean func_71926_d() {
      return false;
   }

   public int func_71858_a(int p_71858_1_, int p_71858_2_) {
      return this.func_71851_a(p_71858_1_);
   }

   public int func_71851_a(int p_71851_1_) {
      return p_71851_1_ == 0?this.field_72059_bZ + 17:(p_71851_1_ == 1?this.field_72059_bZ:this.field_72059_bZ + 16);
   }

   public TileEntity func_72274_a(World p_72274_1_) {
      return new TileEntityEnchantmentTable();
   }

   public boolean func_71903_a(World p_71903_1_, int p_71903_2_, int p_71903_3_, int p_71903_4_, EntityPlayer p_71903_5_, int p_71903_6_, float p_71903_7_, float p_71903_8_, float p_71903_9_) {
      if(p_71903_1_.field_72995_K) {
         return true;
      } else {
         p_71903_5_.func_71002_c(p_71903_2_, p_71903_3_, p_71903_4_);
         return true;
      }
   }
}
