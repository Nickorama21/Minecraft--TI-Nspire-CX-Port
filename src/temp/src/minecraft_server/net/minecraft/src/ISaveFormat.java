package net.minecraft.src;

import net.minecraft.src.IProgressUpdate;
import net.minecraft.src.ISaveHandler;

public interface ISaveFormat {

   ISaveHandler func_75804_a(String var1, boolean var2);

   void func_75800_d();

   void func_75802_e(String var1);

   boolean func_75801_b(String var1);

   boolean func_75805_a(String var1, IProgressUpdate var2);
}
