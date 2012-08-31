package net.minecraft.src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import net.minecraft.src.Block;
import net.minecraft.src.IRecipe;
import net.minecraft.src.InventoryCrafting;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.RecipeSorter;
import net.minecraft.src.RecipesArmor;
import net.minecraft.src.RecipesCrafting;
import net.minecraft.src.RecipesDyes;
import net.minecraft.src.RecipesFood;
import net.minecraft.src.RecipesIngots;
import net.minecraft.src.RecipesTools;
import net.minecraft.src.RecipesWeapons;
import net.minecraft.src.ShapedRecipes;
import net.minecraft.src.ShapelessRecipes;

public class CraftingManager {

   private static final CraftingManager field_77598_a = new CraftingManager();
   private List field_77597_b = new ArrayList();


   public static final CraftingManager func_77594_a() {
      return field_77598_a;
   }

   private CraftingManager() {
      (new RecipesTools()).func_77586_a(this);
      (new RecipesWeapons()).func_77583_a(this);
      (new RecipesIngots()).func_77590_a(this);
      (new RecipesFood()).func_77608_a(this);
      (new RecipesCrafting()).func_77589_a(this);
      (new RecipesArmor()).func_77609_a(this);
      (new RecipesDyes()).func_77607_a(this);
      this.func_77595_a(new ItemStack(Item.field_77759_aK, 3), new Object[]{"###", Character.valueOf('#'), Item.field_77758_aJ});
      this.func_77596_b(new ItemStack(Item.field_77760_aL, 1), new Object[]{Item.field_77759_aK, Item.field_77759_aK, Item.field_77759_aK, Item.field_77770_aF});
      this.func_77596_b(new ItemStack(Item.field_77821_bF, 1), new Object[]{Item.field_77760_aL, new ItemStack(Item.field_77756_aW, 1, 0), Item.field_77676_L});
      this.func_77595_a(new ItemStack(Block.field_72031_aZ, 2), new Object[]{"###", "###", Character.valueOf('#'), Item.field_77669_D});
      this.func_77595_a(new ItemStack(Block.field_72098_bB, 6), new Object[]{"###", "###", Character.valueOf('#'), Block.field_72033_bA});
      this.func_77595_a(new ItemStack(Block.field_71993_bv, 1), new Object[]{"#W#", "#W#", Character.valueOf('#'), Item.field_77669_D, Character.valueOf('W'), Block.field_71988_x});
      this.func_77595_a(new ItemStack(Block.field_72032_aY, 1), new Object[]{"###", "#X#", "###", Character.valueOf('#'), Block.field_71988_x, Character.valueOf('X'), Item.field_77702_n});
      this.func_77595_a(new ItemStack(Block.field_71960_R, 1), new Object[]{"###", "#X#", "###", Character.valueOf('#'), Block.field_71988_x, Character.valueOf('X'), Item.field_77767_aC});
      this.func_77595_a(new ItemStack(Block.field_72093_an, 1), new Object[]{"###", "XXX", "###", Character.valueOf('#'), Block.field_71988_x, Character.valueOf('X'), Item.field_77760_aL});
      this.func_77595_a(new ItemStack(Block.field_72039_aU, 1), new Object[]{"##", "##", Character.valueOf('#'), Item.field_77768_aD});
      this.func_77595_a(new ItemStack(Block.field_72041_aW, 1), new Object[]{"##", "##", Character.valueOf('#'), Item.field_77757_aI});
      this.func_77595_a(new ItemStack(Block.field_72081_al, 1), new Object[]{"##", "##", Character.valueOf('#'), Item.field_77772_aH});
      this.func_77595_a(new ItemStack(Block.field_72014_bd, 1), new Object[]{"##", "##", Character.valueOf('#'), Item.field_77751_aT});
      this.func_77595_a(new ItemStack(Block.field_72101_ab, 1), new Object[]{"##", "##", Character.valueOf('#'), Item.field_77683_K});
      this.func_77595_a(new ItemStack(Block.field_72091_am, 1), new Object[]{"X#X", "#X#", "X#X", Character.valueOf('X'), Item.field_77677_M, Character.valueOf('#'), Block.field_71939_E});
      this.func_77595_a(new ItemStack(Block.field_72079_ak, 6, 3), new Object[]{"###", Character.valueOf('#'), Block.field_71978_w});
      this.func_77595_a(new ItemStack(Block.field_72079_ak, 6, 0), new Object[]{"###", Character.valueOf('#'), Block.field_71981_t});
      this.func_77595_a(new ItemStack(Block.field_72079_ak, 6, 1), new Object[]{"###", Character.valueOf('#'), Block.field_71957_Q});
      this.func_77595_a(new ItemStack(Block.field_72079_ak, 6, 4), new Object[]{"###", Character.valueOf('#'), Block.field_72081_al});
      this.func_77595_a(new ItemStack(Block.field_72079_ak, 6, 5), new Object[]{"###", Character.valueOf('#'), Block.field_72007_bm});
      this.func_77595_a(new ItemStack(Block.field_72092_bO, 6, 0), new Object[]{"###", Character.valueOf('#'), new ItemStack(Block.field_71988_x, 1, 0)});
      this.func_77595_a(new ItemStack(Block.field_72092_bO, 6, 2), new Object[]{"###", Character.valueOf('#'), new ItemStack(Block.field_71988_x, 1, 2)});
      this.func_77595_a(new ItemStack(Block.field_72092_bO, 6, 1), new Object[]{"###", Character.valueOf('#'), new ItemStack(Block.field_71988_x, 1, 1)});
      this.func_77595_a(new ItemStack(Block.field_72092_bO, 6, 3), new Object[]{"###", Character.valueOf('#'), new ItemStack(Block.field_71988_x, 1, 3)});
      this.func_77595_a(new ItemStack(Block.field_72055_aF, 3), new Object[]{"# #", "###", "# #", Character.valueOf('#'), Item.field_77669_D});
      this.func_77595_a(new ItemStack(Item.field_77790_av, 1), new Object[]{"##", "##", "##", Character.valueOf('#'), Block.field_71988_x});
      this.func_77595_a(new ItemStack(Block.field_72005_bk, 2), new Object[]{"###", "###", Character.valueOf('#'), Block.field_71988_x});
      this.func_77595_a(new ItemStack(Item.field_77766_aB, 1), new Object[]{"##", "##", "##", Character.valueOf('#'), Item.field_77703_o});
      this.func_77595_a(new ItemStack(Item.field_77792_au, 3), new Object[]{"###", "###", " X ", Character.valueOf('#'), Block.field_71988_x, Character.valueOf('X'), Item.field_77669_D});
      this.func_77595_a(new ItemStack(Item.field_77746_aZ, 1), new Object[]{"AAA", "BEB", "CCC", Character.valueOf('A'), Item.field_77771_aG, Character.valueOf('B'), Item.field_77747_aY, Character.valueOf('C'), Item.field_77685_T, Character.valueOf('E'), Item.field_77764_aP});
      this.func_77595_a(new ItemStack(Item.field_77747_aY, 1), new Object[]{"#", Character.valueOf('#'), Item.field_77758_aJ});
      this.func_77595_a(new ItemStack(Block.field_71988_x, 4, 0), new Object[]{"#", Character.valueOf('#'), new ItemStack(Block.field_71951_J, 1, 0)});
      this.func_77595_a(new ItemStack(Block.field_71988_x, 4, 1), new Object[]{"#", Character.valueOf('#'), new ItemStack(Block.field_71951_J, 1, 1)});
      this.func_77595_a(new ItemStack(Block.field_71988_x, 4, 2), new Object[]{"#", Character.valueOf('#'), new ItemStack(Block.field_71951_J, 1, 2)});
      this.func_77595_a(new ItemStack(Block.field_71988_x, 4, 3), new Object[]{"#", Character.valueOf('#'), new ItemStack(Block.field_71951_J, 1, 3)});
      this.func_77595_a(new ItemStack(Item.field_77669_D, 4), new Object[]{"#", "#", Character.valueOf('#'), Block.field_71988_x});
      this.func_77595_a(new ItemStack(Block.field_72069_aq, 4), new Object[]{"X", "#", Character.valueOf('X'), Item.field_77705_m, Character.valueOf('#'), Item.field_77669_D});
      this.func_77595_a(new ItemStack(Block.field_72069_aq, 4), new Object[]{"X", "#", Character.valueOf('X'), new ItemStack(Item.field_77705_m, 1, 1), Character.valueOf('#'), Item.field_77669_D});
      this.func_77595_a(new ItemStack(Item.field_77670_E, 4), new Object[]{"# #", " # ", Character.valueOf('#'), Block.field_71988_x});
      this.func_77595_a(new ItemStack(Item.field_77729_bt, 3), new Object[]{"# #", " # ", Character.valueOf('#'), Block.field_71946_M});
      this.func_77595_a(new ItemStack(Block.field_72056_aG, 16), new Object[]{"X X", "X#X", "X X", Character.valueOf('X'), Item.field_77703_o, Character.valueOf('#'), Item.field_77669_D});
      this.func_77595_a(new ItemStack(Block.field_71954_T, 6), new Object[]{"X X", "X#X", "XRX", Character.valueOf('X'), Item.field_77717_p, Character.valueOf('R'), Item.field_77767_aC, Character.valueOf('#'), Item.field_77669_D});
      this.func_77595_a(new ItemStack(Block.field_71953_U, 6), new Object[]{"X X", "X#X", "XRX", Character.valueOf('X'), Item.field_77703_o, Character.valueOf('R'), Item.field_77767_aC, Character.valueOf('#'), Block.field_72044_aK});
      this.func_77595_a(new ItemStack(Item.field_77773_az, 1), new Object[]{"# #", "###", Character.valueOf('#'), Item.field_77703_o});
      this.func_77595_a(new ItemStack(Item.field_77721_bz, 1), new Object[]{"# #", "# #", "###", Character.valueOf('#'), Item.field_77703_o});
      this.func_77595_a(new ItemStack(Item.field_77724_by, 1), new Object[]{" B ", "###", Character.valueOf('#'), Block.field_71978_w, Character.valueOf('B'), Item.field_77731_bo});
      this.func_77595_a(new ItemStack(Block.field_72008_bf, 1), new Object[]{"A", "B", Character.valueOf('A'), Block.field_72061_ba, Character.valueOf('B'), Block.field_72069_aq});
      this.func_77595_a(new ItemStack(Item.field_77762_aN, 1), new Object[]{"A", "B", Character.valueOf('A'), Block.field_72077_au, Character.valueOf('B'), Item.field_77773_az});
      this.func_77595_a(new ItemStack(Item.field_77763_aO, 1), new Object[]{"A", "B", Character.valueOf('A'), Block.field_72051_aB, Character.valueOf('B'), Item.field_77773_az});
      this.func_77595_a(new ItemStack(Item.field_77769_aE, 1), new Object[]{"# #", "###", Character.valueOf('#'), Block.field_71988_x});
      this.func_77595_a(new ItemStack(Item.field_77788_aw, 1), new Object[]{"# #", " # ", Character.valueOf('#'), Item.field_77703_o});
      this.func_77595_a(new ItemStack(Item.field_77709_i, 1), new Object[]{"A ", " B", Character.valueOf('A'), Item.field_77703_o, Character.valueOf('B'), Item.field_77804_ap});
      this.func_77595_a(new ItemStack(Item.field_77684_U, 1), new Object[]{"###", Character.valueOf('#'), Item.field_77685_T});
      this.func_77595_a(new ItemStack(Block.field_72063_at, 4), new Object[]{"#  ", "## ", "###", Character.valueOf('#'), new ItemStack(Block.field_71988_x, 1, 0)});
      this.func_77595_a(new ItemStack(Block.field_72072_bX, 4), new Object[]{"#  ", "## ", "###", Character.valueOf('#'), new ItemStack(Block.field_71988_x, 1, 2)});
      this.func_77595_a(new ItemStack(Block.field_72074_bW, 4), new Object[]{"#  ", "## ", "###", Character.valueOf('#'), new ItemStack(Block.field_71988_x, 1, 1)});
      this.func_77595_a(new ItemStack(Block.field_72070_bY, 4), new Object[]{"#  ", "## ", "###", Character.valueOf('#'), new ItemStack(Block.field_71988_x, 1, 3)});
      this.func_77595_a(new ItemStack(Item.field_77749_aR, 1), new Object[]{"  #", " #X", "# X", Character.valueOf('#'), Item.field_77669_D, Character.valueOf('X'), Item.field_77683_K});
      this.func_77595_a(new ItemStack(Block.field_72057_aH, 4), new Object[]{"#  ", "## ", "###", Character.valueOf('#'), Block.field_71978_w});
      this.func_77595_a(new ItemStack(Block.field_71992_bw, 4), new Object[]{"#  ", "## ", "###", Character.valueOf('#'), Block.field_72081_al});
      this.func_77595_a(new ItemStack(Block.field_71995_bx, 4), new Object[]{"#  ", "## ", "###", Character.valueOf('#'), Block.field_72007_bm});
      this.func_77595_a(new ItemStack(Block.field_72100_bC, 4), new Object[]{"#  ", "## ", "###", Character.valueOf('#'), Block.field_72033_bA});
      this.func_77595_a(new ItemStack(Block.field_72088_bQ, 4), new Object[]{"#  ", "## ", "###", Character.valueOf('#'), Block.field_71957_Q});
      this.func_77595_a(new ItemStack(Item.field_77780_as, 1), new Object[]{"###", "#X#", "###", Character.valueOf('#'), Item.field_77669_D, Character.valueOf('X'), Block.field_72101_ab});
      this.func_77595_a(new ItemStack(Item.field_77778_at, 1, 0), new Object[]{"###", "#X#", "###", Character.valueOf('#'), Item.field_77733_bq, Character.valueOf('X'), Item.field_77706_j});
      this.func_77595_a(new ItemStack(Item.field_77778_at, 1, 1), new Object[]{"###", "#X#", "###", Character.valueOf('#'), Block.field_72105_ah, Character.valueOf('X'), Item.field_77706_j});
      this.func_77595_a(new ItemStack(Block.field_72043_aJ, 1), new Object[]{"X", "#", Character.valueOf('#'), Block.field_71978_w, Character.valueOf('X'), Item.field_77669_D});
      this.func_77595_a(new ItemStack(Block.field_72064_bT, 2), new Object[]{"I", "S", "#", Character.valueOf('#'), Block.field_71988_x, Character.valueOf('S'), Item.field_77669_D, Character.valueOf('I'), Item.field_77703_o});
      this.func_77595_a(new ItemStack(Block.field_72035_aQ, 1), new Object[]{"X", "#", Character.valueOf('#'), Item.field_77669_D, Character.valueOf('X'), Item.field_77767_aC});
      this.func_77595_a(new ItemStack(Item.field_77742_bb, 1), new Object[]{"#X#", "III", Character.valueOf('#'), Block.field_72035_aQ, Character.valueOf('X'), Item.field_77767_aC, Character.valueOf('I'), Block.field_71981_t});
      this.func_77595_a(new ItemStack(Item.field_77752_aS, 1), new Object[]{" # ", "#X#", " # ", Character.valueOf('#'), Item.field_77717_p, Character.valueOf('X'), Item.field_77767_aC});
      this.func_77595_a(new ItemStack(Item.field_77750_aQ, 1), new Object[]{" # ", "#X#", " # ", Character.valueOf('#'), Item.field_77703_o, Character.valueOf('X'), Item.field_77767_aC});
      this.func_77595_a(new ItemStack(Item.field_77744_bd, 1), new Object[]{"###", "#X#", "###", Character.valueOf('#'), Item.field_77759_aK, Character.valueOf('X'), Item.field_77750_aQ});
      this.func_77595_a(new ItemStack(Block.field_72034_aR, 1), new Object[]{"#", "#", Character.valueOf('#'), Block.field_71981_t});
      this.func_77595_a(new ItemStack(Block.field_72044_aK, 1), new Object[]{"##", Character.valueOf('#'), Block.field_71981_t});
      this.func_77595_a(new ItemStack(Block.field_72046_aM, 1), new Object[]{"##", Character.valueOf('#'), Block.field_71988_x});
      this.func_77595_a(new ItemStack(Block.field_71958_P, 1), new Object[]{"###", "#X#", "#R#", Character.valueOf('#'), Block.field_71978_w, Character.valueOf('X'), Item.field_77707_k, Character.valueOf('R'), Item.field_77767_aC});
      this.func_77595_a(new ItemStack(Block.field_71963_Z, 1), new Object[]{"TTT", "#X#", "#R#", Character.valueOf('#'), Block.field_71978_w, Character.valueOf('X'), Item.field_77703_o, Character.valueOf('R'), Item.field_77767_aC, Character.valueOf('T'), Block.field_71988_x});
      this.func_77595_a(new ItemStack(Block.field_71956_V, 1), new Object[]{"S", "P", Character.valueOf('S'), Item.field_77761_aM, Character.valueOf('P'), Block.field_71963_Z});
      this.func_77595_a(new ItemStack(Item.field_77776_ba, 1), new Object[]{"###", "XXX", Character.valueOf('#'), Block.field_72101_ab, Character.valueOf('X'), Block.field_71988_x});
      this.func_77595_a(new ItemStack(Block.field_72096_bE, 1), new Object[]{" B ", "D#D", "###", Character.valueOf('#'), Block.field_72089_ap, Character.valueOf('B'), Item.field_77760_aL, Character.valueOf('D'), Item.field_77702_n});
      this.func_77596_b(new ItemStack(Item.field_77748_bA, 1), new Object[]{Item.field_77730_bn, Item.field_77722_bw});
      this.func_77596_b(new ItemStack(Item.field_77811_bE, 3), new Object[]{Item.field_77677_M, Item.field_77722_bw, Item.field_77705_m});
      this.func_77596_b(new ItemStack(Item.field_77811_bE, 3), new Object[]{Item.field_77677_M, Item.field_77722_bw, new ItemStack(Item.field_77705_m, 1, 1)});
      Collections.sort(this.field_77597_b, new RecipeSorter(this));
      System.out.println(this.field_77597_b.size() + " recipes");
   }

   void func_77595_a(ItemStack p_77595_1_, Object ... p_77595_2_) {
      String var3 = "";
      int var4 = 0;
      int var5 = 0;
      int var6 = 0;
      int var9;
      if(p_77595_2_[var4] instanceof String[]) {
         String[] var7 = (String[])((String[])p_77595_2_[var4++]);
         String[] var8 = var7;
         var9 = var7.length;

         for(int var10 = 0; var10 < var9; ++var10) {
            String var11 = var8[var10];
            ++var6;
            var5 = var11.length();
            var3 = var3 + var11;
         }
      } else {
         while(p_77595_2_[var4] instanceof String) {
            String var13 = (String)p_77595_2_[var4++];
            ++var6;
            var5 = var13.length();
            var3 = var3 + var13;
         }
      }

      HashMap var14;
      for(var14 = new HashMap(); var4 < p_77595_2_.length; var4 += 2) {
         Character var16 = (Character)p_77595_2_[var4];
         ItemStack var17 = null;
         if(p_77595_2_[var4 + 1] instanceof Item) {
            var17 = new ItemStack((Item)p_77595_2_[var4 + 1]);
         } else if(p_77595_2_[var4 + 1] instanceof Block) {
            var17 = new ItemStack((Block)p_77595_2_[var4 + 1], 1, -1);
         } else if(p_77595_2_[var4 + 1] instanceof ItemStack) {
            var17 = (ItemStack)p_77595_2_[var4 + 1];
         }

         var14.put(var16, var17);
      }

      ItemStack[] var15 = new ItemStack[var5 * var6];

      for(var9 = 0; var9 < var5 * var6; ++var9) {
         char var18 = var3.charAt(var9);
         if(var14.containsKey(Character.valueOf(var18))) {
            var15[var9] = ((ItemStack)var14.get(Character.valueOf(var18))).func_77946_l();
         } else {
            var15[var9] = null;
         }
      }

      this.field_77597_b.add(new ShapedRecipes(var5, var6, var15, p_77595_1_));
   }

   void func_77596_b(ItemStack p_77596_1_, Object ... p_77596_2_) {
      ArrayList var3 = new ArrayList();
      Object[] var4 = p_77596_2_;
      int var5 = p_77596_2_.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         Object var7 = var4[var6];
         if(var7 instanceof ItemStack) {
            var3.add(((ItemStack)var7).func_77946_l());
         } else if(var7 instanceof Item) {
            var3.add(new ItemStack((Item)var7));
         } else {
            if(!(var7 instanceof Block)) {
               throw new RuntimeException("Invalid shapeless recipy!");
            }

            var3.add(new ItemStack((Block)var7));
         }
      }

      this.field_77597_b.add(new ShapelessRecipes(p_77596_1_, var3));
   }

   public ItemStack func_77593_a(InventoryCrafting p_77593_1_) {
      int var2 = 0;
      ItemStack var3 = null;
      ItemStack var4 = null;

      for(int var5 = 0; var5 < p_77593_1_.func_70302_i_(); ++var5) {
         ItemStack var6 = p_77593_1_.func_70301_a(var5);
         if(var6 != null) {
            if(var2 == 0) {
               var3 = var6;
            }

            if(var2 == 1) {
               var4 = var6;
            }

            ++var2;
         }
      }

      if(var2 == 2 && var3.field_77993_c == var4.field_77993_c && var3.field_77994_a == 1 && var4.field_77994_a == 1 && Item.field_77698_e[var3.field_77993_c].func_77645_m()) {
         Item var10 = Item.field_77698_e[var3.field_77993_c];
         int var12 = var10.func_77612_l() - var3.func_77952_i();
         int var7 = var10.func_77612_l() - var4.func_77952_i();
         int var8 = var12 + var7 + var10.func_77612_l() * 10 / 100;
         int var9 = var10.func_77612_l() - var8;
         if(var9 < 0) {
            var9 = 0;
         }

         return new ItemStack(var3.field_77993_c, 1, var9);
      } else {
         Iterator var11 = this.field_77597_b.iterator();

         IRecipe var13;
         do {
            if(!var11.hasNext()) {
               return null;
            }

            var13 = (IRecipe)var11.next();
         } while(!var13.func_77569_a(p_77593_1_));

         return var13.func_77572_b(p_77593_1_);
      }
   }

   public List func_77592_b() {
      return this.field_77597_b;
   }

}
