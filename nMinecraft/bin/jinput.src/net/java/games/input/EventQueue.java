/*    */ package net.java.games.input;
/*    */ 
/*    */ public final class EventQueue
/*    */ {
/*    */   private final Event[] queue;
/*    */   private int head;
/*    */   private int tail;
/*    */ 
/*    */   public EventQueue(int size)
/*    */   {
/* 48 */     this.queue = new Event[size + 1];
/* 49 */     for (int i = 0; i < this.queue.length; i++)
/* 50 */       this.queue[i] = new Event();
/*    */   }
/*    */ 
/*    */   final synchronized void add(Event event) {
/* 54 */     this.queue[this.tail].set(event);
/* 55 */     this.tail = increase(this.tail);
/*    */   }
/*    */ 
/*    */   final synchronized boolean isFull() {
/* 59 */     return increase(this.tail) == this.head;
/*    */   }
/*    */ 
/*    */   private final int increase(int x) {
/* 63 */     return (x + 1) % this.queue.length;
/*    */   }
/*    */ 
/*    */   public final synchronized boolean getNextEvent(Event event) {
/* 67 */     if (this.head == this.tail)
/* 68 */       return false;
/* 69 */     event.set(this.queue[this.head]);
/* 70 */     this.head = increase(this.head);
/* 71 */     return true;
/*    */   }
/*    */ }

/* Location:           /Users/Nick/Library/Application Support/minecraft/bin/jinput.jar
 * Qualified Name:     net.java.games.input.EventQueue
 * JD-Core Version:    0.6.1
 */