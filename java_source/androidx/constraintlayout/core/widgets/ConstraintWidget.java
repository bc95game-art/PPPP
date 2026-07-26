package androidx.constraintlayout.core.widgets;

import android.view.View;
import androidx.constraintlayout.core.ArrayRow;
import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.SolverVariable$Type$EnumUnboxingSharedUtility;
import androidx.constraintlayout.core.widgets.analyzer.ChainRun;
import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun;
import androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun;
import androidx.constraintlayout.core.widgets.analyzer.WidgetRun;
import androidx.lifecycle.ViewModelProvider;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.text.MatcherMatchResult;
/* loaded from: classes.dex */
public class ConstraintWidget {
    public ChainRun horizontalChainRun;
    public final ArrayList mAnchors;
    public final ConstraintAnchor mBaseline;
    public final ConstraintAnchor mBottom;
    public final ConstraintAnchor mCenter;
    public final ConstraintAnchor mCenterX;
    public final ConstraintAnchor mCenterY;
    public View mCompanionWidget;
    public final ConstraintAnchor mLeft;
    public final ConstraintAnchor[] mListAnchors;
    public int mMinHeight;
    public int mMinWidth;
    public final ConstraintAnchor mRight;
    public final ConstraintAnchor mTop;
    public String stringId;
    public ChainRun verticalChainRun;
    public boolean measured = false;
    public HorizontalWidgetRun mHorizontalRun = null;
    public VerticalWidgetRun mVerticalRun = null;
    public final boolean[] isTerminalWidget = {true, true};
    public boolean mMeasureRequested = true;
    public int mWidthOverride = -1;
    public int mHeightOverride = -1;
    public boolean mResolvedHorizontal = false;
    public boolean mResolvedVertical = false;
    public boolean mHorizontalSolvingPass = false;
    public boolean mVerticalSolvingPass = false;
    public int mHorizontalResolution = -1;
    public int mVerticalResolution = -1;
    public int mWrapBehaviorInParent = 0;
    public int mMatchConstraintDefaultWidth = 0;
    public int mMatchConstraintDefaultHeight = 0;
    public final int[] mResolvedMatchConstraintDefault = new int[2];
    public int mMatchConstraintMinWidth = 0;
    public int mMatchConstraintMaxWidth = 0;
    public float mMatchConstraintPercentWidth = 1.0f;
    public int mMatchConstraintMinHeight = 0;
    public int mMatchConstraintMaxHeight = 0;
    public float mMatchConstraintPercentHeight = 1.0f;
    public int mResolvedDimensionRatioSide = -1;
    public float mResolvedDimensionRatio = 1.0f;
    public final int[] mMaxDimension = {Integer.MAX_VALUE, Integer.MAX_VALUE};
    public float mCircleConstraintAngle = Float.NaN;
    public boolean mHasBaseline = false;
    public boolean mInVirtualLayout = false;
    public int mLastHorizontalMeasureSpec = 0;
    public int mLastVerticalMeasureSpec = 0;
    public final boolean[] mIsInBarrier = new boolean[2];
    public final int[] mListDimensionBehaviors = {1, 1};
    public ConstraintWidget mParent = null;
    public int mWidth = 0;
    public int mHeight = 0;
    public float mDimensionRatio = 0.0f;
    public int mDimensionRatioSide = -1;

    /* renamed from: mX */
    public int f2mX = 0;

    /* renamed from: mY */
    public int f3mY = 0;
    public int mBaselineDistance = 0;
    public float mHorizontalBiasPercent = 0.5f;
    public float mVerticalBiasPercent = 0.5f;
    public int mVisibility = 0;
    public String mDebugName = null;
    public int mHorizontalChainStyle = 0;
    public int mVerticalChainStyle = 0;
    public final float[] mWeight = {-1.0f, -1.0f};
    public final ConstraintWidget[] mListNextMatchConstraintsWidget = {null, null};
    public final ConstraintWidget[] mNextChainWidget = {null, null};
    public int horizontalGroup = -1;
    public int verticalGroup = -1;

    public ConstraintWidget() {
        new HashMap();
        ConstraintAnchor constraintAnchor = new ConstraintAnchor(this, 2);
        this.mLeft = constraintAnchor;
        ConstraintAnchor constraintAnchor2 = new ConstraintAnchor(this, 3);
        this.mTop = constraintAnchor2;
        ConstraintAnchor constraintAnchor3 = new ConstraintAnchor(this, 4);
        this.mRight = constraintAnchor3;
        ConstraintAnchor constraintAnchor4 = new ConstraintAnchor(this, 5);
        this.mBottom = constraintAnchor4;
        ConstraintAnchor constraintAnchor5 = new ConstraintAnchor(this, 6);
        this.mBaseline = constraintAnchor5;
        ConstraintAnchor constraintAnchor6 = new ConstraintAnchor(this, 8);
        this.mCenterX = constraintAnchor6;
        ConstraintAnchor constraintAnchor7 = new ConstraintAnchor(this, 9);
        this.mCenterY = constraintAnchor7;
        ConstraintAnchor constraintAnchor8 = new ConstraintAnchor(this, 7);
        this.mCenter = constraintAnchor8;
        this.mListAnchors = new ConstraintAnchor[]{constraintAnchor, constraintAnchor3, constraintAnchor2, constraintAnchor4, constraintAnchor5, constraintAnchor8};
        ArrayList arrayList = new ArrayList();
        this.mAnchors = arrayList;
        arrayList.add(constraintAnchor);
        arrayList.add(constraintAnchor2);
        arrayList.add(constraintAnchor3);
        arrayList.add(constraintAnchor4);
        arrayList.add(constraintAnchor6);
        arrayList.add(constraintAnchor7);
        arrayList.add(constraintAnchor8);
        arrayList.add(constraintAnchor5);
    }

    public static void serializeAttribute(StringBuilder sb, String str, float f, float f2) {
        if (f != f2) {
            sb.append(str);
            sb.append(" :   ");
            sb.append(f);
            sb.append(",\n");
        }
    }

    public final void addChildrenToSolverByDependency(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, HashSet hashSet, int i, boolean z) {
        if (z) {
            if (hashSet.contains(this)) {
                Chain.checkMatchParent(constraintWidgetContainer, linearSystem, this);
                hashSet.remove(this);
                addToSolver(linearSystem, constraintWidgetContainer.optimizeFor(64));
            } else {
                return;
            }
        }
        if (i == 0) {
            HashSet hashSet2 = this.mLeft.mDependents;
            if (hashSet2 != null) {
                Iterator it = hashSet2.iterator();
                while (it.hasNext()) {
                    ((ConstraintAnchor) it.next()).mOwner.addChildrenToSolverByDependency(constraintWidgetContainer, linearSystem, hashSet, i, true);
                }
            }
            HashSet hashSet3 = this.mRight.mDependents;
            if (hashSet3 != null) {
                Iterator it2 = hashSet3.iterator();
                while (it2.hasNext()) {
                    ((ConstraintAnchor) it2.next()).mOwner.addChildrenToSolverByDependency(constraintWidgetContainer, linearSystem, hashSet, i, true);
                }
                return;
            }
            return;
        }
        HashSet hashSet4 = this.mTop.mDependents;
        if (hashSet4 != null) {
            Iterator it3 = hashSet4.iterator();
            while (it3.hasNext()) {
                ((ConstraintAnchor) it3.next()).mOwner.addChildrenToSolverByDependency(constraintWidgetContainer, linearSystem, hashSet, i, true);
            }
        }
        HashSet hashSet5 = this.mBottom.mDependents;
        if (hashSet5 != null) {
            Iterator it4 = hashSet5.iterator();
            while (it4.hasNext()) {
                ((ConstraintAnchor) it4.next()).mOwner.addChildrenToSolverByDependency(constraintWidgetContainer, linearSystem, hashSet, i, true);
            }
        }
        HashSet hashSet6 = this.mBaseline.mDependents;
        if (hashSet6 != null) {
            Iterator it5 = hashSet6.iterator();
            while (it5.hasNext()) {
                ((ConstraintAnchor) it5.next()).mOwner.addChildrenToSolverByDependency(constraintWidgetContainer, linearSystem, hashSet, i, true);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0293  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x029c  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x029f  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x02ae  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x02b5  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x02bc  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x02bf  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x02dd  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x03ef  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x0407  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x0410  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x0414  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x0428  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x0431  */
    /* JADX WARN: Removed duplicated region for block: B:293:0x044d  */
    /* JADX WARN: Removed duplicated region for block: B:315:0x04b6  */
    /* JADX WARN: Removed duplicated region for block: B:316:0x04bd  */
    /* JADX WARN: Removed duplicated region for block: B:319:0x04c3  */
    /* JADX WARN: Removed duplicated region for block: B:321:0x04ce  */
    /* JADX WARN: Removed duplicated region for block: B:324:0x04f9  */
    /* JADX WARN: Removed duplicated region for block: B:327:0x0531  */
    /* JADX WARN: Removed duplicated region for block: B:346:0x0595  */
    /* JADX WARN: Removed duplicated region for block: B:349:0x0599  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:388:0x0660  */
    /* JADX WARN: Removed duplicated region for block: B:394:0x06be  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00f9  */
    /* JADX WARN: Type inference failed for: r18v25 */
    /* JADX WARN: Type inference failed for: r18v4 */
    /* JADX WARN: Type inference failed for: r18v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void addToSolver(LinearSystem linearSystem, boolean z) {
        char c;
        boolean z2;
        boolean z3;
        int i;
        boolean z4;
        boolean z5;
        boolean[] zArr;
        ConstraintAnchor constraintAnchor;
        boolean[] zArr2;
        ConstraintAnchor constraintAnchor2;
        boolean z6;
        boolean z7;
        boolean z8;
        ConstraintAnchor constraintAnchor3;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int[] iArr;
        int i7;
        boolean z9;
        int i8;
        boolean z10;
        float f;
        SolverVariable solverVariable;
        ConstraintAnchor constraintAnchor4;
        boolean z11;
        int i9;
        int i10;
        int i11;
        ConstraintAnchor constraintAnchor5;
        int i12;
        boolean z12;
        boolean z13;
        boolean z14;
        ConstraintAnchor constraintAnchor6;
        boolean z15;
        boolean z16;
        int i13;
        int[] iArr2;
        ConstraintAnchor constraintAnchor7;
        ConstraintAnchor constraintAnchor8;
        SolverVariable solverVariable2;
        SolverVariable solverVariable3;
        SolverVariable solverVariable4;
        SolverVariable solverVariable5;
        SolverVariable solverVariable6;
        int[] iArr3;
        ConstraintAnchor constraintAnchor9;
        boolean[] zArr3;
        int i14;
        boolean z17;
        boolean z18;
        boolean z19;
        ?? r18;
        boolean z20;
        int i15;
        int i16;
        SolverVariable solverVariable7;
        SolverVariable solverVariable8;
        SolverVariable solverVariable9;
        SolverVariable solverVariable10;
        SolverVariable solverVariable11;
        boolean z21;
        int i17;
        SolverVariable solverVariable12;
        VerticalWidgetRun verticalWidgetRun;
        DependencyNode dependencyNode;
        ConstraintWidget constraintWidget;
        boolean z22;
        ConstraintWidget constraintWidget2;
        SolverVariable solverVariable13;
        ConstraintWidget constraintWidget3;
        SolverVariable solverVariable14;
        HorizontalWidgetRun horizontalWidgetRun;
        DependencyNode dependencyNode2;
        int i18;
        int i19;
        int i20;
        boolean isInHorizontalChain;
        boolean z23;
        HorizontalWidgetRun horizontalWidgetRun2;
        VerticalWidgetRun verticalWidgetRun2;
        boolean z24;
        ConstraintWidget constraintWidget4;
        ConstraintWidget constraintWidget5;
        boolean z25;
        LinearSystem linearSystem2 = linearSystem;
        ConstraintAnchor constraintAnchor10 = this.mLeft;
        SolverVariable createObjectVariable = linearSystem2.createObjectVariable(constraintAnchor10);
        ConstraintAnchor constraintAnchor11 = this.mRight;
        SolverVariable createObjectVariable2 = linearSystem2.createObjectVariable(constraintAnchor11);
        ConstraintAnchor constraintAnchor12 = this.mTop;
        SolverVariable createObjectVariable3 = linearSystem2.createObjectVariable(constraintAnchor12);
        ConstraintAnchor constraintAnchor13 = this.mBottom;
        SolverVariable createObjectVariable4 = linearSystem2.createObjectVariable(constraintAnchor13);
        ConstraintAnchor constraintAnchor14 = this.mBaseline;
        SolverVariable createObjectVariable5 = linearSystem2.createObjectVariable(constraintAnchor14);
        ConstraintWidget constraintWidget6 = this.mParent;
        if (constraintWidget6 != null) {
            int[] iArr4 = constraintWidget6.mListDimensionBehaviors;
            c = 0;
            if (iArr4[0] == 2) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (iArr4[1] == 2) {
                z25 = true;
            } else {
                z25 = false;
            }
            int i21 = this.mWrapBehaviorInParent;
            if (i21 == 1) {
                z3 = false;
            } else if (i21 == 2) {
                z3 = z25;
                z2 = false;
            } else if (i21 != 3) {
                z3 = z25;
            }
            i = this.mVisibility;
            boolean[] zArr4 = this.mIsInBarrier;
            boolean z26 = z3;
            if (i != 8) {
                ArrayList arrayList = this.mAnchors;
                int size = arrayList.size();
                z4 = z2;
                int i22 = 0;
                while (true) {
                    if (i22 < size) {
                        int i23 = size;
                        HashSet hashSet = ((ConstraintAnchor) arrayList.get(i22)).mDependents;
                        if (hashSet != null && hashSet.size() > 0) {
                            break;
                        }
                        i22++;
                        size = i23;
                    } else if (!zArr4[c] && !zArr4[1]) {
                        return;
                    }
                }
            } else {
                z4 = z2;
            }
            z5 = this.mResolvedHorizontal;
            if (!z5 || this.mResolvedVertical) {
                if (z5) {
                    linearSystem2.addEquality(createObjectVariable, this.f2mX);
                    linearSystem2.addEquality(createObjectVariable2, this.f2mX + this.mWidth);
                    if (z4 && (constraintWidget5 = this.mParent) != null) {
                        ConstraintWidgetContainer constraintWidgetContainer = (ConstraintWidgetContainer) constraintWidget5;
                        WeakReference weakReference = constraintWidgetContainer.mHorizontalWrapMin;
                        if (weakReference == null || weakReference.get() == null || constraintAnchor10.getFinalValue() > ((ConstraintAnchor) constraintWidgetContainer.mHorizontalWrapMin.get()).getFinalValue()) {
                            constraintWidgetContainer.mHorizontalWrapMin = new WeakReference(constraintAnchor10);
                        }
                        WeakReference weakReference2 = constraintWidgetContainer.mHorizontalWrapMax;
                        if (weakReference2 == null || weakReference2.get() == null || constraintAnchor11.getFinalValue() > ((ConstraintAnchor) constraintWidgetContainer.mHorizontalWrapMax.get()).getFinalValue()) {
                            constraintWidgetContainer.mHorizontalWrapMax = new WeakReference(constraintAnchor11);
                        }
                    }
                }
                if (this.mResolvedVertical) {
                    linearSystem2.addEquality(createObjectVariable3, this.f3mY);
                    linearSystem2.addEquality(createObjectVariable4, this.f3mY + this.mHeight);
                    HashSet hashSet2 = constraintAnchor14.mDependents;
                    if (hashSet2 != null && hashSet2.size() > 0) {
                        linearSystem2.addEquality(createObjectVariable5, this.f3mY + this.mBaselineDistance);
                    }
                    if (z26 && (constraintWidget4 = this.mParent) != null) {
                        ConstraintWidgetContainer constraintWidgetContainer2 = (ConstraintWidgetContainer) constraintWidget4;
                        WeakReference weakReference3 = constraintWidgetContainer2.mVerticalWrapMin;
                        if (weakReference3 == null || weakReference3.get() == null || constraintAnchor12.getFinalValue() > ((ConstraintAnchor) constraintWidgetContainer2.mVerticalWrapMin.get()).getFinalValue()) {
                            constraintWidgetContainer2.mVerticalWrapMin = new WeakReference(constraintAnchor12);
                        }
                        WeakReference weakReference4 = constraintWidgetContainer2.mVerticalWrapMax;
                        if (weakReference4 == null || weakReference4.get() == null || constraintAnchor13.getFinalValue() > ((ConstraintAnchor) constraintWidgetContainer2.mVerticalWrapMax.get()).getFinalValue()) {
                            constraintWidgetContainer2.mVerticalWrapMax = new WeakReference(constraintAnchor13);
                        }
                    }
                }
                if (this.mResolvedHorizontal && this.mResolvedVertical) {
                    this.mResolvedHorizontal = false;
                    this.mResolvedVertical = false;
                    return;
                }
            }
            zArr = this.isTerminalWidget;
            if (z || (horizontalWidgetRun2 = this.mHorizontalRun) == null || (verticalWidgetRun2 = this.mVerticalRun) == null) {
                constraintAnchor = constraintAnchor14;
                zArr2 = zArr;
            } else {
                constraintAnchor = constraintAnchor14;
                DependencyNode dependencyNode3 = horizontalWidgetRun2.start;
                zArr2 = zArr;
                if (dependencyNode3.resolved && horizontalWidgetRun2.end.resolved && verticalWidgetRun2.start.resolved && verticalWidgetRun2.end.resolved) {
                    linearSystem2.addEquality(createObjectVariable, dependencyNode3.value);
                    linearSystem2.addEquality(createObjectVariable2, this.mHorizontalRun.end.value);
                    linearSystem2.addEquality(createObjectVariable3, this.mVerticalRun.start.value);
                    linearSystem2.addEquality(createObjectVariable4, this.mVerticalRun.end.value);
                    linearSystem2.addEquality(createObjectVariable5, this.mVerticalRun.baseline.value);
                    if (this.mParent != null) {
                        if (z4 && zArr2[0] && !isInHorizontalChain()) {
                            linearSystem2.addGreaterThan(linearSystem2.createObjectVariable(this.mParent.mRight), createObjectVariable2, 0, 8);
                        }
                        if (z26 && zArr2[1] && !isInVerticalChain()) {
                            z24 = false;
                            linearSystem2.addGreaterThan(linearSystem2.createObjectVariable(this.mParent.mBottom), createObjectVariable4, 0, 8);
                            this.mResolvedHorizontal = z24;
                            this.mResolvedVertical = z24;
                            return;
                        }
                    }
                    z24 = false;
                    this.mResolvedHorizontal = z24;
                    this.mResolvedVertical = z24;
                    return;
                }
            }
            if (this.mParent == null) {
                if (isChainHead(0)) {
                    ((ConstraintWidgetContainer) this.mParent).addChain(this, 0);
                    isInHorizontalChain = true;
                } else {
                    isInHorizontalChain = isInHorizontalChain();
                }
                if (isChainHead(1)) {
                    ((ConstraintWidgetContainer) this.mParent).addChain(this, 1);
                    z23 = true;
                } else {
                    z23 = isInVerticalChain();
                }
                if (isInHorizontalChain || !z4 || this.mVisibility == 8 || constraintAnchor10.mTarget != null || constraintAnchor11.mTarget != null) {
                    constraintAnchor2 = constraintAnchor10;
                } else {
                    constraintAnchor2 = constraintAnchor10;
                    linearSystem2.addGreaterThan(linearSystem2.createObjectVariable(this.mParent.mRight), createObjectVariable2, 0, 1);
                }
                if (!z23 && z26 && this.mVisibility != 8 && constraintAnchor12.mTarget == null && constraintAnchor13.mTarget == null && constraintAnchor == null) {
                    linearSystem2.addGreaterThan(linearSystem2.createObjectVariable(this.mParent.mBottom), createObjectVariable4, 0, 1);
                }
                constraintAnchor3 = constraintAnchor11;
                z8 = z26;
                z6 = z23;
                z7 = isInHorizontalChain;
            } else {
                constraintAnchor2 = constraintAnchor10;
                constraintAnchor3 = constraintAnchor11;
                z8 = z26;
                z7 = false;
                z6 = false;
            }
            i2 = this.mWidth;
            i3 = this.mMinWidth;
            if (i2 >= i3) {
                i3 = i2;
            }
            i4 = this.mHeight;
            ConstraintAnchor constraintAnchor15 = constraintAnchor3;
            i5 = this.mMinHeight;
            if (i4 >= i5) {
                i6 = i5;
            } else {
                i6 = i4;
            }
            iArr = this.mListDimensionBehaviors;
            i7 = iArr[0];
            boolean z27 = z8;
            if (i7 == 3) {
                z9 = true;
            } else {
                z9 = false;
            }
            i8 = iArr[1];
            if (i8 == 3) {
                z10 = true;
            } else {
                z10 = false;
            }
            int i24 = this.mDimensionRatioSide;
            this.mResolvedDimensionRatioSide = i24;
            f = this.mDimensionRatio;
            this.mResolvedDimensionRatio = f;
            int i25 = this.mMatchConstraintDefaultWidth;
            int i26 = this.mMatchConstraintDefaultHeight;
            if (f <= 0.0f) {
                constraintAnchor4 = constraintAnchor13;
                if (this.mVisibility != 8) {
                    if (i7 == 3 && i25 == 0) {
                        i19 = 3;
                    } else {
                        i19 = i25;
                    }
                    if (i8 == 3 && i26 == 0) {
                        solverVariable = createObjectVariable4;
                        i20 = 3;
                    } else {
                        solverVariable = createObjectVariable4;
                        i20 = i26;
                    }
                    if (i7 == 3 && i8 == 3 && i19 == 3 && i20 == 3) {
                        if (i24 == -1) {
                            if (z9 && !z10) {
                                this.mResolvedDimensionRatioSide = 0;
                            } else if (!z9 && z10) {
                                this.mResolvedDimensionRatioSide = 1;
                                if (i24 == -1) {
                                    this.mResolvedDimensionRatio = 1.0f / f;
                                }
                            }
                        }
                        if (this.mResolvedDimensionRatioSide == 0 && (!constraintAnchor12.isConnected() || !constraintAnchor4.isConnected())) {
                            this.mResolvedDimensionRatioSide = 1;
                        } else if (this.mResolvedDimensionRatioSide == 1 && (!constraintAnchor2.isConnected() || !constraintAnchor15.isConnected())) {
                            this.mResolvedDimensionRatioSide = 0;
                        }
                        if (this.mResolvedDimensionRatioSide == -1 && (!constraintAnchor12.isConnected() || !constraintAnchor4.isConnected() || !constraintAnchor2.isConnected() || !constraintAnchor15.isConnected())) {
                            if (constraintAnchor12.isConnected() && constraintAnchor4.isConnected()) {
                                this.mResolvedDimensionRatioSide = 0;
                            } else if (constraintAnchor2.isConnected() && constraintAnchor15.isConnected()) {
                                this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                                this.mResolvedDimensionRatioSide = 1;
                            }
                        }
                        if (this.mResolvedDimensionRatioSide == -1) {
                            int i27 = this.mMatchConstraintMinWidth;
                            if (i27 > 0 && this.mMatchConstraintMinHeight == 0) {
                                this.mResolvedDimensionRatioSide = 0;
                            } else if (i27 == 0 && this.mMatchConstraintMinHeight > 0) {
                                this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                                this.mResolvedDimensionRatioSide = 1;
                            }
                        }
                    } else if (i7 == 3 && i19 == 3) {
                        this.mResolvedDimensionRatioSide = 0;
                        i3 = (int) (f * i4);
                        if (i8 != 3) {
                            constraintAnchor5 = constraintAnchor;
                            i9 = i6;
                            i11 = 4;
                            z11 = false;
                            i10 = i20;
                            int[] iArr5 = this.mResolvedMatchConstraintDefault;
                            iArr5[0] = i11;
                            iArr5[1] = i10;
                            if (!z11) {
                            }
                            z12 = false;
                            if (z11) {
                            }
                            z13 = false;
                            if (iArr[0] == 2) {
                            }
                            z14 = false;
                            if (z14) {
                            }
                            constraintAnchor6 = this.mCenter;
                            z15 = !constraintAnchor6.isConnected();
                            z16 = zArr4[0];
                            boolean z28 = zArr4[1];
                            i13 = this.mHorizontalResolution;
                            iArr2 = this.mMaxDimension;
                            SolverVariable solverVariable15 = null;
                            if (i13 != 2) {
                            }
                            constraintAnchor7 = constraintAnchor5;
                            solverVariable6 = createObjectVariable;
                            solverVariable5 = createObjectVariable2;
                            constraintAnchor9 = constraintAnchor6;
                            iArr3 = iArr2;
                            solverVariable2 = createObjectVariable5;
                            z17 = z7;
                            z19 = z4;
                            z18 = z27;
                            solverVariable4 = createObjectVariable3;
                            constraintAnchor8 = constraintAnchor4;
                            solverVariable3 = solverVariable;
                            i14 = i11;
                            zArr3 = zArr2;
                            if (z) {
                            }
                            solverVariable9 = solverVariable4;
                            solverVariable8 = solverVariable3;
                            solverVariable7 = solverVariable2;
                            i16 = 0;
                            i15 = 8;
                            r18 = 1;
                            z20 = true;
                            if (this.mVerticalResolution == 2) {
                            }
                            if (z20) {
                            }
                            solverVariable11 = solverVariable9;
                            solverVariable10 = solverVariable8;
                            if (z11) {
                            }
                            if (constraintAnchor9.isConnected()) {
                            }
                            this.mResolvedHorizontal = false;
                            this.mResolvedVertical = false;
                        }
                    } else if (i8 == 3 && i20 == 3) {
                        this.mResolvedDimensionRatioSide = 1;
                        if (i24 == -1) {
                            this.mResolvedDimensionRatio = 1.0f / f;
                        }
                        i9 = (int) (this.mResolvedDimensionRatio * i2);
                        if (i7 != 3) {
                            i11 = i19;
                            constraintAnchor5 = constraintAnchor;
                            i10 = 4;
                            z11 = false;
                            int[] iArr52 = this.mResolvedMatchConstraintDefault;
                            iArr52[0] = i11;
                            iArr52[1] = i10;
                            if (!z11) {
                                int i28 = this.mResolvedDimensionRatioSide;
                                i12 = -1;
                                if (i28 == 0 || i28 == -1) {
                                    z12 = true;
                                    if (z11 || !((i18 = this.mResolvedDimensionRatioSide) == 1 || i18 == i12)) {
                                        z13 = false;
                                    } else {
                                        z13 = true;
                                    }
                                    if (iArr[0] == 2 || !(this instanceof ConstraintWidgetContainer)) {
                                        z14 = false;
                                    } else {
                                        z14 = true;
                                    }
                                    if (z14) {
                                        i3 = 0;
                                    }
                                    constraintAnchor6 = this.mCenter;
                                    z15 = !constraintAnchor6.isConnected();
                                    z16 = zArr4[0];
                                    boolean z282 = zArr4[1];
                                    i13 = this.mHorizontalResolution;
                                    iArr2 = this.mMaxDimension;
                                    SolverVariable solverVariable152 = null;
                                    if (i13 != 2 && !this.mResolvedHorizontal) {
                                        if (z && (horizontalWidgetRun = this.mHorizontalRun) != null) {
                                            dependencyNode2 = horizontalWidgetRun.start;
                                            if (!dependencyNode2.resolved && horizontalWidgetRun.end.resolved) {
                                                if (z) {
                                                    linearSystem2.addEquality(createObjectVariable, dependencyNode2.value);
                                                    linearSystem2.addEquality(createObjectVariable2, this.mHorizontalRun.end.value);
                                                    if (this.mParent != null && z4 && zArr2[0] && !isInHorizontalChain()) {
                                                        linearSystem2.addGreaterThan(linearSystem2.createObjectVariable(this.mParent.mRight), createObjectVariable2, 0, 8);
                                                    }
                                                }
                                            }
                                        }
                                        constraintWidget2 = this.mParent;
                                        if (constraintWidget2 == null) {
                                            solverVariable13 = linearSystem2.createObjectVariable(constraintWidget2.mRight);
                                        } else {
                                            solverVariable13 = null;
                                        }
                                        constraintWidget3 = this.mParent;
                                        if (constraintWidget3 == null) {
                                            solverVariable14 = linearSystem2.createObjectVariable(constraintWidget3.mLeft);
                                        } else {
                                            solverVariable14 = null;
                                        }
                                        boolean z29 = zArr2[0];
                                        z19 = z4;
                                        i14 = i11;
                                        SolverVariable solverVariable16 = solverVariable13;
                                        int i29 = iArr[0];
                                        z17 = z7;
                                        int i30 = this.f2mX;
                                        int i31 = this.mMinWidth;
                                        constraintAnchor9 = constraintAnchor6;
                                        SolverVariable solverVariable17 = solverVariable14;
                                        int i32 = iArr2[0];
                                        float f2 = this.mHorizontalBiasPercent;
                                        boolean z30 = true;
                                        ConstraintAnchor constraintAnchor16 = constraintAnchor5;
                                        if (iArr[1] != 3) {
                                            z30 = false;
                                        }
                                        iArr3 = iArr2;
                                        boolean z31 = z12;
                                        solverVariable6 = createObjectVariable;
                                        z18 = z27;
                                        solverVariable4 = createObjectVariable3;
                                        solverVariable5 = createObjectVariable2;
                                        constraintAnchor8 = constraintAnchor4;
                                        solverVariable3 = solverVariable;
                                        constraintAnchor7 = constraintAnchor16;
                                        solverVariable2 = createObjectVariable5;
                                        zArr3 = zArr2;
                                        linearSystem2 = linearSystem;
                                        applyConstraints(linearSystem2, true, z19, z18, z29, solverVariable17, solverVariable16, i29, z14, this.mLeft, this.mRight, i30, i3, i31, i32, f2, z31, z30, z17, z6, z16, i14, i10, this.mMatchConstraintMinWidth, this.mMatchConstraintMaxWidth, this.mMatchConstraintPercentWidth, z15);
                                        if (z && (verticalWidgetRun = this.mVerticalRun) != null) {
                                            dependencyNode = verticalWidgetRun.start;
                                            if (dependencyNode.resolved && verticalWidgetRun.end.resolved) {
                                                int i33 = dependencyNode.value;
                                                solverVariable9 = solverVariable4;
                                                linearSystem2.addEquality(solverVariable9, i33);
                                                solverVariable8 = solverVariable3;
                                                linearSystem2.addEquality(solverVariable8, this.mVerticalRun.end.value);
                                                solverVariable7 = solverVariable2;
                                                linearSystem2.addEquality(solverVariable7, this.mVerticalRun.baseline.value);
                                                constraintWidget = this.mParent;
                                                if (constraintWidget != null || z6 || !z18) {
                                                    i16 = 0;
                                                    i15 = 8;
                                                    z22 = true;
                                                } else {
                                                    z22 = true;
                                                    z22 = true;
                                                    if (zArr3[1]) {
                                                        i16 = 0;
                                                        i15 = 8;
                                                        linearSystem2.addGreaterThan(linearSystem2.createObjectVariable(constraintWidget.mBottom), solverVariable8, 0, 8);
                                                    } else {
                                                        i16 = 0;
                                                        i15 = 8;
                                                    }
                                                }
                                                z20 = false;
                                                r18 = z22;
                                                if (this.mVerticalResolution == 2) {
                                                    z20 = false;
                                                }
                                                if (z20 || this.mResolvedVertical) {
                                                    solverVariable11 = solverVariable9;
                                                    solverVariable10 = solverVariable8;
                                                } else {
                                                    char c2 = r18 == true ? 1 : 0;
                                                    char c3 = r18 == true ? 1 : 0;
                                                    char c4 = r18 == true ? 1 : 0;
                                                    char c5 = r18 == true ? 1 : 0;
                                                    char c6 = r18 == true ? 1 : 0;
                                                    char c7 = r18 == true ? 1 : 0;
                                                    char c8 = r18 == true ? 1 : 0;
                                                    if (iArr[c2] != 2 || !(this instanceof ConstraintWidgetContainer)) {
                                                        z21 = false;
                                                    } else {
                                                        z21 = true;
                                                    }
                                                    if (z21) {
                                                        i17 = 0;
                                                    } else {
                                                        i17 = i9;
                                                    }
                                                    ConstraintWidget constraintWidget7 = this.mParent;
                                                    if (constraintWidget7 != null) {
                                                        solverVariable12 = linearSystem2.createObjectVariable(constraintWidget7.mBottom);
                                                    } else {
                                                        solverVariable12 = null;
                                                    }
                                                    ConstraintWidget constraintWidget8 = this.mParent;
                                                    if (constraintWidget8 != null) {
                                                        solverVariable152 = linearSystem2.createObjectVariable(constraintWidget8.mTop);
                                                    }
                                                    int i34 = this.mBaselineDistance;
                                                    if (i34 > 0 || this.mVisibility == i15) {
                                                        ConstraintAnchor constraintAnchor17 = constraintAnchor7;
                                                        if (constraintAnchor17.mTarget != null) {
                                                            linearSystem2.addEquality(solverVariable7, solverVariable9, i34, i15);
                                                            linearSystem2.addEquality(solverVariable7, linearSystem2.createObjectVariable(constraintAnchor17.mTarget), constraintAnchor17.getMargin(), i15);
                                                            if (z18) {
                                                                linearSystem2.addGreaterThan(solverVariable12, linearSystem2.createObjectVariable(constraintAnchor8), i16, 5);
                                                            }
                                                            z15 = false;
                                                        } else if (this.mVisibility == i15) {
                                                            linearSystem2.addEquality(solverVariable7, solverVariable9, constraintAnchor17.getMargin(), i15);
                                                        } else {
                                                            linearSystem2.addEquality(solverVariable7, solverVariable9, i34, i15);
                                                        }
                                                    }
                                                    boolean z32 = zArr3[r18];
                                                    int i35 = iArr[r18];
                                                    int i36 = this.f3mY;
                                                    int i37 = this.mMinHeight;
                                                    int i38 = iArr3[r18];
                                                    float f3 = this.mVerticalBiasPercent;
                                                    boolean z33 = r18;
                                                    if (iArr[0] != 3) {
                                                        z33 = false;
                                                    }
                                                    solverVariable10 = solverVariable8;
                                                    solverVariable11 = solverVariable9;
                                                    linearSystem2 = linearSystem;
                                                    applyConstraints(linearSystem2, false, z18, z19, z32, solverVariable152, solverVariable12, i35, z21, this.mTop, this.mBottom, i36, i17, i37, i38, f3, z13, z33, z6, z17, z282, i10, i14, this.mMatchConstraintMinHeight, this.mMatchConstraintMaxHeight, this.mMatchConstraintPercentHeight, z15);
                                                }
                                                if (z11) {
                                                    if (this.mResolvedDimensionRatioSide == 1) {
                                                        float f4 = this.mResolvedDimensionRatio;
                                                        ArrayRow createRow = linearSystem2.createRow();
                                                        createRow.variables.put(solverVariable10, -1.0f);
                                                        createRow.variables.put(solverVariable11, 1.0f);
                                                        createRow.variables.put(solverVariable5, f4);
                                                        createRow.variables.put(solverVariable6, -f4);
                                                        linearSystem2.addConstraint(createRow);
                                                    } else {
                                                        float f5 = this.mResolvedDimensionRatio;
                                                        ArrayRow createRow2 = linearSystem2.createRow();
                                                        createRow2.variables.put(solverVariable5, -1.0f);
                                                        createRow2.variables.put(solverVariable6, 1.0f);
                                                        createRow2.variables.put(solverVariable10, f5);
                                                        createRow2.variables.put(solverVariable11, -f5);
                                                        linearSystem2.addConstraint(createRow2);
                                                    }
                                                }
                                                if (constraintAnchor9.isConnected()) {
                                                    ConstraintAnchor constraintAnchor18 = constraintAnchor9;
                                                    ConstraintWidget constraintWidget9 = constraintAnchor18.mTarget.mOwner;
                                                    int margin = constraintAnchor18.getMargin();
                                                    SolverVariable createObjectVariable6 = linearSystem2.createObjectVariable(getAnchor(2));
                                                    SolverVariable createObjectVariable7 = linearSystem2.createObjectVariable(getAnchor(3));
                                                    SolverVariable createObjectVariable8 = linearSystem2.createObjectVariable(getAnchor(4));
                                                    SolverVariable createObjectVariable9 = linearSystem2.createObjectVariable(getAnchor(5));
                                                    SolverVariable createObjectVariable10 = linearSystem2.createObjectVariable(constraintWidget9.getAnchor(2));
                                                    SolverVariable createObjectVariable11 = linearSystem2.createObjectVariable(constraintWidget9.getAnchor(3));
                                                    SolverVariable createObjectVariable12 = linearSystem2.createObjectVariable(constraintWidget9.getAnchor(4));
                                                    SolverVariable createObjectVariable13 = linearSystem2.createObjectVariable(constraintWidget9.getAnchor(5));
                                                    ArrayRow createRow3 = linearSystem2.createRow();
                                                    double radians = (float) Math.toRadians(this.mCircleConstraintAngle + 90.0f);
                                                    double sin = Math.sin(radians);
                                                    double d = margin;
                                                    createRow3.variables.put(createObjectVariable11, 0.5f);
                                                    createRow3.variables.put(createObjectVariable13, 0.5f);
                                                    createRow3.variables.put(createObjectVariable7, -0.5f);
                                                    createRow3.variables.put(createObjectVariable9, -0.5f);
                                                    createRow3.mConstantValue = -((float) (sin * d));
                                                    linearSystem2.addConstraint(createRow3);
                                                    ArrayRow createRow4 = linearSystem2.createRow();
                                                    float cos = (float) (Math.cos(radians) * d);
                                                    createRow4.variables.put(createObjectVariable10, 0.5f);
                                                    createRow4.variables.put(createObjectVariable12, 0.5f);
                                                    createRow4.variables.put(createObjectVariable6, -0.5f);
                                                    createRow4.variables.put(createObjectVariable8, -0.5f);
                                                    createRow4.mConstantValue = -cos;
                                                    linearSystem2.addConstraint(createRow4);
                                                }
                                                this.mResolvedHorizontal = false;
                                                this.mResolvedVertical = false;
                                            }
                                        }
                                        solverVariable9 = solverVariable4;
                                        solverVariable8 = solverVariable3;
                                        solverVariable7 = solverVariable2;
                                        i16 = 0;
                                        i15 = 8;
                                        r18 = 1;
                                        z20 = true;
                                        if (this.mVerticalResolution == 2) {
                                        }
                                        if (z20) {
                                        }
                                        solverVariable11 = solverVariable9;
                                        solverVariable10 = solverVariable8;
                                        if (z11) {
                                        }
                                        if (constraintAnchor9.isConnected()) {
                                        }
                                        this.mResolvedHorizontal = false;
                                        this.mResolvedVertical = false;
                                    }
                                    constraintAnchor7 = constraintAnchor5;
                                    solverVariable6 = createObjectVariable;
                                    solverVariable5 = createObjectVariable2;
                                    constraintAnchor9 = constraintAnchor6;
                                    iArr3 = iArr2;
                                    solverVariable2 = createObjectVariable5;
                                    z17 = z7;
                                    z19 = z4;
                                    z18 = z27;
                                    solverVariable4 = createObjectVariable3;
                                    constraintAnchor8 = constraintAnchor4;
                                    solverVariable3 = solverVariable;
                                    i14 = i11;
                                    zArr3 = zArr2;
                                    if (z) {
                                        dependencyNode = verticalWidgetRun.start;
                                        if (dependencyNode.resolved) {
                                            int i332 = dependencyNode.value;
                                            solverVariable9 = solverVariable4;
                                            linearSystem2.addEquality(solverVariable9, i332);
                                            solverVariable8 = solverVariable3;
                                            linearSystem2.addEquality(solverVariable8, this.mVerticalRun.end.value);
                                            solverVariable7 = solverVariable2;
                                            linearSystem2.addEquality(solverVariable7, this.mVerticalRun.baseline.value);
                                            constraintWidget = this.mParent;
                                            if (constraintWidget != null) {
                                            }
                                            i16 = 0;
                                            i15 = 8;
                                            z22 = true;
                                            z20 = false;
                                            r18 = z22;
                                            if (this.mVerticalResolution == 2) {
                                            }
                                            if (z20) {
                                            }
                                            solverVariable11 = solverVariable9;
                                            solverVariable10 = solverVariable8;
                                            if (z11) {
                                            }
                                            if (constraintAnchor9.isConnected()) {
                                            }
                                            this.mResolvedHorizontal = false;
                                            this.mResolvedVertical = false;
                                        }
                                    }
                                    solverVariable9 = solverVariable4;
                                    solverVariable8 = solverVariable3;
                                    solverVariable7 = solverVariable2;
                                    i16 = 0;
                                    i15 = 8;
                                    r18 = 1;
                                    z20 = true;
                                    if (this.mVerticalResolution == 2) {
                                    }
                                    if (z20) {
                                    }
                                    solverVariable11 = solverVariable9;
                                    solverVariable10 = solverVariable8;
                                    if (z11) {
                                    }
                                    if (constraintAnchor9.isConnected()) {
                                    }
                                    this.mResolvedHorizontal = false;
                                    this.mResolvedVertical = false;
                                }
                            } else {
                                i12 = -1;
                            }
                            z12 = false;
                            if (z11) {
                            }
                            z13 = false;
                            if (iArr[0] == 2) {
                            }
                            z14 = false;
                            if (z14) {
                            }
                            constraintAnchor6 = this.mCenter;
                            z15 = !constraintAnchor6.isConnected();
                            z16 = zArr4[0];
                            boolean z2822 = zArr4[1];
                            i13 = this.mHorizontalResolution;
                            iArr2 = this.mMaxDimension;
                            SolverVariable solverVariable1522 = null;
                            if (i13 != 2) {
                                if (z) {
                                    dependencyNode2 = horizontalWidgetRun.start;
                                    if (!dependencyNode2.resolved) {
                                    }
                                }
                                constraintWidget2 = this.mParent;
                                if (constraintWidget2 == null) {
                                }
                                constraintWidget3 = this.mParent;
                                if (constraintWidget3 == null) {
                                }
                                boolean z292 = zArr2[0];
                                z19 = z4;
                                i14 = i11;
                                SolverVariable solverVariable162 = solverVariable13;
                                int i292 = iArr[0];
                                z17 = z7;
                                int i302 = this.f2mX;
                                int i312 = this.mMinWidth;
                                constraintAnchor9 = constraintAnchor6;
                                SolverVariable solverVariable172 = solverVariable14;
                                int i322 = iArr2[0];
                                float f22 = this.mHorizontalBiasPercent;
                                boolean z302 = true;
                                ConstraintAnchor constraintAnchor162 = constraintAnchor5;
                                if (iArr[1] != 3) {
                                }
                                iArr3 = iArr2;
                                boolean z312 = z12;
                                solverVariable6 = createObjectVariable;
                                z18 = z27;
                                solverVariable4 = createObjectVariable3;
                                solverVariable5 = createObjectVariable2;
                                constraintAnchor8 = constraintAnchor4;
                                solverVariable3 = solverVariable;
                                constraintAnchor7 = constraintAnchor162;
                                solverVariable2 = createObjectVariable5;
                                zArr3 = zArr2;
                                linearSystem2 = linearSystem;
                                applyConstraints(linearSystem2, true, z19, z18, z292, solverVariable172, solverVariable162, i292, z14, this.mLeft, this.mRight, i302, i3, i312, i322, f22, z312, z302, z17, z6, z16, i14, i10, this.mMatchConstraintMinWidth, this.mMatchConstraintMaxWidth, this.mMatchConstraintPercentWidth, z15);
                                if (z) {
                                }
                                solverVariable9 = solverVariable4;
                                solverVariable8 = solverVariable3;
                                solverVariable7 = solverVariable2;
                                i16 = 0;
                                i15 = 8;
                                r18 = 1;
                                z20 = true;
                                if (this.mVerticalResolution == 2) {
                                }
                                if (z20) {
                                }
                                solverVariable11 = solverVariable9;
                                solverVariable10 = solverVariable8;
                                if (z11) {
                                }
                                if (constraintAnchor9.isConnected()) {
                                }
                                this.mResolvedHorizontal = false;
                                this.mResolvedVertical = false;
                            }
                            constraintAnchor7 = constraintAnchor5;
                            solverVariable6 = createObjectVariable;
                            solverVariable5 = createObjectVariable2;
                            constraintAnchor9 = constraintAnchor6;
                            iArr3 = iArr2;
                            solverVariable2 = createObjectVariable5;
                            z17 = z7;
                            z19 = z4;
                            z18 = z27;
                            solverVariable4 = createObjectVariable3;
                            constraintAnchor8 = constraintAnchor4;
                            solverVariable3 = solverVariable;
                            i14 = i11;
                            zArr3 = zArr2;
                            if (z) {
                            }
                            solverVariable9 = solverVariable4;
                            solverVariable8 = solverVariable3;
                            solverVariable7 = solverVariable2;
                            i16 = 0;
                            i15 = 8;
                            r18 = 1;
                            z20 = true;
                            if (this.mVerticalResolution == 2) {
                            }
                            if (z20) {
                            }
                            solverVariable11 = solverVariable9;
                            solverVariable10 = solverVariable8;
                            if (z11) {
                            }
                            if (constraintAnchor9.isConnected()) {
                            }
                            this.mResolvedHorizontal = false;
                            this.mResolvedVertical = false;
                        }
                        i11 = i19;
                        constraintAnchor5 = constraintAnchor;
                        z11 = true;
                        i10 = i20;
                        int[] iArr522 = this.mResolvedMatchConstraintDefault;
                        iArr522[0] = i11;
                        iArr522[1] = i10;
                        if (!z11) {
                        }
                        z12 = false;
                        if (z11) {
                        }
                        z13 = false;
                        if (iArr[0] == 2) {
                        }
                        z14 = false;
                        if (z14) {
                        }
                        constraintAnchor6 = this.mCenter;
                        z15 = !constraintAnchor6.isConnected();
                        z16 = zArr4[0];
                        boolean z28222 = zArr4[1];
                        i13 = this.mHorizontalResolution;
                        iArr2 = this.mMaxDimension;
                        SolverVariable solverVariable15222 = null;
                        if (i13 != 2) {
                        }
                        constraintAnchor7 = constraintAnchor5;
                        solverVariable6 = createObjectVariable;
                        solverVariable5 = createObjectVariable2;
                        constraintAnchor9 = constraintAnchor6;
                        iArr3 = iArr2;
                        solverVariable2 = createObjectVariable5;
                        z17 = z7;
                        z19 = z4;
                        z18 = z27;
                        solverVariable4 = createObjectVariable3;
                        constraintAnchor8 = constraintAnchor4;
                        solverVariable3 = solverVariable;
                        i14 = i11;
                        zArr3 = zArr2;
                        if (z) {
                        }
                        solverVariable9 = solverVariable4;
                        solverVariable8 = solverVariable3;
                        solverVariable7 = solverVariable2;
                        i16 = 0;
                        i15 = 8;
                        r18 = 1;
                        z20 = true;
                        if (this.mVerticalResolution == 2) {
                        }
                        if (z20) {
                        }
                        solverVariable11 = solverVariable9;
                        solverVariable10 = solverVariable8;
                        if (z11) {
                        }
                        if (constraintAnchor9.isConnected()) {
                        }
                        this.mResolvedHorizontal = false;
                        this.mResolvedVertical = false;
                    }
                    i11 = i19;
                    constraintAnchor5 = constraintAnchor;
                    i9 = i6;
                    z11 = true;
                    i10 = i20;
                    int[] iArr5222 = this.mResolvedMatchConstraintDefault;
                    iArr5222[0] = i11;
                    iArr5222[1] = i10;
                    if (!z11) {
                    }
                    z12 = false;
                    if (z11) {
                    }
                    z13 = false;
                    if (iArr[0] == 2) {
                    }
                    z14 = false;
                    if (z14) {
                    }
                    constraintAnchor6 = this.mCenter;
                    z15 = !constraintAnchor6.isConnected();
                    z16 = zArr4[0];
                    boolean z282222 = zArr4[1];
                    i13 = this.mHorizontalResolution;
                    iArr2 = this.mMaxDimension;
                    SolverVariable solverVariable152222 = null;
                    if (i13 != 2) {
                    }
                    constraintAnchor7 = constraintAnchor5;
                    solverVariable6 = createObjectVariable;
                    solverVariable5 = createObjectVariable2;
                    constraintAnchor9 = constraintAnchor6;
                    iArr3 = iArr2;
                    solverVariable2 = createObjectVariable5;
                    z17 = z7;
                    z19 = z4;
                    z18 = z27;
                    solverVariable4 = createObjectVariable3;
                    constraintAnchor8 = constraintAnchor4;
                    solverVariable3 = solverVariable;
                    i14 = i11;
                    zArr3 = zArr2;
                    if (z) {
                    }
                    solverVariable9 = solverVariable4;
                    solverVariable8 = solverVariable3;
                    solverVariable7 = solverVariable2;
                    i16 = 0;
                    i15 = 8;
                    r18 = 1;
                    z20 = true;
                    if (this.mVerticalResolution == 2) {
                    }
                    if (z20) {
                    }
                    solverVariable11 = solverVariable9;
                    solverVariable10 = solverVariable8;
                    if (z11) {
                    }
                    if (constraintAnchor9.isConnected()) {
                    }
                    this.mResolvedHorizontal = false;
                    this.mResolvedVertical = false;
                }
            } else {
                constraintAnchor4 = constraintAnchor13;
            }
            solverVariable = createObjectVariable4;
            constraintAnchor5 = constraintAnchor;
            i9 = i6;
            i11 = i25;
            i10 = i26;
            z11 = false;
            int[] iArr52222 = this.mResolvedMatchConstraintDefault;
            iArr52222[0] = i11;
            iArr52222[1] = i10;
            if (!z11) {
            }
            z12 = false;
            if (z11) {
            }
            z13 = false;
            if (iArr[0] == 2) {
            }
            z14 = false;
            if (z14) {
            }
            constraintAnchor6 = this.mCenter;
            z15 = !constraintAnchor6.isConnected();
            z16 = zArr4[0];
            boolean z2822222 = zArr4[1];
            i13 = this.mHorizontalResolution;
            iArr2 = this.mMaxDimension;
            SolverVariable solverVariable1522222 = null;
            if (i13 != 2) {
            }
            constraintAnchor7 = constraintAnchor5;
            solverVariable6 = createObjectVariable;
            solverVariable5 = createObjectVariable2;
            constraintAnchor9 = constraintAnchor6;
            iArr3 = iArr2;
            solverVariable2 = createObjectVariable5;
            z17 = z7;
            z19 = z4;
            z18 = z27;
            solverVariable4 = createObjectVariable3;
            constraintAnchor8 = constraintAnchor4;
            solverVariable3 = solverVariable;
            i14 = i11;
            zArr3 = zArr2;
            if (z) {
            }
            solverVariable9 = solverVariable4;
            solverVariable8 = solverVariable3;
            solverVariable7 = solverVariable2;
            i16 = 0;
            i15 = 8;
            r18 = 1;
            z20 = true;
            if (this.mVerticalResolution == 2) {
            }
            if (z20) {
            }
            solverVariable11 = solverVariable9;
            solverVariable10 = solverVariable8;
            if (z11) {
            }
            if (constraintAnchor9.isConnected()) {
            }
            this.mResolvedHorizontal = false;
            this.mResolvedVertical = false;
        }
        c = 0;
        z3 = false;
        z2 = false;
        i = this.mVisibility;
        boolean[] zArr42 = this.mIsInBarrier;
        boolean z262 = z3;
        if (i != 8) {
        }
        z5 = this.mResolvedHorizontal;
        if (!z5) {
        }
        if (z5) {
        }
        if (this.mResolvedVertical) {
        }
        if (this.mResolvedHorizontal) {
            this.mResolvedHorizontal = false;
            this.mResolvedVertical = false;
            return;
        }
        zArr = this.isTerminalWidget;
        if (z) {
        }
        constraintAnchor = constraintAnchor14;
        zArr2 = zArr;
        if (this.mParent == null) {
        }
        i2 = this.mWidth;
        i3 = this.mMinWidth;
        if (i2 >= i3) {
        }
        i4 = this.mHeight;
        ConstraintAnchor constraintAnchor152 = constraintAnchor3;
        i5 = this.mMinHeight;
        if (i4 >= i5) {
        }
        iArr = this.mListDimensionBehaviors;
        i7 = iArr[0];
        boolean z272 = z8;
        if (i7 == 3) {
        }
        i8 = iArr[1];
        if (i8 == 3) {
        }
        int i242 = this.mDimensionRatioSide;
        this.mResolvedDimensionRatioSide = i242;
        f = this.mDimensionRatio;
        this.mResolvedDimensionRatio = f;
        int i252 = this.mMatchConstraintDefaultWidth;
        int i262 = this.mMatchConstraintDefaultHeight;
        if (f <= 0.0f) {
        }
        solverVariable = createObjectVariable4;
        constraintAnchor5 = constraintAnchor;
        i9 = i6;
        i11 = i252;
        i10 = i262;
        z11 = false;
        int[] iArr522222 = this.mResolvedMatchConstraintDefault;
        iArr522222[0] = i11;
        iArr522222[1] = i10;
        if (!z11) {
        }
        z12 = false;
        if (z11) {
        }
        z13 = false;
        if (iArr[0] == 2) {
        }
        z14 = false;
        if (z14) {
        }
        constraintAnchor6 = this.mCenter;
        z15 = !constraintAnchor6.isConnected();
        z16 = zArr42[0];
        boolean z28222222 = zArr42[1];
        i13 = this.mHorizontalResolution;
        iArr2 = this.mMaxDimension;
        SolverVariable solverVariable15222222 = null;
        if (i13 != 2) {
        }
        constraintAnchor7 = constraintAnchor5;
        solverVariable6 = createObjectVariable;
        solverVariable5 = createObjectVariable2;
        constraintAnchor9 = constraintAnchor6;
        iArr3 = iArr2;
        solverVariable2 = createObjectVariable5;
        z17 = z7;
        z19 = z4;
        z18 = z272;
        solverVariable4 = createObjectVariable3;
        constraintAnchor8 = constraintAnchor4;
        solverVariable3 = solverVariable;
        i14 = i11;
        zArr3 = zArr2;
        if (z) {
        }
        solverVariable9 = solverVariable4;
        solverVariable8 = solverVariable3;
        solverVariable7 = solverVariable2;
        i16 = 0;
        i15 = 8;
        r18 = 1;
        z20 = true;
        if (this.mVerticalResolution == 2) {
        }
        if (z20) {
        }
        solverVariable11 = solverVariable9;
        solverVariable10 = solverVariable8;
        if (z11) {
        }
        if (constraintAnchor9.isConnected()) {
        }
        this.mResolvedHorizontal = false;
        this.mResolvedVertical = false;
    }

    public boolean allowedInBarrier() {
        if (this.mVisibility != 8) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0195 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:212:0x03a3 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:217:0x03b0  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x03e9  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x03f8  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x0406  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x0426 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:253:0x043d  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x048a  */
    /* JADX WARN: Removed duplicated region for block: B:289:0x049a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:301:0x04b9 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:311:0x04d0 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:337:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:340:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00c8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void applyConstraints(LinearSystem linearSystem, boolean z, boolean z2, boolean z3, boolean z4, SolverVariable solverVariable, SolverVariable solverVariable2, int i, boolean z5, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i2, int i3, int i4, int i5, float f, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, int i6, int i7, int i8, int i9, float f2, boolean z11) {
        boolean z12;
        boolean z13;
        int i10;
        boolean z14;
        int i11;
        int i12;
        boolean z15;
        ConstraintAnchor constraintAnchor3;
        boolean z16;
        boolean z17;
        ConstraintAnchor constraintAnchor4;
        int i13;
        SolverVariable solverVariable3;
        SolverVariable solverVariable4;
        boolean z18;
        boolean z19;
        boolean z20;
        int i14;
        int i15;
        int i16;
        int i17;
        SolverVariable solverVariable5;
        SolverVariable solverVariable6;
        SolverVariable solverVariable7;
        boolean z21;
        int i18;
        int i19;
        ConstraintWidget constraintWidget;
        boolean z22;
        int i20;
        int i21;
        HashSet hashSet;
        boolean z23;
        int i22;
        int i23;
        int i24;
        boolean z24;
        boolean z25;
        int i25;
        int i26;
        SolverVariable solverVariable8;
        SolverVariable solverVariable9;
        LinearSystem linearSystem2 = linearSystem;
        int i27 = i8;
        int i28 = i9;
        SolverVariable createObjectVariable = linearSystem2.createObjectVariable(constraintAnchor);
        SolverVariable createObjectVariable2 = linearSystem2.createObjectVariable(constraintAnchor2);
        SolverVariable createObjectVariable3 = linearSystem2.createObjectVariable(constraintAnchor.mTarget);
        SolverVariable createObjectVariable4 = linearSystem2.createObjectVariable(constraintAnchor2.mTarget);
        boolean isConnected = constraintAnchor.isConnected();
        boolean isConnected2 = constraintAnchor2.isConnected();
        boolean isConnected3 = this.mCenter.isConnected();
        int i29 = isConnected2 ? (isConnected ? 1 : 0) + 1 : isConnected ? 1 : 0;
        if (isConnected3) {
            i29++;
        }
        int i30 = i29;
        int i31 = z6 ? 3 : i6;
        int ordinal = SolverVariable$Type$EnumUnboxingSharedUtility.ordinal(i);
        boolean z26 = (ordinal == 0 || ordinal == 1 || ordinal != 2 || i31 == 4) ? false : true;
        int i32 = this.mWidthOverride;
        if (i32 == -1 || !z) {
            i32 = i3;
            z12 = z26;
        } else {
            this.mWidthOverride = -1;
            z12 = false;
        }
        int i33 = this.mHeightOverride;
        if (i33 == -1 || z) {
            z13 = z12;
        } else {
            this.mHeightOverride = -1;
            i32 = i33;
            z13 = false;
        }
        boolean z27 = z13;
        if (this.mVisibility == 8) {
            z27 = false;
            i10 = 0;
        } else {
            i10 = i32;
        }
        if (z11) {
            if (!isConnected && !isConnected2 && !isConnected3) {
                linearSystem2.addEquality(createObjectVariable, i2);
            } else if (isConnected && !isConnected2) {
                z14 = z27;
                i11 = 8;
                linearSystem2.addEquality(createObjectVariable, createObjectVariable3, constraintAnchor.getMargin(), 8);
                if (!z14) {
                    if (i30 == 2 || z6 || !(i31 == 1 || i31 == 0)) {
                        if (i27 == -2) {
                            i27 = i10;
                        }
                        if (i28 == -2) {
                            i28 = i10;
                        }
                        if (i10 > 0 && i31 != 1) {
                            i10 = 0;
                        }
                        if (i27 > 0) {
                            linearSystem2.addGreaterThan(createObjectVariable2, createObjectVariable, i27, 8);
                            i10 = Math.max(i10, i27);
                        }
                        if (i28 > 0) {
                            if (!z2 || i31 != 1) {
                                linearSystem2.addLowerThan(createObjectVariable2, createObjectVariable, i28, 8);
                            }
                            i10 = Math.min(i10, i28);
                        }
                        if (i31 == 1) {
                            if (z2) {
                                linearSystem2.addEquality(createObjectVariable2, createObjectVariable, i10, 8);
                            } else if (z8) {
                                linearSystem2.addEquality(createObjectVariable2, createObjectVariable, i10, 5);
                                linearSystem2.addLowerThan(createObjectVariable2, createObjectVariable, i10, 8);
                            } else {
                                linearSystem2.addEquality(createObjectVariable2, createObjectVariable, i10, 5);
                                linearSystem2.addLowerThan(createObjectVariable2, createObjectVariable, i10, 8);
                            }
                        } else if (i31 == 2) {
                            int i34 = constraintAnchor.mType;
                            if (i34 == 3 || i34 == 5) {
                                solverVariable9 = linearSystem2.createObjectVariable(this.mParent.getAnchor(3));
                                solverVariable8 = linearSystem2.createObjectVariable(this.mParent.getAnchor(5));
                            } else {
                                solverVariable9 = linearSystem2.createObjectVariable(this.mParent.getAnchor(2));
                                solverVariable8 = linearSystem2.createObjectVariable(this.mParent.getAnchor(4));
                            }
                            ArrayRow createRow = linearSystem2.createRow();
                            i12 = i27;
                            createRow.variables.put(createObjectVariable2, -1.0f);
                            createRow.variables.put(createObjectVariable, 1.0f);
                            createRow.variables.put(solverVariable8, f2);
                            createRow.variables.put(solverVariable9, -f2);
                            linearSystem2.addConstraint(createRow);
                            if (z2) {
                                z14 = false;
                            }
                            z15 = z4;
                        } else {
                            i12 = i27;
                            z15 = true;
                        }
                    } else {
                        int max = Math.max(i27, i10);
                        if (i28 > 0) {
                            max = Math.min(i28, max);
                        }
                        linearSystem2.addEquality(createObjectVariable2, createObjectVariable, max, 8);
                        z15 = z4;
                        i12 = i27;
                        z14 = false;
                    }
                    if (z11 || z8) {
                        boolean z28 = z15;
                        if (i30 >= 2 && z2 && z28) {
                            linearSystem2.addGreaterThan(createObjectVariable, solverVariable, 0, 8);
                            ConstraintAnchor constraintAnchor5 = this.mBaseline;
                            boolean z29 = z || constraintAnchor5.mTarget == null;
                            if (!z && (constraintAnchor3 = constraintAnchor5.mTarget) != null) {
                                ConstraintWidget constraintWidget2 = constraintAnchor3.mOwner;
                                if (constraintWidget2.mDimensionRatio != 0.0f) {
                                    int[] iArr = constraintWidget2.mListDimensionBehaviors;
                                    if (iArr[0] == 3 && iArr[1] == 3) {
                                        z29 = true;
                                    }
                                }
                                z29 = false;
                            }
                            if (z29) {
                                linearSystem2.addGreaterThan(solverVariable2, createObjectVariable2, 0, 8);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    if (!isConnected && !isConnected2 && !isConnected3) {
                        constraintAnchor4 = constraintAnchor2;
                        solverVariable3 = createObjectVariable2;
                        z16 = z15;
                        solverVariable4 = createObjectVariable4;
                    } else if (!isConnected || isConnected2) {
                        if (isConnected || !isConnected2) {
                            solverVariable4 = createObjectVariable4;
                            if (isConnected && isConnected2) {
                                ConstraintWidget constraintWidget3 = constraintAnchor.mTarget.mOwner;
                                ConstraintWidget constraintWidget4 = constraintAnchor2.mTarget.mOwner;
                                z16 = z15;
                                ConstraintWidget constraintWidget5 = this.mParent;
                                int i35 = 6;
                                if (z14) {
                                    if (i31 == 0) {
                                        if (i28 != 0 || i12 != 0) {
                                            i26 = 5;
                                            i25 = 5;
                                            z25 = true;
                                            z24 = false;
                                            z19 = true;
                                        } else if (!createObjectVariable3.isFinalValue || !solverVariable4.isFinalValue) {
                                            i26 = 8;
                                            i25 = 8;
                                            z25 = false;
                                            z24 = true;
                                            z19 = false;
                                        } else {
                                            linearSystem2.addEquality(createObjectVariable, createObjectVariable3, constraintAnchor.getMargin(), 8);
                                            linearSystem2.addEquality(createObjectVariable2, solverVariable4, -constraintAnchor2.getMargin(), 8);
                                            return;
                                        }
                                        if ((constraintWidget3 instanceof Barrier) || (constraintWidget4 instanceof Barrier)) {
                                            linearSystem2 = linearSystem;
                                            i15 = i31;
                                            solverVariable7 = createObjectVariable;
                                            solverVariable3 = createObjectVariable2;
                                            z18 = z24;
                                            solverVariable6 = solverVariable2;
                                            i17 = i26;
                                            solverVariable5 = createObjectVariable3;
                                            z20 = z25;
                                            i16 = 6;
                                            i14 = 4;
                                            if (z19 || solverVariable5 != solverVariable4 || constraintWidget3 == constraintWidget5) {
                                                z21 = true;
                                            } else {
                                                z19 = false;
                                                z21 = false;
                                            }
                                            if (!z20) {
                                                if (z14 || z7 || z9 || solverVariable5 != solverVariable || solverVariable4 != solverVariable6) {
                                                    z17 = z2;
                                                    z23 = z21;
                                                    i22 = i17;
                                                } else {
                                                    i16 = 8;
                                                    z17 = false;
                                                    i22 = 8;
                                                    z23 = false;
                                                }
                                                SolverVariable solverVariable10 = solverVariable5;
                                                i18 = i12;
                                                i19 = i15;
                                                constraintWidget = constraintWidget4;
                                                constraintAnchor4 = constraintAnchor2;
                                                linearSystem2.addCentering(solverVariable7, solverVariable10, constraintAnchor.getMargin(), f, solverVariable4, solverVariable3, constraintAnchor2.getMargin(), i16);
                                                solverVariable5 = solverVariable10;
                                                i17 = i22;
                                                z21 = z23;
                                            } else {
                                                constraintWidget = constraintWidget4;
                                                i18 = i12;
                                                i19 = i15;
                                                constraintAnchor4 = constraintAnchor2;
                                                z17 = z2;
                                            }
                                            if (this.mVisibility == 8 || ((hashSet = constraintAnchor4.mDependents) != null && hashSet.size() > 0)) {
                                                if (z19) {
                                                    if (z17 && solverVariable5 != solverVariable4 && !z14 && ((constraintWidget3 instanceof Barrier) || (constraintWidget instanceof Barrier))) {
                                                        i17 = 6;
                                                    }
                                                    linearSystem2.addGreaterThan(solverVariable7, solverVariable5, constraintAnchor.getMargin(), i17);
                                                    linearSystem2.addLowerThan(solverVariable3, solverVariable4, -constraintAnchor4.getMargin(), i17);
                                                }
                                                if (z17 || !z10 || (constraintWidget3 instanceof Barrier) || (constraintWidget instanceof Barrier) || constraintWidget == constraintWidget5) {
                                                    i20 = i14;
                                                    z22 = z21;
                                                } else {
                                                    i20 = 6;
                                                    i17 = 6;
                                                    z22 = true;
                                                }
                                                if (z22) {
                                                    if (z18 && (!z9 || z3)) {
                                                        if (!(constraintWidget3 == constraintWidget5 || constraintWidget == constraintWidget5)) {
                                                            i35 = i20;
                                                        }
                                                        if ((constraintWidget3 instanceof Guideline) || (constraintWidget instanceof Guideline)) {
                                                            i35 = 5;
                                                        }
                                                        if ((constraintWidget3 instanceof Barrier) || (constraintWidget instanceof Barrier)) {
                                                            i35 = 5;
                                                        }
                                                        i20 = Math.max(z9 ? 5 : i35, i20);
                                                    }
                                                    if (z17) {
                                                        i20 = Math.min(i17, i20);
                                                        if (z6 && !z9 && (constraintWidget3 == constraintWidget5 || constraintWidget == constraintWidget5)) {
                                                            i21 = 4;
                                                            linearSystem2.addEquality(solverVariable7, solverVariable5, constraintAnchor.getMargin(), i21);
                                                            linearSystem2.addEquality(solverVariable3, solverVariable4, -constraintAnchor4.getMargin(), i21);
                                                        }
                                                    }
                                                    i21 = i20;
                                                    linearSystem2.addEquality(solverVariable7, solverVariable5, constraintAnchor.getMargin(), i21);
                                                    linearSystem2.addEquality(solverVariable3, solverVariable4, -constraintAnchor4.getMargin(), i21);
                                                }
                                                if (z17) {
                                                    int margin = solverVariable == solverVariable5 ? constraintAnchor.getMargin() : 0;
                                                    if (solverVariable5 != solverVariable) {
                                                        linearSystem2.addGreaterThan(solverVariable7, solverVariable, margin, 5);
                                                    }
                                                }
                                                if (z17 && z14 && i4 == 0 && i18 == 0) {
                                                    if (z14 || i19 != 3) {
                                                        linearSystem2.addGreaterThan(solverVariable3, solverVariable7, 0, 5);
                                                    } else {
                                                        linearSystem2.addGreaterThan(solverVariable3, solverVariable7, 0, 8);
                                                    }
                                                }
                                            } else {
                                                return;
                                            }
                                        } else {
                                            linearSystem2 = linearSystem;
                                            solverVariable7 = createObjectVariable;
                                            solverVariable3 = createObjectVariable2;
                                            z18 = z24;
                                            i17 = i26;
                                            solverVariable5 = createObjectVariable3;
                                            z20 = z25;
                                            i16 = 6;
                                            i14 = i25;
                                            i15 = i31;
                                            solverVariable6 = solverVariable2;
                                            if (z19) {
                                            }
                                            z21 = true;
                                            if (!z20) {
                                            }
                                            if (this.mVisibility == 8) {
                                            }
                                            if (z19) {
                                            }
                                            if (z17) {
                                            }
                                            i20 = i14;
                                            z22 = z21;
                                            if (z22) {
                                            }
                                            if (z17) {
                                            }
                                            if (z17) {
                                                if (z14) {
                                                }
                                                linearSystem2.addGreaterThan(solverVariable3, solverVariable7, 0, 5);
                                            }
                                        }
                                    } else {
                                        if (i31 == 2) {
                                            if ((constraintWidget3 instanceof Barrier) || (constraintWidget4 instanceof Barrier)) {
                                                linearSystem2 = linearSystem;
                                                i15 = i31;
                                                solverVariable7 = createObjectVariable;
                                                solverVariable3 = createObjectVariable2;
                                                solverVariable5 = createObjectVariable3;
                                                i17 = 5;
                                            } else {
                                                linearSystem2 = linearSystem;
                                                i15 = i31;
                                                solverVariable7 = createObjectVariable;
                                                solverVariable3 = createObjectVariable2;
                                                solverVariable5 = createObjectVariable3;
                                                i17 = 5;
                                                i16 = 6;
                                                i14 = 5;
                                                z20 = true;
                                                z19 = true;
                                                z18 = false;
                                                solverVariable6 = solverVariable2;
                                                if (z19) {
                                                }
                                                z21 = true;
                                                if (!z20) {
                                                }
                                                if (this.mVisibility == 8) {
                                                }
                                                if (z19) {
                                                }
                                                if (z17) {
                                                }
                                                i20 = i14;
                                                z22 = z21;
                                                if (z22) {
                                                }
                                                if (z17) {
                                                }
                                                if (z17) {
                                                }
                                            }
                                        } else if (i31 == 1) {
                                            linearSystem2 = linearSystem;
                                            i15 = i31;
                                            solverVariable7 = createObjectVariable;
                                            solverVariable3 = createObjectVariable2;
                                            solverVariable5 = createObjectVariable3;
                                            i17 = 8;
                                        } else if (i31 == 3) {
                                            i15 = i31;
                                            if (this.mResolvedDimensionRatioSide != -1) {
                                                if (z6) {
                                                    if (i7 == 2 || i7 == 1) {
                                                        i23 = 5;
                                                        i24 = 4;
                                                    } else {
                                                        i23 = 8;
                                                        i24 = 5;
                                                    }
                                                    i14 = i24;
                                                    solverVariable7 = createObjectVariable;
                                                    solverVariable3 = createObjectVariable2;
                                                    solverVariable5 = createObjectVariable3;
                                                    i16 = 6;
                                                    z20 = true;
                                                    z19 = true;
                                                    z18 = true;
                                                    solverVariable6 = solverVariable2;
                                                } else if (i28 > 0) {
                                                    linearSystem2 = linearSystem;
                                                    solverVariable6 = solverVariable2;
                                                    solverVariable7 = createObjectVariable;
                                                    solverVariable3 = createObjectVariable2;
                                                    solverVariable5 = createObjectVariable3;
                                                    i17 = 5;
                                                    i16 = 6;
                                                } else {
                                                    if (i28 != 0 || i12 != 0) {
                                                        linearSystem2 = linearSystem;
                                                        solverVariable6 = solverVariable2;
                                                        solverVariable7 = createObjectVariable;
                                                        solverVariable3 = createObjectVariable2;
                                                        solverVariable5 = createObjectVariable3;
                                                        i17 = 5;
                                                        i16 = 6;
                                                        i14 = 4;
                                                    } else if (!z9) {
                                                        linearSystem2 = linearSystem;
                                                        solverVariable6 = solverVariable2;
                                                        solverVariable7 = createObjectVariable;
                                                        solverVariable3 = createObjectVariable2;
                                                        solverVariable5 = createObjectVariable3;
                                                        i17 = 5;
                                                        i16 = 6;
                                                        i14 = 8;
                                                    } else {
                                                        i23 = (constraintWidget3 == constraintWidget5 || constraintWidget4 == constraintWidget5) ? 5 : 4;
                                                        solverVariable6 = solverVariable2;
                                                        solverVariable7 = createObjectVariable;
                                                        solverVariable3 = createObjectVariable2;
                                                        solverVariable5 = createObjectVariable3;
                                                        i16 = 6;
                                                        i14 = 4;
                                                        z20 = true;
                                                        z19 = true;
                                                        z18 = true;
                                                    }
                                                    z20 = true;
                                                    z19 = true;
                                                    z18 = true;
                                                    if (z19) {
                                                    }
                                                    z21 = true;
                                                    if (!z20) {
                                                    }
                                                    if (this.mVisibility == 8) {
                                                    }
                                                    if (z19) {
                                                    }
                                                    if (z17) {
                                                    }
                                                    i20 = i14;
                                                    z22 = z21;
                                                    if (z22) {
                                                    }
                                                    if (z17) {
                                                    }
                                                    if (z17) {
                                                    }
                                                }
                                                i17 = i23;
                                                linearSystem2 = linearSystem;
                                                if (z19) {
                                                }
                                                z21 = true;
                                                if (!z20) {
                                                }
                                                if (this.mVisibility == 8) {
                                                }
                                                if (z19) {
                                                }
                                                if (z17) {
                                                }
                                                i20 = i14;
                                                z22 = z21;
                                                if (z22) {
                                                }
                                                if (z17) {
                                                }
                                                if (z17) {
                                                }
                                            } else if (z9) {
                                                linearSystem2 = linearSystem;
                                                solverVariable6 = solverVariable2;
                                                solverVariable7 = createObjectVariable;
                                                solverVariable3 = createObjectVariable2;
                                                solverVariable5 = createObjectVariable3;
                                                i17 = 8;
                                                i16 = z2 ? 5 : 4;
                                            } else {
                                                linearSystem2 = linearSystem;
                                                solverVariable6 = solverVariable2;
                                                solverVariable7 = createObjectVariable;
                                                solverVariable3 = createObjectVariable2;
                                                solverVariable5 = createObjectVariable3;
                                                i17 = 8;
                                                i16 = 8;
                                            }
                                            i14 = 5;
                                            z20 = true;
                                            z19 = true;
                                            z18 = true;
                                            if (z19) {
                                            }
                                            z21 = true;
                                            if (!z20) {
                                            }
                                            if (this.mVisibility == 8) {
                                            }
                                            if (z19) {
                                            }
                                            if (z17) {
                                            }
                                            i20 = i14;
                                            z22 = z21;
                                            if (z22) {
                                            }
                                            if (z17) {
                                            }
                                            if (z17) {
                                            }
                                        } else {
                                            i15 = i31;
                                            linearSystem2 = linearSystem;
                                            solverVariable6 = solverVariable2;
                                            solverVariable7 = createObjectVariable;
                                            solverVariable3 = createObjectVariable2;
                                            solverVariable5 = createObjectVariable3;
                                            i17 = 5;
                                            i16 = 6;
                                            i14 = 4;
                                            z20 = false;
                                            z19 = false;
                                        }
                                        i16 = 6;
                                        i14 = 4;
                                        z20 = true;
                                        z19 = true;
                                        z18 = false;
                                        solverVariable6 = solverVariable2;
                                        if (z19) {
                                        }
                                        z21 = true;
                                        if (!z20) {
                                        }
                                        if (this.mVisibility == 8) {
                                        }
                                        if (z19) {
                                        }
                                        if (z17) {
                                        }
                                        i20 = i14;
                                        z22 = z21;
                                        if (z22) {
                                        }
                                        if (z17) {
                                        }
                                        if (z17) {
                                        }
                                    }
                                    i13 = 5;
                                    if (z17 && z16) {
                                        int margin2 = constraintAnchor4.mTarget != null ? constraintAnchor4.getMargin() : 0;
                                        if (solverVariable4 != solverVariable2) {
                                            linearSystem2.addGreaterThan(solverVariable2, solverVariable3, margin2, i13);
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                i15 = i31;
                                if (!createObjectVariable3.isFinalValue || !solverVariable4.isFinalValue) {
                                    linearSystem2 = linearSystem;
                                    solverVariable6 = solverVariable2;
                                    solverVariable7 = createObjectVariable;
                                    solverVariable3 = createObjectVariable2;
                                    solverVariable5 = createObjectVariable3;
                                    i17 = 5;
                                    i16 = 6;
                                    i14 = 4;
                                    z20 = true;
                                    z19 = true;
                                } else {
                                    linearSystem.addCentering(createObjectVariable, createObjectVariable3, constraintAnchor.getMargin(), f, solverVariable4, createObjectVariable2, constraintAnchor2.getMargin(), 8);
                                    if (z2 && z16) {
                                        int margin3 = constraintAnchor2.mTarget != null ? constraintAnchor2.getMargin() : 0;
                                        if (solverVariable4 != solverVariable2) {
                                            linearSystem.addGreaterThan(solverVariable2, createObjectVariable2, margin3, 5);
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                z18 = false;
                                if (z19) {
                                }
                                z21 = true;
                                if (!z20) {
                                }
                                if (this.mVisibility == 8) {
                                }
                                if (z19) {
                                }
                                if (z17) {
                                }
                                i20 = i14;
                                z22 = z21;
                                if (z22) {
                                }
                                if (z17) {
                                }
                                if (z17) {
                                }
                                i13 = 5;
                                if (z17) {
                                    return;
                                }
                                return;
                            }
                        } else {
                            solverVariable4 = createObjectVariable4;
                            linearSystem2.addEquality(createObjectVariable2, solverVariable4, -constraintAnchor2.getMargin(), 8);
                            if (z2) {
                                linearSystem2.addGreaterThan(createObjectVariable, solverVariable, 0, 5);
                            }
                        }
                        constraintAnchor4 = constraintAnchor2;
                        solverVariable3 = createObjectVariable2;
                        z16 = z15;
                    } else {
                        constraintAnchor4 = constraintAnchor2;
                        solverVariable3 = createObjectVariable2;
                        z16 = z15;
                        solverVariable4 = createObjectVariable4;
                        z17 = z2;
                        i13 = (!z2 || !(constraintAnchor.mTarget.mOwner instanceof Barrier)) ? 5 : 8;
                        if (z17) {
                        }
                    }
                    z17 = z2;
                    i13 = 5;
                    if (z17) {
                    }
                } else if (z5) {
                    linearSystem2.addEquality(createObjectVariable2, createObjectVariable, 0, 3);
                    if (i4 > 0) {
                        linearSystem2.addGreaterThan(createObjectVariable2, createObjectVariable, i4, i11);
                    }
                    if (i5 < Integer.MAX_VALUE) {
                        linearSystem2.addLowerThan(createObjectVariable2, createObjectVariable, i5, i11);
                    }
                } else {
                    linearSystem2.addEquality(createObjectVariable2, createObjectVariable, i10, i11);
                }
                z15 = z4;
                i12 = i27;
                if (z11) {
                }
                boolean z282 = z15;
                if (i30 >= 2) {
                    return;
                }
                return;
            }
        }
        z14 = z27;
        i11 = 8;
        if (!z14) {
        }
        z15 = z4;
        i12 = i27;
        if (z11) {
        }
        boolean z2822 = z15;
        if (i30 >= 2) {
        }
    }

    public final void connect(ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i) {
        if (constraintAnchor.mOwner == this) {
            connect(constraintAnchor.mType, constraintAnchor2.mOwner, constraintAnchor2.mType, i);
        }
    }

    public final void createObjectVariables(LinearSystem linearSystem) {
        linearSystem.createObjectVariable(this.mLeft);
        linearSystem.createObjectVariable(this.mTop);
        linearSystem.createObjectVariable(this.mRight);
        linearSystem.createObjectVariable(this.mBottom);
        if (this.mBaselineDistance > 0) {
            linearSystem.createObjectVariable(this.mBaseline);
        }
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun, androidx.constraintlayout.core.widgets.analyzer.WidgetRun] */
    /* JADX WARN: Type inference failed for: r0v3, types: [androidx.constraintlayout.core.widgets.analyzer.WidgetRun, androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun] */
    public final void ensureWidgetRuns() {
        if (this.mHorizontalRun == null) {
            ?? widgetRun = new WidgetRun(this);
            widgetRun.start.mType = 4;
            widgetRun.end.mType = 5;
            widgetRun.orientation = 0;
            this.mHorizontalRun = widgetRun;
        }
        if (this.mVerticalRun == null) {
            ?? widgetRun2 = new WidgetRun(this);
            DependencyNode dependencyNode = new DependencyNode(widgetRun2);
            widgetRun2.baseline = dependencyNode;
            widgetRun2.mBaselineDimension = null;
            widgetRun2.start.mType = 6;
            widgetRun2.end.mType = 7;
            dependencyNode.mType = 8;
            widgetRun2.orientation = 1;
            this.mVerticalRun = widgetRun2;
        }
    }

    public ConstraintAnchor getAnchor(int i) {
        switch (SolverVariable$Type$EnumUnboxingSharedUtility.ordinal(i)) {
            case 0:
                return null;
            case 1:
                return this.mLeft;
            case 2:
                return this.mTop;
            case 3:
                return this.mRight;
            case 4:
                return this.mBottom;
            case 5:
                return this.mBaseline;
            case 6:
                return this.mCenter;
            case 7:
                return this.mCenterX;
            case 8:
                return this.mCenterY;
            default:
                throw new AssertionError(ViewModelProvider.Factory.CC.name(i));
        }
    }

    public final int getDimensionBehaviour(int i) {
        int[] iArr = this.mListDimensionBehaviors;
        if (i == 0) {
            return iArr[0];
        }
        if (i == 1) {
            return iArr[1];
        }
        return 0;
    }

    public final int getHeight() {
        if (this.mVisibility == 8) {
            return 0;
        }
        return this.mHeight;
    }

    public final ConstraintWidget getNextChainMember(int i) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        if (i == 0) {
            ConstraintAnchor constraintAnchor3 = this.mRight;
            ConstraintAnchor constraintAnchor4 = constraintAnchor3.mTarget;
            if (constraintAnchor4 == null || constraintAnchor4.mTarget != constraintAnchor3) {
                return null;
            }
            return constraintAnchor4.mOwner;
        } else if (i == 1 && (constraintAnchor2 = (constraintAnchor = this.mBottom).mTarget) != null && constraintAnchor2.mTarget == constraintAnchor) {
            return constraintAnchor2.mOwner;
        } else {
            return null;
        }
    }

    public final ConstraintWidget getPreviousChainMember(int i) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        if (i == 0) {
            ConstraintAnchor constraintAnchor3 = this.mLeft;
            ConstraintAnchor constraintAnchor4 = constraintAnchor3.mTarget;
            if (constraintAnchor4 == null || constraintAnchor4.mTarget != constraintAnchor3) {
                return null;
            }
            return constraintAnchor4.mOwner;
        } else if (i == 1 && (constraintAnchor2 = (constraintAnchor = this.mTop).mTarget) != null && constraintAnchor2.mTarget == constraintAnchor) {
            return constraintAnchor2.mOwner;
        } else {
            return null;
        }
    }

    public void getSceneString(StringBuilder sb) {
        sb.append("  " + this.stringId + ":{\n");
        StringBuilder sb2 = new StringBuilder("    actualWidth:");
        sb2.append(this.mWidth);
        sb.append(sb2.toString());
        sb.append("\n");
        sb.append("    actualHeight:" + this.mHeight);
        sb.append("\n");
        sb.append("    actualLeft:" + this.f2mX);
        sb.append("\n");
        sb.append("    actualTop:" + this.f3mY);
        sb.append("\n");
        getSceneString(sb, "left", this.mLeft);
        getSceneString(sb, "top", this.mTop);
        getSceneString(sb, "right", this.mRight);
        getSceneString(sb, "bottom", this.mBottom);
        getSceneString(sb, "baseline", this.mBaseline);
        getSceneString(sb, "centerX", this.mCenterX);
        getSceneString(sb, "centerY", this.mCenterY);
        int i = this.mWidth;
        int i2 = this.mMinWidth;
        int[] iArr = this.mMaxDimension;
        int i3 = iArr[0];
        int i4 = this.mMatchConstraintMinWidth;
        int i5 = this.mMatchConstraintDefaultWidth;
        float f = this.mMatchConstraintPercentWidth;
        int[] iArr2 = this.mListDimensionBehaviors;
        int i6 = iArr2[0];
        float[] fArr = this.mWeight;
        float f2 = fArr[0];
        getSceneString(sb, "    width", i, i2, i3, i4, i5, f, i6);
        int i7 = this.mHeight;
        int i8 = this.mMinHeight;
        int i9 = iArr[1];
        int i10 = this.mMatchConstraintMinHeight;
        int i11 = this.mMatchConstraintDefaultHeight;
        float f3 = this.mMatchConstraintPercentHeight;
        int i12 = iArr2[1];
        float f4 = fArr[1];
        getSceneString(sb, "    height", i7, i8, i9, i10, i11, f3, i12);
        float f5 = this.mDimensionRatio;
        int i13 = this.mDimensionRatioSide;
        if (f5 != 0.0f) {
            sb.append("    dimensionRatio");
            sb.append(" :  [");
            sb.append(f5);
            sb.append(",");
            sb.append(i13);
            sb.append("");
            sb.append("],\n");
        }
        serializeAttribute(sb, "    horizontalBias", this.mHorizontalBiasPercent, 0.5f);
        serializeAttribute(sb, "    verticalBias", this.mVerticalBiasPercent, 0.5f);
        serializeAttribute(this.mHorizontalChainStyle, 0, "    horizontalChainStyle", sb);
        serializeAttribute(this.mVerticalChainStyle, 0, "    verticalChainStyle", sb);
        sb.append("  }");
    }

    public final int getWidth() {
        if (this.mVisibility == 8) {
            return 0;
        }
        return this.mWidth;
    }

    public final int getX() {
        ConstraintWidget constraintWidget = this.mParent;
        if (constraintWidget == null || !(constraintWidget instanceof ConstraintWidgetContainer)) {
            return this.f2mX;
        }
        return ((ConstraintWidgetContainer) constraintWidget).mPaddingLeft + this.f2mX;
    }

    public final int getY() {
        ConstraintWidget constraintWidget = this.mParent;
        if (constraintWidget == null || !(constraintWidget instanceof ConstraintWidgetContainer)) {
            return this.f3mY;
        }
        return ((ConstraintWidgetContainer) constraintWidget).mPaddingTop + this.f3mY;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x003a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x003b A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean hasDanglingDimension(int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        if (i == 0) {
            if (this.mLeft.mTarget != null) {
                i5 = 1;
            } else {
                i5 = 0;
            }
            if (this.mRight.mTarget != null) {
                i6 = 1;
            } else {
                i6 = 0;
            }
            if (i5 + i6 < 2) {
                return true;
            }
            return false;
        }
        if (this.mTop.mTarget != null) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        if (this.mBottom.mTarget != null) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        int i7 = i2 + i3;
        if (this.mBaseline.mTarget != null) {
            i4 = 1;
        } else {
            i4 = 0;
        }
        if (i7 + i4 < 2) {
        }
    }

    public final boolean hasResolvedTargets(int i, int i2) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        ConstraintAnchor constraintAnchor3;
        ConstraintAnchor constraintAnchor4;
        if (i == 0) {
            ConstraintAnchor constraintAnchor5 = this.mLeft;
            ConstraintAnchor constraintAnchor6 = constraintAnchor5.mTarget;
            if (constraintAnchor6 == null || !constraintAnchor6.mHasFinalValue || (constraintAnchor4 = (constraintAnchor3 = this.mRight).mTarget) == null || !constraintAnchor4.mHasFinalValue) {
                return false;
            }
            if ((constraintAnchor4.getFinalValue() - constraintAnchor3.getMargin()) - (constraintAnchor5.getMargin() + constraintAnchor5.mTarget.getFinalValue()) >= i2) {
                return true;
            }
            return false;
        }
        ConstraintAnchor constraintAnchor7 = this.mTop;
        ConstraintAnchor constraintAnchor8 = constraintAnchor7.mTarget;
        if (constraintAnchor8 == null || !constraintAnchor8.mHasFinalValue || (constraintAnchor2 = (constraintAnchor = this.mBottom).mTarget) == null || !constraintAnchor2.mHasFinalValue) {
            return false;
        }
        if ((constraintAnchor2.getFinalValue() - constraintAnchor.getMargin()) - (constraintAnchor7.getMargin() + constraintAnchor7.mTarget.getFinalValue()) >= i2) {
            return true;
        }
        return false;
    }

    public final void immediateConnect(int i, int i2, int i3, int i4, ConstraintWidget constraintWidget) {
        getAnchor(i).connect(constraintWidget.getAnchor(i2), i3, i4, true);
    }

    public final boolean isChainHead(int i) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        int i2 = i * 2;
        ConstraintAnchor[] constraintAnchorArr = this.mListAnchors;
        ConstraintAnchor constraintAnchor3 = constraintAnchorArr[i2];
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.mTarget;
        if (constraintAnchor4 == null || constraintAnchor4.mTarget == constraintAnchor3 || (constraintAnchor2 = (constraintAnchor = constraintAnchorArr[i2 + 1]).mTarget) == null || constraintAnchor2.mTarget != constraintAnchor) {
            return false;
        }
        return true;
    }

    public final boolean isInHorizontalChain() {
        ConstraintAnchor constraintAnchor = this.mLeft;
        ConstraintAnchor constraintAnchor2 = constraintAnchor.mTarget;
        if (constraintAnchor2 != null && constraintAnchor2.mTarget == constraintAnchor) {
            return true;
        }
        ConstraintAnchor constraintAnchor3 = this.mRight;
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.mTarget;
        if (constraintAnchor4 == null || constraintAnchor4.mTarget != constraintAnchor3) {
            return false;
        }
        return true;
    }

    public final boolean isInVerticalChain() {
        ConstraintAnchor constraintAnchor = this.mTop;
        ConstraintAnchor constraintAnchor2 = constraintAnchor.mTarget;
        if (constraintAnchor2 != null && constraintAnchor2.mTarget == constraintAnchor) {
            return true;
        }
        ConstraintAnchor constraintAnchor3 = this.mBottom;
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.mTarget;
        if (constraintAnchor4 == null || constraintAnchor4.mTarget != constraintAnchor3) {
            return false;
        }
        return true;
    }

    public final boolean isMeasureRequested() {
        if (!this.mMeasureRequested || this.mVisibility == 8) {
            return false;
        }
        return true;
    }

    public boolean isResolvedHorizontally() {
        if (this.mResolvedHorizontal) {
            return true;
        }
        if (!this.mLeft.mHasFinalValue || !this.mRight.mHasFinalValue) {
            return false;
        }
        return true;
    }

    public boolean isResolvedVertically() {
        if (this.mResolvedVertical) {
            return true;
        }
        if (!this.mTop.mHasFinalValue || !this.mBottom.mHasFinalValue) {
            return false;
        }
        return true;
    }

    public void reset() {
        this.mLeft.reset();
        this.mTop.reset();
        this.mRight.reset();
        this.mBottom.reset();
        this.mBaseline.reset();
        this.mCenterX.reset();
        this.mCenterY.reset();
        this.mCenter.reset();
        this.mParent = null;
        this.mCircleConstraintAngle = Float.NaN;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.f2mX = 0;
        this.f3mY = 0;
        this.mBaselineDistance = 0;
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mHorizontalBiasPercent = 0.5f;
        this.mVerticalBiasPercent = 0.5f;
        int[] iArr = this.mListDimensionBehaviors;
        iArr[0] = 1;
        iArr[1] = 1;
        this.mCompanionWidget = null;
        this.mVisibility = 0;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        float[] fArr = this.mWeight;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        int[] iArr2 = this.mMaxDimension;
        iArr2[0] = Integer.MAX_VALUE;
        iArr2[1] = Integer.MAX_VALUE;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mMatchConstraintMaxWidth = Integer.MAX_VALUE;
        this.mMatchConstraintMaxHeight = Integer.MAX_VALUE;
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMinHeight = 0;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        boolean[] zArr = this.isTerminalWidget;
        zArr[0] = true;
        zArr[1] = true;
        this.mInVirtualLayout = false;
        boolean[] zArr2 = this.mIsInBarrier;
        zArr2[0] = false;
        zArr2[1] = false;
        this.mMeasureRequested = true;
        int[] iArr3 = this.mResolvedMatchConstraintDefault;
        iArr3[0] = 0;
        iArr3[1] = 0;
        this.mWidthOverride = -1;
        this.mHeightOverride = -1;
    }

    public final void resetAnchors() {
        ConstraintWidget constraintWidget = this.mParent;
        if (constraintWidget != null && (constraintWidget instanceof ConstraintWidgetContainer)) {
            ((ConstraintWidgetContainer) constraintWidget).getClass();
        }
        ArrayList arrayList = this.mAnchors;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((ConstraintAnchor) arrayList.get(i)).reset();
        }
    }

    public final void resetFinalResolution() {
        this.mResolvedHorizontal = false;
        this.mResolvedVertical = false;
        this.mHorizontalSolvingPass = false;
        this.mVerticalSolvingPass = false;
        ArrayList arrayList = this.mAnchors;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ConstraintAnchor constraintAnchor = (ConstraintAnchor) arrayList.get(i);
            constraintAnchor.mHasFinalValue = false;
            constraintAnchor.mFinalValue = 0;
        }
    }

    public void resetSolverVariables(MatcherMatchResult matcherMatchResult) {
        this.mLeft.resetSolverVariable();
        this.mTop.resetSolverVariable();
        this.mRight.resetSolverVariable();
        this.mBottom.resetSolverVariable();
        this.mBaseline.resetSolverVariable();
        this.mCenter.resetSolverVariable();
        this.mCenterX.resetSolverVariable();
        this.mCenterY.resetSolverVariable();
    }

    public final void setBaselineDistance(int i) {
        boolean z;
        this.mBaselineDistance = i;
        if (i > 0) {
            z = true;
        } else {
            z = false;
        }
        this.mHasBaseline = z;
    }

    public final void setFinalHorizontal(int i, int i2) {
        if (!this.mResolvedHorizontal) {
            this.mLeft.setFinalValue(i);
            this.mRight.setFinalValue(i2);
            this.f2mX = i;
            this.mWidth = i2 - i;
            this.mResolvedHorizontal = true;
        }
    }

    public final void setFinalVertical(int i, int i2) {
        if (!this.mResolvedVertical) {
            this.mTop.setFinalValue(i);
            this.mBottom.setFinalValue(i2);
            this.f3mY = i;
            this.mHeight = i2 - i;
            if (this.mHasBaseline) {
                this.mBaseline.setFinalValue(i + this.mBaselineDistance);
            }
            this.mResolvedVertical = true;
        }
    }

    public final void setHeight(int i) {
        this.mHeight = i;
        int i2 = this.mMinHeight;
        if (i < i2) {
            this.mHeight = i2;
        }
    }

    public final void setHorizontalDimensionBehaviour(int i) {
        this.mListDimensionBehaviors[0] = i;
    }

    public final void setVerticalDimensionBehaviour(int i) {
        this.mListDimensionBehaviors[1] = i;
    }

    public final void setWidth(int i) {
        this.mWidth = i;
        int i2 = this.mMinWidth;
        if (i < i2) {
            this.mWidth = i2;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        String str = "";
        sb.append(str);
        if (this.mDebugName != null) {
            str = ViewModelProvider.Factory.CC.m593m(new StringBuilder("id: "), this.mDebugName, " ");
        }
        sb.append(str);
        sb.append("(");
        sb.append(this.f2mX);
        sb.append(", ");
        sb.append(this.f3mY);
        sb.append(") - (");
        sb.append(this.mWidth);
        sb.append(" x ");
        sb.append(this.mHeight);
        sb.append(")");
        return sb.toString();
    }

    public void updateFromRuns(boolean z, boolean z2) {
        int i;
        int i2;
        HorizontalWidgetRun horizontalWidgetRun = this.mHorizontalRun;
        boolean z3 = z & horizontalWidgetRun.mResolved;
        VerticalWidgetRun verticalWidgetRun = this.mVerticalRun;
        boolean z4 = z2 & verticalWidgetRun.mResolved;
        int i3 = horizontalWidgetRun.start.value;
        int i4 = verticalWidgetRun.start.value;
        int i5 = horizontalWidgetRun.end.value;
        int i6 = verticalWidgetRun.end.value;
        int i7 = i6 - i4;
        if (i5 - i3 < 0 || i7 < 0 || i3 == Integer.MIN_VALUE || i3 == Integer.MAX_VALUE || i4 == Integer.MIN_VALUE || i4 == Integer.MAX_VALUE || i5 == Integer.MIN_VALUE || i5 == Integer.MAX_VALUE || i6 == Integer.MIN_VALUE || i6 == Integer.MAX_VALUE) {
            i5 = 0;
            i6 = 0;
            i3 = 0;
            i4 = 0;
        }
        int i8 = i5 - i3;
        int i9 = i6 - i4;
        if (z3) {
            this.f2mX = i3;
        }
        if (z4) {
            this.f3mY = i4;
        }
        if (this.mVisibility == 8) {
            this.mWidth = 0;
            this.mHeight = 0;
            return;
        }
        int[] iArr = this.mListDimensionBehaviors;
        if (z3) {
            if (iArr[0] == 1 && i8 < (i2 = this.mWidth)) {
                i8 = i2;
            }
            this.mWidth = i8;
            int i10 = this.mMinWidth;
            if (i8 < i10) {
                this.mWidth = i10;
            }
        }
        if (z4) {
            if (iArr[1] == 1 && i9 < (i = this.mHeight)) {
                i9 = i;
            }
            this.mHeight = i9;
            int i11 = this.mMinHeight;
            if (i9 < i11) {
                this.mHeight = i11;
            }
        }
    }

    public void updateFromSolver(LinearSystem linearSystem, boolean z) {
        int i;
        int i2;
        VerticalWidgetRun verticalWidgetRun;
        HorizontalWidgetRun horizontalWidgetRun;
        linearSystem.getClass();
        int objectVariableValue = LinearSystem.getObjectVariableValue(this.mLeft);
        int objectVariableValue2 = LinearSystem.getObjectVariableValue(this.mTop);
        int objectVariableValue3 = LinearSystem.getObjectVariableValue(this.mRight);
        int objectVariableValue4 = LinearSystem.getObjectVariableValue(this.mBottom);
        if (z && (horizontalWidgetRun = this.mHorizontalRun) != null) {
            DependencyNode dependencyNode = horizontalWidgetRun.start;
            if (dependencyNode.resolved) {
                DependencyNode dependencyNode2 = horizontalWidgetRun.end;
                if (dependencyNode2.resolved) {
                    objectVariableValue = dependencyNode.value;
                    objectVariableValue3 = dependencyNode2.value;
                }
            }
        }
        if (z && (verticalWidgetRun = this.mVerticalRun) != null) {
            DependencyNode dependencyNode3 = verticalWidgetRun.start;
            if (dependencyNode3.resolved) {
                DependencyNode dependencyNode4 = verticalWidgetRun.end;
                if (dependencyNode4.resolved) {
                    objectVariableValue2 = dependencyNode3.value;
                    objectVariableValue4 = dependencyNode4.value;
                }
            }
        }
        int i3 = objectVariableValue4 - objectVariableValue2;
        if (objectVariableValue3 - objectVariableValue < 0 || i3 < 0 || objectVariableValue == Integer.MIN_VALUE || objectVariableValue == Integer.MAX_VALUE || objectVariableValue2 == Integer.MIN_VALUE || objectVariableValue2 == Integer.MAX_VALUE || objectVariableValue3 == Integer.MIN_VALUE || objectVariableValue3 == Integer.MAX_VALUE || objectVariableValue4 == Integer.MIN_VALUE || objectVariableValue4 == Integer.MAX_VALUE) {
            objectVariableValue = 0;
            objectVariableValue2 = 0;
            objectVariableValue3 = 0;
            objectVariableValue4 = 0;
        }
        int i4 = objectVariableValue3 - objectVariableValue;
        int i5 = objectVariableValue4 - objectVariableValue2;
        this.f2mX = objectVariableValue;
        this.f3mY = objectVariableValue2;
        if (this.mVisibility == 8) {
            this.mWidth = 0;
            this.mHeight = 0;
            return;
        }
        int[] iArr = this.mListDimensionBehaviors;
        int i6 = iArr[0];
        if (i6 == 1 && i4 < (i2 = this.mWidth)) {
            i4 = i2;
        }
        if (iArr[1] == 1 && i5 < (i = this.mHeight)) {
            i5 = i;
        }
        this.mWidth = i4;
        this.mHeight = i5;
        int i7 = this.mMinHeight;
        if (i5 < i7) {
            this.mHeight = i7;
        }
        int i8 = this.mMinWidth;
        if (i4 < i8) {
            this.mWidth = i8;
        }
        int i9 = this.mMatchConstraintMaxWidth;
        if (i9 > 0 && i6 == 3) {
            this.mWidth = Math.min(this.mWidth, i9);
        }
        int i10 = this.mMatchConstraintMaxHeight;
        if (i10 > 0 && iArr[1] == 3) {
            this.mHeight = Math.min(this.mHeight, i10);
        }
        int i11 = this.mWidth;
        if (i4 != i11) {
            this.mWidthOverride = i11;
        }
        int i12 = this.mHeight;
        if (i5 != i12) {
            this.mHeightOverride = i12;
        }
    }

    public static void serializeAttribute(int i, int i2, String str, StringBuilder sb) {
        if (i != i2) {
            sb.append(str);
            sb.append(" :   ");
            sb.append(i);
            sb.append(",\n");
        }
    }

    public final void connect(int i, ConstraintWidget constraintWidget, int i2, int i3) {
        boolean z;
        if (i == 7) {
            if (i2 == 7) {
                ConstraintAnchor anchor = getAnchor(2);
                ConstraintAnchor anchor2 = getAnchor(4);
                ConstraintAnchor anchor3 = getAnchor(3);
                ConstraintAnchor anchor4 = getAnchor(5);
                boolean z2 = true;
                if ((anchor == null || !anchor.isConnected()) && (anchor2 == null || !anchor2.isConnected())) {
                    connect(2, constraintWidget, 2, 0);
                    connect(4, constraintWidget, 4, 0);
                    z = true;
                } else {
                    z = false;
                }
                if ((anchor3 == null || !anchor3.isConnected()) && (anchor4 == null || !anchor4.isConnected())) {
                    connect(3, constraintWidget, 3, 0);
                    connect(5, constraintWidget, 5, 0);
                } else {
                    z2 = false;
                }
                if (z && z2) {
                    getAnchor(7).connect(constraintWidget.getAnchor(7), 0);
                } else if (z) {
                    getAnchor(8).connect(constraintWidget.getAnchor(8), 0);
                } else if (z2) {
                    getAnchor(9).connect(constraintWidget.getAnchor(9), 0);
                }
            } else if (i2 == 2 || i2 == 4) {
                connect(2, constraintWidget, i2, 0);
                connect(4, constraintWidget, i2, 0);
                getAnchor(7).connect(constraintWidget.getAnchor(i2), 0);
            } else if (i2 == 3 || i2 == 5) {
                connect(3, constraintWidget, i2, 0);
                connect(5, constraintWidget, i2, 0);
                getAnchor(7).connect(constraintWidget.getAnchor(i2), 0);
            }
        } else if (i == 8 && (i2 == 2 || i2 == 4)) {
            ConstraintAnchor anchor5 = getAnchor(2);
            ConstraintAnchor anchor6 = constraintWidget.getAnchor(i2);
            ConstraintAnchor anchor7 = getAnchor(4);
            anchor5.connect(anchor6, 0);
            anchor7.connect(anchor6, 0);
            getAnchor(8).connect(anchor6, 0);
        } else if (i == 9 && (i2 == 3 || i2 == 5)) {
            ConstraintAnchor anchor8 = constraintWidget.getAnchor(i2);
            getAnchor(3).connect(anchor8, 0);
            getAnchor(5).connect(anchor8, 0);
            getAnchor(9).connect(anchor8, 0);
        } else if (i == 8 && i2 == 8) {
            getAnchor(2).connect(constraintWidget.getAnchor(2), 0);
            getAnchor(4).connect(constraintWidget.getAnchor(4), 0);
            getAnchor(8).connect(constraintWidget.getAnchor(i2), 0);
        } else if (i == 9 && i2 == 9) {
            getAnchor(3).connect(constraintWidget.getAnchor(3), 0);
            getAnchor(5).connect(constraintWidget.getAnchor(5), 0);
            getAnchor(9).connect(constraintWidget.getAnchor(i2), 0);
        } else {
            ConstraintAnchor anchor9 = getAnchor(i);
            ConstraintAnchor anchor10 = constraintWidget.getAnchor(i2);
            if (anchor9.isValidConnection(anchor10)) {
                if (i == 6) {
                    ConstraintAnchor anchor11 = getAnchor(3);
                    ConstraintAnchor anchor12 = getAnchor(5);
                    if (anchor11 != null) {
                        anchor11.reset();
                    }
                    if (anchor12 != null) {
                        anchor12.reset();
                    }
                } else if (i == 3 || i == 5) {
                    ConstraintAnchor anchor13 = getAnchor(6);
                    if (anchor13 != null) {
                        anchor13.reset();
                    }
                    ConstraintAnchor anchor14 = getAnchor(7);
                    if (anchor14.mTarget != anchor10) {
                        anchor14.reset();
                    }
                    ConstraintAnchor opposite = getAnchor(i).getOpposite();
                    ConstraintAnchor anchor15 = getAnchor(9);
                    if (anchor15.isConnected()) {
                        opposite.reset();
                        anchor15.reset();
                    }
                } else if (i == 2 || i == 4) {
                    ConstraintAnchor anchor16 = getAnchor(7);
                    if (anchor16.mTarget != anchor10) {
                        anchor16.reset();
                    }
                    ConstraintAnchor opposite2 = getAnchor(i).getOpposite();
                    ConstraintAnchor anchor17 = getAnchor(8);
                    if (anchor17.isConnected()) {
                        opposite2.reset();
                        anchor17.reset();
                    }
                }
                anchor9.connect(anchor10, i3);
            }
        }
    }

    public static void getSceneString(StringBuilder sb, String str, int i, int i2, int i3, int i4, int i5, float f, int i6) {
        String str2;
        sb.append(str);
        sb.append(" :  {\n");
        if (i6 == 1) {
            str2 = "FIXED";
        } else if (i6 == 2) {
            str2 = "WRAP_CONTENT";
        } else if (i6 == 3) {
            str2 = "MATCH_CONSTRAINT";
        } else if (i6 == 4) {
            str2 = "MATCH_PARENT";
        } else {
            throw null;
        }
        if (!"FIXED".equals(str2)) {
            sb.append("      behavior");
            sb.append(" :   ");
            sb.append(str2);
            sb.append(",\n");
        }
        serializeAttribute(i, 0, "      size", sb);
        serializeAttribute(i2, 0, "      min", sb);
        serializeAttribute(i3, Integer.MAX_VALUE, "      max", sb);
        serializeAttribute(i4, 0, "      matchMin", sb);
        serializeAttribute(i5, 0, "      matchDef", sb);
        serializeAttribute(sb, "      matchPercent", f, 1.0f);
        sb.append("    },\n");
    }

    public static void getSceneString(StringBuilder sb, String str, ConstraintAnchor constraintAnchor) {
        if (constraintAnchor.mTarget != null) {
            sb.append("    ");
            sb.append(str);
            sb.append(" : [ '");
            sb.append(constraintAnchor.mTarget);
            sb.append("'");
            if (!(constraintAnchor.mGoneMargin == Integer.MIN_VALUE && constraintAnchor.mMargin == 0)) {
                sb.append(",");
                sb.append(constraintAnchor.mMargin);
                if (constraintAnchor.mGoneMargin != Integer.MIN_VALUE) {
                    sb.append(",");
                    sb.append(constraintAnchor.mGoneMargin);
                    sb.append(",");
                }
            }
            sb.append(" ] ,\n");
        }
    }
}
