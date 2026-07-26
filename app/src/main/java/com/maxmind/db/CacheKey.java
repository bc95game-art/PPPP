package com.maxmind.db;

import java.lang.reflect.Type;
/* loaded from: classes.dex */
public final class CacheKey<T> {
    private final Class<T> cls;
    private final int offset;
    private final Type type;

    public CacheKey(int i, Class<T> cls, Type type) {
        this.offset = i;
        this.cls = cls;
        this.type = type;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        CacheKey cacheKey = (CacheKey) obj;
        if (this.offset != cacheKey.offset) {
            return false;
        }
        Class<T> cls = this.cls;
        if (cls == null) {
            if (cacheKey.cls != null) {
                return false;
            }
        } else if (!cls.equals(cacheKey.cls)) {
            return false;
        }
        Type type = this.type;
        if (type != null) {
            return type.equals(cacheKey.type);
        }
        if (cacheKey.type == null) {
            return true;
        }
        return false;
    }

    public Class<T> getCls() {
        return this.cls;
    }

    public int getOffset() {
        return this.offset;
    }

    public Type getType() {
        return this.type;
    }

    public int hashCode() {
        int i;
        int i2 = this.offset * 31;
        Class<T> cls = this.cls;
        int i3 = 0;
        if (cls == null) {
            i = 0;
        } else {
            i = cls.hashCode();
        }
        int i4 = (i2 + i) * 31;
        Type type = this.type;
        if (type != null) {
            i3 = type.hashCode();
        }
        return i4 + i3;
    }
}
