package net.minecraft.src;

import net.minecraft.src.BiomeGenBase;
import net.minecraft.src.Material;
import net.minecraft.src.TileEntity;

public interface IBlockAccess {

   int func_72798_a(int var1, int var2, int var3);

   TileEntity func_72796_p(int var1, int var2, int var3);

   int func_72802_i(int var1, int var2, int var3, int var4);

   float func_72808_j(int var1, int var2, int var3, int var4);

   float func_72801_o(int var1, int var2, int var3);

   int func_72805_g(int var1, int var2, int var3);

   Material func_72803_f(int var1, int var2, int var3);

   boolean func_72804_r(int var1, int var2, int var3);

   boolean func_72809_s(int var1, int var2, int var3);

   boolean func_72799_c(int var1, int var2, int var3);

   BiomeGenBase func_72807_a(int var1, int var2);

   int func_72800_K();

   boolean func_72806_N();

   boolean func_72797_t(int var1, int var2, int var3);
}
