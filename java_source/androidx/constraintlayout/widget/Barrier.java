package androidx.constraintlayout.widget;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
/* loaded from: classes.dex */
public final class Barrier extends ConstraintHelper {
    public androidx.constraintlayout.core.widgets.Barrier mBarrier;
    public int mIndicatedType;
    public int mResolvedType;

    public boolean getAllowsGoneWidget() {
        return this.mBarrier.mAllowsGoneWidget;
    }

    public int getMargin() {
        return this.mBarrier.mMargin;
    }

    public int getType() {
        return this.mIndicatedType;
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public final void resolveRtl(ConstraintWidget constraintWidget, boolean z) {
        int i = this.mIndicatedType;
        this.mResolvedType = i;
        if (z) {
            if (i == 5) {
                this.mResolvedType = 1;
            } else if (i == 6) {
                this.mResolvedType = 0;
            }
        } else if (i == 5) {
            this.mResolvedType = 0;
        } else if (i == 6) {
            this.mResolvedType = 1;
        }
        if (constraintWidget instanceof androidx.constraintlayout.core.widgets.Barrier) {
            ((androidx.constraintlayout.core.widgets.Barrier) constraintWidget).mBarrierType = this.mResolvedType;
        }
    }

    public void setAllowsGoneWidget(boolean z) {
        this.mBarrier.mAllowsGoneWidget = z;
    }

    public void setDpMargin(int i) {
        this.mBarrier.mMargin = (int) ((i * getResources().getDisplayMetrics().density) + 0.5f);
    }

    public void setMargin(int i) {
        this.mBarrier.mMargin = i;
    }

    public void setType(int i) {
        this.mIndicatedType = i;
    }
}
