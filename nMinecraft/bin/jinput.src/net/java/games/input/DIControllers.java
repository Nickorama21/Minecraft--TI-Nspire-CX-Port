/*    */ package net.java.games.input;
/*    */ 
/*    */ import java.io.IOException;
/*    */ 
/*    */ final class DIControllers
/*    */ {
/* 48 */   private static final DIDeviceObjectData di_event = new DIDeviceObjectData();
/*    */ 
/*    */   public static final synchronized boolean getNextDeviceEvent(Event event, IDirectInputDevice device) throws IOException
/*    */   {
/* 52 */     if (!device.getNextEvent(di_event))
/* 53 */       return false;
/* 54 */     DIDeviceObject object = device.mapEvent(di_event);
/* 55 */     DIComponent component = device.mapObject(object);
/* 56 */     if (component == null)
/* 57 */       return false;
/*    */     int event_value;
/*    */     int event_value;
/* 59 */     if (object.isRelative())
/* 60 */       event_value = object.getRelativeEventValue(di_event.getData());
/*    */     else {
/* 62 */       event_value = di_event.getData();
/*    */     }
/* 64 */     event.set(component, component.getDeviceObject().convertValue(event_value), di_event.getNanos());
/* 65 */     return true;
/*    */   }
/*    */ 
/*    */   public static final float poll(Component component, DIDeviceObject object) throws IOException {
/* 69 */     int poll_data = object.getDevice().getPollData(object);
/*    */     float result;
/*    */     float result;
/* 71 */     if (object.isRelative())
/* 72 */       result = object.getRelativePollValue(poll_data);
/*    */     else {
/* 74 */       result = poll_data;
/*    */     }
/* 76 */     return object.convertValue(result);
/*    */   }
/*    */ }

/* Location:           /Users/Nick/Library/Application Support/minecraft/bin/jinput.jar
 * Qualified Name:     net.java.games.input.DIControllers
 * JD-Core Version:    0.6.1
 */