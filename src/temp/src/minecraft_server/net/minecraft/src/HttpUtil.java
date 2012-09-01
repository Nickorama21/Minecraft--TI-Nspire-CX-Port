package net.minecraft.src;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HttpUtil {

   public static String func_76179_a(Map p_76179_0_) {
      StringBuilder var1 = new StringBuilder();
      Iterator var2 = p_76179_0_.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         if(var1.length() > 0) {
            var1.append('&');
         }

         try {
            var1.append(URLEncoder.encode((String)var3.getKey(), "UTF-8"));
         } catch (UnsupportedEncodingException var6) {
            var6.printStackTrace();
         }

         if(var3.getValue() != null) {
            var1.append('=');

            try {
               var1.append(URLEncoder.encode(var3.getValue().toString(), "UTF-8"));
            } catch (UnsupportedEncodingException var5) {
               var5.printStackTrace();
            }
         }
      }

      return var1.toString();
   }

   public static String func_76183_a(URL p_76183_0_, Map p_76183_1_, boolean p_76183_2_) {
      return func_76180_a(p_76183_0_, func_76179_a(p_76183_1_), p_76183_2_);
   }

   public static String func_76180_a(URL p_76180_0_, String p_76180_1_, boolean p_76180_2_) {
      try {
         HttpURLConnection var3 = (HttpURLConnection)p_76180_0_.openConnection();
         var3.setRequestMethod("POST");
         var3.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
         var3.setRequestProperty("Content-Length", "" + p_76180_1_.getBytes().length);
         var3.setRequestProperty("Content-Language", "en-US");
         var3.setUseCaches(false);
         var3.setDoInput(true);
         var3.setDoOutput(true);
         DataOutputStream var4 = new DataOutputStream(var3.getOutputStream());
         var4.writeBytes(p_76180_1_);
         var4.flush();
         var4.close();
         BufferedReader var5 = new BufferedReader(new InputStreamReader(var3.getInputStream()));
         StringBuffer var7 = new StringBuffer();

         String var6;
         while((var6 = var5.readLine()) != null) {
            var7.append(var6);
            var7.append('\r');
         }

         var5.close();
         return var7.toString();
      } catch (Exception var8) {
         if(!p_76180_2_) {
            Logger.getLogger("Minecraft").log(Level.SEVERE, "Could not post to " + p_76180_0_, var8);
         }

         return "";
      }
   }
}
