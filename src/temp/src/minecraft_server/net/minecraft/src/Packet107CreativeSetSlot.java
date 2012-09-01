package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.src.ItemStack;
import net.minecraft.src.NetHandler;
import net.minecraft.src.Packet;

public class Packet107CreativeSetSlot extends Packet {

   public int field_73385_a;
   public ItemStack field_73384_b;


   public void func_73279_a(NetHandler p_73279_1_) {
      p_73279_1_.func_72464_a(this);
   }

   public void func_73267_a(DataInputStream p_73267_1_) throws IOException {
      this.field_73385_a = p_73267_1_.readShort();
      this.field_73384_b = func_73276_c(p_73267_1_);
   }

   public void func_73273_a(DataOutputStream p_73273_1_) throws IOException {
      p_73273_1_.writeShort(this.field_73385_a);
      func_73270_a(this.field_73384_b, p_73273_1_);
   }

   public int func_73284_a() {
      return 8;
   }
}
