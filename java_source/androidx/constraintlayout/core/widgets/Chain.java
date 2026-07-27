package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.ArrayRow;
import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.SolverVariable;
import java.util.ArrayList;
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
    */
    public static void applyChainConstraints(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, ArrayList arrayList, int i) {
        int i2;
        ChainHead[] chainHeadArr;
        int i3;
        int i4;
        int i5;
        ConstraintAnchor[] constraintAnchorArr;
        boolean z;
        ConstraintWidget constraintWidget;
        float f;
        boolean z2;
        boolean z3;
        LinearSystem linearSystem2;
        ConstraintWidget constraintWidget2;
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor[] constraintAnchorArr2;
        int i6;
        ConstraintAnchor constraintAnchor2;
        SolverVariable solverVariable;
        SolverVariable solverVariable2;
        ConstraintWidget constraintWidget3;
        SolverVariable solverVariable3;
        SolverVariable solverVariable4;
        ConstraintAnchor constraintAnchor3;
        ConstraintWidget constraintWidget4;
        ConstraintWidget constraintWidget5;
        ConstraintWidget constraintWidget6;
        int i7;
        ConstraintAnchor constraintAnchor4;
        SolverVariable solverVariable5;
        float f2;
        int size;
        int i8;
        ArrayList arrayList2;
        int i9;
        int i10;
        float f3;
        ConstraintWidget constraintWidget7;
        ConstraintWidget constraintWidget8;
        int i11;
        boolean z4;
        int i12;
        int i13;
        ConstraintWidget constraintWidget9;
        ConstraintAnchor constraintAnchor5;
        ConstraintWidget constraintWidget10;
        ConstraintWidgetContainer constraintWidgetContainer2 = constraintWidgetContainer;
        LinearSystem linearSystem3 = linearSystem;
        ArrayList arrayList3 = arrayList;
        if (i == 0) {
            i2 = constraintWidgetContainer2.mHorizontalChainsSize;
            chainHeadArr = constraintWidgetContainer2.mHorizontalChainsArray;
            i3 = 0;
        } else {
            i2 = constraintWidgetContainer2.mVerticalChainsSize;
            chainHeadArr = constraintWidgetContainer2.mVerticalChainsArray;
            i3 = 2;
        }
        int i14 = i2;
        ChainHead[] chainHeadArr2 = chainHeadArr;
        int i15 = 0;
        while (i15 < i14) {
            ChainHead chainHead = chainHeadArr2[i15];
            boolean z5 = chainHead.mDefined;
            ConstraintWidget constraintWidget11 = chainHead.mFirst;
            ConstraintAnchor[] constraintAnchorArr3 = constraintWidget11.mListAnchors;
            int i16 = 3;
            SolverVariable solverVariable6 = null;
            int i17 = 8;
            float f4 = 0.0f;
            if (!z5) {
                int i18 = chainHead.mOrientation;
                int i19 = i18 * 2;
                ConstraintWidget constraintWidget12 = constraintWidget11;
                ConstraintWidget constraintWidget13 = constraintWidget12;
                boolean z6 = false;
                while (!z6) {
                    chainHead.mWidgetsCount++;
                    ConstraintWidget[] constraintWidgetArr = constraintWidget12.mNextChainWidget;
                    ConstraintAnchor[] constraintAnchorArr4 = constraintWidget12.mListAnchors;
                    constraintWidgetArr[i18] = null;
                    constraintWidget12.mListNextMatchConstraintsWidget[i18] = null;
                    if (constraintWidget12.mVisibility != i17) {
                        constraintWidget12.getDimensionBehaviour(i18);
                        constraintAnchorArr4[i19].getMargin();
                        int i20 = i19 + 1;
                        constraintAnchorArr4[i20].getMargin();
                        constraintAnchorArr4[i19].getMargin();
                        constraintAnchorArr4[i20].getMargin();
                        if (chainHead.mFirstVisibleWidget == null) {
                            chainHead.mFirstVisibleWidget = constraintWidget12;
                        }
                        chainHead.mLastVisibleWidget = constraintWidget12;
                        int i21 = constraintWidget12.mListDimensionBehaviors[i18];
                        if (i21 == i16) {
                            int i22 = constraintWidget12.mResolvedMatchConstraintDefault[i18];
                            if (i22 == 0 || i22 == i16 || i22 == 2) {
                                chainHead.mWidgetsMatchCount++;
                                float f5 = constraintWidget12.mWeight[i18];
                                if (f5 > 0.0f) {
                                    i12 = i15;
                                    chainHead.mTotalWeight += f5;
                                } else {
                                    i12 = i15;
                                }
                                i13 = i18;
                                if (constraintWidget12.mVisibility != 8 && i21 == 3 && (i22 == 0 || i22 == 3)) {
                                    if (f5 < 0.0f) {
                                        chainHead.mHasUndefinedWeights = true;
                                    } else {
                                        chainHead.mHasDefinedWeights = true;
                                    }
                                    if (chainHead.mWeightedMatchConstraintsWidgets == null) {
                                        chainHead.mWeightedMatchConstraintsWidgets = new ArrayList();
                                    }
                                    chainHead.mWeightedMatchConstraintsWidgets.add(constraintWidget12);
                                }
                                if (chainHead.mFirstMatchConstraintWidget == null) {
                                    chainHead.mFirstMatchConstraintWidget = constraintWidget12;
                                }
                                ConstraintWidget constraintWidget14 = chainHead.mLastMatchConstraintWidget;
                                if (constraintWidget14 != null) {
                                    constraintWidget14.mListNextMatchConstraintsWidget[i13] = constraintWidget12;
                                }
                                chainHead.mLastMatchConstraintWidget = constraintWidget12;
                            } else {
                                i12 = i15;
                                i13 = i18;
                            }
                            if (i13 == 0) {
                                if (constraintWidget12.mMatchConstraintDefaultWidth == 0 && constraintWidget12.mMatchConstraintMinWidth == 0) {
                                    int i23 = constraintWidget12.mMatchConstraintMaxWidth;
                                }
                            } else if (constraintWidget12.mMatchConstraintDefaultHeight == 0 && constraintWidget12.mMatchConstraintMinHeight == 0) {
                                int i24 = constraintWidget12.mMatchConstraintMaxHeight;
                            }
                            constraintWidget9 = constraintWidget13;
                            if (constraintWidget9 != constraintWidget12) {
                                constraintWidget9.mNextChainWidget[i13] = constraintWidget12;
                            }
                            constraintAnchor5 = constraintAnchorArr4[i19 + 1].mTarget;
                            if (constraintAnchor5 != null) {
                                constraintWidget10 = constraintAnchor5.mOwner;
                                ConstraintAnchor constraintAnchor6 = constraintWidget10.mListAnchors[i19].mTarget;
                                if (constraintAnchor6 != null) {
                                }
                            }
                            constraintWidget10 = null;
                            if (constraintWidget10 != null) {
                                constraintWidget10 = constraintWidget12;
                                z6 = true;
                            }
                            constraintWidget13 = constraintWidget12;
                            i18 = i13;
                            i16 = 3;
                            i17 = 8;
                            constraintWidget12 = constraintWidget10;
                            i15 = i12;
                        }
                    }
                    i12 = i15;
                    i13 = i18;
                    constraintWidget9 = constraintWidget13;
                    if (constraintWidget9 != constraintWidget12) {
                    }
                    constraintAnchor5 = constraintAnchorArr4[i19 + 1].mTarget;
                    if (constraintAnchor5 != null) {
                    }
                    constraintWidget10 = null;
                    if (constraintWidget10 != null) {
                    }
                    constraintWidget13 = constraintWidget12;
                    i18 = i13;
                    i16 = 3;
                    i17 = 8;
                    constraintWidget12 = constraintWidget10;
                    i15 = i12;
                }
                i4 = i15;
                int i25 = i18;
                ConstraintWidget constraintWidget15 = chainHead.mFirstVisibleWidget;
                if (constraintWidget15 != null) {
                    constraintWidget15.mListAnchors[i19].getMargin();
                }
                ConstraintWidget constraintWidget16 = chainHead.mLastVisibleWidget;
                if (constraintWidget16 != null) {
                    constraintWidget16.mListAnchors[i19 + 1].getMargin();
                }
                chainHead.mLast = constraintWidget12;
                if (i25 != 0 || !chainHead.mIsRtl) {
                    chainHead.mHead = constraintWidget11;
                } else {
                    chainHead.mHead = constraintWidget12;
                }
                chainHead.mHasComplexMatchWeights = chainHead.mHasDefinedWeights && chainHead.mHasUndefinedWeights;
            } else {
                i4 = i15;
            }
            chainHead.mDefined = true;
            if (arrayList3 == null || arrayList3.contains(constraintWidget11)) {
                ConstraintWidget constraintWidget17 = chainHead.mLast;
                ConstraintWidget constraintWidget18 = chainHead.mFirstVisibleWidget;
                ConstraintWidget constraintWidget19 = chainHead.mLastVisibleWidget;
                ConstraintWidget constraintWidget20 = chainHead.mHead;
                float f6 = chainHead.mTotalWeight;
                int[] iArr = constraintWidgetContainer2.mListDimensionBehaviors;
                ConstraintAnchor[] constraintAnchorArr5 = constraintWidgetContainer2.mListAnchors;
                boolean z7 = iArr[i] == 2;
                if (i == 0) {
                    int i26 = constraintWidget20.mHorizontalChainStyle;
                    boolean z8 = i26 == 0;
                    constraintAnchorArr = constraintAnchorArr3;
                    boolean z9 = i26 == 1;
                    z = i26 == 2;
                    constraintWidget = constraintWidget11;
                    f = f6;
                    z3 = z9;
                    z2 = z8;
                } else {
                    constraintAnchorArr = constraintAnchorArr3;
                    int i27 = constraintWidget20.mVerticalChainStyle;
                    boolean z10 = i27 == 0;
                    boolean z11 = i27 == 1;
                    z = i27 == 2;
                    constraintWidget = constraintWidget11;
                    f = f6;
                    z2 = z10;
                    z3 = z11;
                }
                boolean z12 = false;
                while (!z12) {
                    ConstraintAnchor[] constraintAnchorArr6 = constraintWidget.mListAnchors;
                    int[] iArr2 = constraintWidget.mListDimensionBehaviors;
                    ConstraintAnchor constraintAnchor7 = constraintAnchorArr6[i3];
                    int i28 = z ? 1 : 4;
                    int margin = constraintAnchor7.getMargin();
                    boolean z13 = z7;
                    boolean z14 = z;
                    boolean z15 = iArr2[i] == 3 && constraintWidget.mResolvedMatchConstraintDefault[i] == 0;
                    ConstraintAnchor constraintAnchor8 = constraintAnchor7.mTarget;
                    if (!(constraintAnchor8 == null || constraintWidget == constraintWidget11)) {
                        margin = constraintAnchor8.getMargin() + margin;
                    }
                    int i29 = margin;
                    if (!(!z14 || constraintWidget == constraintWidget11 || constraintWidget == constraintWidget18)) {
                        i28 = 8;
                    }
                    constraintWidget11 = constraintWidget11;
                    ConstraintAnchor constraintAnchor9 = constraintAnchor7.mTarget;
                    if (constraintAnchor9 != null) {
                        if (constraintWidget == constraintWidget18) {
                            z4 = z15;
                            linearSystem3.addGreaterThan(constraintAnchor7.mSolverVariable, constraintAnchor9.mSolverVariable, i29, 6);
                        } else {
                            z4 = z15;
                            linearSystem3.addGreaterThan(constraintAnchor7.mSolverVariable, constraintAnchor9.mSolverVariable, i29, 8);
                        }
                        if (z4 && !z14) {
                            i28 = 5;
                        }
                        linearSystem3.addEquality(constraintAnchor7.mSolverVariable, constraintAnchor7.mTarget.mSolverVariable, i29, (constraintWidget != constraintWidget18 || !z14 || !constraintWidget.mIsInBarrier[i]) ? i28 : 5);
                    }
                    if (z13) {
                        if (constraintWidget.mVisibility == 8 || iArr2[i] != 3) {
                            i11 = 0;
                        } else {
                            i11 = 0;
                            linearSystem3.addGreaterThan(constraintAnchorArr6[i3 + 1].mSolverVariable, constraintAnchorArr6[i3].mSolverVariable, 0, 5);
                        }
                        linearSystem3.addGreaterThan(constraintAnchorArr6[i3].mSolverVariable, constraintAnchorArr5[i3].mSolverVariable, i11, 8);
                    }
                    ConstraintAnchor constraintAnchor10 = constraintAnchorArr6[i3 + 1].mTarget;
                    if (constraintAnchor10 != null) {
                        constraintWidget8 = constraintAnchor10.mOwner;
                        ConstraintAnchor constraintAnchor11 = constraintWidget8.mListAnchors[i3].mTarget;
                        if (constraintAnchor11 != null) {
                        }
                    }
                    constraintWidget8 = null;
                    if (constraintWidget8 != null) {
                        constraintWidget = constraintWidget8;
                    } else {
                        z12 = true;
                    }
                    z7 = z13;
                    z = z14;
                }
                boolean z16 = z7;
                boolean z17 = z;
                if (constraintWidget19 != null) {
                    int i30 = i3 + 1;
                    if (constraintWidget17.mListAnchors[i30].mTarget != null) {
                        ConstraintAnchor constraintAnchor12 = constraintWidget19.mListAnchors[i30];
                        if (constraintWidget19.mListDimensionBehaviors[i] == 3 && constraintWidget19.mResolvedMatchConstraintDefault[i] == 0 && !z17) {
                            ConstraintAnchor constraintAnchor13 = constraintAnchor12.mTarget;
                            if (constraintAnchor13.mOwner == constraintWidgetContainer2) {
                                linearSystem3.addEquality(constraintAnchor12.mSolverVariable, constraintAnchor13.mSolverVariable, -constraintAnchor12.getMargin(), 5);
                                linearSystem3.addLowerThan(constraintAnchor12.mSolverVariable, constraintWidget17.mListAnchors[i30].mTarget.mSolverVariable, -constraintAnchor12.getMargin(), 6);
                            }
                        }
                        if (z17) {
                            ConstraintAnchor constraintAnchor14 = constraintAnchor12.mTarget;
                            if (constraintAnchor14.mOwner == constraintWidgetContainer2) {
                                linearSystem3.addEquality(constraintAnchor12.mSolverVariable, constraintAnchor14.mSolverVariable, -constraintAnchor12.getMargin(), 4);
                            }
                        }
                        linearSystem3.addLowerThan(constraintAnchor12.mSolverVariable, constraintWidget17.mListAnchors[i30].mTarget.mSolverVariable, -constraintAnchor12.getMargin(), 6);
                    }
                }
                if (z16) {
                    int i31 = i3 + 1;
                    SolverVariable solverVariable7 = constraintAnchorArr5[i31].mSolverVariable;
                    ConstraintAnchor constraintAnchor15 = constraintWidget17.mListAnchors[i31];
                    linearSystem3.addGreaterThan(solverVariable7, constraintAnchor15.mSolverVariable, constraintAnchor15.getMargin(), 8);
                }
                ArrayList arrayList4 = chainHead.mWeightedMatchConstraintsWidgets;
                if (arrayList4 != null && (size = arrayList4.size()) > 1) {
                    if (chainHead.mHasUndefinedWeights && !chainHead.mHasComplexMatchWeights) {
                        f = chainHead.mWidgetsMatchCount;
                    }
                    ConstraintWidget constraintWidget21 = null;
                    int i32 = 0;
                    float f7 = 0.0f;
                    while (i32 < size) {
                        ConstraintWidget constraintWidget22 = (ConstraintWidget) arrayList4.get(i32);
                        float[] fArr = constraintWidget22.mWeight;
                        ConstraintAnchor[] constraintAnchorArr7 = constraintWidget22.mListAnchors;
                        float f8 = fArr[i];
                        if (f8 < f4) {
                            if (chainHead.mHasComplexMatchWeights) {
                                arrayList2 = arrayList4;
                                i8 = size;
                                linearSystem3.addEquality(constraintAnchorArr7[i3 + 1].mSolverVariable, constraintAnchorArr7[i3].mSolverVariable, 0, 4);
                                f3 = f7;
                                i9 = i32;
                                f7 = f3;
                                i10 = i14;
                                i32 = i9 + 1;
                                i14 = i10;
                                arrayList4 = arrayList2;
                                size = i8;
                            } else {
                                f8 = 1.0f;
                            }
                        }
                        arrayList2 = arrayList4;
                        i8 = size;
                        int i33 = (f8 > f4 ? 1 : (f8 == f4 ? 0 : -1));
                        if (i33 == 0) {
                            f3 = f7;
                            linearSystem3.addEquality(constraintAnchorArr7[i3 + 1].mSolverVariable, constraintAnchorArr7[i3].mSolverVariable, 0, 8);
                            i9 = i32;
                            f7 = f3;
                            i10 = i14;
                            i32 = i9 + 1;
                            i14 = i10;
                            arrayList4 = arrayList2;
                            size = i8;
                        } else {
                            float f9 = f7;
                            if (constraintWidget21 != null) {
                                ConstraintAnchor[] constraintAnchorArr8 = constraintWidget21.mListAnchors;
                                SolverVariable solverVariable8 = constraintAnchorArr8[i3].mSolverVariable;
                                int i34 = i3 + 1;
                                SolverVariable solverVariable9 = constraintAnchorArr8[i34].mSolverVariable;
                                SolverVariable solverVariable10 = constraintAnchorArr7[i3].mSolverVariable;
                                SolverVariable solverVariable11 = constraintAnchorArr7[i34].mSolverVariable;
                                ArrayRow createRow = linearSystem3.createRow();
                                constraintWidget7 = constraintWidget22;
                                createRow.mConstantValue = 0.0f;
                                f4 = 0.0f;
                                if (f == 0.0f || f9 == f8) {
                                    i9 = i32;
                                    i10 = i14;
                                    createRow.variables.put(solverVariable8, 1.0f);
                                    createRow.variables.put(solverVariable9, -1.0f);
                                    createRow.variables.put(solverVariable11, 1.0f);
                                    createRow.variables.put(solverVariable10, -1.0f);
                                } else {
                                    if (f9 == 0.0f) {
                                        createRow.variables.put(solverVariable8, 1.0f);
                                        createRow.variables.put(solverVariable9, -1.0f);
                                    } else if (i33 == 0) {
                                        createRow.variables.put(solverVariable10, 1.0f);
                                        createRow.variables.put(solverVariable11, -1.0f);
                                    } else {
                                        i9 = i32;
                                        float f10 = (f9 / f) / (f8 / f);
                                        i10 = i14;
                                        createRow.variables.put(solverVariable8, 1.0f);
                                        createRow.variables.put(solverVariable9, -1.0f);
                                        createRow.variables.put(solverVariable11, f10);
                                        createRow.variables.put(solverVariable10, -f10);
                                    }
                                    i9 = i32;
                                    i10 = i14;
                                }
                                linearSystem3.addConstraint(createRow);
                            } else {
                                constraintWidget7 = constraintWidget22;
                                i9 = i32;
                                i10 = i14;
                            }
                            f7 = f8;
                            constraintWidget21 = constraintWidget7;
                            i32 = i9 + 1;
                            i14 = i10;
                            arrayList4 = arrayList2;
                            size = i8;
                        }
                    }
                }
                i5 = i14;
                if (constraintWidget18 == null || (constraintWidget18 != constraintWidget19 && !z17)) {
                    constraintWidget2 = constraintWidget19;
                    if (!z2 || constraintWidget18 == null) {
                        int i35 = 8;
                        if (z3 && constraintWidget18 != null) {
                            int i36 = chainHead.mWidgetsMatchCount;
                            boolean z18 = i36 > 0 && chainHead.mWidgetsCount == i36;
                            ConstraintWidget constraintWidget23 = constraintWidget18;
                            ConstraintWidget constraintWidget24 = constraintWidget23;
                            while (constraintWidget24 != null) {
                                ConstraintAnchor[] constraintAnchorArr9 = constraintWidget24.mListAnchors;
                                ConstraintWidget constraintWidget25 = constraintWidget24.mNextChainWidget[i];
                                while (constraintWidget25 != null && constraintWidget25.mVisibility == i35) {
                                    constraintWidget25 = constraintWidget25.mNextChainWidget[i];
                                }
                                if (constraintWidget24 == constraintWidget18 || constraintWidget24 == constraintWidget2 || constraintWidget25 == null) {
                                    constraintWidget3 = constraintWidget23;
                                } else {
                                    if (constraintWidget25 == constraintWidget2) {
                                        constraintWidget25 = null;
                                    }
                                    ConstraintAnchor constraintAnchor16 = constraintAnchorArr9[i3];
                                    SolverVariable solverVariable12 = constraintAnchor16.mSolverVariable;
                                    int i37 = i3 + 1;
                                    SolverVariable solverVariable13 = constraintWidget23.mListAnchors[i37].mSolverVariable;
                                    int margin2 = constraintAnchor16.getMargin();
                                    int margin3 = constraintAnchorArr9[i37].getMargin();
                                    if (constraintWidget25 != null) {
                                        constraintAnchor3 = constraintWidget25.mListAnchors[i3];
                                        solverVariable4 = constraintAnchor3.mSolverVariable;
                                        ConstraintAnchor constraintAnchor17 = constraintAnchor3.mTarget;
                                        solverVariable3 = constraintAnchor17 != null ? constraintAnchor17.mSolverVariable : null;
                                    } else {
                                        ConstraintAnchor constraintAnchor18 = constraintWidget2.mListAnchors[i3];
                                        SolverVariable solverVariable14 = constraintAnchor18 != null ? constraintAnchor18.mSolverVariable : null;
                                        solverVariable3 = constraintAnchorArr9[i37].mSolverVariable;
                                        solverVariable4 = solverVariable14;
                                        constraintAnchor3 = constraintAnchor18;
                                    }
                                    if (constraintAnchor3 != null) {
                                        margin3 += constraintAnchor3.getMargin();
                                    }
                                    int margin4 = margin2 + constraintWidget23.mListAnchors[i37].getMargin();
                                    ConstraintWidget constraintWidget26 = constraintWidget25;
                                    SolverVariable solverVariable15 = solverVariable4;
                                    int i38 = z18 ? 8 : 4;
                                    if (solverVariable12 == null || solverVariable13 == null || solverVariable15 == null || solverVariable3 == null) {
                                        constraintWidget3 = constraintWidget23;
                                        constraintWidget4 = constraintWidget26;
                                    } else {
                                        constraintWidget4 = constraintWidget26;
                                        SolverVariable solverVariable16 = solverVariable3;
                                        constraintWidget3 = constraintWidget23;
                                        linearSystem.addCentering(solverVariable12, solverVariable13, margin4, 0.5f, solverVariable15, solverVariable16, margin3, i38);
                                    }
                                    constraintWidget25 = constraintWidget4;
                                }
                                if (constraintWidget24.mVisibility != 8) {
                                    constraintWidget3 = constraintWidget24;
                                }
                                constraintWidget24 = constraintWidget25;
                                constraintWidget23 = constraintWidget3;
                                i35 = 8;
                            }
                            linearSystem2 = linearSystem;
                            ConstraintAnchor constraintAnchor19 = constraintWidget18.mListAnchors[i3];
                            ConstraintAnchor constraintAnchor20 = constraintAnchorArr[i3].mTarget;
                            int i39 = i3 + 1;
                            ConstraintAnchor constraintAnchor21 = constraintWidget2.mListAnchors[i39];
                            ConstraintAnchor constraintAnchor22 = constraintWidget17.mListAnchors[i39].mTarget;
                            if (constraintAnchor20 != null) {
                                if (constraintWidget18 != constraintWidget2) {
                                    linearSystem2.addEquality(constraintAnchor19.mSolverVariable, constraintAnchor20.mSolverVariable, constraintAnchor19.getMargin(), 5);
                                } else if (constraintAnchor22 != null) {
                                    linearSystem2.addCentering(constraintAnchor19.mSolverVariable, constraintAnchor20.mSolverVariable, constraintAnchor19.getMargin(), 0.5f, constraintAnchor21.mSolverVariable, constraintAnchor22.mSolverVariable, constraintAnchor21.getMargin(), 5);
                                }
                            }
                            if (!(constraintAnchor22 == null || constraintWidget18 == constraintWidget2)) {
                                linearSystem2.addEquality(constraintAnchor21.mSolverVariable, constraintAnchor22.mSolverVariable, -constraintAnchor21.getMargin(), 5);
                            }
                            if (!((z2 && !z3) || constraintWidget18 == null || constraintWidget18 == constraintWidget2)) {
                                ConstraintAnchor[] constraintAnchorArr10 = constraintWidget18.mListAnchors;
                                constraintAnchor = constraintAnchorArr10[i3];
                                if (constraintWidget2 == null) {
                                    constraintWidget2 = constraintWidget18;
                                }
                                constraintAnchorArr2 = constraintWidget2.mListAnchors;
                                i6 = i3 + 1;
                                constraintAnchor2 = constraintAnchorArr2[i6];
                                ConstraintAnchor constraintAnchor23 = constraintAnchor.mTarget;
                                solverVariable = constraintAnchor23 == null ? constraintAnchor23.mSolverVariable : null;
                                ConstraintAnchor constraintAnchor24 = constraintAnchor2.mTarget;
                                solverVariable2 = constraintAnchor24 == null ? constraintAnchor24.mSolverVariable : null;
                                if (constraintWidget17 != constraintWidget2) {
                                    ConstraintAnchor constraintAnchor25 = constraintWidget17.mListAnchors[i6].mTarget;
                                    if (constraintAnchor25 != null) {
                                        solverVariable6 = constraintAnchor25.mSolverVariable;
                                    }
                                    solverVariable2 = solverVariable6;
                                }
                                if (constraintWidget18 == constraintWidget2) {
                                    constraintAnchor2 = constraintAnchorArr10[i6];
                                }
                                if (solverVariable != null && solverVariable2 != null) {
                                    linearSystem2.addCentering(constraintAnchor.mSolverVariable, solverVariable, constraintAnchor.getMargin(), 0.5f, solverVariable2, constraintAnchor2.mSolverVariable, constraintAnchorArr2[i6].getMargin(), 5);
                                }
                            }
                        }
                    } else {
                        int i40 = chainHead.mWidgetsMatchCount;
                        boolean z19 = i40 > 0 && chainHead.mWidgetsCount == i40;
                        ConstraintWidget constraintWidget27 = constraintWidget18;
                        ConstraintWidget constraintWidget28 = constraintWidget27;
                        while (constraintWidget27 != null) {
                            ConstraintAnchor[] constraintAnchorArr11 = constraintWidget27.mListAnchors;
                            ConstraintWidget constraintWidget29 = constraintWidget27.mNextChainWidget[i];
                            while (constraintWidget29 != null && constraintWidget29.mVisibility == 8) {
                                constraintWidget29 = constraintWidget29.mNextChainWidget[i];
                            }
                            if (constraintWidget29 != null || constraintWidget27 == constraintWidget2) {
                                ConstraintAnchor constraintAnchor26 = constraintAnchorArr11[i3];
                                SolverVariable solverVariable17 = constraintAnchor26.mSolverVariable;
                                ConstraintAnchor constraintAnchor27 = constraintAnchor26.mTarget;
                                SolverVariable solverVariable18 = constraintAnchor27 != null ? constraintAnchor27.mSolverVariable : null;
                                if (constraintWidget28 != constraintWidget27) {
                                    solverVariable18 = constraintWidget28.mListAnchors[i3 + 1].mSolverVariable;
                                } else if (constraintWidget27 == constraintWidget18) {
                                    ConstraintAnchor constraintAnchor28 = constraintAnchorArr[i3].mTarget;
                                    solverVariable18 = constraintAnchor28 != null ? constraintAnchor28.mSolverVariable : null;
                                }
                                int margin5 = constraintAnchor26.getMargin();
                                int i41 = i3 + 1;
                                int margin6 = constraintAnchorArr11[i41].getMargin();
                                if (constraintWidget29 != null) {
                                    constraintAnchor4 = constraintWidget29.mListAnchors[i3];
                                    solverVariable5 = constraintAnchor4.mSolverVariable;
                                } else {
                                    constraintAnchor4 = constraintWidget17.mListAnchors[i41].mTarget;
                                    solverVariable5 = constraintAnchor4 != null ? constraintAnchor4.mSolverVariable : null;
                                }
                                SolverVariable solverVariable19 = constraintAnchorArr11[i41].mSolverVariable;
                                if (constraintAnchor4 != null) {
                                    margin6 += constraintAnchor4.getMargin();
                                }
                                int margin7 = constraintWidget28.mListAnchors[i41].getMargin() + margin5;
                                if (!(solverVariable17 == null || solverVariable18 == null || solverVariable5 == null || solverVariable19 == null)) {
                                    if (constraintWidget27 == constraintWidget18) {
                                        margin7 = constraintWidget18.mListAnchors[i3].getMargin();
                                    }
                                    if (constraintWidget27 == constraintWidget2) {
                                        margin6 = constraintWidget2.mListAnchors[i41].getMargin();
                                    }
                                    constraintWidget6 = constraintWidget29;
                                    constraintWidget5 = constraintWidget28;
                                    i7 = 8;
                                    linearSystem.addCentering(solverVariable17, solverVariable18, margin7, 0.5f, solverVariable5, solverVariable19, margin6, z19 ? 8 : 5);
                                    if (constraintWidget27.mVisibility == i7) {
                                        constraintWidget5 = constraintWidget27;
                                    }
                                    constraintWidget27 = constraintWidget6;
                                    constraintWidget28 = constraintWidget5;
                                }
                            }
                            constraintWidget6 = constraintWidget29;
                            constraintWidget5 = constraintWidget28;
                            i7 = 8;
                            if (constraintWidget27.mVisibility == i7) {
                            }
                            constraintWidget27 = constraintWidget6;
                            constraintWidget28 = constraintWidget5;
                        }
                    }
                } else {
                    ConstraintAnchor constraintAnchor29 = constraintAnchorArr[i3];
                    int i42 = i3 + 1;
                    ConstraintAnchor constraintAnchor30 = constraintWidget17.mListAnchors[i42];
                    ConstraintAnchor constraintAnchor31 = constraintAnchor29.mTarget;
                    SolverVariable solverVariable20 = constraintAnchor31 != null ? constraintAnchor31.mSolverVariable : null;
                    ConstraintAnchor constraintAnchor32 = constraintAnchor30.mTarget;
                    SolverVariable solverVariable21 = constraintAnchor32 != null ? constraintAnchor32.mSolverVariable : null;
                    ConstraintAnchor constraintAnchor33 = constraintWidget18.mListAnchors[i3];
                    if (constraintWidget19 != null) {
                        constraintAnchor30 = constraintWidget19.mListAnchors[i42];
                    }
                    if (solverVariable20 == null || solverVariable21 == null) {
                        constraintWidget2 = constraintWidget19;
                    } else {
                        if (i == 0) {
                            f2 = constraintWidget20.mHorizontalBiasPercent;
                        } else {
                            f2 = constraintWidget20.mVerticalBiasPercent;
                        }
                        float f11 = f2;
                        int margin8 = constraintAnchor33.getMargin();
                        int margin9 = constraintAnchor30.getMargin();
                        SolverVariable solverVariable22 = constraintAnchor33.mSolverVariable;
                        SolverVariable solverVariable23 = constraintAnchor30.mSolverVariable;
                        SolverVariable solverVariable24 = solverVariable20;
                        constraintWidget2 = constraintWidget19;
                        linearSystem3.addCentering(solverVariable22, solverVariable24, margin8, f11, solverVariable21, solverVariable23, margin9, 7);
                    }
                }
                linearSystem2 = linearSystem;
                if (z2) {
                }
                ConstraintAnchor[] constraintAnchorArr102 = constraintWidget18.mListAnchors;
                constraintAnchor = constraintAnchorArr102[i3];
                if (constraintWidget2 == null) {
                }
                constraintAnchorArr2 = constraintWidget2.mListAnchors;
                i6 = i3 + 1;
                constraintAnchor2 = constraintAnchorArr2[i6];
                ConstraintAnchor constraintAnchor232 = constraintAnchor.mTarget;
                if (constraintAnchor232 == null) {
                }
                ConstraintAnchor constraintAnchor242 = constraintAnchor2.mTarget;
                if (constraintAnchor242 == null) {
                }
                if (constraintWidget17 != constraintWidget2) {
                }
                if (constraintWidget18 == constraintWidget2) {
                }
                if (solverVariable != null) {
                    linearSystem2.addCentering(constraintAnchor.mSolverVariable, solverVariable, constraintAnchor.getMargin(), 0.5f, solverVariable2, constraintAnchor2.mSolverVariable, constraintAnchorArr2[i6].getMargin(), 5);
                }
            } else {
                i5 = i14;
            }
            i15 = i4 + 1;
            constraintWidgetContainer2 = constraintWidgetContainer;
            linearSystem3 = linearSystem;
            arrayList3 = arrayList;
            i14 = i5;
        }
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
            constraintWidget.f2mX = i;
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
            constraintWidget.f3mY = i4;
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
