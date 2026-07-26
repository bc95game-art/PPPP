package com.emanuelef.remote_capture;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import androidx.core.view.inputmethod.InputConnectionCompat$$ExternalSyntheticLambda0;
import com.google.android.datatransport.runtime.AutoValue_TransportContext;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationException;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import p004j$.util.Objects;
/* loaded from: classes.dex */
public final /* synthetic */ class PlayBilling$$ExternalSyntheticLambda6 implements Runnable {
    public final /* synthetic */ int $r8$classId = 0;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ int f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ Object f$3;

    public /* synthetic */ PlayBilling$$ExternalSyntheticLambda6(PlayBilling playBilling, int i, String str, String str2) {
        this.f$0 = playBilling;
        this.f$1 = i;
        this.f$2 = str;
        this.f$3 = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.$r8$classId) {
            case 0:
                ((PlayBilling) this.f$0).lambda$requestUnlockToken$19(this.f$1, (String) this.f$2, (String) this.f$3);
                return;
            default:
                final Uploader uploader = (Uploader) this.f$0;
                final AutoValue_TransportContext autoValue_TransportContext = (AutoValue_TransportContext) this.f$2;
                final int i = this.f$1;
                Runnable runnable = (Runnable) this.f$3;
                SynchronizationGuard synchronizationGuard = uploader.guard;
                try {
                    try {
                        EventStore eventStore = uploader.eventStore;
                        Objects.requireNonNull(eventStore);
                        ((SQLiteEventStore) synchronizationGuard).runCriticalSection(new InputConnectionCompat$$ExternalSyntheticLambda0(13, eventStore));
                        NetworkInfo activeNetworkInfo = ((ConnectivityManager) uploader.context.getSystemService("connectivity")).getActiveNetworkInfo();
                        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                            ((SQLiteEventStore) synchronizationGuard).runCriticalSection(new SynchronizationGuard.CriticalSection() { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader$$ExternalSyntheticLambda2
                                @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
                                public final Object execute() {
                                    Uploader.this.workScheduler.schedule(autoValue_TransportContext, i + 1, false);
                                    return null;
                                }
                            });
                        } else {
                            uploader.logAndUpdateState(autoValue_TransportContext, i);
                        }
                    } catch (SynchronizationException unused) {
                        uploader.workScheduler.schedule(autoValue_TransportContext, i + 1, false);
                    }
                    runnable.run();
                    return;
                } catch (Throwable th) {
                    runnable.run();
                    throw th;
                }
        }
    }

    public /* synthetic */ PlayBilling$$ExternalSyntheticLambda6(Uploader uploader, AutoValue_TransportContext autoValue_TransportContext, int i, Runnable runnable) {
        this.f$0 = uploader;
        this.f$2 = autoValue_TransportContext;
        this.f$1 = i;
        this.f$3 = runnable;
    }
}
