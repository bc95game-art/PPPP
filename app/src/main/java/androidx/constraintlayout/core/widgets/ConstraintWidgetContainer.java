package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measure;
import androidx.constraintlayout.core.widgets.analyzer.ChainRun;
import androidx.constraintlayout.core.widgets.analyzer.DependencyGraph;
import androidx.constraintlayout.core.widgets.analyzer.Direct;
import androidx.constraintlayout.core.widgets.analyzer.WidgetGroup;
import androidx.constraintlayout.core.widgets.analyzer.WidgetRun;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.io.PrintStream;
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
    */
    public final void layout() {
        int[] iArr;
        ConstraintAnchor constraintAnchor;
        int i;
        ConstraintAnchor constraintAnchor2;
        int i2;
        int i3;
        int i4;
        int i5;
        boolean z;
        boolean z2;
        char c;
        boolean z3;
        int i6;
        int i7;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        ConstraintAnchor constraintAnchor3;
        boolean[] zArr;
        boolean z8;
        int max;
        boolean z9;
        ?? r8;
        int max2;
        boolean z10;
        boolean z11;
        int i8;
        int max3;
        int max4;
        Exception e;
        WeakReference weakReference;
        WeakReference weakReference2;
        WeakReference weakReference3;
        WeakReference weakReference4;
        ConstraintAnchor constraintAnchor4;
        int i9;
        int i10;
        int i11;
        int i12;
        char c2;
        WidgetGroup widgetGroup;
        WidgetGroup widgetGroup2;
        int i13;
        int i14;
        int i15;
        int i16;
        int measureWrap;
        int measureWrap2;
        WidgetGroup widgetGroup3;
        WidgetGroup widgetGroup4;
        int i17;
        boolean z12;
        this.f2mX = 0;
        this.f3mY = 0;
        this.mWidthMeasuredTooSmall = false;
        this.mHeightMeasuredTooSmall = false;
        int size = this.mChildren.size();
        int max5 = Math.max(0, getWidth());
        int max6 = Math.max(0, getHeight());
        int[] iArr2 = this.mListDimensionBehaviors;
        int i18 = iArr2[1];
        int i19 = iArr2[0];
        int i20 = this.mPass;
        ConstraintAnchor constraintAnchor5 = this.mTop;
        ConstraintAnchor constraintAnchor6 = this.mLeft;
        if (i20 != 0 || !Chain.enabled(this.mOptimizationLevel, 1)) {
            iArr = iArr2;
        } else {
            ConstraintLayout.Measurer measurer = this.mMeasurer;
            int i21 = iArr2[0];
            int i22 = iArr2[1];
            resetFinalResolution();
            ArrayList arrayList = this.mChildren;
            int size2 = arrayList.size();
            for (int i23 = 0; i23 < size2; i23++) {
                ((ConstraintWidget) arrayList.get(i23)).resetFinalResolution();
            }
            boolean z13 = this.mIsRtl;
            if (i21 == 1) {
                setFinalHorizontal(0, getWidth());
            } else {
                constraintAnchor6.setFinalValue(0);
                this.f2mX = 0;
            }
            int i24 = 0;
            boolean z14 = false;
            boolean z15 = false;
            while (i24 < size2) {
                int[] iArr3 = iArr2;
                ConstraintWidget constraintWidget = (ConstraintWidget) arrayList.get(i24);
                int i25 = i24;
                if (constraintWidget instanceof Guideline) {
                    Guideline guideline = (Guideline) constraintWidget;
                    z12 = z14;
                    if (guideline.mOrientation == 1) {
                        int i26 = guideline.mRelativeBegin;
                        if (i26 != -1) {
                            guideline.setFinalValue(i26);
                        } else if (guideline.mRelativeEnd != -1 && isResolvedHorizontally()) {
                            guideline.setFinalValue(getWidth() - guideline.mRelativeEnd);
                        } else if (isResolvedHorizontally()) {
                            guideline.setFinalValue((int) ((guideline.mRelativePercent * getWidth()) + 0.5f));
                        }
                        z12 = true;
                    }
                } else {
                    z12 = z14;
                    if ((constraintWidget instanceof Barrier) && ((Barrier) constraintWidget).getOrientation() == 0) {
                        z14 = z12;
                        z15 = true;
                        i24 = i25 + 1;
                        iArr2 = iArr3;
                    }
                }
                z14 = z12;
                i24 = i25 + 1;
                iArr2 = iArr3;
            }
            iArr = iArr2;
            if (z14) {
                for (int i27 = 0; i27 < size2; i27 = i17 + 1) {
                    ConstraintWidget constraintWidget2 = (ConstraintWidget) arrayList.get(i27);
                    if (constraintWidget2 instanceof Guideline) {
                        Guideline guideline2 = (Guideline) constraintWidget2;
                        i17 = i27;
                        if (guideline2.mOrientation == 1) {
                            Direct.horizontalSolvingPass(0, guideline2, measurer, z13);
                        }
                    } else {
                        i17 = i27;
                    }
                }
            }
            Direct.horizontalSolvingPass(0, this, measurer, z13);
            if (z15) {
                for (int i28 = 0; i28 < size2; i28++) {
                    ConstraintWidget constraintWidget3 = (ConstraintWidget) arrayList.get(i28);
                    if (constraintWidget3 instanceof Barrier) {
                        Barrier barrier = (Barrier) constraintWidget3;
                        if (barrier.getOrientation() == 0 && barrier.allSolved()) {
                            Direct.horizontalSolvingPass(1, barrier, measurer, z13);
                        }
                    }
                }
            }
            if (i22 == 1) {
                setFinalVertical(0, getHeight());
            } else {
                constraintAnchor5.setFinalValue(0);
                this.f3mY = 0;
            }
            int i29 = 0;
            boolean z16 = false;
            boolean z17 = false;
            while (i29 < size2) {
                ConstraintWidget constraintWidget4 = (ConstraintWidget) arrayList.get(i29);
                int i30 = i29;
                if (constraintWidget4 instanceof Guideline) {
                    Guideline guideline3 = (Guideline) constraintWidget4;
                    if (guideline3.mOrientation == 0) {
                        int i31 = guideline3.mRelativeBegin;
                        if (i31 != -1) {
                            guideline3.setFinalValue(i31);
                        } else if (guideline3.mRelativeEnd != -1 && isResolvedVertically()) {
                            guideline3.setFinalValue(getHeight() - guideline3.mRelativeEnd);
                        } else if (isResolvedVertically()) {
                            guideline3.setFinalValue((int) ((guideline3.mRelativePercent * getHeight()) + 0.5f));
                        }
                        z16 = true;
                    }
                } else if ((constraintWidget4 instanceof Barrier) && ((Barrier) constraintWidget4).getOrientation() == 1) {
                    z17 = true;
                }
                i29 = i30 + 1;
            }
            if (z16) {
                for (int i32 = 0; i32 < size2; i32++) {
                    ConstraintWidget constraintWidget5 = (ConstraintWidget) arrayList.get(i32);
                    if (constraintWidget5 instanceof Guideline) {
                        Guideline guideline4 = (Guideline) constraintWidget5;
                        if (guideline4.mOrientation == 0) {
                            Direct.verticalSolvingPass(1, guideline4, measurer);
                        }
                    }
                }
            }
            Direct.verticalSolvingPass(0, this, measurer);
            if (z17) {
                for (int i33 = 0; i33 < size2; i33++) {
                    ConstraintWidget constraintWidget6 = (ConstraintWidget) arrayList.get(i33);
                    if (constraintWidget6 instanceof Barrier) {
                        Barrier barrier2 = (Barrier) constraintWidget6;
                        if (barrier2.getOrientation() == 1 && barrier2.allSolved()) {
                            Direct.verticalSolvingPass(1, barrier2, measurer);
                        }
                    }
                }
            }
            for (int i34 = 0; i34 < size2; i34++) {
                ConstraintWidget constraintWidget7 = (ConstraintWidget) arrayList.get(i34);
                if (constraintWidget7.isMeasureRequested() && Direct.canMeasure(constraintWidget7)) {
                    measure(constraintWidget7, measurer, Direct.sMeasure);
                    if (!(constraintWidget7 instanceof Guideline)) {
                        Direct.horizontalSolvingPass(0, constraintWidget7, measurer, z13);
                        Direct.verticalSolvingPass(0, constraintWidget7, measurer);
                    } else if (((Guideline) constraintWidget7).mOrientation == 0) {
                        Direct.verticalSolvingPass(0, constraintWidget7, measurer);
                    } else {
                        Direct.horizontalSolvingPass(0, constraintWidget7, measurer, z13);
                    }
                }
            }
            for (int i35 = 0; i35 < size; i35++) {
                ConstraintWidget constraintWidget8 = (ConstraintWidget) this.mChildren.get(i35);
                if (constraintWidget8.isMeasureRequested() && !(constraintWidget8 instanceof Guideline) && !(constraintWidget8 instanceof Barrier) && !(constraintWidget8 instanceof Flow) && !constraintWidget8.mInVirtualLayout) {
                    int dimensionBehaviour = constraintWidget8.getDimensionBehaviour(0);
                    int dimensionBehaviour2 = constraintWidget8.getDimensionBehaviour(1);
                    if (dimensionBehaviour != 3 || constraintWidget8.mMatchConstraintDefaultWidth == 1 || dimensionBehaviour2 != 3 || constraintWidget8.mMatchConstraintDefaultHeight == 1) {
                        measure(constraintWidget8, this.mMeasurer, new Object());
                    }
                }
            }
        }
        LinearSystem linearSystem = this.mSystem;
        if (size <= 2 || (!(i19 == 2 || i18 == 2) || !Chain.enabled(this.mOptimizationLevel, 1024))) {
            i = size;
            i2 = max6;
            i3 = i18;
            i5 = i19;
            constraintAnchor2 = constraintAnchor5;
            constraintAnchor = constraintAnchor6;
            i4 = max5;
        } else {
            ConstraintLayout.Measurer measurer2 = this.mMeasurer;
            ArrayList arrayList2 = this.mChildren;
            int size3 = arrayList2.size();
            int i36 = 0;
            while (i36 < size3) {
                ConstraintWidget constraintWidget9 = (ConstraintWidget) arrayList2.get(i36);
                int i37 = iArr[0];
                int i38 = iArr[1];
                int i39 = i36;
                int[] iArr4 = constraintWidget9.mListDimensionBehaviors;
                constraintAnchor = constraintAnchor6;
                if (!Direct.validInGroup(i37, i38, iArr4[0], iArr4[1]) || (constraintWidget9 instanceof Flow)) {
                    i9 = max5;
                    i = size;
                    i10 = max6;
                    i11 = i18;
                    i12 = i19;
                    constraintAnchor2 = constraintAnchor5;
                    break;
                }
                i36 = i39 + 1;
                constraintAnchor6 = constraintAnchor;
            }
            constraintAnchor = constraintAnchor6;
            i = size;
            constraintAnchor2 = constraintAnchor5;
            int i40 = 0;
            ArrayList arrayList3 = null;
            ArrayList arrayList4 = null;
            ArrayList arrayList5 = null;
            ArrayList arrayList6 = null;
            ArrayList arrayList7 = null;
            ArrayList arrayList8 = null;
            while (i40 < size3) {
                int i41 = i40;
                ConstraintWidget constraintWidget10 = (ConstraintWidget) arrayList2.get(i40);
                int i42 = max6;
                int i43 = iArr[0];
                int i44 = i18;
                int i45 = iArr[1];
                int i46 = max5;
                int[] iArr5 = constraintWidget10.mListDimensionBehaviors;
                int i47 = i19;
                if (!Direct.validInGroup(i43, i45, iArr5[0], iArr5[1])) {
                    measure(constraintWidget10, measurer2, this.mMeasure);
                }
                boolean z18 = constraintWidget10 instanceof Guideline;
                if (z18) {
                    Guideline guideline5 = (Guideline) constraintWidget10;
                    if (guideline5.mOrientation == 0) {
                        if (arrayList7 == null) {
                            arrayList7 = new ArrayList();
                        }
                        arrayList7.add(guideline5);
                    }
                    if (guideline5.mOrientation == 1) {
                        if (arrayList4 == null) {
                            arrayList4 = new ArrayList();
                        }
                        arrayList4.add(guideline5);
                    }
                }
                if (constraintWidget10 instanceof HelperWidget) {
                    if (constraintWidget10 instanceof Barrier) {
                        Barrier barrier3 = (Barrier) constraintWidget10;
                        if (barrier3.getOrientation() == 0) {
                            if (arrayList5 == null) {
                                arrayList5 = new ArrayList();
                            }
                            arrayList5.add(barrier3);
                        }
                        if (barrier3.getOrientation() == 1) {
                            if (arrayList8 == null) {
                                arrayList8 = new ArrayList();
                            }
                            arrayList8.add(barrier3);
                        }
                    } else {
                        HelperWidget helperWidget = (HelperWidget) constraintWidget10;
                        if (arrayList5 == null) {
                            arrayList5 = new ArrayList();
                        }
                        arrayList5.add(helperWidget);
                        if (arrayList8 == null) {
                            arrayList8 = new ArrayList();
                        }
                        arrayList8.add(helperWidget);
                    }
                }
                if (constraintWidget10.mLeft.mTarget == null && constraintWidget10.mRight.mTarget == null && !z18 && !(constraintWidget10 instanceof Barrier)) {
                    if (arrayList6 == null) {
                        arrayList6 = new ArrayList();
                    }
                    arrayList6.add(constraintWidget10);
                }
                if (constraintWidget10.mTop.mTarget == null && constraintWidget10.mBottom.mTarget == null && constraintWidget10.mBaseline.mTarget == null && !z18 && !(constraintWidget10 instanceof Barrier)) {
                    if (arrayList3 == null) {
                        arrayList3 = new ArrayList();
                    }
                    arrayList3.add(constraintWidget10);
                }
                i40 = i41 + 1;
                max6 = i42;
                i18 = i44;
                max5 = i46;
                i19 = i47;
            }
            i9 = max5;
            i10 = max6;
            i11 = i18;
            i12 = i19;
            ArrayList arrayList9 = new ArrayList();
            if (arrayList4 != null) {
                int size4 = arrayList4.size();
                int i48 = 0;
                while (i48 < size4) {
                    Object obj = arrayList4.get(i48);
                    i48++;
                    Direct.findDependents((Guideline) obj, 0, arrayList9, null);
                }
            }
            if (arrayList5 != null) {
                int size5 = arrayList5.size();
                int i49 = 0;
                while (i49 < size5) {
                    Object obj2 = arrayList5.get(i49);
                    i49++;
                    HelperWidget helperWidget2 = (HelperWidget) obj2;
                    WidgetGroup findDependents = Direct.findDependents(helperWidget2, 0, arrayList9, null);
                    helperWidget2.addDependents(0, findDependents, arrayList9);
                    findDependents.cleanup(arrayList9);
                }
            }
            HashSet hashSet = getAnchor(2).mDependents;
            if (hashSet != null) {
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    Direct.findDependents(((ConstraintAnchor) it.next()).mOwner, 0, arrayList9, null);
                }
            }
            HashSet hashSet2 = getAnchor(4).mDependents;
            if (hashSet2 != null) {
                Iterator it2 = hashSet2.iterator();
                while (it2.hasNext()) {
                    Direct.findDependents(((ConstraintAnchor) it2.next()).mOwner, 0, arrayList9, null);
                }
            }
            HashSet hashSet3 = getAnchor(7).mDependents;
            if (hashSet3 != null) {
                Iterator it3 = hashSet3.iterator();
                while (it3.hasNext()) {
                    Direct.findDependents(((ConstraintAnchor) it3.next()).mOwner, 0, arrayList9, null);
                }
            }
            if (arrayList6 != null) {
                int size6 = arrayList6.size();
                int i50 = 0;
                while (i50 < size6) {
                    Object obj3 = arrayList6.get(i50);
                    i50++;
                    Direct.findDependents((ConstraintWidget) obj3, 0, arrayList9, null);
                }
            }
            if (arrayList7 != null) {
                int size7 = arrayList7.size();
                int i51 = 0;
                while (i51 < size7) {
                    Object obj4 = arrayList7.get(i51);
                    i51++;
                    Direct.findDependents((Guideline) obj4, 1, arrayList9, null);
                }
            }
            if (arrayList8 != null) {
                int size8 = arrayList8.size();
                int i52 = 0;
                while (i52 < size8) {
                    Object obj5 = arrayList8.get(i52);
                    i52++;
                    HelperWidget helperWidget3 = (HelperWidget) obj5;
                    WidgetGroup findDependents2 = Direct.findDependents(helperWidget3, 1, arrayList9, null);
                    helperWidget3.addDependents(1, findDependents2, arrayList9);
                    findDependents2.cleanup(arrayList9);
                }
            }
            HashSet hashSet4 = getAnchor(3).mDependents;
            if (hashSet4 != null) {
                Iterator it4 = hashSet4.iterator();
                while (it4.hasNext()) {
                    Direct.findDependents(((ConstraintAnchor) it4.next()).mOwner, 1, arrayList9, null);
                }
            }
            HashSet hashSet5 = getAnchor(6).mDependents;
            if (hashSet5 != null) {
                Iterator it5 = hashSet5.iterator();
                while (it5.hasNext()) {
                    Direct.findDependents(((ConstraintAnchor) it5.next()).mOwner, 1, arrayList9, null);
                }
            }
            HashSet hashSet6 = getAnchor(5).mDependents;
            if (hashSet6 != null) {
                Iterator it6 = hashSet6.iterator();
                while (it6.hasNext()) {
                    Direct.findDependents(((ConstraintAnchor) it6.next()).mOwner, 1, arrayList9, null);
                }
            }
            HashSet hashSet7 = getAnchor(7).mDependents;
            if (hashSet7 != null) {
                Iterator it7 = hashSet7.iterator();
                while (it7.hasNext()) {
                    Direct.findDependents(((ConstraintAnchor) it7.next()).mOwner, 1, arrayList9, null);
                }
            }
            if (arrayList3 != null) {
                int size9 = arrayList3.size();
                int i53 = 0;
                while (i53 < size9) {
                    Object obj6 = arrayList3.get(i53);
                    i53++;
                    Direct.findDependents((ConstraintWidget) obj6, 1, arrayList9, null);
                }
            }
            char c3 = 1;
            int i54 = 0;
            while (i54 < size3) {
                ConstraintWidget constraintWidget11 = (ConstraintWidget) arrayList2.get(i54);
                int[] iArr6 = constraintWidget11.mListDimensionBehaviors;
                if (iArr6[0] == 3 && iArr6[c3] == 3) {
                    int i55 = constraintWidget11.horizontalGroup;
                    int size10 = arrayList9.size();
                    int i56 = 0;
                    while (true) {
                        if (i56 >= size10) {
                            widgetGroup3 = null;
                            break;
                        }
                        widgetGroup3 = (WidgetGroup) arrayList9.get(i56);
                        if (i55 == widgetGroup3.mId) {
                            break;
                        }
                        i56++;
                    }
                    int i57 = constraintWidget11.verticalGroup;
                    int size11 = arrayList9.size();
                    int i58 = 0;
                    while (true) {
                        if (i58 >= size11) {
                            widgetGroup4 = null;
                            break;
                        }
                        widgetGroup4 = (WidgetGroup) arrayList9.get(i58);
                        if (i57 == widgetGroup4.mId) {
                            break;
                        }
                        i58++;
                    }
                    if (!(widgetGroup3 == null || widgetGroup4 == null)) {
                        widgetGroup3.moveTo(0, widgetGroup4);
                        widgetGroup4.mOrientation = 2;
                        arrayList9.remove(widgetGroup3);
                    }
                }
                i54++;
                c3 = 1;
            }
            if (arrayList9.size() > 1) {
                if (iArr[0] == 2) {
                    int size12 = arrayList9.size();
                    int i59 = 0;
                    int i60 = 0;
                    widgetGroup = null;
                    while (i60 < size12) {
                        Object obj7 = arrayList9.get(i60);
                        i60++;
                        WidgetGroup widgetGroup5 = (WidgetGroup) obj7;
                        if (widgetGroup5.mOrientation != 1 && (measureWrap2 = widgetGroup5.measureWrap(linearSystem, 0)) > i59) {
                            widgetGroup = widgetGroup5;
                            i59 = measureWrap2;
                        }
                    }
                    c2 = 1;
                    if (widgetGroup != null) {
                        setHorizontalDimensionBehaviour(1);
                        setWidth(i59);
                        if (iArr[c2] == 2) {
                            int size13 = arrayList9.size();
                            int i61 = 0;
                            int i62 = 0;
                            widgetGroup2 = null;
                            while (i62 < size13) {
                                Object obj8 = arrayList9.get(i62);
                                i62++;
                                WidgetGroup widgetGroup6 = (WidgetGroup) obj8;
                                if (widgetGroup6.mOrientation != 0 && (measureWrap = widgetGroup6.measureWrap(linearSystem, 1)) > i61) {
                                    widgetGroup2 = widgetGroup6;
                                    i61 = measureWrap;
                                }
                            }
                            if (widgetGroup2 != null) {
                                setVerticalDimensionBehaviour(1);
                                setHeight(i61);
                                if (widgetGroup == null || widgetGroup2 != null) {
                                    i5 = i12;
                                    if (i5 == 2) {
                                        i13 = i9;
                                        if (i13 >= getWidth() || i13 <= 0) {
                                            i14 = getWidth();
                                            i3 = i11;
                                            if (i3 != 2) {
                                                i16 = i10;
                                                if (i16 >= getHeight() || i16 <= 0) {
                                                    i15 = getHeight();
                                                    i2 = i15;
                                                    i4 = i14;
                                                    z = true;
                                                    if (!optimizeFor(64) || optimizeFor(128)) {
                                                        z2 = true;
                                                    } else {
                                                        z2 = false;
                                                    }
                                                    linearSystem.getClass();
                                                    linearSystem.newgraphOptimizer = false;
                                                    if (this.mOptimizationLevel != 0 || !z2) {
                                                        c = 1;
                                                    } else {
                                                        c = 1;
                                                        linearSystem.newgraphOptimizer = true;
                                                    }
                                                    ArrayList arrayList10 = this.mChildren;
                                                    if (iArr[0] != 2 || iArr[c] == 2) {
                                                        z3 = true;
                                                    } else {
                                                        z3 = false;
                                                    }
                                                    this.mHorizontalChainsSize = 0;
                                                    this.mVerticalChainsSize = 0;
                                                    i6 = i;
                                                    for (i7 = 0; i7 < i6; i7++) {
                                                        ConstraintWidget constraintWidget12 = (ConstraintWidget) this.mChildren.get(i7);
                                                        if (constraintWidget12 instanceof ConstraintWidgetContainer) {
                                                            ((ConstraintWidgetContainer) constraintWidget12).layout();
                                                        }
                                                    }
                                                    boolean optimizeFor = optimizeFor(64);
                                                    boolean z19 = z;
                                                    int i63 = 0;
                                                    z4 = true;
                                                    while (z4) {
                                                        int i64 = i63 + 1;
                                                        try {
                                                            linearSystem.reset();
                                                            this.mHorizontalChainsSize = 0;
                                                            this.mVerticalChainsSize = 0;
                                                            createObjectVariables(linearSystem);
                                                            for (int i65 = 0; i65 < i6; i65++) {
                                                                ((ConstraintWidget) this.mChildren.get(i65)).createObjectVariables(linearSystem);
                                                            }
                                                            addChildrenToSolver(linearSystem);
                                                            try {
                                                                weakReference = this.mVerticalWrapMin;
                                                            } catch (Exception e2) {
                                                                e = e2;
                                                                constraintAnchor3 = constraintAnchor2;
                                                                z7 = z3;
                                                            }
                                                        } catch (Exception e3) {
                                                            e = e3;
                                                            constraintAnchor3 = constraintAnchor2;
                                                            z7 = z3;
                                                        }
                                                        if (weakReference != null) {
                                                            try {
                                                            } catch (Exception e4) {
                                                                e = e4;
                                                                constraintAnchor3 = constraintAnchor2;
                                                            }
                                                            if (weakReference.get() != null) {
                                                                constraintAnchor3 = constraintAnchor2;
                                                                try {
                                                                } catch (Exception e5) {
                                                                    e = e5;
                                                                }
                                                                try {
                                                                    z7 = z3;
                                                                } catch (Exception e6) {
                                                                    e = e6;
                                                                    z7 = z3;
                                                                    z4 = true;
                                                                    e.printStackTrace();
                                                                    PrintStream printStream = System.out;
                                                                    z6 = z19;
                                                                    printStream.println("EXCEPTION : " + e);
                                                                    boolean[] zArr2 = Chain.sFlags;
                                                                    if (z4) {
                                                                    }
                                                                    if (z7) {
                                                                    }
                                                                    max = Math.max(this.mMinWidth, getWidth());
                                                                    if (max > getWidth()) {
                                                                    }
                                                                    max2 = Math.max(this.mMinHeight, getHeight());
                                                                    if (max2 > getHeight()) {
                                                                    }
                                                                    if (!z10) {
                                                                    }
                                                                    z11 = z8;
                                                                    if (i64 <= 8) {
                                                                    }
                                                                    z19 = z10;
                                                                    i63 = i64;
                                                                    z3 = z7;
                                                                    constraintAnchor2 = constraintAnchor3;
                                                                }
                                                                try {
                                                                    linearSystem.addGreaterThan(linearSystem.createObjectVariable((ConstraintAnchor) this.mVerticalWrapMin.get()), linearSystem.createObjectVariable(constraintAnchor3), 0, 5);
                                                                    this.mVerticalWrapMin = null;
                                                                    weakReference2 = this.mVerticalWrapMax;
                                                                    if (!(weakReference2 == null || weakReference2.get() == null)) {
                                                                        linearSystem.addGreaterThan(linearSystem.createObjectVariable(this.mBottom), linearSystem.createObjectVariable((ConstraintAnchor) this.mVerticalWrapMax.get()), 0, 5);
                                                                        this.mVerticalWrapMax = null;
                                                                    }
                                                                    weakReference3 = this.mHorizontalWrapMin;
                                                                    if (!(weakReference3 == null || weakReference3.get() == null)) {
                                                                        constraintAnchor4 = constraintAnchor;
                                                                        try {
                                                                            constraintAnchor = constraintAnchor4;
                                                                            linearSystem.addGreaterThan(linearSystem.createObjectVariable((ConstraintAnchor) this.mHorizontalWrapMin.get()), linearSystem.createObjectVariable(constraintAnchor4), 0, 5);
                                                                            this.mHorizontalWrapMin = null;
                                                                        } catch (Exception e7) {
                                                                            e = e7;
                                                                            constraintAnchor = constraintAnchor4;
                                                                            z4 = true;
                                                                            e.printStackTrace();
                                                                            PrintStream printStream2 = System.out;
                                                                            z6 = z19;
                                                                            printStream2.println("EXCEPTION : " + e);
                                                                            boolean[] zArr22 = Chain.sFlags;
                                                                            if (z4) {
                                                                            }
                                                                            if (z7) {
                                                                            }
                                                                            max = Math.max(this.mMinWidth, getWidth());
                                                                            if (max > getWidth()) {
                                                                            }
                                                                            max2 = Math.max(this.mMinHeight, getHeight());
                                                                            if (max2 > getHeight()) {
                                                                            }
                                                                            if (!z10) {
                                                                            }
                                                                            z11 = z8;
                                                                            if (i64 <= 8) {
                                                                            }
                                                                            z19 = z10;
                                                                            i63 = i64;
                                                                            z3 = z7;
                                                                            constraintAnchor2 = constraintAnchor3;
                                                                        }
                                                                    }
                                                                    weakReference4 = this.mHorizontalWrapMax;
                                                                    if (weakReference4 == null && weakReference4.get() != null) {
                                                                        try {
                                                                            try {
                                                                                linearSystem.addGreaterThan(linearSystem.createObjectVariable(this.mRight), linearSystem.createObjectVariable((ConstraintAnchor) this.mHorizontalWrapMax.get()), 0, 5);
                                                                            } catch (Exception e8) {
                                                                                e = e8;
                                                                                z4 = true;
                                                                                e.printStackTrace();
                                                                                PrintStream printStream22 = System.out;
                                                                                z6 = z19;
                                                                                printStream22.println("EXCEPTION : " + e);
                                                                                boolean[] zArr222 = Chain.sFlags;
                                                                                if (z4) {
                                                                                }
                                                                                if (z7) {
                                                                                }
                                                                                max = Math.max(this.mMinWidth, getWidth());
                                                                                if (max > getWidth()) {
                                                                                }
                                                                                max2 = Math.max(this.mMinHeight, getHeight());
                                                                                if (max2 > getHeight()) {
                                                                                }
                                                                                if (!z10) {
                                                                                }
                                                                                z11 = z8;
                                                                                if (i64 <= 8) {
                                                                                }
                                                                                z19 = z10;
                                                                                i63 = i64;
                                                                                z3 = z7;
                                                                                constraintAnchor2 = constraintAnchor3;
                                                                            }
                                                                            try {
                                                                                this.mHorizontalWrapMax = null;
                                                                            } catch (Exception e9) {
                                                                                e = e9;
                                                                                z4 = true;
                                                                                e.printStackTrace();
                                                                                PrintStream printStream222 = System.out;
                                                                                z6 = z19;
                                                                                printStream222.println("EXCEPTION : " + e);
                                                                                boolean[] zArr2222 = Chain.sFlags;
                                                                                if (z4) {
                                                                                }
                                                                                if (z7) {
                                                                                }
                                                                                max = Math.max(this.mMinWidth, getWidth());
                                                                                if (max > getWidth()) {
                                                                                }
                                                                                max2 = Math.max(this.mMinHeight, getHeight());
                                                                                if (max2 > getHeight()) {
                                                                                }
                                                                                if (!z10) {
                                                                                }
                                                                                z11 = z8;
                                                                                if (i64 <= 8) {
                                                                                }
                                                                                z19 = z10;
                                                                                i63 = i64;
                                                                                z3 = z7;
                                                                                constraintAnchor2 = constraintAnchor3;
                                                                            }
                                                                        } catch (Exception e10) {
                                                                            e = e10;
                                                                        }
                                                                    }
                                                                    linearSystem.minimize();
                                                                    z6 = z19;
                                                                    z4 = true;
                                                                } catch (Exception e11) {
                                                                    e = e11;
                                                                    z4 = true;
                                                                    e.printStackTrace();
                                                                    PrintStream printStream2222 = System.out;
                                                                    z6 = z19;
                                                                    printStream2222.println("EXCEPTION : " + e);
                                                                    boolean[] zArr22222 = Chain.sFlags;
                                                                    if (z4) {
                                                                    }
                                                                    if (z7) {
                                                                    }
                                                                    max = Math.max(this.mMinWidth, getWidth());
                                                                    if (max > getWidth()) {
                                                                    }
                                                                    max2 = Math.max(this.mMinHeight, getHeight());
                                                                    if (max2 > getHeight()) {
                                                                    }
                                                                    if (!z10) {
                                                                    }
                                                                    z11 = z8;
                                                                    if (i64 <= 8) {
                                                                    }
                                                                    z19 = z10;
                                                                    i63 = i64;
                                                                    z3 = z7;
                                                                    constraintAnchor2 = constraintAnchor3;
                                                                }
                                                                boolean[] zArr222222 = Chain.sFlags;
                                                                if (z4) {
                                                                    zArr222222[2] = false;
                                                                    boolean optimizeFor2 = optimizeFor(64);
                                                                    updateFromSolver(linearSystem, optimizeFor2);
                                                                    int size14 = this.mChildren.size();
                                                                    int i66 = 0;
                                                                    z8 = false;
                                                                    while (i66 < size14) {
                                                                        ConstraintWidget constraintWidget13 = (ConstraintWidget) this.mChildren.get(i66);
                                                                        constraintWidget13.updateFromSolver(linearSystem, optimizeFor2);
                                                                        boolean[] zArr3 = zArr222222;
                                                                        boolean z20 = optimizeFor2;
                                                                        if (constraintWidget13.mWidthOverride != -1 || constraintWidget13.mHeightOverride != -1) {
                                                                            z8 = true;
                                                                        }
                                                                        i66++;
                                                                        zArr222222 = zArr3;
                                                                        optimizeFor2 = z20;
                                                                    }
                                                                    zArr = zArr222222;
                                                                } else {
                                                                    zArr = zArr222222;
                                                                    updateFromSolver(linearSystem, optimizeFor);
                                                                    for (int i67 = 0; i67 < i6; i67++) {
                                                                        ((ConstraintWidget) this.mChildren.get(i67)).updateFromSolver(linearSystem, optimizeFor);
                                                                    }
                                                                    z8 = false;
                                                                }
                                                                if (z7 && i64 < 8 && zArr[2]) {
                                                                    int i68 = 0;
                                                                    int i69 = 0;
                                                                    for (i8 = 0; i8 < i6; i8++) {
                                                                        ConstraintWidget constraintWidget14 = (ConstraintWidget) this.mChildren.get(i8);
                                                                        i68 = Math.max(i68, constraintWidget14.getWidth() + constraintWidget14.f2mX);
                                                                        i69 = Math.max(i69, constraintWidget14.getHeight() + constraintWidget14.f3mY);
                                                                    }
                                                                    max3 = Math.max(this.mMinWidth, i68);
                                                                    max4 = Math.max(this.mMinHeight, i69);
                                                                    if (i5 == 2 && getWidth() < max3) {
                                                                        setWidth(max3);
                                                                        iArr[0] = 2;
                                                                        z8 = true;
                                                                        z6 = true;
                                                                    }
                                                                    if (i3 == 2 && getHeight() < max4) {
                                                                        setHeight(max4);
                                                                        iArr[1] = 2;
                                                                        z8 = true;
                                                                        z6 = true;
                                                                    }
                                                                }
                                                                max = Math.max(this.mMinWidth, getWidth());
                                                                if (max > getWidth()) {
                                                                    setWidth(max);
                                                                    r8 = 1;
                                                                    iArr[0] = 1;
                                                                    z8 = true;
                                                                    z9 = true;
                                                                } else {
                                                                    r8 = 1;
                                                                    z9 = z6;
                                                                }
                                                                max2 = Math.max(this.mMinHeight, getHeight());
                                                                if (max2 > getHeight()) {
                                                                    setHeight(max2);
                                                                    iArr[r8] = r8;
                                                                    z10 = true;
                                                                    z8 = true;
                                                                } else {
                                                                    z10 = z9;
                                                                }
                                                                if (!z10) {
                                                                    if (iArr[0] == 2 && i4 > 0 && getWidth() > i4) {
                                                                        this.mWidthMeasuredTooSmall = r8;
                                                                        iArr[0] = r8;
                                                                        setWidth(i4);
                                                                        z10 = true;
                                                                        z8 = true;
                                                                    }
                                                                    char c4 = r8 == true ? 1 : 0;
                                                                    char c5 = r8 == true ? 1 : 0;
                                                                    if (iArr[c4] == 2 && i2 > 0 && getHeight() > i2) {
                                                                        this.mHeightMeasuredTooSmall = r8;
                                                                        int i70 = r8 == true ? 1 : 0;
                                                                        char c6 = r8 == true ? 1 : 0;
                                                                        iArr[r8] = i70;
                                                                        setHeight(i2);
                                                                        z10 = true;
                                                                        z11 = true;
                                                                        if (i64 <= 8) {
                                                                            z4 = false;
                                                                        } else {
                                                                            z4 = z11;
                                                                        }
                                                                        z19 = z10;
                                                                        i63 = i64;
                                                                        z3 = z7;
                                                                        constraintAnchor2 = constraintAnchor3;
                                                                    }
                                                                }
                                                                z11 = z8;
                                                                if (i64 <= 8) {
                                                                }
                                                                z19 = z10;
                                                                i63 = i64;
                                                                z3 = z7;
                                                                constraintAnchor2 = constraintAnchor3;
                                                            }
                                                        }
                                                        constraintAnchor3 = constraintAnchor2;
                                                        z7 = z3;
                                                        weakReference2 = this.mVerticalWrapMax;
                                                        if (weakReference2 == null) {
                                                            linearSystem.addGreaterThan(linearSystem.createObjectVariable(this.mBottom), linearSystem.createObjectVariable((ConstraintAnchor) this.mVerticalWrapMax.get()), 0, 5);
                                                            this.mVerticalWrapMax = null;
                                                        }
                                                        weakReference3 = this.mHorizontalWrapMin;
                                                        if (weakReference3 == null) {
                                                            constraintAnchor4 = constraintAnchor;
                                                            constraintAnchor = constraintAnchor4;
                                                            linearSystem.addGreaterThan(linearSystem.createObjectVariable((ConstraintAnchor) this.mHorizontalWrapMin.get()), linearSystem.createObjectVariable(constraintAnchor4), 0, 5);
                                                            this.mHorizontalWrapMin = null;
                                                        }
                                                        weakReference4 = this.mHorizontalWrapMax;
                                                        if (weakReference4 == null) {
                                                        }
                                                        linearSystem.minimize();
                                                        z6 = z19;
                                                        z4 = true;
                                                        boolean[] zArr2222222 = Chain.sFlags;
                                                        if (z4) {
                                                        }
                                                        if (z7) {
                                                            int i682 = 0;
                                                            int i692 = 0;
                                                            while (i8 < i6) {
                                                            }
                                                            max3 = Math.max(this.mMinWidth, i682);
                                                            max4 = Math.max(this.mMinHeight, i692);
                                                            if (i5 == 2) {
                                                                setWidth(max3);
                                                                iArr[0] = 2;
                                                                z8 = true;
                                                                z6 = true;
                                                            }
                                                            if (i3 == 2) {
                                                                setHeight(max4);
                                                                iArr[1] = 2;
                                                                z8 = true;
                                                                z6 = true;
                                                            }
                                                        }
                                                        max = Math.max(this.mMinWidth, getWidth());
                                                        if (max > getWidth()) {
                                                        }
                                                        max2 = Math.max(this.mMinHeight, getHeight());
                                                        if (max2 > getHeight()) {
                                                        }
                                                        if (!z10) {
                                                        }
                                                        z11 = z8;
                                                        if (i64 <= 8) {
                                                        }
                                                        z19 = z10;
                                                        i63 = i64;
                                                        z3 = z7;
                                                        constraintAnchor2 = constraintAnchor3;
                                                    }
                                                    z5 = z19;
                                                    this.mChildren = arrayList10;
                                                    if (z5) {
                                                        iArr[0] = i5;
                                                        iArr[1] = i3;
                                                    }
                                                    resetSolverVariables(linearSystem.mCache);
                                                }
                                                setHeight(i16);
                                                this.mHeightMeasuredTooSmall = true;
                                            } else {
                                                i16 = i10;
                                            }
                                            i15 = i16;
                                            i2 = i15;
                                            i4 = i14;
                                            z = true;
                                            if (!optimizeFor(64)) {
                                            }
                                            z2 = true;
                                            linearSystem.getClass();
                                            linearSystem.newgraphOptimizer = false;
                                            if (this.mOptimizationLevel != 0) {
                                            }
                                            c = 1;
                                            ArrayList arrayList102 = this.mChildren;
                                            if (iArr[0] != 2) {
                                            }
                                            z3 = true;
                                            this.mHorizontalChainsSize = 0;
                                            this.mVerticalChainsSize = 0;
                                            i6 = i;
                                            while (i7 < i6) {
                                            }
                                            boolean optimizeFor3 = optimizeFor(64);
                                            boolean z192 = z;
                                            int i632 = 0;
                                            z4 = true;
                                            while (z4) {
                                            }
                                            z5 = z192;
                                            this.mChildren = arrayList102;
                                            if (z5) {
                                            }
                                            resetSolverVariables(linearSystem.mCache);
                                        }
                                        setWidth(i13);
                                        this.mWidthMeasuredTooSmall = true;
                                    } else {
                                        i13 = i9;
                                    }
                                    i14 = i13;
                                    i3 = i11;
                                    if (i3 != 2) {
                                    }
                                    i15 = i16;
                                    i2 = i15;
                                    i4 = i14;
                                    z = true;
                                    if (!optimizeFor(64)) {
                                    }
                                    z2 = true;
                                    linearSystem.getClass();
                                    linearSystem.newgraphOptimizer = false;
                                    if (this.mOptimizationLevel != 0) {
                                    }
                                    c = 1;
                                    ArrayList arrayList1022 = this.mChildren;
                                    if (iArr[0] != 2) {
                                    }
                                    z3 = true;
                                    this.mHorizontalChainsSize = 0;
                                    this.mVerticalChainsSize = 0;
                                    i6 = i;
                                    while (i7 < i6) {
                                    }
                                    boolean optimizeFor32 = optimizeFor(64);
                                    boolean z1922 = z;
                                    int i6322 = 0;
                                    z4 = true;
                                    while (z4) {
                                    }
                                    z5 = z1922;
                                    this.mChildren = arrayList1022;
                                    if (z5) {
                                    }
                                    resetSolverVariables(linearSystem.mCache);
                                }
                            }
                        }
                        widgetGroup2 = null;
                        if (widgetGroup == null) {
                        }
                        i5 = i12;
                        if (i5 == 2) {
                        }
                        i14 = i13;
                        i3 = i11;
                        if (i3 != 2) {
                        }
                        i15 = i16;
                        i2 = i15;
                        i4 = i14;
                        z = true;
                        if (!optimizeFor(64)) {
                        }
                        z2 = true;
                        linearSystem.getClass();
                        linearSystem.newgraphOptimizer = false;
                        if (this.mOptimizationLevel != 0) {
                        }
                        c = 1;
                        ArrayList arrayList10222 = this.mChildren;
                        if (iArr[0] != 2) {
                        }
                        z3 = true;
                        this.mHorizontalChainsSize = 0;
                        this.mVerticalChainsSize = 0;
                        i6 = i;
                        while (i7 < i6) {
                        }
                        boolean optimizeFor322 = optimizeFor(64);
                        boolean z19222 = z;
                        int i63222 = 0;
                        z4 = true;
                        while (z4) {
                        }
                        z5 = z19222;
                        this.mChildren = arrayList10222;
                        if (z5) {
                        }
                        resetSolverVariables(linearSystem.mCache);
                    }
                } else {
                    c2 = 1;
                }
                widgetGroup = null;
                if (iArr[c2] == 2) {
                }
                widgetGroup2 = null;
                if (widgetGroup == null) {
                }
                i5 = i12;
                if (i5 == 2) {
                }
                i14 = i13;
                i3 = i11;
                if (i3 != 2) {
                }
                i15 = i16;
                i2 = i15;
                i4 = i14;
                z = true;
                if (!optimizeFor(64)) {
                }
                z2 = true;
                linearSystem.getClass();
                linearSystem.newgraphOptimizer = false;
                if (this.mOptimizationLevel != 0) {
                }
                c = 1;
                ArrayList arrayList102222 = this.mChildren;
                if (iArr[0] != 2) {
                }
                z3 = true;
                this.mHorizontalChainsSize = 0;
                this.mVerticalChainsSize = 0;
                i6 = i;
                while (i7 < i6) {
                }
                boolean optimizeFor3222 = optimizeFor(64);
                boolean z192222 = z;
                int i632222 = 0;
                z4 = true;
                while (z4) {
                }
                z5 = z192222;
                this.mChildren = arrayList102222;
                if (z5) {
                }
                resetSolverVariables(linearSystem.mCache);
            }
            i2 = i10;
            i3 = i11;
            i4 = i9;
            i5 = i12;
        }
        z = false;
        if (!optimizeFor(64)) {
        }
        z2 = true;
        linearSystem.getClass();
        linearSystem.newgraphOptimizer = false;
        if (this.mOptimizationLevel != 0) {
        }
        c = 1;
        ArrayList arrayList1022222 = this.mChildren;
        if (iArr[0] != 2) {
        }
        z3 = true;
        this.mHorizontalChainsSize = 0;
        this.mVerticalChainsSize = 0;
        i6 = i;
        while (i7 < i6) {
        }
        boolean optimizeFor32222 = optimizeFor(64);
        boolean z1922222 = z;
        int i6322222 = 0;
        z4 = true;
        while (z4) {
        }
        z5 = z1922222;
        this.mChildren = arrayList1022222;
        if (z5) {
        }
        resetSolverVariables(linearSystem.mCache);
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
