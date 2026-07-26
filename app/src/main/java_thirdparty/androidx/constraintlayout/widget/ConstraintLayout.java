package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.SolverVariable$Type$EnumUnboxingSharedUtility;
import androidx.constraintlayout.core.widgets.Chain;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.Flow;
import androidx.constraintlayout.core.widgets.Guideline;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measure;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.zzcl;
import com.emanuelef.remote_capture.fragments.LogviewFragment;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes.dex */
public class ConstraintLayout extends ViewGroup {
    public static SharedValues sSharedValues;
    public final SparseArray mChildrenByIds = new SparseArray();
    public final ArrayList mConstraintHelpers = new ArrayList(4);
    public final ConstraintWidgetContainer mLayoutWidget = new ConstraintWidgetContainer();
    public int mMinWidth = 0;
    public int mMinHeight = 0;
    public int mMaxWidth = Integer.MAX_VALUE;
    public int mMaxHeight = Integer.MAX_VALUE;
    public boolean mDirtyHierarchy = true;
    public int mOptimizationLevel = 257;
    public ConstraintSet mConstraintSet = null;
    public zzcl mConstraintLayoutSpec = null;
    public int mConstraintSetId = -1;
    public HashMap mDesignIds = new HashMap();
    public final SparseArray mTempMapIdToWidget = new SparseArray();
    public final Measurer mMeasurer = new Measurer(this);

    /* loaded from: classes.dex */
    public final class LayoutParams extends ViewGroup.MarginLayoutParams {
        public int baselineMargin;
        public int baselineToBaseline;
        public int baselineToBottom;
        public int baselineToTop;
        public int bottomToBottom;
        public int bottomToTop;
        public float circleAngle;
        public int circleConstraint;
        public int circleRadius;
        public boolean constrainedHeight;
        public boolean constrainedWidth;
        public String constraintTag;
        public String dimensionRatio;
        public int editorAbsoluteX;
        public int editorAbsoluteY;
        public int endToEnd;
        public int endToStart;
        public int goneBaselineMargin;
        public int goneBottomMargin;
        public int goneEndMargin;
        public int goneLeftMargin;
        public int goneRightMargin;
        public int goneStartMargin;
        public int goneTopMargin;
        public int guideBegin;
        public int guideEnd;
        public float guidePercent;
        public boolean guidelineUseRtl;
        public float horizontalBias;
        public int horizontalChainStyle;
        public float horizontalWeight;
        public int leftToLeft;
        public int leftToRight;
        public boolean mHorizontalDimensionFixed;
        public boolean mIsGuideline;
        public boolean mIsHelper;
        public boolean mNeedsBaseline;
        public int mResolveGoneLeftMargin;
        public int mResolveGoneRightMargin;
        public int mResolvedGuideBegin;
        public int mResolvedGuideEnd;
        public float mResolvedGuidePercent;
        public float mResolvedHorizontalBias;
        public int mResolvedLeftToLeft;
        public int mResolvedLeftToRight;
        public int mResolvedRightToLeft;
        public int mResolvedRightToRight;
        public boolean mVerticalDimensionFixed;
        public ConstraintWidget mWidget;
        public int matchConstraintDefaultHeight;
        public int matchConstraintDefaultWidth;
        public int matchConstraintMaxHeight;
        public int matchConstraintMaxWidth;
        public int matchConstraintMinHeight;
        public int matchConstraintMinWidth;
        public float matchConstraintPercentHeight;
        public float matchConstraintPercentWidth;
        public int orientation;
        public int rightToLeft;
        public int rightToRight;
        public int startToEnd;
        public int startToStart;
        public int topToBottom;
        public int topToTop;
        public float verticalBias;
        public int verticalChainStyle;
        public float verticalWeight;
        public int wrapBehaviorInParent;

        /* loaded from: classes.dex */
        public abstract class Table {
            public static final SparseIntArray sMap;

            static {
                SparseIntArray sparseIntArray = new SparseIntArray();
                sMap = sparseIntArray;
                sparseIntArray.append(98, 64);
                sparseIntArray.append(75, 65);
                sparseIntArray.append(84, 8);
                sparseIntArray.append(85, 9);
                sparseIntArray.append(87, 10);
                sparseIntArray.append(88, 11);
                sparseIntArray.append(94, 12);
                sparseIntArray.append(93, 13);
                sparseIntArray.append(65, 14);
                sparseIntArray.append(64, 15);
                sparseIntArray.append(60, 16);
                sparseIntArray.append(62, 52);
                sparseIntArray.append(61, 53);
                sparseIntArray.append(66, 2);
                sparseIntArray.append(68, 3);
                sparseIntArray.append(67, 4);
                sparseIntArray.append(103, 49);
                sparseIntArray.append(104, 50);
                sparseIntArray.append(72, 5);
                sparseIntArray.append(73, 6);
                sparseIntArray.append(74, 7);
                sparseIntArray.append(55, 67);
                sparseIntArray.append(0, 1);
                sparseIntArray.append(89, 17);
                sparseIntArray.append(90, 18);
                sparseIntArray.append(71, 19);
                sparseIntArray.append(70, 20);
                sparseIntArray.append(108, 21);
                sparseIntArray.append(111, 22);
                sparseIntArray.append(109, 23);
                sparseIntArray.append(106, 24);
                sparseIntArray.append(110, 25);
                sparseIntArray.append(107, 26);
                sparseIntArray.append(105, 55);
                sparseIntArray.append(112, 54);
                sparseIntArray.append(80, 29);
                sparseIntArray.append(95, 30);
                sparseIntArray.append(69, 44);
                sparseIntArray.append(82, 45);
                sparseIntArray.append(97, 46);
                sparseIntArray.append(81, 47);
                sparseIntArray.append(96, 48);
                sparseIntArray.append(58, 27);
                sparseIntArray.append(57, 28);
                sparseIntArray.append(99, 31);
                sparseIntArray.append(76, 32);
                sparseIntArray.append(101, 33);
                sparseIntArray.append(100, 34);
                sparseIntArray.append(102, 35);
                sparseIntArray.append(78, 36);
                sparseIntArray.append(77, 37);
                sparseIntArray.append(79, 38);
                sparseIntArray.append(83, 39);
                sparseIntArray.append(92, 40);
                sparseIntArray.append(86, 41);
                sparseIntArray.append(63, 42);
                sparseIntArray.append(59, 43);
                sparseIntArray.append(91, 51);
                sparseIntArray.append(114, 66);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x004a  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0051  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0058  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x005e  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0064  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x007a  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x0082  */
        @Override // android.view.ViewGroup.MarginLayoutParams, android.view.ViewGroup.LayoutParams
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void resolveLayoutDirection(int r11) {
            /*
                Method dump skipped, instructions count: 259
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.LayoutParams.resolveLayoutDirection(int):void");
        }

        public final void validate() {
            this.mIsGuideline = false;
            this.mHorizontalDimensionFixed = true;
            this.mVerticalDimensionFixed = true;
            int i = ((ViewGroup.MarginLayoutParams) this).width;
            if (i == -2 && this.constrainedWidth) {
                this.mHorizontalDimensionFixed = false;
                if (this.matchConstraintDefaultWidth == 0) {
                    this.matchConstraintDefaultWidth = 1;
                }
            }
            int i2 = ((ViewGroup.MarginLayoutParams) this).height;
            if (i2 == -2 && this.constrainedHeight) {
                this.mVerticalDimensionFixed = false;
                if (this.matchConstraintDefaultHeight == 0) {
                    this.matchConstraintDefaultHeight = 1;
                }
            }
            if (i == 0 || i == -1) {
                this.mHorizontalDimensionFixed = false;
                if (i == 0 && this.matchConstraintDefaultWidth == 1) {
                    ((ViewGroup.MarginLayoutParams) this).width = -2;
                    this.constrainedWidth = true;
                }
            }
            if (i2 == 0 || i2 == -1) {
                this.mVerticalDimensionFixed = false;
                if (i2 == 0 && this.matchConstraintDefaultHeight == 1) {
                    ((ViewGroup.MarginLayoutParams) this).height = -2;
                    this.constrainedHeight = true;
                }
            }
            if (this.guidePercent != -1.0f || this.guideBegin != -1 || this.guideEnd != -1) {
                this.mIsGuideline = true;
                this.mHorizontalDimensionFixed = true;
                this.mVerticalDimensionFixed = true;
                if (!(this.mWidget instanceof Guideline)) {
                    this.mWidget = new Guideline();
                }
                ((Guideline) this.mWidget).setOrientation(this.orientation);
            }
        }
    }

    /* loaded from: classes.dex */
    public final class Measurer {
        public final ConstraintLayout mLayout;
        public int mLayoutHeightSpec;
        public int mLayoutWidthSpec;
        public int mPaddingBottom;
        public int mPaddingHeight;
        public int mPaddingTop;
        public int mPaddingWidth;

        public Measurer(ConstraintLayout constraintLayout) {
            this.mLayout = constraintLayout;
        }

        public static boolean isSimilarSpec(int i, int i2, int i3) {
            if (i == i2) {
                return true;
            }
            int mode = View.MeasureSpec.getMode(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            if (mode2 != 1073741824) {
                return false;
            }
            if ((mode == Integer.MIN_VALUE || mode == 0) && i3 == size) {
                return true;
            }
            return false;
        }

        public final void measure(ConstraintWidget constraintWidget, BasicMeasure$Measure basicMeasure$Measure) {
            int i;
            int i2;
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4;
            boolean z5;
            boolean z6;
            int i3;
            int i4;
            int i5;
            int i6;
            boolean z7;
            boolean z8;
            boolean z9;
            int i7;
            int i8;
            boolean z10;
            boolean z11;
            int i9;
            boolean z12;
            boolean z13;
            int i10;
            if (constraintWidget != null) {
                ConstraintAnchor constraintAnchor = constraintWidget.mRight;
                ConstraintAnchor constraintAnchor2 = constraintWidget.mLeft;
                if (constraintWidget.mVisibility == 8) {
                    basicMeasure$Measure.measuredWidth = 0;
                    basicMeasure$Measure.measuredHeight = 0;
                    basicMeasure$Measure.measuredBaseline = 0;
                } else if (constraintWidget.mParent != null) {
                    SharedValues sharedValues = ConstraintLayout.sSharedValues;
                    int i11 = basicMeasure$Measure.horizontalBehavior;
                    int i12 = basicMeasure$Measure.verticalBehavior;
                    int i13 = basicMeasure$Measure.horizontalDimension;
                    int i14 = basicMeasure$Measure.verticalDimension;
                    int i15 = this.mPaddingTop + this.mPaddingBottom;
                    int i16 = this.mPaddingWidth;
                    View view = constraintWidget.mCompanionWidget;
                    int ordinal = SolverVariable$Type$EnumUnboxingSharedUtility.ordinal(i11);
                    if (ordinal == 0) {
                        i = View.MeasureSpec.makeMeasureSpec(i13, 1073741824);
                    } else if (ordinal == 1) {
                        i = ViewGroup.getChildMeasureSpec(this.mLayoutWidthSpec, i16, -2);
                    } else if (ordinal == 2) {
                        i = ViewGroup.getChildMeasureSpec(this.mLayoutWidthSpec, i16, -2);
                        if (constraintWidget.mMatchConstraintDefaultWidth == 1) {
                            z12 = true;
                        } else {
                            z12 = false;
                        }
                        int i17 = basicMeasure$Measure.measureStrategy;
                        if (i17 == 1 || i17 == 2) {
                            if (view.getMeasuredHeight() == constraintWidget.getHeight()) {
                                z13 = true;
                            } else {
                                z13 = false;
                            }
                            if (basicMeasure$Measure.measureStrategy == 2 || !z12 || ((z12 && z13) || constraintWidget.isResolvedHorizontally())) {
                                i = View.MeasureSpec.makeMeasureSpec(constraintWidget.getWidth(), 1073741824);
                            }
                        }
                    } else if (ordinal != 3) {
                        i = 0;
                    } else {
                        int i18 = this.mLayoutWidthSpec;
                        if (constraintAnchor2 != null) {
                            i10 = constraintAnchor2.mMargin;
                        } else {
                            i10 = 0;
                        }
                        if (constraintAnchor != null) {
                            i10 += constraintAnchor.mMargin;
                        }
                        i = ViewGroup.getChildMeasureSpec(i18, i16 + i10, -1);
                    }
                    int ordinal2 = SolverVariable$Type$EnumUnboxingSharedUtility.ordinal(i12);
                    if (ordinal2 == 0) {
                        i2 = View.MeasureSpec.makeMeasureSpec(i14, 1073741824);
                    } else if (ordinal2 == 1) {
                        i2 = ViewGroup.getChildMeasureSpec(this.mLayoutHeightSpec, i15, -2);
                    } else if (ordinal2 == 2) {
                        i2 = ViewGroup.getChildMeasureSpec(this.mLayoutHeightSpec, i15, -2);
                        if (constraintWidget.mMatchConstraintDefaultHeight == 1) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        int i19 = basicMeasure$Measure.measureStrategy;
                        if (i19 == 1 || i19 == 2) {
                            if (view.getMeasuredWidth() == constraintWidget.getWidth()) {
                                z11 = true;
                            } else {
                                z11 = false;
                            }
                            if (basicMeasure$Measure.measureStrategy == 2 || !z10 || ((z10 && z11) || constraintWidget.isResolvedVertically())) {
                                i2 = View.MeasureSpec.makeMeasureSpec(constraintWidget.getHeight(), 1073741824);
                            }
                        }
                    } else if (ordinal2 != 3) {
                        i2 = 0;
                    } else {
                        int i20 = this.mLayoutHeightSpec;
                        if (constraintAnchor2 != null) {
                            i9 = constraintWidget.mTop.mMargin;
                        } else {
                            i9 = 0;
                        }
                        if (constraintAnchor != null) {
                            i9 += constraintWidget.mBottom.mMargin;
                        }
                        i2 = ViewGroup.getChildMeasureSpec(i20, i15 + i9, -1);
                    }
                    ConstraintWidgetContainer constraintWidgetContainer = (ConstraintWidgetContainer) constraintWidget.mParent;
                    ConstraintLayout constraintLayout = ConstraintLayout.this;
                    if (constraintWidgetContainer == null || !Chain.enabled(constraintLayout.mOptimizationLevel, 256) || view.getMeasuredWidth() != constraintWidget.getWidth() || view.getMeasuredWidth() >= constraintWidgetContainer.getWidth() || view.getMeasuredHeight() != constraintWidget.getHeight() || view.getMeasuredHeight() >= constraintWidgetContainer.getHeight() || view.getBaseline() != constraintWidget.mBaselineDistance || constraintWidget.isMeasureRequested() || !isSimilarSpec(constraintWidget.mLastHorizontalMeasureSpec, i, constraintWidget.getWidth()) || !isSimilarSpec(constraintWidget.mLastVerticalMeasureSpec, i2, constraintWidget.getHeight())) {
                        if (i11 == 3) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (i12 == 3) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (i12 == 4 || i12 == 1) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (i11 == 4 || i11 == 1) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        if (!z || constraintWidget.mDimensionRatio <= 0.0f) {
                            z5 = false;
                        } else {
                            z5 = true;
                        }
                        if (!z2 || constraintWidget.mDimensionRatio <= 0.0f) {
                            z6 = false;
                        } else {
                            z6 = true;
                        }
                        if (view != null) {
                            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                            int i21 = basicMeasure$Measure.measureStrategy;
                            if (i21 == 1 || i21 == 2 || !z || constraintWidget.mMatchConstraintDefaultWidth != 0 || !z2 || constraintWidget.mMatchConstraintDefaultHeight != 0) {
                                if (!(view instanceof VirtualLayout) || !(constraintWidget instanceof Flow)) {
                                    view.measure(i, i2);
                                } else {
                                    ((VirtualLayout) view).onMeasure((Flow) constraintWidget, i, i2);
                                }
                                constraintWidget.mLastHorizontalMeasureSpec = i;
                                constraintWidget.mLastVerticalMeasureSpec = i2;
                                constraintWidget.mMeasureRequested = false;
                                int measuredWidth = view.getMeasuredWidth();
                                int measuredHeight = view.getMeasuredHeight();
                                int baseline = view.getBaseline();
                                int i22 = constraintWidget.mMatchConstraintMinWidth;
                                if (i22 > 0) {
                                    i7 = Math.max(i22, measuredWidth);
                                } else {
                                    i7 = measuredWidth;
                                }
                                int i23 = constraintWidget.mMatchConstraintMaxWidth;
                                if (i23 > 0) {
                                    i7 = Math.min(i23, i7);
                                }
                                int i24 = constraintWidget.mMatchConstraintMinHeight;
                                if (i24 > 0) {
                                    i3 = Math.max(i24, measuredHeight);
                                } else {
                                    i3 = measuredHeight;
                                }
                                int i25 = i2;
                                int i26 = constraintWidget.mMatchConstraintMaxHeight;
                                if (i26 > 0) {
                                    i3 = Math.min(i26, i3);
                                }
                                if (!Chain.enabled(constraintLayout.mOptimizationLevel, 1)) {
                                    if (z5 && z3) {
                                        i7 = (int) ((i3 * constraintWidget.mDimensionRatio) + 0.5f);
                                    } else if (z6 && z4) {
                                        i3 = (int) ((i7 / constraintWidget.mDimensionRatio) + 0.5f);
                                    }
                                }
                                if (measuredWidth == i7 && measuredHeight == i3) {
                                    i5 = baseline;
                                    i6 = i7;
                                } else {
                                    if (measuredWidth != i7) {
                                        i = View.MeasureSpec.makeMeasureSpec(i7, 1073741824);
                                    }
                                    if (measuredHeight != i3) {
                                        i8 = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
                                    } else {
                                        i8 = i25;
                                    }
                                    view.measure(i, i8);
                                    constraintWidget.mLastHorizontalMeasureSpec = i;
                                    constraintWidget.mLastVerticalMeasureSpec = i8;
                                    constraintWidget.mMeasureRequested = false;
                                    i6 = view.getMeasuredWidth();
                                    int measuredHeight2 = view.getMeasuredHeight();
                                    i5 = view.getBaseline();
                                    i3 = measuredHeight2;
                                }
                                i4 = -1;
                            } else {
                                i6 = 0;
                                i5 = 0;
                                i4 = -1;
                                i3 = 0;
                            }
                            if (i5 != i4) {
                                z7 = true;
                            } else {
                                z7 = false;
                            }
                            if (i6 == basicMeasure$Measure.horizontalDimension && i3 == basicMeasure$Measure.verticalDimension) {
                                z8 = false;
                            } else {
                                z8 = true;
                            }
                            basicMeasure$Measure.measuredNeedsSolverPass = z8;
                            if (layoutParams.mNeedsBaseline) {
                                z9 = true;
                            } else {
                                z9 = z7;
                            }
                            if (!(!z9 || i5 == -1 || constraintWidget.mBaselineDistance == i5)) {
                                basicMeasure$Measure.measuredNeedsSolverPass = true;
                            }
                            basicMeasure$Measure.measuredWidth = i6;
                            basicMeasure$Measure.measuredHeight = i3;
                            basicMeasure$Measure.measuredHasBaseline = z9;
                            basicMeasure$Measure.measuredBaseline = i5;
                            return;
                        }
                        return;
                    }
                    basicMeasure$Measure.measuredWidth = constraintWidget.getWidth();
                    basicMeasure$Measure.measuredHeight = constraintWidget.getHeight();
                    basicMeasure$Measure.measuredBaseline = constraintWidget.mBaselineDistance;
                }
            }
        }
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet, 0);
    }

    private int getPaddingWidth() {
        int max = Math.max(0, getPaddingRight()) + Math.max(0, getPaddingLeft());
        int max2 = Math.max(0, getPaddingEnd()) + Math.max(0, getPaddingStart());
        if (max2 > 0) {
            return max2;
        }
        return max;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [androidx.constraintlayout.widget.SharedValues, java.lang.Object] */
    public static SharedValues getSharedValues() {
        if (sSharedValues == null) {
            ?? obj = new Object();
            new SparseIntArray();
            new HashMap();
            sSharedValues = obj;
        }
        return sSharedValues;
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        Object tag;
        int size;
        ArrayList arrayList = this.mConstraintHelpers;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            for (int i = 0; i < size; i++) {
                ((ConstraintHelper) arrayList.get(i)).getClass();
            }
        }
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            float width = getWidth();
            float height = getHeight();
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (!(childAt.getVisibility() == 8 || (tag = childAt.getTag()) == null || !(tag instanceof String))) {
                    String[] split = ((String) tag).split(",");
                    if (split.length == 4) {
                        int parseInt = Integer.parseInt(split[0]);
                        int parseInt2 = Integer.parseInt(split[1]);
                        int parseInt3 = Integer.parseInt(split[2]);
                        int i3 = (int) ((parseInt / 1080.0f) * width);
                        int i4 = (int) ((parseInt2 / 1920.0f) * height);
                        Paint paint = new Paint();
                        paint.setColor(-65536);
                        float f = i3;
                        float f2 = i4;
                        float f3 = i3 + ((int) ((parseInt3 / 1080.0f) * width));
                        canvas.drawLine(f, f2, f3, f2, paint);
                        float parseInt4 = i4 + ((int) ((Integer.parseInt(split[3]) / 1920.0f) * height));
                        canvas.drawLine(f3, f2, f3, parseInt4, paint);
                        canvas.drawLine(f3, parseInt4, f, parseInt4, paint);
                        canvas.drawLine(f, parseInt4, f, f2, paint);
                        paint.setColor(-16711936);
                        canvas.drawLine(f, f2, f3, parseInt4, paint);
                        canvas.drawLine(f, parseInt4, f3, f2, paint);
                    }
                }
            }
        }
    }

    @Override // android.view.View
    public final void forceLayout() {
        this.mDirtyHierarchy = true;
        super.forceLayout();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.view.ViewGroup$LayoutParams, android.view.ViewGroup$MarginLayoutParams, java.lang.Object, androidx.constraintlayout.widget.ConstraintLayout$LayoutParams] */
    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        Context context = getContext();
        ?? marginLayoutParams = new ViewGroup.MarginLayoutParams(context, attributeSet);
        marginLayoutParams.guideBegin = -1;
        marginLayoutParams.guideEnd = -1;
        marginLayoutParams.guidePercent = -1.0f;
        marginLayoutParams.guidelineUseRtl = true;
        marginLayoutParams.leftToLeft = -1;
        marginLayoutParams.leftToRight = -1;
        marginLayoutParams.rightToLeft = -1;
        marginLayoutParams.rightToRight = -1;
        marginLayoutParams.topToTop = -1;
        marginLayoutParams.topToBottom = -1;
        marginLayoutParams.bottomToTop = -1;
        marginLayoutParams.bottomToBottom = -1;
        marginLayoutParams.baselineToBaseline = -1;
        marginLayoutParams.baselineToTop = -1;
        marginLayoutParams.baselineToBottom = -1;
        marginLayoutParams.circleConstraint = -1;
        marginLayoutParams.circleRadius = 0;
        marginLayoutParams.circleAngle = 0.0f;
        marginLayoutParams.startToEnd = -1;
        marginLayoutParams.startToStart = -1;
        marginLayoutParams.endToStart = -1;
        marginLayoutParams.endToEnd = -1;
        marginLayoutParams.goneLeftMargin = Integer.MIN_VALUE;
        marginLayoutParams.goneTopMargin = Integer.MIN_VALUE;
        marginLayoutParams.goneRightMargin = Integer.MIN_VALUE;
        marginLayoutParams.goneBottomMargin = Integer.MIN_VALUE;
        marginLayoutParams.goneStartMargin = Integer.MIN_VALUE;
        marginLayoutParams.goneEndMargin = Integer.MIN_VALUE;
        marginLayoutParams.goneBaselineMargin = Integer.MIN_VALUE;
        marginLayoutParams.baselineMargin = 0;
        marginLayoutParams.horizontalBias = 0.5f;
        marginLayoutParams.verticalBias = 0.5f;
        marginLayoutParams.dimensionRatio = null;
        marginLayoutParams.horizontalWeight = -1.0f;
        marginLayoutParams.verticalWeight = -1.0f;
        marginLayoutParams.horizontalChainStyle = 0;
        marginLayoutParams.verticalChainStyle = 0;
        marginLayoutParams.matchConstraintDefaultWidth = 0;
        marginLayoutParams.matchConstraintDefaultHeight = 0;
        marginLayoutParams.matchConstraintMinWidth = 0;
        marginLayoutParams.matchConstraintMinHeight = 0;
        marginLayoutParams.matchConstraintMaxWidth = 0;
        marginLayoutParams.matchConstraintMaxHeight = 0;
        marginLayoutParams.matchConstraintPercentWidth = 1.0f;
        marginLayoutParams.matchConstraintPercentHeight = 1.0f;
        marginLayoutParams.editorAbsoluteX = -1;
        marginLayoutParams.editorAbsoluteY = -1;
        marginLayoutParams.orientation = -1;
        marginLayoutParams.constrainedWidth = false;
        marginLayoutParams.constrainedHeight = false;
        marginLayoutParams.constraintTag = null;
        marginLayoutParams.wrapBehaviorInParent = 0;
        marginLayoutParams.mHorizontalDimensionFixed = true;
        marginLayoutParams.mVerticalDimensionFixed = true;
        marginLayoutParams.mNeedsBaseline = false;
        marginLayoutParams.mIsGuideline = false;
        marginLayoutParams.mIsHelper = false;
        marginLayoutParams.mResolvedLeftToLeft = -1;
        marginLayoutParams.mResolvedLeftToRight = -1;
        marginLayoutParams.mResolvedRightToLeft = -1;
        marginLayoutParams.mResolvedRightToRight = -1;
        marginLayoutParams.mResolveGoneLeftMargin = Integer.MIN_VALUE;
        marginLayoutParams.mResolveGoneRightMargin = Integer.MIN_VALUE;
        marginLayoutParams.mResolvedHorizontalBias = 0.5f;
        marginLayoutParams.mWidget = new ConstraintWidget();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ConstraintLayout_Layout);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            int i2 = LayoutParams.Table.sMap.get(index);
            switch (i2) {
                case 1:
                    marginLayoutParams.orientation = obtainStyledAttributes.getInt(index, marginLayoutParams.orientation);
                    break;
                case 2:
                    int resourceId = obtainStyledAttributes.getResourceId(index, marginLayoutParams.circleConstraint);
                    marginLayoutParams.circleConstraint = resourceId;
                    if (resourceId == -1) {
                        marginLayoutParams.circleConstraint = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    marginLayoutParams.circleRadius = obtainStyledAttributes.getDimensionPixelSize(index, marginLayoutParams.circleRadius);
                    break;
                case 4:
                    float f = obtainStyledAttributes.getFloat(index, marginLayoutParams.circleAngle) % 360.0f;
                    marginLayoutParams.circleAngle = f;
                    if (f < 0.0f) {
                        marginLayoutParams.circleAngle = (360.0f - f) % 360.0f;
                        break;
                    } else {
                        break;
                    }
                case 5:
                    marginLayoutParams.guideBegin = obtainStyledAttributes.getDimensionPixelOffset(index, marginLayoutParams.guideBegin);
                    break;
                case 6:
                    marginLayoutParams.guideEnd = obtainStyledAttributes.getDimensionPixelOffset(index, marginLayoutParams.guideEnd);
                    break;
                case 7:
                    marginLayoutParams.guidePercent = obtainStyledAttributes.getFloat(index, marginLayoutParams.guidePercent);
                    break;
                case 8:
                    int resourceId2 = obtainStyledAttributes.getResourceId(index, marginLayoutParams.leftToLeft);
                    marginLayoutParams.leftToLeft = resourceId2;
                    if (resourceId2 == -1) {
                        marginLayoutParams.leftToLeft = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    int resourceId3 = obtainStyledAttributes.getResourceId(index, marginLayoutParams.leftToRight);
                    marginLayoutParams.leftToRight = resourceId3;
                    if (resourceId3 == -1) {
                        marginLayoutParams.leftToRight = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 10:
                    int resourceId4 = obtainStyledAttributes.getResourceId(index, marginLayoutParams.rightToLeft);
                    marginLayoutParams.rightToLeft = resourceId4;
                    if (resourceId4 == -1) {
                        marginLayoutParams.rightToLeft = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    int resourceId5 = obtainStyledAttributes.getResourceId(index, marginLayoutParams.rightToRight);
                    marginLayoutParams.rightToRight = resourceId5;
                    if (resourceId5 == -1) {
                        marginLayoutParams.rightToRight = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    int resourceId6 = obtainStyledAttributes.getResourceId(index, marginLayoutParams.topToTop);
                    marginLayoutParams.topToTop = resourceId6;
                    if (resourceId6 == -1) {
                        marginLayoutParams.topToTop = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    int resourceId7 = obtainStyledAttributes.getResourceId(index, marginLayoutParams.topToBottom);
                    marginLayoutParams.topToBottom = resourceId7;
                    if (resourceId7 == -1) {
                        marginLayoutParams.topToBottom = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    int resourceId8 = obtainStyledAttributes.getResourceId(index, marginLayoutParams.bottomToTop);
                    marginLayoutParams.bottomToTop = resourceId8;
                    if (resourceId8 == -1) {
                        marginLayoutParams.bottomToTop = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    int resourceId9 = obtainStyledAttributes.getResourceId(index, marginLayoutParams.bottomToBottom);
                    marginLayoutParams.bottomToBottom = resourceId9;
                    if (resourceId9 == -1) {
                        marginLayoutParams.bottomToBottom = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    int resourceId10 = obtainStyledAttributes.getResourceId(index, marginLayoutParams.baselineToBaseline);
                    marginLayoutParams.baselineToBaseline = resourceId10;
                    if (resourceId10 == -1) {
                        marginLayoutParams.baselineToBaseline = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 17:
                    int resourceId11 = obtainStyledAttributes.getResourceId(index, marginLayoutParams.startToEnd);
                    marginLayoutParams.startToEnd = resourceId11;
                    if (resourceId11 == -1) {
                        marginLayoutParams.startToEnd = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 18:
                    int resourceId12 = obtainStyledAttributes.getResourceId(index, marginLayoutParams.startToStart);
                    marginLayoutParams.startToStart = resourceId12;
                    if (resourceId12 == -1) {
                        marginLayoutParams.startToStart = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 19:
                    int resourceId13 = obtainStyledAttributes.getResourceId(index, marginLayoutParams.endToStart);
                    marginLayoutParams.endToStart = resourceId13;
                    if (resourceId13 == -1) {
                        marginLayoutParams.endToStart = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 20:
                    int resourceId14 = obtainStyledAttributes.getResourceId(index, marginLayoutParams.endToEnd);
                    marginLayoutParams.endToEnd = resourceId14;
                    if (resourceId14 == -1) {
                        marginLayoutParams.endToEnd = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 21:
                    marginLayoutParams.goneLeftMargin = obtainStyledAttributes.getDimensionPixelSize(index, marginLayoutParams.goneLeftMargin);
                    break;
                case 22:
                    marginLayoutParams.goneTopMargin = obtainStyledAttributes.getDimensionPixelSize(index, marginLayoutParams.goneTopMargin);
                    break;
                case 23:
                    marginLayoutParams.goneRightMargin = obtainStyledAttributes.getDimensionPixelSize(index, marginLayoutParams.goneRightMargin);
                    break;
                case 24:
                    marginLayoutParams.goneBottomMargin = obtainStyledAttributes.getDimensionPixelSize(index, marginLayoutParams.goneBottomMargin);
                    break;
                case 25:
                    marginLayoutParams.goneStartMargin = obtainStyledAttributes.getDimensionPixelSize(index, marginLayoutParams.goneStartMargin);
                    break;
                case 26:
                    marginLayoutParams.goneEndMargin = obtainStyledAttributes.getDimensionPixelSize(index, marginLayoutParams.goneEndMargin);
                    break;
                case 27:
                    marginLayoutParams.constrainedWidth = obtainStyledAttributes.getBoolean(index, marginLayoutParams.constrainedWidth);
                    break;
                case 28:
                    marginLayoutParams.constrainedHeight = obtainStyledAttributes.getBoolean(index, marginLayoutParams.constrainedHeight);
                    break;
                case 29:
                    marginLayoutParams.horizontalBias = obtainStyledAttributes.getFloat(index, marginLayoutParams.horizontalBias);
                    break;
                case 30:
                    marginLayoutParams.verticalBias = obtainStyledAttributes.getFloat(index, marginLayoutParams.verticalBias);
                    break;
                case 31:
                    int i3 = obtainStyledAttributes.getInt(index, 0);
                    marginLayoutParams.matchConstraintDefaultWidth = i3;
                    if (i3 == 1) {
                        Log.e("ConstraintLayout", "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.");
                        break;
                    } else {
                        break;
                    }
                case 32:
                    int i4 = obtainStyledAttributes.getInt(index, 0);
                    marginLayoutParams.matchConstraintDefaultHeight = i4;
                    if (i4 == 1) {
                        Log.e("ConstraintLayout", "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.");
                        break;
                    } else {
                        break;
                    }
                case 33:
                    try {
                        marginLayoutParams.matchConstraintMinWidth = obtainStyledAttributes.getDimensionPixelSize(index, marginLayoutParams.matchConstraintMinWidth);
                        break;
                    } catch (Exception unused) {
                        if (obtainStyledAttributes.getInt(index, marginLayoutParams.matchConstraintMinWidth) == -2) {
                            marginLayoutParams.matchConstraintMinWidth = -2;
                            break;
                        } else {
                            break;
                        }
                    }
                case 34:
                    try {
                        marginLayoutParams.matchConstraintMaxWidth = obtainStyledAttributes.getDimensionPixelSize(index, marginLayoutParams.matchConstraintMaxWidth);
                        break;
                    } catch (Exception unused2) {
                        if (obtainStyledAttributes.getInt(index, marginLayoutParams.matchConstraintMaxWidth) == -2) {
                            marginLayoutParams.matchConstraintMaxWidth = -2;
                            break;
                        } else {
                            break;
                        }
                    }
                case 35:
                    marginLayoutParams.matchConstraintPercentWidth = Math.max(0.0f, obtainStyledAttributes.getFloat(index, marginLayoutParams.matchConstraintPercentWidth));
                    marginLayoutParams.matchConstraintDefaultWidth = 2;
                    break;
                case 36:
                    try {
                        marginLayoutParams.matchConstraintMinHeight = obtainStyledAttributes.getDimensionPixelSize(index, marginLayoutParams.matchConstraintMinHeight);
                        break;
                    } catch (Exception unused3) {
                        if (obtainStyledAttributes.getInt(index, marginLayoutParams.matchConstraintMinHeight) == -2) {
                            marginLayoutParams.matchConstraintMinHeight = -2;
                            break;
                        } else {
                            break;
                        }
                    }
                case 37:
                    try {
                        marginLayoutParams.matchConstraintMaxHeight = obtainStyledAttributes.getDimensionPixelSize(index, marginLayoutParams.matchConstraintMaxHeight);
                        break;
                    } catch (Exception unused4) {
                        if (obtainStyledAttributes.getInt(index, marginLayoutParams.matchConstraintMaxHeight) == -2) {
                            marginLayoutParams.matchConstraintMaxHeight = -2;
                            break;
                        } else {
                            break;
                        }
                    }
                case 38:
                    marginLayoutParams.matchConstraintPercentHeight = Math.max(0.0f, obtainStyledAttributes.getFloat(index, marginLayoutParams.matchConstraintPercentHeight));
                    marginLayoutParams.matchConstraintDefaultHeight = 2;
                    break;
                default:
                    switch (i2) {
                        case 44:
                            ConstraintSet.parseDimensionRatioString(marginLayoutParams, obtainStyledAttributes.getString(index));
                            continue;
                        case 45:
                            marginLayoutParams.horizontalWeight = obtainStyledAttributes.getFloat(index, marginLayoutParams.horizontalWeight);
                            continue;
                        case 46:
                            marginLayoutParams.verticalWeight = obtainStyledAttributes.getFloat(index, marginLayoutParams.verticalWeight);
                            continue;
                        case 47:
                            marginLayoutParams.horizontalChainStyle = obtainStyledAttributes.getInt(index, 0);
                            continue;
                        case 48:
                            marginLayoutParams.verticalChainStyle = obtainStyledAttributes.getInt(index, 0);
                            continue;
                        case 49:
                            marginLayoutParams.editorAbsoluteX = obtainStyledAttributes.getDimensionPixelOffset(index, marginLayoutParams.editorAbsoluteX);
                            continue;
                        case 50:
                            marginLayoutParams.editorAbsoluteY = obtainStyledAttributes.getDimensionPixelOffset(index, marginLayoutParams.editorAbsoluteY);
                            continue;
                        case 51:
                            marginLayoutParams.constraintTag = obtainStyledAttributes.getString(index);
                            continue;
                        case 52:
                            int resourceId15 = obtainStyledAttributes.getResourceId(index, marginLayoutParams.baselineToTop);
                            marginLayoutParams.baselineToTop = resourceId15;
                            if (resourceId15 == -1) {
                                marginLayoutParams.baselineToTop = obtainStyledAttributes.getInt(index, -1);
                                break;
                            } else {
                                continue;
                            }
                        case 53:
                            int resourceId16 = obtainStyledAttributes.getResourceId(index, marginLayoutParams.baselineToBottom);
                            marginLayoutParams.baselineToBottom = resourceId16;
                            if (resourceId16 == -1) {
                                marginLayoutParams.baselineToBottom = obtainStyledAttributes.getInt(index, -1);
                                break;
                            } else {
                                continue;
                            }
                        case 54:
                            marginLayoutParams.baselineMargin = obtainStyledAttributes.getDimensionPixelSize(index, marginLayoutParams.baselineMargin);
                            continue;
                        case 55:
                            marginLayoutParams.goneBaselineMargin = obtainStyledAttributes.getDimensionPixelSize(index, marginLayoutParams.goneBaselineMargin);
                            continue;
                        default:
                            switch (i2) {
                                case 64:
                                    ConstraintSet.parseDimensionConstraints(marginLayoutParams, obtainStyledAttributes, index, 0);
                                    continue;
                                case 65:
                                    ConstraintSet.parseDimensionConstraints(marginLayoutParams, obtainStyledAttributes, index, 1);
                                    continue;
                                case 66:
                                    marginLayoutParams.wrapBehaviorInParent = obtainStyledAttributes.getInt(index, marginLayoutParams.wrapBehaviorInParent);
                                    continue;
                                case 67:
                                    marginLayoutParams.guidelineUseRtl = obtainStyledAttributes.getBoolean(index, marginLayoutParams.guidelineUseRtl);
                                    continue;
                                    continue;
                            }
                    }
            }
        }
        obtainStyledAttributes.recycle();
        marginLayoutParams.validate();
        return marginLayoutParams;
    }

    public int getMaxHeight() {
        return this.mMaxHeight;
    }

    public int getMaxWidth() {
        return this.mMaxWidth;
    }

    public int getMinHeight() {
        return this.mMinHeight;
    }

    public int getMinWidth() {
        return this.mMinWidth;
    }

    public int getOptimizationLevel() {
        return this.mLayoutWidget.mOptimizationLevel;
    }

    public String getSceneString() {
        int id;
        StringBuilder sb = new StringBuilder();
        ConstraintWidgetContainer constraintWidgetContainer = this.mLayoutWidget;
        if (constraintWidgetContainer.stringId == null) {
            int id2 = getId();
            if (id2 != -1) {
                constraintWidgetContainer.stringId = getContext().getResources().getResourceEntryName(id2);
            } else {
                constraintWidgetContainer.stringId = "parent";
            }
        }
        if (constraintWidgetContainer.mDebugName == null) {
            constraintWidgetContainer.mDebugName = constraintWidgetContainer.stringId;
            Log.v("ConstraintLayout", " setDebugName " + constraintWidgetContainer.mDebugName);
        }
        ArrayList arrayList = constraintWidgetContainer.mChildren;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ConstraintWidget constraintWidget = (ConstraintWidget) obj;
            View view = constraintWidget.mCompanionWidget;
            if (view != null) {
                if (constraintWidget.stringId == null && (id = view.getId()) != -1) {
                    constraintWidget.stringId = getContext().getResources().getResourceEntryName(id);
                }
                if (constraintWidget.mDebugName == null) {
                    constraintWidget.mDebugName = constraintWidget.stringId;
                    Log.v("ConstraintLayout", " setDebugName " + constraintWidget.mDebugName);
                }
            }
        }
        constraintWidgetContainer.getSceneString(sb);
        return sb.toString();
    }

    public final ConstraintWidget getViewWidget(View view) {
        if (view == this) {
            return this.mLayoutWidget;
        }
        if (view == null) {
            return null;
        }
        if (view.getLayoutParams() instanceof LayoutParams) {
            return ((LayoutParams) view.getLayoutParams()).mWidget;
        }
        view.setLayoutParams(generateLayoutParams(view.getLayoutParams()));
        if (view.getLayoutParams() instanceof LayoutParams) {
            return ((LayoutParams) view.getLayoutParams()).mWidget;
        }
        return null;
    }

    public final void init(AttributeSet attributeSet, int i) {
        ConstraintWidgetContainer constraintWidgetContainer = this.mLayoutWidget;
        constraintWidgetContainer.mCompanionWidget = this;
        Measurer measurer = this.mMeasurer;
        constraintWidgetContainer.mMeasurer = measurer;
        constraintWidgetContainer.mDependencyGraph.mMeasurer = measurer;
        this.mChildrenByIds.put(getId(), this);
        this.mConstraintSet = null;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.ConstraintLayout_Layout, i, 0);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == 16) {
                    this.mMinWidth = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMinWidth);
                } else if (index == 17) {
                    this.mMinHeight = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMinHeight);
                } else if (index == 14) {
                    this.mMaxWidth = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMaxWidth);
                } else if (index == 15) {
                    this.mMaxHeight = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMaxHeight);
                } else if (index == 113) {
                    this.mOptimizationLevel = obtainStyledAttributes.getInt(index, this.mOptimizationLevel);
                } else if (index == 56) {
                    int resourceId = obtainStyledAttributes.getResourceId(index, 0);
                    if (resourceId != 0) {
                        try {
                            parseLayoutDescription(resourceId);
                        } catch (Resources.NotFoundException unused) {
                            this.mConstraintLayoutSpec = null;
                        }
                    }
                } else if (index == 34) {
                    int resourceId2 = obtainStyledAttributes.getResourceId(index, 0);
                    try {
                        ConstraintSet constraintSet = new ConstraintSet();
                        this.mConstraintSet = constraintSet;
                        constraintSet.load(getContext(), resourceId2);
                    } catch (Resources.NotFoundException unused2) {
                        this.mConstraintSet = null;
                    }
                    this.mConstraintSetId = resourceId2;
                }
            }
            obtainStyledAttributes.recycle();
        }
        constraintWidgetContainer.mOptimizationLevel = this.mOptimizationLevel;
        LinearSystem.USE_DEPENDENCY_ORDERING = constraintWidgetContainer.optimizeFor(LogviewFragment.MAX_LINES);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        boolean isInEditMode = isInEditMode();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            ConstraintWidget constraintWidget = layoutParams.mWidget;
            if (childAt.getVisibility() != 8 || layoutParams.mIsGuideline || layoutParams.mIsHelper || isInEditMode) {
                int x = constraintWidget.getX();
                int y = constraintWidget.getY();
                childAt.layout(x, y, constraintWidget.getWidth() + x, constraintWidget.getHeight() + y);
            }
        }
        ArrayList arrayList = this.mConstraintHelpers;
        int size = arrayList.size();
        if (size > 0) {
            for (int i6 = 0; i6 < size; i6++) {
                ((ConstraintHelper) arrayList.get(i6)).getClass();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:211:0x0404  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x040c  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onMeasure(int r34, int r35) {
        /*
            Method dump skipped, instructions count: 1529
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup
    public final void onViewAdded(View view) {
        super.onViewAdded(view);
        ConstraintWidget viewWidget = getViewWidget(view);
        if ((view instanceof Guideline) && !(viewWidget instanceof Guideline)) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Guideline guideline = new Guideline();
            layoutParams.mWidget = guideline;
            layoutParams.mIsGuideline = true;
            guideline.setOrientation(layoutParams.orientation);
        }
        if (view instanceof ConstraintHelper) {
            ConstraintHelper constraintHelper = (ConstraintHelper) view;
            constraintHelper.validateParams();
            ((LayoutParams) view.getLayoutParams()).mIsHelper = true;
            ArrayList arrayList = this.mConstraintHelpers;
            if (!arrayList.contains(constraintHelper)) {
                arrayList.add(constraintHelper);
            }
        }
        this.mChildrenByIds.put(view.getId(), view);
        this.mDirtyHierarchy = true;
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        this.mChildrenByIds.remove(view.getId());
        ConstraintWidget viewWidget = getViewWidget(view);
        this.mLayoutWidget.mChildren.remove(viewWidget);
        viewWidget.reset();
        this.mConstraintHelpers.remove(view);
        this.mDirtyHierarchy = true;
    }

    public final void parseLayoutDescription(int i) {
        String str;
        final Context context = getContext();
        zzcl zzclVar = new zzcl(5, false);
        zzclVar.zzb = new SparseArray();
        zzclVar.zzc = new SparseArray();
        final XmlResourceParser xml = context.getResources().getXml(i);
        try {
            BillingResult.Builder builder = null;
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 2) {
                    String name = xml.getName();
                    switch (name.hashCode()) {
                        case -1349929691:
                            if (name.equals("ConstraintSet")) {
                                zzclVar.parseConstraintSet(context, xml);
                                break;
                            } else {
                                break;
                            }
                        case 80204913:
                            if (name.equals("State")) {
                                BillingResult.Builder builder2 = new BillingResult.Builder(context, xml);
                                ((SparseArray) zzclVar.zzb).put(builder2.zza, builder2);
                                builder = builder2;
                                break;
                            } else {
                                break;
                            }
                        case 1382829617:
                            str = "StateSet";
                            name.equals(str);
                            break;
                        case 1657696882:
                            str = "layoutDescription";
                            name.equals(str);
                            break;
                        case 1901439077:
                            if (name.equals("Variant")) {
                                Object constraintLayoutStates$Variant = new Object(context, xml) { // from class: androidx.constraintlayout.widget.ConstraintLayoutStates$Variant
                                    public final int mConstraintID;
                                    public final float mMaxHeight;
                                    public final float mMaxWidth;
                                    public final float mMinHeight;
                                    public final float mMinWidth;

                                    {
                                        this.mMinWidth = Float.NaN;
                                        this.mMinHeight = Float.NaN;
                                        this.mMaxWidth = Float.NaN;
                                        this.mMaxHeight = Float.NaN;
                                        this.mConstraintID = -1;
                                        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xml), R$styleable.Variant);
                                        int indexCount = obtainStyledAttributes.getIndexCount();
                                        for (int i2 = 0; i2 < indexCount; i2++) {
                                            int index = obtainStyledAttributes.getIndex(i2);
                                            if (index == 0) {
                                                int resourceId = obtainStyledAttributes.getResourceId(index, this.mConstraintID);
                                                this.mConstraintID = resourceId;
                                                String resourceTypeName = context.getResources().getResourceTypeName(resourceId);
                                                context.getResources().getResourceName(resourceId);
                                                if ("layout".equals(resourceTypeName)) {
                                                    new ConstraintSet().clone((ConstraintLayout) LayoutInflater.from(context).inflate(resourceId, (ViewGroup) null));
                                                }
                                            } else if (index == 1) {
                                                this.mMaxHeight = obtainStyledAttributes.getDimension(index, this.mMaxHeight);
                                            } else if (index == 2) {
                                                this.mMinHeight = obtainStyledAttributes.getDimension(index, this.mMinHeight);
                                            } else if (index == 3) {
                                                this.mMaxWidth = obtainStyledAttributes.getDimension(index, this.mMaxWidth);
                                            } else if (index == 4) {
                                                this.mMinWidth = obtainStyledAttributes.getDimension(index, this.mMinWidth);
                                            } else {
                                                Log.v("ConstraintLayoutStates", "Unknown tag");
                                            }
                                        }
                                        obtainStyledAttributes.recycle();
                                    }
                                };
                                if (builder != null) {
                                    ((ArrayList) builder.zzc).add(constraintLayoutStates$Variant);
                                    break;
                                } else {
                                    break;
                                }
                            } else {
                                break;
                            }
                    }
                }
            }
        } catch (IOException e) {
            Log.e("ConstraintLayoutStates", "Error parsing resource: " + i, e);
        } catch (XmlPullParserException e2) {
            Log.e("ConstraintLayoutStates", "Error parsing resource: " + i, e2);
        }
        this.mConstraintLayoutSpec = zzclVar;
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        this.mDirtyHierarchy = true;
        super.requestLayout();
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0349  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0365  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x043f  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0449  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x0452  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x0520  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x0525  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01d7 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void resolveSystem(androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r29, int r30, int r31, int r32) {
        /*
            Method dump skipped, instructions count: 1759
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.resolveSystem(androidx.constraintlayout.core.widgets.ConstraintWidgetContainer, int, int, int):void");
    }

    public void setConstraintSet(ConstraintSet constraintSet) {
        this.mConstraintSet = constraintSet;
    }

    @Override // android.view.View
    public void setId(int i) {
        int id = getId();
        SparseArray sparseArray = this.mChildrenByIds;
        sparseArray.remove(id);
        super.setId(i);
        sparseArray.put(getId(), this);
    }

    public void setMaxHeight(int i) {
        if (i != this.mMaxHeight) {
            this.mMaxHeight = i;
            requestLayout();
        }
    }

    public void setMaxWidth(int i) {
        if (i != this.mMaxWidth) {
            this.mMaxWidth = i;
            requestLayout();
        }
    }

    public void setMinHeight(int i) {
        if (i != this.mMinHeight) {
            this.mMinHeight = i;
            requestLayout();
        }
    }

    public void setMinWidth(int i) {
        if (i != this.mMinWidth) {
            this.mMinWidth = i;
            requestLayout();
        }
    }

    public void setOnConstraintsChanged(ConstraintsChangedListener constraintsChangedListener) {
        zzcl zzclVar = this.mConstraintLayoutSpec;
        if (zzclVar != null) {
            zzclVar.getClass();
        }
    }

    public void setOptimizationLevel(int i) {
        this.mOptimizationLevel = i;
        ConstraintWidgetContainer constraintWidgetContainer = this.mLayoutWidget;
        constraintWidgetContainer.mOptimizationLevel = i;
        LinearSystem.USE_DEPENDENCY_ORDERING = constraintWidgetContainer.optimizeFor(LogviewFragment.MAX_LINES);
    }

    public final void setWidgetBaseline(ConstraintWidget constraintWidget, LayoutParams layoutParams, SparseArray sparseArray, int i, int i2) {
        View view = (View) this.mChildrenByIds.get(i);
        ConstraintWidget constraintWidget2 = (ConstraintWidget) sparseArray.get(i);
        if (constraintWidget2 != null && view != null && (view.getLayoutParams() instanceof LayoutParams)) {
            layoutParams.mNeedsBaseline = true;
            if (i2 == 6) {
                LayoutParams layoutParams2 = (LayoutParams) view.getLayoutParams();
                layoutParams2.mNeedsBaseline = true;
                layoutParams2.mWidget.mHasBaseline = true;
            }
            constraintWidget.getAnchor(6).connect(constraintWidget2.getAnchor(i2), layoutParams.baselineMargin, layoutParams.goneBaselineMargin, true);
            constraintWidget.mHasBaseline = true;
            constraintWidget.getAnchor(3).reset();
            constraintWidget.getAnchor(5).reset();
        }
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.view.ViewGroup$MarginLayoutParams, androidx.constraintlayout.widget.ConstraintLayout$LayoutParams] */
    public static LayoutParams generateDefaultLayoutParams() {
        ?? marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
        marginLayoutParams.guideBegin = -1;
        marginLayoutParams.guideEnd = -1;
        marginLayoutParams.guidePercent = -1.0f;
        marginLayoutParams.guidelineUseRtl = true;
        marginLayoutParams.leftToLeft = -1;
        marginLayoutParams.leftToRight = -1;
        marginLayoutParams.rightToLeft = -1;
        marginLayoutParams.rightToRight = -1;
        marginLayoutParams.topToTop = -1;
        marginLayoutParams.topToBottom = -1;
        marginLayoutParams.bottomToTop = -1;
        marginLayoutParams.bottomToBottom = -1;
        marginLayoutParams.baselineToBaseline = -1;
        marginLayoutParams.baselineToTop = -1;
        marginLayoutParams.baselineToBottom = -1;
        marginLayoutParams.circleConstraint = -1;
        marginLayoutParams.circleRadius = 0;
        marginLayoutParams.circleAngle = 0.0f;
        marginLayoutParams.startToEnd = -1;
        marginLayoutParams.startToStart = -1;
        marginLayoutParams.endToStart = -1;
        marginLayoutParams.endToEnd = -1;
        marginLayoutParams.goneLeftMargin = Integer.MIN_VALUE;
        marginLayoutParams.goneTopMargin = Integer.MIN_VALUE;
        marginLayoutParams.goneRightMargin = Integer.MIN_VALUE;
        marginLayoutParams.goneBottomMargin = Integer.MIN_VALUE;
        marginLayoutParams.goneStartMargin = Integer.MIN_VALUE;
        marginLayoutParams.goneEndMargin = Integer.MIN_VALUE;
        marginLayoutParams.goneBaselineMargin = Integer.MIN_VALUE;
        marginLayoutParams.baselineMargin = 0;
        marginLayoutParams.horizontalBias = 0.5f;
        marginLayoutParams.verticalBias = 0.5f;
        marginLayoutParams.dimensionRatio = null;
        marginLayoutParams.horizontalWeight = -1.0f;
        marginLayoutParams.verticalWeight = -1.0f;
        marginLayoutParams.horizontalChainStyle = 0;
        marginLayoutParams.verticalChainStyle = 0;
        marginLayoutParams.matchConstraintDefaultWidth = 0;
        marginLayoutParams.matchConstraintDefaultHeight = 0;
        marginLayoutParams.matchConstraintMinWidth = 0;
        marginLayoutParams.matchConstraintMinHeight = 0;
        marginLayoutParams.matchConstraintMaxWidth = 0;
        marginLayoutParams.matchConstraintMaxHeight = 0;
        marginLayoutParams.matchConstraintPercentWidth = 1.0f;
        marginLayoutParams.matchConstraintPercentHeight = 1.0f;
        marginLayoutParams.editorAbsoluteX = -1;
        marginLayoutParams.editorAbsoluteY = -1;
        marginLayoutParams.orientation = -1;
        marginLayoutParams.constrainedWidth = false;
        marginLayoutParams.constrainedHeight = false;
        marginLayoutParams.constraintTag = null;
        marginLayoutParams.wrapBehaviorInParent = 0;
        marginLayoutParams.mHorizontalDimensionFixed = true;
        marginLayoutParams.mVerticalDimensionFixed = true;
        marginLayoutParams.mNeedsBaseline = false;
        marginLayoutParams.mIsGuideline = false;
        marginLayoutParams.mIsHelper = false;
        marginLayoutParams.mResolvedLeftToLeft = -1;
        marginLayoutParams.mResolvedLeftToRight = -1;
        marginLayoutParams.mResolvedRightToLeft = -1;
        marginLayoutParams.mResolvedRightToRight = -1;
        marginLayoutParams.mResolveGoneLeftMargin = Integer.MIN_VALUE;
        marginLayoutParams.mResolveGoneRightMargin = Integer.MIN_VALUE;
        marginLayoutParams.mResolvedHorizontalBias = 0.5f;
        marginLayoutParams.mWidget = new ConstraintWidget();
        return marginLayoutParams;
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(attributeSet, i);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.view.ViewGroup$LayoutParams, android.view.ViewGroup$MarginLayoutParams, androidx.constraintlayout.widget.ConstraintLayout$LayoutParams] */
    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        ?? marginLayoutParams = new ViewGroup.MarginLayoutParams(layoutParams);
        marginLayoutParams.guideBegin = -1;
        marginLayoutParams.guideEnd = -1;
        marginLayoutParams.guidePercent = -1.0f;
        marginLayoutParams.guidelineUseRtl = true;
        marginLayoutParams.leftToLeft = -1;
        marginLayoutParams.leftToRight = -1;
        marginLayoutParams.rightToLeft = -1;
        marginLayoutParams.rightToRight = -1;
        marginLayoutParams.topToTop = -1;
        marginLayoutParams.topToBottom = -1;
        marginLayoutParams.bottomToTop = -1;
        marginLayoutParams.bottomToBottom = -1;
        marginLayoutParams.baselineToBaseline = -1;
        marginLayoutParams.baselineToTop = -1;
        marginLayoutParams.baselineToBottom = -1;
        marginLayoutParams.circleConstraint = -1;
        marginLayoutParams.circleRadius = 0;
        marginLayoutParams.circleAngle = 0.0f;
        marginLayoutParams.startToEnd = -1;
        marginLayoutParams.startToStart = -1;
        marginLayoutParams.endToStart = -1;
        marginLayoutParams.endToEnd = -1;
        marginLayoutParams.goneLeftMargin = Integer.MIN_VALUE;
        marginLayoutParams.goneTopMargin = Integer.MIN_VALUE;
        marginLayoutParams.goneRightMargin = Integer.MIN_VALUE;
        marginLayoutParams.goneBottomMargin = Integer.MIN_VALUE;
        marginLayoutParams.goneStartMargin = Integer.MIN_VALUE;
        marginLayoutParams.goneEndMargin = Integer.MIN_VALUE;
        marginLayoutParams.goneBaselineMargin = Integer.MIN_VALUE;
        marginLayoutParams.baselineMargin = 0;
        marginLayoutParams.horizontalBias = 0.5f;
        marginLayoutParams.verticalBias = 0.5f;
        marginLayoutParams.dimensionRatio = null;
        marginLayoutParams.horizontalWeight = -1.0f;
        marginLayoutParams.verticalWeight = -1.0f;
        marginLayoutParams.horizontalChainStyle = 0;
        marginLayoutParams.verticalChainStyle = 0;
        marginLayoutParams.matchConstraintDefaultWidth = 0;
        marginLayoutParams.matchConstraintDefaultHeight = 0;
        marginLayoutParams.matchConstraintMinWidth = 0;
        marginLayoutParams.matchConstraintMinHeight = 0;
        marginLayoutParams.matchConstraintMaxWidth = 0;
        marginLayoutParams.matchConstraintMaxHeight = 0;
        marginLayoutParams.matchConstraintPercentWidth = 1.0f;
        marginLayoutParams.matchConstraintPercentHeight = 1.0f;
        marginLayoutParams.editorAbsoluteX = -1;
        marginLayoutParams.editorAbsoluteY = -1;
        marginLayoutParams.orientation = -1;
        marginLayoutParams.constrainedWidth = false;
        marginLayoutParams.constrainedHeight = false;
        marginLayoutParams.constraintTag = null;
        marginLayoutParams.wrapBehaviorInParent = 0;
        marginLayoutParams.mHorizontalDimensionFixed = true;
        marginLayoutParams.mVerticalDimensionFixed = true;
        marginLayoutParams.mNeedsBaseline = false;
        marginLayoutParams.mIsGuideline = false;
        marginLayoutParams.mIsHelper = false;
        marginLayoutParams.mResolvedLeftToLeft = -1;
        marginLayoutParams.mResolvedLeftToRight = -1;
        marginLayoutParams.mResolvedRightToLeft = -1;
        marginLayoutParams.mResolvedRightToRight = -1;
        marginLayoutParams.mResolveGoneLeftMargin = Integer.MIN_VALUE;
        marginLayoutParams.mResolveGoneRightMargin = Integer.MIN_VALUE;
        marginLayoutParams.mResolvedHorizontalBias = 0.5f;
        marginLayoutParams.mWidget = new ConstraintWidget();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams;
            ((ViewGroup.MarginLayoutParams) marginLayoutParams).leftMargin = marginLayoutParams2.leftMargin;
            ((ViewGroup.MarginLayoutParams) marginLayoutParams).rightMargin = marginLayoutParams2.rightMargin;
            ((ViewGroup.MarginLayoutParams) marginLayoutParams).topMargin = marginLayoutParams2.topMargin;
            ((ViewGroup.MarginLayoutParams) marginLayoutParams).bottomMargin = marginLayoutParams2.bottomMargin;
            marginLayoutParams.setMarginStart(marginLayoutParams2.getMarginStart());
            marginLayoutParams.setMarginEnd(marginLayoutParams2.getMarginEnd());
        }
        if (!(layoutParams instanceof LayoutParams)) {
            return marginLayoutParams;
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        marginLayoutParams.guideBegin = layoutParams2.guideBegin;
        marginLayoutParams.guideEnd = layoutParams2.guideEnd;
        marginLayoutParams.guidePercent = layoutParams2.guidePercent;
        marginLayoutParams.guidelineUseRtl = layoutParams2.guidelineUseRtl;
        marginLayoutParams.leftToLeft = layoutParams2.leftToLeft;
        marginLayoutParams.leftToRight = layoutParams2.leftToRight;
        marginLayoutParams.rightToLeft = layoutParams2.rightToLeft;
        marginLayoutParams.rightToRight = layoutParams2.rightToRight;
        marginLayoutParams.topToTop = layoutParams2.topToTop;
        marginLayoutParams.topToBottom = layoutParams2.topToBottom;
        marginLayoutParams.bottomToTop = layoutParams2.bottomToTop;
        marginLayoutParams.bottomToBottom = layoutParams2.bottomToBottom;
        marginLayoutParams.baselineToBaseline = layoutParams2.baselineToBaseline;
        marginLayoutParams.baselineToTop = layoutParams2.baselineToTop;
        marginLayoutParams.baselineToBottom = layoutParams2.baselineToBottom;
        marginLayoutParams.circleConstraint = layoutParams2.circleConstraint;
        marginLayoutParams.circleRadius = layoutParams2.circleRadius;
        marginLayoutParams.circleAngle = layoutParams2.circleAngle;
        marginLayoutParams.startToEnd = layoutParams2.startToEnd;
        marginLayoutParams.startToStart = layoutParams2.startToStart;
        marginLayoutParams.endToStart = layoutParams2.endToStart;
        marginLayoutParams.endToEnd = layoutParams2.endToEnd;
        marginLayoutParams.goneLeftMargin = layoutParams2.goneLeftMargin;
        marginLayoutParams.goneTopMargin = layoutParams2.goneTopMargin;
        marginLayoutParams.goneRightMargin = layoutParams2.goneRightMargin;
        marginLayoutParams.goneBottomMargin = layoutParams2.goneBottomMargin;
        marginLayoutParams.goneStartMargin = layoutParams2.goneStartMargin;
        marginLayoutParams.goneEndMargin = layoutParams2.goneEndMargin;
        marginLayoutParams.goneBaselineMargin = layoutParams2.goneBaselineMargin;
        marginLayoutParams.baselineMargin = layoutParams2.baselineMargin;
        marginLayoutParams.horizontalBias = layoutParams2.horizontalBias;
        marginLayoutParams.verticalBias = layoutParams2.verticalBias;
        marginLayoutParams.dimensionRatio = layoutParams2.dimensionRatio;
        marginLayoutParams.horizontalWeight = layoutParams2.horizontalWeight;
        marginLayoutParams.verticalWeight = layoutParams2.verticalWeight;
        marginLayoutParams.horizontalChainStyle = layoutParams2.horizontalChainStyle;
        marginLayoutParams.verticalChainStyle = layoutParams2.verticalChainStyle;
        marginLayoutParams.constrainedWidth = layoutParams2.constrainedWidth;
        marginLayoutParams.constrainedHeight = layoutParams2.constrainedHeight;
        marginLayoutParams.matchConstraintDefaultWidth = layoutParams2.matchConstraintDefaultWidth;
        marginLayoutParams.matchConstraintDefaultHeight = layoutParams2.matchConstraintDefaultHeight;
        marginLayoutParams.matchConstraintMinWidth = layoutParams2.matchConstraintMinWidth;
        marginLayoutParams.matchConstraintMaxWidth = layoutParams2.matchConstraintMaxWidth;
        marginLayoutParams.matchConstraintMinHeight = layoutParams2.matchConstraintMinHeight;
        marginLayoutParams.matchConstraintMaxHeight = layoutParams2.matchConstraintMaxHeight;
        marginLayoutParams.matchConstraintPercentWidth = layoutParams2.matchConstraintPercentWidth;
        marginLayoutParams.matchConstraintPercentHeight = layoutParams2.matchConstraintPercentHeight;
        marginLayoutParams.editorAbsoluteX = layoutParams2.editorAbsoluteX;
        marginLayoutParams.editorAbsoluteY = layoutParams2.editorAbsoluteY;
        marginLayoutParams.orientation = layoutParams2.orientation;
        marginLayoutParams.mHorizontalDimensionFixed = layoutParams2.mHorizontalDimensionFixed;
        marginLayoutParams.mVerticalDimensionFixed = layoutParams2.mVerticalDimensionFixed;
        marginLayoutParams.mNeedsBaseline = layoutParams2.mNeedsBaseline;
        marginLayoutParams.mIsGuideline = layoutParams2.mIsGuideline;
        marginLayoutParams.mResolvedLeftToLeft = layoutParams2.mResolvedLeftToLeft;
        marginLayoutParams.mResolvedLeftToRight = layoutParams2.mResolvedLeftToRight;
        marginLayoutParams.mResolvedRightToLeft = layoutParams2.mResolvedRightToLeft;
        marginLayoutParams.mResolvedRightToRight = layoutParams2.mResolvedRightToRight;
        marginLayoutParams.mResolveGoneLeftMargin = layoutParams2.mResolveGoneLeftMargin;
        marginLayoutParams.mResolveGoneRightMargin = layoutParams2.mResolveGoneRightMargin;
        marginLayoutParams.mResolvedHorizontalBias = layoutParams2.mResolvedHorizontalBias;
        marginLayoutParams.constraintTag = layoutParams2.constraintTag;
        marginLayoutParams.wrapBehaviorInParent = layoutParams2.wrapBehaviorInParent;
        marginLayoutParams.mWidget = layoutParams2.mWidget;
        return marginLayoutParams;
    }
}
