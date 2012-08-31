package net.minecraft.src;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EntityPotion;
import net.minecraft.src.EnumAction;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Potion;
import net.minecraft.src.PotionEffect;
import net.minecraft.src.PotionHelper;
import net.minecraft.src.StatCollector;
import net.minecraft.src.World;

public class ItemPotion extends Item {

   private HashMap field_77836_a = new HashMap();
   private static final Map field_77835_b = new LinkedHashMap();


   public ItemPotion(int p_i3675_1_) {
      super(p_i3675_1_);
      this.func_77625_d(1);
      this.func_77627_a(true);
      this.func_77656_e(0);
      this.func_77637_a(CreativeTabs.field_78038_k);
   }

   public List func_77832_l(ItemStack p_77832_1_) {
      return this.func_77834_f(p_77832_1_.func_77960_j());
   }

   public List func_77834_f(int p_77834_1_) {
      List var2 = (List)this.field_77836_a.get(Integer.valueOf(p_77834_1_));
      if(var2 == null) {
         var2 = PotionHelper.func_77917_b(p_77834_1_, false);
         this.field_77836_a.put(Integer.valueOf(p_77834_1_), var2);
      }

      return var2;
   }

   public ItemStack func_77654_b(ItemStack p_77654_1_, World p_77654_2_, EntityPlayer p_77654_3_) {
      if(!p_77654_3_.field_71075_bZ.field_75098_d) {
         --p_77654_1_.field_77994_a;
      }

      if(!p_77654_2_.field_72995_K) {
         List var4 = this.func_77832_l(p_77654_1_);
         if(var4 != null) {
            Iterator var5 = var4.iterator();

            while(var5.hasNext()) {
               PotionEffect var6 = (PotionEffect)var5.next();
               p_77654_3_.func_70690_d(new PotionEffect(var6));
            }
         }
      }

      if(!p_77654_3_.field_71075_bZ.field_75098_d) {
         if(p_77654_1_.field_77994_a <= 0) {
            return new ItemStack(Item.field_77729_bt);
         }

         p_77654_3_.field_71071_by.func_70441_a(new ItemStack(Item.field_77729_bt));
      }

      return p_77654_1_;
   }

   public int func_77626_a(ItemStack p_77626_1_) {
      return 32;
   }

   public EnumAction func_77661_b(ItemStack p_77661_1_) {
      return EnumAction.drink;
   }

   public ItemStack func_77659_a(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_) {
      if(func_77831_g(p_77659_1_.func_77960_j())) {
         if(!p_77659_3_.field_71075_bZ.field_75098_d) {
            --p_77659_1_.field_77994_a;
         }

         p_77659_2_.func_72956_a(p_77659_3_, "random.bow", 0.5F, 0.4F / (field_77697_d.nextFloat() * 0.4F + 0.8F));
         if(!p_77659_2_.field_72995_K) {
            p_77659_2_.func_72838_d(new EntityPotion(p_77659_2_, p_77659_3_, p_77659_1_.func_77960_j()));
         }

         return p_77659_1_;
      } else {
         p_77659_3_.func_71008_a(p_77659_1_, this.func_77626_a(p_77659_1_));
         return p_77659_1_;
      }
   }

   public boolean func_77648_a(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
      return false;
   }

   public int func_77617_a(int p_77617_1_) {
      return func_77831_g(p_77617_1_)?154:140;
   }

   public int func_77618_c(int p_77618_1_, int p_77618_2_) {
      return p_77618_2_ == 0?141:super.func_77618_c(p_77618_1_, p_77618_2_);
   }

   public static boolean func_77831_g(int p_77831_0_) {
      return (p_77831_0_ & 16384) != 0;
   }

   public int func_77620_a(int p_77620_1_, int p_77620_2_) {
      return p_77620_2_ > 0?16777215:PotionHelper.func_77915_a(p_77620_1_, false);
   }

   public boolean func_77623_v() {
      return true;
   }

   public boolean func_77833_h(int p_77833_1_) {
      List var2 = this.func_77834_f(p_77833_1_);
      if(var2 != null && !var2.isEmpty()) {
         Iterator var3 = var2.iterator();

         PotionEffect var4;
         do {
            if(!var3.hasNext()) {
               return false;
            }

            var4 = (PotionEffect)var3.next();
         } while(!Potion.field_76425_a[var4.func_76456_a()].func_76403_b());

         return true;
      } else {
         return false;
      }
   }

   public String func_77628_j(ItemStack p_77628_1_) {
      if(p_77628_1_.func_77960_j() == 0) {
         return StatCollector.func_74838_a("item.emptyPotion.name").trim();
      } else {
         String var2 = "";
         if(func_77831_g(p_77628_1_.func_77960_j())) {
            var2 = StatCollector.func_74838_a("potion.prefix.grenade").trim() + " ";
         }

         List var3 = Item.field_77726_bs.func_77832_l(p_77628_1_);
         String var4;
         if(var3 != null && !var3.isEmpty()) {
            var4 = ((PotionEffect)var3.get(0)).func_76453_d();
            var4 = var4 + ".postfix";
            return var2 + StatCollector.func_74838_a(var4).trim();
         } else {
            var4 = PotionHelper.func_77905_c(p_77628_1_.func_77960_j());
            return StatCollector.func_74838_a(var4).trim() + " " + super.func_77628_j(p_77628_1_);
         }
      }
   }

   public void func_77624_a(ItemStack p_77624_1_, List p_77624_2_) {
      if(p_77624_1_.func_77960_j() != 0) {
         List var3 = Item.field_77726_bs.func_77832_l(p_77624_1_);
         if(var3 != null && !var3.isEmpty()) {
            Iterator var7 = var3.iterator();

            while(var7.hasNext()) {
               PotionEffect var5 = (PotionEffect)var7.next();
               String var6 = StatCollector.func_74838_a(var5.func_76453_d()).trim();
               if(var5.func_76458_c() > 0) {
                  var6 = var6 + " " + StatCollector.func_74838_a("potion.potency." + var5.func_76458_c()).trim();
               }

               if(var5.func_76459_b() > 20) {
                  var6 = var6 + " (" + Potion.func_76389_a(var5) + ")";
               }

               if(Potion.field_76425_a[var5.func_76456_a()].func_76398_f()) {
                  p_77624_2_.add("\u00a7c" + var6);
               } else {
                  p_77624_2_.add("\u00a77" + var6);
               }
            }
         } else {
            String var4 = StatCollector.func_74838_a("potion.empty").trim();
            p_77624_2_.add("\u00a77" + var4);
         }

      }
   }

   public boolean func_77636_d(ItemStack p_77636_1_) {
      List var2 = this.func_77832_l(p_77636_1_);
      return var2 != null && !var2.isEmpty();
   }

   public void func_77633_a(int p_77633_1_, CreativeTabs p_77633_2_, List p_77633_3_) {
      super.func_77633_a(p_77633_1_, p_77633_2_, p_77633_3_);
      if(field_77835_b.isEmpty()) {
         for(int var4 = 0; var4 <= 32767; ++var4) {
            List var5 = PotionHelper.func_77917_b(var4, false);
            if(var5 != null && !var5.isEmpty()) {
               field_77835_b.put(var5, Integer.valueOf(var4));
            }
         }
      }

      Iterator var6 = field_77835_b.values().iterator();

      while(var6.hasNext()) {
         int var7 = ((Integer)var6.next()).intValue();
         p_77633_3_.add(new ItemStack(p_77633_1_, 1, var7));
      }

   }

}
