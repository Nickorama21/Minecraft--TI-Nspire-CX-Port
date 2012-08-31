package net.minecraft.src;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.src.Block;
import net.minecraft.src.Enchantment;
import net.minecraft.src.EnchantmentHelper;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EnumAction;
import net.minecraft.src.EnumRarity;
import net.minecraft.src.Item;
import net.minecraft.src.NBTBase;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.NBTTagList;
import net.minecraft.src.StatList;
import net.minecraft.src.World;

public final class ItemStack {

   public int field_77994_a;
   public int field_77992_b;
   public int field_77993_c;
   public NBTTagCompound field_77990_d;
   private int field_77991_e;


   public ItemStack(Block p_i3660_1_) {
      this(p_i3660_1_, 1);
   }

   public ItemStack(Block p_i3661_1_, int p_i3661_2_) {
      this(p_i3661_1_.field_71990_ca, p_i3661_2_, 0);
   }

   public ItemStack(Block p_i3662_1_, int p_i3662_2_, int p_i3662_3_) {
      this(p_i3662_1_.field_71990_ca, p_i3662_2_, p_i3662_3_);
   }

   public ItemStack(Item p_i3663_1_) {
      this(p_i3663_1_.field_77779_bT, 1, 0);
   }

   public ItemStack(Item p_i3664_1_, int p_i3664_2_) {
      this(p_i3664_1_.field_77779_bT, p_i3664_2_, 0);
   }

   public ItemStack(Item p_i3665_1_, int p_i3665_2_, int p_i3665_3_) {
      this(p_i3665_1_.field_77779_bT, p_i3665_2_, p_i3665_3_);
   }

   public ItemStack(int p_i3666_1_, int p_i3666_2_, int p_i3666_3_) {
      this.field_77994_a = 0;
      this.field_77993_c = p_i3666_1_;
      this.field_77994_a = p_i3666_2_;
      this.field_77991_e = p_i3666_3_;
   }

   public static ItemStack func_77949_a(NBTTagCompound p_77949_0_) {
      ItemStack var1 = new ItemStack();
      var1.func_77963_c(p_77949_0_);
      return var1.func_77973_b() != null?var1:null;
   }

   private ItemStack() {
      this.field_77994_a = 0;
   }

   public ItemStack func_77979_a(int p_77979_1_) {
      ItemStack var2 = new ItemStack(this.field_77993_c, p_77979_1_, this.field_77991_e);
      if(this.field_77990_d != null) {
         var2.field_77990_d = (NBTTagCompound)this.field_77990_d.func_74737_b();
      }

      this.field_77994_a -= p_77979_1_;
      return var2;
   }

   public Item func_77973_b() {
      return Item.field_77698_e[this.field_77993_c];
   }

   public int func_77954_c() {
      return this.func_77973_b().func_77650_f(this);
   }

   public boolean func_77943_a(EntityPlayer p_77943_1_, World p_77943_2_, int p_77943_3_, int p_77943_4_, int p_77943_5_, int p_77943_6_, float p_77943_7_, float p_77943_8_, float p_77943_9_) {
      boolean var10 = this.func_77973_b().func_77648_a(this, p_77943_1_, p_77943_2_, p_77943_3_, p_77943_4_, p_77943_5_, p_77943_6_, p_77943_7_, p_77943_8_, p_77943_9_);
      if(var10) {
         p_77943_1_.func_71064_a(StatList.field_75929_E[this.field_77993_c], 1);
      }

      return var10;
   }

   public float func_77967_a(Block p_77967_1_) {
      return this.func_77973_b().func_77638_a(this, p_77967_1_);
   }

   public ItemStack func_77957_a(World p_77957_1_, EntityPlayer p_77957_2_) {
      return this.func_77973_b().func_77659_a(this, p_77957_1_, p_77957_2_);
   }

   public ItemStack func_77950_b(World p_77950_1_, EntityPlayer p_77950_2_) {
      return this.func_77973_b().func_77654_b(this, p_77950_1_, p_77950_2_);
   }

   public NBTTagCompound func_77955_b(NBTTagCompound p_77955_1_) {
      p_77955_1_.func_74777_a("id", (short)this.field_77993_c);
      p_77955_1_.func_74774_a("Count", (byte)this.field_77994_a);
      p_77955_1_.func_74777_a("Damage", (short)this.field_77991_e);
      if(this.field_77990_d != null) {
         p_77955_1_.func_74782_a("tag", this.field_77990_d);
      }

      return p_77955_1_;
   }

   public void func_77963_c(NBTTagCompound p_77963_1_) {
      this.field_77993_c = p_77963_1_.func_74765_d("id");
      this.field_77994_a = p_77963_1_.func_74771_c("Count");
      this.field_77991_e = p_77963_1_.func_74765_d("Damage");
      if(p_77963_1_.func_74764_b("tag")) {
         this.field_77990_d = p_77963_1_.func_74775_l("tag");
      }

   }

   public int func_77976_d() {
      return this.func_77973_b().func_77639_j();
   }

   public boolean func_77985_e() {
      return this.func_77976_d() > 1 && (!this.func_77984_f() || !this.func_77951_h());
   }

   public boolean func_77984_f() {
      return Item.field_77698_e[this.field_77993_c].func_77612_l() > 0;
   }

   public boolean func_77981_g() {
      return Item.field_77698_e[this.field_77993_c].func_77614_k();
   }

   public boolean func_77951_h() {
      return this.func_77984_f() && this.field_77991_e > 0;
   }

   public int func_77952_i() {
      return this.field_77991_e;
   }

   public int func_77960_j() {
      return this.field_77991_e;
   }

   public void func_77964_b(int p_77964_1_) {
      this.field_77991_e = p_77964_1_;
   }

   public int func_77958_k() {
      return Item.field_77698_e[this.field_77993_c].func_77612_l();
   }

   public void func_77972_a(int p_77972_1_, EntityLiving p_77972_2_) {
      if(this.func_77984_f()) {
         if(p_77972_1_ > 0 && p_77972_2_ instanceof EntityPlayer) {
            int var3 = EnchantmentHelper.func_77503_c(((EntityPlayer)p_77972_2_).field_71071_by);
            if(var3 > 0 && p_77972_2_.field_70170_p.field_73012_v.nextInt(var3 + 1) > 0) {
               return;
            }
         }

         if(!(p_77972_2_ instanceof EntityPlayer) || !((EntityPlayer)p_77972_2_).field_71075_bZ.field_75098_d) {
            this.field_77991_e += p_77972_1_;
         }

         if(this.field_77991_e > this.func_77958_k()) {
            p_77972_2_.func_70669_a(this);
            if(p_77972_2_ instanceof EntityPlayer) {
               ((EntityPlayer)p_77972_2_).func_71064_a(StatList.field_75930_F[this.field_77993_c], 1);
            }

            --this.field_77994_a;
            if(this.field_77994_a < 0) {
               this.field_77994_a = 0;
            }

            this.field_77991_e = 0;
         }

      }
   }

   public void func_77961_a(EntityLiving p_77961_1_, EntityPlayer p_77961_2_) {
      boolean var3 = Item.field_77698_e[this.field_77993_c].func_77644_a(this, p_77961_1_, p_77961_2_);
      if(var3) {
         p_77961_2_.func_71064_a(StatList.field_75929_E[this.field_77993_c], 1);
      }

   }

   public void func_77941_a(World p_77941_1_, int p_77941_2_, int p_77941_3_, int p_77941_4_, int p_77941_5_, EntityPlayer p_77941_6_) {
      boolean var7 = Item.field_77698_e[this.field_77993_c].func_77660_a(this, p_77941_1_, p_77941_2_, p_77941_3_, p_77941_4_, p_77941_5_, p_77941_6_);
      if(var7) {
         p_77941_6_.func_71064_a(StatList.field_75929_E[this.field_77993_c], 1);
      }

   }

   public int func_77971_a(Entity p_77971_1_) {
      return Item.field_77698_e[this.field_77993_c].func_77649_a(p_77971_1_);
   }

   public boolean func_77987_b(Block p_77987_1_) {
      return Item.field_77698_e[this.field_77993_c].func_77641_a(p_77987_1_);
   }

   public boolean func_77947_a(EntityLiving p_77947_1_) {
      return Item.field_77698_e[this.field_77993_c].func_77646_a(this, p_77947_1_);
   }

   public ItemStack func_77946_l() {
      ItemStack var1 = new ItemStack(this.field_77993_c, this.field_77994_a, this.field_77991_e);
      if(this.field_77990_d != null) {
         var1.field_77990_d = (NBTTagCompound)this.field_77990_d.func_74737_b();
      }

      return var1;
   }

   public static boolean func_77970_a(ItemStack p_77970_0_, ItemStack p_77970_1_) {
      return p_77970_0_ == null && p_77970_1_ == null?true:(p_77970_0_ != null && p_77970_1_ != null?(p_77970_0_.field_77990_d == null && p_77970_1_.field_77990_d != null?false:p_77970_0_.field_77990_d == null || p_77970_0_.field_77990_d.equals(p_77970_1_.field_77990_d)):false);
   }

   public static boolean func_77989_b(ItemStack p_77989_0_, ItemStack p_77989_1_) {
      return p_77989_0_ == null && p_77989_1_ == null?true:(p_77989_0_ != null && p_77989_1_ != null?p_77989_0_.func_77959_d(p_77989_1_):false);
   }

   private boolean func_77959_d(ItemStack p_77959_1_) {
      return this.field_77994_a != p_77959_1_.field_77994_a?false:(this.field_77993_c != p_77959_1_.field_77993_c?false:(this.field_77991_e != p_77959_1_.field_77991_e?false:(this.field_77990_d == null && p_77959_1_.field_77990_d != null?false:this.field_77990_d == null || this.field_77990_d.equals(p_77959_1_.field_77990_d))));
   }

   public boolean func_77969_a(ItemStack p_77969_1_) {
      return this.field_77993_c == p_77969_1_.field_77993_c && this.field_77991_e == p_77969_1_.field_77991_e;
   }

   public String func_77977_a() {
      return Item.field_77698_e[this.field_77993_c].func_77667_c(this);
   }

   public static ItemStack func_77944_b(ItemStack p_77944_0_) {
      return p_77944_0_ == null?null:p_77944_0_.func_77946_l();
   }

   public String toString() {
      return this.field_77994_a + "x" + Item.field_77698_e[this.field_77993_c].func_77658_a() + "@" + this.field_77991_e;
   }

   public void func_77945_a(World p_77945_1_, Entity p_77945_2_, int p_77945_3_, boolean p_77945_4_) {
      if(this.field_77992_b > 0) {
         --this.field_77992_b;
      }

      Item.field_77698_e[this.field_77993_c].func_77663_a(this, p_77945_1_, p_77945_2_, p_77945_3_, p_77945_4_);
   }

   public void func_77980_a(World p_77980_1_, EntityPlayer p_77980_2_, int p_77980_3_) {
      p_77980_2_.func_71064_a(StatList.field_75928_D[this.field_77993_c], p_77980_3_);
      Item.field_77698_e[this.field_77993_c].func_77622_d(this, p_77980_1_, p_77980_2_);
   }

   public boolean func_77965_c(ItemStack p_77965_1_) {
      return this.field_77993_c == p_77965_1_.field_77993_c && this.field_77994_a == p_77965_1_.field_77994_a && this.field_77991_e == p_77965_1_.field_77991_e;
   }

   public int func_77988_m() {
      return this.func_77973_b().func_77626_a(this);
   }

   public EnumAction func_77975_n() {
      return this.func_77973_b().func_77661_b(this);
   }

   public void func_77974_b(World p_77974_1_, EntityPlayer p_77974_2_, int p_77974_3_) {
      this.func_77973_b().func_77615_a(this, p_77974_1_, p_77974_2_, p_77974_3_);
   }

   public boolean func_77942_o() {
      return this.field_77990_d != null;
   }

   public NBTTagCompound func_77978_p() {
      return this.field_77990_d;
   }

   public NBTTagList func_77986_q() {
      return this.field_77990_d == null?null:(NBTTagList)this.field_77990_d.func_74781_a("ench");
   }

   public void func_77982_d(NBTTagCompound p_77982_1_) {
      this.field_77990_d = p_77982_1_;
   }

   public List func_77968_r() {
      ArrayList var1 = new ArrayList();
      Item var2 = Item.field_77698_e[this.field_77993_c];
      var1.add(var2.func_77628_j(this));
      var2.func_77624_a(this, var1);
      if(this.func_77942_o()) {
         NBTTagList var3 = this.func_77986_q();
         if(var3 != null) {
            for(int var4 = 0; var4 < var3.func_74745_c(); ++var4) {
               short var5 = ((NBTTagCompound)var3.func_74743_b(var4)).func_74765_d("id");
               short var6 = ((NBTTagCompound)var3.func_74743_b(var4)).func_74765_d("lvl");
               if(Enchantment.field_77331_b[var5] != null) {
                  var1.add(Enchantment.field_77331_b[var5].func_77316_c(var6));
               }
            }
         }
      }

      return var1;
   }

   public boolean func_77962_s() {
      return this.func_77973_b().func_77636_d(this);
   }

   public EnumRarity func_77953_t() {
      return this.func_77973_b().func_77613_e(this);
   }

   public boolean func_77956_u() {
      return !this.func_77973_b().func_77616_k(this)?false:!this.func_77948_v();
   }

   public void func_77966_a(Enchantment p_77966_1_, int p_77966_2_) {
      if(this.field_77990_d == null) {
         this.func_77982_d(new NBTTagCompound());
      }

      if(!this.field_77990_d.func_74764_b("ench")) {
         this.field_77990_d.func_74782_a("ench", new NBTTagList("ench"));
      }

      NBTTagList var3 = (NBTTagList)this.field_77990_d.func_74781_a("ench");
      NBTTagCompound var4 = new NBTTagCompound();
      var4.func_74777_a("id", (short)p_77966_1_.field_77352_x);
      var4.func_74777_a("lvl", (short)((byte)p_77966_2_));
      var3.func_74742_a(var4);
   }

   public boolean func_77948_v() {
      return this.field_77990_d != null && this.field_77990_d.func_74764_b("ench");
   }

   public void func_77983_a(String p_77983_1_, NBTBase p_77983_2_) {
      if(this.field_77990_d == null) {
         this.func_77982_d(new NBTTagCompound());
      }

      this.field_77990_d.func_74782_a(p_77983_1_, p_77983_2_);
   }
}
