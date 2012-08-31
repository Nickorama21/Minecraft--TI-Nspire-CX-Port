package net.minecraft.src;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.ChunkCoordinates;
import net.minecraft.src.EntityIronGolem;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityVillager;
import net.minecraft.src.MathHelper;
import net.minecraft.src.Vec3;
import net.minecraft.src.VillageAgressor;
import net.minecraft.src.VillageDoorInfo;
import net.minecraft.src.World;

public class Village {

   private final World field_75586_a;
   private final List field_75584_b = new ArrayList();
   private final ChunkCoordinates field_75585_c = new ChunkCoordinates(0, 0, 0);
   private final ChunkCoordinates field_75582_d = new ChunkCoordinates(0, 0, 0);
   private int field_75583_e = 0;
   private int field_75580_f = 0;
   private int field_75581_g = 0;
   private int field_75588_h = 0;
   private List field_75589_i = new ArrayList();
   private int field_75587_j = 0;


   public Village(World p_i3511_1_) {
      this.field_75586_a = p_i3511_1_;
   }

   public void func_75560_a(int p_75560_1_) {
      this.field_75581_g = p_75560_1_;
      this.func_75557_k();
      this.func_75565_j();
      if(p_75560_1_ % 20 == 0) {
         this.func_75572_i();
      }

      if(p_75560_1_ % 30 == 0) {
         this.func_75579_h();
      }

      int var2 = this.field_75588_h / 16;
      if(this.field_75587_j < var2 && this.field_75584_b.size() > 20 && this.field_75586_a.field_73012_v.nextInt(7000) == 0) {
         Vec3 var3 = this.func_75559_a(MathHelper.func_76141_d((float)this.field_75582_d.field_71574_a), MathHelper.func_76141_d((float)this.field_75582_d.field_71572_b), MathHelper.func_76141_d((float)this.field_75582_d.field_71573_c), 2, 4, 2);
         if(var3 != null) {
            EntityIronGolem var4 = new EntityIronGolem(this.field_75586_a);
            var4.func_70107_b(var3.field_72450_a, var3.field_72448_b, var3.field_72449_c);
            this.field_75586_a.func_72838_d(var4);
            ++this.field_75587_j;
         }
      }

   }

   private Vec3 func_75559_a(int p_75559_1_, int p_75559_2_, int p_75559_3_, int p_75559_4_, int p_75559_5_, int p_75559_6_) {
      for(int var7 = 0; var7 < 10; ++var7) {
         int var8 = p_75559_1_ + this.field_75586_a.field_73012_v.nextInt(16) - 8;
         int var9 = p_75559_2_ + this.field_75586_a.field_73012_v.nextInt(6) - 3;
         int var10 = p_75559_3_ + this.field_75586_a.field_73012_v.nextInt(16) - 8;
         if(this.func_75570_a(var8, var9, var10) && this.func_75563_b(var8, var9, var10, p_75559_4_, p_75559_5_, p_75559_6_)) {
            return Vec3.func_72437_a().func_72345_a((double)var8, (double)var9, (double)var10);
         }
      }

      return null;
   }

   private boolean func_75563_b(int p_75563_1_, int p_75563_2_, int p_75563_3_, int p_75563_4_, int p_75563_5_, int p_75563_6_) {
      if(!this.field_75586_a.func_72797_t(p_75563_1_, p_75563_2_ - 1, p_75563_3_)) {
         return false;
      } else {
         int var7 = p_75563_1_ - p_75563_4_ / 2;
         int var8 = p_75563_3_ - p_75563_6_ / 2;

         for(int var9 = var7; var9 < var7 + p_75563_4_; ++var9) {
            for(int var10 = p_75563_2_; var10 < p_75563_2_ + p_75563_5_; ++var10) {
               for(int var11 = var8; var11 < var8 + p_75563_6_; ++var11) {
                  if(this.field_75586_a.func_72809_s(var9, var10, var11)) {
                     return false;
                  }
               }
            }
         }

         return true;
      }
   }

   private void func_75579_h() {
      List var1 = this.field_75586_a.func_72872_a(EntityIronGolem.class, AxisAlignedBB.func_72332_a().func_72299_a((double)(this.field_75582_d.field_71574_a - this.field_75583_e), (double)(this.field_75582_d.field_71572_b - 4), (double)(this.field_75582_d.field_71573_c - this.field_75583_e), (double)(this.field_75582_d.field_71574_a + this.field_75583_e), (double)(this.field_75582_d.field_71572_b + 4), (double)(this.field_75582_d.field_71573_c + this.field_75583_e)));
      this.field_75587_j = var1.size();
   }

   private void func_75572_i() {
      List var1 = this.field_75586_a.func_72872_a(EntityVillager.class, AxisAlignedBB.func_72332_a().func_72299_a((double)(this.field_75582_d.field_71574_a - this.field_75583_e), (double)(this.field_75582_d.field_71572_b - 4), (double)(this.field_75582_d.field_71573_c - this.field_75583_e), (double)(this.field_75582_d.field_71574_a + this.field_75583_e), (double)(this.field_75582_d.field_71572_b + 4), (double)(this.field_75582_d.field_71573_c + this.field_75583_e)));
      this.field_75588_h = var1.size();
   }

   public ChunkCoordinates func_75577_a() {
      return this.field_75582_d;
   }

   public int func_75568_b() {
      return this.field_75583_e;
   }

   public int func_75567_c() {
      return this.field_75584_b.size();
   }

   public int func_75561_d() {
      return this.field_75581_g - this.field_75580_f;
   }

   public int func_75562_e() {
      return this.field_75588_h;
   }

   public boolean func_75570_a(int p_75570_1_, int p_75570_2_, int p_75570_3_) {
      return this.field_75582_d.func_71569_e(p_75570_1_, p_75570_2_, p_75570_3_) < (float)(this.field_75583_e * this.field_75583_e);
   }

   public List func_75558_f() {
      return this.field_75584_b;
   }

   public VillageDoorInfo func_75564_b(int p_75564_1_, int p_75564_2_, int p_75564_3_) {
      VillageDoorInfo var4 = null;
      int var5 = Integer.MAX_VALUE;
      Iterator var6 = this.field_75584_b.iterator();

      while(var6.hasNext()) {
         VillageDoorInfo var7 = (VillageDoorInfo)var6.next();
         int var8 = var7.func_75474_b(p_75564_1_, p_75564_2_, p_75564_3_);
         if(var8 < var5) {
            var4 = var7;
            var5 = var8;
         }
      }

      return var4;
   }

   public VillageDoorInfo func_75569_c(int p_75569_1_, int p_75569_2_, int p_75569_3_) {
      VillageDoorInfo var4 = null;
      int var5 = Integer.MAX_VALUE;
      Iterator var6 = this.field_75584_b.iterator();

      while(var6.hasNext()) {
         VillageDoorInfo var7 = (VillageDoorInfo)var6.next();
         int var8 = var7.func_75474_b(p_75569_1_, p_75569_2_, p_75569_3_);
         if(var8 > 256) {
            var8 *= 1000;
         } else {
            var8 = var7.func_75468_f();
         }

         if(var8 < var5) {
            var4 = var7;
            var5 = var8;
         }
      }

      return var4;
   }

   public VillageDoorInfo func_75578_e(int p_75578_1_, int p_75578_2_, int p_75578_3_) {
      if(this.field_75582_d.func_71569_e(p_75578_1_, p_75578_2_, p_75578_3_) > (float)(this.field_75583_e * this.field_75583_e)) {
         return null;
      } else {
         Iterator var4 = this.field_75584_b.iterator();

         VillageDoorInfo var5;
         do {
            if(!var4.hasNext()) {
               return null;
            }

            var5 = (VillageDoorInfo)var4.next();
         } while(var5.field_75481_a != p_75578_1_ || var5.field_75480_c != p_75578_3_ || Math.abs(var5.field_75479_b - p_75578_2_) > 1);

         return var5;
      }
   }

   public void func_75576_a(VillageDoorInfo p_75576_1_) {
      this.field_75584_b.add(p_75576_1_);
      this.field_75585_c.field_71574_a += p_75576_1_.field_75481_a;
      this.field_75585_c.field_71572_b += p_75576_1_.field_75479_b;
      this.field_75585_c.field_71573_c += p_75576_1_.field_75480_c;
      this.func_75573_l();
      this.field_75580_f = p_75576_1_.field_75475_f;
   }

   public boolean func_75566_g() {
      return this.field_75584_b.isEmpty();
   }

   public void func_75575_a(EntityLiving p_75575_1_) {
      Iterator var2 = this.field_75589_i.iterator();

      VillageAgressor var3;
      do {
         if(!var2.hasNext()) {
            this.field_75589_i.add(new VillageAgressor(this, p_75575_1_, this.field_75581_g));
            return;
         }

         var3 = (VillageAgressor)var2.next();
      } while(var3.field_75592_a != p_75575_1_);

      var3.field_75590_b = this.field_75581_g;
   }

   public EntityLiving func_75571_b(EntityLiving p_75571_1_) {
      double var2 = Double.MAX_VALUE;
      VillageAgressor var4 = null;
      Iterator var5 = this.field_75589_i.iterator();

      while(var5.hasNext()) {
         VillageAgressor var6 = (VillageAgressor)var5.next();
         double var7 = var6.field_75592_a.func_70068_e(p_75571_1_);
         if(var7 <= var2) {
            var4 = var6;
            var2 = var7;
         }
      }

      return var4 != null?var4.field_75592_a:null;
   }

   private void func_75565_j() {
      Iterator var1 = this.field_75589_i.iterator();

      while(var1.hasNext()) {
         VillageAgressor var2 = (VillageAgressor)var1.next();
         if(!var2.field_75592_a.func_70089_S() || Math.abs(this.field_75581_g - var2.field_75590_b) > 300) {
            var1.remove();
         }
      }

   }

   private void func_75557_k() {
      boolean var1 = false;
      boolean var2 = this.field_75586_a.field_73012_v.nextInt(50) == 0;
      Iterator var3 = this.field_75584_b.iterator();

      while(var3.hasNext()) {
         VillageDoorInfo var4 = (VillageDoorInfo)var3.next();
         if(var2) {
            var4.func_75466_d();
         }

         if(!this.func_75574_f(var4.field_75481_a, var4.field_75479_b, var4.field_75480_c) || Math.abs(this.field_75581_g - var4.field_75475_f) > 1200) {
            this.field_75585_c.field_71574_a -= var4.field_75481_a;
            this.field_75585_c.field_71572_b -= var4.field_75479_b;
            this.field_75585_c.field_71573_c -= var4.field_75480_c;
            var1 = true;
            var4.field_75476_g = true;
            var3.remove();
         }
      }

      if(var1) {
         this.func_75573_l();
      }

   }

   private boolean func_75574_f(int p_75574_1_, int p_75574_2_, int p_75574_3_) {
      int var4 = this.field_75586_a.func_72798_a(p_75574_1_, p_75574_2_, p_75574_3_);
      return var4 <= 0?false:var4 == Block.field_72054_aE.field_71990_ca;
   }

   private void func_75573_l() {
      int var1 = this.field_75584_b.size();
      if(var1 == 0) {
         this.field_75582_d.func_71571_b(0, 0, 0);
         this.field_75583_e = 0;
      } else {
         this.field_75582_d.func_71571_b(this.field_75585_c.field_71574_a / var1, this.field_75585_c.field_71572_b / var1, this.field_75585_c.field_71573_c / var1);
         int var2 = 0;

         VillageDoorInfo var4;
         for(Iterator var3 = this.field_75584_b.iterator(); var3.hasNext(); var2 = Math.max(var4.func_75474_b(this.field_75582_d.field_71574_a, this.field_75582_d.field_71572_b, this.field_75582_d.field_71573_c), var2)) {
            var4 = (VillageDoorInfo)var3.next();
         }

         this.field_75583_e = Math.max(32, (int)Math.sqrt((double)var2) + 1);
      }
   }
}
