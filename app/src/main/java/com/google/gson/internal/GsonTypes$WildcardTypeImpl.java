package com.google.gson.internal;

import j$.util.Objects;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
/* loaded from: classes.dex */
public final class GsonTypes$WildcardTypeImpl implements WildcardType, Serializable {
    public final Type lowerBound;
    public final Type upperBound;

    public GsonTypes$WildcardTypeImpl(Type[] typeArr, Type[] typeArr2) {
        if (typeArr2.length > 1) {
            throw new IllegalArgumentException("At most one lower bound is supported");
        } else if (typeArr.length != 1) {
            throw new IllegalArgumentException("Exactly one upper bound must be specified");
        } else if (typeArr2.length == 1) {
            Objects.requireNonNull(typeArr2[0]);
            Streams.checkNotPrimitive(typeArr2[0]);
            if (typeArr[0] == Object.class) {
                this.lowerBound = Streams.canonicalize(typeArr2[0]);
                this.upperBound = Object.class;
                return;
            }
            throw new IllegalArgumentException("When lower bound is specified, upper bound must be Object");
        } else {
            Objects.requireNonNull(typeArr[0]);
            Streams.checkNotPrimitive(typeArr[0]);
            this.lowerBound = null;
            this.upperBound = Streams.canonicalize(typeArr[0]);
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof WildcardType) || !Streams.equals(this, (WildcardType) obj)) {
            return false;
        }
        return true;
    }

    @Override // java.lang.reflect.WildcardType
    public final Type[] getLowerBounds() {
        Type type = this.lowerBound;
        return type != null ? new Type[]{type} : Streams.EMPTY_TYPE_ARRAY;
    }

    @Override // java.lang.reflect.WildcardType
    public final Type[] getUpperBounds() {
        return new Type[]{this.upperBound};
    }

    public final int hashCode() {
        int i;
        Type type = this.lowerBound;
        if (type != null) {
            i = type.hashCode() + 31;
        } else {
            i = 1;
        }
        return i ^ (this.upperBound.hashCode() + 31);
    }

    public final String toString() {
        Type type = this.lowerBound;
        if (type != null) {
            return "? super " + Streams.typeToString(type);
        }
        Type type2 = this.upperBound;
        if (type2 == Object.class) {
            return "?";
        }
        return "? extends " + Streams.typeToString(type2);
    }
}
