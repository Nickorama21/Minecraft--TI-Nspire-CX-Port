package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.src.NetHandler;
import net.minecraft.src.Packet;

public class Packet14BlockDig extends Packet {

   public int field_73345_a;
   public int field_73343_b;
   public int field_73344_c;
   public int field_73341_d;
   public int field_73342_e;


   public void func_73267_a(DataInputStream p_73267_1_) throws IOException {
      this.field_73342_e = p_73267_1_.read();
      this.field_73345_a = p_73267_1_.readInt();
      this.field_73343_b = p_73267_1_.read();
      this.field_73344_c = p_73267_1_.readInt();
      this.field_73341_d = p_73267_1_.read();
   }

   public void func_73273_a(DataOutputStream p_73273_1_) throws IOException {
      p_73273_1_.write(this.field_73342_e);
      p_73273_1_.writeInt(this.field_73345_a);
      p_73273_1_.write(this.field_73343_b);
      p_73273_1_.writeInt(this.field_73344_c);
      p_73273_1_.write(this.field_73341_d);
   }

   public void func_73279_a(NetHandler p_73279_1_) {
      p_73279_1_.func_72510_a(this);
   }

   public int func_73284_a() {
      return 11;
   }
}
