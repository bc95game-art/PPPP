package androidx.fragment.app;

import android.util.Log;
import androidx.fragment.app.DefaultSpecialEffectsController;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final /* synthetic */ class DefaultSpecialEffectsController$TransitionEffect$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ SpecialEffectsController$FragmentStateManagerOperation f$0;
    public final /* synthetic */ DefaultSpecialEffectsController.TransitionEffect f$1;

    public /* synthetic */ DefaultSpecialEffectsController$TransitionEffect$$ExternalSyntheticLambda1(SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation, DefaultSpecialEffectsController.TransitionEffect transitionEffect, int i) {
        this.$r8$classId = i;
        this.f$0 = specialEffectsController$FragmentStateManagerOperation;
        this.f$1 = transitionEffect;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.$r8$classId) {
            case 0:
                SpecialEffectsController$FragmentStateManagerOperation operation = this.f$0;
                Intrinsics.checkNotNullParameter(operation, "$operation");
                DefaultSpecialEffectsController.TransitionEffect this$0 = this.f$1;
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                if (FragmentManager.isLoggingEnabled(2)) {
                    Log.v("FragmentManager", "Transition for operation " + operation + " has completed");
                }
                operation.completeEffect(this$0);
                return;
            default:
                SpecialEffectsController$FragmentStateManagerOperation operation2 = this.f$0;
                Intrinsics.checkNotNullParameter(operation2, "$operation");
                DefaultSpecialEffectsController.TransitionEffect this$02 = this.f$1;
                Intrinsics.checkNotNullParameter(this$02, "this$0");
                if (FragmentManager.isLoggingEnabled(2)) {
                    Log.v("FragmentManager", "Transition for operation " + operation2 + " has completed");
                }
                operation2.completeEffect(this$02);
                return;
        }
    }
}
