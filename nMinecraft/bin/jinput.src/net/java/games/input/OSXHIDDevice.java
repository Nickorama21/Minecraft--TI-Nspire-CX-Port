/*     */ package net.java.games.input;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.PrintStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ 
/*     */ final class OSXHIDDevice
/*     */ {
/*     */   private static final int AXIS_DEFAULT_MIN_VALUE = 0;
/*     */   private static final int AXIS_DEFAULT_MAX_VALUE = 65536;
/*     */   private static final String kIOHIDTransportKey = "Transport";
/*     */   private static final String kIOHIDVendorIDKey = "VendorID";
/*     */   private static final String kIOHIDVendorIDSourceKey = "VendorIDSource";
/*     */   private static final String kIOHIDProductIDKey = "ProductID";
/*     */   private static final String kIOHIDVersionNumberKey = "VersionNumber";
/*     */   private static final String kIOHIDManufacturerKey = "Manufacturer";
/*     */   private static final String kIOHIDProductKey = "Product";
/*     */   private static final String kIOHIDSerialNumberKey = "SerialNumber";
/*     */   private static final String kIOHIDCountryCodeKey = "CountryCode";
/*     */   private static final String kIOHIDLocationIDKey = "LocationID";
/*     */   private static final String kIOHIDDeviceUsageKey = "DeviceUsage";
/*     */   private static final String kIOHIDDeviceUsagePageKey = "DeviceUsagePage";
/*     */   private static final String kIOHIDDeviceUsagePairsKey = "DeviceUsagePairs";
/*     */   private static final String kIOHIDPrimaryUsageKey = "PrimaryUsage";
/*     */   private static final String kIOHIDPrimaryUsagePageKey = "PrimaryUsagePage";
/*     */   private static final String kIOHIDMaxInputReportSizeKey = "MaxInputReportSize";
/*     */   private static final String kIOHIDMaxOutputReportSizeKey = "MaxOutputReportSize";
/*     */   private static final String kIOHIDMaxFeatureReportSizeKey = "MaxFeatureReportSize";
/*     */   private static final String kIOHIDElementKey = "Elements";
/*     */   private static final String kIOHIDElementCookieKey = "ElementCookie";
/*     */   private static final String kIOHIDElementTypeKey = "Type";
/*     */   private static final String kIOHIDElementCollectionTypeKey = "CollectionType";
/*     */   private static final String kIOHIDElementUsageKey = "Usage";
/*     */   private static final String kIOHIDElementUsagePageKey = "UsagePage";
/*     */   private static final String kIOHIDElementMinKey = "Min";
/*     */   private static final String kIOHIDElementMaxKey = "Max";
/*     */   private static final String kIOHIDElementScaledMinKey = "ScaledMin";
/*     */   private static final String kIOHIDElementScaledMaxKey = "ScaledMax";
/*     */   private static final String kIOHIDElementSizeKey = "Size";
/*     */   private static final String kIOHIDElementReportSizeKey = "ReportSize";
/*     */   private static final String kIOHIDElementReportCountKey = "ReportCount";
/*     */   private static final String kIOHIDElementReportIDKey = "ReportID";
/*     */   private static final String kIOHIDElementIsArrayKey = "IsArray";
/*     */   private static final String kIOHIDElementIsRelativeKey = "IsRelative";
/*     */   private static final String kIOHIDElementIsWrappingKey = "IsWrapping";
/*     */   private static final String kIOHIDElementIsNonLinearKey = "IsNonLinear";
/*     */   private static final String kIOHIDElementHasPreferredStateKey = "HasPreferredState";
/*     */   private static final String kIOHIDElementHasNullStateKey = "HasNullState";
/*     */   private static final String kIOHIDElementUnitKey = "Unit";
/*     */   private static final String kIOHIDElementUnitExponentKey = "UnitExponent";
/*     */   private static final String kIOHIDElementNameKey = "Name";
/*     */   private static final String kIOHIDElementValueLocationKey = "ValueLocation";
/*     */   private static final String kIOHIDElementDuplicateIndexKey = "DuplicateIndex";
/*     */   private static final String kIOHIDElementParentCollectionKey = "ParentCollection";
/*     */   private final long device_address;
/*     */   private final long device_interface_address;
/*     */   private final Map properties;
/*     */   private boolean released;
/*     */ 
/*     */   public OSXHIDDevice(long device_address, long device_interface_address)
/*     */     throws IOException
/*     */   {
/* 110 */     this.device_address = device_address;
/* 111 */     this.device_interface_address = device_interface_address;
/* 112 */     this.properties = getDeviceProperties();
/* 113 */     open();
/*     */   }
/*     */ 
/*     */   public final Controller.PortType getPortType() {
/* 117 */     String transport = (String)this.properties.get("Transport");
/* 118 */     if (transport == null)
/* 119 */       return Controller.PortType.UNKNOWN;
/* 120 */     if (transport.equals("USB")) {
/* 121 */       return Controller.PortType.USB;
/*     */     }
/* 123 */     return Controller.PortType.UNKNOWN;
/*     */   }
/*     */ 
/*     */   public final String getProductName()
/*     */   {
/* 128 */     return (String)this.properties.get("Product");
/*     */   }
/*     */ 
/*     */   private final OSXHIDElement createElementFromElementProperties(Map element_properties)
/*     */   {
/* 136 */     long element_cookie = getLongFromProperties(element_properties, "ElementCookie");
/* 137 */     int element_type_id = getIntFromProperties(element_properties, "Type");
/* 138 */     ElementType element_type = ElementType.map(element_type_id);
/* 139 */     int min = (int)getLongFromProperties(element_properties, "Min", 0L);
/* 140 */     int max = (int)getLongFromProperties(element_properties, "Max", 65536L);
/*     */ 
/* 143 */     UsagePair device_usage_pair = getUsagePair();
/* 144 */     boolean default_relative = (device_usage_pair != null) && ((device_usage_pair.getUsage() == GenericDesktopUsage.POINTER) || (device_usage_pair.getUsage() == GenericDesktopUsage.MOUSE));
/*     */ 
/* 146 */     boolean is_relative = getBooleanFromProperties(element_properties, "IsRelative", default_relative);
/*     */ 
/* 151 */     int usage = getIntFromProperties(element_properties, "Usage");
/* 152 */     int usage_page = getIntFromProperties(element_properties, "UsagePage");
/* 153 */     UsagePair usage_pair = createUsagePair(usage_page, usage);
/* 154 */     if ((usage_pair == null) || ((element_type != ElementType.INPUT_MISC) && (element_type != ElementType.INPUT_BUTTON) && (element_type != ElementType.INPUT_AXIS)))
/*     */     {
/* 156 */       return null;
/*     */     }
/* 158 */     return new OSXHIDElement(this, usage_pair, element_cookie, element_type, min, max, is_relative);
/*     */   }
/*     */ 
/*     */   private final void addElements(List elements, Map properties)
/*     */   {
/* 163 */     Object[] elements_properties = (Object[])properties.get("Elements");
/* 164 */     if (elements_properties == null)
/* 165 */       return;
/* 166 */     for (int i = 0; i < elements_properties.length; i++) {
/* 167 */       Map element_properties = (Map)elements_properties[i];
/* 168 */       OSXHIDElement element = createElementFromElementProperties(element_properties);
/* 169 */       if (element != null) {
/* 170 */         elements.add(element);
/*     */       }
/* 172 */       addElements(elements, element_properties);
/*     */     }
/*     */   }
/*     */ 
/*     */   public final List getElements() {
/* 177 */     List elements = new ArrayList();
/* 178 */     addElements(elements, this.properties);
/* 179 */     return elements;
/*     */   }
/*     */ 
/*     */   private static final long getLongFromProperties(Map properties, String key, long default_value) {
/* 183 */     Long long_obj = (Long)properties.get(key);
/* 184 */     if (long_obj == null)
/* 185 */       return default_value;
/* 186 */     return long_obj.longValue();
/*     */   }
/*     */ 
/*     */   private static final boolean getBooleanFromProperties(Map properties, String key, boolean default_value) {
/* 190 */     return getLongFromProperties(properties, key, default_value ? 1L : 0L) != 0L;
/*     */   }
/*     */ 
/*     */   private static final int getIntFromProperties(Map properties, String key) {
/* 194 */     return (int)getLongFromProperties(properties, key);
/*     */   }
/*     */ 
/*     */   private static final long getLongFromProperties(Map properties, String key) {
/* 198 */     Long long_obj = (Long)properties.get(key);
/* 199 */     return long_obj.longValue();
/*     */   }
/*     */ 
/*     */   private static final UsagePair createUsagePair(int usage_page_id, int usage_id) {
/* 203 */     UsagePage usage_page = UsagePage.map(usage_page_id);
/* 204 */     if (usage_page != null) {
/* 205 */       Usage usage = usage_page.mapUsage(usage_id);
/* 206 */       if (usage != null)
/* 207 */         return new UsagePair(usage_page, usage);
/*     */     }
/* 209 */     return null;
/*     */   }
/*     */ 
/*     */   public final UsagePair getUsagePair() {
/* 213 */     int usage_page_id = getIntFromProperties(this.properties, "PrimaryUsagePage");
/* 214 */     int usage_id = getIntFromProperties(this.properties, "PrimaryUsage");
/* 215 */     return createUsagePair(usage_page_id, usage_id);
/*     */   }
/*     */ 
/*     */   private final void dumpProperties()
/*     */   {
/* 241 */     System.out.println(toString());
/* 242 */     dumpMap("", this.properties);
/*     */   }
/*     */ 
/*     */   private static final void dumpArray(String prefix, Object[] array) {
/* 246 */     System.out.println(prefix + "{");
/* 247 */     for (int i = 0; i < array.length; i++) {
/* 248 */       dumpObject(prefix + "\t", array[i]);
/* 249 */       System.out.println(prefix + ",");
/*     */     }
/* 251 */     System.out.println(prefix + "}");
/*     */   }
/*     */ 
/*     */   private static final void dumpMap(String prefix, Map map) {
/* 255 */     Iterator keys = map.keySet().iterator();
/* 256 */     while (keys.hasNext()) {
/* 257 */       Object key = keys.next();
/* 258 */       Object value = map.get(key);
/* 259 */       dumpObject(prefix, key);
/* 260 */       dumpObject(prefix + "\t", value);
/*     */     }
/*     */   }
/*     */ 
/*     */   private static final void dumpObject(String prefix, Object obj) {
/* 265 */     if ((obj instanceof Long)) {
/* 266 */       Long l = (Long)obj;
/* 267 */       System.out.println(prefix + "0x" + Long.toHexString(l.longValue()));
/* 268 */     } else if ((obj instanceof Map)) {
/* 269 */       dumpMap(prefix, (Map)obj);
/* 270 */     } else if (obj.getClass().isArray()) {
/* 271 */       dumpArray(prefix, (Object[])obj);
/*     */     } else {
/* 273 */       System.out.println(prefix + obj);
/*     */     }
/*     */   }
/*     */ 
/* 277 */   private final Map getDeviceProperties() throws IOException { return nGetDeviceProperties(this.device_address); }
/*     */ 
/*     */   private static final native Map nGetDeviceProperties(long paramLong) throws IOException;
/*     */ 
/*     */   public final synchronized void release() throws IOException {
/*     */     try {
/* 283 */       close();
/*     */     } finally {
/* 285 */       this.released = true;
/* 286 */       nReleaseDevice(this.device_address, this.device_interface_address);
/*     */     }
/*     */   }
/*     */ 
/*     */   private static final native void nReleaseDevice(long paramLong1, long paramLong2);
/*     */ 
/* 292 */   public final synchronized void getElementValue(long element_cookie, OSXEvent event) throws IOException { checkReleased();
/* 293 */     nGetElementValue(this.device_interface_address, element_cookie, event); }
/*     */ 
/*     */   private static final native void nGetElementValue(long paramLong1, long paramLong2, OSXEvent paramOSXEvent) throws IOException;
/*     */ 
/*     */   public final synchronized OSXHIDQueue createQueue(int queue_depth) throws IOException {
/* 298 */     checkReleased();
/* 299 */     long queue_address = nCreateQueue(this.device_interface_address);
/* 300 */     return new OSXHIDQueue(queue_address, queue_depth);
/*     */   }
/*     */   private static final native long nCreateQueue(long paramLong) throws IOException;
/*     */ 
/*     */   private final void open() throws IOException {
/* 305 */     nOpen(this.device_interface_address);
/*     */   }
/*     */   private static final native void nOpen(long paramLong) throws IOException;
/*     */ 
/*     */   private final void close() throws IOException {
/* 310 */     nClose(this.device_interface_address);
/*     */   }
/*     */   private static final native void nClose(long paramLong) throws IOException;
/*     */ 
/*     */   private final void checkReleased() throws IOException {
/* 315 */     if (this.released)
/* 316 */       throw new IOException();
/*     */   }
/*     */ }

/* Location:           /Users/Nick/Library/Application Support/minecraft/bin/jinput.jar
 * Qualified Name:     net.java.games.input.OSXHIDDevice
 * JD-Core Version:    0.6.1
 */