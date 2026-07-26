package androidx.constraintlayout.core;

import androidx.viewpager.widget.ViewPager;
import com.android.billingclient.api.zzcl;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class PriorityGoalRow extends ArrayRow {
    public zzcl mAccessor;
    public SolverVariable[] mArrayGoals;
    public int mNumGoals;
    public SolverVariable[] mSortArray;

    public final void addToGoal(SolverVariable solverVariable) {
        int i;
        int i2 = this.mNumGoals + 1;
        SolverVariable[] solverVariableArr = this.mArrayGoals;
        if (i2 > solverVariableArr.length) {
            SolverVariable[] solverVariableArr2 = (SolverVariable[]) Arrays.copyOf(solverVariableArr, solverVariableArr.length * 2);
            this.mArrayGoals = solverVariableArr2;
            this.mSortArray = (SolverVariable[]) Arrays.copyOf(solverVariableArr2, solverVariableArr2.length * 2);
        }
        SolverVariable[] solverVariableArr3 = this.mArrayGoals;
        int i3 = this.mNumGoals;
        solverVariableArr3[i3] = solverVariable;
        int i4 = i3 + 1;
        this.mNumGoals = i4;
        if (i4 > 1 && solverVariableArr3[i3].f1id > solverVariable.f1id) {
            int i5 = 0;
            while (true) {
                i = this.mNumGoals;
                if (i5 >= i) {
                    break;
                }
                this.mSortArray[i5] = this.mArrayGoals[i5];
                i5++;
            }
            Arrays.sort(this.mSortArray, 0, i, new ViewPager.C01171(1));
            for (int i6 = 0; i6 < this.mNumGoals; i6++) {
                this.mArrayGoals[i6] = this.mSortArray[i6];
            }
        }
        solverVariable.inGoal = true;
        solverVariable.addToRow(this);
    }

    @Override // androidx.constraintlayout.core.ArrayRow
    public final SolverVariable getPivotCandidate(boolean[] zArr) {
        int i = -1;
        for (int i2 = 0; i2 < this.mNumGoals; i2++) {
            SolverVariable[] solverVariableArr = this.mArrayGoals;
            SolverVariable solverVariable = solverVariableArr[i2];
            if (!zArr[solverVariable.f1id]) {
                zzcl zzclVar = this.mAccessor;
                zzclVar.zzb = solverVariable;
                int i3 = 8;
                if (i == -1) {
                    while (i3 >= 0) {
                        float f = ((SolverVariable) zzclVar.zzb).mGoalStrengthVector[i3];
                        if (f <= 0.0f) {
                            if (f < 0.0f) {
                                i = i2;
                                break;
                            }
                            i3--;
                        }
                    }
                } else {
                    SolverVariable solverVariable2 = solverVariableArr[i];
                    while (true) {
                        if (i3 >= 0) {
                            float f2 = solverVariable2.mGoalStrengthVector[i3];
                            float f3 = ((SolverVariable) zzclVar.zzb).mGoalStrengthVector[i3];
                            if (f3 == f2) {
                                i3--;
                            } else if (f3 >= f2) {
                            }
                        }
                    }
                }
            }
        }
        if (i == -1) {
            return null;
        }
        return this.mArrayGoals[i];
    }

    @Override // androidx.constraintlayout.core.ArrayRow
    public final boolean isEmpty() {
        if (this.mNumGoals == 0) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001c, code lost:
        r5.mNumGoals = r2 - 1;
        r6.inGoal = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0022, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x000c, code lost:
        r2 = r5.mNumGoals;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0010, code lost:
        if (r1 >= (r2 - 1)) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0012, code lost:
        r2 = r5.mArrayGoals;
        r3 = r1 + 1;
        r2[r1] = r2[r3];
        r1 = r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void removeGoal(SolverVariable solverVariable) {
        int i = 0;
        while (i < this.mNumGoals) {
            if (this.mArrayGoals[i] == solverVariable) {
                break;
            }
            i++;
        }
    }

    @Override // androidx.constraintlayout.core.ArrayRow
    public final String toString() {
        zzcl zzclVar = this.mAccessor;
        String str = " goal -> (" + this.mConstantValue + ") : ";
        for (int i = 0; i < this.mNumGoals; i++) {
            zzclVar.zzb = this.mArrayGoals[i];
            str = str + zzclVar + " ";
        }
        return str;
    }

    @Override // androidx.constraintlayout.core.ArrayRow
    public final void updateFromRow(LinearSystem linearSystem, ArrayRow arrayRow, boolean z) {
        SolverVariable solverVariable = arrayRow.mVariable;
        if (solverVariable != null) {
            float[] fArr = solverVariable.mGoalStrengthVector;
            ArrayLinkedVariables arrayLinkedVariables = arrayRow.variables;
            int currentSize = arrayLinkedVariables.getCurrentSize();
            for (int i = 0; i < currentSize; i++) {
                SolverVariable variable = arrayLinkedVariables.getVariable(i);
                float variableValue = arrayLinkedVariables.getVariableValue(i);
                zzcl zzclVar = this.mAccessor;
                zzclVar.zzb = variable;
                if (variable.inGoal) {
                    boolean z2 = true;
                    for (int i2 = 0; i2 < 9; i2++) {
                        float[] fArr2 = ((SolverVariable) zzclVar.zzb).mGoalStrengthVector;
                        float f = (fArr[i2] * variableValue) + fArr2[i2];
                        fArr2[i2] = f;
                        if (Math.abs(f) < 1.0E-4f) {
                            ((SolverVariable) zzclVar.zzb).mGoalStrengthVector[i2] = 0.0f;
                        } else {
                            z2 = false;
                        }
                    }
                    if (z2) {
                        ((PriorityGoalRow) zzclVar.zzc).removeGoal((SolverVariable) zzclVar.zzb);
                    }
                } else {
                    for (int i3 = 0; i3 < 9; i3++) {
                        float f2 = fArr[i3];
                        if (f2 != 0.0f) {
                            float f3 = f2 * variableValue;
                            if (Math.abs(f3) < 1.0E-4f) {
                                f3 = 0.0f;
                            }
                            ((SolverVariable) zzclVar.zzb).mGoalStrengthVector[i3] = f3;
                        } else {
                            ((SolverVariable) zzclVar.zzb).mGoalStrengthVector[i3] = 0.0f;
                        }
                    }
                    addToGoal(variable);
                }
                this.mConstantValue = (arrayRow.mConstantValue * variableValue) + this.mConstantValue;
            }
            removeGoal(solverVariable);
        }
    }
}
