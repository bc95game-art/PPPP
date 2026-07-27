package com.google.android.datatransport.runtime.dagger.internal;

import javax.inject.Provider;
/* loaded from: classes.dex */
public final class DoubleCheck implements Provider {
    public static final Object UNINITIALIZED = new Object();
    public volatile Object instance;
    public volatile Factory provider;

    /* JADX WARN: Type inference failed for: r0v1, types: [javax.inject.Provider, com.google.android.datatransport.runtime.dagger.internal.DoubleCheck, java.lang.Object] */
    public static Provider provider(Factory factory) {
        if (factory instanceof DoubleCheck) {
            return factory;
        }
        ?? obj = new Object();
        obj.instance = UNINITIALIZED;
        obj.provider = factory;
        return obj;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        Object obj;
        Object obj2 = this.instance;
        Object obj3 = UNINITIALIZED;
        if (obj2 != obj3) {
            return obj2;
        }
        synchronized (this) {
            try {
                obj = this.instance;
                if (obj == obj3) {
                    obj = this.provider.get();
                    Object obj4 = this.instance;
                    if (!(obj4 == obj3 || obj4 == obj)) {
                        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj4 + " & " + obj + ". This is likely due to a circular dependency.");
                    }
                    this.instance = obj;
                    this.provider = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return obj;
    }
}
