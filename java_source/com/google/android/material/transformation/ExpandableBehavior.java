package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.expandable.ExpandableWidget;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
@Deprecated
/* loaded from: classes.dex */
public abstract class ExpandableBehavior extends CoordinatorLayout.Behavior {
    public int currentState = 0;

    public ExpandableBehavior() {
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public abstract boolean layoutDependsOn(View view, View view2);

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) {
        ExpandableWidget expandableWidget = (ExpandableWidget) view2;
        boolean z = ((FloatingActionButton) expandableWidget).expandableWidgetHelper.expanded;
        int i = 2;
        if (z) {
            int i2 = this.currentState;
            if (!(i2 == 0 || i2 == 2)) {
                return false;
            }
        } else if (this.currentState != 1) {
            return false;
        }
        if (z) {
            i = 1;
        }
        this.currentState = i;
        onExpandedStateChange((View) expandableWidget, view, z, true);
        return true;
    }

    public abstract void onExpandedStateChange(View view, View view2, boolean z, boolean z2);

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onLayoutChild(CoordinatorLayout coordinatorLayout, final View view, int i) {
        final ExpandableWidget expandableWidget;
        int i2;
        if (!view.isLaidOut()) {
            ArrayList dependencies = coordinatorLayout.getDependencies(view);
            int size = dependencies.size();
            int i3 = 0;
            while (true) {
                if (i3 >= size) {
                    expandableWidget = null;
                    break;
                }
                View view2 = (View) dependencies.get(i3);
                if (layoutDependsOn(view, view2)) {
                    expandableWidget = (ExpandableWidget) view2;
                    break;
                }
                i3++;
            }
            if (expandableWidget != null) {
                boolean z = ((FloatingActionButton) expandableWidget).expandableWidgetHelper.expanded;
                final int i4 = 2;
                if (!z ? this.currentState == 1 : (i2 = this.currentState) == 0 || i2 == 2) {
                    if (z) {
                        i4 = 1;
                    }
                    this.currentState = i4;
                    view.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: com.google.android.material.transformation.ExpandableBehavior.1
                        @Override // android.view.ViewTreeObserver.OnPreDrawListener
                        public final boolean onPreDraw() {
                            View view3 = view;
                            view3.getViewTreeObserver().removeOnPreDrawListener(this);
                            ExpandableBehavior expandableBehavior = ExpandableBehavior.this;
                            if (expandableBehavior.currentState == i4) {
                                ExpandableWidget expandableWidget2 = expandableWidget;
                                expandableBehavior.onExpandedStateChange((View) expandableWidget2, view3, ((FloatingActionButton) expandableWidget2).expandableWidgetHelper.expanded, false);
                            }
                            return false;
                        }
                    });
                }
            }
        }
        return false;
    }

    public ExpandableBehavior(Context context, AttributeSet attributeSet) {
    }
}
