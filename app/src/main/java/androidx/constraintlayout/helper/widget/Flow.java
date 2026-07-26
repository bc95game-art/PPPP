package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.Flow;
import androidx.constraintlayout.core.widgets.Guideline;
import androidx.constraintlayout.core.widgets.HelperWidget;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measure;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R$styleable;
import androidx.constraintlayout.widget.VirtualLayout;
import java.util.ArrayList;
import java.util.Arrays;
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
    */
    public final void onMeasure(androidx.constraintlayout.core.widgets.Flow flow, int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        ConstraintWidget[] constraintWidgetArr;
        int i7;
        int[] iArr;
        int i8;
        int i9;
        int i10;
        char c;
        int i11;
        char c2;
        int i12;
        Flow.WidgetsList widgetsList;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        boolean z;
        Object obj;
        ConstraintWidget constraintWidget;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        ArrayList arrayList;
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        ConstraintAnchor constraintAnchor3;
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (flow != null) {
            int[] iArr2 = flow.mListDimensionBehaviors;
            ConstraintAnchor constraintAnchor4 = flow.mTop;
            ConstraintAnchor constraintAnchor5 = flow.mLeft;
            ConstraintAnchor constraintAnchor6 = flow.mRight;
            ConstraintAnchor constraintAnchor7 = flow.mBottom;
            ArrayList arrayList2 = flow.mChainList;
            if (flow.mWidgetsCount > 0) {
                BasicMeasure$Measure basicMeasure$Measure = flow.mMeasure;
                ConstraintWidget constraintWidget2 = flow.mParent;
                ConstraintLayout.Measurer measurer = constraintWidget2 != null ? ((ConstraintWidgetContainer) constraintWidget2).mMeasurer : null;
                if (measurer == null) {
                    flow.mMeasuredWidth = 0;
                    flow.mMeasuredHeight = 0;
                    flow.mNeedsCallFromSolver = false;
                    setMeasuredDimension(flow.mMeasuredWidth, flow.mMeasuredHeight);
                    return;
                }
                int i25 = 0;
                while (i25 < flow.mWidgetsCount) {
                    ConstraintWidget constraintWidget3 = flow.mWidgets[i25];
                    if (constraintWidget3 == null) {
                        constraintAnchor3 = constraintAnchor5;
                    } else {
                        constraintAnchor3 = constraintAnchor5;
                        if (!(constraintWidget3 instanceof Guideline)) {
                            constraintAnchor2 = constraintAnchor6;
                            int dimensionBehaviour = constraintWidget3.getDimensionBehaviour(0);
                            constraintAnchor = constraintAnchor7;
                            int dimensionBehaviour2 = constraintWidget3.getDimensionBehaviour(1);
                            arrayList = arrayList2;
                            if (dimensionBehaviour == 3) {
                                i24 = i25;
                                if (!(constraintWidget3.mMatchConstraintDefaultWidth == 1 || dimensionBehaviour2 != 3 || constraintWidget3.mMatchConstraintDefaultHeight == 1)) {
                                    i25 = i24 + 1;
                                    constraintAnchor5 = constraintAnchor3;
                                    constraintAnchor6 = constraintAnchor2;
                                    constraintAnchor7 = constraintAnchor;
                                    arrayList2 = arrayList;
                                }
                            } else {
                                i24 = i25;
                            }
                            if (dimensionBehaviour == 3) {
                                dimensionBehaviour = 2;
                            }
                            if (dimensionBehaviour2 == 3) {
                                dimensionBehaviour2 = 2;
                            }
                            basicMeasure$Measure.horizontalBehavior = dimensionBehaviour;
                            basicMeasure$Measure.verticalBehavior = dimensionBehaviour2;
                            basicMeasure$Measure.horizontalDimension = constraintWidget3.getWidth();
                            basicMeasure$Measure.verticalDimension = constraintWidget3.getHeight();
                            measurer.measure(constraintWidget3, basicMeasure$Measure);
                            constraintWidget3.setWidth(basicMeasure$Measure.measuredWidth);
                            constraintWidget3.setHeight(basicMeasure$Measure.measuredHeight);
                            constraintWidget3.setBaselineDistance(basicMeasure$Measure.measuredBaseline);
                            i25 = i24 + 1;
                            constraintAnchor5 = constraintAnchor3;
                            constraintAnchor6 = constraintAnchor2;
                            constraintAnchor7 = constraintAnchor;
                            arrayList2 = arrayList;
                        }
                    }
                    constraintAnchor2 = constraintAnchor6;
                    constraintAnchor = constraintAnchor7;
                    arrayList = arrayList2;
                    i24 = i25;
                    i25 = i24 + 1;
                    constraintAnchor5 = constraintAnchor3;
                    constraintAnchor6 = constraintAnchor2;
                    constraintAnchor7 = constraintAnchor;
                    arrayList2 = arrayList;
                }
            }
            ConstraintAnchor constraintAnchor8 = constraintAnchor5;
            ConstraintAnchor constraintAnchor9 = constraintAnchor6;
            ConstraintAnchor constraintAnchor10 = constraintAnchor7;
            ArrayList arrayList3 = arrayList2;
            int i26 = flow.mResolvedPaddingLeft;
            int i27 = flow.mResolvedPaddingRight;
            int i28 = flow.mPaddingTop;
            int i29 = flow.mPaddingBottom;
            int[] iArr3 = new int[2];
            int i30 = (size - i26) - i27;
            int i31 = flow.mOrientation;
            if (i31 == 1) {
                i30 = (size2 - i28) - i29;
            }
            int i32 = i30;
            if (i31 == 0) {
                if (flow.mHorizontalStyle == -1) {
                    i23 = 0;
                    flow.mHorizontalStyle = 0;
                } else {
                    i23 = 0;
                }
                i3 = i27;
                if (flow.mVerticalStyle == -1) {
                    flow.mVerticalStyle = i23;
                }
            } else {
                i3 = i27;
                if (flow.mHorizontalStyle == -1) {
                    flow.mHorizontalStyle = 0;
                }
                if (flow.mVerticalStyle == -1) {
                    flow.mVerticalStyle = 0;
                }
            }
            ConstraintWidget[] constraintWidgetArr2 = flow.mWidgets;
            int i33 = 0;
            int i34 = 0;
            while (true) {
                i4 = flow.mWidgetsCount;
                i5 = i28;
                if (i33 >= i4) {
                    break;
                }
                if (flow.mWidgets[i33].mVisibility == 8) {
                    i34++;
                }
                i33++;
                i28 = i5;
            }
            if (i34 > 0) {
                constraintWidgetArr = new ConstraintWidget[i4 - i34];
                int i35 = 0;
                int i36 = 0;
                while (i35 < flow.mWidgetsCount) {
                    ConstraintWidget constraintWidget4 = flow.mWidgets[i35];
                    ConstraintWidget[] constraintWidgetArr3 = constraintWidgetArr;
                    if (constraintWidget4.mVisibility != 8) {
                        constraintWidgetArr3[i36] = constraintWidget4;
                        i36++;
                    }
                    i35++;
                    constraintWidgetArr = constraintWidgetArr3;
                }
                i6 = i36;
            } else {
                i6 = i4;
                constraintWidgetArr = constraintWidgetArr2;
            }
            flow.mDisplayedWidgets = constraintWidgetArr;
            flow.mDisplayedWidgetsCount = i6;
            int i37 = flow.mWrapMode;
            if (i37 == 0) {
                ConstraintWidget[] constraintWidgetArr4 = constraintWidgetArr;
                int i38 = i6;
                i8 = i29;
                iArr = iArr3;
                i7 = size2;
                i11 = i26;
                i10 = i3;
                i9 = i5;
                int i39 = flow.mOrientation;
                if (i38 != 0) {
                    if (arrayList3.size() == 0) {
                        widgetsList = new Flow.WidgetsList(i39, flow.mLeft, flow.mTop, flow.mRight, flow.mBottom, i32);
                        arrayList3.add(widgetsList);
                    } else {
                        Flow.WidgetsList widgetsList2 = (Flow.WidgetsList) arrayList3.get(0);
                        widgetsList2.mBiggestDimension = 0;
                        widgetsList2.mBiggest = null;
                        widgetsList2.mWidth = 0;
                        widgetsList2.mHeight = 0;
                        widgetsList2.mStartIndex = 0;
                        widgetsList2.mCount = 0;
                        widgetsList2.mNbMatchConstraintsWidgets = 0;
                        widgetsList2.setup(i39, flow.mLeft, flow.mTop, flow.mRight, flow.mBottom, flow.mResolvedPaddingLeft, flow.mPaddingTop, flow.mResolvedPaddingRight, flow.mPaddingBottom, i32);
                        widgetsList = widgetsList2;
                    }
                    for (int i40 = 0; i40 < i38; i40++) {
                        widgetsList.add(constraintWidgetArr4[i40]);
                    }
                    c = 0;
                    iArr[0] = widgetsList.getWidth();
                    c2 = 1;
                    iArr[1] = widgetsList.getHeight();
                    int i41 = iArr[c] + i11 + i10;
                    int i42 = iArr[c2] + i9 + i8;
                    if (mode != 1073741824) {
                    }
                    if (mode2 != 1073741824) {
                    }
                    flow.mMeasuredWidth = size;
                    flow.mMeasuredHeight = i12;
                    flow.setWidth(size);
                    flow.setHeight(i12);
                    flow.mNeedsCallFromSolver = flow.mWidgetsCount <= 0;
                    setMeasuredDimension(flow.mMeasuredWidth, flow.mMeasuredHeight);
                    return;
                }
            } else if (i37 == 1) {
                i8 = i29;
                iArr = iArr3;
                i7 = size2;
                i11 = i26;
                i10 = i3;
                i9 = i5;
                int i43 = i6;
                ConstraintWidget[] constraintWidgetArr5 = constraintWidgetArr;
                int i44 = flow.mOrientation;
                if (i43 != 0) {
                    arrayList3.clear();
                    Flow.WidgetsList widgetsList3 = new Flow.WidgetsList(i44, flow.mLeft, flow.mTop, flow.mRight, flow.mBottom, i32);
                    arrayList3.add(widgetsList3);
                    if (i44 == 0) {
                        i13 = 0;
                        int i45 = 0;
                        for (int i46 = 0; i46 < i43; i46++) {
                            ConstraintWidget constraintWidget5 = constraintWidgetArr5[i46];
                            int widgetWidth = flow.getWidgetWidth(constraintWidget5, i32);
                            if (constraintWidget5.mListDimensionBehaviors[0] == 3) {
                                i13++;
                            }
                            i13 = i13;
                            boolean z2 = (i45 == i32 || (flow.mHorizontalGap + i45) + widgetWidth > i32) && widgetsList3.mBiggest != null;
                            if (!z2 && i46 > 0 && (i15 = flow.mMaxElementsWrap) > 0 && i46 % i15 == 0) {
                                z2 = true;
                            }
                            if (z2) {
                                widgetsList3 = new Flow.WidgetsList(i44, flow.mLeft, flow.mTop, flow.mRight, flow.mBottom, i32);
                                widgetsList3.mStartIndex = i46;
                                arrayList3.add(widgetsList3);
                            } else if (i46 > 0) {
                                i45 = flow.mHorizontalGap + widgetWidth + i45;
                                widgetsList3.add(constraintWidget5);
                            }
                            i45 = widgetWidth;
                            widgetsList3.add(constraintWidget5);
                        }
                    } else {
                        i13 = 0;
                        int i47 = 0;
                        for (int i48 = 0; i48 < i43; i48++) {
                            ConstraintWidget constraintWidget6 = constraintWidgetArr5[i48];
                            int widgetHeight = flow.getWidgetHeight(constraintWidget6, i32);
                            if (constraintWidget6.mListDimensionBehaviors[1] == 3) {
                                i13++;
                            }
                            i13 = i13;
                            boolean z3 = (i47 == i32 || (flow.mVerticalGap + i47) + widgetHeight > i32) && widgetsList3.mBiggest != null;
                            if (!z3 && i48 > 0 && (i14 = flow.mMaxElementsWrap) > 0 && i48 % i14 == 0) {
                                z3 = true;
                            }
                            if (z3) {
                                widgetsList3 = new Flow.WidgetsList(i44, flow.mLeft, flow.mTop, flow.mRight, flow.mBottom, i32);
                                widgetsList3.mStartIndex = i48;
                                arrayList3.add(widgetsList3);
                            } else if (i48 > 0) {
                                i47 = flow.mVerticalGap + widgetHeight + i47;
                                widgetsList3.add(constraintWidget6);
                            }
                            i47 = widgetHeight;
                            widgetsList3.add(constraintWidget6);
                        }
                    }
                    int size3 = arrayList3.size();
                    int i49 = flow.mResolvedPaddingLeft;
                    int i50 = flow.mPaddingTop;
                    int i51 = flow.mResolvedPaddingRight;
                    int i52 = flow.mPaddingBottom;
                    boolean z4 = iArr2[0] == 2 || iArr2[1] == 2;
                    if (i13 > 0 && z4) {
                        for (int i53 = 0; i53 < size3; i53++) {
                            Flow.WidgetsList widgetsList4 = (Flow.WidgetsList) arrayList3.get(i53);
                            if (i44 == 0) {
                                widgetsList4.measureMatchConstraints(i32 - widgetsList4.getWidth());
                            } else {
                                widgetsList4.measureMatchConstraints(i32 - widgetsList4.getHeight());
                            }
                        }
                    }
                    int i54 = i49;
                    int i55 = i50;
                    int i56 = i51;
                    int i57 = i52;
                    ConstraintAnchor constraintAnchor11 = constraintAnchor8;
                    ConstraintAnchor constraintAnchor12 = constraintAnchor9;
                    ConstraintAnchor constraintAnchor13 = constraintAnchor10;
                    ConstraintAnchor constraintAnchor14 = constraintAnchor4;
                    int i58 = 0;
                    int i59 = 0;
                    for (int i60 = 0; i60 < size3; i60++) {
                        Flow.WidgetsList widgetsList5 = (Flow.WidgetsList) arrayList3.get(i60);
                        if (i44 == 0) {
                            if (i60 < size3 - 1) {
                                constraintAnchor13 = ((Flow.WidgetsList) arrayList3.get(i60 + 1)).mBiggest.mTop;
                                i57 = 0;
                            } else {
                                i57 = flow.mPaddingBottom;
                                constraintAnchor13 = constraintAnchor10;
                            }
                            ConstraintAnchor constraintAnchor15 = widgetsList5.mBiggest.mBottom;
                            widgetsList5.setup(i44, constraintAnchor11, constraintAnchor14, constraintAnchor12, constraintAnchor13, i54, i55, i56, i57, i32);
                            i58 = Math.max(i58, widgetsList5.getWidth());
                            int height = widgetsList5.getHeight() + i59;
                            if (i60 > 0) {
                                height += flow.mVerticalGap;
                            }
                            i59 = height;
                            constraintAnchor14 = constraintAnchor15;
                            i55 = 0;
                        } else {
                            if (i60 < size3 - 1) {
                                constraintAnchor12 = ((Flow.WidgetsList) arrayList3.get(i60 + 1)).mBiggest.mLeft;
                                i56 = 0;
                            } else {
                                i56 = flow.mResolvedPaddingRight;
                                constraintAnchor12 = constraintAnchor9;
                            }
                            ConstraintAnchor constraintAnchor16 = widgetsList5.mBiggest.mRight;
                            widgetsList5.setup(i44, constraintAnchor11, constraintAnchor14, constraintAnchor12, constraintAnchor13, i54, i55, i56, i57, i32);
                            int width = widgetsList5.getWidth() + i58;
                            i59 = Math.max(i59, widgetsList5.getHeight());
                            if (i60 > 0) {
                                width += flow.mHorizontalGap;
                            }
                            i58 = width;
                            constraintAnchor11 = constraintAnchor16;
                            i54 = 0;
                        }
                    }
                    iArr[0] = i58;
                    iArr[1] = i59;
                }
            } else if (i37 == 2) {
                ConstraintWidget[] constraintWidgetArr6 = constraintWidgetArr;
                int i61 = i6;
                i8 = i29;
                iArr = iArr3;
                i7 = size2;
                i11 = i26;
                i10 = i3;
                i9 = i5;
                int i62 = flow.mOrientation;
                if (i62 == 0) {
                    int i63 = flow.mMaxElementsWrap;
                    if (i63 <= 0) {
                        int i64 = 0;
                        i16 = 0;
                        for (int i65 = 0; i65 < i61; i65++) {
                            if (i65 > 0) {
                                i64 += flow.mHorizontalGap;
                            }
                            ConstraintWidget constraintWidget7 = constraintWidgetArr6[i65];
                            if (constraintWidget7 != null) {
                                int widgetWidth2 = flow.getWidgetWidth(constraintWidget7, i32) + i64;
                                if (widgetWidth2 > i32) {
                                    break;
                                }
                                i16++;
                                i64 = widgetWidth2;
                            }
                        }
                    } else {
                        i16 = i63;
                    }
                    i17 = 0;
                } else {
                    i17 = flow.mMaxElementsWrap;
                    if (i17 <= 0) {
                        int i66 = 0;
                        int i67 = 0;
                        for (int i68 = 0; i68 < i61; i68++) {
                            if (i68 > 0) {
                                i66 += flow.mVerticalGap;
                            }
                            ConstraintWidget constraintWidget8 = constraintWidgetArr6[i68];
                            if (constraintWidget8 != null) {
                                int widgetHeight2 = flow.getWidgetHeight(constraintWidget8, i32) + i66;
                                if (widgetHeight2 > i32) {
                                    break;
                                }
                                i67++;
                                i66 = widgetHeight2;
                            }
                        }
                        i17 = i67;
                    }
                    i16 = 0;
                }
                if (flow.mAlignedDimensions == null) {
                    flow.mAlignedDimensions = new int[2];
                }
                if (!((i17 == 0 && i62 == 1) || (i16 == 0 && i62 == 0))) {
                    z = false;
                    while (!z) {
                        if (i62 == 0) {
                            i17 = (int) Math.ceil(i61 / i16);
                        } else {
                            i16 = (int) Math.ceil(i61 / i17);
                        }
                        ConstraintWidget[] constraintWidgetArr7 = flow.mAlignedBiggestElementsInCols;
                        if (constraintWidgetArr7 == null || constraintWidgetArr7.length < i16) {
                            obj = null;
                            flow.mAlignedBiggestElementsInCols = new ConstraintWidget[i16];
                        } else {
                            obj = null;
                            Arrays.fill(constraintWidgetArr7, (Object) null);
                        }
                        ConstraintWidget[] constraintWidgetArr8 = flow.mAlignedBiggestElementsInRows;
                        if (constraintWidgetArr8 == null || constraintWidgetArr8.length < i17) {
                            flow.mAlignedBiggestElementsInRows = new ConstraintWidget[i17];
                        } else {
                            Arrays.fill(constraintWidgetArr8, obj);
                        }
                        for (int i69 = 0; i69 < i16; i69++) {
                            for (int i70 = 0; i70 < i17; i70++) {
                                int i71 = (i70 * i16) + i69;
                                if (i62 == 1) {
                                    i71 = (i69 * i17) + i70;
                                }
                                if (i71 < constraintWidgetArr6.length && (constraintWidget = constraintWidgetArr6[i71]) != null) {
                                    int widgetWidth3 = flow.getWidgetWidth(constraintWidget, i32);
                                    ConstraintWidget constraintWidget9 = flow.mAlignedBiggestElementsInCols[i69];
                                    if (constraintWidget9 == null || constraintWidget9.getWidth() < widgetWidth3) {
                                        flow.mAlignedBiggestElementsInCols[i69] = constraintWidget;
                                    }
                                    int widgetHeight3 = flow.getWidgetHeight(constraintWidget, i32);
                                    ConstraintWidget constraintWidget10 = flow.mAlignedBiggestElementsInRows[i70];
                                    if (constraintWidget10 == null || constraintWidget10.getHeight() < widgetHeight3) {
                                        flow.mAlignedBiggestElementsInRows[i70] = constraintWidget;
                                    }
                                }
                            }
                        }
                        int i72 = 0;
                        for (int i73 = 0; i73 < i16; i73++) {
                            ConstraintWidget constraintWidget11 = flow.mAlignedBiggestElementsInCols[i73];
                            if (constraintWidget11 != null) {
                                if (i73 > 0) {
                                    i72 += flow.mHorizontalGap;
                                }
                                i72 = flow.getWidgetWidth(constraintWidget11, i32) + i72;
                            }
                        }
                        int i74 = 0;
                        for (int i75 = 0; i75 < i17; i75++) {
                            ConstraintWidget constraintWidget12 = flow.mAlignedBiggestElementsInRows[i75];
                            if (constraintWidget12 != null) {
                                if (i75 > 0) {
                                    i74 += flow.mVerticalGap;
                                }
                                i74 = flow.getWidgetHeight(constraintWidget12, i32) + i74;
                            }
                        }
                        iArr[0] = i72;
                        iArr[1] = i74;
                        if (i62 != 0) {
                            if (i74 > i32 && i17 > 1) {
                                i17--;
                            }
                        } else if (i72 > i32 && i16 > 1) {
                            i16--;
                        }
                        while (!z) {
                        }
                    }
                    c2 = 1;
                    int[] iArr4 = flow.mAlignedDimensions;
                    iArr4[0] = i16;
                    iArr4[1] = i17;
                    c = 0;
                    int i412 = iArr[c] + i11 + i10;
                    int i422 = iArr[c2] + i9 + i8;
                    if (mode != 1073741824) {
                        if (mode == Integer.MIN_VALUE) {
                            size = Math.min(i412, size);
                        } else {
                            size = mode == 0 ? i412 : 0;
                        }
                    }
                    if (mode2 != 1073741824) {
                        i12 = i7;
                    } else if (mode2 == Integer.MIN_VALUE) {
                        i12 = Math.min(i422, i7);
                    } else {
                        i12 = mode2 == 0 ? i422 : 0;
                    }
                    flow.mMeasuredWidth = size;
                    flow.mMeasuredHeight = i12;
                    flow.setWidth(size);
                    flow.setHeight(i12);
                    flow.mNeedsCallFromSolver = flow.mWidgetsCount <= 0;
                    setMeasuredDimension(flow.mMeasuredWidth, flow.mMeasuredHeight);
                    return;
                }
                z = true;
                while (!z) {
                }
                c2 = 1;
                int[] iArr42 = flow.mAlignedDimensions;
                iArr42[0] = i16;
                iArr42[1] = i17;
                c = 0;
                int i4122 = iArr[c] + i11 + i10;
                int i4222 = iArr[c2] + i9 + i8;
                if (mode != 1073741824) {
                }
                if (mode2 != 1073741824) {
                }
                flow.mMeasuredWidth = size;
                flow.mMeasuredHeight = i12;
                flow.setWidth(size);
                flow.setHeight(i12);
                flow.mNeedsCallFromSolver = flow.mWidgetsCount <= 0;
                setMeasuredDimension(flow.mMeasuredWidth, flow.mMeasuredHeight);
                return;
            } else if (i37 != 3) {
                i8 = i29;
                iArr = iArr3;
                i7 = size2;
                i11 = i26;
                i10 = i3;
                i9 = i5;
            } else {
                int i76 = i6;
                int i77 = flow.mOrientation;
                if (i76 == 0) {
                    i8 = i29;
                    iArr = iArr3;
                    i7 = size2;
                    i11 = i26;
                    i10 = i3;
                    i9 = i5;
                } else {
                    arrayList3.clear();
                    ConstraintWidget[] constraintWidgetArr9 = constraintWidgetArr;
                    i11 = i26;
                    i8 = i29;
                    i10 = i3;
                    i9 = i5;
                    iArr = iArr3;
                    Flow.WidgetsList widgetsList6 = new Flow.WidgetsList(i77, flow.mLeft, flow.mTop, flow.mRight, flow.mBottom, i32);
                    arrayList3.add(widgetsList6);
                    if (i77 == 0) {
                        int i78 = 0;
                        int i79 = 0;
                        i18 = 0;
                        int i80 = 0;
                        while (i78 < i76) {
                            i79++;
                            ConstraintWidget constraintWidget13 = constraintWidgetArr9[i78];
                            int widgetWidth4 = flow.getWidgetWidth(constraintWidget13, i32);
                            int i81 = i77;
                            int i82 = i78;
                            if (constraintWidget13.mListDimensionBehaviors[0] == 3) {
                                i18++;
                            }
                            i18 = i18;
                            boolean z5 = (i80 == i32 || (flow.mHorizontalGap + i80) + widgetWidth4 > i32) && widgetsList6.mBiggest != null;
                            if (!z5 && i82 > 0 && (i22 = flow.mMaxElementsWrap) > 0 && i79 > i22) {
                                z5 = true;
                            }
                            if (z5) {
                                i20 = size2;
                                i77 = i81;
                                i21 = i82;
                                widgetsList6 = new Flow.WidgetsList(i77, flow.mLeft, flow.mTop, flow.mRight, flow.mBottom, i32);
                                widgetsList6.mStartIndex = i21;
                                arrayList3.add(widgetsList6);
                                i80 = widgetWidth4;
                                i79 = 1;
                            } else {
                                i20 = size2;
                                i77 = i81;
                                i21 = i82;
                                i80 = i21 > 0 ? flow.mHorizontalGap + widgetWidth4 + i80 : widgetWidth4;
                            }
                            widgetsList6.add(constraintWidget13);
                            i78 = i21 + 1;
                            size2 = i20;
                        }
                        i7 = size2;
                    } else {
                        i7 = size2;
                        int i83 = 0;
                        int i84 = 0;
                        int i85 = 0;
                        int i86 = 0;
                        while (i83 < i76) {
                            i84++;
                            ConstraintWidget constraintWidget14 = constraintWidgetArr9[i83];
                            int widgetHeight4 = flow.getWidgetHeight(constraintWidget14, i32);
                            int i87 = i77;
                            if (constraintWidget14.mListDimensionBehaviors[1] == 3) {
                                i85++;
                            }
                            i85 = i85;
                            boolean z6 = (i86 == i32 || (flow.mVerticalGap + i86) + widgetHeight4 > i32) && widgetsList6.mBiggest != null;
                            if (!z6 && i83 > 0 && (i19 = flow.mMaxElementsWrap) > 0 && i84 > i19) {
                                z6 = true;
                            }
                            if (z6) {
                                i77 = i87;
                                widgetsList6 = new Flow.WidgetsList(i77, flow.mLeft, flow.mTop, flow.mRight, flow.mBottom, i32);
                                widgetsList6.mStartIndex = i83;
                                arrayList3.add(widgetsList6);
                                i86 = widgetHeight4;
                                i84 = 1;
                            } else {
                                i77 = i87;
                                i86 = i83 > 0 ? flow.mVerticalGap + widgetHeight4 + i86 : widgetHeight4;
                            }
                            widgetsList6.add(constraintWidget14);
                            i83++;
                        }
                        i18 = i85;
                    }
                    int size4 = arrayList3.size();
                    int i88 = flow.mResolvedPaddingLeft;
                    int i89 = flow.mPaddingTop;
                    int i90 = flow.mResolvedPaddingRight;
                    int i91 = flow.mPaddingBottom;
                    boolean z7 = iArr2[0] == 2 || iArr2[1] == 2;
                    if (i18 > 0 && z7) {
                        for (int i92 = 0; i92 < size4; i92++) {
                            Flow.WidgetsList widgetsList7 = (Flow.WidgetsList) arrayList3.get(i92);
                            if (i77 == 0) {
                                widgetsList7.measureMatchConstraints(i32 - widgetsList7.getWidth());
                            } else {
                                widgetsList7.measureMatchConstraints(i32 - widgetsList7.getHeight());
                            }
                        }
                    }
                    int i93 = i88;
                    int i94 = i89;
                    int i95 = i90;
                    int i96 = i91;
                    ConstraintAnchor constraintAnchor17 = constraintAnchor8;
                    ConstraintAnchor constraintAnchor18 = constraintAnchor9;
                    ConstraintAnchor constraintAnchor19 = constraintAnchor10;
                    ConstraintAnchor constraintAnchor20 = constraintAnchor4;
                    int i97 = 0;
                    int i98 = 0;
                    for (int i99 = 0; i99 < size4; i99++) {
                        Flow.WidgetsList widgetsList8 = (Flow.WidgetsList) arrayList3.get(i99);
                        if (i77 == 0) {
                            if (i99 < size4 - 1) {
                                constraintAnchor19 = ((Flow.WidgetsList) arrayList3.get(i99 + 1)).mBiggest.mTop;
                                i96 = 0;
                            } else {
                                i96 = flow.mPaddingBottom;
                                constraintAnchor19 = constraintAnchor10;
                            }
                            ConstraintAnchor constraintAnchor21 = widgetsList8.mBiggest.mBottom;
                            widgetsList8.setup(i77, constraintAnchor17, constraintAnchor20, constraintAnchor18, constraintAnchor19, i93, i94, i95, i96, i32);
                            i97 = Math.max(i97, widgetsList8.getWidth());
                            int height2 = widgetsList8.getHeight() + i98;
                            if (i99 > 0) {
                                height2 += flow.mVerticalGap;
                            }
                            i98 = height2;
                            constraintAnchor20 = constraintAnchor21;
                            i94 = 0;
                        } else {
                            if (i99 < size4 - 1) {
                                constraintAnchor18 = ((Flow.WidgetsList) arrayList3.get(i99 + 1)).mBiggest.mLeft;
                                i95 = 0;
                            } else {
                                i95 = flow.mResolvedPaddingRight;
                                constraintAnchor18 = constraintAnchor9;
                            }
                            ConstraintAnchor constraintAnchor22 = widgetsList8.mBiggest.mRight;
                            widgetsList8.setup(i77, constraintAnchor17, constraintAnchor20, constraintAnchor18, constraintAnchor19, i93, i94, i95, i96, i32);
                            int width2 = widgetsList8.getWidth() + i97;
                            i98 = Math.max(i98, widgetsList8.getHeight());
                            if (i99 > 0) {
                                width2 += flow.mHorizontalGap;
                            }
                            i97 = width2;
                            constraintAnchor17 = constraintAnchor22;
                            i93 = 0;
                        }
                    }
                    iArr[0] = i97;
                    iArr[1] = i98;
                }
            }
            c2 = 1;
            c = 0;
            int i41222 = iArr[c] + i11 + i10;
            int i42222 = iArr[c2] + i9 + i8;
            if (mode != 1073741824) {
            }
            if (mode2 != 1073741824) {
            }
            flow.mMeasuredWidth = size;
            flow.mMeasuredHeight = i12;
            flow.setWidth(size);
            flow.setHeight(i12);
            flow.mNeedsCallFromSolver = flow.mWidgetsCount <= 0;
            setMeasuredDimension(flow.mMeasuredWidth, flow.mMeasuredHeight);
            return;
        }
        setMeasuredDimension(0, 0);
    }
}
