package androidx.appcompat.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat;
import androidx.core.graphics.drawable.DrawableCompat$Api21Impl;
import androidx.core.os.BundleKt;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import com.android.billingclient.api.zzab;
/* loaded from: classes.dex */
public abstract class DrawableContainerCompat extends Drawable implements Drawable.Callback {
    public static final /* synthetic */ int $r8$clinit = 0;
    public int mAlpha;
    public zzab mAnimationRunnable;
    public AnimatedVectorDrawableCompat.AnonymousClass1 mBlockInvalidateCallback;
    public int mCurIndex;
    public Drawable mCurrDrawable;
    public AnimatedStateListDrawableCompat.AnimatedStateListState mDrawableContainerState;
    public long mEnterAnimationEnd;
    public long mExitAnimationEnd;
    public boolean mHasAlpha;
    public Rect mHotspotBounds;
    public Drawable mLastDrawable;
    public boolean mMutated;

    /* JADX WARN: Removed duplicated region for block: B:14:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void animate(boolean r14) {
        /*
            r13 = this;
            r0 = 1
            r13.mHasAlpha = r0
            long r1 = android.os.SystemClock.uptimeMillis()
            android.graphics.drawable.Drawable r3 = r13.mCurrDrawable
            r4 = 255(0xff, double:1.26E-321)
            r6 = 0
            r8 = 0
            if (r3 == 0) goto L38
            long r9 = r13.mEnterAnimationEnd
            int r11 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
            if (r11 == 0) goto L3a
            int r11 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r11 > 0) goto L22
            int r9 = r13.mAlpha
            r3.setAlpha(r9)
            r13.mEnterAnimationEnd = r6
            goto L3a
        L22:
            long r9 = r9 - r1
            long r9 = r9 * r4
            int r10 = (int) r9
            androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat$AnimatedStateListState r9 = r13.mDrawableContainerState
            int r9 = r9.mEnterFadeDuration
            int r10 = r10 / r9
            int r9 = 255 - r10
            int r10 = r13.mAlpha
            int r9 = r9 * r10
            int r9 = r9 / 255
            r3.setAlpha(r9)
            r3 = 1
            goto L3b
        L38:
            r13.mEnterAnimationEnd = r6
        L3a:
            r3 = 0
        L3b:
            android.graphics.drawable.Drawable r9 = r13.mLastDrawable
            if (r9 == 0) goto L65
            long r10 = r13.mExitAnimationEnd
            int r12 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r12 == 0) goto L67
            int r12 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r12 > 0) goto L52
            r9.setVisible(r8, r8)
            r0 = 0
            r13.mLastDrawable = r0
            r13.mExitAnimationEnd = r6
            goto L67
        L52:
            long r10 = r10 - r1
            long r10 = r10 * r4
            int r3 = (int) r10
            androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat$AnimatedStateListState r4 = r13.mDrawableContainerState
            int r4 = r4.mExitFadeDuration
            int r3 = r3 / r4
            int r4 = r13.mAlpha
            int r3 = r3 * r4
            int r3 = r3 / 255
            r9.setAlpha(r3)
            goto L68
        L65:
            r13.mExitAnimationEnd = r6
        L67:
            r0 = r3
        L68:
            if (r14 == 0) goto L74
            if (r0 == 0) goto L74
            com.android.billingclient.api.zzab r14 = r13.mAnimationRunnable
            r3 = 16
            long r1 = r1 + r3
            r13.scheduleSelf(r14, r1)
        L74:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.graphics.drawable.DrawableContainerCompat.animate(boolean):void");
    }

    @Override // android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        AnimatedStateListDrawableCompat.AnimatedStateListState animatedStateListState = this.mDrawableContainerState;
        if (theme != null) {
            animatedStateListState.createAllFutures();
            int i = animatedStateListState.mNumChildren;
            Drawable[] drawableArr = animatedStateListState.mDrawables;
            for (int i2 = 0; i2 < i; i2++) {
                Drawable drawable = drawableArr[i2];
                if (drawable != null && DrawableCompat$Api21Impl.canApplyTheme(drawable)) {
                    DrawableCompat$Api21Impl.applyTheme(drawableArr[i2], theme);
                    animatedStateListState.mChildrenChangingConfigurations |= drawableArr[i2].getChangingConfigurations();
                }
            }
            Resources resources = theme.getResources();
            if (resources != null) {
                animatedStateListState.mSourceRes = resources;
                int i3 = resources.getDisplayMetrics().densityDpi;
                if (i3 == 0) {
                    i3 = 160;
                }
                int i4 = animatedStateListState.mDensity;
                animatedStateListState.mDensity = i3;
                if (i4 != i3) {
                    animatedStateListState.mCheckedConstantSize = false;
                    animatedStateListState.mCheckedPadding = false;
                    return;
                }
                return;
            }
            return;
        }
        animatedStateListState.getClass();
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean canApplyTheme() {
        return this.mDrawableContainerState.canApplyTheme();
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Drawable drawable = this.mCurrDrawable;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        Drawable drawable2 = this.mLastDrawable;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.mAlpha;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.mDrawableContainerState.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        boolean z;
        AnimatedStateListDrawableCompat.AnimatedStateListState animatedStateListState = this.mDrawableContainerState;
        if (!animatedStateListState.mCheckedConstantState) {
            animatedStateListState.createAllFutures();
            animatedStateListState.mCheckedConstantState = true;
            int i = animatedStateListState.mNumChildren;
            Drawable[] drawableArr = animatedStateListState.mDrawables;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    animatedStateListState.mCanConstantState = true;
                    z = true;
                    break;
                } else if (drawableArr[i2].getConstantState() == null) {
                    animatedStateListState.mCanConstantState = false;
                    z = false;
                    break;
                } else {
                    i2++;
                }
            }
        } else {
            z = animatedStateListState.mCanConstantState;
        }
        if (!z) {
            return null;
        }
        this.mDrawableContainerState.mChangingConfigurations = getChangingConfigurations();
        return this.mDrawableContainerState;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable getCurrent() {
        return this.mCurrDrawable;
    }

    @Override // android.graphics.drawable.Drawable
    public final void getHotspotBounds(Rect rect) {
        Rect rect2 = this.mHotspotBounds;
        if (rect2 != null) {
            rect.set(rect2);
        } else {
            super.getHotspotBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        AnimatedStateListDrawableCompat.AnimatedStateListState animatedStateListState = this.mDrawableContainerState;
        if (animatedStateListState.mConstantSize) {
            if (!animatedStateListState.mCheckedConstantSize) {
                animatedStateListState.computeConstantSize();
            }
            return animatedStateListState.mConstantHeight;
        }
        Drawable drawable = this.mCurrDrawable;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        AnimatedStateListDrawableCompat.AnimatedStateListState animatedStateListState = this.mDrawableContainerState;
        if (animatedStateListState.mConstantSize) {
            if (!animatedStateListState.mCheckedConstantSize) {
                animatedStateListState.computeConstantSize();
            }
            return animatedStateListState.mConstantWidth;
        }
        Drawable drawable = this.mCurrDrawable;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getMinimumHeight() {
        AnimatedStateListDrawableCompat.AnimatedStateListState animatedStateListState = this.mDrawableContainerState;
        if (animatedStateListState.mConstantSize) {
            if (!animatedStateListState.mCheckedConstantSize) {
                animatedStateListState.computeConstantSize();
            }
            return animatedStateListState.mConstantMinimumHeight;
        }
        Drawable drawable = this.mCurrDrawable;
        if (drawable != null) {
            return drawable.getMinimumHeight();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getMinimumWidth() {
        AnimatedStateListDrawableCompat.AnimatedStateListState animatedStateListState = this.mDrawableContainerState;
        if (animatedStateListState.mConstantSize) {
            if (!animatedStateListState.mCheckedConstantSize) {
                animatedStateListState.computeConstantSize();
            }
            return animatedStateListState.mConstantMinimumWidth;
        }
        Drawable drawable = this.mCurrDrawable;
        if (drawable != null) {
            return drawable.getMinimumWidth();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        Drawable drawable = this.mCurrDrawable;
        int i = -2;
        if (drawable != null && drawable.isVisible()) {
            AnimatedStateListDrawableCompat.AnimatedStateListState animatedStateListState = this.mDrawableContainerState;
            if (animatedStateListState.mCheckedOpacity) {
                return animatedStateListState.mOpacity;
            }
            animatedStateListState.createAllFutures();
            int i2 = animatedStateListState.mNumChildren;
            Drawable[] drawableArr = animatedStateListState.mDrawables;
            if (i2 > 0) {
                i = drawableArr[0].getOpacity();
            }
            for (int i3 = 1; i3 < i2; i3++) {
                i = Drawable.resolveOpacity(i, drawableArr[i3].getOpacity());
            }
            animatedStateListState.mOpacity = i;
            animatedStateListState.mCheckedOpacity = true;
        }
        return i;
    }

    @Override // android.graphics.drawable.Drawable
    public final void getOutline(Outline outline) {
        Drawable drawable = this.mCurrDrawable;
        if (drawable != null) {
            drawable.getOutline(outline);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean getPadding(Rect rect) {
        AnimatedStateListDrawableCompat.AnimatedStateListState animatedStateListState = this.mDrawableContainerState;
        Rect rect2 = null;
        boolean z = false;
        if (!animatedStateListState.mVariablePadding) {
            Rect rect3 = animatedStateListState.mConstantPadding;
            if (rect3 != null || animatedStateListState.mCheckedPadding) {
                rect2 = rect3;
            } else {
                animatedStateListState.createAllFutures();
                Rect rect4 = new Rect();
                int i = animatedStateListState.mNumChildren;
                Drawable[] drawableArr = animatedStateListState.mDrawables;
                for (int i2 = 0; i2 < i; i2++) {
                    if (drawableArr[i2].getPadding(rect4)) {
                        if (rect2 == null) {
                            rect2 = new Rect(0, 0, 0, 0);
                        }
                        int i3 = rect4.left;
                        if (i3 > rect2.left) {
                            rect2.left = i3;
                        }
                        int i4 = rect4.top;
                        if (i4 > rect2.top) {
                            rect2.top = i4;
                        }
                        int i5 = rect4.right;
                        if (i5 > rect2.right) {
                            rect2.right = i5;
                        }
                        int i6 = rect4.bottom;
                        if (i6 > rect2.bottom) {
                            rect2.bottom = i6;
                        }
                    }
                }
                animatedStateListState.mCheckedPadding = true;
                animatedStateListState.mConstantPadding = rect2;
            }
        }
        if (rect2 != null) {
            rect.set(rect2);
            if ((rect2.left | rect2.top | rect2.bottom | rect2.right) != 0) {
                z = true;
            }
        } else {
            Drawable drawable = this.mCurrDrawable;
            if (drawable != null) {
                z = drawable.getPadding(rect);
            } else {
                z = super.getPadding(rect);
            }
        }
        if (this.mDrawableContainerState.mAutoMirrored && BundleKt.getLayoutDirection(this) == 1) {
            int i7 = rect.left;
            rect.left = rect.right;
            rect.right = i7;
        }
        return z;
    }

    public final void initializeDrawableForDisplay(Drawable drawable) {
        if (this.mBlockInvalidateCallback == null) {
            this.mBlockInvalidateCallback = new AnimatedVectorDrawableCompat.AnonymousClass1();
        }
        AnimatedVectorDrawableCompat.AnonymousClass1 r0 = this.mBlockInvalidateCallback;
        r0.this$0 = drawable.getCallback();
        drawable.setCallback(r0);
        try {
            if (this.mDrawableContainerState.mEnterFadeDuration <= 0 && this.mHasAlpha) {
                drawable.setAlpha(this.mAlpha);
            }
            AnimatedStateListDrawableCompat.AnimatedStateListState animatedStateListState = this.mDrawableContainerState;
            if (animatedStateListState.mHasColorFilter) {
                drawable.setColorFilter(animatedStateListState.mColorFilter);
            } else {
                if (animatedStateListState.mHasTintList) {
                    DrawableCompat$Api21Impl.setTintList(drawable, animatedStateListState.mTintList);
                }
                AnimatedStateListDrawableCompat.AnimatedStateListState animatedStateListState2 = this.mDrawableContainerState;
                if (animatedStateListState2.mHasTintMode) {
                    DrawableCompat$Api21Impl.setTintMode(drawable, animatedStateListState2.mTintMode);
                }
            }
            drawable.setVisible(isVisible(), true);
            drawable.setDither(this.mDrawableContainerState.mDither);
            drawable.setState(getState());
            drawable.setLevel(getLevel());
            drawable.setBounds(getBounds());
            if (Build.VERSION.SDK_INT >= 23) {
                BundleKt.setLayoutDirection(drawable, BundleKt.getLayoutDirection(this));
            }
            drawable.setAutoMirrored(this.mDrawableContainerState.mAutoMirrored);
            Rect rect = this.mHotspotBounds;
            if (rect != null) {
                DrawableCompat$Api21Impl.setHotspotBounds(drawable, rect.left, rect.top, rect.right, rect.bottom);
            }
            AnimatedVectorDrawableCompat.AnonymousClass1 r1 = this.mBlockInvalidateCallback;
            r1.this$0 = null;
            drawable.setCallback((Drawable.Callback) r1.this$0);
        } catch (Throwable th) {
            AnimatedVectorDrawableCompat.AnonymousClass1 r2 = this.mBlockInvalidateCallback;
            r2.this$0 = null;
            drawable.setCallback((Drawable.Callback) r2.this$0);
            throw th;
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable drawable) {
        AnimatedStateListDrawableCompat.AnimatedStateListState animatedStateListState = this.mDrawableContainerState;
        if (animatedStateListState != null) {
            animatedStateListState.mCheckedOpacity = false;
            animatedStateListState.mCheckedStateful = false;
        }
        if (drawable == this.mCurrDrawable && getCallback() != null) {
            getCallback().invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isAutoMirrored() {
        return this.mDrawableContainerState.mAutoMirrored;
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        boolean z;
        Drawable drawable = this.mLastDrawable;
        boolean z2 = true;
        if (drawable != null) {
            drawable.jumpToCurrentState();
            this.mLastDrawable = null;
            z = true;
        } else {
            z = false;
        }
        Drawable drawable2 = this.mCurrDrawable;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
            if (this.mHasAlpha) {
                this.mCurrDrawable.setAlpha(this.mAlpha);
            }
        }
        if (this.mExitAnimationEnd != 0) {
            this.mExitAnimationEnd = 0L;
            z = true;
        }
        if (this.mEnterAnimationEnd != 0) {
            this.mEnterAnimationEnd = 0L;
        } else {
            z2 = z;
        }
        if (z2) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.mMutated && super.mutate() == this) {
            AnimatedStateListDrawableCompat animatedStateListDrawableCompat = (AnimatedStateListDrawableCompat) this;
            AnimatedStateListDrawableCompat.AnimatedStateListState animatedStateListState = new AnimatedStateListDrawableCompat.AnimatedStateListState(animatedStateListDrawableCompat.mState, animatedStateListDrawableCompat, null);
            animatedStateListState.mTransitions = animatedStateListState.mTransitions.clone();
            animatedStateListState.mStateIds = animatedStateListState.mStateIds.clone();
            setConstantState(animatedStateListState);
            this.mMutated = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        Drawable drawable = this.mLastDrawable;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        Drawable drawable2 = this.mCurrDrawable;
        if (drawable2 != null) {
            drawable2.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onLayoutDirectionChanged(int i) {
        boolean z;
        AnimatedStateListDrawableCompat.AnimatedStateListState animatedStateListState = this.mDrawableContainerState;
        int i2 = this.mCurIndex;
        int i3 = animatedStateListState.mNumChildren;
        Drawable[] drawableArr = animatedStateListState.mDrawables;
        boolean z2 = false;
        for (int i4 = 0; i4 < i3; i4++) {
            Drawable drawable = drawableArr[i4];
            if (drawable != null) {
                if (Build.VERSION.SDK_INT >= 23) {
                    z = BundleKt.setLayoutDirection(drawable, i);
                } else {
                    z = false;
                }
                if (i4 == i2) {
                    z2 = z;
                }
            }
        }
        animatedStateListState.mLayoutDirection = i;
        return z2;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onLevelChange(int i) {
        Drawable drawable = this.mLastDrawable;
        if (drawable != null) {
            return drawable.setLevel(i);
        }
        Drawable drawable2 = this.mCurrDrawable;
        if (drawable2 != null) {
            return drawable2.setLevel(i);
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        if (drawable == this.mCurrDrawable && getCallback() != null) {
            getCallback().scheduleDrawable(this, runnable, j);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0077  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean selectDrawable(int r10) {
        /*
            r9 = this;
            int r0 = r9.mCurIndex
            r1 = 0
            if (r10 != r0) goto L6
            return r1
        L6:
            long r2 = android.os.SystemClock.uptimeMillis()
            androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat$AnimatedStateListState r0 = r9.mDrawableContainerState
            int r0 = r0.mExitFadeDuration
            r4 = 0
            r5 = 0
            if (r0 <= 0) goto L2e
            android.graphics.drawable.Drawable r0 = r9.mLastDrawable
            if (r0 == 0) goto L1a
            r0.setVisible(r1, r1)
        L1a:
            android.graphics.drawable.Drawable r0 = r9.mCurrDrawable
            if (r0 == 0) goto L29
            r9.mLastDrawable = r0
            androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat$AnimatedStateListState r0 = r9.mDrawableContainerState
            int r0 = r0.mExitFadeDuration
            long r0 = (long) r0
            long r0 = r0 + r2
            r9.mExitAnimationEnd = r0
            goto L35
        L29:
            r9.mLastDrawable = r4
            r9.mExitAnimationEnd = r5
            goto L35
        L2e:
            android.graphics.drawable.Drawable r0 = r9.mCurrDrawable
            if (r0 == 0) goto L35
            r0.setVisible(r1, r1)
        L35:
            if (r10 < 0) goto L55
            androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat$AnimatedStateListState r0 = r9.mDrawableContainerState
            int r1 = r0.mNumChildren
            if (r10 >= r1) goto L55
            android.graphics.drawable.Drawable r0 = r0.getChild(r10)
            r9.mCurrDrawable = r0
            r9.mCurIndex = r10
            if (r0 == 0) goto L5a
            androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat$AnimatedStateListState r10 = r9.mDrawableContainerState
            int r10 = r10.mEnterFadeDuration
            if (r10 <= 0) goto L51
            long r7 = (long) r10
            long r2 = r2 + r7
            r9.mEnterAnimationEnd = r2
        L51:
            r9.initializeDrawableForDisplay(r0)
            goto L5a
        L55:
            r9.mCurrDrawable = r4
            r10 = -1
            r9.mCurIndex = r10
        L5a:
            long r0 = r9.mEnterAnimationEnd
            r10 = 1
            int r2 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r2 != 0) goto L67
            long r0 = r9.mExitAnimationEnd
            int r2 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r2 == 0) goto L7d
        L67:
            com.android.billingclient.api.zzab r0 = r9.mAnimationRunnable
            if (r0 != 0) goto L77
            com.android.billingclient.api.zzab r0 = new com.android.billingclient.api.zzab
            r1 = r9
            androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat r1 = (androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat) r1
            r2 = 2
            r0.<init>(r2, r1)
            r9.mAnimationRunnable = r0
            goto L7a
        L77:
            r9.unscheduleSelf(r0)
        L7a:
            r9.animate(r10)
        L7d:
            r9.invalidateSelf()
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.graphics.drawable.DrawableContainerCompat.selectDrawable(int):boolean");
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        if (!this.mHasAlpha || this.mAlpha != i) {
            this.mHasAlpha = true;
            this.mAlpha = i;
            Drawable drawable = this.mCurrDrawable;
            if (drawable == null) {
                return;
            }
            if (this.mEnterAnimationEnd == 0) {
                drawable.setAlpha(i);
            } else {
                animate(false);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAutoMirrored(boolean z) {
        AnimatedStateListDrawableCompat.AnimatedStateListState animatedStateListState = this.mDrawableContainerState;
        if (animatedStateListState.mAutoMirrored != z) {
            animatedStateListState.mAutoMirrored = z;
            Drawable drawable = this.mCurrDrawable;
            if (drawable != null) {
                drawable.setAutoMirrored(z);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        AnimatedStateListDrawableCompat.AnimatedStateListState animatedStateListState = this.mDrawableContainerState;
        animatedStateListState.mHasColorFilter = true;
        if (animatedStateListState.mColorFilter != colorFilter) {
            animatedStateListState.mColorFilter = colorFilter;
            Drawable drawable = this.mCurrDrawable;
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
        }
    }

    public abstract void setConstantState(AnimatedStateListDrawableCompat.AnimatedStateListState animatedStateListState);

    @Override // android.graphics.drawable.Drawable
    public final void setDither(boolean z) {
        AnimatedStateListDrawableCompat.AnimatedStateListState animatedStateListState = this.mDrawableContainerState;
        if (animatedStateListState.mDither != z) {
            animatedStateListState.mDither = z;
            Drawable drawable = this.mCurrDrawable;
            if (drawable != null) {
                drawable.setDither(z);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setHotspot(float f, float f2) {
        Drawable drawable = this.mCurrDrawable;
        if (drawable != null) {
            DrawableCompat$Api21Impl.setHotspot(drawable, f, f2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setHotspotBounds(int i, int i2, int i3, int i4) {
        Rect rect = this.mHotspotBounds;
        if (rect == null) {
            this.mHotspotBounds = new Rect(i, i2, i3, i4);
        } else {
            rect.set(i, i2, i3, i4);
        }
        Drawable drawable = this.mCurrDrawable;
        if (drawable != null) {
            DrawableCompat$Api21Impl.setHotspotBounds(drawable, i, i2, i3, i4);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTint(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        AnimatedStateListDrawableCompat.AnimatedStateListState animatedStateListState = this.mDrawableContainerState;
        animatedStateListState.mHasTintList = true;
        if (animatedStateListState.mTintList != colorStateList) {
            animatedStateListState.mTintList = colorStateList;
            DrawableCompat$Api21Impl.setTintList(this.mCurrDrawable, colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        AnimatedStateListDrawableCompat.AnimatedStateListState animatedStateListState = this.mDrawableContainerState;
        animatedStateListState.mHasTintMode = true;
        if (animatedStateListState.mTintMode != mode) {
            animatedStateListState.mTintMode = mode;
            DrawableCompat$Api21Impl.setTintMode(this.mCurrDrawable, mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        Drawable drawable = this.mLastDrawable;
        if (drawable != null) {
            drawable.setVisible(z, z2);
        }
        Drawable drawable2 = this.mCurrDrawable;
        if (drawable2 != null) {
            drawable2.setVisible(z, z2);
        }
        return visible;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        if (drawable == this.mCurrDrawable && getCallback() != null) {
            getCallback().unscheduleDrawable(this, runnable);
        }
    }
}
