package net.minecraft.src;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import net.minecraft.src.BiomeDecorator;
import net.minecraft.src.BiomeGenBeach;
import net.minecraft.src.BiomeGenDesert;
import net.minecraft.src.BiomeGenEnd;
import net.minecraft.src.BiomeGenForest;
import net.minecraft.src.BiomeGenHell;
import net.minecraft.src.BiomeGenHills;
import net.minecraft.src.BiomeGenJungle;
import net.minecraft.src.BiomeGenMushroomIsland;
import net.minecraft.src.BiomeGenOcean;
import net.minecraft.src.BiomeGenPlains;
import net.minecraft.src.BiomeGenRiver;
import net.minecraft.src.BiomeGenSnow;
import net.minecraft.src.BiomeGenSwamp;
import net.minecraft.src.BiomeGenTaiga;
import net.minecraft.src.Block;
import net.minecraft.src.EntityChicken;
import net.minecraft.src.EntityCow;
import net.minecraft.src.EntityCreeper;
import net.minecraft.src.EntityEnderman;
import net.minecraft.src.EntityPig;
import net.minecraft.src.EntitySheep;
import net.minecraft.src.EntitySkeleton;
import net.minecraft.src.EntitySlime;
import net.minecraft.src.EntitySpider;
import net.minecraft.src.EntitySquid;
import net.minecraft.src.EntityZombie;
import net.minecraft.src.EnumCreatureType;
import net.minecraft.src.SpawnListEntry;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenBigTree;
import net.minecraft.src.WorldGenForest;
import net.minecraft.src.WorldGenSwamp;
import net.minecraft.src.WorldGenTallGrass;
import net.minecraft.src.WorldGenTrees;
import net.minecraft.src.WorldGenerator;

public abstract class BiomeGenBase {

   public static final BiomeGenBase[] field_76773_a = new BiomeGenBase[256];
   public static final BiomeGenBase field_76771_b = (new BiomeGenOcean(0)).func_76739_b(112).func_76735_a("Ocean").func_76725_b(-1.0F, 0.4F);
   public static final BiomeGenBase field_76772_c = (new BiomeGenPlains(1)).func_76739_b(9286496).func_76735_a("Plains").func_76732_a(0.8F, 0.4F);
   public static final BiomeGenBase field_76769_d = (new BiomeGenDesert(2)).func_76739_b(16421912).func_76735_a("Desert").func_76745_m().func_76732_a(2.0F, 0.0F).func_76725_b(0.1F, 0.2F);
   public static final BiomeGenBase field_76770_e = (new BiomeGenHills(3)).func_76739_b(6316128).func_76735_a("Extreme Hills").func_76725_b(0.3F, 1.5F).func_76732_a(0.2F, 0.3F);
   public static final BiomeGenBase field_76767_f = (new BiomeGenForest(4)).func_76739_b(353825).func_76735_a("Forest").func_76733_a(5159473).func_76732_a(0.7F, 0.8F);
   public static final BiomeGenBase field_76768_g = (new BiomeGenTaiga(5)).func_76739_b(747097).func_76735_a("Taiga").func_76733_a(5159473).func_76742_b().func_76732_a(0.05F, 0.8F).func_76725_b(0.1F, 0.4F);
   public static final BiomeGenBase field_76780_h = (new BiomeGenSwamp(6)).func_76739_b(522674).func_76735_a("Swampland").func_76733_a(9154376).func_76725_b(-0.2F, 0.1F).func_76732_a(0.8F, 0.9F);
   public static final BiomeGenBase field_76781_i = (new BiomeGenRiver(7)).func_76739_b(255).func_76735_a("River").func_76725_b(-0.5F, 0.0F);
   public static final BiomeGenBase field_76778_j = (new BiomeGenHell(8)).func_76739_b(16711680).func_76735_a("Hell").func_76745_m().func_76732_a(2.0F, 0.0F);
   public static final BiomeGenBase field_76779_k = (new BiomeGenEnd(9)).func_76739_b(8421631).func_76735_a("Sky").func_76745_m();
   public static final BiomeGenBase field_76776_l = (new BiomeGenOcean(10)).func_76739_b(9474208).func_76735_a("FrozenOcean").func_76742_b().func_76725_b(-1.0F, 0.5F).func_76732_a(0.0F, 0.5F);
   public static final BiomeGenBase field_76777_m = (new BiomeGenRiver(11)).func_76739_b(10526975).func_76735_a("FrozenRiver").func_76742_b().func_76725_b(-0.5F, 0.0F).func_76732_a(0.0F, 0.5F);
   public static final BiomeGenBase field_76774_n = (new BiomeGenSnow(12)).func_76739_b(16777215).func_76735_a("Ice Plains").func_76742_b().func_76732_a(0.0F, 0.5F);
   public static final BiomeGenBase field_76775_o = (new BiomeGenSnow(13)).func_76739_b(10526880).func_76735_a("Ice Mountains").func_76742_b().func_76725_b(0.3F, 1.3F).func_76732_a(0.0F, 0.5F);
   public static final BiomeGenBase field_76789_p = (new BiomeGenMushroomIsland(14)).func_76739_b(16711935).func_76735_a("MushroomIsland").func_76732_a(0.9F, 1.0F).func_76725_b(0.2F, 1.0F);
   public static final BiomeGenBase field_76788_q = (new BiomeGenMushroomIsland(15)).func_76739_b(10486015).func_76735_a("MushroomIslandShore").func_76732_a(0.9F, 1.0F).func_76725_b(-1.0F, 0.1F);
   public static final BiomeGenBase field_76787_r = (new BiomeGenBeach(16)).func_76739_b(16440917).func_76735_a("Beach").func_76732_a(0.8F, 0.4F).func_76725_b(0.0F, 0.1F);
   public static final BiomeGenBase field_76786_s = (new BiomeGenDesert(17)).func_76739_b(13786898).func_76735_a("DesertHills").func_76745_m().func_76732_a(2.0F, 0.0F).func_76725_b(0.3F, 0.8F);
   public static final BiomeGenBase field_76785_t = (new BiomeGenForest(18)).func_76739_b(2250012).func_76735_a("ForestHills").func_76733_a(5159473).func_76732_a(0.7F, 0.8F).func_76725_b(0.3F, 0.7F);
   public static final BiomeGenBase field_76784_u = (new BiomeGenTaiga(19)).func_76739_b(1456435).func_76735_a("TaigaHills").func_76742_b().func_76733_a(5159473).func_76732_a(0.05F, 0.8F).func_76725_b(0.3F, 0.8F);
   public static final BiomeGenBase field_76783_v = (new BiomeGenHills(20)).func_76739_b(7501978).func_76735_a("Extreme Hills Edge").func_76725_b(0.2F, 0.8F).func_76732_a(0.2F, 0.3F);
   public static final BiomeGenBase field_76782_w = (new BiomeGenJungle(21)).func_76739_b(5470985).func_76735_a("Jungle").func_76733_a(5470985).func_76732_a(1.2F, 0.9F).func_76725_b(0.2F, 0.4F);
   public static final BiomeGenBase field_76792_x = (new BiomeGenJungle(22)).func_76739_b(2900485).func_76735_a("JungleHills").func_76733_a(5470985).func_76732_a(1.2F, 0.9F).func_76725_b(1.8F, 0.5F);
   public String field_76791_y;
   public int field_76790_z;
   public byte field_76752_A;
   public byte field_76753_B;
   public int field_76754_C;
   public float field_76748_D;
   public float field_76749_E;
   public float field_76750_F;
   public float field_76751_G;
   public int field_76759_H;
   public BiomeDecorator field_76760_I;
   protected List field_76761_J;
   protected List field_76762_K;
   protected List field_76755_L;
   private boolean field_76766_R;
   private boolean field_76765_S;
   public final int field_76756_M;
   protected WorldGenTrees field_76757_N;
   protected WorldGenBigTree field_76758_O;
   protected WorldGenForest field_76764_P;
   protected WorldGenSwamp field_76763_Q;


   protected BiomeGenBase(int p_i3747_1_) {
      this.field_76752_A = (byte)Block.field_71980_u.field_71990_ca;
      this.field_76753_B = (byte)Block.field_71979_v.field_71990_ca;
      this.field_76754_C = 5169201;
      this.field_76748_D = 0.1F;
      this.field_76749_E = 0.3F;
      this.field_76750_F = 0.5F;
      this.field_76751_G = 0.5F;
      this.field_76759_H = 16777215;
      this.field_76761_J = new ArrayList();
      this.field_76762_K = new ArrayList();
      this.field_76755_L = new ArrayList();
      this.field_76765_S = true;
      this.field_76757_N = new WorldGenTrees(false);
      this.field_76758_O = new WorldGenBigTree(false);
      this.field_76764_P = new WorldGenForest(false);
      this.field_76763_Q = new WorldGenSwamp();
      this.field_76756_M = p_i3747_1_;
      field_76773_a[p_i3747_1_] = this;
      this.field_76760_I = this.func_76729_a();
      this.field_76762_K.add(new SpawnListEntry(EntitySheep.class, 12, 4, 4));
      this.field_76762_K.add(new SpawnListEntry(EntityPig.class, 10, 4, 4));
      this.field_76762_K.add(new SpawnListEntry(EntityChicken.class, 10, 4, 4));
      this.field_76762_K.add(new SpawnListEntry(EntityCow.class, 8, 4, 4));
      this.field_76761_J.add(new SpawnListEntry(EntitySpider.class, 10, 4, 4));
      this.field_76761_J.add(new SpawnListEntry(EntityZombie.class, 10, 4, 4));
      this.field_76761_J.add(new SpawnListEntry(EntitySkeleton.class, 10, 4, 4));
      this.field_76761_J.add(new SpawnListEntry(EntityCreeper.class, 10, 4, 4));
      this.field_76761_J.add(new SpawnListEntry(EntitySlime.class, 10, 4, 4));
      this.field_76761_J.add(new SpawnListEntry(EntityEnderman.class, 1, 1, 4));
      this.field_76755_L.add(new SpawnListEntry(EntitySquid.class, 10, 4, 4));
   }

   protected BiomeDecorator func_76729_a() {
      return new BiomeDecorator(this);
   }

   private BiomeGenBase func_76732_a(float p_76732_1_, float p_76732_2_) {
      if(p_76732_1_ > 0.1F && p_76732_1_ < 0.2F) {
         throw new IllegalArgumentException("Please avoid temperatures in the range 0.1 - 0.2 because of snow");
      } else {
         this.field_76750_F = p_76732_1_;
         this.field_76751_G = p_76732_2_;
         return this;
      }
   }

   private BiomeGenBase func_76725_b(float p_76725_1_, float p_76725_2_) {
      this.field_76748_D = p_76725_1_;
      this.field_76749_E = p_76725_2_;
      return this;
   }

   private BiomeGenBase func_76745_m() {
      this.field_76765_S = false;
      return this;
   }

   public WorldGenerator func_76740_a(Random p_76740_1_) {
      return (WorldGenerator)(p_76740_1_.nextInt(10) == 0?this.field_76758_O:this.field_76757_N);
   }

   public WorldGenerator func_76730_b(Random p_76730_1_) {
      return new WorldGenTallGrass(Block.field_71962_X.field_71990_ca, 1);
   }

   protected BiomeGenBase func_76742_b() {
      this.field_76766_R = true;
      return this;
   }

   protected BiomeGenBase func_76735_a(String p_76735_1_) {
      this.field_76791_y = p_76735_1_;
      return this;
   }

   protected BiomeGenBase func_76733_a(int p_76733_1_) {
      this.field_76754_C = p_76733_1_;
      return this;
   }

   protected BiomeGenBase func_76739_b(int p_76739_1_) {
      this.field_76790_z = p_76739_1_;
      return this;
   }

   public List func_76747_a(EnumCreatureType p_76747_1_) {
      return p_76747_1_ == EnumCreatureType.monster?this.field_76761_J:(p_76747_1_ == EnumCreatureType.creature?this.field_76762_K:(p_76747_1_ == EnumCreatureType.waterCreature?this.field_76755_L:null));
   }

   public boolean func_76746_c() {
      return this.field_76766_R;
   }

   public boolean func_76738_d() {
      return this.field_76766_R?false:this.field_76765_S;
   }

   public boolean func_76736_e() {
      return this.field_76751_G > 0.85F;
   }

   public float func_76741_f() {
      return 0.1F;
   }

   public final int func_76744_g() {
      return (int)(this.field_76751_G * 65536.0F);
   }

   public final int func_76734_h() {
      return (int)(this.field_76750_F * 65536.0F);
   }

   public final float func_76743_j() {
      return this.field_76750_F;
   }

   public void func_76728_a(World p_76728_1_, Random p_76728_2_, int p_76728_3_, int p_76728_4_) {
      this.field_76760_I.func_76796_a(p_76728_1_, p_76728_2_, p_76728_3_, p_76728_4_);
   }

}
