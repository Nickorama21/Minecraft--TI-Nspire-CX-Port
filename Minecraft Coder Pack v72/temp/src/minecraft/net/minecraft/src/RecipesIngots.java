package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.CraftingManager;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;

public class RecipesIngots {

   private Object[][] field_77591_a;


   public RecipesIngots() {
      this.field_77591_a = new Object[][]{{Block.field_72105_ah, new ItemStack(Item.field_77717_p, 9)}, {Block.field_72083_ai, new ItemStack(Item.field_77703_o, 9)}, {Block.field_72071_ax, new ItemStack(Item.field_77702_n, 9)}, {Block.field_72076_bV, new ItemStack(Item.field_77817_bH, 9)}, {Block.field_71948_O, new ItemStack(Item.field_77756_aW, 9, 4)}};
   }

   public void func_77590_a(CraftingManager p_77590_1_) {
      Object[][] var2 = this.field_77591_a;
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         Object[] var5 = var2[var4];
         Block var6 = (Block)var5[0];
         ItemStack var7 = (ItemStack)var5[1];
         p_77590_1_.func_77595_a(new ItemStack(var6), new Object[]{"###", "###", "###", Character.valueOf('#'), var7});
         p_77590_1_.func_77595_a(var7, new Object[]{"#", Character.valueOf('#'), var6});
      }

      p_77590_1_.func_77595_a(new ItemStack(Item.field_77717_p), new Object[]{"###", "###", "###", Character.valueOf('#'), Item.field_77733_bq});
      p_77590_1_.func_77595_a(new ItemStack(Item.field_77733_bq, 9), new Object[]{"#", Character.valueOf('#'), Item.field_77717_p});
   }
}
