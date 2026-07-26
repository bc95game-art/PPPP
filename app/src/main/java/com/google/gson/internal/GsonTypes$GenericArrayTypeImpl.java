package com.google.gson.internal;

import j$.util.Objects;
import java.io.Serializable;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
/* loaded from: classes.dex */
public final class GsonTypes$GenericArrayTypeImpl implements GenericArrayType, Serializable {
    public final Type componentType;

    public GsonTypes$GenericArrayTypeImpl(Type type) {
        Objects.requireNonNull(type);
        this.componentType = Streams.canonicalize(type);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof GenericArrayType) || !Streams.equals(this, (GenericArrayType) obj)) {
            return false;
        }
        return true;
    }

    @Override // java.lang.reflect.GenericArrayType
    public final Type getGenericComponentType() {
        return this.componentType;
    }

    public final int hashCode() {
        return this.componentType.hashCode();
    }

    public final String toString() {
        return Streams.typeToString(this.componentType) + "[]";
    }
}
