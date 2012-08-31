package org.bouncycastle.crypto;

import java.security.SecureRandom;
import org.bouncycastle.crypto.KeyGenerationParameters;

public class CipherKeyGenerator {

   protected SecureRandom field_71788_a;
   protected int field_71787_b;


   public void init(KeyGenerationParameters p_init_1_) {
      this.field_71788_a = p_init_1_.func_71843_a();
      this.field_71787_b = (p_init_1_.func_71842_b() + 7) / 8;
   }

   public byte[] generateKey() {
      byte[] var1 = new byte[this.field_71787_b];
      this.field_71788_a.nextBytes(var1);
      return var1;
   }
}
