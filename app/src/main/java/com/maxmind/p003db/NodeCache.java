package com.maxmind.p003db;
/* renamed from: com.maxmind.db.NodeCache */
/* loaded from: classes.dex */
public interface NodeCache {

    /* renamed from: com.maxmind.db.NodeCache$Loader */
    /* loaded from: classes.dex */
    public interface Loader {
        DecodedValue load(CacheKey cacheKey);
    }

    DecodedValue get(CacheKey cacheKey, Loader loader);
}
