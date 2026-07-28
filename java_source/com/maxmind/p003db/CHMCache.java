package com.maxmind.p003db;

import com.maxmind.p003db.NodeCache;
import p004j$.util.concurrent.ConcurrentHashMap;
/* renamed from: com.maxmind.db.CHMCache */
/* loaded from: classes.dex */
public class CHMCache implements NodeCache {
    private static final int DEFAULT_CAPACITY = 4096;
    private final ConcurrentHashMap<CacheKey, DecodedValue> cache;
    private boolean cacheFull;
    private final int capacity;

    public CHMCache() {
        this(DEFAULT_CAPACITY);
    }

    @Override // com.maxmind.p003db.NodeCache
    public DecodedValue get(CacheKey cacheKey, NodeCache.Loader loader) {
        DecodedValue decodedValue = this.cache.get(cacheKey);
        if (decodedValue != null) {
            return decodedValue;
        }
        DecodedValue load = loader.load(cacheKey);
        if (!this.cacheFull) {
            if (this.cache.size() < this.capacity) {
                this.cache.put(cacheKey, load);
                return load;
            }
            this.cacheFull = true;
        }
        return load;
    }

    public CHMCache(int i) {
        this.cacheFull = false;
        this.capacity = i;
        this.cache = new ConcurrentHashMap<>(i);
    }
}
