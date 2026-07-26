package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.ArrayRow;
import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.SolverVariable;
import androidx.lifecycle.ViewModelProvider;
/* loaded from: classes.dex */
public final class Barrier extends HelperWidget {
    public boolean mAllowsGoneWidget;
    public int mBarrierType;
    public int mMargin;
    public boolean mResolved;

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public final void addToSolver(LinearSystem linearSystem, boolean z) {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        int i;
        int i2;
        int i3;
        int i4;
        ConstraintAnchor[] constraintAnchorArr = this.mListAnchors;
        ConstraintAnchor constraintAnchor = this.mLeft;
        constraintAnchorArr[0] = constraintAnchor;
        int i5 = 2;
        ConstraintAnchor constraintAnchor2 = this.mTop;
        constraintAnchorArr[2] = constraintAnchor2;
        ConstraintAnchor constraintAnchor3 = this.mRight;
        constraintAnchorArr[1] = constraintAnchor3;
        ConstraintAnchor constraintAnchor4 = this.mBottom;
        constraintAnchorArr[3] = constraintAnchor4;
        for (ConstraintAnchor constraintAnchor5 : constraintAnchorArr) {
            constraintAnchor5.mSolverVariable = linearSystem.createObjectVariable(constraintAnchor5);
        }
        int i6 = this.mBarrierType;
        if (i6 >= 0 && i6 < 4) {
            ConstraintAnchor constraintAnchor6 = constraintAnchorArr[i6];
            if (!this.mResolved) {
                allSolved();
            }
            if (this.mResolved) {
                this.mResolved = false;
                int i7 = this.mBarrierType;
                if (i7 == 0 || i7 == 1) {
                    linearSystem.addEquality(constraintAnchor.mSolverVariable, this.mX);
                    linearSystem.addEquality(constraintAnchor3.mSolverVariable, this.mX);
                } else if (i7 == 2 || i7 == 3) {
                    linearSystem.addEquality(constraintAnchor2.mSolverVariable, this.mY);
                    linearSystem.addEquality(constraintAnchor4.mSolverVariable, this.mY);
                }
            } else {
                for (int i8 = 0; i8 < this.mWidgetsCount; i8++) {
                    ConstraintWidget constraintWidget = this.mWidgets[i8];
                    if ((this.mAllowsGoneWidget || constraintWidget.allowedInBarrier()) && ((((i4 = this.mBarrierType) == 0 || i4 == 1) && constraintWidget.mListDimensionBehaviors[0] == 3 && constraintWidget.mLeft.mTarget != null && constraintWidget.mRight.mTarget != null) || ((i4 == 2 || i4 == 3) && constraintWidget.mListDimensionBehaviors[1] == 3 && constraintWidget.mTop.mTarget != null && constraintWidget.mBottom.mTarget != null))) {
                        z2 = true;
                        break;
                    }
                }
                z2 = false;
                if (constraintAnchor.hasCenteredDependents() || constraintAnchor3.hasCenteredDependents()) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (constraintAnchor2.hasCenteredDependents() || constraintAnchor4.hasCenteredDependents()) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (z2 || (((i3 = this.mBarrierType) != 0 || !z3) && ((i3 != 2 || !z4) && ((i3 != 1 || !z3) && (i3 != 3 || !z4))))) {
                    z5 = false;
                } else {
                    z5 = true;
                }
                if (!z5) {
                    i = 4;
                } else {
                    i = 5;
                }
                int i9 = 0;
                while (i9 < this.mWidgetsCount) {
                    ConstraintWidget constraintWidget2 = this.mWidgets[i9];
                    if (this.mAllowsGoneWidget || constraintWidget2.allowedInBarrier()) {
                        SolverVariable createObjectVariable = linearSystem.createObjectVariable(constraintWidget2.mListAnchors[this.mBarrierType]);
                        ConstraintAnchor[] constraintAnchorArr2 = constraintWidget2.mListAnchors;
                        int i10 = this.mBarrierType;
                        ConstraintAnchor constraintAnchor7 = constraintAnchorArr2[i10];
                        constraintAnchor7.mSolverVariable = createObjectVariable;
                        ConstraintAnchor constraintAnchor8 = constraintAnchor7.mTarget;
                        if (constraintAnchor8 == null || constraintAnchor8.mOwner != this) {
                            i2 = 0;
                        } else {
                            i2 = constraintAnchor7.mMargin;
                        }
                        if (i10 == 0 || i10 == i5) {
                            ArrayRow createRow = linearSystem.createRow();
                            SolverVariable createSlackVariable = linearSystem.createSlackVariable();
                            createSlackVariable.strength = 0;
                            createRow.createRowLowerThan(constraintAnchor6.mSolverVariable, createObjectVariable, createSlackVariable, this.mMargin - i2);
                            linearSystem.addConstraint(createRow);
                        } else {
                            ArrayRow createRow2 = linearSystem.createRow();
                            SolverVariable createSlackVariable2 = linearSystem.createSlackVariable();
                            createSlackVariable2.strength = 0;
                            createRow2.createRowGreaterThan(constraintAnchor6.mSolverVariable, createObjectVariable, createSlackVariable2, this.mMargin + i2);
                            linearSystem.addConstraint(createRow2);
                        }
                        linearSystem.addEquality(constraintAnchor6.mSolverVariable, createObjectVariable, this.mMargin + i2, i);
                    }
                    i9++;
                    i5 = 2;
                }
                int i11 = this.mBarrierType;
                if (i11 == 0) {
                    linearSystem.addEquality(constraintAnchor3.mSolverVariable, constraintAnchor.mSolverVariable, 0, 8);
                    linearSystem.addEquality(constraintAnchor.mSolverVariable, this.mParent.mRight.mSolverVariable, 0, 4);
                    linearSystem.addEquality(constraintAnchor.mSolverVariable, this.mParent.mLeft.mSolverVariable, 0, 0);
                } else if (i11 == 1) {
                    linearSystem.addEquality(constraintAnchor.mSolverVariable, constraintAnchor3.mSolverVariable, 0, 8);
                    linearSystem.addEquality(constraintAnchor.mSolverVariable, this.mParent.mLeft.mSolverVariable, 0, 4);
                    linearSystem.addEquality(constraintAnchor.mSolverVariable, this.mParent.mRight.mSolverVariable, 0, 0);
                } else if (i11 == 2) {
                    linearSystem.addEquality(constraintAnchor4.mSolverVariable, constraintAnchor2.mSolverVariable, 0, 8);
                    linearSystem.addEquality(constraintAnchor2.mSolverVariable, this.mParent.mBottom.mSolverVariable, 0, 4);
                    linearSystem.addEquality(constraintAnchor2.mSolverVariable, this.mParent.mTop.mSolverVariable, 0, 0);
                } else if (i11 == 3) {
                    linearSystem.addEquality(constraintAnchor2.mSolverVariable, constraintAnchor4.mSolverVariable, 0, 8);
                    linearSystem.addEquality(constraintAnchor2.mSolverVariable, this.mParent.mTop.mSolverVariable, 0, 4);
                    linearSystem.addEquality(constraintAnchor2.mSolverVariable, this.mParent.mBottom.mSolverVariable, 0, 0);
                }
            }
        }
    }

    public final boolean allSolved() {
        int i;
        int i2;
        int i3;
        int i4 = 0;
        boolean z = true;
        while (true) {
            i = this.mWidgetsCount;
            if (i4 >= i) {
                break;
            }
            ConstraintWidget constraintWidget = this.mWidgets[i4];
            if ((this.mAllowsGoneWidget || constraintWidget.allowedInBarrier()) && ((((i2 = this.mBarrierType) == 0 || i2 == 1) && !constraintWidget.isResolvedHorizontally()) || (((i3 = this.mBarrierType) == 2 || i3 == 3) && !constraintWidget.isResolvedVertically()))) {
                z = false;
            }
            i4++;
        }
        if (!z || i <= 0) {
            return false;
        }
        int i5 = 0;
        boolean z2 = false;
        for (int i6 = 0; i6 < this.mWidgetsCount; i6++) {
            ConstraintWidget constraintWidget2 = this.mWidgets[i6];
            if (this.mAllowsGoneWidget || constraintWidget2.allowedInBarrier()) {
                if (!z2) {
                    int i7 = this.mBarrierType;
                    if (i7 == 0) {
                        i5 = constraintWidget2.getAnchor(2).getFinalValue();
                    } else if (i7 == 1) {
                        i5 = constraintWidget2.getAnchor(4).getFinalValue();
                    } else if (i7 == 2) {
                        i5 = constraintWidget2.getAnchor(3).getFinalValue();
                    } else if (i7 == 3) {
                        i5 = constraintWidget2.getAnchor(5).getFinalValue();
                    }
                    z2 = true;
                }
                int i8 = this.mBarrierType;
                if (i8 == 0) {
                    i5 = Math.min(i5, constraintWidget2.getAnchor(2).getFinalValue());
                } else if (i8 == 1) {
                    i5 = Math.max(i5, constraintWidget2.getAnchor(4).getFinalValue());
                } else if (i8 == 2) {
                    i5 = Math.min(i5, constraintWidget2.getAnchor(3).getFinalValue());
                } else if (i8 == 3) {
                    i5 = Math.max(i5, constraintWidget2.getAnchor(5).getFinalValue());
                }
            }
        }
        int i9 = i5 + this.mMargin;
        int i10 = this.mBarrierType;
        if (i10 == 0 || i10 == 1) {
            setFinalHorizontal(i9, i9);
        } else {
            setFinalVertical(i9, i9);
        }
        this.mResolved = true;
        return true;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public final boolean allowedInBarrier() {
        return true;
    }

    public final int getOrientation() {
        int i = this.mBarrierType;
        if (i == 0 || i == 1) {
            return 0;
        }
        if (i == 2 || i == 3) {
            return 1;
        }
        return -1;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public final boolean isResolvedHorizontally() {
        return this.mResolved;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public final boolean isResolvedVertically() {
        return this.mResolved;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public final String toString() {
        String m = ViewModelProvider.Factory.CC.m(new StringBuilder("[Barrier] "), this.mDebugName, " {");
        for (int i = 0; i < this.mWidgetsCount; i++) {
            ConstraintWidget constraintWidget = this.mWidgets[i];
            if (i > 0) {
                m = ViewModelProvider.Factory.CC.m(m, ", ");
            }
            m = m + constraintWidget.mDebugName;
        }
        return ViewModelProvider.Factory.CC.m(m, "}");
    }
}
