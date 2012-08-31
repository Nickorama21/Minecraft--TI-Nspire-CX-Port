package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.List;
import net.minecraft.src.DataWatcher;
import net.minecraft.src.NetHandler;
import net.minecraft.src.Packet;

public class Packet40EntityMetadata extends Packet {

   public int field_73393_a;
   private List field_73392_b;


   public Packet40EntityMetadata() {}

   public Packet40EntityMetadata(int p_i3347_1_, DataWatcher p_i3347_2_) {
      this.field_73393_a = p_i3347_1_;
      this.field_73392_b = p_i3347_2_.func_75688_b();
   }

   public void func_73267_a(DataInputStream p_73267_1_) throws IOException {
      this.field_73393_a = p_73267_1_.readInt();
      this.field_73392_b = DataWatcher.func_75686_a(p_73267_1_);
   }

   public void func_73273_a(DataOutputStream p_73273_1_) throws IOException {
      p_73273_1_.writeInt(this.field_73393_a);
      DataWatcher.func_75680_a(this.field_73392_b, p_73273_1_);
   }

   public void func_73279_a(NetHandler p_73279_1_) {
      p_73279_1_.func_72493_a(this);
   }

   public int func_73284_a() {
      return 5;
   }

   public List func_73391_d() {
      return this.field_73392_b;
   }

   public boolean func_73277_a_() {
      return true;
   }
}
