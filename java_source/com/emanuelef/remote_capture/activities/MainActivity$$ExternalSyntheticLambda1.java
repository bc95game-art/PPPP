package com.emanuelef.remote_capture.activities;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import com.emanuelef.remote_capture.interfaces.CaptureStartListener;
/* loaded from: classes.dex */
public final /* synthetic */ class MainActivity$$ExternalSyntheticLambda1 implements CaptureStartListener, ActivityResultCallback {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ MainActivity f$0;

    public /* synthetic */ MainActivity$$ExternalSyntheticLambda1(MainActivity mainActivity, int i) {
        this.$r8$classId = i;
        this.f$0 = mainActivity;
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public void onActivityResult(Object obj) {
        switch (this.$r8$classId) {
            case 1:
                this.f$0.sslkeyfileExportResult((ActivityResult) obj);
                return;
            case 2:
                this.f$0.peerInfoResult((ActivityResult) obj);
                return;
            case 3:
                this.f$0.pcapFileOpenResult((ActivityResult) obj);
                return;
            default:
                this.f$0.keylogFileOpenResult((ActivityResult) obj);
                return;
        }
    }

    @Override // com.emanuelef.remote_capture.interfaces.CaptureStartListener
    public void onCaptureStartResult(boolean z) {
        this.f$0.lambda$onCreate$1(z);
    }
}
