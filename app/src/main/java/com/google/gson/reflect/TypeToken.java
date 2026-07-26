package com.google.gson.reflect;

import com.google.gson.internal.GsonTypes$GenericArrayTypeImpl;
import com.google.gson.internal.GsonTypes$ParameterizedTypeImpl;
import com.google.gson.internal.Streams;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.HashMap;
import p004j$.util.Objects;
/* loaded from: classes.dex */
public class TypeToken<T> {
    private final int hashCode;
    private final Class<? super T> rawType;
    private final Type type;

    public TypeToken() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        if (genericSuperclass instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
            if (parameterizedType.getRawType() == TypeToken.class) {
                Type canonicalize = Streams.canonicalize(parameterizedType.getActualTypeArguments()[0]);
                if (!Objects.equals(System.getProperty("gson.allowCapturingTypeVariables"), "true")) {
                    verifyNoTypeVariable(canonicalize);
                }
                this.type = canonicalize;
                this.rawType = Streams.getRawType(canonicalize);
                this.hashCode = canonicalize.hashCode();
                return;
            }
        } else if (genericSuperclass == TypeToken.class) {
            throw new IllegalStateException("TypeToken must be created with a type argument: new TypeToken<...>() {}; When using code shrinkers (ProGuard, R8, ...) make sure that generic signatures are preserved.\nSee " + "https://github.com/google/gson/blob/main/Troubleshooting.md#".concat("type-token-raw"));
        }
        throw new IllegalStateException("Must only create direct subclasses of TypeToken");
    }

    public static TypeToken<?> get(Type type) {
        return new TypeToken<>(type);
    }

    public static TypeToken<?> getArray(Type type) {
        return new TypeToken<>(new GsonTypes$GenericArrayTypeImpl(type));
    }

    public static TypeToken<?> getParameterized(Type type, Type... typeArr) {
        Objects.requireNonNull(type);
        Objects.requireNonNull(typeArr);
        boolean z = type instanceof Class;
        if (z) {
            Class cls = (Class) type;
            TypeVariable<Class<T>>[] typeParameters = cls.getTypeParameters();
            int length = typeParameters.length;
            int length2 = typeArr.length;
            if (length2 != length) {
                throw new IllegalArgumentException(cls.getName() + " requires " + length + " type arguments, but got " + length2);
            } else if (typeArr.length == 0) {
                return get(cls);
            } else {
                if (z) {
                    Class cls2 = (Class) type;
                    if (!Modifier.isStatic(cls2.getModifiers()) && cls2.getDeclaringClass() != null) {
                        throw new IllegalArgumentException("Raw type " + cls.getName() + " is not supported because it requires specifying an owner type");
                    }
                }
                for (int i = 0; i < length; i++) {
                    Type type2 = typeArr[i];
                    Objects.requireNonNull(type2, "Type argument must not be null");
                    Class<?> rawType = Streams.getRawType(type2);
                    TypeVariable<Class<T>> typeVariable = typeParameters[i];
                    for (Type type3 : typeVariable.getBounds()) {
                        if (!Streams.getRawType(type3).isAssignableFrom(rawType)) {
                            throw new IllegalArgumentException("Type argument " + type2 + " does not satisfy bounds for type variable " + typeVariable + " declared by " + type);
                        }
                    }
                }
                return new TypeToken<>(new GsonTypes$ParameterizedTypeImpl(null, cls, typeArr));
            }
        } else {
            throw new IllegalArgumentException("rawType must be of type Class, but was " + type);
        }
    }

    public static void verifyNoTypeVariable(Type type) {
        if (type instanceof TypeVariable) {
            TypeVariable typeVariable = (TypeVariable) type;
            throw new IllegalArgumentException("TypeToken type argument must not contain a type variable; captured type variable " + typeVariable.getName() + " declared by " + typeVariable.getGenericDeclaration() + "\nSee " + "https://github.com/google/gson/blob/main/Troubleshooting.md#".concat("typetoken-type-variable"));
        } else if (type instanceof GenericArrayType) {
            verifyNoTypeVariable(((GenericArrayType) type).getGenericComponentType());
        } else {
            int i = 0;
            if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                Type ownerType = parameterizedType.getOwnerType();
                if (ownerType != null) {
                    verifyNoTypeVariable(ownerType);
                }
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                int length = actualTypeArguments.length;
                while (i < length) {
                    verifyNoTypeVariable(actualTypeArguments[i]);
                    i++;
                }
            } else if (type instanceof WildcardType) {
                WildcardType wildcardType = (WildcardType) type;
                for (Type type2 : wildcardType.getLowerBounds()) {
                    verifyNoTypeVariable(type2);
                }
                Type[] upperBounds = wildcardType.getUpperBounds();
                int length2 = upperBounds.length;
                while (i < length2) {
                    verifyNoTypeVariable(upperBounds[i]);
                    i++;
                }
            } else if (type == null) {
                throw new IllegalArgumentException("TypeToken captured `null` as type argument; probably a compiler / runtime bug");
            }
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof TypeToken) || !Streams.equals(this.type, ((TypeToken) obj).type)) {
            return false;
        }
        return true;
    }

    public final Class<? super T> getRawType() {
        return this.rawType;
    }

    public final Type getType() {
        return this.type;
    }

    public final int hashCode() {
        return this.hashCode;
    }

    @Deprecated
    public boolean isAssignableFrom(Class<?> cls) {
        return isAssignableFrom((Type) cls);
    }

    public final String toString() {
        return Streams.typeToString(this.type);
    }

    public static <T> TypeToken<T> get(Class<T> cls) {
        return new TypeToken<>(cls);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.reflect.Type, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v10, types: [java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r6v13, types: [java.lang.Class] */
    /* JADX WARN: Type inference failed for: r6v16, types: [java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r6v20 */
    /* JADX WARN: Type inference failed for: r6v21 */
    @Deprecated
    public boolean isAssignableFrom(Type type) {
        boolean z;
        if (type != 0) {
            if (!this.type.equals(type)) {
                Type type2 = this.type;
                if (type2 instanceof Class) {
                    return this.rawType.isAssignableFrom(Streams.getRawType(type));
                }
                if (type2 instanceof ParameterizedType) {
                    return isAssignableFrom(type, (ParameterizedType) type2, new HashMap());
                }
                if (!(type2 instanceof GenericArrayType)) {
                    Class[] clsArr = {Class.class, ParameterizedType.class, GenericArrayType.class};
                    StringBuilder sb = new StringBuilder("Unsupported type, expected one of: ");
                    for (int i = 0; i < 3; i++) {
                        sb.append(clsArr[i].getName());
                        sb.append(", ");
                    }
                    sb.append("but got: ");
                    sb.append(type2.getClass().getName());
                    sb.append(", for type token: ");
                    sb.append(type2.toString());
                    throw new IllegalArgumentException(sb.toString());
                } else if (this.rawType.isAssignableFrom(Streams.getRawType(type))) {
                    Type genericComponentType = ((GenericArrayType) this.type).getGenericComponentType();
                    if (genericComponentType instanceof ParameterizedType) {
                        if (type instanceof GenericArrayType) {
                            type = ((GenericArrayType) type).getGenericComponentType();
                        } else if (type instanceof Class) {
                            type = (Class) type;
                            while (type.isArray()) {
                                type = type.getComponentType();
                            }
                        }
                        z = isAssignableFrom(type, (ParameterizedType) genericComponentType, new HashMap());
                    } else {
                        z = true;
                    }
                    if (z) {
                    }
                }
            }
            return true;
        }
        return false;
    }

    public TypeToken(Type type) {
        Objects.requireNonNull(type);
        Type canonicalize = Streams.canonicalize(type);
        this.type = canonicalize;
        this.rawType = Streams.getRawType(canonicalize);
        this.hashCode = canonicalize.hashCode();
    }

    @Deprecated
    public boolean isAssignableFrom(TypeToken<?> typeToken) {
        return isAssignableFrom(typeToken.getType());
    }

    public static boolean isAssignableFrom(Type type, ParameterizedType parameterizedType, HashMap hashMap) {
        if (type == null) {
            return false;
        }
        if (parameterizedType.equals(type)) {
            return true;
        }
        Class rawType = Streams.getRawType(type);
        ParameterizedType parameterizedType2 = type instanceof ParameterizedType ? (ParameterizedType) type : null;
        if (parameterizedType2 != null) {
            Type[] actualTypeArguments = parameterizedType2.getActualTypeArguments();
            TypeVariable<Class<T>>[] typeParameters = rawType.getTypeParameters();
            for (int i = 0; i < actualTypeArguments.length; i++) {
                Type type2 = actualTypeArguments[i];
                TypeVariable<Class<T>> typeVariable = typeParameters[i];
                while (type2 instanceof TypeVariable) {
                    type2 = (Type) hashMap.get(((TypeVariable) type2).getName());
                }
                hashMap.put(typeVariable.getName(), type2);
            }
            if (parameterizedType2.getRawType().equals(parameterizedType.getRawType())) {
                Type[] actualTypeArguments2 = parameterizedType2.getActualTypeArguments();
                Type[] actualTypeArguments3 = parameterizedType.getActualTypeArguments();
                for (int i2 = 0; i2 < actualTypeArguments2.length; i2++) {
                    Type type3 = actualTypeArguments2[i2];
                    Type type4 = actualTypeArguments3[i2];
                    if (type4.equals(type3) || ((type3 instanceof TypeVariable) && type4.equals(hashMap.get(((TypeVariable) type3).getName())))) {
                    }
                }
                return true;
            }
        }
        for (Type type5 : rawType.getGenericInterfaces()) {
            if (isAssignableFrom(type5, parameterizedType, new HashMap(hashMap))) {
                return true;
            }
        }
        return isAssignableFrom(rawType.getGenericSuperclass(), parameterizedType, new HashMap(hashMap));
    }
}
