package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import java.util.HashMap;
/* loaded from: classes.dex */
public final class SavedStateHandleAttacher implements LifecycleEventObserver {
    public final /* synthetic */ int $r8$classId;
    public final Object provider;

    public /* synthetic */ SavedStateHandleAttacher(int i, Object obj) {
        this.$r8$classId = i;
        this.provider = obj;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        switch (this.$r8$classId) {
            case 0:
                if (event == Lifecycle.Event.ON_CREATE) {
                    lifecycleOwner.getLifecycle().removeObserver(this);
                    ((SavedStateHandlesProvider) this.provider).performRestore();
                    return;
                }
                throw new IllegalStateException(("Next event must be ON_CREATE, it was " + event).toString());
            default:
                new HashMap();
                GeneratedAdapter[] generatedAdapterArr = (GeneratedAdapter[]) this.provider;
                if (generatedAdapterArr.length > 0) {
                    GeneratedAdapter generatedAdapter = generatedAdapterArr[0];
                    throw null;
                } else if (generatedAdapterArr.length > 0) {
                    GeneratedAdapter generatedAdapter2 = generatedAdapterArr[0];
                    throw null;
                } else {
                    return;
                }
        }
    }
}
