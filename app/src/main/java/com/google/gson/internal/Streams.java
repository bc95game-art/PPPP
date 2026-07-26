package com.google.gson.internal;

import androidx.lifecycle.ViewModelProvider;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.MalformedJsonException;
import java.io.EOFException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import p004j$.util.Objects;
/* loaded from: classes.dex */
public abstract class Streams {
    public static final Type[] EMPTY_TYPE_ARRAY = new Type[0];

    public static Type canonicalize(Type type) {
        if (type instanceof Class) {
            Class cls = (Class) type;
            if (cls.isArray()) {
                return new GsonTypes$GenericArrayTypeImpl(canonicalize(cls.getComponentType()));
            }
            return cls;
        } else if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            return new GsonTypes$ParameterizedTypeImpl(parameterizedType.getOwnerType(), (Class) parameterizedType.getRawType(), parameterizedType.getActualTypeArguments());
        } else if (type instanceof GenericArrayType) {
            return new GsonTypes$GenericArrayTypeImpl(((GenericArrayType) type).getGenericComponentType());
        } else {
            if (!(type instanceof WildcardType)) {
                return type;
            }
            WildcardType wildcardType = (WildcardType) type;
            return new GsonTypes$WildcardTypeImpl(wildcardType.getUpperBounds(), wildcardType.getLowerBounds());
        }
    }

    public static void checkNotPrimitive(Type type) {
        if ((type instanceof Class) && ((Class) type).isPrimitive()) {
            throw new IllegalArgumentException("Primitive type is not allowed");
        }
    }

    public static void checkNumberStringLength(String str) {
        if (str.length() > 10000) {
            throw new NumberFormatException("Number string too large: " + str.substring(0, 30) + "...");
        }
    }

    public static boolean equals(Type type, Type type2) {
        if (type == type2) {
            return true;
        }
        if (type instanceof Class) {
            return type.equals(type2);
        }
        if (type instanceof ParameterizedType) {
            if (!(type2 instanceof ParameterizedType)) {
                return false;
            }
            ParameterizedType parameterizedType = (ParameterizedType) type;
            ParameterizedType parameterizedType2 = (ParameterizedType) type2;
            if (!Objects.equals(parameterizedType.getOwnerType(), parameterizedType2.getOwnerType()) || !parameterizedType.getRawType().equals(parameterizedType2.getRawType()) || !Arrays.equals(parameterizedType.getActualTypeArguments(), parameterizedType2.getActualTypeArguments())) {
                return false;
            }
            return true;
        } else if (type instanceof GenericArrayType) {
            if (!(type2 instanceof GenericArrayType)) {
                return false;
            }
            return equals(((GenericArrayType) type).getGenericComponentType(), ((GenericArrayType) type2).getGenericComponentType());
        } else if (type instanceof WildcardType) {
            if (!(type2 instanceof WildcardType)) {
                return false;
            }
            WildcardType wildcardType = (WildcardType) type;
            WildcardType wildcardType2 = (WildcardType) type2;
            if (!Arrays.equals(wildcardType.getUpperBounds(), wildcardType2.getUpperBounds()) || !Arrays.equals(wildcardType.getLowerBounds(), wildcardType2.getLowerBounds())) {
                return false;
            }
            return true;
        } else if (!(type instanceof TypeVariable) || !(type2 instanceof TypeVariable)) {
            return false;
        } else {
            TypeVariable typeVariable = (TypeVariable) type;
            TypeVariable typeVariable2 = (TypeVariable) type2;
            if (!Objects.equals(typeVariable.getGenericDeclaration(), typeVariable2.getGenericDeclaration()) || !typeVariable.getName().equals(typeVariable2.getName())) {
                return false;
            }
            return true;
        }
    }

    public static void getFilterResult(List list) {
        Iterator it = list.iterator();
        if (it.hasNext()) {
            throw ViewModelProvider.Factory.CC.m592m(it);
        }
    }

    public static Type getGenericSupertype(Type type, Class cls, Class cls2) {
        if (cls2 == cls) {
            return type;
        }
        if (cls2.isInterface()) {
            Class<?>[] interfaces = cls.getInterfaces();
            int length = interfaces.length;
            for (int i = 0; i < length; i++) {
                Class<?> cls3 = interfaces[i];
                if (cls3 == cls2) {
                    return cls.getGenericInterfaces()[i];
                }
                if (cls2.isAssignableFrom(cls3)) {
                    return getGenericSupertype(cls.getGenericInterfaces()[i], interfaces[i], cls2);
                }
            }
        }
        if (!cls.isInterface()) {
            while (cls != Object.class) {
                Class<?> superclass = cls.getSuperclass();
                if (superclass == cls2) {
                    return cls.getGenericSuperclass();
                }
                if (cls2.isAssignableFrom(superclass)) {
                    return getGenericSupertype(cls.getGenericSuperclass(), superclass, cls2);
                }
                cls = superclass;
            }
        }
        return cls2;
    }

    public static Class getRawType(Type type) {
        String str;
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            return (Class) ((ParameterizedType) type).getRawType();
        }
        if (type instanceof GenericArrayType) {
            return Array.newInstance(getRawType(((GenericArrayType) type).getGenericComponentType()), 0).getClass();
        }
        if (type instanceof TypeVariable) {
            return Object.class;
        }
        if (type instanceof WildcardType) {
            return getRawType(((WildcardType) type).getUpperBounds()[0]);
        }
        if (type == null) {
            str = "null";
        } else {
            str = type.getClass().getName();
        }
        throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type + "> is of type " + str);
    }

    public static Type getSupertype(Type type, Class cls, Class cls2) {
        if (type instanceof WildcardType) {
            type = ((WildcardType) type).getUpperBounds()[0];
        }
        if (cls2.isAssignableFrom(cls)) {
            return resolve(type, cls, getGenericSupertype(type, cls, cls2), new HashMap());
        }
        throw new IllegalArgumentException(cls + " is not the same as or a subtype of " + cls2);
    }

    public static JsonElement parse(JsonReader jsonReader) {
        EOFException e;
        boolean z;
        try {
            try {
                jsonReader.peek();
                z = false;
            } catch (EOFException e2) {
                e = e2;
                z = true;
            }
            try {
                return (JsonElement) TypeAdapters.JSON_ELEMENT.read(jsonReader);
            } catch (EOFException e3) {
                e = e3;
                if (z) {
                    return JsonNull.INSTANCE;
                }
                throw new RuntimeException(e);
            }
        } catch (MalformedJsonException e4) {
            throw new RuntimeException(e4);
        } catch (IOException e5) {
            throw new RuntimeException(e5);
        } catch (NumberFormatException e6) {
            throw new RuntimeException(e6);
        }
    }

    public static BigDecimal parseBigDecimal(String str) {
        checkNumberStringLength(str);
        BigDecimal bigDecimal = new BigDecimal(str);
        if (Math.abs(bigDecimal.scale()) < 10000) {
            return bigDecimal;
        }
        throw new NumberFormatException("Number has unsupported scale: ".concat(str));
    }

    /* JADX WARN: Code restructure failed: missing block: B:81:0x0144, code lost:
        if (r1 == null) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0146, code lost:
        r13.put(r1, r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0149, code lost:
        return r12;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0144 A[EDGE_INSN: B:88:0x0144->B:81:0x0144 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r12v0, types: [java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r12v1, types: [java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r12v10, types: [java.lang.reflect.Type, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v13 */
    /* JADX WARN: Type inference failed for: r12v14 */
    /* JADX WARN: Type inference failed for: r12v17 */
    /* JADX WARN: Type inference failed for: r12v2, types: [java.lang.reflect.WildcardType] */
    /* JADX WARN: Type inference failed for: r12v3, types: [com.google.gson.internal.GsonTypes$WildcardTypeImpl] */
    /* JADX WARN: Type inference failed for: r12v4, types: [com.google.gson.internal.GsonTypes$WildcardTypeImpl] */
    /* JADX WARN: Type inference failed for: r12v5, types: [java.lang.reflect.ParameterizedType] */
    /* JADX WARN: Type inference failed for: r12v6, types: [java.lang.reflect.GenericArrayType] */
    /* JADX WARN: Type inference failed for: r12v7 */
    /* JADX WARN: Type inference failed for: r12v9 */
    /* JADX WARN: Type inference failed for: r13v0, types: [java.util.HashMap] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Type resolve(Type type, Class cls, Type type2, HashMap hashMap) {
        Type[] typeArr;
        Type[] typeArr2;
        Type gsonTypes$ParameterizedTypeImpl;
        Class cls2;
        TypeVariable typeVariable = null;
        while (true) {
            int i = 0;
            if (type2 instanceof TypeVariable) {
                TypeVariable typeVariable2 = type2;
                Type type3 = (Type) hashMap.get(typeVariable2);
                Class cls3 = Void.TYPE;
                if (type3 == null) {
                    hashMap.put(typeVariable2, cls3);
                    if (typeVariable == null) {
                        typeVariable = typeVariable2;
                    }
                    GenericDeclaration genericDeclaration = typeVariable2.getGenericDeclaration();
                    if (genericDeclaration instanceof Class) {
                        cls2 = (Class) genericDeclaration;
                    } else {
                        cls2 = null;
                    }
                    if (cls2 != null) {
                        Type genericSupertype = getGenericSupertype(type, cls, cls2);
                        if (genericSupertype instanceof ParameterizedType) {
                            TypeVariable[] typeParameters = cls2.getTypeParameters();
                            int length = typeParameters.length;
                            while (i < length) {
                                if (typeVariable2.equals(typeParameters[i])) {
                                    type2 = ((ParameterizedType) genericSupertype).getActualTypeArguments()[i];
                                    continue;
                                    if (type2 == typeVariable2) {
                                        break;
                                    }
                                } else {
                                    i++;
                                }
                            }
                            throw new NoSuchElementException();
                        }
                    }
                    type2 = typeVariable2;
                    continue;
                    if (type2 == typeVariable2) {
                    }
                } else if (type3 == cls3) {
                    return type2;
                } else {
                    return type3;
                }
            } else {
                if (type2 instanceof Class) {
                    Class cls4 = type2;
                    if (cls4.isArray()) {
                        Class<?> componentType = cls4.getComponentType();
                        Type resolve = resolve(type, cls, componentType, hashMap);
                        if (Objects.equals(componentType, resolve)) {
                            type2 = cls4;
                        } else {
                            gsonTypes$ParameterizedTypeImpl = new GsonTypes$GenericArrayTypeImpl(resolve);
                            type2 = gsonTypes$ParameterizedTypeImpl;
                        }
                    }
                }
                if (type2 instanceof GenericArrayType) {
                    type2 = (GenericArrayType) type2;
                    Type genericComponentType = type2.getGenericComponentType();
                    Type resolve2 = resolve(type, cls, genericComponentType, hashMap);
                    if (!Objects.equals(genericComponentType, resolve2)) {
                        gsonTypes$ParameterizedTypeImpl = new GsonTypes$GenericArrayTypeImpl(resolve2);
                        type2 = gsonTypes$ParameterizedTypeImpl;
                    }
                } else if (type2 instanceof ParameterizedType) {
                    type2 = (ParameterizedType) type2;
                    Type ownerType = type2.getOwnerType();
                    Type resolve3 = resolve(type, cls, ownerType, hashMap);
                    boolean equals = Objects.equals(resolve3, ownerType);
                    Type[] actualTypeArguments = type2.getActualTypeArguments();
                    int length2 = actualTypeArguments.length;
                    Type[] typeArr3 = actualTypeArguments;
                    boolean z = false;
                    while (i < length2) {
                        Type resolve4 = resolve(type, cls, typeArr3[i], hashMap);
                        if (!Objects.equals(resolve4, typeArr3[i])) {
                            if (!z) {
                                typeArr3 = (Type[]) typeArr3.clone();
                                z = true;
                            }
                            typeArr3[i] = resolve4;
                        }
                        i++;
                    }
                    if (!equals || z) {
                        gsonTypes$ParameterizedTypeImpl = new GsonTypes$ParameterizedTypeImpl(resolve3, (Class) type2.getRawType(), typeArr3);
                        type2 = gsonTypes$ParameterizedTypeImpl;
                    }
                } else if (type2 instanceof WildcardType) {
                    type2 = (WildcardType) type2;
                    Type[] lowerBounds = type2.getLowerBounds();
                    Type[] upperBounds = type2.getUpperBounds();
                    if (lowerBounds.length == 1) {
                        Type resolve5 = resolve(type, cls, lowerBounds[0], hashMap);
                        if (resolve5 != lowerBounds[0]) {
                            if (resolve5 instanceof WildcardType) {
                                typeArr2 = ((WildcardType) resolve5).getLowerBounds();
                            } else {
                                typeArr2 = new Type[]{resolve5};
                            }
                            type2 = new GsonTypes$WildcardTypeImpl(new Type[]{Object.class}, typeArr2);
                        }
                    } else if (upperBounds.length == 1) {
                        Type resolve6 = resolve(type, cls, upperBounds[0], hashMap);
                        if (resolve6 != upperBounds[0]) {
                            if (resolve6 instanceof WildcardType) {
                                typeArr = ((WildcardType) resolve6).getUpperBounds();
                            } else {
                                typeArr = new Type[]{resolve6};
                            }
                            type2 = new GsonTypes$WildcardTypeImpl(typeArr, EMPTY_TYPE_ARRAY);
                        }
                    }
                }
            }
        }
    }

    public static String typeToString(Type type) {
        if (type instanceof Class) {
            return ((Class) type).getName();
        }
        return type.toString();
    }

    public static Class wrap(Class cls) {
        if (cls == Integer.TYPE) {
            return Integer.class;
        }
        if (cls == Float.TYPE) {
            return Float.class;
        }
        if (cls == Byte.TYPE) {
            return Byte.class;
        }
        if (cls == Double.TYPE) {
            return Double.class;
        }
        if (cls == Long.TYPE) {
            return Long.class;
        }
        if (cls == Character.TYPE) {
            return Character.class;
        }
        if (cls == Boolean.TYPE) {
            return Boolean.class;
        }
        if (cls == Short.TYPE) {
            return Short.class;
        }
        if (cls == Void.TYPE) {
            return Void.class;
        }
        return cls;
    }
}
