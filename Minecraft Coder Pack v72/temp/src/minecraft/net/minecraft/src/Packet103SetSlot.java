package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.src.ItemStack;
import net.minecraft.src.NetHandler;
import net.minecraft.src.Packet;

public class Packet103SetSlot extends Packet {

   public int field_73637_a;
   public int field_73635_b;
   public ItemStack field_73636_c;


   public Packet103SetSlot() {}

   public Packet103SetSlot(int p_i3314_1_, int p_i3314_2_, ItemStack p_i3314_3_) {
      this.field_73637_a = p_i3314_1_;
      this.field_73635_b = p_i3314_2_;
      this.field_73636_c = p_i3314_3_ == null?p_i3314_3_:p_i3314_3_.func_77946_l();
   }

   public void func_73279_a(NetHandler p_73279_1_) {
      p_73279_1_.func_72490_a(this);
   }

   public void func_73267_a(DataInputStream p_73267_1_) throws IOException {
      this.field_73637_a = p_73267_1_.readByte();
      this.field_73635_b = p_73267_1_.readShort();
      this.field_73636_c = func_73276_c(p_73267_1_);
   }

   public void func_73273_a(DataOutputStream p_73273_1_) throws IOException {
      p_73273_1_.writeByte(this.field_73637_a);
      p_73273_1_.writeShort(this.field_73635_b);
      func_73270_a(this.field_73636_c, p_73273_1_);
   }

   public int func_73284_a() {
      return 8;
   }
}
