package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.navigation.Navigation;
import androidx.transition.Transition;
import androidx.transition.ViewUtils;
import java.util.HashMap;
/* loaded from: classes.dex */
public final class ChangeBounds extends Transition {
    public static final String[] sTransitionProperties = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};
    public static final ViewUtils.C01151 TOP_LEFT_PROPERTY = new ViewUtils.C01151(PointF.class, "topLeft", 2);
    public static final ViewUtils.C01151 BOTTOM_RIGHT_PROPERTY = new ViewUtils.C01151(PointF.class, "bottomRight", 3);
    public static final ViewUtils.C01151 BOTTOM_RIGHT_ONLY_PROPERTY = new ViewUtils.C01151(PointF.class, "bottomRight", 4);
    public static final ViewUtils.C01151 TOP_LEFT_ONLY_PROPERTY = new ViewUtils.C01151(PointF.class, "topLeft", 5);
    public static final ViewUtils.C01151 POSITION_PROPERTY = new ViewUtils.C01151(PointF.class, "position", 6);

    /* loaded from: classes.dex */
    public final class SuppressLayoutListener extends TransitionListenerAdapter {
        public boolean mCanceled = false;
        public final ViewGroup mParent;

        public SuppressLayoutListener(ViewGroup viewGroup) {
            this.mParent = viewGroup;
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public final void onTransitionCancel(Transition transition) {
            Navigation.suppressLayout(this.mParent, false);
            this.mCanceled = true;
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public final void onTransitionEnd(Transition transition) {
            if (!this.mCanceled) {
                Navigation.suppressLayout(this.mParent, false);
            }
            transition.removeListener(this);
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public final void onTransitionPause() {
            Navigation.suppressLayout(this.mParent, false);
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public final void onTransitionResume() {
            Navigation.suppressLayout(this.mParent, true);
        }
    }

    /* loaded from: classes.dex */
    public final class ViewBounds {
        public int mBottom;
        public int mBottomRightCalls;
        public int mLeft;
        public int mRight;
        public int mTop;
        public int mTopLeftCalls;
        public final View mView;

        public ViewBounds(View view) {
            this.mView = view;
        }
    }

    public static void captureValues(TransitionValues transitionValues) {
        View view = transitionValues.view;
        HashMap hashMap = transitionValues.values;
        if (view.isLaidOut() || view.getWidth() != 0 || view.getHeight() != 0) {
            hashMap.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
            hashMap.put("android:changeBounds:parent", view.getParent());
        }
    }

    @Override // androidx.transition.Transition
    public final void captureEndValues(TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    @Override // androidx.transition.Transition
    public final void captureStartValues(TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.transition.Transition
    public final Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        int i;
        ObjectAnimator objectAnimator;
        ChangeBounds changeBounds;
        if (transitionValues != null) {
            HashMap hashMap = transitionValues.values;
            if (transitionValues2 != null) {
                HashMap hashMap2 = transitionValues2.values;
                ViewGroup viewGroup2 = (ViewGroup) hashMap.get("android:changeBounds:parent");
                ViewGroup viewGroup3 = (ViewGroup) hashMap2.get("android:changeBounds:parent");
                if (!(viewGroup2 == null || viewGroup3 == null)) {
                    View view = transitionValues2.view;
                    Rect rect = (Rect) hashMap.get("android:changeBounds:bounds");
                    Rect rect2 = (Rect) hashMap2.get("android:changeBounds:bounds");
                    int i2 = rect.left;
                    int i3 = rect2.left;
                    int i4 = rect.top;
                    int i5 = rect2.top;
                    int i6 = rect.right;
                    int i7 = rect2.right;
                    int i8 = rect.bottom;
                    int i9 = rect2.bottom;
                    int i10 = i6 - i2;
                    int i11 = i8 - i4;
                    int i12 = i7 - i3;
                    int i13 = i9 - i5;
                    Rect rect3 = (Rect) hashMap.get("android:changeBounds:clip");
                    Rect rect4 = (Rect) hashMap2.get("android:changeBounds:clip");
                    if ((i10 == 0 || i11 == 0) && (i12 == 0 || i13 == 0)) {
                        i = 0;
                    } else {
                        if (i2 == i3 && i4 == i5) {
                            i = 0;
                        } else {
                            i = 1;
                        }
                        if (!(i6 == i7 && i8 == i9)) {
                            i++;
                        }
                    }
                    if ((rect3 != null && !rect3.equals(rect4)) || (rect3 == null && rect4 != null)) {
                        i++;
                    }
                    int i14 = i;
                    if (i14 > 0) {
                        ViewUtils.setLeftTopRightBottom(view, i2, i4, i6, i8);
                        if (i14 != 2) {
                            changeBounds = this;
                            if (i2 == i3 && i4 == i5) {
                                changeBounds.mPathMotion.getClass();
                                objectAnimator = ObjectAnimatorUtils$Api21Impl.ofObject(view, BOTTOM_RIGHT_ONLY_PROPERTY, Transition.C01101.getPath(i6, i8, i7, i9));
                            } else {
                                changeBounds.mPathMotion.getClass();
                                objectAnimator = ObjectAnimatorUtils$Api21Impl.ofObject(view, TOP_LEFT_ONLY_PROPERTY, Transition.C01101.getPath(i2, i4, i3, i5));
                            }
                        } else if (i10 == i12 && i11 == i13) {
                            changeBounds = this;
                            changeBounds.mPathMotion.getClass();
                            objectAnimator = ObjectAnimatorUtils$Api21Impl.ofObject(view, POSITION_PROPERTY, Transition.C01101.getPath(i2, i4, i3, i5));
                        } else {
                            changeBounds = this;
                            ViewBounds viewBounds = new ViewBounds(view);
                            changeBounds.mPathMotion.getClass();
                            ObjectAnimator ofObject = ObjectAnimatorUtils$Api21Impl.ofObject(viewBounds, TOP_LEFT_PROPERTY, Transition.C01101.getPath(i2, i4, i3, i5));
                            changeBounds.mPathMotion.getClass();
                            ObjectAnimator ofObject2 = ObjectAnimatorUtils$Api21Impl.ofObject(viewBounds, BOTTOM_RIGHT_PROPERTY, Transition.C01101.getPath(i6, i8, i7, i9));
                            AnimatorSet animatorSet = new AnimatorSet();
                            animatorSet.playTogether(ofObject, ofObject2);
                            animatorSet.addListener(new AnimatorListenerAdapter(viewBounds) { // from class: androidx.transition.ChangeBounds.6
                                private final ViewBounds mViewBounds;

                                {
                                    this.mViewBounds = viewBounds;
                                }
                            });
                            objectAnimator = animatorSet;
                        }
                        if (view.getParent() instanceof ViewGroup) {
                            ViewGroup viewGroup4 = (ViewGroup) view.getParent();
                            Navigation.suppressLayout(viewGroup4, true);
                            changeBounds.getRootTransition().addListener(new SuppressLayoutListener(viewGroup4));
                        }
                        return objectAnimator;
                    }
                }
            }
        }
        return null;
    }

    @Override // androidx.transition.Transition
    public final String[] getTransitionProperties() {
        return sTransitionProperties;
    }

    @Override // androidx.transition.Transition
    public final boolean isSeekingSupported() {
        return true;
    }
}
