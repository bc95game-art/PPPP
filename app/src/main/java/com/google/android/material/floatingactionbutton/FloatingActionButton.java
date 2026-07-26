package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.os.BundleKt;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.FastScroller;
import com.android.billingclient.api.zzca;
import com.emanuelef.remote_capture.R;
import com.google.android.material.R$styleable;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.expandable.ExpandableWidget;
import com.google.android.material.expandable.ExpandableWidgetHelper;
import com.google.android.material.floatingactionbutton.FloatingActionButtonImpl;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.internal.VisibilityAwareImageButton;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import com.google.android.material.stateful.ExtendableSavedState;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.util.ArrayList;
import kotlin.LazyKt__LazyJVMKt;
import kotlinx.coroutines.flow.ReadonlyStateFlow;
/* loaded from: classes.dex */
public class FloatingActionButton extends VisibilityAwareImageButton implements ExpandableWidget, Shapeable, CoordinatorLayout.AttachedBehavior {
    public ColorStateList backgroundTint;
    public PorterDuff.Mode backgroundTintMode;
    public boolean compatPadding;
    public int customSize;
    public final zzca imageHelper;
    public PorterDuff.Mode imageMode;
    public int imagePadding;
    public ColorStateList imageTint;
    public FloatingActionButtonImpl impl;
    public int maxImageSize;
    public ColorStateList rippleColor;
    public int size;
    public final Rect shadowPadding = new Rect();
    public final Rect touchArea = new Rect();
    public final ExpandableWidgetHelper expandableWidgetHelper = new ExpandableWidgetHelper(this);

    /* loaded from: classes.dex */
    public static class Behavior extends BaseBehavior<FloatingActionButton> {
        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    /* loaded from: classes.dex */
    public abstract class TransformationCallbackWrapper {
    }

    /* JADX WARN: Type inference failed for: r5v2, types: [com.google.android.material.floatingactionbutton.FloatingActionButtonImpl$AlwaysStatefulMaterialShapeDrawable, com.google.android.material.shape.MaterialShapeDrawable] */
    public FloatingActionButton(Context context, AttributeSet attributeSet) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, R.attr.floatingActionButtonStyle, R.style.Widget_Design_FloatingActionButton), attributeSet, R.attr.floatingActionButtonStyle);
        ColorStateList colorStateList;
        Drawable drawable;
        Drawable drawable2;
        this.userSetVisibility = getVisibility();
        Context context2 = getContext();
        TypedArray obtainStyledAttributes = ViewUtils.obtainStyledAttributes(context2, attributeSet, R$styleable.FloatingActionButton, R.attr.floatingActionButtonStyle, R.style.Widget_Design_FloatingActionButton, new int[0]);
        this.backgroundTint = LazyKt__LazyJVMKt.getColorStateList(context2, obtainStyledAttributes, 1);
        this.backgroundTintMode = ViewUtils.parseTintMode(obtainStyledAttributes.getInt(2, -1), null);
        this.rippleColor = LazyKt__LazyJVMKt.getColorStateList(context2, obtainStyledAttributes, 12);
        this.size = obtainStyledAttributes.getInt(7, -1);
        this.customSize = obtainStyledAttributes.getDimensionPixelSize(6, 0);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(3, 0);
        float dimension = obtainStyledAttributes.getDimension(4, 0.0f);
        float dimension2 = obtainStyledAttributes.getDimension(9, 0.0f);
        float dimension3 = obtainStyledAttributes.getDimension(11, 0.0f);
        this.compatPadding = obtainStyledAttributes.getBoolean(16, false);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.mtrl_fab_min_touch_target);
        setMaxImageSize(obtainStyledAttributes.getDimensionPixelSize(10, 0));
        MotionSpec createFromAttribute = MotionSpec.createFromAttribute(context2, obtainStyledAttributes, 15);
        MotionSpec createFromAttribute2 = MotionSpec.createFromAttribute(context2, obtainStyledAttributes, 8);
        TypedArray obtainStyledAttributes2 = context2.obtainStyledAttributes(attributeSet, R$styleable.MaterialShape, R.attr.floatingActionButtonStyle, R.style.Widget_Design_FloatingActionButton);
        int resourceId = obtainStyledAttributes2.getResourceId(0, 0);
        int resourceId2 = obtainStyledAttributes2.getResourceId(1, 0);
        obtainStyledAttributes2.recycle();
        ShapeAppearanceModel build = ShapeAppearanceModel.builder(context2, resourceId, resourceId2, ShapeAppearanceModel.PILL).build();
        boolean z = obtainStyledAttributes.getBoolean(5, false);
        setEnabled(obtainStyledAttributes.getBoolean(0, true));
        obtainStyledAttributes.recycle();
        zzca zzcaVar = new zzca(this);
        this.imageHelper = zzcaVar;
        zzcaVar.loadFromAttributes(attributeSet, R.attr.floatingActionButtonStyle);
        getImpl().setShapeAppearance(build);
        FloatingActionButtonImpl impl = getImpl();
        ColorStateList colorStateList2 = this.backgroundTint;
        PorterDuff.Mode mode = this.backgroundTintMode;
        ColorStateList colorStateList3 = this.rippleColor;
        FloatingActionButton floatingActionButton = impl.view;
        ShapeAppearanceModel shapeAppearanceModel = impl.shapeAppearance;
        shapeAppearanceModel.getClass();
        ?? materialShapeDrawable = new MaterialShapeDrawable(shapeAppearanceModel);
        impl.shapeDrawable = materialShapeDrawable;
        materialShapeDrawable.setTintList(colorStateList2);
        if (mode != null) {
            impl.shapeDrawable.setTintMode(mode);
        }
        impl.shapeDrawable.initializeElevationOverlay(floatingActionButton.getContext());
        if (dimensionPixelSize > 0) {
            Context context3 = floatingActionButton.getContext();
            ShapeAppearanceModel shapeAppearanceModel2 = impl.shapeAppearance;
            shapeAppearanceModel2.getClass();
            BorderDrawable borderDrawable = new BorderDrawable(shapeAppearanceModel2);
            int color = BundleKt.getColor(context3, R.color.design_fab_stroke_top_outer_color);
            int color2 = BundleKt.getColor(context3, R.color.design_fab_stroke_top_inner_color);
            colorStateList = colorStateList3;
            int color3 = BundleKt.getColor(context3, R.color.design_fab_stroke_end_inner_color);
            int color4 = BundleKt.getColor(context3, R.color.design_fab_stroke_end_outer_color);
            borderDrawable.topOuterStrokeColor = color;
            borderDrawable.topInnerStrokeColor = color2;
            borderDrawable.bottomOuterStrokeColor = color3;
            borderDrawable.bottomInnerStrokeColor = color4;
            float f = dimensionPixelSize;
            if (borderDrawable.borderWidth != f) {
                borderDrawable.borderWidth = f;
                borderDrawable.paint.setStrokeWidth(f * 1.3333f);
                borderDrawable.invalidateShader = true;
                borderDrawable.invalidateSelf();
            }
            if (colorStateList2 != null) {
                borderDrawable.currentBorderTintColor = colorStateList2.getColorForState(borderDrawable.getState(), borderDrawable.currentBorderTintColor);
            }
            borderDrawable.borderTint = colorStateList2;
            borderDrawable.invalidateShader = true;
            borderDrawable.invalidateSelf();
            impl.borderDrawable = borderDrawable;
            BorderDrawable borderDrawable2 = impl.borderDrawable;
            borderDrawable2.getClass();
            FloatingActionButtonImpl.AlwaysStatefulMaterialShapeDrawable alwaysStatefulMaterialShapeDrawable = impl.shapeDrawable;
            alwaysStatefulMaterialShapeDrawable.getClass();
            drawable = new LayerDrawable(new Drawable[]{borderDrawable2, alwaysStatefulMaterialShapeDrawable});
            drawable2 = null;
        } else {
            colorStateList = colorStateList3;
            drawable2 = null;
            impl.borderDrawable = null;
            drawable = impl.shapeDrawable;
        }
        RippleDrawable rippleDrawable = new RippleDrawable(RippleUtils.sanitizeRippleDrawableColor(colorStateList), drawable, drawable2);
        impl.rippleDrawable = rippleDrawable;
        impl.contentBackground = rippleDrawable;
        getImpl().minTouchTargetSize = dimensionPixelSize2;
        FloatingActionButtonImpl impl2 = getImpl();
        if (impl2.elevation != dimension) {
            impl2.elevation = dimension;
            impl2.onElevationsChanged(dimension, impl2.hoveredFocusedTranslationZ, impl2.pressedTranslationZ);
        }
        FloatingActionButtonImpl impl3 = getImpl();
        if (impl3.hoveredFocusedTranslationZ != dimension2) {
            impl3.hoveredFocusedTranslationZ = dimension2;
            impl3.onElevationsChanged(impl3.elevation, dimension2, impl3.pressedTranslationZ);
        }
        FloatingActionButtonImpl impl4 = getImpl();
        if (impl4.pressedTranslationZ != dimension3) {
            impl4.pressedTranslationZ = dimension3;
            impl4.onElevationsChanged(impl4.elevation, impl4.hoveredFocusedTranslationZ, dimension3);
        }
        getImpl().showMotionSpec = createFromAttribute;
        getImpl().hideMotionSpec = createFromAttribute2;
        getImpl().ensureMinTouchTargetSize = z;
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    private FloatingActionButtonImpl getImpl() {
        if (this.impl == null) {
            this.impl = new FloatingActionButtonImpl(this, new ReadonlyStateFlow(this));
        }
        return this.impl;
    }

    @Override // android.widget.ImageView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        if (Build.VERSION.SDK_INT == 21) {
            FloatingActionButtonImpl impl = getImpl();
            FloatingActionButton floatingActionButton = impl.view;
            if (floatingActionButton.isEnabled()) {
                floatingActionButton.setElevation(impl.elevation);
                if (floatingActionButton.isPressed()) {
                    floatingActionButton.setTranslationZ(impl.pressedTranslationZ);
                } else if (floatingActionButton.isFocused() || floatingActionButton.isHovered()) {
                    floatingActionButton.setTranslationZ(impl.hoveredFocusedTranslationZ);
                } else {
                    floatingActionButton.setTranslationZ(0.0f);
                }
            } else {
                floatingActionButton.setElevation(0.0f);
                floatingActionButton.setTranslationZ(0.0f);
            }
        }
    }

    @Override // android.widget.ImageButton, android.widget.ImageView, android.view.View
    public CharSequence getAccessibilityClassName() {
        return "com.google.android.material.floatingactionbutton.FloatingActionButton";
    }

    @Override // android.view.View
    public ColorStateList getBackgroundTintList() {
        return this.backgroundTint;
    }

    @Override // android.view.View
    public PorterDuff.Mode getBackgroundTintMode() {
        return this.backgroundTintMode;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    public CoordinatorLayout.Behavior getBehavior() {
        return new Behavior();
    }

    public float getCompatElevation() {
        return getImpl().view.getElevation();
    }

    public float getCompatHoveredFocusedTranslationZ() {
        return getImpl().hoveredFocusedTranslationZ;
    }

    public float getCompatPressedTranslationZ() {
        return getImpl().pressedTranslationZ;
    }

    public Drawable getContentBackground() {
        return getImpl().contentBackground;
    }

    public int getCustomSize() {
        return this.customSize;
    }

    public int getExpandedComponentIdHint() {
        return this.expandableWidgetHelper.expandedComponentIdHint;
    }

    public MotionSpec getHideMotionSpec() {
        return getImpl().hideMotionSpec;
    }

    @Deprecated
    public int getRippleColor() {
        ColorStateList colorStateList = this.rippleColor;
        if (colorStateList != null) {
            return colorStateList.getDefaultColor();
        }
        return 0;
    }

    public ColorStateList getRippleColorStateList() {
        return this.rippleColor;
    }

    public ShapeAppearanceModel getShapeAppearanceModel() {
        ShapeAppearanceModel shapeAppearanceModel = getImpl().shapeAppearance;
        shapeAppearanceModel.getClass();
        return shapeAppearanceModel;
    }

    public MotionSpec getShowMotionSpec() {
        return getImpl().showMotionSpec;
    }

    public int getSize() {
        return this.size;
    }

    public int getSizeDimension() {
        return getSizeDimension(this.size);
    }

    public ColorStateList getSupportBackgroundTintList() {
        return getBackgroundTintList();
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return getBackgroundTintMode();
    }

    public ColorStateList getSupportImageTintList() {
        return this.imageTint;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        return this.imageMode;
    }

    public boolean getUseCompatPadding() {
        return this.compatPadding;
    }

    public final void hide(final boolean z) {
        int i;
        AnimatorSet animatorSet;
        final FloatingActionButtonImpl impl = getImpl();
        FloatingActionButton floatingActionButton = impl.view;
        if (floatingActionButton.getVisibility() == 0) {
            if (impl.animState == 1) {
                return;
            }
        } else if (impl.animState != 2) {
            return;
        }
        Animator animator = impl.currentAnimator;
        if (animator != null) {
            animator.cancel();
        }
        FloatingActionButton floatingActionButton2 = impl.view;
        if (!floatingActionButton2.isLaidOut() || floatingActionButton2.isInEditMode()) {
            if (z) {
                i = 8;
            } else {
                i = 4;
            }
            floatingActionButton.internalSetVisibility(i, z);
            return;
        }
        MotionSpec motionSpec = impl.hideMotionSpec;
        if (motionSpec != null) {
            animatorSet = impl.createAnimator(motionSpec, 0.0f, 0.0f, 0.0f);
        } else {
            animatorSet = impl.createDefaultAnimator(0.0f, 0.4f, 0.4f, FloatingActionButtonImpl.HIDE_ANIM_DURATION_ATTR, FloatingActionButtonImpl.HIDE_ANIM_EASING_ATTR);
        }
        animatorSet.addListener(
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x004b: INVOKE  
              (r1v2 'animatorSet' android.animation.AnimatorSet)
              (wrap: android.animation.AnimatorListenerAdapter : 0x0048: CONSTRUCTOR  (r2v4 android.animation.AnimatorListenerAdapter A[REMOVE]) = 
              (r0v0 'impl' com.google.android.material.floatingactionbutton.FloatingActionButtonImpl A[DONT_INLINE])
              (r7v0 'z' boolean A[DONT_INLINE])
             call: com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.1.<init>(com.google.android.material.floatingactionbutton.FloatingActionButtonImpl, boolean):void type: CONSTRUCTOR)
             type: VIRTUAL call: android.animation.Animator.addListener(android.animation.Animator$AnimatorListener):void in method: com.google.android.material.floatingactionbutton.FloatingActionButton.hide(boolean):void, file: classes.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:280)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:243)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:90)
            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
            	at jadx.core.dex.regions.Region.generate(Region.java:35)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
            	at jadx.core.dex.regions.Region.generate(Region.java:35)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
            	at jadx.core.dex.regions.Region.generate(Region.java:35)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:286)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:265)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:369)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:304)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:270)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.google.android.material.floatingactionbutton.FloatingActionButtonImpl, state: NOT_LOADED
            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:302)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:689)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:388)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:142)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:118)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:105)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1017)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:828)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:392)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
            	... 19 more
            */
        /*
            this = this;
            com.google.android.material.floatingactionbutton.FloatingActionButtonImpl r0 = r6.getImpl()
            com.google.android.material.floatingactionbutton.FloatingActionButton r1 = r0.view
            int r2 = r1.getVisibility()
            if (r2 != 0) goto L12
            int r2 = r0.animState
            r3 = 1
            if (r2 != r3) goto L18
            goto L17
        L12:
            int r2 = r0.animState
            r3 = 2
            if (r2 == r3) goto L18
        L17:
            return
        L18:
            android.animation.Animator r2 = r0.currentAnimator
            if (r2 == 0) goto L1f
            r2.cancel()
        L1f:
            com.google.android.material.floatingactionbutton.FloatingActionButton r2 = r0.view
            boolean r3 = r2.isLaidOut()
            if (r3 == 0) goto L52
            boolean r2 = r2.isInEditMode()
            if (r2 != 0) goto L52
            com.google.android.material.animation.MotionSpec r1 = r0.hideMotionSpec
            if (r1 == 0) goto L37
            r2 = 0
            android.animation.AnimatorSet r1 = r0.createAnimator(r1, r2, r2, r2)
            goto L46
        L37:
            int r4 = com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.HIDE_ANIM_DURATION_ATTR
            int r5 = com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.HIDE_ANIM_EASING_ATTR
            r1 = 0
            r2 = 1053609165(0x3ecccccd, float:0.4)
            r3 = 1053609165(0x3ecccccd, float:0.4)
            android.animation.AnimatorSet r1 = r0.createDefaultAnimator(r1, r2, r3, r4, r5)
        L46:
            com.google.android.material.floatingactionbutton.FloatingActionButtonImpl$1 r2 = new com.google.android.material.floatingactionbutton.FloatingActionButtonImpl$1
            r2.<init>(r0, r7)
            r1.addListener(r2)
            r1.start()
            return
        L52:
            if (r7 == 0) goto L57
            r0 = 8
            goto L58
        L57:
            r0 = 4
        L58:
            r1.internalSetVisibility(r0, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.floatingactionbutton.FloatingActionButton.hide(boolean):void");
    }

    public final void onApplySupportImageTint() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            ColorStateList colorStateList = this.imageTint;
            if (colorStateList == null) {
                BundleKt.clearColorFilter(drawable);
                return;
            }
            int colorForState = colorStateList.getColorForState(getDrawableState(), 0);
            PorterDuff.Mode mode = this.imageMode;
            if (mode == null) {
                mode = PorterDuff.Mode.SRC_IN;
            }
            drawable.mutate().setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(colorForState, mode));
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        FloatingActionButtonImpl impl = getImpl();
        FloatingActionButtonImpl.AlwaysStatefulMaterialShapeDrawable alwaysStatefulMaterialShapeDrawable = impl.shapeDrawable;
        if (alwaysStatefulMaterialShapeDrawable != null) {
            LazyKt__LazyJVMKt.setParentAbsoluteElevation(impl.view, alwaysStatefulMaterialShapeDrawable);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getImpl().view.getViewTreeObserver();
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onMeasure(int i, int i2) {
        int sizeDimension = getSizeDimension();
        this.imagePadding = (sizeDimension - this.maxImageSize) / 2;
        getImpl().updatePadding();
        int min = Math.min(View.resolveSize(sizeDimension, i), View.resolveSize(sizeDimension, i2));
        Rect rect = this.shadowPadding;
        setMeasuredDimension(rect.left + min + rect.right, min + rect.top + rect.bottom);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof ExtendableSavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        ExtendableSavedState extendableSavedState = (ExtendableSavedState) parcelable;
        super.onRestoreInstanceState(extendableSavedState.mSuperState);
        Bundle bundle = (Bundle) extendableSavedState.extendableStates.get("expandableWidgetHelper");
        bundle.getClass();
        ExpandableWidgetHelper expandableWidgetHelper = this.expandableWidgetHelper;
        expandableWidgetHelper.getClass();
        expandableWidgetHelper.expanded = bundle.getBoolean("expanded", false);
        expandableWidgetHelper.expandedComponentIdHint = bundle.getInt("expandedComponentIdHint", 0);
        if (expandableWidgetHelper.expanded) {
            FloatingActionButton floatingActionButton = (FloatingActionButton) expandableWidgetHelper.widget;
            ViewParent parent = floatingActionButton.getParent();
            if (parent instanceof CoordinatorLayout) {
                ((CoordinatorLayout) parent).dispatchDependentViewsChanged(floatingActionButton);
            }
        }
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        if (onSaveInstanceState == null) {
            onSaveInstanceState = new Bundle();
        }
        ExtendableSavedState extendableSavedState = new ExtendableSavedState(onSaveInstanceState);
        ExpandableWidgetHelper expandableWidgetHelper = this.expandableWidgetHelper;
        expandableWidgetHelper.getClass();
        Bundle bundle = new Bundle();
        bundle.putBoolean("expanded", expandableWidgetHelper.expanded);
        bundle.putInt("expandedComponentIdHint", expandableWidgetHelper.expandedComponentIdHint);
        extendableSavedState.extendableStates.put("expandableWidgetHelper", bundle);
        return extendableSavedState;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int i;
        if (motionEvent.getAction() == 0) {
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            Rect rect = this.touchArea;
            rect.set(0, 0, measuredWidth, measuredHeight);
            int i2 = rect.left;
            Rect rect2 = this.shadowPadding;
            rect.left = i2 + rect2.left;
            rect.top += rect2.top;
            rect.right -= rect2.right;
            rect.bottom -= rect2.bottom;
            FloatingActionButtonImpl floatingActionButtonImpl = this.impl;
            if (floatingActionButtonImpl.ensureMinTouchTargetSize) {
                i = Math.max((floatingActionButtonImpl.minTouchTargetSize - floatingActionButtonImpl.view.getSizeDimension()) / 2, 0);
            } else {
                i = 0;
            }
            int i3 = -i;
            rect.inset(i3, i3);
            if (!rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return false;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        if (this.backgroundTint != colorStateList) {
            this.backgroundTint = colorStateList;
            FloatingActionButtonImpl impl = getImpl();
            FloatingActionButtonImpl.AlwaysStatefulMaterialShapeDrawable alwaysStatefulMaterialShapeDrawable = impl.shapeDrawable;
            if (alwaysStatefulMaterialShapeDrawable != null) {
                alwaysStatefulMaterialShapeDrawable.setTintList(colorStateList);
            }
            BorderDrawable borderDrawable = impl.borderDrawable;
            if (borderDrawable != null) {
                if (colorStateList != null) {
                    borderDrawable.currentBorderTintColor = colorStateList.getColorForState(borderDrawable.getState(), borderDrawable.currentBorderTintColor);
                }
                borderDrawable.borderTint = colorStateList;
                borderDrawable.invalidateShader = true;
                borderDrawable.invalidateSelf();
            }
        }
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.backgroundTintMode != mode) {
            this.backgroundTintMode = mode;
            FloatingActionButtonImpl.AlwaysStatefulMaterialShapeDrawable alwaysStatefulMaterialShapeDrawable = getImpl().shapeDrawable;
            if (alwaysStatefulMaterialShapeDrawable != null) {
                alwaysStatefulMaterialShapeDrawable.setTintMode(mode);
            }
        }
    }

    public void setCompatElevation(float f) {
        FloatingActionButtonImpl impl = getImpl();
        if (impl.elevation != f) {
            impl.elevation = f;
            impl.onElevationsChanged(f, impl.hoveredFocusedTranslationZ, impl.pressedTranslationZ);
        }
    }

    public void setCompatElevationResource(int i) {
        setCompatElevation(getResources().getDimension(i));
    }

    public void setCompatHoveredFocusedTranslationZ(float f) {
        FloatingActionButtonImpl impl = getImpl();
        if (impl.hoveredFocusedTranslationZ != f) {
            impl.hoveredFocusedTranslationZ = f;
            impl.onElevationsChanged(impl.elevation, f, impl.pressedTranslationZ);
        }
    }

    public void setCompatHoveredFocusedTranslationZResource(int i) {
        setCompatHoveredFocusedTranslationZ(getResources().getDimension(i));
    }

    public void setCompatPressedTranslationZ(float f) {
        FloatingActionButtonImpl impl = getImpl();
        if (impl.pressedTranslationZ != f) {
            impl.pressedTranslationZ = f;
            impl.onElevationsChanged(impl.elevation, impl.hoveredFocusedTranslationZ, f);
        }
    }

    public void setCompatPressedTranslationZResource(int i) {
        setCompatPressedTranslationZ(getResources().getDimension(i));
    }

    public void setCustomSize(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Custom size must be non-negative");
        } else if (i != this.customSize) {
            this.customSize = i;
            requestLayout();
        }
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        FloatingActionButtonImpl.AlwaysStatefulMaterialShapeDrawable alwaysStatefulMaterialShapeDrawable = getImpl().shapeDrawable;
        if (alwaysStatefulMaterialShapeDrawable != null) {
            alwaysStatefulMaterialShapeDrawable.setElevation(f);
        }
    }

    public void setEnsureMinTouchTargetSize(boolean z) {
        if (z != getImpl().ensureMinTouchTargetSize) {
            getImpl().ensureMinTouchTargetSize = z;
            requestLayout();
        }
    }

    public void setExpandedComponentIdHint(int i) {
        this.expandableWidgetHelper.expandedComponentIdHint = i;
    }

    public void setHideMotionSpec(MotionSpec motionSpec) {
        getImpl().hideMotionSpec = motionSpec;
    }

    public void setHideMotionSpecResource(int i) {
        setHideMotionSpec(MotionSpec.createFromResource(getContext(), i));
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        if (getDrawable() != drawable) {
            super.setImageDrawable(drawable);
            FloatingActionButtonImpl impl = getImpl();
            float f = impl.imageMatrixScale;
            impl.imageMatrixScale = f;
            Matrix matrix = impl.tmpMatrix;
            impl.calculateImageMatrixFromScale(f, matrix);
            impl.view.setImageMatrix(matrix);
            if (this.imageTint != null) {
                onApplySupportImageTint();
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        this.imageHelper.setImageResource(i);
        onApplySupportImageTint();
    }

    public void setMaxImageSize(int i) {
        this.maxImageSize = i;
        FloatingActionButtonImpl impl = getImpl();
        if (impl.maxImageSize != i) {
            impl.maxImageSize = i;
            float f = impl.imageMatrixScale;
            impl.imageMatrixScale = f;
            Matrix matrix = impl.tmpMatrix;
            impl.calculateImageMatrixFromScale(f, matrix);
            impl.view.setImageMatrix(matrix);
        }
    }

    public void setRippleColor(int i) {
        setRippleColor(ColorStateList.valueOf(i));
    }

    @Override // android.view.View
    public void setScaleX(float f) {
        super.setScaleX(f);
        getImpl().getClass();
    }

    @Override // android.view.View
    public void setScaleY(float f) {
        super.setScaleY(f);
        getImpl().getClass();
    }

    public void setShadowPaddingEnabled(boolean z) {
        FloatingActionButtonImpl impl = getImpl();
        impl.shadowPaddingEnabled = z;
        impl.updatePadding();
    }

    @Override // com.google.android.material.shape.Shapeable
    public void setShapeAppearanceModel(ShapeAppearanceModel shapeAppearanceModel) {
        getImpl().setShapeAppearance(shapeAppearanceModel);
    }

    public void setShowMotionSpec(MotionSpec motionSpec) {
        getImpl().showMotionSpec = motionSpec;
    }

    public void setShowMotionSpecResource(int i) {
        setShowMotionSpec(MotionSpec.createFromResource(getContext(), i));
    }

    public void setSize(int i) {
        this.customSize = 0;
        if (i != this.size) {
            this.size = i;
            requestLayout();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        setBackgroundTintList(colorStateList);
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        setBackgroundTintMode(mode);
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        if (this.imageTint != colorStateList) {
            this.imageTint = colorStateList;
            onApplySupportImageTint();
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        if (this.imageMode != mode) {
            this.imageMode = mode;
            onApplySupportImageTint();
        }
    }

    @Override // android.view.View
    public void setTranslationX(float f) {
        super.setTranslationX(f);
        getImpl().onTranslationChanged();
    }

    @Override // android.view.View
    public void setTranslationY(float f) {
        super.setTranslationY(f);
        getImpl().onTranslationChanged();
    }

    @Override // android.view.View
    public void setTranslationZ(float f) {
        super.setTranslationZ(f);
        getImpl().onTranslationChanged();
    }

    public void setUseCompatPadding(boolean z) {
        if (this.compatPadding != z) {
            this.compatPadding = z;
            getImpl().updatePadding();
        }
    }

    @Override // com.google.android.material.internal.VisibilityAwareImageButton, android.widget.ImageView, android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
    }

    public final void show(boolean z) {
        AnimatorSet animatorSet;
        float f;
        float f2;
        FloatingActionButtonImpl impl = getImpl();
        FloatingActionButton floatingActionButton = impl.view;
        Matrix matrix = impl.tmpMatrix;
        FloatingActionButton floatingActionButton2 = impl.view;
        boolean z2 = true;
        if (floatingActionButton.getVisibility() != 0) {
            if (impl.animState == 2) {
                return;
            }
        } else if (impl.animState != 1) {
            return;
        }
        Animator animator = impl.currentAnimator;
        if (animator != null) {
            animator.cancel();
        }
        if (impl.showMotionSpec != null) {
            z2 = false;
        }
        if (!floatingActionButton2.isLaidOut() || floatingActionButton2.isInEditMode()) {
            floatingActionButton.internalSetVisibility(0, z);
            floatingActionButton.setAlpha(1.0f);
            floatingActionButton.setScaleY(1.0f);
            floatingActionButton.setScaleX(1.0f);
            impl.imageMatrixScale = 1.0f;
            impl.calculateImageMatrixFromScale(1.0f, matrix);
            floatingActionButton2.setImageMatrix(matrix);
            return;
        }
        if (floatingActionButton.getVisibility() != 0) {
            float f3 = 0.0f;
            floatingActionButton.setAlpha(0.0f);
            if (z2) {
                f = 0.4f;
            } else {
                f = 0.0f;
            }
            floatingActionButton.setScaleY(f);
            if (z2) {
                f2 = 0.4f;
            } else {
                f2 = 0.0f;
            }
            floatingActionButton.setScaleX(f2);
            if (z2) {
                f3 = 0.4f;
            }
            impl.imageMatrixScale = f3;
            impl.calculateImageMatrixFromScale(f3, matrix);
            floatingActionButton2.setImageMatrix(matrix);
        }
        MotionSpec motionSpec = impl.showMotionSpec;
        if (motionSpec != null) {
            animatorSet = impl.createAnimator(motionSpec, 1.0f, 1.0f, 1.0f);
        } else {
            animatorSet = impl.createDefaultAnimator(1.0f, 1.0f, 1.0f, FloatingActionButtonImpl.SHOW_ANIM_DURATION_ATTR, FloatingActionButtonImpl.SHOW_ANIM_EASING_ATTR);
        }
        animatorSet.addListener(new FastScroller.AnimatorListener(impl, z));
        animatorSet.start();
    }

    /* loaded from: classes.dex */
    public static class BaseBehavior<T extends FloatingActionButton> extends CoordinatorLayout.Behavior {
        public final boolean autoHideEnabled;
        public Rect tmpRect;

        public BaseBehavior() {
            this.autoHideEnabled = true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final boolean getInsetDodgeRect(View view, Rect rect) {
            FloatingActionButton floatingActionButton = (FloatingActionButton) view;
            Rect rect2 = floatingActionButton.shadowPadding;
            rect.set(floatingActionButton.getLeft() + rect2.left, floatingActionButton.getTop() + rect2.top, floatingActionButton.getRight() - rect2.right, floatingActionButton.getBottom() - rect2.bottom);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final void onAttachedToLayoutParams(CoordinatorLayout.LayoutParams layoutParams) {
            if (layoutParams.dodgeInsetEdges == 0) {
                layoutParams.dodgeInsetEdges = 80;
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) {
            boolean z;
            FloatingActionButton floatingActionButton = (FloatingActionButton) view;
            if (view2 instanceof AppBarLayout) {
                updateFabVisibilityForAppBarLayout(coordinatorLayout, (AppBarLayout) view2, floatingActionButton);
            } else {
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
                    z = ((CoordinatorLayout.LayoutParams) layoutParams).mBehavior instanceof BottomSheetBehavior;
                } else {
                    z = false;
                }
                if (z) {
                    updateFabVisibilityForBottomSheet(view2, floatingActionButton);
                }
            }
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i) {
            int i2;
            boolean z;
            FloatingActionButton floatingActionButton = (FloatingActionButton) view;
            ArrayList dependencies = coordinatorLayout.getDependencies(floatingActionButton);
            int size = dependencies.size();
            int i3 = 0;
            for (int i4 = 0; i4 < size; i4++) {
                View view2 = (View) dependencies.get(i4);
                if (!(view2 instanceof AppBarLayout)) {
                    ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                    if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
                        z = ((CoordinatorLayout.LayoutParams) layoutParams).mBehavior instanceof BottomSheetBehavior;
                    } else {
                        z = false;
                    }
                    if (z && updateFabVisibilityForBottomSheet(view2, floatingActionButton)) {
                        break;
                    }
                } else if (updateFabVisibilityForAppBarLayout(coordinatorLayout, (AppBarLayout) view2, floatingActionButton)) {
                    break;
                }
            }
            coordinatorLayout.onLayoutChild(i, floatingActionButton);
            Rect rect = floatingActionButton.shadowPadding;
            if (rect.centerX() > 0 && rect.centerY() > 0) {
                CoordinatorLayout.LayoutParams layoutParams2 = (CoordinatorLayout.LayoutParams) floatingActionButton.getLayoutParams();
                if (floatingActionButton.getRight() >= coordinatorLayout.getWidth() - ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin) {
                    i2 = rect.right;
                } else if (floatingActionButton.getLeft() <= ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin) {
                    i2 = -rect.left;
                } else {
                    i2 = 0;
                }
                if (floatingActionButton.getBottom() >= coordinatorLayout.getHeight() - ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin) {
                    i3 = rect.bottom;
                } else if (floatingActionButton.getTop() <= ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin) {
                    i3 = -rect.top;
                }
                if (i3 != 0) {
                    ViewCompat.offsetTopAndBottom(i3, floatingActionButton);
                }
                if (i2 != 0) {
                    ViewCompat.offsetLeftAndRight(i2, floatingActionButton);
                }
            }
            return true;
        }

        public final boolean updateFabVisibilityForAppBarLayout(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, FloatingActionButton floatingActionButton) {
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) floatingActionButton.getLayoutParams();
            if (!this.autoHideEnabled || layoutParams.mAnchorId != appBarLayout.getId() || floatingActionButton.getUserSetVisibility() != 0) {
                return false;
            }
            if (this.tmpRect == null) {
                this.tmpRect = new Rect();
            }
            Rect rect = this.tmpRect;
            ThreadLocal threadLocal = DescendantOffsetUtils.matrix;
            rect.set(0, 0, appBarLayout.getWidth(), appBarLayout.getHeight());
            DescendantOffsetUtils.offsetDescendantRect(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                floatingActionButton.hide(false);
                return true;
            }
            floatingActionButton.show(false);
            return true;
        }

        public final boolean updateFabVisibilityForBottomSheet(View view, FloatingActionButton floatingActionButton) {
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) floatingActionButton.getLayoutParams();
            if (!this.autoHideEnabled || layoutParams.mAnchorId != view.getId() || floatingActionButton.getUserSetVisibility() != 0) {
                return false;
            }
            if (view.getTop() < (floatingActionButton.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.LayoutParams) floatingActionButton.getLayoutParams())).topMargin) {
                floatingActionButton.hide(false);
                return true;
            }
            floatingActionButton.show(false);
            return true;
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.FloatingActionButton_Behavior_Layout);
            this.autoHideEnabled = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
        }
    }

    public final int getSizeDimension(int i) {
        int i2 = this.customSize;
        if (i2 != 0) {
            return i2;
        }
        Resources resources = getResources();
        if (i != -1) {
            if (i != 1) {
                return resources.getDimensionPixelSize(R.dimen.design_fab_size_normal);
            }
            return resources.getDimensionPixelSize(R.dimen.design_fab_size_mini);
        } else if (Math.max(resources.getConfiguration().screenWidthDp, resources.getConfiguration().screenHeightDp) < 470) {
            return getSizeDimension(1);
        } else {
            return getSizeDimension(0);
        }
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (this.rippleColor != colorStateList) {
            this.rippleColor = colorStateList;
            FloatingActionButtonImpl impl = getImpl();
            ColorStateList colorStateList2 = this.rippleColor;
            RippleDrawable rippleDrawable = impl.rippleDrawable;
            if (rippleDrawable != null) {
                rippleDrawable.setColor(RippleUtils.sanitizeRippleDrawableColor(colorStateList2));
            } else if (rippleDrawable != null) {
                rippleDrawable.setTintList(RippleUtils.sanitizeRippleDrawableColor(colorStateList2));
            }
        }
    }
}
