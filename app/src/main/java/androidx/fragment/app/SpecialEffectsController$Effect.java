package androidx.fragment.app;

import android.view.ViewGroup;
import androidx.activity.BackEventCompat;
import androidx.fragment.app.DefaultSpecialEffectsController;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public abstract class SpecialEffectsController$Effect {
    public boolean isCancelled;
    public boolean isStarted;

    public boolean isSeekingSupported() {
        return this instanceof DefaultSpecialEffectsController.AnimatorEffect;
    }

    public abstract void onCancel(ViewGroup viewGroup);

    public abstract void onCommit(ViewGroup viewGroup);

    public void onProgress(BackEventCompat backEvent, ViewGroup container) {
        Intrinsics.checkNotNullParameter(backEvent, "backEvent");
        Intrinsics.checkNotNullParameter(container, "container");
    }

    public void onStart(ViewGroup container) {
        Intrinsics.checkNotNullParameter(container, "container");
    }
}
