package androidx.appcompat.graphics.drawable;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.StateSet;
import androidx.appcompat.resources.Compatibility$Api21Impl;
import androidx.appcompat.resources.R$styleable;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.collection.ArraySetKt;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import androidx.collection.internal.ContainerHelpersKt;
import androidx.core.content.res.CamUtils;
import androidx.core.graphics.drawable.DrawableCompat$Api21Impl;
import androidx.core.graphics.drawable.TintAwareDrawable;
import androidx.core.p002os.BundleKt;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import org.xmlpull.v1.XmlPullParserException;
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

        /* renamed from: mA */
        public final Animatable f0mA;

        public /* synthetic */ AnimatableTransition(Animatable animatable, int i) {
            this.$r8$classId = i;
            this.f0mA = animatable;
        }

        @Override // androidx.core.p002os.BundleKt
        public final void start() {
            switch (this.$r8$classId) {
                case 0:
                    this.f0mA.start();
                    return;
                default:
                    ((AnimatedVectorDrawableCompat) this.f0mA).start();
                    return;
            }
        }

        @Override // androidx.core.p002os.BundleKt
        public final void stop() {
            switch (this.$r8$classId) {
                case 0:
                    this.f0mA.stop();
                    return;
                default:
                    ((AnimatedVectorDrawableCompat) this.f0mA).stop();
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

        /* renamed from: indexOfStateSet$androidx$appcompat$graphics$drawable$StateListDrawableCompat$StateListState */
        public final int m628xc1ab79d6(int[] iArr) {
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

        @Override // androidx.core.p002os.BundleKt
        public final boolean canReverse() {
            return this.mHasReversibleFlag;
        }

        @Override // androidx.core.p002os.BundleKt
        public final void reverse() {
            this.mAnim.reverse();
        }

        @Override // androidx.core.p002os.BundleKt
        public final void start() {
            this.mAnim.start();
        }

        @Override // androidx.core.p002os.BundleKt
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
    /* JADX WARN: Type inference failed for: r10v11, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r10v14 */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r10v21 */
    /* JADX WARN: Type inference failed for: r27v0, types: [android.util.AttributeSet] */
    /* JADX WARN: Type inference failed for: r6v6, types: [android.content.res.TypedArray] */
    /* JADX WARN: Type inference failed for: r9v16, types: [android.content.res.TypedArray] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static AnimatedStateListDrawableCompat createFromXmlInner(Context context, Resources resources, XmlResourceParser xmlResourceParser, AttributeSet attributeSet, Resources.Theme theme) {
        int depth;
        Drawable drawable;
        long j;
        int next;
        Drawable drawable2;
        int next2;
        Context context2 = context;
        Resources resources2 = resources;
        String name = xmlResourceParser.getName();
        if (name.equals("animated-selector")) {
            AnimatedStateListDrawableCompat animatedStateListDrawableCompat = new AnimatedStateListDrawableCompat(null, null);
            TypedArray obtainAttributes = CamUtils.obtainAttributes(resources2, theme, attributeSet, R$styleable.AnimatedStateListDrawableCompat);
            int i = 1;
            animatedStateListDrawableCompat.setVisible(obtainAttributes.getBoolean(1, true), true);
            AnimatedStateListState animatedStateListState = animatedStateListDrawableCompat.mState;
            animatedStateListState.mChangingConfigurations |= Compatibility$Api21Impl.getChangingConfigurations(obtainAttributes);
            int i2 = 2;
            animatedStateListState.mVariablePadding = obtainAttributes.getBoolean(2, animatedStateListState.mVariablePadding);
            int i3 = 3;
            animatedStateListState.mConstantSize = obtainAttributes.getBoolean(3, animatedStateListState.mConstantSize);
            animatedStateListState.mEnterFadeDuration = obtainAttributes.getInt(4, animatedStateListState.mEnterFadeDuration);
            animatedStateListState.mExitFadeDuration = obtainAttributes.getInt(5, animatedStateListState.mExitFadeDuration);
            ?? r10 = 0;
            animatedStateListDrawableCompat.setDither(obtainAttributes.getBoolean(0, animatedStateListState.mDither));
            AnimatedStateListState animatedStateListState2 = animatedStateListDrawableCompat.mDrawableContainerState;
            if (resources2 != null) {
                animatedStateListState2.mSourceRes = resources2;
                int i4 = resources2.getDisplayMetrics().densityDpi;
                if (i4 == 0) {
                    i4 = 160;
                }
                int i5 = animatedStateListState2.mDensity;
                animatedStateListState2.mDensity = i4;
                if (i5 != i4) {
                    animatedStateListState2.mCheckedConstantSize = false;
                    animatedStateListState2.mCheckedPadding = false;
                }
            } else {
                animatedStateListState2.getClass();
            }
            obtainAttributes.recycle();
            int depth2 = xmlResourceParser.getDepth() + 1;
            while (true) {
                int next3 = xmlResourceParser.next();
                if (next3 == i || ((depth = xmlResourceParser.getDepth()) < depth2 && next3 == i3)) {
                    break;
                } else if (next3 == i2 && depth <= depth2) {
                    if (xmlResourceParser.getName().equals("item")) {
                        ?? obtainAttributes2 = CamUtils.obtainAttributes(resources2, theme, attributeSet, R$styleable.AnimatedStateListDrawableItem);
                        int resourceId = obtainAttributes2.getResourceId(r10, r10);
                        int resourceId2 = obtainAttributes2.getResourceId(i, -1);
                        if (resourceId2 > 0) {
                            drawable2 = ResourceManagerInternal.get().getDrawable(context2, resourceId2);
                        } else {
                            drawable2 = null;
                        }
                        obtainAttributes2.recycle();
                        int attributeCount = attributeSet.getAttributeCount();
                        int[] iArr = new int[attributeCount];
                        int i6 = 0;
                        for (int i7 = 0; i7 < attributeCount; i7++) {
                            int attributeNameResource = attributeSet.getAttributeNameResource(i7);
                            if (!(attributeNameResource == 0 || attributeNameResource == 16842960 || attributeNameResource == 16843161)) {
                                int i8 = i6 + 1;
                                if (!attributeSet.getAttributeBooleanValue(i7, r10)) {
                                    attributeNameResource = -attributeNameResource;
                                }
                                iArr[i6] = attributeNameResource;
                                i6 = i8;
                            }
                        }
                        int[] trimStateSet = StateSet.trimStateSet(iArr, i6);
                        if (drawable2 == null) {
                            do {
                                next2 = xmlResourceParser.next();
                            } while (next2 == 4);
                            if (next2 != 2) {
                                throw new XmlPullParserException(xmlResourceParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
                            } else if (xmlResourceParser.getName().equals("vector")) {
                                drawable2 = new VectorDrawableCompat();
                                drawable2.inflate(resources2, xmlResourceParser, attributeSet, theme);
                            } else {
                                drawable2 = Compatibility$Api21Impl.createFromXmlInner(resources, xmlResourceParser, attributeSet, theme);
                            }
                        }
                        if (drawable2 != null) {
                            AnimatedStateListState animatedStateListState3 = animatedStateListDrawableCompat.mState;
                            int addChild = animatedStateListState3.addChild(drawable2);
                            animatedStateListState3.mStateSets[addChild] = trimStateSet;
                            animatedStateListState3.mStateIds.put(addChild, Integer.valueOf(resourceId));
                        } else {
                            throw new XmlPullParserException(xmlResourceParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
                        }
                    } else if (xmlResourceParser.getName().equals("transition")) {
                        ?? obtainAttributes3 = CamUtils.obtainAttributes(resources2, theme, attributeSet, R$styleable.AnimatedStateListDrawableTransition);
                        int resourceId3 = obtainAttributes3.getResourceId(2, -1);
                        int resourceId4 = obtainAttributes3.getResourceId(1, -1);
                        int i9 = r10 == true ? 1 : 0;
                        int i10 = r10 == true ? 1 : 0;
                        int i11 = r10 == true ? 1 : 0;
                        int i12 = r10 == true ? 1 : 0;
                        int i13 = r10 == true ? 1 : 0;
                        int resourceId5 = obtainAttributes3.getResourceId(i9, -1);
                        if (resourceId5 > 0) {
                            drawable = ResourceManagerInternal.get().getDrawable(context2, resourceId5);
                        } else {
                            drawable = null;
                        }
                        boolean z = obtainAttributes3.getBoolean(3, r10);
                        obtainAttributes3.recycle();
                        if (drawable == null) {
                            while (true) {
                                next = xmlResourceParser.next();
                                if (next != 4) {
                                    break;
                                }
                            }
                            if (next != 2) {
                                throw new XmlPullParserException(xmlResourceParser.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
                            } else if (xmlResourceParser.getName().equals("animated-vector")) {
                                drawable = new AnimatedVectorDrawableCompat(context2, r10);
                                drawable.inflate(resources2, xmlResourceParser, attributeSet, theme);
                            } else {
                                drawable = Compatibility$Api21Impl.createFromXmlInner(resources, xmlResourceParser, attributeSet, theme);
                            }
                        }
                        if (drawable == null) {
                            throw new XmlPullParserException(xmlResourceParser.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
                        } else if (resourceId3 == -1 || resourceId4 == -1) {
                            break;
                        } else {
                            AnimatedStateListState animatedStateListState4 = animatedStateListDrawableCompat.mState;
                            int addChild2 = animatedStateListState4.addChild(drawable);
                            long j2 = resourceId3;
                            long j3 = resourceId4;
                            long j4 = (j2 << 32) | j3;
                            if (z) {
                                j = 8589934592L;
                            } else {
                                j = 0;
                            }
                            long j5 = addChild2;
                            animatedStateListState4.mTransitions.append(j4, Long.valueOf(j5 | j));
                            if (z) {
                                animatedStateListState4.mTransitions.append((j3 << 32) | j2, Long.valueOf(j5 | 4294967296L | j));
                            }
                            context2 = context;
                            resources2 = resources;
                            i = 1;
                            r10 = 0;
                            i2 = 2;
                            i3 = 3;
                        }
                    } else {
                        context2 = context;
                        resources2 = resources;
                    }
                    i = 1;
                    r10 = r10;
                    i2 = 2;
                    i3 = 3;
                }
            }
            throw new XmlPullParserException(xmlResourceParser.getPositionDescription() + ": <transition> tag requires 'fromId' & 'toId' attributes");
        }
        throw new XmlPullParserException(xmlResourceParser.getPositionDescription() + ": invalid animated-selector tag " + name);
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
            m629x1482ba24();
            AnimatedStateListState animatedStateListState = this.mState;
            animatedStateListState.mTransitions = animatedStateListState.mTransitions.clone();
            animatedStateListState.mStateIds = animatedStateListState.mStateIds.clone();
            this.mMutated = true;
        }
        return this;
    }

    /* renamed from: mutate$androidx$appcompat$graphics$drawable$StateListDrawableCompat */
    public final Drawable m629x1482ba24() {
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
    */
    public final boolean onStateChange(int[] iArr) {
        boolean z;
        BundleKt bundleKt;
        AnimatedStateListState animatedStateListState = this.mState;
        int indexOfStateSet$androidx$appcompat$graphics$drawable$StateListDrawableCompat$StateListState = animatedStateListState.m628xc1ab79d6(iArr);
        if (indexOfStateSet$androidx$appcompat$graphics$drawable$StateListDrawableCompat$StateListState < 0) {
            indexOfStateSet$androidx$appcompat$graphics$drawable$StateListDrawableCompat$StateListState = animatedStateListState.m628xc1ab79d6(StateSet.WILD_CARD);
        }
        int i = this.mCurIndex;
        boolean z2 = false;
        if (indexOfStateSet$androidx$appcompat$graphics$drawable$StateListDrawableCompat$StateListState != i) {
            BundleKt bundleKt2 = this.mTransition;
            if (bundleKt2 != null) {
                if (indexOfStateSet$androidx$appcompat$graphics$drawable$StateListDrawableCompat$StateListState != this.mTransitionToIndex) {
                    if (indexOfStateSet$androidx$appcompat$graphics$drawable$StateListDrawableCompat$StateListState != this.mTransitionFromIndex || !bundleKt2.canReverse()) {
                        i = this.mTransitionToIndex;
                        bundleKt2.stop();
                    } else {
                        bundleKt2.reverse();
                        this.mTransitionToIndex = this.mTransitionFromIndex;
                        this.mTransitionFromIndex = indexOfStateSet$androidx$appcompat$graphics$drawable$StateListDrawableCompat$StateListState;
                    }
                }
                z2 = true;
            }
            this.mTransition = null;
            this.mTransitionFromIndex = -1;
            this.mTransitionToIndex = -1;
            AnimatedStateListState animatedStateListState2 = this.mState;
            int keyframeIdAt = animatedStateListState2.getKeyframeIdAt(i);
            int keyframeIdAt2 = animatedStateListState2.getKeyframeIdAt(indexOfStateSet$androidx$appcompat$graphics$drawable$StateListDrawableCompat$StateListState);
            if (!(keyframeIdAt2 == 0 || keyframeIdAt == 0)) {
                long j = keyframeIdAt2 | (keyframeIdAt << 32);
                int longValue = (int) ((Long) animatedStateListState2.mTransitions.get$1(j)).longValue();
                if (longValue >= 0) {
                    if ((((Long) animatedStateListState2.mTransitions.get$1(j)).longValue() & 8589934592L) != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    selectDrawable(longValue);
                    Drawable drawable = this.mCurrDrawable;
                    if (drawable instanceof AnimationDrawable) {
                        if ((((Long) animatedStateListState2.mTransitions.get$1(j)).longValue() & 4294967296L) != 0) {
                            z2 = true;
                        }
                        bundleKt = new AnimationDrawableTransition((AnimationDrawable) drawable, z2, z);
                    } else if (drawable instanceof AnimatedVectorDrawableCompat) {
                        bundleKt = new AnimatableTransition((AnimatedVectorDrawableCompat) drawable, 1);
                    } else if (drawable instanceof Animatable) {
                        bundleKt = new AnimatableTransition((Animatable) drawable, 0);
                    }
                    bundleKt.start();
                    this.mTransition = bundleKt;
                    this.mTransitionFromIndex = i;
                    this.mTransitionToIndex = indexOfStateSet$androidx$appcompat$graphics$drawable$StateListDrawableCompat$StateListState;
                    z2 = true;
                }
            }
        }
        Drawable drawable2 = this.mCurrDrawable;
        if (drawable2 != null) {
            return drawable2.setState(iArr) | z2;
        }
        return z2;
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
