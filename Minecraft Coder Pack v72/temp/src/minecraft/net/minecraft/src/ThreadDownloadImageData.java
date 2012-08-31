package net.minecraft.src;

import java.awt.image.BufferedImage;
import net.minecraft.src.ImageBuffer;
import net.minecraft.src.ThreadDownloadImage;

public class ThreadDownloadImageData {

   public BufferedImage field_78462_a;
   public int field_78460_b = 1;
   public int field_78461_c = -1;
   public boolean field_78459_d = false;


   public ThreadDownloadImageData(String p_i3195_1_, ImageBuffer p_i3195_2_) {
      (new ThreadDownloadImage(this, p_i3195_1_, p_i3195_2_)).start();
   }
}
