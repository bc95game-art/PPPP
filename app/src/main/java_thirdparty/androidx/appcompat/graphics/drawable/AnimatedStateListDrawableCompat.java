package androidx.appcompat.graphics.drawable;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.SparseArray;
import android.util.StateSet;
import androidx.collection.ArraySetKt;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import androidx.collection.internal.ContainerHelpersKt;
import androidx.core.graphics.drawable.DrawableCompat$Api21Impl;
import androidx.core.graphics.drawable.TintAwareDrawable;
import androidx.core.os.BundleKt;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
/* loaded from: classes.dex */
public final class AnimatedStateListDrawableCompat extends DrawableContainerCompat implements TintAwareDrawable {
    public boolean mMutated;
    public boolean mMutated$1;
    public AnimatedStateListState mState;
    public AnimatedStateListState mStateListState;
    public BundleKt mTransition;
    public int mTransitionToIndex = -1;
    public int mTransitionFromIndex = -1;

    /* loaded from: classes.dex */
    public final class AnimatableTransition extends BundleKt {
        public final /* synthetic */ int $r8$classId;
        public final Animatable mA;

        public /* synthetic */ AnimatableTransition(Animatable animatable, int i) {
            this.$r8$classId = i;
            this.mA = animatable;
        }

        @Override // androidx.core.os.BundleKt
        public final void start() {
            switch (this.$r8$classId) {
                case 0:
                    this.mA.start();
                    return;
                default:
                    ((AnimatedVectorDrawableCompat) this.mA).start();
                    return;
            }
        }

        @Override // androidx.core.os.BundleKt
        public final void stop() {
            switch (this.$r8$classId) {
                case 0:
                    this.mA.stop();
                    return;
                default:
                    ((AnimatedVectorDrawableCompat) this.mA).stop();
                    return;
            }
        }
    }

    /* loaded from: classes.dex */
    public final class AnimatedStateListState extends Drawable.ConstantState {
        public boolean mAutoMirrored;
        public boolean mCanConstantState;
        public int mChangingConfigurations;
        public boolean mCheckedConstantSize;
        public boolean mCheckedConstantState;
        public boolean mCheckedOpacity;
        public boolean mCheckedPadding;
        public boolean mCheckedStateful;
        public int mChildrenChangingConfigurations;
        public ColorFilter mColorFilter;
        public int mConstantHeight;
        public int mConstantMinimumHeight;
        public int mConstantMinimumWidth;
        public Rect mConstantPadding;
        public boolean mConstantSize;
        public int mConstantWidth;
        public int mDensity;
        public boolean mDither;
        public SparseArray mDrawableFutures;
        public Drawable[] mDrawables;
        public int mEnterFadeDuration;
        public int mExitFadeDuration;
        public boolean mHasColorFilter;
        public boolean mHasTintList;
        public boolean mHasTintMode;
        public int mLayoutDirection;
        public int mNumChildren;
        public int mOpacity;
        public final DrawableContainerCompat mOwner;
        public Resources mSourceRes;
        public SparseArrayCompat mStateIds;
        public int[][] mStateSets;
        public ColorStateList mTintList;
        public PorterDuff.Mode mTintMode;
        public LongSparseArray mTransitions;
        public boolean mVariablePadding;

        public AnimatedStateListState(AnimatedStateListState animatedStateListState, AnimatedStateListDrawableCompat animatedStateListDrawableCompat, Resources resources) {
            Resources resources2;
            int i;
            this.mVariablePadding = false;
            this.mConstantSize = false;
            this.mDither = true;
            this.mEnterFadeDuration = 0;
            this.mExitFadeDuration = 0;
            this.mOwner = animatedStateListDrawableCompat;
            Rect rect = null;
            if (resources != null) {
                resources2 = resources;
            } else if (animatedStateListState != null) {
                resources2 = animatedStateListState.mSourceRes;
            } else {
                resources2 = null;
            }
            this.mSourceRes = resources2;
            if (animatedStateListState != null) {
                i = animatedStateListState.mDensity;
            } else {
                i = 0;
            }
            int i2 = DrawableContainerCompat.$r8$clinit;
            i = resources != null ? resources.getDisplayMetrics().densityDpi : i;
            i = i == 0 ? 160 : i;
            this.mDensity = i;
            if (animatedStateListState != null) {
                this.mChangingConfigurations = animatedStateListState.mChangingConfigurations;
                this.mChildrenChangingConfigurations = animatedStateListState.mChildrenChangingConfigurations;
                this.mCheckedConstantState = true;
                this.mCanConstantState = true;
                this.mVariablePadding = animatedStateListState.mVariablePadding;
                this.mConstantSize = animatedStateListState.mConstantSize;
                this.mDither = animatedStateListState.mDither;
                this.mLayoutDirection = animatedStateListState.mLayoutDirection;
                this.mEnterFadeDuration = animatedStateListState.mEnterFadeDuration;
                this.mExitFadeDuration = animatedStateListState.mExitFadeDuration;
                this.mAutoMirrored = animatedStateListState.mAutoMirrored;
                this.mColorFilter = animatedStateListState.mColorFilter;
                this.mHasColorFilter = animatedStateListState.mHasColorFilter;
                this.mTintList = animatedStateListState.mTintList;
                this.mTintMode = animatedStateListState.mTintMode;
                this.mHasTintList = animatedStateListState.mHasTintList;
                this.mHasTintMode = animatedStateListState.mHasTintMode;
                if (animatedStateListState.mDensity == i) {
                    if (animatedStateListState.mCheckedPadding) {
                        this.mConstantPadding = animatedStateListState.mConstantPadding != null ? new Rect(animatedStateListState.mConstantPadding) : rect;
                        this.mCheckedPadding = true;
                    }
                    if (animatedStateListState.mCheckedConstantSize) {
                        this.mConstantWidth = animatedStateListState.mConstantWidth;
                        this.mConstantHeight = animatedStateListState.mConstantHeight;
                        this.mConstantMinimumWidth = animatedStateListState.mConstantMinimumWidth;
                        this.mConstantMinimumHeight = animatedStateListState.mConstantMinimumHeight;
                        this.mCheckedConstantSize = true;
                    }
                }
                if (animatedStateListState.mCheckedOpacity) {
                    this.mOpacity = animatedStateListState.mOpacity;
                    this.mCheckedOpacity = true;
                }
                if (animatedStateListState.mCheckedStateful) {
                    this.mCheckedStateful = true;
                }
                Drawable[] drawableArr = animatedStateListState.mDrawables;
                this.mDrawables = new Drawable[drawableArr.length];
                this.mNumChildren = animatedStateListState.mNumChildren;
                SparseArray sparseArray = animatedStateListState.mDrawableFutures;
                if (sparseArray != null) {
                    this.mDrawableFutures = sparseArray.clone();
                } else {
                    this.mDrawableFutures = new SparseArray(this.mNumChildren);
                }
                int i3 = this.mNumChildren;
                for (int i4 = 0; i4 < i3; i4++) {
                    Drawable drawable = drawableArr[i4];
                    if (drawable != null) {
                        Drawable.ConstantState constantState = drawable.getConstantState();
                        if (constantState != null) {
                            this.mDrawableFutures.put(i4, constantState);
                        } else {
                            this.mDrawables[i4] = drawableArr[i4];
                        }
                    }
                }
            } else {
                this.mDrawables = new Drawable[10];
                this.mNumChildren = 0;
            }
            if (animatedStateListState != null) {
                this.mStateSets = animatedStateListState.mStateSets;
            } else {
                this.mStateSets = new int[this.mDrawables.length];
            }
            if (animatedStateListState != null) {
                this.mTransitions = animatedStateListState.mTransitions;
                this.mStateIds = animatedStateListState.mStateIds;
                return;
            }
            this.mTransitions = new LongSparseArray();
            this.mStateIds = new SparseArrayCompat(0);
        }

        public final int addChild(Drawable drawable) {
            int i = this.mNumChildren;
            if (i >= this.mDrawables.length) {
                int i2 = i + 10;
                Drawable[] drawableArr = new Drawable[i2];
                Drawable[] drawableArr2 = this.mDrawables;
                if (drawableArr2 != null) {
                    System.arraycopy(drawableArr2, 0, drawableArr, 0, i);
                }
                this.mDrawables = drawableArr;
                int[][] iArr = new int[i2];
                System.arraycopy(this.mStateSets, 0, iArr, 0, i);
                this.mStateSets = iArr;
            }
            drawable.mutate();
            drawable.setVisible(false, true);
            drawable.setCallback(this.mOwner);
            this.mDrawables[i] = drawable;
            this.mNumChildren++;
            this.mChildrenChangingConfigurations = drawable.getChangingConfigurations() | this.mChildrenChangingConfigurations;
            this.mCheckedOpacity = false;
            this.mCheckedStateful = false;
            this.mConstantPadding = null;
            this.mCheckedPadding = false;
            this.mCheckedConstantSize = false;
            this.mCheckedConstantState = false;
            return i;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final boolean canApplyTheme() {
            int i = this.mNumChildren;
            Drawable[] drawableArr = this.mDrawables;
            for (int i2 = 0; i2 < i; i2++) {
                Drawable drawable = drawableArr[i2];
                if (drawable == null) {
                    Drawable.ConstantState constantState = (Drawable.ConstantState) this.mDrawableFutures.get(i2);
                    if (constantState != null && constantState.canApplyTheme()) {
                        return true;
                    }
                } else if (DrawableCompat$Api21Impl.canApplyTheme(drawable)) {
                    return true;
                }
            }
            return false;
        }

        public final void computeConstantSize() {
            this.mCheckedConstantSize = true;
            createAllFutures();
            int i = this.mNumChildren;
            Drawable[] drawableArr = this.mDrawables;
            this.mConstantHeight = -1;
            this.mConstantWidth = -1;
            this.mConstantMinimumHeight = 0;
            this.mConstantMinimumWidth = 0;
            for (int i2 = 0; i2 < i; i2++) {
                Drawable drawable = drawableArr[i2];
                int intrinsicWidth = drawable.getIntrinsicWidth();
                if (intrinsicWidth > this.mConstantWidth) {
                    this.mConstantWidth = intrinsicWidth;
                }
                int intrinsicHeight = drawable.getIntrinsicHeight();
                if (intrinsicHeight > this.mConstantHeight) {
                    this.mConstantHeight = intrinsicHeight;
                }
                int minimumWidth = drawable.getMinimumWidth();
                if (minimumWidth > this.mConstantMinimumWidth) {
                    this.mConstantMinimumWidth = minimumWidth;
                }
                int minimumHeight = drawable.getMinimumHeight();
                if (minimumHeight > this.mConstantMinimumHeight) {
                    this.mConstantMinimumHeight = minimumHeight;
                }
            }
        }

        public final void createAllFutures() {
            SparseArray sparseArray = this.mDrawableFutures;
            if (sparseArray != null) {
                int size = sparseArray.size();
                for (int i = 0; i < size; i++) {
                    int keyAt = this.mDrawableFutures.keyAt(i);
                    Drawable[] drawableArr = this.mDrawables;
                    Drawable newDrawable = ((Drawable.ConstantState) this.mDrawableFutures.valueAt(i)).newDrawable(this.mSourceRes);
                    if (Build.VERSION.SDK_INT >= 23) {
                        BundleKt.setLayoutDirection(newDrawable, this.mLayoutDirection);
                    }
                    Drawable mutate = newDrawable.mutate();
                    mutate.setCallback(this.mOwner);
                    drawableArr[keyAt] = mutate;
                }
                this.mDrawableFutures = null;
            }
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final int getChangingConfigurations() {
            return this.mChangingConfigurations | this.mChildrenChangingConfigurations;
        }

        public final Drawable getChild(int i) {
            int indexOfKey;
            Drawable drawable = this.mDrawables[i];
            if (drawable != null) {
                return drawable;
            }
            SparseArray sparseArray = this.mDrawableFutures;
            if (sparseArray == null || (indexOfKey = sparseArray.indexOfKey(i)) < 0) {
                return null;
            }
            Drawable newDrawable = ((Drawable.ConstantState) this.mDrawableFutures.valueAt(indexOfKey)).newDrawable(this.mSourceRes);
            if (Build.VERSION.SDK_INT >= 23) {
                BundleKt.setLayoutDirection(newDrawable, this.mLayoutDirection);
            }
            Drawable mutate = newDrawable.mutate();
            mutate.setCallback(this.mOwner);
            this.mDrawables[i] = mutate;
            this.mDrawableFutures.removeAt(indexOfKey);
            if (this.mDrawableFutures.size() == 0) {
                this.mDrawableFutures = null;
            }
            return mutate;
        }

        public final int getKeyframeIdAt(int i) {
            Object obj;
            if (i < 0) {
                return 0;
            }
            SparseArrayCompat sparseArrayCompat = this.mStateIds;
            Integer num = 0;
            int binarySearch = ContainerHelpersKt.binarySearch(sparseArrayCompat.size, i, sparseArrayCompat.keys);
            if (binarySearch >= 0 && (obj = sparseArrayCompat.values[binarySearch]) != ArraySetKt.DELETED$1) {
                num = obj;
            }
            return num.intValue();
        }

        public final int indexOfStateSet$androidx$appcompat$graphics$drawable$StateListDrawableCompat$StateListState(int[] iArr) {
            int[][] iArr2 = this.mStateSets;
            int i = this.mNumChildren;
            for (int i2 = 0; i2 < i; i2++) {
                if (StateSet.stateSetMatches(iArr2[i2], iArr)) {
                    return i2;
                }
            }
            return -1;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable() {
            return new AnimatedStateListDrawableCompat(this, null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable(Resources resources) {
            return new AnimatedStateListDrawableCompat(this, resources);
        }
    }

    /* loaded from: classes.dex */
    public final class AnimationDrawableTransition extends BundleKt {
        public final ObjectAnimator mAnim;
        public final boolean mHasReversibleFlag;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v0, types: [androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat$FrameInterpolator, android.animation.TimeInterpolator, java.lang.Object] */
        public AnimationDrawableTransition(AnimationDrawable animationDrawable, boolean z, boolean z2) {
            int i;
            int i2;
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            int i3 = z ? numberOfFrames - 1 : 0;
            if (z) {
                i = 0;
            } else {
                i = numberOfFrames - 1;
            }
            ?? obj = new Object();
            int numberOfFrames2 = animationDrawable.getNumberOfFrames();
            obj.mFrames = numberOfFrames2;
            int[] iArr = obj.mFrameTimes;
            if (iArr == null || iArr.length < numberOfFrames2) {
                obj.mFrameTimes = new int[numberOfFrames2];
            }
            int[] iArr2 = obj.mFrameTimes;
            int i4 = 0;
            for (int i5 = 0; i5 < numberOfFrames2; i5++) {
                if (z) {
                    i2 = (numberOfFrames2 - i5) - 1;
                } else {
                    i2 = i5;
                }
                int duration = animationDrawable.getDuration(i2);
                iArr2[i5] = duration;
                i4 += duration;
            }
            obj.mTotalDuration = i4;
            ObjectAnimator ofInt = ObjectAnimator.ofInt(animationDrawable, "currentIndex", i3, i);
            ofInt.setAutoCancel(true);
            ofInt.setDuration(obj.mTotalDuration);
            ofInt.setInterpolator(obj);
            this.mHasReversibleFlag = z2;
            this.mAnim = ofInt;
        }

        @Override // androidx.core.os.BundleKt
        public final boolean canReverse() {
            return this.mHasReversibleFlag;
        }

        @Override // androidx.core.os.BundleKt
        public final void reverse() {
            this.mAnim.reverse();
        }

        @Override // androidx.core.os.BundleKt
        public final void start() {
            this.mAnim.start();
        }

        @Override // androidx.core.os.BundleKt
        public final void stop() {
            this.mAnim.cancel();
        }
    }

    /* loaded from: classes.dex */
    public final class FrameInterpolator implements TimeInterpolator {
        public int[] mFrameTimes;
        public int mFrames;
        public int mTotalDuration;

        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float f) {
            float f2;
            int i = (int) ((f * this.mTotalDuration) + 0.5f);
            int i2 = this.mFrames;
            int[] iArr = this.mFrameTimes;
            int i3 = 0;
            while (i3 < i2) {
                int i4 = iArr[i3];
                if (i < i4) {
                    break;
                }
                i -= i4;
                i3++;
            }
            if (i3 < i2) {
                f2 = i / this.mTotalDuration;
            } else {
                f2 = 0.0f;
            }
            return (i3 / i2) + f2;
        }
    }

    public AnimatedStateListDrawableCompat(AnimatedStateListState animatedStateListState, Resources resources) {
        this.mAlpha = 255;
        this.mCurIndex = -1;
        setConstantState(new AnimatedStateListState(animatedStateListState, this, resources));
        onStateChange(getState());
        jumpToCurrentState();
    }

    /* JADX WARN: Code restructure failed: missing block: B:94:0x0272, code lost:
        r5.onStateChange(r5.getState());
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0279, code lost:
        return r5;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v11, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r10v14 */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r10v21 */
    /* JADX WARN: Type inference failed for: r27v0, types: [android.util.AttributeSet] */
    /* JADX WARN: Type inference failed for: r6v6, types: [android.content.res.TypedArray] */
    /* JADX WARN: Type inference failed for: r9v16, types: [android.content.res.TypedArray] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat createFromXmlInner(android.content.Context r24, android.content.res.Resources r25, android.content.res.XmlResourceParser r26, android.util.AttributeSet r27, android.content.res.Resources.Theme r28) {
        /*
            Method dump skipped, instructions count: 664
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.createFromXmlInner(android.content.Context, android.content.res.Resources, android.content.res.XmlResourceParser, android.util.AttributeSet, android.content.res.Resources$Theme):androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat");
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainerCompat, android.graphics.drawable.Drawable
    public final void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
        onStateChange(getState());
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        return true;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainerCompat, android.graphics.drawable.Drawable
    public final void jumpToCurrentState() {
        super.jumpToCurrentState();
        BundleKt bundleKt = this.mTransition;
        if (bundleKt != null) {
            bundleKt.stop();
            this.mTransition = null;
            selectDrawable(this.mTransitionToIndex);
            this.mTransitionToIndex = -1;
            this.mTransitionFromIndex = -1;
        }
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainerCompat, android.graphics.drawable.Drawable
    public final Drawable mutate() {
        if (!this.mMutated) {
            mutate$androidx$appcompat$graphics$drawable$StateListDrawableCompat();
            AnimatedStateListState animatedStateListState = this.mState;
            animatedStateListState.mTransitions = animatedStateListState.mTransitions.clone();
            animatedStateListState.mStateIds = animatedStateListState.mStateIds.clone();
            this.mMutated = true;
        }
        return this;
    }

    public final Drawable mutate$androidx$appcompat$graphics$drawable$StateListDrawableCompat() {
        if (!this.mMutated$1) {
            super.mutate();
            AnimatedStateListState animatedStateListState = this.mStateListState;
            animatedStateListState.mTransitions = animatedStateListState.mTransitions.clone();
            animatedStateListState.mStateIds = animatedStateListState.mStateIds.clone();
            this.mMutated$1 = true;
        }
        return this;
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x00d1, code lost:
        if (selectDrawable(r1) != false) goto L41;
     */
    @Override // android.graphics.drawable.Drawable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onStateChange(int[] r14) {
        /*
            Method dump skipped, instructions count: 223
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.onStateChange(int[]):boolean");
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainerCompat
    public final void setConstantState(AnimatedStateListState animatedStateListState) {
        this.mDrawableContainerState = animatedStateListState;
        int i = this.mCurIndex;
        if (i >= 0) {
            Drawable child = animatedStateListState.getChild(i);
            this.mCurrDrawable = child;
            if (child != null) {
                initializeDrawableForDisplay(child);
            }
        }
        this.mLastDrawable = null;
        this.mStateListState = animatedStateListState;
        this.mState = animatedStateListState;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainerCompat, android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        BundleKt bundleKt = this.mTransition;
        if (bundleKt != null && (visible || z2)) {
            if (z) {
                bundleKt.start();
                return visible;
            }
            jumpToCurrentState();
        }
        return visible;
    }
}
