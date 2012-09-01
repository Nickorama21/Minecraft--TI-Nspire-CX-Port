package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EnumAction;
import net.minecraft.src.EnumArmorMaterial;
import net.minecraft.src.EnumToolMaterial;
import net.minecraft.src.ItemAppleGold;
import net.minecraft.src.ItemArmor;
import net.minecraft.src.ItemAxe;
import net.minecraft.src.ItemBed;
import net.minecraft.src.ItemBoat;
import net.minecraft.src.ItemBow;
import net.minecraft.src.ItemBucket;
import net.minecraft.src.ItemBucketMilk;
import net.minecraft.src.ItemCoal;
import net.minecraft.src.ItemDoor;
import net.minecraft.src.ItemDye;
import net.minecraft.src.ItemEditableBook;
import net.minecraft.src.ItemEgg;
import net.minecraft.src.ItemEnderEye;
import net.minecraft.src.ItemEnderPearl;
import net.minecraft.src.ItemExpBottle;
import net.minecraft.src.ItemFireball;
import net.minecraft.src.ItemFishingRod;
import net.minecraft.src.ItemFlintAndSteel;
import net.minecraft.src.ItemFood;
import net.minecraft.src.ItemGlassBottle;
import net.minecraft.src.ItemHoe;
import net.minecraft.src.ItemMap;
import net.minecraft.src.ItemMinecart;
import net.minecraft.src.ItemMonsterPlacer;
import net.minecraft.src.ItemPainting;
import net.minecraft.src.ItemPickaxe;
import net.minecraft.src.ItemPotion;
import net.minecraft.src.ItemRecord;
import net.minecraft.src.ItemRedstone;
import net.minecraft.src.ItemReed;
import net.minecraft.src.ItemSaddle;
import net.minecraft.src.ItemSeeds;
import net.minecraft.src.ItemShears;
import net.minecraft.src.ItemSign;
import net.minecraft.src.ItemSnowball;
import net.minecraft.src.ItemSoup;
import net.minecraft.src.ItemSpade;
import net.minecraft.src.ItemStack;
import net.minecraft.src.ItemSword;
import net.minecraft.src.ItemWritableBook;
import net.minecraft.src.Material;
import net.minecraft.src.MathHelper;
import net.minecraft.src.MovingObjectPosition;
import net.minecraft.src.Potion;
import net.minecraft.src.PotionHelper;
import net.minecraft.src.StatCollector;
import net.minecraft.src.StatList;
import net.minecraft.src.Vec3;
import net.minecraft.src.World;

public class Item {

   private CreativeTabs field_77701_a = null;
   protected static Random field_77697_d = new Random();
   public static Item[] field_77698_e = new Item[32000];
   public static Item field_77695_f = (new ItemSpade(0, EnumToolMaterial.IRON)).func_77652_b(2, 5).func_77655_b("shovelIron");
   public static Item field_77696_g = (new ItemPickaxe(1, EnumToolMaterial.IRON)).func_77652_b(2, 6).func_77655_b("pickaxeIron");
   public static Item field_77708_h = (new ItemAxe(2, EnumToolMaterial.IRON)).func_77652_b(2, 7).func_77655_b("hatchetIron");
   public static Item field_77709_i = (new ItemFlintAndSteel(3)).func_77652_b(5, 0).func_77655_b("flintAndSteel");
   public static Item field_77706_j = (new ItemFood(4, 4, 0.3F, false)).func_77652_b(10, 0).func_77655_b("apple");
   public static Item field_77707_k = (new ItemBow(5)).func_77652_b(5, 1).func_77655_b("bow");
   public static Item field_77704_l = (new Item(6)).func_77652_b(5, 2).func_77655_b("arrow").func_77637_a(CreativeTabs.field_78037_j);
   public static Item field_77705_m = (new ItemCoal(7)).func_77652_b(7, 0).func_77655_b("coal");
   public static Item field_77702_n = (new Item(8)).func_77652_b(7, 3).func_77655_b("diamond").func_77637_a(CreativeTabs.field_78035_l);
   public static Item field_77703_o = (new Item(9)).func_77652_b(7, 1).func_77655_b("ingotIron").func_77637_a(CreativeTabs.field_78035_l);
   public static Item field_77717_p = (new Item(10)).func_77652_b(7, 2).func_77655_b("ingotGold").func_77637_a(CreativeTabs.field_78035_l);
   public static Item field_77716_q = (new ItemSword(11, EnumToolMaterial.IRON)).func_77652_b(2, 4).func_77655_b("swordIron");
   public static Item field_77715_r = (new ItemSword(12, EnumToolMaterial.WOOD)).func_77652_b(0, 4).func_77655_b("swordWood");
   public static Item field_77714_s = (new ItemSpade(13, EnumToolMaterial.WOOD)).func_77652_b(0, 5).func_77655_b("shovelWood");
   public static Item field_77713_t = (new ItemPickaxe(14, EnumToolMaterial.WOOD)).func_77652_b(0, 6).func_77655_b("pickaxeWood");
   public static Item field_77712_u = (new ItemAxe(15, EnumToolMaterial.WOOD)).func_77652_b(0, 7).func_77655_b("hatchetWood");
   public static Item field_77711_v = (new ItemSword(16, EnumToolMaterial.STONE)).func_77652_b(1, 4).func_77655_b("swordStone");
   public static Item field_77710_w = (new ItemSpade(17, EnumToolMaterial.STONE)).func_77652_b(1, 5).func_77655_b("shovelStone");
   public static Item field_77720_x = (new ItemPickaxe(18, EnumToolMaterial.STONE)).func_77652_b(1, 6).func_77655_b("pickaxeStone");
   public static Item field_77719_y = (new ItemAxe(19, EnumToolMaterial.STONE)).func_77652_b(1, 7).func_77655_b("hatchetStone");
   public static Item field_77718_z = (new ItemSword(20, EnumToolMaterial.EMERALD)).func_77652_b(3, 4).func_77655_b("swordDiamond");
   public static Item field_77673_A = (new ItemSpade(21, EnumToolMaterial.EMERALD)).func_77652_b(3, 5).func_77655_b("shovelDiamond");
   public static Item field_77674_B = (new ItemPickaxe(22, EnumToolMaterial.EMERALD)).func_77652_b(3, 6).func_77655_b("pickaxeDiamond");
   public static Item field_77675_C = (new ItemAxe(23, EnumToolMaterial.EMERALD)).func_77652_b(3, 7).func_77655_b("hatchetDiamond");
   public static Item field_77669_D = (new Item(24)).func_77652_b(5, 3).func_77664_n().func_77655_b("stick").func_77637_a(CreativeTabs.field_78035_l);
   public static Item field_77670_E = (new Item(25)).func_77652_b(7, 4).func_77655_b("bowl").func_77637_a(CreativeTabs.field_78035_l);
   public static Item field_77671_F = (new ItemSoup(26, 8)).func_77652_b(8, 4).func_77655_b("mushroomStew");
   public static Item field_77672_G = (new ItemSword(27, EnumToolMaterial.GOLD)).func_77652_b(4, 4).func_77655_b("swordGold");
   public static Item field_77680_H = (new ItemSpade(28, EnumToolMaterial.GOLD)).func_77652_b(4, 5).func_77655_b("shovelGold");
   public static Item field_77681_I = (new ItemPickaxe(29, EnumToolMaterial.GOLD)).func_77652_b(4, 6).func_77655_b("pickaxeGold");
   public static Item field_77682_J = (new ItemAxe(30, EnumToolMaterial.GOLD)).func_77652_b(4, 7).func_77655_b("hatchetGold");
   public static Item field_77683_K = (new ItemReed(31, Block.field_72062_bU)).func_77652_b(8, 0).func_77655_b("string").func_77637_a(CreativeTabs.field_78035_l);
   public static Item field_77676_L = (new Item(32)).func_77652_b(8, 1).func_77655_b("feather").func_77637_a(CreativeTabs.field_78035_l);
   public static Item field_77677_M = (new Item(33)).func_77652_b(8, 2).func_77655_b("sulphur").func_77631_c(PotionHelper.field_77930_k).func_77637_a(CreativeTabs.field_78035_l);
   public static Item field_77678_N = (new ItemHoe(34, EnumToolMaterial.WOOD)).func_77652_b(0, 8).func_77655_b("hoeWood");
   public static Item field_77679_O = (new ItemHoe(35, EnumToolMaterial.STONE)).func_77652_b(1, 8).func_77655_b("hoeStone");
   public static Item field_77689_P = (new ItemHoe(36, EnumToolMaterial.IRON)).func_77652_b(2, 8).func_77655_b("hoeIron");
   public static Item field_77688_Q = (new ItemHoe(37, EnumToolMaterial.EMERALD)).func_77652_b(3, 8).func_77655_b("hoeDiamond");
   public static Item field_77691_R = (new ItemHoe(38, EnumToolMaterial.GOLD)).func_77652_b(4, 8).func_77655_b("hoeGold");
   public static Item field_77690_S = (new ItemSeeds(39, Block.field_72058_az.field_71990_ca, Block.field_72050_aA.field_71990_ca)).func_77652_b(9, 0).func_77655_b("seeds");
   public static Item field_77685_T = (new Item(40)).func_77652_b(9, 1).func_77655_b("wheat").func_77637_a(CreativeTabs.field_78035_l);
   public static Item field_77684_U = (new ItemFood(41, 5, 0.6F, false)).func_77652_b(9, 2).func_77655_b("bread");
   public static Item field_77687_V = (new ItemArmor(42, EnumArmorMaterial.CLOTH, 0, 0)).func_77652_b(0, 0).func_77655_b("helmetCloth");
   public static Item field_77686_W = (new ItemArmor(43, EnumArmorMaterial.CLOTH, 0, 1)).func_77652_b(0, 1).func_77655_b("chestplateCloth");
   public static Item field_77693_X = (new ItemArmor(44, EnumArmorMaterial.CLOTH, 0, 2)).func_77652_b(0, 2).func_77655_b("leggingsCloth");
   public static Item field_77692_Y = (new ItemArmor(45, EnumArmorMaterial.CLOTH, 0, 3)).func_77652_b(0, 3).func_77655_b("bootsCloth");
   public static Item field_77694_Z = (new ItemArmor(46, EnumArmorMaterial.CHAIN, 1, 0)).func_77652_b(1, 0).func_77655_b("helmetChain");
   public static Item field_77814_aa = (new ItemArmor(47, EnumArmorMaterial.CHAIN, 1, 1)).func_77652_b(1, 1).func_77655_b("chestplateChain");
   public static Item field_77816_ab = (new ItemArmor(48, EnumArmorMaterial.CHAIN, 1, 2)).func_77652_b(1, 2).func_77655_b("leggingsChain");
   public static Item field_77810_ac = (new ItemArmor(49, EnumArmorMaterial.CHAIN, 1, 3)).func_77652_b(1, 3).func_77655_b("bootsChain");
   public static Item field_77812_ad = (new ItemArmor(50, EnumArmorMaterial.IRON, 2, 0)).func_77652_b(2, 0).func_77655_b("helmetIron");
   public static Item field_77822_ae = (new ItemArmor(51, EnumArmorMaterial.IRON, 2, 1)).func_77652_b(2, 1).func_77655_b("chestplateIron");
   public static Item field_77824_af = (new ItemArmor(52, EnumArmorMaterial.IRON, 2, 2)).func_77652_b(2, 2).func_77655_b("leggingsIron");
   public static Item field_77818_ag = (new ItemArmor(53, EnumArmorMaterial.IRON, 2, 3)).func_77652_b(2, 3).func_77655_b("bootsIron");
   public static Item field_77820_ah = (new ItemArmor(54, EnumArmorMaterial.DIAMOND, 3, 0)).func_77652_b(3, 0).func_77655_b("helmetDiamond");
   public static Item field_77798_ai = (new ItemArmor(55, EnumArmorMaterial.DIAMOND, 3, 1)).func_77652_b(3, 1).func_77655_b("chestplateDiamond");
   public static Item field_77800_aj = (new ItemArmor(56, EnumArmorMaterial.DIAMOND, 3, 2)).func_77652_b(3, 2).func_77655_b("leggingsDiamond");
   public static Item field_77794_ak = (new ItemArmor(57, EnumArmorMaterial.DIAMOND, 3, 3)).func_77652_b(3, 3).func_77655_b("bootsDiamond");
   public static Item field_77796_al = (new ItemArmor(58, EnumArmorMaterial.GOLD, 4, 0)).func_77652_b(4, 0).func_77655_b("helmetGold");
   public static Item field_77806_am = (new ItemArmor(59, EnumArmorMaterial.GOLD, 4, 1)).func_77652_b(4, 1).func_77655_b("chestplateGold");
   public static Item field_77808_an = (new ItemArmor(60, EnumArmorMaterial.GOLD, 4, 2)).func_77652_b(4, 2).func_77655_b("leggingsGold");
   public static Item field_77802_ao = (new ItemArmor(61, EnumArmorMaterial.GOLD, 4, 3)).func_77652_b(4, 3).func_77655_b("bootsGold");
   public static Item field_77804_ap = (new Item(62)).func_77652_b(6, 0).func_77655_b("flint").func_77637_a(CreativeTabs.field_78035_l);
   public static Item field_77784_aq = (new ItemFood(63, 3, 0.3F, true)).func_77652_b(7, 5).func_77655_b("porkchopRaw");
   public static Item field_77782_ar = (new ItemFood(64, 8, 0.8F, true)).func_77652_b(8, 5).func_77655_b("porkchopCooked");
   public static Item field_77780_as = (new ItemPainting(65)).func_77652_b(10, 1).func_77655_b("painting");
   public static Item field_77778_at = (new ItemAppleGold(66, 4, 1.2F, false)).func_77848_i().func_77844_a(Potion.field_76428_l.field_76415_H, 5, 0, 1.0F).func_77652_b(11, 0).func_77655_b("appleGold");
   public static Item field_77792_au = (new ItemSign(67)).func_77652_b(10, 2).func_77655_b("sign");
   public static Item field_77790_av = (new ItemDoor(68, Material.field_76245_d)).func_77652_b(11, 2).func_77655_b("doorWood");
   public static Item field_77788_aw = (new ItemBucket(69, 0)).func_77652_b(10, 4).func_77655_b("bucket").func_77625_d(16);
   public static Item field_77786_ax = (new ItemBucket(70, Block.field_71942_A.field_71990_ca)).func_77652_b(11, 4).func_77655_b("bucketWater").func_77642_a(field_77788_aw);
   public static Item field_77775_ay = (new ItemBucket(71, Block.field_71944_C.field_71990_ca)).func_77652_b(12, 4).func_77655_b("bucketLava").func_77642_a(field_77788_aw);
   public static Item field_77773_az = (new ItemMinecart(72, 0)).func_77652_b(7, 8).func_77655_b("minecart");
   public static Item field_77765_aA = (new ItemSaddle(73)).func_77652_b(8, 6).func_77655_b("saddle");
   public static Item field_77766_aB = (new ItemDoor(74, Material.field_76243_f)).func_77652_b(12, 2).func_77655_b("doorIron");
   public static Item field_77767_aC = (new ItemRedstone(75)).func_77652_b(8, 3).func_77655_b("redstone").func_77631_c(PotionHelper.field_77932_i);
   public static Item field_77768_aD = (new ItemSnowball(76)).func_77652_b(14, 0).func_77655_b("snowball");
   public static Item field_77769_aE = (new ItemBoat(77)).func_77652_b(8, 8).func_77655_b("boat");
   public static Item field_77770_aF = (new Item(78)).func_77652_b(7, 6).func_77655_b("leather").func_77637_a(CreativeTabs.field_78035_l);
   public static Item field_77771_aG = (new ItemBucketMilk(79)).func_77652_b(13, 4).func_77655_b("milk").func_77642_a(field_77788_aw);
   public static Item field_77772_aH = (new Item(80)).func_77652_b(6, 1).func_77655_b("brick").func_77637_a(CreativeTabs.field_78035_l);
   public static Item field_77757_aI = (new Item(81)).func_77652_b(9, 3).func_77655_b("clay").func_77637_a(CreativeTabs.field_78035_l);
   public static Item field_77758_aJ = (new ItemReed(82, Block.field_72040_aX)).func_77652_b(11, 1).func_77655_b("reeds").func_77637_a(CreativeTabs.field_78035_l);
   public static Item field_77759_aK = (new Item(83)).func_77652_b(10, 3).func_77655_b("paper").func_77637_a(CreativeTabs.field_78026_f);
   public static Item field_77760_aL = (new Item(84)).func_77652_b(11, 3).func_77655_b("book").func_77637_a(CreativeTabs.field_78026_f);
   public static Item field_77761_aM = (new Item(85)).func_77652_b(14, 1).func_77655_b("slimeball").func_77637_a(CreativeTabs.field_78026_f);
   public static Item field_77762_aN = (new ItemMinecart(86, 1)).func_77652_b(7, 9).func_77655_b("minecartChest");
   public static Item field_77763_aO = (new ItemMinecart(87, 2)).func_77652_b(7, 10).func_77655_b("minecartFurnace");
   public static Item field_77764_aP = (new ItemEgg(88)).func_77652_b(12, 0).func_77655_b("egg");
   public static Item field_77750_aQ = (new Item(89)).func_77652_b(6, 3).func_77655_b("compass").func_77637_a(CreativeTabs.field_78040_i);
   public static Item field_77749_aR = (new ItemFishingRod(90)).func_77652_b(5, 4).func_77655_b("fishingRod");
   public static Item field_77752_aS = (new Item(91)).func_77652_b(6, 4).func_77655_b("clock").func_77637_a(CreativeTabs.field_78040_i);
   public static Item field_77751_aT = (new Item(92)).func_77652_b(9, 4).func_77655_b("yellowDust").func_77631_c(PotionHelper.field_77929_j).func_77637_a(CreativeTabs.field_78035_l);
   public static Item field_77754_aU = (new ItemFood(93, 2, 0.3F, false)).func_77652_b(9, 5).func_77655_b("fishRaw");
   public static Item field_77753_aV = (new ItemFood(94, 5, 0.6F, false)).func_77652_b(10, 5).func_77655_b("fishCooked");
   public static Item field_77756_aW = (new ItemDye(95)).func_77652_b(14, 4).func_77655_b("dyePowder");
   public static Item field_77755_aX = (new Item(96)).func_77652_b(12, 1).func_77655_b("bone").func_77664_n().func_77637_a(CreativeTabs.field_78026_f);
   public static Item field_77747_aY = (new Item(97)).func_77652_b(13, 0).func_77655_b("sugar").func_77631_c(PotionHelper.field_77922_b).func_77637_a(CreativeTabs.field_78035_l);
   public static Item field_77746_aZ = (new ItemReed(98, Block.field_72009_bg)).func_77625_d(1).func_77652_b(13, 1).func_77655_b("cake").func_77637_a(CreativeTabs.field_78039_h);
   public static Item field_77776_ba = (new ItemBed(99)).func_77625_d(1).func_77652_b(13, 2).func_77655_b("bed");
   public static Item field_77742_bb = (new ItemReed(100, Block.field_72010_bh)).func_77652_b(6, 5).func_77655_b("diode").func_77637_a(CreativeTabs.field_78028_d);
   public static Item field_77743_bc = (new ItemFood(101, 2, 0.1F, false)).func_77652_b(12, 5).func_77655_b("cookie");
   public static ItemMap field_77744_bd = (ItemMap)(new ItemMap(102)).func_77652_b(12, 3).func_77655_b("map");
   public static ItemShears field_77745_be = (ItemShears)(new ItemShears(103)).func_77652_b(13, 5).func_77655_b("shears");
   public static Item field_77738_bf = (new ItemFood(104, 2, 0.3F, false)).func_77652_b(13, 6).func_77655_b("melon");
   public static Item field_77739_bg = (new ItemSeeds(105, Block.field_71996_bs.field_71990_ca, Block.field_72050_aA.field_71990_ca)).func_77652_b(13, 3).func_77655_b("seeds_pumpkin");
   public static Item field_77740_bh = (new ItemSeeds(106, Block.field_71999_bt.field_71990_ca, Block.field_72050_aA.field_71990_ca)).func_77652_b(14, 3).func_77655_b("seeds_melon");
   public static Item field_77741_bi = (new ItemFood(107, 3, 0.3F, true)).func_77652_b(9, 6).func_77655_b("beefRaw");
   public static Item field_77734_bj = (new ItemFood(108, 8, 0.8F, true)).func_77652_b(10, 6).func_77655_b("beefCooked");
   public static Item field_77735_bk = (new ItemFood(109, 2, 0.3F, true)).func_77844_a(Potion.field_76438_s.field_76415_H, 30, 0, 0.3F).func_77652_b(9, 7).func_77655_b("chickenRaw");
   public static Item field_77736_bl = (new ItemFood(110, 6, 0.6F, true)).func_77652_b(10, 7).func_77655_b("chickenCooked");
   public static Item field_77737_bm = (new ItemFood(111, 4, 0.1F, true)).func_77844_a(Potion.field_76438_s.field_76415_H, 30, 0, 0.8F).func_77652_b(11, 5).func_77655_b("rottenFlesh");
   public static Item field_77730_bn = (new ItemEnderPearl(112)).func_77652_b(11, 6).func_77655_b("enderPearl");
   public static Item field_77731_bo = (new Item(113)).func_77652_b(12, 6).func_77655_b("blazeRod").func_77637_a(CreativeTabs.field_78035_l);
   public static Item field_77732_bp = (new Item(114)).func_77652_b(11, 7).func_77655_b("ghastTear").func_77631_c(PotionHelper.field_77923_c).func_77637_a(CreativeTabs.field_78038_k);
   public static Item field_77733_bq = (new Item(115)).func_77652_b(12, 7).func_77655_b("goldNugget").func_77637_a(CreativeTabs.field_78035_l);
   public static Item field_77727_br = (new ItemSeeds(116, Block.field_72094_bD.field_71990_ca, Block.field_72013_bc.field_71990_ca)).func_77652_b(13, 7).func_77655_b("netherStalkSeeds").func_77631_c("+4");
   public static ItemPotion field_77726_bs = (ItemPotion)(new ItemPotion(117)).func_77652_b(13, 8).func_77655_b("potion");
   public static Item field_77729_bt = (new ItemGlassBottle(118)).func_77652_b(12, 8).func_77655_b("glassBottle");
   public static Item field_77728_bu = (new ItemFood(119, 2, 0.8F, false)).func_77844_a(Potion.field_76436_u.field_76415_H, 5, 0, 1.0F).func_77652_b(11, 8).func_77655_b("spiderEye").func_77631_c(PotionHelper.field_77920_d);
   public static Item field_77723_bv = (new Item(120)).func_77652_b(10, 8).func_77655_b("fermentedSpiderEye").func_77631_c(PotionHelper.field_77921_e).func_77637_a(CreativeTabs.field_78038_k);
   public static Item field_77722_bw = (new Item(121)).func_77652_b(13, 9).func_77655_b("blazePowder").func_77631_c(PotionHelper.field_77919_g).func_77637_a(CreativeTabs.field_78038_k);
   public static Item field_77725_bx = (new Item(122)).func_77652_b(13, 10).func_77655_b("magmaCream").func_77631_c(PotionHelper.field_77931_h).func_77637_a(CreativeTabs.field_78038_k);
   public static Item field_77724_by = (new ItemReed(123, Block.field_72106_bF)).func_77652_b(12, 10).func_77655_b("brewingStand").func_77637_a(CreativeTabs.field_78038_k);
   public static Item field_77721_bz = (new ItemReed(124, Block.field_72108_bG)).func_77652_b(12, 9).func_77655_b("cauldron").func_77637_a(CreativeTabs.field_78038_k);
   public static Item field_77748_bA = (new ItemEnderEye(125)).func_77652_b(11, 9).func_77655_b("eyeOfEnder");
   public static Item field_77813_bB = (new Item(126)).func_77652_b(9, 8).func_77655_b("speckledMelon").func_77631_c(PotionHelper.field_77918_f).func_77637_a(CreativeTabs.field_78038_k);
   public static Item field_77815_bC = (new ItemMonsterPlacer(127)).func_77652_b(9, 9).func_77655_b("monsterPlacer");
   public static Item field_77809_bD = (new ItemExpBottle(128)).func_77652_b(11, 10).func_77655_b("expBottle");
   public static Item field_77811_bE = (new ItemFireball(129)).func_77652_b(14, 2).func_77655_b("fireball");
   public static Item field_77821_bF = (new ItemWritableBook(130)).func_77652_b(11, 11).func_77655_b("writingBook").func_77637_a(CreativeTabs.field_78026_f);
   public static Item field_77823_bG = (new ItemEditableBook(131)).func_77652_b(12, 11).func_77655_b("writtenBook");
   public static Item field_77817_bH = (new Item(132)).func_77652_b(10, 11).func_77655_b("emerald").func_77637_a(CreativeTabs.field_78035_l);
   public static Item field_77819_bI = (new ItemRecord(2000, "13")).func_77652_b(0, 15).func_77655_b("record");
   public static Item field_77797_bJ = (new ItemRecord(2001, "cat")).func_77652_b(1, 15).func_77655_b("record");
   public static Item field_77799_bK = (new ItemRecord(2002, "blocks")).func_77652_b(2, 15).func_77655_b("record");
   public static Item field_77793_bL = (new ItemRecord(2003, "chirp")).func_77652_b(3, 15).func_77655_b("record");
   public static Item field_77795_bM = (new ItemRecord(2004, "far")).func_77652_b(4, 15).func_77655_b("record");
   public static Item field_77805_bN = (new ItemRecord(2005, "mall")).func_77652_b(5, 15).func_77655_b("record");
   public static Item field_77807_bO = (new ItemRecord(2006, "mellohi")).func_77652_b(6, 15).func_77655_b("record");
   public static Item field_77801_bP = (new ItemRecord(2007, "stal")).func_77652_b(7, 15).func_77655_b("record");
   public static Item field_77803_bQ = (new ItemRecord(2008, "strad")).func_77652_b(8, 15).func_77655_b("record");
   public static Item field_77783_bR = (new ItemRecord(2009, "ward")).func_77652_b(9, 15).func_77655_b("record");
   public static Item field_77781_bS = (new ItemRecord(2010, "11")).func_77652_b(10, 15).func_77655_b("record");
   public final int field_77779_bT;
   protected int field_77777_bU = 64;
   private int field_77699_b = 0;
   protected int field_77791_bV;
   protected boolean field_77789_bW = false;
   protected boolean field_77787_bX = false;
   private Item field_77700_c = null;
   private String field_77785_bY = null;
   private String field_77774_bZ;


   protected Item(int p_i3659_1_) {
      this.field_77779_bT = 256 + p_i3659_1_;
      if(field_77698_e[256 + p_i3659_1_] != null) {
         System.out.println("CONFLICT @ " + p_i3659_1_);
      }

      field_77698_e[256 + p_i3659_1_] = this;
   }

   public Item func_77665_c(int p_77665_1_) {
      this.field_77791_bV = p_77665_1_;
      return this;
   }

   public Item func_77625_d(int p_77625_1_) {
      this.field_77777_bU = p_77625_1_;
      return this;
   }

   public Item func_77652_b(int p_77652_1_, int p_77652_2_) {
      this.field_77791_bV = p_77652_1_ + p_77652_2_ * 16;
      return this;
   }

   public boolean func_77648_a(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
      return false;
   }

   public float func_77638_a(ItemStack p_77638_1_, Block p_77638_2_) {
      return 1.0F;
   }

   public ItemStack func_77659_a(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_) {
      return p_77659_1_;
   }

   public ItemStack func_77654_b(ItemStack p_77654_1_, World p_77654_2_, EntityPlayer p_77654_3_) {
      return p_77654_1_;
   }

   public int func_77639_j() {
      return this.field_77777_bU;
   }

   public int func_77647_b(int p_77647_1_) {
      return 0;
   }

   public boolean func_77614_k() {
      return this.field_77787_bX;
   }

   protected Item func_77627_a(boolean p_77627_1_) {
      this.field_77787_bX = p_77627_1_;
      return this;
   }

   public int func_77612_l() {
      return this.field_77699_b;
   }

   protected Item func_77656_e(int p_77656_1_) {
      this.field_77699_b = p_77656_1_;
      return this;
   }

   public boolean func_77645_m() {
      return this.field_77699_b > 0 && !this.field_77787_bX;
   }

   public boolean func_77644_a(ItemStack p_77644_1_, EntityLiving p_77644_2_, EntityLiving p_77644_3_) {
      return false;
   }

   public boolean func_77660_a(ItemStack p_77660_1_, World p_77660_2_, int p_77660_3_, int p_77660_4_, int p_77660_5_, int p_77660_6_, EntityLiving p_77660_7_) {
      return false;
   }

   public int func_77649_a(Entity p_77649_1_) {
      return 1;
   }

   public boolean func_77641_a(Block p_77641_1_) {
      return false;
   }

   public boolean func_77646_a(ItemStack p_77646_1_, EntityLiving p_77646_2_) {
      return false;
   }

   public Item func_77664_n() {
      this.field_77789_bW = true;
      return this;
   }

   public Item func_77655_b(String p_77655_1_) {
      this.field_77774_bZ = "item." + p_77655_1_;
      return this;
   }

   public String func_77658_a() {
      return this.field_77774_bZ;
   }

   public String func_77667_c(ItemStack p_77667_1_) {
      return this.field_77774_bZ;
   }

   public Item func_77642_a(Item p_77642_1_) {
      this.field_77700_c = p_77642_1_;
      return this;
   }

   public boolean func_77630_h(ItemStack p_77630_1_) {
      return true;
   }

   public boolean func_77651_p() {
      return false;
   }

   public Item func_77668_q() {
      return this.field_77700_c;
   }

   public boolean func_77634_r() {
      return this.field_77700_c != null;
   }

   public String func_77635_s() {
      return StatCollector.func_74838_a(this.func_77658_a() + ".name");
   }

   public String func_77653_i(ItemStack p_77653_1_) {
      return StatCollector.func_74838_a(this.func_77667_c(p_77653_1_) + ".name");
   }

   public void func_77663_a(ItemStack p_77663_1_, World p_77663_2_, Entity p_77663_3_, int p_77663_4_, boolean p_77663_5_) {}

   public void func_77622_d(ItemStack p_77622_1_, World p_77622_2_, EntityPlayer p_77622_3_) {}

   public boolean func_77643_m_() {
      return false;
   }

   public EnumAction func_77661_b(ItemStack p_77661_1_) {
      return EnumAction.none;
   }

   public int func_77626_a(ItemStack p_77626_1_) {
      return 0;
   }

   public void func_77615_a(ItemStack p_77615_1_, World p_77615_2_, EntityPlayer p_77615_3_, int p_77615_4_) {}

   protected Item func_77631_c(String p_77631_1_) {
      this.field_77785_bY = p_77631_1_;
      return this;
   }

   public String func_77666_t() {
      return this.field_77785_bY;
   }

   public boolean func_77632_u() {
      return this.field_77785_bY != null;
   }

   public boolean func_77616_k(ItemStack p_77616_1_) {
      return this.func_77639_j() == 1 && this.func_77645_m();
   }

   protected MovingObjectPosition func_77621_a(World p_77621_1_, EntityPlayer p_77621_2_, boolean p_77621_3_) {
      float var4 = 1.0F;
      float var5 = p_77621_2_.field_70127_C + (p_77621_2_.field_70125_A - p_77621_2_.field_70127_C) * var4;
      float var6 = p_77621_2_.field_70126_B + (p_77621_2_.field_70177_z - p_77621_2_.field_70126_B) * var4;
      double var7 = p_77621_2_.field_70169_q + (p_77621_2_.field_70165_t - p_77621_2_.field_70169_q) * (double)var4;
      double var9 = p_77621_2_.field_70167_r + (p_77621_2_.field_70163_u - p_77621_2_.field_70167_r) * (double)var4 + 1.62D - (double)p_77621_2_.field_70129_M;
      double var11 = p_77621_2_.field_70166_s + (p_77621_2_.field_70161_v - p_77621_2_.field_70166_s) * (double)var4;
      Vec3 var13 = Vec3.func_72437_a().func_72345_a(var7, var9, var11);
      float var14 = MathHelper.func_76134_b(-var6 * 0.017453292F - 3.1415927F);
      float var15 = MathHelper.func_76126_a(-var6 * 0.017453292F - 3.1415927F);
      float var16 = -MathHelper.func_76134_b(-var5 * 0.017453292F);
      float var17 = MathHelper.func_76126_a(-var5 * 0.017453292F);
      float var18 = var15 * var16;
      float var20 = var14 * var16;
      double var21 = 5.0D;
      Vec3 var23 = var13.func_72441_c((double)var18 * var21, (double)var17 * var21, (double)var20 * var21);
      return p_77621_1_.func_72831_a(var13, var23, p_77621_3_, !p_77621_3_);
   }

   public int func_77619_b() {
      return 0;
   }

   public Item func_77637_a(CreativeTabs p_77637_1_) {
      this.field_77701_a = p_77637_1_;
      return this;
   }

   static {
      StatList.func_75925_c();
   }
}
