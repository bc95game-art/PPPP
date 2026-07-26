package androidx.navigation.internal;

import android.content.Context;
import androidx.core.provider.FontRequest;
import androidx.emoji2.text.ConcurrencyHelpers$$ExternalSyntheticLambda0;
import androidx.emoji2.text.EmojiCompat;
import androidx.emoji2.text.MetadataRepo;
import androidx.navigation.Navigation;
import androidx.transition.Transition;
import androidx.viewpager2.widget.FakeDrag;
import com.android.billingclient.api.zzcl;
import com.emanuelef.remote_capture.PlayBilling$$ExternalSyntheticLambda23;
import com.google.android.datatransport.runtime.DaggerTransportRuntimeComponent;
import com.google.android.datatransport.runtime.ExecutionModule_ExecutorFactory$InstanceHolder;
import com.google.android.datatransport.runtime.dagger.internal.DoubleCheck;
import com.google.android.datatransport.runtime.scheduling.persistence.SchemaManager_Factory;
import com.google.android.material.snackbar.SnackbarManager;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.inject.Provider;
import kotlin.text.MatcherMatchResult;
/* loaded from: classes.dex */
public final class NavContext implements EmojiCompat.MetadataRepoLoader {
    public Context context;

    public /* synthetic */ NavContext(Context context, boolean z) {
        this.context = context;
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [androidx.appcompat.widget.TooltipPopup, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.Object, com.google.android.datatransport.runtime.DaggerTransportRuntimeComponent] */
    public DaggerTransportRuntimeComponent build() {
        Context context = this.context;
        if (context != null) {
            ?? obj = new Object();
            obj.executorProvider = DoubleCheck.provider(ExecutionModule_ExecutorFactory$InstanceHolder.INSTANCE);
            SnackbarManager snackbarManager = new SnackbarManager(context);
            obj.setApplicationContextProvider = snackbarManager;
            obj.metadataBackendRegistryProvider = DoubleCheck.provider(new zzcl(snackbarManager, 20, new FakeDrag(20, snackbarManager)));
            SnackbarManager snackbarManager2 = obj.setApplicationContextProvider;
            obj.schemaManagerProvider = new SchemaManager_Factory(snackbarManager2, 0);
            Provider provider = DoubleCheck.provider(new zzcl(obj.schemaManagerProvider, 21, DoubleCheck.provider(new SchemaManager_Factory(snackbarManager2, 1))));
            obj.sQLiteEventStoreProvider = provider;
            Transition.C01101 r0 = new Transition.C01101(16);
            SnackbarManager snackbarManager3 = obj.setApplicationContextProvider;
            MatcherMatchResult matcherMatchResult = new MatcherMatchResult(snackbarManager3, provider, r0, 16);
            Provider provider2 = obj.executorProvider;
            Provider provider3 = obj.metadataBackendRegistryProvider;
            FontRequest fontRequest = new FontRequest(provider2, provider3, matcherMatchResult, provider, provider);
            ?? obj2 = new Object();
            obj2.mContext = snackbarManager3;
            obj2.mContentView = provider3;
            obj2.mMessageView = provider;
            obj2.mLayoutParams = matcherMatchResult;
            obj2.mTmpDisplayFrame = provider2;
            obj2.mTmpAnchorPos = provider;
            obj2.mTmpAppPos = provider;
            obj.transportRuntimeProvider = DoubleCheck.provider(new MatcherMatchResult(fontRequest, (Object) obj2, new MetadataRepo(provider2, provider, matcherMatchResult, provider), 14));
            return obj;
        }
        throw new IllegalStateException(Context.class.getCanonicalName() + " must be set");
    }

    @Override // androidx.emoji2.text.EmojiCompat.MetadataRepoLoader
    public void load(Navigation navigation) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new ConcurrencyHelpers$$ExternalSyntheticLambda0("EmojiCompatInitializer"));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        threadPoolExecutor.execute(new PlayBilling$$ExternalSyntheticLambda23(this, navigation, threadPoolExecutor, 1));
    }
}
