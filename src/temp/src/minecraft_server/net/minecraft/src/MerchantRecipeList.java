package net.minecraft.src;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import net.minecraft.src.ItemStack;
import net.minecraft.src.MerchantRecipe;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.NBTTagList;
import net.minecraft.src.Packet;

public class MerchantRecipeList extends ArrayList {

   public MerchantRecipeList() {}

   public MerchantRecipeList(NBTTagCompound p_i3725_1_) {
      this.func_77201_a(p_i3725_1_);
   }

   public MerchantRecipe func_77203_a(ItemStack p_77203_1_, ItemStack p_77203_2_, int p_77203_3_) {
      if(p_77203_3_ > 0 && p_77203_3_ < this.size()) {
         MerchantRecipe var4 = (MerchantRecipe)this.get(p_77203_3_);
         if(p_77203_1_.field_77993_c == var4.func_77394_a().field_77993_c && (p_77203_2_ == null && !var4.func_77398_c() || var4.func_77398_c() && p_77203_2_ != null && var4.func_77396_b().field_77993_c == p_77203_2_.field_77993_c)) {
            if(p_77203_1_.field_77994_a >= var4.func_77394_a().field_77994_a && (!var4.func_77398_c() || p_77203_2_.field_77994_a >= var4.func_77396_b().field_77994_a)) {
               return var4;
            }

            return null;
         }
      }

      for(int var6 = 0; var6 < this.size(); ++var6) {
         MerchantRecipe var5 = (MerchantRecipe)this.get(var6);
         if(p_77203_1_.field_77993_c == var5.func_77394_a().field_77993_c && p_77203_1_.field_77994_a >= var5.func_77394_a().field_77994_a && (!var5.func_77398_c() && p_77203_2_ == null || var5.func_77398_c() && p_77203_2_ != null && var5.func_77396_b().field_77993_c == p_77203_2_.field_77993_c && p_77203_2_.field_77994_a >= var5.func_77396_b().field_77994_a)) {
            return var5;
         }
      }

      return null;
   }

   public void func_77205_a(MerchantRecipe p_77205_1_) {
      for(int var2 = 0; var2 < this.size(); ++var2) {
         MerchantRecipe var3 = (MerchantRecipe)this.get(var2);
         if(p_77205_1_.func_77393_a(var3)) {
            if(p_77205_1_.func_77391_b(var3)) {
               this.set(var2, p_77205_1_);
            }

            return;
         }
      }

      this.add(p_77205_1_);
   }

   public void func_77200_a(DataOutputStream p_77200_1_) throws IOException {
      p_77200_1_.writeByte((byte)(this.size() & 255));

      for(int var2 = 0; var2 < this.size(); ++var2) {
         MerchantRecipe var3 = (MerchantRecipe)this.get(var2);
         Packet.func_73270_a(var3.func_77394_a(), p_77200_1_);
         Packet.func_73270_a(var3.func_77397_d(), p_77200_1_);
         ItemStack var4 = var3.func_77396_b();
         p_77200_1_.writeBoolean(var4 != null);
         if(var4 != null) {
            Packet.func_73270_a(var4, p_77200_1_);
         }
      }

   }

   public void func_77201_a(NBTTagCompound p_77201_1_) {
      NBTTagList var2 = p_77201_1_.func_74761_m("Recipes");

      for(int var3 = 0; var3 < var2.func_74745_c(); ++var3) {
         NBTTagCompound var4 = (NBTTagCompound)var2.func_74743_b(var3);
         this.add(new MerchantRecipe(var4));
      }

   }

   public NBTTagCompound func_77202_a() {
      NBTTagCompound var1 = new NBTTagCompound();
      NBTTagList var2 = new NBTTagList("Recipes");

      for(int var3 = 0; var3 < this.size(); ++var3) {
         MerchantRecipe var4 = (MerchantRecipe)this.get(var3);
         var2.func_74742_a(var4.func_77395_g());
      }

      var1.func_74782_a("Recipes", var2);
      return var1;
   }
}
