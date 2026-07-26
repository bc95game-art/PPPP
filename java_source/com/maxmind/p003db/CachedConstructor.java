package com.maxmind.p003db;

import java.lang.reflect.Constructor;
import java.lang.reflect.Type;
import java.util.Map;
/* renamed from: com.maxmind.db.CachedConstructor */
/* loaded from: classes.dex */
final class CachedConstructor<T> {
    private final Constructor<T> constructor;
    private final Type[] parameterGenericTypes;
    private final Map<String, Integer> parameterIndexes;
    private final Class<?>[] parameterTypes;

    public CachedConstructor(Constructor<T> constructor, Class<?>[] clsArr, Type[] typeArr, Map<String, Integer> map) {
        this.constructor = constructor;
        this.parameterTypes = clsArr;
        this.parameterGenericTypes = typeArr;
        this.parameterIndexes = map;
    }

    public Constructor<T> getConstructor() {
        return this.constructor;
    }

    public Type[] getParameterGenericTypes() {
        return this.parameterGenericTypes;
    }

    public Map<String, Integer> getParameterIndexes() {
        return this.parameterIndexes;
    }

    public Class<?>[] getParameterTypes() {
        return this.parameterTypes;
    }
}
