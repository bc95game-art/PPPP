package androidx.core.view;

import android.animation.ValueAnimator;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.WindowInsetsAnimation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import androidx.core.graphics.Insets;
import androidx.core.view.ContentInfoCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.transition.Transition;
import com.android.billingclient.api.zzam;
import com.android.billingclient.api.zzcl;
import com.emanuelef.remote_capture.R;
import j$.util.DesugarCollections;
import j$.util.Objects;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public final class WindowInsetsAnimationCompat {
    public Impl mImpl;

    /* loaded from: classes.dex */
    public abstract class Impl {
        public final long mDurationMillis;
        public float mFraction;
        public final Interpolator mInterpolator;
        public final int mTypeMask;

        public Impl(int i, Interpolator interpolator, long j) {
            this.mTypeMask = i;
            this.mInterpolator = interpolator;
            this.mDurationMillis = j;
        }

        public long getDurationMillis() {
            return this.mDurationMillis;
        }

        public float getInterpolatedFraction() {
            Interpolator interpolator = this.mInterpolator;
            if (interpolator != null) {
                return interpolator.getInterpolation(this.mFraction);
            }
            return this.mFraction;
        }

        public int getTypeMask() {
            return this.mTypeMask;
        }

        public void setFraction(float f) {
            this.mFraction = f;
        }
    }

    /* loaded from: classes.dex */
    public final class Impl21 extends Impl {
        public static final PathInterpolator SHOW_IME_INTERPOLATOR = new PathInterpolator(0.0f, 1.1f, 0.0f, 1.0f);
        public static final FastOutSlowInInterpolator HIDE_IME_INTERPOLATOR = new FastOutSlowInInterpolator(1);
        public static final DecelerateInterpolator DEFAULT_INSET_INTERPOLATOR = new DecelerateInterpolator();

        /* loaded from: classes.dex */
        public final class Impl21OnApplyWindowInsetsListener implements View.OnApplyWindowInsetsListener {
            public final ContentInfoCompat.CompatImpl mCallback;
            public WindowInsetsCompat mLastInsets;

            public Impl21OnApplyWindowInsetsListener(View view, ContentInfoCompat.CompatImpl compatImpl) {
                WindowInsetsCompat windowInsetsCompat;
                WindowInsetsCompat.BuilderImpl builderImpl;
                this.mCallback = compatImpl;
                WindowInsetsCompat rootWindowInsets = ViewCompat.getRootWindowInsets(view);
                if (rootWindowInsets != null) {
                    int i = Build.VERSION.SDK_INT;
                    if (i >= 30) {
                        builderImpl = new WindowInsetsCompat.BuilderImpl30(rootWindowInsets);
                    } else if (i >= 29) {
                        builderImpl = new WindowInsetsCompat.BuilderImpl29(rootWindowInsets);
                    } else {
                        builderImpl = new WindowInsetsCompat.BuilderImpl20(rootWindowInsets);
                    }
                    windowInsetsCompat = builderImpl.build();
                } else {
                    windowInsetsCompat = null;
                }
                this.mLastInsets = windowInsetsCompat;
            }

            @Override // android.view.View.OnApplyWindowInsetsListener
            public final WindowInsets onApplyWindowInsets(final View view, WindowInsets windowInsets) {
                Interpolator interpolator;
                if (!view.isLaidOut()) {
                    this.mLastInsets = WindowInsetsCompat.toWindowInsetsCompat(view, windowInsets);
                    return Impl21.forwardToViewIfNeeded(view, windowInsets);
                }
                final WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(view, windowInsets);
                WindowInsetsCompat.Impl impl = windowInsetsCompat.mImpl;
                if (this.mLastInsets == null) {
                    this.mLastInsets = ViewCompat.getRootWindowInsets(view);
                }
                if (this.mLastInsets == null) {
                    this.mLastInsets = windowInsetsCompat;
                    return Impl21.forwardToViewIfNeeded(view, windowInsets);
                }
                ContentInfoCompat.CompatImpl callback = Impl21.getCallback(view);
                if (callback != null && Objects.equals((WindowInsets) callback.mClip, windowInsets)) {
                    return Impl21.forwardToViewIfNeeded(view, windowInsets);
                }
                WindowInsetsCompat windowInsetsCompat2 = this.mLastInsets;
                int i = 0;
                for (int i2 = 1; i2 <= 256; i2 <<= 1) {
                    if (!impl.getInsets(i2).equals(windowInsetsCompat2.mImpl.getInsets(i2))) {
                        i |= i2;
                    }
                }
                if (i == 0) {
                    return Impl21.forwardToViewIfNeeded(view, windowInsets);
                }
                final WindowInsetsCompat windowInsetsCompat3 = this.mLastInsets;
                if ((i & 8) == 0) {
                    interpolator = Impl21.DEFAULT_INSET_INTERPOLATOR;
                } else if (impl.getInsets(8).bottom > windowInsetsCompat3.mImpl.getInsets(8).bottom) {
                    interpolator = Impl21.SHOW_IME_INTERPOLATOR;
                } else {
                    interpolator = Impl21.HIDE_IME_INTERPOLATOR;
                }
                final WindowInsetsAnimationCompat windowInsetsAnimationCompat = new WindowInsetsAnimationCompat(i, interpolator, 160L);
                windowInsetsAnimationCompat.mImpl.setFraction(0.0f);
                ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(windowInsetsAnimationCompat.mImpl.getDurationMillis());
                Insets insets = impl.getInsets(i);
                Insets insets2 = windowInsetsCompat3.mImpl.getInsets(i);
                int min = Math.min(insets.left, insets2.left);
                int i3 = insets.top;
                int i4 = insets2.top;
                int min2 = Math.min(i3, i4);
                int i5 = insets.right;
                int i6 = insets2.right;
                int min3 = Math.min(i5, i6);
                int i7 = insets.bottom;
                final int i8 = i;
                int i9 = insets2.bottom;
                zzcl zzclVar = new zzcl(Insets.of(min, min2, min3, Math.min(i7, i9)), 9, Insets.of(Math.max(insets.left, insets2.left), Math.max(i3, i4), Math.max(i5, i6), Math.max(i7, i9)));
                Impl21.dispatchOnPrepare(view, windowInsets, false);
                duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: androidx.core.view.WindowInsetsAnimationCompat.Impl21.Impl21OnApplyWindowInsetsListener.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        WindowInsetsCompat.BuilderImpl builderImpl;
                        float animatedFraction = valueAnimator.getAnimatedFraction();
                        WindowInsetsAnimationCompat windowInsetsAnimationCompat2 = WindowInsetsAnimationCompat.this;
                        Impl impl2 = windowInsetsAnimationCompat2.mImpl;
                        impl2.setFraction(animatedFraction);
                        WindowInsetsCompat windowInsetsCompat4 = windowInsetsCompat;
                        WindowInsetsCompat.Impl impl3 = windowInsetsCompat4.mImpl;
                        float interpolatedFraction = impl2.getInterpolatedFraction();
                        PathInterpolator pathInterpolator = Impl21.SHOW_IME_INTERPOLATOR;
                        int i10 = Build.VERSION.SDK_INT;
                        if (i10 >= 30) {
                            builderImpl = new WindowInsetsCompat.BuilderImpl30(windowInsetsCompat4);
                        } else if (i10 >= 29) {
                            builderImpl = new WindowInsetsCompat.BuilderImpl29(windowInsetsCompat4);
                        } else {
                            builderImpl = new WindowInsetsCompat.BuilderImpl20(windowInsetsCompat4);
                        }
                        for (int i11 = 1; i11 <= 256; i11 <<= 1) {
                            if ((i8 & i11) == 0) {
                                builderImpl.setInsets(i11, impl3.getInsets(i11));
                            } else {
                                Insets insets3 = impl3.getInsets(i11);
                                Insets insets4 = windowInsetsCompat3.mImpl.getInsets(i11);
                                float f = 1.0f - interpolatedFraction;
                                builderImpl.setInsets(i11, WindowInsetsCompat.insetInsets(insets3, (int) (((insets3.left - insets4.left) * f) + 0.5d), (int) (((insets3.top - insets4.top) * f) + 0.5d), (int) (((insets3.right - insets4.right) * f) + 0.5d), (int) (((insets3.bottom - insets4.bottom) * f) + 0.5d)));
                            }
                        }
                        Impl21.dispatchOnProgress(view, builderImpl.build(), Collections.singletonList(windowInsetsAnimationCompat2));
                    }
                });
                duration.addListener(new Transition.AnonymousClass2(view, 1, windowInsetsAnimationCompat));
                OneShotPreDrawListener.add(view, new zzam(view, windowInsetsAnimationCompat, zzclVar, duration));
                this.mLastInsets = windowInsetsCompat;
                return Impl21.forwardToViewIfNeeded(view, windowInsets);
            }
        }

        public static void dispatchOnEnd(View view) {
            ContentInfoCompat.CompatImpl callback = getCallback(view);
            if (callback != null) {
                ((View) callback.mLinkUri).setTranslationY(0.0f);
            } else if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    dispatchOnEnd(viewGroup.getChildAt(i));
                }
            }
        }

        public static void dispatchOnPrepare(View view, WindowInsets windowInsets, boolean z) {
            ContentInfoCompat.CompatImpl callback = getCallback(view);
            if (callback != null) {
                callback.mClip = windowInsets;
                if (!z) {
                    int[] iArr = (int[]) callback.mExtras;
                    ((View) callback.mLinkUri).getLocationOnScreen(iArr);
                    z = true;
                    callback.mSource = iArr[1];
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    dispatchOnPrepare(viewGroup.getChildAt(i), windowInsets, z);
                }
            }
        }

        public static void dispatchOnProgress(View view, WindowInsetsCompat windowInsetsCompat, List list) {
            ContentInfoCompat.CompatImpl callback = getCallback(view);
            if (callback != null) {
                callback.onProgress(windowInsetsCompat, list);
            } else if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    dispatchOnProgress(viewGroup.getChildAt(i), windowInsetsCompat, list);
                }
            }
        }

        public static void dispatchOnStart(View view, zzcl zzclVar) {
            ContentInfoCompat.CompatImpl callback = getCallback(view);
            if (callback != null) {
                View view2 = (View) callback.mLinkUri;
                int[] iArr = (int[]) callback.mExtras;
                view2.getLocationOnScreen(iArr);
                int i = callback.mSource - iArr[1];
                callback.mFlags = i;
                view2.setTranslationY(i);
            } else if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                    dispatchOnStart(viewGroup.getChildAt(i2), zzclVar);
                }
            }
        }

        public static WindowInsets forwardToViewIfNeeded(View view, WindowInsets windowInsets) {
            if (view.getTag(R.id.tag_on_apply_window_listener) != null) {
                return windowInsets;
            }
            return view.onApplyWindowInsets(windowInsets);
        }

        public static ContentInfoCompat.CompatImpl getCallback(View view) {
            Object tag = view.getTag(R.id.tag_window_insets_animation_callback);
            if (tag instanceof Impl21OnApplyWindowInsetsListener) {
                return ((Impl21OnApplyWindowInsetsListener) tag).mCallback;
            }
            return null;
        }
    }

    /* loaded from: classes.dex */
    public final class Impl30 extends Impl {
        public final WindowInsetsAnimation mWrapped;

        /* loaded from: classes.dex */
        public final class ProxyCallback extends WindowInsetsAnimation.Callback {
            public final HashMap mAnimations = new HashMap();
            public final ContentInfoCompat.CompatImpl mCompat;
            public List mRORunningAnimations;
            public ArrayList mTmpRunningAnimations;

            public ProxyCallback(ContentInfoCompat.CompatImpl compatImpl) {
                super(0);
                this.mCompat = compatImpl;
            }

            public final WindowInsetsAnimationCompat getWindowInsetsAnimationCompat(WindowInsetsAnimation windowInsetsAnimation) {
                WindowInsetsAnimationCompat windowInsetsAnimationCompat = (WindowInsetsAnimationCompat) this.mAnimations.get(windowInsetsAnimation);
                if (windowInsetsAnimationCompat == null) {
                    windowInsetsAnimationCompat = new WindowInsetsAnimationCompat(0, null, 0L);
                    if (Build.VERSION.SDK_INT >= 30) {
                        windowInsetsAnimationCompat.mImpl = new Impl30(windowInsetsAnimation);
                    }
                    this.mAnimations.put(windowInsetsAnimation, windowInsetsAnimationCompat);
                }
                return windowInsetsAnimationCompat;
            }

            @Override // android.view.WindowInsetsAnimation.Callback
            public final void onEnd(WindowInsetsAnimation windowInsetsAnimation) {
                ContentInfoCompat.CompatImpl compatImpl = this.mCompat;
                getWindowInsetsAnimationCompat(windowInsetsAnimation);
                ((View) compatImpl.mLinkUri).setTranslationY(0.0f);
                this.mAnimations.remove(windowInsetsAnimation);
            }

            @Override // android.view.WindowInsetsAnimation.Callback
            public final void onPrepare(WindowInsetsAnimation windowInsetsAnimation) {
                ContentInfoCompat.CompatImpl compatImpl = this.mCompat;
                getWindowInsetsAnimationCompat(windowInsetsAnimation);
                int[] iArr = (int[]) compatImpl.mExtras;
                ((View) compatImpl.mLinkUri).getLocationOnScreen(iArr);
                compatImpl.mSource = iArr[1];
            }

            @Override // android.view.WindowInsetsAnimation.Callback
            public final WindowInsets onProgress(WindowInsets windowInsets, List list) {
                ArrayList arrayList = this.mTmpRunningAnimations;
                if (arrayList == null) {
                    ArrayList arrayList2 = new ArrayList(list.size());
                    this.mTmpRunningAnimations = arrayList2;
                    this.mRORunningAnimations = DesugarCollections.unmodifiableList(arrayList2);
                } else {
                    arrayList.clear();
                }
                for (int size = list.size() - 1; size >= 0; size--) {
                    WindowInsetsAnimation windowInsetsAnimation = (WindowInsetsAnimation) list.get(size);
                    WindowInsetsAnimationCompat windowInsetsAnimationCompat = getWindowInsetsAnimationCompat(windowInsetsAnimation);
                    windowInsetsAnimationCompat.mImpl.setFraction(windowInsetsAnimation.getFraction());
                    this.mTmpRunningAnimations.add(windowInsetsAnimationCompat);
                }
                ContentInfoCompat.CompatImpl compatImpl = this.mCompat;
                WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(null, windowInsets);
                compatImpl.onProgress(windowInsetsCompat, this.mRORunningAnimations);
                return windowInsetsCompat.toWindowInsets();
            }

            @Override // android.view.WindowInsetsAnimation.Callback
            public final WindowInsetsAnimation.Bounds onStart(WindowInsetsAnimation windowInsetsAnimation, WindowInsetsAnimation.Bounds bounds) {
                ContentInfoCompat.CompatImpl compatImpl = this.mCompat;
                getWindowInsetsAnimationCompat(windowInsetsAnimation);
                Insets lowerBounds = Impl30.getLowerBounds(bounds);
                Insets higherBounds = Impl30.getHigherBounds(bounds);
                View view = (View) compatImpl.mLinkUri;
                int[] iArr = (int[]) compatImpl.mExtras;
                view.getLocationOnScreen(iArr);
                int i = compatImpl.mSource - iArr[1];
                compatImpl.mFlags = i;
                view.setTranslationY(i);
                WindowInsetsAnimationCompat$Impl30$$ExternalSyntheticApiModelOutline0.m();
                return WindowInsetsAnimationCompat$Impl30$$ExternalSyntheticApiModelOutline0.m(lowerBounds.toPlatformInsets(), higherBounds.toPlatformInsets());
            }
        }

        public Impl30(WindowInsetsAnimation windowInsetsAnimation) {
            super(0, null, 0L);
            this.mWrapped = windowInsetsAnimation;
        }

        public static Insets getHigherBounds(WindowInsetsAnimation.Bounds bounds) {
            return Insets.toCompatInsets(bounds.getUpperBound());
        }

        public static Insets getLowerBounds(WindowInsetsAnimation.Bounds bounds) {
            return Insets.toCompatInsets(bounds.getLowerBound());
        }

        public static void setCallback(View view, ContentInfoCompat.CompatImpl compatImpl) {
            view.setWindowInsetsAnimationCallback(new ProxyCallback(compatImpl));
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.Impl
        public final long getDurationMillis() {
            return this.mWrapped.getDurationMillis();
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.Impl
        public final float getInterpolatedFraction() {
            return this.mWrapped.getInterpolatedFraction();
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.Impl
        public final int getTypeMask() {
            return this.mWrapped.getTypeMask();
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.Impl
        public final void setFraction(float f) {
            this.mWrapped.setFraction(f);
        }
    }

    public WindowInsetsAnimationCompat(int i, Interpolator interpolator, long j) {
        if (Build.VERSION.SDK_INT >= 30) {
            this.mImpl = new Impl30(WindowInsetsAnimationCompat$Impl30$$ExternalSyntheticApiModelOutline0.m(i, interpolator, j));
        } else {
            this.mImpl = new Impl(i, interpolator, j);
        }
    }
}
