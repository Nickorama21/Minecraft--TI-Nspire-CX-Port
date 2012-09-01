package net.minecraft.src;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import net.minecraft.src.NBTBase;
import net.minecraft.src.NBTTagCompound;

public class CompressedStreamTools {

   public static NBTTagCompound func_74796_a(InputStream p_74796_0_) throws IOException {
      DataInputStream var1 = new DataInputStream(new BufferedInputStream(new GZIPInputStream(p_74796_0_)));

      NBTTagCompound var2;
      try {
         var2 = func_74794_a(var1);
      } finally {
         var1.close();
      }

      return var2;
   }

   public static void func_74799_a(NBTTagCompound p_74799_0_, OutputStream p_74799_1_) throws IOException {
      DataOutputStream var2 = new DataOutputStream(new GZIPOutputStream(p_74799_1_));

      try {
         func_74800_a(p_74799_0_, var2);
      } finally {
         var2.close();
      }

   }

   public static NBTTagCompound func_74792_a(byte[] p_74792_0_) throws IOException {
      DataInputStream var1 = new DataInputStream(new BufferedInputStream(new GZIPInputStream(new ByteArrayInputStream(p_74792_0_))));

      NBTTagCompound var2;
      try {
         var2 = func_74794_a(var1);
      } finally {
         var1.close();
      }

      return var2;
   }

   public static byte[] func_74798_a(NBTTagCompound p_74798_0_) throws IOException {
      ByteArrayOutputStream var1 = new ByteArrayOutputStream();
      DataOutputStream var2 = new DataOutputStream(new GZIPOutputStream(var1));

      try {
         func_74800_a(p_74798_0_, var2);
      } finally {
         var2.close();
      }

      return var1.toByteArray();
   }

   public static NBTTagCompound func_74794_a(DataInput p_74794_0_) throws IOException {
      NBTBase var1 = NBTBase.func_74739_b(p_74794_0_);
      if(var1 instanceof NBTTagCompound) {
         return (NBTTagCompound)var1;
      } else {
         throw new IOException("Root tag must be a named compound tag");
      }
   }

   public static void func_74800_a(NBTTagCompound p_74800_0_, DataOutput p_74800_1_) throws IOException {
      NBTBase.func_74731_a(p_74800_0_, p_74800_1_);
   }
}
