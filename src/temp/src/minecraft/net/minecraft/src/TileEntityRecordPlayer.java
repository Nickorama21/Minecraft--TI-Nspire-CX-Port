package net.minecraft.src;

import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.TileEntity;

public class TileEntityRecordPlayer extends TileEntity {

   public int field_70417_a;


   public void func_70307_a(NBTTagCompound p_70307_1_) {
      super.func_70307_a(p_70307_1_);
      this.field_70417_a = p_70307_1_.func_74762_e("Record");
   }

   public void func_70310_b(NBTTagCompound p_70310_1_) {
      super.func_70310_b(p_70310_1_);
      if(this.field_70417_a > 0) {
         p_70310_1_.func_74768_a("Record", this.field_70417_a);
      }

   }
}
