package net.minecraft.src;

import java.util.regex.Pattern;

public class StringUtils {

   private static final Pattern field_76339_a = Pattern.compile("(?i)\\u00A7[0-9A-FK-OR]");


   public static String func_76338_a(String p_76338_0_) {
      return field_76339_a.matcher(p_76338_0_).replaceAll("");
   }

}
