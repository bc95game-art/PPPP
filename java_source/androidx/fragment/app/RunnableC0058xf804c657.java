package androidx.fragment.app;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.DefaultSpecialEffectsController;
import androidx.lifecycle.ViewModelProvider;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: androidx.fragment.app.DefaultSpecialEffectsController$TransitionEffect$$ExternalSyntheticLambda4 */
/* loaded from: classes.dex */
public final /* synthetic */ class RunnableC0058xf804c657 implements Runnable {
    public final /* synthetic */ int $r8$classId = 1;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;

    public /* synthetic */ RunnableC0058xf804c657(DefaultSpecialEffectsController.TransitionEffect transitionEffect, ViewGroup viewGroup) {
        this.f$1 = transitionEffect;
        this.f$2 = viewGroup;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.$r8$classId) {
            case 0:
                FragmentTransitionImpl.getBoundsOnScreen((View) this.f$1, (Rect) this.f$2);
                return;
            default:
                ViewGroup container = (ViewGroup) this.f$2;
                Intrinsics.checkNotNullParameter(container, "$container");
                ArrayList arrayList = ((DefaultSpecialEffectsController.TransitionEffect) this.f$1).transitionInfos;
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation = ((DefaultSpecialEffectsController.TransitionInfo) obj).operation;
                    View view = specialEffectsController$FragmentStateManagerOperation.fragment.getView();
                    if (view != null) {
                        ViewModelProvider.Factory.CC._applyState(specialEffectsController$FragmentStateManagerOperation.finalState, view, container);
                    }
                }
                return;
        }
    }

    public /* synthetic */ RunnableC0058xf804c657(FragmentTransitionImpl fragmentTransitionImpl, View view, Rect rect) {
        this.f$1 = view;
        this.f$2 = rect;
    }
}
