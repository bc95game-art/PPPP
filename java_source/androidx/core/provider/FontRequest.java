package androidx.core.provider;

import android.util.Base64;
import androidx.activity.ComponentActivity$$ExternalSyntheticLambda2;
import com.google.android.datatransport.runtime.backends.MetadataBackendRegistry;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.scheduling.DefaultScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatcherMatchResult;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowImpl;
/* loaded from: classes.dex */
public final class FontRequest implements Factory {
    public final /* synthetic */ int $r8$classId;
    public final Object mCertificates;
    public final Object mIdentifier;
    public final Object mProviderAuthority;
    public final Object mProviderPackage;
    public final Object mQuery;

    public FontRequest(Map initialState) {
        this.$r8$classId = 1;
        Intrinsics.checkNotNullParameter(initialState, "initialState");
        this.mProviderAuthority = new LinkedHashMap(initialState);
        this.mProviderPackage = new LinkedHashMap();
        this.mQuery = new LinkedHashMap();
        this.mIdentifier = new LinkedHashMap();
        this.mCertificates = new ComponentActivity$$ExternalSyntheticLambda2(1, this);
    }

    @Override // javax.inject.Provider
    public Object get() {
        return new DefaultScheduler((Executor) ((Provider) this.mProviderAuthority).get(), (MetadataBackendRegistry) ((Provider) this.mProviderPackage).get(), (MatcherMatchResult) ((MatcherMatchResult) this.mQuery).get(), (EventStore) ((Provider) this.mIdentifier).get(), (SynchronizationGuard) ((Provider) this.mCertificates).get());
    }

    public void set(Object obj, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        ((LinkedHashMap) this.mProviderAuthority).put(key, obj);
        MutableStateFlow mutableStateFlow = (MutableStateFlow) ((LinkedHashMap) this.mQuery).get(key);
        if (mutableStateFlow != null) {
            ((StateFlowImpl) mutableStateFlow).setValue(obj);
        }
        MutableStateFlow mutableStateFlow2 = (MutableStateFlow) ((LinkedHashMap) this.mIdentifier).get(key);
        if (mutableStateFlow2 != null) {
            ((StateFlowImpl) mutableStateFlow2).setValue(obj);
        }
    }

    public String toString() {
        switch (this.$r8$classId) {
            case 0:
                List list = (List) this.mCertificates;
                StringBuilder sb = new StringBuilder();
                sb.append("FontRequest {mProviderAuthority: " + ((String) this.mProviderAuthority) + ", mProviderPackage: " + ((String) this.mProviderPackage) + ", mQuery: " + ((String) this.mQuery) + ", mCertificates:");
                for (int i = 0; i < list.size(); i++) {
                    sb.append(" [");
                    List list2 = (List) list.get(i);
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        sb.append(" \"");
                        sb.append(Base64.encodeToString((byte[]) list2.get(i2), 0));
                        sb.append("\"");
                    }
                    sb.append(" ]");
                }
                sb.append("}mCertificatesArray: 0");
                return sb.toString();
            default:
                return super.toString();
        }
    }

    public FontRequest(Provider provider, Provider provider2, MatcherMatchResult matcherMatchResult, Provider provider3, Provider provider4) {
        this.$r8$classId = 2;
        this.mProviderAuthority = provider;
        this.mProviderPackage = provider2;
        this.mQuery = matcherMatchResult;
        this.mIdentifier = provider3;
        this.mCertificates = provider4;
    }

    public FontRequest(String str, String str2, String str3, List list) {
        this.$r8$classId = 0;
        str.getClass();
        this.mProviderAuthority = str;
        str2.getClass();
        this.mProviderPackage = str2;
        this.mQuery = str3;
        list.getClass();
        this.mCertificates = list;
        this.mIdentifier = str + "-" + str2 + "-" + str3;
    }
}
