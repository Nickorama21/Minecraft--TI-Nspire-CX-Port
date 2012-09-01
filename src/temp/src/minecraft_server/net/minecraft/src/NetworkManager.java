package net.minecraft.src;

import java.net.SocketAddress;
import net.minecraft.src.NetHandler;
import net.minecraft.src.Packet;

public interface NetworkManager {

   void func_74425_a(NetHandler var1);

   void func_74429_a(Packet var1);

   void func_74427_a();

   void func_74428_b();

   SocketAddress func_74430_c();

   void func_74423_d();

   int func_74426_e();

   void func_74424_a(String var1, Object ... var2);
}
