package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.transition.Transition;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.activity.BackEventCompat;
import androidx.collection.ArrayMap;
import androidx.core.p002os.CancellationSignal;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewGroupCompat$Api21Impl;
import androidx.fragment.app.DefaultSpecialEffectsController;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import com.emanuelef.remote_capture.C0130R;
import com.emanuelef.remote_capture.PlayBilling$$ExternalSyntheticLambda23;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class DefaultSpecialEffectsController {
    public final ViewGroup container;
    public boolean isContainerPostponed;
    public boolean operationDirectionIsPop;
    public boolean runningNonSeekableTransition;
    public final ArrayList pendingOperations = new ArrayList();
    public final ArrayList runningOperations = new ArrayList();

    /* loaded from: classes.dex */
    public final class AnimationEffect extends SpecialEffectsController$Effect {
        public final AnimationInfo animationInfo;

        public AnimationEffect(AnimationInfo animationInfo) {
            this.animationInfo = animationInfo;
        }

        @Override // androidx.fragment.app.SpecialEffectsController$Effect
        public final void onCancel(ViewGroup container) {
            Intrinsics.checkNotNullParameter(container, "container");
            AnimationInfo animationInfo = this.animationInfo;
            SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation = animationInfo.operation;
            View view = specialEffectsController$FragmentStateManagerOperation.fragment.mView;
            view.clearAnimation();
            container.endViewTransition(view);
            animationInfo.operation.completeEffect(this);
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v("FragmentManager", "Animation from operation " + specialEffectsController$FragmentStateManagerOperation + " has been cancelled.");
            }
        }

        @Override // androidx.fragment.app.SpecialEffectsController$Effect
        public final void onCommit(final ViewGroup container) {
            Intrinsics.checkNotNullParameter(container, "container");
            AnimationInfo animationInfo = this.animationInfo;
            final SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation = animationInfo.operation;
            if (animationInfo.isVisibilityUnchanged()) {
                specialEffectsController$FragmentStateManagerOperation.completeEffect(this);
                return;
            }
            Context context = container.getContext();
            final View view = specialEffectsController$FragmentStateManagerOperation.fragment.mView;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            FragmentAnim$AnimationOrAnimator animation = animationInfo.getAnimation(context);
            if (animation != null) {
                Animation animation2 = (Animation) animation.animation;
                if (animation2 == null) {
                    throw new IllegalStateException("Required value was null.");
                } else if (specialEffectsController$FragmentStateManagerOperation.finalState != 1) {
                    view.startAnimation(animation2);
                    specialEffectsController$FragmentStateManagerOperation.completeEffect(this);
                } else {
                    container.startViewTransition(view);
                    FragmentAnim$EndViewTransitionAnimation fragmentAnim$EndViewTransitionAnimation = new FragmentAnim$EndViewTransitionAnimation(animation2, container, view);
                    fragmentAnim$EndViewTransitionAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: androidx.fragment.app.DefaultSpecialEffectsController$AnimationEffect$onCommit$1
                        @Override // android.view.animation.Animation.AnimationListener
                        public final void onAnimationEnd(Animation animation3) {
                            Intrinsics.checkNotNullParameter(animation3, "animation");
                            ViewGroup viewGroup = container;
                            viewGroup.post(new PlayBilling$$ExternalSyntheticLambda23(viewGroup, view, this, 2));
                            if (FragmentManager.isLoggingEnabled(2)) {
                                Log.v("FragmentManager", "Animation from operation " + SpecialEffectsController$FragmentStateManagerOperation.this + " has ended.");
                            }
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public final void onAnimationRepeat(Animation animation3) {
                            Intrinsics.checkNotNullParameter(animation3, "animation");
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public final void onAnimationStart(Animation animation3) {
                            Intrinsics.checkNotNullParameter(animation3, "animation");
                            if (FragmentManager.isLoggingEnabled(2)) {
                                Log.v("FragmentManager", "Animation from operation " + SpecialEffectsController$FragmentStateManagerOperation.this + " has reached onAnimationStart.");
                            }
                        }
                    });
                    view.startAnimation(fragmentAnim$EndViewTransitionAnimation);
                    if (FragmentManager.isLoggingEnabled(2)) {
                        Log.v("FragmentManager", "Animation from operation " + specialEffectsController$FragmentStateManagerOperation + " has started.");
                    }
                }
            } else {
                throw new IllegalStateException("Required value was null.");
            }
        }
    }

    /* loaded from: classes.dex */
    public final class AnimationInfo extends SpecialEffectsInfo {
        public FragmentAnim$AnimationOrAnimator animation;
        public boolean isAnimLoaded;
        public final boolean isPop;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnimationInfo(SpecialEffectsController$FragmentStateManagerOperation operation, boolean z) {
            super(operation);
            Intrinsics.checkNotNullParameter(operation, "operation");
            this.isPop = z;
        }

        public final FragmentAnim$AnimationOrAnimator getAnimation(Context context) {
            boolean z;
            int i;
            Animation loadAnimation;
            FragmentAnim$AnimationOrAnimator fragmentAnim$AnimationOrAnimator;
            int activityTransitResId;
            if (this.isAnimLoaded) {
                return this.animation;
            }
            SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation = this.operation;
            Fragment fragment = specialEffectsController$FragmentStateManagerOperation.fragment;
            if (specialEffectsController$FragmentStateManagerOperation.finalState == 2) {
                z = true;
            } else {
                z = false;
            }
            int nextTransition = fragment.getNextTransition();
            if (this.isPop) {
                if (z) {
                    i = fragment.getPopEnterAnim();
                } else {
                    i = fragment.getPopExitAnim();
                }
            } else if (z) {
                i = fragment.getEnterAnim();
            } else {
                i = fragment.getExitAnim();
            }
            fragment.setAnimations(0, 0, 0, 0);
            ViewGroup viewGroup = fragment.mContainer;
            FragmentAnim$AnimationOrAnimator fragmentAnim$AnimationOrAnimator2 = null;
            if (!(viewGroup == null || viewGroup.getTag(C0130R.C0132id.visible_removing_fragment_view_tag) == null)) {
                fragment.mContainer.setTag(C0130R.C0132id.visible_removing_fragment_view_tag, null);
            }
            ViewGroup viewGroup2 = fragment.mContainer;
            if (viewGroup2 == null || viewGroup2.getLayoutTransition() == null) {
                Animation onCreateAnimation = fragment.onCreateAnimation(nextTransition, z, i);
                if (onCreateAnimation != null) {
                    fragmentAnim$AnimationOrAnimator2 = new FragmentAnim$AnimationOrAnimator(onCreateAnimation);
                } else {
                    Animator onCreateAnimator = fragment.onCreateAnimator(nextTransition, z, i);
                    if (onCreateAnimator != null) {
                        fragmentAnim$AnimationOrAnimator2 = new FragmentAnim$AnimationOrAnimator(onCreateAnimator);
                    } else {
                        if (i == 0 && nextTransition != 0) {
                            if (nextTransition != 4097) {
                                if (nextTransition != 8194) {
                                    if (nextTransition != 8197) {
                                        if (nextTransition != 4099) {
                                            if (nextTransition != 4100) {
                                                i = -1;
                                            } else if (z) {
                                                activityTransitResId = Navigation.toActivityTransitResId(context, 16842936);
                                            } else {
                                                activityTransitResId = Navigation.toActivityTransitResId(context, 16842937);
                                            }
                                        } else if (z) {
                                            i = C0130R.animator.fragment_fade_enter;
                                        } else {
                                            i = C0130R.animator.fragment_fade_exit;
                                        }
                                    } else if (z) {
                                        activityTransitResId = Navigation.toActivityTransitResId(context, 16842938);
                                    } else {
                                        activityTransitResId = Navigation.toActivityTransitResId(context, 16842939);
                                    }
                                    i = activityTransitResId;
                                } else if (z) {
                                    i = C0130R.animator.fragment_close_enter;
                                } else {
                                    i = C0130R.animator.fragment_close_exit;
                                }
                            } else if (z) {
                                i = C0130R.animator.fragment_open_enter;
                            } else {
                                i = C0130R.animator.fragment_open_exit;
                            }
                        }
                        if (i != 0) {
                            boolean equals = "anim".equals(context.getResources().getResourceTypeName(i));
                            try {
                                if (equals) {
                                    try {
                                        loadAnimation = AnimationUtils.loadAnimation(context, i);
                                    } catch (Resources.NotFoundException e) {
                                        throw e;
                                    } catch (RuntimeException unused) {
                                    }
                                    if (loadAnimation != null) {
                                        fragmentAnim$AnimationOrAnimator = new FragmentAnim$AnimationOrAnimator(loadAnimation);
                                        fragmentAnim$AnimationOrAnimator2 = fragmentAnim$AnimationOrAnimator;
                                    }
                                }
                                Animator loadAnimator = AnimatorInflater.loadAnimator(context, i);
                                if (loadAnimator != null) {
                                    fragmentAnim$AnimationOrAnimator = new FragmentAnim$AnimationOrAnimator(loadAnimator);
                                    fragmentAnim$AnimationOrAnimator2 = fragmentAnim$AnimationOrAnimator;
                                }
                            } catch (RuntimeException e2) {
                                if (!equals) {
                                    Animation loadAnimation2 = AnimationUtils.loadAnimation(context, i);
                                    if (loadAnimation2 != null) {
                                        fragmentAnim$AnimationOrAnimator2 = new FragmentAnim$AnimationOrAnimator(loadAnimation2);
                                    }
                                } else {
                                    throw e2;
                                }
                            }
                        }
                    }
                }
            }
            this.animation = fragmentAnim$AnimationOrAnimator2;
            this.isAnimLoaded = true;
            return fragmentAnim$AnimationOrAnimator2;
        }
    }

    /* loaded from: classes.dex */
    public final class AnimatorEffect extends SpecialEffectsController$Effect {
        public AnimatorSet animator;
        public final AnimationInfo animatorInfo;

        public AnimatorEffect(AnimationInfo animationInfo) {
            this.animatorInfo = animationInfo;
        }

        @Override // androidx.fragment.app.SpecialEffectsController$Effect
        public final void onCancel(ViewGroup container) {
            String str;
            Intrinsics.checkNotNullParameter(container, "container");
            AnimatorSet animatorSet = this.animator;
            AnimationInfo animationInfo = this.animatorInfo;
            if (animatorSet == null) {
                animationInfo.operation.completeEffect(this);
                return;
            }
            SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation = animationInfo.operation;
            if (!specialEffectsController$FragmentStateManagerOperation.isSeeking) {
                animatorSet.end();
            } else if (Build.VERSION.SDK_INT >= 26) {
                Api26Impl.INSTANCE.reverse(animatorSet);
            }
            if (FragmentManager.isLoggingEnabled(2)) {
                StringBuilder sb = new StringBuilder("Animator from operation ");
                sb.append(specialEffectsController$FragmentStateManagerOperation);
                sb.append(" has been canceled");
                if (specialEffectsController$FragmentStateManagerOperation.isSeeking) {
                    str = " with seeking.";
                } else {
                    str = ".";
                }
                sb.append(str);
                sb.append(' ');
                Log.v("FragmentManager", sb.toString());
            }
        }

        @Override // androidx.fragment.app.SpecialEffectsController$Effect
        public final void onCommit(ViewGroup container) {
            Intrinsics.checkNotNullParameter(container, "container");
            SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation = this.animatorInfo.operation;
            AnimatorSet animatorSet = this.animator;
            if (animatorSet == null) {
                specialEffectsController$FragmentStateManagerOperation.completeEffect(this);
                return;
            }
            animatorSet.start();
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v("FragmentManager", "Animator from operation " + specialEffectsController$FragmentStateManagerOperation + " has started.");
            }
        }

        @Override // androidx.fragment.app.SpecialEffectsController$Effect
        public final void onProgress(BackEventCompat backEvent, ViewGroup container) {
            Intrinsics.checkNotNullParameter(backEvent, "backEvent");
            Intrinsics.checkNotNullParameter(container, "container");
            SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation = this.animatorInfo.operation;
            AnimatorSet animatorSet = this.animator;
            if (animatorSet == null) {
                specialEffectsController$FragmentStateManagerOperation.completeEffect(this);
            } else if (Build.VERSION.SDK_INT >= 34 && specialEffectsController$FragmentStateManagerOperation.fragment.mTransitioning) {
                if (FragmentManager.isLoggingEnabled(2)) {
                    Log.v("FragmentManager", "Adding BackProgressCallbacks for Animators to operation " + specialEffectsController$FragmentStateManagerOperation);
                }
                long j = Api24Impl.INSTANCE.totalDuration(animatorSet);
                long j2 = backEvent.progress * ((float) j);
                if (j2 == 0) {
                    j2 = 1;
                }
                if (j2 == j) {
                    j2 = j - 1;
                }
                if (FragmentManager.isLoggingEnabled(2)) {
                    Log.v("FragmentManager", "Setting currentPlayTime to " + j2 + " for Animator " + animatorSet + " on operation " + specialEffectsController$FragmentStateManagerOperation);
                }
                Api26Impl.INSTANCE.setCurrentPlayTime(animatorSet, j2);
            }
        }

        @Override // androidx.fragment.app.SpecialEffectsController$Effect
        public final void onStart(final ViewGroup container) {
            AnimatorSet animatorSet;
            final boolean z;
            final AnimatorEffect animatorEffect;
            Intrinsics.checkNotNullParameter(container, "container");
            AnimationInfo animationInfo = this.animatorInfo;
            if (!animationInfo.isVisibilityUnchanged()) {
                Context context = container.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                FragmentAnim$AnimationOrAnimator animation = animationInfo.getAnimation(context);
                if (animation != null) {
                    animatorSet = (AnimatorSet) animation.animator;
                } else {
                    animatorSet = null;
                }
                this.animator = animatorSet;
                final SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation = animationInfo.operation;
                Fragment fragment = specialEffectsController$FragmentStateManagerOperation.fragment;
                if (specialEffectsController$FragmentStateManagerOperation.finalState == 3) {
                    z = true;
                } else {
                    z = false;
                }
                final View view = fragment.mView;
                container.startViewTransition(view);
                AnimatorSet animatorSet2 = this.animator;
                if (animatorSet2 != null) {
                    animatorEffect = this;
                    animatorSet2.addListener(new AnimatorListenerAdapter() { // from class: androidx.fragment.app.DefaultSpecialEffectsController$AnimatorEffect$onStart$1
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public final void onAnimationEnd(Animator anim) {
                            Intrinsics.checkNotNullParameter(anim, "anim");
                            ViewGroup viewGroup = container;
                            View viewToAnimate = view;
                            viewGroup.endViewTransition(viewToAnimate);
                            boolean z2 = z;
                            SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation2 = specialEffectsController$FragmentStateManagerOperation;
                            if (z2 || specialEffectsController$FragmentStateManagerOperation2.finalState == 3) {
                                int i = specialEffectsController$FragmentStateManagerOperation2.finalState;
                                Intrinsics.checkNotNullExpressionValue(viewToAnimate, "viewToAnimate");
                                ViewModelProvider.Factory.CC._applyState(i, viewToAnimate, viewGroup);
                            }
                            DefaultSpecialEffectsController.AnimatorEffect animatorEffect2 = animatorEffect;
                            animatorEffect2.animatorInfo.operation.completeEffect(animatorEffect2);
                            if (FragmentManager.isLoggingEnabled(2)) {
                                Log.v("FragmentManager", "Animator from operation " + specialEffectsController$FragmentStateManagerOperation2 + " has ended.");
                            }
                        }
                    });
                } else {
                    animatorEffect = this;
                }
                AnimatorSet animatorSet3 = animatorEffect.animator;
                if (animatorSet3 != null) {
                    animatorSet3.setTarget(view);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public final class Api24Impl {
        public static final Api24Impl INSTANCE = new Object();

        public final long totalDuration(AnimatorSet animatorSet) {
            Intrinsics.checkNotNullParameter(animatorSet, "animatorSet");
            return animatorSet.getTotalDuration();
        }
    }

    /* loaded from: classes.dex */
    public final class Api26Impl {
        public static final Api26Impl INSTANCE = new Object();

        public final void reverse(AnimatorSet animatorSet) {
            Intrinsics.checkNotNullParameter(animatorSet, "animatorSet");
            animatorSet.reverse();
        }

        public final void setCurrentPlayTime(AnimatorSet animatorSet, long j) {
            Intrinsics.checkNotNullParameter(animatorSet, "animatorSet");
            animatorSet.setCurrentPlayTime(j);
        }
    }

    /* loaded from: classes.dex */
    public abstract class SpecialEffectsInfo {
        public final SpecialEffectsController$FragmentStateManagerOperation operation;

        public SpecialEffectsInfo(SpecialEffectsController$FragmentStateManagerOperation operation) {
            Intrinsics.checkNotNullParameter(operation, "operation");
            this.operation = operation;
        }

        public final boolean isVisibilityUnchanged() {
            int i;
            SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation = this.operation;
            View view = specialEffectsController$FragmentStateManagerOperation.fragment.mView;
            if (view != null) {
                i = 4;
                if (!(view.getAlpha() == 0.0f && view.getVisibility() == 0)) {
                    int visibility = view.getVisibility();
                    if (visibility == 0) {
                        i = 2;
                    } else if (visibility != 4) {
                        if (visibility == 8) {
                            i = 3;
                        } else {
                            throw new IllegalArgumentException(ViewModelProvider.Factory.CC.m604m(visibility, "Unknown visibility "));
                        }
                    }
                }
            } else {
                i = 0;
            }
            int i2 = specialEffectsController$FragmentStateManagerOperation.finalState;
            if (i == i2) {
                return true;
            }
            if (i == 2 || i2 == 2) {
                return false;
            }
            return true;
        }
    }

    /* loaded from: classes.dex */
    public final class TransitionEffect extends SpecialEffectsController$Effect {
        public Object controller;
        public final ArrayList enteringNames;
        public final ArrayList exitingNames;
        public final SpecialEffectsController$FragmentStateManagerOperation firstOut;
        public final ArrayMap firstOutViews;
        public final boolean isPop;
        public final SpecialEffectsController$FragmentStateManagerOperation lastIn;
        public final ArrayMap lastInViews;
        public boolean noControllerReturned;
        public final ArrayList sharedElementFirstOutViews;
        public final ArrayList sharedElementLastInViews;
        public final ArrayMap sharedElementNameMapping;
        public final Object sharedElementTransition;
        public final FragmentTransitionImpl transitionImpl;
        public final ArrayList transitionInfos;
        public final CancellationSignal transitionSignal = new Object();

        /* JADX WARN: Type inference failed for: r1v1, types: [androidx.core.os.CancellationSignal, java.lang.Object] */
        public TransitionEffect(ArrayList arrayList, SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation, SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation2, FragmentTransitionImpl fragmentTransitionImpl, Object obj, ArrayList arrayList2, ArrayList arrayList3, ArrayMap arrayMap, ArrayList arrayList4, ArrayList arrayList5, ArrayMap arrayMap2, ArrayMap arrayMap3, boolean z) {
            this.transitionInfos = arrayList;
            this.firstOut = specialEffectsController$FragmentStateManagerOperation;
            this.lastIn = specialEffectsController$FragmentStateManagerOperation2;
            this.transitionImpl = fragmentTransitionImpl;
            this.sharedElementTransition = obj;
            this.sharedElementFirstOutViews = arrayList2;
            this.sharedElementLastInViews = arrayList3;
            this.sharedElementNameMapping = arrayMap;
            this.enteringNames = arrayList4;
            this.exitingNames = arrayList5;
            this.firstOutViews = arrayMap2;
            this.lastInViews = arrayMap3;
            this.isPop = z;
        }

        public static void captureTransitioningViews(View view, ArrayList arrayList) {
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (!ViewGroupCompat$Api21Impl.isTransitionGroup(viewGroup)) {
                    int childCount = viewGroup.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        View childAt = viewGroup.getChildAt(i);
                        if (childAt.getVisibility() == 0) {
                            captureTransitioningViews(childAt, arrayList);
                        }
                    }
                } else if (!arrayList.contains(view)) {
                    arrayList.add(view);
                }
            } else if (!arrayList.contains(view)) {
                arrayList.add(view);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:49:0x018c  */
        /* JADX WARN: Removed duplicated region for block: B:57:0x01d6  */
        /* JADX WARN: Removed duplicated region for block: B:76:0x0235 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:78:0x021d A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Pair createMergedTransition(ViewGroup viewGroup, SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation, SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation2) {
            ArrayList arrayList;
            ArrayList arrayList2;
            Object obj;
            FragmentTransitionImpl fragmentTransitionImpl;
            int i;
            ArrayList arrayList3;
            Object obj2;
            int i2;
            SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation3 = specialEffectsController$FragmentStateManagerOperation;
            SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation4 = specialEffectsController$FragmentStateManagerOperation2;
            View view = new View(viewGroup.getContext());
            Rect rect = new Rect();
            ArrayList arrayList4 = this.transitionInfos;
            int size = arrayList4.size();
            View view2 = null;
            boolean z = false;
            int i3 = 0;
            while (true) {
                arrayList = this.sharedElementLastInViews;
                arrayList2 = this.sharedElementFirstOutViews;
                obj = this.sharedElementTransition;
                fragmentTransitionImpl = this.transitionImpl;
                if (i3 >= size) {
                    break;
                }
                Object obj3 = arrayList4.get(i3);
                i3++;
                if (((TransitionInfo) obj3).sharedElementTransition == null || specialEffectsController$FragmentStateManagerOperation4 == null || specialEffectsController$FragmentStateManagerOperation3 == null || this.sharedElementNameMapping.isEmpty() || obj == null) {
                    i2 = size;
                    z = z;
                } else {
                    Fragment inFragment = specialEffectsController$FragmentStateManagerOperation3.fragment;
                    i2 = size;
                    Fragment outFragment = specialEffectsController$FragmentStateManagerOperation4.fragment;
                    FragmentTransitionCompat21 fragmentTransitionCompat21 = FragmentTransition.PLATFORM_IMPL;
                    boolean z2 = z;
                    Intrinsics.checkNotNullParameter(inFragment, "inFragment");
                    Intrinsics.checkNotNullParameter(outFragment, "outFragment");
                    if (this.isPop) {
                        outFragment.getEnterTransitionCallback();
                    } else {
                        inFragment.getEnterTransitionCallback();
                    }
                    OneShotPreDrawListener.add(viewGroup, new PlayBilling$$ExternalSyntheticLambda23(specialEffectsController$FragmentStateManagerOperation3, specialEffectsController$FragmentStateManagerOperation4, this, 3));
                    ArrayMap arrayMap = this.firstOutViews;
                    arrayList2.addAll(arrayMap.values());
                    ArrayList arrayList5 = this.exitingNames;
                    if (!arrayList5.isEmpty()) {
                        Object obj4 = arrayList5.get(0);
                        Intrinsics.checkNotNullExpressionValue(obj4, "exitingNames[0]");
                        View view3 = (View) arrayMap.get((String) obj4);
                        fragmentTransitionImpl.setEpicenter(view3, obj);
                        view2 = view3;
                    }
                    ArrayMap arrayMap2 = this.lastInViews;
                    arrayList.addAll(arrayMap2.values());
                    ArrayList arrayList6 = this.enteringNames;
                    if (!arrayList6.isEmpty()) {
                        Object obj5 = arrayList6.get(0);
                        Intrinsics.checkNotNullExpressionValue(obj5, "enteringNames[0]");
                        View view4 = (View) arrayMap2.get((String) obj5);
                        if (view4 != null) {
                            OneShotPreDrawListener.add(viewGroup, new RunnableC0058xf804c657(fragmentTransitionImpl, view4, rect));
                            z = true;
                            fragmentTransitionImpl.setSharedElementTargets(obj, view, arrayList2);
                            Object obj6 = this.sharedElementTransition;
                            fragmentTransitionImpl.scheduleRemoveTargets(obj6, null, null, obj6, arrayList);
                        }
                    }
                    z = z2;
                    fragmentTransitionImpl.setSharedElementTargets(obj, view, arrayList2);
                    Object obj62 = this.sharedElementTransition;
                    fragmentTransitionImpl.scheduleRemoveTargets(obj62, null, null, obj62, arrayList);
                }
                size = i2;
            }
            boolean z3 = z;
            ArrayList arrayList7 = new ArrayList();
            int size2 = arrayList4.size();
            Object obj7 = null;
            Object obj8 = null;
            int i4 = 0;
            while (i4 < size2) {
                Object obj9 = arrayList4.get(i4);
                int i5 = i4 + 1;
                ArrayList arrayList8 = arrayList4;
                TransitionInfo transitionInfo = (TransitionInfo) obj9;
                int i6 = size2;
                SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation5 = transitionInfo.operation;
                Object cloneTransition = fragmentTransitionImpl.cloneTransition(transitionInfo.transition);
                if (cloneTransition != null) {
                    ArrayList arrayList9 = arrayList2;
                    ArrayList arrayList10 = new ArrayList();
                    Object obj10 = obj;
                    Fragment fragment = specialEffectsController$FragmentStateManagerOperation5.fragment;
                    Object obj11 = obj8;
                    View view5 = fragment.mView;
                    Object obj12 = obj7;
                    Intrinsics.checkNotNullExpressionValue(view5, "operation.fragment.mView");
                    captureTransitioningViews(view5, arrayList10);
                    if (obj10 != null && (specialEffectsController$FragmentStateManagerOperation5 == specialEffectsController$FragmentStateManagerOperation4 || specialEffectsController$FragmentStateManagerOperation5 == specialEffectsController$FragmentStateManagerOperation3)) {
                        if (specialEffectsController$FragmentStateManagerOperation5 == specialEffectsController$FragmentStateManagerOperation4) {
                            arrayList10.removeAll(CollectionsKt.toSet(arrayList9));
                        } else {
                            arrayList10.removeAll(CollectionsKt.toSet(arrayList));
                        }
                    }
                    if (arrayList10.isEmpty()) {
                        fragmentTransitionImpl.addTarget(view, cloneTransition);
                        obj2 = cloneTransition;
                        arrayList3 = arrayList10;
                    } else {
                        fragmentTransitionImpl.addTargets(arrayList10, cloneTransition);
                        fragmentTransitionImpl.scheduleRemoveTargets(cloneTransition, cloneTransition, arrayList10, null, null);
                        obj2 = cloneTransition;
                        arrayList3 = arrayList10;
                        if (specialEffectsController$FragmentStateManagerOperation5.finalState == 3) {
                            specialEffectsController$FragmentStateManagerOperation5.isAwaitingContainerChanges = false;
                            ArrayList arrayList11 = new ArrayList(arrayList3);
                            arrayList11.remove(fragment.mView);
                            fragmentTransitionImpl.scheduleHideFragmentView(obj2, fragment.mView, arrayList11);
                            i = 2;
                            OneShotPreDrawListener.add(viewGroup, new Fragment$$ExternalSyntheticLambda1(2, arrayList3));
                            if (specialEffectsController$FragmentStateManagerOperation5.finalState != i) {
                                arrayList7.addAll(arrayList3);
                                if (z3) {
                                    fragmentTransitionImpl.setEpicenter(obj2, rect);
                                }
                                if (FragmentManager.isLoggingEnabled(i)) {
                                    Log.v("FragmentManager", "Entering Transition: " + obj2);
                                    Log.v("FragmentManager", ">>>>> EnteringViews <<<<<");
                                    int size3 = arrayList3.size();
                                    int i7 = 0;
                                    while (i7 < size3) {
                                        Object transitioningViews = arrayList3.get(i7);
                                        i7++;
                                        Intrinsics.checkNotNullExpressionValue(transitioningViews, "transitioningViews");
                                        Log.v("FragmentManager", "View: " + ((View) transitioningViews));
                                    }
                                }
                            } else {
                                fragmentTransitionImpl.setEpicenter(view2, obj2);
                                if (FragmentManager.isLoggingEnabled(2)) {
                                    Log.v("FragmentManager", "Exiting Transition: " + obj2);
                                    Log.v("FragmentManager", ">>>>> ExitingViews <<<<<");
                                    int size4 = arrayList3.size();
                                    int i8 = 0;
                                    while (i8 < size4) {
                                        Object transitioningViews2 = arrayList3.get(i8);
                                        i8++;
                                        Intrinsics.checkNotNullExpressionValue(transitioningViews2, "transitioningViews");
                                        Log.v("FragmentManager", "View: " + ((View) transitioningViews2));
                                    }
                                }
                            }
                            if (!transitionInfo.isOverlapAllowed) {
                                obj7 = fragmentTransitionImpl.mergeTransitionsTogether(obj12, obj2);
                                specialEffectsController$FragmentStateManagerOperation3 = specialEffectsController$FragmentStateManagerOperation;
                                specialEffectsController$FragmentStateManagerOperation4 = specialEffectsController$FragmentStateManagerOperation2;
                                size2 = i6;
                                arrayList4 = arrayList8;
                                i4 = i5;
                                arrayList2 = arrayList9;
                                obj = obj10;
                                obj8 = obj11;
                            } else {
                                obj8 = fragmentTransitionImpl.mergeTransitionsTogether(obj11, obj2);
                                specialEffectsController$FragmentStateManagerOperation4 = specialEffectsController$FragmentStateManagerOperation2;
                                obj7 = obj12;
                                size2 = i6;
                                arrayList4 = arrayList8;
                                i4 = i5;
                                arrayList2 = arrayList9;
                                obj = obj10;
                                specialEffectsController$FragmentStateManagerOperation3 = specialEffectsController$FragmentStateManagerOperation;
                            }
                        }
                    }
                    i = 2;
                    if (specialEffectsController$FragmentStateManagerOperation5.finalState != i) {
                    }
                    if (!transitionInfo.isOverlapAllowed) {
                    }
                } else {
                    size2 = i6;
                    arrayList4 = arrayList8;
                    i4 = i5;
                    specialEffectsController$FragmentStateManagerOperation3 = specialEffectsController$FragmentStateManagerOperation;
                    specialEffectsController$FragmentStateManagerOperation4 = specialEffectsController$FragmentStateManagerOperation2;
                }
            }
            Object mergeTransitionsInSequence = fragmentTransitionImpl.mergeTransitionsInSequence(obj7, obj8, obj);
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v("FragmentManager", "Final merged transition: " + mergeTransitionsInSequence + " for container " + viewGroup);
            }
            return new Pair(arrayList7, mergeTransitionsInSequence);
        }

        public final boolean getTransitioning() {
            ArrayList arrayList = this.transitionInfos;
            if (arrayList.isEmpty()) {
                return true;
            }
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                if (!((TransitionInfo) obj).operation.fragment.mTransitioning) {
                    return false;
                }
            }
            return true;
        }

        @Override // androidx.fragment.app.SpecialEffectsController$Effect
        public final boolean isSeekingSupported() {
            FragmentTransitionImpl fragmentTransitionImpl = this.transitionImpl;
            if (fragmentTransitionImpl.isSeekingSupported()) {
                ArrayList arrayList = this.transitionInfos;
                if (!arrayList.isEmpty()) {
                    int size = arrayList.size();
                    int i = 0;
                    while (i < size) {
                        Object obj = arrayList.get(i);
                        i++;
                        TransitionInfo transitionInfo = (TransitionInfo) obj;
                        if (Build.VERSION.SDK_INT >= 34) {
                            Object obj2 = transitionInfo.transition;
                            if (obj2 != null) {
                                if (!fragmentTransitionImpl.isSeekingSupported(obj2)) {
                                    break;
                                }
                            } else {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
                Object obj3 = this.sharedElementTransition;
                if (obj3 == null || fragmentTransitionImpl.isSeekingSupported(obj3)) {
                    return true;
                }
            }
            return false;
        }

        @Override // androidx.fragment.app.SpecialEffectsController$Effect
        public final void onCancel(ViewGroup container) {
            Intrinsics.checkNotNullParameter(container, "container");
            this.transitionSignal.cancel();
        }

        @Override // androidx.fragment.app.SpecialEffectsController$Effect
        public final void onCommit(ViewGroup container) {
            Intrinsics.checkNotNullParameter(container, "container");
            boolean isLaidOut = container.isLaidOut();
            int i = 0;
            ArrayList arrayList = this.transitionInfos;
            if (!isLaidOut || this.noControllerReturned) {
                int size = arrayList.size();
                int i2 = 0;
                while (i2 < size) {
                    Object obj = arrayList.get(i2);
                    i2++;
                    TransitionInfo transitionInfo = (TransitionInfo) obj;
                    SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation = transitionInfo.operation;
                    if (FragmentManager.isLoggingEnabled(2)) {
                        if (this.noControllerReturned) {
                            Log.v("FragmentManager", "SpecialEffectsController: TransitionSeekController was not created. Completing operation " + specialEffectsController$FragmentStateManagerOperation);
                        } else {
                            Log.v("FragmentManager", "SpecialEffectsController: Container " + container + " has not been laid out. Completing operation " + specialEffectsController$FragmentStateManagerOperation);
                        }
                    }
                    transitionInfo.operation.completeEffect(this);
                }
                this.noControllerReturned = false;
                return;
            }
            Object obj2 = this.controller;
            FragmentTransitionImpl fragmentTransitionImpl = this.transitionImpl;
            SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation2 = this.lastIn;
            SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation3 = this.firstOut;
            if (obj2 != null) {
                fragmentTransitionImpl.animateToEnd(obj2);
                if (FragmentManager.isLoggingEnabled(2)) {
                    Log.v("FragmentManager", "Ending execution of operations from " + specialEffectsController$FragmentStateManagerOperation3 + " to " + specialEffectsController$FragmentStateManagerOperation2);
                    return;
                }
                return;
            }
            Pair createMergedTransition = createMergedTransition(container, specialEffectsController$FragmentStateManagerOperation2, specialEffectsController$FragmentStateManagerOperation3);
            ArrayList arrayList2 = (ArrayList) createMergedTransition.first;
            Object obj3 = createMergedTransition.second;
            ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
            int size2 = arrayList.size();
            int i3 = 0;
            while (i3 < size2) {
                Object obj4 = arrayList.get(i3);
                i3++;
                arrayList3.add(((TransitionInfo) obj4).operation);
            }
            int size3 = arrayList3.size();
            while (i < size3) {
                Object obj5 = arrayList3.get(i);
                i++;
                SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation4 = (SpecialEffectsController$FragmentStateManagerOperation) obj5;
                fragmentTransitionImpl.setListenerForTransitionEnd(specialEffectsController$FragmentStateManagerOperation4.fragment, obj3, this.transitionSignal, new RunnableC0057xf804c654(specialEffectsController$FragmentStateManagerOperation4, this, 1));
            }
            runTransition(arrayList2, container, new DefaultSpecialEffectsController$TransitionEffect$onCommit$4(this, container, obj3));
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v("FragmentManager", "Completed executing operations from " + specialEffectsController$FragmentStateManagerOperation3 + " to " + specialEffectsController$FragmentStateManagerOperation2);
            }
        }

        @Override // androidx.fragment.app.SpecialEffectsController$Effect
        public final void onProgress(BackEventCompat backEvent, ViewGroup container) {
            Intrinsics.checkNotNullParameter(backEvent, "backEvent");
            Intrinsics.checkNotNullParameter(container, "container");
            Object obj = this.controller;
            if (obj != null) {
                this.transitionImpl.setCurrentPlayTime(obj, backEvent.progress);
            }
        }

        /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.Object, kotlin.jvm.internal.Ref$ObjectRef] */
        @Override // androidx.fragment.app.SpecialEffectsController$Effect
        public final void onStart(ViewGroup container) {
            Object obj;
            Intrinsics.checkNotNullParameter(container, "container");
            boolean isLaidOut = container.isLaidOut();
            int i = 0;
            ArrayList arrayList = this.transitionInfos;
            if (!isLaidOut) {
                int size = arrayList.size();
                while (i < size) {
                    Object obj2 = arrayList.get(i);
                    i++;
                    SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation = ((TransitionInfo) obj2).operation;
                    if (FragmentManager.isLoggingEnabled(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Container " + container + " has not been laid out. Skipping onStart for operation " + specialEffectsController$FragmentStateManagerOperation);
                    }
                }
                return;
            }
            boolean transitioning = getTransitioning();
            SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation2 = this.lastIn;
            SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation3 = this.firstOut;
            if (transitioning && (obj = this.sharedElementTransition) != null && !isSeekingSupported()) {
                Log.i("FragmentManager", "Ignoring shared elements transition " + obj + " between " + specialEffectsController$FragmentStateManagerOperation3 + " and " + specialEffectsController$FragmentStateManagerOperation2 + " as neither fragment has set a Transition. In order to run a SharedElementTransition, you must also set either an enter or exit transition on a fragment involved in the transaction. The sharedElementTransition will run after the back gesture has been committed.");
            }
            if (isSeekingSupported() && getTransitioning()) {
                ?? obj3 = new Object();
                Pair createMergedTransition = createMergedTransition(container, specialEffectsController$FragmentStateManagerOperation2, specialEffectsController$FragmentStateManagerOperation3);
                ArrayList arrayList2 = (ArrayList) createMergedTransition.first;
                Object obj4 = createMergedTransition.second;
                ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
                int size2 = arrayList.size();
                int i2 = 0;
                while (i2 < size2) {
                    Object obj5 = arrayList.get(i2);
                    i2++;
                    arrayList3.add(((TransitionInfo) obj5).operation);
                }
                int size3 = arrayList3.size();
                while (i < size3) {
                    Object obj6 = arrayList3.get(i);
                    i++;
                    SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation4 = (SpecialEffectsController$FragmentStateManagerOperation) obj6;
                    Fragment$$ExternalSyntheticLambda1 fragment$$ExternalSyntheticLambda1 = new Fragment$$ExternalSyntheticLambda1(1, obj3);
                    Fragment fragment = specialEffectsController$FragmentStateManagerOperation4.fragment;
                    this.transitionImpl.setListenerForTransitionEnd(obj4, this.transitionSignal, fragment$$ExternalSyntheticLambda1, new RunnableC0057xf804c654(specialEffectsController$FragmentStateManagerOperation4, this, 0));
                }
                runTransition(arrayList2, container, new DefaultSpecialEffectsController$TransitionEffect$onStart$4(this, container, obj4, obj3));
            }
        }

        public final void runTransition(ArrayList arrayList, ViewGroup viewGroup, Function0 function0) {
            FragmentTransition.setViewVisibility(arrayList, 4);
            final ArrayList arrayList2 = new ArrayList();
            final ArrayList arrayList3 = this.sharedElementLastInViews;
            int size = arrayList3.size();
            for (int i = 0; i < size; i++) {
                View view = (View) arrayList3.get(i);
                WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                arrayList2.add(ViewCompat.Api21Impl.getTransitionName(view));
                ViewCompat.Api21Impl.setTransitionName(view, null);
            }
            boolean isLoggingEnabled = FragmentManager.isLoggingEnabled(2);
            final ArrayList arrayList4 = this.sharedElementFirstOutViews;
            if (isLoggingEnabled) {
                Log.v("FragmentManager", ">>>>> Beginning transition <<<<<");
                Log.v("FragmentManager", ">>>>> SharedElementFirstOutViews <<<<<");
                int size2 = arrayList4.size();
                int i2 = 0;
                while (i2 < size2) {
                    Object sharedElementFirstOutViews = arrayList4.get(i2);
                    i2++;
                    Intrinsics.checkNotNullExpressionValue(sharedElementFirstOutViews, "sharedElementFirstOutViews");
                    View view2 = (View) sharedElementFirstOutViews;
                    StringBuilder sb = new StringBuilder("View: ");
                    sb.append(view2);
                    sb.append(" Name: ");
                    WeakHashMap weakHashMap2 = ViewCompat.sViewPropertyAnimatorMap;
                    sb.append(ViewCompat.Api21Impl.getTransitionName(view2));
                    Log.v("FragmentManager", sb.toString());
                }
                Log.v("FragmentManager", ">>>>> SharedElementLastInViews <<<<<");
                int size3 = arrayList3.size();
                int i3 = 0;
                while (i3 < size3) {
                    Object sharedElementLastInViews = arrayList3.get(i3);
                    i3++;
                    Intrinsics.checkNotNullExpressionValue(sharedElementLastInViews, "sharedElementLastInViews");
                    View view3 = (View) sharedElementLastInViews;
                    StringBuilder sb2 = new StringBuilder("View: ");
                    sb2.append(view3);
                    sb2.append(" Name: ");
                    WeakHashMap weakHashMap3 = ViewCompat.sViewPropertyAnimatorMap;
                    sb2.append(ViewCompat.Api21Impl.getTransitionName(view3));
                    Log.v("FragmentManager", sb2.toString());
                }
            }
            function0.invoke();
            final int size4 = arrayList3.size();
            final ArrayList arrayList5 = new ArrayList();
            for (int i4 = 0; i4 < size4; i4++) {
                View view4 = (View) arrayList4.get(i4);
                WeakHashMap weakHashMap4 = ViewCompat.sViewPropertyAnimatorMap;
                String transitionName = ViewCompat.Api21Impl.getTransitionName(view4);
                arrayList5.add(transitionName);
                if (transitionName != null) {
                    ViewCompat.Api21Impl.setTransitionName(view4, null);
                    String str = (String) this.sharedElementNameMapping.get(transitionName);
                    int i5 = 0;
                    while (true) {
                        if (i5 >= size4) {
                            break;
                        } else if (str.equals(arrayList2.get(i5))) {
                            ViewCompat.Api21Impl.setTransitionName((View) arrayList3.get(i5), transitionName);
                            break;
                        } else {
                            i5++;
                        }
                    }
                }
            }
            OneShotPreDrawListener.add(viewGroup, new Runnable() { // from class: androidx.fragment.app.FragmentTransitionImpl.1
                @Override // java.lang.Runnable
                public final void run() {
                    for (int i6 = 0; i6 < size4; i6++) {
                        WeakHashMap weakHashMap5 = ViewCompat.sViewPropertyAnimatorMap;
                        ViewCompat.Api21Impl.setTransitionName((View) arrayList3.get(i6), (String) arrayList2.get(i6));
                        ViewCompat.Api21Impl.setTransitionName((View) arrayList4.get(i6), (String) arrayList5.get(i6));
                    }
                }
            });
            FragmentTransition.setViewVisibility(arrayList, 0);
            this.transitionImpl.swapSharedElementTargets(this.sharedElementTransition, arrayList4, arrayList3);
        }
    }

    public DefaultSpecialEffectsController(ViewGroup container) {
        Intrinsics.checkNotNullParameter(container, "container");
        this.container = container;
    }

    public static void findNamedViews(ArrayMap arrayMap, View view) {
        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        String transitionName = ViewCompat.Api21Impl.getTransitionName(view);
        if (transitionName != null) {
            arrayMap.put(transitionName, view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt.getVisibility() == 0) {
                    findNamedViews(arrayMap, childAt);
                }
            }
        }
    }

    public static final DefaultSpecialEffectsController getOrCreateController(ViewGroup container, FragmentManager fragmentManager) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics.checkNotNullExpressionValue(fragmentManager.getSpecialEffectsControllerFactory(), "fragmentManager.specialEffectsControllerFactory");
        Object tag = container.getTag(C0130R.C0132id.special_effects_controller_view_tag);
        if (tag instanceof DefaultSpecialEffectsController) {
            return (DefaultSpecialEffectsController) tag;
        }
        DefaultSpecialEffectsController defaultSpecialEffectsController = new DefaultSpecialEffectsController(container);
        container.setTag(C0130R.C0132id.special_effects_controller_view_tag, defaultSpecialEffectsController);
        return defaultSpecialEffectsController;
    }

    public static boolean isOperationSeekable(ArrayList arrayList) {
        int size = arrayList.size();
        boolean z = true;
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation = (SpecialEffectsController$FragmentStateManagerOperation) obj;
            if (!specialEffectsController$FragmentStateManagerOperation.effects.isEmpty()) {
                ArrayList arrayList2 = specialEffectsController$FragmentStateManagerOperation.effects;
                if (arrayList2 == null || !arrayList2.isEmpty()) {
                    int size2 = arrayList2.size();
                    int i2 = 0;
                    while (i2 < size2) {
                        Object obj2 = arrayList2.get(i2);
                        i2++;
                        if (!((SpecialEffectsController$Effect) obj2).isSeekingSupported()) {
                        }
                    }
                }
                z = true;
            }
            z = false;
        }
        if (z) {
            ArrayList arrayList3 = new ArrayList();
            int size3 = arrayList.size();
            int i3 = 0;
            while (i3 < size3) {
                Object obj3 = arrayList.get(i3);
                i3++;
                CollectionsKt__MutableCollectionsKt.addAll(((SpecialEffectsController$FragmentStateManagerOperation) obj3).effects, arrayList3);
            }
            if (!arrayList3.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public static void retainMatchingViews(ArrayMap arrayMap, Collection collection) {
        Iterator it = ((ArrayMap.EntrySet) arrayMap.entrySet()).iterator();
        while (it.hasNext()) {
            it.next();
            WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            if (!CollectionsKt.contains(collection, ViewCompat.Api21Impl.getTransitionName((View) ((Map.Entry) it).getValue()))) {
                it.remove();
            }
        }
    }

    public final void applyContainerChangesToOperation$fragment_release(SpecialEffectsController$FragmentStateManagerOperation operation) {
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (operation.isAwaitingContainerChanges) {
            int i = operation.finalState;
            View requireView = operation.fragment.requireView();
            Intrinsics.checkNotNullExpressionValue(requireView, "operation.fragment.requireView()");
            ViewModelProvider.Factory.CC._applyState(i, requireView, this.container);
            operation.isAwaitingContainerChanges = false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x02b7, code lost:
        if (androidx.fragment.app.FragmentManager.isLoggingEnabled(2) == false) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x02b9, code lost:
        android.util.Log.v("FragmentManager", ">>> entering view names <<<");
        r0 = r7.size();
        r8 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x02c5, code lost:
        if (r8 >= r0) goto L224;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x02c7, code lost:
        r14 = r7.get(r8);
        r8 = r8 + 1;
        android.util.Log.v("FragmentManager", "Name: " + r14);
        r0 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x02e3, code lost:
        android.util.Log.v("FragmentManager", ">>> exiting view names <<<");
        r0 = r4.size();
        r8 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x02ed, code lost:
        if (r8 >= r0) goto L225;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x02ef, code lost:
        r14 = r4.get(r8);
        r8 = r8 + 1;
        android.util.Log.v("FragmentManager", "Name: " + r14);
        r0 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x030b, code lost:
        r0 = r2.mView;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, "firstOut.fragment.mView");
        findNamedViews(r15, r0);
        r15.retainAll(r4);
        r9.retainAll(r15.keySet());
        r0 = r10.mView;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, "lastIn.fragment.mView");
        findNamedViews(r13, r0);
        r13.retainAll(r7);
        r13.retainAll(r9.values());
        r0 = androidx.fragment.app.FragmentTransition.PLATFORM_IMPL;
        r0 = r9.size - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x033a, code lost:
        if ((-1) >= r0) goto L226;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x0346, code lost:
        if (r13.containsKey((java.lang.String) r9.valueAt(r0)) != false) goto L228;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0348, code lost:
        r9.removeAt(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x034b, code lost:
        r0 = r0 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x034e, code lost:
        retainMatchingViews(r15, r9.keySet());
        retainMatchingViews(r13, r9.values());
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0360, code lost:
        if (r9.isEmpty() == false) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0362, code lost:
        android.util.Log.i("FragmentManager", "Ignoring shared elements transition " + r1 + " between " + r12 + " and " + r5 + " as there are no matching elements in both the entering and exiting fragment. In order to run a SharedElementTransition, both fragments involved must have the element.");
        r26.clear();
        r23.clear();
        r1 = r26;
        r18 = r4;
        r10 = r7;
        r2 = r20;
        r4 = r21;
        r7 = r22;
        r8 = r23;
        r11 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x03a3, code lost:
        r19 = r1;
        r18 = r4;
        r10 = r7;
        r2 = r20;
        r4 = r21;
        r7 = r22;
        r8 = r23;
        r11 = r11;
        r1 = r26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x03bf, code lost:
        throw new java.lang.ClassCastException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x03c5, code lost:
        throw new java.lang.ClassCastException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x03cf, code lost:
        r20 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x03d2, code lost:
        r1 = r26;
        r2 = r20;
        r4 = r4;
        r7 = r7;
        r8 = r8;
        r11 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x03e4, code lost:
        r26 = r1;
        r20 = r2;
        r22 = r7;
        r23 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x03ec, code lost:
        if (r19 != null) goto L134;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x03f2, code lost:
        if (r6.isEmpty() == false) goto L130;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x03f4, code lost:
        r0 = "FragmentManager";
        r15 = r20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x03f8, code lost:
        r0 = r6.size();
        r1 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x03fd, code lost:
        if (r1 >= r0) goto L230;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x03ff, code lost:
        r2 = r6.get(r1);
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x0409, code lost:
        if (((androidx.fragment.app.DefaultSpecialEffectsController.TransitionInfo) r2).transition != null) goto L229;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x040c, code lost:
        r0 = "FragmentManager";
        r15 = r20;
        r1 = new androidx.fragment.app.DefaultSpecialEffectsController.TransitionEffect(r6, r12, r5, r22, r19, r26, r23, r9, r10, r18, r15, r13, r27);
        r3 = r6.size();
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x0429, code lost:
        if (r4 >= r3) goto L231;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x042b, code lost:
        r5 = r6.get(r4);
        r4 = r4 + 1;
        ((androidx.fragment.app.DefaultSpecialEffectsController.TransitionInfo) r5).operation._effects.add(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x043b, code lost:
        r1 = new java.util.ArrayList();
        r2 = new java.util.ArrayList();
        r3 = r15.size();
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x044a, code lost:
        if (r4 >= r3) goto L232;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x044c, code lost:
        r5 = r15.get(r4);
        r4 = r4 + 1;
        kotlin.collections.CollectionsKt__MutableCollectionsKt.addAll(((androidx.fragment.app.DefaultSpecialEffectsController.AnimationInfo) r5).operation.effects, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x045c, code lost:
        r2 = r2.isEmpty();
        r3 = r15.size();
        r4 = false;
        r5 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x0466, code lost:
        if (r5 >= r3) goto L234;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x0468, code lost:
        r6 = r15.get(r5);
        r5 = r5 + 1;
        r6 = (androidx.fragment.app.DefaultSpecialEffectsController.AnimationInfo) r6;
        r8 = r25.container.getContext();
        r9 = r6.operation;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, "context");
        r8 = r6.getAnimation(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x0483, code lost:
        if (r8 != null) goto L233;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x048a, code lost:
        if (((android.animation.AnimatorSet) r8.animator) != null) goto L235;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x048c, code lost:
        r1.add(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x0490, code lost:
        r8 = r9.fragment;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x0498, code lost:
        if (r9.effects.isEmpty() != false) goto L236;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x049e, code lost:
        if (androidx.fragment.app.FragmentManager.isLoggingEnabled(2) == false) goto L243;
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x04a0, code lost:
        android.util.Log.v(r0, "Ignoring Animator set on " + r8 + " as this Fragment was involved in a Transition.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x04ba, code lost:
        if (r9.finalState != 3) goto L155;
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x04bc, code lost:
        r9.isAwaitingContainerChanges = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x04c1, code lost:
        r9._effects.add(new androidx.fragment.app.DefaultSpecialEffectsController.AnimatorEffect(r6));
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x04cd, code lost:
        r8 = 0;
        r3 = r1.size();
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x04d4, code lost:
        if (r8 >= r3) goto L246;
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x04d6, code lost:
        r5 = r1.get(r8);
        r8 = r8 + 1;
        r5 = (androidx.fragment.app.DefaultSpecialEffectsController.AnimationInfo) r5;
        r6 = r5.operation;
        r9 = r6.fragment;
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x04e4, code lost:
        if (r2 != false) goto L247;
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x04ea, code lost:
        if (androidx.fragment.app.FragmentManager.isLoggingEnabled(2) == false) goto L254;
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x04ec, code lost:
        android.util.Log.v(r0, "Ignoring Animation set on " + r9 + " as Animations cannot run alongside Transitions.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x0501, code lost:
        if (r4 == false) goto L249;
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x0507, code lost:
        if (androidx.fragment.app.FragmentManager.isLoggingEnabled(2) == false) goto L256;
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x0509, code lost:
        android.util.Log.v(r0, "Ignoring Animation set on " + r9 + " as Animations cannot run alongside Animators.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x051e, code lost:
        r6._effects.add(new androidx.fragment.app.DefaultSpecialEffectsController.AnimationEffect(r5));
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x0529, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00a9, code lost:
        r5 = (androidx.fragment.app.SpecialEffectsController$FragmentStateManagerOperation) r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00af, code lost:
        if (androidx.fragment.app.FragmentManager.isLoggingEnabled(2) == false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00b1, code lost:
        android.util.Log.v("FragmentManager", "Executing operations from " + r12 + " to " + r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00ca, code lost:
        r2 = new java.util.ArrayList();
        r6 = new java.util.ArrayList();
        r7 = ((androidx.fragment.app.SpecialEffectsController$FragmentStateManagerOperation) kotlin.collections.CollectionsKt.last(r26)).fragment;
        r8 = r26.size();
        r9 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00e1, code lost:
        if (r9 >= r8) goto L191;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00e3, code lost:
        r10 = r26.get(r9);
        r9 = r9 + 1;
        r10 = ((androidx.fragment.app.SpecialEffectsController$FragmentStateManagerOperation) r10).fragment.mAnimationInfo;
        r13 = r7.mAnimationInfo;
        r10.mEnterAnim = r13.mEnterAnim;
        r10.mExitAnim = r13.mExitAnim;
        r10.mPopEnterAnim = r13.mPopEnterAnim;
        r10.mPopExitAnim = r13.mPopExitAnim;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0105, code lost:
        r7 = r26.size();
        r8 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x010d, code lost:
        if (r8 >= r7) goto L192;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x010f, code lost:
        r9 = r26.get(r8);
        r8 = r8 + 1;
        r9 = (androidx.fragment.app.SpecialEffectsController$FragmentStateManagerOperation) r9;
        r2.add(new androidx.fragment.app.DefaultSpecialEffectsController.AnimationInfo(r9, r27));
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0121, code lost:
        if (r27 == false) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0123, code lost:
        if (r9 != r12) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0125, code lost:
        r13 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0127, code lost:
        r13 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0129, code lost:
        if (r9 != r5) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x012c, code lost:
        r6.add(new androidx.fragment.app.DefaultSpecialEffectsController.TransitionInfo(r9, r27, r13));
        r9.completionListeners.add(new androidx.fragment.app.SpecialEffectsController$$ExternalSyntheticLambda0(r25, r9, 1));
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x013d, code lost:
        r1 = new java.util.ArrayList();
        r7 = r6.size();
        r8 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0147, code lost:
        if (r8 >= r7) goto L196;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0149, code lost:
        r9 = r6.get(r8);
        r8 = r8 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0156, code lost:
        if (((androidx.fragment.app.DefaultSpecialEffectsController.TransitionInfo) r9).isVisibilityUnchanged() != false) goto L198;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0158, code lost:
        r1.add(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x015c, code lost:
        r6 = new java.util.ArrayList();
        r7 = r1.size();
        r8 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0166, code lost:
        if (r8 >= r7) goto L201;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0168, code lost:
        r9 = r1.get(r8);
        r8 = r8 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0175, code lost:
        if (((androidx.fragment.app.DefaultSpecialEffectsController.TransitionInfo) r9).getHandlingImpl() == null) goto L203;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0177, code lost:
        r6.add(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x017b, code lost:
        r1 = r6.size();
        r7 = null;
        r8 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0181, code lost:
        if (r8 >= r1) goto L205;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0183, code lost:
        r9 = r6.get(r8);
        r8 = r8 + 1;
        r10 = ((androidx.fragment.app.DefaultSpecialEffectsController.TransitionInfo) r9).getHandlingImpl();
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x018f, code lost:
        if (r7 == null) goto L207;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0191, code lost:
        if (r10 != r7) goto L206;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x01be, code lost:
        throw new java.lang.IllegalArgumentException(("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + r9.operation.fragment + " returned Transition " + r9.transition + " which uses a different Transition type than other Fragments.").toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x01bf, code lost:
        r7 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x01c1, code lost:
        if (r7 != null) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x01c3, code lost:
        r15 = r2;
        r0 = "FragmentManager";
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x01c9, code lost:
        r1 = new java.util.ArrayList();
        r8 = new java.util.ArrayList();
        r9 = new androidx.collection.SimpleArrayMap(0);
        r10 = new java.util.ArrayList<>();
        r13 = new java.util.ArrayList<>();
        r15 = new androidx.collection.SimpleArrayMap(0);
        r18 = r13;
        r13 = new androidx.collection.SimpleArrayMap(0);
        r4 = r6.size();
        r11 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x01f5, code lost:
        r19 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x01f7, code lost:
        if (r11 >= r4) goto L211;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x01f9, code lost:
        r20 = r6.get(r11);
        r11 = r11 + 1;
        r26 = r1;
        r1 = ((androidx.fragment.app.DefaultSpecialEffectsController.TransitionInfo) r20).sharedElementTransition;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0207, code lost:
        if (r1 == null) goto L212;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0209, code lost:
        if (r12 == null) goto L213;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x020b, code lost:
        r20 = r2;
        r2 = r12.fragment;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x020f, code lost:
        if (r5 == null) goto L214;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0211, code lost:
        r10 = r5.fragment;
        r1 = r7.wrapTransitionInSet(r7.cloneTransition(r1));
        r21 = r4;
        r4 = r10.getSharedElementSourceNames();
        r22 = r7;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, "lastIn.fragment.sharedElementSourceNames");
        r7 = r2.getSharedElementSourceNames();
        r23 = r8;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, "firstOut.fragment.sharedElementSourceNames");
        r8 = r2.getSharedElementTargetNames();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, "firstOut.fragment.sharedElementTargetNames");
        r11 = r8.size();
        r14 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0244, code lost:
        if (r14 >= r11) goto L220;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0246, code lost:
        r18 = r11;
        r11 = r4.indexOf(r8.get(r14));
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0250, code lost:
        if (r11 == (-1)) goto L222;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0252, code lost:
        r4.set(r11, r7.get(r14));
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0259, code lost:
        r14 = r14 + 1;
        r11 = r18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x025e, code lost:
        r7 = r10.getSharedElementTargetNames();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, "lastIn.fragment.sharedElementTargetNames");
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0267, code lost:
        if (r27 != false) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0269, code lost:
        r2.getExitTransitionCallback();
        r10.getEnterTransitionCallback();
        r8 = new kotlin.Pair(null, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0276, code lost:
        r2.getEnterTransitionCallback();
        r10.getExitTransitionCallback();
        r8 = new kotlin.Pair(null, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0284, code lost:
        if (r8.first != null) goto L209;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0288, code lost:
        if (r8.second != null) goto L210;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x028a, code lost:
        r8 = r4.size();
        r14 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x028f, code lost:
        if (r14 >= r8) goto L223;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0291, code lost:
        r11 = r4.get(r14);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, "exitingNames[i]");
        r0 = r7.get(r14);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, "enteringNames[i]");
        r9.put(r11, r0);
        r14 = r14 + 1;
        r8 = r8;
     */
    /* JADX WARN: Type inference failed for: r13v1, types: [androidx.collection.SimpleArrayMap, androidx.collection.ArrayMap] */
    /* JADX WARN: Type inference failed for: r15v3, types: [androidx.collection.SimpleArrayMap, androidx.collection.ArrayMap] */
    /* JADX WARN: Type inference failed for: r9v6, types: [androidx.collection.SimpleArrayMap, androidx.collection.ArrayMap] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void collectEffects(ArrayList arrayList, boolean z) {
        float f;
        Object obj;
        Object obj2;
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v("FragmentManager", "Collecting Effects");
        }
        int size = arrayList.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                f = 0.0f;
                obj = null;
                break;
            }
            obj = arrayList.get(i);
            i++;
            SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation = (SpecialEffectsController$FragmentStateManagerOperation) obj;
            f = 0.0f;
            View view = specialEffectsController$FragmentStateManagerOperation.fragment.mView;
            Intrinsics.checkNotNullExpressionValue(view, "operation.fragment.mView");
            if (view.getAlpha() != 0.0f || view.getVisibility() != 0) {
                int visibility = view.getVisibility();
                if (visibility != 0) {
                    if (!(visibility == 4 || visibility == 8)) {
                        throw new IllegalArgumentException(ViewModelProvider.Factory.CC.m604m(visibility, "Unknown visibility "));
                    }
                } else if (specialEffectsController$FragmentStateManagerOperation.finalState != 2) {
                    break;
                }
            }
        }
        SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation2 = (SpecialEffectsController$FragmentStateManagerOperation) obj;
        ListIterator listIterator = arrayList.listIterator(arrayList.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                obj2 = null;
                break;
            }
            obj2 = listIterator.previous();
            SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation3 = (SpecialEffectsController$FragmentStateManagerOperation) obj2;
            View view2 = specialEffectsController$FragmentStateManagerOperation3.fragment.mView;
            Intrinsics.checkNotNullExpressionValue(view2, "operation.fragment.mView");
            if (view2.getAlpha() != f || view2.getVisibility() != 0) {
                int visibility2 = view2.getVisibility();
                if (visibility2 == 0) {
                    continue;
                } else if (!(visibility2 == 4 || visibility2 == 8)) {
                    throw new IllegalArgumentException(ViewModelProvider.Factory.CC.m604m(visibility2, "Unknown visibility "));
                }
            }
            if (specialEffectsController$FragmentStateManagerOperation3.finalState == 2) {
                break;
            }
        }
    }

    public final void commitEffects$fragment_release(List operations) {
        Intrinsics.checkNotNullParameter(operations, "operations");
        ArrayList arrayList = new ArrayList();
        Iterator it = operations.iterator();
        while (it.hasNext()) {
            CollectionsKt__MutableCollectionsKt.addAll(((SpecialEffectsController$FragmentStateManagerOperation) it.next()).effects, arrayList);
        }
        List list = CollectionsKt.toList(CollectionsKt.toSet(arrayList));
        int size = list.size();
        for (int i = 0; i < size; i++) {
            ((SpecialEffectsController$Effect) list.get(i)).onCommit(this.container);
        }
        int size2 = operations.size();
        for (int i2 = 0; i2 < size2; i2++) {
            applyContainerChangesToOperation$fragment_release((SpecialEffectsController$FragmentStateManagerOperation) operations.get(i2));
        }
        List list2 = CollectionsKt.toList(operations);
        int size3 = list2.size();
        for (int i3 = 0; i3 < size3; i3++) {
            SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation = (SpecialEffectsController$FragmentStateManagerOperation) list2.get(i3);
            if (specialEffectsController$FragmentStateManagerOperation.effects.isEmpty()) {
                specialEffectsController$FragmentStateManagerOperation.complete$fragment_release();
            }
        }
    }

    public final void enqueue(int i, int i2, FragmentStateManager fragmentStateManager) {
        synchronized (this.pendingOperations) {
            try {
                Fragment fragment = fragmentStateManager.mFragment;
                Intrinsics.checkNotNullExpressionValue(fragment, "fragmentStateManager.fragment");
                SpecialEffectsController$FragmentStateManagerOperation findPendingOperation = findPendingOperation(fragment);
                if (findPendingOperation == null) {
                    Fragment fragment2 = fragmentStateManager.mFragment;
                    if (!fragment2.mTransitioning && !fragment2.mRemoving) {
                        findPendingOperation = null;
                    }
                    findPendingOperation = findRunningOperation(fragment2);
                }
                if (findPendingOperation != null) {
                    findPendingOperation.mergeWith(i, i2);
                    return;
                }
                SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation = new SpecialEffectsController$FragmentStateManagerOperation(i, i2, fragmentStateManager);
                this.pendingOperations.add(specialEffectsController$FragmentStateManagerOperation);
                specialEffectsController$FragmentStateManagerOperation.completionListeners.add(new SpecialEffectsController$$ExternalSyntheticLambda0(this, specialEffectsController$FragmentStateManagerOperation, 0));
                specialEffectsController$FragmentStateManagerOperation.completionListeners.add(new SpecialEffectsController$$ExternalSyntheticLambda0(this, specialEffectsController$FragmentStateManagerOperation, 2));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void executePendingOperations() {
        boolean z;
        if (!this.isContainerPostponed) {
            if (!this.container.isAttachedToWindow()) {
                forceCompleteAllOperations();
                this.operationDirectionIsPop = false;
                return;
            }
            synchronized (this.pendingOperations) {
                try {
                    ArrayList mutableList = CollectionsKt.toMutableList(this.runningOperations);
                    this.runningOperations.clear();
                    int size = mutableList.size();
                    int i = 0;
                    while (true) {
                        z = true;
                        if (i >= size) {
                            break;
                        }
                        Object obj = mutableList.get(i);
                        i++;
                        SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation = (SpecialEffectsController$FragmentStateManagerOperation) obj;
                        if (this.pendingOperations.isEmpty() || !specialEffectsController$FragmentStateManagerOperation.fragment.mTransitioning) {
                            z = false;
                        }
                        specialEffectsController$FragmentStateManagerOperation.isSeeking = z;
                    }
                    int size2 = mutableList.size();
                    int i2 = 0;
                    while (i2 < size2) {
                        Object obj2 = mutableList.get(i2);
                        i2++;
                        SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation2 = (SpecialEffectsController$FragmentStateManagerOperation) obj2;
                        if (this.runningNonSeekableTransition) {
                            if (FragmentManager.isLoggingEnabled(2)) {
                                Log.v("FragmentManager", "SpecialEffectsController: Completing non-seekable operation " + specialEffectsController$FragmentStateManagerOperation2);
                            }
                            specialEffectsController$FragmentStateManagerOperation2.complete$fragment_release();
                        } else {
                            if (FragmentManager.isLoggingEnabled(2)) {
                                Log.v("FragmentManager", "SpecialEffectsController: Cancelling operation " + specialEffectsController$FragmentStateManagerOperation2);
                            }
                            specialEffectsController$FragmentStateManagerOperation2.cancel(this.container);
                        }
                        this.runningNonSeekableTransition = false;
                        if (!specialEffectsController$FragmentStateManagerOperation2.isComplete) {
                            this.runningOperations.add(specialEffectsController$FragmentStateManagerOperation2);
                        }
                    }
                    if (!this.pendingOperations.isEmpty()) {
                        updateFinalState();
                        ArrayList mutableList2 = CollectionsKt.toMutableList(this.pendingOperations);
                        if (!mutableList2.isEmpty()) {
                            this.pendingOperations.clear();
                            this.runningOperations.addAll(mutableList2);
                            if (FragmentManager.isLoggingEnabled(2)) {
                                Log.v("FragmentManager", "SpecialEffectsController: Executing pending operations");
                            }
                            collectEffects(mutableList2, this.operationDirectionIsPop);
                            boolean isOperationSeekable = isOperationSeekable(mutableList2);
                            int size3 = mutableList2.size();
                            boolean z2 = true;
                            int i3 = 0;
                            while (i3 < size3) {
                                Object obj3 = mutableList2.get(i3);
                                i3++;
                                if (!((SpecialEffectsController$FragmentStateManagerOperation) obj3).fragment.mTransitioning) {
                                    z2 = false;
                                }
                            }
                            if (!z2 || isOperationSeekable) {
                                z = false;
                            }
                            this.runningNonSeekableTransition = z;
                            if (FragmentManager.isLoggingEnabled(2)) {
                                Log.v("FragmentManager", "SpecialEffectsController: Operation seekable = " + isOperationSeekable + " \ntransition = " + z2);
                            }
                            if (!z2) {
                                processStart(mutableList2);
                                commitEffects$fragment_release(mutableList2);
                            } else if (isOperationSeekable) {
                                processStart(mutableList2);
                                int size4 = mutableList2.size();
                                for (int i4 = 0; i4 < size4; i4++) {
                                    applyContainerChangesToOperation$fragment_release((SpecialEffectsController$FragmentStateManagerOperation) mutableList2.get(i4));
                                }
                            }
                            this.operationDirectionIsPop = false;
                            if (FragmentManager.isLoggingEnabled(2)) {
                                Log.v("FragmentManager", "SpecialEffectsController: Finished executing pending operations");
                            }
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public final SpecialEffectsController$FragmentStateManagerOperation findPendingOperation(Fragment fragment) {
        Object obj;
        ArrayList arrayList = this.pendingOperations;
        int size = arrayList.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                obj = null;
                break;
            }
            obj = arrayList.get(i);
            i++;
            SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation = (SpecialEffectsController$FragmentStateManagerOperation) obj;
            if (Intrinsics.areEqual(specialEffectsController$FragmentStateManagerOperation.fragment, fragment) && !specialEffectsController$FragmentStateManagerOperation.isCanceled) {
                break;
            }
        }
        return (SpecialEffectsController$FragmentStateManagerOperation) obj;
    }

    public final SpecialEffectsController$FragmentStateManagerOperation findRunningOperation(Fragment fragment) {
        Object obj;
        ArrayList arrayList = this.runningOperations;
        int size = arrayList.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                obj = null;
                break;
            }
            obj = arrayList.get(i);
            i++;
            SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation = (SpecialEffectsController$FragmentStateManagerOperation) obj;
            if (Intrinsics.areEqual(specialEffectsController$FragmentStateManagerOperation.fragment, fragment) && !specialEffectsController$FragmentStateManagerOperation.isCanceled) {
                break;
            }
        }
        return (SpecialEffectsController$FragmentStateManagerOperation) obj;
    }

    public final void forceCompleteAllOperations() {
        String str;
        String str2;
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Forcing all operations to complete");
        }
        boolean isAttachedToWindow = this.container.isAttachedToWindow();
        synchronized (this.pendingOperations) {
            try {
                updateFinalState();
                processStart(this.pendingOperations);
                ArrayList mutableList = CollectionsKt.toMutableList(this.runningOperations);
                int size = mutableList.size();
                int i = 0;
                int i2 = 0;
                while (i2 < size) {
                    Object obj = mutableList.get(i2);
                    i2++;
                    ((SpecialEffectsController$FragmentStateManagerOperation) obj).isSeeking = false;
                }
                int size2 = mutableList.size();
                int i3 = 0;
                while (i3 < size2) {
                    Object obj2 = mutableList.get(i3);
                    i3++;
                    SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation = (SpecialEffectsController$FragmentStateManagerOperation) obj2;
                    if (FragmentManager.isLoggingEnabled(2)) {
                        if (isAttachedToWindow) {
                            str2 = "";
                        } else {
                            str2 = "Container " + this.container + " is not attached to window. ";
                        }
                        Log.v("FragmentManager", "SpecialEffectsController: " + str2 + "Cancelling running operation " + specialEffectsController$FragmentStateManagerOperation);
                    }
                    specialEffectsController$FragmentStateManagerOperation.cancel(this.container);
                }
                ArrayList mutableList2 = CollectionsKt.toMutableList(this.pendingOperations);
                int size3 = mutableList2.size();
                int i4 = 0;
                while (i4 < size3) {
                    Object obj3 = mutableList2.get(i4);
                    i4++;
                    ((SpecialEffectsController$FragmentStateManagerOperation) obj3).isSeeking = false;
                }
                int size4 = mutableList2.size();
                while (i < size4) {
                    Object obj4 = mutableList2.get(i);
                    i++;
                    SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation2 = (SpecialEffectsController$FragmentStateManagerOperation) obj4;
                    if (FragmentManager.isLoggingEnabled(2)) {
                        if (isAttachedToWindow) {
                            str = "";
                        } else {
                            str = "Container " + this.container + " is not attached to window. ";
                        }
                        Log.v("FragmentManager", "SpecialEffectsController: " + str + "Cancelling pending operation " + specialEffectsController$FragmentStateManagerOperation2);
                    }
                    specialEffectsController$FragmentStateManagerOperation2.cancel(this.container);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void markPostponedState() {
        Fragment fragment;
        Object obj;
        boolean z;
        synchronized (this.pendingOperations) {
            try {
                updateFinalState();
                ArrayList arrayList = this.pendingOperations;
                ListIterator listIterator = arrayList.listIterator(arrayList.size());
                while (true) {
                    fragment = null;
                    if (!listIterator.hasPrevious()) {
                        obj = null;
                        break;
                    }
                    obj = listIterator.previous();
                    SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation = (SpecialEffectsController$FragmentStateManagerOperation) obj;
                    View view = specialEffectsController$FragmentStateManagerOperation.fragment.mView;
                    Intrinsics.checkNotNullExpressionValue(view, "operation.fragment.mView");
                    char c = 4;
                    if (view.getAlpha() != 0.0f || view.getVisibility() != 0) {
                        int visibility = view.getVisibility();
                        if (visibility == 0) {
                            c = 2;
                        } else if (visibility != 4) {
                            if (visibility == 8) {
                                c = 3;
                            } else {
                                throw new IllegalArgumentException("Unknown visibility " + visibility);
                            }
                        }
                    }
                    if (specialEffectsController$FragmentStateManagerOperation.finalState == 2 && c != 2) {
                        break;
                    }
                }
                SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation2 = (SpecialEffectsController$FragmentStateManagerOperation) obj;
                if (specialEffectsController$FragmentStateManagerOperation2 != null) {
                    fragment = specialEffectsController$FragmentStateManagerOperation2.fragment;
                }
                if (fragment != null) {
                    z = fragment.isPostponed();
                } else {
                    z = false;
                }
                this.isContainerPostponed = z;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void processStart(List list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation = (SpecialEffectsController$FragmentStateManagerOperation) list.get(i);
            FragmentStateManager fragmentStateManager = specialEffectsController$FragmentStateManagerOperation.fragmentStateManager;
            if (!specialEffectsController$FragmentStateManagerOperation.isStarted) {
                specialEffectsController$FragmentStateManagerOperation.isStarted = true;
                int i2 = specialEffectsController$FragmentStateManagerOperation.lifecycleImpact;
                if (i2 == 2) {
                    Fragment fragment = fragmentStateManager.mFragment;
                    Intrinsics.checkNotNullExpressionValue(fragment, "fragmentStateManager.fragment");
                    View findFocus = fragment.mView.findFocus();
                    if (findFocus != null) {
                        fragment.setFocusedView(findFocus);
                        if (FragmentManager.isLoggingEnabled(2)) {
                            Log.v("FragmentManager", "requestFocus: Saved focused view " + findFocus + " for Fragment " + fragment);
                        }
                    }
                    View requireView = specialEffectsController$FragmentStateManagerOperation.fragment.requireView();
                    Intrinsics.checkNotNullExpressionValue(requireView, "this.fragment.requireView()");
                    if (requireView.getParent() == null) {
                        if (FragmentManager.isLoggingEnabled(2)) {
                            Log.v("FragmentManager", "Adding fragment " + fragment + " view " + requireView + " to container in onStart");
                        }
                        fragmentStateManager.addViewToContainer();
                        requireView.setAlpha(0.0f);
                    }
                    if (requireView.getAlpha() == 0.0f && requireView.getVisibility() == 0) {
                        if (FragmentManager.isLoggingEnabled(2)) {
                            Log.v("FragmentManager", "Making view " + requireView + " INVISIBLE in onStart");
                        }
                        requireView.setVisibility(4);
                    }
                    requireView.setAlpha(fragment.getPostOnViewCreatedAlpha());
                    if (FragmentManager.isLoggingEnabled(2)) {
                        Log.v("FragmentManager", "Setting view alpha to " + fragment.getPostOnViewCreatedAlpha() + " in onStart");
                    }
                } else if (i2 == 3) {
                    Fragment fragment2 = fragmentStateManager.mFragment;
                    Intrinsics.checkNotNullExpressionValue(fragment2, "fragmentStateManager.fragment");
                    View requireView2 = fragment2.requireView();
                    Intrinsics.checkNotNullExpressionValue(requireView2, "fragment.requireView()");
                    if (FragmentManager.isLoggingEnabled(2)) {
                        Log.v("FragmentManager", "Clearing focus " + requireView2.findFocus() + " on view " + requireView2 + " for Fragment " + fragment2);
                    }
                    requireView2.clearFocus();
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            CollectionsKt__MutableCollectionsKt.addAll(((SpecialEffectsController$FragmentStateManagerOperation) it.next()).effects, arrayList);
        }
        List list2 = CollectionsKt.toList(CollectionsKt.toSet(arrayList));
        int size2 = list2.size();
        for (int i3 = 0; i3 < size2; i3++) {
            SpecialEffectsController$Effect specialEffectsController$Effect = (SpecialEffectsController$Effect) list2.get(i3);
            specialEffectsController$Effect.getClass();
            ViewGroup container = this.container;
            Intrinsics.checkNotNullParameter(container, "container");
            if (!specialEffectsController$Effect.isStarted) {
                specialEffectsController$Effect.onStart(container);
            }
            specialEffectsController$Effect.isStarted = true;
        }
    }

    public final void updateFinalState() {
        ArrayList arrayList = this.pendingOperations;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation = (SpecialEffectsController$FragmentStateManagerOperation) obj;
            int i2 = 2;
            if (specialEffectsController$FragmentStateManagerOperation.lifecycleImpact == 2) {
                View requireView = specialEffectsController$FragmentStateManagerOperation.fragment.requireView();
                Intrinsics.checkNotNullExpressionValue(requireView, "fragment.requireView()");
                int visibility = requireView.getVisibility();
                if (visibility != 0) {
                    i2 = 4;
                    if (visibility != 4) {
                        if (visibility == 8) {
                            i2 = 3;
                        } else {
                            throw new IllegalArgumentException(ViewModelProvider.Factory.CC.m604m(visibility, "Unknown visibility "));
                        }
                    }
                }
                specialEffectsController$FragmentStateManagerOperation.mergeWith(i2, 1);
            }
        }
    }

    /* loaded from: classes.dex */
    public final class TransitionInfo extends SpecialEffectsInfo {
        public final boolean isOverlapAllowed;
        public final Object sharedElementTransition;
        public final Object transition;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TransitionInfo(SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation, boolean z, boolean z2) {
            super(specialEffectsController$FragmentStateManagerOperation);
            Object obj;
            boolean z3;
            Object obj2;
            Fragment fragment = specialEffectsController$FragmentStateManagerOperation.fragment;
            if (specialEffectsController$FragmentStateManagerOperation.finalState == 2) {
                if (z) {
                    obj = fragment.getReenterTransition();
                } else {
                    obj = fragment.getEnterTransition();
                }
            } else if (z) {
                obj = fragment.getReturnTransition();
            } else {
                obj = fragment.getExitTransition();
            }
            this.transition = obj;
            if (specialEffectsController$FragmentStateManagerOperation.finalState != 2) {
                z3 = true;
            } else if (z) {
                z3 = fragment.getAllowReturnTransitionOverlap();
            } else {
                z3 = fragment.getAllowEnterTransitionOverlap();
            }
            this.isOverlapAllowed = z3;
            if (!z2) {
                obj2 = null;
            } else if (z) {
                obj2 = fragment.getSharedElementReturnTransition();
            } else {
                obj2 = fragment.getSharedElementEnterTransition();
            }
            this.sharedElementTransition = obj2;
        }

        public final FragmentTransitionImpl getHandlingImpl() {
            Object obj = this.transition;
            FragmentTransitionImpl handlingImpl = getHandlingImpl(obj);
            Object obj2 = this.sharedElementTransition;
            FragmentTransitionImpl handlingImpl2 = getHandlingImpl(obj2);
            if (handlingImpl == null || handlingImpl2 == null || handlingImpl == handlingImpl2) {
                return handlingImpl == null ? handlingImpl2 : handlingImpl;
            }
            throw new IllegalArgumentException(("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + this.operation.fragment + " returned Transition " + obj + " which uses a different Transition  type than its shared element transition " + obj2).toString());
        }

        public final FragmentTransitionImpl getHandlingImpl(Object obj) {
            if (obj == null) {
                return null;
            }
            FragmentTransitionCompat21 fragmentTransitionCompat21 = FragmentTransition.PLATFORM_IMPL;
            if (obj instanceof Transition) {
                return fragmentTransitionCompat21;
            }
            FragmentTransitionImpl fragmentTransitionImpl = FragmentTransition.SUPPORT_IMPL;
            if (fragmentTransitionImpl != null && fragmentTransitionImpl.canHandle(obj)) {
                return fragmentTransitionImpl;
            }
            throw new IllegalArgumentException("Transition " + obj + " for fragment " + this.operation.fragment + " is not a valid framework Transition or AndroidX Transition");
        }
    }
}
