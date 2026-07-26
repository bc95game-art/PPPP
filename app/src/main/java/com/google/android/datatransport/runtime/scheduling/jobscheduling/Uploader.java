package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.Context;
import com.google.android.datatransport.runtime.backends.MetadataBackendRegistry;
import com.google.android.datatransport.runtime.scheduling.persistence.ClientHealthMetricsStore;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.datatransport.runtime.time.Clock;
import java.util.concurrent.Executor;
import kotlin.text.MatcherMatchResult;
/* loaded from: classes.dex */
public final class Uploader {
    public final MetadataBackendRegistry backendRegistry;
    public final ClientHealthMetricsStore clientHealthMetricsStore;
    public final Clock clock;
    public final Context context;
    public final EventStore eventStore;
    public final Executor executor;
    public final SynchronizationGuard guard;
    public final Clock uptimeClock;
    public final MatcherMatchResult workScheduler;

    public Uploader(Context context, MetadataBackendRegistry metadataBackendRegistry, EventStore eventStore, MatcherMatchResult matcherMatchResult, Executor executor, SynchronizationGuard synchronizationGuard, Clock clock, Clock clock2, ClientHealthMetricsStore clientHealthMetricsStore) {
        this.context = context;
        this.backendRegistry = metadataBackendRegistry;
        this.eventStore = eventStore;
        this.workScheduler = matcherMatchResult;
        this.executor = executor;
        this.guard = synchronizationGuard;
        this.clock = clock;
        this.uptimeClock = clock2;
        this.clientHealthMetricsStore = clientHealthMetricsStore;
    }

    /* JADX WARN: Removed duplicated region for block: B:114:0x03f7  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x03df A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v45, types: [androidx.appcompat.widget.TooltipPopup, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v22, types: [androidx.appcompat.widget.TooltipPopup, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v3, types: [java.lang.Object, androidx.appcompat.widget.AppCompatDrawableManager$1] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void logAndUpdateState(final com.google.android.datatransport.runtime.AutoValue_TransportContext r46, int r47) {
        /*
            Method dump skipped, instructions count: 1145
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader.logAndUpdateState(com.google.android.datatransport.runtime.AutoValue_TransportContext, int):void");
    }
}
