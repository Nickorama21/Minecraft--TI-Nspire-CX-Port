package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.src.NetHandler;
import net.minecraft.src.Packet;

public class Packet108EnchantItem extends Packet {

   public int field_73446_a;
   public int field_73445_b;


   public void func_73279_a(NetHandler p_73279_1_) {
      p_73279_1_.func_72479_a(this);
   }

   public void func_73267_a(DataInputStream p_73267_1_) throws IOException {
      this.field_73446_a = p_73267_1_.readByte();
      this.field_73445_b = p_73267_1_.readByte();
   }

   public void func_73273_a(DataOutputStream p_73273_1_) throws IOException {
      p_73273_1_.writeByte(this.field_73446_a);
      p_73273_1_.writeByte(this.field_73445_b);
   }

   public int func_73284_a() {
      return 2;
   }
}
