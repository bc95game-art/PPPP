package com.emanuelef.remote_capture;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import androidx.emoji2.text.FontRequestEmojiCompatConfig;
import androidx.fragment.app.DefaultSpecialEffectsController;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransition;
import androidx.fragment.app.FragmentTransitionCompat21;
import androidx.fragment.app.SpecialEffectsController$FragmentStateManagerOperation;
import androidx.navigation.Navigation;
import androidx.navigation.internal.NavContext;
import androidx.transition.FragmentTransitionSupport$$ExternalSyntheticLambda0;
import com.emanuelef.remote_capture.PlayBilling;
import com.emanuelef.remote_capture.activities.AboutActivity;
import com.emanuelef.remote_capture.fragments.prefs.GeoipSettings;
import com.google.android.datatransport.cct.CctTransportBackend;
import com.google.android.datatransport.runtime.AutoValue_EventInternal;
import com.google.android.datatransport.runtime.AutoValue_TransportContext;
import com.google.android.datatransport.runtime.TransportImpl$$ExternalSyntheticLambda0;
import com.google.android.datatransport.runtime.backends.TransportBackend;
import com.google.android.datatransport.runtime.scheduling.DefaultScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.logging.Logger;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final /* synthetic */ class PlayBilling$$ExternalSyntheticLambda23 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;

    public /* synthetic */ PlayBilling$$ExternalSyntheticLambda23(View view, AboutActivity aboutActivity, String str) {
        this.$r8$classId = 4;
        this.f$0 = aboutActivity;
        this.f$2 = view;
        this.f$1 = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.$r8$classId) {
            case 0:
                ((PlayBilling) this.f$0).lambda$startQrActivation$28((String) this.f$1, (PlayBilling.QrActivationRequest) this.f$2);
                return;
            case 1:
                NavContext navContext = (NavContext) this.f$0;
                final Navigation navigation = (Navigation) this.f$1;
                final ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) this.f$2;
                try {
                    FontRequestEmojiCompatConfig create = Navigation.create(navContext.context);
                    if (create != null) {
                        FontRequestEmojiCompatConfig.FontRequestMetadataLoader fontRequestMetadataLoader = (FontRequestEmojiCompatConfig.FontRequestMetadataLoader) create.mMetadataLoader;
                        synchronized (fontRequestMetadataLoader.mLock) {
                            fontRequestMetadataLoader.mExecutor = threadPoolExecutor;
                        }
                        create.mMetadataLoader.load(new Navigation() { // from class: androidx.emoji2.text.EmojiCompatInitializer$BackgroundDefaultLoader$1
                            @Override // androidx.navigation.Navigation
                            public final void onFailed(Throwable th) {
                                ThreadPoolExecutor threadPoolExecutor2 = threadPoolExecutor;
                                try {
                                    Navigation.this.onFailed(th);
                                } finally {
                                    threadPoolExecutor2.shutdown();
                                }
                            }

                            @Override // androidx.navigation.Navigation
                            public final void onLoaded(MetadataRepo metadataRepo) {
                                ThreadPoolExecutor threadPoolExecutor2 = threadPoolExecutor;
                                try {
                                    Navigation.this.onLoaded(metadataRepo);
                                } finally {
                                    threadPoolExecutor2.shutdown();
                                }
                            }
                        });
                        return;
                    }
                    throw new RuntimeException("EmojiCompat font provider not available on this device.");
                } catch (Throwable th) {
                    navigation.onFailed(th);
                    threadPoolExecutor.shutdown();
                    return;
                }
            case 2:
                ViewGroup container = (ViewGroup) this.f$0;
                DefaultSpecialEffectsController.AnimationEffect this$0 = (DefaultSpecialEffectsController.AnimationEffect) this.f$2;
                Intrinsics.checkNotNullParameter(container, "$container");
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                container.endViewTransition((View) this.f$1);
                this$0.animationInfo.operation.completeEffect(this$0);
                return;
            case 3:
                Fragment inFragment = ((SpecialEffectsController$FragmentStateManagerOperation) this.f$0).fragment;
                Fragment outFragment = ((SpecialEffectsController$FragmentStateManagerOperation) this.f$1).fragment;
                boolean z = ((DefaultSpecialEffectsController.TransitionEffect) this.f$2).isPop;
                FragmentTransitionCompat21 fragmentTransitionCompat21 = FragmentTransition.PLATFORM_IMPL;
                Intrinsics.checkNotNullParameter(inFragment, "inFragment");
                Intrinsics.checkNotNullParameter(outFragment, "outFragment");
                if (z) {
                    outFragment.getEnterTransitionCallback();
                    return;
                } else {
                    inFragment.getEnterTransitionCallback();
                    return;
                }
            case 4:
                ((AboutActivity) this.f$0).lambda$showQrCode$14((View) this.f$2, (String) this.f$1);
                return;
            case 5:
                ((AboutActivity) this.f$0).lambda$showQrCode$15((Exception) this.f$1, (View) this.f$2);
                return;
            case 6:
                ((GeoipSettings) this.f$0).lambda$downloadDatabases$5((Context) this.f$1, (Handler) this.f$2);
                return;
            default:
                DefaultScheduler defaultScheduler = (DefaultScheduler) this.f$0;
                AutoValue_TransportContext autoValue_TransportContext = (AutoValue_TransportContext) this.f$1;
                String str = autoValue_TransportContext.backendName;
                AutoValue_EventInternal autoValue_EventInternal = (AutoValue_EventInternal) this.f$2;
                defaultScheduler.getClass();
                Logger logger = DefaultScheduler.LOGGER;
                try {
                    TransportBackend transportBackend = defaultScheduler.backendRegistry.get(str);
                    if (transportBackend == null) {
                        String str2 = "Transport backend '" + str + "' is not registered";
                        logger.warning(str2);
                        new IllegalArgumentException(str2);
                    } else {
                        ((SQLiteEventStore) defaultScheduler.guard).runCriticalSection(new FragmentTransitionSupport$$ExternalSyntheticLambda0(defaultScheduler, autoValue_TransportContext, ((CctTransportBackend) transportBackend).decorate(autoValue_EventInternal), 1));
                    }
                    return;
                } catch (Exception e) {
                    logger.warning("Error scheduling event " + e.getMessage());
                    return;
                }
        }
    }

    public /* synthetic */ PlayBilling$$ExternalSyntheticLambda23(DefaultScheduler defaultScheduler, AutoValue_TransportContext autoValue_TransportContext, TransportImpl$$ExternalSyntheticLambda0 transportImpl$$ExternalSyntheticLambda0, AutoValue_EventInternal autoValue_EventInternal) {
        this.$r8$classId = 7;
        this.f$0 = defaultScheduler;
        this.f$1 = autoValue_TransportContext;
        this.f$2 = autoValue_EventInternal;
    }

    public /* synthetic */ PlayBilling$$ExternalSyntheticLambda23(Object obj, Object obj2, Object obj3, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
        this.f$1 = obj2;
        this.f$2 = obj3;
    }
}
