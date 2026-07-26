package com.emanuelef.remote_capture;

import android.app.Notification;
import android.view.View;
import androidx.profileinstaller.DeviceProfileWriter;
import com.emanuelef.remote_capture.activities.AboutActivity;
/* loaded from: classes.dex */
public final /* synthetic */ class CaptureService$$ExternalSyntheticLambda8 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ int f$1;
    public final /* synthetic */ Object f$2;

    public /* synthetic */ CaptureService$$ExternalSyntheticLambda8(int i, int i2, Object obj, Object obj2) {
        this.$r8$classId = i2;
        this.f$0 = obj;
        this.f$1 = i;
        this.f$2 = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.$r8$classId) {
            case 0:
                ((CaptureService) this.f$0).lambda$notifyBlacklistedConnection$0(this.f$1, (Notification) this.f$2);
                return;
            case 1:
                ((DeviceProfileWriter) this.f$0).mDiagnostics.onResultReceived(this.f$1, this.f$2);
                return;
            default:
                ((AboutActivity) this.f$0).lambda$showQrCode$10((View) this.f$2, this.f$1);
                return;
        }
    }

    public /* synthetic */ CaptureService$$ExternalSyntheticLambda8(AboutActivity aboutActivity, View view, int i) {
        this.$r8$classId = 2;
        this.f$0 = aboutActivity;
        this.f$2 = view;
        this.f$1 = i;
    }
}
