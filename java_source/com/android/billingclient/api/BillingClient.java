package com.android.billingclient.api;

import android.app.Activity;
import com.emanuelef.remote_capture.PlayBilling;
import com.emanuelef.remote_capture.PlayBilling$$ExternalSyntheticLambda15;
/* loaded from: classes.dex */
public abstract class BillingClient {
    public abstract void acknowledgePurchase(ConsumeParams consumeParams, PlayBilling$$ExternalSyntheticLambda15 playBilling$$ExternalSyntheticLambda15);

    public abstract void consumeAsync(ConsumeParams consumeParams, ConsumeResponseListener consumeResponseListener);

    public abstract void endConnection();

    public abstract BillingResult launchBillingFlow(Activity activity, BillingFlowParams billingFlowParams);

    public abstract void queryProductDetailsAsync(QueryProductDetailsParams queryProductDetailsParams, PlayBilling playBilling);

    public abstract void startConnection(PlayBilling playBilling);
}
