package com.google.gson.internal;

import java.io.Serializable;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import p004j$.util.Objects;
/* loaded from: classes.dex */
public final class GsonTypes$ParameterizedTypeImpl implements ParameterizedType, Serializable {
    public final Type ownerType;
    public final Type rawType;
    public final Type[] typeArguments;

    public GsonTypes$ParameterizedTypeImpl(Type type, Class cls, Type... typeArr) {
        Type type2;
        Objects.requireNonNull(cls);
        if (type != null || Modifier.isStatic(cls.getModifiers()) || cls.getDeclaringClass() == null) {
            if (type == null) {
                type2 = null;
            } else {
                type2 = Streams.canonicalize(type);
            }
            this.ownerType = type2;
            this.rawType = Streams.canonicalize(cls);
            Type[] typeArr2 = (Type[]) typeArr.clone();
            this.typeArguments = typeArr2;
            int length = typeArr2.length;
            for (int i = 0; i < length; i++) {
                Objects.requireNonNull(this.typeArguments[i]);
                Streams.checkNotPrimitive(this.typeArguments[i]);
                Type[] typeArr3 = this.typeArguments;
                typeArr3[i] = Streams.canonicalize(typeArr3[i]);
            }
            return;
        }
        throw new IllegalArgumentException("Must specify owner type for " + cls);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ParameterizedType) || !Streams.equals(this, (ParameterizedType) obj)) {
            return false;
        }
        return true;
    }

    @Override // java.lang.reflect.ParameterizedType
    public final Type[] getActualTypeArguments() {
        return (Type[]) this.typeArguments.clone();
    }

    @Override // java.lang.reflect.ParameterizedType
    public final Type getOwnerType() {
        return this.ownerType;
    }

    @Override // java.lang.reflect.ParameterizedType
    public final Type getRawType() {
        return this.rawType;
    }

    public final int hashCode() {
        int i;
        int hashCode = Arrays.hashCode(this.typeArguments) ^ this.rawType.hashCode();
        Type type = this.ownerType;
        if (type != null) {
            i = type.hashCode();
        } else {
            i = 0;
        }
        return hashCode ^ i;
    }

    public final String toString() {
        Type[] typeArr = this.typeArguments;
        int length = typeArr.length;
        Type type = this.rawType;
        if (length == 0) {
            return Streams.typeToString(type);
        }
        StringBuilder sb = new StringBuilder((length + 1) * 30);
        sb.append(Streams.typeToString(type));
        sb.append("<");
        sb.append(Streams.typeToString(typeArr[0]));
        for (int i = 1; i < length; i++) {
            sb.append(", ");
            sb.append(Streams.typeToString(typeArr[i]));
        }
        sb.append(">");
        return sb.toString();
    }
}
