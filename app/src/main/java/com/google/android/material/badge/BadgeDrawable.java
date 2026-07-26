package com.google.android.material.badge;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.emanuelef.remote_capture.R;
import com.google.android.material.badge.BadgeState;
import com.google.android.material.internal.TextDrawableHelper;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.lang.ref.WeakReference;
import java.text.NumberFormat;
/* loaded from: classes.dex */
public final class BadgeDrawable extends Drawable implements TextDrawableHelper.TextDrawableDelegate {
    public WeakReference anchorViewRef;
    public final Rect badgeBounds = new Rect();
    public float badgeCenterX;
    public float badgeCenterY;
    public final WeakReference contextRef;
    public float cornerRadius;
    public WeakReference customBadgeParentRef;
    public float halfBadgeHeight;
    public float halfBadgeWidth;
    public final int maxBadgeNumber;
    public final MaterialShapeDrawable shapeDrawable;
    public final BadgeState state;
    public final TextDrawableHelper textDrawableHelper;

    public BadgeDrawable(Context context) {
        int i;
        int i2;
        FrameLayout frameLayout;
        TextAppearance textAppearance;
        WeakReference weakReference = new WeakReference(context);
        this.contextRef = weakReference;
        ViewUtils.checkTheme(context, ViewUtils.MATERIAL_CHECK_ATTRS, "Theme.MaterialComponents");
        TextDrawableHelper textDrawableHelper = new TextDrawableHelper(this);
        this.textDrawableHelper = textDrawableHelper;
        Paint.Align align = Paint.Align.CENTER;
        TextPaint textPaint = textDrawableHelper.textPaint;
        textPaint.setTextAlign(align);
        BadgeState badgeState = new BadgeState(context);
        this.state = badgeState;
        boolean hasBadgeContent = hasBadgeContent();
        BadgeState.State state = badgeState.currentState;
        if (hasBadgeContent) {
            i = state.badgeWithTextShapeAppearanceResId.intValue();
        } else {
            i = state.badgeShapeAppearanceResId.intValue();
        }
        if (hasBadgeContent()) {
            i2 = state.badgeWithTextShapeAppearanceOverlayResId.intValue();
        } else {
            i2 = state.badgeShapeAppearanceOverlayResId.intValue();
        }
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(ShapeAppearanceModel.builder(context, i, i2).build());
        this.shapeDrawable = materialShapeDrawable;
        onBadgeShapeAppearanceUpdated();
        Context context2 = (Context) weakReference.get();
        if (!(context2 == null || textDrawableHelper.textAppearance == (textAppearance = new TextAppearance(context2, state.badgeTextAppearanceResId.intValue())))) {
            textDrawableHelper.setTextAppearance(textAppearance, context2);
            textPaint.setColor(state.badgeTextColor.intValue());
            invalidateSelf();
            updateCenterAndBounds();
            invalidateSelf();
        }
        int i3 = state.maxCharacterCount;
        if (i3 != -2) {
            this.maxBadgeNumber = ((int) Math.pow(10.0d, i3 - 1.0d)) - 1;
        } else {
            this.maxBadgeNumber = state.maxNumber;
        }
        textDrawableHelper.textSizeDirty = true;
        updateCenterAndBounds();
        invalidateSelf();
        textDrawableHelper.textSizeDirty = true;
        onBadgeShapeAppearanceUpdated();
        updateCenterAndBounds();
        invalidateSelf();
        textPaint.setAlpha(getAlpha());
        invalidateSelf();
        ColorStateList valueOf = ColorStateList.valueOf(state.backgroundColor.intValue());
        if (materialShapeDrawable.drawableState.fillColor != valueOf) {
            materialShapeDrawable.setFillColor(valueOf);
            invalidateSelf();
        }
        textPaint.setColor(state.badgeTextColor.intValue());
        invalidateSelf();
        WeakReference weakReference2 = this.anchorViewRef;
        if (!(weakReference2 == null || weakReference2.get() == null)) {
            View view = (View) this.anchorViewRef.get();
            WeakReference weakReference3 = this.customBadgeParentRef;
            if (weakReference3 != null) {
                frameLayout = (FrameLayout) weakReference3.get();
            } else {
                frameLayout = null;
            }
            updateBadgeCoordinates(view, frameLayout);
        }
        updateCenterAndBounds();
        setVisible(state.isVisible.booleanValue(), false);
    }

    public final void autoAdjustWithinViewBounds(View view, View view2) {
        float f;
        float f2;
        boolean z;
        ViewParent customBadgeParent = getCustomBadgeParent();
        if (customBadgeParent == null) {
            float y = view.getY();
            f2 = view.getX();
            customBadgeParent = view.getParent();
            f = y;
        } else {
            f = 0.0f;
            f2 = 0.0f;
        }
        while (true) {
            z = customBadgeParent instanceof View;
            if (!z || customBadgeParent == view2) {
                break;
            }
            ViewParent parent = customBadgeParent.getParent();
            if (!(parent instanceof ViewGroup) || ((ViewGroup) parent).getClipChildren()) {
                break;
            }
            View view3 = (View) customBadgeParent;
            f += view3.getY();
            f2 += view3.getX();
            customBadgeParent = customBadgeParent.getParent();
        }
        if (z) {
            float f3 = (this.badgeCenterY - this.halfBadgeHeight) + f;
            float f4 = (this.badgeCenterX - this.halfBadgeWidth) + f2;
            View view4 = (View) customBadgeParent;
            float height = ((this.badgeCenterY + this.halfBadgeHeight) - view4.getHeight()) + f;
            float width = ((this.badgeCenterX + this.halfBadgeWidth) - view4.getWidth()) + f2;
            if (f3 < 0.0f) {
                this.badgeCenterY = Math.abs(f3) + this.badgeCenterY;
            }
            if (f4 < 0.0f) {
                this.badgeCenterX = Math.abs(f4) + this.badgeCenterX;
            }
            if (height > 0.0f) {
                this.badgeCenterY -= Math.abs(height);
            }
            if (width > 0.0f) {
                this.badgeCenterX -= Math.abs(width);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        String badgeContent;
        int round;
        if (!getBounds().isEmpty() && getAlpha() != 0 && isVisible()) {
            this.shapeDrawable.draw(canvas);
            if (hasBadgeContent() && (badgeContent = getBadgeContent()) != null) {
                Rect rect = new Rect();
                TextDrawableHelper textDrawableHelper = this.textDrawableHelper;
                textDrawableHelper.textPaint.getTextBounds(badgeContent, 0, badgeContent.length(), rect);
                float exactCenterY = this.badgeCenterY - rect.exactCenterY();
                float f = this.badgeCenterX;
                if (rect.bottom <= 0) {
                    round = (int) exactCenterY;
                } else {
                    round = Math.round(exactCenterY);
                }
                canvas.drawText(badgeContent, f, round, textDrawableHelper.textPaint);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.state.currentState.alpha;
    }

    public final String getBadgeContent() {
        BadgeState badgeState = this.state;
        BadgeState.State state = badgeState.currentState;
        BadgeState.State state2 = badgeState.currentState;
        String str = state.text;
        WeakReference weakReference = this.contextRef;
        if (str != null) {
            int i = state.maxCharacterCount;
            if (i == -2 || str == null || str.length() <= i) {
                return str;
            }
            Context context = (Context) weakReference.get();
            if (context == null) {
                return "";
            }
            return String.format(context.getString(R.string.m3_exceed_max_badge_text_suffix), str.substring(0, i - 1), "…");
        } else if (!hasNumber()) {
            return null;
        } else {
            int i2 = this.maxBadgeNumber;
            if (i2 == -2 || getNumber() <= i2) {
                return NumberFormat.getInstance(state2.numberLocale).format(getNumber());
            }
            Context context2 = (Context) weakReference.get();
            if (context2 == null) {
                return "";
            }
            return String.format(state2.numberLocale, context2.getString(R.string.mtrl_exceed_max_badge_number_suffix), Integer.valueOf(i2), "+");
        }
    }

    public final FrameLayout getCustomBadgeParent() {
        WeakReference weakReference = this.customBadgeParentRef;
        if (weakReference != null) {
            return (FrameLayout) weakReference.get();
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.badgeBounds.height();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.badgeBounds.width();
    }

    public final int getNumber() {
        int i = this.state.currentState.number;
        if (i != -1) {
            return i;
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    public final boolean hasBadgeContent() {
        if (this.state.currentState.text == null && !hasNumber()) {
            return false;
        }
        return true;
    }

    public final boolean hasNumber() {
        BadgeState.State state = this.state.currentState;
        if (state.text == null && state.number != -1) {
            return true;
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        return false;
    }

    public final void onBadgeShapeAppearanceUpdated() {
        int i;
        int i2;
        Context context = (Context) this.contextRef.get();
        if (context != null) {
            boolean hasBadgeContent = hasBadgeContent();
            BadgeState badgeState = this.state;
            if (hasBadgeContent) {
                i = badgeState.currentState.badgeWithTextShapeAppearanceResId.intValue();
            } else {
                i = badgeState.currentState.badgeShapeAppearanceResId.intValue();
            }
            if (hasBadgeContent()) {
                i2 = badgeState.currentState.badgeWithTextShapeAppearanceOverlayResId.intValue();
            } else {
                i2 = badgeState.currentState.badgeShapeAppearanceOverlayResId.intValue();
            }
            this.shapeDrawable.setShapeAppearanceModel(ShapeAppearanceModel.builder(context, i, i2).build());
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable, com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    public final boolean onStateChange(int[] iArr) {
        return super.onStateChange(iArr);
    }

    @Override // com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    public final void onTextSizeChange() {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        BadgeState badgeState = this.state;
        badgeState.overridingState.alpha = i;
        badgeState.currentState.alpha = i;
        this.textDrawableHelper.textPaint.setAlpha(getAlpha());
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
    }

    public final void updateBadgeCoordinates(View view, FrameLayout frameLayout) {
        this.anchorViewRef = new WeakReference(view);
        this.customBadgeParentRef = new WeakReference(frameLayout);
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        viewGroup.setClipChildren(false);
        viewGroup.setClipToPadding(false);
        updateCenterAndBounds();
        invalidateSelf();
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0258  */
    /* JADX WARN: Removed duplicated region for block: B:108:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0220  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void updateCenterAndBounds() {
        /*
            Method dump skipped, instructions count: 604
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.badge.BadgeDrawable.updateCenterAndBounds():void");
    }
}
