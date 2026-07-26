package com.google.gson.internal.bind;

import androidx.lifecycle.ViewModelProvider;
import com.google.android.gms.tasks.zzr;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.internal.Streams;
import com.google.gson.internal.bind.MapTypeAdapterFactory;
import com.google.gson.internal.reflect.ReflectionHelper;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.LazyKt__LazyJVMKt;
/* loaded from: classes.dex */
public final class ReflectiveTypeAdapterFactory implements TypeAdapterFactory {
    public final zzr constructorConstructor;
    public final Excluder excluder;
    public final FieldNamingPolicy fieldNamingPolicy;
    public final JsonAdapterAnnotationTypeAdapterFactory jsonAdapterFactory;
    public final List reflectionFilters;

    /* renamed from: com.google.gson.internal.bind.ReflectiveTypeAdapterFactory$2  reason: invalid class name */
    /* loaded from: classes.dex */
    public final class AnonymousClass2 {
        public final Field field;
        public final String fieldName;
        public final String serializedName;
        public final /* synthetic */ Method val$accessor;
        public final /* synthetic */ boolean val$isPrimitive;
        public final /* synthetic */ boolean val$isStaticFinalField;
        public final /* synthetic */ TypeAdapter val$typeAdapter;
        public final /* synthetic */ TypeAdapter val$writeTypeAdapter;

        public AnonymousClass2(String str, Field field, Method method, TypeAdapter typeAdapter, TypeAdapter typeAdapter2, boolean z, boolean z2) {
            this.val$accessor = method;
            this.val$writeTypeAdapter = typeAdapter;
            this.val$typeAdapter = typeAdapter2;
            this.val$isPrimitive = z;
            this.val$isStaticFinalField = z2;
            this.serializedName = str;
            this.field = field;
            this.fieldName = field.getName();
        }

        public final void write(JsonWriter jsonWriter, Object obj) {
            Object obj2;
            Method method = this.val$accessor;
            if (method != null) {
                try {
                    obj2 = method.invoke(obj, null);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(ViewModelProvider.Factory.CC.m("Accessor ", ReflectionHelper.getAccessibleObjectDescription(method, false), " threw exception"), e.getCause());
                }
            } else {
                obj2 = this.field.get(obj);
            }
            if (obj2 != obj) {
                jsonWriter.name(this.serializedName);
                this.val$writeTypeAdapter.write(jsonWriter, obj2);
            }
        }
    }

    /* loaded from: classes.dex */
    public abstract class Adapter extends TypeAdapter {
        public final FieldsData fieldsData;

        public Adapter(FieldsData fieldsData) {
            this.fieldsData = fieldsData;
        }

        public abstract Object createAccumulator();

        public abstract Object finalize(Object obj);

        @Override // com.google.gson.TypeAdapter
        public final Object read(JsonReader jsonReader) {
            if (jsonReader.peek() == 9) {
                jsonReader.nextNull();
                return null;
            }
            Object createAccumulator = createAccumulator();
            Map map = this.fieldsData.deserializedFields;
            try {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    AnonymousClass2 r2 = (AnonymousClass2) map.get(jsonReader.nextName());
                    if (r2 == null) {
                        jsonReader.skipValue();
                    } else {
                        readField(createAccumulator, jsonReader, r2);
                    }
                }
                jsonReader.endObject();
                return finalize(createAccumulator);
            } catch (IllegalAccessException e) {
                LazyKt__LazyJVMKt lazyKt__LazyJVMKt = ReflectionHelper.RECORD_HELPER;
                throw new RuntimeException("Unexpected IllegalAccessException occurred (Gson 2.13.2). Certain ReflectionAccessFilter features require Java >= 9 to work correctly. If you are not using ReflectionAccessFilter, report this to the Gson maintainers.", e);
            } catch (IllegalStateException e2) {
                throw new RuntimeException(e2);
            }
        }

        public abstract void readField(Object obj, JsonReader jsonReader, AnonymousClass2 r3);

        @Override // com.google.gson.TypeAdapter
        public final void write(JsonWriter jsonWriter, Object obj) {
            if (obj == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            try {
                for (AnonymousClass2 r1 : this.fieldsData.serializedFields) {
                    r1.write(jsonWriter, obj);
                }
                jsonWriter.endObject();
            } catch (IllegalAccessException e) {
                LazyKt__LazyJVMKt lazyKt__LazyJVMKt = ReflectionHelper.RECORD_HELPER;
                throw new RuntimeException("Unexpected IllegalAccessException occurred (Gson 2.13.2). Certain ReflectionAccessFilter features require Java >= 9 to work correctly. If you are not using ReflectionAccessFilter, report this to the Gson maintainers.", e);
            }
        }
    }

    /* loaded from: classes.dex */
    public final class FieldReflectionAdapter extends Adapter {
        public final ObjectConstructor constructor;

        public FieldReflectionAdapter(ObjectConstructor objectConstructor, FieldsData fieldsData) {
            super(fieldsData);
            this.constructor = objectConstructor;
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
        public final Object createAccumulator() {
            return this.constructor.construct();
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
        public final Object finalize(Object obj) {
            return obj;
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
        public final void readField(Object obj, JsonReader jsonReader, AnonymousClass2 r5) {
            Field field = r5.field;
            Object read = r5.val$typeAdapter.read(jsonReader);
            if (read == null && r5.val$isPrimitive) {
                return;
            }
            if (!r5.val$isStaticFinalField) {
                field.set(obj, read);
                return;
            }
            String accessibleObjectDescription = ReflectionHelper.getAccessibleObjectDescription(field, false);
            throw new RuntimeException("Cannot set value of 'static final' " + accessibleObjectDescription);
        }
    }

    /* loaded from: classes.dex */
    public final class FieldsData {
        public static final FieldsData EMPTY = new FieldsData(Collections.EMPTY_MAP, Collections.EMPTY_LIST);
        public final Map deserializedFields;
        public final List serializedFields;

        public FieldsData(Map map, List list) {
            this.deserializedFields = map;
            this.serializedFields = list;
        }
    }

    /* loaded from: classes.dex */
    public final class RecordAdapter extends Adapter {
        public static final HashMap PRIMITIVE_DEFAULTS;
        public final HashMap componentIndices = new HashMap();
        public final Constructor constructor;
        public final Object[] constructorArgsDefaults;

        static {
            HashMap hashMap = new HashMap();
            hashMap.put(Byte.TYPE, (byte) 0);
            hashMap.put(Short.TYPE, (short) 0);
            hashMap.put(Integer.TYPE, 0);
            hashMap.put(Long.TYPE, 0L);
            hashMap.put(Float.TYPE, Float.valueOf(0.0f));
            hashMap.put(Double.TYPE, Double.valueOf(0.0d));
            hashMap.put(Character.TYPE, (char) 0);
            hashMap.put(Boolean.TYPE, Boolean.FALSE);
            PRIMITIVE_DEFAULTS = hashMap;
        }

        public RecordAdapter(Class cls, FieldsData fieldsData) {
            super(fieldsData);
            LazyKt__LazyJVMKt lazyKt__LazyJVMKt = ReflectionHelper.RECORD_HELPER;
            Constructor canonicalRecordConstructor = lazyKt__LazyJVMKt.getCanonicalRecordConstructor(cls);
            this.constructor = canonicalRecordConstructor;
            ReflectionHelper.makeAccessible(canonicalRecordConstructor);
            String[] recordComponentNames = lazyKt__LazyJVMKt.getRecordComponentNames(cls);
            for (int i = 0; i < recordComponentNames.length; i++) {
                this.componentIndices.put(recordComponentNames[i], Integer.valueOf(i));
            }
            Class<?>[] parameterTypes = this.constructor.getParameterTypes();
            this.constructorArgsDefaults = new Object[parameterTypes.length];
            for (int i2 = 0; i2 < parameterTypes.length; i2++) {
                this.constructorArgsDefaults[i2] = PRIMITIVE_DEFAULTS.get(parameterTypes[i2]);
            }
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
        public final Object createAccumulator() {
            return (Object[]) this.constructorArgsDefaults.clone();
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
        public final Object finalize(Object obj) {
            Throwable e;
            Object[] objArr = (Object[]) obj;
            Constructor constructor = this.constructor;
            try {
                return constructor.newInstance(objArr);
            } catch (IllegalAccessException e2) {
                LazyKt__LazyJVMKt lazyKt__LazyJVMKt = ReflectionHelper.RECORD_HELPER;
                throw new RuntimeException("Unexpected IllegalAccessException occurred (Gson 2.13.2). Certain ReflectionAccessFilter features require Java >= 9 to work correctly. If you are not using ReflectionAccessFilter, report this to the Gson maintainers.", e2);
            } catch (IllegalArgumentException e3) {
                e = e3;
                throw new RuntimeException("Failed to invoke constructor '" + ReflectionHelper.constructorToString(constructor) + "' with args " + Arrays.toString(objArr), e);
            } catch (InstantiationException e4) {
                e = e4;
                throw new RuntimeException("Failed to invoke constructor '" + ReflectionHelper.constructorToString(constructor) + "' with args " + Arrays.toString(objArr), e);
            } catch (InvocationTargetException e5) {
                throw new RuntimeException("Failed to invoke constructor '" + ReflectionHelper.constructorToString(constructor) + "' with args " + Arrays.toString(objArr), e5.getCause());
            }
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
        public final void readField(Object obj, JsonReader jsonReader, AnonymousClass2 r6) {
            Object[] objArr = (Object[]) obj;
            String str = r6.fieldName;
            Integer num = (Integer) this.componentIndices.get(str);
            if (num != null) {
                int intValue = num.intValue();
                Object read = r6.val$typeAdapter.read(jsonReader);
                if (read != null || !r6.val$isPrimitive) {
                    objArr[intValue] = read;
                    return;
                }
                StringBuilder m = ViewModelProvider.Factory.CC.m15m("null is not allowed as value for record component '", str, "' of primitive type; at path ");
                m.append(jsonReader.getPath(false));
                throw new RuntimeException(m.toString());
            }
            throw new IllegalStateException("Could not find the index in the constructor '" + ReflectionHelper.constructorToString(this.constructor) + "' for field with name '" + str + "', unable to determine which argument in the constructor the field corresponds to. This is unexpected behavior, as we expect the RecordComponents to have the same names as the fields in the Java class, and that the order of the RecordComponents is the same as the order of the canonical constructor parameters.");
        }
    }

    public ReflectiveTypeAdapterFactory(zzr zzrVar, FieldNamingPolicy fieldNamingPolicy, Excluder excluder, JsonAdapterAnnotationTypeAdapterFactory jsonAdapterAnnotationTypeAdapterFactory, List list) {
        this.constructorConstructor = zzrVar;
        this.fieldNamingPolicy = fieldNamingPolicy;
        this.excluder = excluder;
        this.jsonAdapterFactory = jsonAdapterAnnotationTypeAdapterFactory;
        this.reflectionFilters = list;
    }

    public static void createDuplicateFieldException(Class cls, String str, Field field, Field field2) {
        throw new IllegalArgumentException("Class " + cls.getName() + " declares multiple JSON fields named '" + str + "'; conflict is caused by fields " + ReflectionHelper.fieldToString(field) + " and " + ReflectionHelper.fieldToString(field2) + "\nSee " + "https://github.com/google/gson/blob/main/Troubleshooting.md#".concat("duplicate-fields"));
    }

    @Override // com.google.gson.TypeAdapterFactory
    public final TypeAdapter create(Gson gson, TypeToken typeToken) {
        Class rawType = typeToken.getRawType();
        if (!Object.class.isAssignableFrom(rawType)) {
            return null;
        }
        LazyKt__LazyJVMKt lazyKt__LazyJVMKt = ReflectionHelper.RECORD_HELPER;
        if (!Modifier.isStatic(rawType.getModifiers()) && (rawType.isAnonymousClass() || rawType.isLocalClass())) {
            return new Gson.AnonymousClass1(2);
        }
        Streams.getFilterResult(this.reflectionFilters);
        if (ReflectionHelper.RECORD_HELPER.isRecord(rawType)) {
            return new RecordAdapter(rawType, getBoundFields(gson, typeToken, rawType, true));
        }
        return new FieldReflectionAdapter(this.constructorConstructor.get(typeToken, true), getBoundFields(gson, typeToken, rawType, false));
    }

    public final FieldsData getBoundFields(Gson gson, TypeToken typeToken, Class cls, boolean z) {
        boolean z2;
        Method method;
        List list;
        String str;
        ArrayList arrayList;
        boolean z3;
        boolean z4;
        List<String> list2;
        Field field;
        Gson gson2;
        TypeAdapter typeAdapter;
        boolean z5;
        TypeAdapter typeAdapter2;
        AnonymousClass2 r2;
        TypeAdapter typeAdapter3;
        if (cls.isInterface()) {
            return FieldsData.EMPTY;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        TypeToken typeToken2 = typeToken;
        Class cls2 = cls;
        while (cls2 != Object.class) {
            Field[] declaredFields = cls2.getDeclaredFields();
            if (cls2 != cls && declaredFields.length > 0) {
                Streams.getFilterResult(this.reflectionFilters);
            }
            int length = declaredFields.length;
            boolean z6 = false;
            int i = 0;
            while (i < length) {
                Field field2 = declaredFields[i];
                boolean includeField = includeField(field2, true);
                boolean includeField2 = includeField(field2, z6);
                if (includeField || includeField2) {
                    if (!z) {
                        z2 = includeField2;
                        method = null;
                    } else if (Modifier.isStatic(field2.getModifiers())) {
                        method = null;
                        z2 = false;
                    } else {
                        Method accessor = ReflectionHelper.RECORD_HELPER.getAccessor(cls2, field2);
                        ReflectionHelper.makeAccessible(accessor);
                        if (accessor.getAnnotation(SerializedName.class) == null || field2.getAnnotation(SerializedName.class) != null) {
                            z2 = includeField2;
                            method = accessor;
                        } else {
                            throw new RuntimeException(ViewModelProvider.Factory.CC.m("@SerializedName on ", ReflectionHelper.getAccessibleObjectDescription(accessor, z6), " is not supported"));
                        }
                    }
                    if (method == null) {
                        ReflectionHelper.makeAccessible(field2);
                    }
                    Type resolve = Streams.resolve(typeToken2.getType(), cls2, field2.getGenericType(), new HashMap());
                    SerializedName serializedName = (SerializedName) field2.getAnnotation(SerializedName.class);
                    if (serializedName == null) {
                        str = this.fieldNamingPolicy.translateName(field2);
                        list = Collections.EMPTY_LIST;
                    } else {
                        String value = serializedName.value();
                        list = Arrays.asList(serializedName.alternate());
                        str = value;
                    }
                    if (list.isEmpty()) {
                        arrayList = Collections.singletonList(str);
                    } else {
                        ArrayList arrayList2 = new ArrayList(list.size() + 1);
                        arrayList2.add(str);
                        arrayList2.addAll(list);
                        arrayList = arrayList2;
                    }
                    int i2 = z6 ? 1 : 0;
                    int i3 = z6 ? 1 : 0;
                    String str2 = (String) arrayList.get(i2);
                    TypeToken<?> typeToken3 = TypeToken.get(resolve);
                    Class<? super Object> rawType = typeToken3.getRawType();
                    if (rawType == null || !rawType.isPrimitive()) {
                        z3 = false;
                    } else {
                        z3 = true;
                    }
                    int modifiers = field2.getModifiers();
                    if (!Modifier.isStatic(modifiers) || !Modifier.isFinal(modifiers)) {
                        z4 = false;
                    } else {
                        z4 = true;
                    }
                    JsonAdapter jsonAdapter = (JsonAdapter) field2.getAnnotation(JsonAdapter.class);
                    if (jsonAdapter != null) {
                        field = field2;
                        list2 = arrayList;
                        gson2 = gson;
                        typeAdapter = this.jsonAdapterFactory.getTypeAdapter(this.constructorConstructor, gson2, typeToken3, jsonAdapter, false);
                    } else {
                        gson2 = gson;
                        field = field2;
                        list2 = arrayList;
                        typeAdapter = null;
                    }
                    if (typeAdapter != null) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (typeAdapter == null) {
                        typeAdapter = gson2.getAdapter(typeToken3);
                    }
                    if (includeField) {
                        if (z5) {
                            typeAdapter3 = typeAdapter;
                        } else {
                            typeAdapter3 = new MapTypeAdapterFactory.Adapter(gson2, typeAdapter, typeToken3.getType());
                        }
                        typeAdapter2 = typeAdapter3;
                    } else {
                        typeAdapter2 = typeAdapter;
                    }
                    AnonymousClass2 r16 = new AnonymousClass2(str2, field, method, typeAdapter2, typeAdapter, z3, z4);
                    Field field3 = field;
                    if (z2) {
                        for (String str3 : list2) {
                            AnonymousClass2 r14 = (AnonymousClass2) linkedHashMap.put(str3, r16);
                            if (r14 != null) {
                                createDuplicateFieldException(cls, str3, r14.field, field3);
                                throw null;
                            }
                        }
                    }
                    if (includeField && (r2 = (AnonymousClass2) linkedHashMap2.put(str2, r16)) != null) {
                        createDuplicateFieldException(cls, str2, r2.field, field3);
                        throw null;
                    }
                }
                i++;
                z6 = false;
            }
            typeToken2 = TypeToken.get(Streams.resolve(typeToken2.getType(), cls2, cls2.getGenericSuperclass(), new HashMap()));
            cls2 = typeToken2.getRawType();
        }
        return new FieldsData(linkedHashMap, new ArrayList(linkedHashMap2.values()));
    }

    public final boolean includeField(Field field, boolean z) {
        boolean z2;
        List list;
        Excluder excluder = this.excluder;
        excluder.getClass();
        if ((136 & field.getModifiers()) == 0 && !field.isSynthetic() && !excluder.excludeClass(field.getType(), z)) {
            if (z) {
                list = excluder.serializationStrategies;
            } else {
                list = excluder.deserializationStrategies;
            }
            if (!list.isEmpty()) {
                Iterator it = list.iterator();
                if (it.hasNext()) {
                    throw ViewModelProvider.Factory.CC.m(it);
                }
            }
            z2 = false;
        } else {
            z2 = true;
        }
        return !z2;
    }
}
