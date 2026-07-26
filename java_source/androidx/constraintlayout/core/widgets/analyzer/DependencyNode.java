package androidx.constraintlayout.core.widgets.analyzer;

import java.util.ArrayList;
/* loaded from: classes.dex */
public class DependencyNode implements Dependency {
    public int mMargin;
    public final WidgetRun mRun;
    public int value;
    public WidgetRun updateDelegate = null;
    public boolean delegateToWidgetRun = false;
    public boolean readyToSolve = false;
    public int mType = 1;
    public int mMarginFactor = 1;
    public DimensionDependency mMarginDependency = null;
    public boolean resolved = false;
    public final ArrayList mDependencies = new ArrayList();
    public final ArrayList mTargets = new ArrayList();

    public DependencyNode(WidgetRun widgetRun) {
        this.mRun = widgetRun;
    }

    public final void addDependency(WidgetRun widgetRun) {
        this.mDependencies.add(widgetRun);
        if (this.resolved) {
            widgetRun.update(widgetRun);
        }
    }

    public final void clear() {
        this.mTargets.clear();
        this.mDependencies.clear();
        this.resolved = false;
        this.value = 0;
        this.readyToSolve = false;
        this.delegateToWidgetRun = false;
    }

    public void resolve(int i) {
        if (!this.resolved) {
            this.resolved = true;
            this.value = i;
            ArrayList arrayList = this.mDependencies;
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                Object obj = arrayList.get(i2);
                i2++;
                Dependency dependency = (Dependency) obj;
                dependency.update(dependency);
            }
        }
    }

    public final String toString() {
        String str;
        Object obj;
        StringBuilder sb = new StringBuilder();
        sb.append(this.mRun.mWidget.mDebugName);
        sb.append(":");
        switch (this.mType) {
            case 1:
                str = "UNKNOWN";
                break;
            case 2:
                str = "HORIZONTAL_DIMENSION";
                break;
            case 3:
                str = "VERTICAL_DIMENSION";
                break;
            case 4:
                str = "LEFT";
                break;
            case 5:
                str = "RIGHT";
                break;
            case 6:
                str = "TOP";
                break;
            case 7:
                str = "BOTTOM";
                break;
            case 8:
                str = "BASELINE";
                break;
            default:
                str = "null";
                break;
        }
        sb.append(str);
        sb.append("(");
        if (this.resolved) {
            obj = Integer.valueOf(this.value);
        } else {
            obj = "unresolved";
        }
        sb.append(obj);
        sb.append(") <t=");
        sb.append(this.mTargets.size());
        sb.append(":d=");
        sb.append(this.mDependencies.size());
        sb.append(">");
        return sb.toString();
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.Dependency
    public final void update(Dependency dependency) {
        ArrayList arrayList = this.mTargets;
        int size = arrayList.size();
        int i = 0;
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            if (!((DependencyNode) obj).resolved) {
                return;
            }
        }
        this.readyToSolve = true;
        WidgetRun widgetRun = this.updateDelegate;
        if (widgetRun != null) {
            widgetRun.update(this);
        }
        if (this.delegateToWidgetRun) {
            this.mRun.update(this);
            return;
        }
        int size2 = arrayList.size();
        DependencyNode dependencyNode = null;
        int i3 = 0;
        while (i3 < size2) {
            Object obj2 = arrayList.get(i3);
            i3++;
            DependencyNode dependencyNode2 = (DependencyNode) obj2;
            if (!(dependencyNode2 instanceof DimensionDependency)) {
                i++;
                dependencyNode = dependencyNode2;
            }
        }
        if (dependencyNode != null && i == 1 && dependencyNode.resolved) {
            DimensionDependency dimensionDependency = this.mMarginDependency;
            if (dimensionDependency != null) {
                if (dimensionDependency.resolved) {
                    this.mMargin = this.mMarginFactor * dimensionDependency.value;
                } else {
                    return;
                }
            }
            resolve(dependencyNode.value + this.mMargin);
        }
        WidgetRun widgetRun2 = this.updateDelegate;
        if (widgetRun2 != null) {
            widgetRun2.update(this);
        }
    }
}
