package net.minecraft.src;

import net.minecraft.src.CreativeTabBlock;
import net.minecraft.src.CreativeTabBrewing;
import net.minecraft.src.CreativeTabCombat;
import net.minecraft.src.CreativeTabDeco;
import net.minecraft.src.CreativeTabFood;
import net.minecraft.src.CreativeTabInventory;
import net.minecraft.src.CreativeTabMaterial;
import net.minecraft.src.CreativeTabMisc;
import net.minecraft.src.CreativeTabRedstone;
import net.minecraft.src.CreativeTabSearch;
import net.minecraft.src.CreativeTabTools;
import net.minecraft.src.CreativeTabTransport;

public class CreativeTabs {

   public static final CreativeTabs[] field_78032_a = new CreativeTabs[12];
   public static final CreativeTabs field_78030_b = new CreativeTabBlock(0, "buildingBlocks");
   public static final CreativeTabs field_78031_c = new CreativeTabDeco(1, "decorations");
   public static final CreativeTabs field_78028_d = new CreativeTabRedstone(2, "redstone");
   public static final CreativeTabs field_78029_e = new CreativeTabTransport(3, "transportation");
   public static final CreativeTabs field_78026_f = new CreativeTabMisc(4, "misc");
   public static final CreativeTabs field_78027_g = (new CreativeTabSearch(5, "search")).func_78025_a("search.png");
   public static final CreativeTabs field_78039_h = new CreativeTabFood(6, "food");
   public static final CreativeTabs field_78040_i = new CreativeTabTools(7, "tools");
   public static final CreativeTabs field_78037_j = new CreativeTabCombat(8, "combat");
   public static final CreativeTabs field_78038_k = new CreativeTabBrewing(9, "brewing");
   public static final CreativeTabs field_78035_l = new CreativeTabMaterial(10, "materials");
   public static final CreativeTabs field_78036_m = (new CreativeTabInventory(11, "inventory")).func_78025_a("survival_inv.png").func_78022_j().func_78014_h();
   private final int field_78033_n;
   private final String field_78034_o;
   private String field_78043_p = "list_items.png";
   private boolean field_78042_q = true;
   private boolean field_78041_r = true;


   public CreativeTabs(int p_i3642_1_, String p_i3642_2_) {
      this.field_78033_n = p_i3642_1_;
      this.field_78034_o = p_i3642_2_;
      field_78032_a[p_i3642_1_] = this;
   }

   public CreativeTabs func_78025_a(String p_78025_1_) {
      this.field_78043_p = p_78025_1_;
      return this;
   }

   public CreativeTabs func_78014_h() {
      this.field_78041_r = false;
      return this;
   }

   public CreativeTabs func_78022_j() {
      this.field_78042_q = false;
      return this;
   }

}
