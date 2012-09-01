/*     */ package net.java.games.input;
/*     */ 
/*     */ final class DataQueue
/*     */ {
/*     */   private final Object[] elements;
/*     */   private int position;
/*     */   private int limit;
/*     */ 
/*     */   public DataQueue(int size, Class element_type)
/*     */   {
/*  51 */     this.elements = new Object[size];
/*  52 */     for (int i = 0; i < this.elements.length; i++) {
/*     */       try {
/*  54 */         this.elements[i] = element_type.newInstance();
/*     */       } catch (InstantiationException e) {
/*  56 */         throw new RuntimeException(e);
/*     */       } catch (IllegalAccessException e) {
/*  58 */         throw new RuntimeException(e);
/*     */       }
/*     */     }
/*  61 */     clear();
/*     */   }
/*     */ 
/*     */   public final void clear() {
/*  65 */     this.position = 0;
/*  66 */     this.limit = this.elements.length;
/*     */   }
/*     */ 
/*     */   public final int position() {
/*  70 */     return this.position;
/*     */   }
/*     */ 
/*     */   public final int limit() {
/*  74 */     return this.limit;
/*     */   }
/*     */ 
/*     */   public final Object get(int index) {
/*  78 */     assert (index < this.limit);
/*  79 */     return this.elements[index];
/*     */   }
/*     */ 
/*     */   public final Object get() {
/*  83 */     if (!hasRemaining())
/*  84 */       return null;
/*  85 */     return get(this.position++);
/*     */   }
/*     */ 
/*     */   public final void compact() {
/*  89 */     int index = 0;
/*  90 */     while (hasRemaining()) {
/*  91 */       swap(this.position, index);
/*  92 */       this.position += 1;
/*  93 */       index++;
/*     */     }
/*  95 */     this.position = index;
/*  96 */     this.limit = this.elements.length;
/*     */   }
/*     */ 
/*     */   private final void swap(int index1, int index2) {
/* 100 */     Object temp = this.elements[index1];
/* 101 */     this.elements[index1] = this.elements[index2];
/* 102 */     this.elements[index2] = temp;
/*     */   }
/*     */ 
/*     */   public final void flip() {
/* 106 */     this.limit = this.position;
/* 107 */     this.position = 0;
/*     */   }
/*     */ 
/*     */   public final boolean hasRemaining() {
/* 111 */     return remaining() > 0;
/*     */   }
/*     */ 
/*     */   public final int remaining() {
/* 115 */     return this.limit - this.position;
/*     */   }
/*     */ 
/*     */   public final void position(int position) {
/* 119 */     this.position = position;
/*     */   }
/*     */ 
/*     */   public final Object[] getElements() {
/* 123 */     return this.elements;
/*     */   }
/*     */ }

/* Location:           /Users/Nick/Library/Application Support/minecraft/bin/jinput.jar
 * Qualified Name:     net.java.games.input.DataQueue
 * JD-Core Version:    0.6.1
 */