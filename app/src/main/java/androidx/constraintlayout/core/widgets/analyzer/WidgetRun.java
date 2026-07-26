package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.SolverVariable$Type$EnumUnboxingSharedUtility;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
/* loaded from: classes.dex */
public abstract class WidgetRun implements Dependency {
    public int mDimensionBehavior;
    public RunGroup mRunGroup;
    public ConstraintWidget mWidget;
    public int matchConstraintsType;
    public final DimensionDependency mDimension = new DimensionDependency(this);
    public int orientation = 0;
    public boolean mResolved = false;
    public final DependencyNode start = new DependencyNode(this);
    public final DependencyNode end = new DependencyNode(this);
    public int mRunType = 1;

    public WidgetRun(ConstraintWidget constraintWidget) {
        this.mWidget = constraintWidget;
    }

    public static void addTarget(DependencyNode dependencyNode, DependencyNode dependencyNode2, int i) {
        dependencyNode.mTargets.add(dependencyNode2);
        dependencyNode.mMargin = i;
        dependencyNode2.mDependencies.add(dependencyNode);
    }

    public static DependencyNode getTarget(ConstraintAnchor constraintAnchor) {
        ConstraintAnchor constraintAnchor2 = constraintAnchor.mTarget;
        if (constraintAnchor2 == null) {
            return null;
        }
        ConstraintWidget constraintWidget = constraintAnchor2.mOwner;
        int ordinal = SolverVariable$Type$EnumUnboxingSharedUtility.ordinal(constraintAnchor2.mType);
        if (ordinal == 1) {
            return constraintWidget.mHorizontalRun.start;
        }
        if (ordinal == 2) {
            return constraintWidget.mVerticalRun.start;
        }
        if (ordinal == 3) {
            return constraintWidget.mHorizontalRun.end;
        }
        if (ordinal == 4) {
            return constraintWidget.mVerticalRun.end;
        }
        if (ordinal != 5) {
            return null;
        }
        return constraintWidget.mVerticalRun.baseline;
    }

    public abstract void apply();

    public abstract void applyToWidget();

    public abstract void clear();

    public final int getLimitedDimension(int i, int i2) {
        if (i2 == 0) {
            ConstraintWidget constraintWidget = this.mWidget;
            int i3 = constraintWidget.mMatchConstraintMaxWidth;
            int max = Math.max(constraintWidget.mMatchConstraintMinWidth, i);
            if (i3 > 0) {
                max = Math.min(i3, i);
            }
            if (max != i) {
                return max;
            }
        } else {
            ConstraintWidget constraintWidget2 = this.mWidget;
            int i4 = constraintWidget2.mMatchConstraintMaxHeight;
            int max2 = Math.max(constraintWidget2.mMatchConstraintMinHeight, i);
            if (i4 > 0) {
                max2 = Math.min(i4, i);
            }
            if (max2 != i) {
                return max2;
            }
        }
        return i;
    }

    public long getWrapDimension() {
        DimensionDependency dimensionDependency = this.mDimension;
        if (dimensionDependency.resolved) {
            return dimensionDependency.value;
        }
        return 0L;
    }

    public abstract boolean supportsWrapComputation();

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0051, code lost:
        if (r9.matchConstraintsType == 3) goto L47;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void updateRunCenter(ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i) {
        float f;
        WidgetRun widgetRun;
        float f2;
        int i2;
        DependencyNode target = getTarget(constraintAnchor);
        DependencyNode target2 = getTarget(constraintAnchor2);
        if (target.resolved && target2.resolved) {
            int margin = constraintAnchor.getMargin() + target.value;
            int margin2 = target2.value - constraintAnchor2.getMargin();
            int i3 = margin2 - margin;
            DimensionDependency dimensionDependency = this.mDimension;
            if (!dimensionDependency.resolved && this.mDimensionBehavior == 3) {
                int i4 = this.matchConstraintsType;
                if (i4 == 0) {
                    dimensionDependency.resolve(getLimitedDimension(i3, i));
                } else if (i4 == 1) {
                    dimensionDependency.resolve(Math.min(getLimitedDimension(dimensionDependency.wrapValue, i), i3));
                } else if (i4 == 2) {
                    ConstraintWidget constraintWidget = this.mWidget;
                    ConstraintWidget constraintWidget2 = constraintWidget.mParent;
                    if (constraintWidget2 != null) {
                        if (i == 0) {
                            widgetRun = constraintWidget2.mHorizontalRun;
                        } else {
                            widgetRun = constraintWidget2.mVerticalRun;
                        }
                        DimensionDependency dimensionDependency2 = widgetRun.mDimension;
                        if (dimensionDependency2.resolved) {
                            if (i == 0) {
                                f2 = constraintWidget.mMatchConstraintPercentWidth;
                            } else {
                                f2 = constraintWidget.mMatchConstraintPercentHeight;
                            }
                            dimensionDependency.resolve(getLimitedDimension((int) ((dimensionDependency2.value * f2) + 0.5f), i));
                        }
                    }
                } else if (i4 == 3) {
                    ConstraintWidget constraintWidget3 = this.mWidget;
                    WidgetRun widgetRun2 = constraintWidget3.mHorizontalRun;
                    if (widgetRun2.mDimensionBehavior == 3 && widgetRun2.matchConstraintsType == 3) {
                        VerticalWidgetRun verticalWidgetRun = constraintWidget3.mVerticalRun;
                        if (verticalWidgetRun.mDimensionBehavior == 3) {
                        }
                    }
                    if (i == 0) {
                        widgetRun2 = constraintWidget3.mVerticalRun;
                    }
                    DimensionDependency dimensionDependency3 = widgetRun2.mDimension;
                    if (dimensionDependency3.resolved) {
                        float f3 = constraintWidget3.mDimensionRatio;
                        if (i == 1) {
                            i2 = (int) ((dimensionDependency3.value / f3) + 0.5f);
                        } else {
                            i2 = (int) ((f3 * dimensionDependency3.value) + 0.5f);
                        }
                        dimensionDependency.resolve(i2);
                    }
                }
            }
            if (dimensionDependency.resolved) {
                int i5 = dimensionDependency.value;
                DependencyNode dependencyNode = this.end;
                DependencyNode dependencyNode2 = this.start;
                if (i5 == i3) {
                    dependencyNode2.resolve(margin);
                    dependencyNode.resolve(margin2);
                    return;
                }
                if (i == 0) {
                    f = this.mWidget.mHorizontalBiasPercent;
                } else {
                    f = this.mWidget.mVerticalBiasPercent;
                }
                if (target == target2) {
                    margin = target.value;
                    margin2 = target2.value;
                    f = 0.5f;
                }
                dependencyNode2.resolve((int) ((((margin2 - margin) - i5) * f) + margin + 0.5f));
                dependencyNode.resolve(dependencyNode2.value + dimensionDependency.value);
            }
        }
    }

    public final void addTarget(DependencyNode dependencyNode, DependencyNode dependencyNode2, int i, DimensionDependency dimensionDependency) {
        dependencyNode.mTargets.add(dependencyNode2);
        dependencyNode.mTargets.add(this.mDimension);
        dependencyNode.mMarginFactor = i;
        dependencyNode.mMarginDependency = dimensionDependency;
        dependencyNode2.mDependencies.add(dependencyNode);
        dimensionDependency.mDependencies.add(dependencyNode);
    }

    public static DependencyNode getTarget(ConstraintAnchor constraintAnchor, int i) {
        ConstraintAnchor constraintAnchor2 = constraintAnchor.mTarget;
        if (constraintAnchor2 == null) {
            return null;
        }
        ConstraintWidget constraintWidget = constraintAnchor2.mOwner;
        WidgetRun widgetRun = i == 0 ? constraintWidget.mHorizontalRun : constraintWidget.mVerticalRun;
        int ordinal = SolverVariable$Type$EnumUnboxingSharedUtility.ordinal(constraintAnchor2.mType);
        if (ordinal == 1 || ordinal == 2) {
            return widgetRun.start;
        }
        if (ordinal == 3 || ordinal == 4) {
            return widgetRun.end;
        }
        return null;
    }
}
