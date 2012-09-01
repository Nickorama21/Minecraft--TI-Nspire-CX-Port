/*     */ package net.java.games.util.plugins;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.IOException;
/*     */ import java.io.PrintStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Enumeration;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import java.util.jar.JarEntry;
/*     */ import java.util.jar.JarFile;
/*     */ 
/*     */ public class Plugins
/*     */ {
/*     */   static final boolean DEBUG = true;
/*  69 */   List pluginList = new ArrayList();
/*     */ 
/*     */   public Plugins(File pluginRoot)
/*     */     throws IOException
/*     */   {
/*  76 */     scanPlugins(pluginRoot);
/*     */   }
/*     */ 
/*     */   private void scanPlugins(File dir) throws IOException {
/*  80 */     File[] files = dir.listFiles();
/*  81 */     if (files == null) {
/*  82 */       throw new FileNotFoundException("Plugin directory " + dir.getName() + " not found.");
/*     */     }
/*     */ 
/*  85 */     for (int i = 0; i < files.length; i++) {
/*  86 */       File f = files[i];
/*  87 */       if (f.getName().endsWith(".jar"))
/*  88 */         processJar(f);
/*  89 */       else if (f.isDirectory())
/*  90 */         scanPlugins(f);
/*     */     }
/*     */   }
/*     */ 
/*     */   private void processJar(File f)
/*     */   {
/*     */     try
/*     */     {
/* 100 */       System.out.println("Scanning jar: " + f.getName());
/*     */ 
/* 102 */       loader = new PluginLoader(f);
/* 103 */       JarFile jf = new JarFile(f);
/* 104 */       for (en = jf.entries(); en.hasMoreElements(); ) {
/* 105 */         JarEntry je = (JarEntry)en.nextElement();
/*     */ 
/* 107 */         System.out.println("Examining file : " + je.getName());
/*     */ 
/* 109 */         if (je.getName().endsWith("Plugin.class"))
/*     */         {
/* 111 */           System.out.println("Found candidate class: " + je.getName());
/*     */ 
/* 113 */           String cname = je.getName();
/* 114 */           cname = cname.substring(0, cname.length() - 6);
/* 115 */           cname = cname.replace('/', '.');
/* 116 */           Class pc = loader.loadClass(cname);
/* 117 */           if (loader.attemptPluginDefine(pc))
/*     */           {
/* 119 */             System.out.println("Adding class to plugins:" + pc.getName());
/*     */ 
/* 121 */             this.pluginList.add(pc);
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*     */       PluginLoader loader;
/*     */       Enumeration en;
/* 126 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public Class[] get()
/*     */   {
/* 136 */     Class[] pluginArray = new Class[this.pluginList.size()];
/* 137 */     return (Class[])this.pluginList.toArray(pluginArray);
/*     */   }
/*     */ 
/*     */   public Class[] getImplementsAny(Class[] interfaces)
/*     */   {
/* 149 */     List matchList = new ArrayList(this.pluginList.size());
/* 150 */     Set interfaceSet = new HashSet();
/* 151 */     for (int i = 0; i < interfaces.length; i++) {
/* 152 */       interfaceSet.add(interfaces[i]);
/*     */     }
/* 154 */     for (Iterator i = this.pluginList.iterator(); i.hasNext(); ) {
/* 155 */       Class pluginClass = (Class)i.next();
/* 156 */       if (classImplementsAny(pluginClass, interfaceSet)) {
/* 157 */         matchList.add(pluginClass);
/*     */       }
/*     */     }
/* 160 */     Class[] pluginArray = new Class[matchList.size()];
/* 161 */     return (Class[])matchList.toArray(pluginArray);
/*     */   }
/*     */ 
/*     */   private boolean classImplementsAny(Class testClass, Set interfaces) {
/* 165 */     if (testClass == null) return false;
/* 166 */     Class[] implementedInterfaces = testClass.getInterfaces();
/* 167 */     for (int i = 0; i < implementedInterfaces.length; i++) {
/* 168 */       if (interfaces.contains(implementedInterfaces[i])) {
/* 169 */         return true;
/*     */       }
/*     */     }
/* 172 */     for (int i = 0; i < implementedInterfaces.length; i++) {
/* 173 */       if (classImplementsAny(implementedInterfaces[i], interfaces)) {
/* 174 */         return true;
/*     */       }
/*     */     }
/* 177 */     return classImplementsAny(testClass.getSuperclass(), interfaces);
/*     */   }
/*     */ 
/*     */   public Class[] getImplementsAll(Class[] interfaces)
/*     */   {
/* 189 */     List matchList = new ArrayList(this.pluginList.size());
/* 190 */     Set interfaceSet = new HashSet();
/* 191 */     for (int i = 0; i < interfaces.length; i++) {
/* 192 */       interfaceSet.add(interfaces[i]);
/*     */     }
/* 194 */     for (Iterator i = this.pluginList.iterator(); i.hasNext(); ) {
/* 195 */       Class pluginClass = (Class)i.next();
/* 196 */       if (classImplementsAll(pluginClass, interfaceSet)) {
/* 197 */         matchList.add(pluginClass);
/*     */       }
/*     */     }
/* 200 */     Class[] pluginArray = new Class[matchList.size()];
/* 201 */     return (Class[])matchList.toArray(pluginArray);
/*     */   }
/*     */ 
/*     */   private boolean classImplementsAll(Class testClass, Set interfaces) {
/* 205 */     if (testClass == null) return false;
/* 206 */     Class[] implementedInterfaces = testClass.getInterfaces();
/* 207 */     for (int i = 0; i < implementedInterfaces.length; i++) {
/* 208 */       if (interfaces.contains(implementedInterfaces[i])) {
/* 209 */         interfaces.remove(implementedInterfaces[i]);
/* 210 */         if (interfaces.size() == 0) {
/* 211 */           return true;
/*     */         }
/*     */       }
/*     */     }
/* 215 */     for (int i = 0; i < implementedInterfaces.length; i++) {
/* 216 */       if (classImplementsAll(implementedInterfaces[i], interfaces)) {
/* 217 */         return true;
/*     */       }
/*     */     }
/* 220 */     return classImplementsAll(testClass.getSuperclass(), interfaces);
/*     */   }
/*     */ 
/*     */   public Class[] getExtends(Class superclass)
/*     */   {
/* 231 */     List matchList = new ArrayList(this.pluginList.size());
/* 232 */     for (Iterator i = this.pluginList.iterator(); i.hasNext(); ) {
/* 233 */       Class pluginClass = (Class)i.next();
/* 234 */       if (classExtends(pluginClass, superclass)) {
/* 235 */         matchList.add(pluginClass);
/*     */       }
/*     */     }
/* 238 */     Class[] pluginArray = new Class[matchList.size()];
/* 239 */     return (Class[])matchList.toArray(pluginArray);
/*     */   }
/*     */ 
/*     */   private boolean classExtends(Class testClass, Class superclass) {
/* 243 */     if (testClass == null) {
/* 244 */       return false;
/*     */     }
/* 246 */     if (testClass == superclass) {
/* 247 */       return true;
/*     */     }
/* 249 */     return classExtends(testClass.getSuperclass(), superclass);
/*     */   }
/*     */ }

/* Location:           /Users/Nick/Library/Application Support/minecraft/bin/jinput.jar
 * Qualified Name:     net.java.games.util.plugins.Plugins
 * JD-Core Version:    0.6.1
 */