package com.maxmind.db;

import androidx.lifecycle.ViewModelProvider;
import com.maxmind.db.NodeCache;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class Decoder {
    boolean POINTER_TEST_HACK;
    private final ByteBuffer buffer;
    private final NodeCache cache;
    private final NodeCache.Loader cacheLoader;
    private final ConcurrentHashMap<Class, CachedConstructor> constructors;
    private final long pointerBase;
    private final CharsetDecoder utfDecoder;
    private static final Charset UTF_8 = StandardCharsets.UTF_8;
    private static final int[] POINTER_VALUE_OFFSETS = {0, 0, 2048, 526336, 0};

    /* renamed from: com.maxmind.db.Decoder$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$maxmind$db$Type;

        static {
            int[] iArr = new int[Type.values().length];
            $SwitchMap$com$maxmind$db$Type = iArr;
            try {
                iArr[Type.MAP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$maxmind$db$Type[Type.ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$maxmind$db$Type[Type.BOOLEAN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$maxmind$db$Type[Type.UTF8_STRING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$maxmind$db$Type[Type.DOUBLE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$maxmind$db$Type[Type.FLOAT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$maxmind$db$Type[Type.BYTES.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$maxmind$db$Type[Type.UINT16.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$maxmind$db$Type[Type.UINT32.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$maxmind$db$Type[Type.INT32.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$maxmind$db$Type[Type.UINT64.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$maxmind$db$Type[Type.UINT128.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$maxmind$db$Type[Type.POINTER.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    public Decoder(NodeCache nodeCache, ByteBuffer byteBuffer, long j) {
        this(nodeCache, byteBuffer, j, new ConcurrentHashMap());
    }

    private <T, V> List<V> decodeArray(int i, Class<T> cls, Class<V> cls2) {
        List<V> list;
        if (List.class.isAssignableFrom(cls) || cls.equals(Object.class)) {
            if (cls.equals(List.class) || cls.equals(Object.class)) {
                list = new ArrayList<>(i);
            } else {
                try {
                    try {
                        list = (List) cls.getConstructor(Integer.TYPE).newInstance(Integer.valueOf(i));
                    } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
                        throw new DeserializationException("Error creating list: " + e);
                    }
                } catch (NoSuchMethodException e2) {
                    throw new DeserializationException("No constructor found for the List: " + e2);
                }
            }
            for (int i2 = 0; i2 < i; i2++) {
                list.add(cls2.cast(decode(cls2, (Type) null).getValue()));
            }
            return list;
        }
        throw new DeserializationException("Unable to deserialize an array into an " + cls);
    }

    private BigInteger decodeBigInteger(int i) {
        return new BigInteger(1, getByteArray(i));
    }

    private static boolean decodeBoolean(int i) {
        if (i == 0) {
            return false;
        }
        if (i == 1) {
            return true;
        }
        throw new InvalidDatabaseException("The MaxMind DB file's data section contains bad data: invalid size of boolean.");
    }

    private <T> Object decodeByType(Type type, int i, Class<T> cls, Type type2) {
        Class<Object> cls2;
        switch (AnonymousClass1.$SwitchMap$com$maxmind$db$Type[type.ordinal()]) {
            case 1:
                return decodeMap(i, cls, type2);
            case 2:
                if (type2 instanceof ParameterizedType) {
                    Type[] actualTypeArguments = ((ParameterizedType) type2).getActualTypeArguments();
                    if (actualTypeArguments.length == 1) {
                        cls2 = (Class) actualTypeArguments[0];
                        return decodeArray(i, cls, cls2);
                    }
                }
                cls2 = Object.class;
                return decodeArray(i, cls, cls2);
            case 3:
                return Boolean.valueOf(decodeBoolean(i));
            case 4:
                return decodeString(i);
            case 5:
                return Double.valueOf(decodeDouble(i));
            case 6:
                return Float.valueOf(decodeFloat(i));
            case 7:
                return getByteArray(i);
            case 8:
                return Integer.valueOf(decodeUint16(i));
            case 9:
                return Long.valueOf(decodeUint32(i));
            case 10:
                return Integer.valueOf(decodeInt32(i));
            case 11:
            case 12:
                return decodeBigInteger(i);
            default:
                throw new InvalidDatabaseException("Unknown or unexpected type: " + type.name());
        }
    }

    private double decodeDouble(int i) {
        if (i == 8) {
            return this.buffer.getDouble();
        }
        throw new InvalidDatabaseException("The MaxMind DB file's data section contains bad data: invalid size of double.");
    }

    private float decodeFloat(int i) {
        if (i == 4) {
            return this.buffer.getFloat();
        }
        throw new InvalidDatabaseException("The MaxMind DB file's data section contains bad data: invalid size of float.");
    }

    private int decodeInt32(int i) {
        return decodeInteger(i);
    }

    private int decodeInteger(int i) {
        return decodeInteger(0, i);
    }

    private long decodeLong(int i) {
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            j = (j << 8) | (this.buffer.get() & 255);
        }
        return j;
    }

    private <T> Object decodeMap(int i, Class<T> cls, Type type) {
        Class<Object> cls2 = Object.class;
        if (!Map.class.isAssignableFrom(cls) && !cls.equals(cls2)) {
            return decodeMapIntoObject(i, cls);
        }
        if (type instanceof ParameterizedType) {
            Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
            if (actualTypeArguments.length == 2) {
                if (((Class) actualTypeArguments[0]).equals(String.class)) {
                    cls2 = (Class) actualTypeArguments[1];
                } else {
                    throw new DeserializationException("Map keys must be strings.");
                }
            }
        }
        return decodeMapIntoMap(cls, i, cls2);
    }

    private <T, V> Map<String, V> decodeMapIntoMap(Class<T> cls, int i, Class<V> cls2) {
        Map<String, V> map;
        if (cls.equals(Map.class) || cls.equals(Object.class)) {
            map = new HashMap<>(i);
        } else {
            try {
                try {
                    map = (Map) cls.getConstructor(Integer.TYPE).newInstance(Integer.valueOf(i));
                } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
                    throw new DeserializationException("Error creating map: " + e);
                }
            } catch (NoSuchMethodException e2) {
                throw new DeserializationException("No constructor found for the Map: " + e2);
            }
        }
        for (int i2 = 0; i2 < i; i2++) {
            map.put((String) decode(String.class, (Type) null).getValue(), cls2.cast(decode(cls2, (Type) null).getValue()));
        }
        return map;
    }

    private <T> Object decodeMapIntoObject(int i, Class<T> cls) {
        HashMap hashMap;
        Type[] typeArr;
        Class<?>[] clsArr;
        Constructor<T> constructor;
        CachedConstructor cachedConstructor = this.constructors.get(cls);
        if (cachedConstructor == null) {
            constructor = findConstructor(cls);
            clsArr = constructor.getParameterTypes();
            typeArr = constructor.getGenericParameterTypes();
            HashMap hashMap2 = new HashMap();
            Annotation[][] parameterAnnotations = constructor.getParameterAnnotations();
            for (int i2 = 0; i2 < constructor.getParameterTypes().length; i2++) {
                hashMap2.put(getParameterName(cls, i2, parameterAnnotations[i2]), Integer.valueOf(i2));
            }
            this.constructors.put(cls, new CachedConstructor(constructor, clsArr, typeArr, hashMap2));
            hashMap = hashMap2;
        } else {
            Constructor<T> constructor2 = cachedConstructor.getConstructor();
            clsArr = cachedConstructor.getParameterTypes();
            typeArr = cachedConstructor.getParameterGenericTypes();
            Map<String, Integer> parameterIndexes = cachedConstructor.getParameterIndexes();
            constructor = constructor2;
            hashMap = parameterIndexes;
        }
        Object[] objArr = new Object[clsArr.length];
        for (int i3 = 0; i3 < i; i3++) {
            Integer num = hashMap.get((String) decode(String.class, (Type) null).getValue());
            if (num == null) {
                this.buffer.position(nextValueOffset(this.buffer.position(), 1));
            } else {
                objArr[num.intValue()] = decode(clsArr[num.intValue()], typeArr[num.intValue()]).getValue();
            }
        }
        try {
            return constructor.newInstance(objArr);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
            throw new DeserializationException("Error creating object: " + e);
        }
    }

    private String decodeString(int i) {
        int limit = this.buffer.limit();
        ByteBuffer byteBuffer = this.buffer;
        byteBuffer.limit(byteBuffer.position() + i);
        String charBuffer = this.utfDecoder.decode(this.buffer).toString();
        this.buffer.limit(limit);
        return charBuffer;
    }

    private int decodeUint16(int i) {
        return decodeInteger(i);
    }

    private long decodeUint32(int i) {
        return decodeLong(i);
    }

    private static <T> Constructor<T> findConstructor(Class<T> cls) {
        for (Constructor<?> constructor : cls.getConstructors()) {
            Constructor<T> constructor2 = (Constructor<T>) constructor;
            if (constructor2.getAnnotation(MaxMindDbConstructor.class) != null) {
                return constructor2;
            }
        }
        throw new ConstructorNotFoundException("No constructor on class " + cls.getName() + " with the MaxMindDbConstructor annotation was found.");
    }

    private byte[] getByteArray(int i) {
        return getByteArray(this.buffer, i);
    }

    private CtrlData getCtrlData(int i) {
        if (i < this.buffer.capacity()) {
            this.buffer.position(i);
            byte b = this.buffer.get();
            int i2 = b & 255;
            int i3 = i + 1;
            Type fromControlByte = Type.fromControlByte(i2);
            if (fromControlByte.equals(Type.EXTENDED)) {
                int i4 = this.buffer.get() + 7;
                if (i4 >= 8) {
                    fromControlByte = Type.get(i4);
                    i3 = i + 2;
                } else {
                    throw new InvalidDatabaseException("Something went horribly wrong in the decoder. An extended type resolved to a type number < 8 (" + i4 + ")");
                }
            }
            int i5 = b & 31;
            if (i5 >= 29) {
                i3 += i5 - 28;
                if (i5 == 29) {
                    i5 = (this.buffer.get() & 255) + 29;
                } else if (i5 != 30) {
                    i5 = decodeInteger(3) + 65821;
                } else {
                    i5 = decodeInteger(2) + 285;
                }
            }
            return new CtrlData(fromControlByte, i2, i3, i5);
        }
        throw new InvalidDatabaseException("The MaxMind DB file's data section contains bad data: pointer larger than the database.");
    }

    private static <T> String getParameterName(Class<T> cls, int i, Annotation[] annotationArr) {
        for (Annotation annotation : annotationArr) {
            if (annotation.annotationType().equals(MaxMindDbParameter.class)) {
                return ((MaxMindDbParameter) annotation).name();
            }
        }
        StringBuilder m = ViewModelProvider.Factory.CC.m("Constructor parameter ", i, " on class ");
        m.append(cls.getName());
        m.append(" is not annotated with MaxMindDbParameter.");
        throw new ParameterNotFoundException(m.toString());
    }

    private int nextValueOffset(int i, int i2) {
        if (i2 == 0) {
            return i;
        }
        CtrlData ctrlData = getCtrlData(i);
        int ctrlByte = ctrlData.getCtrlByte();
        int size = ctrlData.getSize();
        int offset = ctrlData.getOffset();
        int i3 = AnonymousClass1.$SwitchMap$com$maxmind$db$Type[ctrlData.getType().ordinal()];
        if (i3 == 1) {
            i2 += size * 2;
        } else if (i3 == 2) {
            i2 += size;
        } else if (i3 != 3) {
            offset = i3 != 13 ? offset + size : offset + ((ctrlByte >>> 3) & 3) + 1;
        }
        return nextValueOffset(offset, i2 - 1);
    }

    public <T> T decode(int i, Class<T> cls) {
        if (i < this.buffer.capacity()) {
            this.buffer.position(i);
            return cls.cast(decode(cls, (Type) null).getValue());
        }
        throw new InvalidDatabaseException("The MaxMind DB file's data section contains bad data: pointer larger than the database.");
    }

    public Decoder(NodeCache nodeCache, ByteBuffer byteBuffer, long j, ConcurrentHashMap<Class, CachedConstructor> concurrentHashMap) {
        this.POINTER_TEST_HACK = false;
        this.utfDecoder = UTF_8.newDecoder();
        this.cacheLoader = new NodeCache.Loader() { // from class: com.maxmind.db.Decoder$$ExternalSyntheticLambda0
            @Override // com.maxmind.db.NodeCache.Loader
            public final DecodedValue load(CacheKey cacheKey) {
                DecodedValue decode;
                decode = Decoder.this.decode(cacheKey);
                return decode;
            }
        };
        this.cache = nodeCache;
        this.pointerBase = j;
        this.buffer = byteBuffer;
        this.constructors = concurrentHashMap;
    }

    private int decodeInteger(int i, int i2) {
        return decodeInteger(this.buffer, i, i2);
    }

    private static byte[] getByteArray(ByteBuffer byteBuffer, int i) {
        byte[] bArr = new byte[i];
        byteBuffer.get(bArr);
        return bArr;
    }

    public static int decodeInteger(ByteBuffer byteBuffer, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            i = (i << 8) | (byteBuffer.get() & 255);
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T> DecodedValue decode(CacheKey<T> cacheKey) {
        int offset = cacheKey.getOffset();
        if (offset < this.buffer.capacity()) {
            this.buffer.position(offset);
            return decode(cacheKey.getCls(), cacheKey.getType());
        }
        throw new InvalidDatabaseException("The MaxMind DB file's data section contains bad data: pointer larger than the database.");
    }

    private <T> DecodedValue decode(Class<T> cls, Type type) {
        byte b = this.buffer.get();
        int i = b & 255;
        Type fromControlByte = Type.fromControlByte(i);
        if (fromControlByte.equals(Type.POINTER)) {
            int i2 = ((i >>> 3) & 3) + 1;
            long decodeInteger = decodeInteger(i2 == 4 ? (byte) 0 : (byte) (b & 7), i2) + this.pointerBase + POINTER_VALUE_OFFSETS[i2];
            if (this.POINTER_TEST_HACK) {
                return new DecodedValue(Long.valueOf(decodeInteger));
            }
            int position = this.buffer.position();
            DecodedValue decodedValue = this.cache.get(new CacheKey((int) decodeInteger, cls, type), this.cacheLoader);
            this.buffer.position(position);
            return decodedValue;
        }
        if (fromControlByte.equals(Type.EXTENDED)) {
            int i3 = this.buffer.get() + 7;
            if (i3 >= 8) {
                fromControlByte = Type.get(i3);
            } else {
                throw new InvalidDatabaseException("Something went horribly wrong in the decoder. An extended type resolved to a type number < 8 (" + i3 + ")");
            }
        }
        int i4 = b & 31;
        if (i4 >= 29) {
            if (i4 == 29) {
                i4 = (this.buffer.get() & 255) + 29;
            } else if (i4 != 30) {
                i4 = 65821 + decodeInteger(3);
            } else {
                i4 = decodeInteger(2) + 285;
            }
        }
        return new DecodedValue(decodeByType(fromControlByte, i4, cls, type));
    }
}
