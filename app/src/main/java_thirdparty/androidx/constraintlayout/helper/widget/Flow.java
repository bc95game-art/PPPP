package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.HelperWidget;
import androidx.constraintlayout.widget.R$styleable;
import androidx.constraintlayout.widget.VirtualLayout;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class Flow extends VirtualLayout {
    public final androidx.constraintlayout.core.widgets.Flow mFlow;

    /* JADX WARN: Type inference failed for: r1v0, types: [androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measure, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v1, types: [androidx.constraintlayout.core.widgets.HelperWidget, androidx.constraintlayout.core.widgets.Flow] */
    public Flow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIds = new int[32];
        this.mMap = new HashMap();
        this.myContext = context;
        super.init(attributeSet);
        ?? helperWidget = new HelperWidget();
        helperWidget.mPaddingTop = 0;
        helperWidget.mPaddingBottom = 0;
        helperWidget.mPaddingStart = 0;
        helperWidget.mPaddingEnd = 0;
        helperWidget.mResolvedPaddingLeft = 0;
        helperWidget.mResolvedPaddingRight = 0;
        helperWidget.mNeedsCallFromSolver = false;
        helperWidget.mMeasuredWidth = 0;
        helperWidget.mMeasuredHeight = 0;
        helperWidget.mMeasure = new Object();
        helperWidget.mMeasurer = null;
        helperWidget.mHorizontalStyle = -1;
        helperWidget.mVerticalStyle = -1;
        helperWidget.mFirstHorizontalStyle = -1;
        helperWidget.mFirstVerticalStyle = -1;
        helperWidget.mLastHorizontalStyle = -1;
        helperWidget.mLastVerticalStyle = -1;
        helperWidget.mHorizontalBias = 0.5f;
        helperWidget.mVerticalBias = 0.5f;
        helperWidget.mFirstHorizontalBias = 0.5f;
        helperWidget.mFirstVerticalBias = 0.5f;
        helperWidget.mLastHorizontalBias = 0.5f;
        helperWidget.mLastVerticalBias = 0.5f;
        helperWidget.mHorizontalGap = 0;
        helperWidget.mVerticalGap = 0;
        helperWidget.mHorizontalAlign = 2;
        helperWidget.mVerticalAlign = 2;
        helperWidget.mWrapMode = 0;
        helperWidget.mMaxElementsWrap = -1;
        helperWidget.mOrientation = 0;
        helperWidget.mChainList = new ArrayList();
        helperWidget.mAlignedBiggestElementsInRows = null;
        helperWidget.mAlignedBiggestElementsInCols = null;
        helperWidget.mAlignedDimensions = null;
        helperWidget.mDisplayedWidgetsCount = 0;
        this.mFlow = helperWidget;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == 0) {
                    this.mFlow.mOrientation = obtainStyledAttributes.getInt(index, 0);
                } else if (index == 1) {
                    androidx.constraintlayout.core.widgets.Flow flow = this.mFlow;
                    int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                    flow.mPaddingTop = dimensionPixelSize;
                    flow.mPaddingBottom = dimensionPixelSize;
                    flow.mPaddingStart = dimensionPixelSize;
                    flow.mPaddingEnd = dimensionPixelSize;
                } else if (index == 18) {
                    androidx.constraintlayout.core.widgets.Flow flow2 = this.mFlow;
                    int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                    flow2.mPaddingStart = dimensionPixelSize2;
                    flow2.mResolvedPaddingLeft = dimensionPixelSize2;
                    flow2.mResolvedPaddingRight = dimensionPixelSize2;
                } else if (index == 19) {
                    this.mFlow.mPaddingEnd = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 2) {
                    this.mFlow.mResolvedPaddingLeft = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 3) {
                    this.mFlow.mPaddingTop = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 4) {
                    this.mFlow.mResolvedPaddingRight = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 5) {
                    this.mFlow.mPaddingBottom = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 54) {
                    this.mFlow.mWrapMode = obtainStyledAttributes.getInt(index, 0);
                } else if (index == 44) {
                    this.mFlow.mHorizontalStyle = obtainStyledAttributes.getInt(index, 0);
                } else if (index == 53) {
                    this.mFlow.mVerticalStyle = obtainStyledAttributes.getInt(index, 0);
                } else if (index == 38) {
                    this.mFlow.mFirstHorizontalStyle = obtainStyledAttributes.getInt(index, 0);
                } else if (index == 46) {
                    this.mFlow.mLastHorizontalStyle = obtainStyledAttributes.getInt(index, 0);
                } else if (index == 40) {
                    this.mFlow.mFirstVerticalStyle = obtainStyledAttributes.getInt(index, 0);
                } else if (index == 48) {
                    this.mFlow.mLastVerticalStyle = obtainStyledAttributes.getInt(index, 0);
                } else if (index == 42) {
                    this.mFlow.mHorizontalBias = obtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == 37) {
                    this.mFlow.mFirstHorizontalBias = obtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == 45) {
                    this.mFlow.mLastHorizontalBias = obtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == 39) {
                    this.mFlow.mFirstVerticalBias = obtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == 47) {
                    this.mFlow.mLastVerticalBias = obtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == 51) {
                    this.mFlow.mVerticalBias = obtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == 41) {
                    this.mFlow.mHorizontalAlign = obtainStyledAttributes.getInt(index, 2);
                } else if (index == 50) {
                    this.mFlow.mVerticalAlign = obtainStyledAttributes.getInt(index, 2);
                } else if (index == 43) {
                    this.mFlow.mHorizontalGap = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 52) {
                    this.mFlow.mVerticalGap = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 49) {
                    this.mFlow.mMaxElementsWrap = obtainStyledAttributes.getInt(index, -1);
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.mHelperWidget = this.mFlow;
        validateParams();
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    public final void onMeasure(int i, int i2) {
        onMeasure(this.mFlow, i, i2);
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public final void resolveRtl(ConstraintWidget constraintWidget, boolean z) {
        androidx.constraintlayout.core.widgets.Flow flow = this.mFlow;
        int i = flow.mPaddingStart;
        if (i <= 0 && flow.mPaddingEnd <= 0) {
            return;
        }
        if (z) {
            flow.mResolvedPaddingLeft = flow.mPaddingEnd;
            flow.mResolvedPaddingRight = i;
            return;
        }
        flow.mResolvedPaddingLeft = i;
        flow.mResolvedPaddingRight = flow.mPaddingEnd;
    }

    public void setFirstHorizontalBias(float f) {
        this.mFlow.mFirstHorizontalBias = f;
        requestLayout();
    }

    public void setFirstHorizontalStyle(int i) {
        this.mFlow.mFirstHorizontalStyle = i;
        requestLayout();
    }

    public void setFirstVerticalBias(float f) {
        this.mFlow.mFirstVerticalBias = f;
        requestLayout();
    }

    public void setFirstVerticalStyle(int i) {
        this.mFlow.mFirstVerticalStyle = i;
        requestLayout();
    }

    public void setHorizontalAlign(int i) {
        this.mFlow.mHorizontalAlign = i;
        requestLayout();
    }

    public void setHorizontalBias(float f) {
        this.mFlow.mHorizontalBias = f;
        requestLayout();
    }

    public void setHorizontalGap(int i) {
        this.mFlow.mHorizontalGap = i;
        requestLayout();
    }

    public void setHorizontalStyle(int i) {
        this.mFlow.mHorizontalStyle = i;
        requestLayout();
    }

    public void setLastHorizontalBias(float f) {
        this.mFlow.mLastHorizontalBias = f;
        requestLayout();
    }

    public void setLastHorizontalStyle(int i) {
        this.mFlow.mLastHorizontalStyle = i;
        requestLayout();
    }

    public void setLastVerticalBias(float f) {
        this.mFlow.mLastVerticalBias = f;
        requestLayout();
    }

    public void setLastVerticalStyle(int i) {
        this.mFlow.mLastVerticalStyle = i;
        requestLayout();
    }

    public void setMaxElementsWrap(int i) {
        this.mFlow.mMaxElementsWrap = i;
        requestLayout();
    }

    public void setOrientation(int i) {
        this.mFlow.mOrientation = i;
        requestLayout();
    }

    public void setPadding(int i) {
        androidx.constraintlayout.core.widgets.Flow flow = this.mFlow;
        flow.mPaddingTop = i;
        flow.mPaddingBottom = i;
        flow.mPaddingStart = i;
        flow.mPaddingEnd = i;
        requestLayout();
    }

    public void setPaddingBottom(int i) {
        this.mFlow.mPaddingBottom = i;
        requestLayout();
    }

    public void setPaddingLeft(int i) {
        this.mFlow.mResolvedPaddingLeft = i;
        requestLayout();
    }

    public void setPaddingRight(int i) {
        this.mFlow.mResolvedPaddingRight = i;
        requestLayout();
    }

    public void setPaddingTop(int i) {
        this.mFlow.mPaddingTop = i;
        requestLayout();
    }

    public void setVerticalAlign(int i) {
        this.mFlow.mVerticalAlign = i;
        requestLayout();
    }

    public void setVerticalBias(float f) {
        this.mFlow.mVerticalBias = f;
        requestLayout();
    }

    public void setVerticalGap(int i) {
        this.mFlow.mVerticalGap = i;
        requestLayout();
    }

    public void setVerticalStyle(int i) {
        this.mFlow.mVerticalStyle = i;
        requestLayout();
    }

    public void setWrapMode(int i) {
        this.mFlow.mWrapMode = i;
        requestLayout();
    }

    /* JADX WARN: Removed duplicated region for block: B:219:0x03e0  */
    /* JADX WARN: Removed duplicated region for block: B:389:0x0721  */
    /* JADX WARN: Removed duplicated region for block: B:395:0x072f  */
    /* JADX WARN: Removed duplicated region for block: B:396:0x0732  */
    /* JADX WARN: Removed duplicated region for block: B:403:0x074e  */
    /* JADX WARN: Removed duplicated region for block: B:404:0x0750  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:276:0x0496 -> B:216:0x03db). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:277:0x0498 -> B:216:0x03db). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:279:0x049e -> B:216:0x03db). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:280:0x04a0 -> B:216:0x03db). Please submit an issue!!! */
    @Override // androidx.constraintlayout.widget.VirtualLayout
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onMeasure(androidx.constraintlayout.core.widgets.Flow r39, int r40, int r41) {
        /*
            Method dump skipped, instructions count: 1892
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.helper.widget.Flow.onMeasure(androidx.constraintlayout.core.widgets.Flow, int, int):void");
    }
}
