package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.SolverVariable$Type$EnumUnboxingSharedUtility;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.HelperWidget;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class VerticalWidgetRun extends WidgetRun {
    public DependencyNode baseline;
    public BaselineDimensionDependency mBaselineDimension;

    /* JADX WARN: Type inference failed for: r1v120, types: [androidx.constraintlayout.core.widgets.analyzer.BaselineDimensionDependency, androidx.constraintlayout.core.widgets.analyzer.DimensionDependency] */
    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public final void apply() {
        ConstraintWidget constraintWidget;
        ConstraintWidget constraintWidget2;
        ConstraintWidget constraintWidget3;
        ConstraintWidget constraintWidget4;
        DependencyNode dependencyNode = this.baseline;
        ConstraintWidget constraintWidget5 = this.mWidget;
        boolean z = constraintWidget5.measured;
        DimensionDependency dimensionDependency = this.mDimension;
        if (z) {
            dimensionDependency.resolve(constraintWidget5.getHeight());
        }
        boolean z2 = dimensionDependency.resolved;
        ArrayList arrayList = dimensionDependency.mDependencies;
        ArrayList arrayList2 = dimensionDependency.mTargets;
        DependencyNode dependencyNode2 = this.end;
        DependencyNode dependencyNode3 = this.start;
        if (!z2) {
            ConstraintWidget constraintWidget6 = this.mWidget;
            this.mDimensionBehavior = constraintWidget6.mListDimensionBehaviors[1];
            if (constraintWidget6.mHasBaseline) {
                this.mBaselineDimension = new DimensionDependency(this);
            }
            int i = this.mDimensionBehavior;
            if (i != 3) {
                if (i == 4 && (constraintWidget4 = this.mWidget.mParent) != null && constraintWidget4.mListDimensionBehaviors[1] == 1) {
                    int height = (constraintWidget4.getHeight() - this.mWidget.mTop.getMargin()) - this.mWidget.mBottom.getMargin();
                    WidgetRun.addTarget(dependencyNode3, constraintWidget4.mVerticalRun.start, this.mWidget.mTop.getMargin());
                    WidgetRun.addTarget(dependencyNode2, constraintWidget4.mVerticalRun.end, -this.mWidget.mBottom.getMargin());
                    dimensionDependency.resolve(height);
                    return;
                } else if (i == 1) {
                    dimensionDependency.resolve(this.mWidget.getHeight());
                }
            }
        } else if (this.mDimensionBehavior == 4 && (constraintWidget3 = (constraintWidget2 = this.mWidget).mParent) != null && constraintWidget3.mListDimensionBehaviors[1] == 1) {
            WidgetRun.addTarget(dependencyNode3, constraintWidget3.mVerticalRun.start, constraintWidget2.mTop.getMargin());
            WidgetRun.addTarget(dependencyNode2, constraintWidget3.mVerticalRun.end, -this.mWidget.mBottom.getMargin());
            return;
        }
        boolean z3 = dimensionDependency.resolved;
        if (z3) {
            ConstraintWidget constraintWidget7 = this.mWidget;
            if (constraintWidget7.measured) {
                ConstraintAnchor[] constraintAnchorArr = constraintWidget7.mListAnchors;
                ConstraintAnchor constraintAnchor = constraintAnchorArr[2];
                ConstraintAnchor constraintAnchor2 = constraintAnchor.mTarget;
                if (constraintAnchor2 != null && constraintAnchorArr[3].mTarget != null) {
                    if (constraintWidget7.isInVerticalChain()) {
                        dependencyNode3.mMargin = this.mWidget.mListAnchors[2].getMargin();
                        dependencyNode2.mMargin = -this.mWidget.mListAnchors[3].getMargin();
                    } else {
                        DependencyNode target = WidgetRun.getTarget(this.mWidget.mListAnchors[2]);
                        if (target != null) {
                            WidgetRun.addTarget(dependencyNode3, target, this.mWidget.mListAnchors[2].getMargin());
                        }
                        DependencyNode target2 = WidgetRun.getTarget(this.mWidget.mListAnchors[3]);
                        if (target2 != null) {
                            WidgetRun.addTarget(dependencyNode2, target2, -this.mWidget.mListAnchors[3].getMargin());
                        }
                        dependencyNode3.delegateToWidgetRun = true;
                        dependencyNode2.delegateToWidgetRun = true;
                    }
                    ConstraintWidget constraintWidget8 = this.mWidget;
                    if (constraintWidget8.mHasBaseline) {
                        WidgetRun.addTarget(dependencyNode, dependencyNode3, constraintWidget8.mBaselineDistance);
                        return;
                    }
                    return;
                } else if (constraintAnchor2 != null) {
                    DependencyNode target3 = WidgetRun.getTarget(constraintAnchor);
                    if (target3 != null) {
                        WidgetRun.addTarget(dependencyNode3, target3, this.mWidget.mListAnchors[2].getMargin());
                        WidgetRun.addTarget(dependencyNode2, dependencyNode3, dimensionDependency.value);
                        ConstraintWidget constraintWidget9 = this.mWidget;
                        if (constraintWidget9.mHasBaseline) {
                            WidgetRun.addTarget(dependencyNode, dependencyNode3, constraintWidget9.mBaselineDistance);
                            return;
                        }
                        return;
                    }
                    return;
                } else {
                    ConstraintAnchor constraintAnchor3 = constraintAnchorArr[3];
                    if (constraintAnchor3.mTarget != null) {
                        DependencyNode target4 = WidgetRun.getTarget(constraintAnchor3);
                        if (target4 != null) {
                            WidgetRun.addTarget(dependencyNode2, target4, -this.mWidget.mListAnchors[3].getMargin());
                            WidgetRun.addTarget(dependencyNode3, dependencyNode2, -dimensionDependency.value);
                        }
                        ConstraintWidget constraintWidget10 = this.mWidget;
                        if (constraintWidget10.mHasBaseline) {
                            WidgetRun.addTarget(dependencyNode, dependencyNode3, constraintWidget10.mBaselineDistance);
                            return;
                        }
                        return;
                    }
                    ConstraintAnchor constraintAnchor4 = constraintAnchorArr[4];
                    if (constraintAnchor4.mTarget != null) {
                        DependencyNode target5 = WidgetRun.getTarget(constraintAnchor4);
                        if (target5 != null) {
                            WidgetRun.addTarget(dependencyNode, target5, 0);
                            WidgetRun.addTarget(dependencyNode3, dependencyNode, -this.mWidget.mBaselineDistance);
                            WidgetRun.addTarget(dependencyNode2, dependencyNode3, dimensionDependency.value);
                            return;
                        }
                        return;
                    } else if (!(constraintWidget7 instanceof HelperWidget) && constraintWidget7.mParent != null && constraintWidget7.getAnchor(7).mTarget == null) {
                        ConstraintWidget constraintWidget11 = this.mWidget;
                        WidgetRun.addTarget(dependencyNode3, constraintWidget11.mParent.mVerticalRun.start, constraintWidget11.getY());
                        WidgetRun.addTarget(dependencyNode2, dependencyNode3, dimensionDependency.value);
                        ConstraintWidget constraintWidget12 = this.mWidget;
                        if (constraintWidget12.mHasBaseline) {
                            WidgetRun.addTarget(dependencyNode, dependencyNode3, constraintWidget12.mBaselineDistance);
                            return;
                        }
                        return;
                    } else {
                        return;
                    }
                }
            }
        }
        if (z3 || this.mDimensionBehavior != 3) {
            dimensionDependency.addDependency(this);
        } else {
            ConstraintWidget constraintWidget13 = this.mWidget;
            int i2 = constraintWidget13.mMatchConstraintDefaultHeight;
            if (i2 == 2) {
                ConstraintWidget constraintWidget14 = constraintWidget13.mParent;
                if (constraintWidget14 != null) {
                    DimensionDependency dimensionDependency2 = constraintWidget14.mVerticalRun.mDimension;
                    arrayList2.add(dimensionDependency2);
                    dimensionDependency2.mDependencies.add(dimensionDependency);
                    dimensionDependency.delegateToWidgetRun = true;
                    arrayList.add(dependencyNode3);
                    arrayList.add(dependencyNode2);
                }
            } else if (i2 == 3 && !constraintWidget13.isInVerticalChain()) {
                ConstraintWidget constraintWidget15 = this.mWidget;
                if (constraintWidget15.mMatchConstraintDefaultWidth != 3) {
                    DimensionDependency dimensionDependency3 = constraintWidget15.mHorizontalRun.mDimension;
                    arrayList2.add(dimensionDependency3);
                    dimensionDependency3.mDependencies.add(dimensionDependency);
                    dimensionDependency.delegateToWidgetRun = true;
                    arrayList.add(dependencyNode3);
                    arrayList.add(dependencyNode2);
                }
            }
        }
        ConstraintWidget constraintWidget16 = this.mWidget;
        ConstraintAnchor[] constraintAnchorArr2 = constraintWidget16.mListAnchors;
        ConstraintAnchor constraintAnchor5 = constraintAnchorArr2[2];
        ConstraintAnchor constraintAnchor6 = constraintAnchor5.mTarget;
        if (constraintAnchor6 != null && constraintAnchorArr2[3].mTarget != null) {
            if (constraintWidget16.isInVerticalChain()) {
                dependencyNode3.mMargin = this.mWidget.mListAnchors[2].getMargin();
                dependencyNode2.mMargin = -this.mWidget.mListAnchors[3].getMargin();
            } else {
                DependencyNode target6 = WidgetRun.getTarget(this.mWidget.mListAnchors[2]);
                DependencyNode target7 = WidgetRun.getTarget(this.mWidget.mListAnchors[3]);
                if (target6 != null) {
                    target6.addDependency(this);
                }
                if (target7 != null) {
                    target7.addDependency(this);
                }
                this.mRunType = 4;
            }
            if (this.mWidget.mHasBaseline) {
                addTarget(dependencyNode, dependencyNode3, 1, this.mBaselineDimension);
            }
        } else if (constraintAnchor6 != null) {
            DependencyNode target8 = WidgetRun.getTarget(constraintAnchor5);
            if (target8 != null) {
                WidgetRun.addTarget(dependencyNode3, target8, this.mWidget.mListAnchors[2].getMargin());
                addTarget(dependencyNode2, dependencyNode3, 1, dimensionDependency);
                if (this.mWidget.mHasBaseline) {
                    addTarget(dependencyNode, dependencyNode3, 1, this.mBaselineDimension);
                }
                if (this.mDimensionBehavior == 3) {
                    ConstraintWidget constraintWidget17 = this.mWidget;
                    if (constraintWidget17.mDimensionRatio > 0.0f) {
                        HorizontalWidgetRun horizontalWidgetRun = constraintWidget17.mHorizontalRun;
                        if (horizontalWidgetRun.mDimensionBehavior == 3) {
                            horizontalWidgetRun.mDimension.mDependencies.add(dimensionDependency);
                            arrayList2.add(this.mWidget.mHorizontalRun.mDimension);
                            dimensionDependency.updateDelegate = this;
                        }
                    }
                }
            }
        } else {
            ConstraintAnchor constraintAnchor7 = constraintAnchorArr2[3];
            if (constraintAnchor7.mTarget != null) {
                DependencyNode target9 = WidgetRun.getTarget(constraintAnchor7);
                if (target9 != null) {
                    WidgetRun.addTarget(dependencyNode2, target9, -this.mWidget.mListAnchors[3].getMargin());
                    addTarget(dependencyNode3, dependencyNode2, -1, dimensionDependency);
                    if (this.mWidget.mHasBaseline) {
                        addTarget(dependencyNode, dependencyNode3, 1, this.mBaselineDimension);
                    }
                }
            } else {
                ConstraintAnchor constraintAnchor8 = constraintAnchorArr2[4];
                if (constraintAnchor8.mTarget != null) {
                    DependencyNode target10 = WidgetRun.getTarget(constraintAnchor8);
                    if (target10 != null) {
                        WidgetRun.addTarget(dependencyNode, target10, 0);
                        addTarget(dependencyNode3, dependencyNode, -1, this.mBaselineDimension);
                        addTarget(dependencyNode2, dependencyNode3, 1, dimensionDependency);
                    }
                } else if (!(constraintWidget16 instanceof HelperWidget) && (constraintWidget = constraintWidget16.mParent) != null) {
                    WidgetRun.addTarget(dependencyNode3, constraintWidget.mVerticalRun.start, constraintWidget16.getY());
                    addTarget(dependencyNode2, dependencyNode3, 1, dimensionDependency);
                    if (this.mWidget.mHasBaseline) {
                        addTarget(dependencyNode, dependencyNode3, 1, this.mBaselineDimension);
                    }
                    if (this.mDimensionBehavior == 3) {
                        ConstraintWidget constraintWidget18 = this.mWidget;
                        if (constraintWidget18.mDimensionRatio > 0.0f) {
                            HorizontalWidgetRun horizontalWidgetRun2 = constraintWidget18.mHorizontalRun;
                            if (horizontalWidgetRun2.mDimensionBehavior == 3) {
                                horizontalWidgetRun2.mDimension.mDependencies.add(dimensionDependency);
                                arrayList2.add(this.mWidget.mHorizontalRun.mDimension);
                                dimensionDependency.updateDelegate = this;
                            }
                        }
                    }
                }
            }
        }
        if (arrayList2.size() == 0) {
            dimensionDependency.readyToSolve = true;
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public final void applyToWidget() {
        DependencyNode dependencyNode = this.start;
        if (dependencyNode.resolved) {
            this.mWidget.mY = dependencyNode.value;
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public final void clear() {
        this.mRunGroup = null;
        this.start.clear();
        this.end.clear();
        this.baseline.clear();
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
        DependencyNode dependencyNode3 = this.baseline;
        dependencyNode3.clear();
        dependencyNode3.resolved = false;
        this.mDimension.resolved = false;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public final boolean supportsWrapComputation() {
        if (this.mDimensionBehavior != 3 || this.mWidget.mMatchConstraintDefaultHeight == 0) {
            return true;
        }
        return false;
    }

    public final String toString() {
        return "VerticalRun " + this.mWidget.mDebugName;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.Dependency
    public final void update(Dependency dependency) {
        DimensionDependency dimensionDependency;
        int i;
        float f;
        float f2;
        float f3;
        if (SolverVariable$Type$EnumUnboxingSharedUtility.ordinal(this.mRunType) != 3) {
            DimensionDependency dimensionDependency2 = this.mDimension;
            if (dimensionDependency2.readyToSolve && !dimensionDependency2.resolved && this.mDimensionBehavior == 3) {
                ConstraintWidget constraintWidget = this.mWidget;
                int i2 = constraintWidget.mMatchConstraintDefaultHeight;
                if (i2 == 2) {
                    ConstraintWidget constraintWidget2 = constraintWidget.mParent;
                    if (constraintWidget2 != null) {
                        if (constraintWidget2.mVerticalRun.mDimension.resolved) {
                            dimensionDependency2.resolve((int) ((dimensionDependency.value * constraintWidget.mMatchConstraintPercentHeight) + 0.5f));
                        }
                    }
                } else if (i2 == 3) {
                    DimensionDependency dimensionDependency3 = constraintWidget.mHorizontalRun.mDimension;
                    if (dimensionDependency3.resolved) {
                        int i3 = constraintWidget.mDimensionRatioSide;
                        if (i3 == -1) {
                            f = dimensionDependency3.value;
                            f2 = constraintWidget.mDimensionRatio;
                        } else if (i3 == 0) {
                            f3 = dimensionDependency3.value * constraintWidget.mDimensionRatio;
                            i = (int) (f3 + 0.5f);
                            dimensionDependency2.resolve(i);
                        } else if (i3 != 1) {
                            i = 0;
                            dimensionDependency2.resolve(i);
                        } else {
                            f = dimensionDependency3.value;
                            f2 = constraintWidget.mDimensionRatio;
                        }
                        f3 = f / f2;
                        i = (int) (f3 + 0.5f);
                        dimensionDependency2.resolve(i);
                    }
                }
            }
            DependencyNode dependencyNode = this.start;
            boolean z = dependencyNode.readyToSolve;
            ArrayList arrayList = dependencyNode.mTargets;
            if (z) {
                DependencyNode dependencyNode2 = this.end;
                boolean z2 = dependencyNode2.readyToSolve;
                ArrayList arrayList2 = dependencyNode2.mTargets;
                if (z2) {
                    if (!dependencyNode.resolved || !dependencyNode2.resolved || !dimensionDependency2.resolved) {
                        if (!dimensionDependency2.resolved && this.mDimensionBehavior == 3) {
                            ConstraintWidget constraintWidget3 = this.mWidget;
                            if (constraintWidget3.mMatchConstraintDefaultWidth == 0 && !constraintWidget3.isInVerticalChain()) {
                                int i4 = ((DependencyNode) arrayList.get(0)).value + dependencyNode.mMargin;
                                int i5 = ((DependencyNode) arrayList2.get(0)).value + dependencyNode2.mMargin;
                                dependencyNode.resolve(i4);
                                dependencyNode2.resolve(i5);
                                dimensionDependency2.resolve(i5 - i4);
                                return;
                            }
                        }
                        if (!dimensionDependency2.resolved && this.mDimensionBehavior == 3 && this.matchConstraintsType == 1 && arrayList.size() > 0 && arrayList2.size() > 0) {
                            int i6 = (((DependencyNode) arrayList2.get(0)).value + dependencyNode2.mMargin) - (((DependencyNode) arrayList.get(0)).value + dependencyNode.mMargin);
                            int i7 = dimensionDependency2.wrapValue;
                            if (i6 < i7) {
                                dimensionDependency2.resolve(i6);
                            } else {
                                dimensionDependency2.resolve(i7);
                            }
                        }
                        if (dimensionDependency2.resolved && arrayList.size() > 0 && arrayList2.size() > 0) {
                            DependencyNode dependencyNode3 = (DependencyNode) arrayList.get(0);
                            DependencyNode dependencyNode4 = (DependencyNode) arrayList2.get(0);
                            int i8 = dependencyNode3.value;
                            int i9 = dependencyNode.mMargin + i8;
                            int i10 = dependencyNode4.value;
                            int i11 = dependencyNode2.mMargin + i10;
                            float f4 = this.mWidget.mVerticalBiasPercent;
                            if (dependencyNode3 == dependencyNode4) {
                                f4 = 0.5f;
                            } else {
                                i8 = i9;
                                i10 = i11;
                            }
                            dependencyNode.resolve((int) ((((i10 - i8) - dimensionDependency2.value) * f4) + i8 + 0.5f));
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
        ConstraintWidget constraintWidget4 = this.mWidget;
        updateRunCenter(constraintWidget4.mTop, constraintWidget4.mBottom, 1);
    }
}
