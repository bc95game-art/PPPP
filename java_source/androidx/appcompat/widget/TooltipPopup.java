package androidx.appcompat.widget;

import android.content.Context;
import com.google.android.datatransport.runtime.backends.MetadataBackendRegistry;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader;
import com.google.android.datatransport.runtime.scheduling.persistence.ClientHealthMetricsStore;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import java.util.concurrent.Executor;
import javax.inject.Provider;
import kotlin.text.MatcherMatchResult;
/* loaded from: classes.dex */
public final class TooltipPopup implements Factory {
    public Object mContentView;
    public Object mContext;
    public Object mLayoutParams;
    public Object mMessageView;
    public Object mTmpAnchorPos;
    public Object mTmpAppPos;
    public Object mTmpDisplayFrame;

    /* JADX WARN: Type inference failed for: r8v0, types: [com.google.android.datatransport.runtime.time.Clock, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v0, types: [com.google.android.datatransport.runtime.time.Clock, java.lang.Object] */
    @Override // javax.inject.Provider
    public Object get() {
        return new Uploader((Context) ((Provider) this.mContext).get(), (MetadataBackendRegistry) ((Provider) this.mContentView).get(), (EventStore) ((Provider) this.mMessageView).get(), (MatcherMatchResult) ((MatcherMatchResult) this.mLayoutParams).get(), (Executor) ((Provider) this.mTmpDisplayFrame).get(), (SynchronizationGuard) ((Provider) this.mTmpAnchorPos).get(), new Object(), new Object(), (ClientHealthMetricsStore) ((Provider) this.mTmpAppPos).get());
    }
}
