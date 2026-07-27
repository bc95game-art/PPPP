package androidx.transition;

import android.animation.Animator;
import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowId;
import androidx.collection.ArrayMap;
import androidx.collection.LongSparseArray;
import androidx.collection.SimpleArrayMap;
import androidx.emoji2.text.MetadataRepo;
import androidx.transition.Transition;
import com.emanuelef.remote_capture.C0130R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
/* loaded from: classes.dex */
public abstract class TransitionManager {
    public static final AutoTransition sDefaultTransition;
    public static final ThreadLocal sRunningTransitions = new ThreadLocal();
    public static final ArrayList sPendingTransitions = new ArrayList();

    /* loaded from: classes.dex */
    public final class MultiListener implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {
        public ViewGroup mSceneRoot;
        public Transition mTransition;

        /* JADX WARN: Removed duplicated region for block: B:100:0x021d  */
        /* JADX WARN: Removed duplicated region for block: B:107:0x0249  */
        /* JADX WARN: Removed duplicated region for block: B:140:0x02e5  */
        /* JADX WARN: Removed duplicated region for block: B:142:0x02eb  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x004e  */
        /* JADX WARN: Removed duplicated region for block: B:150:0x01f5 A[EDGE_INSN: B:150:0x01f5->B:90:0x01f5 ?: BREAK  , SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:20:0x008b  */
        /* JADX WARN: Removed duplicated region for block: B:93:0x01fc  */
        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final boolean onPreDraw() {
            ArrayList arrayList;
            MetadataRepo metadataRepo;
            ArrayMap arrayMap;
            ArrayMap arrayMap2;
            int i;
            int[] iArr;
            int i2;
            int i3;
            int i4;
            Transition.AnimationInfo animationInfo;
            MetadataRepo metadataRepo2;
            TransitionValues transitionValues;
            View view;
            View view2;
            MetadataRepo metadataRepo3;
            Transition transition = this.mTransition;
            ViewGroup viewGroup = this.mSceneRoot;
            viewGroup.getViewTreeObserver().removeOnPreDrawListener(this);
            viewGroup.removeOnAttachStateChangeListener(this);
            int i5 = 1;
            if (TransitionManager.sPendingTransitions.remove(viewGroup)) {
                final ArrayMap runningTransitions = TransitionManager.getRunningTransitions();
                ArrayList arrayList2 = (ArrayList) runningTransitions.get(viewGroup);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                    runningTransitions.put(viewGroup, arrayList2);
                } else if (arrayList2.size() > 0) {
                    arrayList = new ArrayList(arrayList2);
                    arrayList2.add(transition);
                    transition.addListener(new TransitionListenerAdapter() { // from class: androidx.transition.TransitionManager.MultiListener.1
                        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
                        public final void onTransitionEnd(Transition transition2) {
                            ((ArrayList) runningTransitions.get(MultiListener.this.mSceneRoot)).remove(transition2);
                            transition2.removeListener(this);
                        }
                    });
                    transition.captureValues(viewGroup, false);
                    if (arrayList != null) {
                        int size = arrayList.size();
                        int i6 = 0;
                        while (i6 < size) {
                            Object obj = arrayList.get(i6);
                            i6++;
                            ((Transition) obj).resume(viewGroup);
                        }
                    }
                    transition.mStartValuesList = new ArrayList();
                    transition.mEndValuesList = new ArrayList();
                    MetadataRepo metadataRepo4 = transition.mStartValues;
                    metadataRepo = transition.mEndValues;
                    arrayMap = new ArrayMap((ArrayMap) metadataRepo4.mMetadataList);
                    arrayMap2 = new ArrayMap((ArrayMap) metadataRepo.mMetadataList);
                    i = 0;
                    while (true) {
                        iArr = transition.mMatchOrder;
                        if (i < iArr.length) {
                            break;
                        }
                        int i7 = iArr[i];
                        if (i7 == i5) {
                            metadataRepo2 = metadataRepo;
                            for (int i8 = arrayMap.size - 1; i8 >= 0; i8--) {
                                View view3 = (View) arrayMap.keyAt(i8);
                                if (view3 != null && transition.isValidTarget(view3) && (transitionValues = (TransitionValues) arrayMap2.remove(view3)) != null && transition.isValidTarget(transitionValues.view)) {
                                    transition.mStartValuesList.add((TransitionValues) arrayMap.removeAt(i8));
                                    transition.mEndValuesList.add(transitionValues);
                                }
                            }
                        } else if (i7 == 2) {
                            metadataRepo2 = metadataRepo;
                            ArrayMap arrayMap3 = (ArrayMap) metadataRepo4.mTypeface;
                            ArrayMap arrayMap4 = (ArrayMap) metadataRepo2.mTypeface;
                            int i9 = arrayMap3.size;
                            for (int i10 = 0; i10 < i9; i10++) {
                                View view4 = (View) arrayMap3.valueAt(i10);
                                if (view4 != null && transition.isValidTarget(view4) && (view = (View) arrayMap4.get(arrayMap3.keyAt(i10))) != null && transition.isValidTarget(view)) {
                                    TransitionValues transitionValues2 = (TransitionValues) arrayMap.get(view4);
                                    TransitionValues transitionValues3 = (TransitionValues) arrayMap2.get(view);
                                    if (!(transitionValues2 == null || transitionValues3 == null)) {
                                        transition.mStartValuesList.add(transitionValues2);
                                        transition.mEndValuesList.add(transitionValues3);
                                        arrayMap.remove(view4);
                                        arrayMap2.remove(view);
                                    }
                                }
                            }
                        } else if (i7 == 3) {
                            SparseArray sparseArray = (SparseArray) metadataRepo4.mEmojiCharArray;
                            metadataRepo2 = metadataRepo;
                            SparseArray sparseArray2 = (SparseArray) metadataRepo2.mEmojiCharArray;
                            int size2 = sparseArray.size();
                            for (int i11 = 0; i11 < size2; i11++) {
                                View view5 = (View) sparseArray.valueAt(i11);
                                if (view5 != null && transition.isValidTarget(view5) && (view2 = (View) sparseArray2.get(sparseArray.keyAt(i11))) != null && transition.isValidTarget(view2)) {
                                    TransitionValues transitionValues4 = (TransitionValues) arrayMap.get(view5);
                                    TransitionValues transitionValues5 = (TransitionValues) arrayMap2.get(view2);
                                    if (!(transitionValues4 == null || transitionValues5 == null)) {
                                        transition.mStartValuesList.add(transitionValues4);
                                        transition.mEndValuesList.add(transitionValues5);
                                        arrayMap.remove(view5);
                                        arrayMap2.remove(view2);
                                    }
                                }
                            }
                        } else if (i7 != 4) {
                            metadataRepo2 = metadataRepo;
                        } else {
                            LongSparseArray longSparseArray = (LongSparseArray) metadataRepo4.mRootNode;
                            LongSparseArray longSparseArray2 = (LongSparseArray) metadataRepo.mRootNode;
                            int size3 = longSparseArray.size();
                            int i12 = 0;
                            while (i12 < size3) {
                                View view6 = (View) longSparseArray.valueAt(i12);
                                if (view6 == null || !transition.isValidTarget(view6)) {
                                    metadataRepo3 = metadataRepo;
                                } else {
                                    metadataRepo3 = metadataRepo;
                                    View view7 = (View) longSparseArray2.get(longSparseArray.keyAt(i12));
                                    if (view7 != null && transition.isValidTarget(view7)) {
                                        TransitionValues transitionValues6 = (TransitionValues) arrayMap.get(view6);
                                        TransitionValues transitionValues7 = (TransitionValues) arrayMap2.get(view7);
                                        if (!(transitionValues6 == null || transitionValues7 == null)) {
                                            transition.mStartValuesList.add(transitionValues6);
                                            transition.mEndValuesList.add(transitionValues7);
                                            arrayMap.remove(view6);
                                            arrayMap2.remove(view7);
                                            i12++;
                                            metadataRepo = metadataRepo3;
                                        }
                                    }
                                }
                                i12++;
                                metadataRepo = metadataRepo3;
                            }
                            metadataRepo2 = metadataRepo;
                        }
                        i++;
                        metadataRepo = metadataRepo2;
                        i5 = 1;
                    }
                    for (i2 = 0; i2 < arrayMap.size; i2++) {
                        TransitionValues transitionValues8 = (TransitionValues) arrayMap.valueAt(i2);
                        if (transition.isValidTarget(transitionValues8.view)) {
                            transition.mStartValuesList.add(transitionValues8);
                            transition.mEndValuesList.add(null);
                        }
                    }
                    for (i3 = 0; i3 < arrayMap2.size; i3++) {
                        TransitionValues transitionValues9 = (TransitionValues) arrayMap2.valueAt(i3);
                        if (transition.isValidTarget(transitionValues9.view)) {
                            transition.mEndValuesList.add(transitionValues9);
                            transition.mStartValuesList.add(null);
                        }
                    }
                    ArrayMap runningAnimators = Transition.getRunningAnimators();
                    int i13 = runningAnimators.size;
                    WindowId windowId = viewGroup.getWindowId();
                    for (i4 = i13 - 1; i4 >= 0; i4--) {
                        Animator animator = (Animator) runningAnimators.keyAt(i4);
                        if (!(animator == null || (animationInfo = (Transition.AnimationInfo) runningAnimators.get(animator)) == null)) {
                            Transition transition2 = animationInfo.mTransition;
                            View view8 = animationInfo.mView;
                            if (view8 != null && windowId.equals(animationInfo.mWindowId)) {
                                TransitionValues transitionValues10 = animationInfo.mValues;
                                TransitionValues transitionValues11 = transition.getTransitionValues(view8, true);
                                TransitionValues matchedTransitionValues = transition.getMatchedTransitionValues(view8, true);
                                if (transitionValues11 == null && matchedTransitionValues == null) {
                                    matchedTransitionValues = (TransitionValues) ((ArrayMap) transition.mEndValues.mMetadataList).get(view8);
                                }
                                if (!(transitionValues11 == null && matchedTransitionValues == null) && transition2.isTransitionRequired(transitionValues10, matchedTransitionValues)) {
                                    Transition rootTransition = transition2.getRootTransition();
                                    ArrayList arrayList3 = transition2.mCurrentAnimators;
                                    if (rootTransition.mSeekController != null) {
                                        animator.cancel();
                                        arrayList3.remove(animator);
                                        runningAnimators.remove(animator);
                                        if (arrayList3.size() == 0) {
                                            transition2.notifyFromTransition(transition2, Transition.TransitionNotification.ON_CANCEL, false);
                                            if (!transition2.mEnded) {
                                                transition2.mEnded = true;
                                                transition2.notifyFromTransition(transition2, Transition.TransitionNotification.ON_END, false);
                                            }
                                        }
                                    } else if (animator.isRunning() || animator.isStarted()) {
                                        animator.cancel();
                                    } else {
                                        runningAnimators.remove(animator);
                                    }
                                }
                            }
                        }
                    }
                    transition.createAnimators(viewGroup, transition.mStartValues, transition.mEndValues, transition.mStartValuesList, transition.mEndValuesList);
                    if (transition.mSeekController != null) {
                        transition.runAnimators();
                        return true;
                    } else if (Build.VERSION.SDK_INT >= 34) {
                        transition.prepareAnimatorsForSeeking();
                        Transition.SeekController seekController = transition.mSeekController;
                        TransitionSet transitionSet = seekController.this$0;
                        long j = 0;
                        if (transitionSet.mTotalDuration == 0) {
                            j = 1;
                        }
                        transitionSet.setCurrentPlayTimeMillis(j, seekController.mCurrentPlayTime);
                        seekController.mCurrentPlayTime = j;
                        transition.mSeekController.mIsReady = true;
                        return true;
                    }
                }
                arrayList = null;
                arrayList2.add(transition);
                transition.addListener(new TransitionListenerAdapter() { // from class: androidx.transition.TransitionManager.MultiListener.1
                    @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
                    public final void onTransitionEnd(Transition transition22) {
                        ((ArrayList) runningTransitions.get(MultiListener.this.mSceneRoot)).remove(transition22);
                        transition22.removeListener(this);
                    }
                });
                transition.captureValues(viewGroup, false);
                if (arrayList != null) {
                }
                transition.mStartValuesList = new ArrayList();
                transition.mEndValuesList = new ArrayList();
                MetadataRepo metadataRepo42 = transition.mStartValues;
                metadataRepo = transition.mEndValues;
                arrayMap = new ArrayMap((ArrayMap) metadataRepo42.mMetadataList);
                arrayMap2 = new ArrayMap((ArrayMap) metadataRepo.mMetadataList);
                i = 0;
                while (true) {
                    iArr = transition.mMatchOrder;
                    if (i < iArr.length) {
                    }
                    i++;
                    metadataRepo = metadataRepo2;
                    i5 = 1;
                }
                while (i2 < arrayMap.size) {
                }
                while (i3 < arrayMap2.size) {
                }
                ArrayMap runningAnimators2 = Transition.getRunningAnimators();
                int i132 = runningAnimators2.size;
                WindowId windowId2 = viewGroup.getWindowId();
                while (i4 >= 0) {
                }
                transition.createAnimators(viewGroup, transition.mStartValues, transition.mEndValues, transition.mStartValuesList, transition.mEndValuesList);
                if (transition.mSeekController != null) {
                }
            }
            return true;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View view) {
            ViewGroup viewGroup = this.mSceneRoot;
            viewGroup.getViewTreeObserver().removeOnPreDrawListener(this);
            viewGroup.removeOnAttachStateChangeListener(this);
            TransitionManager.sPendingTransitions.remove(viewGroup);
            ArrayList arrayList = (ArrayList) TransitionManager.getRunningTransitions().get(viewGroup);
            if (arrayList != null && arrayList.size() > 0) {
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    ((Transition) obj).resume(viewGroup);
                }
            }
            this.mTransition.clearValues(true);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.transition.TransitionSet, androidx.transition.AutoTransition] */
    static {
        ?? transitionSet = new TransitionSet();
        transitionSet.mPlayTogether = false;
        transitionSet.addTransition(new Fade(2));
        transitionSet.addTransition(new Transition());
        transitionSet.addTransition(new Fade(1));
        sDefaultTransition = transitionSet;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [android.view.ViewTreeObserver$OnPreDrawListener, java.lang.Object, android.view.View$OnAttachStateChangeListener, androidx.transition.TransitionManager$MultiListener] */
    public static void beginDelayedTransition(ViewGroup viewGroup, Transition transition) {
        ArrayList arrayList = sPendingTransitions;
        if (!arrayList.contains(viewGroup) && viewGroup.isLaidOut()) {
            arrayList.add(viewGroup);
            if (transition == null) {
                transition = sDefaultTransition;
            }
            Transition clone = transition.clone();
            sceneChangeSetup(viewGroup, clone);
            viewGroup.setTag(C0130R.C0132id.transition_current_scene, null);
            ?? obj = new Object();
            obj.mTransition = clone;
            obj.mSceneRoot = viewGroup;
            viewGroup.addOnAttachStateChangeListener(obj);
            viewGroup.getViewTreeObserver().addOnPreDrawListener(obj);
        }
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.Object, androidx.collection.SimpleArrayMap, androidx.collection.ArrayMap] */
    public static ArrayMap getRunningTransitions() {
        ArrayMap arrayMap;
        ThreadLocal threadLocal = sRunningTransitions;
        WeakReference weakReference = (WeakReference) threadLocal.get();
        if (weakReference != null && (arrayMap = (ArrayMap) weakReference.get()) != null) {
            return arrayMap;
        }
        ?? simpleArrayMap = new SimpleArrayMap(0);
        threadLocal.set(new WeakReference(simpleArrayMap));
        return simpleArrayMap;
    }

    public static void sceneChangeSetup(ViewGroup viewGroup, Transition transition) {
        ArrayList arrayList = (ArrayList) getRunningTransitions().get(viewGroup);
        if (arrayList != null && arrayList.size() > 0) {
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                ((Transition) obj).pause(viewGroup);
            }
        }
        if (transition != null) {
            transition.captureValues(viewGroup, true);
        }
        if (viewGroup.getTag(C0130R.C0132id.transition_current_scene) != null) {
            throw new ClassCastException();
        }
    }
}
