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
import androidx.constraintlayout.core.widgets.Barrier;
import androidx.constraintlayout.core.widgets.Chain;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.Flow;
import androidx.constraintlayout.core.widgets.Guideline;
import androidx.constraintlayout.core.widgets.HelperWidget;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measure;
import androidx.constraintlayout.core.widgets.analyzer.ChainRun;
import androidx.constraintlayout.core.widgets.analyzer.DependencyGraph;
import androidx.constraintlayout.core.widgets.analyzer.GuidelineReference;
import androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun;
import androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun;
import androidx.constraintlayout.core.widgets.analyzer.WidgetRun;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.zzcl;
import com.emanuelef.remote_capture.fragments.LogviewFragment;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.text.MatcherMatchResult;
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
        */
        public final void resolveLayoutDirection(int i) {
            boolean z;
            int i2;
            int i3;
            int i4;
            int i5;
            int i6 = ((ViewGroup.MarginLayoutParams) this).leftMargin;
            int i7 = ((ViewGroup.MarginLayoutParams) this).rightMargin;
            super.resolveLayoutDirection(i);
            boolean z2 = false;
            if (1 == getLayoutDirection()) {
                z = true;
            } else {
                z = false;
            }
            this.mResolvedRightToLeft = -1;
            this.mResolvedRightToRight = -1;
            this.mResolvedLeftToLeft = -1;
            this.mResolvedLeftToRight = -1;
            this.mResolveGoneLeftMargin = this.goneLeftMargin;
            this.mResolveGoneRightMargin = this.goneRightMargin;
            float f = this.horizontalBias;
            this.mResolvedHorizontalBias = f;
            int i8 = this.guideBegin;
            this.mResolvedGuideBegin = i8;
            int i9 = this.guideEnd;
            this.mResolvedGuideEnd = i9;
            float f2 = this.guidePercent;
            this.mResolvedGuidePercent = f2;
            if (z) {
                int i10 = this.startToEnd;
                if (i10 != -1) {
                    this.mResolvedRightToLeft = i10;
                } else {
                    int i11 = this.startToStart;
                    if (i11 != -1) {
                        this.mResolvedRightToRight = i11;
                    }
                    i2 = this.endToStart;
                    if (i2 != -1) {
                        this.mResolvedLeftToRight = i2;
                        z2 = true;
                    }
                    i3 = this.endToEnd;
                    if (i3 != -1) {
                        this.mResolvedLeftToLeft = i3;
                        z2 = true;
                    }
                    i4 = this.goneStartMargin;
                    if (i4 != Integer.MIN_VALUE) {
                        this.mResolveGoneRightMargin = i4;
                    }
                    i5 = this.goneEndMargin;
                    if (i5 != Integer.MIN_VALUE) {
                        this.mResolveGoneLeftMargin = i5;
                    }
                    if (z2) {
                        this.mResolvedHorizontalBias = 1.0f - f;
                    }
                    if (this.mIsGuideline && this.orientation == 1 && this.guidelineUseRtl) {
                        if (f2 == -1.0f) {
                            this.mResolvedGuidePercent = 1.0f - f2;
                            this.mResolvedGuideBegin = -1;
                            this.mResolvedGuideEnd = -1;
                        } else if (i8 != -1) {
                            this.mResolvedGuideEnd = i8;
                            this.mResolvedGuideBegin = -1;
                            this.mResolvedGuidePercent = -1.0f;
                        } else if (i9 != -1) {
                            this.mResolvedGuideBegin = i9;
                            this.mResolvedGuideEnd = -1;
                            this.mResolvedGuidePercent = -1.0f;
                        }
                    }
                }
                z2 = true;
                i2 = this.endToStart;
                if (i2 != -1) {
                }
                i3 = this.endToEnd;
                if (i3 != -1) {
                }
                i4 = this.goneStartMargin;
                if (i4 != Integer.MIN_VALUE) {
                }
                i5 = this.goneEndMargin;
                if (i5 != Integer.MIN_VALUE) {
                }
                if (z2) {
                }
                if (this.mIsGuideline) {
                    if (f2 == -1.0f) {
                    }
                }
            } else {
                int i12 = this.startToEnd;
                if (i12 != -1) {
                    this.mResolvedLeftToRight = i12;
                }
                int i13 = this.startToStart;
                if (i13 != -1) {
                    this.mResolvedLeftToLeft = i13;
                }
                int i14 = this.endToStart;
                if (i14 != -1) {
                    this.mResolvedRightToLeft = i14;
                }
                int i15 = this.endToEnd;
                if (i15 != -1) {
                    this.mResolvedRightToRight = i15;
                }
                int i16 = this.goneStartMargin;
                if (i16 != Integer.MIN_VALUE) {
                    this.mResolveGoneLeftMargin = i16;
                }
                int i17 = this.goneEndMargin;
                if (i17 != Integer.MIN_VALUE) {
                    this.mResolveGoneRightMargin = i17;
                }
            }
            if (this.endToStart == -1 && this.endToEnd == -1 && this.startToStart == -1 && this.startToEnd == -1) {
                int i18 = this.rightToLeft;
                if (i18 != -1) {
                    this.mResolvedRightToLeft = i18;
                    if (((ViewGroup.MarginLayoutParams) this).rightMargin <= 0 && i7 > 0) {
                        ((ViewGroup.MarginLayoutParams) this).rightMargin = i7;
                    }
                } else {
                    int i19 = this.rightToRight;
                    if (i19 != -1) {
                        this.mResolvedRightToRight = i19;
                        if (((ViewGroup.MarginLayoutParams) this).rightMargin <= 0 && i7 > 0) {
                            ((ViewGroup.MarginLayoutParams) this).rightMargin = i7;
                        }
                    }
                }
                int i20 = this.leftToLeft;
                if (i20 != -1) {
                    this.mResolvedLeftToLeft = i20;
                    if (((ViewGroup.MarginLayoutParams) this).leftMargin <= 0 && i6 > 0) {
                        ((ViewGroup.MarginLayoutParams) this).leftMargin = i6;
                        return;
                    }
                    return;
                }
                int i21 = this.leftToRight;
                if (i21 != -1) {
                    this.mResolvedLeftToRight = i21;
                    if (((ViewGroup.MarginLayoutParams) this).leftMargin <= 0 && i6 > 0) {
                        ((ViewGroup.MarginLayoutParams) this).leftMargin = i6;
                    }
                }
            }
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
    */
    public void onMeasure(int i, int i2) {
        boolean z;
        boolean z2;
        boolean z3;
        int i3;
        int i4;
        int i5;
        LayoutParams layoutParams;
        ConstraintWidget constraintWidget;
        int i6;
        int i7;
        float f;
        int i8;
        ConstraintWidget constraintWidget2;
        ConstraintWidget constraintWidget3;
        ConstraintWidget constraintWidget4;
        int i9;
        ConstraintWidget constraintWidget5;
        ConstraintWidget constraintWidget6;
        float f2;
        ArrayList arrayList;
        SparseArray sparseArray;
        ArrayList arrayList2;
        SparseArray sparseArray2;
        String str;
        int findId;
        String resourceName;
        boolean z4;
        int id;
        ConstraintWidget constraintWidget7;
        String str2;
        ConstraintLayout constraintLayout = this;
        boolean z5 = constraintLayout.mDirtyHierarchy;
        constraintLayout.mDirtyHierarchy = z5;
        int i10 = 0;
        if (!z5) {
            int childCount = constraintLayout.getChildCount();
            int i11 = 0;
            while (true) {
                if (i11 >= childCount) {
                    break;
                } else if (constraintLayout.getChildAt(i11).isLayoutRequested()) {
                    constraintLayout.mDirtyHierarchy = true;
                    break;
                } else {
                    i11++;
                }
            }
        }
        if ((constraintLayout.getContext().getApplicationInfo().flags & 4194304) == 0 || 1 != constraintLayout.getLayoutDirection()) {
            z = false;
        } else {
            z = true;
        }
        ConstraintWidgetContainer constraintWidgetContainer = constraintLayout.mLayoutWidget;
        constraintWidgetContainer.mIsRtl = z;
        if (constraintLayout.mDirtyHierarchy) {
            constraintLayout.mDirtyHierarchy = false;
            int childCount2 = constraintLayout.getChildCount();
            int i12 = 0;
            while (true) {
                if (i12 >= childCount2) {
                    z2 = false;
                    break;
                } else if (constraintLayout.getChildAt(i12).isLayoutRequested()) {
                    z2 = true;
                    break;
                } else {
                    i12++;
                }
            }
            if (z2) {
                boolean isInEditMode = constraintLayout.isInEditMode();
                int childCount3 = constraintLayout.getChildCount();
                for (int i13 = 0; i13 < childCount3; i13++) {
                    ConstraintWidget viewWidget = constraintLayout.getViewWidget(constraintLayout.getChildAt(i13));
                    if (viewWidget != null) {
                        viewWidget.reset();
                    }
                }
                SparseArray sparseArray3 = constraintLayout.mChildrenByIds;
                if (isInEditMode) {
                    for (int i14 = 0; i14 < childCount3; i14++) {
                        View childAt = constraintLayout.getChildAt(i14);
                        try {
                            resourceName = constraintLayout.getResources().getResourceName(childAt.getId());
                            Integer valueOf = Integer.valueOf(childAt.getId());
                            if (resourceName != null) {
                                z4 = true;
                            } else {
                                z4 = false;
                            }
                            if (z4) {
                                try {
                                    if (constraintLayout.mDesignIds == null) {
                                        constraintLayout.mDesignIds = new HashMap();
                                    }
                                    int indexOf = resourceName.indexOf("/");
                                    if (indexOf != -1) {
                                        str2 = resourceName.substring(indexOf + 1);
                                    } else {
                                        str2 = resourceName;
                                    }
                                    constraintLayout.mDesignIds.put(str2, valueOf);
                                } catch (Resources.NotFoundException unused) {
                                }
                            }
                            int indexOf2 = resourceName.indexOf(47);
                            if (indexOf2 != -1) {
                                resourceName = resourceName.substring(indexOf2 + 1);
                            }
                            id = childAt.getId();
                        } catch (Resources.NotFoundException unused2) {
                        }
                        if (id != 0) {
                            View view = (View) sparseArray3.get(id);
                            if (view == null && (view = constraintLayout.findViewById(id)) != null && view != constraintLayout && view.getParent() == constraintLayout) {
                                constraintLayout.onViewAdded(view);
                            }
                            if (view != constraintLayout) {
                                if (view == null) {
                                    constraintWidget7 = null;
                                } else {
                                    constraintWidget7 = ((LayoutParams) view.getLayoutParams()).mWidget;
                                }
                                constraintWidget7.mDebugName = resourceName;
                            }
                        }
                        constraintWidget7 = constraintWidgetContainer;
                        constraintWidget7.mDebugName = resourceName;
                    }
                }
                if (constraintLayout.mConstraintSetId != -1) {
                    for (int i15 = 0; i15 < childCount3; i15++) {
                        constraintLayout.getChildAt(i15).getId();
                    }
                }
                ConstraintSet constraintSet = constraintLayout.mConstraintSet;
                if (constraintSet != null) {
                    constraintSet.applyToInternal(constraintLayout);
                }
                constraintWidgetContainer.mChildren.clear();
                ArrayList arrayList3 = constraintLayout.mConstraintHelpers;
                int size = arrayList3.size();
                if (size > 0) {
                    int i16 = 0;
                    while (i16 < size) {
                        ConstraintHelper constraintHelper = (ConstraintHelper) arrayList3.get(i16);
                        HashMap hashMap = constraintHelper.mMap;
                        if (constraintHelper.isInEditMode()) {
                            constraintHelper.setIds(constraintHelper.mReferenceIds);
                        }
                        HelperWidget helperWidget = constraintHelper.mHelperWidget;
                        if (helperWidget == null) {
                            sparseArray = sparseArray3;
                            arrayList = arrayList3;
                        } else {
                            helperWidget.mWidgetsCount = i10;
                            Arrays.fill(helperWidget.mWidgets, (Object) null);
                            int i17 = 0;
                            while (i17 < constraintHelper.mCount) {
                                int i18 = constraintHelper.mIds[i17];
                                View view2 = (View) sparseArray3.get(i18);
                                if (view2 != null || (findId = constraintHelper.findId(constraintLayout, (str = (String) hashMap.get(Integer.valueOf(i18))))) == 0) {
                                    arrayList2 = arrayList3;
                                } else {
                                    arrayList2 = arrayList3;
                                    constraintHelper.mIds[i17] = findId;
                                    hashMap.put(Integer.valueOf(findId), str);
                                    view2 = (View) sparseArray3.get(findId);
                                }
                                View view3 = view2;
                                if (view3 != null) {
                                    HelperWidget helperWidget2 = constraintHelper.mHelperWidget;
                                    ConstraintWidget viewWidget2 = constraintLayout.getViewWidget(view3);
                                    helperWidget2.getClass();
                                    if (!(viewWidget2 == helperWidget2 || viewWidget2 == null)) {
                                        int i19 = helperWidget2.mWidgetsCount + 1;
                                        sparseArray2 = sparseArray3;
                                        ConstraintWidget[] constraintWidgetArr = helperWidget2.mWidgets;
                                        if (i19 > constraintWidgetArr.length) {
                                            helperWidget2.mWidgets = (ConstraintWidget[]) Arrays.copyOf(constraintWidgetArr, constraintWidgetArr.length * 2);
                                        }
                                        ConstraintWidget[] constraintWidgetArr2 = helperWidget2.mWidgets;
                                        int i20 = helperWidget2.mWidgetsCount;
                                        constraintWidgetArr2[i20] = viewWidget2;
                                        helperWidget2.mWidgetsCount = i20 + 1;
                                        i17++;
                                        sparseArray3 = sparseArray2;
                                        arrayList3 = arrayList2;
                                    }
                                }
                                sparseArray2 = sparseArray3;
                                i17++;
                                sparseArray3 = sparseArray2;
                                arrayList3 = arrayList2;
                            }
                            sparseArray = sparseArray3;
                            arrayList = arrayList3;
                            constraintHelper.mHelperWidget.updateConstraints();
                        }
                        i16++;
                        sparseArray3 = sparseArray;
                        arrayList3 = arrayList;
                        i10 = 0;
                    }
                }
                for (int i21 = 0; i21 < childCount3; i21++) {
                    constraintLayout.getChildAt(i21);
                }
                SparseArray sparseArray4 = constraintLayout.mTempMapIdToWidget;
                sparseArray4.clear();
                sparseArray4.put(0, constraintWidgetContainer);
                sparseArray4.put(constraintLayout.getId(), constraintWidgetContainer);
                for (int i22 = 0; i22 < childCount3; i22++) {
                    View childAt2 = constraintLayout.getChildAt(i22);
                    sparseArray4.put(childAt2.getId(), constraintLayout.getViewWidget(childAt2));
                }
                int i23 = 0;
                while (i23 < childCount3) {
                    View childAt3 = constraintLayout.getChildAt(i23);
                    ConstraintWidget viewWidget3 = constraintLayout.getViewWidget(childAt3);
                    if (viewWidget3 != null) {
                        LayoutParams layoutParams2 = (LayoutParams) childAt3.getLayoutParams();
                        constraintWidgetContainer.mChildren.add(viewWidget3);
                        ConstraintWidget constraintWidget8 = viewWidget3.mParent;
                        if (constraintWidget8 != null) {
                            ((ConstraintWidgetContainer) constraintWidget8).mChildren.remove(viewWidget3);
                            viewWidget3.reset();
                        }
                        viewWidget3.mParent = constraintWidgetContainer;
                        layoutParams2.validate();
                        viewWidget3.mVisibility = childAt3.getVisibility();
                        viewWidget3.mCompanionWidget = childAt3;
                        if (childAt3 instanceof ConstraintHelper) {
                            ((ConstraintHelper) childAt3).resolveRtl(viewWidget3, constraintWidgetContainer.mIsRtl);
                        }
                        if (layoutParams2.mIsGuideline) {
                            Guideline guideline = (Guideline) viewWidget3;
                            int i24 = layoutParams2.mResolvedGuideBegin;
                            int i25 = layoutParams2.mResolvedGuideEnd;
                            float f3 = layoutParams2.mResolvedGuidePercent;
                            int i26 = (f3 > (-1.0f) ? 1 : (f3 == (-1.0f) ? 0 : -1));
                            if (i26 != 0) {
                                if (i26 > 0) {
                                    guideline.mRelativePercent = f3;
                                    guideline.mRelativeBegin = -1;
                                    guideline.mRelativeEnd = -1;
                                }
                            } else if (i24 != -1) {
                                if (i24 > -1) {
                                    guideline.mRelativePercent = -1.0f;
                                    guideline.mRelativeBegin = i24;
                                    guideline.mRelativeEnd = -1;
                                }
                            } else if (i25 != -1 && i25 > -1) {
                                guideline.mRelativePercent = -1.0f;
                                guideline.mRelativeBegin = -1;
                                guideline.mRelativeEnd = i25;
                            }
                        } else {
                            int i27 = layoutParams2.mResolvedLeftToLeft;
                            int i28 = layoutParams2.mResolvedLeftToRight;
                            int i29 = layoutParams2.mResolvedRightToLeft;
                            int i30 = layoutParams2.mResolvedRightToRight;
                            int i31 = layoutParams2.mResolveGoneLeftMargin;
                            int i32 = layoutParams2.mResolveGoneRightMargin;
                            i3 = i23;
                            float f4 = layoutParams2.mResolvedHorizontalBias;
                            int i33 = layoutParams2.circleConstraint;
                            z3 = z2;
                            if (i33 != -1) {
                                ConstraintWidget constraintWidget9 = (ConstraintWidget) sparseArray4.get(i33);
                                if (constraintWidget9 != null) {
                                    float f5 = layoutParams2.circleAngle;
                                    viewWidget3.immediateConnect(7, 7, layoutParams2.circleRadius, 0, constraintWidget9);
                                    viewWidget3.mCircleConstraintAngle = f5;
                                }
                                constraintLayout = this;
                                constraintWidget = viewWidget3;
                                layoutParams = layoutParams2;
                                i5 = 2;
                                i4 = 4;
                            } else {
                                if (i27 != -1) {
                                    ConstraintWidget constraintWidget10 = (ConstraintWidget) sparseArray4.get(i27);
                                    if (constraintWidget10 != null) {
                                        constraintWidget2 = viewWidget3;
                                        constraintWidget2.immediateConnect(2, 2, ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin, i31, constraintWidget10);
                                    } else {
                                        constraintWidget2 = viewWidget3;
                                    }
                                } else {
                                    constraintWidget2 = viewWidget3;
                                    if (!(i28 == -1 || (constraintWidget3 = (ConstraintWidget) sparseArray4.get(i28)) == null)) {
                                        constraintWidget2.immediateConnect(2, 4, ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin, i31, constraintWidget3);
                                    }
                                }
                                if (i29 != -1) {
                                    ConstraintWidget constraintWidget11 = (ConstraintWidget) sparseArray4.get(i29);
                                    if (constraintWidget11 != null) {
                                        constraintWidget2.immediateConnect(4, 2, ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin, i32, constraintWidget11);
                                    }
                                    i5 = 2;
                                } else {
                                    i5 = 2;
                                    if (!(i30 == -1 || (constraintWidget4 = (ConstraintWidget) sparseArray4.get(i30)) == null)) {
                                        constraintWidget2.immediateConnect(4, 4, ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin, i32, constraintWidget4);
                                    }
                                }
                                i4 = 4;
                                int i34 = layoutParams2.topToTop;
                                if (i34 != -1) {
                                    ConstraintWidget constraintWidget12 = (ConstraintWidget) sparseArray4.get(i34);
                                    if (constraintWidget12 != null) {
                                        constraintWidget2.immediateConnect(3, 3, ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin, layoutParams2.goneTopMargin, constraintWidget12);
                                    }
                                    i9 = -1;
                                } else {
                                    int i35 = layoutParams2.topToBottom;
                                    i9 = -1;
                                    if (!(i35 == -1 || (constraintWidget5 = (ConstraintWidget) sparseArray4.get(i35)) == null)) {
                                        constraintWidget2.immediateConnect(3, 5, ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin, layoutParams2.goneTopMargin, constraintWidget5);
                                    }
                                }
                                int i36 = layoutParams2.bottomToTop;
                                if (i36 != i9) {
                                    ConstraintWidget constraintWidget13 = (ConstraintWidget) sparseArray4.get(i36);
                                    if (constraintWidget13 != null) {
                                        constraintWidget2.immediateConnect(5, 3, ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin, layoutParams2.goneBottomMargin, constraintWidget13);
                                    }
                                } else {
                                    int i37 = layoutParams2.bottomToBottom;
                                    if (!(i37 == i9 || (constraintWidget6 = (ConstraintWidget) sparseArray4.get(i37)) == null)) {
                                        constraintWidget2.immediateConnect(5, 5, ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin, layoutParams2.goneBottomMargin, constraintWidget6);
                                    }
                                }
                                layoutParams = layoutParams2;
                                int i38 = layoutParams.baselineToBaseline;
                                if (i38 != -1) {
                                    constraintLayout = this;
                                    constraintWidget = constraintWidget2;
                                    constraintLayout.setWidgetBaseline(constraintWidget, layoutParams, sparseArray4, i38, 6);
                                } else {
                                    int i39 = layoutParams.baselineToTop;
                                    if (i39 != -1) {
                                        constraintLayout = this;
                                        constraintWidget = constraintWidget2;
                                        constraintLayout.setWidgetBaseline(constraintWidget, layoutParams, sparseArray4, i39, 3);
                                    } else {
                                        int i40 = layoutParams.baselineToBottom;
                                        constraintLayout = this;
                                        constraintWidget = constraintWidget2;
                                        if (i40 != -1) {
                                            constraintLayout.setWidgetBaseline(constraintWidget, layoutParams, sparseArray4, i40, 5);
                                        }
                                        if (f4 >= 0.0f) {
                                            constraintWidget.mHorizontalBiasPercent = f4;
                                        }
                                        f2 = layoutParams.verticalBias;
                                        if (f2 >= 0.0f) {
                                            constraintWidget.mVerticalBiasPercent = f2;
                                        }
                                    }
                                }
                                if (f4 >= 0.0f) {
                                }
                                f2 = layoutParams.verticalBias;
                                if (f2 >= 0.0f) {
                                }
                            }
                            if (isInEditMode && !((i8 = layoutParams.editorAbsoluteX) == -1 && layoutParams.editorAbsoluteY == -1)) {
                                int i41 = layoutParams.editorAbsoluteY;
                                constraintWidget.f2mX = i8;
                                constraintWidget.f3mY = i41;
                            }
                            if (layoutParams.mHorizontalDimensionFixed) {
                                constraintWidget.setHorizontalDimensionBehaviour(1);
                                constraintWidget.setWidth(((ViewGroup.MarginLayoutParams) layoutParams).width);
                                if (((ViewGroup.MarginLayoutParams) layoutParams).width == -2) {
                                    constraintWidget.setHorizontalDimensionBehaviour(2);
                                }
                            } else if (((ViewGroup.MarginLayoutParams) layoutParams).width == -1) {
                                if (layoutParams.constrainedWidth) {
                                    constraintWidget.setHorizontalDimensionBehaviour(3);
                                } else {
                                    constraintWidget.setHorizontalDimensionBehaviour(4);
                                }
                                constraintWidget.getAnchor(i5).mMargin = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                                constraintWidget.getAnchor(i4).mMargin = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                            } else {
                                constraintWidget.setHorizontalDimensionBehaviour(3);
                                constraintWidget.setWidth(0);
                            }
                            if (layoutParams.mVerticalDimensionFixed) {
                                constraintWidget.setVerticalDimensionBehaviour(1);
                                constraintWidget.setHeight(((ViewGroup.MarginLayoutParams) layoutParams).height);
                                if (((ViewGroup.MarginLayoutParams) layoutParams).height == -2) {
                                    constraintWidget.setVerticalDimensionBehaviour(2);
                                }
                            } else if (((ViewGroup.MarginLayoutParams) layoutParams).height == -1) {
                                if (layoutParams.constrainedHeight) {
                                    constraintWidget.setVerticalDimensionBehaviour(3);
                                } else {
                                    constraintWidget.setVerticalDimensionBehaviour(4);
                                }
                                constraintWidget.getAnchor(3).mMargin = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                                constraintWidget.getAnchor(5).mMargin = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                            } else {
                                constraintWidget.setVerticalDimensionBehaviour(3);
                                constraintWidget.setHeight(0);
                            }
                            String str3 = layoutParams.dimensionRatio;
                            if (str3 == null || str3.length() == 0) {
                                constraintWidget.mDimensionRatio = 0.0f;
                            } else {
                                int length = str3.length();
                                int indexOf3 = str3.indexOf(44);
                                if (indexOf3 <= 0 || indexOf3 >= length - 1) {
                                    i7 = 0;
                                    i6 = -1;
                                } else {
                                    String substring = str3.substring(0, indexOf3);
                                    if (substring.equalsIgnoreCase("W")) {
                                        i6 = 0;
                                    } else if (substring.equalsIgnoreCase("H")) {
                                        i6 = 1;
                                    } else {
                                        i6 = -1;
                                    }
                                    i7 = indexOf3 + 1;
                                }
                                int indexOf4 = str3.indexOf(58);
                                if (indexOf4 < 0 || indexOf4 >= length - 1) {
                                    String substring2 = str3.substring(i7);
                                    if (substring2.length() > 0) {
                                        f = Float.parseFloat(substring2);
                                    }
                                    f = 0.0f;
                                } else {
                                    String substring3 = str3.substring(i7, indexOf4);
                                    String substring4 = str3.substring(indexOf4 + 1);
                                    if (substring3.length() > 0 && substring4.length() > 0) {
                                        try {
                                            float parseFloat = Float.parseFloat(substring3);
                                            float parseFloat2 = Float.parseFloat(substring4);
                                            if (parseFloat > 0.0f && parseFloat2 > 0.0f) {
                                                if (i6 == 1) {
                                                    f = Math.abs(parseFloat2 / parseFloat);
                                                } else {
                                                    f = Math.abs(parseFloat / parseFloat2);
                                                }
                                            }
                                        } catch (NumberFormatException unused3) {
                                        }
                                    }
                                    f = 0.0f;
                                }
                                if (f > 0.0f) {
                                    constraintWidget.mDimensionRatio = f;
                                    constraintWidget.mDimensionRatioSide = i6;
                                }
                            }
                            float f6 = layoutParams.horizontalWeight;
                            float[] fArr = constraintWidget.mWeight;
                            fArr[0] = f6;
                            fArr[1] = layoutParams.verticalWeight;
                            constraintWidget.mHorizontalChainStyle = layoutParams.horizontalChainStyle;
                            constraintWidget.mVerticalChainStyle = layoutParams.verticalChainStyle;
                            int i42 = layoutParams.wrapBehaviorInParent;
                            if (i42 >= 0 && i42 <= 3) {
                                constraintWidget.mWrapBehaviorInParent = i42;
                            }
                            int i43 = layoutParams.matchConstraintDefaultWidth;
                            int i44 = layoutParams.matchConstraintMinWidth;
                            int i45 = layoutParams.matchConstraintMaxWidth;
                            float f7 = layoutParams.matchConstraintPercentWidth;
                            constraintWidget.mMatchConstraintDefaultWidth = i43;
                            constraintWidget.mMatchConstraintMinWidth = i44;
                            if (i45 == Integer.MAX_VALUE) {
                                i45 = 0;
                            }
                            constraintWidget.mMatchConstraintMaxWidth = i45;
                            constraintWidget.mMatchConstraintPercentWidth = f7;
                            if (f7 > 0.0f && f7 < 1.0f && i43 == 0) {
                                constraintWidget.mMatchConstraintDefaultWidth = 2;
                            }
                            int i46 = layoutParams.matchConstraintDefaultHeight;
                            int i47 = layoutParams.matchConstraintMinHeight;
                            int i48 = layoutParams.matchConstraintMaxHeight;
                            float f8 = layoutParams.matchConstraintPercentHeight;
                            constraintWidget.mMatchConstraintDefaultHeight = i46;
                            constraintWidget.mMatchConstraintMinHeight = i47;
                            if (i48 == Integer.MAX_VALUE) {
                                i48 = 0;
                            }
                            constraintWidget.mMatchConstraintMaxHeight = i48;
                            constraintWidget.mMatchConstraintPercentHeight = f8;
                            if (f8 > 0.0f && f8 < 1.0f && i46 == 0) {
                                constraintWidget.mMatchConstraintDefaultHeight = 2;
                            }
                            i23 = i3 + 1;
                            z2 = z3;
                        }
                    }
                    i3 = i23;
                    z3 = z2;
                    i23 = i3 + 1;
                    z2 = z3;
                }
            }
            if (z2) {
                constraintWidgetContainer.mBasicMeasureSolver.updateHierarchy(constraintWidgetContainer);
            }
        }
        constraintWidgetContainer.mSystem.getClass();
        constraintLayout.resolveSystem(constraintWidgetContainer, constraintLayout.mOptimizationLevel, i, i2);
        int width = constraintWidgetContainer.getWidth();
        int height = constraintWidgetContainer.getHeight();
        boolean z6 = constraintWidgetContainer.mWidthMeasuredTooSmall;
        boolean z7 = constraintWidgetContainer.mHeightMeasuredTooSmall;
        Measurer measurer = constraintLayout.mMeasurer;
        int i49 = measurer.mPaddingHeight;
        int min = Math.min(constraintLayout.mMaxWidth, View.resolveSizeAndState(width + measurer.mPaddingWidth, i, 0) & 16777215);
        int min2 = Math.min(constraintLayout.mMaxHeight, View.resolveSizeAndState(height + i49, i2, 0) & 16777215);
        if (z6) {
            min |= 16777216;
        }
        if (z7) {
            min2 |= 16777216;
        }
        constraintLayout.setMeasuredDimension(min, min2);
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
    */
    public final void resolveSystem(ConstraintWidgetContainer constraintWidgetContainer, int i, int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int width;
        DependencyGraph dependencyGraph;
        int i7;
        int i8;
        int i9;
        MatcherMatchResult matcherMatchResult;
        boolean z;
        int i10;
        boolean z2;
        int i11;
        boolean z3;
        ArrayList arrayList;
        Measurer measurer;
        boolean z4;
        boolean z5;
        int i12;
        int size;
        int i13;
        Measurer measurer2;
        int i14;
        int i15;
        int i16;
        boolean z6;
        Measurer measurer3;
        HorizontalWidgetRun horizontalWidgetRun;
        VerticalWidgetRun verticalWidgetRun;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        boolean z7;
        int size2;
        int i23;
        int size3;
        int i24;
        int i25;
        int max;
        int max2;
        int mode = View.MeasureSpec.getMode(i2);
        int size4 = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size5 = View.MeasureSpec.getSize(i3);
        int max3 = Math.max(0, getPaddingTop());
        int max4 = Math.max(0, getPaddingBottom());
        int i26 = max3 + max4;
        int paddingWidth = getPaddingWidth();
        Measurer measurer4 = this.mMeasurer;
        measurer4.mPaddingTop = max3;
        measurer4.mPaddingBottom = max4;
        measurer4.mPaddingWidth = paddingWidth;
        measurer4.mPaddingHeight = i26;
        measurer4.mLayoutWidthSpec = i2;
        measurer4.mLayoutHeightSpec = i3;
        int max5 = Math.max(0, getPaddingStart());
        int max6 = Math.max(0, getPaddingEnd());
        int i27 = 1;
        if (max5 <= 0 && max6 <= 0) {
            max5 = Math.max(0, getPaddingLeft());
        } else if ((getContext().getApplicationInfo().flags & 4194304) != 0 && 1 == getLayoutDirection()) {
            max5 = max6;
        }
        int i28 = size4 - paddingWidth;
        int i29 = size5 - i26;
        int i30 = measurer4.mPaddingHeight;
        int i31 = measurer4.mPaddingWidth;
        int childCount = getChildCount();
        if (mode != Integer.MIN_VALUE) {
            if (mode != 0) {
                if (mode == 1073741824) {
                    i4 = Math.min(this.mMaxWidth - i31, i28);
                    i27 = 1;
                    if (mode2 == Integer.MIN_VALUE) {
                        if (mode2 != 0) {
                            if (mode2 != 1073741824) {
                                i6 = 1;
                            } else {
                                i5 = Math.min(this.mMaxHeight - i30, i29);
                                i6 = 1;
                                width = constraintWidgetContainer.getWidth();
                                dependencyGraph = constraintWidgetContainer.mDependencyGraph;
                                int[] iArr = constraintWidgetContainer.mMaxDimension;
                                i7 = i4;
                                if (i7 == width || i5 != constraintWidgetContainer.getHeight()) {
                                    dependencyGraph.mNeedRedoMeasures = true;
                                }
                                constraintWidgetContainer.f2mX = 0;
                                constraintWidgetContainer.f3mY = 0;
                                iArr[0] = this.mMaxWidth - i31;
                                iArr[1] = this.mMaxHeight - i30;
                                constraintWidgetContainer.mMinWidth = 0;
                                constraintWidgetContainer.mMinHeight = 0;
                                constraintWidgetContainer.setHorizontalDimensionBehaviour(i27);
                                constraintWidgetContainer.setWidth(i7);
                                constraintWidgetContainer.setVerticalDimensionBehaviour(i6);
                                constraintWidgetContainer.setHeight(i5);
                                i8 = this.mMinWidth - i31;
                                if (i8 < 0) {
                                    constraintWidgetContainer.mMinWidth = 0;
                                } else {
                                    constraintWidgetContainer.mMinWidth = i8;
                                }
                                i9 = this.mMinHeight - i30;
                                if (i9 < 0) {
                                    constraintWidgetContainer.mMinHeight = 0;
                                } else {
                                    constraintWidgetContainer.mMinHeight = i9;
                                }
                                constraintWidgetContainer.mPaddingLeft = max5;
                                constraintWidgetContainer.mPaddingTop = max3;
                                matcherMatchResult = constraintWidgetContainer.mBasicMeasureSolver;
                                ConstraintWidgetContainer constraintWidgetContainer2 = (ConstraintWidgetContainer) matcherMatchResult.groups;
                                ArrayList arrayList2 = (ArrayList) matcherMatchResult.matcher;
                                Measurer measurer5 = constraintWidgetContainer.mMeasurer;
                                int size6 = constraintWidgetContainer.mChildren.size();
                                int width2 = constraintWidgetContainer.getWidth();
                                int height = constraintWidgetContainer.getHeight();
                                boolean enabled = Chain.enabled(i, 128);
                                z = !enabled || Chain.enabled(i, 64);
                                if (z) {
                                    int i32 = 0;
                                    while (i32 < size6) {
                                        z = z;
                                        ConstraintWidget constraintWidget = (ConstraintWidget) constraintWidgetContainer.mChildren.get(i32);
                                        int i33 = i32;
                                        int[] iArr2 = constraintWidget.mListDimensionBehaviors;
                                        i10 = size6;
                                        boolean z8 = (iArr2[0] == 3) && (iArr2[1] == 3) && constraintWidget.mDimensionRatio > 0.0f;
                                        if ((constraintWidget.isInHorizontalChain() && z8) || ((constraintWidget.isInVerticalChain() && z8) || (constraintWidget instanceof Flow) || constraintWidget.isInHorizontalChain() || constraintWidget.isInVerticalChain())) {
                                            i11 = 1073741824;
                                            z2 = false;
                                            break;
                                        }
                                        i32 = i33 + 1;
                                        size6 = i10;
                                    }
                                }
                                z2 = z;
                                i10 = size6;
                                i11 = 1073741824;
                                z3 = z2 & ((mode != i11 && mode2 == i11) || enabled);
                                if (z3) {
                                    int min = Math.min(iArr[0], i28);
                                    int min2 = Math.min(iArr[1], i29);
                                    int i34 = 1073741824;
                                    if (mode == 1073741824) {
                                        if (constraintWidgetContainer.getWidth() != min) {
                                            constraintWidgetContainer.setWidth(min);
                                            dependencyGraph.mNeedBuildGraph = true;
                                        }
                                        i34 = 1073741824;
                                    }
                                    if (mode2 == i34 && constraintWidgetContainer.getHeight() != min2) {
                                        constraintWidgetContainer.setHeight(min2);
                                        dependencyGraph.mNeedBuildGraph = true;
                                    }
                                    if (mode == i34 && mode2 == i34) {
                                        ArrayList arrayList3 = dependencyGraph.mRuns;
                                        ConstraintWidgetContainer constraintWidgetContainer3 = dependencyGraph.mWidgetcontainer;
                                        if (dependencyGraph.mNeedBuildGraph || dependencyGraph.mNeedRedoMeasures) {
                                            ArrayList arrayList4 = constraintWidgetContainer3.mChildren;
                                            int size7 = arrayList4.size();
                                            z4 = z3;
                                            int i35 = 0;
                                            while (i35 < size7) {
                                                Object obj = arrayList4.get(i35);
                                                i35++;
                                                ConstraintWidget constraintWidget2 = (ConstraintWidget) obj;
                                                constraintWidget2.ensureWidgetRuns();
                                                arrayList4 = arrayList4;
                                                constraintWidget2.measured = false;
                                                constraintWidget2.mHorizontalRun.reset();
                                                constraintWidget2.mVerticalRun.reset();
                                            }
                                            constraintWidgetContainer3.ensureWidgetRuns();
                                            i19 = 0;
                                            constraintWidgetContainer3.measured = false;
                                            constraintWidgetContainer3.mHorizontalRun.reset();
                                            constraintWidgetContainer3.mVerticalRun.reset();
                                            dependencyGraph.mNeedRedoMeasures = false;
                                        } else {
                                            z4 = z3;
                                            i19 = 0;
                                        }
                                        dependencyGraph.basicMeasureWidgets(dependencyGraph.mContainer);
                                        constraintWidgetContainer3.f2mX = i19;
                                        int[] iArr3 = constraintWidgetContainer3.mListDimensionBehaviors;
                                        constraintWidgetContainer3.f3mY = i19;
                                        int dimensionBehaviour = constraintWidgetContainer3.getDimensionBehaviour(i19);
                                        int dimensionBehaviour2 = constraintWidgetContainer3.getDimensionBehaviour(1);
                                        if (dependencyGraph.mNeedBuildGraph) {
                                            dependencyGraph.buildGraph();
                                        }
                                        int x = constraintWidgetContainer3.getX();
                                        measurer = measurer5;
                                        int y = constraintWidgetContainer3.getY();
                                        arrayList = arrayList2;
                                        constraintWidgetContainer3.mHorizontalRun.start.resolve(x);
                                        constraintWidgetContainer3.mVerticalRun.start.resolve(y);
                                        dependencyGraph.measureWidgets();
                                        if (dimensionBehaviour == 2 || dimensionBehaviour2 == 2) {
                                            if (enabled) {
                                                int size8 = arrayList3.size();
                                                i20 = x;
                                                int i36 = 0;
                                                while (true) {
                                                    if (i36 >= size8) {
                                                        break;
                                                    }
                                                    Object obj2 = arrayList3.get(i36);
                                                    i36++;
                                                    if (!((WidgetRun) obj2).supportsWrapComputation()) {
                                                        enabled = false;
                                                        break;
                                                    }
                                                }
                                            } else {
                                                i20 = x;
                                            }
                                            if (enabled && dimensionBehaviour == 2) {
                                                constraintWidgetContainer3.setHorizontalDimensionBehaviour(1);
                                                constraintWidgetContainer3.setWidth(dependencyGraph.computeWrap(constraintWidgetContainer3, 0));
                                                constraintWidgetContainer3.mHorizontalRun.mDimension.resolve(constraintWidgetContainer3.getWidth());
                                            }
                                            if (enabled && dimensionBehaviour2 == 2) {
                                                i21 = 1;
                                                constraintWidgetContainer3.setVerticalDimensionBehaviour(1);
                                                constraintWidgetContainer3.setHeight(dependencyGraph.computeWrap(constraintWidgetContainer3, 1));
                                                constraintWidgetContainer3.mVerticalRun.mDimension.resolve(constraintWidgetContainer3.getHeight());
                                                i22 = iArr3[0];
                                                if (i22 != i21 || i22 == 4) {
                                                    int width3 = constraintWidgetContainer3.getWidth() + i20;
                                                    constraintWidgetContainer3.mHorizontalRun.end.resolve(width3);
                                                    constraintWidgetContainer3.mHorizontalRun.mDimension.resolve(width3 - i20);
                                                    dependencyGraph.measureWidgets();
                                                    i25 = iArr3[1];
                                                    if (i25 != 1 || i25 == 4) {
                                                        int height2 = constraintWidgetContainer3.getHeight() + y;
                                                        constraintWidgetContainer3.mVerticalRun.end.resolve(height2);
                                                        constraintWidgetContainer3.mVerticalRun.mDimension.resolve(height2 - y);
                                                    }
                                                    dependencyGraph.measureWidgets();
                                                    z7 = true;
                                                } else {
                                                    z7 = false;
                                                }
                                                size2 = arrayList3.size();
                                                i23 = 0;
                                                while (i23 < size2) {
                                                    Object obj3 = arrayList3.get(i23);
                                                    i23++;
                                                    WidgetRun widgetRun = (WidgetRun) obj3;
                                                    if (widgetRun.mWidget != constraintWidgetContainer3 || widgetRun.mResolved) {
                                                        widgetRun.applyToWidget();
                                                    }
                                                }
                                                size3 = arrayList3.size();
                                                i24 = 0;
                                                while (i24 < size3) {
                                                    Object obj4 = arrayList3.get(i24);
                                                    i24++;
                                                    WidgetRun widgetRun2 = (WidgetRun) obj4;
                                                    if (z7 || widgetRun2.mWidget != constraintWidgetContainer3) {
                                                        if (!widgetRun2.start.resolved || ((!widgetRun2.end.resolved && !(widgetRun2 instanceof GuidelineReference)) || (!widgetRun2.mDimension.resolved && !(widgetRun2 instanceof ChainRun) && !(widgetRun2 instanceof GuidelineReference)))) {
                                                            z5 = false;
                                                            break;
                                                        }
                                                    }
                                                }
                                                z5 = true;
                                                constraintWidgetContainer3.setHorizontalDimensionBehaviour(dimensionBehaviour);
                                                constraintWidgetContainer3.setVerticalDimensionBehaviour(dimensionBehaviour2);
                                                i12 = 2;
                                                i17 = 1073741824;
                                            }
                                        } else {
                                            i20 = x;
                                        }
                                        i21 = 1;
                                        i22 = iArr3[0];
                                        if (i22 != i21) {
                                        }
                                        int width32 = constraintWidgetContainer3.getWidth() + i20;
                                        constraintWidgetContainer3.mHorizontalRun.end.resolve(width32);
                                        constraintWidgetContainer3.mHorizontalRun.mDimension.resolve(width32 - i20);
                                        dependencyGraph.measureWidgets();
                                        i25 = iArr3[1];
                                        if (i25 != 1) {
                                        }
                                        int height22 = constraintWidgetContainer3.getHeight() + y;
                                        constraintWidgetContainer3.mVerticalRun.end.resolve(height22);
                                        constraintWidgetContainer3.mVerticalRun.mDimension.resolve(height22 - y);
                                        dependencyGraph.measureWidgets();
                                        z7 = true;
                                        size2 = arrayList3.size();
                                        i23 = 0;
                                        while (i23 < size2) {
                                        }
                                        size3 = arrayList3.size();
                                        i24 = 0;
                                        while (i24 < size3) {
                                        }
                                        z5 = true;
                                        constraintWidgetContainer3.setHorizontalDimensionBehaviour(dimensionBehaviour);
                                        constraintWidgetContainer3.setVerticalDimensionBehaviour(dimensionBehaviour2);
                                        i12 = 2;
                                        i17 = 1073741824;
                                    } else {
                                        z4 = z3;
                                        arrayList = arrayList2;
                                        measurer = measurer5;
                                        ConstraintWidgetContainer constraintWidgetContainer4 = dependencyGraph.mWidgetcontainer;
                                        if (dependencyGraph.mNeedBuildGraph) {
                                            ArrayList arrayList5 = constraintWidgetContainer4.mChildren;
                                            int size9 = arrayList5.size();
                                            int i37 = 0;
                                            while (i37 < size9) {
                                                Object obj5 = arrayList5.get(i37);
                                                i37++;
                                                ConstraintWidget constraintWidget3 = (ConstraintWidget) obj5;
                                                constraintWidget3.ensureWidgetRuns();
                                                constraintWidget3.measured = false;
                                                HorizontalWidgetRun horizontalWidgetRun2 = constraintWidget3.mHorizontalRun;
                                                arrayList5 = arrayList5;
                                                horizontalWidgetRun2.mDimension.resolved = false;
                                                horizontalWidgetRun2.mResolved = false;
                                                horizontalWidgetRun2.reset();
                                                VerticalWidgetRun verticalWidgetRun2 = constraintWidget3.mVerticalRun;
                                                verticalWidgetRun2.mDimension.resolved = false;
                                                verticalWidgetRun2.mResolved = false;
                                                verticalWidgetRun2.reset();
                                            }
                                            i18 = 0;
                                            constraintWidgetContainer4.ensureWidgetRuns();
                                            constraintWidgetContainer4.measured = false;
                                            HorizontalWidgetRun horizontalWidgetRun3 = constraintWidgetContainer4.mHorizontalRun;
                                            horizontalWidgetRun3.mDimension.resolved = false;
                                            horizontalWidgetRun3.mResolved = false;
                                            horizontalWidgetRun3.reset();
                                            VerticalWidgetRun verticalWidgetRun3 = constraintWidgetContainer4.mVerticalRun;
                                            verticalWidgetRun3.mDimension.resolved = false;
                                            verticalWidgetRun3.mResolved = false;
                                            verticalWidgetRun3.reset();
                                            dependencyGraph.buildGraph();
                                        } else {
                                            i18 = 0;
                                        }
                                        dependencyGraph.basicMeasureWidgets(dependencyGraph.mContainer);
                                        constraintWidgetContainer4.f2mX = i18;
                                        constraintWidgetContainer4.f3mY = i18;
                                        constraintWidgetContainer4.mHorizontalRun.start.resolve(i18);
                                        constraintWidgetContainer4.mVerticalRun.start.resolve(i18);
                                        i17 = 1073741824;
                                        if (mode == 1073741824) {
                                            z5 = constraintWidgetContainer.directMeasureWithOrientation(i18, enabled);
                                            i12 = 1;
                                        } else {
                                            i12 = 0;
                                            z5 = true;
                                        }
                                        if (mode2 == 1073741824) {
                                            z5 &= constraintWidgetContainer.directMeasureWithOrientation(1, enabled);
                                            i12++;
                                        }
                                    }
                                    if (z5) {
                                        constraintWidgetContainer.updateFromRuns(mode == i17, mode2 == i17);
                                    }
                                } else {
                                    z4 = z3;
                                    arrayList = arrayList2;
                                    measurer = measurer5;
                                    i12 = 0;
                                    z5 = false;
                                }
                                if (z5 || i12 != 2) {
                                    int i38 = constraintWidgetContainer.mOptimizationLevel;
                                    if (i10 > 0) {
                                        int size10 = constraintWidgetContainer.mChildren.size();
                                        boolean optimizeFor = constraintWidgetContainer.optimizeFor(64);
                                        Measurer measurer6 = constraintWidgetContainer.mMeasurer;
                                        for (int i39 = 0; i39 < size10; i39++) {
                                            ConstraintWidget constraintWidget4 = (ConstraintWidget) constraintWidgetContainer.mChildren.get(i39);
                                            if (!(constraintWidget4 instanceof Guideline) && !(constraintWidget4 instanceof Barrier) && !constraintWidget4.mInVirtualLayout && (!optimizeFor || (horizontalWidgetRun = constraintWidget4.mHorizontalRun) == null || (verticalWidgetRun = constraintWidget4.mVerticalRun) == null || !horizontalWidgetRun.mDimension.resolved || !verticalWidgetRun.mDimension.resolved)) {
                                                int dimensionBehaviour3 = constraintWidget4.getDimensionBehaviour(0);
                                                int dimensionBehaviour4 = constraintWidget4.getDimensionBehaviour(1);
                                                boolean z9 = dimensionBehaviour3 == 3 && constraintWidget4.mMatchConstraintDefaultWidth != 1 && dimensionBehaviour4 == 3 && constraintWidget4.mMatchConstraintDefaultHeight != 1;
                                                if (!z9 && constraintWidgetContainer.optimizeFor(1) && !(constraintWidget4 instanceof Flow)) {
                                                    if (dimensionBehaviour3 == 3 && constraintWidget4.mMatchConstraintDefaultWidth == 0 && dimensionBehaviour4 != 3 && !constraintWidget4.isInHorizontalChain()) {
                                                        z9 = true;
                                                    }
                                                    if (dimensionBehaviour4 == 3 && constraintWidget4.mMatchConstraintDefaultHeight == 0 && dimensionBehaviour3 != 3 && !constraintWidget4.isInHorizontalChain()) {
                                                        z9 = true;
                                                    }
                                                    if ((dimensionBehaviour3 == 3 || dimensionBehaviour4 == 3) && constraintWidget4.mDimensionRatio > 0.0f) {
                                                        z9 = true;
                                                    }
                                                }
                                                if (!z9) {
                                                    matcherMatchResult.measure(0, constraintWidget4, measurer6);
                                                }
                                            }
                                        }
                                        ConstraintLayout constraintLayout = measurer6.mLayout;
                                        int childCount2 = constraintLayout.getChildCount();
                                        ArrayList arrayList6 = constraintLayout.mConstraintHelpers;
                                        for (int i40 = 0; i40 < childCount2; i40++) {
                                            constraintLayout.getChildAt(i40);
                                        }
                                        int size11 = arrayList6.size();
                                        if (size11 > 0) {
                                            for (int i41 = 0; i41 < size11; i41++) {
                                                ((ConstraintHelper) arrayList6.get(i41)).getClass();
                                            }
                                        }
                                    }
                                    matcherMatchResult.updateHierarchy(constraintWidgetContainer);
                                    size = arrayList.size();
                                    if (i10 > 0) {
                                        matcherMatchResult.solveLinearSystem(constraintWidgetContainer, 0, width2, height);
                                    }
                                    if (size > 0) {
                                        int[] iArr4 = constraintWidgetContainer.mListDimensionBehaviors;
                                        boolean z10 = iArr4[0] == 2;
                                        boolean z11 = iArr4[1] == 2;
                                        int max7 = Math.max(constraintWidgetContainer.getWidth(), constraintWidgetContainer2.mMinWidth);
                                        int max8 = Math.max(constraintWidgetContainer.getHeight(), constraintWidgetContainer2.mMinHeight);
                                        int i42 = 0;
                                        boolean z12 = false;
                                        while (i42 < size) {
                                            ArrayList arrayList7 = arrayList;
                                            ConstraintWidget constraintWidget5 = (ConstraintWidget) arrayList7.get(i42);
                                            if (!(constraintWidget5 instanceof Flow)) {
                                                z6 = z11;
                                                i16 = i42;
                                                measurer3 = measurer;
                                            } else {
                                                int width4 = constraintWidget5.getWidth();
                                                int height3 = constraintWidget5.getHeight();
                                                z6 = z11;
                                                i16 = i42;
                                                measurer3 = measurer;
                                                boolean measure = z12 | matcherMatchResult.measure(1, constraintWidget5, measurer3);
                                                int width5 = constraintWidget5.getWidth();
                                                int height4 = constraintWidget5.getHeight();
                                                if (width5 != width4) {
                                                    constraintWidget5.setWidth(width5);
                                                    if (z10 && constraintWidget5.getX() + constraintWidget5.mWidth > max7) {
                                                        max7 = Math.max(max7, constraintWidget5.getAnchor(4).getMargin() + constraintWidget5.getX() + constraintWidget5.mWidth);
                                                    }
                                                    measure = true;
                                                }
                                                if (height4 != height3) {
                                                    constraintWidget5.setHeight(height4);
                                                    if (z6 && constraintWidget5.getY() + constraintWidget5.mHeight > max8) {
                                                        max8 = Math.max(max8, constraintWidget5.getAnchor(5).getMargin() + constraintWidget5.getY() + constraintWidget5.mHeight);
                                                    }
                                                    measure = true;
                                                }
                                                z12 = measure | ((Flow) constraintWidget5).mNeedsCallFromSolver;
                                            }
                                            i42 = i16 + 1;
                                            measurer = measurer3;
                                            arrayList = arrayList7;
                                            z11 = z6;
                                        }
                                        boolean z13 = z11;
                                        ArrayList arrayList8 = arrayList;
                                        int i43 = 0;
                                        while (true) {
                                            Measurer measurer7 = measurer;
                                            if (i43 >= 2) {
                                                break;
                                            }
                                            int i44 = 0;
                                            while (i44 < size) {
                                                ConstraintWidget constraintWidget6 = (ConstraintWidget) arrayList8.get(i44);
                                                if ((!(constraintWidget6 instanceof HelperWidget) || (constraintWidget6 instanceof Flow)) && !(constraintWidget6 instanceof Guideline)) {
                                                    i15 = size;
                                                    if (constraintWidget6.mVisibility != 8 && ((!z4 || !constraintWidget6.mHorizontalRun.mDimension.resolved || !constraintWidget6.mVerticalRun.mDimension.resolved) && !(constraintWidget6 instanceof Flow))) {
                                                        int width6 = constraintWidget6.getWidth();
                                                        int height5 = constraintWidget6.getHeight();
                                                        i14 = i44;
                                                        int i45 = constraintWidget6.mBaselineDistance;
                                                        boolean z14 = z12;
                                                        int i46 = 1;
                                                        if (i43 == 1) {
                                                            i46 = 2;
                                                        }
                                                        z12 = z14 | matcherMatchResult.measure(i46, constraintWidget6, measurer7);
                                                        measurer2 = measurer7;
                                                        int width7 = constraintWidget6.getWidth();
                                                        i13 = i43;
                                                        int height6 = constraintWidget6.getHeight();
                                                        if (width7 != width6) {
                                                            constraintWidget6.setWidth(width7);
                                                            if (z10 && constraintWidget6.getX() + constraintWidget6.mWidth > max7) {
                                                                max7 = Math.max(max7, constraintWidget6.getAnchor(4).getMargin() + constraintWidget6.getX() + constraintWidget6.mWidth);
                                                            }
                                                            z12 = true;
                                                        }
                                                        if (height6 != height5) {
                                                            constraintWidget6.setHeight(height6);
                                                            if (z13 && constraintWidget6.getY() + constraintWidget6.mHeight > max8) {
                                                                max8 = Math.max(max8, constraintWidget6.getAnchor(5).getMargin() + constraintWidget6.getY() + constraintWidget6.mHeight);
                                                            }
                                                            z12 = true;
                                                        }
                                                        if (constraintWidget6.mHasBaseline && i45 != constraintWidget6.mBaselineDistance) {
                                                            z12 = true;
                                                        }
                                                        i44 = i14 + 1;
                                                        size = i15;
                                                        measurer7 = measurer2;
                                                        i43 = i13;
                                                    }
                                                } else {
                                                    i15 = size;
                                                }
                                                measurer2 = measurer7;
                                                i13 = i43;
                                                i14 = i44;
                                                i44 = i14 + 1;
                                                size = i15;
                                                measurer7 = measurer2;
                                                i43 = i13;
                                            }
                                            size = size;
                                            measurer = measurer7;
                                            int i47 = i43;
                                            if (!z12) {
                                                break;
                                            }
                                            int i48 = i47 + 1;
                                            matcherMatchResult.solveLinearSystem(constraintWidgetContainer, i48, width2, height);
                                            i43 = i48;
                                            z12 = false;
                                        }
                                    }
                                    constraintWidgetContainer.mOptimizationLevel = i38;
                                    LinearSystem.USE_DEPENDENCY_ORDERING = constraintWidgetContainer.optimizeFor(LogviewFragment.MAX_LINES);
                                }
                                return;
                            }
                        } else if (childCount == 0) {
                            max = Math.max(0, this.mMinHeight);
                        } else {
                            i6 = 2;
                        }
                        i5 = 0;
                        width = constraintWidgetContainer.getWidth();
                        dependencyGraph = constraintWidgetContainer.mDependencyGraph;
                        int[] iArr5 = constraintWidgetContainer.mMaxDimension;
                        i7 = i4;
                        if (i7 == width) {
                        }
                        dependencyGraph.mNeedRedoMeasures = true;
                        constraintWidgetContainer.f2mX = 0;
                        constraintWidgetContainer.f3mY = 0;
                        iArr5[0] = this.mMaxWidth - i31;
                        iArr5[1] = this.mMaxHeight - i30;
                        constraintWidgetContainer.mMinWidth = 0;
                        constraintWidgetContainer.mMinHeight = 0;
                        constraintWidgetContainer.setHorizontalDimensionBehaviour(i27);
                        constraintWidgetContainer.setWidth(i7);
                        constraintWidgetContainer.setVerticalDimensionBehaviour(i6);
                        constraintWidgetContainer.setHeight(i5);
                        i8 = this.mMinWidth - i31;
                        if (i8 < 0) {
                        }
                        i9 = this.mMinHeight - i30;
                        if (i9 < 0) {
                        }
                        constraintWidgetContainer.mPaddingLeft = max5;
                        constraintWidgetContainer.mPaddingTop = max3;
                        matcherMatchResult = constraintWidgetContainer.mBasicMeasureSolver;
                        ConstraintWidgetContainer constraintWidgetContainer22 = (ConstraintWidgetContainer) matcherMatchResult.groups;
                        ArrayList arrayList22 = (ArrayList) matcherMatchResult.matcher;
                        Measurer measurer52 = constraintWidgetContainer.mMeasurer;
                        int size62 = constraintWidgetContainer.mChildren.size();
                        int width22 = constraintWidgetContainer.getWidth();
                        int height7 = constraintWidgetContainer.getHeight();
                        boolean enabled2 = Chain.enabled(i, 128);
                        if (!enabled2) {
                        }
                        if (z) {
                        }
                        z2 = z;
                        i10 = size62;
                        i11 = 1073741824;
                        z3 = z2 & ((mode != i11 && mode2 == i11) || enabled2);
                        if (z3) {
                        }
                        if (z5) {
                        }
                        int i382 = constraintWidgetContainer.mOptimizationLevel;
                        if (i10 > 0) {
                        }
                        matcherMatchResult.updateHierarchy(constraintWidgetContainer);
                        size = arrayList.size();
                        if (i10 > 0) {
                        }
                        if (size > 0) {
                        }
                        constraintWidgetContainer.mOptimizationLevel = i382;
                        LinearSystem.USE_DEPENDENCY_ORDERING = constraintWidgetContainer.optimizeFor(LogviewFragment.MAX_LINES);
                    } else if (childCount == 0) {
                        max = Math.max(0, this.mMinHeight);
                    } else {
                        i5 = i29;
                        i6 = 2;
                        width = constraintWidgetContainer.getWidth();
                        dependencyGraph = constraintWidgetContainer.mDependencyGraph;
                        int[] iArr52 = constraintWidgetContainer.mMaxDimension;
                        i7 = i4;
                        if (i7 == width) {
                        }
                        dependencyGraph.mNeedRedoMeasures = true;
                        constraintWidgetContainer.f2mX = 0;
                        constraintWidgetContainer.f3mY = 0;
                        iArr52[0] = this.mMaxWidth - i31;
                        iArr52[1] = this.mMaxHeight - i30;
                        constraintWidgetContainer.mMinWidth = 0;
                        constraintWidgetContainer.mMinHeight = 0;
                        constraintWidgetContainer.setHorizontalDimensionBehaviour(i27);
                        constraintWidgetContainer.setWidth(i7);
                        constraintWidgetContainer.setVerticalDimensionBehaviour(i6);
                        constraintWidgetContainer.setHeight(i5);
                        i8 = this.mMinWidth - i31;
                        if (i8 < 0) {
                        }
                        i9 = this.mMinHeight - i30;
                        if (i9 < 0) {
                        }
                        constraintWidgetContainer.mPaddingLeft = max5;
                        constraintWidgetContainer.mPaddingTop = max3;
                        matcherMatchResult = constraintWidgetContainer.mBasicMeasureSolver;
                        ConstraintWidgetContainer constraintWidgetContainer222 = (ConstraintWidgetContainer) matcherMatchResult.groups;
                        ArrayList arrayList222 = (ArrayList) matcherMatchResult.matcher;
                        Measurer measurer522 = constraintWidgetContainer.mMeasurer;
                        int size622 = constraintWidgetContainer.mChildren.size();
                        int width222 = constraintWidgetContainer.getWidth();
                        int height72 = constraintWidgetContainer.getHeight();
                        boolean enabled22 = Chain.enabled(i, 128);
                        if (!enabled22) {
                        }
                        if (z) {
                        }
                        z2 = z;
                        i10 = size622;
                        i11 = 1073741824;
                        z3 = z2 & ((mode != i11 && mode2 == i11) || enabled22);
                        if (z3) {
                        }
                        if (z5) {
                        }
                        int i3822 = constraintWidgetContainer.mOptimizationLevel;
                        if (i10 > 0) {
                        }
                        matcherMatchResult.updateHierarchy(constraintWidgetContainer);
                        size = arrayList.size();
                        if (i10 > 0) {
                        }
                        if (size > 0) {
                        }
                        constraintWidgetContainer.mOptimizationLevel = i3822;
                        LinearSystem.USE_DEPENDENCY_ORDERING = constraintWidgetContainer.optimizeFor(LogviewFragment.MAX_LINES);
                    }
                    i5 = max;
                    i6 = 2;
                    width = constraintWidgetContainer.getWidth();
                    dependencyGraph = constraintWidgetContainer.mDependencyGraph;
                    int[] iArr522 = constraintWidgetContainer.mMaxDimension;
                    i7 = i4;
                    if (i7 == width) {
                    }
                    dependencyGraph.mNeedRedoMeasures = true;
                    constraintWidgetContainer.f2mX = 0;
                    constraintWidgetContainer.f3mY = 0;
                    iArr522[0] = this.mMaxWidth - i31;
                    iArr522[1] = this.mMaxHeight - i30;
                    constraintWidgetContainer.mMinWidth = 0;
                    constraintWidgetContainer.mMinHeight = 0;
                    constraintWidgetContainer.setHorizontalDimensionBehaviour(i27);
                    constraintWidgetContainer.setWidth(i7);
                    constraintWidgetContainer.setVerticalDimensionBehaviour(i6);
                    constraintWidgetContainer.setHeight(i5);
                    i8 = this.mMinWidth - i31;
                    if (i8 < 0) {
                    }
                    i9 = this.mMinHeight - i30;
                    if (i9 < 0) {
                    }
                    constraintWidgetContainer.mPaddingLeft = max5;
                    constraintWidgetContainer.mPaddingTop = max3;
                    matcherMatchResult = constraintWidgetContainer.mBasicMeasureSolver;
                    ConstraintWidgetContainer constraintWidgetContainer2222 = (ConstraintWidgetContainer) matcherMatchResult.groups;
                    ArrayList arrayList2222 = (ArrayList) matcherMatchResult.matcher;
                    Measurer measurer5222 = constraintWidgetContainer.mMeasurer;
                    int size6222 = constraintWidgetContainer.mChildren.size();
                    int width2222 = constraintWidgetContainer.getWidth();
                    int height722 = constraintWidgetContainer.getHeight();
                    boolean enabled222 = Chain.enabled(i, 128);
                    if (!enabled222) {
                    }
                    if (z) {
                    }
                    z2 = z;
                    i10 = size6222;
                    i11 = 1073741824;
                    z3 = z2 & ((mode != i11 && mode2 == i11) || enabled222);
                    if (z3) {
                    }
                    if (z5) {
                    }
                    int i38222 = constraintWidgetContainer.mOptimizationLevel;
                    if (i10 > 0) {
                    }
                    matcherMatchResult.updateHierarchy(constraintWidgetContainer);
                    size = arrayList.size();
                    if (i10 > 0) {
                    }
                    if (size > 0) {
                    }
                    constraintWidgetContainer.mOptimizationLevel = i38222;
                    LinearSystem.USE_DEPENDENCY_ORDERING = constraintWidgetContainer.optimizeFor(LogviewFragment.MAX_LINES);
                }
            } else if (childCount == 0) {
                max2 = Math.max(0, this.mMinWidth);
            } else {
                i27 = 2;
            }
            i4 = 0;
            if (mode2 == Integer.MIN_VALUE) {
            }
            i5 = max;
            i6 = 2;
            width = constraintWidgetContainer.getWidth();
            dependencyGraph = constraintWidgetContainer.mDependencyGraph;
            int[] iArr5222 = constraintWidgetContainer.mMaxDimension;
            i7 = i4;
            if (i7 == width) {
            }
            dependencyGraph.mNeedRedoMeasures = true;
            constraintWidgetContainer.f2mX = 0;
            constraintWidgetContainer.f3mY = 0;
            iArr5222[0] = this.mMaxWidth - i31;
            iArr5222[1] = this.mMaxHeight - i30;
            constraintWidgetContainer.mMinWidth = 0;
            constraintWidgetContainer.mMinHeight = 0;
            constraintWidgetContainer.setHorizontalDimensionBehaviour(i27);
            constraintWidgetContainer.setWidth(i7);
            constraintWidgetContainer.setVerticalDimensionBehaviour(i6);
            constraintWidgetContainer.setHeight(i5);
            i8 = this.mMinWidth - i31;
            if (i8 < 0) {
            }
            i9 = this.mMinHeight - i30;
            if (i9 < 0) {
            }
            constraintWidgetContainer.mPaddingLeft = max5;
            constraintWidgetContainer.mPaddingTop = max3;
            matcherMatchResult = constraintWidgetContainer.mBasicMeasureSolver;
            ConstraintWidgetContainer constraintWidgetContainer22222 = (ConstraintWidgetContainer) matcherMatchResult.groups;
            ArrayList arrayList22222 = (ArrayList) matcherMatchResult.matcher;
            Measurer measurer52222 = constraintWidgetContainer.mMeasurer;
            int size62222 = constraintWidgetContainer.mChildren.size();
            int width22222 = constraintWidgetContainer.getWidth();
            int height7222 = constraintWidgetContainer.getHeight();
            boolean enabled2222 = Chain.enabled(i, 128);
            if (!enabled2222) {
            }
            if (z) {
            }
            z2 = z;
            i10 = size62222;
            i11 = 1073741824;
            z3 = z2 & ((mode != i11 && mode2 == i11) || enabled2222);
            if (z3) {
            }
            if (z5) {
            }
            int i382222 = constraintWidgetContainer.mOptimizationLevel;
            if (i10 > 0) {
            }
            matcherMatchResult.updateHierarchy(constraintWidgetContainer);
            size = arrayList.size();
            if (i10 > 0) {
            }
            if (size > 0) {
            }
            constraintWidgetContainer.mOptimizationLevel = i382222;
            LinearSystem.USE_DEPENDENCY_ORDERING = constraintWidgetContainer.optimizeFor(LogviewFragment.MAX_LINES);
        } else if (childCount == 0) {
            max2 = Math.max(0, this.mMinWidth);
        } else {
            i4 = i28;
            i27 = 2;
            if (mode2 == Integer.MIN_VALUE) {
            }
            i5 = max;
            i6 = 2;
            width = constraintWidgetContainer.getWidth();
            dependencyGraph = constraintWidgetContainer.mDependencyGraph;
            int[] iArr52222 = constraintWidgetContainer.mMaxDimension;
            i7 = i4;
            if (i7 == width) {
            }
            dependencyGraph.mNeedRedoMeasures = true;
            constraintWidgetContainer.f2mX = 0;
            constraintWidgetContainer.f3mY = 0;
            iArr52222[0] = this.mMaxWidth - i31;
            iArr52222[1] = this.mMaxHeight - i30;
            constraintWidgetContainer.mMinWidth = 0;
            constraintWidgetContainer.mMinHeight = 0;
            constraintWidgetContainer.setHorizontalDimensionBehaviour(i27);
            constraintWidgetContainer.setWidth(i7);
            constraintWidgetContainer.setVerticalDimensionBehaviour(i6);
            constraintWidgetContainer.setHeight(i5);
            i8 = this.mMinWidth - i31;
            if (i8 < 0) {
            }
            i9 = this.mMinHeight - i30;
            if (i9 < 0) {
            }
            constraintWidgetContainer.mPaddingLeft = max5;
            constraintWidgetContainer.mPaddingTop = max3;
            matcherMatchResult = constraintWidgetContainer.mBasicMeasureSolver;
            ConstraintWidgetContainer constraintWidgetContainer222222 = (ConstraintWidgetContainer) matcherMatchResult.groups;
            ArrayList arrayList222222 = (ArrayList) matcherMatchResult.matcher;
            Measurer measurer522222 = constraintWidgetContainer.mMeasurer;
            int size622222 = constraintWidgetContainer.mChildren.size();
            int width222222 = constraintWidgetContainer.getWidth();
            int height72222 = constraintWidgetContainer.getHeight();
            boolean enabled22222 = Chain.enabled(i, 128);
            if (!enabled22222) {
            }
            if (z) {
            }
            z2 = z;
            i10 = size622222;
            i11 = 1073741824;
            z3 = z2 & ((mode != i11 && mode2 == i11) || enabled22222);
            if (z3) {
            }
            if (z5) {
            }
            int i3822222 = constraintWidgetContainer.mOptimizationLevel;
            if (i10 > 0) {
            }
            matcherMatchResult.updateHierarchy(constraintWidgetContainer);
            size = arrayList.size();
            if (i10 > 0) {
            }
            if (size > 0) {
            }
            constraintWidgetContainer.mOptimizationLevel = i3822222;
            LinearSystem.USE_DEPENDENCY_ORDERING = constraintWidgetContainer.optimizeFor(LogviewFragment.MAX_LINES);
        }
        i4 = max2;
        i27 = 2;
        if (mode2 == Integer.MIN_VALUE) {
        }
        i5 = max;
        i6 = 2;
        width = constraintWidgetContainer.getWidth();
        dependencyGraph = constraintWidgetContainer.mDependencyGraph;
        int[] iArr522222 = constraintWidgetContainer.mMaxDimension;
        i7 = i4;
        if (i7 == width) {
        }
        dependencyGraph.mNeedRedoMeasures = true;
        constraintWidgetContainer.f2mX = 0;
        constraintWidgetContainer.f3mY = 0;
        iArr522222[0] = this.mMaxWidth - i31;
        iArr522222[1] = this.mMaxHeight - i30;
        constraintWidgetContainer.mMinWidth = 0;
        constraintWidgetContainer.mMinHeight = 0;
        constraintWidgetContainer.setHorizontalDimensionBehaviour(i27);
        constraintWidgetContainer.setWidth(i7);
        constraintWidgetContainer.setVerticalDimensionBehaviour(i6);
        constraintWidgetContainer.setHeight(i5);
        i8 = this.mMinWidth - i31;
        if (i8 < 0) {
        }
        i9 = this.mMinHeight - i30;
        if (i9 < 0) {
        }
        constraintWidgetContainer.mPaddingLeft = max5;
        constraintWidgetContainer.mPaddingTop = max3;
        matcherMatchResult = constraintWidgetContainer.mBasicMeasureSolver;
        ConstraintWidgetContainer constraintWidgetContainer2222222 = (ConstraintWidgetContainer) matcherMatchResult.groups;
        ArrayList arrayList2222222 = (ArrayList) matcherMatchResult.matcher;
        Measurer measurer5222222 = constraintWidgetContainer.mMeasurer;
        int size6222222 = constraintWidgetContainer.mChildren.size();
        int width2222222 = constraintWidgetContainer.getWidth();
        int height722222 = constraintWidgetContainer.getHeight();
        boolean enabled222222 = Chain.enabled(i, 128);
        if (!enabled222222) {
        }
        if (z) {
        }
        z2 = z;
        i10 = size6222222;
        i11 = 1073741824;
        z3 = z2 & ((mode != i11 && mode2 == i11) || enabled222222);
        if (z3) {
        }
        if (z5) {
        }
        int i38222222 = constraintWidgetContainer.mOptimizationLevel;
        if (i10 > 0) {
        }
        matcherMatchResult.updateHierarchy(constraintWidgetContainer);
        size = arrayList.size();
        if (i10 > 0) {
        }
        if (size > 0) {
        }
        constraintWidgetContainer.mOptimizationLevel = i38222222;
        LinearSystem.USE_DEPENDENCY_ORDERING = constraintWidgetContainer.optimizeFor(LogviewFragment.MAX_LINES);
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
