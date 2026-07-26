package com.maxmind.db;
/* loaded from: classes.dex */
public interface NodeCache {

    /* loaded from: classes.dex */
    public interface Loader {
        DecodedValue load(CacheKey cacheKey);
    }

    DecodedValue get(CacheKey cacheKey, Loader loader);
}
