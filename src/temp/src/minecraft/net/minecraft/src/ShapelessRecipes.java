package net.minecraft.src;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.src.IRecipe;
import net.minecraft.src.InventoryCrafting;
import net.minecraft.src.ItemStack;

public class ShapelessRecipes implements IRecipe {

   private final ItemStack field_77580_a;
   private final List field_77579_b;


   public ShapelessRecipes(ItemStack p_i3701_1_, List p_i3701_2_) {
      this.field_77580_a = p_i3701_1_;
      this.field_77579_b = p_i3701_2_;
   }

   public ItemStack func_77571_b() {
      return this.field_77580_a;
   }

   public boolean func_77569_a(InventoryCrafting p_77569_1_) {
      ArrayList var2 = new ArrayList(this.field_77579_b);

      for(int var3 = 0; var3 < 3; ++var3) {
         for(int var4 = 0; var4 < 3; ++var4) {
            ItemStack var5 = p_77569_1_.func_70463_b(var4, var3);
            if(var5 != null) {
               boolean var6 = false;
               Iterator var7 = var2.iterator();

               while(var7.hasNext()) {
                  ItemStack var8 = (ItemStack)var7.next();
                  if(var5.field_77993_c == var8.field_77993_c && (var8.func_77960_j() == -1 || var5.func_77960_j() == var8.func_77960_j())) {
                     var6 = true;
                     var2.remove(var8);
                     break;
                  }
               }

               if(!var6) {
                  return false;
               }
            }
         }
      }

      return var2.isEmpty();
   }

   public ItemStack func_77572_b(InventoryCrafting p_77572_1_) {
      return this.field_77580_a.func_77946_l();
   }

   public int func_77570_a() {
      return this.field_77579_b.size();
   }
}
