package com.emanuelef.remote_capture;

import android.view.View;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import com.android.billingclient.api.BillingResult;
import com.emanuelef.remote_capture.HTTPReassembly;
import com.emanuelef.remote_capture.WebSocketDecoder;
import com.emanuelef.remote_capture.model.PayloadChunk;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public final /* synthetic */ class PlayBilling$$ExternalSyntheticLambda4 implements ActivityResultCallback, WebSocketDecoder.DecodedFrameListener, HTTPReassembly.ReassemblyListener, OnApplyWindowInsetsListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ PlayBilling$$ExternalSyntheticLambda4(int i, Object obj) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public void onActivityResult(Object obj) {
        switch (this.$r8$classId) {
            case 1:
                ((CaptureHelper) this.f$0).captureServiceResult((ActivityResult) obj);
                return;
            default:
                PersistableUriPermission.m55$r8$lambda$CFSqVagE681JiZhc8dLTW5sLoI((PersistableUriPermission) this.f$0, (ActivityResult) obj);
                return;
        }
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        WindowInsetsCompat lambda$fixViewPager2Insets$2;
        lambda$fixViewPager2Insets$2 = Utils.lambda$fixViewPager2Insets$2((AtomicReference) this.f$0, view, windowInsetsCompat);
        return lambda$fixViewPager2Insets$2;
    }

    @Override // com.emanuelef.remote_capture.HTTPReassembly.ReassemblyListener
    public void onChunkReassembled(PayloadChunk payloadChunk) {
        HarWriter.$r8$lambda$ALZOPtD8RuCNncgkHgYxObdhrpw((ArrayList) this.f$0, payloadChunk);
    }

    public void onQueryPurchasesResponse(BillingResult billingResult, List list) {
        ((PlayBilling) this.f$0).lambda$onProductDetailsResponse$10(billingResult, list);
    }

    @Override // com.emanuelef.remote_capture.WebSocketDecoder.DecodedFrameListener
    public void onWebSocketFrame(PayloadChunk payloadChunk) {
        ((HTTPReassembly) this.f$0).lambda$handleChunk$0(payloadChunk);
    }
}
