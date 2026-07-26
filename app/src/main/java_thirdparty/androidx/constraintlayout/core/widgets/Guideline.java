package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.ArrayRow;
import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.SolverVariable$Type$EnumUnboxingSharedUtility;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class Guideline extends ConstraintWidget {
    public boolean mResolved;
    public float mRelativePercent = -1.0f;
    public int mRelativeBegin = -1;
    public int mRelativeEnd = -1;
    public ConstraintAnchor mAnchor = this.mTop;
    public int mOrientation = 0;

    public Guideline() {
        this.mAnchors.clear();
        this.mAnchors.add(this.mAnchor);
        int length = this.mListAnchors.length;
        for (int i = 0; i < length; i++) {
            this.mListAnchors[i] = this.mAnchor;
        }
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public final void addToSolver(LinearSystem linearSystem, boolean z) {
        boolean z2;
        ConstraintWidgetContainer constraintWidgetContainer = (ConstraintWidgetContainer) this.mParent;
        if (constraintWidgetContainer != null) {
            Object anchor = constraintWidgetContainer.getAnchor(2);
            Object anchor2 = constraintWidgetContainer.getAnchor(4);
            ConstraintWidget constraintWidget = this.mParent;
            boolean z3 = true;
            if (constraintWidget == null || constraintWidget.mListDimensionBehaviors[0] != 2) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (this.mOrientation == 0) {
                anchor = constraintWidgetContainer.getAnchor(3);
                anchor2 = constraintWidgetContainer.getAnchor(5);
                ConstraintWidget constraintWidget2 = this.mParent;
                if (constraintWidget2 == null || constraintWidget2.mListDimensionBehaviors[1] != 2) {
                    z3 = false;
                }
                z2 = z3;
            }
            if (this.mResolved) {
                ConstraintAnchor constraintAnchor = this.mAnchor;
                if (constraintAnchor.mHasFinalValue) {
                    SolverVariable createObjectVariable = linearSystem.createObjectVariable(constraintAnchor);
                    linearSystem.addEquality(createObjectVariable, this.mAnchor.getFinalValue());
                    if (this.mRelativeBegin != -1) {
                        if (z2) {
                            linearSystem.addGreaterThan(linearSystem.createObjectVariable(anchor2), createObjectVariable, 0, 5);
                        }
                    } else if (this.mRelativeEnd != -1 && z2) {
                        SolverVariable createObjectVariable2 = linearSystem.createObjectVariable(anchor2);
                        linearSystem.addGreaterThan(createObjectVariable, linearSystem.createObjectVariable(anchor), 0, 5);
                        linearSystem.addGreaterThan(createObjectVariable2, createObjectVariable, 0, 5);
                    }
                    this.mResolved = false;
                    return;
                }
            }
            if (this.mRelativeBegin != -1) {
                SolverVariable createObjectVariable3 = linearSystem.createObjectVariable(this.mAnchor);
                linearSystem.addEquality(createObjectVariable3, linearSystem.createObjectVariable(anchor), this.mRelativeBegin, 8);
                if (z2) {
                    linearSystem.addGreaterThan(linearSystem.createObjectVariable(anchor2), createObjectVariable3, 0, 5);
                }
            } else if (this.mRelativeEnd != -1) {
                SolverVariable createObjectVariable4 = linearSystem.createObjectVariable(this.mAnchor);
                SolverVariable createObjectVariable5 = linearSystem.createObjectVariable(anchor2);
                linearSystem.addEquality(createObjectVariable4, createObjectVariable5, -this.mRelativeEnd, 8);
                if (z2) {
                    linearSystem.addGreaterThan(createObjectVariable4, linearSystem.createObjectVariable(anchor), 0, 5);
                    linearSystem.addGreaterThan(createObjectVariable5, createObjectVariable4, 0, 5);
                }
            } else if (this.mRelativePercent != -1.0f) {
                SolverVariable createObjectVariable6 = linearSystem.createObjectVariable(this.mAnchor);
                SolverVariable createObjectVariable7 = linearSystem.createObjectVariable(anchor2);
                float f = this.mRelativePercent;
                ArrayRow createRow = linearSystem.createRow();
                createRow.variables.put(createObjectVariable6, -1.0f);
                createRow.variables.put(createObjectVariable7, f);
                linearSystem.addConstraint(createRow);
            }
        }
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public final boolean allowedInBarrier() {
        return true;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public final ConstraintAnchor getAnchor(int i) {
        int ordinal = SolverVariable$Type$EnumUnboxingSharedUtility.ordinal(i);
        if (ordinal != 1) {
            if (ordinal != 2) {
                if (ordinal != 3) {
                    if (ordinal != 4) {
                        return null;
                    }
                }
            }
            if (this.mOrientation == 0) {
                return this.mAnchor;
            }
            return null;
        }
        if (this.mOrientation == 1) {
            return this.mAnchor;
        }
        return null;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public final boolean isResolvedHorizontally() {
        return this.mResolved;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public final boolean isResolvedVertically() {
        return this.mResolved;
    }

    public final void setFinalValue(int i) {
        this.mAnchor.setFinalValue(i);
        this.mResolved = true;
    }

    public final void setOrientation(int i) {
        if (this.mOrientation != i) {
            this.mOrientation = i;
            ArrayList arrayList = this.mAnchors;
            arrayList.clear();
            if (this.mOrientation == 1) {
                this.mAnchor = this.mLeft;
            } else {
                this.mAnchor = this.mTop;
            }
            arrayList.add(this.mAnchor);
            ConstraintAnchor[] constraintAnchorArr = this.mListAnchors;
            int length = constraintAnchorArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                constraintAnchorArr[i2] = this.mAnchor;
            }
        }
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public final void updateFromSolver(LinearSystem linearSystem, boolean z) {
        if (this.mParent != null) {
            ConstraintAnchor constraintAnchor = this.mAnchor;
            linearSystem.getClass();
            int objectVariableValue = LinearSystem.getObjectVariableValue(constraintAnchor);
            if (this.mOrientation == 1) {
                this.mX = objectVariableValue;
                this.mY = 0;
                setHeight(this.mParent.getHeight());
                setWidth(0);
                return;
            }
            this.mX = 0;
            this.mY = objectVariableValue;
            setWidth(this.mParent.getWidth());
            setHeight(0);
        }
    }
}
