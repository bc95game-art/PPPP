package androidx.transition;

import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import androidx.core.os.CancellationSignal;
import androidx.fragment.app.DefaultSpecialEffectsController$TransitionEffect$$ExternalSyntheticLambda4;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.Fragment$$ExternalSyntheticLambda1;
import androidx.fragment.app.FragmentTransitionImpl;
import androidx.navigation.Navigation;
import androidx.transition.Transition;
import com.emanuelef.remote_capture.R;
import java.util.ArrayList;
import org.brotli.dec.HuffmanTreeGroup;
/* loaded from: classes.dex */
public class FragmentTransitionSupport extends FragmentTransitionImpl {

    /* renamed from: androidx.transition.FragmentTransitionSupport$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public final class AnonymousClass1 extends Navigation {
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public final void addTarget(View view, Object obj) {
        ((Transition) obj).addTarget(view);
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public final void addTargets(ArrayList arrayList, Object obj) {
        Transition transition = (Transition) obj;
        if (transition != null) {
            int i = 0;
            if (transition instanceof TransitionSet) {
                TransitionSet transitionSet = (TransitionSet) transition;
                int size = transitionSet.mTransitions.size();
                while (i < size) {
                    addTargets(arrayList, transitionSet.getTransitionAt(i));
                    i++;
                }
            } else if (FragmentTransitionImpl.isNullOrEmpty(transition.mTargetIds) && FragmentTransitionImpl.isNullOrEmpty(transition.mTargets)) {
                int size2 = arrayList.size();
                while (i < size2) {
                    transition.addTarget((View) arrayList.get(i));
                    i++;
                }
            }
        }
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public final void animateToEnd(Object obj) {
        Transition.SeekController seekController = (Transition.SeekController) obj;
        seekController.ensureAnimation();
        seekController.mSpringAnimation.animateToFinalPosition((float) (seekController.this$0.mTotalDuration + 1));
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public final void animateToStart(Object obj, DefaultSpecialEffectsController$TransitionEffect$$ExternalSyntheticLambda4 defaultSpecialEffectsController$TransitionEffect$$ExternalSyntheticLambda4) {
        Transition.SeekController seekController = (Transition.SeekController) obj;
        seekController.mResetToStartState = defaultSpecialEffectsController$TransitionEffect$$ExternalSyntheticLambda4;
        seekController.ensureAnimation();
        seekController.mSpringAnimation.animateToFinalPosition(0.0f);
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public final void beginDelayedTransition(ViewGroup viewGroup, Object obj) {
        TransitionManager.beginDelayedTransition(viewGroup, (Transition) obj);
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public final boolean canHandle(Object obj) {
        return obj instanceof Transition;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public final Object cloneTransition(Object obj) {
        if (obj != null) {
            return ((Transition) obj).clone();
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v5, types: [android.view.ViewTreeObserver$OnPreDrawListener, java.lang.Object, android.view.View$OnAttachStateChangeListener, androidx.transition.TransitionManager$MultiListener] */
    @Override // androidx.fragment.app.FragmentTransitionImpl
    public final Object controlDelayedTransition(ViewGroup viewGroup, Object obj) {
        Transition transition = (Transition) obj;
        ArrayList arrayList = TransitionManager.sPendingTransitions;
        if (arrayList.contains(viewGroup) || !viewGroup.isLaidOut() || Build.VERSION.SDK_INT < 34) {
            return null;
        }
        if (transition.isSeekingSupported()) {
            arrayList.add(viewGroup);
            Transition clone = transition.clone();
            TransitionSet transitionSet = new TransitionSet();
            transitionSet.addTransition(clone);
            TransitionManager.sceneChangeSetup(viewGroup, transitionSet);
            viewGroup.setTag(R.id.transition_current_scene, null);
            ?? obj2 = new Object();
            obj2.mTransition = transitionSet;
            obj2.mSceneRoot = viewGroup;
            viewGroup.addOnAttachStateChangeListener(obj2);
            viewGroup.getViewTreeObserver().addOnPreDrawListener(obj2);
            viewGroup.invalidate();
            Transition.SeekController seekController = new Transition.SeekController(transitionSet);
            transitionSet.mSeekController = seekController;
            transitionSet.addListener(seekController);
            return transitionSet.mSeekController;
        }
        throw new IllegalArgumentException("The Transition must support seeking.");
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public final boolean isSeekingSupported() {
        return true;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public final Object mergeTransitionsInSequence(Object obj, Object obj2, Object obj3) {
        Transition transition = (Transition) obj;
        Transition transition2 = (Transition) obj2;
        Transition transition3 = (Transition) obj3;
        if (transition != null && transition2 != null) {
            TransitionSet transitionSet = new TransitionSet();
            transitionSet.addTransition(transition);
            transitionSet.addTransition(transition2);
            transitionSet.mPlayTogether = false;
            transition = transitionSet;
        } else if (transition == null) {
            if (transition2 != null) {
                transition = transition2;
            } else {
                transition = null;
            }
        }
        if (transition3 == null) {
            return transition;
        }
        TransitionSet transitionSet2 = new TransitionSet();
        if (transition != null) {
            transitionSet2.addTransition(transition);
        }
        transitionSet2.addTransition(transition3);
        return transitionSet2;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public final Object mergeTransitionsTogether(Object obj, Object obj2) {
        TransitionSet transitionSet = new TransitionSet();
        if (obj != null) {
            transitionSet.addTransition((Transition) obj);
        }
        transitionSet.addTransition((Transition) obj2);
        return transitionSet;
    }

    public final void replaceTargets(Object obj, ArrayList arrayList, ArrayList arrayList2) {
        int i;
        Transition transition = (Transition) obj;
        int i2 = 0;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            int size = transitionSet.mTransitions.size();
            while (i2 < size) {
                replaceTargets(transitionSet.getTransitionAt(i2), arrayList, arrayList2);
                i2++;
            }
        } else if (FragmentTransitionImpl.isNullOrEmpty(transition.mTargetIds)) {
            ArrayList arrayList3 = transition.mTargets;
            if (arrayList3.size() == arrayList.size() && arrayList3.containsAll(arrayList)) {
                if (arrayList2 == null) {
                    i = 0;
                } else {
                    i = arrayList2.size();
                }
                while (i2 < i) {
                    transition.addTarget((View) arrayList2.get(i2));
                    i2++;
                }
                for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                    transition.removeTarget((View) arrayList.get(size2));
                }
            }
        }
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public final void scheduleHideFragmentView(Object obj, final View view, final ArrayList arrayList) {
        ((Transition) obj).addListener(new Transition.TransitionListener() { // from class: androidx.transition.FragmentTransitionSupport.2
            @Override // androidx.transition.Transition.TransitionListener
            public final void onTransitionCancel(Transition transition) {
            }

            @Override // androidx.transition.Transition.TransitionListener
            public final void onTransitionEnd(Transition transition) {
                transition.removeListener(this);
                view.setVisibility(8);
                ArrayList arrayList2 = arrayList;
                int size = arrayList2.size();
                for (int i = 0; i < size; i++) {
                    ((View) arrayList2.get(i)).setVisibility(0);
                }
            }

            @Override // androidx.transition.Transition.TransitionListener
            public final void onTransitionEnd$1(Transition transition) {
                onTransitionEnd(transition);
            }

            @Override // androidx.transition.Transition.TransitionListener
            public final void onTransitionStart(Transition transition) {
                transition.removeListener(this);
                transition.addListener(this);
            }

            @Override // androidx.transition.Transition.TransitionListener
            public final void onTransitionStart$1(Transition transition) {
                onTransitionStart(transition);
            }

            @Override // androidx.transition.Transition.TransitionListener
            public final void onTransitionPause() {
            }

            @Override // androidx.transition.Transition.TransitionListener
            public final void onTransitionResume() {
            }
        });
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public final void scheduleRemoveTargets(Object obj, final Object obj2, final ArrayList arrayList, final Object obj3, final ArrayList arrayList2) {
        ((Transition) obj).addListener(new TransitionListenerAdapter() { // from class: androidx.transition.FragmentTransitionSupport.3
            @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
            public final void onTransitionEnd(Transition transition) {
                transition.removeListener(this);
            }

            @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
            public final void onTransitionStart(Transition transition) {
                FragmentTransitionSupport fragmentTransitionSupport = FragmentTransitionSupport.this;
                Object obj4 = obj2;
                if (obj4 != null) {
                    fragmentTransitionSupport.replaceTargets(obj4, arrayList, null);
                }
                Object obj5 = obj3;
                if (obj5 != null) {
                    fragmentTransitionSupport.replaceTargets(obj5, arrayList2, null);
                }
            }
        });
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public final void setCurrentPlayTime(Object obj, float f) {
        Transition.SeekController seekController = (Transition.SeekController) obj;
        boolean z = seekController.mIsReady;
        if (z) {
            TransitionSet transitionSet = seekController.this$0;
            long j = transitionSet.mTotalDuration;
            long j2 = f * ((float) j);
            if (j2 == 0) {
                j2 = 1;
            }
            if (j2 == j) {
                j2 = j - 1;
            }
            if (seekController.mSpringAnimation == null) {
                long j3 = seekController.mCurrentPlayTime;
                if (j2 != j3 && z) {
                    if (!seekController.mIsCanceled) {
                        if (j2 == 0 && j3 > 0) {
                            j2 = -1;
                        } else if (j2 == j && j3 < j) {
                            j2 = j + 1;
                        }
                        if (j2 != j3) {
                            transitionSet.setCurrentPlayTimeMillis(j2, j3);
                            seekController.mCurrentPlayTime = j2;
                        }
                    }
                    HuffmanTreeGroup huffmanTreeGroup = seekController.mVelocityTracker;
                    long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                    int i = (huffmanTreeGroup.alphabetSize + 1) % 20;
                    huffmanTreeGroup.alphabetSize = i;
                    ((long[]) huffmanTreeGroup.codes)[i] = currentAnimationTimeMillis;
                    ((float[]) huffmanTreeGroup.trees)[i] = (float) j2;
                    return;
                }
                return;
            }
            throw new IllegalStateException("setCurrentPlayTimeMillis() called after animation has been started");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [androidx.navigation.Navigation, java.lang.Object] */
    @Override // androidx.fragment.app.FragmentTransitionImpl
    public final void setEpicenter(View view, Object obj) {
        if (view != null) {
            FragmentTransitionImpl.getBoundsOnScreen(view, new Rect());
            ((Transition) obj).setEpicenterCallback(new Object());
        }
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public final void setListenerForTransitionEnd(Fragment fragment, Object obj, CancellationSignal cancellationSignal, Runnable runnable) {
        setListenerForTransitionEnd(obj, cancellationSignal, (Fragment$$ExternalSyntheticLambda1) null, runnable);
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public final void setSharedElementTargets(Object obj, View view, ArrayList arrayList) {
        TransitionSet transitionSet = (TransitionSet) obj;
        ArrayList arrayList2 = transitionSet.mTargets;
        arrayList2.clear();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            FragmentTransitionImpl.bfsAddViewChildren((View) arrayList.get(i), arrayList2);
        }
        arrayList2.add(view);
        arrayList.add(view);
        addTargets(arrayList, transitionSet);
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public final void swapSharedElementTargets(Object obj, ArrayList arrayList, ArrayList arrayList2) {
        TransitionSet transitionSet = (TransitionSet) obj;
        if (transitionSet != null) {
            ArrayList arrayList3 = transitionSet.mTargets;
            arrayList3.clear();
            arrayList3.addAll(arrayList2);
            replaceTargets(transitionSet, arrayList, arrayList2);
        }
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public final Object wrapTransitionInSet(Object obj) {
        if (obj == null) {
            return null;
        }
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.addTransition((Transition) obj);
        return transitionSet;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public final boolean isSeekingSupported(Object obj) {
        boolean isSeekingSupported = ((Transition) obj).isSeekingSupported();
        if (!isSeekingSupported) {
            Log.v("FragmentManager", "Predictive back not available for AndroidX Transition " + obj + ". Please enable seeking support for the designated transition by overriding isSeekingSupported().");
        }
        return isSeekingSupported;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public final void setListenerForTransitionEnd(Object obj, CancellationSignal cancellationSignal, Fragment$$ExternalSyntheticLambda1 fragment$$ExternalSyntheticLambda1, final Runnable runnable) {
        Transition transition = (Transition) obj;
        FragmentTransitionSupport$$ExternalSyntheticLambda0 fragmentTransitionSupport$$ExternalSyntheticLambda0 = new FragmentTransitionSupport$$ExternalSyntheticLambda0(fragment$$ExternalSyntheticLambda1, transition, runnable);
        synchronized (cancellationSignal) {
            while (cancellationSignal.mCancelInProgress) {
                try {
                    try {
                        cancellationSignal.wait();
                    } catch (InterruptedException unused) {
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (cancellationSignal.mOnCancelListener != fragmentTransitionSupport$$ExternalSyntheticLambda0) {
                cancellationSignal.mOnCancelListener = fragmentTransitionSupport$$ExternalSyntheticLambda0;
                if (cancellationSignal.mIsCanceled) {
                    Runnable runnable2 = (Runnable) fragmentTransitionSupport$$ExternalSyntheticLambda0.f$0;
                    Transition transition2 = (Transition) fragmentTransitionSupport$$ExternalSyntheticLambda0.f$1;
                    Runnable runnable3 = (Runnable) fragmentTransitionSupport$$ExternalSyntheticLambda0.f$2;
                    if (runnable2 == null) {
                        transition2.cancel();
                        runnable3.run();
                    } else {
                        runnable2.run();
                    }
                }
            }
        }
        transition.addListener(new Transition.TransitionListener() { // from class: androidx.transition.FragmentTransitionSupport.4
            @Override // androidx.transition.Transition.TransitionListener
            public final void onTransitionCancel(Transition transition3) {
            }

            @Override // androidx.transition.Transition.TransitionListener
            public final void onTransitionEnd(Transition transition3) {
                runnable.run();
            }

            @Override // androidx.transition.Transition.TransitionListener
            public final void onTransitionEnd$1(Transition transition3) {
                onTransitionEnd(transition3);
            }

            @Override // androidx.transition.Transition.TransitionListener
            public final void onTransitionStart(Transition transition3) {
                throw null;
            }

            @Override // androidx.transition.Transition.TransitionListener
            public final void onTransitionStart$1(Transition transition3) {
            }

            @Override // androidx.transition.Transition.TransitionListener
            public final void onTransitionPause() {
            }

            @Override // androidx.transition.Transition.TransitionListener
            public final void onTransitionResume() {
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [androidx.navigation.Navigation, java.lang.Object] */
    @Override // androidx.fragment.app.FragmentTransitionImpl
    public final void setEpicenter(Object obj, Rect rect) {
        ((Transition) obj).setEpicenterCallback(new Object());
    }
}
