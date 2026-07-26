package androidx.core.content.res;

import android.view.View;
import androidx.core.content.res.ResourcesCompat;
import com.emanuelef.remote_capture.fragments.ConnectionsFragment;
import com.google.android.material.sidesheet.SideSheetBehavior;
/* loaded from: classes.dex */
public final /* synthetic */ class ResourcesCompat$FontCallback$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ int f$1;

    public /* synthetic */ ResourcesCompat$FontCallback$$ExternalSyntheticLambda1(int i, int i2, Object obj) {
        this.$r8$classId = i2;
        this.f$0 = obj;
        this.f$1 = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.$r8$classId) {
            case 0:
                ((ResourcesCompat.FontCallback) this.f$0).onFontRetrievalFailed(this.f$1);
                return;
            case 1:
                ConnectionsFragment.$r8$lambda$Oo3FeU_lbLwIJhdberAbQ7alkQw((ConnectionsFragment) this.f$0, this.f$1);
                return;
            default:
                SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) this.f$0;
                View view = (View) sideSheetBehavior.viewRef.get();
                if (view != null) {
                    sideSheetBehavior.startSettling$1(view, this.f$1, false);
                    return;
                }
                return;
        }
    }
}
