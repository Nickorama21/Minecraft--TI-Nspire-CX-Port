package net.minecraft.src;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ChatAllowedCharacters {

   public static final String field_71568_a = func_71564_a();
   public static final char[] field_71567_b = new char[]{'/', '\n', '\r', '\t', '\u0000', '\f', '`', '?', '*', '\\', '<', '>', '|', '\"', ':'};


   private static String func_71564_a() {
      String var0 = "";

      try {
         BufferedReader var1 = new BufferedReader(new InputStreamReader(ChatAllowedCharacters.class.getResourceAsStream("/font.txt"), "UTF-8"));
         String var2 = "";

         while((var2 = var1.readLine()) != null) {
            if(!var2.startsWith("#")) {
               var0 = var0 + var2;
            }
         }

         var1.close();
      } catch (Exception var3) {
         ;
      }

      return var0;
   }

   public static final boolean func_71566_a(char p_71566_0_) {
      return p_71566_0_ != 167 && (field_71568_a.indexOf(p_71566_0_) >= 0 || p_71566_0_ > 32);
   }

}
