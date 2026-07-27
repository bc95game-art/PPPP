package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import androidx.appcompat.R$styleable;
import androidx.core.view.ViewCompat;
import kotlin.text.MatcherMatchResult;
/* loaded from: classes.dex */
public abstract class LinearLayoutCompat extends ViewGroup {
    public int mBaselineAlignedChildIndex;
    public Drawable mDivider;
    public int mDividerHeight;
    public int mDividerPadding;
    public int mDividerWidth;
    public int[] mMaxAscent;
    public int[] mMaxDescent;
    public int mOrientation;
    public int mShowDividers;
    public int mTotalLength;
    public boolean mUseLargestChild;
    public float mWeightSum;
    public boolean mBaselineAligned = true;
    public int mBaselineChildTop = 0;
    public int mGravity = 8388659;

    /* loaded from: classes.dex */
    public class LayoutParams extends LinearLayout.LayoutParams {
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mBaselineAlignedChildIndex = -1;
        int[] iArr = R$styleable.LinearLayoutCompat;
        MatcherMatchResult obtainStyledAttributes = MatcherMatchResult.obtainStyledAttributes(context, attributeSet, iArr, i);
        ViewCompat.saveAttributeDataForStyleable(this, context, iArr, attributeSet, (TypedArray) obtainStyledAttributes.input, i);
        TypedArray typedArray = (TypedArray) obtainStyledAttributes.input;
        int i2 = typedArray.getInt(1, -1);
        if (i2 >= 0) {
            setOrientation(i2);
        }
        int i3 = typedArray.getInt(0, -1);
        if (i3 >= 0) {
            setGravity(i3);
        }
        boolean z = typedArray.getBoolean(2, true);
        if (!z) {
            setBaselineAligned(z);
        }
        this.mWeightSum = typedArray.getFloat(4, -1.0f);
        this.mBaselineAlignedChildIndex = typedArray.getInt(3, -1);
        this.mUseLargestChild = typedArray.getBoolean(7, false);
        setDividerDrawable(obtainStyledAttributes.getDrawable(5));
        this.mShowDividers = typedArray.getInt(8, 0);
        this.mDividerPadding = typedArray.getDimensionPixelSize(6, 0);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public final void drawHorizontalDivider(Canvas canvas, int i) {
        this.mDivider.setBounds(getPaddingLeft() + this.mDividerPadding, i, (getWidth() - getPaddingRight()) - this.mDividerPadding, this.mDividerHeight + i);
        this.mDivider.draw(canvas);
    }

    public final void drawVerticalDivider(Canvas canvas, int i) {
        this.mDivider.setBounds(i, getPaddingTop() + this.mDividerPadding, this.mDividerWidth + i, (getHeight() - getPaddingBottom()) - this.mDividerPadding);
        this.mDivider.draw(canvas);
    }

    @Override // android.view.View
    public int getBaseline() {
        int i;
        if (this.mBaselineAlignedChildIndex < 0) {
            return super.getBaseline();
        }
        int childCount = getChildCount();
        int i2 = this.mBaselineAlignedChildIndex;
        if (childCount > i2) {
            View childAt = getChildAt(i2);
            int baseline = childAt.getBaseline();
            if (baseline != -1) {
                int i3 = this.mBaselineChildTop;
                if (this.mOrientation == 1 && (i = this.mGravity & 112) != 48) {
                    if (i == 16) {
                        i3 += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.mTotalLength) / 2;
                    } else if (i == 80) {
                        i3 = ((getBottom() - getTop()) - getPaddingBottom()) - this.mTotalLength;
                    }
                }
                return i3 + ((LinearLayout.LayoutParams) ((LayoutParams) childAt.getLayoutParams())).topMargin + baseline;
            } else if (this.mBaselineAlignedChildIndex == 0) {
                return -1;
            } else {
                throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
            }
        } else {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
    }

    public int getBaselineAlignedChildIndex() {
        return this.mBaselineAlignedChildIndex;
    }

    public Drawable getDividerDrawable() {
        return this.mDivider;
    }

    public int getDividerPadding() {
        return this.mDividerPadding;
    }

    public int getDividerWidth() {
        return this.mDividerWidth;
    }

    public int getGravity() {
        return this.mGravity;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public int getShowDividers() {
        return this.mShowDividers;
    }

    public int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.mWeightSum;
    }

    public final boolean hasDividerBeforeChildAt(int i) {
        if (i == 0) {
            if ((this.mShowDividers & 1) != 0) {
                return true;
            }
            return false;
        } else if (i != getChildCount()) {
            if ((this.mShowDividers & 2) != 0) {
                for (int i2 = i - 1; i2 >= 0; i2--) {
                    if (getChildAt(i2).getVisibility() != 8) {
                        return true;
                    }
                }
            }
            return false;
        } else if ((this.mShowDividers & 4) != 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        boolean z;
        int i;
        int left;
        int i2;
        int i3;
        int i4;
        if (this.mDivider != null) {
            int i5 = 0;
            if (this.mOrientation == 1) {
                int virtualChildCount = getVirtualChildCount();
                while (i5 < virtualChildCount) {
                    View childAt = getChildAt(i5);
                    if (!(childAt == null || childAt.getVisibility() == 8 || !hasDividerBeforeChildAt(i5))) {
                        drawHorizontalDivider(canvas, (childAt.getTop() - ((LinearLayout.LayoutParams) ((LayoutParams) childAt.getLayoutParams())).topMargin) - this.mDividerHeight);
                    }
                    i5++;
                }
                if (hasDividerBeforeChildAt(virtualChildCount)) {
                    View childAt2 = getChildAt(virtualChildCount - 1);
                    if (childAt2 == null) {
                        i4 = (getHeight() - getPaddingBottom()) - this.mDividerHeight;
                    } else {
                        i4 = childAt2.getBottom() + ((LinearLayout.LayoutParams) ((LayoutParams) childAt2.getLayoutParams())).bottomMargin;
                    }
                    drawHorizontalDivider(canvas, i4);
                    return;
                }
                return;
            }
            int virtualChildCount2 = getVirtualChildCount();
            boolean z2 = ViewUtils.sInitComputeFitSystemWindowsMethod;
            if (getLayoutDirection() == 1) {
                z = true;
            } else {
                z = false;
            }
            while (i5 < virtualChildCount2) {
                View childAt3 = getChildAt(i5);
                if (!(childAt3 == null || childAt3.getVisibility() == 8 || !hasDividerBeforeChildAt(i5))) {
                    LayoutParams layoutParams = (LayoutParams) childAt3.getLayoutParams();
                    if (z) {
                        i3 = childAt3.getRight() + ((LinearLayout.LayoutParams) layoutParams).rightMargin;
                    } else {
                        i3 = (childAt3.getLeft() - ((LinearLayout.LayoutParams) layoutParams).leftMargin) - this.mDividerWidth;
                    }
                    drawVerticalDivider(canvas, i3);
                }
                i5++;
            }
            if (hasDividerBeforeChildAt(virtualChildCount2)) {
                View childAt4 = getChildAt(virtualChildCount2 - 1);
                if (childAt4 != null) {
                    LayoutParams layoutParams2 = (LayoutParams) childAt4.getLayoutParams();
                    if (z) {
                        left = childAt4.getLeft() - ((LinearLayout.LayoutParams) layoutParams2).leftMargin;
                        i2 = this.mDividerWidth;
                        i = left - i2;
                        drawVerticalDivider(canvas, i);
                    }
                    i = childAt4.getRight() + ((LinearLayout.LayoutParams) layoutParams2).rightMargin;
                    drawVerticalDivider(canvas, i);
                } else if (z) {
                    i = getPaddingLeft();
                    drawVerticalDivider(canvas, i);
                } else {
                    left = getWidth() - getPaddingRight();
                    i2 = this.mDividerWidth;
                    i = left - i2;
                    drawVerticalDivider(canvas, i);
                }
            }
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01a8  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20 = 8;
        if (this.mOrientation == 1) {
            int paddingLeft = getPaddingLeft();
            int i21 = i3 - i;
            int paddingRight = i21 - getPaddingRight();
            int paddingRight2 = (i21 - paddingLeft) - getPaddingRight();
            int virtualChildCount = getVirtualChildCount();
            int i22 = this.mGravity;
            int i23 = i22 & 112;
            int i24 = 8388615 & i22;
            if (i23 == 16) {
                i16 = getPaddingTop() + (((i4 - i2) - this.mTotalLength) / 2);
            } else if (i23 != 80) {
                i16 = getPaddingTop();
            } else {
                i16 = ((getPaddingTop() + i4) - i2) - this.mTotalLength;
            }
            int i25 = 0;
            while (i25 < virtualChildCount) {
                View childAt = getChildAt(i25);
                if (childAt != null && childAt.getVisibility() != i20) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                    int i26 = ((LinearLayout.LayoutParams) layoutParams).gravity;
                    if (i26 < 0) {
                        i26 = i24;
                    }
                    int absoluteGravity = Gravity.getAbsoluteGravity(i26, getLayoutDirection()) & 7;
                    if (absoluteGravity == 1) {
                        i18 = ((paddingRight2 - measuredWidth) / 2) + paddingLeft + ((LinearLayout.LayoutParams) layoutParams).leftMargin;
                        i19 = ((LinearLayout.LayoutParams) layoutParams).rightMargin;
                    } else if (absoluteGravity != 5) {
                        i17 = ((LinearLayout.LayoutParams) layoutParams).leftMargin + paddingLeft;
                        if (hasDividerBeforeChildAt(i25)) {
                            i16 += this.mDividerHeight;
                        }
                        int i27 = i16 + ((LinearLayout.LayoutParams) layoutParams).topMargin;
                        childAt.layout(i17, i27, measuredWidth + i17, i27 + measuredHeight);
                        i16 = measuredHeight + ((LinearLayout.LayoutParams) layoutParams).bottomMargin + i27;
                    } else {
                        i18 = paddingRight - measuredWidth;
                        i19 = ((LinearLayout.LayoutParams) layoutParams).rightMargin;
                    }
                    i17 = i18 - i19;
                    if (hasDividerBeforeChildAt(i25)) {
                    }
                    int i272 = i16 + ((LinearLayout.LayoutParams) layoutParams).topMargin;
                    childAt.layout(i17, i272, measuredWidth + i17, i272 + measuredHeight);
                    i16 = measuredHeight + ((LinearLayout.LayoutParams) layoutParams).bottomMargin + i272;
                }
                i25++;
                i20 = 8;
            }
            return;
        }
        boolean z3 = ViewUtils.sInitComputeFitSystemWindowsMethod;
        if (getLayoutDirection() == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        int paddingTop = getPaddingTop();
        int i28 = i4 - i2;
        int paddingBottom = i28 - getPaddingBottom();
        int paddingBottom2 = (i28 - paddingTop) - getPaddingBottom();
        int virtualChildCount2 = getVirtualChildCount();
        int i29 = this.mGravity;
        int i30 = 8388615 & i29;
        int i31 = i29 & 112;
        boolean z4 = this.mBaselineAligned;
        int[] iArr = this.mMaxAscent;
        int[] iArr2 = this.mMaxDescent;
        int absoluteGravity2 = Gravity.getAbsoluteGravity(i30, getLayoutDirection());
        if (absoluteGravity2 == 1) {
            i5 = getPaddingLeft() + (((i3 - i) - this.mTotalLength) / 2);
        } else if (absoluteGravity2 != 5) {
            i5 = getPaddingLeft();
        } else {
            i5 = ((getPaddingLeft() + i3) - i) - this.mTotalLength;
        }
        if (z2) {
            i7 = virtualChildCount2 - 1;
            i6 = -1;
        } else {
            i7 = 0;
            i6 = 1;
        }
        int i32 = 0;
        while (i32 < virtualChildCount2) {
            int i33 = (i6 * i32) + i7;
            View childAt2 = getChildAt(i33);
            if (childAt2 == null) {
                i8 = i7;
            } else {
                i8 = i7;
                if (childAt2.getVisibility() != 8) {
                    int measuredWidth2 = childAt2.getMeasuredWidth();
                    int measuredHeight2 = childAt2.getMeasuredHeight();
                    LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
                    int i34 = i5;
                    if (z4) {
                        i9 = paddingTop;
                        if (((LinearLayout.LayoutParams) layoutParams2).height != -1) {
                            i10 = childAt2.getBaseline();
                            i11 = ((LinearLayout.LayoutParams) layoutParams2).gravity;
                            if (i11 < 0) {
                                i11 = i31;
                            }
                            i12 = i11 & 112;
                            if (i12 == 16) {
                                if (i12 == 48) {
                                    i13 = i9 + ((LinearLayout.LayoutParams) layoutParams2).topMargin;
                                    if (i10 != -1) {
                                        i13 = (iArr[1] - i10) + i13;
                                    }
                                } else if (i12 != 80) {
                                    i13 = i9;
                                } else {
                                    i13 = (paddingBottom - measuredHeight2) - ((LinearLayout.LayoutParams) layoutParams2).bottomMargin;
                                    if (i10 != -1) {
                                        i15 = iArr2[2] - (childAt2.getMeasuredHeight() - i10);
                                    }
                                }
                                if (hasDividerBeforeChildAt(i33)) {
                                    i14 = i34 + this.mDividerWidth;
                                } else {
                                    i14 = i34;
                                }
                                int i35 = i14 + ((LinearLayout.LayoutParams) layoutParams2).leftMargin;
                                childAt2.layout(i35, i13, i35 + measuredWidth2, i13 + measuredHeight2);
                                i5 = measuredWidth2 + ((LinearLayout.LayoutParams) layoutParams2).rightMargin + i35;
                                i32++;
                                i7 = i8;
                                paddingTop = i9;
                            } else {
                                i13 = ((paddingBottom2 - measuredHeight2) / 2) + i9 + ((LinearLayout.LayoutParams) layoutParams2).topMargin;
                                i15 = ((LinearLayout.LayoutParams) layoutParams2).bottomMargin;
                            }
                            i13 -= i15;
                            if (hasDividerBeforeChildAt(i33)) {
                            }
                            int i352 = i14 + ((LinearLayout.LayoutParams) layoutParams2).leftMargin;
                            childAt2.layout(i352, i13, i352 + measuredWidth2, i13 + measuredHeight2);
                            i5 = measuredWidth2 + ((LinearLayout.LayoutParams) layoutParams2).rightMargin + i352;
                            i32++;
                            i7 = i8;
                            paddingTop = i9;
                        }
                    } else {
                        i9 = paddingTop;
                    }
                    i10 = -1;
                    i11 = ((LinearLayout.LayoutParams) layoutParams2).gravity;
                    if (i11 < 0) {
                    }
                    i12 = i11 & 112;
                    if (i12 == 16) {
                    }
                    i13 -= i15;
                    if (hasDividerBeforeChildAt(i33)) {
                    }
                    int i3522 = i14 + ((LinearLayout.LayoutParams) layoutParams2).leftMargin;
                    childAt2.layout(i3522, i13, i3522 + measuredWidth2, i13 + measuredHeight2);
                    i5 = measuredWidth2 + ((LinearLayout.LayoutParams) layoutParams2).rightMargin + i3522;
                    i32++;
                    i7 = i8;
                    paddingTop = i9;
                }
            }
            i9 = paddingTop;
            i32++;
            i7 = i8;
            paddingTop = i9;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:222:0x04f4  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x0522  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x0538  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x0542  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0145  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onMeasure(int i, int i2) {
        boolean z;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        boolean z2;
        int i8;
        boolean z3;
        int baseline;
        int i9;
        boolean z4;
        boolean z5;
        int i10;
        int[] iArr;
        int[] iArr2;
        int i11;
        View view;
        LayoutParams layoutParams;
        int i12;
        int i13;
        int i14;
        int i15;
        boolean z6;
        boolean z7;
        boolean z8;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        boolean z9;
        int i21;
        int i22;
        boolean z10;
        int i23;
        int i24;
        int i25;
        View view2;
        boolean z11;
        boolean z12;
        int i26;
        int i27;
        int i28;
        LinearLayoutCompat linearLayoutCompat = this;
        int i29 = -2;
        int i30 = 0;
        int i31 = 1073741824;
        int i32 = 8;
        if (linearLayoutCompat.mOrientation == 1) {
            linearLayoutCompat.mTotalLength = 0;
            int virtualChildCount = linearLayoutCompat.getVirtualChildCount();
            int mode = View.MeasureSpec.getMode(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            int i33 = linearLayoutCompat.mBaselineAlignedChildIndex;
            boolean z13 = linearLayoutCompat.mUseLargestChild;
            int i34 = 0;
            int i35 = 0;
            int i36 = 0;
            int i37 = 0;
            float f = 0.0f;
            boolean z14 = false;
            int i38 = 0;
            boolean z15 = false;
            boolean z16 = true;
            while (i34 < virtualChildCount) {
                int i39 = mode;
                View childAt = linearLayoutCompat.getChildAt(i34);
                if (childAt == null) {
                    linearLayoutCompat.mTotalLength = linearLayoutCompat.mTotalLength;
                } else if (childAt.getVisibility() != i32) {
                    if (linearLayoutCompat.hasDividerBeforeChildAt(i34)) {
                        linearLayoutCompat.mTotalLength += linearLayoutCompat.mDividerHeight;
                    }
                    LayoutParams layoutParams2 = (LayoutParams) childAt.getLayoutParams();
                    float f2 = ((LinearLayout.LayoutParams) layoutParams2).weight;
                    f += f2;
                    if (mode2 == i31 && ((LinearLayout.LayoutParams) layoutParams2).height == 0 && f2 > 0.0f) {
                        int i40 = linearLayoutCompat.mTotalLength;
                        linearLayoutCompat.mTotalLength = Math.max(i40, ((LinearLayout.LayoutParams) layoutParams2).topMargin + i40 + ((LinearLayout.LayoutParams) layoutParams2).bottomMargin);
                        view2 = childAt;
                        i22 = mode2;
                        i25 = i33;
                        z10 = z13;
                        i23 = i34;
                        i24 = i39;
                        z14 = true;
                    } else {
                        if (((LinearLayout.LayoutParams) layoutParams2).height != 0 || f2 <= 0.0f) {
                            i26 = Integer.MIN_VALUE;
                        } else {
                            ((LinearLayout.LayoutParams) layoutParams2).height = i29;
                            i26 = 0;
                        }
                        if (f == 0.0f) {
                            i27 = i34;
                            i28 = linearLayoutCompat.mTotalLength;
                        } else {
                            i27 = i34;
                            i28 = 0;
                        }
                        i22 = mode2;
                        z10 = z13;
                        i25 = i33;
                        i23 = i27;
                        i24 = i39;
                        linearLayoutCompat.measureChildWithMargins(childAt, i, 0, i2, i28);
                        if (i26 != Integer.MIN_VALUE) {
                            ((LinearLayout.LayoutParams) layoutParams2).height = i26;
                        }
                        int measuredHeight = childAt.getMeasuredHeight();
                        int i41 = linearLayoutCompat.mTotalLength;
                        view2 = childAt;
                        linearLayoutCompat.mTotalLength = Math.max(i41, i41 + measuredHeight + ((LinearLayout.LayoutParams) layoutParams2).topMargin + ((LinearLayout.LayoutParams) layoutParams2).bottomMargin);
                        if (z10) {
                            i37 = Math.max(measuredHeight, i37);
                        }
                    }
                    if (i25 >= 0 && i25 == i23 + 1) {
                        linearLayoutCompat.mBaselineChildTop = linearLayoutCompat.mTotalLength;
                    }
                    if (i23 >= i25 || ((LinearLayout.LayoutParams) layoutParams2).weight <= 0.0f) {
                        if (i24 == 1073741824 || ((LinearLayout.LayoutParams) layoutParams2).width != -1) {
                            z11 = false;
                        } else {
                            z11 = true;
                            z15 = true;
                        }
                        int i42 = ((LinearLayout.LayoutParams) layoutParams2).leftMargin + ((LinearLayout.LayoutParams) layoutParams2).rightMargin;
                        int measuredWidth = view2.getMeasuredWidth() + i42;
                        i30 = Math.max(i30, measuredWidth);
                        int measuredState = view2.getMeasuredState();
                        boolean z17 = z11;
                        int combineMeasuredStates = View.combineMeasuredStates(i38, measuredState);
                        if (z16) {
                            i38 = combineMeasuredStates;
                            if (((LinearLayout.LayoutParams) layoutParams2).width == -1) {
                                z12 = true;
                                if (((LinearLayout.LayoutParams) layoutParams2).weight <= 0.0f) {
                                    if (!z17) {
                                        i42 = measuredWidth;
                                    }
                                    i36 = Math.max(i36, i42);
                                } else {
                                    if (!z17) {
                                        i42 = measuredWidth;
                                    }
                                    i35 = Math.max(i35, i42);
                                }
                                z16 = z12;
                                i34 = i23 + 1;
                                i33 = i25;
                                mode = i24;
                                z13 = z10;
                                mode2 = i22;
                                i29 = -2;
                                i31 = 1073741824;
                                i32 = 8;
                            }
                        } else {
                            i38 = combineMeasuredStates;
                        }
                        z12 = false;
                        if (((LinearLayout.LayoutParams) layoutParams2).weight <= 0.0f) {
                        }
                        z16 = z12;
                        i34 = i23 + 1;
                        i33 = i25;
                        mode = i24;
                        z13 = z10;
                        mode2 = i22;
                        i29 = -2;
                        i31 = 1073741824;
                        i32 = 8;
                    } else {
                        throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
                    }
                }
                i22 = mode2;
                i25 = i33;
                z10 = z13;
                i23 = i34;
                i24 = i39;
                i34 = i23 + 1;
                i33 = i25;
                mode = i24;
                z13 = z10;
                mode2 = i22;
                i29 = -2;
                i31 = 1073741824;
                i32 = 8;
            }
            int i43 = mode;
            int i44 = mode2;
            boolean z18 = z13;
            int i45 = i38;
            int i46 = i2;
            if (linearLayoutCompat.mTotalLength > 0 && linearLayoutCompat.hasDividerBeforeChildAt(virtualChildCount)) {
                linearLayoutCompat.mTotalLength += linearLayoutCompat.mDividerHeight;
            }
            if (z18 && (i44 == Integer.MIN_VALUE || i44 == 0)) {
                linearLayoutCompat.mTotalLength = 0;
                for (int i47 = 0; i47 < virtualChildCount; i47++) {
                    View childAt2 = linearLayoutCompat.getChildAt(i47);
                    if (childAt2 == null) {
                        linearLayoutCompat.mTotalLength = linearLayoutCompat.mTotalLength;
                    } else if (childAt2.getVisibility() != 8) {
                        LayoutParams layoutParams3 = (LayoutParams) childAt2.getLayoutParams();
                        int i48 = linearLayoutCompat.mTotalLength;
                        linearLayoutCompat.mTotalLength = Math.max(i48, i48 + i37 + ((LinearLayout.LayoutParams) layoutParams3).topMargin + ((LinearLayout.LayoutParams) layoutParams3).bottomMargin);
                    }
                }
            }
            int paddingBottom = linearLayoutCompat.getPaddingBottom() + linearLayoutCompat.getPaddingTop() + linearLayoutCompat.mTotalLength;
            linearLayoutCompat.mTotalLength = paddingBottom;
            int resolveSizeAndState = View.resolveSizeAndState(Math.max(paddingBottom, linearLayoutCompat.getSuggestedMinimumHeight()), i46, 0);
            int i49 = (resolveSizeAndState & 16777215) - linearLayoutCompat.mTotalLength;
            if (z14 || (i49 != 0 && f > 0.0f)) {
                float f3 = linearLayoutCompat.mWeightSum;
                if (f3 > 0.0f) {
                    f = f3;
                }
                linearLayoutCompat.mTotalLength = 0;
                int i50 = i45;
                int i51 = 0;
                while (i51 < virtualChildCount) {
                    View childAt3 = linearLayoutCompat.getChildAt(i51);
                    if (childAt3.getVisibility() == 8) {
                        i19 = i51;
                    } else {
                        LayoutParams layoutParams4 = (LayoutParams) childAt3.getLayoutParams();
                        float f4 = ((LinearLayout.LayoutParams) layoutParams4).weight;
                        if (f4 > 0.0f) {
                            int i52 = (int) ((i49 * f4) / f);
                            f -= f4;
                            i49 -= i52;
                            i19 = i51;
                            int childMeasureSpec = ViewGroup.getChildMeasureSpec(i, linearLayoutCompat.getPaddingRight() + linearLayoutCompat.getPaddingLeft() + ((LinearLayout.LayoutParams) layoutParams4).leftMargin + ((LinearLayout.LayoutParams) layoutParams4).rightMargin, ((LinearLayout.LayoutParams) layoutParams4).width);
                            if (((LinearLayout.LayoutParams) layoutParams4).height == 0) {
                                i21 = 1073741824;
                                if (i44 == 1073741824) {
                                    if (i52 <= 0) {
                                        i52 = 0;
                                    }
                                    childAt3.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(i52, 1073741824));
                                    i50 = View.combineMeasuredStates(i50, childAt3.getMeasuredState() & (-256));
                                }
                            } else {
                                i21 = 1073741824;
                            }
                            int measuredHeight2 = childAt3.getMeasuredHeight() + i52;
                            if (measuredHeight2 < 0) {
                                measuredHeight2 = 0;
                            }
                            childAt3.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(measuredHeight2, i21));
                            i50 = View.combineMeasuredStates(i50, childAt3.getMeasuredState() & (-256));
                        } else {
                            i19 = i51;
                        }
                        int i53 = ((LinearLayout.LayoutParams) layoutParams4).leftMargin + ((LinearLayout.LayoutParams) layoutParams4).rightMargin;
                        int measuredWidth2 = childAt3.getMeasuredWidth() + i53;
                        i30 = Math.max(i30, measuredWidth2);
                        if (i43 != 1073741824) {
                            i20 = -1;
                            if (((LinearLayout.LayoutParams) layoutParams4).width == -1) {
                                measuredWidth2 = i53;
                            }
                        } else {
                            i20 = -1;
                        }
                        i35 = Math.max(i35, measuredWidth2);
                        if (!z16 || ((LinearLayout.LayoutParams) layoutParams4).width != i20) {
                            z9 = false;
                        } else {
                            z9 = true;
                        }
                        int i54 = linearLayoutCompat.mTotalLength;
                        linearLayoutCompat.mTotalLength = Math.max(i54, childAt3.getMeasuredHeight() + i54 + ((LinearLayout.LayoutParams) layoutParams4).topMargin + ((LinearLayout.LayoutParams) layoutParams4).bottomMargin);
                        z16 = z9;
                    }
                    i51 = i19 + 1;
                }
                linearLayoutCompat.mTotalLength = linearLayoutCompat.getPaddingBottom() + linearLayoutCompat.getPaddingTop() + linearLayoutCompat.mTotalLength;
                i45 = i50;
            } else {
                i35 = Math.max(i35, i36);
                if (z18 && i44 != 1073741824) {
                    for (int i55 = 0; i55 < virtualChildCount; i55++) {
                        View childAt4 = linearLayoutCompat.getChildAt(i55);
                        if (!(childAt4 == null || childAt4.getVisibility() == 8 || ((LinearLayout.LayoutParams) ((LayoutParams) childAt4.getLayoutParams())).weight <= 0.0f)) {
                            childAt4.measure(View.MeasureSpec.makeMeasureSpec(childAt4.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(i37, 1073741824));
                        }
                    }
                }
            }
            if (z16 || i43 == 1073741824) {
                i35 = i30;
            }
            linearLayoutCompat.setMeasuredDimension(View.resolveSizeAndState(Math.max(linearLayoutCompat.getPaddingRight() + linearLayoutCompat.getPaddingLeft() + i35, linearLayoutCompat.getSuggestedMinimumWidth()), i, i45), resolveSizeAndState);
            if (z15) {
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(linearLayoutCompat.getMeasuredWidth(), 1073741824);
                int i56 = 0;
                while (i56 < virtualChildCount) {
                    View childAt5 = linearLayoutCompat.getChildAt(i56);
                    if (childAt5.getVisibility() != 8) {
                        LayoutParams layoutParams5 = (LayoutParams) childAt5.getLayoutParams();
                        if (((LinearLayout.LayoutParams) layoutParams5).width == -1) {
                            int i57 = ((LinearLayout.LayoutParams) layoutParams5).height;
                            ((LinearLayout.LayoutParams) layoutParams5).height = childAt5.getMeasuredHeight();
                            linearLayoutCompat.measureChildWithMargins(childAt5, makeMeasureSpec, 0, i46, 0);
                            ((LinearLayout.LayoutParams) layoutParams5).height = i57;
                        }
                    }
                    i56++;
                    i46 = i2;
                }
                return;
            }
            return;
        }
        int i58 = i;
        linearLayoutCompat.mTotalLength = 0;
        int virtualChildCount2 = linearLayoutCompat.getVirtualChildCount();
        int mode3 = View.MeasureSpec.getMode(i58);
        int mode4 = View.MeasureSpec.getMode(i2);
        if (linearLayoutCompat.mMaxAscent == null || linearLayoutCompat.mMaxDescent == null) {
            linearLayoutCompat.mMaxAscent = new int[4];
            linearLayoutCompat.mMaxDescent = new int[4];
        }
        int[] iArr3 = linearLayoutCompat.mMaxAscent;
        int[] iArr4 = linearLayoutCompat.mMaxDescent;
        iArr3[3] = -1;
        iArr3[2] = -1;
        iArr3[1] = -1;
        iArr3[0] = -1;
        iArr4[3] = -1;
        iArr4[2] = -1;
        iArr4[1] = -1;
        iArr4[0] = -1;
        boolean z19 = linearLayoutCompat.mBaselineAligned;
        boolean z20 = linearLayoutCompat.mUseLargestChild;
        if (mode3 == 1073741824) {
            z = true;
        } else {
            z = false;
        }
        int i59 = 0;
        int i60 = 0;
        int i61 = 0;
        int i62 = 0;
        int i63 = 0;
        int i64 = 0;
        boolean z21 = false;
        boolean z22 = false;
        float f5 = 0.0f;
        boolean z23 = true;
        while (i59 < virtualChildCount2) {
            View childAt6 = linearLayoutCompat.getChildAt(i59);
            if (childAt6 == null) {
                linearLayoutCompat.mTotalLength = linearLayoutCompat.mTotalLength;
                i10 = i59;
                i11 = i61;
                iArr2 = iArr3;
                iArr = iArr4;
                z5 = z19;
                z4 = z20;
            } else {
                int i65 = i60;
                if (childAt6.getVisibility() == 8) {
                    i58 = i;
                    i10 = i59;
                    i11 = i61;
                    iArr = iArr4;
                    z5 = z19;
                    z4 = z20;
                    i60 = i65;
                    iArr2 = iArr3;
                } else {
                    if (linearLayoutCompat.hasDividerBeforeChildAt(i59)) {
                        linearLayoutCompat.mTotalLength += linearLayoutCompat.mDividerWidth;
                    }
                    LayoutParams layoutParams6 = (LayoutParams) childAt6.getLayoutParams();
                    float f6 = ((LinearLayout.LayoutParams) layoutParams6).weight;
                    f5 += f6;
                    int i66 = i59;
                    if (mode3 == 1073741824 && ((LinearLayout.LayoutParams) layoutParams6).width == 0 && f6 > 0.0f) {
                        if (z) {
                            linearLayoutCompat.mTotalLength = ((LinearLayout.LayoutParams) layoutParams6).leftMargin + ((LinearLayout.LayoutParams) layoutParams6).rightMargin + linearLayoutCompat.mTotalLength;
                        } else {
                            int i67 = linearLayoutCompat.mTotalLength;
                            linearLayoutCompat.mTotalLength = Math.max(i67, ((LinearLayout.LayoutParams) layoutParams6).leftMargin + i67 + ((LinearLayout.LayoutParams) layoutParams6).rightMargin);
                        }
                        if (z19) {
                            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
                            childAt6.measure(makeMeasureSpec2, makeMeasureSpec2);
                            view = childAt6;
                            z5 = z19;
                            z4 = z20;
                            i12 = i65;
                            i10 = i66;
                            layoutParams = layoutParams6;
                            iArr2 = iArr3;
                            iArr = iArr4;
                            i58 = i;
                            i14 = i61;
                            i13 = i62;
                        } else {
                            view = childAt6;
                            z5 = z19;
                            z4 = z20;
                            i12 = i65;
                            i10 = i66;
                            i15 = 1073741824;
                            z22 = true;
                            layoutParams = layoutParams6;
                            iArr2 = iArr3;
                            iArr = iArr4;
                            i58 = i;
                            i14 = i61;
                            i13 = i62;
                            if (mode4 == i15 && ((LinearLayout.LayoutParams) layoutParams).height == -1) {
                                z6 = true;
                                z21 = true;
                            } else {
                                z6 = false;
                            }
                            int i68 = ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                            int measuredHeight3 = view.getMeasuredHeight() + i68;
                            i64 = View.combineMeasuredStates(i64, view.getMeasuredState());
                            if (!z5) {
                                int baseline2 = view.getBaseline();
                                z7 = z6;
                                if (baseline2 != -1) {
                                    int i69 = ((LinearLayout.LayoutParams) layoutParams).gravity;
                                    if (i69 < 0) {
                                        i69 = linearLayoutCompat.mGravity;
                                    }
                                    int i70 = (((i69 & 112) >> 4) & (-2)) >> 1;
                                    iArr2[i70] = Math.max(iArr2[i70], baseline2);
                                    iArr[i70] = Math.max(iArr[i70], measuredHeight3 - baseline2);
                                }
                            } else {
                                z7 = z6;
                            }
                            int max = Math.max(i12, measuredHeight3);
                            if (z23 || ((LinearLayout.LayoutParams) layoutParams).height != -1) {
                                z8 = false;
                            } else {
                                z8 = true;
                            }
                            if (((LinearLayout.LayoutParams) layoutParams).weight <= 0.0f) {
                                if (!z7) {
                                    i68 = measuredHeight3;
                                }
                                i62 = Math.max(i13, i68);
                                i16 = i14;
                            } else {
                                if (!z7) {
                                    i68 = measuredHeight3;
                                }
                                i16 = Math.max(i14, i68);
                                i62 = i13;
                            }
                            int i71 = i16;
                            i60 = max;
                            i11 = i71;
                            z23 = z8;
                        }
                    } else {
                        if (((LinearLayout.LayoutParams) layoutParams6).width != 0 || f6 <= 0.0f) {
                            i17 = Integer.MIN_VALUE;
                        } else {
                            ((LinearLayout.LayoutParams) layoutParams6).width = -2;
                            i17 = 0;
                        }
                        if (f5 == 0.0f) {
                            i18 = linearLayoutCompat.mTotalLength;
                        } else {
                            i18 = 0;
                        }
                        iArr = iArr4;
                        i13 = i62;
                        i10 = i66;
                        z5 = z19;
                        z4 = z20;
                        int i72 = i17;
                        layoutParams = layoutParams6;
                        i12 = i65;
                        i58 = i;
                        iArr2 = iArr3;
                        i14 = i61;
                        linearLayoutCompat.measureChildWithMargins(childAt6, i58, i18, i2, 0);
                        if (i72 != Integer.MIN_VALUE) {
                            ((LinearLayout.LayoutParams) layoutParams).width = i72;
                        }
                        int measuredWidth3 = childAt6.getMeasuredWidth();
                        if (z) {
                            view = childAt6;
                            linearLayoutCompat.mTotalLength = ((LinearLayout.LayoutParams) layoutParams).leftMargin + measuredWidth3 + ((LinearLayout.LayoutParams) layoutParams).rightMargin + linearLayoutCompat.mTotalLength;
                        } else {
                            view = childAt6;
                            int i73 = linearLayoutCompat.mTotalLength;
                            linearLayoutCompat.mTotalLength = Math.max(i73, i73 + measuredWidth3 + ((LinearLayout.LayoutParams) layoutParams).leftMargin + ((LinearLayout.LayoutParams) layoutParams).rightMargin);
                        }
                        if (z4) {
                            i63 = Math.max(measuredWidth3, i63);
                        }
                    }
                    i15 = 1073741824;
                    if (mode4 == i15) {
                    }
                    z6 = false;
                    int i682 = ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                    int measuredHeight32 = view.getMeasuredHeight() + i682;
                    i64 = View.combineMeasuredStates(i64, view.getMeasuredState());
                    if (!z5) {
                    }
                    int max2 = Math.max(i12, measuredHeight32);
                    if (z23) {
                    }
                    z8 = false;
                    if (((LinearLayout.LayoutParams) layoutParams).weight <= 0.0f) {
                    }
                    int i712 = i16;
                    i60 = max2;
                    i11 = i712;
                    z23 = z8;
                }
            }
            i61 = i11;
            i59 = i10 + 1;
            iArr3 = iArr2;
            iArr4 = iArr;
            z19 = z5;
            z20 = z4;
        }
        int i74 = i60;
        int[] iArr5 = iArr3;
        int[] iArr6 = iArr4;
        boolean z24 = z19;
        boolean z25 = z20;
        int i75 = i61;
        int i76 = i62;
        if (linearLayoutCompat.mTotalLength > 0 && linearLayoutCompat.hasDividerBeforeChildAt(virtualChildCount2)) {
            linearLayoutCompat.mTotalLength += linearLayoutCompat.mDividerWidth;
        }
        int i77 = iArr5[1];
        if (i77 == -1 && iArr5[0] == -1 && iArr5[2] == -1 && iArr5[3] == -1) {
            i3 = i74;
        } else {
            i3 = Math.max(i74, Math.max(iArr6[3], Math.max(iArr6[0], Math.max(iArr6[1], iArr6[2]))) + Math.max(iArr5[3], Math.max(iArr5[0], Math.max(i77, iArr5[2]))));
        }
        if (z25 && (mode3 == Integer.MIN_VALUE || mode3 == 0)) {
            linearLayoutCompat.mTotalLength = 0;
            for (int i78 = 0; i78 < virtualChildCount2; i78++) {
                View childAt7 = linearLayoutCompat.getChildAt(i78);
                if (childAt7 == null) {
                    linearLayoutCompat.mTotalLength = linearLayoutCompat.mTotalLength;
                } else if (childAt7.getVisibility() != 8) {
                    LayoutParams layoutParams7 = (LayoutParams) childAt7.getLayoutParams();
                    if (z) {
                        linearLayoutCompat.mTotalLength = ((LinearLayout.LayoutParams) layoutParams7).leftMargin + i63 + ((LinearLayout.LayoutParams) layoutParams7).rightMargin + linearLayoutCompat.mTotalLength;
                    } else {
                        int i79 = linearLayoutCompat.mTotalLength;
                        linearLayoutCompat.mTotalLength = Math.max(i79, i79 + i63 + ((LinearLayout.LayoutParams) layoutParams7).leftMargin + ((LinearLayout.LayoutParams) layoutParams7).rightMargin);
                    }
                }
            }
        }
        int paddingRight = linearLayoutCompat.getPaddingRight() + linearLayoutCompat.getPaddingLeft() + linearLayoutCompat.mTotalLength;
        linearLayoutCompat.mTotalLength = paddingRight;
        int resolveSizeAndState2 = View.resolveSizeAndState(Math.max(paddingRight, linearLayoutCompat.getSuggestedMinimumWidth()), i58, 0);
        int i80 = (resolveSizeAndState2 & 16777215) - linearLayoutCompat.mTotalLength;
        if (z22 || (i80 != 0 && f5 > 0.0f)) {
            float f7 = linearLayoutCompat.mWeightSum;
            if (f7 > 0.0f) {
                f5 = f7;
            }
            iArr5[3] = -1;
            iArr5[2] = -1;
            iArr5[1] = -1;
            iArr5[0] = -1;
            iArr6[3] = -1;
            iArr6[2] = -1;
            iArr6[1] = -1;
            iArr6[0] = -1;
            linearLayoutCompat.mTotalLength = 0;
            i3 = -1;
            int i81 = 0;
            while (i81 < virtualChildCount2) {
                View childAt8 = linearLayoutCompat.getChildAt(i81);
                if (childAt8 == null || childAt8.getVisibility() == 8) {
                    i7 = resolveSizeAndState2;
                } else {
                    LayoutParams layoutParams8 = (LayoutParams) childAt8.getLayoutParams();
                    float f8 = ((LinearLayout.LayoutParams) layoutParams8).weight;
                    if (f8 > 0.0f) {
                        int i82 = (int) ((i80 * f8) / f5);
                        f5 -= f8;
                        i80 -= i82;
                        i7 = resolveSizeAndState2;
                        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i2, linearLayoutCompat.getPaddingBottom() + linearLayoutCompat.getPaddingTop() + ((LinearLayout.LayoutParams) layoutParams8).topMargin + ((LinearLayout.LayoutParams) layoutParams8).bottomMargin, ((LinearLayout.LayoutParams) layoutParams8).height);
                        if (((LinearLayout.LayoutParams) layoutParams8).width == 0) {
                            i9 = 1073741824;
                            if (mode3 == 1073741824) {
                                if (i82 <= 0) {
                                    i82 = 0;
                                }
                                childAt8.measure(View.MeasureSpec.makeMeasureSpec(i82, 1073741824), childMeasureSpec2);
                                i64 = View.combineMeasuredStates(i64, childAt8.getMeasuredState() & (-16777216));
                            }
                        } else {
                            i9 = 1073741824;
                        }
                        int measuredWidth4 = childAt8.getMeasuredWidth() + i82;
                        if (measuredWidth4 < 0) {
                            measuredWidth4 = 0;
                        }
                        childAt8.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth4, i9), childMeasureSpec2);
                        i64 = View.combineMeasuredStates(i64, childAt8.getMeasuredState() & (-16777216));
                    } else {
                        i7 = resolveSizeAndState2;
                    }
                    if (z) {
                        linearLayoutCompat.mTotalLength = childAt8.getMeasuredWidth() + ((LinearLayout.LayoutParams) layoutParams8).leftMargin + ((LinearLayout.LayoutParams) layoutParams8).rightMargin + linearLayoutCompat.mTotalLength;
                    } else {
                        int i83 = linearLayoutCompat.mTotalLength;
                        linearLayoutCompat.mTotalLength = Math.max(i83, childAt8.getMeasuredWidth() + i83 + ((LinearLayout.LayoutParams) layoutParams8).leftMargin + ((LinearLayout.LayoutParams) layoutParams8).rightMargin);
                    }
                    if (mode4 == 1073741824 || ((LinearLayout.LayoutParams) layoutParams8).height != -1) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    int i84 = ((LinearLayout.LayoutParams) layoutParams8).topMargin + ((LinearLayout.LayoutParams) layoutParams8).bottomMargin;
                    int measuredHeight4 = childAt8.getMeasuredHeight() + i84;
                    i3 = Math.max(i3, measuredHeight4);
                    if (!z2) {
                        i84 = measuredHeight4;
                    }
                    int max3 = Math.max(i75, i84);
                    if (z23) {
                        i8 = -1;
                        if (((LinearLayout.LayoutParams) layoutParams8).height == -1) {
                            z3 = true;
                            if (!z24 && (baseline = childAt8.getBaseline()) != i8) {
                                int i85 = ((LinearLayout.LayoutParams) layoutParams8).gravity;
                                if (i85 < 0) {
                                    i85 = linearLayoutCompat.mGravity;
                                }
                                int i86 = (((i85 & 112) >> 4) & (-2)) >> 1;
                                iArr5[i86] = Math.max(iArr5[i86], baseline);
                                iArr6[i86] = Math.max(iArr6[i86], measuredHeight4 - baseline);
                            }
                            z23 = z3;
                            i75 = max3;
                        }
                    } else {
                        i8 = -1;
                    }
                    z3 = false;
                    if (!z24) {
                    }
                    z23 = z3;
                    i75 = max3;
                }
                i81++;
                resolveSizeAndState2 = i7;
            }
            i4 = resolveSizeAndState2;
            i5 = -16777216;
            linearLayoutCompat.mTotalLength = linearLayoutCompat.getPaddingRight() + linearLayoutCompat.getPaddingLeft() + linearLayoutCompat.mTotalLength;
            int i87 = iArr5[1];
            if (i87 != -1 || iArr5[0] != -1 || iArr5[2] != -1 || iArr5[3] != -1) {
                i3 = Math.max(i3, Math.max(iArr6[3], Math.max(iArr6[0], Math.max(iArr6[1], iArr6[2]))) + Math.max(iArr5[3], Math.max(iArr5[0], Math.max(i87, iArr5[2]))));
            }
            i6 = i75;
        } else {
            i6 = Math.max(i75, i76);
            if (z25 && mode3 != 1073741824) {
                for (int i88 = 0; i88 < virtualChildCount2; i88++) {
                    View childAt9 = linearLayoutCompat.getChildAt(i88);
                    if (!(childAt9 == null || childAt9.getVisibility() == 8 || ((LinearLayout.LayoutParams) ((LayoutParams) childAt9.getLayoutParams())).weight <= 0.0f)) {
                        childAt9.measure(View.MeasureSpec.makeMeasureSpec(i63, 1073741824), View.MeasureSpec.makeMeasureSpec(childAt9.getMeasuredHeight(), 1073741824));
                    }
                }
            }
            i4 = resolveSizeAndState2;
            i5 = -16777216;
        }
        if (!z23 && mode4 != 1073741824) {
            i3 = i6;
        }
        linearLayoutCompat.setMeasuredDimension(i4 | (i64 & i5), View.resolveSizeAndState(Math.max(linearLayoutCompat.getPaddingBottom() + linearLayoutCompat.getPaddingTop() + i3, linearLayoutCompat.getSuggestedMinimumHeight()), i2, i64 << 16));
        if (z21) {
            int makeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(linearLayoutCompat.getMeasuredHeight(), 1073741824);
            int i89 = 0;
            while (i89 < virtualChildCount2) {
                View childAt10 = linearLayoutCompat.getChildAt(i89);
                if (childAt10.getVisibility() != 8) {
                    LayoutParams layoutParams9 = (LayoutParams) childAt10.getLayoutParams();
                    if (((LinearLayout.LayoutParams) layoutParams9).height == -1) {
                        int i90 = ((LinearLayout.LayoutParams) layoutParams9).width;
                        ((LinearLayout.LayoutParams) layoutParams9).width = childAt10.getMeasuredWidth();
                        linearLayoutCompat.measureChildWithMargins(childAt10, i58, 0, makeMeasureSpec3, 0);
                        ((LinearLayout.LayoutParams) layoutParams9).width = i90;
                    }
                }
                i89++;
                linearLayoutCompat = this;
                i58 = i;
            }
        }
    }

    public void setBaselineAligned(boolean z) {
        this.mBaselineAligned = z;
    }

    public void setBaselineAlignedChildIndex(int i) {
        if (i < 0 || i >= getChildCount()) {
            throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
        }
        this.mBaselineAlignedChildIndex = i;
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable != this.mDivider) {
            this.mDivider = drawable;
            boolean z = false;
            if (drawable != null) {
                this.mDividerWidth = drawable.getIntrinsicWidth();
                this.mDividerHeight = drawable.getIntrinsicHeight();
            } else {
                this.mDividerWidth = 0;
                this.mDividerHeight = 0;
            }
            if (drawable == null) {
                z = true;
            }
            setWillNotDraw(z);
            requestLayout();
        }
    }

    public void setDividerPadding(int i) {
        this.mDividerPadding = i;
    }

    public void setGravity(int i) {
        if (this.mGravity != i) {
            if ((8388615 & i) == 0) {
                i |= 8388611;
            }
            if ((i & 112) == 0) {
                i |= 48;
            }
            this.mGravity = i;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i) {
        int i2 = i & 8388615;
        int i3 = this.mGravity;
        if ((8388615 & i3) != i2) {
            this.mGravity = i2 | ((-8388616) & i3);
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z) {
        this.mUseLargestChild = z;
    }

    public void setOrientation(int i) {
        if (this.mOrientation != i) {
            this.mOrientation = i;
            requestLayout();
        }
    }

    public void setShowDividers(int i) {
        if (i != this.mShowDividers) {
            requestLayout();
        }
        this.mShowDividers = i;
    }

    public void setVerticalGravity(int i) {
        int i2 = i & 112;
        int i3 = this.mGravity;
        if ((i3 & 112) != i2) {
            this.mGravity = i2 | (i3 & (-113));
            requestLayout();
        }
    }

    public void setWeightSum(float f) {
        this.mWeightSum = Math.max(0.0f, f);
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [androidx.appcompat.widget.LinearLayoutCompat$LayoutParams, android.widget.LinearLayout$LayoutParams] */
    /* JADX WARN: Type inference failed for: r0v3, types: [androidx.appcompat.widget.LinearLayoutCompat$LayoutParams, android.widget.LinearLayout$LayoutParams] */
    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        int i = this.mOrientation;
        if (i == 0) {
            return new LinearLayout.LayoutParams(-2, -2);
        }
        if (i == 1) {
            return new LinearLayout.LayoutParams(-1, -2);
        }
        return null;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.appcompat.widget.LinearLayoutCompat$LayoutParams, android.widget.LinearLayout$LayoutParams] */
    @Override // android.view.ViewGroup
    /* renamed from: generateLayoutParams */
    public LayoutParams mo634generateLayoutParams(AttributeSet attributeSet) {
        return new LinearLayout.LayoutParams(getContext(), attributeSet);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [androidx.appcompat.widget.LinearLayoutCompat$LayoutParams, android.widget.LinearLayout$LayoutParams] */
    /* JADX WARN: Type inference failed for: r0v3, types: [androidx.appcompat.widget.LinearLayoutCompat$LayoutParams, android.widget.LinearLayout$LayoutParams] */
    /* JADX WARN: Type inference failed for: r0v4, types: [androidx.appcompat.widget.LinearLayoutCompat$LayoutParams, android.widget.LinearLayout$LayoutParams] */
    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LinearLayout.LayoutParams((ViewGroup.MarginLayoutParams) ((LayoutParams) layoutParams));
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LinearLayout.LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LinearLayout.LayoutParams(layoutParams);
    }
}
