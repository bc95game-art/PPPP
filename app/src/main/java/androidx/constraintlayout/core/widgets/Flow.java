package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measure;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class Flow extends HelperWidget {
    public ConstraintWidget[] mAlignedBiggestElementsInCols;
    public ConstraintWidget[] mAlignedBiggestElementsInRows;
    public int[] mAlignedDimensions;
    public ArrayList mChainList;
    public ConstraintWidget[] mDisplayedWidgets;
    public int mDisplayedWidgetsCount;
    public float mFirstHorizontalBias;
    public int mFirstHorizontalStyle;
    public float mFirstVerticalBias;
    public int mFirstVerticalStyle;
    public int mHorizontalAlign;
    public float mHorizontalBias;
    public int mHorizontalGap;
    public int mHorizontalStyle;
    public float mLastHorizontalBias;
    public int mLastHorizontalStyle;
    public float mLastVerticalBias;
    public int mLastVerticalStyle;
    public int mMaxElementsWrap;
    public BasicMeasure$Measure mMeasure;
    public int mMeasuredHeight;
    public int mMeasuredWidth;
    public ConstraintLayout.Measurer mMeasurer;
    public boolean mNeedsCallFromSolver;
    public int mOrientation;
    public int mPaddingBottom;
    public int mPaddingEnd;
    public int mPaddingStart;
    public int mPaddingTop;
    public int mResolvedPaddingLeft;
    public int mResolvedPaddingRight;
    public int mVerticalAlign;
    public float mVerticalBias;
    public int mVerticalGap;
    public int mVerticalStyle;
    public int mWrapMode;

    /* loaded from: classes.dex */
    public final class WidgetsList {
        public ConstraintAnchor mBottom;
        public ConstraintAnchor mLeft;
        public int mMax;
        public int mOrientation;
        public int mPaddingBottom;
        public int mPaddingLeft;
        public int mPaddingRight;
        public int mPaddingTop;
        public ConstraintAnchor mRight;
        public ConstraintAnchor mTop;
        public ConstraintWidget mBiggest = null;
        public int mBiggestDimension = 0;
        public int mWidth = 0;
        public int mHeight = 0;
        public int mStartIndex = 0;
        public int mCount = 0;
        public int mNbMatchConstraintsWidgets = 0;

        public WidgetsList(int i, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, ConstraintAnchor constraintAnchor3, ConstraintAnchor constraintAnchor4, int i2) {
            this.mOrientation = i;
            this.mLeft = constraintAnchor;
            this.mTop = constraintAnchor2;
            this.mRight = constraintAnchor3;
            this.mBottom = constraintAnchor4;
            this.mPaddingLeft = Flow.this.mResolvedPaddingLeft;
            this.mPaddingTop = Flow.this.mPaddingTop;
            this.mPaddingRight = Flow.this.mResolvedPaddingRight;
            this.mPaddingBottom = Flow.this.mPaddingBottom;
            this.mMax = i2;
        }

        public final void add(ConstraintWidget constraintWidget) {
            int i = this.mOrientation;
            int i2 = 0;
            Flow flow = Flow.this;
            if (i == 0) {
                int widgetWidth = flow.getWidgetWidth(constraintWidget, this.mMax);
                if (constraintWidget.mListDimensionBehaviors[0] == 3) {
                    this.mNbMatchConstraintsWidgets++;
                    widgetWidth = 0;
                }
                int i3 = flow.mHorizontalGap;
                if (constraintWidget.mVisibility != 8) {
                    i2 = i3;
                }
                this.mWidth = widgetWidth + i2 + this.mWidth;
                int widgetHeight = flow.getWidgetHeight(constraintWidget, this.mMax);
                if (this.mBiggest == null || this.mBiggestDimension < widgetHeight) {
                    this.mBiggest = constraintWidget;
                    this.mBiggestDimension = widgetHeight;
                    this.mHeight = widgetHeight;
                }
            } else {
                int widgetWidth2 = flow.getWidgetWidth(constraintWidget, this.mMax);
                int widgetHeight2 = flow.getWidgetHeight(constraintWidget, this.mMax);
                if (constraintWidget.mListDimensionBehaviors[1] == 3) {
                    this.mNbMatchConstraintsWidgets++;
                    widgetHeight2 = 0;
                }
                int i4 = flow.mVerticalGap;
                if (constraintWidget.mVisibility != 8) {
                    i2 = i4;
                }
                this.mHeight = widgetHeight2 + i2 + this.mHeight;
                if (this.mBiggest == null || this.mBiggestDimension < widgetWidth2) {
                    this.mBiggest = constraintWidget;
                    this.mBiggestDimension = widgetWidth2;
                    this.mWidth = widgetWidth2;
                }
            }
            this.mCount++;
        }

        public final void createConstraints(int i, boolean z, boolean z2) {
            Flow flow;
            boolean z3;
            int i2;
            int i3;
            int i4;
            ConstraintWidget constraintWidget;
            int i5;
            int i6;
            int i7;
            boolean z4;
            float f;
            float f2;
            float f3;
            int i8;
            float f4;
            float f5;
            int i9;
            int i10;
            int i11;
            int i12 = this.mCount;
            int i13 = 0;
            while (true) {
                flow = Flow.this;
                if (i13 >= i12 || (i11 = this.mStartIndex + i13) >= flow.mDisplayedWidgetsCount) {
                    break;
                }
                ConstraintWidget constraintWidget2 = flow.mDisplayedWidgets[i11];
                if (constraintWidget2 != null) {
                    constraintWidget2.resetAnchors();
                }
                i13++;
            }
            if (i12 != 0 && this.mBiggest != null) {
                if (!z2 || i != 0) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                int i14 = -1;
                int i15 = -1;
                for (int i16 = 0; i16 < i12; i16++) {
                    if (z) {
                        i10 = (i12 - 1) - i16;
                    } else {
                        i10 = i16;
                    }
                    int i17 = this.mStartIndex + i10;
                    if (i17 >= flow.mDisplayedWidgetsCount) {
                        break;
                    }
                    ConstraintWidget constraintWidget3 = flow.mDisplayedWidgets[i17];
                    if (constraintWidget3 != null && constraintWidget3.mVisibility == 0) {
                        if (i14 == -1) {
                            i14 = i16;
                        }
                        i15 = i16;
                    }
                }
                if (this.mOrientation == 0) {
                    ConstraintWidget constraintWidget4 = this.mBiggest;
                    constraintWidget4.mVerticalChainStyle = flow.mVerticalStyle;
                    ConstraintAnchor constraintAnchor = constraintWidget4.mBottom;
                    ConstraintAnchor constraintAnchor2 = constraintWidget4.mTop;
                    int i18 = this.mPaddingTop;
                    if (i > 0) {
                        i18 += flow.mVerticalGap;
                    }
                    constraintAnchor2.connect(this.mTop, i18);
                    if (z2) {
                        constraintAnchor.connect(this.mBottom, this.mPaddingBottom);
                    }
                    if (i > 0) {
                        this.mTop.mOwner.mBottom.connect(constraintAnchor2, 0);
                    }
                    if (flow.mVerticalAlign == 3 && !constraintWidget4.mHasBaseline) {
                        for (int i19 = 0; i19 < i12; i19++) {
                            if (z) {
                                i9 = (i12 - 1) - i19;
                            } else {
                                i9 = i19;
                            }
                            int i20 = this.mStartIndex + i9;
                            if (i20 >= flow.mDisplayedWidgetsCount) {
                                break;
                            }
                            constraintWidget = flow.mDisplayedWidgets[i20];
                            if (constraintWidget.mHasBaseline) {
                                break;
                            }
                        }
                    }
                    constraintWidget = constraintWidget4;
                    ConstraintWidget constraintWidget5 = null;
                    int i21 = 0;
                    while (i21 < i12) {
                        if (z) {
                            i5 = (i12 - 1) - i21;
                        } else {
                            i5 = i21;
                        }
                        int i22 = this.mStartIndex + i5;
                        if (i22 < flow.mDisplayedWidgetsCount) {
                            ConstraintWidget constraintWidget6 = flow.mDisplayedWidgets[i22];
                            if (constraintWidget6 == null) {
                                i6 = i12;
                                z4 = z3;
                                i7 = i15;
                            } else {
                                ConstraintAnchor constraintAnchor3 = constraintWidget6.mBottom;
                                ConstraintAnchor constraintAnchor4 = constraintWidget6.mTop;
                                ConstraintAnchor constraintAnchor5 = constraintWidget6.mLeft;
                                z4 = z3;
                                if (i21 == 0) {
                                    i7 = i15;
                                    constraintWidget6.connect(constraintAnchor5, this.mLeft, this.mPaddingLeft);
                                } else {
                                    i7 = i15;
                                }
                                if (i5 == 0) {
                                    int i23 = flow.mHorizontalStyle;
                                    if (z) {
                                        f = 1.0f;
                                        f2 = 1.0f - flow.mHorizontalBias;
                                    } else {
                                        f = 1.0f;
                                        f2 = flow.mHorizontalBias;
                                    }
                                    if (this.mStartIndex == 0) {
                                        i8 = flow.mFirstHorizontalStyle;
                                        f4 = f2;
                                        if (i8 != -1) {
                                            if (z) {
                                                f5 = flow.mFirstHorizontalBias;
                                                f3 = f - f5;
                                                constraintWidget6.mHorizontalChainStyle = i8;
                                                constraintWidget6.mHorizontalBiasPercent = f3;
                                            } else {
                                                f3 = flow.mFirstHorizontalBias;
                                                constraintWidget6.mHorizontalChainStyle = i8;
                                                constraintWidget6.mHorizontalBiasPercent = f3;
                                            }
                                        }
                                    } else {
                                        f4 = f2;
                                    }
                                    if (!z2 || (i8 = flow.mLastHorizontalStyle) == -1) {
                                        i8 = i23;
                                        f3 = f4;
                                    } else if (z) {
                                        f5 = flow.mLastHorizontalBias;
                                        f3 = f - f5;
                                    } else {
                                        f3 = flow.mLastHorizontalBias;
                                    }
                                    constraintWidget6.mHorizontalChainStyle = i8;
                                    constraintWidget6.mHorizontalBiasPercent = f3;
                                }
                                if (i21 == i12 - 1) {
                                    i6 = i12;
                                    constraintWidget6.connect(constraintWidget6.mRight, this.mRight, this.mPaddingRight);
                                } else {
                                    i6 = i12;
                                }
                                if (constraintWidget5 != null) {
                                    ConstraintAnchor constraintAnchor6 = constraintWidget5.mRight;
                                    constraintAnchor5.connect(constraintAnchor6, flow.mHorizontalGap);
                                    if (i21 == i14) {
                                        int i24 = this.mPaddingLeft;
                                        if (constraintAnchor5.isConnected()) {
                                            constraintAnchor5.mGoneMargin = i24;
                                        }
                                    }
                                    constraintAnchor6.connect(constraintAnchor5, 0);
                                    if (i21 == i7 + 1) {
                                        int i25 = this.mPaddingRight;
                                        if (constraintAnchor6.isConnected()) {
                                            constraintAnchor6.mGoneMargin = i25;
                                        }
                                    }
                                }
                                if (constraintWidget6 != constraintWidget4) {
                                    int i26 = flow.mVerticalAlign;
                                    if (i26 == 3 && constraintWidget.mHasBaseline && constraintWidget6 != constraintWidget && constraintWidget6.mHasBaseline) {
                                        constraintWidget6.mBaseline.connect(constraintWidget.mBaseline, 0);
                                    } else if (i26 == 0) {
                                        constraintAnchor4.connect(constraintAnchor2, 0);
                                    } else if (i26 == 1) {
                                        constraintAnchor3.connect(constraintAnchor, 0);
                                    } else if (z4) {
                                        constraintAnchor4.connect(this.mTop, this.mPaddingTop);
                                        constraintAnchor3.connect(this.mBottom, this.mPaddingBottom);
                                    } else {
                                        constraintAnchor4.connect(constraintAnchor2, 0);
                                        constraintAnchor3.connect(constraintAnchor, 0);
                                    }
                                }
                                constraintWidget5 = constraintWidget6;
                            }
                            i21++;
                            z3 = z4;
                            i15 = i7;
                            i12 = i6;
                        } else {
                            return;
                        }
                    }
                    return;
                }
                int i27 = i12;
                boolean z5 = z3;
                int i28 = i15;
                ConstraintWidget constraintWidget7 = this.mBiggest;
                constraintWidget7.mHorizontalChainStyle = flow.mHorizontalStyle;
                ConstraintAnchor constraintAnchor7 = constraintWidget7.mLeft;
                ConstraintAnchor constraintAnchor8 = constraintWidget7.mRight;
                int i29 = this.mPaddingLeft;
                if (i > 0) {
                    i29 += flow.mHorizontalGap;
                }
                if (z) {
                    constraintAnchor8.connect(this.mRight, i29);
                    if (z2) {
                        constraintAnchor7.connect(this.mLeft, this.mPaddingRight);
                    }
                    if (i > 0) {
                        this.mRight.mOwner.mLeft.connect(constraintAnchor8, 0);
                    }
                } else {
                    constraintAnchor7.connect(this.mLeft, i29);
                    if (z2) {
                        constraintAnchor8.connect(this.mRight, this.mPaddingRight);
                    }
                    if (i > 0) {
                        this.mLeft.mOwner.mRight.connect(constraintAnchor7, 0);
                    }
                }
                int i30 = 0;
                ConstraintWidget constraintWidget8 = null;
                while (true) {
                    int i31 = i27;
                    if (i30 < i31 && (i2 = this.mStartIndex + i30) < flow.mDisplayedWidgetsCount) {
                        ConstraintWidget constraintWidget9 = flow.mDisplayedWidgets[i2];
                        if (constraintWidget9 == null) {
                            i27 = i31;
                        } else {
                            ConstraintAnchor constraintAnchor9 = constraintWidget9.mTop;
                            ConstraintAnchor constraintAnchor10 = constraintWidget9.mRight;
                            ConstraintAnchor constraintAnchor11 = constraintWidget9.mLeft;
                            if (i30 == 0) {
                                constraintWidget9.connect(constraintAnchor9, this.mTop, this.mPaddingTop);
                                int i32 = flow.mVerticalStyle;
                                float f6 = flow.mVerticalBias;
                                if (this.mStartIndex == 0) {
                                    i4 = flow.mFirstVerticalStyle;
                                    i27 = i31;
                                    i3 = -1;
                                    if (i4 != -1) {
                                        f6 = flow.mFirstVerticalBias;
                                        i32 = i4;
                                        constraintWidget9.mVerticalChainStyle = i32;
                                        constraintWidget9.mVerticalBiasPercent = f6;
                                    }
                                } else {
                                    i27 = i31;
                                    i3 = -1;
                                }
                                if (z2 && (i4 = flow.mLastVerticalStyle) != i3) {
                                    f6 = flow.mLastVerticalBias;
                                    i32 = i4;
                                }
                                constraintWidget9.mVerticalChainStyle = i32;
                                constraintWidget9.mVerticalBiasPercent = f6;
                            } else {
                                i27 = i31;
                            }
                            if (i30 == i27 - 1) {
                                constraintWidget9.connect(constraintWidget9.mBottom, this.mBottom, this.mPaddingBottom);
                            }
                            if (constraintWidget8 != null) {
                                ConstraintAnchor constraintAnchor12 = constraintWidget8.mBottom;
                                constraintAnchor9.connect(constraintAnchor12, flow.mVerticalGap);
                                if (i30 == i14) {
                                    int i33 = this.mPaddingTop;
                                    if (constraintAnchor9.isConnected()) {
                                        constraintAnchor9.mGoneMargin = i33;
                                    }
                                }
                                constraintAnchor12.connect(constraintAnchor9, 0);
                                if (i30 == i28 + 1) {
                                    int i34 = this.mPaddingBottom;
                                    if (constraintAnchor12.isConnected()) {
                                        constraintAnchor12.mGoneMargin = i34;
                                    }
                                }
                            }
                            if (constraintWidget9 != constraintWidget7) {
                                if (z) {
                                    int i35 = flow.mHorizontalAlign;
                                    if (i35 == 0) {
                                        constraintAnchor10.connect(constraintAnchor8, 0);
                                    } else if (i35 == 1) {
                                        constraintAnchor11.connect(constraintAnchor7, 0);
                                    } else if (i35 == 2) {
                                        constraintAnchor11.connect(constraintAnchor7, 0);
                                        constraintAnchor10.connect(constraintAnchor8, 0);
                                    }
                                } else {
                                    int i36 = flow.mHorizontalAlign;
                                    if (i36 == 0) {
                                        constraintAnchor11.connect(constraintAnchor7, 0);
                                    } else if (i36 == 1) {
                                        constraintAnchor10.connect(constraintAnchor8, 0);
                                    } else if (i36 == 2) {
                                        if (z5) {
                                            constraintAnchor11.connect(this.mLeft, this.mPaddingLeft);
                                            constraintAnchor10.connect(this.mRight, this.mPaddingRight);
                                        } else {
                                            constraintAnchor11.connect(constraintAnchor7, 0);
                                            constraintAnchor10.connect(constraintAnchor8, 0);
                                        }
                                    }
                                    constraintWidget8 = constraintWidget9;
                                }
                            }
                            constraintWidget8 = constraintWidget9;
                        }
                        i30++;
                    } else {
                        return;
                    }
                }
            }
        }

        public final int getHeight() {
            if (this.mOrientation == 1) {
                return this.mHeight - Flow.this.mVerticalGap;
            }
            return this.mHeight;
        }

        public final int getWidth() {
            if (this.mOrientation == 0) {
                return this.mWidth - Flow.this.mHorizontalGap;
            }
            return this.mWidth;
        }

        public final void measureMatchConstraints(int i) {
            Flow flow;
            int i2;
            int i3 = this.mNbMatchConstraintsWidgets;
            if (i3 != 0) {
                int i4 = this.mCount;
                int i5 = i / i3;
                int i6 = 0;
                while (true) {
                    flow = Flow.this;
                    if (i6 >= i4 || (i2 = this.mStartIndex + i6) >= flow.mDisplayedWidgetsCount) {
                        break;
                    }
                    ConstraintWidget constraintWidget = flow.mDisplayedWidgets[i2];
                    if (this.mOrientation == 0) {
                        if (constraintWidget != null) {
                            int[] iArr = constraintWidget.mListDimensionBehaviors;
                            if (iArr[0] == 3 && constraintWidget.mMatchConstraintDefaultWidth == 0) {
                                flow.measure(1, i5, iArr[1], constraintWidget.getHeight(), constraintWidget);
                            }
                        }
                    } else if (constraintWidget != null) {
                        int[] iArr2 = constraintWidget.mListDimensionBehaviors;
                        if (iArr2[1] == 3 && constraintWidget.mMatchConstraintDefaultHeight == 0) {
                            int i7 = i5;
                            flow.measure(iArr2[0], constraintWidget.getWidth(), 1, i7, constraintWidget);
                            i5 = i7;
                        }
                    }
                    i6++;
                }
                this.mWidth = 0;
                this.mHeight = 0;
                this.mBiggest = null;
                this.mBiggestDimension = 0;
                int i8 = this.mCount;
                for (int i9 = 0; i9 < i8; i9++) {
                    int i10 = this.mStartIndex + i9;
                    if (i10 < flow.mDisplayedWidgetsCount) {
                        ConstraintWidget constraintWidget2 = flow.mDisplayedWidgets[i10];
                        if (this.mOrientation == 0) {
                            int width = constraintWidget2.getWidth();
                            int i11 = flow.mHorizontalGap;
                            if (constraintWidget2.mVisibility == 8) {
                                i11 = 0;
                            }
                            this.mWidth = width + i11 + this.mWidth;
                            int widgetHeight = flow.getWidgetHeight(constraintWidget2, this.mMax);
                            if (this.mBiggest == null || this.mBiggestDimension < widgetHeight) {
                                this.mBiggest = constraintWidget2;
                                this.mBiggestDimension = widgetHeight;
                                this.mHeight = widgetHeight;
                            }
                        } else {
                            int widgetWidth = flow.getWidgetWidth(constraintWidget2, this.mMax);
                            int widgetHeight2 = flow.getWidgetHeight(constraintWidget2, this.mMax);
                            int i12 = flow.mVerticalGap;
                            if (constraintWidget2.mVisibility == 8) {
                                i12 = 0;
                            }
                            this.mHeight = widgetHeight2 + i12 + this.mHeight;
                            if (this.mBiggest == null || this.mBiggestDimension < widgetWidth) {
                                this.mBiggest = constraintWidget2;
                                this.mBiggestDimension = widgetWidth;
                                this.mWidth = widgetWidth;
                            }
                        }
                    } else {
                        return;
                    }
                }
            }
        }

        public final void setup(int i, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, ConstraintAnchor constraintAnchor3, ConstraintAnchor constraintAnchor4, int i2, int i3, int i4, int i5, int i6) {
            this.mOrientation = i;
            this.mLeft = constraintAnchor;
            this.mTop = constraintAnchor2;
            this.mRight = constraintAnchor3;
            this.mBottom = constraintAnchor4;
            this.mPaddingLeft = i2;
            this.mPaddingTop = i3;
            this.mPaddingRight = i4;
            this.mPaddingBottom = i5;
            this.mMax = i6;
        }
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public final void addToSolver(LinearSystem linearSystem, boolean z) {
        boolean z2;
        boolean z3;
        ConstraintWidget constraintWidget;
        float f;
        int i;
        boolean z4;
        ArrayList arrayList = this.mChainList;
        super.addToSolver(linearSystem, z);
        ConstraintWidget constraintWidget2 = this.mParent;
        if (constraintWidget2 == null || !((ConstraintWidgetContainer) constraintWidget2).mIsRtl) {
            z2 = false;
        } else {
            z2 = true;
        }
        int i2 = this.mWrapMode;
        if (i2 != 0) {
            if (i2 == 1) {
                int size = arrayList.size();
                for (int i3 = 0; i3 < size; i3++) {
                    WidgetsList widgetsList = (WidgetsList) arrayList.get(i3);
                    if (i3 == size - 1) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    widgetsList.createConstraints(i3, z2, z3);
                }
            } else if (i2 != 2) {
                if (i2 == 3) {
                    int size2 = arrayList.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        WidgetsList widgetsList2 = (WidgetsList) arrayList.get(i4);
                        if (i4 == size2 - 1) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        widgetsList2.createConstraints(i4, z2, z4);
                    }
                }
            } else if (!(this.mAlignedDimensions == null || this.mAlignedBiggestElementsInCols == null || this.mAlignedBiggestElementsInRows == null)) {
                for (int i5 = 0; i5 < this.mDisplayedWidgetsCount; i5++) {
                    this.mDisplayedWidgets[i5].resetAnchors();
                }
                int[] iArr = this.mAlignedDimensions;
                int i6 = iArr[0];
                int i7 = iArr[1];
                float f2 = this.mHorizontalBias;
                ConstraintWidget constraintWidget3 = null;
                int i8 = 0;
                while (i8 < i6) {
                    if (z2) {
                        i = (i6 - i8) - 1;
                        f = 1.0f - this.mHorizontalBias;
                    } else {
                        f = f2;
                        i = i8;
                    }
                    ConstraintWidget constraintWidget4 = this.mAlignedBiggestElementsInCols[i];
                    if (constraintWidget4 != null) {
                        ConstraintAnchor constraintAnchor = constraintWidget4.mLeft;
                        if (constraintWidget4.mVisibility != 8) {
                            if (i8 == 0) {
                                constraintWidget4.connect(constraintAnchor, this.mLeft, this.mResolvedPaddingLeft);
                                constraintWidget4.mHorizontalChainStyle = this.mHorizontalStyle;
                                constraintWidget4.mHorizontalBiasPercent = f;
                            }
                            if (i8 == i6 - 1) {
                                constraintWidget4.connect(constraintWidget4.mRight, this.mRight, this.mResolvedPaddingRight);
                            }
                            if (i8 > 0 && constraintWidget3 != null) {
                                ConstraintAnchor constraintAnchor2 = constraintWidget3.mRight;
                                constraintWidget4.connect(constraintAnchor, constraintAnchor2, this.mHorizontalGap);
                                constraintWidget3.connect(constraintAnchor2, constraintAnchor, 0);
                            }
                            constraintWidget3 = constraintWidget4;
                        }
                    }
                    i8++;
                    f2 = f;
                }
                for (int i9 = 0; i9 < i7; i9++) {
                    ConstraintWidget constraintWidget5 = this.mAlignedBiggestElementsInRows[i9];
                    if (constraintWidget5 != null) {
                        ConstraintAnchor constraintAnchor3 = constraintWidget5.mTop;
                        if (constraintWidget5.mVisibility != 8) {
                            if (i9 == 0) {
                                constraintWidget5.connect(constraintAnchor3, this.mTop, this.mPaddingTop);
                                constraintWidget5.mVerticalChainStyle = this.mVerticalStyle;
                                constraintWidget5.mVerticalBiasPercent = this.mVerticalBias;
                            }
                            if (i9 == i7 - 1) {
                                constraintWidget5.connect(constraintWidget5.mBottom, this.mBottom, this.mPaddingBottom);
                            }
                            if (i9 > 0 && constraintWidget3 != null) {
                                ConstraintAnchor constraintAnchor4 = constraintWidget3.mBottom;
                                constraintWidget5.connect(constraintAnchor3, constraintAnchor4, this.mVerticalGap);
                                constraintWidget3.connect(constraintAnchor4, constraintAnchor3, 0);
                            }
                            constraintWidget3 = constraintWidget5;
                        }
                    }
                }
                for (int i10 = 0; i10 < i6; i10++) {
                    for (int i11 = 0; i11 < i7; i11++) {
                        int i12 = (i11 * i6) + i10;
                        if (this.mOrientation == 1) {
                            i12 = (i10 * i7) + i11;
                        }
                        ConstraintWidget[] constraintWidgetArr = this.mDisplayedWidgets;
                        if (!(i12 >= constraintWidgetArr.length || (constraintWidget = constraintWidgetArr[i12]) == null || constraintWidget.mVisibility == 8)) {
                            ConstraintWidget constraintWidget6 = this.mAlignedBiggestElementsInCols[i10];
                            ConstraintWidget constraintWidget7 = this.mAlignedBiggestElementsInRows[i11];
                            if (constraintWidget != constraintWidget6) {
                                constraintWidget.connect(constraintWidget.mLeft, constraintWidget6.mLeft, 0);
                                constraintWidget.connect(constraintWidget.mRight, constraintWidget6.mRight, 0);
                            }
                            if (constraintWidget != constraintWidget7) {
                                constraintWidget.connect(constraintWidget.mTop, constraintWidget7.mTop, 0);
                                constraintWidget.connect(constraintWidget.mBottom, constraintWidget7.mBottom, 0);
                            }
                        }
                    }
                }
            }
        } else if (arrayList.size() > 0) {
            ((WidgetsList) arrayList.get(0)).createConstraints(0, z2, true);
        }
        this.mNeedsCallFromSolver = false;
    }

    public final int getWidgetHeight(ConstraintWidget constraintWidget, int i) {
        ConstraintWidget constraintWidget2;
        if (constraintWidget != null) {
            int[] iArr = constraintWidget.mListDimensionBehaviors;
            if (iArr[1] == 3) {
                int i2 = constraintWidget.mMatchConstraintDefaultHeight;
                if (i2 != 0) {
                    if (i2 == 2) {
                        int i3 = (int) (constraintWidget.mMatchConstraintPercentHeight * i);
                        if (i3 != constraintWidget.getHeight()) {
                            constraintWidget.mMeasureRequested = true;
                            measure(iArr[0], constraintWidget.getWidth(), 1, i3, constraintWidget);
                        }
                        return i3;
                    }
                    constraintWidget2 = constraintWidget;
                    if (i2 == 1) {
                        return constraintWidget2.getHeight();
                    }
                    if (i2 == 3) {
                        return (int) ((constraintWidget2.getWidth() * constraintWidget2.mDimensionRatio) + 0.5f);
                    }
                }
            } else {
                constraintWidget2 = constraintWidget;
            }
            return constraintWidget2.getHeight();
        }
        return 0;
    }

    public final int getWidgetWidth(ConstraintWidget constraintWidget, int i) {
        ConstraintWidget constraintWidget2;
        if (constraintWidget != null) {
            int[] iArr = constraintWidget.mListDimensionBehaviors;
            if (iArr[0] == 3) {
                int i2 = constraintWidget.mMatchConstraintDefaultWidth;
                if (i2 != 0) {
                    if (i2 == 2) {
                        int i3 = (int) (constraintWidget.mMatchConstraintPercentWidth * i);
                        if (i3 != constraintWidget.getWidth()) {
                            constraintWidget.mMeasureRequested = true;
                            measure(1, i3, iArr[1], constraintWidget.getHeight(), constraintWidget);
                        }
                        return i3;
                    }
                    constraintWidget2 = constraintWidget;
                    if (i2 == 1) {
                        return constraintWidget2.getWidth();
                    }
                    if (i2 == 3) {
                        return (int) ((constraintWidget2.getHeight() * constraintWidget2.mDimensionRatio) + 0.5f);
                    }
                }
            } else {
                constraintWidget2 = constraintWidget;
            }
            return constraintWidget2.getWidth();
        }
        return 0;
    }

    public final void measure(int i, int i2, int i3, int i4, ConstraintWidget constraintWidget) {
        ConstraintLayout.Measurer measurer;
        ConstraintWidget constraintWidget2;
        BasicMeasure$Measure basicMeasure$Measure = this.mMeasure;
        while (true) {
            measurer = this.mMeasurer;
            if (measurer != null || (constraintWidget2 = this.mParent) == null) {
                break;
            }
            this.mMeasurer = ((ConstraintWidgetContainer) constraintWidget2).mMeasurer;
        }
        basicMeasure$Measure.horizontalBehavior = i;
        basicMeasure$Measure.verticalBehavior = i3;
        basicMeasure$Measure.horizontalDimension = i2;
        basicMeasure$Measure.verticalDimension = i4;
        measurer.measure(constraintWidget, basicMeasure$Measure);
        constraintWidget.setWidth(basicMeasure$Measure.measuredWidth);
        constraintWidget.setHeight(basicMeasure$Measure.measuredHeight);
        constraintWidget.mHasBaseline = basicMeasure$Measure.measuredHasBaseline;
        constraintWidget.setBaselineDistance(basicMeasure$Measure.measuredBaseline);
    }

    @Override // androidx.constraintlayout.core.widgets.HelperWidget
    public final void updateConstraints() {
        for (int i = 0; i < this.mWidgetsCount; i++) {
            ConstraintWidget constraintWidget = this.mWidgets[i];
            if (constraintWidget != null) {
                constraintWidget.mInVirtualLayout = true;
            }
        }
    }
}
