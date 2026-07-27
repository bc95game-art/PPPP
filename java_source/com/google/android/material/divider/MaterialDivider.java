package com.google.android.material.divider;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.p002os.BundleKt;
import com.emanuelef.remote_capture.C0130R;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import kotlin.LazyKt__LazyJVMKt;
/* loaded from: classes.dex */
public class MaterialDivider extends View {
    public int color;
    public final MaterialShapeDrawable dividerDrawable = new MaterialShapeDrawable();
    public int insetEnd;
    public int insetStart;
    public int thickness;

    public MaterialDivider(Context context, AttributeSet attributeSet) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, C0130R.attr.materialDividerStyle, C0130R.style.Widget_MaterialComponents_MaterialDivider), attributeSet, C0130R.attr.materialDividerStyle);
        Context context2 = getContext();
        TypedArray obtainStyledAttributes = ViewUtils.obtainStyledAttributes(context2, attributeSet, R$styleable.MaterialDivider, C0130R.attr.materialDividerStyle, C0130R.style.Widget_MaterialComponents_MaterialDivider, new int[0]);
        this.thickness = obtainStyledAttributes.getDimensionPixelSize(3, getResources().getDimensionPixelSize(C0130R.dimen.material_divider_thickness));
        this.insetStart = obtainStyledAttributes.getDimensionPixelOffset(2, 0);
        this.insetEnd = obtainStyledAttributes.getDimensionPixelOffset(1, 0);
        setDividerColor(LazyKt__LazyJVMKt.getColorStateList(context2, obtainStyledAttributes, 0).getDefaultColor());
        obtainStyledAttributes.recycle();
    }

    public int getDividerColor() {
        return this.color;
    }

    public int getDividerInsetEnd() {
        return this.insetEnd;
    }

    public int getDividerInsetStart() {
        return this.insetStart;
    }

    public int getDividerThickness() {
        return this.thickness;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        int i;
        int width;
        int i2;
        super.onDraw(canvas);
        boolean z = true;
        if (getLayoutDirection() != 1) {
            z = false;
        }
        if (z) {
            i = this.insetEnd;
        } else {
            i = this.insetStart;
        }
        if (z) {
            width = getWidth();
            i2 = this.insetStart;
        } else {
            width = getWidth();
            i2 = this.insetEnd;
        }
        int i3 = width - i2;
        int bottom = getBottom() - getTop();
        MaterialShapeDrawable materialShapeDrawable = this.dividerDrawable;
        materialShapeDrawable.setBounds(i, 0, i3, bottom);
        materialShapeDrawable.draw(canvas);
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i2);
        int measuredHeight = getMeasuredHeight();
        if (mode == Integer.MIN_VALUE || mode == 0) {
            int i3 = this.thickness;
            if (i3 > 0 && measuredHeight != i3) {
                measuredHeight = i3;
            }
            setMeasuredDimension(getMeasuredWidth(), measuredHeight);
        }
    }

    public void setDividerColor(int i) {
        if (this.color != i) {
            this.color = i;
            this.dividerDrawable.setFillColor(ColorStateList.valueOf(i));
            invalidate();
        }
    }

    public void setDividerColorResource(int i) {
        setDividerColor(BundleKt.getColor(getContext(), i));
    }

    public void setDividerInsetEnd(int i) {
        this.insetEnd = i;
    }

    public void setDividerInsetEndResource(int i) {
        setDividerInsetEnd(getContext().getResources().getDimensionPixelOffset(i));
    }

    public void setDividerInsetStart(int i) {
        this.insetStart = i;
    }

    public void setDividerInsetStartResource(int i) {
        setDividerInsetStart(getContext().getResources().getDimensionPixelOffset(i));
    }

    public void setDividerThickness(int i) {
        if (this.thickness != i) {
            this.thickness = i;
            requestLayout();
        }
    }

    public void setDividerThicknessResource(int i) {
        setDividerThickness(getContext().getResources().getDimensionPixelSize(i));
    }
}
