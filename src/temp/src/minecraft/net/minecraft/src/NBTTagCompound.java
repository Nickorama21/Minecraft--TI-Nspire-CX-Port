package net.minecraft.src;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.minecraft.src.NBTBase;
import net.minecraft.src.NBTTagByte;
import net.minecraft.src.NBTTagByteArray;
import net.minecraft.src.NBTTagDouble;
import net.minecraft.src.NBTTagFloat;
import net.minecraft.src.NBTTagInt;
import net.minecraft.src.NBTTagIntArray;
import net.minecraft.src.NBTTagList;
import net.minecraft.src.NBTTagLong;
import net.minecraft.src.NBTTagShort;
import net.minecraft.src.NBTTagString;

public class NBTTagCompound extends NBTBase {

   private Map field_74784_a = new HashMap();


   public NBTTagCompound() {
      super("");
   }

   public NBTTagCompound(String p_i3265_1_) {
      super(p_i3265_1_);
   }

   void func_74734_a(DataOutput p_74734_1_) throws IOException {
      Iterator var2 = this.field_74784_a.values().iterator();

      while(var2.hasNext()) {
         NBTBase var3 = (NBTBase)var2.next();
         NBTBase.func_74731_a(var3, p_74734_1_);
      }

      p_74734_1_.writeByte(0);
   }

   void func_74735_a(DataInput p_74735_1_) throws IOException {
      this.field_74784_a.clear();

      NBTBase var2;
      while((var2 = NBTBase.func_74739_b(p_74735_1_)).func_74732_a() != 0) {
         this.field_74784_a.put(var2.func_74740_e(), var2);
      }

   }

   public Collection func_74758_c() {
      return this.field_74784_a.values();
   }

   public byte func_74732_a() {
      return (byte)10;
   }

   public void func_74782_a(String p_74782_1_, NBTBase p_74782_2_) {
      this.field_74784_a.put(p_74782_1_, p_74782_2_.func_74738_o(p_74782_1_));
   }

   public void func_74774_a(String p_74774_1_, byte p_74774_2_) {
      this.field_74784_a.put(p_74774_1_, new NBTTagByte(p_74774_1_, p_74774_2_));
   }

   public void func_74777_a(String p_74777_1_, short p_74777_2_) {
      this.field_74784_a.put(p_74777_1_, new NBTTagShort(p_74777_1_, p_74777_2_));
   }

   public void func_74768_a(String p_74768_1_, int p_74768_2_) {
      this.field_74784_a.put(p_74768_1_, new NBTTagInt(p_74768_1_, p_74768_2_));
   }

   public void func_74772_a(String p_74772_1_, long p_74772_2_) {
      this.field_74784_a.put(p_74772_1_, new NBTTagLong(p_74772_1_, p_74772_2_));
   }

   public void func_74776_a(String p_74776_1_, float p_74776_2_) {
      this.field_74784_a.put(p_74776_1_, new NBTTagFloat(p_74776_1_, p_74776_2_));
   }

   public void func_74780_a(String p_74780_1_, double p_74780_2_) {
      this.field_74784_a.put(p_74780_1_, new NBTTagDouble(p_74780_1_, p_74780_2_));
   }

   public void func_74778_a(String p_74778_1_, String p_74778_2_) {
      this.field_74784_a.put(p_74778_1_, new NBTTagString(p_74778_1_, p_74778_2_));
   }

   public void func_74773_a(String p_74773_1_, byte[] p_74773_2_) {
      this.field_74784_a.put(p_74773_1_, new NBTTagByteArray(p_74773_1_, p_74773_2_));
   }

   public void func_74783_a(String p_74783_1_, int[] p_74783_2_) {
      this.field_74784_a.put(p_74783_1_, new NBTTagIntArray(p_74783_1_, p_74783_2_));
   }

   public void func_74766_a(String p_74766_1_, NBTTagCompound p_74766_2_) {
      this.field_74784_a.put(p_74766_1_, p_74766_2_.func_74738_o(p_74766_1_));
   }

   public void func_74757_a(String p_74757_1_, boolean p_74757_2_) {
      this.func_74774_a(p_74757_1_, (byte)(p_74757_2_?1:0));
   }

   public NBTBase func_74781_a(String p_74781_1_) {
      return (NBTBase)this.field_74784_a.get(p_74781_1_);
   }

   public boolean func_74764_b(String p_74764_1_) {
      return this.field_74784_a.containsKey(p_74764_1_);
   }

   public byte func_74771_c(String p_74771_1_) {
      return !this.field_74784_a.containsKey(p_74771_1_)?0:((NBTTagByte)this.field_74784_a.get(p_74771_1_)).field_74756_a;
   }

   public short func_74765_d(String p_74765_1_) {
      return !this.field_74784_a.containsKey(p_74765_1_)?0:((NBTTagShort)this.field_74784_a.get(p_74765_1_)).field_74752_a;
   }

   public int func_74762_e(String p_74762_1_) {
      return !this.field_74784_a.containsKey(p_74762_1_)?0:((NBTTagInt)this.field_74784_a.get(p_74762_1_)).field_74748_a;
   }

   public long func_74763_f(String p_74763_1_) {
      return !this.field_74784_a.containsKey(p_74763_1_)?0L:((NBTTagLong)this.field_74784_a.get(p_74763_1_)).field_74753_a;
   }

   public float func_74760_g(String p_74760_1_) {
      return !this.field_74784_a.containsKey(p_74760_1_)?0.0F:((NBTTagFloat)this.field_74784_a.get(p_74760_1_)).field_74750_a;
   }

   public double func_74769_h(String p_74769_1_) {
      return !this.field_74784_a.containsKey(p_74769_1_)?0.0D:((NBTTagDouble)this.field_74784_a.get(p_74769_1_)).field_74755_a;
   }

   public String func_74779_i(String p_74779_1_) {
      return !this.field_74784_a.containsKey(p_74779_1_)?"":((NBTTagString)this.field_74784_a.get(p_74779_1_)).field_74751_a;
   }

   public byte[] func_74770_j(String p_74770_1_) {
      return !this.field_74784_a.containsKey(p_74770_1_)?new byte[0]:((NBTTagByteArray)this.field_74784_a.get(p_74770_1_)).field_74754_a;
   }

   public int[] func_74759_k(String p_74759_1_) {
      return !this.field_74784_a.containsKey(p_74759_1_)?new int[0]:((NBTTagIntArray)this.field_74784_a.get(p_74759_1_)).field_74749_a;
   }

   public NBTTagCompound func_74775_l(String p_74775_1_) {
      return !this.field_74784_a.containsKey(p_74775_1_)?new NBTTagCompound(p_74775_1_):(NBTTagCompound)this.field_74784_a.get(p_74775_1_);
   }

   public NBTTagList func_74761_m(String p_74761_1_) {
      return !this.field_74784_a.containsKey(p_74761_1_)?new NBTTagList(p_74761_1_):(NBTTagList)this.field_74784_a.get(p_74761_1_);
   }

   public boolean func_74767_n(String p_74767_1_) {
      return this.func_74771_c(p_74767_1_) != 0;
   }

   public String toString() {
      return "" + this.field_74784_a.size() + " entries";
   }

   public NBTBase func_74737_b() {
      NBTTagCompound var1 = new NBTTagCompound(this.func_74740_e());
      Iterator var2 = this.field_74784_a.keySet().iterator();

      while(var2.hasNext()) {
         String var3 = (String)var2.next();
         var1.func_74782_a(var3, ((NBTBase)this.field_74784_a.get(var3)).func_74737_b());
      }

      return var1;
   }

   public boolean equals(Object p_equals_1_) {
      if(super.equals(p_equals_1_)) {
         NBTTagCompound var2 = (NBTTagCompound)p_equals_1_;
         return this.field_74784_a.entrySet().equals(var2.field_74784_a.entrySet());
      } else {
         return false;
      }
   }

   public int hashCode() {
      return super.hashCode() ^ this.field_74784_a.hashCode();
   }
}
