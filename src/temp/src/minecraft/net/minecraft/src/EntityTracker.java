package net.minecraft.src;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityArrow;
import net.minecraft.src.EntityBoat;
import net.minecraft.src.EntityDragon;
import net.minecraft.src.EntityEgg;
import net.minecraft.src.EntityEnderCrystal;
import net.minecraft.src.EntityEnderEye;
import net.minecraft.src.EntityEnderPearl;
import net.minecraft.src.EntityExpBottle;
import net.minecraft.src.EntityFallingSand;
import net.minecraft.src.EntityFireball;
import net.minecraft.src.EntityFishHook;
import net.minecraft.src.EntityItem;
import net.minecraft.src.EntityMinecart;
import net.minecraft.src.EntityPainting;
import net.minecraft.src.EntityPlayerMP;
import net.minecraft.src.EntityPotion;
import net.minecraft.src.EntitySmallFireball;
import net.minecraft.src.EntitySnowball;
import net.minecraft.src.EntitySquid;
import net.minecraft.src.EntityTNTPrimed;
import net.minecraft.src.EntityTrackerEntry;
import net.minecraft.src.EntityXPOrb;
import net.minecraft.src.IAnimals;
import net.minecraft.src.IntHashMap;
import net.minecraft.src.Packet;
import net.minecraft.src.WorldServer;

public class EntityTracker {

   private final WorldServer field_72795_a;
   private Set field_72793_b = new HashSet();
   private IntHashMap field_72794_c = new IntHashMap();
   private int field_72792_d;


   public EntityTracker(WorldServer p_i3389_1_) {
      this.field_72795_a = p_i3389_1_;
      this.field_72792_d = p_i3389_1_.func_73046_m().func_71203_ab().func_72372_a();
   }

   public void func_72786_a(Entity p_72786_1_) {
      if(p_72786_1_ instanceof EntityPlayerMP) {
         this.func_72791_a(p_72786_1_, 512, 2);
         EntityPlayerMP var2 = (EntityPlayerMP)p_72786_1_;
         Iterator var3 = this.field_72793_b.iterator();

         while(var3.hasNext()) {
            EntityTrackerEntry var4 = (EntityTrackerEntry)var3.next();
            if(var4.field_73132_a != var2) {
               var4.func_73117_b(var2);
            }
         }
      } else if(p_72786_1_ instanceof EntityFishHook) {
         this.func_72785_a(p_72786_1_, 64, 5, true);
      } else if(p_72786_1_ instanceof EntityArrow) {
         this.func_72785_a(p_72786_1_, 64, 20, false);
      } else if(p_72786_1_ instanceof EntitySmallFireball) {
         this.func_72785_a(p_72786_1_, 64, 10, false);
      } else if(p_72786_1_ instanceof EntityFireball) {
         this.func_72785_a(p_72786_1_, 64, 10, false);
      } else if(p_72786_1_ instanceof EntitySnowball) {
         this.func_72785_a(p_72786_1_, 64, 10, true);
      } else if(p_72786_1_ instanceof EntityEnderPearl) {
         this.func_72785_a(p_72786_1_, 64, 10, true);
      } else if(p_72786_1_ instanceof EntityEnderEye) {
         this.func_72785_a(p_72786_1_, 64, 4, true);
      } else if(p_72786_1_ instanceof EntityEgg) {
         this.func_72785_a(p_72786_1_, 64, 10, true);
      } else if(p_72786_1_ instanceof EntityPotion) {
         this.func_72785_a(p_72786_1_, 64, 10, true);
      } else if(p_72786_1_ instanceof EntityExpBottle) {
         this.func_72785_a(p_72786_1_, 64, 10, true);
      } else if(p_72786_1_ instanceof EntityItem) {
         this.func_72785_a(p_72786_1_, 64, 20, true);
      } else if(p_72786_1_ instanceof EntityMinecart) {
         this.func_72785_a(p_72786_1_, 80, 3, true);
      } else if(p_72786_1_ instanceof EntityBoat) {
         this.func_72785_a(p_72786_1_, 80, 3, true);
      } else if(p_72786_1_ instanceof EntitySquid) {
         this.func_72785_a(p_72786_1_, 64, 3, true);
      } else if(p_72786_1_ instanceof IAnimals) {
         this.func_72785_a(p_72786_1_, 80, 3, true);
      } else if(p_72786_1_ instanceof EntityDragon) {
         this.func_72785_a(p_72786_1_, 160, 3, true);
      } else if(p_72786_1_ instanceof EntityTNTPrimed) {
         this.func_72785_a(p_72786_1_, 160, 10, true);
      } else if(p_72786_1_ instanceof EntityFallingSand) {
         this.func_72785_a(p_72786_1_, 160, 20, true);
      } else if(p_72786_1_ instanceof EntityPainting) {
         this.func_72785_a(p_72786_1_, 160, Integer.MAX_VALUE, false);
      } else if(p_72786_1_ instanceof EntityXPOrb) {
         this.func_72785_a(p_72786_1_, 160, 20, true);
      } else if(p_72786_1_ instanceof EntityEnderCrystal) {
         this.func_72785_a(p_72786_1_, 256, Integer.MAX_VALUE, false);
      }

   }

   public void func_72791_a(Entity p_72791_1_, int p_72791_2_, int p_72791_3_) {
      this.func_72785_a(p_72791_1_, p_72791_2_, p_72791_3_, false);
   }

   public void func_72785_a(Entity p_72785_1_, int p_72785_2_, int p_72785_3_, boolean p_72785_4_) {
      if(p_72785_2_ > this.field_72792_d) {
         p_72785_2_ = this.field_72792_d;
      }

      if(this.field_72794_c.func_76037_b(p_72785_1_.field_70157_k)) {
         throw new IllegalStateException("Entity is already tracked!");
      } else {
         EntityTrackerEntry var5 = new EntityTrackerEntry(p_72785_1_, p_72785_2_, p_72785_3_, p_72785_4_);
         this.field_72793_b.add(var5);
         this.field_72794_c.func_76038_a(p_72785_1_.field_70157_k, var5);
         var5.func_73125_b(this.field_72795_a.field_73010_i);
      }
   }

   public void func_72790_b(Entity p_72790_1_) {
      if(p_72790_1_ instanceof EntityPlayerMP) {
         EntityPlayerMP var2 = (EntityPlayerMP)p_72790_1_;
         Iterator var3 = this.field_72793_b.iterator();

         while(var3.hasNext()) {
            EntityTrackerEntry var4 = (EntityTrackerEntry)var3.next();
            var4.func_73118_a(var2);
         }
      }

      EntityTrackerEntry var5 = (EntityTrackerEntry)this.field_72794_c.func_76049_d(p_72790_1_.field_70157_k);
      if(var5 != null) {
         this.field_72793_b.remove(var5);
         var5.func_73119_a();
      }

   }

   public void func_72788_a() {
      ArrayList var1 = new ArrayList();
      Iterator var2 = this.field_72793_b.iterator();

      while(var2.hasNext()) {
         EntityTrackerEntry var3 = (EntityTrackerEntry)var2.next();
         var3.func_73122_a(this.field_72795_a.field_73010_i);
         if(var3.field_73133_n && var3.field_73132_a instanceof EntityPlayerMP) {
            var1.add((EntityPlayerMP)var3.field_73132_a);
         }
      }

      var2 = var1.iterator();

      while(var2.hasNext()) {
         EntityPlayerMP var7 = (EntityPlayerMP)var2.next();
         EntityPlayerMP var4 = var7;
         Iterator var5 = this.field_72793_b.iterator();

         while(var5.hasNext()) {
            EntityTrackerEntry var6 = (EntityTrackerEntry)var5.next();
            if(var6.field_73132_a != var4) {
               var6.func_73117_b(var4);
            }
         }
      }

   }

   public void func_72784_a(Entity p_72784_1_, Packet p_72784_2_) {
      EntityTrackerEntry var3 = (EntityTrackerEntry)this.field_72794_c.func_76041_a(p_72784_1_.field_70157_k);
      if(var3 != null) {
         var3.func_73120_a(p_72784_2_);
      }

   }

   public void func_72789_b(Entity p_72789_1_, Packet p_72789_2_) {
      EntityTrackerEntry var3 = (EntityTrackerEntry)this.field_72794_c.func_76041_a(p_72789_1_.field_70157_k);
      if(var3 != null) {
         var3.func_73116_b(p_72789_2_);
      }

   }

   public void func_72787_a(EntityPlayerMP p_72787_1_) {
      Iterator var2 = this.field_72793_b.iterator();

      while(var2.hasNext()) {
         EntityTrackerEntry var3 = (EntityTrackerEntry)var2.next();
         var3.func_73123_c(p_72787_1_);
      }

   }
}
