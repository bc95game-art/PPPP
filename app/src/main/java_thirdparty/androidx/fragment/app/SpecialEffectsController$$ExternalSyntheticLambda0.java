package androidx.fragment.app;

import android.view.View;
import androidx.lifecycle.ViewModelProvider;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final /* synthetic */ class SpecialEffectsController$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ DefaultSpecialEffectsController f$0;
    public final /* synthetic */ SpecialEffectsController$FragmentStateManagerOperation f$1;

    public /* synthetic */ SpecialEffectsController$$ExternalSyntheticLambda0(DefaultSpecialEffectsController defaultSpecialEffectsController, SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation, int i) {
        this.$r8$classId = i;
        this.f$0 = defaultSpecialEffectsController;
        this.f$1 = specialEffectsController$FragmentStateManagerOperation;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.$r8$classId) {
            case 0:
                DefaultSpecialEffectsController defaultSpecialEffectsController = this.f$0;
                ArrayList arrayList = defaultSpecialEffectsController.pendingOperations;
                SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation = this.f$1;
                if (arrayList.contains(specialEffectsController$FragmentStateManagerOperation)) {
                    int i = specialEffectsController$FragmentStateManagerOperation.finalState;
                    View view = specialEffectsController$FragmentStateManagerOperation.fragment.mView;
                    Intrinsics.checkNotNullExpressionValue(view, "operation.fragment.mView");
                    ViewModelProvider.Factory.CC._applyState(i, view, defaultSpecialEffectsController.container);
                    return;
                }
                return;
            case 1:
                DefaultSpecialEffectsController this$0 = this.f$0;
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                SpecialEffectsController$FragmentStateManagerOperation operation = this.f$1;
                Intrinsics.checkNotNullParameter(operation, "$operation");
                this$0.applyContainerChangesToOperation$fragment_release(operation);
                return;
            default:
                DefaultSpecialEffectsController defaultSpecialEffectsController2 = this.f$0;
                ArrayList arrayList2 = defaultSpecialEffectsController2.pendingOperations;
                SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation2 = this.f$1;
                arrayList2.remove(specialEffectsController$FragmentStateManagerOperation2);
                defaultSpecialEffectsController2.runningOperations.remove(specialEffectsController$FragmentStateManagerOperation2);
                return;
        }
    }
}
