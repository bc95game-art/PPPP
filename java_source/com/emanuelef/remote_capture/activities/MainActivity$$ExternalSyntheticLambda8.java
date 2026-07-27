package com.emanuelef.remote_capture.activities;

import android.net.Uri;
import android.os.Handler;
import com.emanuelef.remote_capture.HttpLog;
import com.emanuelef.remote_capture.fragments.ConnectionsFragment;
import java.io.File;
/* loaded from: classes.dex */
public final /* synthetic */ class MainActivity$$ExternalSyntheticLambda8 implements Runnable {
    public final /* synthetic */ int $r8$classId = 1;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Uri f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ Object f$3;
    public final /* synthetic */ Object f$4;

    public /* synthetic */ MainActivity$$ExternalSyntheticLambda8(HttpDetailsActivity httpDetailsActivity, Uri uri, HttpLog.HttpRequest httpRequest, boolean[] zArr, Handler handler) {
        this.f$0 = httpDetailsActivity;
        this.f$1 = uri;
        this.f$4 = httpRequest;
        this.f$2 = zArr;
        this.f$3 = handler;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.$r8$classId) {
            case 0:
                ((MainActivity) this.f$0).lambda$startOpenPcap$27(this.f$1, (File) this.f$2, (String) this.f$3, (Uri) this.f$4);
                return;
            case 1:
                ((HttpDetailsActivity) this.f$0).lambda$exportHar$5(this.f$1, (HttpLog.HttpRequest) this.f$4, (boolean[]) this.f$2, (Handler) this.f$3);
                return;
            default:
                ((ConnectionsFragment) this.f$0).lambda$dumpCsv$20(this.f$1, (String) this.f$3, (boolean[]) this.f$4, (Handler) this.f$2);
                return;
        }
    }

    public /* synthetic */ MainActivity$$ExternalSyntheticLambda8(MainActivity mainActivity, Uri uri, File file, String str, Uri uri2) {
        this.f$0 = mainActivity;
        this.f$1 = uri;
        this.f$2 = file;
        this.f$3 = str;
        this.f$4 = uri2;
    }

    public /* synthetic */ MainActivity$$ExternalSyntheticLambda8(ConnectionsFragment connectionsFragment, Uri uri, String str, boolean[] zArr, Handler handler) {
        this.f$0 = connectionsFragment;
        this.f$1 = uri;
        this.f$3 = str;
        this.f$4 = zArr;
        this.f$2 = handler;
    }
}
