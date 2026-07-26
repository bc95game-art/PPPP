package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import com.android.billingclient.api.zzcl;
import com.google.android.datatransport.cct.CctBackendFactory;
import com.google.android.datatransport.runtime.time.Clock;
import java.util.HashMap;
import kotlin.text.MatcherMatchResult;
/* loaded from: classes.dex */
public final class MetadataBackendRegistry {
    public final zzcl backendFactoryProvider;
    public final HashMap backends = new HashMap();
    public final MatcherMatchResult creationContextFactory;

    public MetadataBackendRegistry(Context context, MatcherMatchResult matcherMatchResult) {
        zzcl zzclVar = new zzcl(context);
        this.backendFactoryProvider = zzclVar;
        this.creationContextFactory = matcherMatchResult;
    }

    public final synchronized TransportBackend get(String str) {
        if (this.backends.containsKey(str)) {
            return (TransportBackend) this.backends.get(str);
        }
        CctBackendFactory cctBackendFactory = this.backendFactoryProvider.get(str);
        if (cctBackendFactory == null) {
            return null;
        }
        MatcherMatchResult matcherMatchResult = this.creationContextFactory;
        TransportBackend create = cctBackendFactory.create(new AutoValue_CreationContext((Context) matcherMatchResult.matcher, (Clock) matcherMatchResult.input, (Clock) matcherMatchResult.groups, str));
        this.backends.put(str, create);
        return create;
    }
}
