package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.SolverVariable;
/* loaded from: classes.dex */
public abstract class Chain {
    public static final boolean[] sFlags = new boolean[3];

    /* JADX WARN: Code restructure failed: missing block: B:182:0x028e, code lost:
        if (r7.mOwner == r6) goto L184;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0110, code lost:
        if (r4.mOwner == r12) goto L73;
     */
    /* JADX WARN: Removed duplicated region for block: B:331:0x056c  */
    /* JADX WARN: Removed duplicated region for block: B:398:0x068d  */
    /* JADX WARN: Removed duplicated region for block: B:401:0x0698  */
    /* JADX WARN: Removed duplicated region for block: B:402:0x069b  */
    /* JADX WARN: Removed duplicated region for block: B:405:0x06a1  */
    /* JADX WARN: Removed duplicated region for block: B:406:0x06a4  */
    /* JADX WARN: Removed duplicated region for block: B:408:0x06a8  */
    /* JADX WARN: Removed duplicated region for block: B:413:0x06b8  */
    /* JADX WARN: Removed duplicated region for block: B:429:0x011a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:438:0x056e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0117  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void applyChainConstraints(androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r40, androidx.constraintlayout.core.LinearSystem r41, java.util.ArrayList r42, int r43) {
        /*
            Method dump skipped, instructions count: 1765
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.Chain.applyChainConstraints(androidx.constraintlayout.core.widgets.ConstraintWidgetContainer, androidx.constraintlayout.core.LinearSystem, java.util.ArrayList, int):void");
    }

    public static void checkMatchParent(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, ConstraintWidget constraintWidget) {
        constraintWidget.mHorizontalResolution = -1;
        ConstraintAnchor constraintAnchor = constraintWidget.mBaseline;
        int[] iArr = constraintWidget.mListDimensionBehaviors;
        ConstraintAnchor constraintAnchor2 = constraintWidget.mBottom;
        ConstraintAnchor constraintAnchor3 = constraintWidget.mTop;
        ConstraintAnchor constraintAnchor4 = constraintWidget.mRight;
        ConstraintAnchor constraintAnchor5 = constraintWidget.mLeft;
        constraintWidget.mVerticalResolution = -1;
        int[] iArr2 = constraintWidgetContainer.mListDimensionBehaviors;
        if (iArr2[0] != 2 && iArr[0] == 4) {
            int i = constraintAnchor5.mMargin;
            int width = constraintWidgetContainer.getWidth() - constraintAnchor4.mMargin;
            constraintAnchor5.mSolverVariable = linearSystem.createObjectVariable(constraintAnchor5);
            constraintAnchor4.mSolverVariable = linearSystem.createObjectVariable(constraintAnchor4);
            linearSystem.addEquality(constraintAnchor5.mSolverVariable, i);
            linearSystem.addEquality(constraintAnchor4.mSolverVariable, width);
            constraintWidget.mHorizontalResolution = 2;
            constraintWidget.mX = i;
            int i2 = width - i;
            constraintWidget.mWidth = i2;
            int i3 = constraintWidget.mMinWidth;
            if (i2 < i3) {
                constraintWidget.mWidth = i3;
            }
        }
        if (iArr2[1] != 2 && iArr[1] == 4) {
            int i4 = constraintAnchor3.mMargin;
            int height = constraintWidgetContainer.getHeight() - constraintAnchor2.mMargin;
            constraintAnchor3.mSolverVariable = linearSystem.createObjectVariable(constraintAnchor3);
            constraintAnchor2.mSolverVariable = linearSystem.createObjectVariable(constraintAnchor2);
            linearSystem.addEquality(constraintAnchor3.mSolverVariable, i4);
            linearSystem.addEquality(constraintAnchor2.mSolverVariable, height);
            if (constraintWidget.mBaselineDistance > 0 || constraintWidget.mVisibility == 8) {
                SolverVariable createObjectVariable = linearSystem.createObjectVariable(constraintAnchor);
                constraintAnchor.mSolverVariable = createObjectVariable;
                linearSystem.addEquality(createObjectVariable, constraintWidget.mBaselineDistance + i4);
            }
            constraintWidget.mVerticalResolution = 2;
            constraintWidget.mY = i4;
            int i5 = height - i4;
            constraintWidget.mHeight = i5;
            int i6 = constraintWidget.mMinHeight;
            if (i5 < i6) {
                constraintWidget.mHeight = i6;
            }
        }
    }

    public static final boolean enabled(int i, int i2) {
        if ((i & i2) == i2) {
            return true;
        }
        return false;
    }
}
