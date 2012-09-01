/*    */ package net.java.games.util.plugins.test;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import java.awt.Component;
/*    */ import javax.swing.JLabel;
/*    */ import javax.swing.JList;
/*    */ import javax.swing.ListCellRenderer;
/*    */ 
/*    */ class ClassRenderer
/*    */   implements ListCellRenderer
/*    */ {
/* 53 */   JLabel label = new JLabel();
/*    */ 
/*    */   public Component getListCellRendererComponent(JList jList, Object obj, int param, boolean param3, boolean param4)
/*    */   {
/* 57 */     this.label.setText(((Class)obj).getName());
/* 58 */     this.label.setForeground(Color.BLACK);
/* 59 */     this.label.setBackground(Color.WHITE);
/*    */ 
/* 63 */     return this.label;
/*    */   }
/*    */ }

/* Location:           /Users/Nick/Library/Application Support/minecraft/bin/jinput.jar
 * Qualified Name:     net.java.games.util.plugins.test.ClassRenderer
 * JD-Core Version:    0.6.1
 */