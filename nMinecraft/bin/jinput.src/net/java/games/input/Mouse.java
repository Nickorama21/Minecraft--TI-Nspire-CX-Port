/*     */ package net.java.games.input;
/*     */ 
/*     */ public abstract class Mouse extends AbstractController
/*     */ {
/*     */   protected Mouse(String name, Component[] components, Controller[] children, Rumbler[] rumblers)
/*     */   {
/*  51 */     super(name, components, children, rumblers);
/*     */   }
/*     */ 
/*     */   public Controller.Type getType()
/*     */   {
/*  58 */     return Controller.Type.MOUSE;
/*     */   }
/*     */ 
/*     */   public Component getX()
/*     */   {
/*  65 */     return getComponent(Component.Identifier.Axis.X);
/*     */   }
/*     */ 
/*     */   public Component getY()
/*     */   {
/*  72 */     return getComponent(Component.Identifier.Axis.Y);
/*     */   }
/*     */ 
/*     */   public Component getWheel()
/*     */   {
/*  79 */     return getComponent(Component.Identifier.Axis.Z);
/*     */   }
/*     */ 
/*     */   public Component getPrimaryButton()
/*     */   {
/*  86 */     Component primaryButton = getComponent(Component.Identifier.Button.LEFT);
/*  87 */     if (primaryButton == null) {
/*  88 */       primaryButton = getComponent(Component.Identifier.Button._1);
/*     */     }
/*  90 */     return primaryButton;
/*     */   }
/*     */ 
/*     */   public Component getSecondaryButton()
/*     */   {
/*  98 */     Component secondaryButton = getComponent(Component.Identifier.Button.RIGHT);
/*  99 */     if (secondaryButton == null) {
/* 100 */       secondaryButton = getComponent(Component.Identifier.Button._2);
/*     */     }
/* 102 */     return secondaryButton;
/*     */   }
/*     */ 
/*     */   public Component getTertiaryButton()
/*     */   {
/* 110 */     Component tertiaryButton = getComponent(Component.Identifier.Button.MIDDLE);
/* 111 */     if (tertiaryButton == null) {
/* 112 */       tertiaryButton = getComponent(Component.Identifier.Button._3);
/*     */     }
/* 114 */     return tertiaryButton;
/*     */   }
/*     */ 
/*     */   public Component getLeft()
/*     */   {
/* 121 */     return getComponent(Component.Identifier.Button.LEFT);
/*     */   }
/*     */ 
/*     */   public Component getRight()
/*     */   {
/* 128 */     return getComponent(Component.Identifier.Button.RIGHT);
/*     */   }
/*     */ 
/*     */   public Component getMiddle()
/*     */   {
/* 135 */     return getComponent(Component.Identifier.Button.MIDDLE);
/*     */   }
/*     */ 
/*     */   public Component getSide()
/*     */   {
/* 143 */     return getComponent(Component.Identifier.Button.SIDE);
/*     */   }
/*     */ 
/*     */   public Component getExtra()
/*     */   {
/* 151 */     return getComponent(Component.Identifier.Button.EXTRA);
/*     */   }
/*     */ 
/*     */   public Component getForward()
/*     */   {
/* 159 */     return getComponent(Component.Identifier.Button.FORWARD);
/*     */   }
/*     */ 
/*     */   public Component getBack()
/*     */   {
/* 167 */     return getComponent(Component.Identifier.Button.BACK);
/*     */   }
/*     */ 
/*     */   public Component getButton3()
/*     */   {
/* 175 */     return getComponent(Component.Identifier.Button._3);
/*     */   }
/*     */ 
/*     */   public Component getButton4()
/*     */   {
/* 183 */     return getComponent(Component.Identifier.Button._4);
/*     */   }
/*     */ }

/* Location:           /Users/Nick/Library/Application Support/minecraft/bin/jinput.jar
 * Qualified Name:     net.java.games.input.Mouse
 * JD-Core Version:    0.6.1
 */