package net.minecraft.src;

import java.io.File;
import java.net.SocketAddress;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;
import net.minecraft.server.MinecraftServer;
import net.minecraft.src.BanEntry;
import net.minecraft.src.BanList;
import net.minecraft.src.ChunkCoordinates;
import net.minecraft.src.DemoWorldManager;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EntityPlayerMP;
import net.minecraft.src.EnumGameType;
import net.minecraft.src.IPlayerFileData;
import net.minecraft.src.ItemInWorldManager;
import net.minecraft.src.MathHelper;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.NetServerHandler;
import net.minecraft.src.NetworkManager;
import net.minecraft.src.Packet;
import net.minecraft.src.Packet1Login;
import net.minecraft.src.Packet201PlayerInfo;
import net.minecraft.src.Packet202PlayerAbilities;
import net.minecraft.src.Packet3Chat;
import net.minecraft.src.Packet41EntityEffect;
import net.minecraft.src.Packet4UpdateTime;
import net.minecraft.src.Packet6SpawnPosition;
import net.minecraft.src.Packet70GameEvent;
import net.minecraft.src.Packet9Respawn;
import net.minecraft.src.PlayerManager;
import net.minecraft.src.PotionEffect;
import net.minecraft.src.Teleporter;
import net.minecraft.src.World;
import net.minecraft.src.WorldServer;

public abstract class ServerConfigurationManager {

   private static final SimpleDateFormat field_72403_e = new SimpleDateFormat("yyyy-MM-dd \'at\' HH:mm:ss z");
   public static final Logger field_72406_a = Logger.getLogger("Minecraft");
   private final MinecraftServer field_72400_f;
   public final List field_72404_b = new ArrayList();
   private final BanList field_72401_g = new BanList(new File("banned-players.txt"));
   private final BanList field_72413_h = new BanList(new File("banned-ips.txt"));
   private Set field_72414_i = new HashSet();
   private Set field_72411_j = new HashSet();
   private IPlayerFileData field_72412_k;
   private boolean field_72409_l;
   protected int field_72405_c;
   protected int field_72402_d;
   private EnumGameType field_72410_m;
   private boolean field_72407_n;
   private int field_72408_o = 0;


   public ServerConfigurationManager(MinecraftServer p_i3376_1_) {
      this.field_72400_f = p_i3376_1_;
      this.field_72401_g.func_73708_a(false);
      this.field_72413_h.func_73708_a(false);
      this.field_72405_c = 8;
   }

   public void func_72355_a(NetworkManager p_72355_1_, EntityPlayerMP p_72355_2_) {
      this.func_72380_a(p_72355_2_);
      p_72355_2_.func_70029_a(this.field_72400_f.func_71218_a(p_72355_2_.field_71093_bK));
      p_72355_2_.field_71134_c.func_73080_a((WorldServer)p_72355_2_.field_70170_p);
      String var3 = "local";
      if(p_72355_1_.func_74430_c() != null) {
         var3 = p_72355_1_.func_74430_c().toString();
      }

      field_72406_a.info(p_72355_2_.field_71092_bJ + "[" + var3 + "] logged in with entity id " + p_72355_2_.field_70157_k + " at (" + p_72355_2_.field_70165_t + ", " + p_72355_2_.field_70163_u + ", " + p_72355_2_.field_70161_v + ")");
      WorldServer var4 = this.field_72400_f.func_71218_a(p_72355_2_.field_71093_bK);
      ChunkCoordinates var5 = var4.func_72861_E();
      this.func_72381_a(p_72355_2_, (EntityPlayerMP)null, var4);
      NetServerHandler var6 = new NetServerHandler(this.field_72400_f, p_72355_1_, p_72355_2_);
      var6.func_72567_b(new Packet1Login(p_72355_2_.field_70157_k, var4.func_72912_H().func_76067_t(), p_72355_2_.field_71134_c.func_73081_b(), var4.func_72912_H().func_76093_s(), var4.field_73011_w.field_76574_g, var4.field_73013_u, var4.func_72800_K(), this.func_72352_l()));
      var6.func_72567_b(new Packet6SpawnPosition(var5.field_71574_a, var5.field_71572_b, var5.field_71573_c));
      var6.func_72567_b(new Packet202PlayerAbilities(p_72355_2_.field_71075_bZ));
      this.func_72354_b(p_72355_2_, var4);
      this.func_72384_a(new Packet3Chat("\u00a7e" + p_72355_2_.field_71092_bJ + " joined the game."));
      this.func_72377_c(p_72355_2_);
      var6.func_72569_a(p_72355_2_.field_70165_t, p_72355_2_.field_70163_u, p_72355_2_.field_70161_v, p_72355_2_.field_70177_z, p_72355_2_.field_70125_A);
      this.field_72400_f.func_71212_ac().func_71745_a(var6);
      var6.func_72567_b(new Packet4UpdateTime(var4.func_72820_D()));
      if(this.field_72400_f.func_71202_P().length() > 0) {
         p_72355_2_.func_71115_a(this.field_72400_f.func_71202_P(), this.field_72400_f.func_71227_R());
      }

      Iterator var7 = p_72355_2_.func_70651_bq().iterator();

      while(var7.hasNext()) {
         PotionEffect var8 = (PotionEffect)var7.next();
         var6.func_72567_b(new Packet41EntityEffect(p_72355_2_.field_70157_k, var8));
      }

      p_72355_2_.func_71116_b();
   }

   public void func_72364_a(WorldServer[] p_72364_1_) {
      this.field_72412_k = p_72364_1_[0].func_72860_G().func_75756_e();
   }

   public void func_72375_a(EntityPlayerMP p_72375_1_, WorldServer p_72375_2_) {
      WorldServer var3 = p_72375_1_.func_71121_q();
      if(p_72375_2_ != null) {
         p_72375_2_.func_73040_p().func_72695_c(p_72375_1_);
      }

      var3.func_73040_p().func_72683_a(p_72375_1_);
      var3.field_73059_b.func_73158_c((int)p_72375_1_.field_70165_t >> 4, (int)p_72375_1_.field_70161_v >> 4);
   }

   public int func_72372_a() {
      return PlayerManager.func_72686_a(this.func_72395_o());
   }

   public void func_72380_a(EntityPlayerMP p_72380_1_) {
      NBTTagCompound var2 = this.field_72400_f.field_71305_c[0].func_72912_H().func_76072_h();
      if(p_72380_1_.func_70005_c_().equals(this.field_72400_f.func_71214_G()) && var2 != null) {
         p_72380_1_.func_70020_e(var2);
      } else {
         this.field_72412_k.func_75752_b(p_72380_1_);
      }

   }

   protected void func_72391_b(EntityPlayerMP p_72391_1_) {
      this.field_72412_k.func_75753_a(p_72391_1_);
   }

   public void func_72377_c(EntityPlayerMP p_72377_1_) {
      this.func_72384_a(new Packet201PlayerInfo(p_72377_1_.field_71092_bJ, true, 1000));
      this.field_72404_b.add(p_72377_1_);
      WorldServer var2 = this.field_72400_f.func_71218_a(p_72377_1_.field_71093_bK);

      while(!var2.func_72945_a(p_72377_1_, p_72377_1_.field_70121_D).isEmpty()) {
         p_72377_1_.func_70107_b(p_72377_1_.field_70165_t, p_72377_1_.field_70163_u + 1.0D, p_72377_1_.field_70161_v);
      }

      var2.func_72838_d(p_72377_1_);
      this.func_72375_a(p_72377_1_, (WorldServer)null);
      Iterator var3 = this.field_72404_b.iterator();

      while(var3.hasNext()) {
         EntityPlayerMP var4 = (EntityPlayerMP)var3.next();
         p_72377_1_.field_71135_a.func_72567_b(new Packet201PlayerInfo(var4.field_71092_bJ, true, var4.field_71138_i));
      }

   }

   public void func_72358_d(EntityPlayerMP p_72358_1_) {
      p_72358_1_.func_71121_q().func_73040_p().func_72685_d(p_72358_1_);
   }

   public void func_72367_e(EntityPlayerMP p_72367_1_) {
      this.func_72391_b(p_72367_1_);
      WorldServer var2 = p_72367_1_.func_71121_q();
      var2.func_72900_e(p_72367_1_);
      var2.func_73040_p().func_72695_c(p_72367_1_);
      this.field_72404_b.remove(p_72367_1_);
      this.func_72384_a(new Packet201PlayerInfo(p_72367_1_.field_71092_bJ, false, 9999));
   }

   public String func_72399_a(SocketAddress p_72399_1_, String p_72399_2_) {
      if(this.field_72401_g.func_73704_a(p_72399_2_)) {
         BanEntry var6 = (BanEntry)this.field_72401_g.func_73712_c().get(p_72399_2_);
         String var7 = "You are banned from this server!\nReason: " + var6.func_73686_f();
         if(var6.func_73680_d() != null) {
            var7 = var7 + "\nYour ban will be removed on " + field_72403_e.format(var6.func_73680_d());
         }

         return var7;
      } else if(!this.func_72370_d(p_72399_2_)) {
         return "You are not white-listed on this server!";
      } else {
         String var3 = p_72399_1_.toString();
         var3 = var3.substring(var3.indexOf("/") + 1);
         var3 = var3.substring(0, var3.indexOf(":"));
         if(this.field_72413_h.func_73704_a(var3)) {
            BanEntry var4 = (BanEntry)this.field_72413_h.func_73712_c().get(var3);
            String var5 = "Your IP address is banned from this server!\nReason: " + var4.func_73686_f();
            if(var4.func_73680_d() != null) {
               var5 = var5 + "\nYour ban will be removed on " + field_72403_e.format(var4.func_73680_d());
            }

            return var5;
         } else {
            return this.field_72404_b.size() >= this.field_72405_c?"The server is full!":null;
         }
      }
   }

   public EntityPlayerMP func_72366_a(String p_72366_1_) {
      ArrayList var2 = new ArrayList();
      Iterator var3 = this.field_72404_b.iterator();

      EntityPlayerMP var4;
      while(var3.hasNext()) {
         var4 = (EntityPlayerMP)var3.next();
         if(var4.field_71092_bJ.equalsIgnoreCase(p_72366_1_)) {
            var2.add(var4);
         }
      }

      var3 = var2.iterator();

      while(var3.hasNext()) {
         var4 = (EntityPlayerMP)var3.next();
         var4.field_71135_a.func_72565_c("You logged in from another location");
      }

      Object var5;
      if(this.field_72400_f.func_71242_L()) {
         var5 = new DemoWorldManager(this.field_72400_f.func_71218_a(0));
      } else {
         var5 = new ItemInWorldManager(this.field_72400_f.func_71218_a(0));
      }

      return new EntityPlayerMP(this.field_72400_f, this.field_72400_f.func_71218_a(0), p_72366_1_, (ItemInWorldManager)var5);
   }

   public EntityPlayerMP func_72368_a(EntityPlayerMP p_72368_1_, int p_72368_2_, boolean p_72368_3_) {
      p_72368_1_.func_71121_q().func_73039_n().func_72787_a(p_72368_1_);
      p_72368_1_.func_71121_q().func_73039_n().func_72790_b(p_72368_1_);
      p_72368_1_.func_71121_q().func_73040_p().func_72695_c(p_72368_1_);
      this.field_72404_b.remove(p_72368_1_);
      this.field_72400_f.func_71218_a(p_72368_1_.field_71093_bK).func_72973_f(p_72368_1_);
      ChunkCoordinates var4 = p_72368_1_.func_70997_bJ();
      p_72368_1_.field_71093_bK = p_72368_2_;
      Object var5;
      if(this.field_72400_f.func_71242_L()) {
         var5 = new DemoWorldManager(this.field_72400_f.func_71218_a(p_72368_1_.field_71093_bK));
      } else {
         var5 = new ItemInWorldManager(this.field_72400_f.func_71218_a(p_72368_1_.field_71093_bK));
      }

      EntityPlayerMP var6 = new EntityPlayerMP(this.field_72400_f, this.field_72400_f.func_71218_a(p_72368_1_.field_71093_bK), p_72368_1_.field_71092_bJ, (ItemInWorldManager)var5);
      var6.func_71049_a(p_72368_1_, p_72368_3_);
      var6.field_70157_k = p_72368_1_.field_70157_k;
      var6.field_71135_a = p_72368_1_.field_71135_a;
      WorldServer var7 = this.field_72400_f.func_71218_a(p_72368_1_.field_71093_bK);
      this.func_72381_a(var6, p_72368_1_, var7);
      ChunkCoordinates var8;
      if(var4 != null) {
         var8 = EntityPlayer.func_71056_a(this.field_72400_f.func_71218_a(p_72368_1_.field_71093_bK), var4);
         if(var8 != null) {
            var6.func_70012_b((double)((float)var8.field_71574_a + 0.5F), (double)((float)var8.field_71572_b + 0.1F), (double)((float)var8.field_71573_c + 0.5F), 0.0F, 0.0F);
            var6.func_71063_a(var4);
         } else {
            var6.field_71135_a.func_72567_b(new Packet70GameEvent(0, 0));
         }
      }

      var7.field_73059_b.func_73158_c((int)var6.field_70165_t >> 4, (int)var6.field_70161_v >> 4);

      while(!var7.func_72945_a(var6, var6.field_70121_D).isEmpty()) {
         var6.func_70107_b(var6.field_70165_t, var6.field_70163_u + 1.0D, var6.field_70161_v);
      }

      var6.field_71135_a.func_72567_b(new Packet9Respawn(var6.field_71093_bK, (byte)var6.field_70170_p.field_73013_u, var6.field_70170_p.func_72912_H().func_76067_t(), var6.field_70170_p.func_72800_K(), var6.field_71134_c.func_73081_b()));
      var8 = var7.func_72861_E();
      var6.field_71135_a.func_72569_a(var6.field_70165_t, var6.field_70163_u, var6.field_70161_v, var6.field_70177_z, var6.field_70125_A);
      var6.field_71135_a.func_72567_b(new Packet6SpawnPosition(var8.field_71574_a, var8.field_71572_b, var8.field_71573_c));
      this.func_72354_b(var6, var7);
      var7.func_73040_p().func_72683_a(var6);
      var7.func_72838_d(var6);
      this.field_72404_b.add(var6);
      var6.func_71116_b();
      return var6;
   }

   public void func_72356_a(EntityPlayerMP p_72356_1_, int p_72356_2_) {
      int var3 = p_72356_1_.field_71093_bK;
      WorldServer var4 = this.field_72400_f.func_71218_a(p_72356_1_.field_71093_bK);
      p_72356_1_.field_71093_bK = p_72356_2_;
      WorldServer var5 = this.field_72400_f.func_71218_a(p_72356_1_.field_71093_bK);
      p_72356_1_.field_71135_a.func_72567_b(new Packet9Respawn(p_72356_1_.field_71093_bK, (byte)p_72356_1_.field_70170_p.field_73013_u, var5.func_72912_H().func_76067_t(), var5.func_72800_K(), p_72356_1_.field_71134_c.func_73081_b()));
      var4.func_72973_f(p_72356_1_);
      p_72356_1_.field_70128_L = false;
      double var6 = p_72356_1_.field_70165_t;
      double var8 = p_72356_1_.field_70161_v;
      double var10 = 8.0D;
      if(p_72356_1_.field_71093_bK == -1) {
         var6 /= var10;
         var8 /= var10;
         p_72356_1_.func_70012_b(var6, p_72356_1_.field_70163_u, var8, p_72356_1_.field_70177_z, p_72356_1_.field_70125_A);
         if(p_72356_1_.func_70089_S()) {
            var4.func_72866_a(p_72356_1_, false);
         }
      } else if(p_72356_1_.field_71093_bK == 0) {
         var6 *= var10;
         var8 *= var10;
         p_72356_1_.func_70012_b(var6, p_72356_1_.field_70163_u, var8, p_72356_1_.field_70177_z, p_72356_1_.field_70125_A);
         if(p_72356_1_.func_70089_S()) {
            var4.func_72866_a(p_72356_1_, false);
         }
      } else {
         ChunkCoordinates var12 = var5.func_73054_j();
         var6 = (double)var12.field_71574_a;
         p_72356_1_.field_70163_u = (double)var12.field_71572_b;
         var8 = (double)var12.field_71573_c;
         p_72356_1_.func_70012_b(var6, p_72356_1_.field_70163_u, var8, 90.0F, 0.0F);
         if(p_72356_1_.func_70089_S()) {
            var4.func_72866_a(p_72356_1_, false);
         }
      }

      if(var3 != 1) {
         var6 = (double)MathHelper.func_76125_a((int)var6, -29999872, 29999872);
         var8 = (double)MathHelper.func_76125_a((int)var8, -29999872, 29999872);
         if(p_72356_1_.func_70089_S()) {
            var5.func_72838_d(p_72356_1_);
            p_72356_1_.func_70012_b(var6, p_72356_1_.field_70163_u, var8, p_72356_1_.field_70177_z, p_72356_1_.field_70125_A);
            var5.func_72866_a(p_72356_1_, false);
            (new Teleporter()).func_77185_a(var5, p_72356_1_);
         }
      }

      p_72356_1_.func_70029_a(var5);
      this.func_72375_a(p_72356_1_, var4);
      p_72356_1_.field_71135_a.func_72569_a(p_72356_1_.field_70165_t, p_72356_1_.field_70163_u, p_72356_1_.field_70161_v, p_72356_1_.field_70177_z, p_72356_1_.field_70125_A);
      p_72356_1_.field_71134_c.func_73080_a(var5);
      this.func_72354_b(p_72356_1_, var5);
      this.func_72385_f(p_72356_1_);
      Iterator var14 = p_72356_1_.func_70651_bq().iterator();

      while(var14.hasNext()) {
         PotionEffect var13 = (PotionEffect)var14.next();
         p_72356_1_.field_71135_a.func_72567_b(new Packet41EntityEffect(p_72356_1_.field_70157_k, var13));
      }

   }

   public void func_72374_b() {
      if(++this.field_72408_o > 600) {
         this.field_72408_o = 0;
      }

      if(this.field_72408_o < this.field_72404_b.size()) {
         EntityPlayerMP var1 = (EntityPlayerMP)this.field_72404_b.get(this.field_72408_o);
         this.func_72384_a(new Packet201PlayerInfo(var1.field_71092_bJ, true, var1.field_71138_i));
      }

   }

   public void func_72384_a(Packet p_72384_1_) {
      for(int var2 = 0; var2 < this.field_72404_b.size(); ++var2) {
         ((EntityPlayerMP)this.field_72404_b.get(var2)).field_71135_a.func_72567_b(p_72384_1_);
      }

   }

   public void func_72396_a(Packet p_72396_1_, int p_72396_2_) {
      Iterator var3 = this.field_72404_b.iterator();

      while(var3.hasNext()) {
         EntityPlayerMP var4 = (EntityPlayerMP)var3.next();
         if(var4.field_71093_bK == p_72396_2_) {
            var4.field_71135_a.func_72567_b(p_72396_1_);
         }
      }

   }

   public String func_72398_c() {
      String var1 = "";

      for(int var2 = 0; var2 < this.field_72404_b.size(); ++var2) {
         if(var2 > 0) {
            var1 = var1 + ", ";
         }

         var1 = var1 + ((EntityPlayerMP)this.field_72404_b.get(var2)).field_71092_bJ;
      }

      return var1;
   }

   public String[] func_72369_d() {
      String[] var1 = new String[this.field_72404_b.size()];

      for(int var2 = 0; var2 < this.field_72404_b.size(); ++var2) {
         var1[var2] = ((EntityPlayerMP)this.field_72404_b.get(var2)).field_71092_bJ;
      }

      return var1;
   }

   public BanList func_72390_e() {
      return this.field_72401_g;
   }

   public BanList func_72363_f() {
      return this.field_72413_h;
   }

   public void func_72386_b(String p_72386_1_) {
      this.field_72414_i.add(p_72386_1_.toLowerCase());
   }

   public void func_72360_c(String p_72360_1_) {
      this.field_72414_i.remove(p_72360_1_.toLowerCase());
   }

   public boolean func_72370_d(String p_72370_1_) {
      p_72370_1_ = p_72370_1_.trim().toLowerCase();
      return !this.field_72409_l || this.field_72414_i.contains(p_72370_1_) || this.field_72411_j.contains(p_72370_1_);
   }

   public boolean func_72353_e(String p_72353_1_) {
      return this.field_72414_i.contains(p_72353_1_.trim().toLowerCase()) || this.field_72400_f.func_71264_H() && this.field_72400_f.field_71305_c[0].func_72912_H().func_76086_u() && this.field_72400_f.func_71214_G().equalsIgnoreCase(p_72353_1_) || this.field_72407_n;
   }

   public EntityPlayerMP func_72361_f(String p_72361_1_) {
      Iterator var2 = this.field_72404_b.iterator();

      EntityPlayerMP var3;
      do {
         if(!var2.hasNext()) {
            return null;
         }

         var3 = (EntityPlayerMP)var2.next();
      } while(!var3.field_71092_bJ.equalsIgnoreCase(p_72361_1_));

      return var3;
   }

   public void func_72393_a(double p_72393_1_, double p_72393_3_, double p_72393_5_, double p_72393_7_, int p_72393_9_, Packet p_72393_10_) {
      this.func_72397_a((EntityPlayer)null, p_72393_1_, p_72393_3_, p_72393_5_, p_72393_7_, p_72393_9_, p_72393_10_);
   }

   public void func_72397_a(EntityPlayer p_72397_1_, double p_72397_2_, double p_72397_4_, double p_72397_6_, double p_72397_8_, int p_72397_10_, Packet p_72397_11_) {
      Iterator var12 = this.field_72404_b.iterator();

      while(var12.hasNext()) {
         EntityPlayerMP var13 = (EntityPlayerMP)var12.next();
         if(var13 != p_72397_1_ && var13.field_71093_bK == p_72397_10_) {
            double var14 = p_72397_2_ - var13.field_70165_t;
            double var16 = p_72397_4_ - var13.field_70163_u;
            double var18 = p_72397_6_ - var13.field_70161_v;
            if(var14 * var14 + var16 * var16 + var18 * var18 < p_72397_8_ * p_72397_8_) {
               var13.field_71135_a.func_72567_b(p_72397_11_);
            }
         }
      }

   }

   public void func_72389_g() {
      Iterator var1 = this.field_72404_b.iterator();

      while(var1.hasNext()) {
         EntityPlayerMP var2 = (EntityPlayerMP)var1.next();
         this.func_72391_b(var2);
      }

   }

   public void func_72359_h(String p_72359_1_) {
      this.field_72411_j.add(p_72359_1_);
   }

   public void func_72379_i(String p_72379_1_) {
      this.field_72411_j.remove(p_72379_1_);
   }

   public Set func_72388_h() {
      return this.field_72411_j;
   }

   public Set func_72376_i() {
      return this.field_72414_i;
   }

   public void func_72362_j() {}

   public void func_72354_b(EntityPlayerMP p_72354_1_, WorldServer p_72354_2_) {
      p_72354_1_.field_71135_a.func_72567_b(new Packet4UpdateTime(p_72354_2_.func_72820_D()));
      if(p_72354_2_.func_72896_J()) {
         p_72354_1_.field_71135_a.func_72567_b(new Packet70GameEvent(1, 0));
      }

   }

   public void func_72385_f(EntityPlayerMP p_72385_1_) {
      p_72385_1_.func_71120_a(p_72385_1_.field_71069_bz);
      p_72385_1_.func_71118_n();
   }

   public int func_72394_k() {
      return this.field_72404_b.size();
   }

   public int func_72352_l() {
      return this.field_72405_c;
   }

   public String[] func_72373_m() {
      return this.field_72400_f.field_71305_c[0].func_72860_G().func_75756_e().func_75754_f();
   }

   public boolean func_72383_n() {
      return this.field_72409_l;
   }

   public void func_72371_a(boolean p_72371_1_) {
      this.field_72409_l = p_72371_1_;
   }

   public List func_72382_j(String p_72382_1_) {
      ArrayList var2 = new ArrayList();
      Iterator var3 = this.field_72404_b.iterator();

      while(var3.hasNext()) {
         EntityPlayerMP var4 = (EntityPlayerMP)var3.next();
         if(var4.func_71114_r().equals(p_72382_1_)) {
            var2.add(var4);
         }
      }

      return var2;
   }

   public int func_72395_o() {
      return this.field_72402_d;
   }

   public MinecraftServer func_72365_p() {
      return this.field_72400_f;
   }

   public NBTTagCompound func_72378_q() {
      return null;
   }

   public void func_72357_a(EnumGameType p_72357_1_) {
      this.field_72410_m = p_72357_1_;
   }

   private void func_72381_a(EntityPlayerMP p_72381_1_, EntityPlayerMP p_72381_2_, World p_72381_3_) {
      if(p_72381_2_ != null) {
         p_72381_1_.field_71134_c.func_73076_a(p_72381_2_.field_71134_c.func_73081_b());
      } else if(this.field_72410_m != null) {
         p_72381_1_.field_71134_c.func_73076_a(this.field_72410_m);
      }

      p_72381_1_.field_71134_c.func_73077_b(p_72381_3_.func_72912_H().func_76077_q());
   }

   public void func_72387_b(boolean p_72387_1_) {
      this.field_72407_n = p_72387_1_;
   }

   public void func_72392_r() {
      while(!this.field_72404_b.isEmpty()) {
         ((EntityPlayerMP)this.field_72404_b.get(0)).field_71135_a.func_72565_c("Server closed");
      }

   }

}
