/*    */ package net.java.games.input;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ final class LinuxDeviceThread extends Thread
/*    */ {
/* 43 */   private final List tasks = new ArrayList();
/*    */ 
/*    */   public LinuxDeviceThread() {
/* 46 */     setDaemon(true);
/* 47 */     start();
/*    */   }
/*    */ 
/*    */   public final synchronized void run() {
/*    */     while (true)
/* 52 */       if (!this.tasks.isEmpty()) {
/* 53 */         LinuxDeviceTask task = (LinuxDeviceTask)this.tasks.remove(0);
/* 54 */         task.doExecute();
/* 55 */         synchronized (task) {
/* 56 */           task.notify();
/*    */         }
/*    */       } else {
/*    */         try {
/* 60 */           wait();
/*    */         }
/*    */         catch (InterruptedException e)
/*    */         {
/*    */         }
/*    */       }
/*    */   }
/*    */ 
/*    */   public final Object execute(LinuxDeviceTask task) throws IOException {
/* 69 */     synchronized (this) {
/* 70 */       this.tasks.add(task);
/* 71 */       notify();
/*    */     }
/* 73 */     synchronized (task) {
/* 74 */       while (task.getState() == 1)
/*    */         try {
/* 76 */           task.wait();
/*    */         }
/*    */         catch (InterruptedException e)
/*    */         {
/*    */         }
/*    */     }
/* 82 */     switch (task.getState()) {
/*    */     case 2:
/* 84 */       return task.getResult();
/*    */     case 3:
/* 86 */       throw task.getException();
/*    */     }
/* 88 */     throw new RuntimeException("Invalid task state: " + task.getState());
/*    */   }
/*    */ }

/* Location:           /Users/Nick/Library/Application Support/minecraft/bin/jinput.jar
 * Qualified Name:     net.java.games.input.LinuxDeviceThread
 * JD-Core Version:    0.6.1
 */