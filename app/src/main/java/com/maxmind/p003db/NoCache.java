package com.maxmind.p003db;

import com.maxmind.p003db.NodeCache;
/* renamed from: com.maxmind.db.NoCache */
/* loaded from: classes.dex */
public class NoCache implements NodeCache {
    private static final NoCache INSTANCE = new NoCache();

    private NoCache() {
    }

    public static NoCache getInstance() {
        return INSTANCE;
    }

    @Override // com.maxmind.p003db.NodeCache
    public DecodedValue get(CacheKey cacheKey, NodeCache.Loader loader) {
        return loader.load(cacheKey);
    }
}
