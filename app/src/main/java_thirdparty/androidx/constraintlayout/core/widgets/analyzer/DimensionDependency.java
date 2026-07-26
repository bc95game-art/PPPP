package androidx.constraintlayout.core.widgets.analyzer;

import java.util.ArrayList;
/* loaded from: classes.dex */
public class DimensionDependency extends DependencyNode {
    public int wrapValue;

    public DimensionDependency(WidgetRun widgetRun) {
        super(widgetRun);
        if (widgetRun instanceof HorizontalWidgetRun) {
            this.mType = 2;
        } else {
            this.mType = 3;
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.DependencyNode
    public final void resolve(int i) {
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
}
