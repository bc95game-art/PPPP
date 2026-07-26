package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measure;
import androidx.constraintlayout.core.widgets.analyzer.ChainRun;
import androidx.constraintlayout.core.widgets.analyzer.DependencyGraph;
import androidx.constraintlayout.core.widgets.analyzer.WidgetRun;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.text.MatcherMatchResult;
/* loaded from: classes.dex */
public final class ConstraintWidgetContainer extends ConstraintWidget {
    public final DependencyGraph mDependencyGraph;
    public int mPaddingLeft;
    public int mPaddingTop;
    public int mPass;
    public ArrayList mChildren = new ArrayList();
    public final MatcherMatchResult mBasicMeasureSolver = new MatcherMatchResult(this);
    public ConstraintLayout.Measurer mMeasurer = null;
    public boolean mIsRtl = false;
    public final LinearSystem mSystem = new LinearSystem();
    public int mHorizontalChainsSize = 0;
    public int mVerticalChainsSize = 0;
    public ChainHead[] mVerticalChainsArray = new ChainHead[4];
    public ChainHead[] mHorizontalChainsArray = new ChainHead[4];
    public int mOptimizationLevel = 257;
    public boolean mWidthMeasuredTooSmall = false;
    public boolean mHeightMeasuredTooSmall = false;
    public WeakReference mVerticalWrapMin = null;
    public WeakReference mHorizontalWrapMin = null;
    public WeakReference mVerticalWrapMax = null;
    public WeakReference mHorizontalWrapMax = null;
    public final HashSet mWidgetsToAdd = new HashSet();
    public final BasicMeasure$Measure mMeasure = new Object();

    /* JADX WARN: Type inference failed for: r0v2, types: [androidx.constraintlayout.core.widgets.analyzer.DependencyGraph, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v5, types: [androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measure, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v0, types: [androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measure, java.lang.Object] */
    public ConstraintWidgetContainer() {
        ?? obj = new Object();
        obj.mNeedBuildGraph = true;
        obj.mNeedRedoMeasures = true;
        obj.mRuns = new ArrayList();
        new ArrayList();
        obj.mMeasurer = null;
        obj.mMeasure = new Object();
        obj.mGroups = new ArrayList();
        obj.mWidgetcontainer = this;
        obj.mContainer = this;
        this.mDependencyGraph = obj;
    }

    public static void measure(ConstraintWidget constraintWidget, ConstraintLayout.Measurer measurer, BasicMeasure$Measure basicMeasure$Measure) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        int i;
        int i2;
        if (measurer != null) {
            int i3 = constraintWidget.mVisibility;
            int[] iArr = constraintWidget.mResolvedMatchConstraintDefault;
            if (i3 == 8 || (constraintWidget instanceof Guideline) || (constraintWidget instanceof Barrier)) {
                basicMeasure$Measure.measuredWidth = 0;
                basicMeasure$Measure.measuredHeight = 0;
                return;
            }
            int[] iArr2 = constraintWidget.mListDimensionBehaviors;
            basicMeasure$Measure.horizontalBehavior = iArr2[0];
            basicMeasure$Measure.verticalBehavior = iArr2[1];
            basicMeasure$Measure.horizontalDimension = constraintWidget.getWidth();
            basicMeasure$Measure.verticalDimension = constraintWidget.getHeight();
            basicMeasure$Measure.measuredNeedsSolverPass = false;
            basicMeasure$Measure.measureStrategy = 0;
            if (basicMeasure$Measure.horizontalBehavior == 3) {
                z = true;
            } else {
                z = false;
            }
            if (basicMeasure$Measure.verticalBehavior == 3) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z || constraintWidget.mDimensionRatio <= 0.0f) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (!z2 || constraintWidget.mDimensionRatio <= 0.0f) {
                z4 = false;
            } else {
                z4 = true;
            }
            if (z && constraintWidget.hasDanglingDimension(0) && constraintWidget.mMatchConstraintDefaultWidth == 0 && !z3) {
                basicMeasure$Measure.horizontalBehavior = 2;
                if (z2 && constraintWidget.mMatchConstraintDefaultHeight == 0) {
                    basicMeasure$Measure.horizontalBehavior = 1;
                }
                z = false;
            }
            if (z2 && constraintWidget.hasDanglingDimension(1) && constraintWidget.mMatchConstraintDefaultHeight == 0 && !z4) {
                basicMeasure$Measure.verticalBehavior = 2;
                if (z && constraintWidget.mMatchConstraintDefaultWidth == 0) {
                    basicMeasure$Measure.verticalBehavior = 1;
                }
                z2 = false;
            }
            if (constraintWidget.isResolvedHorizontally()) {
                basicMeasure$Measure.horizontalBehavior = 1;
                z = false;
            }
            if (constraintWidget.isResolvedVertically()) {
                basicMeasure$Measure.verticalBehavior = 1;
                z2 = false;
            }
            if (z3) {
                if (iArr[0] == 4) {
                    basicMeasure$Measure.horizontalBehavior = 1;
                } else if (!z2) {
                    if (basicMeasure$Measure.verticalBehavior == 1) {
                        i2 = basicMeasure$Measure.verticalDimension;
                    } else {
                        basicMeasure$Measure.horizontalBehavior = 2;
                        measurer.measure(constraintWidget, basicMeasure$Measure);
                        i2 = basicMeasure$Measure.measuredHeight;
                    }
                    basicMeasure$Measure.horizontalBehavior = 1;
                    basicMeasure$Measure.horizontalDimension = (int) (constraintWidget.mDimensionRatio * i2);
                }
            }
            if (z4) {
                if (iArr[1] == 4) {
                    basicMeasure$Measure.verticalBehavior = 1;
                } else if (!z) {
                    if (basicMeasure$Measure.horizontalBehavior == 1) {
                        i = basicMeasure$Measure.horizontalDimension;
                    } else {
                        basicMeasure$Measure.verticalBehavior = 2;
                        measurer.measure(constraintWidget, basicMeasure$Measure);
                        i = basicMeasure$Measure.measuredWidth;
                    }
                    basicMeasure$Measure.verticalBehavior = 1;
                    if (constraintWidget.mDimensionRatioSide == -1) {
                        basicMeasure$Measure.verticalDimension = (int) (i / constraintWidget.mDimensionRatio);
                    } else {
                        basicMeasure$Measure.verticalDimension = (int) (constraintWidget.mDimensionRatio * i);
                    }
                }
            }
            measurer.measure(constraintWidget, basicMeasure$Measure);
            constraintWidget.setWidth(basicMeasure$Measure.measuredWidth);
            constraintWidget.setHeight(basicMeasure$Measure.measuredHeight);
            constraintWidget.mHasBaseline = basicMeasure$Measure.measuredHasBaseline;
            constraintWidget.setBaselineDistance(basicMeasure$Measure.measuredBaseline);
            basicMeasure$Measure.measureStrategy = 0;
        }
    }

    public final void addChain(ConstraintWidget constraintWidget, int i) {
        if (i == 0) {
            int i2 = this.mHorizontalChainsSize + 1;
            ChainHead[] chainHeadArr = this.mHorizontalChainsArray;
            if (i2 >= chainHeadArr.length) {
                this.mHorizontalChainsArray = (ChainHead[]) Arrays.copyOf(chainHeadArr, chainHeadArr.length * 2);
            }
            ChainHead[] chainHeadArr2 = this.mHorizontalChainsArray;
            int i3 = this.mHorizontalChainsSize;
            chainHeadArr2[i3] = new ChainHead(constraintWidget, 0, this.mIsRtl);
            this.mHorizontalChainsSize = i3 + 1;
        } else if (i == 1) {
            int i4 = this.mVerticalChainsSize + 1;
            ChainHead[] chainHeadArr3 = this.mVerticalChainsArray;
            if (i4 >= chainHeadArr3.length) {
                this.mVerticalChainsArray = (ChainHead[]) Arrays.copyOf(chainHeadArr3, chainHeadArr3.length * 2);
            }
            ChainHead[] chainHeadArr4 = this.mVerticalChainsArray;
            int i5 = this.mVerticalChainsSize;
            chainHeadArr4[i5] = new ChainHead(constraintWidget, 1, this.mIsRtl);
            this.mVerticalChainsSize = i5 + 1;
        }
    }

    public final void addChildrenToSolver(LinearSystem linearSystem) {
        LinearSystem linearSystem2;
        ConstraintWidgetContainer constraintWidgetContainer;
        int i;
        boolean optimizeFor = optimizeFor(64);
        addToSolver(linearSystem, optimizeFor);
        int size = this.mChildren.size();
        boolean z = false;
        for (int i2 = 0; i2 < size; i2++) {
            ConstraintWidget constraintWidget = (ConstraintWidget) this.mChildren.get(i2);
            boolean[] zArr = constraintWidget.mIsInBarrier;
            zArr[0] = false;
            zArr[1] = false;
            if (constraintWidget instanceof Barrier) {
                z = true;
            }
        }
        if (z) {
            for (int i3 = 0; i3 < size; i3++) {
                ConstraintWidget constraintWidget2 = (ConstraintWidget) this.mChildren.get(i3);
                if (constraintWidget2 instanceof Barrier) {
                    Barrier barrier = (Barrier) constraintWidget2;
                    for (int i4 = 0; i4 < barrier.mWidgetsCount; i4++) {
                        ConstraintWidget constraintWidget3 = barrier.mWidgets[i4];
                        if (barrier.mAllowsGoneWidget || constraintWidget3.allowedInBarrier()) {
                            int i5 = barrier.mBarrierType;
                            if (i5 == 0 || i5 == 1) {
                                constraintWidget3.mIsInBarrier[0] = true;
                            } else if (i5 == 2 || i5 == 3) {
                                constraintWidget3.mIsInBarrier[1] = true;
                            }
                        }
                    }
                }
            }
        }
        HashSet hashSet = this.mWidgetsToAdd;
        hashSet.clear();
        for (int i6 = 0; i6 < size; i6++) {
            ConstraintWidget constraintWidget4 = (ConstraintWidget) this.mChildren.get(i6);
            constraintWidget4.getClass();
            boolean z2 = constraintWidget4 instanceof Flow;
            if (z2 || (constraintWidget4 instanceof Guideline)) {
                if (z2) {
                    hashSet.add(constraintWidget4);
                } else {
                    constraintWidget4.addToSolver(linearSystem, optimizeFor);
                }
            }
        }
        while (hashSet.size() > 0) {
            int size2 = hashSet.size();
            Iterator it = hashSet.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Flow flow = (Flow) ((ConstraintWidget) it.next());
                for (int i7 = 0; i7 < flow.mWidgetsCount; i7++) {
                    if (hashSet.contains(flow.mWidgets[i7])) {
                        flow.addToSolver(linearSystem, optimizeFor);
                        hashSet.remove(flow);
                        break;
                    }
                }
            }
            if (size2 == hashSet.size()) {
                Iterator it2 = hashSet.iterator();
                while (it2.hasNext()) {
                    ((ConstraintWidget) it2.next()).addToSolver(linearSystem, optimizeFor);
                }
                hashSet.clear();
            }
        }
        if (LinearSystem.USE_DEPENDENCY_ORDERING) {
            HashSet hashSet2 = new HashSet();
            for (int i8 = 0; i8 < size; i8++) {
                ConstraintWidget constraintWidget5 = (ConstraintWidget) this.mChildren.get(i8);
                constraintWidget5.getClass();
                if (!(constraintWidget5 instanceof Flow) && !(constraintWidget5 instanceof Guideline)) {
                    hashSet2.add(constraintWidget5);
                }
            }
            if (this.mListDimensionBehaviors[0] == 2) {
                i = 0;
            } else {
                i = 1;
            }
            constraintWidgetContainer = this;
            linearSystem2 = linearSystem;
            constraintWidgetContainer.addChildrenToSolverByDependency(this, linearSystem2, hashSet2, i, false);
            Iterator it3 = hashSet2.iterator();
            while (it3.hasNext()) {
                ConstraintWidget constraintWidget6 = (ConstraintWidget) it3.next();
                Chain.checkMatchParent(this, linearSystem2, constraintWidget6);
                constraintWidget6.addToSolver(linearSystem2, optimizeFor);
            }
        } else {
            constraintWidgetContainer = this;
            linearSystem2 = linearSystem;
            for (int i9 = 0; i9 < size; i9++) {
                ConstraintWidget constraintWidget7 = (ConstraintWidget) constraintWidgetContainer.mChildren.get(i9);
                if (constraintWidget7 instanceof ConstraintWidgetContainer) {
                    int[] iArr = constraintWidget7.mListDimensionBehaviors;
                    int i10 = iArr[0];
                    int i11 = iArr[1];
                    if (i10 == 2) {
                        constraintWidget7.setHorizontalDimensionBehaviour(1);
                    }
                    if (i11 == 2) {
                        constraintWidget7.setVerticalDimensionBehaviour(1);
                    }
                    constraintWidget7.addToSolver(linearSystem2, optimizeFor);
                    if (i10 == 2) {
                        constraintWidget7.setHorizontalDimensionBehaviour(i10);
                    }
                    if (i11 == 2) {
                        constraintWidget7.setVerticalDimensionBehaviour(i11);
                    }
                } else {
                    Chain.checkMatchParent(this, linearSystem2, constraintWidget7);
                    if (!(constraintWidget7 instanceof Flow) && !(constraintWidget7 instanceof Guideline)) {
                        constraintWidget7.addToSolver(linearSystem2, optimizeFor);
                    }
                }
            }
        }
        if (constraintWidgetContainer.mHorizontalChainsSize > 0) {
            Chain.applyChainConstraints(this, linearSystem2, null, 0);
        }
        if (constraintWidgetContainer.mVerticalChainsSize > 0) {
            Chain.applyChainConstraints(this, linearSystem2, null, 1);
        }
    }

    public final boolean directMeasureWithOrientation(int i, boolean z) {
        boolean z2;
        boolean z3;
        boolean z4;
        DependencyGraph dependencyGraph = this.mDependencyGraph;
        ArrayList arrayList = dependencyGraph.mRuns;
        ConstraintWidgetContainer constraintWidgetContainer = dependencyGraph.mWidgetcontainer;
        int dimensionBehaviour = constraintWidgetContainer.getDimensionBehaviour(0);
        int[] iArr = constraintWidgetContainer.mListDimensionBehaviors;
        int dimensionBehaviour2 = constraintWidgetContainer.getDimensionBehaviour(1);
        int x = constraintWidgetContainer.getX();
        int y = constraintWidgetContainer.getY();
        if (z && (dimensionBehaviour == 2 || dimensionBehaviour2 == 2)) {
            int size = arrayList.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    z4 = z;
                    break;
                }
                Object obj = arrayList.get(i2);
                i2++;
                WidgetRun widgetRun = (WidgetRun) obj;
                if (widgetRun.orientation == i && !widgetRun.supportsWrapComputation()) {
                    z4 = false;
                    break;
                }
            }
            if (i == 0) {
                if (z4 && dimensionBehaviour == 2) {
                    constraintWidgetContainer.setHorizontalDimensionBehaviour(1);
                    constraintWidgetContainer.setWidth(dependencyGraph.computeWrap(constraintWidgetContainer, 0));
                    constraintWidgetContainer.mHorizontalRun.mDimension.resolve(constraintWidgetContainer.getWidth());
                }
            } else if (z4 && dimensionBehaviour2 == 2) {
                constraintWidgetContainer.setVerticalDimensionBehaviour(1);
                constraintWidgetContainer.setHeight(dependencyGraph.computeWrap(constraintWidgetContainer, 1));
                constraintWidgetContainer.mVerticalRun.mDimension.resolve(constraintWidgetContainer.getHeight());
            }
        }
        if (i == 0) {
            int i3 = iArr[0];
            if (i3 == 1 || i3 == 4) {
                int width = constraintWidgetContainer.getWidth() + x;
                constraintWidgetContainer.mHorizontalRun.end.resolve(width);
                constraintWidgetContainer.mHorizontalRun.mDimension.resolve(width - x);
                z2 = true;
            }
            z2 = false;
        } else {
            int i4 = iArr[1];
            if (i4 == 1 || i4 == 4) {
                int height = constraintWidgetContainer.getHeight() + y;
                constraintWidgetContainer.mVerticalRun.end.resolve(height);
                constraintWidgetContainer.mVerticalRun.mDimension.resolve(height - y);
                z2 = true;
            }
            z2 = false;
        }
        dependencyGraph.measureWidgets();
        int size2 = arrayList.size();
        int i5 = 0;
        while (i5 < size2) {
            Object obj2 = arrayList.get(i5);
            i5++;
            WidgetRun widgetRun2 = (WidgetRun) obj2;
            if (widgetRun2.orientation == i && (widgetRun2.mWidget != constraintWidgetContainer || widgetRun2.mResolved)) {
                widgetRun2.applyToWidget();
            }
        }
        int size3 = arrayList.size();
        int i6 = 0;
        while (i6 < size3) {
            Object obj3 = arrayList.get(i6);
            i6++;
            WidgetRun widgetRun3 = (WidgetRun) obj3;
            if (widgetRun3.orientation == i && (z2 || widgetRun3.mWidget != constraintWidgetContainer)) {
                if (!widgetRun3.start.resolved || !widgetRun3.end.resolved || (!(widgetRun3 instanceof ChainRun) && !widgetRun3.mDimension.resolved)) {
                    z3 = false;
                    break;
                }
            }
        }
        z3 = true;
        constraintWidgetContainer.setHorizontalDimensionBehaviour(dimensionBehaviour);
        constraintWidgetContainer.setVerticalDimensionBehaviour(dimensionBehaviour2);
        return z3;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public final void getSceneString(StringBuilder sb) {
        sb.append(this.stringId + ":{\n");
        StringBuilder sb2 = new StringBuilder("  actualWidth:");
        sb2.append(this.mWidth);
        sb.append(sb2.toString());
        sb.append("\n");
        sb.append("  actualHeight:" + this.mHeight);
        sb.append("\n");
        ArrayList arrayList = this.mChildren;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((ConstraintWidget) obj).getSceneString(sb);
            sb.append(",\n");
        }
        sb.append("}");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:332:0x05da  */
    /* JADX WARN: Removed duplicated region for block: B:344:0x0607 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:348:0x0618  */
    /* JADX WARN: Removed duplicated region for block: B:354:0x0631  */
    /* JADX WARN: Removed duplicated region for block: B:357:0x0637  */
    /* JADX WARN: Removed duplicated region for block: B:362:0x064d  */
    /* JADX WARN: Removed duplicated region for block: B:368:0x065d  */
    /* JADX WARN: Removed duplicated region for block: B:374:0x0673 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:379:0x0681  */
    /* JADX WARN: Removed duplicated region for block: B:385:0x0692  */
    /* JADX WARN: Removed duplicated region for block: B:391:0x06af  */
    /* JADX WARN: Removed duplicated region for block: B:459:0x07c1  */
    /* JADX WARN: Removed duplicated region for block: B:468:0x0802  */
    /* JADX WARN: Removed duplicated region for block: B:474:0x081f A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:479:0x082c A[LOOP:34: B:478:0x082a->B:479:0x082c, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:491:0x0894  */
    /* JADX WARN: Removed duplicated region for block: B:492:0x08a1  */
    /* JADX WARN: Removed duplicated region for block: B:495:0x08b4  */
    /* JADX WARN: Removed duplicated region for block: B:496:0x08bd  */
    /* JADX WARN: Removed duplicated region for block: B:498:0x08c1  */
    /* JADX WARN: Removed duplicated region for block: B:512:0x08f6  */
    /* JADX WARN: Removed duplicated region for block: B:514:0x08fa  */
    /* JADX WARN: Removed duplicated region for block: B:515:0x08fc  */
    /* JADX WARN: Removed duplicated region for block: B:519:0x090d  */
    /* JADX WARN: Type inference failed for: r6v87, types: [androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measure, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v5, types: [boolean] */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void layout() {
        /*
            Method dump skipped, instructions count: 2331
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.ConstraintWidgetContainer.layout():void");
    }

    public final boolean optimizeFor(int i) {
        if ((this.mOptimizationLevel & i) == i) {
            return true;
        }
        return false;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public final void reset() {
        this.mSystem.reset();
        this.mPaddingLeft = 0;
        this.mPaddingTop = 0;
        this.mChildren.clear();
        super.reset();
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public final void resetSolverVariables(MatcherMatchResult matcherMatchResult) {
        super.resetSolverVariables(matcherMatchResult);
        int size = this.mChildren.size();
        for (int i = 0; i < size; i++) {
            ((ConstraintWidget) this.mChildren.get(i)).resetSolverVariables(matcherMatchResult);
        }
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public final void updateFromRuns(boolean z, boolean z2) {
        super.updateFromRuns(z, z2);
        int size = this.mChildren.size();
        for (int i = 0; i < size; i++) {
            ((ConstraintWidget) this.mChildren.get(i)).updateFromRuns(z, z2);
        }
    }
}
