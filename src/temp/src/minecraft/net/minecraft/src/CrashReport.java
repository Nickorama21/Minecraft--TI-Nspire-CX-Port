package net.minecraft.src;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.minecraft.src.CallableJVMFlags;
import net.minecraft.src.CallableJavaInfo;
import net.minecraft.src.CallableJavaInfo2;
import net.minecraft.src.CallableMemoryInfo;
import net.minecraft.src.CallableMinecraftVersion;
import net.minecraft.src.CallableOSInfo;

public class CrashReport {

   private final String field_71513_a;
   private final Throwable field_71511_b;
   private final Map field_71512_c = new LinkedHashMap();
   private File field_71510_d = null;


   public CrashReport(String p_i3250_1_, Throwable p_i3250_2_) {
      this.field_71513_a = p_i3250_1_;
      this.field_71511_b = p_i3250_2_;
      this.func_71504_g();
   }

   private void func_71504_g() {
      this.func_71500_a("Minecraft Version", new CallableMinecraftVersion(this));
      this.func_71500_a("Operating System", new CallableOSInfo(this));
      this.func_71500_a("Java Version", new CallableJavaInfo(this));
      this.func_71500_a("Java VM Version", new CallableJavaInfo2(this));
      this.func_71500_a("Memory", new CallableMemoryInfo(this));
      this.func_71500_a("JVM Flags", new CallableJVMFlags(this));
   }

   public void func_71500_a(String p_71500_1_, Callable p_71500_2_) {
      try {
         this.func_71507_a(p_71500_1_, p_71500_2_.call());
      } catch (Throwable var4) {
         this.func_71499_a(p_71500_1_, var4);
      }

   }

   public void func_71507_a(String p_71507_1_, Object p_71507_2_) {
      this.field_71512_c.put(p_71507_1_, p_71507_2_ == null?"null":p_71507_2_.toString());
   }

   public void func_71499_a(String p_71499_1_, Throwable p_71499_2_) {
      this.func_71507_a(p_71499_1_, "~ERROR~ " + p_71499_2_.getClass().getSimpleName() + ": " + p_71499_2_.getMessage());
   }

   public String func_71501_a() {
      return this.field_71513_a;
   }

   public Throwable func_71505_b() {
      return this.field_71511_b;
   }

   public String func_71509_c() {
      StringBuilder var1 = new StringBuilder();
      this.func_71506_a(var1);
      return var1.toString();
   }

   public void func_71506_a(StringBuilder p_71506_1_) {
      boolean var2 = true;

      for(Iterator var3 = this.field_71512_c.entrySet().iterator(); var3.hasNext(); var2 = false) {
         Entry var4 = (Entry)var3.next();
         if(!var2) {
            p_71506_1_.append("\n");
         }

         p_71506_1_.append("- ");
         p_71506_1_.append((String)var4.getKey());
         p_71506_1_.append(": ");
         p_71506_1_.append((String)var4.getValue());
      }

   }

   public String func_71498_d() {
      StringWriter var1 = null;
      PrintWriter var2 = null;
      String var3 = this.field_71511_b.toString();

      try {
         var1 = new StringWriter();
         var2 = new PrintWriter(var1);
         this.field_71511_b.printStackTrace(var2);
         var3 = var1.toString();
      } finally {
         try {
            if(var1 != null) {
               var1.close();
            }

            if(var2 != null) {
               var2.close();
            }
         } catch (IOException var10) {
            ;
         }

      }

      return var3;
   }

   public String func_71502_e() {
      StringBuilder var1 = new StringBuilder();
      var1.append("---- Minecraft Crash Report ----\n");
      var1.append("// ");
      var1.append(func_71503_h());
      var1.append("\n\n");
      var1.append("Time: ");
      var1.append((new SimpleDateFormat()).format(new Date()));
      var1.append("\n");
      var1.append("Description: ");
      var1.append(this.field_71513_a);
      var1.append("\n\n");
      var1.append(this.func_71498_d());
      var1.append("\n");
      var1.append("Relevant Details:");
      var1.append("\n");
      this.func_71506_a(var1);
      return var1.toString();
   }

   public File func_71497_f() {
      return this.field_71510_d;
   }

   public boolean func_71508_a(File p_71508_1_) {
      if(this.field_71510_d != null) {
         return false;
      } else {
         if(p_71508_1_.getParentFile() != null) {
            p_71508_1_.getParentFile().mkdirs();
         }

         try {
            FileWriter var2 = new FileWriter(p_71508_1_);
            var2.write(this.func_71502_e());
            var2.close();
            this.field_71510_d = p_71508_1_;
            return true;
         } catch (Throwable var3) {
            Logger.getLogger("Minecraft").log(Level.SEVERE, "Could not save crash report to " + p_71508_1_, var3);
            return false;
         }
      }
   }

   private static String func_71503_h() {
      String[] var0 = new String[]{"Who set us up the TNT?", "Everything\'s going to plan. No, really, that was supposed to happen.", "Uh... Did I do that?", "Oops.", "Why did you do that?", "I feel sad now :(", "My bad.", "I\'m sorry, Dave.", "I let you down. Sorry :(", "On the bright side, I bought you a teddy bear!", "Daisy, daisy...", "Oh - I know what I did wrong!", "Hey, that tickles! Hehehe!", "I blame Dinnerbone.", "You should try our sister game, Minceraft!", "Don\'t be sad. I\'ll do better next time, I promise!", "Don\'t be sad, have a hug! <3", "I just don\'t know what went wrong :(", "Shall we play a game?", "Quite honestly, I wouldn\'t worry myself about that.", "I bet Cylons wouldn\'t have this problem.", "Sorry :(", "Surprise! Haha. Well, this is awkward.", "Would you like a cupcake?", "Hi. I\'m Minecraft, and I\'m a crashaholic.", "Ooh. Shiny.", "This doesn\'t make any sense!", "Why is it breaking :("};

      try {
         return var0[(int)(System.nanoTime() % (long)var0.length)];
      } catch (Throwable var2) {
         return "Witty comment unavailable :(";
      }
   }
}
