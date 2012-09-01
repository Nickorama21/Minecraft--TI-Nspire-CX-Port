/*    */ package net.java.games.util.plugins.test;
/*    */ 
/*    */ import javax.swing.DefaultListModel;
/*    */ import javax.swing.JList;
/*    */ 
/*    */ class ListUpdater
/*    */   implements Runnable
/*    */ {
/*    */   Object[] objList;
/*    */   DefaultListModel mdl;
/*    */ 
/*    */   public ListUpdater(JList jlist, Object[] list)
/*    */   {
/* 71 */     this.objList = list;
/* 72 */     this.mdl = ((DefaultListModel)jlist.getModel());
/*    */   }
/*    */ 
/*    */   public void run() {
/* 76 */     this.mdl.clear();
/* 77 */     for (int i = 0; i < this.objList.length; i++)
/* 78 */       this.mdl.addElement(this.objList[i]);
/*    */   }
/*    */ }

/* Location:           /Users/Nick/Library/Application Support/minecraft/bin/jinput.jar
 * Qualified Name:     net.java.games.util.plugins.test.ListUpdater
 * JD-Core Version:    0.6.1
 */