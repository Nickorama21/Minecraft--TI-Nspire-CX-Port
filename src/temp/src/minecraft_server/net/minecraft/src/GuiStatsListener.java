package net.minecraft.src;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import net.minecraft.src.GuiStatsComponent;

class GuiStatsListener implements ActionListener {

   // $FF: synthetic field
   final GuiStatsComponent field_79021_a;


   GuiStatsListener(GuiStatsComponent p_i4109_1_) {
      this.field_79021_a = p_i4109_1_;
   }

   public void actionPerformed(ActionEvent p_actionPerformed_1_) {
      GuiStatsComponent.func_79013_a(this.field_79021_a);
   }
}
