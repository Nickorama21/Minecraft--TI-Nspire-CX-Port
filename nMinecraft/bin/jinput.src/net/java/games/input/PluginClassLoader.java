/*     */ package net.java.games.input;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileFilter;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.util.StringTokenizer;
/*     */ import java.util.jar.JarEntry;
/*     */ import java.util.jar.JarFile;
/*     */ 
/*     */ class PluginClassLoader extends ClassLoader
/*     */ {
/*     */   private static String pluginDirectory;
/*  67 */   private static final FileFilter JAR_FILTER = new JarFileFilter(null);
/*     */ 
/*     */   public PluginClassLoader()
/*     */   {
/*  73 */     super(Thread.currentThread().getContextClassLoader());
/*     */   }
/*     */ 
/*     */   protected Class findClass(String name)
/*     */     throws ClassNotFoundException
/*     */   {
/*  83 */     byte[] b = loadClassData(name);
/*  84 */     return defineClass(name, b, 0, b.length);
/*     */   }
/*     */ 
/*     */   private byte[] loadClassData(String name)
/*     */     throws ClassNotFoundException
/*     */   {
/*  92 */     if (pluginDirectory == null) {
/*  93 */       pluginDirectory = DefaultControllerEnvironment.libPath + File.separator + "controller";
/*     */     }
/*     */     try
/*     */     {
/*  97 */       return loadClassFromDirectory(name);
/*     */     } catch (Exception e) {
/*     */       try {
/* 100 */         return loadClassFromJAR(name);
/*     */       } catch (IOException e2) {
/* 102 */         throw new ClassNotFoundException(name, e2);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   private byte[] loadClassFromDirectory(String name)
/*     */     throws ClassNotFoundException, IOException
/*     */   {
/* 115 */     StringTokenizer tokenizer = new StringTokenizer(name, ".");
/* 116 */     StringBuffer path = new StringBuffer(pluginDirectory);
/* 117 */     while (tokenizer.hasMoreTokens()) {
/* 118 */       path.append(File.separator);
/* 119 */       path.append(tokenizer.nextToken());
/*     */     }
/* 121 */     path.append(".class");
/* 122 */     File file = new File(path.toString());
/* 123 */     if (!file.exists()) {
/* 124 */       throw new ClassNotFoundException(name);
/*     */     }
/* 126 */     FileInputStream fileInputStream = new FileInputStream(file);
/* 127 */     assert (file.length() <= 2147483647L);
/* 128 */     int length = (int)file.length();
/* 129 */     byte[] bytes = new byte[length];
/* 130 */     int length2 = fileInputStream.read(bytes);
/* 131 */     assert (length == length2);
/* 132 */     return bytes;
/*     */   }
/*     */ 
/*     */   private byte[] loadClassFromJAR(String name)
/*     */     throws ClassNotFoundException, IOException
/*     */   {
/* 141 */     File dir = new File(pluginDirectory);
/* 142 */     File[] jarFiles = dir.listFiles(JAR_FILTER);
/* 143 */     if (jarFiles == null) {
/* 144 */       throw new ClassNotFoundException("Could not find class " + name);
/*     */     }
/* 146 */     for (int i = 0; i < jarFiles.length; i++) {
/* 147 */       JarFile jarfile = new JarFile(jarFiles[i]);
/* 148 */       JarEntry jarentry = jarfile.getJarEntry(name + ".class");
/* 149 */       if (jarentry != null) {
/* 150 */         InputStream jarInputStream = jarfile.getInputStream(jarentry);
/* 151 */         assert (jarentry.getSize() <= 2147483647L);
/* 152 */         int length = (int)jarentry.getSize();
/* 153 */         assert (length >= 0);
/* 154 */         byte[] bytes = new byte[length];
/* 155 */         int length2 = jarInputStream.read(bytes);
/* 156 */         assert (length == length2);
/* 157 */         return bytes;
/*     */       }
/*     */     }
/* 160 */     throw new FileNotFoundException(name);
/*     */   }
/*     */ 
/*     */   private static class JarFileFilter implements FileFilter
/*     */   {
/*     */     private JarFileFilter() {
/*     */     }
/*     */ 
/*     */     public boolean accept(File file) {
/* 169 */       return file.getName().toUpperCase().endsWith(".JAR");
/*     */     }
/*     */ 
/*     */     JarFileFilter(PluginClassLoader.1 x0)
/*     */     {
/* 167 */       this();
/*     */     }
/*     */   }
/*     */ }

/* Location:           /Users/Nick/Library/Application Support/minecraft/bin/jinput.jar
 * Qualified Name:     net.java.games.input.PluginClassLoader
 * JD-Core Version:    0.6.1
 */