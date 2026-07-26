package androidx.constraintlayout.core;

import androidx.lifecycle.ViewModelProvider;
import java.util.ArrayList;
import kotlin.text.MatcherMatchResult;
/* loaded from: classes.dex */
public class ArrayRow {
    public final ArrayLinkedVariables variables;
    public SolverVariable mVariable = null;
    public float mConstantValue = 0.0f;
    public final ArrayList mVariablesToUpdate = new ArrayList();
    public boolean mIsSimpleDefinition = false;

    public ArrayRow(MatcherMatchResult matcherMatchResult) {
        this.variables = new ArrayLinkedVariables(this, matcherMatchResult);
    }

    public final void addError(LinearSystem linearSystem, int i) {
        this.variables.put(linearSystem.createErrorVariable(i), 1.0f);
        this.variables.put(linearSystem.createErrorVariable(i), -1.0f);
    }

    public final void createRowGreaterThan(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, int i) {
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            this.mConstantValue = i;
        }
        if (!z) {
            this.variables.put(solverVariable, -1.0f);
            this.variables.put(solverVariable2, 1.0f);
            this.variables.put(solverVariable3, 1.0f);
            return;
        }
        this.variables.put(solverVariable, 1.0f);
        this.variables.put(solverVariable2, -1.0f);
        this.variables.put(solverVariable3, -1.0f);
    }

    public final void createRowLowerThan(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, int i) {
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            this.mConstantValue = i;
        }
        if (!z) {
            this.variables.put(solverVariable, -1.0f);
            this.variables.put(solverVariable2, 1.0f);
            this.variables.put(solverVariable3, -1.0f);
            return;
        }
        this.variables.put(solverVariable, 1.0f);
        this.variables.put(solverVariable2, -1.0f);
        this.variables.put(solverVariable3, 1.0f);
    }

    public SolverVariable getPivotCandidate(boolean[] zArr) {
        return pickPivotInVariables(zArr, null);
    }

    public boolean isEmpty() {
        if (this.mVariable == null && this.mConstantValue == 0.0f && this.variables.getCurrentSize() == 0) {
            return true;
        }
        return false;
    }

    public final SolverVariable pickPivotInVariables(boolean[] zArr, SolverVariable solverVariable) {
        int i;
        int currentSize = this.variables.getCurrentSize();
        SolverVariable solverVariable2 = null;
        float f = 0.0f;
        for (int i2 = 0; i2 < currentSize; i2++) {
            float variableValue = this.variables.getVariableValue(i2);
            if (variableValue < 0.0f) {
                SolverVariable variable = this.variables.getVariable(i2);
                if ((zArr == null || !zArr[variable.f1id]) && variable != solverVariable && (((i = variable.mType) == 3 || i == 4) && variableValue < f)) {
                    f = variableValue;
                    solverVariable2 = variable;
                }
            }
        }
        return solverVariable2;
    }

    public final void pivot(SolverVariable solverVariable) {
        SolverVariable solverVariable2 = this.mVariable;
        if (solverVariable2 != null) {
            this.variables.put(solverVariable2, -1.0f);
            this.mVariable.mDefinitionId = -1;
            this.mVariable = null;
        }
        float remove = this.variables.remove(solverVariable, true) * (-1.0f);
        this.mVariable = solverVariable;
        if (remove != 1.0f) {
            this.mConstantValue /= remove;
            ArrayLinkedVariables arrayLinkedVariables = this.variables;
            int i = arrayLinkedVariables.mHead;
            for (int i2 = 0; i != -1 && i2 < arrayLinkedVariables.mCurrentSize; i2++) {
                float[] fArr = arrayLinkedVariables.mArrayValues;
                fArr[i] = fArr[i] / remove;
                i = arrayLinkedVariables.mArrayNextIndices[i];
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0086  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String toString() {
        String str;
        boolean z;
        float variableValue;
        int i;
        if (this.mVariable == null) {
            str = "0";
        } else {
            str = "" + this.mVariable;
        }
        String m = ViewModelProvider.Factory.CC.m596m(str, " = ");
        if (this.mConstantValue != 0.0f) {
            m = m + this.mConstantValue;
            z = true;
        } else {
            z = false;
        }
        int currentSize = this.variables.getCurrentSize();
        for (int i2 = 0; i2 < currentSize; i2++) {
            SolverVariable variable = this.variables.getVariable(i2);
            if (!(variable == null || (variableValue = this.variables.getVariableValue(i2)) == 0.0f)) {
                String solverVariable = variable.toString();
                if (!z) {
                    if (variableValue < 0.0f) {
                        m = ViewModelProvider.Factory.CC.m596m(m, "- ");
                        variableValue *= -1.0f;
                    }
                    if (variableValue == 1.0f) {
                        m = ViewModelProvider.Factory.CC.m596m(m, solverVariable);
                    } else {
                        m = m + variableValue + " " + solverVariable;
                    }
                    z = true;
                } else if (i > 0) {
                    m = ViewModelProvider.Factory.CC.m596m(m, " + ");
                    if (variableValue == 1.0f) {
                    }
                    z = true;
                } else {
                    m = ViewModelProvider.Factory.CC.m596m(m, " - ");
                    variableValue *= -1.0f;
                    if (variableValue == 1.0f) {
                    }
                    z = true;
                }
            }
        }
        if (!z) {
            return ViewModelProvider.Factory.CC.m596m(m, "0.0");
        }
        return m;
    }

    public final void updateFromFinalVariable(LinearSystem linearSystem, SolverVariable solverVariable, boolean z) {
        if (solverVariable.isFinalValue) {
            float f = this.variables.get(solverVariable);
            this.mConstantValue = (solverVariable.computedValue * f) + this.mConstantValue;
            this.variables.remove(solverVariable, z);
            if (z) {
                solverVariable.removeFromRow(this);
            }
            if (this.variables.getCurrentSize() == 0) {
                this.mIsSimpleDefinition = true;
                linearSystem.hasSimpleDefinition = true;
            }
        }
    }

    public void updateFromRow(LinearSystem linearSystem, ArrayRow arrayRow, boolean z) {
        ArrayLinkedVariables arrayLinkedVariables = this.variables;
        arrayLinkedVariables.getClass();
        float f = arrayLinkedVariables.get(arrayRow.mVariable);
        arrayLinkedVariables.remove(arrayRow.mVariable, z);
        ArrayLinkedVariables arrayLinkedVariables2 = arrayRow.variables;
        int currentSize = arrayLinkedVariables2.getCurrentSize();
        for (int i = 0; i < currentSize; i++) {
            SolverVariable variable = arrayLinkedVariables2.getVariable(i);
            arrayLinkedVariables.add(variable, arrayLinkedVariables2.get(variable) * f, z);
        }
        this.mConstantValue = (arrayRow.mConstantValue * f) + this.mConstantValue;
        if (z) {
            arrayRow.mVariable.removeFromRow(this);
        }
        if (this.mVariable != null && this.variables.getCurrentSize() == 0) {
            this.mIsSimpleDefinition = true;
            linearSystem.hasSimpleDefinition = true;
        }
    }
}
