package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.SolverVariable$Type$EnumUnboxingSharedUtility;
import androidx.constraintlayout.core.widgets.analyzer.Direct;
import androidx.constraintlayout.core.widgets.analyzer.WidgetGroup;
import androidx.lifecycle.ViewModelProvider;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class ConstraintAnchor {
    public int mFinalValue;
    public boolean mHasFinalValue;
    public final ConstraintWidget mOwner;
    public SolverVariable mSolverVariable;
    public ConstraintAnchor mTarget;
    public final int mType;
    public HashSet mDependents = null;
    public int mMargin = 0;
    public int mGoneMargin = Integer.MIN_VALUE;

    public ConstraintAnchor(ConstraintWidget constraintWidget, int i) {
        this.mOwner = constraintWidget;
        this.mType = i;
    }

    public final boolean connect(ConstraintAnchor constraintAnchor, int i, int i2, boolean z) {
        if (constraintAnchor == null) {
            reset();
            return true;
        } else if (!z && !isValidConnection(constraintAnchor)) {
            return false;
        } else {
            this.mTarget = constraintAnchor;
            if (constraintAnchor.mDependents == null) {
                constraintAnchor.mDependents = new HashSet();
            }
            HashSet hashSet = this.mTarget.mDependents;
            if (hashSet != null) {
                hashSet.add(this);
            }
            this.mMargin = i;
            this.mGoneMargin = i2;
            return true;
        }
    }

    public final void findDependents(int i, WidgetGroup widgetGroup, ArrayList arrayList) {
        HashSet hashSet = this.mDependents;
        if (hashSet != null) {
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                Direct.findDependents(((ConstraintAnchor) it.next()).mOwner, i, arrayList, widgetGroup);
            }
        }
    }

    public final int getFinalValue() {
        if (!this.mHasFinalValue) {
            return 0;
        }
        return this.mFinalValue;
    }

    public final int getMargin() {
        ConstraintAnchor constraintAnchor;
        if (this.mOwner.mVisibility == 8) {
            return 0;
        }
        int i = this.mGoneMargin;
        if (i == Integer.MIN_VALUE || (constraintAnchor = this.mTarget) == null || constraintAnchor.mOwner.mVisibility != 8) {
            return this.mMargin;
        }
        return i;
    }

    public final ConstraintAnchor getOpposite() {
        int i = this.mType;
        int ordinal = SolverVariable$Type$EnumUnboxingSharedUtility.ordinal(i);
        ConstraintWidget constraintWidget = this.mOwner;
        switch (ordinal) {
            case 0:
            case 5:
            case 6:
            case 7:
            case 8:
                return null;
            case 1:
                return constraintWidget.mRight;
            case 2:
                return constraintWidget.mBottom;
            case 3:
                return constraintWidget.mLeft;
            case 4:
                return constraintWidget.mTop;
            default:
                throw new AssertionError(ViewModelProvider.Factory.CC.name(i));
        }
    }

    public final boolean hasCenteredDependents() {
        HashSet hashSet = this.mDependents;
        if (hashSet == null) {
            return false;
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            if (((ConstraintAnchor) it.next()).getOpposite().isConnected()) {
                return true;
            }
        }
        return false;
    }

    public final boolean isConnected() {
        if (this.mTarget != null) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0063 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean isValidConnection(ConstraintAnchor constraintAnchor) {
        boolean z;
        boolean z2;
        if (constraintAnchor != null) {
            ConstraintWidget constraintWidget = constraintAnchor.mOwner;
            int i = constraintAnchor.mType;
            int i2 = this.mType;
            if (i != i2) {
                switch (SolverVariable$Type$EnumUnboxingSharedUtility.ordinal(i2)) {
                    case 0:
                    case 7:
                    case 8:
                        break;
                    case 1:
                    case 3:
                        if (i == 2 || i == 4) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (!(constraintWidget instanceof Guideline)) {
                            return z;
                        }
                        if (z || i == 8) {
                        }
                        break;
                    case 2:
                    case 4:
                        if (i == 3 || i == 5) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (!(constraintWidget instanceof Guideline)) {
                            return z2;
                        }
                        if (z2 || i == 9) {
                        }
                        break;
                    case 5:
                        if (i == 2 || i == 4) {
                        }
                        break;
                    case 6:
                        if (i == 6 || i == 8 || i == 9) {
                        }
                        break;
                    default:
                        throw new AssertionError(ViewModelProvider.Factory.CC.name(i2));
                }
            } else if (i2 != 6 || (constraintWidget.mHasBaseline && this.mOwner.mHasBaseline)) {
                return true;
            }
        }
        return false;
    }

    public final void reset() {
        HashSet hashSet;
        ConstraintAnchor constraintAnchor = this.mTarget;
        if (!(constraintAnchor == null || (hashSet = constraintAnchor.mDependents) == null)) {
            hashSet.remove(this);
            if (this.mTarget.mDependents.size() == 0) {
                this.mTarget.mDependents = null;
            }
        }
        this.mDependents = null;
        this.mTarget = null;
        this.mMargin = 0;
        this.mGoneMargin = Integer.MIN_VALUE;
        this.mHasFinalValue = false;
        this.mFinalValue = 0;
    }

    public final void resetSolverVariable() {
        SolverVariable solverVariable = this.mSolverVariable;
        if (solverVariable == null) {
            this.mSolverVariable = new SolverVariable(1);
        } else {
            solverVariable.reset();
        }
    }

    public final void setFinalValue(int i) {
        this.mFinalValue = i;
        this.mHasFinalValue = true;
    }

    public final String toString() {
        return this.mOwner.mDebugName + ":" + ViewModelProvider.Factory.CC.name(this.mType);
    }

    public final void connect(ConstraintAnchor constraintAnchor, int i) {
        connect(constraintAnchor, i, Integer.MIN_VALUE, false);
    }
}
