package com.emanuelef.remote_capture;

import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.ConsumeResponseListener;
import com.emanuelef.remote_capture.interfaces.CaptureStartListener;
/* loaded from: classes.dex */
public final /* synthetic */ class PlayBilling$$ExternalSyntheticLambda15 implements CaptureStartListener, ConsumeResponseListener, OnApplyWindowInsetsListener {
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ PlayBilling$$ExternalSyntheticLambda15(int i) {
        this.$r8$classId = i;
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        WindowInsetsCompat lambda$fixListviewInsetsBottom$3;
        WindowInsetsCompat lambda$fixScrollableTabLayoutInsets$4;
        switch (this.$r8$classId) {
            case 4:
                lambda$fixListviewInsetsBottom$3 = Utils.lambda$fixListviewInsetsBottom$3(view, windowInsetsCompat);
                return lambda$fixListviewInsetsBottom$3;
            default:
                lambda$fixScrollableTabLayoutInsets$4 = Utils.lambda$fixScrollableTabLayoutInsets$4(view, windowInsetsCompat);
                return lambda$fixScrollableTabLayoutInsets$4;
        }
    }

    @Override // com.emanuelef.remote_capture.interfaces.CaptureStartListener
    public void onCaptureStartResult(boolean z) {
        VpnReconnectService.stopService();
    }

    @Override // com.android.billingclient.api.ConsumeResponseListener
    public void onConsumeResponse(BillingResult billingResult, String str) {
        PlayBilling.lambda$consumePurchase$14(billingResult, str);
    }
}
