package androidx.fragment.app;

import android.util.Log;
import android.view.ViewGroup;
import androidx.constraintlayout.core.SolverVariable$Type$EnumUnboxingSharedUtility;
import androidx.lifecycle.ViewModelProvider;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class SpecialEffectsController$FragmentStateManagerOperation {
    public final ArrayList _effects;
    public final ArrayList effects;
    public int finalState;
    public final Fragment fragment;
    public final FragmentStateManager fragmentStateManager;
    public boolean isCanceled;
    public boolean isComplete;
    public boolean isSeeking;
    public boolean isStarted;
    public int lifecycleImpact;
    public final ArrayList completionListeners = new ArrayList();
    public boolean isAwaitingContainerChanges = true;

    public SpecialEffectsController$FragmentStateManagerOperation(int i, int i2, FragmentStateManager fragmentStateManager) {
        ViewModelProvider.Factory.CC.m(i, "finalState");
        ViewModelProvider.Factory.CC.m(i2, "lifecycleImpact");
        Fragment fragment = fragmentStateManager.mFragment;
        Intrinsics.checkNotNullExpressionValue(fragment, "fragmentStateManager.fragment");
        ViewModelProvider.Factory.CC.m(i, "finalState");
        ViewModelProvider.Factory.CC.m(i2, "lifecycleImpact");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.finalState = i;
        this.lifecycleImpact = i2;
        this.fragment = fragment;
        ArrayList arrayList = new ArrayList();
        this._effects = arrayList;
        this.effects = arrayList;
        this.fragmentStateManager = fragmentStateManager;
    }

    public final void cancel(ViewGroup container) {
        Intrinsics.checkNotNullParameter(container, "container");
        this.isStarted = false;
        if (!this.isCanceled) {
            this.isCanceled = true;
            if (this._effects.isEmpty()) {
                complete$fragment_release();
                return;
            }
            for (SpecialEffectsController$Effect specialEffectsController$Effect : CollectionsKt.toList(this.effects)) {
                specialEffectsController$Effect.getClass();
                if (!specialEffectsController$Effect.isCancelled) {
                    specialEffectsController$Effect.onCancel(container);
                }
                specialEffectsController$Effect.isCancelled = true;
            }
        }
    }

    public final void complete$fragment_release() {
        this.isStarted = false;
        if (!this.isComplete) {
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: " + this + " has called complete.");
            }
            this.isComplete = true;
            ArrayList arrayList = this.completionListeners;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                ((Runnable) obj).run();
            }
        }
        this.fragment.mTransitioning = false;
        this.fragmentStateManager.moveToExpectedState();
    }

    public final void completeEffect(SpecialEffectsController$Effect effect) {
        Intrinsics.checkNotNullParameter(effect, "effect");
        ArrayList arrayList = this._effects;
        if (arrayList.remove(effect) && arrayList.isEmpty()) {
            complete$fragment_release();
        }
    }

    public final void mergeWith(int i, int i2) {
        ViewModelProvider.Factory.CC.m(i, "finalState");
        ViewModelProvider.Factory.CC.m(i2, "lifecycleImpact");
        int ordinal = SolverVariable$Type$EnumUnboxingSharedUtility.ordinal(i2);
        Fragment fragment = this.fragment;
        if (ordinal != 0) {
            if (ordinal != 1) {
                if (ordinal == 2) {
                    if (FragmentManager.isLoggingEnabled(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: For fragment " + fragment + " mFinalState = " + ViewModelProvider.Factory.CC.stringValueOf$2(this.finalState) + " -> REMOVED. mLifecycleImpact  = " + ViewModelProvider.Factory.CC.stringValueOf$1(this.lifecycleImpact) + " to REMOVING.");
                    }
                    this.finalState = 1;
                    this.lifecycleImpact = 3;
                    this.isAwaitingContainerChanges = true;
                }
            } else if (this.finalState == 1) {
                if (FragmentManager.isLoggingEnabled(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: For fragment " + fragment + " mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = " + ViewModelProvider.Factory.CC.stringValueOf$1(this.lifecycleImpact) + " to ADDING.");
                }
                this.finalState = 2;
                this.lifecycleImpact = 2;
                this.isAwaitingContainerChanges = true;
            }
        } else if (this.finalState != 1) {
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: For fragment " + fragment + " mFinalState = " + ViewModelProvider.Factory.CC.stringValueOf$2(this.finalState) + " -> " + ViewModelProvider.Factory.CC.stringValueOf$2(i) + '.');
            }
            this.finalState = i;
        }
    }

    public final String toString() {
        StringBuilder m = ViewModelProvider.Factory.CC.m15m("Operation {", Integer.toHexString(System.identityHashCode(this)), "} {finalState = ");
        m.append(ViewModelProvider.Factory.CC.stringValueOf$2(this.finalState));
        m.append(" lifecycleImpact = ");
        m.append(ViewModelProvider.Factory.CC.stringValueOf$1(this.lifecycleImpact));
        m.append(" fragment = ");
        m.append(this.fragment);
        m.append('}');
        return m.toString();
    }
}
