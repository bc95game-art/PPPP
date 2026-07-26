package com.maxmind.db;

import com.maxmind.db.NodeCache;
/* loaded from: classes.dex */
public class NoCache implements NodeCache {
    private static final NoCache INSTANCE = new NoCache();

    private NoCache() {
    }

    public static NoCache getInstance() {
        return INSTANCE;
    }

    @Override // com.maxmind.db.NodeCache
    public DecodedValue get(CacheKey cacheKey, NodeCache.Loader loader) {
        return loader.load(cacheKey);
    }
}
