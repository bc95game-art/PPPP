package com.google.gson;

import androidx.fragment.app.LogWriter;
import com.google.android.gms.tasks.zzr;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.ToNumberPolicy;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.internal.Streams;
import com.google.gson.internal.bind.ArrayTypeAdapter;
import com.google.gson.internal.bind.DefaultDateTypeAdapter;
import com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory;
import com.google.gson.internal.bind.JsonElementTypeAdapter;
import com.google.gson.internal.bind.MapTypeAdapterFactory;
import com.google.gson.internal.bind.NumberTypeAdapter;
import com.google.gson.internal.bind.ObjectTypeAdapter;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.google.gson.internal.bind.SerializationDelegatingTypeAdapter;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.internal.sql.SqlTypesSupport;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.MalformedJsonException;
import j$.util.DesugarCollections;
import j$.util.Objects;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.EOFException;
import java.io.IOException;
import java.io.StringReader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
/* loaded from: classes.dex */
public final class Gson {
    public final zzr constructorConstructor;
    public final List factories;
    public final FormattingStyle formattingStyle;
    public final boolean htmlSafe;
    public final JsonAdapterAnnotationTypeAdapterFactory jsonAdapterFactory;
    public final ThreadLocal threadLocalAdapterResults;
    public final ConcurrentHashMap typeTokenCache;
    public static final FormattingStyle DEFAULT_FORMATTING_STYLE = FormattingStyle.COMPACT;
    public static final FieldNamingPolicy.AnonymousClass1 DEFAULT_FIELD_NAMING_STRATEGY = FieldNamingPolicy.IDENTITY;
    public static final ToNumberPolicy.AnonymousClass1 DEFAULT_OBJECT_TO_NUMBER_STRATEGY = ToNumberPolicy.DOUBLE;
    public static final ToNumberPolicy.AnonymousClass2 DEFAULT_NUMBER_TO_NUMBER_STRATEGY = ToNumberPolicy.LAZILY_PARSED_NUMBER;

    /* renamed from: com.google.gson.Gson$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public final class AnonymousClass1 extends TypeAdapter {
        public final /* synthetic */ int $r8$classId;

        public /* synthetic */ AnonymousClass1(int i) {
            this.$r8$classId = i;
        }

        @Override // com.google.gson.TypeAdapter
        public final Object read(JsonReader jsonReader) {
            switch (this.$r8$classId) {
                case 0:
                    if (jsonReader.peek() != 9) {
                        return Double.valueOf(jsonReader.nextDouble());
                    }
                    jsonReader.nextNull();
                    return null;
                case 1:
                    if (jsonReader.peek() != 9) {
                        return Float.valueOf((float) jsonReader.nextDouble());
                    }
                    jsonReader.nextNull();
                    return null;
                default:
                    jsonReader.skipValue();
                    return null;
            }
        }

        public String toString() {
            switch (this.$r8$classId) {
                case 2:
                    return "AnonymousOrNonStaticLocalClassAdapter";
                default:
                    return super.toString();
            }
        }

        @Override // com.google.gson.TypeAdapter
        public final void write(JsonWriter jsonWriter, Object obj) {
            switch (this.$r8$classId) {
                case 0:
                    Number number = (Number) obj;
                    if (number == null) {
                        jsonWriter.nullValue();
                        return;
                    }
                    double doubleValue = number.doubleValue();
                    Gson.checkValidFloatingPoint(doubleValue);
                    jsonWriter.value(doubleValue);
                    return;
                case 1:
                    Number number2 = (Number) obj;
                    if (number2 == null) {
                        jsonWriter.nullValue();
                        return;
                    }
                    float floatValue = number2.floatValue();
                    Gson.checkValidFloatingPoint(floatValue);
                    if (!(number2 instanceof Float)) {
                        number2 = Float.valueOf(floatValue);
                    }
                    jsonWriter.value(number2);
                    return;
                default:
                    jsonWriter.nullValue();
                    return;
            }
        }
    }

    /* loaded from: classes.dex */
    public class FutureTypeAdapter extends SerializationDelegatingTypeAdapter {
        public TypeAdapter delegate = null;

        @Override // com.google.gson.internal.bind.SerializationDelegatingTypeAdapter
        public final TypeAdapter getSerializationDelegate() {
            TypeAdapter typeAdapter = this.delegate;
            if (typeAdapter != null) {
                return typeAdapter;
            }
            throw new IllegalStateException("Adapter for type with cyclic dependency has been used before dependency has been resolved");
        }

        @Override // com.google.gson.TypeAdapter
        public final Object read(JsonReader jsonReader) {
            TypeAdapter typeAdapter = this.delegate;
            if (typeAdapter != null) {
                return typeAdapter.read(jsonReader);
            }
            throw new IllegalStateException("Adapter for type with cyclic dependency has been used before dependency has been resolved");
        }

        @Override // com.google.gson.TypeAdapter
        public final void write(JsonWriter jsonWriter, Object obj) {
            TypeAdapter typeAdapter = this.delegate;
            if (typeAdapter != null) {
                typeAdapter.write(jsonWriter, obj);
                return;
            }
            throw new IllegalStateException("Adapter for type with cyclic dependency has been used before dependency has been resolved");
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public Gson() {
        /*
            r12 = this;
            com.google.gson.internal.Excluder r1 = com.google.gson.internal.Excluder.DEFAULT
            java.util.Map r3 = java.util.Collections.EMPTY_MAP
            java.util.List r8 = java.util.Collections.EMPTY_LIST
            com.google.gson.ToNumberPolicy$1 r9 = com.google.gson.Gson.DEFAULT_OBJECT_TO_NUMBER_STRATEGY
            com.google.gson.ToNumberPolicy$2 r10 = com.google.gson.Gson.DEFAULT_NUMBER_TO_NUMBER_STRATEGY
            com.google.gson.FieldNamingPolicy$1 r2 = com.google.gson.Gson.DEFAULT_FIELD_NAMING_STRATEGY
            r4 = 1
            com.google.gson.FormattingStyle r5 = com.google.gson.Gson.DEFAULT_FORMATTING_STYLE
            r6 = 1
            r7 = 1
            r11 = r8
            r0 = r12
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.Gson.<init>():void");
    }

    public static void checkValidFloatingPoint(double d) {
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            throw new IllegalArgumentException(d + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    public final Object fromJson(String str, TypeToken typeToken) {
        Object obj = null;
        if (str == null) {
            return null;
        }
        JsonReader jsonReader = new JsonReader(new StringReader(str));
        jsonReader.setStrictness(2);
        int i = jsonReader.strictness;
        boolean z = true;
        if (i == 2) {
            jsonReader.strictness = 1;
        }
        try {
            try {
                try {
                    jsonReader.peek();
                    z = false;
                    TypeAdapter adapter = getAdapter(typeToken);
                    Object read = adapter.read(jsonReader);
                    Class wrap = Streams.wrap(typeToken.getRawType());
                    if (read != null && !wrap.isInstance(read)) {
                        throw new ClassCastException("Type adapter '" + adapter + "' returned wrong type; requested " + typeToken.getRawType() + " but got instance of " + read.getClass() + "\nVerify that the adapter was registered for the correct type.");
                    }
                    jsonReader.setStrictness(i);
                    obj = read;
                } catch (AssertionError e) {
                    throw new AssertionError("AssertionError (GSON 2.13.2): " + e.getMessage(), e);
                } catch (IllegalStateException e2) {
                    throw new RuntimeException(e2);
                }
            } catch (EOFException e3) {
                if (z) {
                    jsonReader.setStrictness(i);
                } else {
                    throw new RuntimeException(e3);
                }
            } catch (IOException e4) {
                throw new RuntimeException(e4);
            }
            if (obj != null) {
                try {
                    if (jsonReader.peek() != 10) {
                        throw new RuntimeException("JSON document was not fully consumed.");
                    }
                } catch (MalformedJsonException e5) {
                    throw new RuntimeException(e5);
                } catch (IOException e6) {
                    throw new RuntimeException(e6);
                }
            }
            return obj;
        } catch (Throwable th) {
            jsonReader.setStrictness(i);
            throw th;
        }
    }

    public final TypeAdapter getAdapter(TypeToken typeToken) {
        boolean z;
        Objects.requireNonNull(typeToken, "type must not be null");
        ConcurrentHashMap concurrentHashMap = this.typeTokenCache;
        TypeAdapter typeAdapter = (TypeAdapter) concurrentHashMap.get(typeToken);
        if (typeAdapter != null) {
            return typeAdapter;
        }
        ThreadLocal threadLocal = this.threadLocalAdapterResults;
        Map map = (Map) threadLocal.get();
        if (map == null) {
            map = new HashMap();
            threadLocal.set(map);
            z = true;
        } else {
            TypeAdapter typeAdapter2 = (TypeAdapter) map.get(typeToken);
            if (typeAdapter2 != null) {
                return typeAdapter2;
            }
            z = false;
        }
        try {
            FutureTypeAdapter futureTypeAdapter = new FutureTypeAdapter();
            map.put(typeToken, futureTypeAdapter);
            Iterator it = this.factories.iterator();
            TypeAdapter typeAdapter3 = null;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                typeAdapter3 = ((TypeAdapterFactory) it.next()).create(this, typeToken);
                if (typeAdapter3 != null) {
                    if (futureTypeAdapter.delegate == null) {
                        futureTypeAdapter.delegate = typeAdapter3;
                        map.put(typeToken, typeAdapter3);
                    } else {
                        throw new AssertionError("Delegate is already set");
                    }
                }
            }
            if (z) {
                threadLocal.remove();
            }
            if (typeAdapter3 != null) {
                if (z) {
                    concurrentHashMap.putAll(map);
                }
                return typeAdapter3;
            }
            throw new IllegalArgumentException("GSON (2.13.2) cannot handle " + typeToken);
        } catch (Throwable th) {
            if (z) {
                threadLocal.remove();
            }
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0057, code lost:
        if (r4 == r7) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0023, code lost:
        if (r4 == r7) goto L15;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0081  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.gson.TypeAdapter getDelegateAdapter(com.google.gson.TypeAdapterFactory r7, com.google.gson.reflect.TypeToken r8) {
        /*
            r6 = this;
            java.lang.String r0 = "skipPast must not be null"
            j$.util.Objects.requireNonNull(r7, r0)
            java.lang.String r0 = "type must not be null"
            j$.util.Objects.requireNonNull(r8, r0)
            com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory r0 = r6.jsonAdapterFactory
            r0.getClass()
            j$.util.concurrent.ConcurrentHashMap r1 = r0.adapterFactoryMap
            com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory$DummyTypeAdapterFactory r2 = com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory.TREE_TYPE_CLASS_DUMMY_FACTORY
            r3 = 1
            if (r7 != r2) goto L17
            goto L59
        L17:
            java.lang.Class r2 = r8.getRawType()
            java.lang.Object r4 = r1.get(r2)
            com.google.gson.TypeAdapterFactory r4 = (com.google.gson.TypeAdapterFactory) r4
            if (r4 == 0) goto L26
            if (r4 != r7) goto L5a
            goto L59
        L26:
            java.lang.Class<com.google.gson.annotations.JsonAdapter> r4 = com.google.gson.annotations.JsonAdapter.class
            java.lang.annotation.Annotation r4 = r2.getAnnotation(r4)
            com.google.gson.annotations.JsonAdapter r4 = (com.google.gson.annotations.JsonAdapter) r4
            if (r4 != 0) goto L31
            goto L5a
        L31:
            java.lang.Class r4 = r4.value()
            java.lang.Class<com.google.gson.TypeAdapterFactory> r5 = com.google.gson.TypeAdapterFactory.class
            boolean r5 = r5.isAssignableFrom(r4)
            if (r5 != 0) goto L3e
            goto L5a
        L3e:
            com.google.android.gms.tasks.zzr r5 = r0.constructorConstructor
            com.google.gson.reflect.TypeToken r4 = com.google.gson.reflect.TypeToken.get(r4)
            com.google.gson.internal.ObjectConstructor r4 = r5.get(r4, r3)
            java.lang.Object r4 = r4.construct()
            com.google.gson.TypeAdapterFactory r4 = (com.google.gson.TypeAdapterFactory) r4
            java.lang.Object r1 = r1.putIfAbsent(r2, r4)
            com.google.gson.TypeAdapterFactory r1 = (com.google.gson.TypeAdapterFactory) r1
            if (r1 == 0) goto L57
            r4 = r1
        L57:
            if (r4 != r7) goto L5a
        L59:
            r7 = r0
        L5a:
            java.util.List r0 = r6.factories
            java.util.Iterator r0 = r0.iterator()
            r1 = 0
        L61:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L7a
            java.lang.Object r2 = r0.next()
            com.google.gson.TypeAdapterFactory r2 = (com.google.gson.TypeAdapterFactory) r2
            if (r1 != 0) goto L73
            if (r2 != r7) goto L61
            r1 = 1
            goto L61
        L73:
            com.google.gson.TypeAdapter r2 = r2.create(r6, r8)
            if (r2 == 0) goto L61
            return r2
        L7a:
            if (r1 != 0) goto L81
            com.google.gson.TypeAdapter r7 = r6.getAdapter(r8)
            return r7
        L81:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "GSON cannot serialize or deserialize "
            r0.<init>(r1)
            r0.append(r8)
            java.lang.String r8 = r0.toString()
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.Gson.getDelegateAdapter(com.google.gson.TypeAdapterFactory, com.google.gson.reflect.TypeToken):com.google.gson.TypeAdapter");
    }

    public final JsonWriter newJsonWriter(Writer writer) {
        JsonWriter jsonWriter = new JsonWriter(writer);
        jsonWriter.setFormattingStyle(this.formattingStyle);
        jsonWriter.htmlSafe = this.htmlSafe;
        jsonWriter.setStrictness(2);
        jsonWriter.serializeNulls = false;
        return jsonWriter;
    }

    public final String toJson(Object obj) {
        if (obj == null) {
            return toJson((JsonElement) JsonNull.INSTANCE);
        }
        Class<?> cls = obj.getClass();
        StringBuilder sb = new StringBuilder();
        try {
            toJson(obj, cls, newJsonWriter(new LogWriter(sb)));
            return sb.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public final String toString() {
        return "{serializeNulls:false,factories:" + this.factories + ",instanceCreators:" + this.constructorConstructor + "}";
    }

    public Gson(Excluder excluder, FieldNamingPolicy fieldNamingPolicy, Map map, boolean z, FormattingStyle formattingStyle, boolean z2, int i, List list, ToNumberPolicy toNumberPolicy, ToNumberPolicy toNumberPolicy2, List list2) {
        TypeAdapters.AnonymousClass31 r5;
        final TypeAdapter typeAdapter;
        TypeAdapters.AnonymousClass31 r6;
        this.threadLocalAdapterResults = new ThreadLocal();
        this.typeTokenCache = new ConcurrentHashMap();
        zzr zzrVar = new zzr(map, z2, list2);
        this.constructorConstructor = zzrVar;
        this.htmlSafe = z;
        this.formattingStyle = formattingStyle;
        ArrayList arrayList = new ArrayList();
        arrayList.add(TypeAdapters.JSON_ELEMENT_FACTORY);
        if (toNumberPolicy == ToNumberPolicy.DOUBLE) {
            r5 = ObjectTypeAdapter.DOUBLE_FACTORY;
        } else {
            r5 = new TypeAdapters.AnonymousClass31(2, toNumberPolicy);
        }
        arrayList.add(r5);
        arrayList.add(excluder);
        arrayList.addAll(list);
        arrayList.add(TypeAdapters.STRING_FACTORY);
        arrayList.add(TypeAdapters.INTEGER_FACTORY);
        arrayList.add(TypeAdapters.BOOLEAN_FACTORY);
        arrayList.add(TypeAdapters.BYTE_FACTORY);
        arrayList.add(TypeAdapters.SHORT_FACTORY);
        if (i == 1) {
            typeAdapter = TypeAdapters.LONG;
        } else {
            typeAdapter = new TypeAdapter() { // from class: com.google.gson.Gson.3
                @Override // com.google.gson.TypeAdapter
                public final Object read(JsonReader jsonReader) {
                    if (jsonReader.peek() != 9) {
                        return Long.valueOf(jsonReader.nextLong());
                    }
                    jsonReader.nextNull();
                    return null;
                }

                @Override // com.google.gson.TypeAdapter
                public final void write(JsonWriter jsonWriter, Object obj) {
                    Number number = (Number) obj;
                    if (number == null) {
                        jsonWriter.nullValue();
                    } else {
                        jsonWriter.value(number.toString());
                    }
                }
            };
        }
        arrayList.add(new TypeAdapters.AnonymousClass30(Long.TYPE, Long.class, typeAdapter));
        arrayList.add(new TypeAdapters.AnonymousClass30(Double.TYPE, Double.class, new AnonymousClass1(0)));
        arrayList.add(new TypeAdapters.AnonymousClass30(Float.TYPE, Float.class, new AnonymousClass1(1)));
        if (toNumberPolicy2 == ToNumberPolicy.LAZILY_PARSED_NUMBER) {
            r6 = NumberTypeAdapter.LAZILY_PARSED_NUMBER_FACTORY;
        } else {
            r6 = new TypeAdapters.AnonymousClass31(1, new NumberTypeAdapter(toNumberPolicy2));
        }
        arrayList.add(r6);
        arrayList.add(TypeAdapters.ATOMIC_INTEGER_FACTORY);
        arrayList.add(TypeAdapters.ATOMIC_BOOLEAN_FACTORY);
        arrayList.add(new TypeAdapters.AnonymousClass29(AtomicLong.class, new TypeAdapter() { // from class: com.google.gson.Gson.4
            @Override // com.google.gson.TypeAdapter
            public final Object read(JsonReader jsonReader) {
                switch (r2) {
                    case 0:
                        return new AtomicLong(((Number) typeAdapter.read(jsonReader)).longValue());
                    default:
                        ArrayList arrayList2 = new ArrayList();
                        jsonReader.beginArray();
                        while (jsonReader.hasNext()) {
                            arrayList2.add(Long.valueOf(((Number) typeAdapter.read(jsonReader)).longValue()));
                        }
                        jsonReader.endArray();
                        int size = arrayList2.size();
                        AtomicLongArray atomicLongArray = new AtomicLongArray(size);
                        for (int i2 = 0; i2 < size; i2++) {
                            atomicLongArray.set(i2, ((Long) arrayList2.get(i2)).longValue());
                        }
                        return atomicLongArray;
                }
            }

            @Override // com.google.gson.TypeAdapter
            public final void write(JsonWriter jsonWriter, Object obj) {
                switch (r2) {
                    case 0:
                        typeAdapter.write(jsonWriter, Long.valueOf(((AtomicLong) obj).get()));
                        return;
                    default:
                        AtomicLongArray atomicLongArray = (AtomicLongArray) obj;
                        jsonWriter.beginArray();
                        int length = atomicLongArray.length();
                        for (int i2 = 0; i2 < length; i2++) {
                            typeAdapter.write(jsonWriter, Long.valueOf(atomicLongArray.get(i2)));
                        }
                        jsonWriter.endArray();
                        return;
                }
            }
        }.nullSafe(), 0));
        arrayList.add(new TypeAdapters.AnonymousClass29(AtomicLongArray.class, new TypeAdapter() { // from class: com.google.gson.Gson.4
            @Override // com.google.gson.TypeAdapter
            public final Object read(JsonReader jsonReader) {
                switch (r2) {
                    case 0:
                        return new AtomicLong(((Number) typeAdapter.read(jsonReader)).longValue());
                    default:
                        ArrayList arrayList2 = new ArrayList();
                        jsonReader.beginArray();
                        while (jsonReader.hasNext()) {
                            arrayList2.add(Long.valueOf(((Number) typeAdapter.read(jsonReader)).longValue()));
                        }
                        jsonReader.endArray();
                        int size = arrayList2.size();
                        AtomicLongArray atomicLongArray = new AtomicLongArray(size);
                        for (int i2 = 0; i2 < size; i2++) {
                            atomicLongArray.set(i2, ((Long) arrayList2.get(i2)).longValue());
                        }
                        return atomicLongArray;
                }
            }

            @Override // com.google.gson.TypeAdapter
            public final void write(JsonWriter jsonWriter, Object obj) {
                switch (r2) {
                    case 0:
                        typeAdapter.write(jsonWriter, Long.valueOf(((AtomicLong) obj).get()));
                        return;
                    default:
                        AtomicLongArray atomicLongArray = (AtomicLongArray) obj;
                        jsonWriter.beginArray();
                        int length = atomicLongArray.length();
                        for (int i2 = 0; i2 < length; i2++) {
                            typeAdapter.write(jsonWriter, Long.valueOf(atomicLongArray.get(i2)));
                        }
                        jsonWriter.endArray();
                        return;
                }
            }
        }.nullSafe(), 0));
        arrayList.add(TypeAdapters.ATOMIC_INTEGER_ARRAY_FACTORY);
        arrayList.add(TypeAdapters.CHARACTER_FACTORY);
        arrayList.add(TypeAdapters.STRING_BUILDER_FACTORY);
        arrayList.add(TypeAdapters.STRING_BUFFER_FACTORY);
        arrayList.add(new TypeAdapters.AnonymousClass29(BigDecimal.class, TypeAdapters.BIG_DECIMAL, 0));
        arrayList.add(new TypeAdapters.AnonymousClass29(BigInteger.class, TypeAdapters.BIG_INTEGER, 0));
        arrayList.add(new TypeAdapters.AnonymousClass29(LazilyParsedNumber.class, TypeAdapters.LAZILY_PARSED_NUMBER, 0));
        arrayList.add(TypeAdapters.URL_FACTORY);
        arrayList.add(TypeAdapters.URI_FACTORY);
        arrayList.add(TypeAdapters.UUID_FACTORY);
        arrayList.add(TypeAdapters.CURRENCY_FACTORY);
        arrayList.add(TypeAdapters.LOCALE_FACTORY);
        arrayList.add(TypeAdapters.INET_ADDRESS_FACTORY);
        arrayList.add(TypeAdapters.BIT_SET_FACTORY);
        arrayList.add(DefaultDateTypeAdapter.DEFAULT_STYLE_FACTORY);
        arrayList.add(TypeAdapters.CALENDAR_FACTORY);
        if (SqlTypesSupport.SUPPORTS_SQL_TYPES) {
            arrayList.add(SqlTypesSupport.TIME_FACTORY);
            arrayList.add(SqlTypesSupport.DATE_FACTORY);
            arrayList.add(SqlTypesSupport.TIMESTAMP_FACTORY);
        }
        arrayList.add(ArrayTypeAdapter.FACTORY);
        arrayList.add(TypeAdapters.CLASS_FACTORY);
        arrayList.add(new MapTypeAdapterFactory(zzrVar, 1));
        arrayList.add(new MapTypeAdapterFactory(zzrVar, 0));
        JsonAdapterAnnotationTypeAdapterFactory jsonAdapterAnnotationTypeAdapterFactory = new JsonAdapterAnnotationTypeAdapterFactory(zzrVar);
        this.jsonAdapterFactory = jsonAdapterAnnotationTypeAdapterFactory;
        arrayList.add(jsonAdapterAnnotationTypeAdapterFactory);
        arrayList.add(TypeAdapters.ENUM_FACTORY);
        arrayList.add(new ReflectiveTypeAdapterFactory(zzrVar, fieldNamingPolicy, excluder, jsonAdapterAnnotationTypeAdapterFactory, list2));
        this.factories = DesugarCollections.unmodifiableList(arrayList);
    }

    public final void toJson(Object obj, Class cls, JsonWriter jsonWriter) {
        TypeAdapter adapter = getAdapter(TypeToken.get((Type) cls));
        int i = jsonWriter.strictness;
        if (i == 2) {
            jsonWriter.strictness = 1;
        }
        boolean z = jsonWriter.htmlSafe;
        boolean z2 = jsonWriter.serializeNulls;
        jsonWriter.htmlSafe = this.htmlSafe;
        jsonWriter.serializeNulls = false;
        try {
            try {
                adapter.write(jsonWriter, obj);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (AssertionError e2) {
                throw new AssertionError("AssertionError (GSON 2.13.2): " + e2.getMessage(), e2);
            }
        } finally {
            jsonWriter.setStrictness(i);
            jsonWriter.htmlSafe = z;
            jsonWriter.serializeNulls = z2;
        }
    }

    public final String toJson(JsonElement jsonElement) {
        StringBuilder sb = new StringBuilder();
        try {
            toJson(jsonElement, newJsonWriter(new LogWriter(sb)));
            return sb.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public final void toJson(JsonElement jsonElement, JsonWriter jsonWriter) {
        int i = jsonWriter.strictness;
        boolean z = jsonWriter.htmlSafe;
        boolean z2 = jsonWriter.serializeNulls;
        jsonWriter.htmlSafe = this.htmlSafe;
        jsonWriter.serializeNulls = false;
        if (i == 2) {
            jsonWriter.strictness = 1;
        }
        try {
            try {
                try {
                    TypeAdapters.JSON_ELEMENT.getClass();
                    JsonElementTypeAdapter.write(jsonElement, jsonWriter);
                    jsonWriter.setStrictness(i);
                    jsonWriter.htmlSafe = z;
                    jsonWriter.serializeNulls = z2;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } catch (AssertionError e2) {
                throw new AssertionError("AssertionError (GSON 2.13.2): " + e2.getMessage(), e2);
            }
        } catch (Throwable th) {
            jsonWriter.setStrictness(i);
            jsonWriter.htmlSafe = z;
            jsonWriter.serializeNulls = z2;
            throw th;
        }
    }
}
