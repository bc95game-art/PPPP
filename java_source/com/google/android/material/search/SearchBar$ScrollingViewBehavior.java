package com.google.android.material.search;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
/* loaded from: classes.dex */
public class SearchBar$ScrollingViewBehavior extends AppBarLayout.ScrollingViewBehavior {
    public boolean initialized = false;

    public SearchBar$ScrollingViewBehavior() {
    }

    @Override // com.google.android.material.appbar.AppBarLayout.ScrollingViewBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) {
        super.onDependentViewChanged(coordinatorLayout, view, view2);
        if (!this.initialized && (view2 instanceof AppBarLayout)) {
            this.initialized = true;
            AppBarLayout appBarLayout = (AppBarLayout) view2;
            appBarLayout.setBackgroundColor(0);
            if (Build.VERSION.SDK_INT == 21) {
                appBarLayout.setOutlineProvider(null);
                return false;
            }
            appBarLayout.setTargetElevation(0.0f);
        }
        return false;
    }

    public SearchBar$ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
