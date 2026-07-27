package com.emanuelef.remote_capture;

import android.app.Notification;
import androidx.appcompat.widget.SearchView;
import androidx.viewpager2.widget.ViewPager2;
import com.android.billingclient.api.Purchase;
import com.emanuelef.remote_capture.Blacklists;
import com.emanuelef.remote_capture.Utils;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public final /* synthetic */ class Utils$$ExternalSyntheticLambda3 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;

    public /* synthetic */ Utils$$ExternalSyntheticLambda3(Object obj, int i, Object obj2) {
        this.$r8$classId = i;
        this.f$0 = obj;
        this.f$1 = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.$r8$classId) {
            case 0:
                Utils.lambda$setSearchQuery$1((SearchView) this.f$0, (String) this.f$1);
                return;
            case 1:
                Utils.C01383.lambda$onPageSelected$0((ViewPager2) this.f$0, (AtomicReference) this.f$1);
                return;
            case 2:
                ((CaptureService) this.f$0).lambda$notifyLowMemory$1((Notification) this.f$1);
                return;
            case 3:
                ((CaptureService) this.f$0).lambda$notifyBlacklistsLoaded$7((Blacklists.NativeBlacklistStatus[]) this.f$1);
                return;
            default:
                ((PlayBilling) this.f$0).lambda$processPurchases$2((Purchase) this.f$1);
                return;
        }
    }
}
