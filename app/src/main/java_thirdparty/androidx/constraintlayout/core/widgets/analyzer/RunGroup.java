package androidx.constraintlayout.core.widgets.analyzer;

import java.util.ArrayList;
/* loaded from: classes.dex */
public final class RunGroup {
    public WidgetRun mFirstRun;
    public ArrayList mRuns;

    public static long traverseEnd(DependencyNode dependencyNode, long j) {
        WidgetRun widgetRun = dependencyNode.mRun;
        ArrayList arrayList = dependencyNode.mDependencies;
        if (widgetRun instanceof HelperReferences) {
            return j;
        }
        int size = arrayList.size();
        long j2 = j;
        for (int i = 0; i < size; i++) {
            Dependency dependency = (Dependency) arrayList.get(i);
            if (dependency instanceof DependencyNode) {
                DependencyNode dependencyNode2 = (DependencyNode) dependency;
                if (dependencyNode2.mRun != widgetRun) {
                    j2 = Math.min(j2, traverseEnd(dependencyNode2, dependencyNode2.mMargin + j));
                }
            }
        }
        DependencyNode dependencyNode3 = widgetRun.end;
        DependencyNode dependencyNode4 = widgetRun.start;
        if (dependencyNode != dependencyNode3) {
            return j2;
        }
        long wrapDimension = j - widgetRun.getWrapDimension();
        return Math.min(Math.min(j2, traverseEnd(dependencyNode4, wrapDimension)), wrapDimension - dependencyNode4.mMargin);
    }

    public static long traverseStart(DependencyNode dependencyNode, long j) {
        WidgetRun widgetRun = dependencyNode.mRun;
        ArrayList arrayList = dependencyNode.mDependencies;
        if (widgetRun instanceof HelperReferences) {
            return j;
        }
        int size = arrayList.size();
        long j2 = j;
        for (int i = 0; i < size; i++) {
            Dependency dependency = (Dependency) arrayList.get(i);
            if (dependency instanceof DependencyNode) {
                DependencyNode dependencyNode2 = (DependencyNode) dependency;
                if (dependencyNode2.mRun != widgetRun) {
                    j2 = Math.max(j2, traverseStart(dependencyNode2, dependencyNode2.mMargin + j));
                }
            }
        }
        DependencyNode dependencyNode3 = widgetRun.start;
        DependencyNode dependencyNode4 = widgetRun.end;
        if (dependencyNode != dependencyNode3) {
            return j2;
        }
        long wrapDimension = widgetRun.getWrapDimension() + j;
        return Math.max(Math.max(j2, traverseStart(dependencyNode4, wrapDimension)), wrapDimension - dependencyNode4.mMargin);
    }
}
