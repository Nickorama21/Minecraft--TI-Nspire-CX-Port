package net.minecraft.src;

import java.util.List;
import net.minecraft.src.IProgressUpdate;
import net.minecraft.src.ISaveHandler;
import net.minecraft.src.WorldInfo;

public interface ISaveFormat {

   ISaveHandler func_75804_a(String var1, boolean var2);

   List func_75799_b();

   void func_75800_d();

   WorldInfo func_75803_c(String var1);

   void func_75802_e(String var1);

   void func_75806_a(String var1, String var2);

   boolean func_75801_b(String var1);

   boolean func_75805_a(String var1, IProgressUpdate var2);
}
