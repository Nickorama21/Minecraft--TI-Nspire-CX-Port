package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.src.NetHandler;
import net.minecraft.src.Packet;

public class Packet61DoorChange extends Packet {

   public int field_73567_a;
   public int field_73565_b;
   public int field_73566_c;
   public int field_73563_d;
   public int field_73564_e;


   public Packet61DoorChange() {}

   public Packet61DoorChange(int p_i3325_1_, int p_i3325_2_, int p_i3325_3_, int p_i3325_4_, int p_i3325_5_) {
      this.field_73567_a = p_i3325_1_;
      this.field_73566_c = p_i3325_2_;
      this.field_73563_d = p_i3325_3_;
      this.field_73564_e = p_i3325_4_;
      this.field_73565_b = p_i3325_5_;
   }

   public void func_73267_a(DataInputStream p_73267_1_) throws IOException {
      this.field_73567_a = p_73267_1_.readInt();
      this.field_73566_c = p_73267_1_.readInt();
      this.field_73563_d = p_73267_1_.readByte() & 255;
      this.field_73564_e = p_73267_1_.readInt();
      this.field_73565_b = p_73267_1_.readInt();
   }

   public void func_73273_a(DataOutputStream p_73273_1_) throws IOException {
      p_73273_1_.writeInt(this.field_73567_a);
      p_73273_1_.writeInt(this.field_73566_c);
      p_73273_1_.writeByte(this.field_73563_d & 255);
      p_73273_1_.writeInt(this.field_73564_e);
      p_73273_1_.writeInt(this.field_73565_b);
   }

   public void func_73279_a(NetHandler p_73279_1_) {
      p_73279_1_.func_72462_a(this);
   }

   public int func_73284_a() {
      return 20;
   }
}
