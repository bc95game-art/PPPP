package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.widgets.analyzer.Direct;
import androidx.constraintlayout.core.widgets.analyzer.WidgetGroup;
import java.util.ArrayList;
/* loaded from: classes.dex */
public abstract class HelperWidget extends ConstraintWidget {
    public ConstraintWidget[] mWidgets = new ConstraintWidget[4];
    public int mWidgetsCount = 0;

    public final void addDependents(int i, WidgetGroup widgetGroup, ArrayList arrayList) {
        for (int i2 = 0; i2 < this.mWidgetsCount; i2++) {
            ConstraintWidget constraintWidget = this.mWidgets[i2];
            ArrayList arrayList2 = widgetGroup.mWidgets;
            if (!arrayList2.contains(constraintWidget)) {
                arrayList2.add(constraintWidget);
            }
        }
        for (int i3 = 0; i3 < this.mWidgetsCount; i3++) {
            Direct.findDependents(this.mWidgets[i3], i, arrayList, widgetGroup);
        }
    }

    public void updateConstraints() {
    }
}
