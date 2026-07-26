package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.SolverVariable$Type$EnumUnboxingSharedUtility;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.HelperWidget;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class HorizontalWidgetRun extends WidgetRun {
    public static final int[] sTempDimensions = new int[2];

    public static void computeInsetRatio(int[] iArr, int i, int i2, int i3, int i4, float f, int i5) {
        int i6 = i2 - i;
        int i7 = i4 - i3;
        if (i5 == -1) {
            int i8 = (int) ((i7 * f) + 0.5f);
            int i9 = (int) ((i6 / f) + 0.5f);
            if (i8 <= i6) {
                iArr[0] = i8;
                iArr[1] = i7;
            } else if (i9 <= i7) {
                iArr[0] = i6;
                iArr[1] = i9;
            }
        } else if (i5 == 0) {
            iArr[0] = (int) ((i7 * f) + 0.5f);
            iArr[1] = i7;
        } else if (i5 == 1) {
            iArr[0] = i6;
            iArr[1] = (int) ((i6 * f) + 0.5f);
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public final void apply() {
        ConstraintWidget constraintWidget;
        ConstraintWidget constraintWidget2;
        ConstraintWidget constraintWidget3;
        int i;
        ConstraintWidget constraintWidget4;
        int i2;
        ConstraintWidget constraintWidget5 = this.mWidget;
        boolean z = constraintWidget5.measured;
        DimensionDependency dimensionDependency = this.mDimension;
        if (z) {
            dimensionDependency.resolve(constraintWidget5.getWidth());
        }
        boolean z2 = dimensionDependency.resolved;
        ArrayList arrayList = dimensionDependency.mDependencies;
        ArrayList arrayList2 = dimensionDependency.mTargets;
        DependencyNode dependencyNode = this.end;
        DependencyNode dependencyNode2 = this.start;
        if (!z2) {
            ConstraintWidget constraintWidget6 = this.mWidget;
            int i3 = constraintWidget6.mListDimensionBehaviors[0];
            this.mDimensionBehavior = i3;
            if (i3 != 3) {
                if (i3 == 4 && (constraintWidget4 = constraintWidget6.mParent) != null && ((i2 = constraintWidget4.mListDimensionBehaviors[0]) == 1 || i2 == 4)) {
                    int width = (constraintWidget4.getWidth() - this.mWidget.mLeft.getMargin()) - this.mWidget.mRight.getMargin();
                    WidgetRun.addTarget(dependencyNode2, constraintWidget4.mHorizontalRun.start, this.mWidget.mLeft.getMargin());
                    WidgetRun.addTarget(dependencyNode, constraintWidget4.mHorizontalRun.end, -this.mWidget.mRight.getMargin());
                    dimensionDependency.resolve(width);
                    return;
                } else if (i3 == 1) {
                    dimensionDependency.resolve(constraintWidget6.getWidth());
                }
            }
        } else if (this.mDimensionBehavior == 4 && (constraintWidget3 = (constraintWidget2 = this.mWidget).mParent) != null && ((i = constraintWidget3.mListDimensionBehaviors[0]) == 1 || i == 4)) {
            WidgetRun.addTarget(dependencyNode2, constraintWidget3.mHorizontalRun.start, constraintWidget2.mLeft.getMargin());
            WidgetRun.addTarget(dependencyNode, constraintWidget3.mHorizontalRun.end, -this.mWidget.mRight.getMargin());
            return;
        }
        if (dimensionDependency.resolved) {
            ConstraintWidget constraintWidget7 = this.mWidget;
            if (constraintWidget7.measured) {
                ConstraintAnchor[] constraintAnchorArr = constraintWidget7.mListAnchors;
                ConstraintAnchor constraintAnchor = constraintAnchorArr[0];
                ConstraintAnchor constraintAnchor2 = constraintAnchor.mTarget;
                if (constraintAnchor2 == null || constraintAnchorArr[1].mTarget == null) {
                    if (constraintAnchor2 != null) {
                        DependencyNode target = WidgetRun.getTarget(constraintAnchor);
                        if (target != null) {
                            WidgetRun.addTarget(dependencyNode2, target, this.mWidget.mListAnchors[0].getMargin());
                            WidgetRun.addTarget(dependencyNode, dependencyNode2, dimensionDependency.value);
                            return;
                        }
                        return;
                    }
                    ConstraintAnchor constraintAnchor3 = constraintAnchorArr[1];
                    if (constraintAnchor3.mTarget != null) {
                        DependencyNode target2 = WidgetRun.getTarget(constraintAnchor3);
                        if (target2 != null) {
                            WidgetRun.addTarget(dependencyNode, target2, -this.mWidget.mListAnchors[1].getMargin());
                            WidgetRun.addTarget(dependencyNode2, dependencyNode, -dimensionDependency.value);
                            return;
                        }
                        return;
                    } else if (!(constraintWidget7 instanceof HelperWidget) && constraintWidget7.mParent != null && constraintWidget7.getAnchor(7).mTarget == null) {
                        ConstraintWidget constraintWidget8 = this.mWidget;
                        WidgetRun.addTarget(dependencyNode2, constraintWidget8.mParent.mHorizontalRun.start, constraintWidget8.getX());
                        WidgetRun.addTarget(dependencyNode, dependencyNode2, dimensionDependency.value);
                        return;
                    } else {
                        return;
                    }
                } else if (constraintWidget7.isInHorizontalChain()) {
                    dependencyNode2.mMargin = this.mWidget.mListAnchors[0].getMargin();
                    dependencyNode.mMargin = -this.mWidget.mListAnchors[1].getMargin();
                    return;
                } else {
                    DependencyNode target3 = WidgetRun.getTarget(this.mWidget.mListAnchors[0]);
                    if (target3 != null) {
                        WidgetRun.addTarget(dependencyNode2, target3, this.mWidget.mListAnchors[0].getMargin());
                    }
                    DependencyNode target4 = WidgetRun.getTarget(this.mWidget.mListAnchors[1]);
                    if (target4 != null) {
                        WidgetRun.addTarget(dependencyNode, target4, -this.mWidget.mListAnchors[1].getMargin());
                    }
                    dependencyNode2.delegateToWidgetRun = true;
                    dependencyNode.delegateToWidgetRun = true;
                    return;
                }
            }
        }
        if (this.mDimensionBehavior == 3) {
            ConstraintWidget constraintWidget9 = this.mWidget;
            int i4 = constraintWidget9.mMatchConstraintDefaultWidth;
            if (i4 == 2) {
                ConstraintWidget constraintWidget10 = constraintWidget9.mParent;
                if (constraintWidget10 != null) {
                    DimensionDependency dimensionDependency2 = constraintWidget10.mVerticalRun.mDimension;
                    arrayList2.add(dimensionDependency2);
                    dimensionDependency2.mDependencies.add(dimensionDependency);
                    dimensionDependency.delegateToWidgetRun = true;
                    arrayList.add(dependencyNode2);
                    arrayList.add(dependencyNode);
                }
            } else if (i4 == 3) {
                if (constraintWidget9.mMatchConstraintDefaultHeight == 3) {
                    dependencyNode2.updateDelegate = this;
                    dependencyNode.updateDelegate = this;
                    VerticalWidgetRun verticalWidgetRun = constraintWidget9.mVerticalRun;
                    verticalWidgetRun.start.updateDelegate = this;
                    verticalWidgetRun.end.updateDelegate = this;
                    dimensionDependency.updateDelegate = this;
                    if (constraintWidget9.isInVerticalChain()) {
                        arrayList2.add(this.mWidget.mVerticalRun.mDimension);
                        this.mWidget.mVerticalRun.mDimension.mDependencies.add(dimensionDependency);
                        VerticalWidgetRun verticalWidgetRun2 = this.mWidget.mVerticalRun;
                        verticalWidgetRun2.mDimension.updateDelegate = this;
                        arrayList2.add(verticalWidgetRun2.start);
                        arrayList2.add(this.mWidget.mVerticalRun.end);
                        this.mWidget.mVerticalRun.start.mDependencies.add(dimensionDependency);
                        this.mWidget.mVerticalRun.end.mDependencies.add(dimensionDependency);
                    } else if (this.mWidget.isInHorizontalChain()) {
                        this.mWidget.mVerticalRun.mDimension.mTargets.add(dimensionDependency);
                        arrayList.add(this.mWidget.mVerticalRun.mDimension);
                    } else {
                        this.mWidget.mVerticalRun.mDimension.mTargets.add(dimensionDependency);
                    }
                } else {
                    DimensionDependency dimensionDependency3 = constraintWidget9.mVerticalRun.mDimension;
                    arrayList2.add(dimensionDependency3);
                    dimensionDependency3.mDependencies.add(dimensionDependency);
                    this.mWidget.mVerticalRun.start.mDependencies.add(dimensionDependency);
                    this.mWidget.mVerticalRun.end.mDependencies.add(dimensionDependency);
                    dimensionDependency.delegateToWidgetRun = true;
                    arrayList.add(dependencyNode2);
                    arrayList.add(dependencyNode);
                    dependencyNode2.mTargets.add(dimensionDependency);
                    dependencyNode.mTargets.add(dimensionDependency);
                }
            }
        }
        ConstraintWidget constraintWidget11 = this.mWidget;
        ConstraintAnchor[] constraintAnchorArr2 = constraintWidget11.mListAnchors;
        ConstraintAnchor constraintAnchor4 = constraintAnchorArr2[0];
        ConstraintAnchor constraintAnchor5 = constraintAnchor4.mTarget;
        if (constraintAnchor5 == null || constraintAnchorArr2[1].mTarget == null) {
            if (constraintAnchor5 != null) {
                DependencyNode target5 = WidgetRun.getTarget(constraintAnchor4);
                if (target5 != null) {
                    WidgetRun.addTarget(dependencyNode2, target5, this.mWidget.mListAnchors[0].getMargin());
                    addTarget(dependencyNode, dependencyNode2, 1, dimensionDependency);
                    return;
                }
                return;
            }
            ConstraintAnchor constraintAnchor6 = constraintAnchorArr2[1];
            if (constraintAnchor6.mTarget != null) {
                DependencyNode target6 = WidgetRun.getTarget(constraintAnchor6);
                if (target6 != null) {
                    WidgetRun.addTarget(dependencyNode, target6, -this.mWidget.mListAnchors[1].getMargin());
                    addTarget(dependencyNode2, dependencyNode, -1, dimensionDependency);
                }
            } else if (!(constraintWidget11 instanceof HelperWidget) && (constraintWidget = constraintWidget11.mParent) != null) {
                WidgetRun.addTarget(dependencyNode2, constraintWidget.mHorizontalRun.start, constraintWidget11.getX());
                addTarget(dependencyNode, dependencyNode2, 1, dimensionDependency);
            }
        } else if (constraintWidget11.isInHorizontalChain()) {
            dependencyNode2.mMargin = this.mWidget.mListAnchors[0].getMargin();
            dependencyNode.mMargin = -this.mWidget.mListAnchors[1].getMargin();
        } else {
            DependencyNode target7 = WidgetRun.getTarget(this.mWidget.mListAnchors[0]);
            DependencyNode target8 = WidgetRun.getTarget(this.mWidget.mListAnchors[1]);
            if (target7 != null) {
                target7.addDependency(this);
            }
            if (target8 != null) {
                target8.addDependency(this);
            }
            this.mRunType = 4;
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public final void applyToWidget() {
        DependencyNode dependencyNode = this.start;
        if (dependencyNode.resolved) {
            this.mWidget.f2mX = dependencyNode.value;
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public final void clear() {
        this.mRunGroup = null;
        this.start.clear();
        this.end.clear();
        this.mDimension.clear();
        this.mResolved = false;
    }

    public final void reset() {
        this.mResolved = false;
        DependencyNode dependencyNode = this.start;
        dependencyNode.clear();
        dependencyNode.resolved = false;
        DependencyNode dependencyNode2 = this.end;
        dependencyNode2.clear();
        dependencyNode2.resolved = false;
        this.mDimension.resolved = false;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public final boolean supportsWrapComputation() {
        if (this.mDimensionBehavior != 3 || this.mWidget.mMatchConstraintDefaultWidth == 0) {
            return true;
        }
        return false;
    }

    public final String toString() {
        return "HorizontalRun " + this.mWidget.mDebugName;
    }

    /* JADX WARN: Code restructure failed: missing block: B:103:0x0246, code lost:
        if (r5 != 1) goto L117;
     */
    /* JADX WARN: Removed duplicated region for block: B:119:0x02b0  */
    /* JADX WARN: Removed duplicated region for block: B:168:? A[RETURN, SYNTHETIC] */
    @Override // androidx.constraintlayout.core.widgets.analyzer.Dependency
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void update(Dependency dependency) {
        float f;
        boolean z;
        DimensionDependency dimensionDependency;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        int i;
        float f2;
        float f3;
        float f4;
        if (SolverVariable$Type$EnumUnboxingSharedUtility.ordinal(this.mRunType) != 3) {
            DimensionDependency dimensionDependency2 = this.mDimension;
            boolean z6 = dimensionDependency2.resolved;
            DependencyNode dependencyNode = this.start;
            DependencyNode dependencyNode2 = this.end;
            if (!z6 && this.mDimensionBehavior == 3) {
                ConstraintWidget constraintWidget = this.mWidget;
                int i2 = constraintWidget.mMatchConstraintDefaultWidth;
                if (i2 == 2) {
                    f = 0.5f;
                    ConstraintWidget constraintWidget2 = constraintWidget.mParent;
                    if (constraintWidget2 != null) {
                        if (constraintWidget2.mHorizontalRun.mDimension.resolved) {
                            dimensionDependency2.resolve((int) ((dimensionDependency.value * constraintWidget.mMatchConstraintPercentWidth) + 0.5f));
                        }
                    }
                } else if (i2 == 3) {
                    int i3 = constraintWidget.mMatchConstraintDefaultHeight;
                    if (i3 == 0 || i3 == 3) {
                        VerticalWidgetRun verticalWidgetRun = constraintWidget.mVerticalRun;
                        DependencyNode dependencyNode3 = verticalWidgetRun.start;
                        DependencyNode dependencyNode4 = verticalWidgetRun.end;
                        if (constraintWidget.mLeft.mTarget != null) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (constraintWidget.mTop.mTarget != null) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (constraintWidget.mRight.mTarget != null) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        if (constraintWidget.mBottom.mTarget != null) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        f = 0.5f;
                        int i4 = constraintWidget.mDimensionRatioSide;
                        if (z2 && z3 && z4 && z5) {
                            float f5 = constraintWidget.mDimensionRatio;
                            boolean z7 = dependencyNode3.resolved;
                            ArrayList arrayList = dependencyNode3.mTargets;
                            int[] iArr = sTempDimensions;
                            if (!z7 || !dependencyNode4.resolved) {
                                if (dependencyNode.resolved && dependencyNode2.resolved) {
                                    if (dependencyNode3.readyToSolve && dependencyNode4.readyToSolve) {
                                        computeInsetRatio(iArr, dependencyNode.value + dependencyNode.mMargin, dependencyNode2.value - dependencyNode2.mMargin, ((DependencyNode) arrayList.get(0)).value + dependencyNode3.mMargin, ((DependencyNode) dependencyNode4.mTargets.get(0)).value - dependencyNode4.mMargin, f5, i4);
                                        dimensionDependency2.resolve(iArr[0]);
                                        this.mWidget.mVerticalRun.mDimension.resolve(iArr[1]);
                                    } else {
                                        return;
                                    }
                                }
                                if (dependencyNode.readyToSolve && dependencyNode2.readyToSolve && dependencyNode3.readyToSolve && dependencyNode4.readyToSolve) {
                                    computeInsetRatio(iArr, ((DependencyNode) dependencyNode.mTargets.get(0)).value + dependencyNode.mMargin, ((DependencyNode) dependencyNode2.mTargets.get(0)).value - dependencyNode2.mMargin, ((DependencyNode) arrayList.get(0)).value + dependencyNode3.mMargin, ((DependencyNode) dependencyNode4.mTargets.get(0)).value - dependencyNode4.mMargin, f5, i4);
                                    dimensionDependency2.resolve(iArr[0]);
                                    this.mWidget.mVerticalRun.mDimension.resolve(iArr[1]);
                                } else {
                                    return;
                                }
                            } else if (dependencyNode.readyToSolve && dependencyNode2.readyToSolve) {
                                computeInsetRatio(iArr, ((DependencyNode) dependencyNode.mTargets.get(0)).value + dependencyNode.mMargin, ((DependencyNode) dependencyNode2.mTargets.get(0)).value - dependencyNode2.mMargin, dependencyNode3.value + dependencyNode3.mMargin, dependencyNode4.value - dependencyNode4.mMargin, f5, i4);
                                dimensionDependency2.resolve(iArr[0]);
                                this.mWidget.mVerticalRun.mDimension.resolve(iArr[1]);
                                return;
                            } else {
                                return;
                            }
                        } else if (!z2 || !z4) {
                            if (z3 && z5) {
                                if (dependencyNode3.readyToSolve && dependencyNode4.readyToSolve) {
                                    float f6 = constraintWidget.mDimensionRatio;
                                    int i5 = ((DependencyNode) dependencyNode3.mTargets.get(0)).value + dependencyNode3.mMargin;
                                    int i6 = ((DependencyNode) dependencyNode4.mTargets.get(0)).value - dependencyNode4.mMargin;
                                    if (i4 != -1) {
                                        if (i4 == 0) {
                                            int limitedDimension = getLimitedDimension(i6 - i5, 1);
                                            int i7 = (int) ((limitedDimension * f6) + 0.5f);
                                            int limitedDimension2 = getLimitedDimension(i7, 0);
                                            if (i7 != limitedDimension2) {
                                                limitedDimension = (int) ((limitedDimension2 / f6) + 0.5f);
                                            }
                                            dimensionDependency2.resolve(limitedDimension2);
                                            this.mWidget.mVerticalRun.mDimension.resolve(limitedDimension);
                                        }
                                    }
                                    int limitedDimension3 = getLimitedDimension(i6 - i5, 1);
                                    int i8 = (int) ((limitedDimension3 / f6) + 0.5f);
                                    int limitedDimension4 = getLimitedDimension(i8, 0);
                                    if (i8 != limitedDimension4) {
                                        limitedDimension3 = (int) ((limitedDimension4 * f6) + 0.5f);
                                    }
                                    dimensionDependency2.resolve(limitedDimension4);
                                    this.mWidget.mVerticalRun.mDimension.resolve(limitedDimension3);
                                } else {
                                    return;
                                }
                            }
                        } else if (dependencyNode.readyToSolve && dependencyNode2.readyToSolve) {
                            float f7 = constraintWidget.mDimensionRatio;
                            int i9 = ((DependencyNode) dependencyNode.mTargets.get(0)).value + dependencyNode.mMargin;
                            int i10 = ((DependencyNode) dependencyNode2.mTargets.get(0)).value - dependencyNode2.mMargin;
                            if (i4 == -1 || i4 == 0) {
                                int limitedDimension5 = getLimitedDimension(i10 - i9, 0);
                                int i11 = (int) ((limitedDimension5 * f7) + 0.5f);
                                int limitedDimension6 = getLimitedDimension(i11, 1);
                                if (i11 != limitedDimension6) {
                                    limitedDimension5 = (int) ((limitedDimension6 / f7) + 0.5f);
                                }
                                dimensionDependency2.resolve(limitedDimension5);
                                this.mWidget.mVerticalRun.mDimension.resolve(limitedDimension6);
                            } else if (i4 == 1) {
                                int limitedDimension7 = getLimitedDimension(i10 - i9, 0);
                                int i12 = (int) ((limitedDimension7 / f7) + 0.5f);
                                int limitedDimension8 = getLimitedDimension(i12, 1);
                                if (i12 != limitedDimension8) {
                                    limitedDimension7 = (int) ((limitedDimension8 * f7) + 0.5f);
                                }
                                dimensionDependency2.resolve(limitedDimension7);
                                this.mWidget.mVerticalRun.mDimension.resolve(limitedDimension8);
                            }
                        } else {
                            return;
                        }
                    } else {
                        int i13 = constraintWidget.mDimensionRatioSide;
                        if (i13 == -1) {
                            f2 = constraintWidget.mVerticalRun.mDimension.value;
                            f3 = constraintWidget.mDimensionRatio;
                        } else if (i13 == 0) {
                            f4 = constraintWidget.mVerticalRun.mDimension.value / constraintWidget.mDimensionRatio;
                            i = (int) (f4 + 0.5f);
                            dimensionDependency2.resolve(i);
                        } else if (i13 != 1) {
                            i = 0;
                            dimensionDependency2.resolve(i);
                        } else {
                            f2 = constraintWidget.mVerticalRun.mDimension.value;
                            f3 = constraintWidget.mDimensionRatio;
                        }
                        f4 = f2 * f3;
                        i = (int) (f4 + 0.5f);
                        dimensionDependency2.resolve(i);
                    }
                }
                z = dependencyNode.readyToSolve;
                ArrayList arrayList2 = dependencyNode.mTargets;
                if (!z) {
                    boolean z8 = dependencyNode2.readyToSolve;
                    ArrayList arrayList3 = dependencyNode2.mTargets;
                    if (z8) {
                        if (!dependencyNode.resolved || !dependencyNode2.resolved || !dimensionDependency2.resolved) {
                            if (!dimensionDependency2.resolved && this.mDimensionBehavior == 3) {
                                ConstraintWidget constraintWidget3 = this.mWidget;
                                if (constraintWidget3.mMatchConstraintDefaultWidth == 0 && !constraintWidget3.isInHorizontalChain()) {
                                    int i14 = ((DependencyNode) arrayList2.get(0)).value + dependencyNode.mMargin;
                                    int i15 = ((DependencyNode) arrayList3.get(0)).value + dependencyNode2.mMargin;
                                    dependencyNode.resolve(i14);
                                    dependencyNode2.resolve(i15);
                                    dimensionDependency2.resolve(i15 - i14);
                                    return;
                                }
                            }
                            if (!dimensionDependency2.resolved && this.mDimensionBehavior == 3 && this.matchConstraintsType == 1 && arrayList2.size() > 0 && arrayList3.size() > 0) {
                                int min = Math.min((((DependencyNode) arrayList3.get(0)).value + dependencyNode2.mMargin) - (((DependencyNode) arrayList2.get(0)).value + dependencyNode.mMargin), dimensionDependency2.wrapValue);
                                ConstraintWidget constraintWidget4 = this.mWidget;
                                int i16 = constraintWidget4.mMatchConstraintMaxWidth;
                                int max = Math.max(constraintWidget4.mMatchConstraintMinWidth, min);
                                if (i16 > 0) {
                                    max = Math.min(i16, max);
                                }
                                dimensionDependency2.resolve(max);
                            }
                            if (dimensionDependency2.resolved) {
                                DependencyNode dependencyNode5 = (DependencyNode) arrayList2.get(0);
                                DependencyNode dependencyNode6 = (DependencyNode) arrayList3.get(0);
                                int i17 = dependencyNode5.value;
                                int i18 = dependencyNode.mMargin + i17;
                                int i19 = dependencyNode6.value;
                                int i20 = dependencyNode2.mMargin + i19;
                                float f8 = this.mWidget.mHorizontalBiasPercent;
                                if (dependencyNode5 == dependencyNode6) {
                                    f8 = 0.5f;
                                } else {
                                    i17 = i18;
                                    i19 = i20;
                                }
                                dependencyNode.resolve((int) ((((i19 - i17) - dimensionDependency2.value) * f8) + i17 + f));
                                dependencyNode2.resolve(dependencyNode.value + dimensionDependency2.value);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            f = 0.5f;
            z = dependencyNode.readyToSolve;
            ArrayList arrayList22 = dependencyNode.mTargets;
            if (!z) {
            }
        } else {
            ConstraintWidget constraintWidget5 = this.mWidget;
            updateRunCenter(constraintWidget5.mLeft, constraintWidget5.mRight, 0);
        }
    }
}
