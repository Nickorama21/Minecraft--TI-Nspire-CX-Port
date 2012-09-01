/*     */ package net.java.games.util.plugins.test;
/*     */ 
/*     */ import java.awt.BorderLayout;
/*     */ import java.awt.Container;
/*     */ import java.awt.FlowLayout;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import javax.swing.DefaultListModel;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JList;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.SwingUtilities;
/*     */ import net.java.games.util.plugins.Plugins;
/*     */ 
/*     */ public class PluginTest
/*     */ {
/*     */   static final boolean DEBUG = false;
/*     */   Plugins plugins;
/*     */   JList plist;
/*     */   Class[] piList;
/*     */ 
/*     */   public PluginTest()
/*     */   {
/*     */     try
/*     */     {
/*  92 */       this.plugins = new Plugins(new File("test_plugins"));
/*     */     } catch (IOException e) {
/*  94 */       e.printStackTrace();
/*  95 */       System.exit(1);
/*     */     }
/*  97 */     JFrame f = new JFrame("PluginTest");
/*  98 */     this.plist = new JList(new DefaultListModel());
/*  99 */     this.plist.setCellRenderer(new ClassRenderer());
/* 100 */     Container c = f.getContentPane();
/* 101 */     c.setLayout(new BorderLayout());
/* 102 */     c.add(new JScrollPane(this.plist), "Center");
/* 103 */     JPanel p = new JPanel();
/* 104 */     c.add(p, "South");
/* 105 */     p.setLayout(new FlowLayout());
/* 106 */     f.pack();
/* 107 */     f.setDefaultCloseOperation(3);
/* 108 */     f.setVisible(true);
/* 109 */     doListAll();
/*     */   }
/*     */ 
/*     */   private void doListAll() {
/* 113 */     SwingUtilities.invokeLater(new ListUpdater(this.plist, this.plugins.get()));
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/* 119 */     new PluginTest();
/*     */   }
/*     */ }

/* Location:           /Users/Nick/Library/Application Support/minecraft/bin/jinput.jar
 * Qualified Name:     net.java.games.util.plugins.test.PluginTest
 * JD-Core Version:    0.6.1
 */