package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatcherMatchResult;
/* loaded from: classes.dex */
public final class FragmentAnim$AnimationOrAnimator {
    public final Object animation;
    public final Cloneable animator;

    public FragmentAnim$AnimationOrAnimator(FragmentManager fragmentManager) {
        this.animation = fragmentManager;
        this.animator = new CopyOnWriteArrayList();
    }

    public void dispatchOnFragmentActivityCreated(Fragment f, boolean z) {
        Intrinsics.checkNotNullParameter(f, "f");
        Fragment fragment = ((FragmentManager) this.animation).mParent;
        if (fragment != null) {
            FragmentManager parentFragmentManager = fragment.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.mLifecycleCallbacksDispatcher.dispatchOnFragmentActivityCreated(f, true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.animator).iterator();
        while (it.hasNext()) {
            C0072x7c22a489 fragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder = (C0072x7c22a489) it.next();
            if (z) {
                fragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder.getClass();
            } else {
                MatcherMatchResult matcherMatchResult = fragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder.callback;
            }
        }
    }

    public void dispatchOnFragmentAttached(Fragment f, boolean z) {
        Intrinsics.checkNotNullParameter(f, "f");
        FragmentManager fragmentManager = (FragmentManager) this.animation;
        AppCompatActivity appCompatActivity = fragmentManager.mHost.context;
        Fragment fragment = fragmentManager.mParent;
        if (fragment != null) {
            FragmentManager parentFragmentManager = fragment.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.mLifecycleCallbacksDispatcher.dispatchOnFragmentAttached(f, true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.animator).iterator();
        while (it.hasNext()) {
            C0072x7c22a489 fragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder = (C0072x7c22a489) it.next();
            if (z) {
                fragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder.getClass();
            } else {
                MatcherMatchResult matcherMatchResult = fragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder.callback;
            }
        }
    }

    public void dispatchOnFragmentCreated(Fragment f, boolean z) {
        Intrinsics.checkNotNullParameter(f, "f");
        Fragment fragment = ((FragmentManager) this.animation).mParent;
        if (fragment != null) {
            FragmentManager parentFragmentManager = fragment.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.mLifecycleCallbacksDispatcher.dispatchOnFragmentCreated(f, true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.animator).iterator();
        while (it.hasNext()) {
            C0072x7c22a489 fragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder = (C0072x7c22a489) it.next();
            if (z) {
                fragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder.getClass();
            } else {
                MatcherMatchResult matcherMatchResult = fragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder.callback;
            }
        }
    }

    public void dispatchOnFragmentDestroyed(Fragment f, boolean z) {
        Intrinsics.checkNotNullParameter(f, "f");
        Fragment fragment = ((FragmentManager) this.animation).mParent;
        if (fragment != null) {
            FragmentManager parentFragmentManager = fragment.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.mLifecycleCallbacksDispatcher.dispatchOnFragmentDestroyed(f, true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.animator).iterator();
        while (it.hasNext()) {
            C0072x7c22a489 fragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder = (C0072x7c22a489) it.next();
            if (z) {
                fragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder.getClass();
            } else {
                MatcherMatchResult matcherMatchResult = fragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder.callback;
            }
        }
    }

    public void dispatchOnFragmentDetached(Fragment f, boolean z) {
        Intrinsics.checkNotNullParameter(f, "f");
        Fragment fragment = ((FragmentManager) this.animation).mParent;
        if (fragment != null) {
            FragmentManager parentFragmentManager = fragment.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.mLifecycleCallbacksDispatcher.dispatchOnFragmentDetached(f, true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.animator).iterator();
        while (it.hasNext()) {
            C0072x7c22a489 fragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder = (C0072x7c22a489) it.next();
            if (z) {
                fragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder.getClass();
            } else {
                MatcherMatchResult matcherMatchResult = fragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder.callback;
            }
        }
    }

    public void dispatchOnFragmentPaused(Fragment f, boolean z) {
        Intrinsics.checkNotNullParameter(f, "f");
        Fragment fragment = ((FragmentManager) this.animation).mParent;
        if (fragment != null) {
            FragmentManager parentFragmentManager = fragment.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.mLifecycleCallbacksDispatcher.dispatchOnFragmentPaused(f, true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.animator).iterator();
        while (it.hasNext()) {
            C0072x7c22a489 fragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder = (C0072x7c22a489) it.next();
            if (z) {
                fragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder.getClass();
            } else {
                MatcherMatchResult matcherMatchResult = fragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder.callback;
            }
        }
    }

    public void dispatchOnFragmentPreAttached(Fragment f, boolean z) {
        Intrinsics.checkNotNullParameter(f, "f");
        FragmentManager fragmentManager = (FragmentManager) this.animation;
        AppCompatActivity appCompatActivity = fragmentManager.mHost.context;
        Fragment fragment = fragmentManager.mParent;
        if (fragment != null) {
            FragmentManager parentFragmentManager = fragment.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.mLifecycleCallbacksDispatcher.dispatchOnFragmentPreAttached(f, true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.animator).iterator();
        while (it.hasNext()) {
            C0072x7c22a489 fragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder = (C0072x7c22a489) it.next();
            if (z) {
                fragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder.getClass();
            } else {
                MatcherMatchResult matcherMatchResult = fragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder.callback;
            }
        }
    }

    public void dispatchOnFragmentPreCreated(Fragment f, boolean z) {
        Intrinsics.checkNotNullParameter(f, "f");
        Fragment fragment = ((FragmentManager) this.animation).mParent;
        if (fragment != null) {
            FragmentManager parentFragmentManager = fragment.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.mLifecycleCallbacksDispatcher.dispatchOnFragmentPreCreated(f, true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.animator).iterator();
        while (it.hasNext()) {
            C0072x7c22a489 fragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder = (C0072x7c22a489) it.next();
            if (z) {
                fragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder.getClass();
            } else {
                MatcherMatchResult matcherMatchResult = fragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder.callback;
            }
        }
    }

    public void dispatchOnFragmentResumed(Fragment f, boolean z) {
        Intrinsics.checkNotNullParameter(f, "f");
        Fragment fragment = ((FragmentManager) this.animation).mParent;
        if (fragment != null) {
            FragmentManager parentFragmentManager = fragment.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.mLifecycleCallbacksDispatcher.dispatchOnFragmentResumed(f, true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.animator).iterator();
        while (it.hasNext()) {
            C0072x7c22a489 fragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder = (C0072x7c22a489) it.next();
            if (z) {
                fragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder.getClass();
            } else {
                MatcherMatchResult matcherMatchResult = fragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder.callback;
            }
        }
    }

    public void dispatchOnFragmentSaveInstanceState(Fragment f, Bundle bundle, boolean z) {
        Intrinsics.checkNotNullParameter(f, "f");
        Fragment fragment = ((FragmentManager) this.animation).mParent;
        if (fragment != null) {
            FragmentManager parentFragmentManager = fragment.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.mLifecycleCallbacksDispatcher.dispatchOnFragmentSaveInstanceState(f, bundle, true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.animator).iterator();
        while (it.hasNext()) {
            C0072x7c22a489 fragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder = (C0072x7c22a489) it.next();
            if (z) {
                fragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder.getClass();
            } else {
                MatcherMatchResult matcherMatchResult = fragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder.callback;
            }
        }
    }

    public void dispatchOnFragmentStarted(Fragment f, boolean z) {
        Intrinsics.checkNotNullParameter(f, "f");
        Fragment fragment = ((FragmentManager) this.animation).mParent;
        if (fragment != null) {
            FragmentManager parentFragmentManager = fragment.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.mLifecycleCallbacksDispatcher.dispatchOnFragmentStarted(f, true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.animator).iterator();
        while (it.hasNext()) {
            C0072x7c22a489 fragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder = (C0072x7c22a489) it.next();
            if (z) {
                fragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder.getClass();
            } else {
                MatcherMatchResult matcherMatchResult = fragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder.callback;
            }
        }
    }

    public void dispatchOnFragmentStopped(Fragment f, boolean z) {
        Intrinsics.checkNotNullParameter(f, "f");
        Fragment fragment = ((FragmentManager) this.animation).mParent;
        if (fragment != null) {
            FragmentManager parentFragmentManager = fragment.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.mLifecycleCallbacksDispatcher.dispatchOnFragmentStopped(f, true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.animator).iterator();
        while (it.hasNext()) {
            C0072x7c22a489 fragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder = (C0072x7c22a489) it.next();
            if (z) {
                fragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder.getClass();
            } else {
                MatcherMatchResult matcherMatchResult = fragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder.callback;
            }
        }
    }

    public void dispatchOnFragmentViewCreated(Fragment f, View v, boolean z) {
        Intrinsics.checkNotNullParameter(f, "f");
        Intrinsics.checkNotNullParameter(v, "v");
        Fragment fragment = ((FragmentManager) this.animation).mParent;
        if (fragment != null) {
            FragmentManager parentFragmentManager = fragment.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.mLifecycleCallbacksDispatcher.dispatchOnFragmentViewCreated(f, v, true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.animator).iterator();
        while (it.hasNext()) {
            C0072x7c22a489 fragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder = (C0072x7c22a489) it.next();
            if (z) {
                fragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder.getClass();
            } else {
                MatcherMatchResult matcherMatchResult = fragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder.callback;
                FragmentManager fragmentManager = (FragmentManager) this.animation;
                if (f == ((Fragment) matcherMatchResult.matcher)) {
                    FragmentAnim$AnimationOrAnimator fragmentAnim$AnimationOrAnimator = fragmentManager.mLifecycleCallbacksDispatcher;
                    fragmentAnim$AnimationOrAnimator.getClass();
                    synchronized (((CopyOnWriteArrayList) fragmentAnim$AnimationOrAnimator.animator)) {
                        int size = ((CopyOnWriteArrayList) fragmentAnim$AnimationOrAnimator.animator).size();
                        int i = 0;
                        while (true) {
                            if (i >= size) {
                                break;
                            } else if (((C0072x7c22a489) ((CopyOnWriteArrayList) fragmentAnim$AnimationOrAnimator.animator).get(i)).callback == matcherMatchResult) {
                                ((CopyOnWriteArrayList) fragmentAnim$AnimationOrAnimator.animator).remove(i);
                                break;
                            } else {
                                i++;
                            }
                        }
                    }
                    ((FragmentStateAdapter) matcherMatchResult.groups).addViewToContainer(v, (FrameLayout) matcherMatchResult.input);
                } else {
                    continue;
                }
            }
        }
    }

    public void dispatchOnFragmentViewDestroyed(Fragment f, boolean z) {
        Intrinsics.checkNotNullParameter(f, "f");
        Fragment fragment = ((FragmentManager) this.animation).mParent;
        if (fragment != null) {
            FragmentManager parentFragmentManager = fragment.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.mLifecycleCallbacksDispatcher.dispatchOnFragmentViewDestroyed(f, true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.animator).iterator();
        while (it.hasNext()) {
            C0072x7c22a489 fragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder = (C0072x7c22a489) it.next();
            if (z) {
                fragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder.getClass();
            } else {
                MatcherMatchResult matcherMatchResult = fragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder.callback;
            }
        }
    }

    public FragmentAnim$AnimationOrAnimator(Animation animation) {
        this.animation = animation;
        this.animator = null;
    }

    public FragmentAnim$AnimationOrAnimator(Animator animator) {
        this.animation = null;
        AnimatorSet animatorSet = new AnimatorSet();
        this.animator = animatorSet;
        animatorSet.play(animator);
    }
}
