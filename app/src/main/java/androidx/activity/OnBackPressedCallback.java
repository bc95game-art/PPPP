package androidx.activity;

import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public abstract class OnBackPressedCallback {
    public OnBackPressedDispatcher$addCallback$1 enabledChangedCallback;
    public boolean isEnabled = false;
    public final CopyOnWriteArrayList cancellables = new CopyOnWriteArrayList();

    public void handleOnBackCancelled() {
    }

    public abstract void handleOnBackPressed();

    public void handleOnBackProgressed(BackEventCompat backEvent) {
        Intrinsics.checkNotNullParameter(backEvent, "backEvent");
    }

    public void handleOnBackStarted(BackEventCompat backEvent) {
        Intrinsics.checkNotNullParameter(backEvent, "backEvent");
    }

    public final void setEnabled(boolean z) {
        this.isEnabled = z;
        OnBackPressedDispatcher$addCallback$1 onBackPressedDispatcher$addCallback$1 = this.enabledChangedCallback;
        if (onBackPressedDispatcher$addCallback$1 != null) {
            onBackPressedDispatcher$addCallback$1.invoke();
        }
    }
}
