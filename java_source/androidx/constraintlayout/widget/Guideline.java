package androidx.constraintlayout.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
/* loaded from: classes.dex */
public class Guideline extends View {
    public boolean mFilterRedundantCalls = true;

    public Guideline(Context context) {
        super(context);
        super.setVisibility(8);
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        setMeasuredDimension(0, 0);
    }

    public void setFilterRedundantCalls(boolean z) {
        this.mFilterRedundantCalls = z;
    }

    public void setGuidelineBegin(int i) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
        if (!this.mFilterRedundantCalls || layoutParams.guideBegin != i) {
            layoutParams.guideBegin = i;
            setLayoutParams(layoutParams);
        }
    }

    public void setGuidelineEnd(int i) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
        if (!this.mFilterRedundantCalls || layoutParams.guideEnd != i) {
            layoutParams.guideEnd = i;
            setLayoutParams(layoutParams);
        }
    }

    public void setGuidelinePercent(float f) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
        if (!this.mFilterRedundantCalls || layoutParams.guidePercent != f) {
            layoutParams.guidePercent = f;
            setLayoutParams(layoutParams);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
    }

    public Guideline(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setVisibility(8);
    }
}
