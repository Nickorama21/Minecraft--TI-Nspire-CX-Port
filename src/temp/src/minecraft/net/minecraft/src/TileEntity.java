package net.minecraft.src;

import java.util.HashMap;
import java.util.Map;
import net.minecraft.src.Block;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.Packet;
import net.minecraft.src.TileEntityBrewingStand;
import net.minecraft.src.TileEntityChest;
import net.minecraft.src.TileEntityDispenser;
import net.minecraft.src.TileEntityEnchantmentTable;
import net.minecraft.src.TileEntityEndPortal;
import net.minecraft.src.TileEntityEnderChest;
import net.minecraft.src.TileEntityFurnace;
import net.minecraft.src.TileEntityMobSpawner;
import net.minecraft.src.TileEntityNote;
import net.minecraft.src.TileEntityPiston;
import net.minecraft.src.TileEntityRecordPlayer;
import net.minecraft.src.TileEntitySign;
import net.minecraft.src.World;

public class TileEntity {

   private static Map field_70326_a = new HashMap();
   private static Map field_70323_b = new HashMap();
   protected World field_70331_k;
   public int field_70329_l;
   public int field_70330_m;
   public int field_70327_n;
   protected boolean field_70328_o;
   public int field_70325_p = -1;
   public Block field_70324_q;


   private static void func_70306_a(Class p_70306_0_, String p_70306_1_) {
      if(field_70326_a.containsKey(p_70306_1_)) {
         throw new IllegalArgumentException("Duplicate id: " + p_70306_1_);
      } else {
         field_70326_a.put(p_70306_1_, p_70306_0_);
         field_70323_b.put(p_70306_0_, p_70306_1_);
      }
   }

   public World func_70314_l() {
      return this.field_70331_k;
   }

   public void func_70308_a(World p_70308_1_) {
      this.field_70331_k = p_70308_1_;
   }

   public boolean func_70309_m() {
      return this.field_70331_k != null;
   }

   public void func_70307_a(NBTTagCompound p_70307_1_) {
      this.field_70329_l = p_70307_1_.func_74762_e("x");
      this.field_70330_m = p_70307_1_.func_74762_e("y");
      this.field_70327_n = p_70307_1_.func_74762_e("z");
   }

   public void func_70310_b(NBTTagCompound p_70310_1_) {
      String var2 = (String)field_70323_b.get(this.getClass());
      if(var2 == null) {
         throw new RuntimeException(this.getClass() + " is missing a mapping! This is a bug!");
      } else {
         p_70310_1_.func_74778_a("id", var2);
         p_70310_1_.func_74768_a("x", this.field_70329_l);
         p_70310_1_.func_74768_a("y", this.field_70330_m);
         p_70310_1_.func_74768_a("z", this.field_70327_n);
      }
   }

   public void func_70316_g() {}

   public static TileEntity func_70317_c(NBTTagCompound p_70317_0_) {
      TileEntity var1 = null;

      try {
         Class var2 = (Class)field_70326_a.get(p_70317_0_.func_74779_i("id"));
         if(var2 != null) {
            var1 = (TileEntity)var2.newInstance();
         }
      } catch (Exception var3) {
         var3.printStackTrace();
      }

      if(var1 != null) {
         var1.func_70307_a(p_70317_0_);
      } else {
         System.out.println("Skipping TileEntity with id " + p_70317_0_.func_74779_i("id"));
      }

      return var1;
   }

   public int func_70322_n() {
      if(this.field_70325_p == -1) {
         this.field_70325_p = this.field_70331_k.func_72805_g(this.field_70329_l, this.field_70330_m, this.field_70327_n);
      }

      return this.field_70325_p;
   }

   public void func_70296_d() {
      if(this.field_70331_k != null) {
         this.field_70325_p = this.field_70331_k.func_72805_g(this.field_70329_l, this.field_70330_m, this.field_70327_n);
         this.field_70331_k.func_72944_b(this.field_70329_l, this.field_70330_m, this.field_70327_n, this);
      }

   }

   public double func_70318_a(double p_70318_1_, double p_70318_3_, double p_70318_5_) {
      double var7 = (double)this.field_70329_l + 0.5D - p_70318_1_;
      double var9 = (double)this.field_70330_m + 0.5D - p_70318_3_;
      double var11 = (double)this.field_70327_n + 0.5D - p_70318_5_;
      return var7 * var7 + var9 * var9 + var11 * var11;
   }

   public Block func_70311_o() {
      if(this.field_70324_q == null) {
         this.field_70324_q = Block.field_71973_m[this.field_70331_k.func_72798_a(this.field_70329_l, this.field_70330_m, this.field_70327_n)];
      }

      return this.field_70324_q;
   }

   public Packet func_70319_e() {
      return null;
   }

   public boolean func_70320_p() {
      return this.field_70328_o;
   }

   public void func_70313_j() {
      this.field_70328_o = true;
   }

   public void func_70312_q() {
      this.field_70328_o = false;
   }

   public void func_70315_b(int p_70315_1_, int p_70315_2_) {}

   public void func_70321_h() {
      this.field_70324_q = null;
      this.field_70325_p = -1;
   }

   static {
      func_70306_a(TileEntityFurnace.class, "Furnace");
      func_70306_a(TileEntityChest.class, "Chest");
      func_70306_a(TileEntityEnderChest.class, "EnderChest");
      func_70306_a(TileEntityRecordPlayer.class, "RecordPlayer");
      func_70306_a(TileEntityDispenser.class, "Trap");
      func_70306_a(TileEntitySign.class, "Sign");
      func_70306_a(TileEntityMobSpawner.class, "MobSpawner");
      func_70306_a(TileEntityNote.class, "Music");
      func_70306_a(TileEntityPiston.class, "Piston");
      func_70306_a(TileEntityBrewingStand.class, "Cauldron");
      func_70306_a(TileEntityEnchantmentTable.class, "EnchantTable");
      func_70306_a(TileEntityEndPortal.class, "Airportal");
   }
}
