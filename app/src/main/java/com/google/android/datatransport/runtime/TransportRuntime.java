package com.google.android.datatransport.runtime;

import android.content.Context;
import androidx.core.app.ActivityCompat$$ExternalSyntheticLambda0;
import androidx.emoji2.text.MetadataRepo;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.cct.CCTDestination;
import com.google.android.datatransport.runtime.scheduling.Scheduler;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader;
import com.google.android.datatransport.runtime.time.Clock;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;
import kotlin.text.MatcherMatchResult;
import p004j$.util.DesugarCollections;
/* loaded from: classes.dex */
public final class TransportRuntime {
    public static volatile DaggerTransportRuntimeComponent instance;
    public final Clock eventClock;
    public final Scheduler scheduler;
    public final Uploader uploader;
    public final Clock uptimeClock;

    public TransportRuntime(Clock clock, Clock clock2, Scheduler scheduler, Uploader uploader, MetadataRepo metadataRepo) {
        this.eventClock = clock;
        this.uptimeClock = clock2;
        this.scheduler = scheduler;
        this.uploader = uploader;
        ((Executor) metadataRepo.mMetadataList).execute(new ActivityCompat$$ExternalSyntheticLambda0(15, metadataRepo));
    }

    public static TransportRuntime getInstance() {
        DaggerTransportRuntimeComponent daggerTransportRuntimeComponent = instance;
        if (daggerTransportRuntimeComponent != null) {
            return (TransportRuntime) daggerTransportRuntimeComponent.transportRuntimeProvider.get();
        }
        throw new IllegalStateException("Not initialized!");
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, androidx.navigation.internal.NavContext] */
    public static void initialize(Context context) {
        if (instance == null) {
            synchronized (TransportRuntime.class) {
                try {
                    if (instance == null) {
                        ?? obj = new Object();
                        context.getClass();
                        obj.context = context;
                        instance = obj.build();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public final MatcherMatchResult newFactory(EncodedDestination encodedDestination) {
        Set set;
        byte[] bArr;
        if (encodedDestination != null) {
            set = DesugarCollections.unmodifiableSet(CCTDestination.SUPPORTED_ENCODINGS);
        } else {
            set = Collections.singleton(new Encoding("proto"));
        }
        MatcherMatchResult builder = AutoValue_TransportContext.builder();
        encodedDestination.getClass();
        builder.matcher = "cct";
        CCTDestination cCTDestination = (CCTDestination) encodedDestination;
        String str = cCTDestination.endPoint;
        String str2 = cCTDestination.apiKey;
        if (str2 == null && str == null) {
            bArr = null;
        } else {
            if (str2 == null) {
                str2 = "";
            }
            bArr = ("1$" + str + "\\" + str2).getBytes(Charset.forName("UTF-8"));
        }
        builder.input = bArr;
        return new MatcherMatchResult(set, builder.build(), this, 12);
    }
}
