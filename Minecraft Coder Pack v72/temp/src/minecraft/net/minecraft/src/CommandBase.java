package net.minecraft.src;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.IAdminCommand;
import net.minecraft.src.ICommand;
import net.minecraft.src.ICommandSender;
import net.minecraft.src.NumberInvalidException;
import net.minecraft.src.PlayerNotFoundException;

public abstract class CommandBase implements ICommand {

   private static IAdminCommand field_71533_a = null;


   public String func_71518_a(ICommandSender p_71518_1_) {
      return "/" + this.func_71517_b();
   }

   public List func_71514_a() {
      return null;
   }

   public boolean func_71519_b(ICommandSender p_71519_1_) {
      return p_71519_1_.func_70003_b(this.func_71517_b());
   }

   public List func_71516_a(ICommandSender p_71516_1_, String[] p_71516_2_) {
      return null;
   }

   public static int func_71526_a(ICommandSender p_71526_0_, String p_71526_1_) {
      try {
         return Integer.parseInt(p_71526_1_);
      } catch (NumberFormatException var3) {
         throw new NumberInvalidException("commands.generic.num.invalid", new Object[]{p_71526_1_});
      }
   }

   public static int func_71528_a(ICommandSender p_71528_0_, String p_71528_1_, int p_71528_2_) {
      return func_71532_a(p_71528_0_, p_71528_1_, p_71528_2_, Integer.MAX_VALUE);
   }

   public static int func_71532_a(ICommandSender p_71532_0_, String p_71532_1_, int p_71532_2_, int p_71532_3_) {
      int var4 = func_71526_a(p_71532_0_, p_71532_1_);
      if(var4 < p_71532_2_) {
         throw new NumberInvalidException("commands.generic.num.tooSmall", new Object[]{Integer.valueOf(var4), Integer.valueOf(p_71532_2_)});
      } else if(var4 > p_71532_3_) {
         throw new NumberInvalidException("commands.generic.num.tooBig", new Object[]{Integer.valueOf(var4), Integer.valueOf(p_71532_3_)});
      } else {
         return var4;
      }
   }

   public static EntityPlayer func_71521_c(ICommandSender p_71521_0_) {
      if(p_71521_0_ instanceof EntityPlayer) {
         return (EntityPlayer)p_71521_0_;
      } else {
         throw new PlayerNotFoundException("You must specify which player you wish to perform this action on.", new Object[0]);
      }
   }

   public static String func_71520_a(String[] p_71520_0_, int p_71520_1_) {
      StringBuilder var2 = new StringBuilder();

      for(int var3 = p_71520_1_; var3 < p_71520_0_.length; ++var3) {
         if(var3 > p_71520_1_) {
            var2.append(" ");
         }

         var2.append(p_71520_0_[var3]);
      }

      return var2.toString();
   }

   public static String func_71527_a(Object[] p_71527_0_) {
      StringBuilder var1 = new StringBuilder();

      for(int var2 = 0; var2 < p_71527_0_.length; ++var2) {
         String var3 = p_71527_0_[var2].toString();
         if(var2 > 0) {
            if(var2 == p_71527_0_.length - 1) {
               var1.append(" and ");
            } else {
               var1.append(", ");
            }
         }

         var1.append(var3);
      }

      return var1.toString();
   }

   public static boolean func_71523_a(String p_71523_0_, String p_71523_1_) {
      return p_71523_1_.regionMatches(true, 0, p_71523_0_, 0, p_71523_0_.length());
   }

   public static List func_71530_a(String[] p_71530_0_, String ... p_71530_1_) {
      String var2 = p_71530_0_[p_71530_0_.length - 1];
      ArrayList var3 = new ArrayList();
      String[] var4 = p_71530_1_;
      int var5 = p_71530_1_.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         String var7 = var4[var6];
         if(func_71523_a(var2, var7)) {
            var3.add(var7);
         }
      }

      return var3;
   }

   public static List func_71531_a(String[] p_71531_0_, Iterable p_71531_1_) {
      String var2 = p_71531_0_[p_71531_0_.length - 1];
      ArrayList var3 = new ArrayList();
      Iterator var4 = p_71531_1_.iterator();

      while(var4.hasNext()) {
         String var5 = (String)var4.next();
         if(func_71523_a(var2, var5)) {
            var3.add(var5);
         }
      }

      return var3;
   }

   public static void func_71522_a(ICommandSender p_71522_0_, String p_71522_1_, Object ... p_71522_2_) {
      func_71524_a(p_71522_0_, 0, p_71522_1_, p_71522_2_);
   }

   public static void func_71524_a(ICommandSender p_71524_0_, int p_71524_1_, String p_71524_2_, Object ... p_71524_3_) {
      if(field_71533_a != null) {
         field_71533_a.func_71563_a(p_71524_0_, p_71524_1_, p_71524_2_, p_71524_3_);
      }

   }

   public static void func_71529_a(IAdminCommand p_71529_0_) {
      field_71533_a = p_71529_0_;
   }

   public int func_71525_a(ICommand p_71525_1_) {
      return this.func_71517_b().compareTo(p_71525_1_.func_71517_b());
   }

   // $FF: synthetic method
   public int compareTo(Object p_compareTo_1_) {
      return this.func_71525_a((ICommand)p_compareTo_1_);
   }

}
