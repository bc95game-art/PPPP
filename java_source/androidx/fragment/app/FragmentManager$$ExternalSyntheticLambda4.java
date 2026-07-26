package androidx.fragment.app;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.savedstate.SavedStateRegistry;
/* loaded from: classes.dex */
public final /* synthetic */ class FragmentManager$$ExternalSyntheticLambda4 implements SavedStateRegistry.SavedStateProvider {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ FragmentManager$$ExternalSyntheticLambda4(int i, Object obj) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }

    @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
    public final Bundle saveState() {
        switch (this.$r8$classId) {
            case 0:
                return ((FragmentManager) this.f$0).saveAllStateInternal();
            default:
                AppCompatActivity appCompatActivity = (AppCompatActivity) this.f$0;
                appCompatActivity.markFragmentsCreated();
                appCompatActivity.mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
                return new Bundle();
        }
    }
}
