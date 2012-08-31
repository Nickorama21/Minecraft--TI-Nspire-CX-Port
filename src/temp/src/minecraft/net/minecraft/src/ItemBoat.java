package net.minecraft.src;

import java.util.Iterator;
import java.util.List;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityBoat;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EnumMovingObjectType;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.MathHelper;
import net.minecraft.src.MovingObjectPosition;
import net.minecraft.src.Vec3;
import net.minecraft.src.World;

public class ItemBoat extends Item {

   public ItemBoat(int p_i3621_1_) {
      super(p_i3621_1_);
      this.field_77777_bU = 1;
      this.func_77637_a(CreativeTabs.field_78029_e);
   }

   public ItemStack func_77659_a(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_) {
      float var4 = 1.0F;
      float var5 = p_77659_3_.field_70127_C + (p_77659_3_.field_70125_A - p_77659_3_.field_70127_C) * var4;
      float var6 = p_77659_3_.field_70126_B + (p_77659_3_.field_70177_z - p_77659_3_.field_70126_B) * var4;
      double var7 = p_77659_3_.field_70169_q + (p_77659_3_.field_70165_t - p_77659_3_.field_70169_q) * (double)var4;
      double var9 = p_77659_3_.field_70167_r + (p_77659_3_.field_70163_u - p_77659_3_.field_70167_r) * (double)var4 + 1.62D - (double)p_77659_3_.field_70129_M;
      double var11 = p_77659_3_.field_70166_s + (p_77659_3_.field_70161_v - p_77659_3_.field_70166_s) * (double)var4;
      Vec3 var13 = Vec3.func_72437_a().func_72345_a(var7, var9, var11);
      float var14 = MathHelper.func_76134_b(-var6 * 0.017453292F - 3.1415927F);
      float var15 = MathHelper.func_76126_a(-var6 * 0.017453292F - 3.1415927F);
      float var16 = -MathHelper.func_76134_b(-var5 * 0.017453292F);
      float var17 = MathHelper.func_76126_a(-var5 * 0.017453292F);
      float var18 = var15 * var16;
      float var20 = var14 * var16;
      double var21 = 5.0D;
      Vec3 var23 = var13.func_72441_c((double)var18 * var21, (double)var17 * var21, (double)var20 * var21);
      MovingObjectPosition var24 = p_77659_2_.func_72901_a(var13, var23, true);
      if(var24 == null) {
         return p_77659_1_;
      } else {
         Vec3 var25 = p_77659_3_.func_70676_i(var4);
         boolean var26 = false;
         float var27 = 1.0F;
         List var28 = p_77659_2_.func_72839_b(p_77659_3_, p_77659_3_.field_70121_D.func_72321_a(var25.field_72450_a * var21, var25.field_72448_b * var21, var25.field_72449_c * var21).func_72314_b((double)var27, (double)var27, (double)var27));
         Iterator var29 = var28.iterator();

         while(var29.hasNext()) {
            Entity var30 = (Entity)var29.next();
            if(var30.func_70067_L()) {
               float var31 = var30.func_70111_Y();
               AxisAlignedBB var32 = var30.field_70121_D.func_72314_b((double)var31, (double)var31, (double)var31);
               if(var32.func_72318_a(var13)) {
                  var26 = true;
               }
            }
         }

         if(var26) {
            return p_77659_1_;
         } else {
            if(var24.field_72313_a == EnumMovingObjectType.TILE) {
               int var35 = var24.field_72311_b;
               int var33 = var24.field_72312_c;
               int var34 = var24.field_72309_d;
               if(!p_77659_2_.field_72995_K) {
                  if(p_77659_2_.func_72798_a(var35, var33, var34) == Block.field_72037_aS.field_71990_ca) {
                     --var33;
                  }

                  p_77659_2_.func_72838_d(new EntityBoat(p_77659_2_, (double)((float)var35 + 0.5F), (double)((float)var33 + 1.0F), (double)((float)var34 + 0.5F)));
               }

               if(!p_77659_3_.field_71075_bZ.field_75098_d) {
                  --p_77659_1_.field_77994_a;
               }
            }

            return p_77659_1_;
         }
      }
   }
}
