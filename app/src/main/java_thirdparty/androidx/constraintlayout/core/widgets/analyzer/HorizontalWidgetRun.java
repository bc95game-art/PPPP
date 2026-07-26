package androidx.constraintlayout.core.widgets.analyzer;

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
            this.mWidget.mX = dependencyNode.value;
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
        To view partially-correct add '--show-bad-code' argument
    */
    public final void update(androidx.constraintlayout.core.widgets.analyzer.Dependency r24) {
        /*
            Method dump skipped, instructions count: 908
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun.update(androidx.constraintlayout.core.widgets.analyzer.Dependency):void");
    }
}
