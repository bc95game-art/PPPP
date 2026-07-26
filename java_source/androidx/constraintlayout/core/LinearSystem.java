package androidx.constraintlayout.core;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.core.util.Pools$SimplePool;
import com.android.billingclient.api.zzcl;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.text.MatcherMatchResult;
/* loaded from: classes.dex */
public final class LinearSystem {
    public static boolean USE_DEPENDENCY_ORDERING = false;
    public final MatcherMatchResult mCache;
    public final PriorityGoalRow mGoal;
    public ArrayRow mTempGoal;
    public int mPoolSize = 1000;
    public boolean hasSimpleDefinition = false;
    public int mVariablesID = 0;
    public int mTableSize = 32;
    public int mMaxColumns = 32;
    public boolean newgraphOptimizer = false;
    public boolean[] mAlreadyTestedCandidates = new boolean[32];
    public int mNumColumns = 1;
    public int mNumRows = 0;
    public int mMaxRows = 32;
    public SolverVariable[] mPoolVariables = new SolverVariable[1000];
    public int mPoolVariablesCount = 0;
    public ArrayRow[] mRows = new ArrayRow[32];

    /* JADX WARN: Type inference failed for: r2v2, types: [androidx.constraintlayout.core.ArrayRow, java.lang.Object, androidx.constraintlayout.core.PriorityGoalRow] */
    public LinearSystem() {
        releaseRows();
        MatcherMatchResult matcherMatchResult = new MatcherMatchResult(4);
        matcherMatchResult.matcher = new Pools$SimplePool();
        matcherMatchResult.input = new Pools$SimplePool();
        matcherMatchResult.groups = new SolverVariable[32];
        this.mCache = matcherMatchResult;
        ?? arrayRow = new ArrayRow(matcherMatchResult);
        arrayRow.mArrayGoals = new SolverVariable[128];
        arrayRow.mSortArray = new SolverVariable[128];
        arrayRow.mNumGoals = 0;
        arrayRow.mAccessor = new zzcl(4, (Object) arrayRow);
        this.mGoal = arrayRow;
        this.mTempGoal = new ArrayRow(matcherMatchResult);
    }

    public static int getObjectVariableValue(Object obj) {
        SolverVariable solverVariable = ((ConstraintAnchor) obj).mSolverVariable;
        if (solverVariable != null) {
            return (int) (solverVariable.computedValue + 0.5f);
        }
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r4v0 */
    public final SolverVariable acquireSolverVariable(int i) {
        Pools$SimplePool pools$SimplePool = (Pools$SimplePool) this.mCache.input;
        int i2 = pools$SimplePool.poolSize;
        SolverVariable solverVariable = null;
        if (i2 > 0) {
            int i3 = i2 - 1;
            ?? r3 = pools$SimplePool.pool;
            ?? r4 = r3[i3];
            r3[i3] = 0;
            pools$SimplePool.poolSize = i3;
            solverVariable = r4;
        }
        SolverVariable solverVariable2 = solverVariable;
        if (solverVariable2 == null) {
            solverVariable2 = new SolverVariable(i);
            solverVariable2.mType = i;
        } else {
            solverVariable2.reset();
            solverVariable2.mType = i;
        }
        int i4 = this.mPoolVariablesCount;
        int i5 = this.mPoolSize;
        if (i4 >= i5) {
            int i6 = i5 * 2;
            this.mPoolSize = i6;
            this.mPoolVariables = (SolverVariable[]) Arrays.copyOf(this.mPoolVariables, i6);
        }
        SolverVariable[] solverVariableArr = this.mPoolVariables;
        int i7 = this.mPoolVariablesCount;
        this.mPoolVariablesCount = i7 + 1;
        solverVariableArr[i7] = solverVariable2;
        return solverVariable2;
    }

    public final void addCentering(SolverVariable solverVariable, SolverVariable solverVariable2, int i, float f, SolverVariable solverVariable3, SolverVariable solverVariable4, int i2, int i3) {
        ArrayRow createRow = createRow();
        if (solverVariable2 == solverVariable3) {
            createRow.variables.put(solverVariable, 1.0f);
            createRow.variables.put(solverVariable4, 1.0f);
            createRow.variables.put(solverVariable2, -2.0f);
        } else if (f == 0.5f) {
            createRow.variables.put(solverVariable, 1.0f);
            createRow.variables.put(solverVariable2, -1.0f);
            createRow.variables.put(solverVariable3, -1.0f);
            createRow.variables.put(solverVariable4, 1.0f);
            if (i > 0 || i2 > 0) {
                createRow.mConstantValue = (-i) + i2;
            }
        } else if (f <= 0.0f) {
            createRow.variables.put(solverVariable, -1.0f);
            createRow.variables.put(solverVariable2, 1.0f);
            createRow.mConstantValue = i;
        } else if (f >= 1.0f) {
            createRow.variables.put(solverVariable4, -1.0f);
            createRow.variables.put(solverVariable3, 1.0f);
            createRow.mConstantValue = -i2;
        } else {
            float f2 = 1.0f - f;
            createRow.variables.put(solverVariable, f2 * 1.0f);
            createRow.variables.put(solverVariable2, f2 * (-1.0f));
            createRow.variables.put(solverVariable3, (-1.0f) * f);
            createRow.variables.put(solverVariable4, 1.0f * f);
            if (i > 0 || i2 > 0) {
                createRow.mConstantValue = (i2 * f) + ((-i) * f2);
            }
        }
        if (i3 != 8) {
            createRow.addError(this, i3);
        }
        addConstraint(createRow);
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x00d5, code lost:
        if (r4.usageInRowCount <= 1) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00d7, code lost:
        r12 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00d9, code lost:
        r12 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00e3, code lost:
        if (r4.usageInRowCount <= 1) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00fa, code lost:
        if (r4.usageInRowCount <= 1) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00fc, code lost:
        r14 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00fe, code lost:
        r14 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0108, code lost:
        if (r4.usageInRowCount <= 1) goto L71;
     */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:151:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void addConstraint(ArrayRow arrayRow) {
        boolean z;
        boolean z2;
        SolverVariable solverVariable;
        SolverVariable pickPivotInVariables;
        if (this.mNumRows + 1 >= this.mMaxRows || this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        if (!arrayRow.mIsSimpleDefinition) {
            ArrayList arrayList = arrayRow.mVariablesToUpdate;
            if (this.mRows.length != 0) {
                boolean z3 = false;
                while (!z3) {
                    int currentSize = arrayRow.variables.getCurrentSize();
                    for (int i = 0; i < currentSize; i++) {
                        SolverVariable variable = arrayRow.variables.getVariable(i);
                        if (variable.mDefinitionId != -1 || variable.isFinalValue) {
                            arrayList.add(variable);
                        }
                    }
                    int size = arrayList.size();
                    if (size > 0) {
                        for (int i2 = 0; i2 < size; i2++) {
                            SolverVariable solverVariable2 = (SolverVariable) arrayList.get(i2);
                            if (solverVariable2.isFinalValue) {
                                arrayRow.updateFromFinalVariable(this, solverVariable2, true);
                            } else {
                                arrayRow.updateFromRow(this, this.mRows[solverVariable2.mDefinitionId], true);
                            }
                        }
                        arrayList.clear();
                    } else {
                        z3 = true;
                    }
                }
                if (arrayRow.mVariable != null && arrayRow.variables.getCurrentSize() == 0) {
                    arrayRow.mIsSimpleDefinition = true;
                    this.hasSimpleDefinition = true;
                }
            }
            if (!arrayRow.isEmpty()) {
                float f = arrayRow.mConstantValue;
                if (f < 0.0f) {
                    arrayRow.mConstantValue = f * (-1.0f);
                    ArrayLinkedVariables arrayLinkedVariables = arrayRow.variables;
                    int i3 = arrayLinkedVariables.mHead;
                    for (int i4 = 0; i3 != -1 && i4 < arrayLinkedVariables.mCurrentSize; i4++) {
                        float[] fArr = arrayLinkedVariables.mArrayValues;
                        fArr[i3] = fArr[i3] * (-1.0f);
                        i3 = arrayLinkedVariables.mArrayNextIndices[i3];
                    }
                }
                int currentSize2 = arrayRow.variables.getCurrentSize();
                SolverVariable solverVariable3 = null;
                SolverVariable solverVariable4 = null;
                float f2 = 0.0f;
                boolean z4 = false;
                float f3 = 0.0f;
                boolean z5 = false;
                for (int i5 = 0; i5 < currentSize2; i5++) {
                    float variableValue = arrayRow.variables.getVariableValue(i5);
                    SolverVariable variable2 = arrayRow.variables.getVariable(i5);
                    if (variable2.mType == 1) {
                        if (solverVariable3 != null) {
                            if (f2 <= variableValue) {
                                if (!z4 && variable2.usageInRowCount <= 1) {
                                    solverVariable3 = variable2;
                                    f2 = variableValue;
                                    z4 = true;
                                }
                            }
                        }
                        solverVariable3 = variable2;
                        f2 = variableValue;
                    } else if (solverVariable3 == null && variableValue < 0.0f) {
                        if (solverVariable4 != null) {
                            if (f3 <= variableValue) {
                                if (!z5 && variable2.usageInRowCount <= 1) {
                                    solverVariable4 = variable2;
                                    f3 = variableValue;
                                    z5 = true;
                                }
                            }
                        }
                        solverVariable4 = variable2;
                        f3 = variableValue;
                    }
                }
                if (solverVariable3 == null) {
                    solverVariable3 = solverVariable4;
                }
                if (solverVariable3 == null) {
                    z2 = true;
                } else {
                    arrayRow.pivot(solverVariable3);
                    z2 = false;
                }
                if (arrayRow.variables.getCurrentSize() == 0) {
                    arrayRow.mIsSimpleDefinition = true;
                }
                if (z2) {
                    if (this.mNumColumns + 1 >= this.mMaxColumns) {
                        increaseTableSize();
                    }
                    SolverVariable acquireSolverVariable = acquireSolverVariable(3);
                    int i6 = this.mVariablesID + 1;
                    this.mVariablesID = i6;
                    this.mNumColumns++;
                    acquireSolverVariable.f1id = i6;
                    MatcherMatchResult matcherMatchResult = this.mCache;
                    ((SolverVariable[]) matcherMatchResult.groups)[i6] = acquireSolverVariable;
                    arrayRow.mVariable = acquireSolverVariable;
                    int i7 = this.mNumRows;
                    addRow(arrayRow);
                    if (this.mNumRows == i7 + 1) {
                        ArrayRow arrayRow2 = this.mTempGoal;
                        arrayRow2.mVariable = null;
                        arrayRow2.variables.clear();
                        for (int i8 = 0; i8 < arrayRow.variables.getCurrentSize(); i8++) {
                            arrayRow2.variables.add(arrayRow.variables.getVariable(i8), arrayRow.variables.getVariableValue(i8), true);
                        }
                        optimize(this.mTempGoal);
                        if (acquireSolverVariable.mDefinitionId == -1) {
                            if (arrayRow.mVariable == acquireSolverVariable && (pickPivotInVariables = arrayRow.pickPivotInVariables(null, acquireSolverVariable)) != null) {
                                arrayRow.pivot(pickPivotInVariables);
                            }
                            if (!arrayRow.mIsSimpleDefinition) {
                                arrayRow.mVariable.updateReferencesWithNewDefinition(this, arrayRow);
                            }
                            ((Pools$SimplePool) matcherMatchResult.matcher).release(arrayRow);
                            this.mNumRows--;
                        }
                        z = true;
                        solverVariable = arrayRow.mVariable;
                        if (solverVariable != null) {
                            return;
                        }
                        if (solverVariable.mType != 1 && arrayRow.mConstantValue < 0.0f) {
                            return;
                        }
                    }
                }
                z = false;
                solverVariable = arrayRow.mVariable;
                if (solverVariable != null) {
                }
            } else {
                return;
            }
        } else {
            z = false;
        }
        if (!z) {
            addRow(arrayRow);
        }
    }

    public final void addEquality(SolverVariable solverVariable, SolverVariable solverVariable2, int i, int i2) {
        if (i2 == 8 && solverVariable2.isFinalValue && solverVariable.mDefinitionId == -1) {
            solverVariable.setFinalValue(this, solverVariable2.computedValue + i);
            return;
        }
        ArrayRow createRow = createRow();
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            createRow.mConstantValue = i;
        }
        if (!z) {
            createRow.variables.put(solverVariable, -1.0f);
            createRow.variables.put(solverVariable2, 1.0f);
        } else {
            createRow.variables.put(solverVariable, 1.0f);
            createRow.variables.put(solverVariable2, -1.0f);
        }
        if (i2 != 8) {
            createRow.addError(this, i2);
        }
        addConstraint(createRow);
    }

    public final void addGreaterThan(SolverVariable solverVariable, SolverVariable solverVariable2, int i, int i2) {
        ArrayRow createRow = createRow();
        SolverVariable createSlackVariable = createSlackVariable();
        createSlackVariable.strength = 0;
        createRow.createRowGreaterThan(solverVariable, solverVariable2, createSlackVariable, i);
        if (i2 != 8) {
            createRow.variables.put(createErrorVariable(i2), (int) (createRow.variables.get(createSlackVariable) * (-1.0f)));
        }
        addConstraint(createRow);
    }

    public final void addLowerThan(SolverVariable solverVariable, SolverVariable solverVariable2, int i, int i2) {
        ArrayRow createRow = createRow();
        SolverVariable createSlackVariable = createSlackVariable();
        createSlackVariable.strength = 0;
        createRow.createRowLowerThan(solverVariable, solverVariable2, createSlackVariable, i);
        if (i2 != 8) {
            createRow.variables.put(createErrorVariable(i2), (int) (createRow.variables.get(createSlackVariable) * (-1.0f)));
        }
        addConstraint(createRow);
    }

    public final void addRow(ArrayRow arrayRow) {
        int i;
        if (arrayRow.mIsSimpleDefinition) {
            arrayRow.mVariable.setFinalValue(this, arrayRow.mConstantValue);
        } else {
            ArrayRow[] arrayRowArr = this.mRows;
            int i2 = this.mNumRows;
            arrayRowArr[i2] = arrayRow;
            SolverVariable solverVariable = arrayRow.mVariable;
            solverVariable.mDefinitionId = i2;
            this.mNumRows = i2 + 1;
            solverVariable.updateReferencesWithNewDefinition(this, arrayRow);
        }
        if (this.hasSimpleDefinition) {
            int i3 = 0;
            while (i3 < this.mNumRows) {
                if (this.mRows[i3] == null) {
                    System.out.println("WTF");
                }
                ArrayRow arrayRow2 = this.mRows[i3];
                if (arrayRow2 != null && arrayRow2.mIsSimpleDefinition) {
                    arrayRow2.mVariable.setFinalValue(this, arrayRow2.mConstantValue);
                    ((Pools$SimplePool) this.mCache.matcher).release(arrayRow2);
                    this.mRows[i3] = null;
                    int i4 = i3 + 1;
                    int i5 = i4;
                    while (true) {
                        i = this.mNumRows;
                        if (i4 >= i) {
                            break;
                        }
                        ArrayRow[] arrayRowArr2 = this.mRows;
                        int i6 = i4 - 1;
                        ArrayRow arrayRow3 = arrayRowArr2[i4];
                        arrayRowArr2[i6] = arrayRow3;
                        SolverVariable solverVariable2 = arrayRow3.mVariable;
                        if (solverVariable2.mDefinitionId == i4) {
                            solverVariable2.mDefinitionId = i6;
                        }
                        i5 = i4;
                        i4++;
                    }
                    if (i5 < i) {
                        this.mRows[i5] = null;
                    }
                    this.mNumRows = i - 1;
                    i3--;
                }
                i3++;
            }
            this.hasSimpleDefinition = false;
        }
    }

    public final void computeValues() {
        for (int i = 0; i < this.mNumRows; i++) {
            ArrayRow arrayRow = this.mRows[i];
            arrayRow.mVariable.computedValue = arrayRow.mConstantValue;
        }
    }

    public final SolverVariable createErrorVariable(int i) {
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        SolverVariable acquireSolverVariable = acquireSolverVariable(4);
        float[] fArr = acquireSolverVariable.mGoalStrengthVector;
        int i2 = this.mVariablesID + 1;
        this.mVariablesID = i2;
        this.mNumColumns++;
        acquireSolverVariable.f1id = i2;
        acquireSolverVariable.strength = i;
        ((SolverVariable[]) this.mCache.groups)[i2] = acquireSolverVariable;
        PriorityGoalRow priorityGoalRow = this.mGoal;
        priorityGoalRow.mAccessor.zzb = acquireSolverVariable;
        Arrays.fill(fArr, 0.0f);
        fArr[acquireSolverVariable.strength] = 1.0f;
        priorityGoalRow.addToGoal(acquireSolverVariable);
        return acquireSolverVariable;
    }

    public final SolverVariable createObjectVariable(Object obj) {
        if (obj == null) {
            return null;
        }
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        if (!(obj instanceof ConstraintAnchor)) {
            return null;
        }
        ConstraintAnchor constraintAnchor = (ConstraintAnchor) obj;
        SolverVariable solverVariable = constraintAnchor.mSolverVariable;
        if (solverVariable == null) {
            constraintAnchor.resetSolverVariable();
            solverVariable = constraintAnchor.mSolverVariable;
        }
        int i = solverVariable.f1id;
        MatcherMatchResult matcherMatchResult = this.mCache;
        if (i != -1 && i <= this.mVariablesID && ((SolverVariable[]) matcherMatchResult.groups)[i] != null) {
            return solverVariable;
        }
        if (i != -1) {
            solverVariable.reset();
        }
        int i2 = this.mVariablesID + 1;
        this.mVariablesID = i2;
        this.mNumColumns++;
        solverVariable.f1id = i2;
        solverVariable.mType = 1;
        ((SolverVariable[]) matcherMatchResult.groups)[i2] = solverVariable;
        return solverVariable;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r5v4 */
    public final ArrayRow createRow() {
        ArrayRow arrayRow;
        MatcherMatchResult matcherMatchResult = this.mCache;
        Pools$SimplePool pools$SimplePool = (Pools$SimplePool) matcherMatchResult.matcher;
        int i = pools$SimplePool.poolSize;
        if (i > 0) {
            int i2 = i - 1;
            ?? r4 = pools$SimplePool.pool;
            ?? r5 = r4[i2];
            r4[i2] = 0;
            pools$SimplePool.poolSize = i2;
            arrayRow = r5;
        } else {
            arrayRow = null;
        }
        ArrayRow arrayRow2 = arrayRow;
        if (arrayRow2 == null) {
            return new ArrayRow(matcherMatchResult);
        }
        arrayRow2.mVariable = null;
        arrayRow2.variables.clear();
        arrayRow2.mConstantValue = 0.0f;
        arrayRow2.mIsSimpleDefinition = false;
        return arrayRow2;
    }

    public final SolverVariable createSlackVariable() {
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        SolverVariable acquireSolverVariable = acquireSolverVariable(3);
        int i = this.mVariablesID + 1;
        this.mVariablesID = i;
        this.mNumColumns++;
        acquireSolverVariable.f1id = i;
        ((SolverVariable[]) this.mCache.groups)[i] = acquireSolverVariable;
        return acquireSolverVariable;
    }

    public final void increaseTableSize() {
        int i = this.mTableSize * 2;
        this.mTableSize = i;
        this.mRows = (ArrayRow[]) Arrays.copyOf(this.mRows, i);
        MatcherMatchResult matcherMatchResult = this.mCache;
        matcherMatchResult.groups = (SolverVariable[]) Arrays.copyOf((SolverVariable[]) matcherMatchResult.groups, this.mTableSize);
        int i2 = this.mTableSize;
        this.mAlreadyTestedCandidates = new boolean[i2];
        this.mMaxColumns = i2;
        this.mMaxRows = i2;
    }

    public final void minimize() {
        PriorityGoalRow priorityGoalRow = this.mGoal;
        if (priorityGoalRow.isEmpty()) {
            computeValues();
        } else if (this.newgraphOptimizer) {
            for (int i = 0; i < this.mNumRows; i++) {
                if (!this.mRows[i].mIsSimpleDefinition) {
                    minimizeGoal(priorityGoalRow);
                    return;
                }
            }
            computeValues();
        } else {
            minimizeGoal(priorityGoalRow);
        }
    }

    public final void minimizeGoal(PriorityGoalRow priorityGoalRow) {
        int i = 0;
        while (true) {
            if (i >= this.mNumRows) {
                break;
            }
            ArrayRow arrayRow = this.mRows[i];
            int i2 = 1;
            if (arrayRow.mVariable.mType != 1) {
                float f = 0.0f;
                if (arrayRow.mConstantValue < 0.0f) {
                    boolean z = false;
                    int i3 = 0;
                    while (!z) {
                        i3 += i2;
                        float f2 = Float.MAX_VALUE;
                        int i4 = 0;
                        int i5 = -1;
                        int i6 = -1;
                        int i7 = 0;
                        while (i4 < this.mNumRows) {
                            ArrayRow arrayRow2 = this.mRows[i4];
                            if (arrayRow2.mVariable.mType != i2 && !arrayRow2.mIsSimpleDefinition && arrayRow2.mConstantValue < f) {
                                int currentSize = arrayRow2.variables.getCurrentSize();
                                int i8 = 0;
                                while (i8 < currentSize) {
                                    SolverVariable variable = arrayRow2.variables.getVariable(i8);
                                    float f3 = arrayRow2.variables.get(variable);
                                    if (f3 > f) {
                                        for (int i9 = 0; i9 < 9; i9++) {
                                            float f4 = variable.mStrengthVector[i9] / f3;
                                            if ((f4 < f2 && i9 == i7) || i9 > i7) {
                                                i7 = i9;
                                                i6 = variable.f1id;
                                                i5 = i4;
                                                f2 = f4;
                                            }
                                        }
                                    }
                                    i8++;
                                    f = 0.0f;
                                }
                            }
                            i4++;
                            f = 0.0f;
                            i2 = 1;
                        }
                        if (i5 != -1) {
                            ArrayRow arrayRow3 = this.mRows[i5];
                            arrayRow3.mVariable.mDefinitionId = -1;
                            arrayRow3.pivot(((SolverVariable[]) this.mCache.groups)[i6]);
                            SolverVariable solverVariable = arrayRow3.mVariable;
                            solverVariable.mDefinitionId = i5;
                            solverVariable.updateReferencesWithNewDefinition(this, arrayRow3);
                        } else {
                            z = true;
                        }
                        if (i3 > this.mNumColumns / 2) {
                            z = true;
                        }
                        f = 0.0f;
                        i2 = 1;
                    }
                }
            }
            i++;
        }
        optimize(priorityGoalRow);
        computeValues();
    }

    public final void optimize(ArrayRow arrayRow) {
        boolean z;
        for (int i = 0; i < this.mNumColumns; i++) {
            this.mAlreadyTestedCandidates[i] = false;
        }
        boolean z2 = false;
        int i2 = 0;
        while (!z2) {
            int i3 = 1;
            i2++;
            if (i2 < this.mNumColumns * 2) {
                SolverVariable solverVariable = arrayRow.mVariable;
                if (solverVariable != null) {
                    this.mAlreadyTestedCandidates[solverVariable.f1id] = true;
                }
                SolverVariable pivotCandidate = arrayRow.getPivotCandidate(this.mAlreadyTestedCandidates);
                if (pivotCandidate != null) {
                    boolean[] zArr = this.mAlreadyTestedCandidates;
                    int i4 = pivotCandidate.f1id;
                    if (!zArr[i4]) {
                        zArr[i4] = true;
                    } else {
                        return;
                    }
                }
                if (pivotCandidate != null) {
                    float f = Float.MAX_VALUE;
                    int i5 = 0;
                    int i6 = -1;
                    while (i5 < this.mNumRows) {
                        ArrayRow arrayRow2 = this.mRows[i5];
                        if (arrayRow2.mVariable.mType != i3 && !arrayRow2.mIsSimpleDefinition) {
                            ArrayLinkedVariables arrayLinkedVariables = arrayRow2.variables;
                            int i7 = arrayLinkedVariables.mHead;
                            if (i7 != -1) {
                                for (int i8 = 0; i7 != -1 && i8 < arrayLinkedVariables.mCurrentSize; i8++) {
                                    if (arrayLinkedVariables.mArrayIndices[i7] == pivotCandidate.f1id) {
                                        z = true;
                                        break;
                                    } else {
                                        i7 = arrayLinkedVariables.mArrayNextIndices[i7];
                                    }
                                }
                            }
                            z = false;
                            if (z) {
                                float f2 = arrayRow2.variables.get(pivotCandidate);
                                if (f2 < 0.0f) {
                                    float f3 = (-arrayRow2.mConstantValue) / f2;
                                    if (f3 < f) {
                                        f = f3;
                                        i6 = i5;
                                    }
                                }
                            }
                        }
                        i5++;
                        i3 = 1;
                    }
                    if (i6 > -1) {
                        ArrayRow arrayRow3 = this.mRows[i6];
                        arrayRow3.mVariable.mDefinitionId = -1;
                        arrayRow3.pivot(pivotCandidate);
                        SolverVariable solverVariable2 = arrayRow3.mVariable;
                        solverVariable2.mDefinitionId = i6;
                        solverVariable2.updateReferencesWithNewDefinition(this, arrayRow3);
                    }
                } else {
                    z2 = true;
                }
            } else {
                return;
            }
        }
    }

    public final void releaseRows() {
        for (int i = 0; i < this.mNumRows; i++) {
            ArrayRow arrayRow = this.mRows[i];
            if (arrayRow != null) {
                ((Pools$SimplePool) this.mCache.matcher).release(arrayRow);
            }
            this.mRows[i] = null;
        }
    }

    public final void reset() {
        MatcherMatchResult matcherMatchResult;
        int i = 0;
        while (true) {
            matcherMatchResult = this.mCache;
            SolverVariable[] solverVariableArr = (SolverVariable[]) matcherMatchResult.groups;
            if (i >= solverVariableArr.length) {
                break;
            }
            SolverVariable solverVariable = solverVariableArr[i];
            if (solverVariable != null) {
                solverVariable.reset();
            }
            i++;
        }
        Pools$SimplePool pools$SimplePool = (Pools$SimplePool) matcherMatchResult.input;
        SolverVariable[] solverVariableArr2 = this.mPoolVariables;
        int i2 = this.mPoolVariablesCount;
        pools$SimplePool.getClass();
        if (i2 > solverVariableArr2.length) {
            i2 = solverVariableArr2.length;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            SolverVariable solverVariable2 = solverVariableArr2[i3];
            int i4 = pools$SimplePool.poolSize;
            Object[] objArr = pools$SimplePool.pool;
            if (i4 < objArr.length) {
                objArr[i4] = solverVariable2;
                pools$SimplePool.poolSize = i4 + 1;
            }
        }
        this.mPoolVariablesCount = 0;
        Arrays.fill((SolverVariable[]) matcherMatchResult.groups, (Object) null);
        this.mVariablesID = 0;
        PriorityGoalRow priorityGoalRow = this.mGoal;
        priorityGoalRow.mNumGoals = 0;
        priorityGoalRow.mConstantValue = 0.0f;
        this.mNumColumns = 1;
        for (int i5 = 0; i5 < this.mNumRows; i5++) {
            ArrayRow arrayRow = this.mRows[i5];
        }
        releaseRows();
        this.mNumRows = 0;
        this.mTempGoal = new ArrayRow(matcherMatchResult);
    }

    public final void addEquality(SolverVariable solverVariable, int i) {
        int i2 = solverVariable.mDefinitionId;
        if (i2 == -1) {
            solverVariable.setFinalValue(this, i);
            for (int i3 = 0; i3 < this.mVariablesID + 1; i3++) {
                SolverVariable solverVariable2 = ((SolverVariable[]) this.mCache.groups)[i3];
            }
        } else if (i2 != -1) {
            ArrayRow arrayRow = this.mRows[i2];
            if (arrayRow.mIsSimpleDefinition) {
                arrayRow.mConstantValue = i;
            } else if (arrayRow.variables.getCurrentSize() == 0) {
                arrayRow.mIsSimpleDefinition = true;
                arrayRow.mConstantValue = i;
            } else {
                ArrayRow createRow = createRow();
                if (i < 0) {
                    createRow.mConstantValue = i * (-1);
                    createRow.variables.put(solverVariable, 1.0f);
                } else {
                    createRow.mConstantValue = i;
                    createRow.variables.put(solverVariable, -1.0f);
                }
                addConstraint(createRow);
            }
        } else {
            ArrayRow createRow2 = createRow();
            createRow2.mVariable = solverVariable;
            float f = i;
            solverVariable.computedValue = f;
            createRow2.mConstantValue = f;
            createRow2.mIsSimpleDefinition = true;
            addConstraint(createRow2);
        }
    }
}
