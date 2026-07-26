package com.emanuelef.remote_capture.activities;

import android.net.Uri;
/* loaded from: classes.dex */
public final /* synthetic */ class MainActivity$$ExternalSyntheticLambda16 implements Runnable {
    public final /* synthetic */ int $r8$classId = 1;
    public final /* synthetic */ MainActivity f$0;
    public final /* synthetic */ String f$1;
    public final /* synthetic */ Uri f$2;

    public /* synthetic */ MainActivity$$ExternalSyntheticLambda16(MainActivity mainActivity, Uri uri, String str) {
        this.f$0 = mainActivity;
        this.f$2 = uri;
        this.f$1 = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.$r8$classId) {
            case 0:
                this.f$0.lambda$startOpenPcap$26(this.f$1, this.f$2);
                return;
            default:
                this.f$0.lambda$loadKeylogfile$31(this.f$2, this.f$1);
                return;
        }
    }

    public /* synthetic */ MainActivity$$ExternalSyntheticLambda16(MainActivity mainActivity, String str, Uri uri) {
        this.f$0 = mainActivity;
        this.f$1 = str;
        this.f$2 = uri;
    }
}
