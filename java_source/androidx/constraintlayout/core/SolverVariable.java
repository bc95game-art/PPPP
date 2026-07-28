package androidx.constraintlayout.core;

import java.util.Arrays;
/* loaded from: classes.dex */
public final class SolverVariable implements Comparable {
    public float computedValue;
    public boolean inGoal;
    public int mType;

    /* renamed from: id */
    public int f1id = -1;
    public int mDefinitionId = -1;
    public int strength = 0;
    public boolean isFinalValue = false;
    public final float[] mStrengthVector = new float[9];
    public final float[] mGoalStrengthVector = new float[9];
    public ArrayRow[] mClientEquations = new ArrayRow[16];
    public int mClientEquationsCount = 0;
    public int usageInRowCount = 0;

    public SolverVariable(int i) {
        this.mType = i;
    }

    public final void addToRow(ArrayRow arrayRow) {
        int i = 0;
        while (true) {
            int i2 = this.mClientEquationsCount;
            if (i >= i2) {
                ArrayRow[] arrayRowArr = this.mClientEquations;
                if (i2 >= arrayRowArr.length) {
                    this.mClientEquations = (ArrayRow[]) Arrays.copyOf(arrayRowArr, arrayRowArr.length * 2);
                }
                ArrayRow[] arrayRowArr2 = this.mClientEquations;
                int i3 = this.mClientEquationsCount;
                arrayRowArr2[i3] = arrayRow;
                this.mClientEquationsCount = i3 + 1;
                return;
            } else if (this.mClientEquations[i] != arrayRow) {
                i++;
            } else {
                return;
            }
        }
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return this.f1id - ((SolverVariable) obj).f1id;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001f, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x000d, code lost:
        if (r1 >= (r0 - 1)) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x000f, code lost:
        r5 = r4.mClientEquations;
        r2 = r1 + 1;
        r5[r1] = r5[r2];
        r1 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0019, code lost:
        r4.mClientEquationsCount--;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void removeFromRow(ArrayRow arrayRow) {
        int i = this.mClientEquationsCount;
        int i2 = 0;
        while (i2 < i) {
            if (this.mClientEquations[i2] == arrayRow) {
                break;
            }
            i2++;
        }
    }

    public final void reset() {
        this.mType = 5;
        this.strength = 0;
        this.f1id = -1;
        this.mDefinitionId = -1;
        this.computedValue = 0.0f;
        this.isFinalValue = false;
        int i = this.mClientEquationsCount;
        for (int i2 = 0; i2 < i; i2++) {
            this.mClientEquations[i2] = null;
        }
        this.mClientEquationsCount = 0;
        this.usageInRowCount = 0;
        this.inGoal = false;
        Arrays.fill(this.mGoalStrengthVector, 0.0f);
    }

    public final void setFinalValue(LinearSystem linearSystem, float f) {
        this.computedValue = f;
        this.isFinalValue = true;
        int i = this.mClientEquationsCount;
        this.mDefinitionId = -1;
        for (int i2 = 0; i2 < i; i2++) {
            this.mClientEquations[i2].updateFromFinalVariable(linearSystem, this, false);
        }
        this.mClientEquationsCount = 0;
    }

    public final String toString() {
        return "" + this.f1id;
    }

    public final void updateReferencesWithNewDefinition(LinearSystem linearSystem, ArrayRow arrayRow) {
        int i = this.mClientEquationsCount;
        for (int i2 = 0; i2 < i; i2++) {
            this.mClientEquations[i2].updateFromRow(linearSystem, arrayRow, false);
        }
        this.mClientEquationsCount = 0;
    }
}
