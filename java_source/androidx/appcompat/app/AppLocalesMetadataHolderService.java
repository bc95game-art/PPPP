package androidx.appcompat.app;

import android.app.Service;
import com.emanuelef.remote_capture.fragments.LogviewFragment;
/* loaded from: classes.dex */
public abstract class AppLocalesMetadataHolderService extends Service {
    public static final /* synthetic */ int $r8$clinit = 0;

    /* loaded from: classes.dex */
    public abstract class Api24Impl {
        public static int getDisabledComponentFlag() {
            return LogviewFragment.MAX_LINES;
        }
    }
}
