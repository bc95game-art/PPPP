package androidx.fragment.app;

import android.util.Log;
import android.view.ViewGroup;
import androidx.core.p002os.CancellationSignal;
import androidx.fragment.app.DefaultSpecialEffectsController;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
/* loaded from: classes.dex */
public final class DefaultSpecialEffectsController$TransitionEffect$onCommit$4 extends Lambda implements Function0 {
    public final /* synthetic */ ViewGroup $container;
    public final /* synthetic */ Object $mergedTransition;
    public final /* synthetic */ int $r8$classId = 0;
    public final /* synthetic */ DefaultSpecialEffectsController.TransitionEffect this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultSpecialEffectsController$TransitionEffect$onCommit$4(DefaultSpecialEffectsController.TransitionEffect transitionEffect, ViewGroup viewGroup, Object obj) {
        super(0);
        this.this$0 = transitionEffect;
        this.$container = viewGroup;
        this.$mergedTransition = obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v4, types: [androidx.core.os.CancellationSignal, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch (this.$r8$classId) {
            case 0:
                this.this$0.transitionImpl.beginDelayedTransition(this.$container, this.$mergedTransition);
                return Unit.INSTANCE;
            default:
                DefaultSpecialEffectsController.TransitionEffect transitionEffect = this.this$0;
                ArrayList arrayList = transitionEffect.transitionInfos;
                FragmentTransitionImpl fragmentTransitionImpl = transitionEffect.transitionImpl;
                if (!arrayList.isEmpty()) {
                    int size = arrayList.size();
                    int i = 0;
                    while (i < size) {
                        Object obj = arrayList.get(i);
                        i++;
                        if (!((DefaultSpecialEffectsController.TransitionInfo) obj).operation.isSeeking) {
                            if (FragmentManager.isLoggingEnabled(2)) {
                                Log.v("FragmentManager", "Completing animating immediately");
                            }
                            ?? obj2 = new Object();
                            fragmentTransitionImpl.setListenerForTransitionEnd(((DefaultSpecialEffectsController.TransitionInfo) arrayList.get(0)).operation.fragment, this.$mergedTransition, (CancellationSignal) obj2, new Fragment$$ExternalSyntheticLambda1(3, transitionEffect));
                            obj2.cancel();
                            return Unit.INSTANCE;
                        }
                    }
                }
                if (FragmentManager.isLoggingEnabled(2)) {
                    Log.v("FragmentManager", "Animating to start");
                }
                Object obj3 = transitionEffect.controller;
                Intrinsics.checkNotNull(obj3);
                fragmentTransitionImpl.animateToStart(obj3, new RunnableC0058xf804c657(transitionEffect, this.$container));
                return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultSpecialEffectsController$TransitionEffect$onCommit$4(DefaultSpecialEffectsController.TransitionEffect transitionEffect, Object obj, ViewGroup viewGroup) {
        super(0);
        this.this$0 = transitionEffect;
        this.$mergedTransition = obj;
        this.$container = viewGroup;
    }
}
