package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.Guideline;
import androidx.constraintlayout.core.widgets.HelperWidget;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.HashSet;
/* loaded from: classes.dex */
public final class DependencyGraph {
    public ConstraintWidgetContainer mContainer;
    public ArrayList mGroups;
    public BasicMeasure$Measure mMeasure;
    public ConstraintLayout.Measurer mMeasurer;
    public boolean mNeedBuildGraph;
    public boolean mNeedRedoMeasures;
    public ArrayList mRuns;
    public ConstraintWidgetContainer mWidgetcontainer;

    /* JADX WARN: Type inference failed for: r13v2, types: [java.lang.Object, androidx.constraintlayout.core.widgets.analyzer.RunGroup] */
    public final void applyGroup(DependencyNode dependencyNode, int i, ArrayList arrayList, RunGroup runGroup) {
        WidgetRun widgetRun = dependencyNode.mRun;
        RunGroup runGroup2 = widgetRun.mRunGroup;
        DependencyNode dependencyNode2 = widgetRun.end;
        DependencyNode dependencyNode3 = widgetRun.start;
        if (runGroup2 == null) {
            ConstraintWidgetContainer constraintWidgetContainer = this.mWidgetcontainer;
            if (widgetRun != constraintWidgetContainer.mHorizontalRun) {
                RunGroup runGroup3 = runGroup;
                if (widgetRun != constraintWidgetContainer.mVerticalRun) {
                    if (runGroup == null) {
                        ?? obj = new Object();
                        obj.mFirstRun = null;
                        obj.mRuns = new ArrayList();
                        obj.mFirstRun = widgetRun;
                        arrayList.add(obj);
                        runGroup3 = obj;
                    }
                    widgetRun.mRunGroup = runGroup3;
                    runGroup3.mRuns.add(widgetRun);
                    ArrayList arrayList2 = dependencyNode3.mDependencies;
                    int size = arrayList2.size();
                    int i2 = 0;
                    int i3 = 0;
                    while (i3 < size) {
                        Object obj2 = arrayList2.get(i3);
                        i3++;
                        Dependency dependency = (Dependency) obj2;
                        if (dependency instanceof DependencyNode) {
                            applyGroup((DependencyNode) dependency, i, arrayList, runGroup3);
                        }
                    }
                    ArrayList arrayList3 = dependencyNode2.mDependencies;
                    int size2 = arrayList3.size();
                    int i4 = 0;
                    while (i4 < size2) {
                        Object obj3 = arrayList3.get(i4);
                        i4++;
                        Dependency dependency2 = (Dependency) obj3;
                        if (dependency2 instanceof DependencyNode) {
                            applyGroup((DependencyNode) dependency2, i, arrayList, runGroup3);
                        }
                    }
                    if (i == 1 && (widgetRun instanceof VerticalWidgetRun)) {
                        ArrayList arrayList4 = ((VerticalWidgetRun) widgetRun).baseline.mDependencies;
                        int size3 = arrayList4.size();
                        int i5 = 0;
                        while (i5 < size3) {
                            Object obj4 = arrayList4.get(i5);
                            i5++;
                            Dependency dependency3 = (Dependency) obj4;
                            if (dependency3 instanceof DependencyNode) {
                                applyGroup((DependencyNode) dependency3, i, arrayList, runGroup3);
                            }
                        }
                    }
                    ArrayList arrayList5 = dependencyNode3.mTargets;
                    int size4 = arrayList5.size();
                    int i6 = 0;
                    while (i6 < size4) {
                        Object obj5 = arrayList5.get(i6);
                        i6++;
                        applyGroup((DependencyNode) obj5, i, arrayList, runGroup3);
                    }
                    ArrayList arrayList6 = dependencyNode2.mTargets;
                    int size5 = arrayList6.size();
                    int i7 = 0;
                    while (i7 < size5) {
                        Object obj6 = arrayList6.get(i7);
                        i7++;
                        applyGroup((DependencyNode) obj6, i, arrayList, runGroup3);
                    }
                    if (i == 1 && (widgetRun instanceof VerticalWidgetRun)) {
                        ArrayList arrayList7 = ((VerticalWidgetRun) widgetRun).baseline.mTargets;
                        int size6 = arrayList7.size();
                        while (i2 < size6) {
                            Object obj7 = arrayList7.get(i2);
                            i2++;
                            applyGroup((DependencyNode) obj7, i, arrayList, runGroup3);
                        }
                    }
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x01af, code lost:
        if (r10 != r0) goto L130;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x01b1, code lost:
        if (r13 == r8) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x01b3, code lost:
        if (r13 != r6) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x01b6, code lost:
        r7 = r10;
        r0 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x01b8, code lost:
        r6 = 1;
        r8 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x01ba, code lost:
        r9 = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x01be, code lost:
        if (r1 != r0) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x01c0, code lost:
        if (r13 != r8) goto L109;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x01c2, code lost:
        measure(r8, 0, r8, 0, r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x01ca, code lost:
        r9 = r12.getWidth();
        r0 = r12.mDimensionRatio;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x01d3, code lost:
        if (r12.mDimensionRatioSide != (-1)) goto L112;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x01d5, code lost:
        r0 = 1.0f / r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x01d7, code lost:
        measure(1, r9, r6, (int) ((r9 * r0) + 0.5f), r12);
        r12.mHorizontalRun.mDimension.resolve(r12.getWidth());
        r12.mVerticalRun.mDimension.resolve(r12.getHeight());
        r12.measured = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0200, code lost:
        if (r1 != 1) goto L116;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0202, code lost:
        measure(r13, 0, 2, 0, r12);
        r12.mVerticalRun.mDimension.wrapValue = r12.getHeight();
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0217, code lost:
        r8 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x021a, code lost:
        if (r1 != 2) goto L124;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x021c, code lost:
        r7 = r2[1];
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x021e, code lost:
        if (r7 == r6) goto L123;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x0221, code lost:
        if (r7 != 4) goto L122;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x0224, code lost:
        r0 = r8;
        r7 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x0227, code lost:
        measure(r8, r12.getWidth(), 1, (int) ((r14 * r24.getHeight()) + 0.5f), r12);
        r12.mHorizontalRun.mDimension.resolve(r12.getWidth());
        r12.mVerticalRun.mDimension.resolve(r12.getHeight());
        r12.measured = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x0256, code lost:
        r0 = r8;
        r8 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x025e, code lost:
        if (r7[2].mTarget == null) goto L129;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x0266, code lost:
        if (r7[3].mTarget != null) goto L128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x0269, code lost:
        r7 = r10;
        r6 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x026d, code lost:
        measure(2, 0, r10, 0, r12);
        r12.mHorizontalRun.mDimension.resolve(r12.getWidth());
        r12.mVerticalRun.mDimension.resolve(r12.getHeight());
        r12.measured = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x0290, code lost:
        r7 = r10;
        r0 = r13;
        r6 = 1;
        r8 = 1;
        r9 = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x0296, code lost:
        if (r0 != r9) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x0298, code lost:
        if (r7 != r9) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x029a, code lost:
        if (r15 == r6) goto L143;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x029c, code lost:
        if (r1 != r6) goto L135;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x02a0, code lost:
        if (r1 != 2) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x02a2, code lost:
        if (r15 != 2) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x02a6, code lost:
        if (r2[0] != r8) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x02aa, code lost:
        if (r2[r6] != r8) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x02ac, code lost:
        measure(r8, (int) ((r4 * r24.getWidth()) + 0.5f), r8, (int) ((r14 * r24.getHeight()) + 0.5f), r12);
        r12.mHorizontalRun.mDimension.resolve(r12.getWidth());
        r12.mVerticalRun.mDimension.resolve(r12.getHeight());
        r12.measured = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x02e1, code lost:
        measure(2, 0, 2, 0, r12);
        r12.mHorizontalRun.mDimension.wrapValue = r12.getWidth();
        r12.mVerticalRun.mDimension.wrapValue = r12.getHeight();
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00bd, code lost:
        if (r13 == 2) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00c6, code lost:
        if (r6 == 2) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00d1, code lost:
        if (r13 != 3) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00d3, code lost:
        if (r6 == r0) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00d6, code lost:
        if (r6 != 1) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00d9, code lost:
        r10 = r6;
        r0 = 3;
        r6 = 1;
        r8 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x00df, code lost:
        if (r15 != 3) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x00e1, code lost:
        if (r6 != r0) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x00e3, code lost:
        measure(2, 0, r0, 0, r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x00ec, code lost:
        r11 = r12.getHeight();
        measure(1, (int) ((r11 * r12.mDimensionRatio) + 0.5f), 1, r11, r12);
        r12.mHorizontalRun.mDimension.resolve(r12.getWidth());
        r12.mVerticalRun.mDimension.resolve(r12.getHeight());
        r12.measured = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0121, code lost:
        r8 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0124, code lost:
        if (r15 != 1) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0126, code lost:
        measure(2, 0, r6, 0, r12);
        r12.mHorizontalRun.mDimension.wrapValue = r12.getWidth();
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x013a, code lost:
        if (r15 != 2) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x013c, code lost:
        r0 = r2[0];
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x013e, code lost:
        if (r0 == 1) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0141, code lost:
        if (r0 != 4) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0144, code lost:
        r10 = r6;
        r0 = 3;
        r6 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0148, code lost:
        measure(1, (int) ((r4 * r24.getWidth()) + 0.5f), r6, r12.getHeight(), r12);
        r12.mHorizontalRun.mDimension.resolve(r12.getWidth());
        r12.mVerticalRun.mDimension.resolve(r12.getHeight());
        r12.measured = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0177, code lost:
        r10 = r6;
        r6 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x017e, code lost:
        if (r7[0].mTarget == null) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0184, code lost:
        if (r7[1].mTarget != null) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0187, code lost:
        r0 = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0189, code lost:
        measure(2, 0, r10, 0, r12);
        r12.mHorizontalRun.mDimension.resolve(r12.getWidth());
        r12.mVerticalRun.mDimension.resolve(r12.getHeight());
        r12.measured = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x01ab, code lost:
        r10 = r6;
        r6 = 1;
        r8 = 2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void basicMeasureWidgets(androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r24) {
        /*
            Method dump skipped, instructions count: 848
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.DependencyGraph.basicMeasureWidgets(androidx.constraintlayout.core.widgets.ConstraintWidgetContainer):void");
    }

    public final void buildGraph() {
        ConstraintWidgetContainer constraintWidgetContainer = this.mWidgetcontainer;
        ArrayList arrayList = this.mGroups;
        ArrayList arrayList2 = this.mRuns;
        arrayList2.clear();
        ConstraintWidgetContainer constraintWidgetContainer2 = this.mContainer;
        constraintWidgetContainer2.mHorizontalRun.clear();
        constraintWidgetContainer2.mVerticalRun.clear();
        arrayList2.add(constraintWidgetContainer2.mHorizontalRun);
        arrayList2.add(constraintWidgetContainer2.mVerticalRun);
        ArrayList arrayList3 = constraintWidgetContainer2.mChildren;
        int size = arrayList3.size();
        HashSet hashSet = null;
        int i = 0;
        while (i < size) {
            Object obj = arrayList3.get(i);
            i++;
            ConstraintWidget constraintWidget = (ConstraintWidget) obj;
            if (constraintWidget instanceof Guideline) {
                WidgetRun widgetRun = new WidgetRun(constraintWidget);
                constraintWidget.mHorizontalRun.clear();
                constraintWidget.mVerticalRun.clear();
                widgetRun.orientation = ((Guideline) constraintWidget).mOrientation;
                arrayList2.add(widgetRun);
            } else {
                if (constraintWidget.isInHorizontalChain()) {
                    if (constraintWidget.horizontalChainRun == null) {
                        constraintWidget.horizontalChainRun = new ChainRun(constraintWidget, 0);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(constraintWidget.horizontalChainRun);
                } else {
                    arrayList2.add(constraintWidget.mHorizontalRun);
                }
                if (constraintWidget.isInVerticalChain()) {
                    if (constraintWidget.verticalChainRun == null) {
                        constraintWidget.verticalChainRun = new ChainRun(constraintWidget, 1);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(constraintWidget.verticalChainRun);
                } else {
                    arrayList2.add(constraintWidget.mVerticalRun);
                }
                if (constraintWidget instanceof HelperWidget) {
                    arrayList2.add(new WidgetRun(constraintWidget));
                }
            }
        }
        if (hashSet != null) {
            arrayList2.addAll(hashSet);
        }
        int size2 = arrayList2.size();
        int i2 = 0;
        while (i2 < size2) {
            Object obj2 = arrayList2.get(i2);
            i2++;
            ((WidgetRun) obj2).clear();
        }
        int size3 = arrayList2.size();
        int i3 = 0;
        while (i3 < size3) {
            Object obj3 = arrayList2.get(i3);
            i3++;
            WidgetRun widgetRun2 = (WidgetRun) obj3;
            if (widgetRun2.mWidget != constraintWidgetContainer2) {
                widgetRun2.apply();
            }
        }
        arrayList.clear();
        findGroup(constraintWidgetContainer.mHorizontalRun, 0, arrayList);
        findGroup(constraintWidgetContainer.mVerticalRun, 1, arrayList);
        this.mNeedBuildGraph = false;
    }

    public final int computeWrap(ConstraintWidgetContainer constraintWidgetContainer, int i) {
        int i2;
        ArrayList arrayList;
        long j;
        WidgetRun widgetRun;
        WidgetRun widgetRun2;
        float f;
        long j2;
        ConstraintWidgetContainer constraintWidgetContainer2 = constraintWidgetContainer;
        ArrayList arrayList2 = this.mGroups;
        int size = arrayList2.size();
        long j3 = 0;
        int i3 = 0;
        long j4 = 0;
        while (i3 < size) {
            WidgetRun widgetRun3 = ((RunGroup) arrayList2.get(i3)).mFirstRun;
            if (!(widgetRun3 instanceof ChainRun) ? i != 0 ? (widgetRun3 instanceof VerticalWidgetRun) : (widgetRun3 instanceof HorizontalWidgetRun) : ((ChainRun) widgetRun3).orientation == i) {
                if (i == 0) {
                    widgetRun = constraintWidgetContainer2.mHorizontalRun;
                } else {
                    widgetRun = constraintWidgetContainer2.mVerticalRun;
                }
                DependencyNode dependencyNode = widgetRun.start;
                if (i == 0) {
                    widgetRun2 = constraintWidgetContainer2.mHorizontalRun;
                } else {
                    widgetRun2 = constraintWidgetContainer2.mVerticalRun;
                }
                DependencyNode dependencyNode2 = widgetRun2.end;
                DependencyNode dependencyNode3 = widgetRun3.start;
                DependencyNode dependencyNode4 = widgetRun3.end;
                boolean contains = dependencyNode3.mTargets.contains(dependencyNode);
                boolean contains2 = dependencyNode4.mTargets.contains(dependencyNode2);
                long wrapDimension = widgetRun3.getWrapDimension();
                if (!contains || !contains2) {
                    arrayList = arrayList2;
                    i2 = size;
                    if (contains) {
                        j = Math.max(RunGroup.traverseStart(dependencyNode3, dependencyNode3.mMargin), dependencyNode3.mMargin + wrapDimension);
                    } else if (contains2) {
                        j = Math.max(-RunGroup.traverseEnd(dependencyNode4, dependencyNode4.mMargin), (-dependencyNode4.mMargin) + wrapDimension);
                    } else {
                        j = (widgetRun3.getWrapDimension() + dependencyNode3.mMargin) - dependencyNode4.mMargin;
                    }
                } else {
                    long traverseStart = RunGroup.traverseStart(dependencyNode3, j3);
                    long traverseEnd = RunGroup.traverseEnd(dependencyNode4, j3);
                    long j5 = traverseStart - wrapDimension;
                    int i4 = dependencyNode4.mMargin;
                    arrayList = arrayList2;
                    i2 = size;
                    if (j5 >= (-i4)) {
                        j5 += i4;
                    }
                    long j6 = dependencyNode3.mMargin;
                    long j7 = ((-traverseEnd) - wrapDimension) - j6;
                    if (j7 >= j6) {
                        j7 -= j6;
                    }
                    ConstraintWidget constraintWidget = widgetRun3.mWidget;
                    if (i == 0) {
                        f = constraintWidget.mHorizontalBiasPercent;
                    } else if (i == 1) {
                        f = constraintWidget.mVerticalBiasPercent;
                    } else {
                        constraintWidget.getClass();
                        f = -1.0f;
                    }
                    if (f > 0.0f) {
                        j2 = (((float) j5) / (1.0f - f)) + (((float) j7) / f);
                    } else {
                        j2 = 0;
                    }
                    float f2 = (float) j2;
                    j = (dependencyNode3.mMargin + ((((f2 * f) + 0.5f) + wrapDimension) + (((1.0f - f) * f2) + 0.5f))) - dependencyNode4.mMargin;
                }
            } else {
                arrayList = arrayList2;
                i2 = size;
                j = j3;
            }
            j4 = Math.max(j4, j);
            i3++;
            constraintWidgetContainer2 = constraintWidgetContainer;
            arrayList2 = arrayList;
            size = i2;
            j3 = 0;
        }
        return (int) j4;
    }

    public final void findGroup(WidgetRun widgetRun, int i, ArrayList arrayList) {
        DependencyNode dependencyNode = widgetRun.start;
        DependencyNode dependencyNode2 = widgetRun.end;
        ArrayList arrayList2 = dependencyNode.mDependencies;
        int size = arrayList2.size();
        int i2 = 0;
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList2.get(i3);
            i3++;
            Dependency dependency = (Dependency) obj;
            if (dependency instanceof DependencyNode) {
                applyGroup((DependencyNode) dependency, i, arrayList, null);
            } else if (dependency instanceof WidgetRun) {
                applyGroup(((WidgetRun) dependency).start, i, arrayList, null);
            }
        }
        ArrayList arrayList3 = dependencyNode2.mDependencies;
        int size2 = arrayList3.size();
        int i4 = 0;
        while (i4 < size2) {
            Object obj2 = arrayList3.get(i4);
            i4++;
            Dependency dependency2 = (Dependency) obj2;
            if (dependency2 instanceof DependencyNode) {
                applyGroup((DependencyNode) dependency2, i, arrayList, null);
            } else if (dependency2 instanceof WidgetRun) {
                applyGroup(((WidgetRun) dependency2).end, i, arrayList, null);
            }
        }
        if (i == 1) {
            ArrayList arrayList4 = ((VerticalWidgetRun) widgetRun).baseline.mDependencies;
            int size3 = arrayList4.size();
            while (i2 < size3) {
                Object obj3 = arrayList4.get(i2);
                i2++;
                Dependency dependency3 = (Dependency) obj3;
                if (dependency3 instanceof DependencyNode) {
                    applyGroup((DependencyNode) dependency3, i, arrayList, null);
                }
            }
        }
    }

    public final void measure(int i, int i2, int i3, int i4, ConstraintWidget constraintWidget) {
        BasicMeasure$Measure basicMeasure$Measure = this.mMeasure;
        basicMeasure$Measure.horizontalBehavior = i;
        basicMeasure$Measure.verticalBehavior = i3;
        basicMeasure$Measure.horizontalDimension = i2;
        basicMeasure$Measure.verticalDimension = i4;
        this.mMeasurer.measure(constraintWidget, basicMeasure$Measure);
        constraintWidget.setWidth(basicMeasure$Measure.measuredWidth);
        constraintWidget.setHeight(basicMeasure$Measure.measuredHeight);
        constraintWidget.mHasBaseline = basicMeasure$Measure.measuredHasBaseline;
        constraintWidget.setBaselineDistance(basicMeasure$Measure.measuredBaseline);
    }

    public final void measureWidgets() {
        boolean z;
        boolean z2;
        BaselineDimensionDependency baselineDimensionDependency;
        DependencyGraph dependencyGraph = this;
        ArrayList arrayList = dependencyGraph.mWidgetcontainer.mChildren;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            ConstraintWidget constraintWidget = (ConstraintWidget) arrayList.get(i);
            if (!constraintWidget.measured) {
                int[] iArr = constraintWidget.mListDimensionBehaviors;
                int i3 = iArr[0];
                int i4 = iArr[1];
                int i5 = constraintWidget.mMatchConstraintDefaultWidth;
                int i6 = constraintWidget.mMatchConstraintDefaultHeight;
                if (i3 == 2 || (i3 == 3 && i5 == 1)) {
                    z = true;
                } else {
                    z = false;
                }
                if (i4 == 2 || (i4 == 3 && i6 == 1)) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                DimensionDependency dimensionDependency = constraintWidget.mHorizontalRun.mDimension;
                boolean z3 = dimensionDependency.resolved;
                DimensionDependency dimensionDependency2 = constraintWidget.mVerticalRun.mDimension;
                boolean z4 = dimensionDependency2.resolved;
                boolean z5 = z;
                if (z3 && z4) {
                    dependencyGraph.measure(1, dimensionDependency.value, 1, dimensionDependency2.value, constraintWidget);
                    constraintWidget.measured = true;
                } else if (z3 && z2) {
                    measure(1, dimensionDependency.value, 2, dimensionDependency2.value, constraintWidget);
                    if (i4 == 3) {
                        constraintWidget.mVerticalRun.mDimension.wrapValue = constraintWidget.getHeight();
                    } else {
                        constraintWidget.mVerticalRun.mDimension.resolve(constraintWidget.getHeight());
                        constraintWidget.measured = true;
                    }
                } else if (z4 && z5) {
                    measure(2, dimensionDependency.value, 1, dimensionDependency2.value, constraintWidget);
                    if (i3 == 3) {
                        constraintWidget.mHorizontalRun.mDimension.wrapValue = constraintWidget.getWidth();
                    } else {
                        constraintWidget.mHorizontalRun.mDimension.resolve(constraintWidget.getWidth());
                        constraintWidget.measured = true;
                    }
                }
                if (constraintWidget.measured && (baselineDimensionDependency = constraintWidget.mVerticalRun.mBaselineDimension) != null) {
                    baselineDimensionDependency.resolve(constraintWidget.mBaselineDistance);
                }
                dependencyGraph = this;
            }
            i = i2;
        }
    }
}
