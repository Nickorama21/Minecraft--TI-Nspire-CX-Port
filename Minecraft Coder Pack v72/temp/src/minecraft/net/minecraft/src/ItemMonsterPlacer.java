package net.minecraft.src;

import java.util.Iterator;
import java.util.List;
import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityEggInfo;
import net.minecraft.src.EntityList;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EntityVillager;
import net.minecraft.src.Facing;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.StatCollector;
import net.minecraft.src.World;

public class ItemMonsterPlacer extends Item {

   public ItemMonsterPlacer(int p_i3671_1_) {
      super(p_i3671_1_);
      this.func_77627_a(true);
      this.func_77637_a(CreativeTabs.field_78026_f);
   }

   public String func_77628_j(ItemStack p_77628_1_) {
      String var2 = ("" + StatCollector.func_74838_a(this.func_77658_a() + ".name")).trim();
      String var3 = EntityList.func_75617_a(p_77628_1_.func_77960_j());
      if(var3 != null) {
         var2 = var2 + " " + StatCollector.func_74838_a("entity." + var3 + ".name");
      }

      return var2;
   }

   public int func_77620_a(int p_77620_1_, int p_77620_2_) {
      EntityEggInfo var3 = (EntityEggInfo)EntityList.field_75627_a.get(Integer.valueOf(p_77620_1_));
      return var3 != null?(p_77620_2_ == 0?var3.field_75611_b:var3.field_75612_c):16777215;
   }

   public boolean func_77623_v() {
      return true;
   }

   public int func_77618_c(int p_77618_1_, int p_77618_2_) {
      return p_77618_2_ > 0?super.func_77618_c(p_77618_1_, p_77618_2_) + 16:super.func_77618_c(p_77618_1_, p_77618_2_);
   }

   public boolean func_77648_a(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
      if(p_77648_3_.field_72995_K) {
         return true;
      } else {
         int var11 = p_77648_3_.func_72798_a(p_77648_4_, p_77648_5_, p_77648_6_);
         p_77648_4_ += Facing.field_71586_b[p_77648_7_];
         p_77648_5_ += Facing.field_71587_c[p_77648_7_];
         p_77648_6_ += Facing.field_71585_d[p_77648_7_];
         double var12 = 0.0D;
         if(p_77648_7_ == 1 && var11 == Block.field_72031_aZ.field_71990_ca || var11 == Block.field_72098_bB.field_71990_ca) {
            var12 = 0.5D;
         }

         if(func_77840_a(p_77648_3_, p_77648_1_.func_77960_j(), (double)p_77648_4_ + 0.5D, (double)p_77648_5_ + var12, (double)p_77648_6_ + 0.5D) && !p_77648_2_.field_71075_bZ.field_75098_d) {
            --p_77648_1_.field_77994_a;
         }

         return true;
      }
   }

   public static boolean func_77840_a(World p_77840_0_, int p_77840_1_, double p_77840_2_, double p_77840_4_, double p_77840_6_) {
      if(!EntityList.field_75627_a.containsKey(Integer.valueOf(p_77840_1_))) {
         return false;
      } else {
         Entity var8 = EntityList.func_75616_a(p_77840_1_, p_77840_0_);
         if(var8 != null) {
            var8.func_70012_b(p_77840_2_, p_77840_4_, p_77840_6_, p_77840_0_.field_73012_v.nextFloat() * 360.0F, 0.0F);
            if(var8 instanceof EntityVillager) {
               EntityVillager var9 = (EntityVillager)var8;
               var9.func_70938_b(var9.func_70681_au().nextInt(5));
               p_77840_0_.func_72838_d(var9);
               return true;
            }

            p_77840_0_.func_72838_d(var8);
            ((EntityLiving)var8).func_70642_aH();
         }

         return var8 != null;
      }
   }

   public void func_77633_a(int p_77633_1_, CreativeTabs p_77633_2_, List p_77633_3_) {
      Iterator var4 = EntityList.field_75627_a.values().iterator();

      while(var4.hasNext()) {
         EntityEggInfo var5 = (EntityEggInfo)var4.next();
         p_77633_3_.add(new ItemStack(p_77633_1_, 1, var5.field_75613_a));
      }

   }
}
