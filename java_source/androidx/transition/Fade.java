package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Picture;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.transition.Transition;
import androidx.transition.TransitionUtils;
import com.emanuelef.remote_capture.C0130R;
import java.util.HashMap;
/* loaded from: classes.dex */
public final class Fade extends Transition {
    public static final String[] sTransitionProperties = {"android:visibility:visibility", "android:visibility:parent"};
    public final int mMode;

    /* loaded from: classes.dex */
    public final class FadeAnimatorListener extends AnimatorListenerAdapter implements Transition.TransitionListener {
        public boolean mLayerTypeChanged = false;
        public final View mView;

        public FadeAnimatorListener(View view) {
            this.mView = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator animator) {
            ViewUtils.IMPL.setTransitionAlpha(this.mView, 1.0f);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            onAnimationEnd(animator, false);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator animator) {
            View view = this.mView;
            if (view.hasOverlappingRendering() && view.getLayerType() == 0) {
                this.mLayerTypeChanged = true;
                view.setLayerType(2, null);
            }
        }

        @Override // androidx.transition.Transition.TransitionListener
        public final void onTransitionCancel(Transition transition) {
        }

        @Override // androidx.transition.Transition.TransitionListener
        public final void onTransitionEnd(Transition transition) {
            throw null;
        }

        @Override // androidx.transition.Transition.TransitionListener
        public final void onTransitionEnd$1(Transition transition) {
        }

        @Override // androidx.transition.Transition.TransitionListener
        public final void onTransitionPause() {
            float f;
            View view = this.mView;
            if (view.getVisibility() == 0) {
                f = ViewUtils.IMPL.getTransitionAlpha(view);
            } else {
                f = 0.0f;
            }
            view.setTag(C0130R.C0132id.transition_pause_alpha, Float.valueOf(f));
        }

        @Override // androidx.transition.Transition.TransitionListener
        public final void onTransitionResume() {
            this.mView.setTag(C0130R.C0132id.transition_pause_alpha, null);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public final void onTransitionStart(Transition transition) {
            throw null;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator, boolean z) {
            boolean z2 = this.mLayerTypeChanged;
            View view = this.mView;
            if (z2) {
                view.setLayerType(0, null);
            }
            if (!z) {
                ViewUtilsApi21 viewUtilsApi21 = ViewUtils.IMPL;
                viewUtilsApi21.setTransitionAlpha(view, 1.0f);
                viewUtilsApi21.getClass();
            }
        }

        @Override // androidx.transition.Transition.TransitionListener
        public final void onTransitionStart$1(Transition transition) {
        }
    }

    public Fade(int i) {
        this();
        this.mMode = i;
    }

    public static void captureValues$1(TransitionValues transitionValues) {
        View view = transitionValues.view;
        int visibility = view.getVisibility();
        HashMap hashMap = transitionValues.values;
        hashMap.put("android:visibility:visibility", Integer.valueOf(visibility));
        hashMap.put("android:visibility:parent", view.getParent());
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        hashMap.put("android:visibility:screenLocation", iArr);
    }

    public static float getStartAlpha(TransitionValues transitionValues, float f) {
        Float f2;
        if (transitionValues == null || (f2 = (Float) transitionValues.values.get("android:fade:transitionAlpha")) == null) {
            return f;
        }
        return f2.floatValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0059 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0035  */
    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.transition.Visibility$VisibilityInfo, java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Visibility$VisibilityInfo getVisibilityChangeInfo(TransitionValues transitionValues, TransitionValues transitionValues2) {
        ?? obj = new Object();
        obj.mVisibilityChange = false;
        obj.mFadeIn = false;
        if (transitionValues != null) {
            HashMap hashMap = transitionValues.values;
            if (hashMap.containsKey("android:visibility:visibility")) {
                obj.mStartVisibility = ((Integer) hashMap.get("android:visibility:visibility")).intValue();
                obj.mStartParent = (ViewGroup) hashMap.get("android:visibility:parent");
                if (transitionValues2 != null) {
                    HashMap hashMap2 = transitionValues2.values;
                    if (hashMap2.containsKey("android:visibility:visibility")) {
                        obj.mEndVisibility = ((Integer) hashMap2.get("android:visibility:visibility")).intValue();
                        obj.mEndParent = (ViewGroup) hashMap2.get("android:visibility:parent");
                        if (transitionValues == null && transitionValues2 != null) {
                            int i = obj.mStartVisibility;
                            int i2 = obj.mEndVisibility;
                            if (!(i == i2 && obj.mStartParent == obj.mEndParent)) {
                                if (i != i2) {
                                    if (i == 0) {
                                        obj.mFadeIn = false;
                                        obj.mVisibilityChange = true;
                                        return obj;
                                    } else if (i2 == 0) {
                                        obj.mFadeIn = true;
                                        obj.mVisibilityChange = true;
                                        return obj;
                                    }
                                } else if (obj.mEndParent == null) {
                                    obj.mFadeIn = false;
                                    obj.mVisibilityChange = true;
                                    return obj;
                                } else if (obj.mStartParent == null) {
                                    obj.mFadeIn = true;
                                    obj.mVisibilityChange = true;
                                    return obj;
                                }
                            }
                        } else if (transitionValues != null && obj.mEndVisibility == 0) {
                            obj.mFadeIn = true;
                            obj.mVisibilityChange = true;
                            return obj;
                        } else if (transitionValues2 == null && obj.mStartVisibility == 0) {
                            obj.mFadeIn = false;
                            obj.mVisibilityChange = true;
                        }
                        return obj;
                    }
                }
                obj.mEndVisibility = -1;
                obj.mEndParent = null;
                if (transitionValues == null) {
                }
                if (transitionValues != null) {
                }
                if (transitionValues2 == null) {
                    obj.mFadeIn = false;
                    obj.mVisibilityChange = true;
                }
                return obj;
            }
        }
        obj.mStartVisibility = -1;
        obj.mStartParent = null;
        if (transitionValues2 != null) {
        }
        obj.mEndVisibility = -1;
        obj.mEndParent = null;
        if (transitionValues == null) {
        }
        if (transitionValues != null) {
        }
        if (transitionValues2 == null) {
        }
        return obj;
    }

    @Override // androidx.transition.Transition
    public final void captureEndValues(TransitionValues transitionValues) {
        captureValues$1(transitionValues);
    }

    @Override // androidx.transition.Transition
    public final void captureStartValues(TransitionValues transitionValues) {
        captureValues$1(transitionValues);
        View view = transitionValues.view;
        Float f = (Float) view.getTag(C0130R.C0132id.transition_pause_alpha);
        if (f == null) {
            if (view.getVisibility() == 0) {
                f = Float.valueOf(ViewUtils.IMPL.getTransitionAlpha(view));
            } else {
                f = Float.valueOf(0.0f);
            }
        }
        transitionValues.values.put("android:fade:transitionAlpha", f);
    }

    public final ObjectAnimator createAnimation(View view, float f, float f2) {
        if (f == f2) {
            return null;
        }
        ViewUtils.IMPL.setTransitionAlpha(view, f);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, ViewUtils.TRANSITION_ALPHA, f2);
        FadeAnimatorListener fadeAnimatorListener = new FadeAnimatorListener(view);
        ofFloat.addListener(fadeAnimatorListener);
        getRootTransition().addListener(fadeAnimatorListener);
        return ofFloat;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0048, code lost:
        if (getVisibilityChangeInfo(getMatchedTransitionValues(r3, false), getTransitionValues(r3, false)).mVisibilityChange != false) goto L8;
     */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01e1  */
    @Override // androidx.transition.Transition
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        View view;
        int i;
        char c;
        char c2;
        Animator animator;
        View view2;
        boolean z;
        View view3;
        View view4;
        boolean z2;
        Bitmap bitmap;
        boolean z3;
        ViewGroup viewGroup2;
        int i2;
        Visibility$VisibilityInfo visibilityChangeInfo = getVisibilityChangeInfo(transitionValues, transitionValues2);
        if (visibilityChangeInfo.mVisibilityChange && !(visibilityChangeInfo.mStartParent == null && visibilityChangeInfo.mEndParent == null)) {
            boolean z4 = visibilityChangeInfo.mFadeIn;
            int i3 = this.mMode;
            boolean z5 = true;
            if (!z4) {
                int i4 = visibilityChangeInfo.mEndVisibility;
                if ((i3 & 2) == 2 && transitionValues != null) {
                    View view5 = transitionValues.view;
                    if (transitionValues2 != null) {
                        view = transitionValues2.view;
                    } else {
                        view = null;
                    }
                    View view6 = (View) view5.getTag(C0130R.C0132id.save_overlay_view);
                    if (view6 != null) {
                        i = i4;
                        view2 = null;
                        animator = null;
                        c2 = 0;
                        c = 1;
                    } else {
                        if (view == null || view.getParent() == null) {
                            if (view != null) {
                                view3 = null;
                                z = false;
                            }
                            view = null;
                            view3 = null;
                            z = true;
                        } else {
                            if (i4 == 4 || view5 == view) {
                                view3 = view;
                                view = null;
                                z = false;
                            }
                            view = null;
                            view3 = null;
                            z = true;
                        }
                        if (z) {
                            if (view5.getParent() == null) {
                                i = i4;
                                view2 = view3;
                                z5 = false;
                                animator = null;
                                c2 = 0;
                                c = 1;
                                view6 = view5;
                            } else if (view5.getParent() instanceof View) {
                                View view7 = (View) view5.getParent();
                                animator = null;
                                c2 = 0;
                                if (!getVisibilityChangeInfo(getTransitionValues(view7, true), getMatchedTransitionValues(view7, true)).mVisibilityChange) {
                                    boolean z6 = TransitionUtils.HAS_PICTURE_BITMAP;
                                    Matrix matrix = new Matrix();
                                    matrix.setTranslate(-view7.getScrollX(), -view7.getScrollY());
                                    ViewUtilsApi21 viewUtilsApi21 = ViewUtils.IMPL;
                                    viewUtilsApi21.transformMatrixToGlobal(view5, matrix);
                                    viewUtilsApi21.transformMatrixToLocal(viewGroup, matrix);
                                    RectF rectF = new RectF(0.0f, 0.0f, view5.getWidth(), view5.getHeight());
                                    matrix.mapRect(rectF);
                                    int round = Math.round(rectF.left);
                                    int round2 = Math.round(rectF.top);
                                    c = 1;
                                    int round3 = Math.round(rectF.right);
                                    int round4 = Math.round(rectF.bottom);
                                    ImageView imageView = new ImageView(view5.getContext());
                                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                                    boolean isAttachedToWindow = view5.isAttachedToWindow();
                                    if (viewGroup == null || !viewGroup.isAttachedToWindow()) {
                                        z2 = false;
                                    } else {
                                        z2 = true;
                                    }
                                    if (isAttachedToWindow) {
                                        z3 = isAttachedToWindow;
                                        viewGroup2 = null;
                                        i2 = 0;
                                    } else if (!z2) {
                                        i = i4;
                                        view4 = view3;
                                        bitmap = null;
                                        if (bitmap != null) {
                                            imageView.setImageBitmap(bitmap);
                                        }
                                        imageView.measure(View.MeasureSpec.makeMeasureSpec(round3 - round, 1073741824), View.MeasureSpec.makeMeasureSpec(round4 - round2, 1073741824));
                                        imageView.layout(round, round2, round3, round4);
                                        view6 = imageView;
                                        view2 = view4;
                                        z5 = false;
                                    } else {
                                        viewGroup2 = (ViewGroup) view5.getParent();
                                        int indexOfChild = viewGroup2.indexOfChild(view5);
                                        z3 = isAttachedToWindow;
                                        viewGroup.getOverlay().add(view5);
                                        i2 = indexOfChild;
                                    }
                                    view4 = view3;
                                    int round5 = Math.round(rectF.width());
                                    i = i4;
                                    int round6 = Math.round(rectF.height());
                                    if (round5 <= 0 || round6 <= 0) {
                                        bitmap = null;
                                    } else {
                                        float min = Math.min(1.0f, 1048576.0f / (round5 * round6));
                                        int round7 = Math.round(round5 * min);
                                        int round8 = Math.round(round6 * min);
                                        matrix.postTranslate(-rectF.left, -rectF.top);
                                        matrix.postScale(min, min);
                                        if (TransitionUtils.HAS_PICTURE_BITMAP) {
                                            Picture picture = new Picture();
                                            Canvas beginRecording = picture.beginRecording(round7, round8);
                                            beginRecording.concat(matrix);
                                            view5.draw(beginRecording);
                                            picture.endRecording();
                                            bitmap = TransitionUtils.Api28Impl.createBitmap(picture);
                                        } else {
                                            bitmap = Bitmap.createBitmap(round7, round8, Bitmap.Config.ARGB_8888);
                                            Canvas canvas = new Canvas(bitmap);
                                            canvas.concat(matrix);
                                            view5.draw(canvas);
                                        }
                                    }
                                    if (!z3) {
                                        viewGroup.getOverlay().remove(view5);
                                        viewGroup2.addView(view5, i2);
                                    }
                                    if (bitmap != null) {
                                    }
                                    imageView.measure(View.MeasureSpec.makeMeasureSpec(round3 - round, 1073741824), View.MeasureSpec.makeMeasureSpec(round4 - round2, 1073741824));
                                    imageView.layout(round, round2, round3, round4);
                                    view6 = imageView;
                                    view2 = view4;
                                    z5 = false;
                                } else {
                                    i = i4;
                                    view4 = view3;
                                    c = 1;
                                    int id = view7.getId();
                                    if (view7.getParent() == null && id != -1) {
                                        viewGroup.findViewById(id);
                                    }
                                    view6 = view;
                                    view2 = view4;
                                    z5 = false;
                                }
                            }
                        }
                        i = i4;
                        view4 = view3;
                        animator = null;
                        c2 = 0;
                        c = 1;
                        view6 = view;
                        view2 = view4;
                        z5 = false;
                    }
                    if (view6 != null) {
                        if (!z5) {
                            int[] iArr = (int[]) transitionValues.values.get("android:visibility:screenLocation");
                            int i5 = iArr[c2];
                            int i6 = iArr[c];
                            int[] iArr2 = new int[2];
                            viewGroup.getLocationOnScreen(iArr2);
                            view6.offsetLeftAndRight((i5 - iArr2[c2]) - view6.getLeft());
                            view6.offsetTopAndBottom((i6 - iArr2[c]) - view6.getTop());
                            viewGroup.getOverlay().add(view6);
                        }
                        ViewUtilsApi21 viewUtilsApi212 = ViewUtils.IMPL;
                        viewUtilsApi212.getClass();
                        ObjectAnimator createAnimation = createAnimation(view6, getStartAlpha(transitionValues, 1.0f), 0.0f);
                        if (createAnimation == null) {
                            viewUtilsApi212.setTransitionAlpha(view6, getStartAlpha(transitionValues2, 1.0f));
                        }
                        if (!z5) {
                            if (createAnimation == null) {
                                viewGroup.getOverlay().remove(view6);
                                return createAnimation;
                            }
                            view5.setTag(C0130R.C0132id.save_overlay_view, view6);
                            Visibility$OverlayListener visibility$OverlayListener = new Visibility$OverlayListener(this, viewGroup, view6, view5);
                            createAnimation.addListener(visibility$OverlayListener);
                            createAnimation.addPauseListener(visibility$OverlayListener);
                            getRootTransition().addListener(visibility$OverlayListener);
                        }
                        return createAnimation;
                    } else if (view2 == null) {
                        return animator;
                    } else {
                        int visibility = view2.getVisibility();
                        ViewUtils.setTransitionVisibility(view2, 0);
                        ViewUtilsApi21 viewUtilsApi213 = ViewUtils.IMPL;
                        viewUtilsApi213.getClass();
                        ObjectAnimator createAnimation2 = createAnimation(view2, getStartAlpha(transitionValues, 1.0f), 0.0f);
                        if (createAnimation2 == null) {
                            viewUtilsApi213.setTransitionAlpha(view2, getStartAlpha(transitionValues2, 1.0f));
                        }
                        if (createAnimation2 != null) {
                            Visibility$DisappearListener visibility$DisappearListener = new Visibility$DisappearListener(i, view2);
                            createAnimation2.addListener(visibility$DisappearListener);
                            getRootTransition().addListener(visibility$DisappearListener);
                            return createAnimation2;
                        }
                        ViewUtils.setTransitionVisibility(view2, visibility);
                        return createAnimation2;
                    }
                }
            } else if ((i3 & 1) == 1 && transitionValues2 != null) {
                View view8 = transitionValues2.view;
                if (transitionValues == null) {
                    View view9 = (View) view8.getParent();
                }
                ViewUtils.IMPL.getClass();
                return createAnimation(view8, getStartAlpha(transitionValues, 0.0f), 1.0f);
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

    @Override // androidx.transition.Transition
    public final boolean isTransitionRequired(TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues == null && transitionValues2 == null) {
            return false;
        }
        if (transitionValues != null && transitionValues2 != null && transitionValues2.values.containsKey("android:visibility:visibility") != transitionValues.values.containsKey("android:visibility:visibility")) {
            return false;
        }
        Visibility$VisibilityInfo visibilityChangeInfo = getVisibilityChangeInfo(transitionValues, transitionValues2);
        if (!visibilityChangeInfo.mVisibilityChange) {
            return false;
        }
        if (visibilityChangeInfo.mStartVisibility == 0 || visibilityChangeInfo.mEndVisibility == 0) {
            return true;
        }
        return false;
    }

    public Fade() {
        this.mMode = 3;
    }
}
