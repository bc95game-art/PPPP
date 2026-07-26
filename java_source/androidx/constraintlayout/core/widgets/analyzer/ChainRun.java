package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class ChainRun extends WidgetRun {
    public int mChainStyle;
    public final ArrayList mWidgets;

    public ChainRun(ConstraintWidget constraintWidget, int i) {
        super(constraintWidget);
        ConstraintWidget constraintWidget2;
        Object obj;
        int i2;
        Object obj2;
        ArrayList arrayList = new ArrayList();
        this.mWidgets = arrayList;
        this.orientation = i;
        ConstraintWidget constraintWidget3 = this.mWidget;
        ConstraintWidget previousChainMember = constraintWidget3.getPreviousChainMember(i);
        while (true) {
            constraintWidget2 = constraintWidget3;
            constraintWidget3 = previousChainMember;
            if (constraintWidget3 == null) {
                break;
            }
            previousChainMember = constraintWidget3.getPreviousChainMember(this.orientation);
        }
        this.mWidget = constraintWidget2;
        int i3 = this.orientation;
        if (i3 == 0) {
            obj = constraintWidget2.mHorizontalRun;
        } else if (i3 == 1) {
            obj = constraintWidget2.mVerticalRun;
        } else {
            obj = null;
        }
        arrayList.add(obj);
        ConstraintWidget nextChainMember = constraintWidget2.getNextChainMember(this.orientation);
        while (nextChainMember != null) {
            int i4 = this.orientation;
            if (i4 == 0) {
                obj2 = nextChainMember.mHorizontalRun;
            } else if (i4 == 1) {
                obj2 = nextChainMember.mVerticalRun;
            } else {
                obj2 = null;
            }
            arrayList.add(obj2);
            nextChainMember = nextChainMember.getNextChainMember(this.orientation);
        }
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            Object obj3 = arrayList.get(i5);
            i5++;
            WidgetRun widgetRun = (WidgetRun) obj3;
            int i6 = this.orientation;
            if (i6 == 0) {
                widgetRun.mWidget.horizontalChainRun = this;
            } else if (i6 == 1) {
                widgetRun.mWidget.verticalChainRun = this;
            }
        }
        if (this.orientation == 0 && ((ConstraintWidgetContainer) this.mWidget.mParent).mIsRtl && arrayList.size() > 1) {
            this.mWidget = ((WidgetRun) arrayList.get(arrayList.size() - 1)).mWidget;
        }
        if (this.orientation == 0) {
            i2 = this.mWidget.mHorizontalChainStyle;
        } else {
            i2 = this.mWidget.mVerticalChainStyle;
        }
        this.mChainStyle = i2;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public final void apply() {
        ArrayList arrayList = this.mWidgets;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((WidgetRun) obj).apply();
        }
        int size2 = arrayList.size();
        if (size2 >= 1) {
            ConstraintWidget constraintWidget = ((WidgetRun) arrayList.get(0)).mWidget;
            ConstraintWidget constraintWidget2 = ((WidgetRun) arrayList.get(size2 - 1)).mWidget;
            int i2 = this.orientation;
            DependencyNode dependencyNode = this.end;
            DependencyNode dependencyNode2 = this.start;
            if (i2 == 0) {
                ConstraintAnchor constraintAnchor = constraintWidget.mLeft;
                ConstraintAnchor constraintAnchor2 = constraintWidget2.mRight;
                DependencyNode target = WidgetRun.getTarget(constraintAnchor, 0);
                int margin = constraintAnchor.getMargin();
                ConstraintWidget firstVisibleWidget = getFirstVisibleWidget();
                if (firstVisibleWidget != null) {
                    margin = firstVisibleWidget.mLeft.getMargin();
                }
                if (target != null) {
                    WidgetRun.addTarget(dependencyNode2, target, margin);
                }
                DependencyNode target2 = WidgetRun.getTarget(constraintAnchor2, 0);
                int margin2 = constraintAnchor2.getMargin();
                ConstraintWidget lastVisibleWidget = getLastVisibleWidget();
                if (lastVisibleWidget != null) {
                    margin2 = lastVisibleWidget.mRight.getMargin();
                }
                if (target2 != null) {
                    WidgetRun.addTarget(dependencyNode, target2, -margin2);
                }
            } else {
                ConstraintAnchor constraintAnchor3 = constraintWidget.mTop;
                ConstraintAnchor constraintAnchor4 = constraintWidget2.mBottom;
                DependencyNode target3 = WidgetRun.getTarget(constraintAnchor3, 1);
                int margin3 = constraintAnchor3.getMargin();
                ConstraintWidget firstVisibleWidget2 = getFirstVisibleWidget();
                if (firstVisibleWidget2 != null) {
                    margin3 = firstVisibleWidget2.mTop.getMargin();
                }
                if (target3 != null) {
                    WidgetRun.addTarget(dependencyNode2, target3, margin3);
                }
                DependencyNode target4 = WidgetRun.getTarget(constraintAnchor4, 1);
                int margin4 = constraintAnchor4.getMargin();
                ConstraintWidget lastVisibleWidget2 = getLastVisibleWidget();
                if (lastVisibleWidget2 != null) {
                    margin4 = lastVisibleWidget2.mBottom.getMargin();
                }
                if (target4 != null) {
                    WidgetRun.addTarget(dependencyNode, target4, -margin4);
                }
            }
            dependencyNode2.updateDelegate = this;
            dependencyNode.updateDelegate = this;
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public final void applyToWidget() {
        int i = 0;
        while (true) {
            ArrayList arrayList = this.mWidgets;
            if (i < arrayList.size()) {
                ((WidgetRun) arrayList.get(i)).applyToWidget();
                i++;
            } else {
                return;
            }
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public final void clear() {
        this.mRunGroup = null;
        ArrayList arrayList = this.mWidgets;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((WidgetRun) obj).clear();
        }
    }

    public final ConstraintWidget getFirstVisibleWidget() {
        int i = 0;
        while (true) {
            ArrayList arrayList = this.mWidgets;
            if (i >= arrayList.size()) {
                return null;
            }
            ConstraintWidget constraintWidget = ((WidgetRun) arrayList.get(i)).mWidget;
            if (constraintWidget.mVisibility != 8) {
                return constraintWidget;
            }
            i++;
        }
    }

    public final ConstraintWidget getLastVisibleWidget() {
        ArrayList arrayList = this.mWidgets;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            ConstraintWidget constraintWidget = ((WidgetRun) arrayList.get(size)).mWidget;
            if (constraintWidget.mVisibility != 8) {
                return constraintWidget;
            }
        }
        return null;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public final long getWrapDimension() {
        ArrayList arrayList = this.mWidgets;
        int size = arrayList.size();
        long j = 0;
        for (int i = 0; i < size; i++) {
            WidgetRun widgetRun = (WidgetRun) arrayList.get(i);
            j = widgetRun.end.mMargin + widgetRun.getWrapDimension() + j + widgetRun.start.mMargin;
        }
        return j;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public final boolean supportsWrapComputation() {
        ArrayList arrayList = this.mWidgets;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (!((WidgetRun) arrayList.get(i)).supportsWrapComputation()) {
                return false;
            }
        }
        return true;
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("ChainRun ");
        if (this.orientation == 0) {
            str = "horizontal : ";
        } else {
            str = "vertical : ";
        }
        sb.append(str);
        ArrayList arrayList = this.mWidgets;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            sb.append("<");
            sb.append((WidgetRun) obj);
            sb.append("> ");
        }
        return sb.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:264:0x0393, code lost:
        r2 = r2 - r13;
     */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00dd  */
    @Override // androidx.constraintlayout.core.widgets.analyzer.Dependency
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void update(Dependency dependency) {
        boolean z;
        int i;
        int i2;
        boolean z2;
        int i3;
        int i4;
        int i5;
        float f;
        float f2;
        int i6;
        int i7;
        float f3;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        boolean z3;
        boolean z4;
        int i20;
        DependencyNode dependencyNode = this.start;
        if (dependencyNode.resolved) {
            DependencyNode dependencyNode2 = this.end;
            if (dependencyNode2.resolved) {
                ConstraintWidget constraintWidget = this.mWidget.mParent;
                if (constraintWidget instanceof ConstraintWidgetContainer) {
                    z = ((ConstraintWidgetContainer) constraintWidget).mIsRtl;
                } else {
                    z = false;
                }
                int i21 = dependencyNode2.value - dependencyNode.value;
                ArrayList arrayList = this.mWidgets;
                int size = arrayList.size();
                int i22 = 0;
                while (true) {
                    i = -1;
                    i2 = 8;
                    if (i22 >= size) {
                        i22 = -1;
                        break;
                    }
                    if (((WidgetRun) arrayList.get(i22)).mWidget.mVisibility != 8) {
                        break;
                    }
                    i22++;
                }
                int i23 = size - 1;
                int i24 = i23;
                while (true) {
                    if (i24 < 0) {
                        break;
                    }
                    if (((WidgetRun) arrayList.get(i24)).mWidget.mVisibility != 8) {
                        i = i24;
                        break;
                    }
                    i24--;
                }
                int i25 = 0;
                while (i25 < 2) {
                    int i26 = 0;
                    i5 = 0;
                    int i27 = 0;
                    int i28 = 0;
                    f = 0.0f;
                    while (i26 < size) {
                        WidgetRun widgetRun = (WidgetRun) arrayList.get(i26);
                        ConstraintWidget constraintWidget2 = widgetRun.mWidget;
                        boolean z5 = z;
                        if (constraintWidget2.mVisibility == i2) {
                            i19 = i25;
                        } else {
                            i28++;
                            if (i26 > 0 && i26 >= i22) {
                                i5 += widgetRun.start.mMargin;
                            }
                            DimensionDependency dimensionDependency = widgetRun.mDimension;
                            int i29 = dimensionDependency.value;
                            i19 = i25;
                            if (widgetRun.mDimensionBehavior != 3) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            if (z3) {
                                int i30 = this.orientation;
                                if (i30 == 0 && !constraintWidget2.mHorizontalRun.mDimension.resolved) {
                                    return;
                                }
                                if (i30 != 1 || constraintWidget2.mVerticalRun.mDimension.resolved) {
                                    z4 = z3;
                                } else {
                                    return;
                                }
                            } else {
                                z4 = z3;
                                if (widgetRun.matchConstraintsType == 1 && i19 == 0) {
                                    i20 = dimensionDependency.wrapValue;
                                    i27++;
                                } else if (dimensionDependency.resolved) {
                                    i20 = i29;
                                }
                                z4 = true;
                                if (z4) {
                                    i27++;
                                    float f4 = constraintWidget2.mWeight[this.orientation];
                                    if (f4 >= 0.0f) {
                                        f += f4;
                                    }
                                } else {
                                    i5 += i20;
                                }
                                if (i26 < i23 && i26 < i) {
                                    i5 += -widgetRun.end.mMargin;
                                }
                            }
                            i20 = i29;
                            if (z4) {
                            }
                            if (i26 < i23) {
                                i5 += -widgetRun.end.mMargin;
                            }
                        }
                        i26++;
                        z = z5;
                        i25 = i19;
                        i2 = 8;
                    }
                    z2 = z;
                    int i31 = i25;
                    if (i5 < i21 || i27 == 0) {
                        i3 = i27;
                        i4 = i28;
                        break;
                    }
                    i25 = i31 + 1;
                    z = z2;
                    i2 = 8;
                }
                z2 = z;
                i3 = 0;
                i4 = 0;
                i5 = 0;
                f = 0.0f;
                int i32 = dependencyNode.value;
                if (z2) {
                    i32 = dependencyNode2.value;
                }
                if (i5 > i21) {
                    if (z2) {
                        i32 += (int) (((i5 - i21) / 2.0f) + 0.5f);
                    } else {
                        i32 -= (int) (((i5 - i21) / 2.0f) + 0.5f);
                    }
                }
                if (i3 > 0) {
                    float f5 = i21 - i5;
                    int i33 = (int) ((f5 / i3) + 0.5f);
                    int i34 = 0;
                    int i35 = 0;
                    while (i34 < size) {
                        WidgetRun widgetRun2 = (WidgetRun) arrayList.get(i34);
                        int i36 = i32;
                        ConstraintWidget constraintWidget3 = widgetRun2.mWidget;
                        int i37 = i3;
                        DimensionDependency dimensionDependency2 = widgetRun2.mDimension;
                        float f6 = f5;
                        int i38 = i33;
                        if (constraintWidget3.mVisibility != 8 && widgetRun2.mDimensionBehavior == 3 && !dimensionDependency2.resolved) {
                            if (f > 0.0f) {
                                i15 = (int) (((constraintWidget3.mWeight[this.orientation] * f6) / f) + 0.5f);
                            } else {
                                i15 = i38;
                            }
                            if (this.orientation == 0) {
                                i16 = constraintWidget3.mMatchConstraintMaxWidth;
                                i17 = constraintWidget3.mMatchConstraintMinWidth;
                            } else {
                                i16 = constraintWidget3.mMatchConstraintMaxHeight;
                                i17 = constraintWidget3.mMatchConstraintMinHeight;
                            }
                            i14 = i34;
                            if (widgetRun2.matchConstraintsType == 1) {
                                i18 = Math.min(i15, dimensionDependency2.wrapValue);
                            } else {
                                i18 = i15;
                            }
                            int max = Math.max(i17, i18);
                            if (i16 > 0) {
                                max = Math.min(i16, max);
                            }
                            if (max != i15) {
                                i35++;
                                i15 = max;
                            }
                            dimensionDependency2.resolve(i15);
                        } else {
                            i14 = i34;
                        }
                        i34 = i14 + 1;
                        i32 = i36;
                        i3 = i37;
                        f5 = f6;
                        i33 = i38;
                    }
                    i6 = i32;
                    int i39 = i3;
                    f2 = 0.5f;
                    if (i35 > 0) {
                        i3 = i39 - i35;
                        i5 = 0;
                        for (int i40 = 0; i40 < size; i40++) {
                            WidgetRun widgetRun3 = (WidgetRun) arrayList.get(i40);
                            if (widgetRun3.mWidget.mVisibility != 8) {
                                if (i40 > 0 && i40 >= i22) {
                                    i5 += widgetRun3.start.mMargin;
                                }
                                i5 += widgetRun3.mDimension.value;
                                if (i40 < i23 && i40 < i) {
                                    i5 += -widgetRun3.end.mMargin;
                                }
                            }
                        }
                    } else {
                        i3 = i39;
                    }
                    i7 = 2;
                    if (this.mChainStyle == 2 && i35 == 0) {
                        this.mChainStyle = 0;
                    }
                } else {
                    i6 = i32;
                    i7 = 2;
                    f2 = 0.5f;
                }
                if (i5 > i21) {
                    this.mChainStyle = i7;
                }
                if (i4 > 0 && i3 == 0 && i22 == i) {
                    this.mChainStyle = i7;
                }
                int i41 = this.mChainStyle;
                if (i41 == 1) {
                    if (i4 > 1) {
                        i12 = (i21 - i5) / (i4 - 1);
                    } else if (i4 == 1) {
                        i12 = (i21 - i5) / 2;
                    } else {
                        i12 = 0;
                    }
                    if (i3 > 0) {
                        i12 = 0;
                    }
                    int i42 = i6;
                    for (int i43 = 0; i43 < size; i43++) {
                        if (z2) {
                            i13 = size - (i43 + 1);
                        } else {
                            i13 = i43;
                        }
                        WidgetRun widgetRun4 = (WidgetRun) arrayList.get(i13);
                        ConstraintWidget constraintWidget4 = widgetRun4.mWidget;
                        DependencyNode dependencyNode3 = widgetRun4.end;
                        DependencyNode dependencyNode4 = widgetRun4.start;
                        if (constraintWidget4.mVisibility == 8) {
                            dependencyNode4.resolve(i42);
                            dependencyNode3.resolve(i42);
                        } else {
                            if (i43 > 0) {
                                if (z2) {
                                    i42 -= i12;
                                } else {
                                    i42 += i12;
                                }
                            }
                            if (i43 > 0 && i43 >= i22) {
                                if (z2) {
                                    i42 -= dependencyNode4.mMargin;
                                } else {
                                    i42 += dependencyNode4.mMargin;
                                }
                            }
                            if (z2) {
                                dependencyNode3.resolve(i42);
                            } else {
                                dependencyNode4.resolve(i42);
                            }
                            DimensionDependency dimensionDependency3 = widgetRun4.mDimension;
                            int i44 = dimensionDependency3.value;
                            if (widgetRun4.mDimensionBehavior == 3 && widgetRun4.matchConstraintsType == 1) {
                                i44 = dimensionDependency3.wrapValue;
                            }
                            if (z2) {
                                i42 -= i44;
                            } else {
                                i42 += i44;
                            }
                            if (z2) {
                                dependencyNode4.resolve(i42);
                            } else {
                                dependencyNode3.resolve(i42);
                            }
                            widgetRun4.mResolved = true;
                            if (i43 < i23 && i43 < i) {
                                if (z2) {
                                    i42 -= -dependencyNode3.mMargin;
                                } else {
                                    i42 += -dependencyNode3.mMargin;
                                }
                            }
                        }
                    }
                } else if (i41 == 0) {
                    int i45 = (i21 - i5) / (i4 + 1);
                    if (i3 > 0) {
                        i45 = 0;
                    }
                    int i46 = i6;
                    for (int i47 = 0; i47 < size; i47++) {
                        if (z2) {
                            i10 = size - (i47 + 1);
                        } else {
                            i10 = i47;
                        }
                        WidgetRun widgetRun5 = (WidgetRun) arrayList.get(i10);
                        ConstraintWidget constraintWidget5 = widgetRun5.mWidget;
                        DependencyNode dependencyNode5 = widgetRun5.end;
                        DependencyNode dependencyNode6 = widgetRun5.start;
                        if (constraintWidget5.mVisibility == 8) {
                            dependencyNode6.resolve(i46);
                            dependencyNode5.resolve(i46);
                        } else {
                            if (z2) {
                                i11 = i46 - i45;
                            } else {
                                i11 = i46 + i45;
                            }
                            if (i47 > 0 && i47 >= i22) {
                                if (z2) {
                                    i11 -= dependencyNode6.mMargin;
                                } else {
                                    i11 += dependencyNode6.mMargin;
                                }
                            }
                            if (z2) {
                                dependencyNode5.resolve(i11);
                            } else {
                                dependencyNode6.resolve(i11);
                            }
                            DimensionDependency dimensionDependency4 = widgetRun5.mDimension;
                            int i48 = dimensionDependency4.value;
                            if (widgetRun5.mDimensionBehavior == 3 && widgetRun5.matchConstraintsType == 1) {
                                i48 = Math.min(i48, dimensionDependency4.wrapValue);
                            }
                            if (z2) {
                                i46 = i11 - i48;
                            } else {
                                i46 = i11 + i48;
                            }
                            if (z2) {
                                dependencyNode6.resolve(i46);
                            } else {
                                dependencyNode5.resolve(i46);
                            }
                            if (i47 < i23 && i47 < i) {
                                if (z2) {
                                    i46 -= -dependencyNode5.mMargin;
                                } else {
                                    i46 += -dependencyNode5.mMargin;
                                }
                            }
                        }
                    }
                } else if (i41 == 2) {
                    if (this.orientation == 0) {
                        f3 = this.mWidget.mHorizontalBiasPercent;
                    } else {
                        f3 = this.mWidget.mVerticalBiasPercent;
                    }
                    if (z2) {
                        f3 = 1.0f - f3;
                    }
                    int i49 = (int) (((i21 - i5) * f3) + f2);
                    if (i49 < 0 || i3 > 0) {
                        i49 = 0;
                    }
                    if (z2) {
                        i8 = i6 - i49;
                    } else {
                        i8 = i6 + i49;
                    }
                    for (int i50 = 0; i50 < size; i50++) {
                        if (z2) {
                            i9 = size - (i50 + 1);
                        } else {
                            i9 = i50;
                        }
                        WidgetRun widgetRun6 = (WidgetRun) arrayList.get(i9);
                        ConstraintWidget constraintWidget6 = widgetRun6.mWidget;
                        DependencyNode dependencyNode7 = widgetRun6.end;
                        DependencyNode dependencyNode8 = widgetRun6.start;
                        if (constraintWidget6.mVisibility == 8) {
                            dependencyNode8.resolve(i8);
                            dependencyNode7.resolve(i8);
                        } else {
                            if (i50 > 0 && i50 >= i22) {
                                if (z2) {
                                    i8 -= dependencyNode8.mMargin;
                                } else {
                                    i8 += dependencyNode8.mMargin;
                                }
                            }
                            if (z2) {
                                dependencyNode7.resolve(i8);
                            } else {
                                dependencyNode8.resolve(i8);
                            }
                            DimensionDependency dimensionDependency5 = widgetRun6.mDimension;
                            int i51 = dimensionDependency5.value;
                            if (widgetRun6.mDimensionBehavior == 3 && widgetRun6.matchConstraintsType == 1) {
                                i51 = dimensionDependency5.wrapValue;
                            }
                            i8 += i51;
                            if (z2) {
                                dependencyNode8.resolve(i8);
                            } else {
                                dependencyNode7.resolve(i8);
                            }
                            if (i50 < i23 && i50 < i) {
                                if (z2) {
                                    i8 -= -dependencyNode7.mMargin;
                                } else {
                                    i8 += -dependencyNode7.mMargin;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
