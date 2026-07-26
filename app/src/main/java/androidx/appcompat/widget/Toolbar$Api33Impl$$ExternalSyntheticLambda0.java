package androidx.appcompat.widget;

import android.window.OnBackInvokedCallback;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.google.android.material.motion.MaterialBackHandler;
import kotlin.jvm.functions.Function0;
/* loaded from: classes.dex */
public final /* synthetic */ class Toolbar$Api33Impl$$ExternalSyntheticLambda0 implements OnBackInvokedCallback {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ Toolbar$Api33Impl$$ExternalSyntheticLambda0(int i, Object obj) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }

    public final void onBackInvoked() {
        switch (this.$r8$classId) {
            case 0:
                ((Runnable) this.f$0).run();
                return;
            case 1:
                ((Function0) this.f$0).invoke();
                return;
            case 2:
                ((AppCompatDelegateImpl) this.f$0).onBackPressed();
                return;
            default:
                ((MaterialBackHandler) this.f$0).handleBackInvoked();
                return;
        }
    }
}
