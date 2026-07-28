package com.github.appintro.indicator;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat$Api21Impl;
import androidx.core.graphics.drawable.DrawableCompat$Api21Impl;
import androidx.core.p002os.BundleKt;
import com.github.appintro.C0161R;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class DotIndicatorController extends LinearLayout implements IndicatorController {
    private int currentPosition;
    private int selectedIndicatorColor;
    private int slideCount;
    private int unselectedIndicatorColor;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DotIndicatorController(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.selectedIndicatorColor = BundleKt.getColor(context, C0161R.color.appintro_default_selected_color);
        this.unselectedIndicatorColor = BundleKt.getColor(context, C0161R.color.appintro_default_unselected_color);
    }

    @Override // com.github.appintro.indicator.IndicatorController
    public int getSelectedIndicatorColor() {
        return this.selectedIndicatorColor;
    }

    @Override // com.github.appintro.indicator.IndicatorController
    public int getUnselectedIndicatorColor() {
        return this.unselectedIndicatorColor;
    }

    @Override // com.github.appintro.indicator.IndicatorController
    public void initialize(int i) {
        this.slideCount = i;
        int i2 = 0;
        while (i2 < i) {
            i2++;
            ImageView imageView = new ImageView(getContext());
            imageView.setImageDrawable(ContextCompat$Api21Impl.getDrawable(getContext(), C0161R.C0162drawable.ic_appintro_indicator));
            ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            if (i == 1) {
                imageView.setVisibility(4);
            }
            addView(imageView, layoutParams);
        }
        selectPosition(0);
    }

    @Override // com.github.appintro.indicator.IndicatorController
    public View newInstance(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        layoutParams.gravity = 16;
        setLayoutParams(layoutParams);
        setOrientation(0);
        setGravity(17);
        return this;
    }

    @Override // com.github.appintro.indicator.IndicatorController
    public void selectPosition(int i) {
        int i2;
        this.currentPosition = i;
        int i3 = this.slideCount;
        int i4 = 0;
        while (i4 < i3) {
            int i5 = i4 + 1;
            if (i4 == i) {
                i2 = getSelectedIndicatorColor();
            } else {
                i2 = getUnselectedIndicatorColor();
            }
            View childAt = getChildAt(i4);
            if (childAt != null) {
                DrawableCompat$Api21Impl.setTint(((ImageView) childAt).getDrawable(), i2);
                i4 = i5;
            } else {
                throw new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
            }
        }
    }

    @Override // com.github.appintro.indicator.IndicatorController
    public void setSelectedIndicatorColor(int i) {
        this.selectedIndicatorColor = i;
        selectPosition(this.currentPosition);
    }

    @Override // com.github.appintro.indicator.IndicatorController
    public void setUnselectedIndicatorColor(int i) {
        this.unselectedIndicatorColor = i;
        selectPosition(this.currentPosition);
    }
}
