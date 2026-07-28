package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.emanuelef.remote_capture.C0130R;
import com.google.android.material.R$styleable;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.RelativeCornerSize;
import com.google.android.material.shape.ShapeAppearanceModel;
/* loaded from: classes.dex */
public abstract class RadialViewGroup extends ConstraintLayout {
    public final MaterialShapeDrawable background;
    public int radius;
    public final RadialViewGroup$$ExternalSyntheticLambda0 updateLayoutParametersRunnable = new Runnable() { // from class: com.google.android.material.timepicker.RadialViewGroup$$ExternalSyntheticLambda0
        @Override // java.lang.Runnable
        public final void run() {
            RadialViewGroup.this.updateLayoutParams();
        }
    };

    /* JADX WARN: Type inference failed for: r6v2, types: [com.google.android.material.timepicker.RadialViewGroup$$ExternalSyntheticLambda0] */
    public RadialViewGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, C0130R.attr.materialClockStyle);
        LayoutInflater.from(context).inflate(C0130R.layout.material_radial_view_group, this);
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
        this.background = materialShapeDrawable;
        RelativeCornerSize relativeCornerSize = new RelativeCornerSize(0.5f);
        ShapeAppearanceModel.Builder builder = materialShapeDrawable.drawableState.shapeAppearanceModel.toBuilder();
        builder.topLeftCornerSize = relativeCornerSize;
        builder.topRightCornerSize = relativeCornerSize;
        builder.bottomRightCornerSize = relativeCornerSize;
        builder.bottomLeftCornerSize = relativeCornerSize;
        materialShapeDrawable.setShapeAppearanceModel(builder.build());
        this.background.setFillColor(ColorStateList.valueOf(-1));
        setBackground(this.background);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.RadialViewGroup, C0130R.attr.materialClockStyle, 0);
        this.radius = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (view.getId() == -1) {
            view.setId(View.generateViewId());
        }
        Handler handler = getHandler();
        if (handler != null) {
            RadialViewGroup$$ExternalSyntheticLambda0 radialViewGroup$$ExternalSyntheticLambda0 = this.updateLayoutParametersRunnable;
            handler.removeCallbacks(radialViewGroup$$ExternalSyntheticLambda0);
            handler.post(radialViewGroup$$ExternalSyntheticLambda0);
        }
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        updateLayoutParams();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public final void onViewRemoved(View view) {
        super.onViewRemoved(view);
        Handler handler = getHandler();
        if (handler != null) {
            RadialViewGroup$$ExternalSyntheticLambda0 radialViewGroup$$ExternalSyntheticLambda0 = this.updateLayoutParametersRunnable;
            handler.removeCallbacks(radialViewGroup$$ExternalSyntheticLambda0);
            handler.post(radialViewGroup$$ExternalSyntheticLambda0);
        }
    }

    @Override // android.view.View
    public final void setBackgroundColor(int i) {
        this.background.setFillColor(ColorStateList.valueOf(i));
    }

    public abstract void updateLayoutParams();
}
