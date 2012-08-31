package net.minecraft.src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import net.minecraft.src.DamageSource;
import net.minecraft.src.Empty3;
import net.minecraft.src.Enchantment;
import net.minecraft.src.EnchantmentData;
import net.minecraft.src.EnchantmentModifierDamage;
import net.minecraft.src.EnchantmentModifierLiving;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.IEnchantmentModifier;
import net.minecraft.src.InventoryPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.NBTTagList;
import net.minecraft.src.WeightedRandom;

public class EnchantmentHelper {

   private static final Random field_77522_a = new Random();
   private static final EnchantmentModifierDamage field_77520_b = new EnchantmentModifierDamage((Empty3)null);
   private static final EnchantmentModifierLiving field_77521_c = new EnchantmentModifierLiving((Empty3)null);


   public static int func_77506_a(int p_77506_0_, ItemStack p_77506_1_) {
      if(p_77506_1_ == null) {
         return 0;
      } else {
         NBTTagList var2 = p_77506_1_.func_77986_q();
         if(var2 == null) {
            return 0;
         } else {
            for(int var3 = 0; var3 < var2.func_74745_c(); ++var3) {
               short var4 = ((NBTTagCompound)var2.func_74743_b(var3)).func_74765_d("id");
               short var5 = ((NBTTagCompound)var2.func_74743_b(var3)).func_74765_d("lvl");
               if(var4 == p_77506_0_) {
                  return var5;
               }
            }

            return 0;
         }
      }
   }

   private static int func_77511_a(int p_77511_0_, ItemStack[] p_77511_1_) {
      int var2 = 0;
      ItemStack[] var3 = p_77511_1_;
      int var4 = p_77511_1_.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         ItemStack var6 = var3[var5];
         int var7 = func_77506_a(p_77511_0_, var6);
         if(var7 > var2) {
            var2 = var7;
         }
      }

      return var2;
   }

   private static void func_77518_a(IEnchantmentModifier p_77518_0_, ItemStack p_77518_1_) {
      if(p_77518_1_ != null) {
         NBTTagList var2 = p_77518_1_.func_77986_q();
         if(var2 != null) {
            for(int var3 = 0; var3 < var2.func_74745_c(); ++var3) {
               short var4 = ((NBTTagCompound)var2.func_74743_b(var3)).func_74765_d("id");
               short var5 = ((NBTTagCompound)var2.func_74743_b(var3)).func_74765_d("lvl");
               if(Enchantment.field_77331_b[var4] != null) {
                  p_77518_0_.func_77493_a(Enchantment.field_77331_b[var4], var5);
               }
            }

         }
      }
   }

   private static void func_77516_a(IEnchantmentModifier p_77516_0_, ItemStack[] p_77516_1_) {
      ItemStack[] var2 = p_77516_1_;
      int var3 = p_77516_1_.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         ItemStack var5 = var2[var4];
         func_77518_a(p_77516_0_, var5);
      }

   }

   public static int func_77508_a(InventoryPlayer p_77508_0_, DamageSource p_77508_1_) {
      field_77520_b.field_77497_a = 0;
      field_77520_b.field_77496_b = p_77508_1_;
      func_77516_a(field_77520_b, p_77508_0_.field_70460_b);
      if(field_77520_b.field_77497_a > 25) {
         field_77520_b.field_77497_a = 25;
      }

      return (field_77520_b.field_77497_a + 1 >> 1) + field_77522_a.nextInt((field_77520_b.field_77497_a >> 1) + 1);
   }

   public static int func_77512_a(InventoryPlayer p_77512_0_, EntityLiving p_77512_1_) {
      field_77521_c.field_77495_a = 0;
      field_77521_c.field_77494_b = p_77512_1_;
      func_77518_a(field_77521_c, p_77512_0_.func_70448_g());
      return field_77521_c.field_77495_a > 0?1 + field_77522_a.nextInt(field_77521_c.field_77495_a):0;
   }

   public static int func_77507_b(InventoryPlayer p_77507_0_, EntityLiving p_77507_1_) {
      return func_77506_a(Enchantment.field_77337_m.field_77352_x, p_77507_0_.func_70448_g());
   }

   public static int func_77515_c(InventoryPlayer p_77515_0_, EntityLiving p_77515_1_) {
      return func_77506_a(Enchantment.field_77334_n.field_77352_x, p_77515_0_.func_70448_g());
   }

   public static int func_77501_a(InventoryPlayer p_77501_0_) {
      return func_77511_a(Enchantment.field_77340_h.field_77352_x, p_77501_0_.field_70460_b);
   }

   public static int func_77509_b(InventoryPlayer p_77509_0_) {
      return func_77506_a(Enchantment.field_77349_p.field_77352_x, p_77509_0_.func_70448_g());
   }

   public static int func_77503_c(InventoryPlayer p_77503_0_) {
      return func_77506_a(Enchantment.field_77347_r.field_77352_x, p_77503_0_.func_70448_g());
   }

   public static boolean func_77502_d(InventoryPlayer p_77502_0_) {
      return func_77506_a(Enchantment.field_77348_q.field_77352_x, p_77502_0_.func_70448_g()) > 0;
   }

   public static int func_77517_e(InventoryPlayer p_77517_0_) {
      return func_77506_a(Enchantment.field_77346_s.field_77352_x, p_77517_0_.func_70448_g());
   }

   public static int func_77519_f(InventoryPlayer p_77519_0_) {
      return func_77506_a(Enchantment.field_77335_o.field_77352_x, p_77519_0_.func_70448_g());
   }

   public static boolean func_77510_g(InventoryPlayer p_77510_0_) {
      return func_77511_a(Enchantment.field_77341_i.field_77352_x, p_77510_0_.field_70460_b) > 0;
   }

   public static int func_77514_a(Random p_77514_0_, int p_77514_1_, int p_77514_2_, ItemStack p_77514_3_) {
      Item var4 = p_77514_3_.func_77973_b();
      int var5 = var4.func_77619_b();
      if(var5 <= 0) {
         return 0;
      } else {
         if(p_77514_2_ > 15) {
            p_77514_2_ = 15;
         }

         int var6 = p_77514_0_.nextInt(8) + 1 + (p_77514_2_ >> 1) + p_77514_0_.nextInt(p_77514_2_ + 1);
         return p_77514_1_ == 0?Math.max(var6 / 3, 1):(p_77514_1_ == 1?var6 * 2 / 3 + 1:Math.max(var6, p_77514_2_ * 2));
      }
   }

   public static ItemStack func_77504_a(Random p_77504_0_, ItemStack p_77504_1_, int p_77504_2_) {
      List var3 = func_77513_b(p_77504_0_, p_77504_1_, p_77504_2_);
      if(var3 != null) {
         Iterator var4 = var3.iterator();

         while(var4.hasNext()) {
            EnchantmentData var5 = (EnchantmentData)var4.next();
            p_77504_1_.func_77966_a(var5.field_76302_b, var5.field_76303_c);
         }
      }

      return p_77504_1_;
   }

   public static List func_77513_b(Random p_77513_0_, ItemStack p_77513_1_, int p_77513_2_) {
      Item var3 = p_77513_1_.func_77973_b();
      int var4 = var3.func_77619_b();
      if(var4 <= 0) {
         return null;
      } else {
         var4 /= 2;
         var4 = 1 + p_77513_0_.nextInt((var4 >> 1) + 1) + p_77513_0_.nextInt((var4 >> 1) + 1);
         int var5 = var4 + p_77513_2_;
         float var6 = (p_77513_0_.nextFloat() + p_77513_0_.nextFloat() - 1.0F) * 0.15F;
         int var7 = (int)((float)var5 * (1.0F + var6) + 0.5F);
         if(var7 < 1) {
            var7 = 1;
         }

         ArrayList var8 = null;
         Map var9 = func_77505_b(var7, p_77513_1_);
         if(var9 != null && !var9.isEmpty()) {
            EnchantmentData var10 = (EnchantmentData)WeightedRandom.func_76271_a(p_77513_0_, var9.values());
            if(var10 != null) {
               var8 = new ArrayList();
               var8.add(var10);

               for(int var11 = var7; p_77513_0_.nextInt(50) <= var11; var11 >>= 1) {
                  Iterator var12 = var9.keySet().iterator();

                  while(var12.hasNext()) {
                     Integer var13 = (Integer)var12.next();
                     boolean var14 = true;
                     Iterator var15 = var8.iterator();

                     while(true) {
                        if(var15.hasNext()) {
                           EnchantmentData var16 = (EnchantmentData)var15.next();
                           if(var16.field_76302_b.func_77326_a(Enchantment.field_77331_b[var13.intValue()])) {
                              continue;
                           }

                           var14 = false;
                        }

                        if(!var14) {
                           var12.remove();
                        }
                        break;
                     }
                  }

                  if(!var9.isEmpty()) {
                     EnchantmentData var17 = (EnchantmentData)WeightedRandom.func_76271_a(p_77513_0_, var9.values());
                     var8.add(var17);
                  }
               }
            }
         }

         return var8;
      }
   }

   public static Map func_77505_b(int p_77505_0_, ItemStack p_77505_1_) {
      Item var2 = p_77505_1_.func_77973_b();
      HashMap var3 = null;
      Enchantment[] var4 = Enchantment.field_77331_b;
      int var5 = var4.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         Enchantment var7 = var4[var6];
         if(var7 != null && var7.field_77351_y.func_77557_a(var2)) {
            for(int var8 = var7.func_77319_d(); var8 <= var7.func_77325_b(); ++var8) {
               if(p_77505_0_ >= var7.func_77321_a(var8) && p_77505_0_ <= var7.func_77317_b(var8)) {
                  if(var3 == null) {
                     var3 = new HashMap();
                  }

                  var3.put(Integer.valueOf(var7.field_77352_x), new EnchantmentData(var7, var8));
               }
            }
         }
      }

      return var3;
   }

}
