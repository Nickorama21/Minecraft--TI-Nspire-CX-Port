package net.minecraft.src;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import net.minecraft.server.MinecraftServer;
import net.minecraft.src.ServerGUI;

class ServerGuiCommandListener implements ActionListener {

   // $FF: synthetic field
   final JTextField field_79027_a;
   // $FF: synthetic field
   final ServerGUI field_79026_b;


   ServerGuiCommandListener(ServerGUI p_i4104_1_, JTextField p_i4104_2_) {
      this.field_79026_b = p_i4104_1_;
      this.field_79027_a = p_i4104_2_;
   }

   public void actionPerformed(ActionEvent p_actionPerformed_1_) {
      String var2 = this.field_79027_a.getText().trim();
      if(var2.length() > 0) {
         ServerGUI.func_79004_a(this.field_79026_b).func_71331_a(var2, MinecraftServer.func_71276_C());
      }

      this.field_79027_a.setText("");
   }
}
