package androidx.vectordrawable.graphics.drawable;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;
import androidx.core.content.res.CamUtils;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.drawable.DrawableCompat$Api21Impl;
import androidx.core.p002os.BundleKt;
import androidx.transition.Transition;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.floatingactionbutton.BorderDrawable;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes.dex */
public final class AnimatedVectorDrawableCompat extends VectorDrawableCommon implements Animatable {
    public static final /* synthetic */ int $r8$clinit = 0;
    public final Context mContext;
    public Transition.C01123 mAnimatorListener = null;
    public ArrayList mAnimationCallbacks = null;
    public final C01161 mCallback = new C01161(this);
    public final AnimatedVectorDrawableCompatState mAnimatedVectorState = new Drawable.ConstantState();

    /* renamed from: androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat$1 */
    /* loaded from: classes.dex */
    public final class C01161 implements Drawable.Callback {
        public final /* synthetic */ int $r8$classId = 1;
        public Object this$0;

        @Override // android.graphics.drawable.Drawable.Callback
        public final void invalidateDrawable(Drawable drawable) {
            switch (this.$r8$classId) {
                case 0:
                    ((AnimatedVectorDrawableCompat) this.this$0).invalidateSelf();
                    return;
                default:
                    return;
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            switch (this.$r8$classId) {
                case 0:
                    ((AnimatedVectorDrawableCompat) this.this$0).scheduleSelf(runnable, j);
                    return;
                default:
                    Drawable.Callback callback = (Drawable.Callback) this.this$0;
                    if (callback != null) {
                        callback.scheduleDrawable(drawable, runnable, j);
                        return;
                    }
                    return;
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            switch (this.$r8$classId) {
                case 0:
                    ((AnimatedVectorDrawableCompat) this.this$0).unscheduleSelf(runnable);
                    return;
                default:
                    Drawable.Callback callback = (Drawable.Callback) this.this$0;
                    if (callback != null) {
                        callback.unscheduleDrawable(drawable, runnable);
                        return;
                    }
                    return;
            }
        }

        public C01161(AnimatedVectorDrawableCompat animatedVectorDrawableCompat) {
            this.this$0 = animatedVectorDrawableCompat;
        }

        /* renamed from: invalidateDrawable$androidx$appcompat$graphics$drawable$DrawableContainerCompat$BlockInvalidateCallback */
        private final void m588xb5cfe610(Drawable drawable) {
        }
    }

    /* loaded from: classes.dex */
    public final class AnimatedVectorDrawableCompatState extends Drawable.ConstantState {
        public AnimatorSet mAnimatorSet;
        public ArrayList mAnimators;
        public ArrayMap mTargetNameMap;
        public VectorDrawableCompat mVectorDrawable;

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable(Resources resources) {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat$AnimatedVectorDrawableCompatState, android.graphics.drawable.Drawable$ConstantState] */
    public AnimatedVectorDrawableCompat(Context context, int i) {
        this.mContext = context;
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public final void applyTheme(Resources.Theme theme) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            DrawableCompat$Api21Impl.applyTheme(drawable, theme);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean canApplyTheme() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return DrawableCompat$Api21Impl.canApplyTheme(drawable);
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        AnimatedVectorDrawableCompatState animatedVectorDrawableCompatState = this.mAnimatedVectorState;
        animatedVectorDrawableCompatState.mVectorDrawable.draw(canvas);
        if (animatedVectorDrawableCompatState.mAnimatorSet.isStarted()) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return drawable.getAlpha();
        }
        return this.mAnimatedVectorState.mVectorDrawable.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getChangingConfigurations() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        int changingConfigurations = super.getChangingConfigurations();
        this.mAnimatedVectorState.getClass();
        return changingConfigurations;
    }

    @Override // android.graphics.drawable.Drawable
    public final ColorFilter getColorFilter() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return DrawableCompat$Api21Impl.getColorFilter(drawable);
        }
        return this.mAnimatedVectorState.mVectorDrawable.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        if (this.mDelegateDrawable == null || Build.VERSION.SDK_INT < 24) {
            return null;
        }
        return new BorderDrawable.BorderState(this.mDelegateDrawable.getConstantState());
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return this.mAnimatedVectorState.mVectorDrawable.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return this.mAnimatedVectorState.mVectorDrawable.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return this.mAnimatedVectorState.mVectorDrawable.getOpacity();
    }

    /* JADX WARN: Code restructure failed: missing block: B:79:0x0182, code lost:
        if (r8.mAnimatorSet != null) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0184, code lost:
        r8.mAnimatorSet = new android.animation.AnimatorSet();
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x018b, code lost:
        r8.mAnimatorSet.playTogether(r8.mAnimators);
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0192, code lost:
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a7  */
    /* JADX WARN: Type inference failed for: r11v9, types: [androidx.collection.SimpleArrayMap, androidx.collection.ArrayMap] */
    @Override // android.graphics.drawable.Drawable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        Animator animator;
        Throwable th;
        XmlPullParserException e;
        IOException e2;
        XmlResourceParser animation;
        VectorDrawableCompat vectorDrawableCompat;
        int next;
        VectorDrawableCompat vectorDrawableCompat2;
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            DrawableCompat$Api21Impl.inflate(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        while (true) {
            AnimatedVectorDrawableCompatState animatedVectorDrawableCompatState = this.mAnimatedVectorState;
            if (eventType == 1 || (xmlPullParser.getDepth() < depth && eventType == 3)) {
                break;
            }
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if ("animated-vector".equals(name)) {
                    TypedArray obtainAttributes = CamUtils.obtainAttributes(resources, theme, attributeSet, AndroidResources.STYLEABLE_ANIMATED_VECTOR_DRAWABLE);
                    int resourceId = obtainAttributes.getResourceId(0, 0);
                    if (resourceId != 0) {
                        PorterDuff.Mode mode = VectorDrawableCompat.DEFAULT_TINT_MODE;
                        if (Build.VERSION.SDK_INT >= 24) {
                            vectorDrawableCompat = new VectorDrawableCompat();
                            ThreadLocal threadLocal = ResourcesCompat.sTempTypedValue;
                            vectorDrawableCompat.mDelegateDrawable = ResourcesCompat.Api21Impl.getDrawable(resources, resourceId, theme);
                            new VectorDrawableCompat.VectorDrawableDelegateState(vectorDrawableCompat.mDelegateDrawable.getConstantState());
                        } else {
                            try {
                                XmlResourceParser xml = resources.getXml(resourceId);
                                AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
                                while (true) {
                                    next = xml.next();
                                    if (next == 2 || next == 1) {
                                        break;
                                    }
                                }
                                if (next != 2) {
                                    throw new XmlPullParserException("No start tag found");
                                    break;
                                } else {
                                    vectorDrawableCompat = new VectorDrawableCompat();
                                    vectorDrawableCompat.inflate(resources, xml, asAttributeSet, theme);
                                }
                            } catch (IOException e3) {
                                Log.e("VectorDrawableCompat", "parser error", e3);
                                vectorDrawableCompat = null;
                                vectorDrawableCompat.mAllowCaching = false;
                                vectorDrawableCompat.setCallback(this.mCallback);
                                vectorDrawableCompat2 = animatedVectorDrawableCompatState.mVectorDrawable;
                                if (vectorDrawableCompat2 != null) {
                                }
                                animatedVectorDrawableCompatState.mVectorDrawable = vectorDrawableCompat;
                                obtainAttributes.recycle();
                                eventType = xmlPullParser.next();
                            } catch (XmlPullParserException e4) {
                                Log.e("VectorDrawableCompat", "parser error", e4);
                                vectorDrawableCompat = null;
                                vectorDrawableCompat.mAllowCaching = false;
                                vectorDrawableCompat.setCallback(this.mCallback);
                                vectorDrawableCompat2 = animatedVectorDrawableCompatState.mVectorDrawable;
                                if (vectorDrawableCompat2 != null) {
                                }
                                animatedVectorDrawableCompatState.mVectorDrawable = vectorDrawableCompat;
                                obtainAttributes.recycle();
                                eventType = xmlPullParser.next();
                            }
                        }
                        vectorDrawableCompat.mAllowCaching = false;
                        vectorDrawableCompat.setCallback(this.mCallback);
                        vectorDrawableCompat2 = animatedVectorDrawableCompatState.mVectorDrawable;
                        if (vectorDrawableCompat2 != null) {
                            vectorDrawableCompat2.setCallback(null);
                        }
                        animatedVectorDrawableCompatState.mVectorDrawable = vectorDrawableCompat;
                    }
                    obtainAttributes.recycle();
                } else {
                    XmlResourceParser xmlResourceParser = null;
                    if ("target".equals(name)) {
                        TypedArray obtainAttributes2 = resources.obtainAttributes(attributeSet, AndroidResources.STYLEABLE_ANIMATED_VECTOR_DRAWABLE_TARGET);
                        String string = obtainAttributes2.getString(0);
                        int resourceId2 = obtainAttributes2.getResourceId(1, 0);
                        if (resourceId2 != 0) {
                            Context context = this.mContext;
                            if (context != null) {
                                if (Build.VERSION.SDK_INT >= 24) {
                                    animator = AnimatorInflater.loadAnimator(context, resourceId2);
                                } else {
                                    Resources resources2 = context.getResources();
                                    Resources.Theme theme2 = context.getTheme();
                                    try {
                                        try {
                                            animation = resources2.getAnimation(resourceId2);
                                        } catch (Throwable th2) {
                                            th = th2;
                                        }
                                    } catch (IOException e5) {
                                        e2 = e5;
                                    } catch (XmlPullParserException e6) {
                                        e = e6;
                                    }
                                    try {
                                        animator = AndroidResources.createAnimatorFromXml(context, resources2, theme2, animation, Xml.asAttributeSet(animation), null, 0);
                                        animation.close();
                                    } catch (IOException e7) {
                                        e2 = e7;
                                        Resources.NotFoundException notFoundException = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(resourceId2));
                                        notFoundException.initCause(e2);
                                        throw notFoundException;
                                    } catch (XmlPullParserException e8) {
                                        e = e8;
                                        Resources.NotFoundException notFoundException2 = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(resourceId2));
                                        notFoundException2.initCause(e);
                                        throw notFoundException2;
                                    } catch (Throwable th3) {
                                        th = th3;
                                        xmlResourceParser = animation;
                                        if (xmlResourceParser != null) {
                                            xmlResourceParser.close();
                                        }
                                        throw th;
                                    }
                                }
                                animator.setTarget(animatedVectorDrawableCompatState.mVectorDrawable.mVectorState.mVPathRenderer.mVGTargetsMap.get(string));
                                if (animatedVectorDrawableCompatState.mAnimators == null) {
                                    animatedVectorDrawableCompatState.mAnimators = new ArrayList();
                                    animatedVectorDrawableCompatState.mTargetNameMap = new SimpleArrayMap(0);
                                }
                                animatedVectorDrawableCompatState.mAnimators.add(animator);
                                animatedVectorDrawableCompatState.mTargetNameMap.put(animator, string);
                            } else {
                                obtainAttributes2.recycle();
                                throw new IllegalStateException("Context can't be null when inflating animators");
                            }
                        }
                        obtainAttributes2.recycle();
                    } else {
                        continue;
                    }
                }
            }
            eventType = xmlPullParser.next();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isAutoMirrored() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return drawable.isAutoMirrored();
        }
        return this.mAnimatedVectorState.mVectorDrawable.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Animatable
    public final boolean isRunning() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return ((AnimatedVectorDrawable) drawable).isRunning();
        }
        return this.mAnimatedVectorState.mAnimatorSet.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return drawable.isStateful();
        }
        return this.mAnimatedVectorState.mVectorDrawable.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable mutate() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            drawable.mutate();
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            drawable.setBounds(rect);
        } else {
            this.mAnimatedVectorState.mVectorDrawable.setBounds(rect);
        }
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public final boolean onLevelChange(int i) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return drawable.setLevel(i);
        }
        return this.mAnimatedVectorState.mVectorDrawable.setLevel(i);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] iArr) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        return this.mAnimatedVectorState.mVectorDrawable.setState(iArr);
    }

    public final void registerAnimationCallback(MaterialCheckBox.C01731 r3) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            AnimatedVectorDrawable animatedVectorDrawable = (AnimatedVectorDrawable) drawable;
            if (r3.mPlatformCallback == null) {
                r3.mPlatformCallback = new Animatable2Compat$AnimationCallback$1(r3);
            }
            animatedVectorDrawable.registerAnimationCallback(r3.mPlatformCallback);
        } else if (r3 != null) {
            if (this.mAnimationCallbacks == null) {
                this.mAnimationCallbacks = new ArrayList();
            }
            if (!this.mAnimationCallbacks.contains(r3)) {
                this.mAnimationCallbacks.add(r3);
                if (this.mAnimatorListener == null) {
                    this.mAnimatorListener = new Transition.C01123(3, this);
                }
                this.mAnimatedVectorState.mAnimatorSet.addListener(this.mAnimatorListener);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            drawable.setAlpha(i);
        } else {
            this.mAnimatedVectorState.mVectorDrawable.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAutoMirrored(boolean z) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            drawable.setAutoMirrored(z);
        } else {
            this.mAnimatedVectorState.mVectorDrawable.setAutoMirrored(z);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.mAnimatedVectorState.mVectorDrawable.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTint(int i) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            BundleKt.setTint(drawable, i);
        } else {
            this.mAnimatedVectorState.mVectorDrawable.setTint(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            DrawableCompat$Api21Impl.setTintList(drawable, colorStateList);
        } else {
            this.mAnimatedVectorState.mVectorDrawable.setTintList(colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            DrawableCompat$Api21Impl.setTintMode(drawable, mode);
        } else {
            this.mAnimatedVectorState.mVectorDrawable.setTintMode(mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z, boolean z2) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return drawable.setVisible(z, z2);
        }
        this.mAnimatedVectorState.mVectorDrawable.setVisible(z, z2);
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Animatable
    public final void start() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).start();
            return;
        }
        AnimatedVectorDrawableCompatState animatedVectorDrawableCompatState = this.mAnimatedVectorState;
        if (!animatedVectorDrawableCompatState.mAnimatorSet.isStarted()) {
            animatedVectorDrawableCompatState.mAnimatorSet.start();
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public final void stop() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).stop();
        } else {
            this.mAnimatedVectorState.mAnimatorSet.end();
        }
    }

    public final void unregisterAnimationCallback(MaterialCheckBox.C01731 r3) {
        Transition.C01123 r32;
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            AnimatedVectorDrawable animatedVectorDrawable = (AnimatedVectorDrawable) drawable;
            if (r3.mPlatformCallback == null) {
                r3.mPlatformCallback = new Animatable2Compat$AnimationCallback$1(r3);
            }
            animatedVectorDrawable.unregisterAnimationCallback(r3.mPlatformCallback);
        }
        ArrayList arrayList = this.mAnimationCallbacks;
        if (arrayList != null && r3 != null) {
            arrayList.remove(r3);
            if (this.mAnimationCallbacks.size() == 0 && (r32 = this.mAnimatorListener) != null) {
                this.mAnimatedVectorState.mAnimatorSet.removeListener(r32);
                this.mAnimatorListener = null;
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        inflate(resources, xmlPullParser, attributeSet, null);
    }
}
