package androidx.fragment.app;

import android.util.Log;
import android.view.ViewGroup;
import androidx.fragment.app.DefaultSpecialEffectsController;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$ObjectRef;
/* loaded from: classes.dex */
public final class DefaultSpecialEffectsController$TransitionEffect$onStart$4 extends Lambda implements Function0 {
    public final /* synthetic */ ViewGroup $container;
    public final /* synthetic */ Object $mergedTransition;
    public final /* synthetic */ Ref$ObjectRef $seekCancelLambda;
    public final /* synthetic */ DefaultSpecialEffectsController.TransitionEffect this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultSpecialEffectsController$TransitionEffect$onStart$4(DefaultSpecialEffectsController.TransitionEffect transitionEffect, ViewGroup viewGroup, Object obj, Ref$ObjectRef ref$ObjectRef) {
        super(0);
        this.this$0 = transitionEffect;
        this.$container = viewGroup;
        this.$mergedTransition = obj;
        this.$seekCancelLambda = ref$ObjectRef;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v("FragmentManager", "Attempting to create TransitionSeekController");
        }
        DefaultSpecialEffectsController.TransitionEffect transitionEffect = this.this$0;
        FragmentTransitionImpl fragmentTransitionImpl = transitionEffect.transitionImpl;
        ViewGroup viewGroup = this.$container;
        Object obj = this.$mergedTransition;
        Object controlDelayedTransition = fragmentTransitionImpl.controlDelayedTransition(viewGroup, obj);
        transitionEffect.controller = controlDelayedTransition;
        if (controlDelayedTransition == null) {
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v("FragmentManager", "TransitionSeekController was not created.");
            }
            transitionEffect.noControllerReturned = true;
        } else {
            this.$seekCancelLambda.element = new DefaultSpecialEffectsController$TransitionEffect$onCommit$4(transitionEffect, obj, viewGroup);
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v("FragmentManager", "Started executing operations from " + transitionEffect.firstOut + " to " + transitionEffect.lastIn);
            }
        }
        return Unit.INSTANCE;
    }
}
