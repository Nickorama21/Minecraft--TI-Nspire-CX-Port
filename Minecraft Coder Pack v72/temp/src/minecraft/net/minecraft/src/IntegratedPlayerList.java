package net.minecraft.src;

import net.minecraft.server.MinecraftServer;
import net.minecraft.src.EntityPlayerMP;
import net.minecraft.src.IntegratedServer;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.ServerConfigurationManager;

public class IntegratedPlayerList extends ServerConfigurationManager {

   private NBTTagCompound field_72416_e = null;


   public IntegratedPlayerList(IntegratedServer p_i3125_1_) {
      super(p_i3125_1_);
      this.field_72402_d = 10;
   }

   protected void func_72391_b(EntityPlayerMP p_72391_1_) {
      if(p_72391_1_.func_70005_c_().equals(this.func_72415_s().func_71214_G())) {
         this.field_72416_e = new NBTTagCompound();
         p_72391_1_.func_70109_d(this.field_72416_e);
      }

      super.func_72391_b(p_72391_1_);
   }

   public IntegratedServer func_72415_s() {
      return (IntegratedServer)super.func_72365_p();
   }

   public NBTTagCompound func_72378_q() {
      return this.field_72416_e;
   }

   // $FF: synthetic method
   public MinecraftServer func_72365_p() {
      return this.func_72415_s();
   }
}
